 package cn.medigical.publish.interfaces.his.hisTianshui.xml.dept;

 import javax.xml.bind.annotation.XmlAccessType;
 import javax.xml.bind.annotation.XmlAccessorType;
 import javax.xml.bind.annotation.XmlElement;
 import javax.xml.bind.annotation.XmlType;

 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name="ITEMType", propOrder={"serialNO", "deptCode", "deptName", "inputCode"})
 public class ITEMType
 {
 
   @XmlElement(name="SerialNO", required=true)
   protected String serialNO;
 
   @XmlElement(name="DeptCode", required=true)
   protected String deptCode;
 
   @XmlElement(name="DeptName", required=true)
   protected String deptName;
 
   @XmlElement(name="InputCode", required=true)
   protected String inputCode;
 
   public String getSerialNO()
   {
     return this.serialNO;
   }
 
   public void setSerialNO(String value)
   {
     this.serialNO = value;
   }
 
   public String getDeptCode()
   {
     return this.deptCode;
   }
 
   public void setDeptCode(String value)
   {
     this.deptCode = value;
   }
 
   public String getDeptName()
   {
     return this.deptName;
   }
 
   public void setDeptName(String value)
   {
     this.deptName = value;
   }
 
   public String getInputCode()
   {
     return this.inputCode;
   }
 
   public void setInputCode(String value)
   {
     this.inputCode = value;
   }
 }

