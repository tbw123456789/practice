package cn.medigical.publish.pojo.zjpa.patientLink;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;



public class OperationHisSelectXml {
	public OperationHisSelectXml(){
		mazuiList.clear();
		map.clear();
	}
	private static HashMap<String, String> map=new HashMap<>();
	private static List<String> mazuiList=new ArrayList();
	private static List<String> idList=new ArrayList<>();

	public static OperationHis getOperatoin(String xml) {
		  map.clear();
          idList.clear();
          mazuiList.clear();
		OperationHis operationHis=new OperationHis();
		try{
			OperationHisSelectXml operationHisSelectXml =new OperationHisSelectXml();
            Document document=DocumentHelper.parseText(xml);
            Element rElement=document.getRootElement();
            operationHisSelectXml.getNodes(rElement);
              Field field[] = operationHis.getClass().getDeclaredFields();
              for (Field field2 : field) {
            	  String fieldName=field2.getName();
        		  if (fieldName.endsWith("List")) {
					  continue;
				  }
				  if(field2.getName().equals("DeptName")){
					
				  }
					String value= map.get(OperationHisMap.operMap.get(field2.getName()));
					Method method= operationHis.getClass().getMethod("set"+field2.getName().substring(0, 1).toUpperCase()+field2.getName().substring(1),String.class);
					method.invoke(operationHis, value);
				}
              Element point;
              for(int i=0;i<OperationHisMap.path.length;i++){
            	  point=rElement.element(OperationHisMap.path[i]);
            	  rElement=point;
              }
            
              List<Element> nodeList=rElement.elements(OperationHisMap.cycle);
              operationHis.setOperIdList(new ArrayList<String>());
              operationHis.setExecDeptIdList(new ArrayList<String>());
              operationHis.setExecDeptNameList(new ArrayList<String>());
              operationHis.setOperDocIdList(new ArrayList<String>());
              operationHis.setOperDocNameList(new ArrayList<String>());
              operationHis.setOperLevelIdList(new ArrayList<String>());
              operationHis.setOperLevelNmeList(new ArrayList<String>());
              operationHis.setOperNameList(new ArrayList<String>());
              operationHis.setOperPlanTimeList(new ArrayList<String>());
              for(int i=0;i<nodeList.size();i++){
            	  operationHisSelectXml.getNodes(nodeList.get(i));

            	  operationHis.getOperIdList().add(map.get(OperationHisMap.operMap.get("operId"))==null?"":map.get(OperationHisMap.operMap.get("operId")));
            	  operationHis.getOperNameList().add(map.get(OperationHisMap.operMap.get("operName"))==null?"":map.get(OperationHisMap.operMap.get("operName")));
            	  operationHis.getOperLevelIdList().add(map.get(OperationHisMap.operMap.get("operLevelId"))==null?"":map.get(OperationHisMap.operMap.get("operLevelId")));
            	  operationHis.getOperLevelNmeList().add(map.get(OperationHisMap.operMap.get("operLevelNme"))==null?"":map.get(OperationHisMap.operMap.get("operLevelNme")));
            	  operationHis.getOperPlanTimeList().add(map.get(OperationHisMap.operMap.get("operPlanTime"))==null?"":map.get(OperationHisMap.operMap.get("operPlanTime")));
            	  operationHis.getOperDocIdList().add(map.get(OperationHisMap.operMap.get("operDocId"))==null?"":map.get(OperationHisMap.operMap.get("operDocId")));
           	      operationHis.getOperDocNameList().add(map.get(OperationHisMap.operMap.get("operDocName"))==null?"":map.get(OperationHisMap.operMap.get("operDocName")));
            	  operationHis.getExecDeptIdList().add(map.get(OperationHisMap.operMap.get("execDeptId"))==null?"":map.get(OperationHisMap.operMap.get("execDeptId")));
            	  operationHis.getExecDeptNameList().add(map.get(OperationHisMap.operMap.get("execDeptName"))==null?"":map.get(OperationHisMap.operMap.get("execDeptName")));

			  }
			  operationHis.setMaZuiMethodName(mazuiList.get(0));
              operationHis.setOperTypeName(mazuiList.get(1));
              operationHis.setAreaId(idList.get(0));
              operationHis.setPatientId(idList.get(1));
              operationHis.setOutPatientId(idList.get(2));
              operationHis.setVisitId(idList.get(3));
	        }catch (Exception e){
	            e.printStackTrace();
	        }
		return operationHis;
	}
	public  void getNodes(Node node){  
				List<Attribute> listAttr=((Element)node).attributes();
				if (listAttr.size()==0) {
					String path=node.getPath().replace("']/*[name()='", "/").replace("']/", "/").replace("']", "").trim().substring(26);
					String value=node.getText();
					map.put(path==null?"":path, value==null?"":value);
				}else {
					for(Attribute attr:listAttr){
				        String name=attr.getName();
				        String value=attr.getValue();
				        if (attr.getPath().contains("']/*[name()='")) {
							String string= attr.getPath().replace("']/*[name()='", "/").replace("']/", "/").substring(26);
							if (string.equalsIgnoreCase(OperationHisMap.operMap.get("operTypeName"))){
								mazuiList.add(value==null?"":value);
							}
							if (string.equalsIgnoreCase(OperationHisMap.operMap.get("areaId"))){
								idList.add(value==null?"":value);
							}
							map.put(string==null?"":string, value==null?"":value);
						}
				    } 
				}
		    	
		    List<Element> listElement=((Element)node).elements();
		    for(Element e:listElement){
		        this.getNodes(e);
		   }  
		}  

}
