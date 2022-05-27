package cn.medigical.publish.interfaces.his.hisTianshui.xml.apply;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name="ITEMType", propOrder={"brxm","patientId", "visitId", "scheduleId", "deptStayed", "bedNO", "scheduledDateTime", "operatingRoom", "operatingRoomNo", "sequence", "diagBeforeOperation", "patientCondition", "operationScale", "emergencyIndicator", "isolationIndicator", "operatingDept", "surgeon", "zhuDaoName", "firstAssistant", "yiZhuName", "secondAssistant", "erZhuName", "thirdAssistant", "sanZhuName", "fourthAssistant", "siZhuAsName", "anesthesiaMethod", "anesthesiaDoctor", "maZuiName", "secondAnesthesiaDoctor", "erMaZuiName", "thirdAnesthesiaDoctor", "sanMaZuiName", "anesthesiaAssistant", "yiMaZhuName", "secondAnesthesiaAssistant", "erMaZhuName", "thirdAnesthesiaAssistant", "sanMaZhuName", "fourthAnesthesiaAssistant", "siMaZhuName", "bloodTranDoctor", "shuXueYiShengName", "firstOperationNurse", "firstHuShiName", "secondOperationNurse", "erTaiHuShiName", "firstSupplyNurse", "firstGongYingName", "secondSupplyNurse", "erGongYingHuShiName", "thirdSupplyNurse", "sanGongYingHuShi", "notesOnOperation", "reqDateTime", "enteredBy", "enteredByName", "operStatus","chuanRanBing","beiZhuXinXi","keshiName","deptName","shoushujb"})
public class ITEMType
{



  @XmlElement(name="PatientId", required=true)
  protected String patientId;

  @XmlElement(name="VisitId", required=true)
  protected String visitId;

  @XmlElement(name="ScheduleId", required=true)
  protected String scheduleId;

  @XmlElement(name="DeptStayed", required=true)
  protected String deptStayed;

  @XmlElement(name="BedNO", required=true)
  protected String bedNO;

  @XmlElement(name="ScheduledDateTime", required=true)
  protected String scheduledDateTime;

  @XmlElement(name="OperatingRoom", required=true)
  protected String operatingRoom;

  @XmlElement(name="OperatingRoomNo", required=true)
  protected String operatingRoomNo;

  @XmlElement(name="Sequence", required=true)
  protected String sequence;

  @XmlElement(name="DiagBeforeOperation", required=true)
  protected String diagBeforeOperation;

  @XmlElement(name="PatientCondition", required=true)
  protected String patientCondition;

  @XmlElement(name="OperationScale", required=true)
  protected String operationScale;

  @XmlElement(name="EmergencyIndicator", required=true)
  protected String emergencyIndicator;

  @XmlElement(name="IsolationIndicator", required=true)
  protected String isolationIndicator;

  @XmlElement(name="OperatingDept", required=true)
  protected String operatingDept;

  @XmlElement(name="Surgeon", required=true)
  protected String surgeon;

  @XmlElement(name="ZhuDaoName", required=true)
  protected String zhuDaoName;

  @XmlElement(name="FirstAssistant", required=true)
  protected String firstAssistant;

  @XmlElement(name="YiZhuName", required=true)
  protected String yiZhuName;

  @XmlElement(name="SecondAssistant", required=true)
  protected String secondAssistant;

  @XmlElement(name="ErZhuName", required=true)
  protected String erZhuName;

  @XmlElement(name="ThirdAssistant", required=true)
  protected String thirdAssistant;

  @XmlElement(name="SanZhuName", required=true)
  protected String sanZhuName;

  @XmlElement(name="FourthAssistant", required=true)
  protected String fourthAssistant;

  @XmlElement(name="SiZhuAsName", required=true)
  protected String siZhuAsName;

  @XmlElement(name="AnesthesiaMethod", required=true)
  protected String anesthesiaMethod;

  @XmlElement(name="AnesthesiaDoctor", required=true)
  protected String anesthesiaDoctor;

  @XmlElement(name="MaZuiName", required=true)
  protected String maZuiName;

