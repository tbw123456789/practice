package cn.medigical.publish.interfaces.lis.tianshui;

import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.dao.impl.PatientLisDataDao;
import cn.medigical.publish.pojo.lis.JianYan;
import cn.medigical.publish.pojo.lis.jianyanxm.ITEMType;
import cn.medigical.publish.pojo.patient.PatientLisData;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.utils.SpringUtils;
import cn.medigical.publish.utils.StringUtil;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;


public class LisLinkTianshui {
    private static LisLinkTianshui instance;
    protected Logger logger = Logger.getLogger("LisLinkFuyou");

    public static LisLinkTianshui getInstance() {
        if (instance == null) {
            instance = new LisLinkTianshui();
        }
        return instance;
    }

    PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);
    PatientLisDataDao patientLisDataDao = SpringUtils.getBean(PatientLisDataDao.class);

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

    JianYan jianYan;

    public String GetPatientLabTestMaster(String id) {
        clear();
        PatientLink patientLink = patientLinkDao.findById(id);
        if (patientLink != null) {
            System.out.println(patientLink.getPatient().getBrxm() + ":" + patientLink.getPatient().getZyh());
            String xmlString = reqRespData(getPatientLabMessage(patientLink));
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
            if (itemTypeList.size() > 0) {
                JianYan jy = getJianyan(patientLink, samllmap);
                System.out.println(jy);
                PatientLisData patientLisData = patientLisDataDao.getPatientLisData8PatientId(id);
                if (patientLisData == null) {
                    patientLisData = new PatientLisData();
                }
                patientLisData.setZyh(patientLink.getPatient().getZyh());
                patientLisData.setPatientID(id);
                patientLisData.setJianYan(jy);
                patientLisData.setBeginTime(new Date());
                if (jy != null) {
                    patientLisData.setResult(true);
                } else {
                    patientLisData.setResult(false);
                }
//                patientLisDataDao.addUpdate(patientLisData);
            }
        }
        this.logger.warn("getLisData over...");
        return "succes";
    }

    public String getPatientLabMessage(PatientLink p) {


        String m = "<GetPatientLabTestMaster xmlns=\"http://tempuri.org/\">"
                + "<PatientId>" + p.getPatient().getZyh() + "</PatientId>"
                + "<VisitId>1</VisitId>" + "</GetPatientLabTestMaster>";

        return m;
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
        List<ITEMType> mapRules = new ArrayList<>();
        int index = 0;
        String testNo = "";
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, List> entry : map.entrySet()) {
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
                                if(itemType.getResult().contains("4+")||itemType.getResult().contains("阳")){
                                    xuexing = xuexing +" Rh+";
                                }else
                                {
                                    xuexing = xuexing +" Rh-";
                                }
                            }
                            jianYan.setBloodType(xuexing);
                            continue;
                        }
                        if (itemType.getReportItemName().contains("免疫全套")) {
                            if (itemType.getReportParmNameSX().equalsIgnoreCase("HBsAg")) {
                            	System.out.println("HBsAg:"+StringUtil.ToDouble(itemType.getResult()));
                                if (StringUtil.ToDouble(itemType.getResult()) >= HBSAG) {
                                    HBsAg = "(+)";
                                } else {
                                    HBsAg = "(-)";
                                }
                                jianYan.setHbsag(HBsAg);
                                continue;
                            }
                            if (itemType.getReportParmNameSX().equalsIgnoreCase("HBeAg")) {
                            	System.out.println("HBeAg:"+StringUtil.ToDouble(itemType.getResult()));
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
                                xuechanggui = xuechanggui + itemType.getReportParmNameSX()+ " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("PLT")) {
                                if (xuechanggui.equalsIgnoreCase("未查")) {
                                    xuechanggui = "";
                                }
                                xuechanggui = xuechanggui + itemType.getReportParmNameSX()+ " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("WBC")) {
                                if (xuechanggui.equalsIgnoreCase("未查")) {
                                    xuechanggui = "";
                                }
                                xuechanggui = xuechanggui + itemType.getReportParmNameSX()+ " " + itemType.getResult() + itemType.getUnit() + " ";
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
                                if (itemType.getResult().contains("阴")||itemType.getResult().contains("-")) {
                                    niaochanggui = niaochanggui + itemType.getReportParmNameSX() + "(-)" + " ";
                                } else {
                                    niaochanggui = niaochanggui + itemType.getReportParmNameSX() + "(+)" + " ";
                                }
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("PRO")) {
                                if (niaochanggui.equalsIgnoreCase("未查")) {
                                    niaochanggui = "";
                                }
                                if (itemType.getResult().contains("阴")||itemType.getResult().contains("-")) {
                                    niaochanggui = niaochanggui + itemType.getReportParmNameSX() + "(-)" + " ";
                                } else {
                                    niaochanggui = niaochanggui + itemType.getReportParmNameSX() + "(+)" + " ";
                                }
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("GLU")) {
                                if (niaochanggui.equalsIgnoreCase("未查")) {
                                    niaochanggui = "";
                                }
                                if (itemType.getResult().contains("阴")||itemType.getResult().contains("-")) {
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
                                gangong = gangong + itemType.getReportParmNameSX()+ " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("ALT")) {
                                if (gangong.equalsIgnoreCase("未查")) {
                                    gangong = "";
                                }
                                gangong = gangong + itemType.getReportParmNameSX()+ " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("AST")) {
                                if (gangong.equalsIgnoreCase("未查")) {
                                    gangong = "";
                                }
                                gangong = gangong + itemType.getReportParmNameSX()+ " " + itemType.getResult() + itemType.getUnit() + " ";
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
                                shengong = shengong + itemType.getReportParmNameSX()+ " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("Cr")) {
                                if (shengong.equalsIgnoreCase("未查")) {
                                    shengong = "";
                                }
                                shengong = shengong + itemType.getReportParmNameSX()+ " " + itemType.getResult() + itemType.getUnit() + " ";
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
                                dianjiezhi = dianjiezhi + itemType.getReportParmNameSX()+ " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("Na")) {
                                if (dianjiezhi.equalsIgnoreCase("未查")) {
                                    dianjiezhi = "";
                                }
                                dianjiezhi = dianjiezhi + itemType.getReportParmNameSX()+ " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("Ca")) {
                                if (dianjiezhi.equalsIgnoreCase("未查")) {
                                    dianjiezhi = "";
                                }
                                dianjiezhi = dianjiezhi + itemType.getReportParmNameSX()+ " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("Mg")) {
                                if (dianjiezhi.equalsIgnoreCase("未查")) {
                                    dianjiezhi = "";
                                }
                                dianjiezhi = dianjiezhi + itemType.getReportParmNameSX()+ " " + itemType.getResult() + itemType.getUnit() + " ";
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
                                ningxue = ningxue + itemType.getReportParmNameSX()+ " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("APTT")) {
                                if (ningxue.equalsIgnoreCase("未查")) {
                                    ningxue = "";
                                }
                                ningxue = ningxue + itemType.getReportParmNameSX()+ " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("TT")) {
                                if (ningxue.equalsIgnoreCase("未查")) {
                                    ningxue = "";
                                }
                                ningxue = ningxue + itemType.getReportParmNameSX()+ " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("FIB")) {
                                if (ningxue.equalsIgnoreCase("未查")) {
                                    ningxue = "";
                                }
                                ningxue = ningxue + itemType.getReportParmNameSX()+ " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("D-D")) {
                                if (ningxue.equalsIgnoreCase("未查")) {
                                    ningxue = "";
                                }
                                ningxue = ningxue + itemType.getReportParmNameSX()+ " " + itemType.getResult() + itemType.getUnit() + " ";
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
                                jiagong = jiagong + itemType.getReportParmNameSX()+ " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("FT4")) {
                                if (jiagong.equalsIgnoreCase("未查")) {
                                    jiagong = "";
                                }
                                jiagong = jiagong + itemType.getReportParmNameSX()+ " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else if (itemType.getReportParmNameSX().equalsIgnoreCase("hTSH")) {
                                if (jiagong.equalsIgnoreCase("未查")) {
                                    jiagong = "";
                                }
                                jiagong = jiagong + itemType.getReportParmNameSX()+ " " + itemType.getResult() + itemType.getUnit() + " ";
                            } else {
                                //jiagong = "未见异常";
                            }
                            jianYan.setJiaGong(jiagong);
                            continue;
                        }
                        if (itemType.getReportItemName().contains("葡萄糖测定")) {
                            if(!"".equalsIgnoreCase(itemType.getResult())) {
                                xuetang = itemType.getReportParmNameSX() + " " + itemType.getResult() + itemType.getUnit() + " ";
                            }
                            jianYan.setXueTang(xuetang);
                            continue;
                        }
                        if (itemType.getReportItemName().contains("血气分析")) {
                            if(!"".equalsIgnoreCase(itemType.getResult())) {
                                xueqifenxi = itemType.getResult();
                            }
                            jianYan.setXueQiFenXi( xueqifenxi);
                            continue;
                        }
                        if (itemType.getReportItemName().contains("胸部正侧位")) {
                            if(!"".equalsIgnoreCase(itemType.getResult())) {
                                xiongpian = itemType.getResult();
                            }
                            jianYan.setXiongPian(xiongpian);
                            continue;
                        }
                        if (itemType.getReportItemName().contains("超声心动图")) {
                            if(itemType.getResult().contains("★")){
                                String arr[]=itemType.getResult().split("★");
                                xindongtu = arr[0];
                                System.out.println("xindongtu:"+xindongtu);
                                jianYan.setChaoShengXinDongTu( xindongtu);
                                continue;
                            }else {
                                if(!"".equalsIgnoreCase(itemType.getResult())) {
                                    xindongtu = itemType.getResult();
                                }
                                System.out.println("xindongtu:"+xindongtu);
                                jianYan.setChaoShengXinDongTu( xindongtu);
                                continue;

                            }
                        }
                        if (itemType.getReportItemName().contains("心电图")) {
                            if(!"".equalsIgnoreCase(itemType.getResult())){
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

    public String getMessage(String paibanMessage) {
        String message = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">" + "<soap12:Body>" + paibanMessage + "</soap12:Body>" + "</soap12:Envelope>";
        return message;
    }

    protected String trimStr(String str) {
        if (null == str)
            return "";
        return str.trim();
    }

    public String GetLabTestResult(String testNo) {
        String m = "<GetLabTestResult xmlns=\"http://tempuri.org/\">" + "<TestNo>" + testNo + "</TestNo>" + "</GetLabTestResult>";
        return m;
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
}
