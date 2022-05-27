package cn.medigical.publish.xmlUtil.tongliang;

import cn.medigical.publish.pojo.patient.Patient;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class NISRequestXml {
    public Map readRequestXML(String xmlString) {
        long start = System.currentTimeMillis();
        Map map=new HashMap();
        List<Patient> list=new ArrayList();
        SAXReader reader = new SAXReader();
        try {
            org.dom4j.Document doc = reader.read(new ByteArrayInputStream(xmlString.getBytes("UTF-8")));
            org.dom4j.Element root = doc.getRootElement();
            org.dom4j.Element element;
            org.dom4j.Element element2;
            org.dom4j.Element element3;
            System.out.println("method:[" + root.elementText("method") + "]");
            map.put("method",root.elementText("method"));
            for (Iterator i = root.elementIterator("para"); i.hasNext(); ) {
                element = (org.dom4j.Element) i.next();
                for (Iterator j = element.elementIterator("patientids"); j.hasNext(); ) {
                    element2 = (org.dom4j.Element) j.next();
                    Patient patient=new Patient();
                    for (Iterator k = element2.elementIterator("element"); k.hasNext(); ) {
                        element3 = (org.dom4j.Element) k.next();
                        System.out.println("\t\tPATIENT_ID:["+ element3.elementText("PATIENT_ID") + "]");
                        System.out.println("\t\tVISIT_ID:["+ element3.elementText("VISIT_ID") + "]");
                        patient.setZyh(element3.elementText("PATIENT_ID"));
                        patient.setZycs(element3.elementText("VISIT_ID"));
                        list.add(patient);
                    }
                }
            }
            map.put("patient",list);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start) + "ms");
        return  map;
    }

}

