 package cn.medigical.publish.interfaces.his.hisNantong.stub;

 import cn.medigical.publish.interfaces.his.hisNantong.cmd.AbsXMLSendCmd;
 import org.apache.axis2.AxisFault;
 import org.apache.commons.codec.binary.Base64;
 import org.apache.log4j.Logger;

 import javax.crypto.Cipher;
 import javax.crypto.spec.SecretKeySpec;
 import javax.xml.bind.JAXBContext;
 import javax.xml.bind.JAXBElement;
 import javax.xml.bind.Unmarshaller;
 import java.io.ByteArrayInputStream;
 import java.io.InputStream;
 import java.io.UnsupportedEncodingException;

 public class SendCmdSvr
 {
   ZL_InformationServiceStub.Public serverPort;
   ZL_InformationServiceStub serviceStub = null;
   Logger logger = Logger.getLogger("SendCmdSvr");
 
   private static String webServiceAddress = "http://192.168.35.13:8088/ExternalServices/ZL_InformationService.asmx";
   private static String token = "7E275AFD1B89B6D177BE5FAB33F43ABC";
   private static String key = "3B24C8590C94FE79";
   static final String xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
   static String msg = "<ROOT>\n<TOKEN><![CDATA[PDjksv6qTc59JB+FSk3t+zy8VV+87t+SRgZswTfQeHf9HGZXbWa0MXKgf0UWXJ6E]]></TOKEN>\n<SERVICE><![CDATA[Basic.MCTest.Query]]></SERVICE>\n<DATAPARAM>\n<![CDATA[/RxmV21mtDFyoH9FFlyehA==]]>\n</DATAPARAM>\n</ROOT>";
 
   static String msg2 = "<ROOT>\n<TOKEN><![CDATA[PDjksv6qTc59JB+FSk3t+zy8VV+87t+SRgZswTfQeHf9HGZXbWa0MXKgf0UWXJ6E]]></TOKEN>\n<SERVICE><![CDATA[BC.surgery.dept]]></SERVICE>\n<DATAPARAM>\n<![CDATA[/RxmV21mtDFyoH9FFlyehA==]]>\n</DATAPARAM>\n</ROOT>";
 
   static String msgUserFuchan = "<ROOT>\n<TOKEN><![CDATA[PDjksv6qTc59JB+FSk3t+zy8VV+87t+SRgZswTfQeHf9HGZXbWa0MXKgf0UWXJ6E]]></TOKEN>\n<SERVICE><![CDATA[BC.surgery.user]]></SERVICE>\n<DATAPARAM>\n<![CDATA[hzNUruElp2CTgCfXw1ctZUoGNw6hgkldizUhgg907nKnWSxmk1APw0geu1wQk3gy]]>\n</DATAPARAM>\n</ROOT>";
 
   static String msgUserMazui = "<ROOT>\n<TOKEN><![CDATA[PDjksv6qTc59JB+FSk3t+zy8VV+87t+SRgZswTfQeHf9HGZXbWa0MXKgf0UWXJ6E]]></TOKEN>\n<SERVICE><![CDATA[BC.surgery.user]]></SERVICE>\n<DATAPARAM>\n<![CDATA[hzNUruElp2CTgCfXw1ctZS9n0XNmS9vFLT0p94+8mQ5hgZlwrzrHsX+rRbeI0LZx]]>\n</DATAPARAM>\n</ROOT>";
 
   public SendCmdSvr()
   {
   }
 
   public SendCmdSvr(String webServiceAddress, String token, String key)
   {
     webServiceAddress = webServiceAddress;
     token = token;
     key = key;
   }
 
   public boolean initial() {
     this.serverPort = new ZL_InformationServiceStub.Public();
     try {
       this.serviceStub = new ZL_InformationServiceStub(webServiceAddress);
     } catch (AxisFault axisFault) {
       this.logger.fatal(axisFault.getMessage(), axisFault);
       return false;
     }
 
     return true;
   }
 
   public void sendCmd(AbsXMLSendCmd sendCmd) throws Exception {
     long start = System.currentTimeMillis();
 
     sendCmd.setToken(token);
     sendCmd.setKey(key);
     String sxml = sendCmd.generateXML();
     this.logger.info("send msg --> " + sxml);
 
     this.serverPort.setReData(sxml);
 
     String element = this.serviceStub.publicm(this.serverPort);
     this.logger.info("Got it -----> " + element);
     int indexErr = element.indexOf("<ERROR>");
     int indexParam = element.indexOf("<DATAPARAM>");
     int indexParamEnd = element.indexOf("</DATAPARAM>");
     int indexState = element.indexOf("<STATE>T</STATE>");
 
     if (indexErr >= 0)
       parseError(element);
     else if ((indexParam >= 0) && (indexParamEnd > indexParam) && (indexState >= 0))
       try {
         start = System.currentTimeMillis();
         String xml = getParam(element);
         String xml2 = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><" + sendCmd.getXMLRoot() + ">" + xml + "</" + sendCmd.getXMLRoot() + ">";
         start = System.currentTimeMillis();
         sendCmd.parseXML(xml2);
       }
       catch (Exception e) {
         this.logger.fatal(e.getMessage(), e);
       }
   }
 
   private void parseError(String element)
   {
     JAXBContext jc = null;
     try {
       jc = JAXBContext.newInstance("cn.medigical.publish.interfaces.his.hisNantong.xml.error");
       Unmarshaller u = jc.createUnmarshaller();
 
       InputStream payLoadStream = null;
       try
       {
         payLoadStream = new ByteArrayInputStream(element.getBytes("utf-8"));
       } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
         return;
       }
 
       if (null == payLoadStream) {
         return;
       }
 
       JAXBElement customerE = (JAXBElement)u.unmarshal(payLoadStream);

       cn.medigical.publish.interfaces.his.hisNantong.xml.error.ROOTType rootType = (cn.medigical.publish.interfaces.his.hisNantong.xml.error.ROOTType)customerE.getValue();
       this.logger.info("State : " + rootType.getSTATE());
       this.logger.info("getERRCODE : " + rootType.getERROR().getERRCODE());
     }
     catch (Exception e)
     {
       this.logger.fatal(e.getMessage(), e);
     }
   }
 
   private String getParam(String element) {
     JAXBContext jc = null;
     String xml = null;
     try {
       jc = JAXBContext.newInstance("cn.medigical.publish.interfaces.his.hisNantong.xml.param");
       Unmarshaller u = jc.createUnmarshaller();
 
       InputStream payLoadStream = null;
       try
       {
         payLoadStream = new ByteArrayInputStream(element.getBytes("utf-8"));
       } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
         return null;
       }
 
       if (null == payLoadStream) {
         return null;
       }
 
       JAXBElement customerE = (JAXBElement)u.unmarshal(payLoadStream);

       cn.medigical.publish.interfaces.his.hisNantong.xml.param.ROOTType rootType = (cn.medigical.publish.interfaces.his.hisNantong.xml.param.ROOTType)customerE.getValue();
       this.logger.info("State : " + rootType.getSTATE());
       String ss = rootType.getDATAPARAM();
       xml = decrypt(ss, key);
     }
     catch (Exception e) {
       this.logger.fatal(e.getMessage(), e);
     }
 
     return xml;
   }
 
   public String decrypt(String sSrc, String sKey) throws Exception
   {
     try {
       if (sKey == null) {
         System.out.print("Key为空null");
         return null;
       }
 
       if (sKey.length() != 16) {
         System.out.print("Key长度不是16位");
         return null;
       }
       byte[] raw = sKey.getBytes("utf-8");
       SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
       Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
       cipher.init(2, skeySpec);
       byte[] encrypted1 = new Base64().decode(sSrc);
       try {
         byte[] original = cipher.doFinal(encrypted1);
         String originalString = new String(original, "utf-8");
         return originalString;
       } catch (Exception e) {
         System.out.println(e.toString());
         return null;
       }
     } catch (Exception ex) {
       System.out.println(ex.toString());
     }return null;
   }
 }