  @XmlElement(name="SecondAnesthesiaDoctor", required=true)
  protected String secondAnesthesiaDoctor;

  @XmlElement(name="ErMaZuiName", required=true)
  protected String erMaZuiName;

  @XmlElement(name="ThirdAnesthesiaDoctor", required=true)
  protected String thirdAnesthesiaDoctor;

  @XmlElement(name="SanMaZuiName", required=true)
  protected String sanMaZuiName;

  @XmlElement(name="AnesthesiaAssistant", required=true)
  protected String anesthesiaAssistant;

  @XmlElement(name="YiMaZhuName", required=true)
  protected String yiMaZhuName;

  @XmlElement(name="SecondAnesthesiaAssistant", required=true)
  protected String secondAnesthesiaAssistant;

  @XmlElement(name="ErMaZhuName", required=true)
  protected String erMaZhuName;

  @XmlElement(name="ThirdAnesthesiaAssistant", required=true)
  protected String thirdAnesthesiaAssistant;

  @XmlElement(name="SanMaZhuName", required=true)
  protected String sanMaZhuName;

  @XmlElement(name="FourthAnesthesiaAssistant", required=true)
  protected String fourthAnesthesiaAssistant;

  @XmlElement(name="SiMaZhuName", required=true)
  protected String siMaZhuName;

  @XmlElement(name="BloodTranDoctor", required=true)
  protected String bloodTranDoctor;

  @XmlElement(name="ShuXueYiShengName", required=true)
  protected String shuXueYiShengName;

  @XmlElement(name="FirstOperationNurse", required=true)
  protected String firstOperationNurse;

  @XmlElement(name="FirstHuShiName", required=true)
  protected String firstHuShiName;

  @XmlElement(name="SecondOperationNurse", required=true)
  protected String secondOperationNurse;

  @XmlElement(name="ErTaiHuShiName", required=true)
  protected String erTaiHuShiName;

  @XmlElement(name="FirstSupplyNurse", required=true)
  protected String firstSupplyNurse;

  @XmlElement(name="FirstGongYingName", required=true)
  protected String firstGongYingName;

  @XmlElement(name="SecondSupplyNurse", required=true)
  protected String secondSupplyNurse;

  @XmlElement(name="ErGongYingHuShiName", required=true)
  protected String erGongYingHuShiName;

  @XmlElement(name="ThirdSupplyNurse", required=true)
  protected String thirdSupplyNurse;

  @XmlElement(name="SanGongYingHuShi", required=true)
  protected String sanGongYingHuShi;

  @XmlElement(name="NotesOnOperation", required=true)
  protected String notesOnOperation;

  @XmlElement(name="ReqDateTime", required=true)
  protected String reqDateTime;

  @XmlElement(name="EnteredBy", required=true)
  protected String enteredBy;

  @XmlElement(name="EnteredByName", required=true)
  protected String enteredByName;

  @XmlElement(name="OperStatus", required=true)
  protected String operStatus;

  @XmlElement(name="DeptName", required=true)
  protected String deptName;

  @XmlElement(name="KeshiName", required=true)
  protected String keshiName;

  @XmlElement(name="ChuanRanBing", required=true)
  protected String chuanRanBing;

  @XmlElement(name="BeiZhuXinXi", required=true)
  protected String beiZhuXinXi;

  @XmlElement(name="type", required=true)
  protected String type;

  @XmlElement(name="Brxm", required=true)
  protected String brxm;

  @XmlElement(name="Xb", required=true)
  protected String xb;

  @XmlElement(name="Nl", required=true)
  protected String nl;

  @XmlElement(name="Sg", required=true)
  protected String sg;

  @XmlElement(name="Tz", required=true)
  protected String tz;

  @XmlElement(name="Nsssmc1", required=true)
  protected String nsssmc1;

  @XmlElement(name="Nsssmc2", required=true)
  protected String nsssmc2;

  @XmlElement(name="Nsssmc3", required=true)
  protected String nsssmc3;

  @XmlElement(name="Nsssmc4", required=true)
  protected String nsssmc4;

