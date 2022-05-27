package cn.medigical.publish.interfaces.lis.hishezhouguangji;

import cn.medigical.publish.pojo.lis.JianYan;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.text.DecimalFormat;
import java.util.*;

public class LisDataHeZhouGuangJi {

    Logger logger;

    public Map<String, String> SMALLITEMCODE_ENNAME;
    public Map<String, String> SMALLITEMCODE_PROPERTY;
    private static LisDataHeZhouGuangJi instance;

    public LisDataHeZhouGuangJi() {
        logger = Logger.getLogger("LisDataHeZhouGuangJi");

        this.SMALLITEMCODE_ENNAME = new HashMap();

        //肝功能
        this.SMALLITEMCODE_ENNAME.put("SH001", "AST");//*天门冬氨酸氨基转酶测定
        this.SMALLITEMCODE_ENNAME.put("SH002", "ALT");//丙氨酸氨基转移酶
        //this.SMALLITEMCODE_ENNAME.put("SH003", "A/A");//A/A
        this.SMALLITEMCODE_ENNAME.put("SH004", "TP");//*总蛋白
        this.SMALLITEMCODE_ENNAME.put("SH050", "ALB");//*白蛋白测定
        this.SMALLITEMCODE_ENNAME.put("SH006", "GLO");//球蛋白
        this.SMALLITEMCODE_ENNAME.put("SH007", "A/G");//A/G
        this.SMALLITEMCODE_ENNAME.put("SH009", "TBIL");//*总胆红素
        this.SMALLITEMCODE_ENNAME.put("SH010", "DBIL");//直接胆红素
        this.SMALLITEMCODE_ENNAME.put("SH011", "IBIL");//间接胆红素
//        this.SMALLITEMCODE_ENNAME.put("SH012", "TBA");//血清总胆汁酸测定
//        this.SMALLITEMCODE_ENNAME.put("SH015", "ALP");//*碱性磷酸酶
//        this.SMALLITEMCODE_ENNAME.put("SH016", "GGT");//γ-谷氨酰基转移酶

        //肾功能
        this.SMALLITEMCODE_ENNAME.put("SH019", "Urea");//*尿素
        this.SMALLITEMCODE_ENNAME.put("SH020", "CREA");//*肌酐
        this.SMALLITEMCODE_ENNAME.put("SH022", "Cys-C");//胱抑素C
        this.SMALLITEMCODE_ENNAME.put("SH023", "CCR");//内生肌酐清除率

        //尿常规
//        this.SMALLITEMCODE_ENNAME.put("NY027", "DBZ");//*蛋白质
//        this.SMALLITEMCODE_ENNAME.put("NY001", "HXB");//红细胞
//        this.SMALLITEMCODE_ENNAME.put("NY030", "TT");//*尿酮体
//        this.SMALLITEMCODE_ENNAME.put("NY028", "DHS");//*尿胆红素
//        this.SMALLITEMCODE_ENNAME.put("NY002", "BXB");//*白细胞
//        this.SMALLITEMCODE_ENNAME.put("NY045", "NQX");//尿潜血
//        this.SMALLITEMCODE_ENNAME.put("NY024", "PTT");//*葡萄糖

        //血常规
        this.SMALLITEMCODE_ENNAME.put("XCG012", "RBC");//*红细胞
        this.SMALLITEMCODE_ENNAME.put("XCG020", "PLT");//*血小板计数
        this.SMALLITEMCODE_ENNAME.put("XCG001", "WBC");//*白细胞
        this.SMALLITEMCODE_ENNAME.put("XCG013", "HGB");//*血红蛋白

        //血气分析
        //this.SMALLITEMCODE_ENNAME.put("XQ015", "O2ct");//氧含量
        this.SMALLITEMCODE_ENNAME.put("XQ014", "SBC");//标准碳酸氢根
        //this.SMALLITEMCODE_ENNAME.put("XQ011", "TCO2");//二氧化碳总量
        //this.SMALLITEMCODE_ENNAME.put("XQ012", "BEb");//剩余碱
        this.SMALLITEMCODE_ENNAME.put("XQ019", "Hb");//血红蛋白
        //this.SMALLITEMCODE_ENNAME.put("XQ017", "RI");//呼吸商
        this.SMALLITEMCODE_ENNAME.put("XQ016", "A-aDO");//A-aDO
        //this.SMALLITEMCODE_ENNAME.put("XQ001", "PAT.TEMP1");//病人体温
        //this.SMALLITEMCODE_ENNAME.put("XQ010", "HCO3-");//实际碳酸氢根
        this.SMALLITEMCODE_ENNAME.put("XQ009", "PO2(2)");//PO2(T)
        //this.SMALLITEMCODE_ENNAME.put("XQ018", "%SOc");//氧饱和度
        this.SMALLITEMCODE_ENNAME.put("XQ004", "PH");//PH值
        //this.SMALLITEMCODE_ENNAME.put("XQ002", "PI02");//吸氧浓度
        //this.SMALLITEMCODE_ENNAME.put("XQ013", "BEecf");//细胞外剩余碱
        //this.SMALLITEMCODE_ENNAME.put("XQ003", "B.P.");//B.P.
        //this.SMALLITEMCODE_ENNAME.put("XQ007", "PH(T)");//PH值（T）
        this.SMALLITEMCODE_ENNAME.put("XQ008", "PCO2(T)");//PCO2(T)
        //this.SMALLITEMCODE_ENNAME.put("XQ005", "LPCO2");//PCO2
        //this.SMALLITEMCODE_ENNAME.put("XQ006", "PO2");//PO2

        //电解质
        this.SMALLITEMCODE_ENNAME.put("SH024", "K");//钾测定
        this.SMALLITEMCODE_ENNAME.put("SH025", "Na");//钠测定
        this.SMALLITEMCODE_ENNAME.put("SH026", "CL");//氯测定
        this.SMALLITEMCODE_ENNAME.put("SH027", "CA");//*钙测定
        this.SMALLITEMCODE_ENNAME.put("SH028", "Mg");//镁测定
        this.SMALLITEMCODE_ENNAME.put("SH029", "P");//无机磷测定

        //凝血功能
        this.SMALLITEMCODE_ENNAME.put("NX001", "PT");//血浆凝血酶原时间测定（PT）
        this.SMALLITEMCODE_ENNAME.put("NX002", "APTT");//活化部分凝血活酶时间测定(APTT)
        this.SMALLITEMCODE_ENNAME.put("NX003", "PT%");//血浆凝血酶原活动度测定（PT%）
        this.SMALLITEMCODE_ENNAME.put("NX004", "INR");//血浆凝血酶原时间比值（INR）
        this.SMALLITEMCODE_ENNAME.put("NX005", "TT");//凝血酶时间测定（TT）
        this.SMALLITEMCODE_ENNAME.put("NX006", "FIB");//血浆纤维蛋白原测定（FIB）

        //其他
//        this.SMALLITEMCODE_ENNAME.put("SH030", "GLU");//葡萄糖测定
//        this.SMALLITEMCODE_ENNAME.put("SH056", "FN");//纤维结合蛋白测定
//        this.SMALLITEMCODE_ENNAME.put("SH058", "UA");//*血清尿酸测定
//        this.SMALLITEMCODE_ENNAME.put("SH061", "CO2cp");//血清碳酸氢盐（HCO3）测定
//        this.SMALLITEMCODE_ENNAME.put("SH073", "RBP");//视黄醇结合蛋白(RBP)
//        this.SMALLITEMCODE_ENNAME.put("SH086", "G-6-PD");//葡萄糖-6-磷酸脱氢酶测定
        this.SMALLITEMCODE_ENNAME.put("SH037", "CK");//肌酸激酶
//        this.SMALLITEMCODE_ENNAME.put("SH038", "CK-MB");//肌酸激酶同工酶
//        this.SMALLITEMCODE_ENNAME.put("SH039", "LDH");//乳酸脱氢酶测定
//        this.SMALLITEMCODE_ENNAME.put("SH040", "α-HBDH");//α羟基丁酸脱氢酶
//        this.SMALLITEMCODE_ENNAME.put("SH041", "血清肌钙蛋白I测定");//血清肌钙蛋白I测定



        this.SMALLITEMCODE_PROPERTY = new HashMap();

        //肝功能
        this.SMALLITEMCODE_PROPERTY.put("SH001", "ganGongNeng");//*天门冬氨酸氨基转酶测定
        this.SMALLITEMCODE_PROPERTY.put("SH002", "ganGongNeng");//丙氨酸氨基转移酶
        //this.SMALLITEMCODE_PROPERTY.put("SH003", "ganGongNeng");//A/A
        this.SMALLITEMCODE_PROPERTY.put("SH004", "ganGongNeng");//*总蛋白
        this.SMALLITEMCODE_PROPERTY.put("SH050", "ganGongNeng");//*白蛋白测定
        this.SMALLITEMCODE_PROPERTY.put("SH006", "ganGongNeng");//球蛋白
        this.SMALLITEMCODE_PROPERTY.put("SH007", "ganGongNeng");//A/G
        this.SMALLITEMCODE_PROPERTY.put("SH009", "ganGongNeng");//*总胆红素
        this.SMALLITEMCODE_PROPERTY.put("SH010", "ganGongNeng");//直接胆红素
        this.SMALLITEMCODE_PROPERTY.put("SH011", "ganGongNeng");//间接胆红素
        //this.SMALLITEMCODE_PROPERTY.put("SH012", "ganGongNeng");//血清总胆汁酸测定
        //this.SMALLITEMCODE_PROPERTY.put("SH015", "ganGongNeng");//*碱性磷酸酶
        //this.SMALLITEMCODE_PROPERTY.put("SH016", "ganGongNeng");//γ-谷氨酰基转移酶

        //肾功能
        this.SMALLITEMCODE_PROPERTY.put("SH019", "shenGongNeng");//*尿素
        this.SMALLITEMCODE_PROPERTY.put("SH020", "shenGongNeng");//*肌酐
        this.SMALLITEMCODE_PROPERTY.put("SH022", "shenGongNeng");//胱抑素C
        this.SMALLITEMCODE_PROPERTY.put("SH023", "shenGongNeng");//内生肌酐清除率

//        this.SMALLITEMCODE_PROPERTY.put("NY027", "niaoChangGui");//*蛋白质
//        this.SMALLITEMCODE_PROPERTY.put("NY001", "niaoChangGui");//红细胞
//        this.SMALLITEMCODE_PROPERTY.put("NY030", "niaoChangGui");//*尿酮体
//        this.SMALLITEMCODE_PROPERTY.put("NY028", "niaoChangGui");//*尿胆红素
//        this.SMALLITEMCODE_PROPERTY.put("NY002", "niaoChangGui");//*白细胞
//        this.SMALLITEMCODE_PROPERTY.put("NY045", "niaoChangGui");//尿潜血
//        this.SMALLITEMCODE_PROPERTY.put("NY024", "niaoChangGui");//*葡萄糖

        //血常规
        this.SMALLITEMCODE_PROPERTY.put("XCG012", "xueChangGui");//*红细胞
        this.SMALLITEMCODE_PROPERTY.put("XCG020", "xueChangGui");//*血小板计数
        this.SMALLITEMCODE_PROPERTY.put("XCG001", "xueChangGui");//*白细胞
        this.SMALLITEMCODE_PROPERTY.put("XCG013", "xueChangGui");//*血红蛋白

        //血气分析
        //this.SMALLITEMCODE_PROPERTY.put("XQ015", "xueQiFenXi");//氧含量
        this.SMALLITEMCODE_PROPERTY.put("XQ014", "xueQiFenXi");//标准碳酸氢根
        //this.SMALLITEMCODE_PROPERTY.put("XQ011", "xueQiFenXi");//二氧化碳总量
        //this.SMALLITEMCODE_PROPERTY.put("XQ012", "xueQiFenXi");//剩余碱
        this.SMALLITEMCODE_PROPERTY.put("XQ019", "xueQiFenXi");//血红蛋白
        //this.SMALLITEMCODE_PROPERTY.put("XQ017", "xueQiFenXi");//呼吸商
        this.SMALLITEMCODE_PROPERTY.put("XQ016", "xueQiFenXi");//A-aDO
        //this.SMALLITEMCODE_PROPERTY.put("XQ001", "xueQiFenXi");//病人体温
        //this.SMALLITEMCODE_PROPERTY.put("XQ010", "xueQiFenXi");//实际碳酸氢根
        this.SMALLITEMCODE_PROPERTY.put("XQ009", "xueQiFenXi");//PO2(T)
        //this.SMALLITEMCODE_PROPERTY.put("XQ018", "xueQiFenXi");//氧饱和度
        this.SMALLITEMCODE_PROPERTY.put("XQ004", "xueQiFenXi");//PH值
        //this.SMALLITEMCODE_PROPERTY.put("XQ002", "xueQiFenXi");//吸氧浓度
        //this.SMALLITEMCODE_PROPERTY.put("XQ013", "xueQiFenXi");//细胞外剩余碱
        //this.SMALLITEMCODE_PROPERTY.put("XQ003", "xueQiFenXi");//B.P.
        //this.SMALLITEMCODE_PROPERTY.put("XQ007", "xueQiFenXi");//PH值（T）
        this.SMALLITEMCODE_PROPERTY.put("XQ008", "xueQiFenXi");//PCO2(T)
        //this.SMALLITEMCODE_PROPERTY.put("XQ005", "xueQiFenXi");//PCO2
        //this.SMALLITEMCODE_PROPERTY.put("XQ006", "xueQiFenXi");//PO2

        //电解质
        this.SMALLITEMCODE_PROPERTY.put("SH024", "dianJieZhi");//钾测定
        this.SMALLITEMCODE_PROPERTY.put("SH025", "dianJieZhi");//钠测定
        this.SMALLITEMCODE_PROPERTY.put("SH026", "dianJieZhi");//氯测定
        this.SMALLITEMCODE_PROPERTY.put("SH027", "dianJieZhi");//*钙测定
        this.SMALLITEMCODE_PROPERTY.put("SH028", "dianJieZhi");//镁测定
        this.SMALLITEMCODE_PROPERTY.put("SH029", "dianJieZhi");//无机磷测定

        //凝血功能
        this.SMALLITEMCODE_PROPERTY.put("NX001", "ningXueGongNeng");//血浆凝血酶原时间测定（PT）
        this.SMALLITEMCODE_PROPERTY.put("NX002", "ningXueGongNeng");//活化部分凝血活酶时间测定(APTT)
        this.SMALLITEMCODE_PROPERTY.put("NX003", "ningXueGongNeng");//血浆凝血酶原活动度测定（PT%）
        this.SMALLITEMCODE_PROPERTY.put("NX004", "ningXueGongNeng");//血浆凝血酶原时间比值（INR）
        this.SMALLITEMCODE_PROPERTY.put("NX005", "ningXueGongNeng");//凝血酶时间测定（TT）
        this.SMALLITEMCODE_PROPERTY.put("NX006", "ningXueGongNeng");//血浆纤维蛋白原测定（FIB）

        //其他
//        this.SMALLITEMCODE_PROPERTY.put("SH030", "otherJianYan");//葡萄糖测定
//        this.SMALLITEMCODE_PROPERTY.put("SH056", "otherJianYan");//纤维结合蛋白测定
//        this.SMALLITEMCODE_PROPERTY.put("SH058", "otherJianYan");//*血清尿酸测定
//        this.SMALLITEMCODE_PROPERTY.put("SH061", "otherJianYan");//血清碳酸氢盐（HCO3）测定
//        this.SMALLITEMCODE_PROPERTY.put("SH073", "otherJianYan");//视黄醇结合蛋白(RBP)
//        this.SMALLITEMCODE_PROPERTY.put("SH086", "otherJianYan");//葡萄糖-6-磷酸脱氢酶测定
        this.SMALLITEMCODE_PROPERTY.put("SH037", "otherJianYan");//肌酸激酶
//        this.SMALLITEMCODE_PROPERTY.put("SH038", "otherJianYan");//肌酸激酶同工酶
//        this.SMALLITEMCODE_PROPERTY.put("SH039", "otherJianYan");//乳酸脱氢酶测定
//        this.SMALLITEMCODE_PROPERTY.put("SH040", "otherJianYan");//α羟基丁酸脱氢酶
//        this.SMALLITEMCODE_PROPERTY.put("SH041", "otherJianYan");//血清肌钙蛋白I测定


    }

