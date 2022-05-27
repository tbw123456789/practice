 package cn.medigical.publish.interfaces.his.hisNantong.xml.user;

 import javax.xml.bind.annotation.XmlAccessType;
 import javax.xml.bind.annotation.XmlAccessorType;
 import javax.xml.bind.annotation.XmlElement;
 import javax.xml.bind.annotation.XmlType;

 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name="ITEMType", propOrder={"userid", "username", "usersex", "usercode", "userdlm", "userdept", "userjob", "createdate"})
 public class ITEMType
 {
 
   @XmlElement(name="USER_ID", required=true)
   protected String userid;
 
   @XmlElement(name="USER_NAME", required=true)
   protected String username;
 
   @XmlElement(name="USER_SEX", required=true)
   protected String usersex;
 
   @XmlElement(name="USER_CODE", required=true)
   protected String usercode;
 
   @XmlElement(name="USER_DLM", required=true)
   protected String userdlm;
 
   @XmlElement(name="USER_DEPT", required=true)
   protected String userdept;
 
   @XmlElement(name="USER_JOB", required=true)
   protected String userjob;
 
   @XmlElement(name="CREATE_DATE", required=true)
   protected String createdate;
 
   public String getUSERID()
   {
     return this.userid;
   }
 
   public void setUSERID(String value)
   {
     this.userid = value;
   }
 
   public String getUSERNAME()
   {
     return this.username;
   }
 
   public void setUSERNAME(String value)
   {
     this.username = value;
   }
 
   public String getUSERSEX()
   {
     return this.usersex;
   }
 
   public void setUSERSEX(String value)
   {
     this.usersex = value;
   }
 
   public String getUSERCODE()
   {
     return this.usercode;
   }
 
   public void setUSERCODE(String value)
   {
     this.usercode = value;
   }
 
   public String getUSERDLM()
   {
     return this.userdlm;
   }
 
   public void setUSERDLM(String value)
   {
     this.userdlm = value;
   }
 
   public String getUSERDEPT()
   {
     return this.userdept;
   }
 
   public void setUSERDEPT(String value)
   {
     this.userdept = value;
   }
 
   public String getUSERJOB()
   {
     return this.userjob;
   }
 
   public void setUSERJOB(String value)
   {
     this.userjob = value;
   }
 
   public String getCREATEDATE()
   {
     return this.createdate;
   }
 
   public void setCREATEDATE(String value)
   {
     this.createdate = value;
   }
 }

