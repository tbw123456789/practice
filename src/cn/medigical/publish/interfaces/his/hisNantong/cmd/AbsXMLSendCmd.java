 package cn.medigical.publish.interfaces.his.hisNantong.cmd;

 import org.apache.commons.codec.binary.Base64;

 import javax.crypto.Cipher;
 import javax.crypto.spec.SecretKeySpec;

 public abstract class AbsXMLSendCmd
 {
   static String token = "7E275AFD1B89B6D177BE5FAB33F43ABC";
 
   static String key = "3B24C8590C94FE79";
 
   public abstract String getParam();
 
   public abstract String getService();
 
   public abstract String getXMLRoot();
 
   public abstract void parseXML(String paramString);
 
   public String generateXML() throws Exception { String xml = "<ROOT>\n<TOKEN><![CDATA[" + 
       encrypt(token) + 
       "]]></TOKEN>\n" + "<SERVICE><![CDATA[" + 
       getService() + "]]></SERVICE>\n" + "<DATAPARAM>\n" + "<![CDATA[" + 
       encrypt(getParam()) + "]]>\n" + "</DATAPARAM>\n" + "</ROOT>";
 
     return xml; }
 
   public void setKey(String key)
   {
     key = key;
   }
 
   public void setToken(String token) {
     token = token;
   }
 
   public static String encrypt(String sSrc) throws Exception
   {
     byte[] raw = key.getBytes("utf-8");
     SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
     Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
     cipher.init(1, skeySpec);
     byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
 
     return new Base64().encodeToString(encrypted);
   }
 }

