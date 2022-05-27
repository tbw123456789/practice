 package cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm;

 import javax.xml.bind.annotation.XmlAccessType;
 import javax.xml.bind.annotation.XmlAccessorType;
 import javax.xml.bind.annotation.XmlElement;
 import javax.xml.bind.annotation.XmlType;

 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name="ITEMType", propOrder={"bzh", "reportid", "authtime", "specid", "specname"})
 public class ITEMType
 {
 
   @XmlElement(name="BZH", required=true)
   protected String bzh;
 
   @XmlElement(name="REPORTID", required=true)
   protected String reportid;
 
   @XmlElement(name="AUTHTIME", required=true)
   protected String authtime;
 
   @XmlElement(name="SPECID", required=true)
   protected String specid;
 
   @XmlElement(name="SPECNAME", required=true)
   protected String specname;
 
   public String getBZH()
   {
     return this.bzh;
   }
 
   public void setBZH(String value)
   {
     this.bzh = value;
   }
 
   public String getREPORTID()
   {
     return this.reportid;
   }
 
   public void setREPORTID(String value)
   {
     this.reportid = value;
   }
 
   public String getAUTHTIME()
   {
     return this.authtime;
   }
 
   public void setAUTHTIME(String value)
   {
     this.authtime = value;
   }
 
   public String getSPECID()
   {
     return this.specid;
   }
 
   public void setSPECID(String value)
   {
     this.specid = value;
   }
 
   public String getSPECNAME()
   {
     return this.specname;
   }
 
   public void setSPECNAME(String value)
   {
     this.specname = value;
   }
 }

