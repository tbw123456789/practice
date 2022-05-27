package cn.medigical.publish.interfaces.his.hishezhouguangji.webserver;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Structure;
import ca.uhn.hl7v2.model.v24.message.QRY_R02;
import ca.uhn.hl7v2.model.v24.segment.MSH;
import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigDepartmentsDao;
import cn.medigical.publish.interfaces.his.hishezhouguangji.segment.*;
import cn.medigical.publish.interfaces.his.hishezhouguangji.utils.Constants;
import cn.medigical.publish.interfaces.his.hisLink.PojoBGA;
import cn.medigical.publish.interfaces.his.hishezhouguangji.HisLinkHeZhouGuangJi;
import cn.medigical.publish.interfaces.his.hishezhouguangji.message.*;
import cn.medigical.publish.interfaces.his.hishezhouguangji.utils.MsgDealUtil;
import cn.medigical.publish.interfaces.lis.LisData;
import cn.medigical.publish.interfaces.lis.hishezhouguangji.JYBigItem;
import cn.medigical.publish.interfaces.lis.hishezhouguangji.JYSmallItem;
import cn.medigical.publish.interfaces.lis.hishezhouguangji.LisDataHeZhouGuangJi;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.dictionary.ConfigAnesMethods;
import cn.medigical.publish.pojo.dictionary.ConfigDepartments;
import cn.medigical.publish.pojo.lis.JianYan;
import cn.medigical.publish.pojo.patient.PatientDrugs;
import cn.medigical.publish.pojo.patient.PatientEvents;
import cn.medigical.publish.pojo.patient.drug.Drugs;
import cn.medigical.publish.pojo.patient.drug.Item;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.utils.MyDateFormat;
import cn.medigical.publish.utils.PropertyUtil;
import cn.medigical.publish.utils.SpringUtils;
import cn.medigical.publish.utils.StringUtil;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService
@Component
public class HeZhouGuangJiServer {

    @WebMethod
    public void test(){
        //return SpringUtils.getBean(HisLinkHeZhouGuangJi.class).getOprationFromHis();
        RecieveMessages("<req><apply_data>%0bMSH%7C%5E~%26%7CHIS%7C%7Ctarno%5E7006%7C%7C20190821183716%7C%7CZDM%5EZ01%7CZDM_Z01-20190821183716.703792%7CP%7C2.4%7C%7C%7CNE%7CAL%7C%7C%7C%7C%7C%0DPID%7C1%7C1388260%7C1388205%5E%5E212879%5E100000849456%5E452426195802181573%7C61%E5%B2%81%7C%E8%82%96%E9%99%85%E8%B9%84%5E%5E%7C%7C19580218%7CM%7C%7C%7C%E5%B9%B3%E6%A1%82%E5%8C%BA%E5%85%AC%E4%BC%9A%E9%95%87%E5%8F%8C%E7%9F%B3%E6%9D%9110%E7%BB%84%7C%7C%5E15177687207%7C%5E%7C%7CM%7C%7C%7C100001548970%7C%E8%87%AA%E8%B4%B9%5E%E5%85%A8%E8%87%AA%E8%B4%B9%7C%7C%5E%E6%B1%89%E6%97%8F%7C%E5%B9%BF%E8%A5%BF%E8%B4%BA%E5%B7%9E%E5%B8%82%E5%B9%B3%E6%A1%82%E5%8C%BA%E5%85%AC%E4%BC%9A%E9%95%87%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%0DPV1%7C1%7CI%7C536%5E2659%5E23%5E%5E%E8%82%BE%E5%86%85%E7%A7%91%5E%E5%86%85%E7%A7%91%E4%BA%8C%E5%8C%BA%7C%7C%7C%7C5638%5E%E5%8D%A2%E6%B3%B3%E6%AD%A6%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C5638%5E%E5%8D%A2%E6%B3%B3%E6%AD%A6%7C%E6%99%AE%E9%80%9A%E7%97%85%E4%BA%BA%5E%5E%7C1388260%5E3%5E%7C%7C%7C50%5E%E2%85%A0%E7%BA%A7%E6%8A%A4%E7%90%86%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%5E%7C%7C%7C%7C%7C-1%5E-9096.5358%7C%7C%7C20190224114000%7C%E5%B0%BF%E6%AF%92%E7%97%87%7C%5E%5E%5E%7C%5E%5E%7C20190224114349%7C%7C10347%5E%E9%99%88%E5%AE%98%E4%B8%BD%0DZ01%7C55997049%7C330201319%7C%E3%80%90%E6%B5%B7%E7%BB%B5%E7%AA%A6%E7%98%98%E7%9B%B4%E6%8E%A5%E6%89%8B%E6%9C%AF%E3%80%91%7C%7C0%7CIP%7C1388260%5E3%5E536%5E23%7C20190822133600%7C806%5E%E6%89%8B%E6%9C%AF%E5%AE%A4%7C%5E%7C%7C%7C536%5E%E8%82%BE%E5%86%85%E7%A7%91%7C671%5E193%E6%B5%8B%E8%AF%95%E5%91%98%7C%5E%7C%5E%7C%7C%7C330100008%5E%E5%9F%BA%E7%A1%80%E9%BA%BB%E9%86%89%7C%5E%7C%7C%7C%5E%7C%7C%7C%7C%7C%5E%7C%7C%7C%7C%7C%7C20190821183700%7C%5E193%E6%B5%8B%E8%AF%95%E5%91%98%7C%E5%B0%BF%E6%AF%92%E7%97%87%7C%0DZ02%7C1%7C%7C%7C%1c%0d</apply_data></req>");
//        RecieveMessages("<req><apply_data>%0bMSH%7C%5E~%26%7CHIS%7C%7Ctarno%5E1012%7C%7C20190821103051%7C%7CZDM%5ERES%7CZDM_RES-20190821103051.719970%7CP%7C2.4%7C%7C%7CNE%7CAL%7C%7C%7C%7C%7C%0DZD1%7C1012%7C1%7C1%7C900%7C9%7C%E6%84%9F%E6%9F%93%E9%83%A8%E9%97%A8%7C%7C%7C20190821103046%7C20190821103046%7CI%7C0%7C3353%7C1047%1c%0d</apply_data></req>");
//        RecieveMessages("<req><apply_data>%0bMSH%7C%5E~%26%7CHIS%7C%7Ctarno%5E1022%7C%7C20190821103329%7C%7CZDM%5ERES%7CZDM_RES-20190821103329.052336%7CP%7C2.4%7C%7C%7CNE%7CAL%7C%7C%7C%7C%7C%0DZD1%7C1022%7C1%7C1%7C900%7C9%7C%E6%84%9F%E6%9F%93%E9%83%A8%E9%97%A81%7C%7C%7C20190821103046%7C20190821103046%7CU%7C0%7C3353%7C1047%1c%0d</apply_data></req>");
//        RecieveMessages("<req><apply_data>%0bMSH%7C%5E~%26%7CHIS%7C%7Ctarno%5E1032%7C%7C20190821102718%7C%7CZDM%5ERES%7CZDM_RES-20190821102718.880307%7CP%7C2.4%7C%7C%7CNE%7CAL%7C%7C%7C%7C%7C%0DZD1%7C1032%7C1%7C1%7C901%7C9%7C%E6%B3%8C%E5%B0%BF%E8%89%BE%E5%85%8B%E7%A7%91%E5%AE%A4%7C%7C%7C20190801112639%7C20190801112639%7CD%7C0%7C3330%7C1047%1c%0d</apply_data></req>");
//        RecieveMessages("<req><apply_data>%0bMSH%7C%5E~%26%7CHIS%7C%7Ctarno%5E1042%7C%7C20190821104234%7C%7CZDM%5ERES%7CZDM_RES-20190821104234.508370%7CP%7C2.4%7C%7C%7CNE%7CAL%7C%7C%7C%7C%7C%0DZD1%7C1042%7C1%7C1%7C930%7C9%7C%E5%A4%96%E7%A7%91%E7%A7%91%E5%AE%A494%7C%7C%7C20190821094841%7C20190821094841%7CS%7C0%7C3351%7C1047%1c%0d</apply_data></req>");
    }

