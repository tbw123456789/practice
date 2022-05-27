 package cn.medigical.publish.interfaces.his.hisTianshui.xml.operApplyName;

 import javax.xml.bind.annotation.XmlAccessType;
 import javax.xml.bind.annotation.XmlAccessorType;
 import javax.xml.bind.annotation.XmlElement;
 import javax.xml.bind.annotation.XmlType;

 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name="ITEMType", propOrder={"patientId", "visitId", "scheduleId", "operationNO", "operation", "operationScale", "operationCode"})
 public class ITEMType
 {
 
   @XmlElement(name="PatientId", required=true)
   protected String patientId;
 
   @XmlElement(name="VisitId", required=true)
   protected String visitId;
 
   @XmlElement(name="ScheduleId", required=true)
   protected String scheduleId;
 
   @XmlElement(name="OperationNO", required=true)
   protected String operationNO;
 
   @XmlElement(name="Operation", required=true)
   protected String operation;
 
   @XmlElement(name="OperationScale", required=true)
   protected String operationScale;
 
   @XmlElement(name="OperationCode", required=true)
   protected String operationCode;
 
   public String getPatientId()
   {
     return this.patientId;
   }
 
   public void setPatientId(String patientId) {
     this.patientId = patientId;
   }
 
   public String getVisitId() {
     return this.visitId;
   }
 
   public void setVisitId(String visitId) {
     this.visitId = visitId;
   }
 
   public String getScheduleId() {
     return this.scheduleId;
   }
 
   public void setScheduleId(String scheduleId) {
     this.scheduleId = scheduleId;
   }
 
   public String getOperationNO() {
     return this.operationNO;
   }
 
   public void setOperationNO(String operationNO) {
     this.operationNO = operationNO;
   }
 
   public String getOperation() {
     return this.operation;
   }
 
   public void setOperation(String operation) {
     this.operation = operation;
   }
 
   public String getOperationScale() {
     return this.operationScale;
   }
 
   public void setOperationScale(String operationScale) {
     this.operationScale = operationScale;
   }
 
   public String getOperationCode() {
     return this.operationCode;
   }
 
   public void setOperationCode(String operationCode) {
     this.operationCode = operationCode;
   }
 }

