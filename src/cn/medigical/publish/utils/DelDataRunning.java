package cn.medigical.publish.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

import cn.medigical.publish.dao.impl.QualityMessageDao;
import cn.medigical.publish.dao.impl.delPojo.LogDao;
import cn.medigical.publish.dao.impl.delPojo.PatientLinkCopyDao;
import cn.medigical.publish.dao.impl.delPojo.VitalSignCacheDao;
import cn.medigical.publish.udp.UdpHelper;
import sun.util.logging.resources.logging;

public class DelDataRunning implements Runnable {

	private LogDao logDao=SpringUtils.getBean(LogDao.class);
	private PatientLinkCopyDao patientLinkCopyDao=SpringUtils.getBean(PatientLinkCopyDao.class);
	private Logger logger=Logger.getLogger(DelDataRunning.class);
	private VitalSignCacheDao vitalSignDao=SpringUtils.getBean(VitalSignCacheDao.class);
	private QualityMessageDao qualityMessageDao=SpringUtils.getBean(QualityMessageDao.class);
	private   SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	public void run() {
		 synchronized (this) {
	        	while(true){
	        		try {
	        			delDataByTimer(false);
						Thread.sleep(15*24*60*60*1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	}
	        }
	}
	
	/**
	 * 删除logs，patientCopy，vitalSignCache
	 */
	private void delDataByTimer(boolean isNewTask) {
		
		Date startTime=new Date();
		try {
			
			if (isNewTask) {
				 new Thread(new Runnable() {
						
						@Override
						public void run() {
							logger.info("1");
							//删除log
							int delBefore=logDao.getAll().size();
							logger.info("日志未清除之前的条数："+delBefore);
							logDao.delLogByTime(new Date(), 7);
							int delAfter=logDao.getAll().size();
							logger.info("delteting Logs,the del count="+(delBefore-delAfter));
							
						}
					}).start();
				 new Thread(new Runnable() {
					
					@Override
					public void run() {
						 logger.info("2");
						//删除PatientLinkCopy
					    int delBefore2=patientLinkCopyDao.getAll().size();
					    logger.info("PatientLinkCopy未清除之前的条数："+delBefore2);
					    patientLinkCopyDao.delPatientCopyByTime(new Date(), 15);
						int delAfter2=patientLinkCopyDao.getAll().size();
						logger.info("delteting patientLinkCopy,the del count="+(delBefore2-delAfter2));
						
					}
				}).start();
				 new Thread(new Runnable() {
						
						@Override
						public void run() {
							 logger.info("3");
							//删除生命体征
							int delBefore1=vitalSignDao.getAll().size();
							logger.info("生命体征未清除之前的条数："+delBefore1);
							vitalSignDao.delVitalSignByTime(new Date(), 15);
							int delAfter1=vitalSignDao.getAll().size();
							logger.info("delteting vitalSign,the del count="+(delBefore1-delAfter1));
							
						}
					}).start();
				 
				 new Thread(new Runnable() {
						@Override
						public void run() {
							 logger.info("");
							//删除质控查询记录
								int delBefore3=qualityMessageDao.getAll().size();
								logger.info("质控未清除之前的条数："+delBefore3);
								qualityMessageDao.delZhiKongByTime(new Date(), 7);
								int delAfter3=qualityMessageDao.getAll().size();
								logger.info("delteting zhikongMessage,the del count="+(delBefore3-delAfter3));
						}
					}).start();
			}
			else {
				//删除log
				int delBefore=logDao.getAll().size();
				logger.info("日志未清除之前的条数："+delBefore);
				logDao.delLogByTime(new Date(), 7);
				int delAfter=logDao.getAll().size();
				logger.info("delteting Logs,the del count="+(delBefore-delAfter));
			
			//删除PatientLinkCopy
			    int delBefore2=patientLinkCopyDao.getAll().size();
			    logger.info("PatientLinkCopy未清除之前的条数："+delBefore2);
			    patientLinkCopyDao.delPatientCopyByTime(new Date(), 15);
				int delAfter2=patientLinkCopyDao.getAll().size();
				logger.info("delteting patientLinkCopy,the del count="+(delBefore2-delAfter2));
			
			//删除生命体征
				int delBefore1=vitalSignDao.getAll().size();
				logger.info("生命体征未清除之前的条数："+delBefore1);
				vitalSignDao.delVitalSignByTime(new Date(), 15);
				int delAfter1=vitalSignDao.getAll().size();
				logger.info("delteting vitalSign,the del count="+(delBefore1-delAfter1));
			
			//删除质控查询记录
				int delBefore3=qualityMessageDao.getAll().size();
				logger.info("质控未清除之前的条数："+delBefore3);
				qualityMessageDao.delZhiKongByTime(new Date(), 7);
				int delAfter3=qualityMessageDao.getAll().size();
				logger.info("delteting zhikongMessage,the del count="+(delBefore3-delAfter3));
			}
		} catch (Exception e) {
				e.printStackTrace();
		}
		
		Date endTime=new Date();
		int mints=(int)((endTime.getTime()-startTime.getTime())/(1000*60));
		int sec=(int)(endTime.getTime()-startTime.getTime())/1000-mints*60;
		logger.info("this del data spend time："+mints+"分"+sec+"秒");
		
	} 
	

}
