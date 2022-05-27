 package cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm;

 import javax.xml.bind.JAXBElement;
 import javax.xml.bind.annotation.XmlElementDecl;
 import javax.xml.bind.annotation.XmlRegistry;
 import javax.xml.namespace.QName;

 @XmlRegistry
 public class ObjectFactory
 {
   private static final QName _JYXMROOT_QNAME = new QName("", "JYXMROOT");
 
   public JYXMROOTType createJYXMROOTType()
   {
     return new JYXMROOTType();
   }
 
   public ITEMType createITEMType()
   {
     return new ITEMType();
   }
 
   @XmlElementDecl(namespace="", name="JYXMROOT")
   public JAXBElement<JYXMROOTType> createJYXMROOT(JYXMROOTType value)
   {
     return new JAXBElement(_JYXMROOT_QNAME, JYXMROOTType.class, null, value);
   }
 }

