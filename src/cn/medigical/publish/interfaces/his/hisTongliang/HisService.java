package cn.medigical.publish.interfaces.his.hisTongliang;


import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.dao.impl.PatientLisDataDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigDepartmentsDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigDrugsDao;
import cn.medigical.publish.interfaces.his.hisLink.HisLinkFactory;
import cn.medigical.publish.interfaces.lis.LisData;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.dictionary.ConfigDepartments;
import cn.medigical.publish.pojo.lis.JianYan;
import cn.medigical.publish.pojo.patient.PatientLisData;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.utils.Constants;
import cn.medigical.publish.utils.SpringUtils;
import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;

import java.util.*;

public class HisService {
    protected Logger logger = Logger.getLogger("HisService");
    PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);
    AccountDao accountDao = (AccountDao) SpringUtils.getBean(AccountDao.class);
    ConfigDepartmentsDao configDepartmentsDao = SpringUtils.getBean(ConfigDepartmentsDao.class);
    ConfigDrugsDao configDrugsDao = SpringUtils.getBean(ConfigDrugsDao.class);
    PatientLisDataDao patientLisDataDao = SpringUtils.getBean(PatientLisDataDao.class);

    /**
     * 从His中提取数据
     */
    public Boolean getOprationFromHis() {
        Boolean flag = false;
//        // 获取his端的手术申请
//        List<PatientLink> hisPatientLinkList = HisLinkFactory.getInstance().getHisLink().getOprationFromHis();
//        System.out.println("hisPatientLinkList:" + hisPatientLinkList.size());
//        Map<String, PatientLink> filterPatientLinkMap = new HashMap<>();
//        for (PatientLink patientLink : hisPatientLinkList) {
//        	System.out.println(patientLink.getPatient().getBrxm());
//            filterPatientLinkMap.put(patientLink.getApplication().getSssqdh(), patientLink);
//        }
//        // System.out.println("筛选手术:" + filterAccountMap);
//        System.out.println("筛选手术数量:" + filterPatientLinkMap.size());
//
//        if (null == filterPatientLinkMap || filterPatientLinkMap.size() == 0) {
//            return false;
//        }
//        List<PatientLink> newPatientList = new ArrayList();
//        for (String hisID : filterPatientLinkMap.keySet()) {
//            newPatientList.add(filterPatientLinkMap.get(hisID));
//        }
//
//        // 获取当前数据库的手术申请
//        List<PatientLink> patientLinkList = patientLinkDao.getScheduleTableOpers();
//       
//        if (null != patientLinkList && patientLinkList.size() != 0) {
//            for (int i = 0; i < newPatientList.size(); i++) {
////            	System.out.println("his:"+i+"--"+newPatientList.get(i).getApplication().getSssqdh());
//                boolean addFlag = true;
//                for (int j = 0; j < patientLinkList.size(); j++) {
////                	System.out.println("loc:"+j+"--"+patientLinkList.get(j).getApplication().getSssqdh());
//                    if (newPatientList.get(i).getApplication().getSssqdh().equals(patientLinkList.get(j).getApplication().getSssqdh())) {
//                        addFlag = false;
//                        //更新数据库
// //                       patientLinkDao.findAndUpdate(new Criteria(newPatientList.get(i).getApplication().getSssqdh()), Update.update(newPatientList.get(i).getApplication().getSssqdh(), newPatientList.get(i)));
//                        break;
//                    }
//                }
//                if (addFlag) {
// //               	patientLinkDao.addUpdate(newPatientList.get(i));
//                }
//            }
////            System.out.println("local:"+patientLinkList.size());
//        } else {
//            for (PatientLink patientLink : newPatientList) {
//                String hisOperId = patientLink.getHisID();
//                boolean addFlag = true;
//                for (PatientLink dbPatientLink : patientLinkList) {
//                    String dbOperId = dbPatientLink.getHisID();
//                    if (null != dbOperId && dbOperId.equals(hisOperId)) {
//                        addFlag = false;
//                        break;
//                    }
//                }
//                if (addFlag) {
// //               	patientLinkDao.addUpdate(patientLink);
//                }
//            }
//        }
        try {

            // 获取his端的手术申请
            List<PatientLink> hisPatientLinkList = HisLinkFactory.getInstance().getHisLink().getOprationFromHis();

            System.out.println("hisPatientLinkList:" + hisPatientLinkList.size());
            // 获取当前数据库的手术申请
            List<PatientLink> patientLinkList = patientLinkDao.getScheduleTableOpers();
            System.out.println("patientLinkList:" + patientLinkList.size());
            if (null == hisPatientLinkList || hisPatientLinkList.size() == 0) {
                flag = false;
                return flag;
            } else {
                if (null != patientLinkList && patientLinkList.size() != 0) {
                    for (int i = 0; i < hisPatientLinkList.size(); i++) {
                        System.out.println("hisPatientLinkList:" + hisPatientLinkList.get(i).getPatient().getBrxm());
                        boolean addFlag = true;
                        for (int j = 0; j < patientLinkList.size(); j++) {
                            if (hisPatientLinkList.get(i).getApplication().getSssqdh().equals(patientLinkList.get(j).getApplication().getSssqdh())) {
                                addFlag = false;
                                // 更新数据库
//                                if (patientLinkList.get(j).getApplication().getDetailstatus() != null && patientLinkList.get(j).getApplication().getDetailstatus().equals(Constants.OR_STATUS_FLAG_SCHEDULED)) {
//                                    patientLinkDao.addUpdateApplication(hisPatientLinkList.get(i), patientLinkList.get(j));
//                                    patientLinkDao.addUpdateSchedule(hisPatientLinkList.get(i), patientLinkList.get(j));
//                                }
//                               /* patientLinkDao.findAndUpdate(Criteria.where("application.ssssdh").is(hisPatientLinkList.get(i).getApplication().getSssqdh()), Update.update("application", hisPatientLinkList.get(i).getApplication()));
//                                patientLinkDao.findAndUpdate(new Criteria(hisPatientLinkList.get(i).getApplication().getSssqdh()), Update.update("schedule", hisPatientLinkList.get(i).getSchedule()));*/
                                break;
                            }
                        }
                        if (addFlag) {
                            this.logger.warn("正在向数据库插入病人"+hisPatientLinkList.get(i).getPatient().getBrxm());
                            patientLinkDao.addUpdate(hisPatientLinkList.get(i));
                        }
                    }
                } else {
                    for (PatientLink patientLink : hisPatientLinkList) {
                        this.logger.warn("正在向数据库插入病人"+patientLink.getPatient().getBrxm());
                        patientLinkDao.addUpdate(patientLink);
                    }
                }
            }
            flag = true;
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean getAccountFromHis() {
        Boolean flag;
        List<Account> newAcconutList = new ArrayList<>();
        List<Account> accountListFromHis = HisLinkFactory.getInstance().getHisLink().getAccountFromHis();
        // System.out.println("His账号:" + accountListFromHis);
        System.out.println("His账号数量:" + accountListFromHis.size());

        Map<String, Account> filterAccountMap = new HashMap<>();
        for (Account accountFrom : accountListFromHis) {
            filterAccountMap.put(accountFrom.getWorkID(), accountFrom);
        }
        // System.out.println("筛选账号:" + filterAccountMap);
        System.out.println("筛选账号数量:" + filterAccountMap.size());

        if (null == filterAccountMap || filterAccountMap.size() == 0) {
            return false;
        }
        List<Account> accountListFromDb = accountDao.gets();
        // System.out.println("现有账号:" + accountListFromDb);
        System.out.println("现有账号数量:" + accountListFromDb.size());

        if (accountListFromDb != null) {
            for (String workID : filterAccountMap.keySet()) {
                flag = false;
                for (int j = 0; j < accountListFromDb.size(); j++) {
                    if (null != accountListFromDb.get(j).getWorkID())
                        if (accountListFromDb.get(j).getWorkID().equals(filterAccountMap.get(workID).getWorkID())) {
                            flag = true;
                        }
                }
                if (!flag) {
                    newAcconutList.add(filterAccountMap.get(workID));
                }
            }
        }
        accountDao.addAll(newAcconutList);
        return false;
    }

    public Boolean getAllDepartment() {
        Boolean flag;
        List<ConfigDepartments> newAcconutList = new ArrayList<>();
        List<ConfigDepartments> departmentListFromHis = HisLinkFactory.getInstance().getHisLink()
                .getDepartmentFromHis();
        System.out.println("departmentListFromHis:" + departmentListFromHis);
        System.out.println("departmentListFromHis:" + departmentListFromHis.size());
        List<ConfigDepartments> departmentListFromDb = configDepartmentsDao.getAll();
        if (departmentListFromHis == null) {
            flag = false;
            return flag;
        } else {
            for (int i = 0; i < departmentListFromHis.size(); i++) {
                boolean addFlag = false;
                for (int j = 0; j < departmentListFromDb.size(); j++) {
                    if (departmentListFromDb.get(j).getCode().equals(departmentListFromHis.get(i).getCode())) {
                        addFlag = true;
                    }
                }
                if (!addFlag) {
                    newAcconutList.add(departmentListFromHis.get(i));
                }
            }
            configDepartmentsDao.addAll(newAcconutList);
            flag = true;
            return flag;
        }
    }

    public Boolean getLisDateTongLiang(String pid, String zyh, String name) {
        LisData lisData = HisLinkFactory.getInstance().getHisLink().getLisData(zyh, name);
        JianYan jianyan = new JianYan();
        if (lisData != null) {
            jianyan.setHIV(lisData.getHIV() == null ? "" : lisData.getHIV());
            jianyan.setHCV(lisData.getHCV() == null ? "" : lisData.getHCV());
            jianyan.setHbsag(lisData.getHBsAg() == null ? "" : lisData.getHBsAg());
            jianyan.setTpab(lisData.getTP() == null ? "" : lisData.getTP());
            jianyan.setHb((lisData.getHb() == null ? "" : lisData.getHb()) + (lisData.getHCT() == null ? "" : "/" + lisData.getHCT()));
            jianyan.setWbc(lisData.getWBC() == null ? "（-）" : lisData.getWBC());
            jianyan.setPlt(lisData.getPLT() == null ? "（-）" : lisData.getPLT());
            jianyan.setK(lisData.getK() == null ? "（-）" : lisData.getK());
            jianyan.setNA(lisData.getNA() == null ? "（-）" : lisData.getNA());
            jianyan.setCL(lisData.getCL() == null ? "（-）" : lisData.getCL());
            jianyan.setGLU(lisData.getGLU() == null ? "（-）" : lisData.getGLU());
            jianyan.setALT(lisData.getALT() == null ? "（-）" : lisData.getALT());
            jianyan.setBUN(lisData.getBUN() == null ? "（-）" : lisData.getBUN());
            jianyan.setCr(lisData.getCr() == null ? "（-）" : lisData.getCr());
            jianyan.setPT(lisData.getPT() == null ? "（-）" : lisData.getPT());
            jianyan.setAPTT(lisData.getAPTT() == null ? "（-）" : lisData.getAPTT());
            jianyan.setPAO2(lisData.getPAO2() == null ? "（-）" : lisData.getPAO2());
        } else {

        }
        System.out.println(jianyan);
        PatientLisData patientLisData = patientLisDataDao.getPatientLisData8PatientId(pid);
        System.out.println(patientLisData);
        if (patientLisData == null) {
            patientLisData = new PatientLisData();
        }
        patientLisData.setZyh(zyh);
        patientLisData.setPatientID(pid);
        patientLisData.setJianYan(jianyan);
        if (jianyan != null) {
            patientLisData.setResult(true);
        } else {
            patientLisData.setResult(false);
        }
        patientLisData.setBeginTime(new Date());
        patientLisDataDao.addUpdate(patientLisData);

        return true;
    }
}
