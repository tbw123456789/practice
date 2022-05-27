 package cn.medigical.publish.interfaces.his.hisTianshui.xml.apply;

 import javax.xml.bind.annotation.*;

 @XmlAccessorType(XmlAccessType.FIELD)
 @XmlType(name="RESULTType", propOrder={"deptroot"})
 public class RESULTType
 {
 
   @XmlElement(name="DEPTROOT", required=true)
   protected DEPTROOTType deptroot;
 
   @XmlAttribute(name="RETURN")
   protected String _return;
 
   @XmlAttribute(name="ERRMSG")
   protected String errmsg;
 
   public DEPTROOTType getDEPTROOT()
   {
     return this.deptroot;
   }
 
   public void setDEPTROOT(DEPTROOTType value)
   {
     this.deptroot = value;
   }
 
   public String getRETURN()
   {
     return this._return;
   }
 
   public void setRETURN(String value)
   {
     this._return = value;
   }
 
   public String getERRMSG()
   {
     return this.errmsg;
   }
 
   public void setERRMSG(String value)
   {
     this.errmsg = value;
   }
 }

