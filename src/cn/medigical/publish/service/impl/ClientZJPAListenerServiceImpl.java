package cn.medigical.publish.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigDepartmentsDao;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.pojo.zjpa.HuiChuan;
import cn.medigical.publish.pojo.zjpa.PingTaiConfig;
import cn.medigical.publish.udp.*;
import cn.medigical.publish.utils.JsonUtilTool;
import cn.medigical.publish.service.ClientListenerService;
import cn.medigical.publish.utils.SpringUtils;
import cn.medigical.publish.xmlUtil.ClientSelectXml;
import cn.medigical.publish.xmlUtil.HttpNetClient;
import cn.medigical.publish.xmlUtil.ServicesSign;


public class ClientZJPAListenerServiceImpl implements ClientListenerService {

	AccountDao accountDao = (AccountDao) SpringUtils.getBean(AccountDao.class);
	ConfigDepartmentsDao configDepartmentsDao = SpringUtils.getBean(ConfigDepartmentsDao.class);
	PatientLinkDao patientLinkDao=SpringUtils.getBean(PatientLinkDao.class);
	static Logger logger=Logger.getLogger(ClientZJPAListenerServiceImpl.class);

	UdpMsgAnalysis udpMsgAnalysis;
	UdpModel udpModel;
	int timeOut = 0;
	String jianyanStr = "";

	@Override
	public boolean clientInteraction(String xmlString) {
		ClientSelectXml clientSelectXml = new ClientSelectXml();
		udpMsgAnalysis = clientSelectXml.readJsonString(xmlString);
		// System.out.println(udpMsgAnalysis);
		if (!"Anes".equalsIgnoreCase(udpMsgAnalysis.getSystemType())) {
			return false;
		}
		if (udpMsgAnalysis.getMethodId().equalsIgnoreCase("SYSTEMMODIFY")) {
			return false;
		}
		udpModel = JsonUtilTool.fromJsonToObject(udpMsgAnalysis.getCustomContent(), UdpModel.class);
		HuiChuan huiChuan=new HuiChuan();
		HttpNetClient httpNetClient=new HttpNetClient();
		if (ServicesSign.PAIBANHUICHUAN.equals(udpMsgAnalysis.getMethodId())) {
                 PatientLink patientLink = patientLinkDao.getPatientById(udpModel.PatientId);
                 if (patientLink != null) {
                     String xml = huiChuan.getSurgeryScheduleXML(patientLink);
                     logger.info("======return operation Scedule to Pingtai======");
                     logger.info("the operation scedule update xml is: "+xml);
                     httpNetClient.HttpClientGet(PingTaiConfig.PINGTAI_PAIBAN, xml);
                     logger.info("======return operation Scedule to Pingtai Success======");
                 }
		}
		
		if (ServicesSign.OPERATION_STATUS_UPDATE.equals(udpMsgAnalysis.getMethodId())) {
            PatientLink patientLink = patientLinkDao.getPatientById(udpModel.PatientId);
            if (patientLink != null) {
            	 String xml = huiChuan.getSurgicalState(patientLink);
                 logger.info("======return operation Status to Pingtai======");
                 logger.info("the operation status update xml is: "+xml);
                 httpNetClient.HttpClientGet(PingTaiConfig.PINGTAI_STATUS, xml);
                 logger.info("======return operation Status to Pingtai Success======");
            }
	}
		
		return false;
	}
}