  @XmlElement(name="Shoushujb", required=true)
  protected String shoushujb;

  public String getShoushujb() {
    return shoushujb;
  }

  public void setShoushujb(String shoushujb) {
    this.shoushujb = shoushujb;
  }

  public String getNsssmc1() {
    return nsssmc1;
  }

  public void setNsssmc1(String nsssmc1) {
    this.nsssmc1 = nsssmc1;
  }

  public String getNsssmc2() {
    return nsssmc2;
  }

  public void setNsssmc2(String nsssmc2) {
    this.nsssmc2 = nsssmc2;
  }

  public String getNsssmc3() {
    return nsssmc3;
  }

  public void setNsssmc3(String nsssmc3) {
    this.nsssmc3 = nsssmc3;
  }

  public String getNsssmc4() {
    return nsssmc4;
  }

  public void setNsssmc4(String nsssmc4) {
    this.nsssmc4 = nsssmc4;
  }

  public String getSg() {
    return sg;
  }

  public void setSg(String sg) {
    this.sg = sg;
  }

  public String getTz() {
    return tz;
  }

  public void setTz(String tz) {
    this.tz = tz;
  }

  public String getNl() {
    return nl;
  }

  public void setNl(String nl) {
    this.nl = nl;
  }

  public String getXb() {
    return xb;
  }

  public void setXb(String xb) {
    this.xb = xb;
  }

  public String getBrxm() {
    return brxm;
  }

