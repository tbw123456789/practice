 package cn.medigical.publish.interfaces.his.hisNantong.xml.error;

 import javax.xml.bind.annotation.XmlAccessType;
 import javax.xml.bind.annotation.XmlAccessorType;
 import javax.xml.bind.annotation.XmlElement;
 import javax.xml.bind.annotation.XmlType;

 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name="ERRORType", propOrder={"errcode"})
 public class ERRORType
 {
 
   @XmlElement(name="ERRCODE", required=true)
   protected String errcode;
 
   public String getERRCODE()
   {
     return this.errcode;
   }
 
   public void setERRCODE(String value)
   {
     this.errcode = value;
   }
 }

