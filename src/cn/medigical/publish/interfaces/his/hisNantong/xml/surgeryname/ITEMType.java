 package cn.medigical.publish.interfaces.his.hisNantong.xml.surgeryname;

 import javax.xml.bind.annotation.XmlAccessType;
 import javax.xml.bind.annotation.XmlAccessorType;
 import javax.xml.bind.annotation.XmlElement;
 import javax.xml.bind.annotation.XmlType;

 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name="ITEMType", propOrder={"admno", "patientid", "visitid", "scheduleid", "operationno", "operation", "operationscale", "operationcode"})
 public class ITEMType
 {
 
   @XmlElement(name="ADM_NO", required=true)
   protected String admno;
 
   @XmlElement(name="PATIENT_ID", required=true)
   protected String patientid;
 
   @XmlElement(name="VISIT_ID", required=true)
   protected String visitid;
 
   @XmlElement(name="SCHEDULE_ID", required=true)
   protected String scheduleid;
 
   @XmlElement(name="OPERATION_NO", required=true)
   protected String operationno;
 
   @XmlElement(name="OPERATION", required=true)
   protected String operation;
 
   @XmlElement(name="OPERATION_SCALE", required=true)
   protected String operationscale;
 
   @XmlElement(name="OPERATION_CODE", required=true)
   protected String operationcode;
 
   public String getADMNO()
   {
     return this.admno;
   }
 
   public void setADMNO(String value)
   {
     this.admno = value;
   }
 
   public String getPATIENTID()
   {
     return this.patientid;
   }
 
   public void setPATIENTID(String value)
   {
     this.patientid = value;
   }
 
   public String getVISITID()
   {
     return this.visitid;
   }
 
   public void setVISITID(String value)
   {
     this.visitid = value;
   }
 
   public String getSCHEDULEID()
   {
     return this.scheduleid;
   }
 
   public void setSCHEDULEID(String value)
   {
     this.scheduleid = value;
   }
 
   public String getOPERATIONNO()
   {
     return this.operationno;
   }
 
   public void setOPERATIONNO(String value)
   {
     this.operationno = value;
   }
 
   public String getOPERATION()
   {
     return this.operation;
   }
 
   public void setOPERATION(String value)
   {
     this.operation = value;
   }
 
   public String getOPERATIONSCALE()
   {
     return this.operationscale;
   }
 
   public void setOPERATIONSCALE(String value)
   {
     this.operationscale = value;
   }
 
   public String getOPERATIONCODE()
   {
     return this.operationcode;
   }
 
   public void setOPERATIONCODE(String value)
   {
     this.operationcode = value;
   }
 }

