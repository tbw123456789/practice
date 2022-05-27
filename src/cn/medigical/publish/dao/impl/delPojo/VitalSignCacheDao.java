package cn.medigical.publish.dao.impl.delPojo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.medigical.publish.dao.BaseDao;
import cn.medigical.publish.pojo.delPojo.LogDBModel;
import cn.medigical.publish.pojo.vitalSign.VitalSignCache;

@Service
public class VitalSignCacheDao extends BaseDao<VitalSignCache> {
	private Logger logger=Logger.getLogger(VitalSignCacheDao.class);
	 /**
     * 
     * @param time 当前时间
     * @param days 时间段
     */
    public void delVitalSignByTime(Date time,int days) {
    	Calendar calendar=Calendar.getInstance();
    	logger.info("体征删除周期:"+days);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	logger.info("当前时间："+sdf2.format(calendar.getTime()));
    	List<VitalSignCache> list=getAll();
    	calendar.add(Calendar.DATE, -days);
    	Date delTime=calendar.getTime();
    	logger.info("体征删除截止时间："+sdf2.format(delTime));
    	logger.info("体征正在删除中······");
		for (VitalSignCache vitalSignCache : list) {
			try {
				if (vitalSignCache.getCaptureTime()==null) {
					remove(vitalSignCache);
				}
				else if ( vitalSignCache.getCaptureTime().getTime()<delTime.getTime()) {
//					logger.info("正在删除体征，该条体征创建时间为："+sdf2.format(vitalSignCache.getCaptureTime()));
					remove(vitalSignCache);
				}
			} catch (Exception e) {
//				logger.info("正在删除体征，该条体征创建时间为："+sdf2.format(vitalSignCache.getCaptureTime()));
				remove(vitalSignCache);
			}
			
		}
	}
}
