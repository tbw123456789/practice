 package cn.medigical.publish.pojo.lis.jianyanxm;

 import javax.xml.bind.annotation.XmlAccessType;
 import javax.xml.bind.annotation.XmlAccessorType;
 import javax.xml.bind.annotation.XmlElement;
 import javax.xml.bind.annotation.XmlType;

 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name="ITEMType", propOrder={"testNo", "priorityIndicator", "patientId", "visitId", "name", "workingId", "testCause", "relevantClinicDiag", "specimen", "spcmReceivedDateTime", "orderingDept", "orderingProvider", "performedBy", "resultStatus", "resultsRptDateTime", "transcriptionist", "verifiedBy"})
 public class ITEMType
 {
 
   @XmlElement(name="TestNo", required=true)
   protected String testNo;
 
   @XmlElement(name="priorityIndicator", required=true)
   protected String priorityIndicator;
 
   @XmlElement(name="PatientId", required=true)
   protected String patientId;
 
   @XmlElement(name="VisitId", required=true)
   protected String visitId;
 
   @XmlElement(name="Name", required=true)
   protected String name;
 
   @XmlElement(name="WorkingId", required=true)
   protected String workingId;
 
   @XmlElement(name="TestCause", required=true)
   protected String testCause;
 
   @XmlElement(name="RelevantClinicDiag", required=true)
   protected String relevantClinicDiag;

   @XmlElement(name="Specimen", required=true)
   protected String specimen;

   @XmlElement(name="SpcmReceivedDateTime", required=true)
   protected String spcmReceivedDateTime;

   @XmlElement(name="OrderingDept", required=true)
   protected String orderingDept;

   @XmlElement(name="orderingProvider", required=true)
   protected String orderingProvider;

   @XmlElement(name="PerformedBy", required=true)
   protected String performedBy;

   @XmlElement(name="ResultStatus", required=true)
   protected String resultStatus;

   @XmlElement(name="ResultsRptDateTime", required=true)
   protected String resultsRptDateTime;

   @XmlElement(name="transcriptionist", required=true)
   protected String transcriptionist;

   @XmlElement(name="VerifiedBy", required=true)
   protected String verifiedBy;


   public String getTestNo() {
     return testNo;
   }

   public void setTestNo(String testNo) {
     this.testNo = testNo;
   }

   public String getPriorityIndicator() {
     return priorityIndicator;
   }

   public void setPriorityIndicator(String priorityIndicator) {
     this.priorityIndicator = priorityIndicator;
   }

   public String getPatientId() {
     return patientId;
   }

   public void setPatientId(String patientId) {
     this.patientId = patientId;
   }

   public String getVisitId() {
     return visitId;
   }

   public void setVisitId(String visitId) {
     this.visitId = visitId;
   }

   public String getName() {
     return name;
   }

   public void setName(String name) {
     this.name = name;
   }

   public String getWorkingId() {
     return workingId;
   }

   public void setWorkingId(String workingId) {
     this.workingId = workingId;
   }

   public String getTestCause() {
     return testCause;
   }

   public void setTestCause(String testCause) {
     this.testCause = testCause;
   }

   public String getRelevantClinicDiag() {
     return relevantClinicDiag;
   }

   public void setRelevantClinicDiag(String relevantClinicDiag) {
     this.relevantClinicDiag = relevantClinicDiag;
   }

   public String getSpecimen() {
     return specimen;
   }

   public void setSpecimen(String specimen) {
     this.specimen = specimen;
   }

   public String getSpcmReceivedDateTime() {
     return spcmReceivedDateTime;
   }

   public void setSpcmReceivedDateTime(String spcmReceivedDateTime) {
     this.spcmReceivedDateTime = spcmReceivedDateTime;
   }

   public String getOrderingDept() {
     return orderingDept;
   }

   public void setOrderingDept(String orderingDept) {
     this.orderingDept = orderingDept;
   }

   public String getOrderingProvider() {
     return orderingProvider;
   }

   public void setOrderingProvider(String orderingProvider) {
     this.orderingProvider = orderingProvider;
   }

   public String getPerformedBy() {
     return performedBy;
   }

   public void setPerformedBy(String performedBy) {
     this.performedBy = performedBy;
   }

   public String getResultStatus() {
     return resultStatus;
   }

   public void setResultStatus(String resultStatus) {
     this.resultStatus = resultStatus;
   }

   public String getResultsRptDateTime() {
     return resultsRptDateTime;
   }

   public void setResultsRptDateTime(String resultsRptDateTime) {
     this.resultsRptDateTime = resultsRptDateTime;
   }

   public String getTranscriptionist() {
     return transcriptionist;
   }

   public void setTranscriptionist(String transcriptionist) {
     this.transcriptionist = transcriptionist;
   }

   public String getVerifiedBy() {
     return verifiedBy;
   }

   public void setVerifiedBy(String verifiedBy) {
     this.verifiedBy = verifiedBy;
   }
 }

