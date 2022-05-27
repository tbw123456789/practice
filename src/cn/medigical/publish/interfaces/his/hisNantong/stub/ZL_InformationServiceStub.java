package cn.medigical.publish.interfaces.his.hisNantong.stub;

import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.om.OMFactory;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.FaultMapKey;
import org.apache.axis2.client.OperationClient;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.client.Stub;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.databinding.ADBBean;
import org.apache.axis2.databinding.ADBDataSource;
import org.apache.axis2.databinding.ADBException;
import org.apache.axis2.databinding.utils.BeanUtil;
import org.apache.axis2.databinding.utils.ConverterUtil;
import org.apache.axis2.description.AxisOperation;
import org.apache.axis2.description.AxisService;
import org.apache.axis2.description.OutInAxisOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Vector;

public class ZL_InformationServiceStub extends Stub {
    protected AxisOperation[] _operations;
    private HashMap faultExceptionNameMap = new HashMap();
    private HashMap faultExceptionClassNameMap = new HashMap();
    private HashMap faultMessageMap = new HashMap();

    private static int counter = 0;

    private QName[] opNameArray = null;

    private static synchronized String getUniqueSuffix() {
        if (counter > 99999) {
            counter = 0;
        }
        counter += 1;
        return Long.toString(System.currentTimeMillis()) + "_" + counter;
    }

    private void populateAxisService()
            throws AxisFault {
        this._service = new AxisService("ZL_InformationService" + getUniqueSuffix());
        addAnonymousOperations();

        this._operations = new AxisOperation[1];

        AxisOperation __operation = new OutInAxisOperation();

        __operation.setName(new QName("http://tempuri.org/", "public"));
        this._service.addOperation(__operation);

        this._operations[0] = __operation;
    }

    private void populateFaults() {
    }

    public ZL_InformationServiceStub(ConfigurationContext configurationContext, String targetEndpoint)
            throws AxisFault {
        this(configurationContext, targetEndpoint, false);
    }

    public ZL_InformationServiceStub(ConfigurationContext configurationContext, String targetEndpoint, boolean useSeparateListener)
            throws AxisFault {
        populateAxisService();
        populateFaults();

        this._serviceClient = new ServiceClient(configurationContext, this._service);

        this._serviceClient.getOptions().setTo(new EndpointReference(targetEndpoint));

        this._serviceClient.getOptions().setUseSeparateListener(useSeparateListener);
    }

    public ZL_InformationServiceStub(ConfigurationContext configurationContext)
            throws AxisFault {
        this(configurationContext, "http://192.168.35.13:8088/ExternalServices/ZL_InformationService.asmx");
    }

    public ZL_InformationServiceStub()
            throws AxisFault {
        this("http://192.168.35.13:8088/ExternalServices/ZL_InformationService.asmx");
    }

    public ZL_InformationServiceStub(String targetEndpoint)
            throws AxisFault {
        this(null, targetEndpoint);
    }

