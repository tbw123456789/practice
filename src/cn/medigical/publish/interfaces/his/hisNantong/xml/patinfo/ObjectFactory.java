 package cn.medigical.publish.interfaces.his.hisNantong.xml.patinfo;

 import javax.xml.bind.JAXBElement;
 import javax.xml.bind.annotation.XmlElementDecl;
 import javax.xml.bind.annotation.XmlRegistry;
 import javax.xml.namespace.QName;

 @XmlRegistry
 public class ObjectFactory
 {
   private static final QName _PATINFOROOT_QNAME = new QName("", "PATINFOROOT");
 
   public PATINFOROOTType createPATINFOROOTType()
   {
     return new PATINFOROOTType();
   }
 
   public ITEMType createITEMType()
   {
     return new ITEMType();
   }
 
   @XmlElementDecl(namespace="", name="PATINFOROOT")
   public JAXBElement<PATINFOROOTType> createPATINFOROOT(PATINFOROOTType value)
   {
     return new JAXBElement(_PATINFOROOT_QNAME, PATINFOROOTType.class, null, value);
   }
 }

