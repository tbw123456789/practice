 package cn.medigical.publish.interfaces.his.hisNantong.xml.patinfo;

 import javax.xml.bind.annotation.XmlAccessType;
 import javax.xml.bind.annotation.XmlAccessorType;
 import javax.xml.bind.annotation.XmlElement;
 import javax.xml.bind.annotation.XmlType;

 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name="ITEMType", propOrder={"patientid", "admno", "name", "namephonetic", "sex", "height", "weight", "dateofbirth", "birthplace", "citizenship", "nation", "idno", "identity", "chargetype", "mailingaddress", "zipcode", "phonenumberhome", "phonenumberbusiness", "nextofkin", "relationship", "nextofkinaddr", "nextofkinzipcode", "nextofkinphone", "lastvisitdate", "vipindicator", "createdate", "operator"})
 public class ITEMType
 {
 
   @XmlElement(name="PATIENT_ID", required=true)
   protected String patientid;
 
   @XmlElement(name="ADM_NO", required=true)
   protected String admno;
 
   @XmlElement(name="NAME", required=true)
   protected String name;
 
   @XmlElement(name="NAME_PHONETIC", required=true)
   protected String namephonetic;
 
   @XmlElement(name="SEX", required=true)
   protected String sex;
 
   @XmlElement(name="HEIGHT", required=true)
   protected String height;
 
   @XmlElement(name="WEIGHT", required=true)
   protected String weight;
 
   @XmlElement(name="DATE_OF_BIRTH", required=true)
   protected String dateofbirth;
 
   @XmlElement(name="BIRTH_PLACE", required=true)
   protected String birthplace;
 
   @XmlElement(name="CITIZENSHIP", required=true)
   protected String citizenship;
 
   @XmlElement(name="NATION", required=true)
   protected String nation;
 
   @XmlElement(name="ID_NO", required=true)
   protected String idno;
 
   @XmlElement(name="IDENTITY", required=true)
   protected String identity;
 
   @XmlElement(name="CHARGE_TYPE", required=true)
   protected String chargetype;
 
   @XmlElement(name="MAILING_ADDRESS", required=true)
   protected String mailingaddress;
 
   @XmlElement(name="ZIP_CODE", required=true)
   protected String zipcode;
 
   @XmlElement(name="PHONE_NUMBER_HOME", required=true)
   protected String phonenumberhome;
 
   @XmlElement(name="PHONE_NUMBER_BUSINESS", required=true)
   protected String phonenumberbusiness;
 
   @XmlElement(name="NEXT_OF_KIN", required=true)
   protected String nextofkin;
 
   @XmlElement(name="RELATIONSHIP", required=true)
   protected String relationship;
 
   @XmlElement(name="NEXT_OF_KIN_ADDR", required=true)
   protected String nextofkinaddr;
 
   @XmlElement(name="NEXT_OF_KIN_ZIP_CODE", required=true)
   protected String nextofkinzipcode;
 
   @XmlElement(name="NEXT_OF_KIN_PHONE", required=true)
   protected String nextofkinphone;
 
   @XmlElement(name="LAST_VISIT_DATE", required=true)
   protected String lastvisitdate;
 
   @XmlElement(name="VIP_INDICATOR", required=true)
   protected String vipindicator;
 
   @XmlElement(name="CREATE_DATE", required=true)
   protected String createdate;
 
   @XmlElement(name="OPERATOR", required=true)
   protected String operator;
 
   public String getPATIENTID()
   {
     return this.patientid;
   }
 
   public void setPATIENTID(String value)
   {
     this.patientid = value;
   }
 
   public String getADMNO()
   {
     return this.admno;
   }
 
   public void setADMNO(String value)
   {
     this.admno = value;
   }
 
   public String getNAME()
   {
     return this.name;
   }
 
   public void setNAME(String value)
   {
     this.name = value;
   }
 
   public String getNAMEPHONETIC()
   {
     return this.namephonetic;
   }
 
   public void setNAMEPHONETIC(String value)
   {
     this.namephonetic = value;
   }
 
   public String getSEX()
   {
     return this.sex;
   }
 
   public void setSEX(String value)
   {
     this.sex = value;
   }
 
   public String getHEIGHT()
   {
     return this.height;
   }
 
   public void setHEIGHT(String value)
   {
     this.height = value;
   }
 
   public String getWEIGHT()
   {
     return this.weight;
   }
 
   public void setWEIGHT(String value)
   {
     this.weight = value;
   }
 
   public String getDATEOFBIRTH()
   {
     return this.dateofbirth;
   }
 
   public void setDATEOFBIRTH(String value)
   {
     this.dateofbirth = value;
   }
 
   public String getBIRTHPLACE()
   {
     return this.birthplace;
   }
 
   public void setBIRTHPLACE(String value)
   {
     this.birthplace = value;
   }
 
   public String getCITIZENSHIP()
   {
     return this.citizenship;
   }
 
   public void setCITIZENSHIP(String value)
   {
     this.citizenship = value;
   }
 
   public String getNATION()
   {
     return this.nation;
   }
 
   public void setNATION(String value)
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
 
   public String getIDENTITY()
   {
     return this.identity;
   }
 
   public void setIDENTITY(String value)
   {
     this.identity = value;
   }
 
   public String getCHARGETYPE()
   {
     return this.chargetype;
   }
 
   public void setCHARGETYPE(String value)
   {
     this.chargetype = value;
   }
 
   public String getMAILINGADDRESS()
   {
     return this.mailingaddress;
   }
 
   public void setMAILINGADDRESS(String value)
   {
     this.mailingaddress = value;
   }
 
   public String getZIPCODE()
   {
     return this.zipcode;
   }
 
   public void setZIPCODE(String value)
   {
     this.zipcode = value;
   }
 
   public String getPHONENUMBERHOME()
   {
     return this.phonenumberhome;
   }
 
   public void setPHONENUMBERHOME(String value)
   {
     this.phonenumberhome = value;
   }
 
   public String getPHONENUMBERBUSINESS()
   {
     return this.phonenumberbusiness;
   }
 
   public void setPHONENUMBERBUSINESS(String value)
   {
     this.phonenumberbusiness = value;
   }
 
   public String getNEXTOFKIN()
   {
     return this.nextofkin;
   }
 
   public void setNEXTOFKIN(String value)
   {
     this.nextofkin = value;
   }
 
   public String getRELATIONSHIP()
   {
     return this.relationship;
   }
 
   public void setRELATIONSHIP(String value)
   {
     this.relationship = value;
   }
 
   public String getNEXTOFKINADDR()
   {
     return this.nextofkinaddr;
   }
 
   public void setNEXTOFKINADDR(String value)
   {
     this.nextofkinaddr = value;
   }
 
   public String getNEXTOFKINZIPCODE()
   {
     return this.nextofkinzipcode;
   }
 
   public void setNEXTOFKINZIPCODE(String value)
   {
     this.nextofkinzipcode = value;
   }
 
   public String getNEXTOFKINPHONE()
   {
     return this.nextofkinphone;
   }
 
   public void setNEXTOFKINPHONE(String value)
   {
     this.nextofkinphone = value;
   }
 
   public String getLASTVISITDATE()
   {
     return this.lastvisitdate;
   }
 
   public void setLASTVISITDATE(String value)
   {
     this.lastvisitdate = value;
   }
 
   public String getVIPINDICATOR()
   {
     return this.vipindicator;
   }
 
   public void setVIPINDICATOR(String value)
   {
     this.vipindicator = value;
   }
 
   public String getCREATEDATE()
   {
     return this.createdate;
   }
 
   public void setCREATEDATE(String value)
   {
     this.createdate = value;
   }
 
   public String getOPERATOR()
   {
     return this.operator;
   }
 
   public void setOPERATOR(String value)
   {
     this.operator = value;
   }
 }