  public void setBrxm(String brxm) {
    this.brxm = brxm;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getPatientId()
  {
    return this.patientId;
  }

  public void setPatientId(String value)
  {
    this.patientId = value;
  }

  public String getVisitId()
  {
    return this.visitId;
  }

  public void setVisitId(String value)
  {
    this.visitId = value;
  }

  public String getDeptName()
  {
    return this.deptName;
  }

  public void setDeptName(String value)
  {
    this.deptName = value;
  }

  public String getKeshiName()
  {
    return this.keshiName;
  }

  public void setKeshiName(String value)
  {
    this.keshiName = value;
  }

  public String getScheduleId()
  {
    return this.scheduleId;
  }

  public void setScheduleId(String value)
  {
    this.scheduleId = value;
  }

  public String getDeptStayed()
  {
    return this.deptStayed;
  }

  public void setDeptStayed(String value)
  {
    this.deptStayed = value;
  }

  public String getBedNO()
  {
    return this.bedNO;
  }

  public void setBedNO(String value)
  {
    this.bedNO = value;
  }

  public String getScheduledDateTime()
  {
    return this.scheduledDateTime;
  }

  public void setScheduledDateTime(String value)
  {
    this.scheduledDateTime = value;
  }

  public String getOperatingRoom()
  {
    return this.operatingRoom;
  }

  public void setOperatingRoom(String value)
  {
    this.operatingRoom = value;
  }

  public String getOperatingRoomNo()
  {
    return this.operatingRoomNo;
  }

  public void setOperatingRoomNo(String value)
  {
    this.operatingRoomNo = value;
  }

  public String getSequence()
  {
    return this.sequence;
  }

  public void setSequence(String value)
  {
    this.sequence = value;
  }

  public String getDiagBeforeOperation()
  {
    return this.diagBeforeOperation;
  }

  public void setDiagBeforeOperation(String value)
  {
    this.diagBeforeOperation = value;
  }

  public String getPatientCondition()
  {
    return this.patientCondition;
  }

  public void setPatientCondition(String value)
  {
    this.patientCondition = value;
  }

  public String getOperationScale()
  {
    return this.operationScale;
  }

  public void setOperationScale(String value)
  {
    this.operationScale = value;
  }

  public String getEmergencyIndicator()
  {
    return this.emergencyIndicator;
  }

  public void setEmergencyIndicator(String value)
  {
    this.emergencyIndicator = value;
  }

  public String getIsolationIndicator()
  {
    return this.isolationIndicator;
  }

  public void setIsolationIndicator(String value)
  {
    this.isolationIndicator = value;
  }

  public String getOperatingDept()
  {
    return this.operatingDept;
  }

  public void setOperatingDept(String value)
  {
    this.operatingDept = value;
  }

  public String getSurgeon()
  {
    return this.surgeon;
  }

  public void setSurgeon(String value)
  {
    this.surgeon = value;
  }

  public String getZhuDaoName()
  {
    return this.zhuDaoName;
  }

  public void setZhuDaoName(String value)
  {
    this.zhuDaoName = value;
  }

  public String getFirstAssistant()
  {
    return this.firstAssistant;
  }

  public void setFirstAssistant(String value)
  {
    this.firstAssistant = value;
  }

  public String getYiZhuName() { return this.yiZhuName; }

  public void setYiZhuName(String value)
  {
    this.yiZhuName = value;
  }

  public String getSecondAssistant()
  {
    return this.secondAssistant;
  }

  public void setSecondAssistant(String value)
  {
    this.secondAssistant = value;
  }

  public String getErZhuName()
  {
    return this.erZhuName;
  }

  public void setErZhuName(String value)
  {
    this.erZhuName = value;
  }

  public String getThirdAssistant()
  {
    return this.thirdAssistant;
  }

  public void setThirdAssistant(String value)
  {
    this.thirdAssistant = value;
  }

  public String getSanZhuName()
  {
    return this.sanZhuName;
  }

  public void setSanZhuName(String value)
  {
    this.sanZhuName = value;
  }

  public String getFourthAssistant()
  {
    return this.fourthAssistant;
  }

  public void setFourthAssistant(String value)
  {
    this.fourthAssistant = value;
  }

  public String getSiZhuAsName()
  {
    return this.siZhuAsName;
  }

  public void setSiZhuAsName(String value)
  {
    this.siZhuAsName = value;
  }

  public String getAnesthesiaMethod()
  {
    return this.anesthesiaMethod;
  }

  public void setAnesthesiaMethod(String value)
  {
    this.anesthesiaMethod = value;
  }

  public String getAnesthesiaDoctor()
  {
    return this.anesthesiaDoctor;
  }

  public void setAnesthesiaDoctor(String value)
  {
    this.anesthesiaDoctor = value;
  }

  public String getMaZuiName()
  {
    return this.maZuiName;
  }

  public void setMaZuiName(String value)
  {
    this.maZuiName = value;
  }

  public String getSecondAnesthesiaDoctor()
  {
    return this.secondAnesthesiaDoctor;
  }

  public void setSecondAnesthesiaDoctor(String value)
  {
    this.secondAnesthesiaDoctor = value;
  }

  public String getErMaZuiName()
  {
    return this.erMaZuiName;
  }

  public void setErMaZuiName(String value)
  {
    this.erMaZuiName = value;
  }

  public String getThirdAnesthesiaDoctor()
  {
    return this.thirdAnesthesiaDoctor;
  }

  public void setThirdAnesthesiaDoctor(String value)
  {
    this.thirdAnesthesiaDoctor = value;
  }

  public String getSanMaZuiName()
  {
    return this.sanMaZuiName;
  }

  public void setSanMaZuiName(String value)
  {
    this.sanMaZuiName = value;
  }

  public String getAnesthesiaAssistant()
  {
    return this.anesthesiaAssistant;
  }

  public void setAnesthesiaAssistant(String value)
  {
    this.anesthesiaAssistant = value;
  }

  public String getYiMaZhuName()
  {
    return this.yiMaZhuName;
  }

  public void setYiMaZhuName(String value)
  {
    this.yiMaZhuName = value;
  }

  public String getSecondAnesthesiaAssistant()
  {
    return this.secondAnesthesiaAssistant;
  }

  public void setSecondAnesthesiaAssistant(String value)
  {
    this.secondAnesthesiaAssistant = value;
  }

  public String getErMaZhuName()
  {
    return this.erMaZhuName;
  }

  public void setErMaZhuName(String value)
  {
    this.erMaZhuName = value;
  }

  public String getThirdAnesthesiaAssistant()
  {
    return this.thirdAnesthesiaAssistant;
  }

  public void setThirdAnesthesiaAssistant(String value)
  {
    this.thirdAnesthesiaAssistant = value;
  }

  public String getSanMaZhuName()
  {
    return this.sanMaZhuName;
  }

  public void setSanMaZhuName(String value)
  {
    this.sanMaZhuName = value;
  }

  public String getFourthAnesthesiaAssistant()
  {
    return this.fourthAnesthesiaAssistant;
  }

  public void setFourthAnesthesiaAssistant(String value)
  {
    this.fourthAnesthesiaAssistant = value;
  }

  public String getSiMaZhuName()
  {
    return this.siMaZhuName;
  }

  public void setSiMaZhuName(String value)
  {
    this.siMaZhuName = value;
  }

  public String getBloodTranDoctor()
  {
    return this.bloodTranDoctor;
  }

  public void setBloodTranDoctor(String value)
  {
    this.bloodTranDoctor = value;
  }

  public String getShuXueYiShengName()
  {
    return this.shuXueYiShengName;
  }

  public void setShuXueYiShengName(String value)
  {
    this.shuXueYiShengName = value;
  }

  public String getFirstOperationNurse()
  {
    return this.firstOperationNurse;
  }

  public void setFirstOperationNurse(String value)
  {
    this.firstOperationNurse = value;
  }

  public String getFirstHuShiName()
  {
    return this.firstHuShiName;
  }

  public void setFirstHuShiName(String value)
  {
    this.firstHuShiName = value;
  }

  public String getSecondOperationNurse()
  {
    return this.secondOperationNurse;
  }

  public void setSecondOperationNurse(String value)
  {
    this.secondOperationNurse = value;
  }

  public String getErTaiHuShiName()
  {
    return this.erTaiHuShiName;
  }

  public void setErTaiHuShiName(String value)
  {
    this.erTaiHuShiName = value;
  }

  public String getFirstSupplyNurse()
  {
    return this.firstSupplyNurse;
  }

  public void setFirstSupplyNurse(String value)
  {
    this.firstSupplyNurse = value;
  }

  public String getFirstGongYingName()
  {
    return this.firstGongYingName;
  }

  public void setFirstGongYingName(String value)
  {
    this.firstGongYingName = value;
  }

  public String getSecondSupplyNurse()
  {
    return this.secondSupplyNurse;
  }

  public void setSecondSupplyNurse(String value)
  {
    this.secondSupplyNurse = value;
  }

  public String getErGongYingHuShiName()
  {
    return this.erGongYingHuShiName;
  }

  public void setErGongYingHuShiName(String value)
  {
    this.erGongYingHuShiName = value;
  }

  public String getThirdSupplyNurse()
  {
    return this.thirdSupplyNurse;
  }

  public void setThirdSupplyNurse(String value)
  {
    this.thirdSupplyNurse = value;
  }

  public String getSanGongYingHuShi()
  {
    return this.sanGongYingHuShi;
  }

  public void setSanGongYingHuShi(String value)
  {
    this.sanGongYingHuShi = value;
  }

  public String getNotesOnOperation()
  {
    return this.notesOnOperation;
  }

  public void setNotesOnOperation(String value)
  {
    this.notesOnOperation = value;
  }

  public String getReqDateTime()
  {
    return this.reqDateTime;
  }

  public void setReqDateTime(String value)
  {
    this.reqDateTime = value;
  }

  public String getEnteredBy()
  {
    return this.enteredBy;
  }

  public void setEnteredBy(String value)
  {
    this.enteredBy = value;
  }

  public String getOperStatus()
  {
    return this.operStatus;
  }

  public void setOperStatus(String value)
  {
    this.operStatus = value;
  }

  public String getEnteredByName() {
    return this.enteredByName;
  }

  public void setEnteredByName(String enteredByName) {
    this.enteredByName = enteredByName;
  }

  public String getChuanRanBing() {
    return chuanRanBing;
  }

  public void setChuanRanBing(String value) {
    this.chuanRanBing = value;
  }

  public String getBeiZhuXinXi() {
    return beiZhuXinXi;
  }

  public void setBeiZhuXinXi(String value) {
    this.beiZhuXinXi = value;
  }
}

