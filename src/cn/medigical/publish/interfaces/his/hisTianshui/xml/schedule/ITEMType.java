 package cn.medigical.publish.interfaces.his.hisTianshui.xml.schedule;

 import javax.xml.bind.annotation.XmlAccessType;
 import javax.xml.bind.annotation.XmlAccessorType;
 import javax.xml.bind.annotation.XmlElement;
 import javax.xml.bind.annotation.XmlType;

 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name="ITEMType", propOrder={"resultSchedule"})
 public class ITEMType
 {
 
   @XmlElement(name="ResultSchedule", required=true)
   protected String resultSchedule;

 
   public String getResultSchedule()
   {
     return this.resultSchedule;
   }
 
   public void setResultSchedule(String value)
   {
     this.resultSchedule = value;
   }
 


 }

