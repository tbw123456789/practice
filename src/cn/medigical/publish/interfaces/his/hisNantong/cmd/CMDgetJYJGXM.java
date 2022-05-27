 package cn.medigical.publish.interfaces.his.hisNantong.cmd;

 import cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.ITEMType;
 import cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.JYJGXMROOTType;
 import org.apache.log4j.Logger;

 import javax.xml.bind.JAXBContext;
 import javax.xml.bind.JAXBElement;
 import javax.xml.bind.Unmarshaller;
 import java.io.ByteArrayInputStream;
 import java.io.InputStream;
 import java.io.UnsupportedEncodingException;
 import java.util.ArrayList;
 import java.util.List;

 public class CMDgetJYJGXM extends AbsXMLSendCmd
 {
   Logger logger = Logger.getLogger("CMDgetJYJGXM");
   String pid = "";
   String zycs = "";
   String cxlx = "";
   String zyh = "";
   private List<ITEMType> itemTypeList;
 
   public void setZyh(String zyh)
   {
     this.zyh = zyh;
   }
 
   public void setCxlx(String cxlx) {
     this.cxlx = cxlx;
   }
 
   public void setPid(String pid) {
     this.pid = pid;
   }
 
   public void setZycs(String zycs) {
     this.zycs = zycs;
   }
 
   public String getParam()
   {
     if (this.cxlx.equals("")) {
       return "<ADM_NO></ADM_NO><PATIENT_ID>" + this.pid + "</PATIENT_ID>" + "<VISIT_ID>" + this.zycs + "</VISIT_ID>";
     }
     if (this.cxlx.equals("1")) {
       this.logger.info("检验请求XML ================= <PATIENT_ID>" + this.pid + "</PATIENT_ID>" + "<VISIT_ID>" + this.zycs + "</VISIT_ID>");
       return "<CXLX>1</CXLX><PATIENT_ID>" + this.pid + "</PATIENT_ID>" + "<VISIT_ID>" + this.zycs + "</VISIT_ID>";
     }if (this.cxlx.equals("2")) {
       this.logger.info("检验请求XML ================= <CXLX>2</CXLX><ADM_NO>" + this.zyh + "</ADM_NO>");
       return "<CXLX>2</CXLX><ADM_NO>" + this.zyh + "</ADM_NO>";
     }
     return "";
   }
 
   public String getService()
   {
     return "BC.lab.master";
   }
 
   public String getXMLRoot()
   {
     return "JYJGXMROOT";
   }
 
   public void parseXML(String xml)
   {
     JAXBContext jc = null;
     try
     {
       jc = JAXBContext.newInstance("cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm");
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
 
       JYJGXMROOTType contentType = (JYJGXMROOTType)customerE.getValue();
 
       List list = contentType.getITEM();
       if (null == list) {
         this.itemTypeList = null;
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
       this.itemTypeList = null;
     }
   }
 
   public List<ITEMType> getItemTypeList() {
     return this.itemTypeList;
   }
 }

