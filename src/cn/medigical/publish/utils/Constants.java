package cn.medigical.publish.utils;

public class Constants {
    private Constants() {
    }

    //用药表编码
    public static final String HIS_DRUGS_CODE = "1";

    //耗材表编码
    public static final String HIS_CONSUMES_CODE = "C";

    //武侯区
    public static final String HIS_COURTYARDA_CODE = "A";

    //高新区
    public static final String HIS_COURTYARDB_CODE = "B";

    public static final String HIS_CHARGING_PRIMARY_KEY="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALn6CTuQ8aRXmNlu" +
            "U5OGvsgqyNSdVeQDnlQY0VIHleNWoIFl+ZZozdZRiW6LIXlHSikRCXOpuZ6QuLyA" +
            "qqaOeFJBu4FjCjTSjBvNtuNJq9qRtCxmBdtfXc6YgtvexLbWZ8Gxp4hMQIruIozP" +
            "A1n2bqRDCu3EbvD1bMknQCp8dYUDAgMBAAECgYAS7MO1wQkl7RgLwDNXBtYxLlFj" +
            "eWM9IbUh36ilTUpOaQlKQaNFUALqNT/j9NqCKeP9C9PHZlUSMq3p2LoE2uiZYZ3c" +
            "QOFgTQcglFuwOru0bkKl5Kcwqf2l6pXBkWC5ksP4zimeHPLMr15PAYmXngFoM5x4" +
            "cWGAmv6B3Dy9Hhr40QJBAPGH2Z1Mb0rvQUTIyYq54FKqH/Cq0Vao9TMysCAKs6N/" +
            "rRHQhe5+rmZy1c7/PjLAKXanHSKzuX+0K7+I9uyAUGkCQQDFHjPHNtX7aJYSsG3f" +
            "f+LolvW41gR/2KrcvxBU9dvpG04B0xVOto0ttWG2Ba0mVYeyEb4O8XUW8L3aAgDS" +
            "P3yLAkEA51Y5/ap/EmPUvQAf4cqk7ChcTVQfC4Tqze3nudjmNFyOtPhnv4YAnsmw" +
            "tgHNXiilzirEAj/oFUPJfzu9XcqMuQJAEVMWOewX4oDOr9XR0lLrHoYmEpi8zH++" +
            "hKhGRzFUoqhDsuVaehCRV/MZI2ZcUYIy6vOkQKv4HowKI58Jc3EhAQJBANwCoiH3" +
            "Ip0J/DG3KC0hPPVrSkznTANQuB8PIhfr5Rhzw9MlugRZBOt4hnxTI85ujJ6VeShV" +
            "3X+kgHCgHypY55A=";

   // public static final String HIS_CHARGING_URL = "http://117.172.54.14:10086/xpsm/XdyySmjf/interfacecall";
    public static final String HIS_CHARGING_URL = "http://172.168.3.12:8088/xpsm/XdyySmjf/interfacecall";

    //存储所有的表单
    public static final String EMRPNGMAPTABLES = "emrPngMap";
    /***********************广西贺州、脑科**********************/
    //麻醉单
    public static final String PDF_ANESTABLE = "anesTable";
    //复苏单
    public static final String PDF_PACUTABLE = "pacuTable";
    /***********************广西贺州**********************/
    //术前访视
    public static final String PDF_SHUQIANFANGSHITABLE = "shuqianTable";
    //术后访视
    public static final String PDF_SHUHOUFANGSHITABLE = "shuhouTable";
    //麻醉经过
    public static final String PDF_MAZUIJINGGUOTABLE = "anesprocessTable";

    public static int ONE_SECOND_LONG = 1000;

    public static long ONE_MINUTE_LONG = ONE_SECOND_LONG * 60;

    public static long ONE_HOUR_LONG = ONE_MINUTE_LONG * 60;

    public static long ONE_DAY_LONG = ONE_HOUR_LONG * 24;

    public static int ANESRECORD_WIDTH = 823;

    public static String FLAG_VALID = "valid";
    public static String FLAG_IN_VALID = "invalid";

    public static String AP_STATUS_MAZUIQIAN = "麻醉术前";
    public static String AP_STATUS_MAZUIZHONG = "麻醉术中";
    public static String AP_STATUS_MAZUIHOU = "麻醉术后";

