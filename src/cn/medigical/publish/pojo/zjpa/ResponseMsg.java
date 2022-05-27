package cn.medigical.publish.pojo.zjpa;



import java.text.SimpleDateFormat;
import java.util.Date;

import cn.medigical.publish.udp.MsgHelper;

public class ResponseMsg {
    public static String getOkMsg(String infoId){

        String xml="<MCCI_IN000002UV01 ITSVersion=\"XML_1.0\" xmlns=\"urn:hl7-org:v3\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "\t<id extension=\""+ MsgHelper.getUUID()+"\"/>\n" +
                "\t<creationTime value="+"\""+new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())+"\"" +"/>\n"+
                "\t<interactionId extension=\"MCCI_IN000002UV01\" root=\"2.16.840.1.113883.1.6\"/>\n" +
                "\t<processingCode code=\"P\"/>\n" +
                "\t<processingModeCode/>\n" +
                "\t<acceptAckCode code=\"AL\"/>\n" +
                "\t<receiver typeCode=\"RCV\">\n" +
                "\t\t<device classCode=\"DEV\" determinerCode=\"INSTANCE\">\n" +
                "\t\t\t<id>\n" +
                "\t\t\t\t<item extension=\"SYS001\"/>\n" +
                "\t\t\t</id>\n" +
                "\t\t</device>\n" +
                "\t</receiver>\n" +
                "\t<sender typeCode=\"SND\">\n" +
                "\t\t<device classCode=\"DEV\" determinerCode=\"INSTANCE\">\n" +
                "\t\t\t<id>\n" +
                "\t\t\t\t<item extension=\"SYS007\"/>\n" +
                "\t\t\t</id>\n" +
                "\t\t</device>\n" +
                "\t</sender>\n" +
                "\t<!--AA成功，AE失败-->\n" +
                "\t<acknowledgement typeCode=\"AA\">\n" +
                "\t\t<!--请求消息ID-->\n" +
                "\t\t<targetMessage>\n" +
                "\t\t\t<id extension=\""+infoId+"\"/>\n" +
                "\t\t</targetMessage>\n" +
                "\t\t<acknowledgementDetail>\n" +
                "\t\t\t<text value=\"消息处理成功\"/>\n" +
                "\t\t</acknowledgementDetail>\n" +
                "\t</acknowledgement>\n" +
                "</MCCI_IN000002UV01>\n";
        return xml;
    }
    public static String getFailuMsg(String infoId){
    String xml="<MCCI_IN000002UV01 ITSVersion=\"XML_1.0\" xmlns=\"urn:hl7-org:v3\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
            "\t<id extension=\""+MsgHelper.getUUID()+"\"/>\n" +
            "\t<creationTime value="+"\""+new SimpleDateFormat("yyyyMMddhhmm").format(new Date())+"\""+"/>\n" +
            "\t<interactionId extension=\"MCCI_IN000002UV01\" root=\"2.16.840.1.113883.1.6\"/>\n" +
            "\t<processingCode code=\"P\"/>\n" +
            "\t<processingModeCode/>\n" +
            "\t<acceptAckCode code=\"AL\"/>\n" +
            "\t<receiver typeCode=\"RCV\">\n" +
            "\t\t<device classCode=\"DEV\" determinerCode=\"INSTANCE\">\n" +
            "\t\t\t<id>\n" +
            "\t\t\t\t<item extension=\"SYS001\"/>\n" +
            "\t\t\t</id>\n" +
            "\t\t</device>\n" +
            "\t</receiver>\n" +
            "\t<sender typeCode=\"SND\">\n" +
            "\t\t<device classCode=\"DEV\" determinerCode=\"INSTANCE\">\n" +
            "\t\t\t<id>\n" +
            "\t\t\t\t<item extension=\"SYS007\"/>\n" +
            "\t\t\t</id>\n" +
            "\t\t</device>\n" +
            "\t</sender>\n" +
            "\t<!--AA成功，AE失败-->\n" +
            "\t<acknowledgement typeCode=\"AE\">\n" +
            "\t\t<!--请求消息ID-->\n" +
            "\t\t<targetMessage>\n" +
            "\t\t\t<id extension=\""+infoId+"\"/>\n" +
            "\t\t</targetMessage>\n" +
            "\t\t<acknowledgementDetail>\n" +
            "\t\t\t<text value=\"xml解析失败\"/>\n" +
            "\t\t</acknowledgementDetail>\n" +
            "\t</acknowledgement>\n" +
            "</MCCI_IN000002UV01>\n";
    return xml;
    }

}
