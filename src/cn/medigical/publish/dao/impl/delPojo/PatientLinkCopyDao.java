package cn.medigical.publish.dao.impl.delPojo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.medigical.publish.dao.BaseDao;
import cn.medigical.publish.pojo.delPojo.PatientLinkCopy;
@Service
public class PatientLinkCopyDao extends BaseDao<PatientLinkCopy> {
	private Logger logger=Logger.getLogger(PatientLinkCopyDao.class);
	
	
	/**
     * 
     * @param time 当前时间
     * @param days 时间段
     */
    public void delPatientCopyByTime(Date time,int days) {
    	Calendar calendar=Calendar.getInstance();
    	logger.info("patientLinkCopy删除周期:"+days);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	logger.info("当前时间："+sdf2.format(calendar.getTime()));
    	List<PatientLinkCopy> list=getAll();
    	calendar.add(Calendar.DATE, -days);
    	Date delTime=calendar.getTime();
    	logger.info("patientLinkCopy删除截止时间："+sdf2.format(delTime));
    	logger.info("patientLinkCopy正在删除中······");
		for (PatientLinkCopy patientLinkCopy : list) {
			try {
				if (patientLinkCopy.getLastModifyTime()==null) {
					remove(patientLinkCopy);
				}
				else if (patientLinkCopy.getLastModifyTime() .getTime()<delTime.getTime()) {
//					logger.info("正在删除patientLinkCopy，该条patientLinkCopy创建时间为："+sdf2.format(patientLinkCopy.getLastModifyTime()));
					remove(patientLinkCopy);
				}
			} catch (Exception e) {
//				logger.info("正在删除patientLinkCopy，该条patientLinkCopy创建时间为："+sdf2.format(patientLinkCopy.getLastModifyTime()));
				remove(patientLinkCopy);
			}
			
		}
	}
}
