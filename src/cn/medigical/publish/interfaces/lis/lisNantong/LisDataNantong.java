package cn.medigical.publish.interfaces.lis.lisNantong;


import cn.medigical.publish.interfaces.his.hisNantong.interface4Business.JYJGXMInterface;
import cn.medigical.publish.interfaces.his.hisNantong.interface4Business.JYXMInterface;
import cn.medigical.publish.interfaces.his.hisNantong.stub.SendCmdSvr;
import cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.ITEMType;
import cn.medigical.publish.pojo.lis.JianYan;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.util.*;
import java.util.Map.Entry;

public class LisDataNantong {
    protected Logger logger;
    protected JYXMInterface jyxmInterface;
    protected JYJGXMInterface jyjgxmInterface;
    Map<String, String> XCG_CODE_PROPER;
    public String[] bloodType;
    public String[] niaoChangGui;
    public String[] dianJieZhi;
    public String[] ganGongNeng;
    public String[] shenGongNeng;
    public String[] xueTang;
    public String[] ningXueGongNeng;
    public Map<String, String> SMALLITEMCODE_ENNAME;
    public Map<String, String[]> NAME_SMALLITEMCODES;
    String[] bigItemCnNames;
    String[] bigItemPinYinNames;
    String[] bigItemCnNames2;
    String[] bigItemPinYinNames2;

    public LisDataNantong() {
        this.logger = Logger.getLogger("LisDataNantong");

        this.jyxmInterface = new JYXMInterface();
        this.jyjgxmInterface = new JYJGXMInterface();

        this.XCG_CODE_PROPER = new HashMap();

        this.XCG_CODE_PROPER.put("1902", "rbc");
        this.XCG_CODE_PROPER.put("1903", "hb");
        this.XCG_CODE_PROPER.put("1907", "hct");
        this.XCG_CODE_PROPER.put("1905", "plt");
        this.XCG_CODE_PROPER.put("1901", "wbc");


        this.bloodType = new String[]{"3128", "3129"};

        			
        this.niaoChangGui = new String[]{"5965", "2028", "2023", "2024"};


        this.dianJieZhi = new String[]{"1654", "1655", "1648", "1608", "1681"};


        this.ganGongNeng = new String[]{"1624", "1625", "1651", "1620", "1621"};


        this.shenGongNeng = new String[]{"1640", "1645", "1646"};


        this.xueTang = new String[]{"1607"};


        this.ningXueGongNeng = new String[]{"2001", "2004", "2002", "2003", "5021", "5361"};


        this.SMALLITEMCODE_ENNAME = new HashMap();

        this.SMALLITEMCODE_ENNAME.put("5965", "PRO");
        this.SMALLITEMCODE_ENNAME.put("2028", "GLU");
        this.SMALLITEMCODE_ENNAME.put("2023", "KET");
        this.SMALLITEMCODE_ENNAME.put("2024", "BLD");

        this.SMALLITEMCODE_ENNAME.put("1654", "K");
        this.SMALLITEMCODE_ENNAME.put("1655", "NA");
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


        this.NAME_SMALLITEMCODES = new HashMap();

        this.NAME_SMALLITEMCODES.put("niaoChangGui", this.niaoChangGui);
        this.NAME_SMALLITEMCODES.put("dianJieZhi", this.dianJieZhi);
        this.NAME_SMALLITEMCODES.put("ganGongNeng", this.ganGongNeng);
        this.NAME_SMALLITEMCODES.put("shenGongNeng", this.shenGongNeng);
        this.NAME_SMALLITEMCODES.put("ningXueGongNeng", this.ningXueGongNeng);
        this.NAME_SMALLITEMCODES.put("xueTang", this.xueTang);


        this.NAME_SMALLITEMCODES.put("bloodType", this.bloodType);


        this.bigItemCnNames = new String[]{"尿液分析", "电解质", "肝功", "肾功", "凝血像五项", "血常规", "血糖", "血型"};
        this.bigItemPinYinNames = new String[]{"niaoChangGui", "dianJieZhi", "ganGongNeng", "shenGongNeng", "ningXueGongNeng", "xueChangGui", "xueTang", "bloodType"};


        this.bigItemCnNames2 = new String[]{"生化四项", "心肌酶谱五项", "心肌酶谱五项", "肾功", "肾功"};
        this.bigItemPinYinNames2 = new String[]{"dianJieZhi", "shenGongNeng", "xueTang", "ganGongNeng", "xueTang"};
    }

