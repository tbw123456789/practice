package cn.medigical.publish.service.impl;

import java.util.List;

import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigDepartmentsDao;
import cn.medigical.publish.interfaces.his.hisPLXYY.HisLinkPLXYY;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.dictionary.ConfigDepartments;
import cn.medigical.publish.service.ClientListenerService;
import cn.medigical.publish.udp.UdpHelper;
import cn.medigical.publish.udp.UdpModel;
import cn.medigical.publish.udp.UdpMsgAnalysis;
import cn.medigical.publish.utils.JsonUtilTool;
import cn.medigical.publish.utils.SpringUtils;
import cn.medigical.publish.xmlUtil.ClientSelectXml;
import cn.medigical.publish.xmlUtil.ServicesSign;

public class ClientPLXYYListenerServiceImpl implements ClientListenerService{

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
			Boolean flag = HisLinkPLXYY.getInstance().getOperationFromHis();			
		}
//		if (ServicesSign.PATIENT_ADD.equals(udpMsgAnalysis.getMethodId())) {
//			Boolean flag = HisLinkFuyou.getInstance().getBasicPatInfoOperation(udpModel.getZyh());			
//		}

		if (ServicesSign.ACCCOUNT_ADD.equals(udpMsgAnalysis.getMethodId())) {
			List<Account> account = HisLinkPLXYY.getInstance().getAccountFromHis();			
			UdpHelper.sendMsg("successed");
		}

		if (ServicesSign.DEPART_ADD.equals(udpMsgAnalysis.getMethodId())) {
			List<ConfigDepartments> configDepartments = HisLinkPLXYY.getInstance().getDepartmentFromHis();
			
			UdpHelper.sendMsg("successed");
		}

		// if (ServicesSign.GETLISDATA.equals(udpMsgAnalysis.getMethodId())) {
		// HisLinkFuyou.getInstance().getLisFromHis(udpModel.getPatientId(), udpModel.getZyh());
		//
		// }
		
		return false;
	}

}
