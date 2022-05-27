 package cn.medigical.publish.interfaces.his.hisNantong.xml.dept;

 import javax.xml.bind.annotation.XmlAccessType;
 import javax.xml.bind.annotation.XmlAccessorType;
 import javax.xml.bind.annotation.XmlElement;
 import javax.xml.bind.annotation.XmlType;

 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name="ITEMType", propOrder={"serialno", "deptcode", "deptname", "inputcode"})
 public class ITEMType
 {
 
   @XmlElement(name="SERIAL_NO", required=true)
   protected String serialno;
 
   @XmlElement(name="DEPT_CODE", required=true)
   protected String deptcode;
 
   @XmlElement(name="DEPT_NAME", required=true)
   protected String deptname;
 
   @XmlElement(name="INPUT_CODE", required=true)
   protected String inputcode;
 
   public String getSERIALNO()
   {
     return this.serialno;
   }
 
   public void setSERIALNO(String value)
   {
     this.serialno = value;
   }
 
   public String getDEPTCODE()
   {
     return this.deptcode;
   }
 
   public void setDEPTCODE(String value)
   {
     this.deptcode = value;
   }
 
   public String getDEPTNAME()
   {
     return this.deptname;
   }
 
   public void setDEPTNAME(String value)
   {
     this.deptname = value;
   }
 
   public String getINPUTCODE()
   {
     return this.inputcode;
   }
 
   public void setINPUTCODE(String value)
   {
     this.inputcode = value;
   }
 }

