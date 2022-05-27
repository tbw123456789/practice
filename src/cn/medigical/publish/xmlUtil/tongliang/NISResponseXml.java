package cn.medigical.publish.xmlUtil.tongliang;


import cn.medigical.publish.interfaces.nis.tongliang.NisOperEvents;
import cn.medigical.publish.interfaces.nis.tongliang.NisOperInfo;

import java.util.List;

public class NISResponseXml {

    public String getNisOperInfoResponseXml(List<NisOperInfo> nisOperInfoList){
        String head = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "<response>\n";
        String bottom = "   </response>\n";
        for (NisOperInfo nisOperInfo : nisOperInfoList) {
            String xml = 
                    "\t\t<NIS_OperationB>\n" +
                            "\t\t\t<PATIENT_ID>"+ nisOperInfo.getPATIENT_ID()+"</PATIENT_ID>\n" +
                            "\t\t\t<VISIT_ID>"+ nisOperInfo.getVISIT_ID()+"</VISIT_ID>\n" +
                            "            <OPER_ID>"+ nisOperInfo.getOPER_ID()+"</OPER_ID>\n" +
                            "            <OPER_NAME>"+ nisOperInfo.getOPER_NAME()+"</OPER_NAME>\n" +
                            "            <OPER_CODE>"+ nisOperInfo.getOPER_CODE()+"</OPER_CODE>\n" +
                            "            <OPER_DIAGNOSIS>"+ nisOperInfo.getOPER_DIAGNOSIS()+"</OPER_DIAGNOSIS>\n" +
                            "            <SURGEON>"+ nisOperInfo.getSURGEON()+"</SURGEON>\n" +
                            "            <FIRSTAS>"+ nisOperInfo.getFIRSTAS()+"</FIRSTAS>\n" +
                            "\t\t    <ANESTHESTA>"+ nisOperInfo.getANESTHESTA()+"</ANESTHESTA>\n" +
                            "            <ANESTHESTA_METHOD>"+ nisOperInfo.getANESTHESTA_METHOD()+"</ANESTHESTA_METHOD>\n" +
                            "            <START_DATE_TIME>"+ nisOperInfo.getSTART_DATE_TIME()+"</START_DATE_TIME>\n" +
                            "            <END_DATE_TIME>"+ nisOperInfo.getEND_DATE_TIME()+"</END_DATE_TIME>\n" +
                            "            <OPER_QUANTUM>"+ nisOperInfo.getOPER_QUANTUM()+"</OPER_QUANTUM>\n" +
                            "\t\t   <WOUND_GRADE>"+ nisOperInfo.getWOUND_GRADE()+"</WOUND_GRADE>\n" +
                            "            <ASA>"+ nisOperInfo.getASA()+"</ASA>\n" +
                            "\t\t\t<NNIS>"+ nisOperInfo.getNNIS()+"</NNIS>\n" +
                            "\t\t\t<HEAL>"+ nisOperInfo.getHEAL()+"</HEAL>\n" +
                            "\t\t\t<LOCATION>"+ nisOperInfo.getLOCATION()+"</LOCATION>\n" +
                            "            <OPER_TYPE>"+ nisOperInfo.getOPER_TYPE()+"</OPER_TYPE>\n" +
                            "            <EMBED>"+ nisOperInfo.getEMBED()+"</EMBED>\n" +
                            "\t\t\t<ENDOSCOPIC>"+ nisOperInfo.getENDOSCOPIC()+"</ENDOSCOPIC>\n" +
                            "\t\t\t<OPER_ROOM>"+ nisOperInfo.getOPER_ROOM()+"</OPER_ROOM>\n" +
                            "            <BLOOD_OUT>"+ nisOperInfo.getBLOOD_OUT()+"</BLOOD_OUT>\n" +
                            "            <BLOOD_IN>"+ nisOperInfo.getBLOOD_IN()+"</BLOOD_IN>\n" +
                            "\t\t</NIS_OperationB>\n";
            
            head = head + xml;
        }
        return head + bottom;
    }

    public String getNisOperEventResponseXml(List<NisOperEvents> nisOperEventsList){
        String head = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "<response>\n";
        String bottom = "   </response>\n";
        for (NisOperEvents nisOperEvents : nisOperEventsList) {
            String xml =
                    "\t\t<NIS_OperationEvent>\n" +
                            "\t\t\t<PATIENT_ID>"+nisOperEvents.getPATIENT_ID()+"</PATIENT_ID>\n" +
                            "\t\t\t<VISIT_ID>"+nisOperEvents.getVISIT_ID()+"</VISIT_ID>\n" +
                            "            <OPER_ID>"+nisOperEvents.getOPER_ID()+"</OPER_ID>\n" +
                            "            <EVENTS_ID>"+nisOperEvents.getEVENTS_ID()+"</EVENTS_ID>\n" +
                            "            <EVENTS_NAME>"+nisOperEvents.getEVENTS_NAME()+"</EVENTS_NAME>\n" +
                            "            <EVENTS_TIME>"+nisOperEvents.getEVENTS_TIME()+"</EVENTS_TIME>\n" +
                            "\t\t   <EVENTS_TYPE>"+nisOperEvents.getEVENTS_TYPE()+"</EVENTS_TYPE>\n" +
                            "            <ADMINISTRATION>"+nisOperEvents.getADMINISTRATION()+"</ADMINISTRATION>\n" +
                            "\t\t</NIS_OperationEvent>";
            
            head = head + xml;
        }
        return head + bottom;
    }



}
