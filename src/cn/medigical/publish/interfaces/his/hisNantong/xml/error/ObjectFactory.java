 package cn.medigical.publish.interfaces.his.hisNantong.xml.error;

 import javax.xml.bind.JAXBElement;
 import javax.xml.bind.annotation.XmlElementDecl;
 import javax.xml.bind.annotation.XmlRegistry;
 import javax.xml.namespace.QName;

 @XmlRegistry
 public class ObjectFactory
 {
   private static final QName _ROOT_QNAME = new QName("", "ROOT");
 
   public ROOTType createROOTType()
   {
     return new ROOTType();
   }
 
   public ERRORType createERRORType()
   {
     return new ERRORType();
   }
 
   @XmlElementDecl(namespace="", name="ROOT")
   public JAXBElement<ROOTType> createROOT(ROOTType value)
   {
     return new JAXBElement(_ROOT_QNAME, ROOTType.class, null, value);
   }
 }

