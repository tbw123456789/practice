 package cn.medigical.publish.pojo.lis.jianyanjgxm;

 import javax.xml.bind.annotation.XmlAccessType;
 import javax.xml.bind.annotation.XmlAccessorType;
 import javax.xml.bind.annotation.XmlElement;
 import javax.xml.bind.annotation.XmlType;

 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name="ITEMType", propOrder={"testNo", "reportItemName", "reportItemCode", "abnormalIndicator", "result", "unit", "resultDateTime", "referenceResult", "reportParmName", "reportParmNameSX", "reportParmCheckNO"})
 public class ITEMType
 {
 
   @XmlElement(name="TestNo", required=true)
   protected String testNo;
 
   @XmlElement(name="ReportItemName", required=true)
   protected String reportItemName;
 
   @XmlElement(name="ReportItemCode", required=true)
   protected String reportItemCode;
 
   @XmlElement(name="AbnormalIndicator", required=true)
   protected String abnormalIndicator;
 
   @XmlElement(name="Result", required=true)
   protected String result;

   @XmlElement(name="Unit", required=true)
   protected String unit;

   @XmlElement(name="ResultDateTime", required=true)
   protected String resultDateTime;

   @XmlElement(name="ReferenceResult", required=true)
   protected String referenceResult;

   @XmlElement(name="ReportParmName", required=true)
   protected String reportParmName;

   @XmlElement(name="ReportParmNameSX", required=true)
   protected String reportParmNameSX;

   @XmlElement(name="ReportParmCheckNO", required=true)
   protected String reportParmCheckNO;

   public String getTestNo() {
     return testNo;
   }

   public void setTestNo(String testNo) {
     this.testNo = testNo;
   }

   public String getReportItemName() {
     return reportItemName;
   }

   public void setReportItemName(String reportItemName) {
     this.reportItemName = reportItemName;
   }

   public String getReportItemCode() {
     return reportItemCode;
   }

   public void setReportItemCode(String reportItemCode) {
     this.reportItemCode = reportItemCode;
   }

   public String getAbnormalIndicator() {
     return abnormalIndicator;
   }

   public void setAbnormalIndicator(String abnormalIndicator) {
     this.abnormalIndicator = abnormalIndicator;
   }

   public String getResult() {
     return result;
   }

   public void setResult(String result) {
     this.result = result;
   }

   public String getUnit() {
     return unit;
   }

   public void setUnit(String unit) {
     this.unit = unit;
   }

   public String getResultDateTime() {
     return resultDateTime;
   }

   public void setResultDateTime(String resultDateTime) {
     this.resultDateTime = resultDateTime;
   }

   public String getReferenceResult() {
     return referenceResult;
   }

   public void setReferenceResult(String referenceResult) {
     this.referenceResult = referenceResult;
   }

   public String getReportParmName() {
     return reportParmName;
   }

   public void setReportParmName(String reportParmName) {
     this.reportParmName = reportParmName;
   }

   public String getReportParmNameSX() {
     return reportParmNameSX;
   }

   public void setReportParmNameSX(String reportParmNameSX) {
     this.reportParmNameSX = reportParmNameSX;
   }

   public String getReportParmCheckNO() {
     return reportParmCheckNO;
   }

   public void setReportParmCheckNO(String reportParmCheckNO) {
     this.reportParmCheckNO = reportParmCheckNO;
   }
 }

