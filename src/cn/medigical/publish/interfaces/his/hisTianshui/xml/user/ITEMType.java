 package cn.medigical.publish.interfaces.his.hisTianshui.xml.user;

 import javax.xml.bind.annotation.XmlAccessType;
 import javax.xml.bind.annotation.XmlAccessorType;
 import javax.xml.bind.annotation.XmlElement;
 import javax.xml.bind.annotation.XmlType;

 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name="ITEMType", propOrder={"userID", "userName", "sex", "userDept", "userJob", "createDate"})
 public class ITEMType
 {
 
   @XmlElement(name="UserID", required=true)
   protected String userID;
 
   @XmlElement(name="UserName", required=true)
   protected String userName;
 
   @XmlElement(name="Sex", required=true)
   protected String sex;
 
   @XmlElement(name="UserDept", required=true)
   protected String userDept;

   @XmlElement(name="userDeptID", required=true)
   protected String userDeptID;

   @XmlElement(name="UserJob", required=true)
   protected String userJob;
 
   @XmlElement(name="CreateDate", required=true)
   protected String createDate;
 
   public String getUserID()
   {
     return this.userID;
   }
 
   public void setUserID(String value)
   {
     this.userID = value;
   }
 
   public String getUserName()
   {
     return this.userName;
   }
 
   public void setUserName(String value)
   {
     this.userName = value;
   }
 
   public String getUserDept()
   {
     return this.userDept;
   }
 
   public void setUserDept(String value)
   {
     this.userDept = value;
   }
 
   public String getUserJob()
   {
     return this.userJob;
   }
 
   public void setUserJob(String value)
   {
     this.userJob = value;
   }
 
   public String getCreateDate()
   {
     return this.createDate;
   }
 
   public void setCreateDate(String value)
   {
     this.createDate = value;
   }
 
   public String getSex() {
     return this.sex;
   }
 
   public void setSex(String sex) {
     this.sex = sex;
   }

   public String getUserDeptID() {
     return userDeptID;
   }

   public void setUserDeptID(String userDeptID) {
     this.userDeptID = userDeptID;
   }
 }

