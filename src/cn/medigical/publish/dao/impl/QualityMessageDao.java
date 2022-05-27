package cn.medigical.publish.dao.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.medigical.publish.dao.BaseDao;
import cn.medigical.publish.pojo.delPojo.LogDBModel;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.pojo.zhikong.QualityMessage;
import cn.medigical.publish.pojo.zhikong.QualityStatistics;

@Service
public class QualityMessageDao extends BaseDao<QualityMessage> {
   private static Logger logger=Logger.getLogger(QualityMessageDao.class);
	
	public boolean addUpdate(QualityMessage qualityMessage) {
		return save(qualityMessage);
	}
	
	/**
     * 
     * @param time 当前时间
     * @param days 时间段
     */
    public void delZhiKongByTime(Date time,int days) {
    	Calendar calendar=Calendar.getInstance();
    	logger.info("质控删除周期:"+days);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	logger.info("当前时间："+sdf2.format(calendar.getTime()));
    	List<QualityMessage> list=getAll();
    	calendar.add(Calendar.DATE, -days);
    	Date delTime=calendar.getTime();
    	logger.info("质控删除截止时间："+sdf2.format(delTime));
    	logger.info("质控正在删除中······");
		for (QualityMessage qualityMessage : list) {
			try {
				if (qualityMessage.getLastUpdateTime()==null) {
					remove(qualityMessage);
				}
				else if (qualityMessage.getLastUpdateTime().getTime()<delTime.getTime()) {
//					logger.info("正在删除质控，该条日志创建时间为："+sdf2.format(qualityMessage.getLastUpdateTime()));
					remove(qualityMessage);
				}
			} catch (Exception e) {
//				logger.info("正在删除日志，该条质控创建时间为："+sdf2.format(qualityMessage.getLastUpdateTime()));
				remove(qualityMessage);
			}
			
		}
	}
}
