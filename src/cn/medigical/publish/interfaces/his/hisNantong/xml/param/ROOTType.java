 package cn.medigical.publish.interfaces.his.hisNantong.xml.param;

 import javax.xml.bind.annotation.XmlAccessType;
 import javax.xml.bind.annotation.XmlAccessorType;
 import javax.xml.bind.annotation.XmlElement;
 import javax.xml.bind.annotation.XmlType;

 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name="ROOTType", propOrder={"state", "dataparam"})
 public class ROOTType
 {
 
   @XmlElement(name="STATE", required=true)
   protected String state;
 
   @XmlElement(name="DATAPARAM", required=true)
   protected String dataparam;
 
   public String getSTATE()
   {
     return this.state;
   }
 
   public void setSTATE(String value)
   {
     this.state = value;
   }
 
   public String getDATAPARAM()
   {
     return this.dataparam;
   }
 
   public void setDATAPARAM(String value)
   {
     this.dataparam = value;
   }
 }

