 package cn.medigical.publish.interfaces.his.hisNantong.xml.surgeryname;

 import javax.xml.bind.JAXBElement;
 import javax.xml.bind.annotation.XmlElementDecl;
 import javax.xml.bind.annotation.XmlRegistry;
 import javax.xml.namespace.QName;

 @XmlRegistry
 public class ObjectFactory
 {
   private static final QName _OPERNAMEROOT_QNAME = new QName("", "OPERNAMEROOT");
 
   public OPERNAMEROOTType createOPERNAMEROOTType()
   {
     return new OPERNAMEROOTType();
   }
 
   public ITEMType createITEMType()
   {
     return new ITEMType();
   }
 
   @XmlElementDecl(namespace="", name="OPERNAMEROOT")
   public JAXBElement<OPERNAMEROOTType> createOPERNAMEROOT(OPERNAMEROOTType value)
   {
     return new JAXBElement(_OPERNAMEROOT_QNAME, OPERNAMEROOTType.class, null, value);
   }
 }

