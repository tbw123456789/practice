package cn.medigical.publish.xmlUtil;

public class ServicesSign {
	//手术申请新增POOR_IN200901UV POOR_IN200901UV
	public static String OPERATION_ADD = "POOR_IN200901UV";
	//手术申请更新
	public static String OPERATION_UPDATE = "POOR_IN200902UV";
	//手术排班新增
	public static String SCHEDULED_ADD = "PRSC_IN010101UV01";
	//手术排班更新
	public static String SCHEDULED_UPDATE = "PRSC_IN010201UV01";
	//手术状态更新
	public static String OPERATION_STATUS_UPDATE = "POOR_IN200902UV";
	//注册科室信息
	public static String DEPART_ADD = "PRPM_IN401030UV01";
	//更新科室信息 
	public static String DEPART_UPDATE = "PRPM_IN403010UV01";
	//查询科室信息
	public static String DEPART_QUERY = "PRPM_IN406010UV01";
	//注册医护人员信息
	public static String ACCCOUNT_ADD = "PRPM_IN301010UV01";
	//患者信息新增
	public static String PATIENT_ADD = "PRPA_IN201311UV02";
	//更新医护人员信息
	public static String ACCOUNT_UPDATE = "PRPM_IN303010UV0";
	//查询医护人员的信息
	public static String ACCOUNT_QUERY = "PRPM_IN306010UV01";
	//术语字典新增

	//药物信息更新
	public static String YAO_UPDATE = "PRVS_IN000001UV01";
	//药物信息回传
	public static String OPERATION_YAO_UPDATE = "PRPM_IN20180525";
	//患者更新
	public static String PATIENT_UPDATE = "PRPA_IN201314UV02";
	//患者查询
	public static String PATIENT_QUERY = "PRPA_IN201305UV02";
	//医嘱新增
	public static String DACTORADVICE_ADD = "POOR_IN200901UV";
	//医嘱更新
	public static String DACTORADVICE_UPDATE = "POOR_IN200902UV";
	//医嘱查询
	public static String DACTORADVICE_QUERY = "QUMT_IN020030UV01";
	//获取物料编号
	public static String GET_WULIAO_ID = "HRP005";
	//住院转科新增
	public static String ZHUYUANZHUABKE_ADD = "PRPA_IN302011UV";
	//住院转科就诊
	public static String ZHUYUANZHUANKE_JIUZHEN = "PRPA_IN400001UV";

	public static String V_NIS_OPERATION_B = "V_NIS_OPERATION_B";

	public static String V_NIS_OPERATION_EVENT = "V_NIS_OPERATION_EVENT";

	public static String GETNIS_OPERATIONBBYPATIENTID = "GETNIS_OPERATIONBBYPATIENTID";

	public static String GETNIS_OPERATIONEVENTBYPATIENTID = "GETNIS_OPERATIONEVENTBYPATIENTID";
	
	public static String GETLISDATA = "PRPM20180722";
	//排班回传
    public static String PAIBANHUICHUAN = "PAIBANHUICHUAN";
}
