package cn.medigical.publish.interfaces.his.hisTianshui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    public static String filtration(String xml){
        StringBuffer buffer = new StringBuffer();
        buffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        buffer.append(xml);
        if (xml!=null && !xml.equals("")) {
            xml = xml.replace("<![CDATA[","").replace("]]>","");
            Pattern p = Pattern.compile("\r|\n");
            Matcher m = p.matcher(xml);
            xml = m.replaceAll("");
        }//创建一个新的字符串
        return xml;
    }
}