    /**
     * @param recieveMsg
     * @return
             */
    @WebMethod
    public String RecieveMessages(String recieveMsg){
        String responseMSG = "";
        System.out.println("recieve msg.......");
        try {
            recieveMsg = MsgDealUtil.autoRecieveMsgXml(recieveMsg);
            recieveMsg = URLDecoder.decode(recieveMsg,"UTF-8");
            MSH msh = MsgDealUtil.getMSGHeader(recieveMsg);
            String keyCode = msh.getReceivingApplication().getHd2_UniversalID().getValue();
            ACK_R01 ack_r01 = null;
            switch (keyCode){
                case Constants.KEY_ASPANOPERATION_CMD:

                    break;
                case Constants.KEY_OPERATIONSCHEDULED_CMD:
                    break;
                case Constants.KEY_OPERATIONSCHEDULESTATUS_CMD:
                    break;
                    //获取手术申请
                case Constants.KEY_OPERATION_CMD:
                    ZDM_Z01 zdm_z01 = MsgDealUtil.recieveOprationFromHis(recieveMsg);
                    ack_r01 = new ACK_R01();
                    if(zdm_z01.isEmpty()){
                        ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_ERROR_MSG);
                    }else{
                        PatientLink patientLink = new PatientLink();
                        patientLink.getPatient().setStatus(cn.medigical.publish.utils.Constants.FLAG_VALID);
                        patientLink.getApplication().setStatus(cn.medigical.publish.utils.Constants.AP_STATUS_MAZUIQIAN);
                        patientLink.getApplication().setDetailstatus(cn.medigical.publish.utils.Constants.OR_STATUS_FLAG_APPLIED);
                        setOperationNsssmc(patientLink,zdm_z01);
                        MsgDealUtil.getPID(zdm_z01,zdm_z01.getPID(),patientLink);
                        MsgDealUtil.getPV1(zdm_z01,zdm_z01.getPV1(),patientLink);
                        List<PatientLink> patientLinkList = new ArrayList<>();
                        patientLinkList.add(patientLink);
                        addOperation(patientLinkList);
                        ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_SUCCESS_MSG);
                    }
                   responseMSG = MsgDealUtil.responseOprationToHis(ack_r01,Constants.TAG_SYSTEM_REMOTE,Constants.KEY_OPERATION_CMD);
                   break;
                   //取消手术申请
                case Constants.KEY_CANCELOPERATION_CMD:

                    ZDM_Z01 zdmZ01 = MsgDealUtil.recieveOprationFromHis(recieveMsg);
                    ack_r01 = new ACK_R01();
                    if(zdmZ01.isEmpty()){
                        ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_ERROR_MSG);
                    }else{
                        PatientLink patientLink = new PatientLink();
                        setOperationNsssmc(patientLink,zdmZ01);
                        MsgDealUtil.getPID(zdmZ01,zdmZ01.getPID(),patientLink);
                        MsgDealUtil.getPV1(zdmZ01,zdmZ01.getPV1(),patientLink);
                        PatientLink patientLinkRet = SpringUtils.getBean(PatientLinkDao.class).getPatientLinkBySssqdh(patientLink.getApplication().getSssqdh());
                        if(patientLinkRet != null) {
                            patientLinkRet.getPatient().setStatus(cn.medigical.publish.utils.Constants.FLAG_IN_VALID);
                            SpringUtils.getBean(PatientLinkDao.class).addUpdate(patientLinkRet);
                            ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_SUCCESS_MSG);
                        }else{
                            ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_ERROR_MSG);
                        }
                    }

                    responseMSG = MsgDealUtil.responseOprationToHis(ack_r01,Constants.TAG_SYSTEM_REMOTE,Constants.KEY_OPERATION_CMD);

                    break;
                case Constants.KEY_ACOUNT_CMD:
                    break;
                case Constants.KEY_DEPARTMENT_CMD:
                    break;
                case Constants.KEY_DIAGNOSIS_CMD:
                    break;
                case Constants.KEY_SPECIMEN_CMD:
                    break;
                case Constants.KEY_INSPECTION_CMD:
                    break;
                case Constants.KEY_DISEASECODE_CMD:
                    break;
                case Constants.KEY_CHARGEPROJECT_CMD:
                    break;
                    //人员同步
                case Constants.KEY_ACOUNTSYNC_CMD:
                    ZDM_RES addAcount = MsgDealUtil.recieveSyncFromHis(recieveMsg);
                    ack_r01 = new ACK_R01();
                    if(addAcount.isEmpty()){
                        ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_ERROR_MSG);
                    }else{
                        Account account = new Account();
                        MsgDealUtil.getZD1(addAcount,addAcount.getZD1(),account);
                        MsgDealUtil.getZD2(addAcount,addAcount.getZD2(),account);
                        Account accounts = SpringUtils.getBean(AccountDao.class).findNotLikeByWorkID(account.getWorkID());
                        if(accounts == null && !StringUtil.isEmpty(account.getWorkID())){
                            SpringUtils.getBean(AccountDao.class).addUpdate(account);
                            ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_SUCCESS_MSG);
                        }else{
                            ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_ERROR_MSG);
                        }

                    }

                    responseMSG =  MsgDealUtil.responseSyncToHis(ack_r01,Constants.TAG_SYSTEM_REMOTE,Constants.KEY_ACOUNTSYNC_CMD);
                    break;
                    //部门同步
                case Constants.KEY_DEPARTMENTSYNC_CMD:
                    ZDM_RES addDepartment = MsgDealUtil.recieveSyncFromHis(recieveMsg);
                    ack_r01 = new ACK_R01();
                    if(addDepartment.isEmpty()){
                        ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_ERROR_MSG);
                    }else{
                        ConfigDepartments departments = new ConfigDepartments();
                        MsgDealUtil.getZD1(addDepartment,addDepartment.getZD1(),departments);
                        ConfigDepartments configDepartments = SpringUtils.getBean(ConfigDepartmentsDao.class).getNamebyId(departments.getCode());
                        if(configDepartments == null){
                            SpringUtils.getBean(ConfigDepartmentsDao.class).save(departments);
                            ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_SUCCESS_MSG);
                        }else{
                            ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_ERROR_MSG);
                        }

                    }

                    responseMSG =  MsgDealUtil.responseSyncToHis(ack_r01,Constants.TAG_SYSTEM_REMOTE,Constants.KEY_DEPARTMENTSYNC_CMD);
                    break;
                case Constants.KEY_DIAGNOSISSYNC_CMD:
                    break;
                case Constants.KEY_SPECIMENSYNC_CMD:
                    break;
                case Constants.KEY_INSPECTIONSYNC_CMD:
                    break;
                case Constants.KEY_DISEASECODESYNC_CMD:
                    break;
                case Constants.KEY_CHARGEPROJECTSYNC_CMD:
                    break;
                case Constants.KEY_ACOUNTEDITSYNC_CMD:
                    ZDM_RES editAcount = MsgDealUtil.recieveSyncFromHis(recieveMsg);
                    ack_r01 = new ACK_R01();
                    if(editAcount.isEmpty()){
                        ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_ERROR_MSG);
                    }else{
                        Account account = new Account();
                        MsgDealUtil.getZD1(editAcount,editAcount.getZD1(),account);
                        MsgDealUtil.getZD2(editAcount,editAcount.getZD2(),account);
                        Account accountRet = SpringUtils.getBean(AccountDao.class).findNotLikeByWorkID(account.getWorkID());
                        if(accountRet != null  && !StringUtil.isEmpty(account.getWorkID())) {
                            account.setId(accountRet.getId());
                            if(SpringUtils.getBean(AccountDao.class).updateInsert(account)){
                                ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_SUCCESS_MSG);
                            }else{
                                ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_ERROR_MSG);
                            }
                        }else{
                            ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_ERROR_MSG);
                        }
                    }

                    responseMSG =  MsgDealUtil.responseSyncToHis(ack_r01,Constants.TAG_SYSTEM_REMOTE,Constants.KEY_ACOUNTEDITSYNC_CMD);
                    break;
                case Constants.KEY_DEPARRTMENTEDITSYNC_CMD:
                    ZDM_RES editDepartment = MsgDealUtil.recieveSyncFromHis(recieveMsg);
                    ack_r01 = new ACK_R01();
                    if(editDepartment.isEmpty()){
                        ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_ERROR_MSG);
                    }else{
                        ConfigDepartments departments = new ConfigDepartments();
                        MsgDealUtil.getZD1(editDepartment,editDepartment.getZD1(),departments);
                        ConfigDepartments configDepartments = SpringUtils.getBean(ConfigDepartmentsDao.class).getNamebyId(departments.getCode());
                        if(configDepartments != null){
                            departments.setId(configDepartments.getId());
                            if(SpringUtils.getBean(ConfigDepartmentsDao.class).updateInsert(departments)) {
                                ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_SUCCESS_MSG);
                            }else{
                                ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_ERROR_MSG);
                            }
                        }else{
                            ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_ERROR_MSG);
                        }
                    }

                    responseMSG =  MsgDealUtil.responseSyncToHis(ack_r01,Constants.TAG_SYSTEM_REMOTE,Constants.KEY_DEPARRTMENTEDITSYNC_CMD);
                    break;
                case Constants.KEY_DIAGNOSISEDITSYNC_CMD:
                    break;
                case Constants.KEY_SPECIMENEDITSYNC_CMD:
                    break;
                case Constants.KEY_INSPECTIONEDITSYNC_CMD:
                    break;
                case Constants.KEY_DISEASECODEEDITSYNC_CMD:
                    break;
                case Constants.KEY_CHARGEPROJECTEDITSYNC_CMD:
                    break;
                    //启用用户
                case Constants.KEY_ACOUNTVALIDSYNC_CMD:
                    ZDM_RES validAcount = MsgDealUtil.recieveSyncFromHis(recieveMsg);
                    ack_r01 = new ACK_R01();
                    if(validAcount.isEmpty()){
                        ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_ERROR_MSG);
                    }else{
                        Account account = new Account();
                        MsgDealUtil.getZD1(validAcount,validAcount.getZD1(),account);
                        MsgDealUtil.getZD2(validAcount,validAcount.getZD2(),account);
                        Account accountRet = SpringUtils.getBean(AccountDao.class).findNotLikeByWorkID(account.getWorkID());
                        if(accountRet != null && !StringUtil.isEmpty(account.getWorkID())){
                            account.setId(accountRet.getId());
                            SpringUtils.getBean(AccountDao.class).undel(accountRet);
                            ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_SUCCESS_MSG);
                        }else{
                            ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_ERROR_MSG);
                        }
                    }
                    responseMSG =  MsgDealUtil.responseSyncToHis(ack_r01,Constants.TAG_SYSTEM_REMOTE,Constants.KEY_ACOUNTINVALIDSYNC_CMD);
                    break;
                    //弃用用户
                case Constants.KEY_ACOUNTINVALIDSYNC_CMD:
                    ZDM_RES deleteAcount = MsgDealUtil.recieveSyncFromHis(recieveMsg);
                    ack_r01 = new ACK_R01();
                    if(deleteAcount.isEmpty()){
                        ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_ERROR_MSG);
                    }else{
                        Account account = new Account();
                        MsgDealUtil.getZD1(deleteAcount,deleteAcount.getZD1(),account);
                        MsgDealUtil.getZD2(deleteAcount,deleteAcount.getZD2(),account);
                        Account accountRet = SpringUtils.getBean(AccountDao.class).findNotLikeByWorkID(account.getWorkID());
                        if(accountRet != null && !StringUtil.isEmpty(account.getWorkID())){
                            account.setId(accountRet.getId());
                            SpringUtils.getBean(AccountDao.class).del(account);
                            ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_SUCCESS_MSG);
                        }else{
                            ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_ERROR_MSG);
                        }

                    }
                    responseMSG =  MsgDealUtil.responseSyncToHis(ack_r01,Constants.TAG_SYSTEM_REMOTE,Constants.KEY_ACOUNTINVALIDSYNC_CMD);
                    break;
                case Constants.KEY_DEPARTMENTINVALIDSYNC_CMD:
                    ZDM_RES deleteDepartment = MsgDealUtil.recieveSyncFromHis(recieveMsg);
                    ack_r01 = new ACK_R01();
                    if(deleteDepartment.isEmpty()){
                        ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_ERROR_MSG);
                    }else{
                        ConfigDepartments departments = new ConfigDepartments();
                        MsgDealUtil.getZD1(deleteDepartment,deleteDepartment.getZD1(),departments);
                        ConfigDepartments configDepartments = SpringUtils.getBean(ConfigDepartmentsDao.class).getNamebyId(departments.getCode());
                        if(configDepartments != null) {
                            departments.setId(configDepartments.getId());
                            SpringUtils.getBean(ConfigDepartmentsDao.class).del(departments);
                            ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_SUCCESS_MSG);
                        }else{
                            ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_ERROR_MSG);
                        }
                    }
                    responseMSG =  MsgDealUtil.responseSyncToHis(ack_r01,Constants.TAG_SYSTEM_REMOTE,Constants.KEY_DEPARTMENTINVALIDSYNC_CMD);
                    break;
                case Constants.KEY_DEPARTMENTVALIDSYNC_CMD:
                    ZDM_RES validDepartment = MsgDealUtil.recieveSyncFromHis(recieveMsg);
                    ack_r01 = new ACK_R01();
                    if(validDepartment.isEmpty()){
                        ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_ERROR_MSG);
                    }else{
                        ConfigDepartments departments = new ConfigDepartments();
                        MsgDealUtil.getZD1(validDepartment,validDepartment.getZD1(),departments);
                        ConfigDepartments configDepartments = SpringUtils.getBean(ConfigDepartmentsDao.class).getNamebyId(departments.getCode());
                        if(configDepartments != null) {
                            departments.setId(configDepartments.getId());
                            SpringUtils.getBean(ConfigDepartmentsDao.class).undel(departments);
                            ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_SUCCESS_MSG);
                        }else{
                            ack_r01.getMSA().getAcknowledgementCode().setValue(Constants.KEY_ERROR_MSG);
                        }
                    }

                    responseMSG =  MsgDealUtil.responseSyncToHis(ack_r01,Constants.TAG_SYSTEM_REMOTE,Constants.KEY_DEPARTMENTINVALIDSYNC_CMD);
                    break;
                case Constants.KEY_DIAGNOSISINVALIDSYNC_CMD:
                    break;
                case Constants.KEY_SPECIMENINVALIDSYNC_CMD:
                    break;
                case Constants.KEY_INSPECTIONINVALIDSYNC_CMD:
                    break;
                default:
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return responseMSG;
    }

    /**
     * 设置拟行手术名称
     * @param patientLink
     * @param zdm_z01
     * @throws HL7Exception
     */
    private void setOperationNsssmc(PatientLink patientLink,ZDM_Z01 zdm_z01) throws HL7Exception {
        MsgDealUtil.getZ01(zdm_z01,zdm_z01.getZ01(),patientLink);
        List<Structure> structureList = MsgDealUtil.getStructureList(zdm_z01, Z02.class);
        StringBuffer buffer = new StringBuffer();
        int i = 0;
        if(!StringUtil.isEmpty(patientLink.getApplication().getNsssmc())){
            i++;
            buffer.append(i);
            buffer.append("、");
            buffer.append(patientLink.getApplication().getNsssmc());
        }
        if(structureList != null){
            for(Structure structure : structureList){
                Z02 z02 = (Z02) structure;
                if(!StringUtil.isEmpty(z02.getNameOfSecondaryOperation().getValue())) {
                    i++;
                    buffer.append(i);
                    buffer.append("、");
                    //拟施手术名称
                    buffer.append(z02.getNameOfSecondaryOperation().getValue());
                }
            }
        }
        patientLink.getApplication().setNsssmc(buffer.toString());
    }

    public static void main(String[] args) {

//        HeZhouGuangJiServer heZhouGuangJiServer = new HeZhouGuangJiServer();
//        //heZhouGuangJiServer.RecieveMessages("<req><apply_data>%0bMSH%7C%5E~%26%7CHIS%7C%7Ctarno%5E7006%7C%7C20190710115414%7C%7CZDM%5EZ01%7CZDM_Z01-20190710115414.032567%7CP%7C2.4%7C%7C%7CNE%7CAL%7C%7C%7C%7C%7C%0DPID%7C1%7C1639282%7C100000795169%5E%5E229380%5E100000871533%5E432926198204016620%7C36%E5%B2%81%7C%E6%BD%98%E4%BD%B3%E7%8F%8D%5E%5E%7C%7C19820401%7CF%7C%7C%7C%E6%B9%96%E5%8D%97%E7%9C%81%E6%B0%B8%E5%B7%9E%E5%B8%82%E6%B1%9F%E5%8D%8E%E5%8E%BF%E6%9D%A1%E6%B1%9F%E4%B9%A1%E8%83%A1%E9%9D%92%E6%9D%9114%E5%8F%B7%7C%7C%5E18274900415%7C%5E%7C%7CM%7C%7C%7C%7C%E8%87%AA%E8%B4%B9%5E%E5%85%A8%E8%87%AA%E8%B4%B9%7C%7C%5E%E6%B1%89%E6%97%8F%7C%E6%B9%96%E5%8D%97%E7%9C%81%E6%B0%B8%E5%B7%9E%E5%B8%82%E6%B1%9F%E5%8D%8E%E5%8E%BF%E6%9D%A1%E6%B1%9F%E4%B9%A1%E8%83%A1%E9%9D%92%E6%9D%91%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%0DPV1%7C1%7CI%7C2016%5E2664%5E14%5E%5E%E6%99%AE%E9%80%9A%E5%A4%96%E7%A7%91%5E%E5%A4%96%E7%A7%91%E4%B8%89%E5%8C%BA%7C%7C%7C%7C4672%5E%E8%A6%83%E7%A6%8F%E5%A3%B9%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C4672%5E%E8%A6%83%E7%A6%8F%E5%A3%B9%7C%E6%99%AE%E9%80%9A%E7%97%85%E4%BA%BA%5E%5E%7C1639282%5E1%5E%7C%7C%7C50%5E%E2%85%A0%E7%BA%A7%E6%8A%A4%E7%90%86%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%7C%E6%AD%A3%E5%B8%B8%5E%7C%7C%7C%7C%7C-1%5E-14636.1825%7C%7C%7C20190214203700%7C(K85.002)%E6%80%A5%E6%80%A7%E7%89%B9%E5%8F%91%E6%80%A7%E8%83%B0%E8%85%BA%E7%82%8E%EF%BC%8C%E9%87%8D%E7%97%87%2C(K85.002)%E6%80%A5%E6%80%A7%E7%89%B9%E5%8F%91%E6%80%A7%E8%83%B0%E8%85%BA%E7%82%8E%EF%BC%8C%E9%87%8D%E7%97%87%7C%5E%5E%5E%7C%5E%5E%7C20190214211336%7C%7C7133%5E%E9%BE%99%E5%A4%A7%E8%90%A5%0DZ01%7C55996001%7C330201023%7C%E3%80%90%E5%BC%80%E6%94%BE%E6%80%A7%E9%A2%85%E8%84%91%E6%8D%9F%E4%BC%A4%E6%B8%85%E9%99%A4%E6%9C%AF%E3%80%91%7C%7C0%7CIP%7C1639282%5E1%5E2016%5E14%7C20190710111200%7C806%5E%E6%89%8B%E6%9C%AF%E5%AE%A4%7C%5E%7C%7C%7C2016%5E%E6%99%AE%E9%80%9A%E5%A4%96%E7%A7%91%7C671%5E193%E6%B5%8B%E8%AF%95%E5%91%98%7C%5E%7C%5E%7C%7C%7C330100008%5E%E5%9F%BA%E7%A1%80%E9%BA%BB%E9%86%89%7C%5E%7C%7C%7C%5E%7C%7C%7C%7C%7C%5E%7C%7C%7C%7C%7C%7C20190710111200%7C%5E193%E6%B5%8B%E8%AF%95%E5%91%98%7C(K85.002)%E6%80%A5%E6%80%A7%E7%89%B9%E5%8F%91%E6%80%A7%E8%83%B0%E8%85%BA%E7%82%8E%EF%BC%8C%E9%87%8D%E7%97%87%7C%0DZ02%7C1%7C%7C%7C%1c%0d</apply_data></req>");
//
//        List<PatientLink> patientLinkList =heZhouGuangJiServer.getOprationFromHis();
//
//        List<Account> accountList =heZhouGuangJiServer.getAccountFromHis();
//
//        List<ConfigDepartments> configDepartmentsList =heZhouGuangJiServer.getDepartmentFromHis();
//        HeZhouGuangJiServer guangJiServer = new HeZhouGuangJiServer();
//        guangJiServer.RecieveMessages("<req>" +
//                "<apply_data>" +
//                "%0bMSH%7C%5E~%26%7CHIS%7C%7Ctarno%5E1011%7C%7C20190731122258%7C%7CZDM%5ERES%7CZDM_RES-20190731122258.865999%7CP%7C2.4%7C%7C%7CNE%7CAL%7C%7C%7C%7C%7C%0DZD1%7C1011%7C1%7C1%7C009835%7C%7C%E5%BB%96%E6%B2%A1la%7C%7C%7C20190731122010%7C20190731122010%7CI%7C0%7C11135%7C%0DZD2%7C1%7C1%7CLMLA%7C%E7%94%B7%7C%7C%7C%7C%7C%7C%E4%B8%BB%E6%B2%BB%E5%8C%BB%E5%B8%88%7C%7C110%7C%7C%7C%7C%E6%B1%89%E6%97%8F%7C%7C%7C%7C%7C%7C%E5%85%B6%E4%BB%96%7C%7C%7C%7C%7C553%7C%E9%BA%BB%E9%86%89%E6%89%8B%E6%9C%AF%E9%83%A8%7C1%7C%7C%1c%0d" +
//                "</apply_data>" +
//                "</req>");
//        guangJiServer.RecieveMessages("<req>" +
//                "<apply_data>" +
//                "%0bMSH%7C%5E~%26%7CHIS%7C%7Ctarno%5E1012%7C%7C20190801131648%7C%7CZDM%5ERES%7CZDM_RES-20190801131648.738837%7CP%7C2.4%7C%7C%7CNE%7CAL%7C%7C%7C%7C%7C%0DZD1%7C1012%7C1%7C1%7C910%7C9%7C%E5%81%A5%E5%BA%B7%E7%9A%84%E6%83%8A%E6%81%90%E5%9C%B0%7C%7C%7C20190801131646%7C20190801131646%7CI%7C0%7C3341%7C1047%1c%0d" +
//                "</apply_data>" +
//                "</req>");


        int i = 0;
        i++;

        Object implementor = new HeZhouGuangJiServer ();
        //String address = Constants.HOST_HEZHOUGUANGJISERVER + "/HeZhouGuangJiServer";
        String address = "http://localhost:8080/Anes_WebService/services/HeZhouGuangJiServer";
        Endpoint.publish(address, implementor);

    }

    @WebMethod
    public PatientLink getPatientInfoFromHisByID(String patientdId){
        PatientLink patientLink = new PatientLink();
        QRY_A19 qryA19 = new QRY_A19();
        try {
            qryA19.getMSH().getSendingApplication().getHd1_NamespaceID().setValue(Constants.TAG_SYSTEM_LOCAL);
            qryA19.getQRD().getQueryPriority().setValue("IP");
            //226430
            qryA19.getQRD().getQueryID().setValue(patientdId);
            ADR_A19 adrA19 = MsgDealUtil.getPatientInfoFromHis(qryA19,Constants.TAG_SYSTEM_REMOTE,Constants.KEY_PATIENTINFO_CMD);
            MsgDealUtil.getPID(adrA19,adrA19.getPID(),patientLink);
            MsgDealUtil.getPV1(adrA19,adrA19.getPV1(),patientLink);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patientLink;
    }

    @WebMethod
    public JianYan getJianYanFromHisForLis(String patientdId){
        QRY_R02 qryR02 = new QRY_R02();
        try {
            qryR02.getMSH().getSendingApplication().getHd1_NamespaceID().setValue(Constants.TAG_SYSTEM_LOCAL);
            qryR02.getQRD().getQueryPriority().setValue("IP");
            qryR02.getQRD().getQueryID().setValue(patientdId);
            qryR02.getQRF().getWhenDataStartDateTime().getTs1_TimeOfAnEvent().setValue(new SimpleDateFormat("yyyymmddhhmmss").format(new Date()));
            qryR02.getQRF().getWhenDataEndDateTime().getTs1_TimeOfAnEvent().setValue(new SimpleDateFormat("yyyymmddhhmmss").format(new Date()));
            ZDM_Z08 zdmZ08 = MsgDealUtil.getLisInfoFromHisByPid(qryR02, Constants.TAG_SYSTEM_REMOTE, Constants.KEY_GETLISINFOBYPID_CMD);
            List<Structure> structureList = MsgDealUtil.getStructureList(zdmZ08, ZD11.class);
            List<JYBigItem> jyBigItemList = new ArrayList<>();
            List<JYSmallItem> jySmallItemList = new ArrayList<>();
            for (int i = 0; i < structureList.size(); i++) {
                ZD11 zd11 = (ZD11) structureList.get(i);

                if (!zd11.isEmpty()) {
                    JYBigItem jyBigItem = new JYBigItem();
                    jyBigItem.applyId = zd11.getApplicationId().getValue();
                    jyBigItem.patientId = patientdId;
                    jyBigItem.jyContent = zd11.getInspectionContent().getValue();
                    jyBigItem.shenHeDate = zd11.getReportReviewTime().getValue();
                    jyBigItemList.add(jyBigItem);

                    QRY_R02 qryR02Detail = new QRY_R02();
                    qryR02Detail.getMSH().getSendingApplication().getHd1_NamespaceID().setValue(Constants.TAG_SYSTEM_LOCAL);
                    qryR02Detail.getQRD().getQueryPriority().setValue("OI");
                    qryR02Detail.getQRD().getQueryID().setValue(zd11.getApplicationId().getValue());
                    ZDM_Z09 zdmZ09 = MsgDealUtil.getDetailLisInfoFromHisByPid(qryR02Detail, Constants.TAG_SYSTEM_REMOTE, Constants.KEY_GETDETAILLISINFOBYPID_CMD);
                    List<Structure> structureDetailList = MsgDealUtil.getStructureList(zdmZ09, ZD12.class);
                    for (int j = 0; j < structureDetailList.size(); j++) {
                        ZD12 zd12 = (ZD12) structureDetailList.get(j);
                        JYSmallItem jySmallItem = new JYSmallItem();
                        //检查小项名称
                        jySmallItem.eName = zd12.getObservationSubitem().getValue();
                        //检查内容
                        jySmallItem.cName = zd11.getInspectionContent().getValue();
                        //检查小项编码
                        jySmallItem.code = zd12.getObservationIdentifier().getIdentifier().getValue();
                        //取值偏高还是偏低,检查状态
                        jySmallItem.abnormalFlags = zd12.getObservationStatus().getValue();
                        //正常值范围
                        jySmallItem.referRange = zd12.getReferenceInterval().getValue();
                        //检查值
                        jySmallItem.vlue = zd12.getObservationValue().getValue();
                        //检查单位
                        jySmallItem.unit = zd12.getResultValueUnit().getIdentifier().getValue();
                        //分析日期/日期
                        jySmallItem.time = zd12.getAnalysisDate().getValue();
                        //值类型
                        jySmallItem.abb02 = zd12.getValueType().getValue();
                        if (!zd12.isEmpty()) {
                            jySmallItemList.add(jySmallItem);
                        }
                    }
                }
            }
            return LisDataHeZhouGuangJi.getInstance().getListDataFromHis(jyBigItemList, jySmallItemList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new JianYan();
    }

    public void getJianYanFromHisForPacs(String patientdId,List<JYBigItem> jyBigItemList,List<JYSmallItem> jySmallItemList) {
        QRY_R02 qryR02 = new QRY_R02();
        try {
            qryR02.getMSH().getSendingApplication().getHd1_NamespaceID().setValue(Constants.TAG_SYSTEM_LOCAL);
            qryR02.getQRD().getQueryPriority().setValue("IP");
            qryR02.getQRD().getQueryID().setValue(patientdId);
            qryR02.getQRF().getWhenDataStartDateTime().getTs1_TimeOfAnEvent().setValue(new SimpleDateFormat("yyyymmddhhmmss").format(new Date()));
            qryR02.getQRF().getWhenDataEndDateTime().getTs1_TimeOfAnEvent().setValue(new SimpleDateFormat("yyyymmddhhmmss").format(new Date()));
            ZDM_Z10 zdmZ10 = MsgDealUtil.getPacsInfoFromHisByPid(qryR02, Constants.TAG_SYSTEM_REMOTE, Constants.KEY_GETPACSINFOBYPID_CMD);
            List<Structure> structureList = MsgDealUtil.getStructureList(zdmZ10, ZD13.class);
            for (int i = 0; i < structureList.size(); i++) {
                ZD13 zd13 = (ZD13) structureList.get(i);
                if (!zd13.isEmpty()) {
                    JYBigItem jyBigItem = new JYBigItem();
                    jyBigItem.applyId = zd13.getApplicationId().getValue();
                    jyBigItem.patientId = patientdId;
                    jyBigItem.jyContent = zd13.getInspectionContent().getValue();
                    jyBigItem.shenHeDate = zd13.getReportReviewTime().getValue();
                    jyBigItemList.add(jyBigItem);
                    QRY_R02 qryR02Detail = new QRY_R02();
                    qryR02Detail.getMSH().getSendingApplication().getHd1_NamespaceID().setValue(Constants.TAG_SYSTEM_LOCAL);
                    qryR02Detail.getQRD().getQueryPriority().setValue("OI");
                    qryR02Detail.getQRD().getQueryID().setValue(zd13.getApplicationId().getValue());
                    ZDM_Z11 zdmZ11 = MsgDealUtil.getPacsDetailedInfoFromHisByPid(qryR02Detail, Constants.TAG_SYSTEM_REMOTE, Constants.KEY_GETDETAILPACSINFOBYPID_CMD);
                    List<Structure> structureDetailList = MsgDealUtil.getStructureList(zdmZ11, ZD14.class);
                    for (int j = 0; j < structureDetailList.size(); j++) {
                        ZD14 zd14 = (ZD14) structureDetailList.get(j);
                        JYSmallItem jySmallItem = new JYSmallItem();
                        //检查小项名称
                        jySmallItem.eName = zd14.getObservationSubitem().getValue();
                        //检查内容
                        jySmallItem.cName = zd13.getInspectionContent().getValue();
                        //检查小项编码
                        jySmallItem.code = zd14.getObservationIdentifier().getIdentifier().getValue();
                        //取值偏高还是偏低,检查状态
                        jySmallItem.abnormalFlags = zd14.getObservationStatus().getValue();
                        //正常值范围
                        jySmallItem.referRange = zd14.getReferenceInterval().getValue();
                        //检查值
                        jySmallItem.vlue = zd14.getObservationValue().getValue();
                        //检查单位
                        jySmallItem.unit = zd14.getResultValueUnit().getIdentifier().getValue();
                        //分析日期/日期
                        jySmallItem.time = zd14.getAnalysisDate().getValue();
                        //值类型
                        jySmallItem.abb02 = zd14.getValueType().getValue();
                        if (!zd14.isEmpty()) {
                            jySmallItemList.add(jySmallItem);
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void addOperation(List<PatientLink> hisPatientLinkList){
        List<PatientLink> patientLinkList = SpringUtils.getBean(PatientLinkDao.class).getScheduleTableOpers();
        if (null != patientLinkList && patientLinkList.size() != 0) {
            for (int i = 0; i < hisPatientLinkList.size(); i++) {
                if(StringUtil.isEmpty(hisPatientLinkList.get(i).getApplication().getSssqdh())){
                    continue;
                }
                boolean addFlag = true;
                for (int j = 0; j < patientLinkList.size(); j++) {
                    if (hisPatientLinkList.get(i)!=null && patientLinkList.get(j) != null && hisPatientLinkList.get(i).getApplication().getSssqdh().equals(patientLinkList.get(j).getApplication().getSssqdh())) {
                        addFlag = false;
                        SpringUtils.getBean(PatientLinkDao.class).findAndUpdate(new Criteria(hisPatientLinkList.get(i).getApplication().getSssqdh()), Update.update(hisPatientLinkList.get(i).getApplication().getSssqdh(), hisPatientLinkList.get(i)));
                        break;
                    }
                }
                if (addFlag) {
                    SpringUtils.getBean(PatientLinkDao.class).addUpdate(hisPatientLinkList.get(i));
                }
            }
        } else {
            for (PatientLink patientLink : hisPatientLinkList) {
                String hisOperId = patientLink.getHisID();
                boolean addFlag = true;
                for (PatientLink dbPatientLink : patientLinkList) {
                    String dbOperId = dbPatientLink.getHisID();
                    if (null != dbOperId && dbOperId.equals(hisOperId)) {
                        addFlag = false;
                        break;
                    }
                }
                if (addFlag) {
                    SpringUtils.getBean(PatientLinkDao.class).addUpdate(patientLink);
                }
            }
        }
    }

    @WebMethod
    public List<PatientLink> retOprationFromHis(){
        return SpringUtils.getBean(HisLinkHeZhouGuangJi.class).getOprationFromHis();
    }

    @WebMethod
    public void updateOperationStatus(String hisOperId, String operStatus){

    }

    @WebMethod
    public ArrayList<Account> retAccountFromHis(){
//        ZDM_REQ zdmReq = new ZDM_REQ();
//        try {
//            zdmReq.getMSH().getSendingApplication().getHd1_NamespaceID().setValue(Constants.TAG_SYSTEM_LOCAL);
//        } catch (DataTypeException e) {
//            e.printStackTrace();
//        }
//        ZDM_RES zdmRes = MsgDealUtil.getBaseInformationFromHis(zdmReq,Constants.TAG_SYSTEM_REMOTE,Constants.KEY_ACOUNT_CMD);
        ArrayList<Account> accountList = SpringUtils.getBean(HisLinkHeZhouGuangJi.class).getAccountFromHis();
        return accountList;
    }

    @WebMethod
    public boolean updateScheduleInfo(PatientLink patientLink){
        boolean isSuccess = false;
        if(patientLink != null){
            ZDM_Z02 zdm_z02 = new ZDM_Z02();
            ACK_R01 ackR01;
            try {
                zdm_z02.getMSH().getSendingApplication().getHd1_NamespaceID().setValue(Constants.TAG_SYSTEM_LOCAL);
                MsgDealUtil.setZ01(zdm_z02,zdm_z02.getZ01(),patientLink);
                if(StringUtil.isEmpty(patientLink.getSchedule().getSyncStatu())
                        ||patientLink.getSchedule().getSyncStatu().equals(Constants.KEY_INSERT_ERROR_MSG))
                {
                    //如果没有成功过，那就是新增
                    ackR01 = MsgDealUtil.sendOprationScheduleToHis(zdm_z02, Constants.TAG_SYSTEM_REMOTE, Constants.KEY_OPERATIONSCHEDULED_CMD);
                    if (ackR01 != null) {
                        if (Constants.KEY_SUCCESS_MSG.equals(ackR01.getMSA().getAcknowledgementCode().getValue())) {
                            patientLink.getSchedule().setSyncStatu(Constants.KEY_SUCCESS_MSG);
                            isSuccess = true;
                        }else{
                            patientLink.getSchedule().setSyncStatu(Constants.KEY_INSERT_ERROR_MSG);
                            isSuccess = false;
                        }
                    }
                }else if(patientLink.getSchedule().getSyncStatu().equals(Constants.KEY_SUCCESS_MSG)
                        ||patientLink.getSchedule().getSyncStatu().equals(Constants.KEY_UPDATE_ERROR_MSG)){
                    //如果有成功信息，OAAS发送手术排班变更信息
                    ackR01 = MsgDealUtil.sendOprationScheduleToHis(zdm_z02, Constants.TAG_SYSTEM_REMOTE, Constants.KEY_OPERATIONSCHEDULESTATUS_CMD);
                    if (ackR01 != null) {
                        if (Constants.KEY_SUCCESS_MSG.equals(ackR01.getMSA().getAcknowledgementCode().getValue())) {
                            patientLink.getSchedule().setSyncStatu(Constants.KEY_SUCCESS_MSG);
                            isSuccess = true;
                        }else{
                            patientLink.getSchedule().setSyncStatu(Constants.KEY_UPDATE_ERROR_MSG);
                            isSuccess = false;
                        }
                    }
                }
                if(!StringUtil.isEmpty(patientLink.getSchedule().getSyncStatu())
                        &&!StringUtil.isEmpty(patientLink.getApplication().getSssqdh())
                        &&!StringUtil.isEmpty(patientLink.getId())) {
                    SpringUtils.getBean(PatientLinkDao.class).addUpdateOneField(patientLink, "schedule.operStatu", patientLink.getSchedule().getOperStatu());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isSuccess;
    }

    @WebMethod
    public boolean addScheduleInfo(String patientLinkId){
        PatientLink patientLink = SpringUtils.getBean(PatientLinkDao.class).getScheduleByPLinkId(patientLinkId);
        return false;
    }

    @WebMethod
    public ArrayList<ConfigDepartments> retDepartmentFromHis(){
//        ZDM_REQ zdmReq = new ZDM_REQ();
//        try {
//            zdmReq.getMSH().getSendingApplication().getHd1_NamespaceID().setValue(Constants.TAG_SYSTEM_LOCAL);
//        } catch (DataTypeException e) {
//            e.printStackTrace();
//        }
//        ZDM_RES zdmRes = MsgDealUtil.getBaseInformationFromHis(zdmReq,Constants.TAG_SYSTEM_REMOTE,Constants.KEY_DEPARTMENT_CMD);
        ArrayList<ConfigDepartments> configDepartmentsList = SpringUtils.getBean(HisLinkHeZhouGuangJi.class).getDepartmentFromHis();
        return configDepartmentsList;
    }

    @WebMethod
    public boolean writeEndOper2HIS(PatientLink patientLink){
        return false;
    }

    @WebMethod
    public boolean addEndOper2HISUpateBatch(List<PatientLink> patientLinks){
        return false;
    }

    @WebMethod
    public LisData getLisData(String zyh, String name){
        return null;
    }

    @WebMethod
    public String retMazuiDocDeptCode(){
        return null;
    }

    @WebMethod
    public String retMazuiDocDeptName(){
        return null;
    }

    @WebMethod
    public String retNurseDeptCode(){
        return null;
    }

    @WebMethod
    public String retNurseDeptName(){
        return null;
    }

    @WebMethod
    public boolean retBGAEnable(){
        return false;
    }

    @WebMethod
    public List<PojoBGA> getBGA(String zyh, Date startTime, Date endTime){
        List<PojoBGA> pojoBGAList = new ArrayList<>();
        return pojoBGAList;
    }

    @WebMethod
    public boolean writeOperSchedule2HISUpateBatch(List<PatientLink> patientLinks) {
        return false;
    }

    @WebMethod
    public boolean sendOperationInformation(PatientLink patientLink) {

        boolean isSuccess = false;
        if(patientLink != null){
            ZDM_Z22 zdm_z22 = new ZDM_Z22();
            ACK_R01 ackR01;
            try {
                zdm_z22.getMSH().getSendingApplication().getHd1_NamespaceID().setValue(Constants.TAG_SYSTEM_LOCAL);
                MsgDealUtil.setZM01(zdm_z22,zdm_z22.getZM01(),patientLink);
                if(patientLink.getPatientEventsList().size() > 0) {
                    for (int i = 0; i < patientLink.getPatientEventsList().size(); i++) {
                        ZM02 zm02 = (ZM02) zdm_z22.get(ZM02.class.getSimpleName(), i);
                        MsgDealUtil.setZM02(zdm_z22, zm02, patientLink.getPatientEventsList().get(i), patientLink);
                    }
                }else{
                    ZM02 zm02 = (ZM02) zdm_z22.get(ZM02.class.getSimpleName(), 0);
                    MsgDealUtil.setZM02(zdm_z22, zm02, null, patientLink);
                }
                if(patientLink.getPatientDrugsList().size() > 0) {
                    for (int i = 0; i < patientLink.getPatientDrugsList().size(); i++) {
                        Drugs drugs = patientLink.getPatientDrugsList().get(i).getDrugs();
                        if (drugs != null) {
                            ZM03 zm03 = (ZM03) zdm_z22.get(ZM03.class.getSimpleName(), i);
                            List<Item> items = drugs.getItems();
                            for (Item item : items) {
                                MsgDealUtil.setZM03(zdm_z22, zm03, item, patientLink.getPatientDrugsList().get(i), patientLink);
                            }
                        }
                    }
                }else{
                    ZM03 zm03 = (ZM03) zdm_z22.get(ZM03.class.getSimpleName(), 0);
                    MsgDealUtil.setZM03(zdm_z22, zm03, null, null, patientLink);
                }
                ackR01 = MsgDealUtil.sendOperationInformation(zdm_z22, Constants.TAG_SYSTEM_REMOTE, Constants.KEY_OPERATIONINFO_CMD);
                if (ackR01 != null) {
                    if (Constants.KEY_SUCCESS_MSG.equals(ackR01.getMSA().getAcknowledgementCode().getValue())) {
                        isSuccess = true;
                    }
                    patientLink.setSyncStatu(StringUtil.nullToSpace(ackR01.getMSA().getAcknowledgementCode().getValue()));
                    if(!StringUtil.isEmpty(patientLink.getApplication().getSssqdh())
                            &&!StringUtil.isEmpty(patientLink.getId())) {
                        SpringUtils.getBean(PatientLinkDao.class).addUpdateOneField(patientLink, "syncStatu", patientLink.getSyncStatu());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isSuccess;
    }

    @WebMethod
    public boolean sendOperationRoomInformation(PatientLink patientLink) {
        boolean isSuccess = false;
        if(patientLink != null){
            ZDM_Z23 zdm_z23 = new ZDM_Z23();
            ACK_R01 ackR01;
            try {
                zdm_z23.getMSH().getSendingApplication().getHd1_NamespaceID().setValue(Constants.TAG_SYSTEM_LOCAL);
                MsgDealUtil.setSJ01(zdm_z23,zdm_z23.getSJ01(),patientLink);
                if(StringUtil.isEmpty(patientLink.getSchedule().getSyncStatu())
                        ||patientLink.getSchedule().getSyncStatu().equals(Constants.KEY_INSERT_ERROR_MSG))
                {
                    ackR01 = MsgDealUtil.sendOperationRoomInformation(zdm_z23, Constants.TAG_SYSTEM_REMOTE, Constants.KEY_OPERATIONROOMINFO_CMD);
                    if (ackR01 != null) {
                        if (ackR01.getMSA().getAcknowledgementCode().getValue().equals(Constants.KEY_SUCCESS_MSG)) {
                            isSuccess = true;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isSuccess;
    }

    @WebMethod
    public boolean sendAnesthesiaMethodInformation(ConfigAnesMethods configAnesMethods) {
        boolean isSuccess = false;
        if(configAnesMethods != null){
            ZDM_Z24 zdm_z24 = new ZDM_Z24();
            ACK_R01 ackR01;
            try {
                zdm_z24.getMSH().getSendingApplication().getHd1_NamespaceID().setValue(Constants.TAG_SYSTEM_LOCAL);
                MsgDealUtil.setMZ01(zdm_z24,zdm_z24.getMZ01(),configAnesMethods);
                ackR01 = MsgDealUtil.sendAnesthesiaMethodInformation(zdm_z24, Constants.TAG_SYSTEM_REMOTE, Constants.KEY_ANESTHESIAMETHODINFO_CMD);
                if (ackR01 != null) {
                    if (ackR01.getMSA().getAcknowledgementCode().getValue().equals(Constants.KEY_SUCCESS_MSG)) {
                        isSuccess = true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return isSuccess;
    }

}
