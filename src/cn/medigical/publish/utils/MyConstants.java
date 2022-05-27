package cn.medigical.publish.utils;

/**
 * Created by on 2015/3/19, 15:13. Copy right by
 */
public class MyConstants {
	private MyConstants() {
	}

	public static final int ONE_SECOND_LONG = 1000;

	public static final long ONE_MINUTE_LONG = ONE_SECOND_LONG * 60;

	public static final long ONE_HOUR_LONG = ONE_MINUTE_LONG * 60;

	public static final long ONE_DAY_LONG = ONE_HOUR_LONG * 24;

	public static final int ANESRECORD_WIDTH = 968;
	// private static Rectangle2D screenSize = null;
	//
	// public static Rectangle2D getScreenSize() {
	//
	// if (null == screenSize) {
	// screenSize = Screen.getPrimary().getVisualBounds();
	// if( screenSize.getHeight() < 800){
	// isSmallScreen = true;
	// }
	// }
	// return screenSize;
	// }
	//
	// public static boolean isSmallScreen(){
	// getScreenSize();
	// return isSmallScreen;
	// }
	//
	// private static boolean isSmallScreen = false;

	public static final String EVENT_STATUS_FINISHED = "finished";
	public static final String EVENT_STATUS_WORKING = "working";
	public static final String ACTION_START = "start";
	public static final String ACTION_FINISH = "finish";

	public static final String FLAG_VALID = "valid";
	public static final String FLAG_IN_VALID = "invalid";

	public static final String AP_STATUS_MAZUIQIAN = "麻醉术前";
	public static final String AP_STATUS_MAZUIZHONG = "麻醉术中";
	public static final String AP_STATUS_MAZUIHOU = "麻醉术后";

	public static final String BEDSIDE_FLAG_CONFIRMED = "confirmed";
	public static final String BEDSIDE_FLAG_DELETED = "deleted";
	// 明细状态
	public static final String OR_STATUS_FLAG_UNKNOWN = "unknown"; // 未知
	public static final String OR_STATUS_FLAG_APPLIED = "未排班"; // 申请中，未排班
	public static final String OR_STATUS_FLAG_SCHEDULED = "已排班"; // 已经排班
	public static final String OR_STATUS_FLAG_CANCEL = "取消已排班"; // 取消已经排班
	public static final String OR_STATUS_FLAG_CHECKED = "术前准备"; // 做完术前访视
	public static final String OR_STATUS_FLAG_IN_ROOM = "进手术间"; // 术中，正在进行
	public static final String OR_STATUS_FLAG_OUT_ROOM = "出手术间";// 术后
	public static final String OR_STATUS_FLAG_MAZUIDAN = "麻醉中";
	public static final String OR_STATUS_FLAG_SHOUSHUZHONG = "手术中";
	public static final String OR_STATUS_FLAG_HUIFUZHONG = "恢复中";
	// 术后病人去往
	public final static String ICU = "ICU";
	public final static String PACU = "恢复室";
	public final static String BINGFANG = "病房";

	public static final String OR_STATUS_FLAG_AN = "an";
	public static final String OR_STATUS_FLAG_OPERATE = "operate";
	public static final String OR_STATUS_FLAG_AN_END = "anEnd";
	public static final String OR_STATUS_FLAG_OPERATE_END = "operateEnd";
	public static final String OR_STATUS_FLAG_IN_PCU = "inPCU";
	public static final String OR_STATUS_FLAG_OUT_PCU = "outPCU";
	public static final String OR_STATUS_FLAG_DISCHARGED = "discharged";

	public static final String OR_TYPE_SCHEDULE = "schedule";
	public static final String OR_TYPE_URGENT = "urgent";

	public final static String FILE_NURSING = "D:\\recordPic\\";

	public final static String VIDEO_PATH = "D:\\phoneVideo\\";
	public final static String VOICE_PATH = "D:\\phoneVoice\\";
	public final static String PIC_PATH = "D:\\phonePic\\";
	public final static String ATTACHMENT_PATH = "D:\\attachment\\";

	public final static String FEMALE = "女";
	public final static String MALE = "男";

	public final static String SPLIT_NAME = "麻醉单";

	public final static String BEDSIDE_SHOW_METHOD_TREND = "line";
	public final static String BEDSIDE_SHOW_METHOD_TABLE = "table";

	// 用药分类
	public final static String DRUG_SHUXUE = "shuxue"; // 输血
	public final static String DRUG_SHUYE = "shuye"; // 输液
	public final static String DRUG_SPECIAL = "special"; // 特殊用药
	public final static String DRUG_SHUZHONG = "shuzhong"; // 其它术中用药
	public final static String DRUG_SHUHOU = "shuhou"; // 术后镇痛用药

	// ASA分级
	public final static String ASA_1 = "Ⅰ";
	public final static String ASA_2 = "Ⅱ";
	public final static String ASA_3 = "Ⅲ";
	public final static String ASA_4 = "Ⅳ";
	public final static String ASA_5 = "Ⅴ";
	public final static String ASA_6 = "Ⅵ";

