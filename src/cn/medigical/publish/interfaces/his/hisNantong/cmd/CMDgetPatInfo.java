 package cn.medigical.publish.interfaces.his.hisNantong.cmd;

 import cn.medigical.publish.interfaces.his.hisNantong.xml.patinfo.ITEMType;
 import cn.medigical.publish.interfaces.his.hisNantong.xml.patinfo.PATINFOROOTType;
 import org.apache.log4j.Logger;

 import javax.xml.bind.JAXBContext;
 import javax.xml.bind.JAXBElement;
 import javax.xml.bind.Unmarshaller;
 import java.io.ByteArrayInputStream;
 import java.io.InputStream;
 import java.io.UnsupportedEncodingException;

 public class CMDgetPatInfo extends AbsXMLSendCmd
 {
   Logger logger = Logger.getLogger("CMDgetPatInfo");
   String patID = "";
   String visitID = "";
   String zyh = "";
   String cxlx = "";
   private ITEMType itemType;
 
   public void setPatID(String patID)
   {
     this.patID = patID;
   }
 
   public void setVisitID(String visitID) {
     this.visitID = visitID;
   }
 
   public void setZyh(String zyh) {
     this.zyh = zyh;
   }
 
   public void setCxlx(String cxlx) {
     this.cxlx = cxlx;
   }
 
   public String getParam()
   {
     if (this.cxlx.equals("")) {
       this.logger.info("请求XML =================== <ADM_NO></ADM_NO><PATIENT_ID>" + this.patID + "</PATIENT_ID>" + "<VISIT_ID>" + this.visitID + "</VISIT_ID>");
       return "<ADM_NO></ADM_NO><PATIENT_ID>" + this.patID + "</PATIENT_ID>" + "<VISIT_ID>" + this.visitID + "</VISIT_ID>";
     }
     if (this.cxlx.equals("1")) {
       this.logger.info("请求XML =================== <CXLX>1</CXLX><PATIENT_ID>" + this.patID + "</PATIENT_ID>" + "<VISIT_ID>" + this.visitID + "</VISIT_ID>");
       return "<CXLX>1</CXLX><PATIENT_ID>" + this.patID + "</PATIENT_ID>" + "<VISIT_ID>" + this.visitID + "</VISIT_ID>";
     }if (this.cxlx.equals("2")) {
       this.logger.info("请求XML =================== <CXLX>2</CXLX><ADM_NO>" + this.zyh + "</ADM_NO>");
       return "<CXLX>2</CXLX><ADM_NO>" + this.zyh + "</ADM_NO>";
     }
     return "";
   }
 
   public String getService()
   {
     return "BC.surgery.into";
   }
 
   public String getXMLRoot()
   {
     return "PATINFOROOT";
   }
 
   public void parseXML(String xml)
   {
     JAXBContext jc = null;
     try
     {
       jc = JAXBContext.newInstance("cn.medigical.publish.interfaces.his.hisNantong.xml.patinfo");
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
 
       PATINFOROOTType contentType = (PATINFOROOTType)customerE.getValue();
 
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

