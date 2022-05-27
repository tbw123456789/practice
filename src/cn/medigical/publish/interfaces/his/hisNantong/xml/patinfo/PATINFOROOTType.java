 package cn.medigical.publish.interfaces.his.hisNantong.xml.patinfo;

 import javax.xml.bind.annotation.XmlAccessType;
 import javax.xml.bind.annotation.XmlAccessorType;
 import javax.xml.bind.annotation.XmlElement;
 import javax.xml.bind.annotation.XmlType;

 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name="PATINFOROOTType", propOrder={"item"})
 public class PATINFOROOTType
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