	// 账号角色
	public final static String OR_SUPER_ACCOUNT = "admin";
	public final static String MAZUI_DOCTOR = "麻醉医生";
	public final static String SHOUSHU_DOCTOR = "手术医生";
	public final static String HUSHI = "护士";
	public final static String DOCTOR = "医生";
	public final static String OTHER_STUFF = "其他";
	public final static String ADMIN = "管理员";
	public final static String MAZUI_ZHUREN = "麻醉主任";

	// 药分组
	public final static String MAZUIYAO = "麻醉药";
	public final static String JISONGYAO = "肌松药";
	public final static String ZHENJINGZHENTONGYAO = "镇痛镇静药";
	public final static String SHUYE = "输液";
	public final static String QITAYAO = "其他";
	public final static String BUCHANGYONG = "不常用";

	// 麻醉药处方类别
	public final static String MAZUI_CHUFANGYAO_PUTONG = "普通";
	public final static String MAZUI_CHUFANGYAO_JING1 = "精1";
	public final static String MAZUI_CHUFANGYAO_JING2 = "精2";
	public final static String MAZUI_CHUFANGYAO_KOUFU = "口服";
	public final static String MAZUI_CHUFANGYAO_ERKE = "儿科";
	public final static String MAZUI_CHUFANGYAO_WU = "无";

	// 麻醉药容器单位
	public final static String MAZUI_RQUNIT_ZHI = "支";
	public final static String MAZUI_RQUNIT_PIAN = "片";
	public final static String MAZUI_RQUNIT_PING = "瓶";
	public final static String MAZUI_RQUNIT_HE = "盒";
	public final static String MAZUI_RQUNIT_BAO = "包";
	public final static String MAZUI_RQUNIT_DAI = "袋";

	// 事件分组
	public final static String EVENT_GROUP_CHANGYONG = "常用";
	public final static String EVENT_GROUP_XINZANG = "心脏手术";
	public final static String EVENT_GROUP_SHUYE = "出液";
	public final static String EVENT_GROUP_JIANYAN = "检验";
	public final static String EVENT_GROUP_OTHER = "其他";

	// 单位分组
	public final static String UNIT_GROUP_MAZUI = "麻醉";
	public final static String UNIT_GROUP_OTHER = "其他";

	// 药类型，垫江版麻醉单用
	public final static String SHUXUESHUYE_TYPE = "晶体液";
	public final static String CHIXUYONGYAO_TYPE = "药";

	// 科室模板特殊ID
	public final static String TEMPLATE_DEPARTMENT_ACCOUNTID = "department_accountID";

	// 入手术室事件Code
	public final static String EVENT_CODE_RUSHOUSHUSHI = "event_ru_shoushushi";
	public final static String EVENT_CODE_SHOUSHU = "event_shoushu";

	// ICU账号角色
	public final static String ICU_DOCTOR = "医生";
	public final static String ICU_HUSHI = "护士";
	public final static String ICU_HUSHIZHANG = "护士长";
	public final static String ICU_ZHUREN = "主任";
	public final static String ICU_FUZHUREN = "副主任";
	public final static String ICU_HUZIDOC = "呼吸治疗师";

	// 麻醉给药方式
	public final static String DRUG_BENGZHU = "泵注";
	public final static String DRUG__IVGTT = "ivgtt";
	public final static String DRUG_XIRU = "吸入";
	public final static String DRUG_TCIBENGZHU = "TCI泵";

	// ICU药物执行状态
	public final static String YAOEXE_START = "working"; // 开始
	public final static String YAOEXE_PAUSE = "pause"; // 暂停
	public final static String YAOEXE_STOP = "stop"; // 停止
	public final static String YAOEXE_FINISHED = "finished"; // 结束

	// ICU药物当前状态
	public final static String YAOEXE_STATUS_READY = "ready";
	public final static String YAOEXE_STATUS_WORKING = "working";
	public final static String YAOEXE_STATUS_PAUSED = "paused";
	public final static String YAOEXE_STATUS_FINISHED = "finished"; // 单次用药结束状态
	public final static String YAOEXE_STATUS_INVALID = "invalid";
	public final static String YAOEXE_STATUS_STOP = "stop"; // 持续用药结束状态
	public final static String YAOEXE_STATUS_MANUALSTOP = "manualStop"; // 手动停止用药状态

	// ICU药物Action 的 action 属性
	public final static String YAOEXE_ACTION_START = "start";
	public final static String YAOEXE_ACTION_PAUSE = "pause";
	public final static String YAOEXE_ACTION_RECOVERY = "recovery";
	public final static String YAOEXE_ACTION_STOP = "stop";
	public final static String YAOEXE_ACTION_ADD = "add";
	public final static String YAOEXE_ACTION_MINUS = "minus";
	public final static String YAOEXE_ACTION_QUICK_ADD = "quickAdd"; // 快速推注

