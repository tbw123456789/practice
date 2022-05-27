 package cn.medigical.publish.interfaces.his.hisTianshui.xml.schedule;

 import javax.xml.bind.annotation.XmlAccessType;
 import javax.xml.bind.annotation.XmlAccessorType;
 import javax.xml.bind.annotation.XmlElement;
 import javax.xml.bind.annotation.XmlType;

 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name="DEPTROOTType", propOrder={"item"})
 public class DEPTROOTType
 {
 
   @XmlElement(name="ITEM", required=true)
   protected ITEMType item;

   public ITEMType getITEM()
   {
     return this.item;
   }
 
   public void setITEM(ITEMType value)
   {
     this.item = value;
   }
 }

