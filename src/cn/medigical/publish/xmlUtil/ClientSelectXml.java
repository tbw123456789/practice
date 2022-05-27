package cn.medigical.publish.xmlUtil;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.xml.sax.InputSource;

import cn.medigical.publish.udp.UdpMsgAnalysis;
import cn.medigical.publish.utils.JsonUtilTool;

public class ClientSelectXml {
    public Map readXML(String xmlResult) {
        Map map = new HashMap();
        try {
            // 将xml格式字符串转化为DOM对象
            Document document = DocumentHelper.parseText(xmlResult);
            // 获取根结点对象
            Element rootElement = document.getRootElement();
            // 获取该标签对象的属性
            Attribute attr1 = rootElement.attribute("type");
            System.out.println(attr1.getValue());
            Element element2 = rootElement.element("MethodId");
            map.put("MethodId", element2.getTextTrim());
            Element element = rootElement.element("businessIds");
            List<Element> nodelist = element.elements("id");
            List<String> list = new ArrayList<>();
            for (int i = 0; i < nodelist.size(); i++) {
                list.add(nodelist.get(i).getTextTrim());
            }
            map.put("businessIds", list);
            // 循环根节点，获取其子节点
           /* for (Iterator iter = rootElement.elementIterator(); iter.hasNext();) {
                Element element = (Element) iter.next(); // 获取标签对象
                // 获取该标签对象的属性
                Attribute attr = element.attribute("id");
                if (null != attr) {
                    String attrVal = attr.getValue();
                    String attrName = attr.getName();
                    System.out.println(attrName + ": " + attrVal);
                }
                // 循环第一层节点，获取其子节点
                for (Iterator iterInner = element.elementIterator(); iterInner.hasNext();) {
                    // 获取标签对象
                    Element elementOption = (Element) iterInner.next();
                    // 获取该标签对象的名称
                    String tagName = elementOption.getName();
                    // 获取该标签对象的内容
                    String tagContent = elementOption.getTextTrim();
                    // 输出内容
                    System.out.print(tagName + ": " + tagContent + "  ");
                }
                System.out.println();
            }*/

        } catch (Exception e) {
            //e.printStackTrace();
        }
        return map;
    }

    public UdpMsgAnalysis readJsonString(String jsonStr) {

        //JSONObject jsonobject = JSONObject.fromObject(jsonStr);
        //UdpMsgAnalysis udpMsgAnalysis = (UdpMsgAnalysis) JSONObject.toBean(jsonobject, UdpMsgAnalysis.class);
        UdpMsgAnalysis udpMsgAnalysis =JsonUtilTool.fromJsonToObject(jsonStr, UdpMsgAnalysis.class);

        return udpMsgAnalysis;
    }
}


