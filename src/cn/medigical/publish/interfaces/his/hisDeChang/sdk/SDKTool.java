//package cn.medigical.publish.interfaces.his.hisDeChang.sdk;
//
//import cn.medigical.publish.dao.impl.AccountDao;
//import cn.medigical.publish.dao.impl.PatientLinkDao;
//import cn.medigical.publish.dao.impl.PatientLisDataDao;
//import cn.medigical.publish.dao.impl.dictionary.ConfigDepartmentsDao;
//import cn.medigical.publish.pojo.Account;
//import cn.medigical.publish.pojo.dictionary.ConfigDepartments;
//import cn.medigical.publish.pojo.lis.JianYan;
//import cn.medigical.publish.pojo.lis.LisReport;
//import cn.medigical.publish.pojo.lis.LisReportDetail;
//import cn.medigical.publish.pojo.patient.PatientLisData;
//import cn.medigical.publish.pojo.patientLink.PatientLink;
//import cn.medigical.publish.utils.SpringUtils;
//import org.apache.log4j.Logger;
//import org.springframework.data.mongodb.core.query.Criteria;
//import org.springframework.data.mongodb.core.query.Update;
//
//import java.math.BigDecimal;
//import java.util.*;
//
//public class SDKTool {
//    protected static Logger logger = Logger.getLogger("HisService");
//    static String patientNo = "";
//    static AccountDao accountDao = SpringUtils.getBean(AccountDao.class);
//    static PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);
//    static ConfigDepartmentsDao configDepartmentsDao = SpringUtils.getBean(ConfigDepartmentsDao.class);
//    static PatientLisDataDao patientLisDataDao = SpringUtils.getBean(PatientLisDataDao.class);
//    static JianYan jianYan = null;
//
//    public static void judge(String fid, String message) {
//        //patientNo = "";
//        switch (fid) {
//            //科室视图
//            case "BS02001": {
//                List<ConfigDepartments> newAcconutList = new ArrayList<>();
//                List<ConfigDepartments> departmentListFromHis = SDKParse.parseDepartmentXml(message);
//                List<ConfigDepartments> departmentListFromDb = configDepartmentsDao.getAll();
//
//                for (int i = 0; i < departmentListFromHis.size(); i++) {
//                    boolean flag = false;
//                    for (int j = 0; j < departmentListFromDb.size(); j++) {
//                        if (departmentListFromDb.get(j).getCode().equals(departmentListFromHis.get(i).getCode())) {
//                            flag = true;
//                        }
//                    }
//                    if (!flag) {
//                        newAcconutList.add(departmentListFromHis.get(i));
//                    }
//                }
//
//                configDepartmentsDao.addAll(newAcconutList);
//                break;
//            }
//            //职工视图
//            case "BS02004": {
//
//                List<Account> newAcconutList = new ArrayList<>();
//                List<Account> accountListFromHis = SDKParse.parseAccountXml(message);
//                //System.out.println("His账号:"+accountListFromHis);
//                //System.out.println("His账号数量:"+accountListFromHis.size());
//
//                Map<String, Account> filterAccountMap = new HashMap<>();
//                for (Account accountFrom : accountListFromHis) {
//                    filterAccountMap.put(accountFrom.getWorkID(), accountFrom);
//                }
//                //System.out.println("筛选账号:"+filterAccountMap);
//                //System.out.println("筛选账号数量:"+filterAccountMap.size());
//
//                if (null == filterAccountMap || filterAccountMap.size() == 0) {
//                    return;
//                }
//                List<Account> accountListFromDb = accountDao.gets();
//                //System.out.println("现有账号:"+accountListFromDb);
//                //System.out.println("现有账号数量:"+accountListFromDb.size());
//
//                if (accountListFromDb != null) {
//                    for (String workID : filterAccountMap.keySet()) {
//                        boolean flag = false;
//                        for (int j = 0; j < accountListFromDb.size(); j++) {
//                            if (null != accountListFromDb.get(j).getWorkID())
//                                if (accountListFromDb.get(j).getWorkID().equals(filterAccountMap.get(workID).getWorkID())) {
//                                    flag = true;
//                                }
//                        }
//                        if (!flag) {
//                            newAcconutList.add(filterAccountMap.get(workID));
//                        }
//                    }
//                }
//                accountDao.addAll(newAcconutList);
//                break;
//            }
//            //药品
//            case "BS35010": {
//
//                break;
//            }
//            //手术申请单
//            case "BS35008": {
//                try {
//                    List<PatientLink> patientLinkList = patientLinkDao.getScheduleTableOpers();
//                    logger.warn("this size of list from mongo is " + patientLinkList.size());
//                    List<PatientLink> hisPatientLinkList = SDKParse.parseOperationtXml(message);
//                    if (patientLinkList == null) patientLinkList = new ArrayList<>();
//                    System.out.println("this size of list from his is " + hisPatientLinkList.size());
//                    if (null != patientLinkList && patientLinkList.size() != 0) {
//                        for (int i = 0; i < hisPatientLinkList.size(); i++) {
//                            boolean addFlag = true;
//                            for (int j = 0; j < patientLinkList.size(); j++) {
//                                if (hisPatientLinkList.get(i).getApplication().getSssqdh().equals(patientLinkList.get(j).getApplication().getSssqdh())) {
//                                    addFlag = false;
//                                    //更新数据库
//                                    //patientLinkDao.findAndUpdate(new Criteria(hisPatientLinkList.get(i).getApplication().getSssqdh()), Update.update(hisPatientLinkList.get(i).getApplication().getSssqdh(), hisPatientLinkList.get(i)));
//                                    break;
//                                }
//                            }
//                            if (addFlag) {
//                                logger.warn(new Date() + "：正在向数据库插入病人" + hisPatientLinkList.get(i).getPatient().getBrxm());
//                                patientLinkDao.addUpdate(hisPatientLinkList.get(i));
//                            }
//                        }
//                    } else {
//                        for (PatientLink patientLink : hisPatientLinkList) {
//                            String hisOperId = patientLink.getHisID();
//                            boolean addFlag = true;
//                            for (PatientLink dbPatientLink : patientLinkList) {
//                                String dbOperId = dbPatientLink.getHisID();
//                                if (null != dbOperId && dbOperId.equals(hisOperId)) {
//                                    addFlag = false;
//                                    break;
//                                }
//                            }
//                            if (addFlag) {
//                                logger.warn(new Date() + "：正在向数据库插入病人" + patientLink.getPatient().getBrxm());
//                                patientLinkDao.addUpdate(patientLink);
//                            }
//                        }
//                    }
//                    System.out.println("获取手术通知单over...");
////                    PnlHomePage.getInstance().getHomePageController().inMenu("shoushupaitai");
//                    //PnlSchedule.getInstance().getController().sarchTime();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                break;
//            }
//            //lis报告视图
//            case "BS20003": {
//                List<LisReport> lisReportList = SDKParse.parseLisReportXml(message);
//                if (!patientNo.equalsIgnoreCase(lisReportList.get(0).getMRN())) {
//                    patientNo = lisReportList.get(0).getMRN();
//                    jianYan = new JianYan();
//                }
//                Map<String, LisReport> map = getReportList(lisReportList);
//                System.out.println("map.size()=" + map.size());
//                int i = 0;
//                for (Map.Entry<String, LisReport> entry : map.entrySet()) {
//                    getLisReportDetailFromHis(entry.getValue().getREPORTID());
//                    i++;
//                    System.out.println("i=" + i);
//                    if (i > 6 || i >= map.size()) {
//                        List<PatientLink> patientLinks = patientLinkDao.getPaientLinkbyPatId(patientNo);
//                        if (null != patientLinks && patientLinks.size() != 0) {
//                            for (PatientLink patient : patientLinks) {
//                                PatientLisData patientLisData = patientLisDataDao.getPatientLisData8PatientId(patient.getId());
//                                System.out.println(patientLisData);
//                                if (patientLisData == null) {
//                                    patientLisData = new PatientLisData();
//                                }
//                                patientLisData.setZyh(patient.getPatient().getZyh());
//                                patientLisData.setPatientID(patient.getId());
//                                patientLisData.setJianYan(jianYan);
//                                if (jianYan != null) {
//                                    patientLisData.setResult(true);
//                                } else {
//                                    patientLisData.setResult(false);
//                                }
//                                patientLisData.setBeginTime(new Date());
//                                patientLisDataDao.addUpdate(patientLisData);
//                            }
//                        }
//                        System.out.println("获取检验数据over...");
//                        break;
//                    }
//                }
//
//                break;
//            }
//            //lis报告明细视图
//            case "BS20004": {
//                List<LisReportDetail> lisReportDetailList = SDKParse.parseLisReportDetailXml(message);
//                if (lisReportDetailList.size() > 0) {
//                    for (LisReportDetail lis : lisReportDetailList) {
//                        if (lis.getITEMSHORTNAME().contains("HGB")) {
//                            jianYan.setHb(keepDecimal(lis.getRESULT()));
//                        } else if (lis.getITEMSHORTNAME().contains("HCT")) {
//                            jianYan.setHct(keepDecimal(lis.getRESULT()));
//                        } else if (lis.getITEMSHORTNAME().contains("PLT")) {
//                            jianYan.setPlt(keepDecimal(lis.getRESULT()));
//                        } else if (lis.getITEMSHORTNAME().contains("K")) {
//                            jianYan.setK(keepDecimal(lis.getRESULT()));
//                        } else if (lis.getITEMSHORTNAME().contains("GLU")) {
//                            jianYan.setGLU(keepDecimal(lis.getRESULT()));
//                        } else if (lis.getITEMSHORTNAME().contains("ALT")) {
//                            if (!lis.getITEMSHORTNAME().contains("AST")) {
//                                jianYan.setALT(keepDecimal(lis.getRESULT()));
//                            }
//                        } else if (lis.getITEMSHORTNAME().contains("UREA")) {
//                            jianYan.setUREA(keepDecimal(lis.getRESULT()));
//                        } else if (lis.getITEMSHORTNAME().contains("CREA")) {
//                            jianYan.setCREA(keepDecimal(lis.getRESULT()));
//                        } else if (lis.getITEMSHORTNAME().contains("PT")) {
//                            if (lis.getITEMSHORTNAME().contains("APTT")) {
//                                jianYan.setAPTT(keepDecimal(lis.getRESULT()));
//                            } else {
//                                jianYan.setPT(keepDecimal(lis.getRESULT()));
//                            }
//                        }
//                    }
//                }
//                System.out.println(jianYan);
//
//            }
//        }
//    }
//
//    public static void getLisReportDetailFromHis(String ReportId) {
//        String lisReportDetailString = ServiceMessage.lisReportDetailString.replace("REPORTID", ReportId);
//        SDKHelper.getInstance().SendMsg(ServiceMessage.ANES_LIS_REPORT_DETAIL, lisReportDetailString);
//    }
//
//    public static Map<String, LisReport> getReportList(List<LisReport> list) {
//        Map<String, LisReport> map = new HashMap();
//        for (LisReport lisReport : list) {
//            LisReport lisReportold = map.get(lisReport.getREPORTID());
//
//            if (null == lisReportold) {  //新增exe
//                map.put(lisReport.getREPORTID(), lisReport);
//            } else {
//                Date reportTime = lisReport.getAUTHTIME();
//                Date reportTimeold = lisReportold.getAUTHTIME();
//                if (reportTimeold.getTime() > reportTime.getTime()) {
//                    System.out.println("dt1 在dt2前");
//                    map.put(lisReportold.getREPORTID(), lisReportold);
//                } else {
//                    map.put(lisReport.getREPORTID(), lisReport);
//                }
//                if (map.size() > 4) {
//                    return map;
//                }
//            }
//        }
//
////        LisReport lisReport = null;
////        for (Map.Entry<String, LisReport> entry : map.entrySet()) {
//////        System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
////            lisReport = entry.getValue();
////        }
//        return map;
//    }
//
//    public static String keepDecimal(String s) {
//
//        String rs = null;
//        try {
//            int scale = 2;//设置位数
//            int roundingMode = 4;//表示四舍五入，可以选择其他舍值方式，例如去尾，等等.
//            BigDecimal bd = new BigDecimal(Double.parseDouble(s));
//            bd = bd.setScale(scale, roundingMode);
//            float ft = bd.floatValue();
//            rs = String.valueOf(ft);
//            return rs;
//        } catch (NumberFormatException e) {
//            //e.printStackTrace();
//            return rs;
//        }
//    }
//}
