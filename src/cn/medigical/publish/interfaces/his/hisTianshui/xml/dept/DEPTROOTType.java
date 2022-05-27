 package cn.medigical.publish.interfaces.his.hisTianshui.xml.dept;

 import javax.xml.bind.annotation.XmlAccessType;
 import javax.xml.bind.annotation.XmlAccessorType;
 import javax.xml.bind.annotation.XmlElement;
 import javax.xml.bind.annotation.XmlType;
 import java.util.ArrayList;
 import java.util.List;

 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name="DEPTROOTType", propOrder={"item"})
 public class DEPTROOTType
 {
 
   @XmlElement(name="ITEM")
   protected List<ITEMType> item;
 
   public List<ITEMType> getITEM()
   {
     if (this.item == null) {
       this.item = new ArrayList();
     }
     return this.item;
   }
 }

