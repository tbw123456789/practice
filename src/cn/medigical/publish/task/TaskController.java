package cn.medigical.publish.task;

import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.interfaces.his.hishezhouguangji.utils.Constants;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.utils.PropertyUtil;
import cn.medigical.publish.utils.SpringUtils;
import cn.medigical.publish.utils.StringUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 执行计划任务
 */

@Component
public class TaskController {

	private Map<String,String> cacheKey = new HashMap<>();

	@Scheduled(cron = "0 */5 * * * ?") // 间隔5秒执行  0/5 * * * * ?     0 */1 * * * ?
	public void taskCycle() {
		//贺州排班回传
//		String Name = PropertyUtil.getProperty("Hospital.Name");
//		if(Constants.HOSPITALNAME.equals(Name)){
//			List<PatientLink> patientLinkList = SpringUtils.getBean(PatientLinkDao.class).getScheduledOpers8Time(new Date());
//			if(patientLinkList != null) {
//				for (PatientLink patientLink : patientLinkList) {
//					if (!StringUtil.isEmpty(patientLink.getApplication().getSssqdh())) {
//						String sssqdh = cacheKey.get(patientLink.getApplication().getSssqdh());
//						if(StringUtil.isEmpty(sssqdh) || !sssqdh.equals(getStringBuffer(patientLink).toString())){
//							//正在执行,正在修改
//							patientLink.getSchedule().setOperStatu("SC");
//							boolean isSuccess = SpringUtils.getBean(HeZhouGuangJiServer.class).updateScheduleInfo(patientLink);
//							if (!isSuccess) {
//								if (StringUtil.isEmpty(patientLink.getApplication())) {
//									System.out.printf("--->" + patientLink.getPatient().toString());
//								}
//							}
//						} else if(!StringUtil.isEmpty(sssqdh) && "SC".equals(patientLink.getSchedule().getOperStatu())) {
//							//完全执行
//							patientLink.getSchedule().setOperStatu("CM");
//							boolean isSuccess = SpringUtils.getBean(HeZhouGuangJiServer.class).updateScheduleInfo(patientLink);
//							if (!isSuccess) {
//								if (StringUtil.isEmpty(patientLink.getApplication())) {
//									System.out.printf("--->" + patientLink.getPatient().toString());
//								}
//							}
//						}
//
//					}
//				}
//				cacheKey.clear();
//				for(PatientLink patientLink : patientLinkList) {
//					if (!StringUtil.isEmpty(patientLink.getApplication().getSssqdh())) {
//						cacheKey.put(patientLink.getApplication().getSssqdh(), getStringBuffer(patientLink).toString());
//					}
//				}
//			}
//		}

	}

	private StringBuffer getStringBuffer(PatientLink patientLink){
		StringBuffer buffer = new StringBuffer();
		buffer.append(patientLink.getSchedule().getQxhsbh1());
		buffer.append(patientLink.getSchedule().getXhhsbh1());
		buffer.append(patientLink.getApplication().getMzfs());
		buffer.append(patientLink.getAnesthesiaRecord().getZmys());
		buffer.append(patientLink.getAnesthesiaRecord().getFmys1());
		buffer.append(patientLink.getAnesthesiaRecord().getOperDoctor1());
		return buffer;
	}

	//开启UDP接收消息
	{
//		UdpRunning udpRunning = new UdpRunning();
//		Thread thread = new Thread(udpRunning);
//		thread.start();
//
//
//
//		GetHisDataRunning getHisDataRunning=new GetHisDataRunning();
//		Thread thread2=new Thread(getHisDataRunning);
//		thread2.start();
		
//		DelDataRunning dataRunning=new DelDataRunning();
//		Thread thread3=new Thread(dataRunning);
//		thread3.start();
		
	}
}
