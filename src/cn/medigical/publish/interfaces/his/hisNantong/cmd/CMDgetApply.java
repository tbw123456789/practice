 package cn.medigical.publish.interfaces.his.hisNantong.cmd;

 import cn.medigical.publish.interfaces.his.hisNantong.xml.apply.APPLYROOTType;
 import cn.medigical.publish.interfaces.his.hisNantong.xml.apply.ITEMType;
 import org.apache.log4j.Logger;

 import javax.xml.bind.JAXBContext;
 import javax.xml.bind.JAXBElement;
 import javax.xml.bind.Unmarshaller;
 import java.io.ByteArrayInputStream;
 import java.io.InputStream;
 import java.io.UnsupportedEncodingException;
 import java.util.ArrayList;
 import java.util.List;

 public class CMDgetApply extends AbsXMLSendCmd
 {
   Logger logger = Logger.getLogger("CMDgetApply");
   private List<ITEMType> itemTypeList;
   private String startTimeStr = "";
   private String endTimeStr = "";
 
   public void setTime(String startTimeStr, String endTimeStr) {
     this.startTimeStr = startTimeStr;
     this.endTimeStr = endTimeStr;
   }
 
   public String getParam()
   {
     return "<ADM_NO></ADM_NO><PATIENT_ID></PATIENT_ID><VISIT_ID></VISIT_ID><IN_START>" + this.startTimeStr + "</IN_START>" + "<IN_END>" + this.endTimeStr + "</IN_END>" + "<SCHEDULE_ID></SCHEDULE_ID><DEPT_STAYED></DEPT_STAYED>";
   }
 
   public String getService()
   {
     return "BC.surgery.schedule";
   }
 
   public String getXMLRoot()
   {
     return "APPLYROOT";
   }
 
   public void parseXML(String xml)
   {
     JAXBContext jc = null;
     try {
       jc = JAXBContext.newInstance("cn.medigical.publish.interfaces.his.hisNantong.xml.apply");
       Unmarshaller u = jc.createUnmarshaller();
 
       InputStream payLoadStream = null;
       try
       {
         payLoadStream = new ByteArrayInputStream(xml.getBytes("utf-8"));
       } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
         return;
       }
 
       if (null == payLoadStream) {
         return;
       }
 
       JAXBElement customerE = (JAXBElement)u.unmarshal(payLoadStream);
 
       APPLYROOTType contentType = (APPLYROOTType)customerE.getValue();
 
       List list = contentType.getITEM();
       if (null == list) {
         this.itemTypeList = new ArrayList();
       } else {
         if (null == this.itemTypeList) {
           this.itemTypeList = new ArrayList();
         }
         this.itemTypeList.clear();
         this.itemTypeList.addAll(list);
       }
 
     }
     catch (Exception e)
     {
       this.logger.fatal(e.getMessage(), e);
       this.itemTypeList = new ArrayList();
     }
   }
 
   public List<ITEMType> getItemTypeList()
   {
     return this.itemTypeList;
   }
 }

