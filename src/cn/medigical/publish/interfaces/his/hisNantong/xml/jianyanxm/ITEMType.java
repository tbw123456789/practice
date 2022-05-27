 package cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm;

 import javax.xml.bind.annotation.XmlAccessType;
 import javax.xml.bind.annotation.XmlAccessorType;
 import javax.xml.bind.annotation.XmlElement;
 import javax.xml.bind.annotation.XmlType;

 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name="ITEMType", propOrder={"testno", "reportitemname", "reportitemcode", "abnormalindicator", "result", "units", "resultdatetime", "referenceresult"})
 public class ITEMType
 {
 
   @XmlElement(name="TEST_NO", required=true)
   protected String testno;
 
   @XmlElement(name="REPORT_ITEM_NAME", required=true)
   protected String reportitemname;
 
   @XmlElement(name="REPORT_ITEM_CODE", required=true)
   protected String reportitemcode;
 
   @XmlElement(name="ABNORMAL_INDICATOR", required=true)
   protected String abnormalindicator;
 
   @XmlElement(name="RESULT", required=true)
   protected String result;
 
   @XmlElement(name="UNITS", required=true)
   protected String units;
 
   @XmlElement(name="RESULT_DATE_TIME", required=true)
   protected String resultdatetime;
 
   @XmlElement(name="REFERENCE_RESULT", required=true)
   protected String referenceresult;
 
   public String getTESTNO()
   {
     return this.testno;
   }
 
   public void setTESTNO(String value)
   {
     this.testno = value;
   }
 
   public String getREPORTITEMNAME()
   {
     return this.reportitemname;
   }
 
   public void setREPORTITEMNAME(String value)
   {
     this.reportitemname = value;
   }
 
   public String getREPORTITEMCODE()
   {
     return this.reportitemcode;
   }
 
   public void setREPORTITEMCODE(String value)
   {
     this.reportitemcode = value;
   }
 
   public String getABNORMALINDICATOR()
   {
     return this.abnormalindicator;
   }
 
   public void setABNORMALINDICATOR(String value)
   {
     this.abnormalindicator = value;
   }
 
   public String getRESULT()
   {
     return this.result;
   }
 
   public void setRESULT(String value)
   {
     this.result = value;
   }
 
   public String getUNITS()
   {
     return this.units;
   }
 
   public void setUNITS(String value)
   {
     this.units = value;
   }
 
   public String getRESULTDATETIME()
   {
     return this.resultdatetime;
   }
 
   public void setRESULTDATETIME(String value)
   {
     this.resultdatetime = value;
   }
 
   public String getREFERENCERESULT()
   {
     return this.referenceresult;
   }
 
   public void setREFERENCERESULT(String value)
   {
     this.referenceresult = value;
   }
 }