    public JianYan getListDataFromHis(String pid, String zycs) {
        SendCmdSvr sendCmdSvr = new SendCmdSvr();

        boolean iniOK = sendCmdSvr.initial();
        if (!iniOK) {
            return null;
        }
        List<cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.ITEMType> jyjgxmItemList = this.jyjgxmInterface.getJianYanJGXM(sendCmdSvr, pid, zycs);
        if (null == jyjgxmItemList) {
            this.logger.warn("该病人没有检验结果");
            return null;
        }
        Collections.sort(jyjgxmItemList, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }

            public int compare(cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.ITEMType o1, cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.ITEMType o2) {
                return o1.getAUTHTIME().compareTo(o2.getAUTHTIME());
            }
        });
        JianYan jianYan = new JianYan();

        Map<String, cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.ITEMType> PYNAME_MAP_JYITEM = new HashMap();
        Map<String, cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.ITEMType> PYNAME_MAP_JYITEM2 = new HashMap();
        for (Object localObject1 = jyjgxmItemList.iterator(); ((Iterator) localObject1).hasNext(); ) {
            cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.ITEMType jyjgxmItem=new ITEMType();
            jyjgxmItem = (cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.ITEMType) ((Iterator) localObject1).next();
            String bigItemName = jyjgxmItem.getSPECNAME();
            this.logger.warn("获取检验大项中文名" + bigItemName);
            int i = 0;
            String[] arrayOfString1 = this.bigItemCnNames;
            i = arrayOfString1.length;
            for (int str1 = 0; str1 < i; str1++) {
            	if (str1>=arrayOfString1.length) {
					continue;
				}
                String bigItemCnName = arrayOfString1[str1];
                if (bigItemName.contains(bigItemCnName)) {
                    if (PYNAME_MAP_JYITEM.containsKey(this.bigItemPinYinNames[i])) {
                        break;
                    }
                    PYNAME_MAP_JYITEM.put(this.bigItemPinYinNames[i], jyjgxmItem);
                }
                i++;
            }
            int j = 0;
            String[] localObject2 = this.bigItemCnNames2;
            int str1 = localObject2.length;
            for (int k = 0; k < str1; k++) {
                String bigItemCnName = localObject2[k];
                if (bigItemName.contains(bigItemCnName)) {
                    if (PYNAME_MAP_JYITEM2.containsKey(this.bigItemPinYinNames2[j])) {
                        break;
                    }
                    PYNAME_MAP_JYITEM2.put(this.bigItemPinYinNames2[j], jyjgxmItem);
                }
                j++;
            }
            if (PYNAME_MAP_JYITEM.size() > 7) {
                this.logger.warn("获取检验完成，共获取" + PYNAME_MAP_JYITEM.size() + "项");
                break;
            }
        }
        Object localObject2;
        this.logger.warn("已取到" + PYNAME_MAP_JYITEM.size() + "条所需结果");

        String[] localObject1 = this.bigItemPinYinNames2;
        //int str2 = localObject1.length;
        for (int k = 0; k < localObject1.length; k++) {
            String s = localObject1[k];
            if ((!PYNAME_MAP_JYITEM.containsKey(s)) &&
                    (PYNAME_MAP_JYITEM2.containsKey(s))) {
                PYNAME_MAP_JYITEM.put(s, PYNAME_MAP_JYITEM2.get(s));
            }
        }
        int i = 0;
        for (Entry<String, cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.ITEMType> PINYINNAME_JYITEM : PYNAME_MAP_JYITEM.entrySet()) {
            String REPORTID = ((cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanjgxm.ITEMType) PINYINNAME_JYITEM.getValue()).getREPORTID();

            Object jyxmItemList = this.jyxmInterface.getJianYanXM(sendCmdSvr, REPORTID);

            this.logger.warn("第" + i++ + "项=" + (String) PINYINNAME_JYITEM.getKey());
            if (null == jyxmItemList) {
                this.logger.warn((String) PINYINNAME_JYITEM.getKey() + "大项没有结果，结果为NULL");
            } else {
                String status;
                if (((String) PINYINNAME_JYITEM.getKey()).equals(this.bigItemPinYinNames[5])) {
                    for (localObject2 = ((List) jyxmItemList).iterator(); ((Iterator) localObject2).hasNext(); ) {
                        cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType itemType = (cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType) ((Iterator) localObject2).next();
                        String SMALLITEMCODE = itemType.getREPORTITEMCODE();
                        if (this.XCG_CODE_PROPER.containsKey(SMALLITEMCODE)) {
                            status = trimStr(itemType.getABNORMALINDICATOR());
                            if (status.equals("L")) {
                                status = "↓";
                            } else if (status.equals("H")) {
                                status = "↑";
                            } else {
                                status = "";
                            }
                            String result = itemType.getRESULT();

                            String lastResult = result + status;
                            this.logger.warn(itemType.getREPORTITEMNAME() + "=" + lastResult);
                            setFieldValue(jianYan, (String) this.XCG_CODE_PROPER.get(SMALLITEMCODE), lastResult);
                        }
                    }
                } else {
                    String[] strings = this.NAME_SMALLITEMCODES.get(PINYINNAME_JYITEM.getKey());
                    Object SMALLITEMCODES = Arrays.asList(strings);

                    StringBuffer bigItemResult = new StringBuffer("");
                    for (Object itemType : (List) jyxmItemList) {
                        String SMALLITEMCODE = ((cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType) itemType).getREPORTITEMCODE();
                        if (((List) SMALLITEMCODES).contains(SMALLITEMCODE)) {
                            String showSmallItemName = (String) this.SMALLITEMCODE_ENNAME.get(SMALLITEMCODE);

                            status = trimStr(((cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType) itemType).getABNORMALINDICATOR());
                            if (status.equals("L")) {
                                status = "↓";
                            } else if (status.equals("H")) {
                                status = "↑";
                            } else {
                                status = "";
                            }
                            String result = ((cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType) itemType).getRESULT();
                            this.logger.warn(showSmallItemName + "=" + result + status);
                            bigItemResult.append(showSmallItemName + ":" + result + status + ((cn.medigical.publish.interfaces.his.hisNantong.xml.jianyanxm.ITEMType) itemType).getUNITS() + " ");
                        }
                    }
                    this.logger.warn((String) PINYINNAME_JYITEM.getKey() + "=" + bigItemResult);
                    setFieldValue(jianYan, (String) PINYINNAME_JYITEM.getKey(), bigItemResult.toString());
                }
            }
        }
        return jianYan;
    }

    protected void setFieldValue(Object instance, String fieldName, Object fieldValue) {
        try {
            Field field = instance.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
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
}





