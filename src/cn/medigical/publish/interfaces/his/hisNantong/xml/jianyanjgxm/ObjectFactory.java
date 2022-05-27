 package cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm;

 import javax.xml.bind.JAXBElement;
 import javax.xml.bind.annotation.XmlElementDecl;
 import javax.xml.bind.annotation.XmlRegistry;
 import javax.xml.namespace.QName;

 @XmlRegistry
 public class ObjectFactory
 {
   private static final QName _JYJGXMROOT_QNAME = new QName("", "JYJGXMROOT");
 
   public JYJGXMROOTType createJYJGXMROOTType()
   {
     return new JYJGXMROOTType();
   }
 
   public ITEMType createITEMType()
   {
     return new ITEMType();
   }
 
   @XmlElementDecl(namespace="", name="JYJGXMROOT")
   public JAXBElement<JYJGXMROOTType> createJYJGXMROOT(JYJGXMROOTType value)
   {
     return new JAXBElement(_JYJGXMROOT_QNAME, JYJGXMROOTType.class, null, value);
   }
 }

