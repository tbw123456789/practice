package cn.medigical.publish.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.medigical.publish.dao.impl.AccountCache;
import cn.medigical.publish.dao.impl.dictionary.ConfigConsumablesDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigDrugsDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigHaoCaiDao;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.dictionary.ConfigConsumables;
import cn.medigical.publish.pojo.dictionary.ConfigDrugs;
import cn.medigical.publish.pojo.dictionary.ConfigHaoCaiType;
import cn.medigical.publish.utils.MyDateFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.dao.impl.PatientLisDataDao;
import cn.medigical.publish.pojo.lis.JianYan;
import cn.medigical.publish.pojo.lis.jianyanxm.ITEMType;
import cn.medigical.publish.pojo.patient.PatientLisData;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.utils.SpringUtils;
import cn.medigical.publish.utils.StringUtil;

@Controller
@RequestMapping("ShouMaHisController")
public class ShouMaHisController {

    PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);
    private double HBSAG = 0.05;
    private double HBEAG = 1;
    private double HCVAB = 1;
    private double HIVAGAB = 1;
    private double TPAB = 1;

    String ningxue = "未查";
    String xuetang = "未查";
    String jiagong = "未查";
    String dianjiezhi = "未查";
    String shengong = "未查";
    String gangong = "未查";
    String niaochanggui = "未查";
    String xuechanggui = "未查";
    String TRUST = "未查";
    String TPAb = "未查";
    String HIVAgAb = "未查";
    String HCVAb = "未查";
    String HBeAg = "未查";
    String HBsAg = "未查";
    String xuexing = "未查";
    String ecg = "未查";
    String xueqifenxi = "未查";
    String xindongtu = "未查";
    String xiongpian = "未查";
    String feigong = "未查";
    JianYan jianYan;
    public List bloodlist = new ArrayList();
    public List mianyilist = new ArrayList();
    public List xuechangguilist = new ArrayList();
    public List niaochangguilist = new ArrayList();
    public List gangonglist = new ArrayList();
    public List shengonglist = new ArrayList();
    public List dianjiezhilist = new ArrayList();
    public List ningxuelist = new ArrayList();
    public List jiagonglist = new ArrayList();
    public List xuetanglist = new ArrayList();
    public List xiongpianlist = new ArrayList();

    public List ecglist = new ArrayList();
    public List xueqifenxilist = new ArrayList();
    public List xindongtulist = new ArrayList();

    public Map<String, List> checkmap = new HashMap<String, List>();
    public Map<String, String> lastmap = new HashMap<String, String>();
    // public LisDataResult lisDataResult=new LisDataResult();
    PatientLisDataDao patientLisDataDao = SpringUtils.getBean(PatientLisDataDao.class);
    AccountDao accountDao = (AccountDao) SpringUtils.getBean(AccountDao.class);
    ConfigDrugsDao configDrugsDao = SpringUtils.getBean(ConfigDrugsDao.class);
    ConfigConsumablesDao configConsumablesDao = SpringUtils.getBean(ConfigConsumablesDao.class);
    ConfigHaoCaiDao configHaoCaiDao = SpringUtils.getBean(ConfigHaoCaiDao.class);

    @ResponseBody
    @RequestMapping(value = "getPaibanMessage", method = RequestMethod.GET)
    public String getPaibanMessage() {
//        List<ConfigHaoCaiType> haoCaiList = configHaoCaiDao.getAll();
//        for (int i = 0; i < haoCaiList.size(); i++) {
//            ConfigConsumables configConsumables=new ConfigConsumables();
//            if (i % 2 == 0) {
//                configConsumables.setCol(1);
//                configConsumables.setRow((i/2)+1);
//            } else {
//                configConsumables.setCol(2);
//                configConsumables.setRow(((i+1)/2));
//            }
//            configConsumables.setCount("");
//            configConsumables.setPrice("");
//            configConsumables.setIndex(configConsumables.getRow()+"");
//            configConsumables.setName(haoCaiList.get(i).getCode());
//            configConsumables.setCode("consumable_"+configConsumables.getCol()+"_"+configConsumables.getRow());
//            configConsumablesDao.addUpdate(configConsumables);
//        }

        //HisLinkDeChang.getInstance().getOperationFromHis();


//        JianYan jy = LisDataNantong2.getInstance().getListDataFromHis("2", "18120054", "", "");
//        PatientLink patientLink = patientLinkDao.findById("5c161be71b8c37142958ee85");
//        System.out.println(patientLink.getPatient().getBrxm());
//        reqRespData(paibanMessage(patientLink));

//        List<PatientLink> patientLinks = patientLinkDao.getPatientLinks();
//        for (PatientLink p : patientLinks) {
//            System.out.println(p.getPatient().getBrxm());
//            reqRespData(paibanMessage(p));
//        }


        List<ConfigDrugs> configDrugsList = configDrugsDao.getAll();
        for (ConfigDrugs configDrug : configDrugsList) {
            configDrug.setUsage("drug_4");
            configDrugsDao.addUpdate(configDrug);
        }
//        for (int i=0;i<configDrugsList.size();i++) {
//            configDrugsList.get(i).setCode("drug_"+i);
//            configDrugsDao.addUpdate(configDrugsList.get(i));
//        }
        return "succes";
    }

    @ResponseBody
    @RequestMapping(value = "GetPatientLabTestMaster/{id}", method = RequestMethod.GET)
    public String GetPatientLabTestMaster(@PathVariable("id") String id) {
        clear();
        PatientLink patientLinks = patientLinkDao.findById(id);
        if (patientLinks != null) {
            System.out.println(patientLinks.getPatient().getBrxm() + ":" + patientLinks.getPatient().getZyh());
            String xmlString = reqRespData(getPatientLabMessage(patientLinks));
            List<ITEMType> itemTypeList = new ArrayList<ITEMType>();
            xmlString = xmlString.replace("&gt;", ">").replace("&lt;", "<");
            String xmlStartStr = "DEPTROOT";
            int xmlStartIndex = xmlString.indexOf("<" + xmlStartStr + ">") + ("<" + xmlStartStr + ">").length();
            int xmlEndIndex = xmlString.lastIndexOf("</" + xmlStartStr + ">");
            xmlString = xmlString.substring(xmlStartIndex, xmlEndIndex);
            String[] checkItems = {"ITEM"};
            if (null != checkItems) {
                int index = 0;
                while (index != -1) {
                    for (String checkItem : checkItems) {
                        int itemStartIndex = xmlString.indexOf("<" + checkItem + ">");
                        if (itemStartIndex == -1) {
                            index = -1;
                            break;
                        }
                        int itemEndIndex = xmlString.indexOf("</" + checkItem + ">", itemStartIndex);
                        String itemStr = xmlString.substring(itemStartIndex + ("<" + checkItem + ">").length(), itemEndIndex);
                        if ((itemStr.contains("<")) || (itemStr.contains(">"))) {
                            String itemStrNew = itemStr.substring(itemStr.indexOf("<TestNo>") + 8, itemStr.indexOf("</TestNo>"));
                            String spcmReceivedDateTime = itemStr.substring(itemStr.indexOf("<SpcmReceivedDateTime>") + 22, itemStr.indexOf("</SpcmReceivedDateTime>"));
                            String TestCause = itemStr.substring(itemStr.indexOf("<TestCause>") + 11, itemStr.indexOf("</TestCause>"));
                            System.out.println(spcmReceivedDateTime + "hhh");
                            ITEMType itemType = new ITEMType();
                            itemType.setTestNo(itemStrNew);
                            itemType.setSpcmReceivedDateTime(spcmReceivedDateTime);
                            itemType.setTestCause(TestCause);
                            itemTypeList.add(itemType);
                            xmlString = xmlString.substring(itemEndIndex);
                        }
                        index = itemEndIndex;
                    }
                }
            }
            Map<String, List> bigmap = getJyBigItemData(itemTypeList);
            Map<String, String> samllmap = getLastJYXM(bigmap);
            if (samllmap.size() > 0) {
                JianYan jy = getJianyan(patientLinks, samllmap);
                PatientLisData patientLisData = patientLisDataDao.getPatientLisData8PatientId(id);
                if (patientLisData == null) {
                    patientLisData = new PatientLisData();
                }
                patientLisData.setZyh(patientLinks.getPatient().getZyh());
                patientLisData.setPatientID(id);
                patientLisData.setJianYan(jy);
                patientLisData.setBeginTime(new Date());
                if (jy != null) {
                    patientLisData.setResult(true);
                } else {
                    patientLisData.setResult(false);
                }
                patientLisDataDao.addUpdate(patientLisData);
            }
        }
        return "succes";
    }

    public String reqRespData(String message) {
        String xml = getMessage(message);
        System.out.println(xml);
        String urlString = "http://192.168.2.224/crds3/ShouMaHisWebService.asmx";
        HttpURLConnection httpConn = null;
        OutputStream out = null;
        String returnXml = "";
        BufferedReader reader;
        try {
            httpConn = (HttpURLConnection) new URL(urlString).openConnection();
            httpConn.setRequestProperty("Content-Type", "application/soap+xml; charset=utf-8");
            httpConn.setRequestMethod("POST");
            httpConn.setDoOutput(true);
            httpConn.setDoInput(true);
            httpConn.connect();
            out = httpConn.getOutputStream();
            httpConn.getOutputStream().write(xml.getBytes());
            out.flush();
            out.close();
            int code = httpConn.getResponseCode();
            String tempString = null;
            StringBuffer sb1 = new StringBuffer();
            if (code == 200) {
                reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
                while ((tempString = reader.readLine()) != null) {
                    sb1.append(tempString);
                }
                if (null != reader)
                    reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(httpConn.getErrorStream(), "UTF-8"));
                while ((tempString = reader.readLine()) != null) {
                    sb1.append(tempString);
                }
                if (null != reader) {
                    reader.close();
                }
            }
            returnXml = sb1.toString();
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println(returnXml);
        return returnXml;
    }

    public String getMessage(String paibanMessage) {
        String message = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">" + "<soap12:Body>" + paibanMessage + "</soap12:Body>" + "</soap12:Envelope>";
        return message;
    }

    public String paibanMessage(PatientLink p) {
        String m = "<GetReturnShouMaXinXi xmlns=\"http://tempuri.org/\">" +
                "<OPER_ORDER_NO>" + p.getApplication().getSssqdh() + "</OPER_ORDER_NO>" +
                "<PatientId>" + p.getPatient().getZyh() + "</PatientId>" +
                "<OPER_ROOM>" + p.getSchedule().getPbssjh() + "</OPER_ROOM>" +
                "<OPER_NAME>" + p.getAnesthesiaRecord().getYsss1() + "</OPER_NAME>" +
                "<OPER_ID>" + p.getApplication().getSssqdh() + "</OPER_ID>" +
                "<OPER_AT>" + MyDateFormat.DATE_FORMAT_YMDHMS.format(p.getStatus().getInRoomTime()) + "</OPER_AT>" +
                "<OPEDOC_ID>" + AccountCache.getInstance().getAccount8Id(p.getAnesthesiaRecord().getOperDoctor1()).getWorkID() + "</OPEDOC_ID>" +
                "<OPEDOC_NAME>" + AccountCache.getInstance().getAccount8Id(p.getAnesthesiaRecord().getOperDoctor1()).getTrueName() + "</OPEDOC_NAME>" +
                "<ANES_DR_ID>" + AccountCache.getInstance().getAccount8Id(p.getAnesthesiaRecord().getZmys()).getWorkID() + "</ANES_DR_ID>" +
                "<ANES_DR_NAME>" + AccountCache.getInstance().getAccount8Id(p.getAnesthesiaRecord().getZmys()).getTrueName() + "</ANES_DR_NAME>" +
                "<OPER_DIAGNOSE>" + p.getAnesthesiaRecord().getShzd1() + "</OPER_DIAGNOSE>" +
                "<INCISION_GRADE>" + getIncision(p) + "</INCISION_GRADE>" +
                "<ASA>" + getASA(p) + "</ASA>" +
                "<NNIS>" + "" + "</NNIS>" +
                "<URGENT_OPE>" + getjz(p) + "</URGENT_OPE>" +
                "<NARC_KIND>" + p.getAnesthesiaRecord().getMzff() + "</NARC_KIND>" +
                "<OPER_START_TIME>" + MyDateFormat.DATE_FORMAT_YMDHMS.format(p.getStatus().getOperStartTime()) + "</OPER_START_TIME>" +
                "<OPER_END_TIME>" + MyDateFormat.DATE_FORMAT_YMDHMS.format(p.getStatus().getOperEndTime()) + "</OPER_END_TIME>" +
                "<OPER_LENG_TIME>" + p.getStatus().getOperSpanTime() + "</OPER_LENG_TIME>" +
                "<DEPT_ID>" + p.getApplication().getSqksbh() + "</DEPT_ID>" +
                "<DEPT_NAME>" + p.getApplication().getSqksmc() + "</DEPT_NAME>" +
                "<OPEDOC_NAME2>" + AccountCache.getInstance().getAccount8Id(p.getAnesthesiaRecord().getOperDoctor2()).getTrueName() + "</OPEDOC_NAME2>" +
                "<OPEDOC_NAME3>" + AccountCache.getInstance().getAccount8Id(p.getAnesthesiaRecord().getOperDoctor3()).getTrueName() + "</OPEDOC_NAME3>" +
                "<NURSE_NAME1>" + AccountCache.getInstance().getAccount8Id(p.getAnesthesiaRecord().getXhhs1()).getTrueName() + "</NURSE_NAME1>" +
                "<NURSE_NAME2>" + AccountCache.getInstance().getAccount8Id(p.getAnesthesiaRecord().getXshs1()).getTrueName() + "</NURSE_NAME2>" +
                "</GetReturnShouMaXinXi>";
        return m;
    }

    public String getPatientLabMessage(PatientLink p) {
        String m = "<GetPatientLabTestMaster xmlns=\"http://tempuri.org/\">" + "<PatientId>" + p.getPatient().getZyh() + "</PatientId>" + "<VisitId>1</VisitId>" + "</GetPatientLabTestMaster>";
        return m;
    }

    public String GetLabTestResult(String testNo) {
        String m = "<GetLabTestResult xmlns=\"http://tempuri.org/\">" + "<TestNo>" + testNo + "</TestNo>" + "</GetLabTestResult>";
        return m;
    }

    public String getjz(PatientLink p) {
        if (p.getAnesthesiaRecord() != null && p.getAnesthesiaRecord().getAsa() != null && p.getAnesthesiaRecord().getAsa().getJz()) {
            return "0";
        }
        return "1";
    }

    public String getASA(PatientLink p) {
        if (p.getAnesthesiaRecord() != null && p.getAnesthesiaRecord().getAsa() != null) {
            return p.getAnesthesiaRecord().getAsa().getLevel();
        }
        return "";
    }

    public String getIncision(PatientLink p) {
        String qklx = "";
        if (p.getQualityPojo() != null) {
            if (p.getQualityPojo().getSsqkfl1()) {
                qklx = "Ⅰ级";
            } else if (p.getQualityPojo().getSsqkfl2()) {
                qklx = "Ⅱ级";
            } else if (p.getQualityPojo().getSsqkfl3()) {
                qklx = "Ⅲ级";
            } else if (p.getQualityPojo().getSsqkfl4()) {
                qklx = "Ⅳ级";
            }
        }
        return qklx;
    }

    public List<cn.medigical.publish.pojo.lis.jianyanjgxm.ITEMType> getHisMessage(String xmlString) {
        List<cn.medigical.publish.pojo.lis.jianyanjgxm.ITEMType> itemTypeList = new ArrayList<cn.medigical.publish.pojo.lis.jianyanjgxm.ITEMType>();
        xmlString = xmlString.replace("&gt;", ">").replace("&lt;", "<");
        String xmlStartStr = "DEPTROOT";
        int xmlStartIndex = xmlString.indexOf("<" + xmlStartStr + ">") + ("<" + xmlStartStr + ">").length();
        int xmlEndIndex = xmlString.lastIndexOf("</" + xmlStartStr + ">");
        xmlString = xmlString.substring(xmlStartIndex, xmlEndIndex);
        String[] checkItems = {"ITEM"};
        if (null != checkItems) {
            int index = 0;
            while (index != -1) {
                for (String checkItem : checkItems) {
                    int itemStartIndex = xmlString.indexOf("<" + checkItem + ">");
                    if (itemStartIndex == -1) {
                        index = -1;
                        break;
                    }
                    int itemEndIndex = xmlString.indexOf("</" + checkItem + ">", itemStartIndex);
                    String itemStr = xmlString.substring(itemStartIndex + ("<" + checkItem + ">").length(), itemEndIndex);
                    if ((itemStr.contains("<")) || (itemStr.contains(">"))) {
                        String ReportParmNameSX = itemStr.substring(itemStr.indexOf("<ReportParmNameSX>") + 18, itemStr.indexOf("</ReportParmNameSX>"));
                        String ReportItemName = itemStr.substring(itemStr.indexOf("<ReportItemName>") + 16, itemStr.indexOf("</ReportItemName>"));
                        String ReportParmName = itemStr.substring(itemStr.indexOf("<ReportParmName>") + 16, itemStr.indexOf("</ReportParmName>"));
                        String ReferenceResult = itemStr.substring(itemStr.indexOf("<ReferenceResult>") + 17, itemStr.indexOf("</ReferenceResult>"));

                        String Result = itemStr.substring(itemStr.indexOf("<Result>") + 8, itemStr.indexOf("</Result>"));
                        String Unit = itemStr.substring(itemStr.indexOf("<Unit>") + 6, itemStr.indexOf("</Unit>"));
                        cn.medigical.publish.pojo.lis.jianyanjgxm.ITEMType itemType = new cn.medigical.publish.pojo.lis.jianyanjgxm.ITEMType();
                        itemType.setReportParmNameSX(ReportParmNameSX);
                        itemType.setReportParmName(ReportParmName);
                        itemType.setReportItemName(ReportItemName);
                        itemType.setReferenceResult(ReferenceResult);
                        itemType.setResult(Result);
                        itemType.setUnit(Unit);
                        itemTypeList.add(itemType);
                        xmlString = xmlString.substring(itemEndIndex);
                    }
                    index = itemEndIndex;
                }
            }
        }
        return itemTypeList;
    }

    // 得到大检验项目的map
    public Map<String, List> getJyBigItemData(List<ITEMType> itemTypeList) {
        checkmap.clear();
        if (null != itemTypeList) {
            for (ITEMType itemType : itemTypeList) {
                System.out.println("检验项目:" + itemType.getTestCause() + "-----------");
                String BigItemData = trimStr(itemType.getTestCause());
                if (BigItemData.contains("血型")) {
                    bloodlist.add(itemType);
                    checkmap.put("血型", bloodlist);
                    continue;
                }
                if (BigItemData.contains("免疫全套")) {
                    mianyilist.add(itemType);
                    checkmap.put("免疫全套", mianyilist);
                    continue;
                }
                if (BigItemData.contains("血液分析")) {
                    xuechangguilist.add(itemType);
                    checkmap.put("血常规", xuechangguilist);
                    continue;
                }
                if (BigItemData.contains("尿液分析")) {
                    niaochangguilist.add(itemType);
                    checkmap.put("尿常规", niaochangguilist);
                    continue;
                }
                if (BigItemData.contains("肝功")) {
                    gangonglist.add(itemType);
                    checkmap.put("肝功", gangonglist);
                    continue;
                }
                if (BigItemData.contains("肾功")) {
                    shengonglist.add(itemType);
                    checkmap.put("肾功", shengonglist);
                    continue;
                }
                if (BigItemData.contains("电解质")) {
                    dianjiezhilist.add(itemType);
                    checkmap.put("电解质", dianjiezhilist);
                    continue;
                }
                if (BigItemData.contains("凝血")) {
                    ningxuelist.add(itemType);
                    checkmap.put("凝血功能", ningxuelist);
                    continue;
                }
                if (BigItemData.contains("甲功")) {
                    jiagonglist.add(itemType);
                    checkmap.put("甲功", jiagonglist);
                    continue;
                }
                if (BigItemData.contains("葡萄糖测定")) {
                    xuetanglist.add(itemType);
                    checkmap.put("血糖", xuetanglist);
                    continue;
                }
                if (BigItemData.contains("胸部正侧位")) {
                    xiongpianlist.add(itemType);
                    checkmap.put("胸片", xiongpianlist);
                    continue;
                }
                if (BigItemData.contains("心电图")) {
                    ecglist.add(itemType);
                    checkmap.put("ECG", ecglist);
                    continue;
                }
                if (BigItemData.contains("血气分析")) {
                    xueqifenxilist.add(itemType);
                    checkmap.put("血气分析", xueqifenxilist);
                    continue;
                }
                if (BigItemData.contains("超声心动图")) {
                    xindongtulist.add(itemType);
                    checkmap.put("超声心动图", xindongtulist);
                    continue;
                }
            }
            return checkmap;
        } else {
            System.out.println("该病人目前没有任何检验结果！");
            return null;
        }
    }

    // 得到最新大检验项目的时间map
    public Map<String, String> getLastJYXM(Map<String, List> map) {
        lastmap.clear();
        List<ITEMType> mapRules = new ArrayList<>();
        int index = 0;
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, List> entry : map.entrySet()) {
                String testNo = "";
                mapRules = entry.getValue();
                String beginTime = new String("2000-01-01 00:00:00");
                for (int i = 0; i < mapRules.size(); i++) {
                    if (mapRules.get(i).getResultsRptDateTime() != null) {
                        String endTime = new String(mapRules.get(i).getResultsRptDateTime());
                        if (endTime != null && beginTime.compareTo(endTime) < 0) {
                            beginTime = endTime;// beginTime.compareTo(endTime)<0时，开始时间小于结束时间
                            index = i;
                        }
                    }
                    testNo = mapRules.get(index).getTestNo();
                }
                lastmap.put(entry.getKey(), testNo);
            }
            return lastmap;
        } else {
            return null;
        }
    }

    // 得到最新小检验项目
    public JianYan getJianyan(PatientLink p, Map<String, String> map) {

        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String testno = entry.getValue();
                String xmlString = reqRespData(GetLabTestResult(testno));
                List<cn.medigical.publish.pojo.lis.jianyanjgxm.ITEMType> itemTypesLX = getHisMessage(xmlString);
                if (null != itemTypesLX) {
                    for (cn.medigical.publish.pojo.lis.jianyanjgxm.ITEMType itemType : itemTypesLX) {
                        System.out.println("检验指标:" + itemType.getReportItemName() + "-----------" + itemType.getReportParmName() + "--" + itemType.getReportParmNameSX() + "--" + itemType.getResult());
                        if (itemType.getReportItemName().contains("血型")) {
                            if (itemType.getReportParmName() != null && itemType.getReportParmName().equalsIgnoreCase("ABO血型")) {
                                if (xuexing.equalsIgnoreCase("缺")) {
                                    xuexing = "";
                                }
                                xuexing = xuexing + itemType.getResult();
                            }
                            if (itemType.getReportParmName() != null && itemType.getReportParmName().equalsIgnoreCase("RH(D)")) {
                                if (xuexing.equalsIgnoreCase("缺")) {
                                    xuexing = "";
                                }
                                if (itemType.getResult().contains("4+") || itemType.getResult().contains("阳")) {
                                    xuexing = xuexing + " Rh+";
                                } else {
                                    xuexing = xuexing + " Rh-";
                                }
                            }
                            jianYan.setBloodType(xuexing);
                            continue;
                        }
                        if (itemType.getReportItemName().contains("免疫全套")) {
                            if (itemType.getReportParmNameSX().equalsIgnoreCase("HBsAg")) {
                                if (itemType.getResult().contains(">250") || StringUtil.ToDouble(itemType.getResult()) >= HBSAG) {
                                    HBsAg = "(+)";
                                } else {
                                    HBsAg = "(-)";
                                }
                                jianYan.setHbsag(HBsAg);
                                continue;
                            }
                            if (itemType.getReportParmNameSX().equalsIgnoreCase("HBeAg")) {
                                if (StringUtil.ToDouble(itemType.getResult()) >= HBEAG) {
                                    HBeAg = "(+)";
                                } else {
                                    HBeAg = "(-)";
                                }
                                jianYan.setHbeag(HBeAg);
                                continue;
                            }
                            if (itemType.getReportParmNameSX().equalsIgnoreCase("HCV-Ab")) {
                                if (StringUtil.ToDouble(itemType.getResult()) >= HCVAB) {
                                    HCVAb = "(+)";
                                } else {
                                    HCVAb = "(-)";
                                }
                                jianYan.setHcvab(HCVAb);
                                continue;
                            }
                            if (itemType.getReportParmNameSX().equalsIgnoreCase("HIV-Ag/Ab")) {
                                if (StringUtil.ToDouble(itemType.getResult()) >= HIVAGAB) {
                                    HIVAgAb = "(+)";
                                } else {
                                    HIVAgAb = "(-)";
                                }
                                jianYan.setHcvagab(HIVAgAb);
                                continue;
                            }
                            if (itemType.getReportParmNameSX().equalsIgnoreCase("TP-Ab")) {
                                if (StringUtil.ToDouble(itemType.getResult()) >= TPAB) {
                                    TPAb = "(+)";
                                } else {
                                    TPAb = "(-)";
                                }
                                jianYan.setTpab(TPAb);
                                continue;
                            }
                            if (itemType.getReportParmNameSX().equalsIgnoreCase("TRUST")) {
                                if (itemType.getResult().contains("阳")) {
                                    TRUST = "(+)";
                                } else if (itemType.getResult().contains("阴")) {
                                    TRUST = "(-)";
                                }
                                jianYan.setTrust(TRUST);
                                continue;
                            }
                            continue;
                        }
                        if (itemType.getReportItemName().contains("血液分析")) {
                            if (itemType.getReportParmNameSX().equalsIgnoreCase("HGB")) {
                                if (xuechanggui.equalsIgnoreCase("未查")) {
                                    xuechanggui = "";
                                }
                                xuechanggui = xuechanggui + itemType.getReportParmNameSX() + " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("PLT")) {
                                if (xuechanggui.equalsIgnoreCase("未查")) {
                                    xuechanggui = "";
                                }
                                xuechanggui = xuechanggui + itemType.getReportParmNameSX() + " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("WBC")) {
                                if (xuechanggui.equalsIgnoreCase("未查")) {
                                    xuechanggui = "";
                                }
                                xuechanggui = xuechanggui + itemType.getReportParmNameSX() + " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else {
                                //xuechanggui = "未见异常";
                            }
                            jianYan.setXueChangGui(xuechanggui);
                            continue;
                        }
                        if (itemType.getReportItemName().contains("尿液分析")) {
                            if (itemType.getReportParmNameSX().equalsIgnoreCase("KET")) {
                                if (niaochanggui.equalsIgnoreCase("未查")) {
                                    niaochanggui = "";
                                }
                                if (itemType.getResult().contains("阴") || itemType.getResult().contains("-")) {
                                    niaochanggui = niaochanggui + itemType.getReportParmNameSX() + "(-)" + " ";
                                } else {
                                    niaochanggui = niaochanggui + itemType.getReportParmNameSX() + "(+)" + " ";
                                }
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("PRO")) {
                                if (niaochanggui.equalsIgnoreCase("未查")) {
                                    niaochanggui = "";
                                }
                                if (itemType.getResult().contains("阴") || itemType.getResult().contains("-")) {
                                    niaochanggui = niaochanggui + itemType.getReportParmNameSX() + "(-)" + " ";
                                } else {
                                    niaochanggui = niaochanggui + itemType.getReportParmNameSX() + "(+)" + " ";
                                }
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("GLU")) {
                                if (niaochanggui.equalsIgnoreCase("未查")) {
                                    niaochanggui = "";
                                }
                                if (itemType.getResult().contains("阴") || itemType.getResult().contains("-")) {
                                    niaochanggui = niaochanggui + itemType.getReportParmNameSX() + "(-)" + " ";
                                } else {
                                    niaochanggui = niaochanggui + itemType.getReportParmNameSX() + "(+)" + " ";
                                }
                            }
                            jianYan.setNiaoChangGui(niaochanggui);
                            continue;
                        }
                        if (itemType.getReportItemName().contains("肝功")) {
                            if (itemType.getReportParmNameSX().equalsIgnoreCase("ALB")) {
                                if (gangong.equalsIgnoreCase("未查")) {
                                    gangong = "";
                                }
                                gangong = gangong + itemType.getReportParmNameSX() + " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("ALT")) {
                                if (gangong.equalsIgnoreCase("未查")) {
                                    gangong = "";
                                }
                                gangong = gangong + itemType.getReportParmNameSX() + " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("AST")) {
                                if (gangong.equalsIgnoreCase("未查")) {
                                    gangong = "";
                                }
                                gangong = gangong + itemType.getReportParmNameSX() + " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else {
                                //gangong = "未见异常";
                            }
                            jianYan.setGanGongNeng(gangong);
                            continue;
                        }
                        if (itemType.getReportItemName().contains("肾功")) {
                            if (itemType.getReportParmNameSX().equalsIgnoreCase("UREA")) {
                                if (shengong.equalsIgnoreCase("未查")) {
                                    shengong = "";
                                }
                                shengong = shengong + itemType.getReportParmNameSX() + " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("Cr")) {
                                if (shengong.equalsIgnoreCase("未查")) {
                                    shengong = "";
                                }
                                shengong = shengong + itemType.getReportParmNameSX() + " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else {
                                //shengong = "未见异常";
                            }
                            jianYan.setShenGongNeng(shengong);
                            continue;
                        }
                        if (itemType.getReportItemName().contains("电解质")) {
                            if (itemType.getReportParmNameSX().equalsIgnoreCase("K")) {
                                if (dianjiezhi.equalsIgnoreCase("未查")) {
                                    dianjiezhi = "";
                                }
                                dianjiezhi = dianjiezhi + itemType.getReportParmNameSX() + " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("Na")) {
                                if (dianjiezhi.equalsIgnoreCase("未查")) {
                                    dianjiezhi = "";
                                }
                                dianjiezhi = dianjiezhi + itemType.getReportParmNameSX() + " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("Ca")) {
                                if (dianjiezhi.equalsIgnoreCase("未查")) {
                                    dianjiezhi = "";
                                }
                                dianjiezhi = dianjiezhi + itemType.getReportParmNameSX() + " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("Mg")) {
                                if (dianjiezhi.equalsIgnoreCase("未查")) {
                                    dianjiezhi = "";
                                }
                                dianjiezhi = dianjiezhi + itemType.getReportParmNameSX() + " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else {
                                //dianjiezhi = "未见异常";
                            }
                            jianYan.setDianJieZhi(dianjiezhi);
                            continue;
                        }
                        if (itemType.getReportItemName().contains("凝血")) {
                            if (itemType.getReportParmNameSX().equalsIgnoreCase("PT")) {
                                if (ningxue.equalsIgnoreCase("未查")) {
                                    ningxue = "";
                                }
                                ningxue = ningxue + itemType.getReportParmNameSX() + " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("APTT")) {
                                if (ningxue.equalsIgnoreCase("未查")) {
                                    ningxue = "";
                                }
                                ningxue = ningxue + itemType.getReportParmNameSX() + " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("TT")) {
                                if (ningxue.equalsIgnoreCase("未查")) {
                                    ningxue = "";
                                }
                                ningxue = ningxue + itemType.getReportParmNameSX() + " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("FIB")) {
                                if (ningxue.equalsIgnoreCase("未查")) {
                                    ningxue = "";
                                }
                                ningxue = ningxue + itemType.getReportParmNameSX() + " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("D-D")) {
                                if (ningxue.equalsIgnoreCase("未查")) {
                                    ningxue = "";
                                }
                                ningxue = ningxue + itemType.getReportParmNameSX() + " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else {
                                //ningxue = "未见异常";
                            }
                            jianYan.setNingXueGongNeng(ningxue);
                            continue;
                        }
                        if (itemType.getReportItemName().contains("甲功")) {
                            if (itemType.getReportParmNameSX().equalsIgnoreCase("FT3")) {
                                if (jiagong.equalsIgnoreCase("未查")) {
                                    jiagong = "";
                                }
                                jiagong = jiagong + itemType.getReportParmNameSX() + " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("FT4")) {
                                if (jiagong.equalsIgnoreCase("未查")) {
                                    jiagong = "";
                                }
                                jiagong = jiagong + itemType.getReportParmNameSX() + " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("hTSH")) {
                                if (jiagong.equalsIgnoreCase("未查")) {
                                    jiagong = "";
                                }
                                jiagong = jiagong + itemType.getReportParmNameSX() + " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else {
                                //jiagong = "未见异常";
                            }
                            jianYan.setJiaGong(jiagong);
                            continue;
                        }
                        if (itemType.getReportItemName().contains("葡萄糖测定")) {
                            if (!"".equalsIgnoreCase(itemType.getResult())) {
                                xuetang = itemType.getReportParmNameSX() + " " + itemType.getResult() + itemType.getUnit() + " ";
                            }
                            jianYan.setXueTang(xuetang);
                            continue;
                        }
                        if (itemType.getReportItemName().contains("血气分析")) {
                            if (!"".equalsIgnoreCase(itemType.getResult())) {
                                xueqifenxi = itemType.getResult();
                            }
                            jianYan.setXueQiFenXi(xueqifenxi);
                            continue;
                        }
                        if (itemType.getReportItemName().contains("胸部正侧位")) {
                            if (!"".equalsIgnoreCase(itemType.getResult())) {
                                xiongpian = itemType.getResult();
                            }
                            jianYan.setXiongPian(xiongpian);
                            continue;
                        }
                        if (itemType.getReportItemName().contains("超声心动图")) {
                            if (itemType.getResult().contains("★")) {
                                String arr[] = itemType.getResult().split("★");
                                xindongtu = arr[0];
                                System.out.println("xindongtu:" + xindongtu);
                                jianYan.setChaoShengXinDongTu(xindongtu);
                                continue;
                            } else {
                                if (!"".equalsIgnoreCase(itemType.getResult())) {
                                    xindongtu = itemType.getResult();
                                }
                                System.out.println("xindongtu:" + xindongtu);
                                jianYan.setChaoShengXinDongTu(xindongtu);
                                continue;

                            }
                        }
                        if (itemType.getReportItemName().contains("心电图")) {
                            if (!"".equalsIgnoreCase(itemType.getResult())) {
                                ecg = itemType.getResult();
                            }
                            jianYan.setEcg(ecg);
                            continue;
                        }
                    }
                }
            }
        }
        return jianYan;
    }


    public void clear() {
        jianYan = new JianYan();
        xuexing = "缺";
        ningxue = "未查";
        xuetang = "未查";
        jiagong = "未查";
        dianjiezhi = "未查";
        shengong = "未查";
        gangong = "未查";
        niaochanggui = "未查";
        xuechanggui = "未查";
        TRUST = "未查";
        TPAb = "未查";
        HIVAgAb = "未查";
        HCVAb = "未查";
        HBeAg = "未查";
        HBsAg = "未查";

        ecg = "未查";
        xueqifenxi = "未查";
        xindongtu = "未查";
        xiongpian = "未查";
        feigong = "未查";

        jianYan.setXueTang(xuetang);
        jianYan.setJiaGong(jiagong);
        jianYan.setNingXueGongNeng(ningxue);
        jianYan.setDianJieZhi(dianjiezhi);
        jianYan.setShenGongNeng(shengong);
        jianYan.setGanGongNeng(gangong);
        jianYan.setNiaoChangGui(niaochanggui);
        jianYan.setXueChangGui(xuechanggui);
        jianYan.setTrust(TRUST);
        jianYan.setTpab(TPAb);
        jianYan.setHcvagab(HIVAgAb);
        jianYan.setHcvab(HCVAb);
        jianYan.setHbeag(HBeAg);
        jianYan.setHbsag(HBsAg);
        jianYan.setBloodType(xuexing);
        jianYan.setEcg(ecg);
        jianYan.setXueQiFenXi(xueqifenxi);
        jianYan.setChaoShengXinDongTu(xindongtu);
        jianYan.setXiongPian(xiongpian);
        jianYan.setFeiGongNeng(feigong);

        bloodlist.clear();
        mianyilist.clear();
        xuechangguilist.clear();
        niaochangguilist.clear();
        gangonglist.clear();
        shengonglist.clear();
        dianjiezhilist.clear();
        ningxuelist.clear();
        jiagonglist.clear();
        xuetanglist.clear();
        xiongpianlist.clear();
        ecglist.clear();
        xueqifenxilist.clear();
        xindongtulist.clear();

        checkmap.clear();
        lastmap.clear();
    }

    protected String trimStr(String str) {
        if (null == str)
            return "";
        return str.trim();
    }
}