    public String publicm(Public p)
            throws RemoteException {
        MessageContext _messageContext = null;
        try {
            OperationClient _operationClient = this._serviceClient.createClient(this._operations[0].getName());
            _operationClient.getOptions().setAction("\"\"");
            _operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);

            addPropertyToOperationClient(_operationClient, "whttp:queryParameterSeparator", "&");

            addPropertyToOperationClient(_operationClient, "whttp:location", "/ExternalServices/ZL_InformationService.asmx/Custom");

            addPropertyToOperationClient(_operationClient, "enableREST", true);

            addPropertyToOperationClient(_operationClient, "HTTP_METHOD", "GET");

            addPropertyToOperationClient(_operationClient, "ContentType", "application/x-www-form-urlencoded");

            addPropertyToOperationClient(_operationClient, "messageType", "application/x-www-form-urlencoded");

            _messageContext = new MessageContext();

            SOAPEnvelope env = null;

            env = toEnvelope(getFactory(_operationClient.getOptions().getSoapVersionURI()), p,
                    optimizeContent(new QName("http://tempuri.org/", "public")),
                    new QName("http://tempuri.org/", "Public"));

            this._serviceClient.addHeadersToEnvelope(env);

            _messageContext.setEnvelope(env);

            _operationClient.addMessageContext(_messageContext);

            _operationClient.execute(true);

            MessageContext _returnMessageContext = _operationClient.getMessageContext("In");

            SOAPEnvelope _returnEnv = _returnMessageContext.getEnvelope();

            String str1 = new String(_returnEnv.getBody().getFirstElement().toString());
            return str1;
        } catch (AxisFault f) {
            OMElement faultElt = f.getDetail();
            if (faultElt != null) {
                if (this.faultExceptionNameMap.containsKey(new FaultMapKey(faultElt.getQName(), "Public"))) {
                    try {
                        String exceptionClassName = (String) this.faultExceptionClassNameMap.get(new FaultMapKey(faultElt.getQName(), "Public"));
                        Class exceptionClass = Class.forName(exceptionClassName);
                        Constructor constructor = exceptionClass.getConstructor(new Class[]{String.class});
                        Exception ex = (Exception) constructor.newInstance(new Object[]{f.getMessage()});

                        String messageClassName = (String) this.faultMessageMap.get(new FaultMapKey(faultElt.getQName(), "Public"));
                        Class messageClass = Class.forName(messageClassName);
                        Object messageObject = fromOM(faultElt, messageClass);
                        Method m = exceptionClass.getMethod("setFaultMessage", new Class[]{messageClass});

                        m.invoke(ex, new Object[]{messageObject});

                        throw new RemoteException(ex.getMessage(), ex);
                    } catch (ClassCastException e) {
                        throw f;
                    } catch (ClassNotFoundException e) {
                        throw f;
                    } catch (NoSuchMethodException e) {
                        throw f;
                    } catch (InvocationTargetException e) {
                        throw f;
                    } catch (IllegalAccessException e) {
                        throw f;
                    } catch (InstantiationException e) {
                        throw f;
                    }
                }
                throw f;
            }

            throw f;
        } finally {
            if (_messageContext.getTransportOut() != null)
                _messageContext.getTransportOut().getSender().cleanup(_messageContext);
        }
    }

    private boolean optimizeContent(QName opName) {
        if (this.opNameArray == null) {
            return false;
        }
        for (int i = 0; i < this.opNameArray.length; i++) {
            if (opName.equals(this.opNameArray[i])) {
                return true;
            }
        }
        return false;
    }

    private OMElement toOM(ROOT param, boolean optimizeContent)
            throws AxisFault {
        OMElement omElement = null;
        try {
            omElement = param.getOMElement(ROOT.MY_QNAME,OMAbstractFactory.getOMFactory());
        } catch (ADBException e) {
            e.printStackTrace();
        }
        return omElement;
    }

    private SOAPEnvelope toEnvelope(SOAPFactory factory, Public param, boolean optimizeContent, QName elementQName) throws AxisFault {
        SOAPEnvelope emptyEnvelope = null;
        try {
            emptyEnvelope = factory.getDefaultEnvelope();
            emptyEnvelope.getBody().addChild(param.getOMElement(Public.MY_QNAME, factory));

        } catch (ADBException e) {
            e.printStackTrace();
        }
        return emptyEnvelope;
    }

    private SOAPEnvelope toEnvelope(SOAPFactory factory) {
        return factory.getDefaultEnvelope();
    }

    private Object fromOM(OMElement param, Class type)
            throws AxisFault {
        try {
            if (Public.class.equals(type)) {
                return ZL_InformationServiceStub.Public.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

            if (ROOT.class.equals(type)) {
                return ZL_InformationServiceStub.ROOT.Factory.parse(param.getXMLStreamReaderWithoutCaching());
            }

        } catch (Exception e) {
            throw AxisFault.makeFault(e);
        }
        return null;
    }

    public static class PublicResponse
            implements ADBBean {
        public static final QName MY_QNAME = new QName("http://tempuri.org/", "PublicResponse", "ns1");

        public OMElement getOMElement(QName parentQName, OMFactory factory)
                throws ADBException {
            return factory.createOMElement(new ADBDataSource(this, MY_QNAME));
        }

        public void serialize(QName parentQName, XMLStreamWriter xmlWriter)
                throws XMLStreamException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(QName parentQName, XMLStreamWriter xmlWriter, boolean serializeType)
                throws XMLStreamException {
            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if (serializeType) {
                String namespacePrefix = registerPrefix(xmlWriter, "http://tempuri.org/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":PublicResponse", xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "PublicResponse", xmlWriter);
                }

            }

            xmlWriter.writeEndElement();
        }

        private static String generatePrefix(String namespace) {
            if (namespace.equals("http://tempuri.org/")) {
                return "ns1";
            }
            return BeanUtil.getUniquePrefix();
        }

        private void writeStartElement(String prefix, String namespace, String localPart, XMLStreamWriter xmlWriter)
                throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0)
                    prefix = "";
                else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        private void writeAttribute(String prefix, String namespace, String attName, String attValue, XMLStreamWriter xmlWriter)
                throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName, attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        private void writeAttribute(String namespace, String attName, String attValue, XMLStreamWriter xmlWriter)
                throws XMLStreamException {
            if (namespace.equals(""))
                xmlWriter.writeAttribute(attName, attValue);
            else
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace), namespace, attName, attValue);
        }

        private void writeQNameAttribute(String namespace, String attName, QName qname, XMLStreamWriter xmlWriter)
                throws XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null)
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            String attributeValue;
            if (attributePrefix.trim().length() > 0)
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName, attributeValue);
            }
        }

        private void writeQName(QName qname, XMLStreamWriter xmlWriter)
                throws XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + ConverterUtil.convertToString(qname));
                } else
                    xmlWriter.writeCharacters(ConverterUtil.convertToString(qname));
            } else {
                xmlWriter.writeCharacters(ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(QName[] qnames, XMLStreamWriter xmlWriter)
                throws XMLStreamException {
            if (qnames != null) {
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0)
                            stringToWrite.append(prefix).append(":").append(ConverterUtil.convertToString(qnames[i]));
                        else
                            stringToWrite.append(ConverterUtil.convertToString(qnames[i]));
                    } else {
                        stringToWrite.append(ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        private String registerPrefix(XMLStreamWriter xmlWriter, String namespace)
                throws XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);
                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }
                    prefix = BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        public static class Factory {
            private static Log log = LogFactory.getLog(Factory.class);

            public static ZL_InformationServiceStub.PublicResponse parse(XMLStreamReader reader)
                    throws Exception {
                ZL_InformationServiceStub.PublicResponse object = new ZL_InformationServiceStub.PublicResponse();

                QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";
                try {
                    while ((!reader.isStartElement()) && (!reader.isEndElement())) {
                        reader.next();
                    }
                    currentQName = reader.getName();

                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");

                        if (fullTypeName != null) {
                            String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"PublicResponse".equals(type)) {
                                String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ZL_InformationServiceStub.PublicResponse) ZL_InformationServiceStub.ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    Vector handledAttributes = new Vector();

                    reader.next();

                    while ((!reader.isStartElement()) && (!reader.isEndElement())) {
                        reader.next();
                    }
                    if (reader.isStartElement()) {
                        throw new ADBException("Unexpected subelement " + reader.getName());
                    }

                } catch (XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        }
    }

    public static class Public
            implements ADBBean {
        public static final QName MY_QNAME = new QName("http://tempuri.org/", "Public", "ns1");
        protected String localReData;
        protected boolean localReDataTracker;

        public Public() {
            this.localReDataTracker = false;
        }

        public boolean isReDataSpecified() {
            return this.localReDataTracker;
        }

        public String getReData() {
            return this.localReData;
        }

        public void setReData(String param) {
            this.localReDataTracker = (param != null);

            this.localReData = param;
        }

        public OMElement getOMElement(QName parentQName, OMFactory factory)
                throws ADBException {
            return factory.createOMElement(new ADBDataSource(this, MY_QNAME));
        }

        public void serialize(QName parentQName, XMLStreamWriter xmlWriter)
                throws XMLStreamException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(QName parentQName, XMLStreamWriter xmlWriter, boolean serializeType)
                throws XMLStreamException {
            String prefix = null;
            String namespace = null;

            prefix = parentQName.getPrefix();
            namespace = parentQName.getNamespaceURI();
            writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

            if (serializeType) {
                String namespacePrefix = registerPrefix(xmlWriter, "http://tempuri.org/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":Public", xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "Public", xmlWriter);
                }

            }

            if (this.localReDataTracker) {
                namespace = "http://tempuri.org/";
                writeStartElement(null, namespace, "ReData", xmlWriter);

                if (this.localReData == null) {
                    throw new ADBException("ReData cannot be null!!");
                }

                xmlWriter.writeCharacters(this.localReData);

                xmlWriter.writeEndElement();
            }
            xmlWriter.writeEndElement();
        }

        private static String generatePrefix(String namespace) {
            if (namespace.equals("http://tempuri.org/")) {
                return "ns1";
            }
            return BeanUtil.getUniquePrefix();
        }

        private void writeStartElement(String prefix, String namespace, String localPart, XMLStreamWriter xmlWriter)
                throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0)
                    prefix = "";
                else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        private void writeAttribute(String prefix, String namespace, String attName, String attValue, XMLStreamWriter xmlWriter)
                throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName, attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        private void writeAttribute(String namespace, String attName, String attValue, XMLStreamWriter xmlWriter)
                throws XMLStreamException {
            if (namespace.equals(""))
                xmlWriter.writeAttribute(attName, attValue);
            else
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace), namespace, attName, attValue);
        }

        private void writeQNameAttribute(String namespace, String attName, QName qname, XMLStreamWriter xmlWriter)
                throws XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null)
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            String attributeValue;
            if (attributePrefix.trim().length() > 0)
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName, attributeValue);
            }
        }

        private void writeQName(QName qname, XMLStreamWriter xmlWriter)
                throws XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + ConverterUtil.convertToString(qname));
                } else
                    xmlWriter.writeCharacters(ConverterUtil.convertToString(qname));
            } else {
                xmlWriter.writeCharacters(ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(QName[] qnames, XMLStreamWriter xmlWriter)
                throws XMLStreamException {
            if (qnames != null) {
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0)
                            stringToWrite.append(prefix).append(":").append(ConverterUtil.convertToString(qnames[i]));
                        else
                            stringToWrite.append(ConverterUtil.convertToString(qnames[i]));
                    } else {
                        stringToWrite.append(ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        private String registerPrefix(XMLStreamWriter xmlWriter, String namespace)
                throws XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);
                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }
                    prefix = BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        public static class Factory {
            private static Log log = LogFactory.getLog(Factory.class);

            public static ZL_InformationServiceStub.Public parse(XMLStreamReader reader)
                    throws Exception {
                ZL_InformationServiceStub.Public object = new ZL_InformationServiceStub.Public();

                QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";
                try {
                    while ((!reader.isStartElement()) && (!reader.isEndElement())) {
                        reader.next();
                    }
                    currentQName = reader.getName();

                    if (reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type") != null) {
                        String fullTypeName = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "type");

                        if (fullTypeName != null) {
                            String nsPrefix = null;
                            if (fullTypeName.indexOf(":") > -1) {
                                nsPrefix = fullTypeName.substring(0, fullTypeName.indexOf(":"));
                            }
                            nsPrefix = nsPrefix == null ? "" : nsPrefix;

                            String type = fullTypeName.substring(fullTypeName.indexOf(":") + 1);

                            if (!"Public".equals(type)) {
                                String nsUri = reader.getNamespaceContext().getNamespaceURI(nsPrefix);
                                return (ZL_InformationServiceStub.Public) ZL_InformationServiceStub.ExtensionMapper.getTypeObject(nsUri, type, reader);
                            }

                        }

                    }

                    Vector handledAttributes = new Vector();

                    reader.next();

                    while ((!reader.isStartElement()) && (!reader.isEndElement())) reader.next();

                    if (((reader.isStartElement()) && (new QName("http://tempuri.org/", "ReData").equals(reader.getName()))) || (new QName("", "ReData").equals(reader.getName()))) {
                        nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                        if (("true".equals(nillableValue)) || ("1".equals(nillableValue))) {
                            throw new ADBException("The element: ReData  cannot be null");
                        }

                        String content = reader.getElementText();

                        object.setReData(
                                ConverterUtil.convertToString(content));

                        reader.next();
                    }

                    while ((!reader.isStartElement()) && (!reader.isEndElement())) {
                        reader.next();
                    }
                    if (reader.isStartElement()) {
                        throw new ADBException("Unexpected subelement " + reader.getName());
                    }

                } catch (XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        }
    }

    public static class ROOT
            implements ADBBean {
        public static final QName MY_QNAME = new QName("http://tempuri.org/", "ROOT", "ns1");
        protected String localROOT;

        public String getROOT() {
            return this.localROOT;
        }

        public void setROOT(String param) {
            this.localROOT = param;
        }

        public OMElement getOMElement(QName parentQName, OMFactory factory)
                throws ADBException {
            return factory.createOMElement(new ADBDataSource(this, MY_QNAME));
        }

        public void serialize(QName parentQName, XMLStreamWriter xmlWriter)
                throws XMLStreamException {
            serialize(parentQName, xmlWriter, false);
        }

        public void serialize(QName parentQName, XMLStreamWriter xmlWriter, boolean serializeType)
                throws XMLStreamException {
            String namespace = "http://tempuri.org/";
            String _localName = "ROOT";

            writeStartElement(null, namespace, _localName, xmlWriter);

            if (serializeType) {
                String namespacePrefix = registerPrefix(xmlWriter, "http://tempuri.org/");
                if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", namespacePrefix + ":ROOT", xmlWriter);
                } else {
                    writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "type", "ROOT", xmlWriter);
                }

            }

            if (this.localROOT == null) {
                writeAttribute("xsi", "http://www.w3.org/2001/XMLSchema-instance", "nil", "1", xmlWriter);
            } else {
                xmlWriter.writeCharacters(this.localROOT);
            }

            xmlWriter.writeEndElement();
        }

        private static String generatePrefix(String namespace) {
            if (namespace.equals("http://tempuri.org/")) {
                return "ns1";
            }
            return BeanUtil.getUniquePrefix();
        }

        private void writeStartElement(String prefix, String namespace, String localPart, XMLStreamWriter xmlWriter)
                throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
            } else {
                if (namespace.length() == 0)
                    prefix = "";
                else if (prefix == null) {
                    prefix = generatePrefix(namespace);
                }

                xmlWriter.writeStartElement(prefix, localPart, namespace);
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
        }

        private void writeAttribute(String prefix, String namespace, String attName, String attValue, XMLStreamWriter xmlWriter)
                throws XMLStreamException {
            String writerPrefix = xmlWriter.getPrefix(namespace);
            if (writerPrefix != null) {
                xmlWriter.writeAttribute(writerPrefix, namespace, attName, attValue);
            } else {
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
                xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
            }
        }

        private void writeAttribute(String namespace, String attName, String attValue, XMLStreamWriter xmlWriter)
                throws XMLStreamException {
            if (namespace.equals(""))
                xmlWriter.writeAttribute(attName, attValue);
            else
                xmlWriter.writeAttribute(registerPrefix(xmlWriter, namespace), namespace, attName, attValue);
        }

        private void writeQNameAttribute(String namespace, String attName, QName qname, XMLStreamWriter xmlWriter)
                throws XMLStreamException {
            String attributeNamespace = qname.getNamespaceURI();
            String attributePrefix = xmlWriter.getPrefix(attributeNamespace);
            if (attributePrefix == null)
                attributePrefix = registerPrefix(xmlWriter, attributeNamespace);
            String attributeValue;
            if (attributePrefix.trim().length() > 0)
                attributeValue = attributePrefix + ":" + qname.getLocalPart();
            else {
                attributeValue = qname.getLocalPart();
            }

            if (namespace.equals("")) {
                xmlWriter.writeAttribute(attName, attributeValue);
            } else {
                registerPrefix(xmlWriter, namespace);
                xmlWriter.writeAttribute(attributePrefix, namespace, attName, attributeValue);
            }
        }

        private void writeQName(QName qname, XMLStreamWriter xmlWriter)
                throws XMLStreamException {
            String namespaceURI = qname.getNamespaceURI();
            if (namespaceURI != null) {
                String prefix = xmlWriter.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = generatePrefix(namespaceURI);
                    xmlWriter.writeNamespace(prefix, namespaceURI);
                    xmlWriter.setPrefix(prefix, namespaceURI);
                }

                if (prefix.trim().length() > 0) {
                    xmlWriter.writeCharacters(prefix + ":" + ConverterUtil.convertToString(qname));
                } else
                    xmlWriter.writeCharacters(ConverterUtil.convertToString(qname));
            } else {
                xmlWriter.writeCharacters(ConverterUtil.convertToString(qname));
            }
        }

        private void writeQNames(QName[] qnames, XMLStreamWriter xmlWriter)
                throws XMLStreamException {
            if (qnames != null) {
                StringBuffer stringToWrite = new StringBuffer();
                String namespaceURI = null;
                String prefix = null;

                for (int i = 0; i < qnames.length; i++) {
                    if (i > 0) {
                        stringToWrite.append(" ");
                    }
                    namespaceURI = qnames[i].getNamespaceURI();
                    if (namespaceURI != null) {
                        prefix = xmlWriter.getPrefix(namespaceURI);
                        if ((prefix == null) || (prefix.length() == 0)) {
                            prefix = generatePrefix(namespaceURI);
                            xmlWriter.writeNamespace(prefix, namespaceURI);
                            xmlWriter.setPrefix(prefix, namespaceURI);
                        }

                        if (prefix.trim().length() > 0)
                            stringToWrite.append(prefix).append(":").append(ConverterUtil.convertToString(qnames[i]));
                        else
                            stringToWrite.append(ConverterUtil.convertToString(qnames[i]));
                    } else {
                        stringToWrite.append(ConverterUtil.convertToString(qnames[i]));
                    }
                }
                xmlWriter.writeCharacters(stringToWrite.toString());
            }
        }

        private String registerPrefix(XMLStreamWriter xmlWriter, String namespace)
                throws XMLStreamException {
            String prefix = xmlWriter.getPrefix(namespace);
            if (prefix == null) {
                prefix = generatePrefix(namespace);
                NamespaceContext nsContext = xmlWriter.getNamespaceContext();
                while (true) {
                    String uri = nsContext.getNamespaceURI(prefix);
                    if ((uri == null) || (uri.length() == 0)) {
                        break;
                    }
                    prefix = BeanUtil.getUniquePrefix();
                }
                xmlWriter.writeNamespace(prefix, namespace);
                xmlWriter.setPrefix(prefix, namespace);
            }
            return prefix;
        }

        public static class Factory {
            private static Log log = LogFactory.getLog(Factory.class);

            public static ZL_InformationServiceStub.ROOT parse(XMLStreamReader reader)
                    throws Exception {
                ZL_InformationServiceStub.ROOT object = new ZL_InformationServiceStub.ROOT();

                QName currentQName = null;
                String nillableValue = null;
                String prefix = "";
                String namespaceuri = "";
                try {
                    while ((!reader.isStartElement()) && (!reader.isEndElement())) {
                        reader.next();
                    }
                    currentQName = reader.getName();

                    nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                    if (("true".equals(nillableValue)) || ("1".equals(nillableValue))) {
                        while (!reader.isEndElement()) {
                            reader.next();
                        }
                        return object;
                    }

                    Vector handledAttributes = new Vector();

                    while (!reader.isEndElement()) {
                        if (reader.isStartElement()) {
                            if (((reader.isStartElement()) && (new QName("http://tempuri.org/", "ROOT").equals(reader.getName()))) || (new QName("", "ROOT").equals(reader.getName()))) {
                                nillableValue = reader.getAttributeValue("http://www.w3.org/2001/XMLSchema-instance", "nil");
                                if ((!"true".equals(nillableValue)) && (!"1".equals(nillableValue))) {
                                    String content = reader.getElementText();

                                    object.setROOT(
                                            ConverterUtil.convertToString(content));

                                    continue;
                                }

                                reader.getElementText();
                                continue;
                            }

                            throw new ADBException("Unexpected subelement " + reader.getName());
                        }

                        reader.next();
                    }

                } catch (XMLStreamException e) {
                    throw new Exception(e);
                }

                return object;
            }
        }
    }

    public static class ExtensionMapper {
        public static Object getTypeObject(String namespaceURI, String typeName, XMLStreamReader reader)
                throws Exception {
            throw new ADBException("Unsupported type " + namespaceURI + " " + typeName);
        }
    }
}

