package cn.medigical.publish.xmlUtil.tongliang;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

public class NISOperInfoTestXml {
    public static void readRequestXML() {
        String xml = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>"+
                "<request>" +
                    "<method>GETNIS_OPERATIONBBYPATIENTID</method>" +
                    "<para>" +
                        "<patientids>" +
                            "<element>" +
                                "<PATIENT_ID>123456</PATIENT_ID>" +
                                "<VISIT_ID>1</VISIT_ID>" +
                            "</element>" +
                            "<element>" +
                                "<PATIENT_ID>1234509</PATIENT_ID>" +
                                "<VISIT_ID>2</VISIT_ID>" +
                            "</element>" +
                        "</patientids>" +
                    "</para>" +
                "</request>";

        long start = System.currentTimeMillis();

        SAXReader reader = new SAXReader();
        try {
            org.dom4j.Document doc = reader.read(new ByteArrayInputStream(xml.getBytes("UTF-8")));
            org.dom4j.Element root = doc.getRootElement();
            org.dom4j.Element element;
            org.dom4j.Element element2;
            org.dom4j.Element element3;
            System.out.println("name:[" + root.elementText("method") + "]");

            for (Iterator i = root.elementIterator("para"); i.hasNext(); ) {
                element = (org.dom4j.Element) i.next();
                //System.out.println("name:[" + element.elementText("name") + "]");
                //System.out.println("age:[" + element.elementText("age") + "]");
                for (Iterator j = element.elementIterator("patientids"); j.hasNext(); ) {
                    element2 = (org.dom4j.Element) j.next();
                    //System.out.println("\tnum:[" + element2.elementText("num")+ "]");
                    //System.out.println("\tcode:["+ element2.elementText("code") + "]");
                    for (Iterator k = element2.elementIterator("element"); k.hasNext(); ) {
                        element3 = (org.dom4j.Element) k.next();
                        System.out.println("\t\tip:["+ element3.elementText("PATIENT_ID") + "]");
                        System.out.println("\t\tmask:["+ element3.elementText("VISIT_ID") + "]");
                    }
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");
    }
    public static void main(String[] args) {
        readRequestXML();
    }
}
