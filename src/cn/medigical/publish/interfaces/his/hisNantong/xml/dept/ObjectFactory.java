 package cn.medigical.publish.interfaces.his.hisNantong.xml.dept;

 import javax.xml.bind.JAXBElement;
 import javax.xml.bind.annotation.XmlElementDecl;
 import javax.xml.bind.annotation.XmlRegistry;
 import javax.xml.namespace.QName;

 @XmlRegistry
 public class ObjectFactory
 {
   private static final QName _DEPTROOT_QNAME = new QName("", "DEPTROOT");
 
   public DEPTROOTType createDEPTROOTType()
   {
     return new DEPTROOTType();
   }
 
   public ITEMType createITEMType()
   {
     return new ITEMType();
   }
 
   @XmlElementDecl(namespace="", name="DEPTROOT")
   public JAXBElement<DEPTROOTType> createDEPTROOT(DEPTROOTType value)
   {
     return new JAXBElement(_DEPTROOT_QNAME, DEPTROOTType.class, null, value);
   }
 }

