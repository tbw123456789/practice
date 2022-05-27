package cn.medigical.publish.interfaces.lis.lisNantong;


import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.dao.impl.PatientLisDataDao;
import cn.medigical.publish.interfaces.his.hisNantong.interface4Business.JYJGXMInterface;
import cn.medigical.publish.interfaces.his.hisNantong.interface4Business.JYXMInterface;
import cn.medigical.publish.interfaces.his.hisNantong.stub.SendCmdSvr;
import cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.ITEMType;
import cn.medigical.publish.pojo.lis.JianYan;
import cn.medigical.publish.pojo.patient.PatientLisData;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.utils.SpringUtils;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LisDataNantong2 {
    protected Logger logger;
    protected JYXMInterface jyxmInterface;
    protected JYJGXMInterface jyjgxmInterface;
    public String[] rbc;
    public String[] hb;
    public String[] hct;
    public String[] plt;
    public String[] wbc;
    public String[] bloodType;
    public String[] niaoChangGui;
    public String[] dianJieZhi;
    public String[] ganGongNeng;
    public String[] shenGongNeng;
    public String[] xueTang;
    public String[] ningXueGongNeng;
    public String[] xueQiFenXi;
    public Map<String, String> SMALLITEMCODE_ENNAME;
    public Map<String, String[]> NAME_SMALLITEMCODESMAP;
    public Map<String, String> SMALLITEMCODE_VALUE;
    
    public List<cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType> timeCodeList;

    PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);
    PatientLisDataDao patientLisDataDao = SpringUtils.getBean(PatientLisDataDao.class);
    AccountDao accountDao = (AccountDao) SpringUtils.getBean(AccountDao.class);
    private static LisDataNantong2 instance;

    public static LisDataNantong2 getInstance() {
        if (instance == null) {
            instance = new LisDataNantong2();
        }
        return instance;
    }

    public LisDataNantong2() {
        this.logger = Logger.getLogger("LisDataNantong");
        this.jyxmInterface = new JYXMInterface();
        this.jyjgxmInterface = new JYJGXMInterface();
        this.rbc = new String[]{"1902"};
        this.hb = new String[]{"1903"};
        this.hct = new String[]{"1904"};
        this.plt = new String[]{"1905"};
        this.wbc = new String[]{"1901"};
        this.bloodType = new String[]{"3128", "3129"};
        this.niaoChangGui = new String[]{"5965", "2028", "2023", "2024"};
        this.dianJieZhi = new String[]{"1654", "1655", "1648", "1608", "1681"};
        this.ganGongNeng = new String[]{"1624", "1625", "1651", "1620", "1621"};
        this.shenGongNeng = new String[]{"1640", "1645", "1646"};
        this.xueTang = new String[]{"1607"};
        this.ningXueGongNeng = new String[]{"2001", "2004", "2002", "2003", "5021", "5361"};
        this.ningXueGongNeng = new String[]{"2001", "2004", "2002", "2003", "5021", "5361"};
        this.xueQiFenXi=new String[]{"6484", "6486", "6485",};
        this.SMALLITEMCODE_ENNAME = new HashMap();
        this.SMALLITEMCODE_ENNAME.put("5965", "PRO");
        this.SMALLITEMCODE_ENNAME.put("2028", "GLU");
        this.SMALLITEMCODE_ENNAME.put("2023", "KET");
        this.SMALLITEMCODE_ENNAME.put("2024", "BLD");
        this.SMALLITEMCODE_ENNAME.put("1654", "K");
        this.SMALLITEMCODE_ENNAME.put("1655", "Na");
        this.SMALLITEMCODE_ENNAME.put("1648", "CA");
        this.SMALLITEMCODE_ENNAME.put("1608", "MG");
        this.SMALLITEMCODE_ENNAME.put("1681", "P");
        this.SMALLITEMCODE_ENNAME.put("1624", "TP");
        this.SMALLITEMCODE_ENNAME.put("1625", "ALB");
        this.SMALLITEMCODE_ENNAME.put("1651", "GLB");
        this.SMALLITEMCODE_ENNAME.put("1620", "ALT");
        this.SMALLITEMCODE_ENNAME.put("1621", "AST");
        this.SMALLITEMCODE_ENNAME.put("1640", "UREA");
        this.SMALLITEMCODE_ENNAME.put("1645", "CREA");
        this.SMALLITEMCODE_ENNAME.put("1646", "UA");
        this.SMALLITEMCODE_ENNAME.put("1607", "GLU");
        this.SMALLITEMCODE_ENNAME.put("2001", "PT");
        this.SMALLITEMCODE_ENNAME.put("2004", "PT-INR");
        this.SMALLITEMCODE_ENNAME.put("2002", "APTT");
        this.SMALLITEMCODE_ENNAME.put("2003", "FIB");
        this.SMALLITEMCODE_ENNAME.put("5021", "TT");
        this.SMALLITEMCODE_ENNAME.put("5361", "D-Dimer");
        this.SMALLITEMCODE_ENNAME.put("6484", "PH");
        this.SMALLITEMCODE_ENNAME.put("6486", "PO2");
        this.SMALLITEMCODE_ENNAME.put("6485", "PCO2");
        this.NAME_SMALLITEMCODESMAP = new HashMap();
        this.NAME_SMALLITEMCODESMAP.put("xueQiFenXi", this.xueQiFenXi);
        this.NAME_SMALLITEMCODESMAP.put("niaoChangGui", this.niaoChangGui);
        this.NAME_SMALLITEMCODESMAP.put("dianJieZhi", this.dianJieZhi);
        this.NAME_SMALLITEMCODESMAP.put("ganGongNeng", this.ganGongNeng);
        this.NAME_SMALLITEMCODESMAP.put("shenGongNeng", this.shenGongNeng);
        this.NAME_SMALLITEMCODESMAP.put("ningXueGongNeng", this.ningXueGongNeng);
        this.NAME_SMALLITEMCODESMAP.put("xueTang", this.xueTang);
        this.NAME_SMALLITEMCODESMAP.put("rbc", this.rbc);
        this.NAME_SMALLITEMCODESMAP.put("hb", this.hb);
        this.NAME_SMALLITEMCODESMAP.put("hct", this.hct);
        this.NAME_SMALLITEMCODESMAP.put("plt", this.plt);
        this.NAME_SMALLITEMCODESMAP.put("wbc", this.wbc);
        this.NAME_SMALLITEMCODESMAP.put("bloodType", this.bloodType);
        this.SMALLITEMCODE_VALUE = new HashMap();
        this.timeCodeList=new ArrayList<>();
    }

    public JianYan getListDataFromHis(String cxlx, String zyh, String pid, String zycs) {
    	   this.SMALLITEMCODE_VALUE.clear();
//        SendCmdSvr sendCmdSvr = new SendCmdSvr();
//
//        boolean iniOK = sendCmdSvr.initial();
//        if (!iniOK) {
//            return null;
//        }
//        List<cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.ITEMType> jyjgxmItemList = this.jyjgxmInterface.getJianYanJGXM(sendCmdSvr, cxlx, zyh, pid, zycs);
//        if (null == jyjgxmItemList) {
//            this.logger.warn("该病人没有检验结果");
//            return null;
//        }
//        Collections.sort(jyjgxmItemList, new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                return 0;
//            }
//
//            public int compare(cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.ITEMType o1, cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.ITEMType o2) {
//                return o2.getAUTHTIME().compareTo(o1.getAUTHTIME());
//            }
//        });
//        for (Iterator localIterator1 = jyjgxmItemList.iterator(); localIterator1.hasNext(); ) {
//            cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.ITEMType jyjgxmItem = new ITEMType();
//            jyjgxmItem = (cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.ITEMType) localIterator1.next();
//            String REPORTID = jyjgxmItem.getREPORTID();
//            List<cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType> jyxmItemList = this.jyxmInterface.getJianYanXM(sendCmdSvr, REPORTID);
//            for (Object localIterator2 = jyxmItemList.iterator(); ((Iterator) localIterator2).hasNext(); ) {
//
//                cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType itemType = new cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType();
//                itemType = (cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType) ((Iterator) localIterator2).next();
//                String SMALLITEMCODE = itemType.getREPORTITEMCODE();
//                String status = trimStr(itemType.getABNORMALINDICATOR());
//                if (status.equals("L")) {
//                    status = "↓";
//                } else if (status.equals("H")) {
//                    status = "↑";
//                } else {
//                    status = "";
//                }
//                String result = itemType.getRESULT();
//                String SMALLITEMNAMEEN = (String) this.SMALLITEMCODE_ENNAME.get(SMALLITEMCODE);
//                if (null != SMALLITEMNAMEEN) {
//                    this.SMALLITEMCODE_VALUE.put(SMALLITEMCODE, (String) this.SMALLITEMCODE_ENNAME.get(SMALLITEMCODE) + ":" + result + status + itemType.getUNITS());
//                } else {
//                    this.SMALLITEMCODE_VALUE.put(SMALLITEMCODE, result + status);
//                }
//            }
//        }
//        cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.ITEMType jyjgxmItem;
//        Iterator localIterator2;
//        cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType itemType;
//        int SMALLITEMCODE;
//        String status = "";
//        JianYan jianYan = new JianYan();
//        for (Map.Entry<String, String[]> NAME_SMALLITEMCODES : this.NAME_SMALLITEMCODESMAP.entrySet()) {
//            String PROPERTY = (String) NAME_SMALLITEMCODES.getKey();
//            StringBuffer valueStr = new StringBuffer("");
//            String[] itemTypeStr = (String[]) NAME_SMALLITEMCODES.getValue();
//            SMALLITEMCODE = itemTypeStr.length;
//            for (int i = 0; i < SMALLITEMCODE; i++) {
//                String s = itemTypeStr[i];
//                String SMALLITEMVALUE = (String) this.SMALLITEMCODE_VALUE.get(s);
//                if (null != SMALLITEMVALUE) {
//                    valueStr.append(SMALLITEMVALUE + " ");
//                }
//            }
//            if (!"".equals(valueStr.toString())) {
//                if (PROPERTY.equals("bloodType")) {
//                    //AllDataPool.getInstance().getCurOperAllData().getOperation().getPatient().setBloodType(valueStr.toString());
//                } else {
//                    setFieldValue(jianYan, PROPERTY, valueStr.toString());
//                }
//            }
//        }

        SendCmdSvr sendCmdSvr = new SendCmdSvr();
        timeCodeList.clear();
        boolean iniOK = sendCmdSvr.initial();
        if (!iniOK) {
            return null;
        }
        List<cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.ITEMType> jyjgxmItemList = this.jyjgxmInterface.getJianYanJGXM(sendCmdSvr, cxlx, zyh, pid, zycs);
        if (null == jyjgxmItemList) {
            this.logger.warn("该病人没有检验结果");
            return null;
        }
        Collections.sort(jyjgxmItemList, new Comparator() {
            public int compare(cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.ITEMType o1, cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.ITEMType o2) {
                return o2.getAUTHTIME().compareTo(o1.getAUTHTIME());
            }

            @Override
            public int compare(Object arg0, Object arg1) {
                // TODO Auto-generated method stub
                return 0;
            }
        });
        cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.ITEMType jyjgxmItem;
        Iterator localIterator2;
        cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType itemType1;
        String SMALLITEMCODE;
        String status;
        for (Iterator localIterator1 = jyjgxmItemList.iterator(); localIterator1.hasNext(); ) {
            jyjgxmItem = (cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.ITEMType) localIterator1.next();
            String REPORTID = jyjgxmItem.getREPORTID();
            List<cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType> jyxmItemList = this.jyxmInterface.getJianYanXM(sendCmdSvr, REPORTID);
            for (localIterator2 = jyxmItemList.iterator(); localIterator2.hasNext(); ) {
                itemType1 = (cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType) localIterator2.next();
                timeCodeList.add(itemType1);
                cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType itemType=getResultBytime(itemType1, timeCodeList);
                SMALLITEMCODE = itemType.getREPORTITEMCODE();
                logger.info("检验项目小项名字："+itemType.getREPORTITEMNAME()+"  值为"+itemType.getRESULT()+"   code:"+itemType.getREPORTITEMCODE()+"时间"+itemType.getRESULTDATETIME());
                status = trimStr(itemType.getABNORMALINDICATOR());
                if (status.equals("L")) {
                    status = "↓";
                } else if (status.equals("H")) {
                    status = "↑";
                } else {
                    status = "";
                }
                String result =itemType.getRESULT();
               
                String SMALLITEMNAMEEN = (String) this.SMALLITEMCODE_ENNAME.get(SMALLITEMCODE);
                if (null != SMALLITEMNAMEEN) {
//                    if (this.SMALLITEMCODE_VALUE.get(SMALLITEMCODE) == null || ("").equals(this.SMALLITEMCODE_VALUE.get(SMALLITEMCODE))) {
                        this.SMALLITEMCODE_VALUE.put(SMALLITEMCODE, (String) this.SMALLITEMCODE_ENNAME.get(SMALLITEMCODE) + ":" + result + status + itemType.getUNITS());
 //                   }
                } else {
//                    if (this.SMALLITEMCODE_VALUE.get(SMALLITEMCODE) == null || ("").equals(this.SMALLITEMCODE_VALUE.get(SMALLITEMCODE))) {
                        this.SMALLITEMCODE_VALUE.put(SMALLITEMCODE, result + status);
 //                   }
                }
            }
          
        }
        JianYan jianYan = new JianYan();
        int status2;
        int SMALLITEMCODE2;
        for (Map.Entry<String, String[]> NAME_SMALLITEMCODES : this.NAME_SMALLITEMCODESMAP.entrySet()) {
            String PROPERTY = (String) NAME_SMALLITEMCODES.getKey();

            StringBuffer valueStr = new StringBuffer("");
            String[] str = (String[]) NAME_SMALLITEMCODES.getValue();
            SMALLITEMCODE2 = str.length;
            for (status2 = 0; status2 < SMALLITEMCODE2; status2++) {
                String s = str[status2];
                String SMALLITEMVALUE = (String) this.SMALLITEMCODE_VALUE.get(s);
                if (null != SMALLITEMVALUE) {
                    valueStr.append(SMALLITEMVALUE + " ");
                }
            }
            if (!"".equals(valueStr.toString())) {
                if (PROPERTY.equals("bloodType")) {
                	 setFieldValue(jianYan, PROPERTY, valueStr.toString());
                } else {
                    setFieldValue(jianYan, PROPERTY, valueStr.toString());
                }
            }
        }
       logger.info(jianYan);
        return jianYan;
    }

    private cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType getResultBytime(cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType itemType,
    		
			List<cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType> timeCodeList2) {
    		List<cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType> list=new ArrayList<cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType>();
    		if (timeCodeList2.size()>0) {
    			for (cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType itemType2 : timeCodeList2) {
    				if (itemType.getREPORTITEMCODE()!=null && !("").equals(itemType.getREPORTITEMCODE()) && itemType2.getREPORTITEMCODE()!=null) {
						if (itemType.getREPORTITEMCODE().equals(itemType2.getREPORTITEMCODE())) {
							list.add(itemType2);
						}
					}
			}
			}
    		cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType itemType3=itemType;
    		if (list.size()>0) {
    			if (list.get(0).getREPORTITEMCODE().equals("1902")) {
					System.out.println("++++++++++++++");
				}
    			for (cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType itemType2 : list) {
    				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    				try {
						Date date1=format.parse(itemType3.getRESULTDATETIME());
						Date date2=format.parse(itemType2.getRESULTDATETIME());
						if (date2.getTime()>date1.getTime()) {
							if (itemType2.getRESULT()!=null &&! ("").equals(itemType2.getRESULT())) {
								itemType3=itemType2;
							}
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    				
				}
//    			 Collections.sort(list, new Comparator() {
//    			
//    		            public int compare(cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType o1, cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType o2) {
//    		                
//    		            	
//     		            	Date o1Date;
// 							try {
// 								o1Date = format.parse(o1.getRESULTDATETIME());
// 							
//     		            	Date o2Date=format.parse(o2.getRESULTDATETIME());
//     		            	if (o1Date.getTime()<o2Date.getTime()) {
// 								return -1;
// 							}
//     		            	else  if (o1Date.getTime()>o2Date.getTime()) {
// 								return 1;
// 							}else {
// 								return 0;
// 							}
// 							} catch (ParseException e) {
// 							
// 								// TODO Auto-generated catch block
// 								e.printStackTrace();
// 								return 0;
// 							}
//    		            }
//
//						@Override
//						public int compare(Object arg0, Object arg1) {
//							// TODO Auto-generated method stub
//							return 0;
//						}
//
//						
//    		        });
			}
		return itemType3;
	}

	protected void setFieldValue(Object instance, String fieldName, Object fieldValue) {
        try {
            Field field = instance.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            if (fieldName.equals("rbc")) {
                System.out.println("+++++++++++++++++++++++++++" + fieldValue);
            }
            if (field.get(instance) != null && !("").equals(field.get(instance).toString())) {
                return;
            }
            ;
            field.set(instance, fieldValue);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected String trimStr(String str) {
        if (null == str) {
            return "";
        }
        return str.trim();
    }


    //
//    public void getLisFromHis(String Pid, String zyh) {
//        JianYan jy = getListDataFromHis("2", zyh, "", "");
    public void getLisFromHis(String PatientId, String zyh, String pid, String zycs) {
        JianYan jy;
        String cxlx;
        if (zycs == null||"".equalsIgnoreCase(zycs)) {
            cxlx = "";
        } else {
            cxlx = "1";
        }
        jy = getListDataFromHis(cxlx, zyh, pid, zycs);
        System.out.println(jy);
        PatientLisData patientLisData = patientLisDataDao.getPatientLisData8PatientId(PatientId);
        System.out.println(patientLisData);
        if (patientLisData == null) {
            patientLisData = new PatientLisData();
        }
        patientLisData.setZyh(zyh);
        patientLisData.setPatientID(PatientId);
        patientLisData.setJianYan(jy);
        if (jy != null) {
            patientLisData.setResult(true);
        } else {
            patientLisData.setResult(false);
        }
        patientLisData.setBeginTime(new Date());
        patientLisDataDao.addUpdate(patientLisData);
    }
}
