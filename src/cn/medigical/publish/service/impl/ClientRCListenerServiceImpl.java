package cn.medigical.publish.service.impl;

import cn.medigical.publish.interfaces.his.hisNantong.HisLinkNantong;
import cn.medigical.publish.interfaces.his.hisRongchang.HisLinkRongChang;
import cn.medigical.publish.interfaces.lis.lisNantong.LisDataNantong2;
import cn.medigical.publish.interfaces.lis.rongchang.LisDataRongChang;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.dictionary.ConfigDepartments;
import cn.medigical.publish.service.ClientListenerService;
import cn.medigical.publish.udp.UdpHelper;
import cn.medigical.publish.udp.UdpModel;
import cn.medigical.publish.udp.UdpMsgAnalysis;
import cn.medigical.publish.utils.JsonUtilTool;
import cn.medigical.publish.xmlUtil.ClientSelectXml;
import cn.medigical.publish.xmlUtil.ServicesSign;

import java.util.List;

public class ClientRCListenerServiceImpl implements ClientListenerService {

    UdpMsgAnalysis udpMsgAnalysis;
    UdpModel udpModel;


    @Override
    public boolean clientInteraction(String xmlString) {
        ClientSelectXml clientSelectXml = new ClientSelectXml();
        udpMsgAnalysis = clientSelectXml.readJsonString(xmlString);
        if (!"Anes".equalsIgnoreCase(udpMsgAnalysis.getSystemType())) {
            return false;
        }
        if (udpMsgAnalysis.getMethodId().equalsIgnoreCase("SYSTEMMODIFY")) {
            return false;
        }
        udpModel = JsonUtilTool.fromJsonToObject(udpMsgAnalysis.getCustomContent(), UdpModel.class);
        if (ServicesSign.OPERATION_ADD.equals(udpMsgAnalysis.getMethodId())) {
            HisLinkRongChang.getInstance().getOperationFromHis();
            UdpHelper.sendMsg("successed");
        }
        if (ServicesSign.PATIENT_ADD.equals(udpMsgAnalysis.getMethodId())) {
            HisLinkRongChang.getInstance().getBasicPatInfoOperation(udpModel.getZyh());
            UdpHelper.sendMsg("successed");
        }

        if (ServicesSign.ACCCOUNT_ADD.equals(udpMsgAnalysis.getMethodId())) {
            HisLinkRongChang.getInstance() .getAccountFromHis();
            UdpHelper.sendMsg("successed");
        }

        if (ServicesSign.DEPART_ADD.equals(udpMsgAnalysis.getMethodId())) {
            HisLinkRongChang .getInstance().getDepartmentFromHis();
            UdpHelper.sendMsg("successed");
        }

        if (ServicesSign.GETLISDATA.equals(udpMsgAnalysis.getMethodId())) {
            LisDataRongChang.getInstance().getLisFromHis(udpModel.getPatientId(),udpModel.getZyh(), "");
        }
        return false;
    }
}
