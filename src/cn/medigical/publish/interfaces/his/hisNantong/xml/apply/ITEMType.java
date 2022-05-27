 package cn.medigical.publish.interfaces.his.hisNantong.xml.apply;

 import javax.xml.bind.annotation.XmlAccessType;
 import javax.xml.bind.annotation.XmlAccessorType;
 import javax.xml.bind.annotation.XmlElement;
 import javax.xml.bind.annotation.XmlType;

 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name="ITEMType", propOrder={"admno", "patientid", "visitid", "scheduleid", "deptstayed", "bedno", "scheduleddatetime", "operatingroom", "operatingroomno", "sequence", "diagbeforeoperation", "patientcondition", "operationscale", "emergencyindicator", "isolationindicator", "operatingdept", "surgeon", "firstassistant", "secondassistant", "thirdassistant", "fourthassistant", "anesthesiamethod", "anesthesiadoctor", "secondanesthesiadoctor", "thirdanesthesiadoctor", "anesthesiaassistant", "secondanesthesiaassistant", "thirdanesthesiaassistant", "fourthanesthesiaassistant", "bloodtrandoctor", "firstoperationnurse", "secondoperationnurse", "firstsupplynurse", "secondsupplynurse", "thirdsupplynurse", "notesonoperation", "reqdatetime", "enteredby", "status", "allergy", "preoperativeexamination", "diagnosticdescription", "operationpurpose", "operationscheme"})
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
 
   @XmlElement(name="DEPT_STAYED", required=true)
   protected String deptstayed;
 
   @XmlElement(name="BED_NO", required=true)
   protected String bedno;
 
   @XmlElement(name="SCHEDULED_DATE_TIME", required=true)
   protected String scheduleddatetime;
 
   @XmlElement(name="OPERATING_ROOM", required=true)
   protected String operatingroom;
 
   @XmlElement(name="OPERATING_ROOM_NO", required=true)
   protected String operatingroomno;
 
   @XmlElement(name="SEQUENCE", required=true)
   protected String sequence;
 
   @XmlElement(name="DIAG_BEFORE_OPERATION", required=true)
   protected String diagbeforeoperation;
 
   @XmlElement(name="PATIENT_CONDITION", required=true)
   protected String patientcondition;
 
   @XmlElement(name="OPERATION_SCALE", required=true)
   protected String operationscale;
 
   @XmlElement(name="EMERGENCY_INDICATOR", required=true)
   protected String emergencyindicator;
 
   @XmlElement(name="ISOLATION_INDICATOR", required=true)
   protected String isolationindicator;
 
   @XmlElement(name="OPERATING_DEPT", required=true)
   protected String operatingdept;
 
   @XmlElement(name="SURGEON", required=true)
   protected String surgeon;
 
   @XmlElement(name="FIRST_ASSISTANT", required=true)
   protected String firstassistant;
 
   @XmlElement(name="SECOND_ASSISTANT", required=true)
   protected String secondassistant;
 
   @XmlElement(name="THIRD_ASSISTANT", required=true)
   protected String thirdassistant;
 
   @XmlElement(name="FOURTH_ASSISTANT", required=true)
   protected String fourthassistant;
 
   @XmlElement(name="ANESTHESIA_METHOD", required=true)
   protected String anesthesiamethod;
 
   @XmlElement(name="ANESTHESIA_DOCTOR", required=true)
   protected String anesthesiadoctor;
 
   @XmlElement(name="SECOND_ANESTHESIA_DOCTOR", required=true)
   protected String secondanesthesiadoctor;
 
   @XmlElement(name="THIRD_ANESTHESIA_DOCTOR", required=true)
   protected String thirdanesthesiadoctor;
 
   @XmlElement(name="ANESTHESIA_ASSISTANT", required=true)
   protected String anesthesiaassistant;
 
   @XmlElement(name="SECOND_ANESTHESIA_ASSISTANT", required=true)
   protected String secondanesthesiaassistant;
 
   @XmlElement(name="THIRD_ANESTHESIA_ASSISTANT", required=true)
   protected String thirdanesthesiaassistant;
 
   @XmlElement(name="FOURTH_ANESTHESIA_ASSISTANT", required=true)
   protected String fourthanesthesiaassistant;
 
   @XmlElement(name="BLOOD_TRAN_DOCTOR", required=true)
   protected String bloodtrandoctor;
 
   @XmlElement(name="FIRST_OPERATION_NURSE", required=true)
   protected String firstoperationnurse;
 
   @XmlElement(name="SECOND_OPERATION_NURSE", required=true)
   protected String secondoperationnurse;
 
   @XmlElement(name="FIRST_SUPPLY_NURSE", required=true)
   protected String firstsupplynurse;
 
   @XmlElement(name="SECOND_SUPPLY_NURSE", required=true)
   protected String secondsupplynurse;
 
   @XmlElement(name="THIRD_SUPPLY_NURSE", required=true)
   protected String thirdsupplynurse;
 
   @XmlElement(name="NOTES_ON_OPERATION", required=true)
   protected String notesonoperation;
 
   @XmlElement(name="REQ_DATE_TIME", required=true)
   protected String reqdatetime;
 
   @XmlElement(name="ENTERED_BY", required=true)
   protected String enteredby;
 
   @XmlElement(name="STATUS", required=true)
   protected String status;
 
   @XmlElement(name="ALLERGY", required=true)
   protected String allergy;
 
   @XmlElement(name="PREOPERATIVE_EXAMINATION", required=true)
   protected String preoperativeexamination;
 
   @XmlElement(name="DIAGNOSTIC_DESCRIPTION", required=true)
   protected String diagnosticdescription;
 
   @XmlElement(name="OPERATION_PURPOSE", required=true)
   protected String operationpurpose;
 
   @XmlElement(name="OPERATION_SCHEME", required=true)
   protected String operationscheme;
 
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
 
   public String getDEPTSTAYED()
   {
     return this.deptstayed;
   }
 
   public void setDEPTSTAYED(String value)
   {
     this.deptstayed = value;
   }
 
   public String getBEDNO()
   {
     return this.bedno;
   }
 
   public void setBEDNO(String value)
   {
     this.bedno = value;
   }
 
   public String getSCHEDULEDDATETIME()
   {
     return this.scheduleddatetime;
   }
 
   public void setSCHEDULEDDATETIME(String value)
   {
     this.scheduleddatetime = value;
   }
 
   public String getOPERATINGROOM()
   {
     return this.operatingroom;
   }
 
   public void setOPERATINGROOM(String value)
   {
     this.operatingroom = value;
   }
 
   public String getOPERATINGROOMNO()
   {
     return this.operatingroomno;
   }
 
   public void setOPERATINGROOMNO(String value)
   {
     this.operatingroomno = value;
   }
 
   public String getSEQUENCE()
   {
     return this.sequence;
   }
 
   public void setSEQUENCE(String value)
   {
     this.sequence = value;
   }
 
   public String getDIAGBEFOREOPERATION()
   {
     return this.diagbeforeoperation;
   }
 
   public void setDIAGBEFOREOPERATION(String value)
   {
     this.diagbeforeoperation = value;
   }
 
   public String getPATIENTCONDITION()
   {
     return this.patientcondition;
   }
 
   public void setPATIENTCONDITION(String value)
   {
     this.patientcondition = value;
   }
 
   public String getOPERATIONSCALE()
   {
     return this.operationscale;
   }
 
   public void setOPERATIONSCALE(String value)
   {
     this.operationscale = value;
   }
 
   public String getEMERGENCYINDICATOR()
   {
     return this.emergencyindicator;
   }
 
   public void setEMERGENCYINDICATOR(String value)
   {
     this.emergencyindicator = value;
   }
 
   public String getISOLATIONINDICATOR()
   {
     return this.isolationindicator;
   }
 
   public void setISOLATIONINDICATOR(String value)
   {
     this.isolationindicator = value;
   }
 
   public String getOPERATINGDEPT()
   {
     return this.operatingdept;
   }
 
   public void setOPERATINGDEPT(String value)
   {
     this.operatingdept = value;
   }
 
   public String getSURGEON()
   {
     return this.surgeon;
   }
 
   public void setSURGEON(String value)
   {
     this.surgeon = value;
   }
 
   public String getFIRSTASSISTANT()
   {
     return this.firstassistant;
   }
 
   public void setFIRSTASSISTANT(String value)
   {
     this.firstassistant = value;
   }
 
   public String getSECONDASSISTANT()
   {
     return this.secondassistant;
   }
 
   public void setSECONDASSISTANT(String value)
   {
     this.secondassistant = value;
   }
 
   public String getTHIRDASSISTANT()
   {
     return this.thirdassistant;
   }
 
   public void setTHIRDASSISTANT(String value)
   {
     this.thirdassistant = value;
   }
 
   public String getFOURTHASSISTANT()
   {
     return this.fourthassistant;
   }
 
   public void setFOURTHASSISTANT(String value)
   {
     this.fourthassistant = value;
   }
 
   public String getANESTHESIAMETHOD()
   {
     return this.anesthesiamethod;
   }
 
   public void setANESTHESIAMETHOD(String value)
   {
     this.anesthesiamethod = value;
   }
 
   public String getANESTHESIADOCTOR()
   {
     return this.anesthesiadoctor;
   }
 
   public void setANESTHESIADOCTOR(String value)
   {
     this.anesthesiadoctor = value;
   }
 
   public String getSECONDANESTHESIADOCTOR()
   {
     return this.secondanesthesiadoctor;
   }
 
   public void setSECONDANESTHESIADOCTOR(String value)
   {
     this.secondanesthesiadoctor = value;
   }
 
   public String getTHIRDANESTHESIADOCTOR()
   {
     return this.thirdanesthesiadoctor;
   }
 
   public void setTHIRDANESTHESIADOCTOR(String value)
   {
     this.thirdanesthesiadoctor = value;
   }
 
   public String getANESTHESIAASSISTANT()
   {
     return this.anesthesiaassistant;
   }
 
   public void setANESTHESIAASSISTANT(String value)
   {
     this.anesthesiaassistant = value;
   }
 
   public String getSECONDANESTHESIAASSISTANT()
   {
     return this.secondanesthesiaassistant;
   }
 
   public void setSECONDANESTHESIAASSISTANT(String value)
   {
     this.secondanesthesiaassistant = value;
   }
 
   public String getTHIRDANESTHESIAASSISTANT()
   {
     return this.thirdanesthesiaassistant;
   }
 
   public void setTHIRDANESTHESIAASSISTANT(String value)
   {
     this.thirdanesthesiaassistant = value;
   }
 
   public String getFOURTHANESTHESIAASSISTANT()
   {
     return this.fourthanesthesiaassistant;
   }
 
   public void setFOURTHANESTHESIAASSISTANT(String value)
   {
     this.fourthanesthesiaassistant = value;
   }
 
   public String getBLOODTRANDOCTOR()
   {
     return this.bloodtrandoctor;
   }
 
   public void setBLOODTRANDOCTOR(String value)
   {
     this.bloodtrandoctor = value;
   }
 
   public String getFIRSTOPERATIONNURSE()
   {
     return this.firstoperationnurse;
   }
 
   public void setFIRSTOPERATIONNURSE(String value)
   {
     this.firstoperationnurse = value;
   }
 
   public String getSECONDOPERATIONNURSE()
   {
     return this.secondoperationnurse;
   }
 
   public void setSECONDOPERATIONNURSE(String value)
   {
     this.secondoperationnurse = value;
   }
 
   public String getFIRSTSUPPLYNURSE()
   {
     return this.firstsupplynurse;
   }
 
   public void setFIRSTSUPPLYNURSE(String value)
   {
     this.firstsupplynurse = value;
   }
 
   public String getSECONDSUPPLYNURSE()
   {
     return this.secondsupplynurse;
   }
 
   public void setSECONDSUPPLYNURSE(String value)
   {
     this.secondsupplynurse = value;
   }
 
   public String getTHIRDSUPPLYNURSE()
   {
     return this.thirdsupplynurse;
   }
 
   public void setTHIRDSUPPLYNURSE(String value)
   {
     this.thirdsupplynurse = value;
   }
 
   public String getNOTESONOPERATION()
   {
     return this.notesonoperation;
   }
 
   public void setNOTESONOPERATION(String value)
   {
     this.notesonoperation = value;
   }
 
   public String getREQDATETIME()
   {
     return this.reqdatetime;
   }
 
   public void setREQDATETIME(String value)
   {
     this.reqdatetime = value;
   }
 
   public String getENTEREDBY()
   {
     return this.enteredby;
   }
 
   public void setENTEREDBY(String value)
   {
     this.enteredby = value;
   }
 
   public String getSTATUS()
   {
     return this.status;
   }
 
   public void setSTATUS(String value)
   {
     this.status = value;
   }
 
   public String getALLERGY()
   {
     return this.allergy;
   }
 
   public void setALLERGY(String value)
   {
     this.allergy = value;
   }
 
   public String getPREOPERATIVEEXAMINATION()
   {
     return this.preoperativeexamination;
   }
 
   public void setPREOPERATIVEEXAMINATION(String value)
   {
     this.preoperativeexamination = value;
   }
 
   public String getDIAGNOSTICDESCRIPTION()
   {
     return this.diagnosticdescription;
   }
 
   public void setDIAGNOSTICDESCRIPTION(String value)
   {
     this.diagnosticdescription = value;
   }
 
   public String getOPERATIONPURPOSE()
   {
     return this.operationpurpose;
   }
 
   public void setOPERATIONPURPOSE(String value)
   {
     this.operationpurpose = value;
   }
 
   public String getOPERATIONSCHEME()
   {
     return this.operationscheme;
   }
 
   public void setOPERATIONSCHEME(String value)
   {
     this.operationscheme = value;
   }
 }

