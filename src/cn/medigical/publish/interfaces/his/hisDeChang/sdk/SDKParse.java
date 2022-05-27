package cn.medigical.publish.interfaces.his.hisDeChang.sdk;


import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigDepartmentsDao;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.dictionary.ConfigDepartments;
import cn.medigical.publish.pojo.dictionary.ConfigDrugs;
import cn.medigical.publish.pojo.lis.LisReport;
import cn.medigical.publish.pojo.lis.LisReportDetail;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.utils.Constants;
import cn.medigical.publish.utils.SpringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SDKParse {
    static AccountDao accountDao = SpringUtils.getBean(AccountDao.class);
    static PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);
    static ConfigDepartmentsDao configDepartmentsDao = SpringUtils.getBean(ConfigDepartmentsDao.class);
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.0");

    public static List<Account> parseAccountXml(String accountStringXml) {
        List<Account> list = new ArrayList<>();
        try {
//            Document document = DocumentHelper.parseText(accountStringXml);
//            Element element = document.getRootElement().element("MsgInfo").element("Msg").element("[CDATA").element("msg").element("body").element("row");
//            List<Element> list1 = element.elements();
            Document document = DocumentHelper.parseText(accountStringXml);
            List<Element> elements = document.getRootElement().element("MsgInfo").elements("Msg");
            if (elements != null) {
                for (Element element : elements) {
                    Account account = new Account();
                    String StringELE = element.getText();
                    Document document1 = DocumentHelper.parseText(StringELE);
                    Element ele = document1.getRootElement().element("body").element("row");
                    List<Element> list1 = ele.elements();
                    for (int i = 0; i < list1.size(); i++) {
                        String name = list1.get(i).getName();
                        String value = list1.get(i).getText() == null ? "" : list1.get(i).getText();
                        if (name.equalsIgnoreCase("ZHIGONGGH")) {
                            account.setWorkID(value);
                            account.setLoginName(value);
                            account.setHisID(value);
                            account.setPwd(accountDao.generatePassword(String.valueOf(value)));
                        } else if (name.equalsIgnoreCase("ZHIGONGXM")) {
                            account.setTrueName(value);
                        } else if (name.equalsIgnoreCase("KESHIMC")) {
                            account.setOfficeName(value);
                        } else if (name.equalsIgnoreCase("KESHIID")) {
                            account.setOfficeID(value);
                        } else if (name.equalsIgnoreCase("XINGBIE")) {
                            account.setGender(value);
                        } else if (name.equalsIgnoreCase("ZHIGONGLB")) {
                            account.setTitle(value);
                            account.setRole(value);
                            account.setZhiCheng(value);
                        } else if (name.equalsIgnoreCase("XUELI")) {
                            account.setSchoolLevel(value);
                        }
                        account.setInDate(new Date());
                        account.setCreateTime(new Date());
                        account.setCanLogin(true);
                        account.setStatus("valid");
                    }
                    list.add(account);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<ConfigDepartments> parseDepartmentXml(String accountStringXml) {
        List<ConfigDepartments> list = new ArrayList<ConfigDepartments>();
        try {
//            Document document = DocumentHelper.parseText(accountStringXml);
//            Element element = document.getRootElement().element("MsgInfo").element("Msg").element("[CDATA").element("msg").element("body").element("row");
//            List<Element> list1 = element.elements();
            Document document = DocumentHelper.parseText(accountStringXml);
            List<Element> elements = document.getRootElement().element("MsgInfo").elements("Msg");
            for (Element element : elements) {
                ConfigDepartments departments = new ConfigDepartments();
                String StringELE = element.getText();
                Document document1 = DocumentHelper.parseText(StringELE);
                Element ele = document1.getRootElement().element("body").element("row");
                List<Element> list1 = ele.elements();
                for (int i = 0; i < list1.size(); i++) {
                    String name = list1.get(i).getName();
                    String value = list1.get(i).getText() == null ? "" : list1.get(i).getText();
                    if (name.equalsIgnoreCase("KESHIID")) {
                        departments.setCode(value);
                    } else if (name.equalsIgnoreCase("KESHIMC")) {
                        departments.setName(value);
                    }
                }
                departments.setDeleted(false);
                list.add(departments);
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<LisReportDetail> parseLisReportDetailXml(String accountStringXml) {
        List<LisReportDetail> list = new ArrayList<LisReportDetail>();
        try {
            Document document = DocumentHelper.parseText(accountStringXml);
            List<Element> elements = document.getRootElement().element("MsgInfo").elements("Msg");
            if (elements != null) {
                for (Element element : elements) {
                    LisReportDetail lisReportDetail = new LisReportDetail();
                    String StringELE = element.getText();
                    Document document1 = DocumentHelper.parseText(StringELE);
                    Element ele = document1.getRootElement().element("body").element("row");
                    List<Element> list1 = ele.elements();
                    for (int i = 0; i < list1.size(); i++) {
                        String name = list1.get(i).getName();
                        String value = list1.get(i).getText() == null ? "" : list1.get(i).getText();
                        if (name.indexOf("EXAMID") >= 0) {
                            lisReportDetail.setEXAMID(value);
                        } else if (name.equalsIgnoreCase("TESTSHORTNAME")) {
                            lisReportDetail.setITEMSHORTNAME(value);
                        } else if (name.equalsIgnoreCase("AUTHTIME")) {
                            try {
                                if (!value.equalsIgnoreCase("")) {
                                    lisReportDetail.setAUTHTIME(sdf.parse(value));
                                }
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        } else if (name.equalsIgnoreCase("RESULT")) {
                            lisReportDetail.setRESULT(value);
                        } else if (name.equalsIgnoreCase("patIndexNo")) {
                            lisReportDetail.setPatIndexNo(value);
                        }
                    }
                    list.add(lisReportDetail);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static List<LisReport> parseLisReportXml(String accountStringXml) {
        List<LisReport> list = new ArrayList<LisReport>();
        try {
//            Document document = DocumentHelper.parseText(accountStringXml);
//            Element element = document.getRootElement().element("MsgInfo").element("Msg").element("[CDATA").element("msg").element("body").element("row");
//            List<Element> list1 = element.elements();
            Document document = DocumentHelper.parseText(accountStringXml);
            List<Element> elements = document.getRootElement().element("MsgInfo").elements("Msg");
            if (elements != null) {
                for (Element element : elements) {
                    LisReport lisReport = new LisReport();
                    String StringELE = element.getText();
                    Document document1 = DocumentHelper.parseText(StringELE);
                    Element ele = document1.getRootElement().element("body").element("row");
                    List<Element> list1 = ele.elements();
                    for (int i = 0; i < list1.size(); i++) {
                        String name = list1.get(i).getName();
                        String value = list1.get(i).getText() == null ? "" : list1.get(i).getText();
                        if (name.indexOf("MRN") >= 0) {
                            lisReport.setMRN(value);
                        } else if (name.equalsIgnoreCase("REPORTID")) {
                            lisReport.setREPORTID(value);
                        } else if (name.equalsIgnoreCase("AUTHTIME")) {
                            try {
                                lisReport.setAUTHTIME(sdf.parse(value));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        } else if (name.equalsIgnoreCase("MRN")) {
                            lisReport.setMRN(value);
                        }
                    }
                    list.add(lisReport);
//                if(list.size()>0) {
//                    PatientLink patient = SpringCache.getInstance().getBean(PatientLinkDao.class).getPaientLinkbyIndexNo(list.get(0).getPatIndexNo());
//                    for(LisReport lis:list){
//
//                    }
//                }
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return list;
    }


    public static List<ConfigDrugs> parseDrugtXml(String drugStringXml) {
        List<ConfigDrugs> list = new ArrayList<>();
        try {
            Document document = DocumentHelper.parseText(drugStringXml);
            Element element = document.getRootElement().element("MsgInfo").element("Msg").element("msg").element("body").element("row");
            if (element != null) {
                List<Element> list1 = element.elements();
                for (int i = 0; i < list1.size(); i++) {
                    ConfigDrugs drug = new ConfigDrugs();
                    List<Element> list2 = list1.get(i).elements();
                    for (int j = 0; j < list2.size(); j++) {
                        String name = list2.get(j).getName();
                        String value = list2.get(j).getText() == null ? "" : list2.get(j).getText();
                        if (name.equalsIgnoreCase("DRUG_CODE")) {
                            drug.setCode(value);
                        } else if (name.equalsIgnoreCase("DRUGNAME")) {
                            drug.setName(value);
                        } else if (name.equalsIgnoreCase("DRUG_SPEC")) {
                            drug.setSpec(value);
                        } else if (name.equalsIgnoreCase("STORE_UNIT")) {
                            drug.setContainerName(value);
                        } else if (name.equalsIgnoreCase("INP_DOSE_UNIT")) {
                            drug.setUnitName(value);
                        }
                        drug.setDrugTypeCode("drugType_1");
                        drug.setDrugGroupTypeCode("drugGroupType_1");
                        drug.setDose("0");
                        drug.setPrescriptionTypeCode("");
                        drug.setPrescriptionName("");
                    }
                    list.add(drug);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return list;
    }


    public static List<PatientLink> parseOperationtXml(String operationStringXml) {
        List<PatientLink> patientLinkList = new ArrayList<>();
        try {
            Document document = DocumentHelper.parseText(operationStringXml);
            List<Element> elements = document.getRootElement().element("MsgInfo").elements("Msg");
            if (elements != null) {
                for (Element element : elements) {
                    PatientLink patientLink = new PatientLink();
                    patientLink.setCreateDate(new Date());
                    patientLink.getApplication().setDetailstatus(Constants.OR_STATUS_FLAG_APPLIED);
                    //手术状态
                    patientLink.getApplication().setStatus(Constants.AP_STATUS_MAZUIQIAN);
                    //明细状态
                    patientLink.getApplication().setDetailstatus(Constants.OR_STATUS_FLAG_APPLIED);
                    //患者状态
                    patientLink.getPatient().setStatus(Constants.FLAG_VALID);
                    String StringELE = element.getText();
//                System.out.println(StringELE);
                    Document document1 = DocumentHelper.parseText(StringELE);
                    Element ele = document1.getRootElement().element("body").element("row");
                    List<Element> list1 = ele.elements();
                    for (int i = 0; i < list1.size(); i++) {

                        List<Element> list2 = list1.get(i).elements();
                        for (Element e1 : list2) {
                            try {
                                String name = e1.getName();
                                String value = e1.getText() == null ? "" : e1.getText();
                                if (name.equalsIgnoreCase("BINGRENCW")) {
                                    patientLink.getPatient().setZych(value);
                                } else if (name.equalsIgnoreCase("BQBH")) {

                                    patientLink.getPatient().setBqbh(value);
                                } else if (name.equalsIgnoreCase("BQMC")) {

                                    patientLink.getPatient().setBqmc(value);
                                } else if (name.equalsIgnoreCase("NIANLING")) {
                                    patientLink.getPatient().setNl(value + "岁");
                                } else if (name.equalsIgnoreCase("ZHUYUANHAO")) {
                                    patientLink.getPatient().setZyh(value);
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        String name = list1.get(i).getName();
                        String value = list1.get(i).getText() == null ? "" : list1.get(i).getText();
                        if (name.equalsIgnoreCase("BINGRENXM")) {
                            patientLink.getPatient().setBrxm(value);
                        } else if (name.equalsIgnoreCase("LEIXING")) {
                            if (value.equals("1")) {
                                patientLink.getAnesthesiaRecord().getAsa().setJz(true);
                            } else {
                                patientLink.getAnesthesiaRecord().getAsa().setZq(true);
                            }
                        } else if (name.equalsIgnoreCase("PAT_INDEX_NO")) {
                            patientLink.getPatient().setPatId(value);
                        } else if (name.equalsIgnoreCase("SHENQINGKS")) {
                            patientLink.getApplication().setSqksbh(value);
                            patientLink.getPatient().setKsbh(value);
                            ConfigDepartments configDepartments = configDepartmentsDao.getNamebyId(value);
                            if (configDepartments != null) {
                                patientLink.getApplication().setSqksmc(configDepartments.getName());
                                patientLink.getPatient().setKsmc(configDepartments.getName());
                            }
                        } else if (name.equalsIgnoreCase("SHENQINGKSMC")) {
                            if (patientLink.getApplication().getSqksmc() == null || "".equalsIgnoreCase(patientLink.getApplication().getSqksmc())) {
                                patientLink.getApplication().setSqksmc(value);
                            }
                            if (patientLink.getPatient().getKsmc() == null || "".equalsIgnoreCase(patientLink.getPatient().getKsmc())) {
                                patientLink.getPatient().setKsmc(value);
                            }
//                        patientLink.getApplication().setSqksmc(value);
//                        patientLink.getPatient().setKsmc(value);
                        } else if (name.equalsIgnoreCase("SHENQINGSJ")) {
                            try {
                                patientLink.getApplication().setSssqsj(sdf.parse(value));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        } else if (name.equalsIgnoreCase("SHENQINGYISHENG")) {
                            patientLink.getApplication().setSqysbh(value);
                        } else if (name.equalsIgnoreCase("SHOUSHUDID")) {
                            patientLink.getApplication().setSssqdh(value);
                            patientLink.setHisID(value);
                        } else if (name.equalsIgnoreCase("SHOUSHUJB")) {
                            //
                        } else if (name.equalsIgnoreCase("SHOUSHUMC")) {
                            patientLink.getAnesthesiaRecord().setYsss1(value);
                            patientLink.getApplication().setNsssmc(value);
                        } else if (name.equalsIgnoreCase("SHOUSHUYS")) {
                            patientLink.getApplication().setSsysxm(value);
                            if (!value.equalsIgnoreCase("")) {
                                patientLink.getApplication().setSsysbh(accountDao.findAccountByName(value).getId());
                                patientLink.getAnesthesiaRecord().setOperDoctor1(accountDao.findAccountByName(value).getId());
                            }
                        } else if (name.equalsIgnoreCase("SHOUSHUZT")) {
                            //
                        } else if (name.equalsIgnoreCase("XINGBIE")) {
                            patientLink.getPatient().setXb(value);
                        } else if (name.equalsIgnoreCase("YAOQIUSJ")) {
                            try {
                                patientLink.getApplication().setYysssj(sdf.parse(value));
                                patientLink.getSchedule().setJhsssj(sdf1.parse(value));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        } else if (name.equalsIgnoreCase("ZHENDUANMC1")) {
                            patientLink.getAnesthesiaRecord().setShzd1(value);
                            patientLink.getApplication().setSqzd1(value);
                        } else if (name.equalsIgnoreCase("ZHUYUANHAO")) {
                            patientLink.getPatient().setZyh(value);
                        }
                    }
                    patientLinkList.add(patientLink);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return patientLinkList;
    }

}
