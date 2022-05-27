 package cn.medigical.publish.interfaces.his.hisNantong.xml.error;

 import javax.xml.bind.annotation.XmlAccessType;
 import javax.xml.bind.annotation.XmlAccessorType;
 import javax.xml.bind.annotation.XmlElement;
 import javax.xml.bind.annotation.XmlType;

 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name="ROOTType", propOrder={"error", "state"})
 public class ROOTType
 {
 
   @XmlElement(name="ERROR", required=true)
   protected ERRORType error;
 
   @XmlElement(name="STATE", required=true)
   protected String state;
 
   public ERRORType getERROR()
   {
     return this.error;
   }
 
   public void setERROR(ERRORType value)
   {
     this.error = value;
   }
 
   public String getSTATE()
   {
     return this.state;
   }
 
   public void setSTATE(String value)
   {
     this.state = value;
   }
 }

