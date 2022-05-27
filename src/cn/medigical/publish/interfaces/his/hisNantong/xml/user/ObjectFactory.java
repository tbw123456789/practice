 package cn.medigical.publish.interfaces.his.hisNantong.xml.user;

 import javax.xml.bind.JAXBElement;
 import javax.xml.bind.annotation.XmlElementDecl;
 import javax.xml.bind.annotation.XmlRegistry;
 import javax.xml.namespace.QName;

 @XmlRegistry
 public class ObjectFactory
 {
   private static final QName _USERROOT_QNAME = new QName("", "USERROOT");
 
   public USERROOTType createUSERROOTType()
   {
     return new USERROOTType();
   }
 
   public ITEMType createITEMType()
   {
     return new ITEMType();
   }
 
   @XmlElementDecl(namespace="", name="USERROOT")
   public JAXBElement<USERROOTType> createUSERROOT(USERROOTType value)
   {
     return new JAXBElement(_USERROOT_QNAME, USERROOTType.class, null, value);
   }
 }

