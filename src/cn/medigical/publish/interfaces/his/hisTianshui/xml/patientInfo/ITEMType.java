 package cn.medigical.publish.interfaces.his.hisTianshui.xml.patientInfo;

 import javax.xml.bind.annotation.XmlAccessType;
 import javax.xml.bind.annotation.XmlAccessorType;
 import javax.xml.bind.annotation.XmlElement;
 import javax.xml.bind.annotation.XmlType;

 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name="ITEMType", propOrder={"patientId", "inpNO", "name", "namePhonetic", "sex", "dateOfBirth", "tizhong", "shenchang", "birthPlace", "citizenship", "nation", "idno", "identity", "chargeType", "mailingAddress", "zipCode", "phoneNumberHome", "phoneNumbeBusiness", "nextOfKin", "relationShip", "nextOfKinAddr", "nextOfKinZipCode", "nextOfKinPhome", "lastVisitDate", "vipIndicator", "createDate", "operator"})
 public class ITEMType
 {
 
   @XmlElement(name="PatientId", required=true)
   protected String patientId;
 
   @XmlElement(name="InpNO", required=true)
   protected String inpNO;
 
   @XmlElement(name="Name", required=true)
   protected String name;
 
   @XmlElement(name="NamePhonetic", required=true)
   protected String namePhonetic;
 
   @XmlElement(name="Sex", required=true)
   protected String sex;
 
   @XmlElement(name="DateOfBirth", required=true)
   protected String dateOfBirth;
 
   @XmlElement(name="tizhong", required=true)
   protected String tizhong;
 
   @XmlElement(name="shenchang", required=true)
   protected String shenchang;
 
   @XmlElement(name="BirthPlace", required=true)
   protected String birthPlace;
 
   @XmlElement(name="Citizenship", required=true)
   protected String citizenship;
 
   @XmlElement(name="Nation", required=true)
   protected String nation;
 
   @XmlElement(name="IDNO", required=true)
   protected String idno;
 
   @XmlElement(name="Identity", required=true)
   protected String identity;
 
   @XmlElement(name="ChargeType", required=true)
   protected String chargeType;
 
   @XmlElement(name="MailingAddress", required=true)
   protected String mailingAddress;
 
   @XmlElement(name="ZipCode", required=true)
   protected String zipCode;
 
   @XmlElement(name="PhoneNumberHome", required=true)
   protected String phoneNumberHome;
 
   @XmlElement(name="PhoneNumbeBusiness", required=true)
   protected String phoneNumbeBusiness;
 
   @XmlElement(name="NextOfKin", required=true)
   protected String nextOfKin;
 
   @XmlElement(name="RelationShip", required=true)
   protected String relationShip;
 
   @XmlElement(name="NextOfKinAddr", required=true)
   protected String nextOfKinAddr;
 
   @XmlElement(name="NextOfKinZipCode", required=true)
   protected String nextOfKinZipCode;
 
   @XmlElement(name="NextOfKinPhome", required=true)
   protected String nextOfKinPhome;
 
   @XmlElement(name="LastVisitDate", required=true)
   protected String lastVisitDate;
 
   @XmlElement(name="VipIndicator", required=true)
   protected String vipIndicator;
 
   @XmlElement(name="CreateDate", required=true)
   protected String createDate;
 
   @XmlElement(name="Operator", required=true)
   protected String operator;
 
   public String getPatientId()
   {
     return this.patientId;
   }
 
   public void setPatientId(String value)
   {
     this.patientId = value;
   }
 
   public String getInpNO()
   {
     return this.inpNO;
   }
 
   public void setInpNO(String value)
   {
     this.inpNO = value;
   }
 
   public String getName()
   {
     return this.name;
   }
 
   public void setName(String value)
   {
     this.name = value;
   }
 
   public String getNamePhonetic()
   {
     return this.namePhonetic;
   }
 
   public void setNamePhonetic(String value)
   {
     this.namePhonetic = value;
   }
 
   public String getSex()
   {
     return this.sex;
   }
 
   public void setSex(String value)
   {
     this.sex = value;
   }
 
   public String getDateOfBirth()
   {
     return this.dateOfBirth;
   }
 
   public void setDateOfBirth(String value)
   {
     this.dateOfBirth = value;
   }
 
   public String getBirthPlace()
   {
     return this.birthPlace;
   }
 
   public void setBirthPlace(String value)
   {
     this.birthPlace = value;
   }
 
   public String getCitizenship()
   {
     return this.citizenship;
   }
 
   public void setCitizenship(String value)
   {
     this.citizenship = value;
   }
 
   public String getNation()
   {
     return this.nation;
   }
 
   public void setNation(String value)
   {
     this.nation = value;
   }
 
   public String getIDNO()
   {
     return this.idno;
   }
 
   public void setIDNO(String value)
   {
     this.idno = value;
   }
 
   public String getIdentity()
   {
     return this.identity;
   }
 
   public void setIdentity(String value)
   {
     this.identity = value;
   }
 
   public String getChargeType()
   {
     return this.chargeType;
   }
 
   public void setChargeType(String value)
   {
     this.chargeType = value;
   }
 
   public String getMailingAddress()
   {
     return this.mailingAddress;
   }
 
   public void setMailingAddress(String value)
   {
     this.mailingAddress = value;
   }
 
   public String getZipCode()
   {
     return this.zipCode;
   }
 
   public void setZipCode(String value)
   {
     this.zipCode = value;
   }
 
   public String getPhoneNumberHome()
   {
     return this.phoneNumberHome;
   }
 
   public void setPhoneNumberHome(String value)
   {
     this.phoneNumberHome = value;
   }
 
   public String getPhoneNumbeBusiness()
   {
     return this.phoneNumbeBusiness;
   }
 
   public void setPhoneNumbeBusiness(String value)
   {
     this.phoneNumbeBusiness = value;
   }
 
   public String getNextOfKin()
   {
     return this.nextOfKin;
   }
 
   public void setNextOfKin(String value)
   {
     this.nextOfKin = value;
   }
 
   public String getRelationShip()
   {
     return this.relationShip;
   }
 
   public void setRelationShip(String value)
   {
     this.relationShip = value;
   }
 
   public String getNextOfKinAddr()
   {
     return this.nextOfKinAddr;
   }
 
   public void setNextOfKinAddr(String value)
   {
     this.nextOfKinAddr = value;
   }
 
   public String getNextOfKinZipCode()
   {
     return this.nextOfKinZipCode;
   }
 
   public void setNextOfKinZipCode(String value)
   {
     this.nextOfKinZipCode = value;
   }
 
   public String getNextOfKinPhome()
   {
     return this.nextOfKinPhome;
   }
 
   public void setNextOfKinPhome(String value)
   {
     this.nextOfKinPhome = value;
   }
 
   public String getLastVisitDate()
   {
     return this.lastVisitDate;
   }
 
   public void setLastVisitDate(String value)
   {
     this.lastVisitDate = value;
   }
 
   public String getVipIndicator()
   {
     return this.vipIndicator;
   }
 
   public void setVipIndicator(String value)
   {
     this.vipIndicator = value;
   }
 
   public String getCreateDate()
   {
     return this.createDate;
   }
 
   public void setCreateDate(String value)
   {
     this.createDate = value;
   }
 
   public String getOperator()
   {
     return this.operator;
   }
 
   public void setOperator(String value)
   {
     this.operator = value;
   }
 
   public String getTizhong() {
     return this.tizhong;
   }
 
   public void setTizhong(String tizhong) {
     this.tizhong = tizhong;
   }
 
   public String getShenchang() {
     return this.shenchang;
   }
 
   public void setShenchang(String shenchang) {
     this.shenchang = shenchang;
   }
 }

