package cn.medigical.publish.xmlUtil.nantong;


import cn.medigical.publish.interfaces.wxzt.WXZTInfo;

import java.util.List;

public class WXZTResponseXml {

    public String getWXZTResponseXml(List<WXZTInfo> WXZTList){
        String head = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "<response>\n";
        String bottom = "   </response>\n";
        for (WXZTInfo WXZT : WXZTList) {
            String xml = 
                    "\t\t<WXZT_BASE>\n" +
                            "\t\t\t<ZHY>"+ WXZT.getZHY()+"</ZHY>\n" +
                            "\t\t\t<XM>"+ WXZT.getXM()+"</XM>\n" +
                            "            <XB>"+ WXZT.getXB()+"</XB>\n" +
                            "            <BQ>"+ WXZT.getBQ()+"</BQ>\n" +
                            "            <CH>"+ WXZT.getCH()+"</CH>\n" +
                            "            <NL>"+ WXZT.getNL()+"</NL>\n" +
                            "            <TZ>"+ WXZT.getTZ()+"</TZ>\n" +
                            "            <SG>"+ WXZT.getSG()+"</SG>\n" +
                            "\t\t    <SSMC>"+ WXZT.getSSMC()+"</SSMC>\n" +
                            "            <ASA>"+ WXZT.getASA()+"</ASA>\n" +
                            "            <MZYS>"+ WXZT.getMZYS()+"</MZYS>\n" +
                            "            <ZTFS>"+ WXZT.getZTFS()+"</ZTFS>\n" +
                            "            <PF>"+ WXZT.getPF()+"</PF>\n" +
                            "\t\t   <FB>"+ WXZT.getFB()+"</FB>\n" +
                            "            <SFZH>"+ WXZT.getSFZH()+"</SFZH>\n" +
                            "\t\t\t<KS>"+ WXZT.getKS()+"</KS>\n" +
                            "\t\t\t<HKDZ>"+ WXZT.getHKDZ()+"</HKDZ>\n" +
                            "\t\t\t<BQZZ>"+ WXZT.getBQZZ()+"</BQZZ>\n" +
                            "            <SSSJ>"+ WXZT.getSSSJ()+"</SSSJ>\n" +
                            "            <ZYSJ>"+ WXZT.getZYSJ()+"</ZYSJ>\n" +
                            "\t\t\t<OPERID>"+ WXZT.getOPERID()+"</OPERID>\n" +
                            "\t\t</WXZT_BASE>\n";
            
            head = head + xml;
        }
        return head + bottom;
    }
   }
