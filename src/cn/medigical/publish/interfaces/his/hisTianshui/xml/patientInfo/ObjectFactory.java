 package cn.medigical.publish.interfaces.his.hisTianshui.xml.patientInfo;

 import javax.xml.bind.JAXBElement;
 import javax.xml.bind.annotation.XmlElementDecl;
 import javax.xml.bind.annotation.XmlRegistry;
 import javax.xml.namespace.QName;

 @XmlRegistry
 public class ObjectFactory
 {
   private static final QName _RESULT_QNAME = new QName("", "RESULT");
 
   public RESULTType createRESULTType()
   {
     return new RESULTType();
   }

   public ITEMType createITEMType()
   {
     return new ITEMType();
   }

   public DEPTROOTType createDEPTROOTType()
   {
     return new DEPTROOTType();
   }

   @XmlElementDecl(namespace="", name="RESULT")
   public JAXBElement<RESULTType> createRESULT(RESULTType value)
   {
     return new JAXBElement(_RESULT_QNAME, RESULTType.class, null, value);
   }
 }

