package cn.medigical.publish.pojo.zjpa;




import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

public class BaseSelectXml <T>{

    T cls;
    Class  clsmap;

    private static int idea[];
    private static List<HashMap> diagnosisList = new ArrayList<>();
    private static HashMap<String, String> Identifier = new HashMap<>();
    private HashMap<String, String> patId=new HashMap<>();
    private static HashMap<String, HashMap<String, String>> address = new HashMap<>();

    public BaseSelectXml(T cls){
        this.cls = cls;
        try{
            String path=this.cls.getClass().getName()+ "Map";//得到包路径
            clsmap = Class.forName(path);//得到对应的map
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static HashMap<String, String> map=new HashMap<>();

    public T getDataPlatformModel(String xmlString,String num) {
        try{
            idea = new int[10];
            Document doc = DocumentHelper.parseText(xmlString); // 将字符串转为XML
            Element root = doc.getRootElement(); // 获取根节点
            Object obj = clsmap.newInstance();
            Field clsmapPath = clsmap.getField("path");
            String tssts = clsmap.getName();
            String[] pack =tssts.split("[.]");
            Field clsmapDeptMap = clsmap.getField(pack[pack.length-2]);
            Field clsmapCycle = clsmap.getField("cycle");
            String [] path = (String[]) clsmapPath.get(obj);
            HashMap<String, String> modelMap = (HashMap<String, String>)clsmapDeptMap.get(obj);
            String cycle = (String) clsmapCycle.get(obj);
            for(int i = 0; i< path.length; i++){
                Element point=root.element(path[i]);
                root=point;
            }
            List<Element> nodeList=root.elements(cycle);
            Field field[] = cls.getClass().getDeclaredFields();
            for(int i=0;i<nodeList.size();i++){
                getNodes(nodeList.get(i),num);
                for (Field field2 : field) {
                    String name = field2.getName();
                    String mapName = modelMap.get(name);
                    String value = map.get(mapName);
                }
            }
            for(int i=0;i<nodeList.size();i++){
                getNodes(nodeList.get(i),num);
                for (Field field2 : field) {
                    String name = field2.getName();
                    String mapName = modelMap.get(name);
                    String value= map.get(mapName);
                    if(name.equals("Identifier") && this.cls.getClass().getName().indexOf("PatientHis") > 0){
                        Method method = cls.getClass().getMethod("setIdentifier", HashMap.class);
                        method.invoke(cls, Identifier);
                    }else if(name.equals("address") && this.cls.getClass().getName().indexOf("PatientHis") > 0) {
                        Method method = cls.getClass().getMethod("setAddress", HashMap.class);
                        method.invoke(cls, address);
                    }else if(name.equals("diagnosisList") && this.cls.getClass().getName().indexOf("HospitalVisitInformationHis") > 0) {
                        Method method = cls.getClass().getMethod("setDiagnosisList", List.class);
                        method.invoke(cls, diagnosisList);
                    }else if(name.equals("patId") && this.cls.getClass().getName().indexOf("PatientQuery") > 0){
                        Method method = cls.getClass().getMethod("setPatId", HashMap.class);
                        method.invoke(cls,  patId);
                    }else{
                        Method method = cls.getClass().getMethod("set" + field2.getName().substring(0, 1).toUpperCase() + field2.getName().substring(1), String.class);
                        method.invoke(cls, value);
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return cls;
    }

    public void getNodes(Node node, String num){
        List<Attribute> listAttr=((Element)node).attributes();//当前节点的所有属性的list
        for(Attribute attr:listAttr){//遍历属性取值
            String name=attr.getName();
            String value=attr.getValue();
            if (attr.getPath().contains("']/*[name()='")) {
                String string= attr.getPath().replace("']/*[name()='", "/").replace("']/", "/");
                string = string.substring(num.length() + 11);
                if(value.equals("/controlActProcess/subject/placerGroup/componentOf1/encounter/subject/patient/id/item/@extension")){
                    value = value.replaceAll("item","item" + String.valueOf(idea[0]));
                    idea[0]++;
                }
                map.put(string==null?"":string, value==null?"":value);
            }
        }
        List<Element> listElement=((Element)node).elements();//当前节点的所有下级节点
        if(node.getName().equals("id")){
        }
        if(listAttr.size() == 0 && listElement.size() == 0 && node.hasContent()){//当节点无下级并且无属性并且有text时
            String value = ((Element) node).attribute(0).getText();
            String string= node.getPath().replace("']/*[name()='", "/").replace("']/", "/").substring(num.length() + 11);
            map.put(string==null?"":string, value==null?"":value);
        }
        if(node.getName().equals("id")&&listElement.size() == 2){//当节点名称为id并且有十三个下级节点时
            for(Element e:listElement){
                List<Attribute> list=((Element)e).attributes();
                patId.put(list.get(1).getValue(),list.get(0).getValue());
            }
        }
        if(node.getName().equals("id")&&listElement.size() == 6){//当节点名称为id并且有十三个下级节点时
            for(Element e:listElement){
                List<Attribute> list=((Element)e).attributes();
                Identifier.put(list.get(1).getValue(),list.get(0).getValue());
            }
        }
//        if(node.getName().equals("reason")){//当节点名称为id并且有十三个下级节点时
//            HashMap<String, String> diagnosisMap = new HashMap<>();
//            Node value=((Element)listElement.get(0)).elements().get(2);
//            Node authorAssIdItem=((Element)listElement.get(0)).elements().get(3).elements().get(0).elements().get(0).elements().get(0).attributes().get(0);
//            diagnosisMap.put(((Element)value).attributes().get(0).getName(),((Element)value).attributes().get(0).getValue());
//            diagnosisMap.put(((Element)value).elements().get(0).attributes().get(0).getName(),((Element)value).elements().get(0).attributes().get(0).getValue());
//            diagnosisMap.put(authorAssIdItem.getName(),authorAssIdItem.getStringValue());
//            diagnosisList.add(diagnosisMap);
//        }
        if(node.getName().equals("addr")){//当节点为地址时

            HashMap<String, String> addr = new HashMap<>();
            String string= node.getPath().replace("']/*[name()='", "/").replace("']/", "/").substring(num.length() + 11);
            if(listElement.size() == 1){
                addr.putAll(setHashMap(addr,listElement.get(0).elements()));
            }else{
                addr.putAll(setHashMap(addr,listElement));
            }
            address.put(string,addr);
        }
        for(Element e:listElement){
            getNodes(e,num);
        }
    }

    private HashMap<String, String> setHashMap(HashMap<String, String> addr,List<Element> listElement){
        for(Element e:listElement){
            List<Attribute> list=((Element)e).attributes();
            addr.put(list.get(0).getValue(),list.get(1).getValue());
        }
        return addr;
    }

}
