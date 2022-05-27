 package cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm;

 import javax.xml.bind.annotation.XmlAccessType;
 import javax.xml.bind.annotation.XmlAccessorType;
 import javax.xml.bind.annotation.XmlElement;
 import javax.xml.bind.annotation.XmlType;
 import java.util.ArrayList;
 import java.util.List;

 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name="JYJGXMROOTType", propOrder={"item"})
 public class JYJGXMROOTType
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

