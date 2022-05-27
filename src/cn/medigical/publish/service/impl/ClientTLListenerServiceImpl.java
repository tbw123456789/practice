package cn.medigical.publish.service.impl;

import java.util.List;

import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigDepartmentsDao;
import cn.medigical.publish.interfaces.his.hisTongliang.HisService;
import cn.medigical.publish.udp.*;
import cn.medigical.publish.utils.JsonUtilTool;
import cn.medigical.publish.service.ClientListenerService;
import cn.medigical.publish.utils.SpringUtils;
import cn.medigical.publish.xmlUtil.ClientSelectXml;
import cn.medigical.publish.xmlUtil.ServicesSign;


public class ClientTLListenerServiceImpl implements ClientListenerService {

    AccountDao accountDao = (AccountDao) SpringUtils.getBean(AccountDao.class);
    ConfigDepartmentsDao configDepartmentsDao = SpringUtils.getBean(ConfigDepartmentsDao.class);

    UdpMsgAnalysis udpMsgAnalysis;
    UdpModel udpModel;
    HisService hisService = new HisService();

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
            Boolean flag = hisService.getOprationFromHis();
            if (flag == true) {
                UdpHelper.sendMsg("successed");
            } else {
                UdpHelper.sendMsg("failed");
            }
        }
        if (ServicesSign.ACCCOUNT_ADD.equals(udpMsgAnalysis.getMethodId())) {
            Boolean flag = hisService.getAccountFromHis();
            UdpHelper.sendMsg("successed");
        }
        if (ServicesSign.DEPART_ADD.equals(udpMsgAnalysis.getMethodId())) {
            Boolean flag = hisService.getAllDepartment();
            UdpHelper.sendMsg("successed");
        }
        if (ServicesSign.GETLISDATA.equals(udpMsgAnalysis.getMethodId())) {
            hisService.getLisDateTongLiang(udpModel.getPatientId(),udpModel.getZyh(),udpModel.getAccountID());
            UdpHelper.sendMsg("successed");
        }

        return false;
    }
}