    //明细状态
    public static String OR_STATUS_FLAG_UNKNOWN = "unknown"; // 未知
    public static String OR_STATUS_FLAG_APPLIED = "未排班"; // 申请中，未排班
    public static String OR_STATUS_FLAG_SCHEDULED = "已排班"; // 已经排班
    public static String OR_STATUS_FLAG_CANCEL = "取消已排班"; // 取消已经排班
    public static String OR_STATUS_FLAG_CHECKED = "术前准备"; // 做完术前访视
    public static String OR_STATUS_FLAG_IN_ROOM = "进手术间"; // 术中，正在进行
    public static String OR_STATUS_FLAG_OUT_ROOM = "出手术间";//术后
    public static String OR_STATUS_FLAG_IN_PCU = "入复苏室";
    public static String OR_STATUS_FLAG_OUT_PCU = "出复苏室";
    public static String OR_STATUS_FLAG_MAZUIDAN = "麻醉中";
    public static String OR_STATUS_FLAG_SHOUSHUZHONG = "手术中";
    public static String OR_STATUS_FLAG_HUIFUZHONG = "恢复中";
    //术后病人去往
    public static String ICU = "ICU";
    public static String PACU = "复苏室";
    public static String BINGFANG = "病房";


    public static String OR_STATUS_FLAG_AN = "an";
    public static String OR_STATUS_FLAG_OPERATE = "operate";
    public static String OR_STATUS_FLAG_AN_END = "anEnd";
    public static String OR_STATUS_FLAG_OPERATE_END = "operateEnd";
    public static String OR_STATUS_FLAG_DISCHARGED = "discharged";

    public static String OR_TYPE_SCHEDULE = "schedule";
    public static String OR_TYPE_URGENT = "urgent";

    public static String FEMALE = "female ";
    public static String MALE = "male";

    public static String SPLIT_NAME = "麻醉单";


    public static int BEDSIDE_SHOW_METHOD_TREND = 0;
    public static int BEDSIDE_SHOW_METHOD_TABLE = 1;

    public static int HINT_CAVEAT = 0;
    public static int HINT_PROMPT = 1;
    public static int HINT_QUESTION = 2;
    public static int HINT_WAIT = 3;


    //用药分类

    public static String DRUG_SHUXUE = "shuxue";  //输血
    public static String DRUG_SHUYE = "shuye";   //输液
    public static String DRUG_SPECIAL = "special";  //特殊用药
    public static String DRUG_SHUZHONG = "shuzhong"; //其它术中用药
    public static String DRUG_FUSU = "fusu"; //其它术中用药
    public static String DRUG_FUSU_SHUYE = "fusu_shuye";   //输液
    public static String DRUG_SHUHOU = "shuhou"; //术后镇痛用药
    public static String DRUG_ZHENGTONG = "zhengtong"; //术后镇痛用药
    //ASA分级
    public static String ASA_1 = "Ⅰ";
    public static String ASA_2 = "Ⅱ";
    public static String ASA_3 = "Ⅲ";
    public static String ASA_4 = "Ⅳ";
    public static String ASA_5 = "Ⅴ";
    public static String ASA_6 = "Ⅵ";



    //账号角色
    public static String OR_SUPER_ACCOUNT = "admin";
    public static String MAZUI_DOCTOR = "麻醉医生";
    public static String SHOUSHU_DOCTOR = "手术医生";
    public static String HUSHI = "护士";
    public static String DOCTOR = "医生";
    public static String OTHER_STUFF = "其他";
    public static String ADMIN = "管理员";
    public static String MAZUI_ZHUREN = "麻醉主任";

    //药分组
    public static String MAZUIYAO = "麻醉药";
    public static String JISONGYAO = "肌松药";
    public static String ZHENJINGZHENTONGYAO = "镇痛镇静药";
    public static String SHUYE = "输液";
    public static String QITAYAO = "其他";
    public static String BUCHANGYONG = "不常用";

    //麻醉药处方类别
    public static String MAZUI_CHUFANGYAO_PUTONG = "普通";
    public static String MAZUI_CHUFANGYAO_JING1 = "精1";
    public static String MAZUI_CHUFANGYAO_JING2 = "精2";
    public static String MAZUI_CHUFANGYAO_KOUFU = "口服";
    public static String MAZUI_CHUFANGYAO_ERKE = "儿科";
    public static String MAZUI_CHUFANGYAO_CAILIAO = "材料";
    public static String MAZUI_CHUFANGYAO_WU = "无";

    //麻醉药容器单位
    public static String MAZUI_RQUNIT_ZHI = "支";
    public static String MAZUI_RQUNIT_PIAN = "片";
    public static String MAZUI_RQUNIT_PING = "瓶";
    public static String MAZUI_RQUNIT_HE = "盒";
    public static String MAZUI_RQUNIT_BAO = "包";
    public static String MAZUI_RQUNIT_DAI = "袋";

    //事件分组
    public static String EVENT_GROUP_CHANGYONG = "常用";
    public static String EVENT_GROUP_XINZANG = "心脏手术";
    public static String EVENT_GROUP_SHUYE = "出液";
    public static String EVENT_GROUP_JIANYAN = "检验";
    public static String EVENT_GROUP_OTHER = "其他";