	public final static String YAOEXE_ACTION_FINISH = "finish"; // 单次

	public final static String ORDER_ADD_TYPE_SYSTEM = "system"; // 软件自动加入
	public final static String ORDER_ADD_TYPE_MANUAL_ADD = "manualAdd"; // 手工添加
	public final static String ORDER_ADD_TYPE_MANUAL_IMPORT = "manualImport"; // 手工导入
	public final static String ORDER_ADD_TYPE_MANUAL_COPY = "manualCopy"; // 手工复制

	public final static String UNIT_GROUP_YAO = "yao";
	public final static String UNIT_GROUP_LIS = "lis";
	public final static String UNIT_GROUP_ALL = "all";

	public final static String UNIT_GROUP2_GUTI = "guti";
	public final static String UNIT_GROUP2_YETI = "yeti";

	public final static String TUBE_TYPE_XGTL = "血管通道";
	public final static String TUBE_TYPE_HXGL = "呼吸管路";
	public final static String TUBE_TYPE_WCG = "胃肠管";
	public final static String TUBE_TYPE_NG = "尿管";
	public final static String TUBE_TYPE_YLG = "引流管";
	public final static String TUBE_TYPE_CGQ = "传感器";
	public final static String TUBE_TYPE_ZLS = "造瘘术";
	public final static String TUBE_TYPE_LNYMW = "颅内/硬膜外";
	public final static String TUBE_TYPE_OTHER = "其它";

	public final static String ICU_DRUG_TYPE_KANGSHENGSU = "抗生素";
	public final static String ICU_DRUG_TYPE_ZHENJING = "镇静镇痛";
	public final static String ICU_DRUG_TYPE_YINGYANG = "营养";
	public final static String ICU_DRUG_TYPE_HUOXING = "活性";
	public final static String ICU_DRUG_TYPE_OTHER = "其他";

	public final static String ICU_SCORE_TYPE_NONE = "none";
	public final static String ICU_SCORE_TYPE_GCS = "gcs";
	public final static String ICU_SCORE_TYPE_BRADEN = "braden";
	public final static String ICU_SCORE_TYPE_TENGTONG = "tengTong";
	public final static String ICU_SCORE_TYPE_TENGTONG_CPOT = "tengTongCPOT";
	public final static String ICU_SCORE_TYPE_ZHENJING = "zhenJing";
	public final static String ICU_SCORE_TYPE_ZHENTONG = "zhenTong";
	public final static String ICU_SCORE_TYPE_ZHANWANG = "zhanWang";
	public final static String ICU_SCORE_TYPE_FANGDIEDAO = "fangDieDao";
	public final static String ICU_SCORE_TYPE_UNPLANBAGUAN = "unPlanBaGuan";
	public final static String ICU_SCORE_TYPE_BINGQINGFENJI = "bingQingFenJi";
	public final static String ICU_SCORE_TYPE_ZHANWANG4ZS1 = "zhanWangZS1";
	public final static String ICU_SCORE_TYPE_APACHEII = "apacheII";

	public final static String EVENT_VENT = "event_vent";

	public static String EQUIPMENT_TYPE_JHY = "监护仪";
	public static String EQUIPMENT_TYPE_HXJ = "呼吸机";
	public static String EQUIPMENT_TYPE_ZYSB = "转运设备";
	public static String EQUIPMENT_TYPE_ZDZK = "重点专科";
	public static String EQUIPMENT_TYPE_PTSB = "普通设备";

	public static String AGE_UNIT_YEAR = "岁";
	public static String AGE_UNIT_MONTH = "月";
	public static String AGE_UNIT_DAY = "天";

	public static final String DATA_TYPE_NUM = "num";
	public static final String DATA_TYPE_STR = "str";

	public static final String SYSTEM_NAME = "手术麻醉系统";

	public static final String ANESTHETIC_START = "anes_start";
	public static final String ANESTHETIC_END = "anes_end";
	public static final String OPERATION_START = "operation_start";
	public static final String OPERATION_END = "operation_end";

	public static final String EVENT_IN_ROOM = "event_ru_shoushushi"; // 入手术室
	public static final String EVENT_OPERATION = "event_shoushu";// 手术
	public static final String EVENT_ANES = "event_mazui";// 麻醉
	public static final String EVENT_IN_HUIFUSHI = "event_ruhuifushi";// 入恢复室
	public static final String EVENT_CTRL_REST = "event_kongzhi_huxi";// 控制呼吸

	public static final String PARAM_CTRL_RESP = "控制呼吸";// 控制呼吸参数name
	public static final String PARAM_RESP = "呼吸";// 呼吸参数name

	public static final String SHUYE_TYPE_JINGTIYE = "晶体液";
	public static final String SHUYE_TYPE_JIAOTIYE = "胶体液";
}
