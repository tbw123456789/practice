 package cn.medigical.publish.interfaces.his.hisNantong.cmd;

 import cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType;
 import cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.JYXMROOTType;
 import org.apache.log4j.Logger;

 import javax.xml.bind.JAXBContext;
 import javax.xml.bind.JAXBElement;
 import javax.xml.bind.Unmarshaller;
 import java.io.ByteArrayInputStream;
 import java.io.InputStream;
 import java.io.UnsupportedEncodingException;
 import java.util.ArrayList;
 import java.util.List;

 public class CMDgetJYXM extends AbsXMLSendCmd
 {
   Logger logger = Logger.getLogger("CMDgetJYXM");
   String testID = "";
   private List<ITEMType> itemTypeList;
 
   public void setTestID(String testID)
   {
     this.testID = testID;
   }
 
   public String getParam()
   {
     return "<TEST_NO>" + this.testID + "</TEST_NO>";
   }
 
   public String getService()
   {
     return "BC.lab.result";
   }
 
   public String getXMLRoot()
   {
     return "JYXMROOT";
   }
 
   public void parseXML(String xml)
   {
     JAXBContext jc = null;
     try
     {
       jc = JAXBContext.newInstance("cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm");
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
 
       JYXMROOTType contentType = (JYXMROOTType)customerE.getValue();
 
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