    //单位分组
    public static String UNIT_GROUP_MAZUI = "0";
    public static String UNIT_GROUP_OTHER = "1";

    //药类型，垫江版麻醉单用
    public static String SHUXUESHUYE_TYPE = "晶体液";
    public static String CHIXUYONGYAO_TYPE = "药";

    //科室模板特殊ID
    public static String TEMPLATE_DEPARTMENT_ACCOUNTID = "department_accountID";

    //持续用药状态
    public static String ACTION_START = "start";
    public static String ACTION_PAUSE = "pause";
    public static String ACTION_STOP = "stop";
    public static String ACTION_WORK = "working";
    public static String ACTION_FINISH = "finished";

    //麻醉给药方式
    public static String DRUG_BENGZHU = "泵注";
    public static String DRUG__IVGTT = "ivgtt";
    public static String DRUG_XIRU = "吸入";
    public static String DRUG_TCIBENGZHU = "TCI泵";
    public static String DRUG_ZHENGTONGBENG = "镇痛泵";
    public static String DRUG_IV = "i.v.";

    //ICU药物当前状态
    public static String PatientDrugs_STATUS_READY = "ready";
    public static String PatientDrugs_STATUS_WORKING = "working";
    public static String PatientDrugs_STATUS_PAUSED = "paused";
    public static String PatientDrugs_STATUS_FINISHED = "finished"; //单次用药结束状态
    public static String PatientDrugs_STATUS_INVALID = "invalid";
    public static String PatientDrugs_STATUS_STOP = "stop";  //持续用药结束状态
    public static String PatientDrugs_STATUS_MANUALSTOP = "manualStop"; //手动停止用药状态

    public static String AGE_UNIT_YEAR = "岁";
    public static String AGE_UNIT_MONTH = "月";
    public static String AGE_UNIT_DAY = "天";


    public static int DATA_TYPE_NUM = 0;
    public static int DATA_TYPE_STR = 1;

    public static String SYSTEM_NAME = "手术麻醉系统";

    //状态
    public static String ANESTHETIC_START = "anes_start";
    public static String ANESTHETIC_END = "anes_end";
    public static String OPERATION_START = "operation_start";
    public static String OPERATION_END = "operation_end";
    public static String IN_ROOM = "inRoom";
    public static String OUT_ROOM = "outRoom";


    //事件
    public static String EVENT_IN_ROOM = "event_1"; //入手术室
    public static String EVENT_OPERATION = "event_2";//手术
    public static String EVENT_ANES = "event_3";//麻醉
    public static String EVENT_IN_HUIFUSHI = "event_5";//入复苏室
    public static String EVENT_OUT_HUIFUSHI = "event_9";//出复苏室
    public static String EVENT_CTRL_REST = "event_4";//控制呼吸
    public static String EVENT_SUB_REST = "event_6"; //辅助呼吸
    public static String EVENT_QIGUAN_CHAGUAN = "event_11"; //气管插管
    public static String EVENT_QIGUAN_BAGUAN = "event_13"; //气管拔管

    //体征参数
    public static String PARAM_CTRL_RESP = "控制呼吸";//控制呼吸参数name
    public static String PARAM_RESP = "呼吸";//呼吸参数name
    public static String PARAM_SUB_RESP = "param_sub_resp";//辅助呼吸参数code

    public static String PARAM_CTRL_RESP_CODE = "param_resp_ctrl"; //控制呼吸参数code
    public static String PARAM_RESP_CODE = "param_resp";//呼吸参数Code

    public static String RESP = "resp";//呼吸的group

    public static String PARAM_NIBP_S = "param_nibp_s";//无创收缩压
    public static String PARAM_NIBP_D = "param_nibp_d"; //无创舒张压
    public static String PARAM_NIBP_M = "param_nibp_m"; //无创平均压

    public static String PARAM_IBP_S = "param_ibp_s";//有创收缩压
    public static String PARAM_IBP_D = "param_ibp_d"; //有创舒张压
    public static String PARAM_IBP_M = "param_ibp_m"; //有创平均压

    public static String PARAM_S = "S"; //收缩压
    public static String PARAM_D = "D"; //舒张压
    public static String PARAM_M = "M"; //平均压


    public static String SHUYE_TYPE_JINGTIYE = "晶体液";
    public static String SHUYE_TYPE_JIAOTIYE = "胶体液";
    public static String SHUYE_TYPE_PINGHENGYE = "平衡液";
    public static String SHUYE_TYPE_HONGXIBAO = "红细胞悬液";
    public static String SHUYE_TYPE_XUEJIANG = "血浆";
    public static String SHUYE_TYPE_XUEXIAOBAN = "血小板";


    //区别麻醉单与复苏单

    public static String ISANES = "ANES";
    public static String ISPACU = "PACU";


    public static String DateY = "yyyy-MM-dd HH:mm:ss";
}
