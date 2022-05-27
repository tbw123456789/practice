 package cn.medigical.publish.interfaces.his.hisNantong.cmd;

 import cn.medigical.publish.interfaces.his.hisNantong.xml.user.ITEMType;
 import cn.medigical.publish.interfaces.his.hisNantong.xml.user.USERROOTType;
 import org.apache.log4j.Logger;

 import javax.xml.bind.JAXBContext;
 import javax.xml.bind.JAXBElement;
 import javax.xml.bind.Unmarshaller;
 import java.io.ByteArrayInputStream;
 import java.io.InputStream;
 import java.io.UnsupportedEncodingException;
 import java.util.ArrayList;
 import java.util.List;

 public class CMDgetUser extends AbsXMLSendCmd
 {
   Logger logger = Logger.getLogger("CMDgetUser");
   String deptID = "";
   String userID = "";
   String paramStr = "";
   private List<ITEMType> itemTypeList;
 
   public void setDeptID(String deptID)
   {
     this.deptID = deptID;
     this.paramStr = ("<USER_ID></USER_ID><DEPT_ID>" + deptID + "</DEPT_ID>");
   }
 
   public void setUserID(String userID) {
     this.userID = userID;
     this.paramStr = ("<USER_ID>" + userID + "</USER_ID>");
   }
 
   public String getParam()
   {
     return this.paramStr;
   }
 
   public String getService()
   {
     return "BC.surgery.user";
   }
 
   public String getXMLRoot()
   {
     return "USERROOT";
   }
 
   public void parseXML(String xml)
   {
     JAXBContext jc = null;
     try
     {
       jc = JAXBContext.newInstance("cn.medigical.publish.interfaces.his.hisNantong.xml.user");
       Unmarshaller u = jc.createUnmarshaller();
 
       InputStream payLoadStream = null;
       try
       {
         payLoadStream = new ByteArrayInputStream(xml.getBytes("utf-8"));
       } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
         this.logger.info("UnsupportedEncodingException e");
         return;
       }
 
       if (null == payLoadStream) {
         this.logger.info(" null == payLoadStream");
         return;
       }
 
       JAXBElement customerE = (JAXBElement)u.unmarshal(payLoadStream);
 
       USERROOTType contentType = (USERROOTType)customerE.getValue();
       List list = contentType.getITEM();
       if (null == list) {
         this.logger.info("itemTypeList = null");
         this.itemTypeList = null;
       } else {
         if (null == this.itemTypeList) {
           this.itemTypeList = new ArrayList();
         }
         this.itemTypeList.clear();
         this.itemTypeList.addAll(list);
         this.logger.info(Integer.valueOf(this.itemTypeList.size()));
       }
     }
     catch (Exception e)
     {
       this.logger.fatal(e.getMessage(), e);
       this.itemTypeList = null;
     }
   }
 
   public List<ITEMType> getItemTypeList()
   {
     return this.itemTypeList;
   }
 }