    public static LisDataHeZhouGuangJi getInstance() {
        if (instance == null) {
            instance = new LisDataHeZhouGuangJi();
        }
        return instance;
    }

    public JianYan getListDataFromHis(final List<JYBigItem> jyBigItemList, List<JYSmallItem> jySmallItemList) {

        if ((null == jyBigItemList) || (jyBigItemList.size() == 0)) {
            return null;
        }

        List<JYSmallItem> JYAllSmallItemList = jySmallItemList;
        if (JYAllSmallItemList.size() == 0 ){
            return null;
        }

        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        Map<String, JYSmallItem> JYShowSmallItemMap = new HashMap();
        for (Iterator localIterator = JYAllSmallItemList.iterator(); localIterator.hasNext();) {
            JYSmallItem jySmallItem = (JYSmallItem) localIterator.next();
            if ((this.SMALLITEMCODE_ENNAME.containsKey(jySmallItem.code))
                    && (!JYShowSmallItemMap.containsKey(jySmallItem.code))) {
//                this.logger.error("------需要的小项--------\n" + jySmallItem.toString());
                jySmallItem.eName = ((String) this.SMALLITEMCODE_ENNAME.get(jySmallItem.code));
                try {
                    Double vlueDoub = Double.valueOf(Double.parseDouble(jySmallItem.vlue));
                    jySmallItem.vlue = decimalFormat.format(vlueDoub);
                } catch (Exception e) {
                }
                JYShowSmallItemMap.put(jySmallItem.code, jySmallItem);
            }
        }
        if (JYShowSmallItemMap.size() == 0) {
            return null;
        }
        JianYan jianYan = new JianYan();
        for (Iterator iterator = JYShowSmallItemMap.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry<String, JYSmallItem> entry = (Map.Entry) iterator.next();
            JYSmallItem jySmallItem = (JYSmallItem) entry.getValue();
            this.logger.fatal("jySmallItem = " + jySmallItem.toString());

            String property = (String) this.SMALLITEMCODE_PROPERTY.get(jySmallItem.code);
            if (("bloodType".equals(property))
                    && ((jySmallItem.code.equals("ABO")) || (jySmallItem.code.equals("RH")))) {
                if (jySmallItem.vlue.contains("型")) {
                    jySmallItem.vlue = jySmallItem.vlue.replace("型", "").trim();
                } else if (jySmallItem.vlue.contains("阳性(+)")) {
                    jySmallItem.vlue = "Rh﹢";
                } else if (jySmallItem.vlue.contains("阴性(-)")) {
                    jySmallItem.vlue = "Rh﹣";
                }
            }
            String eName = jySmallItem.eName;
            String propertyValue = getFieldValue(jianYan, property);
            if ("".equals(eName)) {
                if (null == propertyValue) {
                    propertyValue = jySmallItem.vlue;
                } else {
                    propertyValue = propertyValue + " " + jySmallItem.vlue;
                }
            } else if (null == propertyValue) {
                propertyValue = eName + ":" + jySmallItem.vlue + jySmallItem.unit;
            } else {
                propertyValue = propertyValue + " " + eName + ":" + jySmallItem.vlue + jySmallItem.unit;
            }
            setFieldValue(jianYan, property, propertyValue);
        }
        String[] propertys = { "rbc", "hb", "hct", "plt", "wbc", "bloodType", "niaoChangGui", "dianJieZhi",
                "ganGongNeng", "shenGongNeng", "xueTang", "ningXueGongNeng" };

        for (int property1 = 0; property1 < propertys.length; property1++) {
            String property = propertys[property1];
            String propertyValue = getFieldValue(jianYan, property);
            if (null == propertyValue) {
                setFieldValue(jianYan, property, "未查");
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

    protected String getFieldValue(Object instance, String fieldName) {
        try {
            Field field = instance.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return (String) field.get(instance);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
