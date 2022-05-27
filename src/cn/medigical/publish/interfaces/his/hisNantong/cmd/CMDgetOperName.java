 package cn.medigical.publish.interfaces.his.hisNantong.cmd;


 import cn.medigical.publish.interfaces.his.hisNantong.xml.surgeryname.ITEMType;
 import cn.medigical.publish.interfaces.his.hisNantong.xml.surgeryname.OPERNAMEROOTType;
 import org.apache.log4j.Logger;

 import javax.xml.bind.JAXBContext;
 import javax.xml.bind.JAXBElement;
 import javax.xml.bind.Unmarshaller;
 import java.io.ByteArrayInputStream;
 import java.io.InputStream;
 import java.io.UnsupportedEncodingException;

 public class CMDgetOperName extends AbsXMLSendCmd
 {
   Logger logger = Logger.getLogger("CMDgetOperName");
   String pid = "";
   String zycs = "";
   String scheduleID = "";
   ITEMType itemType;
 
   public void setPid(String pid)
   {
     this.pid = pid;
   }
 
   public void setZycs(String zycs) {
     this.zycs = zycs;
   }
 
   public void setScheduleID(String scheduleID) {
     this.scheduleID = scheduleID;
   }
 
   public String getParam()
   {
     return "<ADM_NO></ADM_NO><PATIENT_ID>" + this.pid + "</PATIENT_ID>" + "<VISIT_ID>" + this.zycs + "</VISIT_ID>" + "<SCHEDULE_ID>" + this.scheduleID + "</SCHEDULE_ID>";
   }
 
   public String getService()
   {
     return "BC.surgery.name";
   }
 
   public String getXMLRoot()
   {
     return "OPERNAMEROOT";
   }
 
   public void parseXML(String xml)
   {
     JAXBContext jc = null;
     try
     {
       jc = JAXBContext.newInstance("cn.medigical.publish.interfaces.his.hisNantong.xml.surgeryname");
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
 
       OPERNAMEROOTType contentType = (OPERNAMEROOTType)customerE.getValue();
 
       ITEMType itemTypeJX = contentType.getITEM();
       this.itemType = itemTypeJX;
     }
     catch (Exception e)
     {
       this.logger.fatal(e.getMessage(), e);
       this.itemType = null;
     }
   }
 
   public ITEMType getItemType() {
     return this.itemType;
   }
 }

