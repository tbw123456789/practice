 package cn.medigical.publish.interfaces.his.hisNantong.xml.apply;

 import javax.xml.bind.JAXBElement;
 import javax.xml.bind.annotation.XmlElementDecl;
 import javax.xml.bind.annotation.XmlRegistry;
 import javax.xml.namespace.QName;

 @XmlRegistry
 public class ObjectFactory
 {
   private static final QName _APPLYROOT_QNAME = new QName("", "APPLYROOT");
 
   public APPLYROOTType createAPPLYROOTType()
   {
     return new APPLYROOTType();
   }
 
   public ITEMType createITEMType()
   {
     return new ITEMType();
   }
 
   @XmlElementDecl(namespace="", name="APPLYROOT")
   public JAXBElement<APPLYROOTType> createAPPLYROOT(APPLYROOTType value)
   {
     return new JAXBElement(_APPLYROOT_QNAME, APPLYROOTType.class, null, value);
   }
 }

