//package cn.medigical.publish.service.impl;
//
//import cn.medigical.publish.interfaces.his.hisDeChang.HisLinkDeChang;
//import cn.medigical.publish.service.ClientListenerService;
//import cn.medigical.publish.udp.UdpHelper;
//import cn.medigical.publish.udp.UdpModel;
//import cn.medigical.publish.udp.UdpMsgAnalysis;
//import cn.medigical.publish.utils.JsonUtilTool;
//import cn.medigical.publish.xmlUtil.ClientSelectXml;
//import cn.medigical.publish.xmlUtil.ServicesSign;
//
//public class ClientDCListenerServiceImpl implements ClientListenerService {
//
//    UdpMsgAnalysis udpMsgAnalysis;
//    UdpModel udpModel;
//
//
//    @Override
//    public boolean clientInteraction(String xmlString) {
//        ClientSelectXml clientSelectXml = new ClientSelectXml();
//        udpMsgAnalysis = clientSelectXml.readJsonString(xmlString);
//        if (!"Anes".equalsIgnoreCase(udpMsgAnalysis.getSystemType())) {
//            return false;
//        }
//        if (udpMsgAnalysis.getMethodId().equalsIgnoreCase("SYSTEMMODIFY")) {
//            return false;
//        }
//        udpModel = JsonUtilTool.fromJsonToObject(udpMsgAnalysis.getCustomContent(), UdpModel.class);
//        if (ServicesSign.OPERATION_ADD.equals(udpMsgAnalysis.getMethodId())) {
//            HisLinkDeChang.getInstance().getOperationFromHis();
//            UdpHelper.sendMsg("successed");
//        }
//
//        if (ServicesSign.ACCCOUNT_ADD.equals(udpMsgAnalysis.getMethodId())) {
//            HisLinkDeChang.getInstance() .getAccountFromHis();
//            UdpHelper.sendMsg("successed");
//        }
//
//        if (ServicesSign.DEPART_ADD.equals(udpMsgAnalysis.getMethodId())) {
//            HisLinkDeChang .getInstance().getDepartmentFromHis();
//            UdpHelper.sendMsg("successed");
//        }
//
//        if (ServicesSign.GETLISDATA.equals(udpMsgAnalysis.getMethodId())) {
//            HisLinkDeChang.getInstance().getLisReportFromHis(udpModel.getPatId());
//        }
//        return false;
//    }
//}
