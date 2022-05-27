package cn.medigical.publish.interfaces.his.hishezhouguangji.utils;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.*;
import ca.uhn.hl7v2.model.v24.datatype.ST;
import ca.uhn.hl7v2.model.v24.message.QRY_R02;
import ca.uhn.hl7v2.model.v24.segment.MSA;
import ca.uhn.hl7v2.model.v24.segment.MSH;
import ca.uhn.hl7v2.model.v24.segment.PID;
import ca.uhn.hl7v2.model.v24.segment.PV1;
import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigEventsDao;
import cn.medigical.publish.interfaces.his.hishezhouguangji.hl7.HL7Helper;
import cn.medigical.publish.interfaces.his.hishezhouguangji.hl7.UserDefineMessage;
import cn.medigical.publish.interfaces.his.hishezhouguangji.message.*;
import cn.medigical.publish.interfaces.his.hishezhouguangji.segment.*;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.dictionary.ConfigAnesMethods;
import cn.medigical.publish.pojo.dictionary.ConfigDepartments;
import cn.medigical.publish.pojo.dictionary.ConfigEvents;
import cn.medigical.publish.pojo.patient.PatientDrugs;
import cn.medigical.publish.pojo.patient.PatientEvents;
import cn.medigical.publish.pojo.patient.drug.Item;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.pojo.zjpa.patientLink.ConverToPojoUtil;
import cn.medigical.publish.utils.MyConstants;
import cn.medigical.publish.utils.MyDateFormat;
import cn.medigical.publish.utils.SpringUtils;
import cn.medigical.publish.utils.StringUtil;
import org.apache.log4j.Logger;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import cn.medigical.publish.interfaces.his.hishezhouguangji.hl7.UserDefineMessage.ASType;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MsgDealUtil {

    private static Logger logger = Logger.getLogger("MsgDealUtil");

    public static SimpleDateFormat getYmdhms() {
        return ymdhms;
    }

    public static SimpleDateFormat getYmdhmss() {
        return ymdhmss;
    }

    private static SimpleDateFormat ymdhms = new SimpleDateFormat("yyyyMMddHHmmss");
    private static SimpleDateFormat ymdhmsNormal = new SimpleDateFormat("yyyy-MM-dd/HH:mm:ss");
    private static SimpleDateFormat ymdhmss = new SimpleDateFormat("yyyyMMddHHmmss.sss");

    /**
     * 用于节点消息转换
     * @param converMessage
     * @return
     */
    private static String converMessage(String converMessage){
        return "|"+converMessage.replace("_","^")+"|";
    }

    public static List<Structure> getStructureList(AbstractMessage abstractMessage, Class<?> cls) throws HL7Exception {
        return HL7Helper.getStructureList(abstractMessage,cls);
    }

    /**
     * 用于匹配其中一个节点
     * @param converMessage
     * @return
     */
    private static String getOnePointMSG(String converMessage){
        return "|"+converMessage+"|";
    }

    /**
     * 将消息处理后传输
     * @param message
     * @return
     */
    private static String dealMessage(String message){
        StringBuilder builder = new StringBuilder();
        builder.append("%0b");
        builder.append(message);
        builder.append("%1c%0d");
        return builder.toString();
    }

    /**
     * 获取单个字段
     * @param type
     * @return
     */
    private static StringBuilder getValue(Type type) throws HL7Exception {
        return new StringBuilder(type.encode());
    }

    @SuppressWarnings("unchecked")
    public static <T extends AbstractMessage> T dealRecieveMsgFromHis(String operationMsg, Class<T> msgTypeCls) {
        ASType[] asTypes = new ASType[1];
        asTypes[0] = new ASType(msgTypeCls,true,true);
        UserDefineMessage udm;
        try {
            udm = new UserDefineMessage(asTypes);
            System.out.println("--->"+operationMsg);
            HL7Helper.acceptResponse(udm, operationMsg);
            return udm.getMsgAS(msgTypeCls);
        } catch (HL7Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解析接收到的XML消息
     * @param operationMsg
     * @return
     */
    public static String autoRecieveMsgXml(String operationMsg) {
        Document document;
        Element element = null;
        try {
            document = DocumentHelper.parseText(operationMsg);
            element = XmlParser.getRootNode(document);
        } catch (Exception e) {
            logger.error("xml decode package error");
            e.printStackTrace();
        }
        Node childApplyData = XmlParser.getChild(element,"apply_data");
        if(childApplyData == null){
            logger.error("xml decode package error");
        }else {
            String result = childApplyData.getText().trim();
            result = result.replaceFirst("%0b","");
            return result.substring(0,result.lastIndexOf("%1c%0d"));
        }
        return "";
    }

    /**
     * 解析接收到的XML消息
     * @param operationMsg
     * @return
     */
    public static String getRecieveMsgXml(String operationMsg) {
        Document document;
        Element element = null;
        try {
            document = DocumentHelper.parseText(operationMsg);
            element = XmlParser.getRootNode(document);
        } catch (Exception e) {
            logger.error("xml decode package error");
            e.printStackTrace();
        }
        Node childStat = XmlParser.getSingleNode(element,"stat");
        Node childMessage = XmlParser.getSingleNode(element,"message");
        Node childApplyData = XmlParser.getSingleNode(element,"apply_data");
        if(childStat == null || childApplyData == null || childMessage == null){
            logger.error("xml decode package error");
        }else if(Integer.parseInt(childStat.getText()) == 1){
            return childApplyData.getText().trim();
        }else{
            logger.error("xml decode package error,stat="+childStat.getText()+" message="+childMessage.getText()+" apply_data="+childApplyData.getText());
        }
        return "";
    }

    /**
     * 组成发送的XML消息
     * @param sendMsg
     * @return
     */
    private static String getSendMsgXml(String sendMsg){
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("req");
        root.addElement("apply_data").addText(sendMsg);
        OutputFormat format = OutputFormat.createCompactFormat();
        format.setEncoding("UTF-8");
        StringWriter writer = new StringWriter();
        XMLWriter output = new XMLWriter(writer, format);
        try {
            output.write(document);
            writer.close();
            output.close();
        }catch (Exception e){
            logger.error("xml Composition package error");
            e.printStackTrace();
        }
        return writer.toString();
    }

    /**
     * 所有的消息头默认设置
     * @param msh
     * @throws DataTypeException
     */
    public static void setHeader(MSH msh, String simpleName, String receiveDev, String keyCode) throws DataTypeException {
        // 分隔符
        msh.getFieldSeparator().setValue("|");
        // MSH-2
        msh.getEncodingCharacters().setValue("^~\\&");
        // MSH-7
        msh.getDateTimeOfMessage().getTimeOfAnEvent().setValue(ymdhms.format(new Date()));
        msh.getMsh11_ProcessingID().getProcessingID().setValue("P");
        msh.getMsh12_VersionID().getVersionID().setValue("2.4");
        msh.getMsh15_AcceptAcknowledgmentType().setValue("NE");
        msh.getMsh16_ApplicationAcknowledgmentType().setValue("AL");
        msh.getMsh5_ReceivingApplication().getHd2_UniversalID().setValue(keyCode);
        msh.getMsh5_ReceivingApplication().getHd1_NamespaceID().setValue(receiveDev);
        String[] simpleNameSplit = simpleName.split(Constants.SPLIT_ITEM_STRING);
        msh.getMessageType().getMsg1_MessageType().setValue(simpleNameSplit[0]);
        msh.getMessageType().getMsg2_TriggerEvent().setValue(simpleNameSplit[1]);
        msh.getMsh10_MessageControlID().setValue(simpleName+"-"+MsgDealUtil.ymdhmss.format(new Date()));
    }

    public static MSH getMSGHeader(String recieveMsg){
        ASType[] asTypes = new ASType[1];
        asTypes[0] = new ASType(MSH.class,true,true);
        UserDefineMessage udm = null;
        MSH msh = null;
        try {
            udm = new UserDefineMessage(asTypes);
            HL7Helper.acceptResponse(udm, recieveMsg);
            msh = udm.getAS(MSH.class);
        } catch (HL7Exception e) {
            e.printStackTrace();
        }
        return msh;
    }

    /****************************
     * 第7部分
     * 2.4	HIS发送手术申请信息
     * 2.5	HIS发送取消手术申请信息
     * ******************************/

    /**
     * 获取被动接收或者取消手术的手术数据
     * @param operationMsg
     * @throws HL7Exception
     */
    public static ZDM_Z01 recieveOprationFromHis(String operationMsg) throws DataTypeException {
        return dealRecieveMsgFromHis(operationMsg,ZDM_Z01.class);
    }

    /**
     * 回复消息是否获取正确
     * AA-成功，AE-失败
     * @param ack_r01
     * @return
     */
    public static String responseOprationToHis(ACK_R01 ack_r01, String receiveDev, String keyCode){
        String sendStr = null;
        MSH msh = ack_r01.getMSH();
        try {
            String simpleName = ack_r01.getClass().getSimpleName();
            setHeader(msh,simpleName,receiveDev,keyCode);
            HL7Helper.setMsgValue(ack_r01, MSA.class, msh.getMsh10_MessageControlID().getValue(), 2,0,0);
            //sendStr = dealMessage(ack_r01.encode(),simpleName,keyCode);
            sendStr = getSendMsgXml(dealMessage(URLEncoder.encode(ack_r01.encode(),"UTF-8")));
        } catch (Exception e) {
            logger.error("消息发送失败："+sendStr);
            e.printStackTrace();
        }
        return sendStr;
    }

    /****************************
     * 第7部分
     * 2.2	OAAS发送手术安排信息
     * 2.3	OAAS发送手术状态变更信息
     * ******************************/

    /**
     * 发送排班信息或者排班变更信息给His
     * @param zdm_z02
     * @throws HL7Exception
     */
    public static ACK_R01 sendOprationScheduleToHis(ZDM_Z02 zdm_z02, String receiveDev, String keyCode) {
        String sendStr = null;
        ACK_R01 ackR01 = null;
        MSH msh = zdm_z02.getMSH();
        try {
            String simpleName = zdm_z02.getClass().getSimpleName();
            setHeader(msh,simpleName,receiveDev,keyCode);
            String resultStr = removeNull(zdm_z02.encode());
            System.out.printf("--->resultStr:"+resultStr);
            sendStr = dealMessage(URLEncoder.encode(resultStr,"UTF-8"));
            String response = getRecieveMsgXml(sendMessage(getSendMsgXml(sendStr)));
            ackR01 = responseOprationScheduleBackMsg(response);
        } catch (Exception e) {
            logger.error("消息发送失败："+sendStr);
            e.printStackTrace();
        }
        return ackR01;
    }

    /**
     * 设置segment消息的值
     * @param message
     * @param segment
     * @throws HL7Exception
     */
    private static void setSegmentValue(AbstractMessage message, AbstractSegment segment, int ... ints) throws HL7Exception {
        for (int i = 1; i <= segment.getNames().length; i++) {
            Type type = segment.getField(i, 0);
            HL7Helper.setMsgValue(message, segment.getClass(), getValue(type).toString(), i, 0, 0);
        }
    }

    /**
     * 获取排班信息给His的回复
     * @param operationScheduleMsg
     * @throws HL7Exception
     */
    private static ACK_R01 responseOprationScheduleBackMsg(String operationScheduleMsg) throws Exception {
        operationScheduleMsg = URLDecoder.decode(operationScheduleMsg,StandardCharsets.UTF_8.toString());
        return dealRecieveMsgFromHis(operationScheduleMsg,ACK_R01.class);
    }

    /****************************
     * 第7部分
     * 2.1	获取指定时间范围手术申请单
     * ******************************/

    /**
     * 主动从his获取一段时间的手术信息
     * @param qry_r02
     * @throws HL7Exception
     */
    public static ZDM_Z01 getASpanOprationFromHis(QRY_R02 qry_r02, String receiveDev, String keyCode) {
        String sendStr = null;
        String response = null;
        ZDM_Z01 zdmZ01 = null;
        MSH msh = qry_r02.getMSH();
        try {
            String simpleName = qry_r02.getClass().getSimpleName();
            setHeader(msh,simpleName,receiveDev,keyCode);
            sendStr = dealMessage(URLEncoder.encode(qry_r02.encode(),"UTF-8"));
            String test = getSendMsgXml(sendStr);
            response = getRecieveMsgXml(sendMessage(getSendMsgXml(sendStr)));
            zdmZ01 = responseASpanOprationToHis(response);
        } catch (Exception e) {
            logger.error("消息发送失败："+sendStr);
            e.printStackTrace();
        }
        return zdmZ01;
    }

    /**
     * 获取一段时间手术信息的回复
     * @param aSpanOperationMsg
     * @throws HL7Exception
     */
    private static ZDM_Z01 responseASpanOprationToHis(String aSpanOperationMsg) throws Exception {
        aSpanOperationMsg = URLDecoder.decode(aSpanOperationMsg,StandardCharsets.UTF_8.toString());
        return dealRecieveMsgFromHis(aSpanOperationMsg,ZDM_Z01.class);
    }

    /****************************
     *
     * 获取病人基本信息
     * ******************************/

    /**
     * 获取病人基本信息
     * @param qryA19
     */
    public static ADR_A19 getPatientInfoFromHis(QRY_A19 qryA19, String receiveDev, String keyCode) {
        String sendStr = null;
        String response = null;
        ADR_A19 adrA19 = null;
        MSH msh = qryA19.getMSH();
        try {
            String simpleName = qryA19.getClass().getSimpleName();
            setHeader(msh,simpleName,receiveDev,keyCode);
            //此处需要加上尖括号,否则消息不对
            addSpecialSymbol(qryA19,qryA19.getQRD(),Constants.FILL_ITEM_STRING,4,0);
            String test = removeNull(qryA19.encode());
            sendStr = dealMessage(URLEncoder.encode(removeNull(qryA19.encode()),"UTF-8"));
            response = getRecieveMsgXml(sendMessage(getSendMsgXml(sendStr)));
            adrA19 = responsePatientInfoToHis(response);
        } catch (Exception e) {
            logger.error("消息发送失败："+sendStr);
            e.printStackTrace();
        }
        return adrA19;
    }

    /**
     * 此处加^只为那边能解析数据,贺州特殊,添加特殊符号
     * @param abstractMessage  QRY_A19
     * @param segment
     * @param index
     * @param rep
     * @return
     * @throws HL7Exception
     */
    private static void addSpecialSymbol(AbstractMessage abstractMessage, AbstractSegment segment, String value, int index, int rep) throws HL7Exception {
        ST st =  new ST(abstractMessage);
        st.setValue(value == null ? "":value);
        segment.getField(index,0).getExtraComponents().getComponent(rep).setData(st);
    }

    private static String removeNull(String message){
        return message.replace("^"+Constants.FILL_ITEM_STRING,"^");
    }

    /**
     * 获取一段时间手术信息的回复
     * @param patientInfo
     * @throws HL7Exception
     */
    private static ADR_A19 responsePatientInfoToHis(String patientInfo) throws UnsupportedEncodingException {
        patientInfo = URLDecoder.decode(patientInfo,StandardCharsets.UTF_8.toString());
        return dealRecieveMsgFromHis(patientInfo, ADR_A19.class);
    }

    /****************************
     * 第1部分
     * 2.1	字典查询服务
     *
     * ******************************/

    /**
     * 获取人员信息
     * 获取部门信息
     * 获取诊疗项目字典
     * 获取标本采集项目
     * 获取检验指标项目
     * 获取疾病编码字典
     * 获取收费项目字典
     * @param zdm_req
     * @throws HL7Exception
     */
    public static ZDM_RES getBaseInformationFromHis(ZDM_REQ zdm_req, String receiveDev, String keyCode) {
        String sendStr = null;
        String response = null;
        MSH msh = zdm_req.getMSH();
        ZDM_RES zdmRes = null;
        try {
            String simpleName = zdm_req.getClass().getSimpleName();
            setHeader(msh,simpleName,receiveDev,keyCode);
            sendStr = dealMessage(URLEncoder.encode(zdm_req.encode(),"UTF-8"));
            String test = getSendMsgXml(sendStr);
            response = getRecieveMsgXml(sendMessage(getSendMsgXml(sendStr)));
            zdmRes = responseBaseInformationToHis(response);
        } catch (Exception e) {
            logger.error("消息发送失败："+sendStr);
            e.printStackTrace();
        }
        return zdmRes;
    }

    /**
     * 获取人员信息回复
     * @param aSpanOperationMsg
     * @throws HL7Exception
     */
    private static ZDM_RES responseBaseInformationToHis(String aSpanOperationMsg) throws DataTypeException {
        return dealRecieveMsgFromHis(aSpanOperationMsg,ZDM_RES.class);
    }

    /****************************
     * 第1部分
     * 2.2	人员信息同步
     * 2.3	部门信息同步
     * 2.4	诊疗项目字典同步
     * 2.6	检验指标项目同步
     * 2.7	疾病编码字典同步
     * 2.8	收费项目字典同步
     * 2.9	药品字典同步
     * 2.10	卫材字典同步
     * ******************************/
    /**
     * 同步人员信息
     * @param recieveMSG
     * @throws HL7Exception
     */
    public static ZDM_RES recieveSyncFromHis(String recieveMSG) {
        return dealRecieveMsgFromHis(recieveMSG,ZDM_RES.class);
    }

    /**
     * 同步人员信息回复
     * @param ack_r01
     * @param keyCode
     * @return
     */
    public static String responseSyncToHis(ACK_R01 ack_r01,String receiveDev,String keyCode) {
        String sendStr = null;
        MSH msh = ack_r01.getMSH();
        try {
            String simpleName = ack_r01.getClass().getSimpleName();
            setHeader(msh,simpleName,receiveDev,keyCode);
            HL7Helper.setMsgValue(ack_r01, MSA.class, msh.getMsh10_MessageControlID().getValue(), 2,0,0);
            sendStr = getSendMsgXml(dealMessage(URLEncoder.encode(ack_r01.encode(),"UTF-8")));
        } catch (Exception e) {
            logger.error("消息发送失败："+sendStr);
            e.printStackTrace();
        }
        return sendStr;
    }

    /**
     * 根据患者ID和时间断查询检查数据
     * @param qryR02
     * @param receiveDev
     * @param keyCode
     * @return
     */
    public static ZDM_Z08 getLisTestFromHis(QRY_R02 qryR02, String receiveDev, String keyCode){
        String sendStr = null;
        String response = null;
        MSH msh = qryR02.getMSH();
        ZDM_Z08 zdmZ08 = null;
        try {
            String simpleName = qryR02.getClass().getSimpleName();
            setHeader(msh,simpleName,receiveDev,keyCode);
            sendStr = dealMessage(URLEncoder.encode(qryR02.encode(),"UTF-8"));
            String test = getSendMsgXml(sendStr);
            response = getRecieveMsgXml(sendMessage(getSendMsgXml(sendStr)));
            zdmZ08 = dealRecieveMsgFromHis(response,ZDM_Z08.class);
        } catch (Exception e) {
            logger.error("消息发送失败："+sendStr);
            e.printStackTrace();
        }
        return  zdmZ08;
    }

    /**
     * 根据病人ID获取最新一条Pacs信息
     * @param qryR02
     */
    public static ZDM_Z10 getPacsInfoFromHisByPid(QRY_R02 qryR02, String receiveDev, String keyCode) {
        String sendStr = null;
        String response = null;
        ZDM_Z10 zdmZ10 = null;
        MSH msh = qryR02.getMSH();
        try {
            String simpleName = qryR02.getClass().getSimpleName();
            setHeader(msh,simpleName,receiveDev,keyCode);
            //此处需要加上尖括号,否则消息不对
            addSpecialSymbol(qryR02,qryR02.getQRD(),Constants.FILL_ITEM_STRING,4,0);
            sendStr = dealMessage(URLEncoder.encode(removeNull(qryR02.encode()),"UTF-8"));
            response = getRecieveMsgXml(sendMessage(getSendMsgXml(sendStr)));
            zdmZ10 = responsePacsInfoToHis(response);
        } catch (Exception e) {
            logger.error("消息发送失败："+sendStr);
            e.printStackTrace();
        }
        return zdmZ10;
    }

    /**
     * 根据病人ID获取最新一条Pacs信息的回复
     * @param patientInfo
     * @throws HL7Exception
     */
    private static ZDM_Z10 responsePacsInfoToHis(String patientInfo) throws UnsupportedEncodingException {
        patientInfo = URLDecoder.decode(patientInfo,StandardCharsets.UTF_8.toString());
        return dealRecieveMsgFromHis(patientInfo, ZDM_Z10.class);
    }

    /**
     * 根据病人ID获取最新一条Pacs详细信息
     * @param qryR02
     */
    public static ZDM_Z11 getPacsDetailedInfoFromHisByPid(QRY_R02 qryR02, String receiveDev, String keyCode) {
        String sendStr = null;
        String response = null;
        ZDM_Z11 zdmZ11 = null;
        MSH msh = qryR02.getMSH();
        try {
            String simpleName = qryR02.getClass().getSimpleName();
            setHeader(msh,simpleName,receiveDev,keyCode);
            //此处需要加上尖括号,否则消息不对
            addSpecialSymbol(qryR02,qryR02.getQRD(),Constants.FILL_ITEM_STRING,4,0);
            sendStr = dealMessage(URLEncoder.encode(removeNull(qryR02.encode()),"UTF-8"));
            response = getRecieveMsgXml(sendMessage(getSendMsgXml(sendStr)));
            zdmZ11 = responsePacsDetailedInfoToHis(response);
        } catch (Exception e) {
            logger.error("消息发送失败："+sendStr);
            e.printStackTrace();
        }
        return zdmZ11;
    }

    /**
     * 根据病人ID获取最新一条Pacs详细信息的回复
     * @param patientInfo
     * @throws HL7Exception
     */
    private static ZDM_Z11 responsePacsDetailedInfoToHis(String patientInfo) throws UnsupportedEncodingException {
        patientInfo = URLDecoder.decode(patientInfo,StandardCharsets.UTF_8.toString());
        return dealRecieveMsgFromHis(patientInfo, ZDM_Z11.class);
    }


    /**
     * 根据病人ID获取最新一条Lis信息
     * @param qryR02
     */
    public static ZDM_Z08 getLisInfoFromHisByPid(QRY_R02 qryR02, String receiveDev, String keyCode) {
        String sendStr = null;
        String response = null;
        ZDM_Z08 zdmZ08 = null;
        MSH msh = qryR02.getMSH();
        try {
            String simpleName = qryR02.getClass().getSimpleName();
            setHeader(msh,simpleName,receiveDev,keyCode);
            //此处需要加上尖括号,否则消息不对
            addSpecialSymbol(qryR02,qryR02.getQRD(),Constants.FILL_ITEM_STRING,4,0);
            sendStr = dealMessage(URLEncoder.encode(removeNull(qryR02.encode()),"UTF-8"));
            response = getRecieveMsgXml(sendMessage(getSendMsgXml(sendStr)));
            zdmZ08 = responseLisInfoToHis(response);
        } catch (Exception e) {
            logger.error("消息发送失败："+sendStr);
            e.printStackTrace();
        }
        return zdmZ08;
    }

    /**
     * 根据病人ID获取最新一条Lis信息的回复
     * @param patientInfo
     * @throws HL7Exception
     */
    private static ZDM_Z08 responseLisInfoToHis(String patientInfo) throws UnsupportedEncodingException {
        patientInfo = URLDecoder.decode(patientInfo,StandardCharsets.UTF_8.toString());
        return dealRecieveMsgFromHis(patientInfo, ZDM_Z08.class);
    }

    /**
     * 根据病人ID获取最新一条Lis信息
     * @param qryR02
     */
    public static ZDM_Z09 getDetailLisInfoFromHisByPid(QRY_R02 qryR02, String receiveDev, String keyCode) {
        String sendStr = null;
        String response = null;
        ZDM_Z09 zdmZ09 = null;
        MSH msh = qryR02.getMSH();
        try {
            String simpleName = qryR02.getClass().getSimpleName();
            setHeader(msh,simpleName,receiveDev,keyCode);
            //此处需要加上尖括号,否则消息不对
            addSpecialSymbol(qryR02,qryR02.getQRD(),Constants.FILL_ITEM_STRING,4,0);
            sendStr = dealMessage(URLEncoder.encode(removeNull(qryR02.encode()),"UTF-8"));
            response = getRecieveMsgXml(sendMessage(getSendMsgXml(sendStr)));
            zdmZ09 = responseDetailLisInfoToHis(response);
        } catch (Exception e) {
            System.out.println("--->消息发送失败："+sendStr);
            e.printStackTrace();
        }
        return zdmZ09;
    }

    /**
     * 根据病人ID获取最新一条Lis信息的回复
     * @param patientInfo
     * @throws HL7Exception
     */
    private static ZDM_Z09 responseDetailLisInfoToHis(String patientInfo) throws UnsupportedEncodingException {
        patientInfo = URLDecoder.decode(patientInfo,StandardCharsets.UTF_8.toString());
        return dealRecieveMsgFromHis(patientInfo, ZDM_Z09.class);
    }

    /**
     * 发送消息
     * @param sendMsg
     * @return
     * @throws Exception
     */
    private static String sendMessage(String sendMsg) throws IOException {
        URL wsUrl;
        InputStream is = null;
        OutputStream os = null;
        HttpURLConnection conn = null;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            wsUrl = new URL(Constants.HOST_REMOTE_HEZHOUGUANGJISERVER);
            conn = (HttpURLConnection) wsUrl.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "text/xml;charset=UTF-8");
            os = conn.getOutputStream();
            os.write(sendMsg.getBytes());
            is = conn.getInputStream();
            byte[] b = new byte[1024];
            int len;
            while((len = is.read(b)) != -1){
                outputStream.write(b,0,len);
            }
        } catch (Exception e) {
            logger.error("返回消息失败："+sendMsg);
            e.printStackTrace();
        }finally {
            if(is != null){
                is.close();
            }
            if(os != null){
                os.close();
            }
            if(conn != null){
                conn.disconnect();
            }
        }
        String result = outputStream.toString();
        outputStream.close();
        System.out.println("---result"+outputStream.toString());
        return result;
    }

    public static void setZ01(AbstractMessage zdmZ02, Z01 z01, PatientLink patientLink) throws HL7Exception {

        z01.getOperativeFlowNumber().setValue(StringUtil.nullToSpace(patientLink.getApplication().getSssqdh()));
        //暂定手术申请编号
        z01.getOperationCode().setValue(StringUtil.nullToSpace(patientLink.getApplication().getSssqdh()));
        z01.getNameOfOperation().setValue(StringUtil.nullToSpace(patientLink.getApplication().getNsssmc()));
        z01.getSurgicalGrade().setValue(StringUtil.nullToSpace(patientLink.getApplication().getOperLevel()));
        z01.getSurgicalMarkers().setValue(StringUtil.nullToSpace(patientLink.getApplication().getType()));
        //执行状态
        z01.getStatusOfApplicationForOperation().setValue(StringUtil.nullToSpace(patientLink.getApplication().getOperStatu()));
        z01.getPatientIdentificationList().getID().setValue(StringUtil.nullToSpace(patientLink.getPatient().getPatId()));
        //主页ID
        z01.getPatientIdentificationList().getCheckDigit().setValue("");
        z01.getPatientIdentificationList().getCodeIdentifyingTheCheckDigitSchemeEmployed().setValue(StringUtil.nullToSpace(patientLink.getPatient().getKsbh()));
        z01.getPatientIdentificationList().getAssigningAuthority().getHd1_NamespaceID().setValue(StringUtil.nullToSpace(patientLink.getPatient().getZych()));
        if(patientLink.getApplication().getSssqsj() != null) {
            z01.getDateAndTimeOfOperation().getTimeOfAnEvent().setValue(ymdhms.format(patientLink.getApplication().getSssqsj()));
        }
        z01.getOperationRoom().getIdentifier().setValue(StringUtil.nullToSpace(patientLink.getApplication().getOperDeptCode()));
        z01.getOperationRoom().getCe2_Text().setValue(StringUtil.nullToSpace(patientLink.getApplication().getOperDeptName()));
        if(patientLink.getSchedule().getPbssjh() != null) {
            z01.getOperatingRoom().setValue(StringUtil.nullToSpace(patientLink.getSchedule().getPbssjh()));
        }
        //addSpecialSymbol(zdmZ02,z01,"手术间 "+patientLink.getSchedule().getPbssjh(),10,0);
        z01.getTableNumber().getQuantity().getCq1_Quantity().setValue(StringUtil.nullToSpace(patientLink.getSchedule().getPbts()));
        //隔离标志
        z01.getIsolationMark().setValue("");
        z01.getOperatingDepartments().getPointOfCare().setValue(StringUtil.nullToSpace(patientLink.getApplication().getSqksbh()));
        z01.getOperatingDepartments().getPl2_Room().setValue(StringUtil.nullToSpace(patientLink.getApplication().getSqksmc()));
        z01.getSurgeon().getIDNumber().setValue(StringUtil.nullToSpace(getCodeWorkIDById(patientLink.getAnesthesiaRecord().getOperDoctor1())));
        z01.getSurgeon().getFamilyName().getSurname().setValue(StringUtil.nullToSpace(getNameById(patientLink.getAnesthesiaRecord().getOperDoctor1())));
        z01.getFirstOperativeAssistant().getIDNumber().setValue(StringUtil.nullToSpace(getCodeWorkIDById(patientLink.getSchedule().getZlysbh1())));
        z01.getFirstOperativeAssistant().getFamilyName().getSurname().setValue(StringUtil.nullToSpace(getNameById(patientLink.getSchedule().getZlysbh1())));
        z01.getSecondOperativeAssistant().getIDNumber().setValue(StringUtil.nullToSpace(getCodeWorkIDById(patientLink.getSchedule().getZlysbh2())));
        z01.getSecondOperativeAssistant().getFamilyName().getSurname().setValue(StringUtil.nullToSpace(getNameById(patientLink.getSchedule().getZlysbh2())));
        z01.getThirdOperativeAssistant().getIDNumber().setValue(StringUtil.nullToSpace(getCodeWorkIDById(patientLink.getSchedule().getZlysbh3())));
        z01.getThirdOperativeAssistant().getFamilyName().getSurname().setValue(StringUtil.nullToSpace(getNameById(patientLink.getSchedule().getZlysbh3())));
        z01.getFourthOperativeAssistant().getIDNumber().setValue(StringUtil.nullToSpace(getCodeWorkIDById(patientLink.getSchedule().getZlysbh4())));
        z01.getThirdOperativeAssistant().getFamilyName().getSurname().setValue(StringUtil.nullToSpace(getNameById(patientLink.getSchedule().getZlysbh4())));
        z01.getAnesthesiaMethod().setValue(StringUtil.nullToSpace(patientLink.getAnesthesiaRecord().getMzff()));
        String mzff = patientLink.getAnesthesiaRecord().getMzff();
        addSpecialSymbol(zdmZ02,z01,StringUtil.isEmpty(mzff)?Constants.FILL_ITEM_STRING:mzff,19,0);
        z01.getAnesthesiologist().getIDNumber().setValue(StringUtil.nullToSpace(getCodeWorkIDById(patientLink.getSchedule().getMzysbh1())));
        z01.getAnesthesiologist().getFamilyName().getSurname().setValue(StringUtil.nullToSpace(patientLink.getSchedule().getMzysbh1Name()));
        z01.getAnesthesiologist2().getIDNumber().setValue(StringUtil.nullToSpace(getCodeWorkIDById(patientLink.getSchedule().getMzysbh2())));
        z01.getAnesthesiologist2().getFamilyName().getSurname().setValue(StringUtil.nullToSpace(patientLink.getSchedule().getMzysbh2Name()));
        z01.getAnesthesiologist3().getIDNumber().setValue(StringUtil.nullToSpace(getCodeWorkIDById(patientLink.getSchedule().getMzysbh3())));
        z01.getAnesthesiologist3().getFamilyName().getSurname().setValue(StringUtil.nullToSpace(patientLink.getSchedule().getMzysbh3Name()));
        z01.getAnesthesiaAssistant().getIDNumber().setValue(StringUtil.nullToSpace(getCodeWorkIDById(patientLink.getAnesthesiaRecord().getFmys1())));
        z01.getAnesthesiaAssistant().getFamilyName().getSurname().setValue(StringUtil.nullToSpace(getNameById(patientLink.getAnesthesiaRecord().getFmys1())));
        z01.getAnesthesiaAssistant2().getIDNumber().setValue(StringUtil.nullToSpace(getCodeWorkIDById(patientLink.getAnesthesiaRecord().getFmys2())));
        z01.getAnesthesiaAssistant2().getFamilyName().getSurname().setValue(StringUtil.nullToSpace(getNameById(patientLink.getAnesthesiaRecord().getFmys2())));
        z01.getAnesthesiaAssistant3().getIDNumber().setValue(StringUtil.nullToSpace(getCodeWorkIDById(patientLink.getAnesthesiaRecord().getFmys3())));
        z01.getAnesthesiaAssistant3().getFamilyName().getSurname().setValue(StringUtil.nullToSpace(getNameById(patientLink.getAnesthesiaRecord().getFmys3())));
        z01.getAnesthesiaAssistant4().getIDNumber().setValue(StringUtil.nullToSpace(getCodeWorkIDById(patientLink.getAnesthesiaRecord().getFmys4())));
        z01.getAnesthesiaAssistant4().getFamilyName().getSurname().setValue(StringUtil.nullToSpace(getNameById(patientLink.getAnesthesiaRecord().getFmys4())));
        //输血者
        z01.getBloodDonator().getIDNumber().setValue("");
        z01.getBloodDonator().getFamilyName().getSurname().setValue(StringUtil.nullToSpace(patientLink.getAnesthesiaRecord().getBloodDonator()));
        z01.getFirstNurseOnBoard().getIDNumber().setValue(StringUtil.nullToSpace(getCodeWorkIDById(patientLink.getAnesthesiaRecord().getXshs1())));
        z01.getFirstNurseOnBoard().getFamilyName().getSurname().setValue(StringUtil.nullToSpace(getNameById(patientLink.getAnesthesiaRecord().getXshs1())));
        z01.getSecondNurseOnBoard().getIDNumber().setValue(StringUtil.nullToSpace(getCodeWorkIDById(patientLink.getAnesthesiaRecord().getXshs2())));
        z01.getSecondNurseOnBoard().getFamilyName().getSurname().setValue(StringUtil.nullToSpace(getNameById(patientLink.getAnesthesiaRecord().getXshs2())));
        z01.getFirstSupplyNurse().getIDNumber().setValue(StringUtil.nullToSpace(getCodeWorkIDById(patientLink.getSchedule().getXhhsbh1())));
        z01.getFirstSupplyNurse().getFamilyName().getSurname().setValue(StringUtil.nullToSpace(patientLink.getSchedule().getXhhsbh1Name()));
        z01.getSecondSupplyNurse().getIDNumber().setValue(StringUtil.nullToSpace(getCodeWorkIDById(patientLink.getSchedule().getXhhsbh2())));
        z01.getSecondSupplyNurse().getFamilyName().getSurname().setValue(StringUtil.nullToSpace(getNameById(patientLink.getSchedule().getXhhsbh2())));
        z01.getThirdSupplyNurse().getIDNumber().setValue(StringUtil.nullToSpace(getCodeWorkIDById(patientLink.getSchedule().getXhhsbh3())));
        z01.getThirdSupplyNurse().getFamilyName().getSurname().setValue(StringUtil.nullToSpace(getNameById(patientLink.getSchedule().getXhhsbh3())));
        //医生嘱托
        StringBuffer buffer = new StringBuffer();
        buffer.append("麻醉开始时间:");
        if(patientLink.getStatus().getMazuiStartTime() != null) {
            buffer.append(ymdhmsNormal.format(patientLink.getStatus().getMazuiStartTime())).append(",");
        }else{
            buffer.append(",");
        }
        buffer.append("麻醉结束时间:");
        if(patientLink.getStatus().getMazuiEndTime() != null) {
            buffer.append(ymdhmsNormal.format(patientLink.getStatus().getMazuiEndTime())).append(",");
        }else{
            buffer.append(",");
        }
        buffer.append("手术开始时间:");
        if(patientLink.getStatus().getOperStartTime() != null) {
            buffer.append(ymdhmsNormal.format(patientLink.getStatus().getOperStartTime())).append(",");
        }else{
            buffer.append(",");
        }
        buffer.append("手术结束时间:");
        if(patientLink.getStatus().getOperEndTime() != null) {
            buffer.append(ymdhmsNormal.format(patientLink.getStatus().getOperEndTime())).append(",");
        }else{
            buffer.append(",");
        }
        buffer.append("RBC:");
        buffer.append(patientLink.getAnesthesiaRecord().getLiquidInAndOut().getRbc()).append(",");
        buffer.append("血浆:");
        buffer.append(patientLink.getAnesthesiaRecord().getLiquidInAndOut().getXueJiang()).append(",");
        buffer.append("胶体液:");
        buffer.append(patientLink.getAnesthesiaRecord().getLiquidInAndOut().getJiaoTiYe()).append(",");
        buffer.append("晶体液:");
        buffer.append(patientLink.getAnesthesiaRecord().getLiquidInAndOut().getJingTiYe()).append(",");
        buffer.append("总输入量:");
        buffer.append(patientLink.getAnesthesiaRecord().getLiquidInAndOut().getZongShuRuLiang()).append(",");
        buffer.append("出血量:");
        buffer.append(patientLink.getAnesthesiaRecord().getLiquidInAndOut().getChuXueLiang()).append(",");
        buffer.append("尿量:");
        buffer.append(patientLink.getAnesthesiaRecord().getLiquidInAndOut().getNiaoLiang());
        z01.getRemarks().setValue(StringUtil.nullToSpace(buffer.toString()));
        //开嘱时间
        z01.getDateAndTimeOfApplication().getTs1_TimeOfAnEvent().setValue("");
        //修改者编号
        z01.getInputer().getIDNumber().setValue("");
        z01.getInputer().getFamilyName().getSurname().setValue("");
        z01.getPreoperativeDiagnosis().getIDNumber().setValue(StringUtil.nullToSpace(getCodeWorkIDById(patientLink.getApplication().getSqzd1())));
        //手术路径
        z01.getOperativePath().getIDNumber().setValue("");
    }

    private static String getCodeWorkIDById(String id){
        Account account = SpringUtils.getBean(AccountDao.class).findAccountById(id);
        if(account == null) {
            return "";
        }else {
            return account.getWorkID();
        }
    }

    private static String getEventNameByCode(String code){
        ConfigEvents configEvents = SpringUtils.getBean(ConfigEventsDao.class).getIsCode(code);
        if(configEvents == null) {
            return "";
        }else {
            return configEvents.getName();
        }
    }

    private static String getNameById(String id){
        Account account = SpringUtils.getBean(AccountDao.class).findAccountById(id);
        if(account == null) {
            return "";
        }else {
            return account.getTrueName();
        }
    }

    public static PatientLink getZ01(AbstractMessage zdmZ02, Z01 z01, PatientLink patientLink) throws HL7Exception {
        //手术申请单号
        patientLink.getApplication().setSssqdh(StringUtil.nullToSpace(z01.getOperativeFlowNumber().getValue()));
        //拟施手术名称
        patientLink.getApplication().setNsssmc(StringUtil.nullToSpace(z01.getNameOfOperation().getValue()));
        //手术等级
        patientLink.getApplication().setOperLevel(StringUtil.nullToSpace(z01.getSurgicalGrade().getValue()));
        //术类型 急诊，择期
        patientLink.getApplication().setType(StringUtil.nullToSpace(z01.getSurgicalMarkers().getValue()));
        //手术申请状态 IP-已申请未执行,CA-拒绝执行,SC-正在执行,CM-完全执行
        patientLink.getApplication().setOperStatu(StringUtil.nullToSpace(z01.getStatusOfApplicationForOperation().getValue()));
        //病人ID
        patientLink.getPatient().setPatId(StringUtil.nullToSpace(z01.getPatientIdentificationList().getID().getValue()));
        //科室编码
        patientLink.getPatient().setKsbh(StringUtil.nullToSpace(z01.getOperatingDepartments().getPointOfCare().getValue()));
        //科室名称
        patientLink.getPatient().setKsmc(StringUtil.nullToSpace(z01.getOperatingDepartments().getRoom().getValue()));
        //住院床号
        patientLink.getPatient().setZych(StringUtil.nullToSpace(z01.getPatientIdentificationList().getAssigningAuthority().getHd1_NamespaceID().getValue()));
        try {
            //手术日期
            if(z01.getDateAndTimeOfOperation().getTimeOfAnEvent().getValue() != null) {
                patientLink.getApplication().setYysssj(MyDateFormat.DATE_FORMAT_YMDHMl.parse(z01.getDateAndTimeOfOperation().getTimeOfAnEvent().getValue()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //执行手术科室编码
        patientLink.getApplication().setOperDeptCode(StringUtil.nullToSpace(z01.getOperationRoom().getIdentifier().getValue()));
        //执行手术科室名称
        patientLink.getApplication().setOperDeptName(StringUtil.nullToSpace(z01.getOperationRoom().getCe2_Text().getValue()));
        //排班手术间号
        patientLink.getSchedule().setPbssjh(StringUtil.nullToSpace(z01.getOperatingRoom().getValue()));
        //排班手术间台数
        patientLink.getSchedule().setPbts(StringUtil.nullToSpace(z01.getTableNumber().getQuantity().getCq1_Quantity().getValue()));
        //申请科室编号
        patientLink.getApplication().setSqksbh(StringUtil.nullToSpace(z01.getOperatingDepartments().getPointOfCare().getValue()));
        //申请科室名称
        patientLink.getApplication().setSqksmc(StringUtil.nullToSpace(z01.getOperatingDepartments().getPl2_Room().getValue()));
        //主刀医生
        patientLink.getAnesthesiaRecord().setOperDoctor1(StringUtil.nullToSpace(z01.getSurgeon().getIDNumber().getValue()));
        //助理医师编号1
        patientLink.getSchedule().setZlysbh1(StringUtil.nullToSpace(z01.getFirstOperativeAssistant().getIDNumber().getValue()));
        //助理医师编号2
        patientLink.getSchedule().setZlysbh2(StringUtil.nullToSpace(z01.getSecondOperativeAssistant().getIDNumber().getValue()));
        //助理医师编号3
        patientLink.getSchedule().setZlysbh3(StringUtil.nullToSpace(z01.getThirdOperativeAssistant().getIDNumber().getValue()));
        //助理医师编号4
        patientLink.getSchedule().setZlysbh4(StringUtil.nullToSpace(z01.getFourthOperativeAssistant().getIDNumber().getValue()));
        //麻醉方法
        patientLink.getAnesthesiaRecord().setMzff(StringUtil.nullToSpace(z01.getAnesthesiaMethod().getValue()));
        //麻醉医师编号1
        patientLink.getSchedule().setMzysbh1(StringUtil.nullToSpace(z01.getAnesthesiologist().getIDNumber().getValue()));
        //麻醉医师1名称
        patientLink.getSchedule().setMzysbh1Name(StringUtil.nullToSpace(z01.getAnesthesiologist().getFamilyName().getSurname().getValue()));
        //麻醉医师编号2
        patientLink.getSchedule().setMzysbh2(StringUtil.nullToSpace(z01.getAnesthesiologist2().getIDNumber().getValue()));
        //麻醉医师2名称
        patientLink.getSchedule().setMzysbh2Name(StringUtil.nullToSpace(z01.getAnesthesiologist2().getFamilyName().getSurname().getValue()));
        //麻醉医师编号3
        patientLink.getSchedule().setMzysbh3(StringUtil.nullToSpace(z01.getAnesthesiologist3().getIDNumber().getValue()));
        //麻醉医师3名称
        patientLink.getSchedule().setMzysbh3Name(StringUtil.nullToSpace(z01.getAnesthesiologist3().getFamilyName().getSurname().getValue()));
        //副麻医师1编号
        patientLink.getAnesthesiaRecord().setFmys1(StringUtil.nullToSpace(z01.getAnesthesiaAssistant().getIDNumber().getValue()));
        //副麻医师2编号
        patientLink.getAnesthesiaRecord().setFmys2(StringUtil.nullToSpace(z01.getAnesthesiaAssistant2().getIDNumber().getValue()));
        //副麻医师3编号
        patientLink.getAnesthesiaRecord().setFmys3(StringUtil.nullToSpace(z01.getAnesthesiaAssistant3().getIDNumber().getValue()));
        //副麻医师4编号
        patientLink.getAnesthesiaRecord().setFmys4(StringUtil.nullToSpace(z01.getAnesthesiaAssistant4().getIDNumber().getValue()));
        //输血者
        patientLink.getAnesthesiaRecord().setBloodDonator(StringUtil.nullToSpace(z01.getBloodDonator().getFamilyName().getSurname().getValue()));
        //洗手护士1编号
        patientLink.getAnesthesiaRecord().setXshs1(StringUtil.nullToSpace(z01.getFirstNurseOnBoard().getIDNumber().getValue()));
        //洗手护士2编号
        patientLink.getAnesthesiaRecord().setXshs2(StringUtil.nullToSpace(z01.getSecondNurseOnBoard().getIDNumber().getValue()));
        //巡回护士1编号
        patientLink.getSchedule().setXhhsbh1(StringUtil.nullToSpace(z01.getFirstSupplyNurse().getIDNumber().getValue()));
        //巡回护士2编号
        patientLink.getSchedule().setXhhsbh2(StringUtil.nullToSpace(z01.getSecondSupplyNurse().getIDNumber().getValue()));
        //巡回护士3编号
        patientLink.getSchedule().setXhhsbh3(StringUtil.nullToSpace(z01.getThirdSupplyNurse().getIDNumber().getValue()));
        //术前诊断1
        patientLink.getApplication().setSqzd1(StringUtil.nullToSpace(z01.getPreoperativeDiagnosis().getIDNumber().getValue()));
        //手术申请日期
        try {
            if(z01.getDateAndTimeOfApplication().getTimeOfAnEvent().getValue() != null) {
                patientLink.getApplication().setSssqsj(MyDateFormat.DATE_FORMAT_YMDHMl.parse(z01.getDateAndTimeOfApplication().getTimeOfAnEvent().getValue()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return patientLink;
    }

    public static PatientLink getZ02(AbstractMessage zdmZ02, Z02 z02, PatientLink patientLink) throws HL7Exception {
        //拟施手术名称
        patientLink.getApplication().setNsssmc(StringUtil.nullToSpace(z02.getNameOfSecondaryOperation().getValue()));
        return patientLink;
    }

    public static PatientLink getPID(AbstractMessage zdmZ02, PID pid, PatientLink patientLink) throws HL7Exception {
        //病人ID
        patientLink.getPatient().setPatId(StringUtil.nullToSpace(pid.getPatientID().getID().getValue()));
        if(pid.getPatientName().length>0) {
            //病人姓名
            patientLink.getPatient().setBrxm(StringUtil.nullToSpace(pid.getPatientName()[0].getFamilyName().getFn1_Surname().getValue()));
        }
        if(pid.getAlternatePatientIDPID().length>0) {
            Date now = new Date();
            String strAge = StringUtil.nullToSpace(pid.getAlternatePatientIDPID()[0].getID().getValue());
            if (strAge.contains("岁") || strAge.contains("月") || strAge.contains("天")) {
                //病人年龄
                patientLink.getPatient().setNl(strAge);// 年龄
                if (strAge.contains("岁")) {
                    try {
                        //病人年龄单位
                        patientLink.getPatient().setNldw(MyConstants.AGE_UNIT_YEAR);// 年龄单位
                        Integer numAge = Integer.parseInt(strAge.substring(0, strAge.indexOf("岁")));
                        //年龄数值
                        patientLink.getPatient().setNumAge(numAge);
                        now.setYear(now.getYear() - numAge);
                        //出生日期
                        patientLink.getPatient().setDob(now);
                    } catch (Exception e) {
                        patientLink.getPatient().setNumAge(0);
                    }
                } else {
                    patientLink.getPatient().setNumAge(0);
                }
            } else {
                patientLink.getPatient().setNl(strAge + "岁");// 年龄
                try {
                    Integer numAge = Integer.parseInt(strAge.trim());
                    patientLink.getPatient().setNumAge(numAge);
                    patientLink.getPatient().setNldw(MyConstants.AGE_UNIT_YEAR);// 年龄单位
                    now.setYear(now.getYear() - numAge);
                    patientLink.getPatient().setDob(now);
                } catch (Exception e) {
                }
            }
        }
        if(pid.getPatientIdentifierList().length>0) {
            //病人住院号
            patientLink.getPatient().setZyh(StringUtil.nullToSpace(pid.getPatientIdentifierList()[0].getCodeIdentifyingTheCheckDigitSchemeEmployed().getValue()));
        }
        //病人出生日期
        patientLink.getPatient().setDob(pid.getDateTimeOfBirth().getTimeOfAnEvent().getValueAsDate());
        //性别
        String sex = StringUtil.nullToSpace(pid.getAdministrativeSex().getValue());
        if("M".equals(sex)){
            patientLink.getPatient().setXb(MyConstants.MALE);
        }else if("F".equals(sex)){
            patientLink.getPatient().setXb(MyConstants.FEMALE);
        }else if("A".equals(sex)){
            patientLink.getPatient().setXb("未说明的性别");
        }else{
            patientLink.getPatient().setXb("未知");
        }
        return patientLink;
    }

    public static PatientLink getPV1(AbstractMessage zdmZ02, PV1 pv1, PatientLink patientLink) throws HL7Exception {
        //病区编码
        patientLink.getPatient().setBqbh(StringUtil.nullToSpace(pv1.getAssignedPatientLocation().getRoom().getValue()));

        //科室编码
        patientLink.getPatient().setKsbh(StringUtil.nullToSpace(pv1.getAssignedPatientLocation().getPointOfCare().getValue()));
        //科室名称
        patientLink.getPatient().setKsmc(StringUtil.nullToSpace(pv1.getAssignedPatientLocation().getLocationStatus().getValue()));
        //住院床号
        patientLink.getPatient().setZych(StringUtil.nullToSpace(pv1.getAssignedPatientLocation().getBed().getValue()));
        //身高、体重、血型
        String value = StringUtil.nullToSpace(pv1.getDietType().getIdentifier().getValue());
        if(!StringUtil.isEmpty(value)){
            String[] values = value.split("_");
            if(values.length>=1) {
                patientLink.getPatient().setSg(values[0]);
            }
            if(values.length>=2) {
                patientLink.getPatient().setTz(values[1]);
            }
            if(values.length>=3) {
                patientLink.getPatient().setXx(values[2]);
            }
        }
        //术前诊断
        if(pv1.getDischargeDateTime(0) != null) {
            patientLink.getApplication().setSqzd1(StringUtil.nullToSpace(pv1.getDischargeDateTime(0).getTs1_TimeOfAnEvent().getValue()));
        }
        return patientLink;
    }

    public static ConfigDepartments getZD1(AbstractMessage zdmZ02, ZD1 zd1, ConfigDepartments departments) {
        departments.setId(StringUtil.nullToSpace(zd1.getItemId().getValue()));
        departments.setCode(StringUtil.nullToSpace(zd1.getItemNo().getValue()));
        departments.setName(StringUtil.nullToSpace(zd1.getItemName().getValue()));
        departments.setDeleted(false);
        return departments;
    }

    public static Account getZD1(AbstractMessage zdmZ02, ZD1 zd1, Account account) {
        //职工科室编号
        account.setOfficeID(trimStr(zd1.getItemNo().getValue()));
        account.setNeiBuId(trimStr(zd1.getItemNo().getValue()));
        account.setWorkID(trimStr(zd1.getItemNo().getValue()));
        account.setHisID(trimStr(zd1.getItemNo().getValue()));
        account.setLoginName(trimStr(zd1.getItemNo().getValue()));
        account.setPwd(AccountDao.generatePassword(trimStr(zd1.getItemNo().getValue())));
        account.setTrueName(trimStr(zd1.getItemName().getValue()));
        account.setCreateTime(new Date());
        account.setLastUpdateTime(new Date());
        return account;
    }

    public static Account getZD2(AbstractMessage zdmZ02, ZD2 zd2, Account account) {
        account.setGender(trimStr(zd2.getStaffSex().getValue()));
        //职工科室名称
        account.setOfficeName(trimStr(zd2.getDeptName().getValue()));

        account.setDob(ConverToPojoUtil.parseDate(trimStr(zd2.getBirthDate().getValue())));
        String zgzw = zd2.getJobTitle().getValue();
        if (null != zgzw) {
            if (!zgzw.contains("护师") && (zgzw.contains("主任") || zgzw.contains("医师") || zgzw.contains("医生") || zgzw.contains("教授") || zgzw.contains("医士"))) {
                if (zd2.getDeptNo().getValue().equalsIgnoreCase(Constants.MAZUIDOCDEPTCODE)) {
                    account.setRole(MyConstants.MAZUI_DOCTOR);
                } else {
                    account.setRole(MyConstants.DOCTOR);
                }
            } else if (zgzw.contains("护士") || zgzw.contains("护理") || zgzw.contains("护师")) {
                account.setRole(MyConstants.HUSHI);
            } else {
                account.setRole(MyConstants.OTHER_STUFF);
                account.setCanLogin(false);
            }
            account.setTitle(zgzw);
        }
        account.setStatus("valid");
        account.setPhone(trimStr(zd2.getMobile().getValue()));
        account.setOrLevel(trimStr(zd2.getManagerPost().getValue()));
        account.setSchoolLevel(zd2.getEducation().getValue());
        account.setCanLogin(true);
        return account;
    }

    public static String trimStr(String str) {
        if (null == str) {
            return "";
        }
        return str.trim();
    }

    /****************************
     * 第7部分
     * 2.8	手术麻醉系统的麻醉方式基础信息回传给CIS系统。
     *
     * ******************************/

    public static ACK_R01 sendAnesthesiaMethodInformation(ZDM_Z24 zdmReq, String receiveDev, String keyCode){
        String response;
        String sendStr = null;
        ACK_R01 ack_r01 = null;
        MSH msh = zdmReq.getMSH();
        try {
            String simpleName = zdmReq.getClass().getSimpleName();
            setHeader(msh,simpleName,receiveDev,keyCode);
            sendStr = dealMessage(URLEncoder.encode(zdmReq.encode(),"UTF-8"));
            response = getRecieveMsgXml(sendMessage(getSendMsgXml(sendStr)));
            ack_r01 = recieveAnesMethodInfoBackMsg(response);
        } catch (Exception e) {
            logger.error("消息发送失败："+sendStr);
            e.printStackTrace();
        }
        return ack_r01;
    }

    /**
     * 接收发送麻醉方法基本信息his返回的数据
     * @param responseSucces
     * @throws HL7Exception
     */
    private static ACK_R01 recieveAnesMethodInfoBackMsg(String responseSucces) throws UnsupportedEncodingException {
        responseSucces = URLDecoder.decode(responseSucces,StandardCharsets.UTF_8.toString());
        return dealRecieveMsgFromHis(responseSucces, ACK_R01.class);
    }

    public static void setMZ01(ZDM_Z24 zdm_z24, MZ01 mz01, ConfigAnesMethods anesMethods) throws DataTypeException {
        mz01.getCoding().setValue(StringUtil.nullToSpace(anesMethods.getCode()));
        mz01.getAnesthesia().setValue(StringUtil.nullToSpace(anesMethods.getName()));
        mz01.getPinyinCode().setValue("");
        mz01.getCustomCode().setValue(StringUtil.nullToSpace(anesMethods.getId()));
        mz01.getAnesthesiaType().setValue(StringUtil.nullToSpace(anesMethods.getGroupCode()));
        mz01.getDisplayOrder().setValue("");
        mz01.getDefaultFlag().setValue("");
        mz01.getCreateTime().setValue("");
        mz01.getUpdateTime().setValue("");
        mz01.getRecordStatus().setValue(StringUtil.nullToSpace(anesMethods.getDeleted()));

    }

    /****************************
     * 第7部分
     * 2.7	手术麻醉系统的手术间基础信息回传给CIS系统。
     *
     * ******************************/

    public static ACK_R01 sendOperationRoomInformation(ZDM_Z23 zdmReq, String receiveDev, String keyCode){
        String response;
        String sendStr = null;
        ACK_R01 ack_r01 = null;
        MSH msh = zdmReq.getMSH();
        try {
            String simpleName = zdmReq.getClass().getSimpleName();
            setHeader(msh,simpleName,receiveDev,keyCode);
            sendStr = dealMessage(URLEncoder.encode(zdmReq.encode(),"UTF-8"));
            response = getRecieveMsgXml(sendMessage(getSendMsgXml(sendStr)));
            ack_r01 = recieveOperRoomInfoBackMsg(response);
        } catch (Exception e) {
            logger.error("消息发送失败："+sendStr);
            e.printStackTrace();
        }
        return ack_r01;
    }

    /**
     * 接收发送手术室基本信息信息his返回的数据
     * @param responseSucces
     * @throws HL7Exception
     */
    private static ACK_R01 recieveOperRoomInfoBackMsg(String responseSucces) throws UnsupportedEncodingException {
        responseSucces = URLDecoder.decode(responseSucces, StandardCharsets.UTF_8.toString());
        return dealRecieveMsgFromHis(responseSucces, ACK_R01.class);
    }

    public static void setSJ01(ZDM_Z23 zdm_z23, SJ01 sj01,PatientLink patientLink) throws DataTypeException {
        sj01.getCoding().setValue("1");
        sj01.getOperatingRoom().setValue("2");
        sj01.getPinyinCode().setValue("3");
        sj01.getCustomCode().setValue("4");
        sj01.getOperatingDept().setValue("5");
        sj01.getDisplayOrder().setValue("6");
        sj01.getCreateTime().setValue("7");
        sj01.getUpdateTime().setValue("8");
        sj01.getRecordStatus().setValue("9");

    }

    /****************************
     * 第7部分
     * 2.6	手术室在做好手术后，将手术麻醉相关信息回传给CIS系统。
     *
     * ******************************/

    public static ACK_R01 sendOperationInformation(ZDM_Z22 zdm_req, String receiveDev, String keyCode){
        String sendStr = null;
        String response;
        MSH msh = zdm_req.getMSH();
        ACK_R01 ack_r01 = null;
        try {
            String simpleName = zdm_req.getClass().getSimpleName();
            setHeader(msh,simpleName,receiveDev,keyCode);
            sendStr = dealMessage(URLEncoder.encode(removeNull(zdm_req.encode()),"UTF-8"));
            response = getRecieveMsgXml(sendMessage(getSendMsgXml(sendStr)));
            System.out.println("--->:response"+response);
            ack_r01 = recieveOperInfoBackMsg(response);
        } catch (Exception e) {
            logger.error("消息发送失败："+sendStr);
            e.printStackTrace();
        }
        return ack_r01;
    }

    /**
     * 接收发送手术信息his返回的数据
     * @param responseSucces
     * @throws HL7Exception
     */
    private static ACK_R01 recieveOperInfoBackMsg(String responseSucces) throws UnsupportedEncodingException {
        responseSucces = URLDecoder.decode(responseSucces,StandardCharsets.UTF_8.toString());
        return dealRecieveMsgFromHis(responseSucces, ACK_R01.class);
    }

    public static void setZM01(ZDM_Z22 zdmZ22, ZM01 zm01,PatientLink patientLink) throws HL7Exception {
        zm01.getSurgerySerialNumber().setValue(StringUtil.nullToSpace(patientLink.getApplication().getSssqdh()));
        zm01.getPatientID().setValue(StringUtil.nullToSpace(patientLink.getPatient().getZyh()));
        zm01.getNumberOfHospitalizations().setValue(StringUtil.nullToSpace(patientLink.getPatient().getZycs()));
        zm01.getOperationNumber().setValue(StringUtil.nullToSpace(patientLink.getId()));
        zm01.getOperationCode().setValue("");
        zm01.getNameOfOperation().setValue(StringUtil.nullToSpace(patientLink.getAnesthesiaRecord().getNsss1()));
        if(patientLink.getStatus().getOperStartTime() != null) {
            zm01.getOperationDate().setValue(ymdhmsNormal.format(patientLink.getStatus().getOperStartTime()));
        }
//        addSpecialSymbol(zdmZ22,zm01,"1",7,0);
//        addSpecialSymbol(zdmZ22,zm01,"1289",7,1);
//        addSpecialSymbol(zdmZ22,zm01,Constants.FILL_ITEM_STRING,7,2);
        zm01.getOperationMethod().setValue("");
        zm01.getWhetherToOperateAgain().setValue("");
        zm01.getSurgicalGrade().setValue("");
//        addSpecialSymbol(zdmZ22,zm01,"手麻科",10,0);
        zm01.getPreoperativeDiagnosis().setValue(StringUtil.nullToSpace(patientLink.getApplication().getSqzd1()));
//        addSpecialSymbol(zdmZ22,zm01,"手术间3",11,0);
        zm01.getApplyDept().setValue(StringUtil.nullToSpace(patientLink.getApplication().getSqksbh()));
        String applyDept = patientLink.getApplication().getSqksmc();
        addSpecialSymbol(zdmZ22,zm01,StringUtil.isEmpty(applyDept)?Constants.FILL_ITEM_STRING:applyDept,12,0);
        zm01.getBedNo().setValue(StringUtil.nullToSpace(patientLink.getPatient().getZych()));
        zm01.getSurgeryDoctor().setValue(StringUtil.nullToSpace(getCodeWorkIDById(patientLink.getAnesthesiaRecord().getOperDoctor1())));
        String surgeryDoctor = getNameById(patientLink.getAnesthesiaRecord().getOperDoctor1());
        addSpecialSymbol(zdmZ22,zm01,StringUtil.isEmpty(surgeryDoctor) ? Constants.FILL_ITEM_STRING : surgeryDoctor ,14,0);
        zm01.getFirstSurgicalAssistant().setValue(StringUtil.nullToSpace(getCodeWorkIDById(patientLink.getAnesthesiaRecord().getOperDoctor1Assistant1())));
        String firstSurgicalAssistant = getNameById(patientLink.getAnesthesiaRecord().getOperDoctor1Assistant1());
        addSpecialSymbol(zdmZ22,zm01,StringUtil.isEmpty(firstSurgicalAssistant)?Constants.FILL_ITEM_STRING:firstSurgicalAssistant,15,0);
        zm01.getSecondSurgicalAssistant().setValue(getCodeWorkIDById(patientLink.getAnesthesiaRecord().getOperDoctor1Assistant2()));
        String secondSurgicalAssistant = getNameById(patientLink.getAnesthesiaRecord().getOperDoctor1Assistant2());
        addSpecialSymbol(zdmZ22,zm01,StringUtil.isEmpty(secondSurgicalAssistant)?Constants.FILL_ITEM_STRING:secondSurgicalAssistant,16,0);
        zm01.getThirdSurgicalAssistant().setValue(getCodeWorkIDById(patientLink.getAnesthesiaRecord().getOperDoctor1Assistant3()));
        String thirdSurgicalAssistant = getNameById(patientLink.getAnesthesiaRecord().getOperDoctor1Assistant3());
        addSpecialSymbol(zdmZ22,zm01,StringUtil.isEmpty(thirdSurgicalAssistant)?Constants.FILL_ITEM_STRING:thirdSurgicalAssistant,17,0);
        zm01.getFourthSurgicalAssistant().setValue("");
        zm01.getAnesthesia().setValue(StringUtil.nullToSpace(patientLink.getAnesthesiaRecord().getMzff()));
        zm01.getAnesthesiologist().setValue(getCodeWorkIDById(patientLink.getAnesthesiaRecord().getZmys()));
        String anesthesiologist = getNameById(patientLink.getAnesthesiaRecord().getZmys());
        addSpecialSymbol(zdmZ22,zm01,StringUtil.isEmpty(anesthesiologist)?Constants.FILL_ITEM_STRING:anesthesiologist,20,0);
        zm01.getAnesthesiologist2().setValue(getCodeWorkIDById(patientLink.getAnesthesiaRecord().getFmys1()));
        String anesthesiologist2 = getNameById(patientLink.getAnesthesiaRecord().getFmys1());
        addSpecialSymbol(zdmZ22,zm01,StringUtil.isEmpty(anesthesiologist2)?Constants.FILL_ITEM_STRING:anesthesiologist2,21,0);
        zm01.getAnesthesiologist3().setValue(getCodeWorkIDById(patientLink.getAnesthesiaRecord().getFmys2()));
        String anesthesiologist3 = getNameById(patientLink.getAnesthesiaRecord().getFmys2());
        addSpecialSymbol(zdmZ22,zm01,StringUtil.isEmpty(anesthesiologist3)?Constants.FILL_ITEM_STRING:anesthesiologist3,22,0);
        zm01.getAnesthesiaAssistant().setValue(getCodeWorkIDById(patientLink.getAnesthesiaRecord().getFmys3()));
        String anesthesiaAssistant = getNameById(patientLink.getAnesthesiaRecord().getFmys3());
        addSpecialSymbol(zdmZ22,zm01,StringUtil.isEmpty(anesthesiaAssistant)?Constants.FILL_ITEM_STRING:anesthesiaAssistant,23,0);
        zm01.getAnesthesiaAssistant2().setValue(getCodeWorkIDById(patientLink.getAnesthesiaRecord().getFmys4()));
        String anesthesiaAssistant2 = getNameById(patientLink.getAnesthesiaRecord().getFmys4());
        addSpecialSymbol(zdmZ22,zm01,StringUtil.isEmpty(anesthesiaAssistant2)?Constants.FILL_ITEM_STRING:anesthesiaAssistant2,24,0);
        zm01.getAnesthesiaAssistant3().setValue("");
        zm01.getAnesthesiaAssistant4().setValue("");
        zm01.getNurseOnTheFirstStage().setValue(getCodeWorkIDById(patientLink.getAnesthesiaRecord().getXshs1()));
        String nurseOnTheFirstStage = getNameById(patientLink.getAnesthesiaRecord().getXshs1());
        addSpecialSymbol(zdmZ22,zm01,StringUtil.isEmpty(nurseOnTheFirstStage)?Constants.FILL_ITEM_STRING:nurseOnTheFirstStage,27,0);
        zm01.getNurseOnTheSecondStage().setValue(getCodeWorkIDById(patientLink.getAnesthesiaRecord().getXshs2()));
        String nurseOnTheSecondStage = getNameById(patientLink.getAnesthesiaRecord().getXshs2());
        addSpecialSymbol(zdmZ22,zm01,StringUtil.isEmpty(nurseOnTheSecondStage)?Constants.FILL_ITEM_STRING:nurseOnTheSecondStage,28,0);
        zm01.getFirstSupplyNurse().setValue(getCodeWorkIDById(patientLink.getAnesthesiaRecord().getXhhs1()));
        String firstSupplyNurse = getNameById(patientLink.getAnesthesiaRecord().getXhhs1());
        addSpecialSymbol(zdmZ22,zm01,StringUtil.isEmpty(firstSupplyNurse)?Constants.FILL_ITEM_STRING:firstSupplyNurse,29,0);
        zm01.getSecondSupplyNurse().setValue(getCodeWorkIDById(patientLink.getAnesthesiaRecord().getXhhs2()));
        String secondSupplyNurse = getNameById(patientLink.getAnesthesiaRecord().getXhhs2());
        addSpecialSymbol(zdmZ22,zm01,StringUtil.isEmpty(secondSupplyNurse)?Constants.FILL_ITEM_STRING:secondSupplyNurse,30,0);
        zm01.getFirstEquipmentNurse().setValue(getCodeWorkIDById(patientLink.getSchedule().getQxhsbh1()));
        String firstEquipmentNurse = getNameById(patientLink.getSchedule().getQxhsbh1());
        addSpecialSymbol(zdmZ22,zm01,StringUtil.isEmpty(firstEquipmentNurse)?Constants.FILL_ITEM_STRING:firstEquipmentNurse,31,0);
        zm01.getSecondEquipmentNurse().setValue(getCodeWorkIDById(patientLink.getSchedule().getQxhsbh2()));
        String secondEquipmentNurse = getNameById(patientLink.getSchedule().getQxhsbh2());
        addSpecialSymbol(zdmZ22,zm01,StringUtil.isEmpty(secondEquipmentNurse)?Constants.FILL_ITEM_STRING:secondEquipmentNurse,32,0);
        zm01.getProposedInvasiveOperation().setValue("");
        zm01.getCodeOfProposedAnesthesiaMethod().setValue("");
        zm01.getPatientUnderlyingDisease().setValue("");
        zm01.getWhetherToUseAnAnalgesicPump().setValue("");
        if(patientLink.getStatus().getOperStartTime() != null) {
            zm01.getStartingTime().setValue(ymdhmsNormal.format(patientLink.getStatus().getOperStartTime()));
        }
        if(patientLink.getStatus().getOperEndTime() != null) {
            zm01.getEndTime().setValue(ymdhmsNormal.format(patientLink.getStatus().getOperEndTime()));
        }
        zm01.getLengthOfOperation().setValue(String.valueOf(patientLink.getStatus().getOperSpanTime()));
        zm01.getASARating().setValue(StringUtil.nullToSpace(patientLink.getAnesthesiaRecord().getAsa().getLevel()));
        if(patientLink.getTableForHeZhouGuangJiEY().getFengXianPingGu().ssqk_a1Property().getValue()){
            zm01.getSurgicalIncisionType().setValue("I");
            addSpecialSymbol(zdmZ22,zm01,"I类手术",41,0);
        }else if(patientLink.getTableForHeZhouGuangJiEY().getFengXianPingGu().ssqk_a2Property().getValue()){
            zm01.getSurgicalIncisionType().setValue("II");
            addSpecialSymbol(zdmZ22,zm01,"II类手术",41,0);
        }else if(patientLink.getTableForHeZhouGuangJiEY().getFengXianPingGu().ssqk_a3Property().getValue()){
            zm01.getSurgicalIncisionType().setValue("III");
            addSpecialSymbol(zdmZ22,zm01,"III类手术",41,0);
        }else if(patientLink.getTableForHeZhouGuangJiEY().getFengXianPingGu().ssqk_a4Property().getValue()){
            zm01.getSurgicalIncisionType().setValue("IV");
            addSpecialSymbol(zdmZ22,zm01,"IV类手术",41,0);
        }
        zm01.getChineseAndWesternMedicineLogo().setValue("");
        zm01.getBloodTransfusionNumber().setValue("");
        int level = 0;
        if(patientLink.getTableForHeZhouGuangJiEY().getFengXianPingGu().nnis1Property().getValue()){
            level = 1;
        }else if(patientLink.getTableForHeZhouGuangJiEY().getFengXianPingGu().nnis2Property().getValue()){
            level = 2;
        }else if(patientLink.getTableForHeZhouGuangJiEY().getFengXianPingGu().nnis3Property().getValue()){
            level = 3;
        }
        zm01.getNNISClassification().setValue(String.valueOf(level));
        zm01.getIncisionHealingGrade().setValue("");
        zm01.getIncisionSite().setValue("");
        if(patientLink.getAnesthesiaRecord().getFjhss()){
            zm01.getWhetherSecondOperUnexpected().setValue("是");
        }
        if(patientLink.getAnesthesiaRecord().getJhss()){
            zm01.getWhetherSecondOperUnexpected().setValue("否");
        }
        if(patientLink.getAnesthesiaRecord().getAsa().getZq()){
            zm01.getElectiveEmergency().setValue("择期");
        }else if(patientLink.getAnesthesiaRecord().getAsa().getJz()){
            zm01.getElectiveEmergency().setValue("急诊");
        }
        if(patientLink.getTableForHeZhouGuangJiEY().getFengXianPingGu().qgssProperty().getValue()){
            zm01.getSurgicalLocation().setValue("器官手术");
        }
        if(patientLink.getTableForHeZhouGuangJiEY().getFengXianPingGu().qczzssProperty().getValue()){
            zm01.getSurgicalLocation().setValue("浅层组织手术");
        }
        if(patientLink.getTableForHeZhouGuangJiEY().getFengXianPingGu().sbzzssProperty().getValue()){
            zm01.getSurgicalLocation().setValue("深层组织手术");
        }
        if(patientLink.getTableForHeZhouGuangJiEY().getFengXianPingGu().jxssProperty().getValue()){
            zm01.getSurgicalLocation().setValue("腔隙内手术");
        }
        if(patientLink.getTableForHeZhouGuangJiEY().getAnQuanHeCha().tiNeiZhiRuWu_yesProperty().getValue()){
            zm01.getImplants().setValue("有");
        }else{
            zm01.getImplants().setValue("无");
        }
        zm01.getEndoscopicSurgery().setValue("");
        zm01.getOperatingRoom().setValue("");
        zm01.getOperatingRoomNum().setValue(StringUtil.nullToSpace(patientLink.getSchedule().getPbssjh()));
        zm01.getTaiwan().setValue(StringUtil.nullToSpace(patientLink.getSchedule().getPbts()));
        zm01.getIsolationSign().setValue("");
        zm01.getBloodLoss().setValue(StringUtil.nullToSpace(patientLink.getAnesthesiaRecord().getLiquidInAndOut().getJxl()));
        zm01.getBloodTransfusion().setValue("");
        zm01.getSkinPreparationMethod().setValue("");
        zm01.getSkinPreparationTime().setValue("");
        zm01.getApplicationDateAndTime().setValue("");
        zm01.getEntrant().setValue("");
        zm01.getSurgicalOrderNumber().setValue("");
        zm01.getReturnOpeRoomUnexpectedly().setValue("");
        zm01.getSurgicalRiskAssessment().setValue("");
        if(patientLink.getTableForHeZhouGuangJiEY().getFengXianPingGu().qgssProperty().getValue()){
            zm01.getSurgicalSiteCategory().setValue("器官手术");
        }
        if(patientLink.getTableForHeZhouGuangJiEY().getFengXianPingGu().qczzssProperty().getValue()){
            zm01.getSurgicalSiteCategory().setValue("浅层组织手术");
        }
        if(patientLink.getTableForHeZhouGuangJiEY().getFengXianPingGu().sbzzssProperty().getValue()){
            zm01.getSurgicalSiteCategory().setValue("深层组织手术");
        }
        if(patientLink.getTableForHeZhouGuangJiEY().getFengXianPingGu().jxssProperty().getValue()){
            zm01.getSurgicalSiteCategory().setValue("腔隙内手术");
        }
        zm01.getOperationDescription().setValue("");
        if(patientLink.getStatus().getInRoomTime()!=null) {
            zm01.getTimeEnterOperatingRoom().setValue(ymdhmsNormal.format(patientLink.getStatus().getInRoomTime()));
        }
        if(patientLink.getStatus().getOutRoomTime()!=null) {
            zm01.getTimeOutOperatingRoom().setValue(ymdhmsNormal.format(patientLink.getStatus().getOutRoomTime()));
        }
        if(patientLink.getStatus().getMazuiStartTime()!=null) {
            zm01.getAnesthesiaStartTime().setValue(ymdhmsNormal.format(patientLink.getStatus().getMazuiStartTime()));
        }
        if(patientLink.getStatus().getMazuiEndTime()!=null) {
            zm01.getEndOfAnesthesiaTime().setValue(ymdhmsNormal.format(patientLink.getStatus().getMazuiEndTime()));
        }
        if(patientLink.getStatus().getOperStartTime() != null) {
            zm01.getSurgeryStartTime().setValue(ymdhmsNormal.format(patientLink.getStatus().getOperStartTime()));
        }
        if(patientLink.getStatus().getOperEndTime() != null) {
            zm01.getSurgeryEndTime().setValue(ymdhmsNormal.format(patientLink.getStatus().getOperEndTime()));
        }
        zm01.getCardiopulmonaryBypass().setValue("");
        zm01.getRemainsDuringOperation().setValue("");
        zm01.getOperationWasSuccessful().setValue("");
        if(patientLink.getTableForRongChangEY().getZhiKongXinXi().getYwsw()) {
            zm01.getDiedDuringOperation().setValue("是");
        }else{
            zm01.getDiedDuringOperation().setValue("否");
        }
        zm01.getSurgicalSafetyCheck().setValue("");
        zm01.getAnesthesiaEffect().setValue("");
        zm01.getNarcoticDrugs().setValue("");
        zm01.getDose().setValue("");
        zm01.getDoseUnite().setValue("");
        zm01.getUsage().setValue("");
        zm01.getstewardScore().setValue("");
        if(patientLink.getTableForRongChangEY().getZhiKongXinXi().getXffscg()) {
            zm01.getCardiopulmonaryResuscitation().setValue("成功");
        }
        if(patientLink.getTableForRongChangEY().getZhiKongXinXi().getXffsbcg()) {
            zm01.getCardiopulmonaryResuscitation().setValue("不成功");
        }
        zm01.getEnterPAVU().setValue("");
        zm01.getPostoperativeAnalgesia().setValue("");
        zm01.getVisitBeforeSurgery().setValue("");
        zm01.getVisitAfterSurgery().setValue("");
        zm01.getPostoperativeTrachealIntubationRemoval().setValue("");
        zm01.getTimeEnterPAVU().setValue("");
        zm01.getTimeOutPAVU().setValue("");
        zm01.getPACUEntryTemperature().setValue("");
        zm01.getCancelOperationAfterAnesthesiStarts().setValue("");
        zm01.getUnplannedTransferICU().setValue("");
        zm01.getTransferICUAfterSurgery().setValue("");
        zm01.getIntraoperativeAutologousBloodTransfusion().setValue("");
        zm01.getAutologousBloodTransfusion().setValue("");
        zm01.getSurgery().setValue(StringUtil.nullToSpace(patientLink.getAnesthesiaRecord().getYsss1()));
    }

    public static void setZM02(ZDM_Z22 zdmZ02, ZM02 zm02, PatientEvents patientEvents,PatientLink patientLink) throws HL7Exception {
        if(patientEvents != null) {
            zm02.getEventNumber().setValue(StringUtil.nullToSpace(patientEvents.getId()));
            zm02.getEventName().setValue(StringUtil.nullToSpace(getEventNameByCode(patientEvents.getCode())));
            if (patientEvents.getBeginTime() != null) {
                zm02.getTimeOccurrence().setValue(ymdhmsNormal.format(patientEvents.getBeginTime()));
            }
            zm02.getEventType().setValue(StringUtil.nullToSpace(patientEvents.getCode()));
            zm02.getTimingMedication().setValue("");
            zm02.getOperationNumber().setValue(StringUtil.nullToSpace(patientLink.getId()));
            zm02.getPatientID().setValue(StringUtil.nullToSpace(patientLink.getPatient().getZyh()));
            zm02.getNumberHospitalizations().setValue(patientLink.getPatient().getZycs());
        }else{
            zm02.getNumberHospitalizations().setValue(Constants.FILL_ITEM_STRING);
        }
    }

    public static void setZM03(ZDM_Z22 zdm_z22, ZM03 zm03, Item item,PatientDrugs patientDrugs, PatientLink patientLink) throws DataTypeException {
        if(patientDrugs != null) {
            zm03.getAnesthesiaMedicationCode().setValue("");
            zm03.getNameOfNarcoticDrug().setValue(StringUtil.nullToSpace(item.getName()));
            if (patientDrugs.getBeginTime() != null) {
                zm03.getTimeOccurrence().setValue(ymdhmsNormal.format(patientDrugs.getBeginTime()));
            }
            zm03.getDose().setValue(StringUtil.nullToSpace(item.getDose()));
            zm03.getUnitOfMeasurement().setValue(StringUtil.nullToSpace(item.getUnit()));
            zm03.getUsage().setValue(StringUtil.nullToSpace(patientDrugs.getDrugMethod()));
            zm03.getDosageForm().setValue(StringUtil.nullToSpace(patientLink.getId()));
            zm03.getPatientID().setValue(StringUtil.nullToSpace(patientLink.getPatient().getZyh()));
            zm03.getNumberHospitalizations().setValue(StringUtil.nullToSpace(patientLink.getPatient().getZycs()));
        }else{
            zm03.getNumberHospitalizations().setValue(Constants.FILL_ITEM_STRING);
        }
    }
}
