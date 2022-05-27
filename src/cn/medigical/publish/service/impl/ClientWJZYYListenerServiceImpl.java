package cn.medigical.publish.service.impl;

import java.util.List;

import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigDepartmentsDao;
import cn.medigical.publish.interfaces.his.hisWJZYY.HisWJZYY;
import cn.medigical.publish.interfaces.lis.lisWjyy.LisWjyyData;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.dictionary.ConfigDepartments;
import cn.medigical.publish.udp.*;
import cn.medigical.publish.utils.JsonUtilTool;
import cn.medigical.publish.service.ClientListenerService;
import cn.medigical.publish.utils.SpringUtils;
import cn.medigical.publish.xmlUtil.ClientSelectXml;
import cn.medigical.publish.xmlUtil.ServicesSign;


public class ClientWJZYYListenerServiceImpl implements ClientListenerService {

	AccountDao accountDao = (AccountDao) SpringUtils.getBean(AccountDao.class);
	ConfigDepartmentsDao configDepartmentsDao = SpringUtils.getBean(ConfigDepartmentsDao.class);

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
		if (ServicesSign.OPERATION_ADD.equals(udpMsgAnalysis.getMethodId())) {
			Boolean flag = HisWJZYY.getInstance().getOperationFromHis();			
		}

		if (ServicesSign.ACCCOUNT_ADD.equals(udpMsgAnalysis.getMethodId())) {
			List<Account> account = HisWJZYY.getInstance().getAccountFromHis();			
			UdpHelper.sendMsg("successed");
		}

		if (ServicesSign.DEPART_ADD.equals(udpMsgAnalysis.getMethodId())) {
			List<ConfigDepartments> configDepartments = HisWJZYY.getInstance().getDepartmentFromHis();
			
			UdpHelper.sendMsg("successed");
		}

		 if (ServicesSign.GETLISDATA.equals(udpMsgAnalysis.getMethodId())) {
			 LisWjyyData.getInstance().getLisDataFromHis(udpModel.getZyh(), udpModel.getPatientId());
		 }
		
		 if (ServicesSign.OPERATION_STATUS_UPDATE.equals(udpMsgAnalysis.getMethodId())) {
			 HisWJZYY.getInstance().updateOperationStatus(udpModel.getPatientId());		
		 }
		
		return false;
	}
}
