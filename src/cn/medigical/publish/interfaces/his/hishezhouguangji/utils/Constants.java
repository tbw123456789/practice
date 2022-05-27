package cn.medigical.publish.interfaces.his.hishezhouguangji.utils;

public class Constants {

    // 四川省现代医院 武侯
    public static final String TableForXianDaiEY_HOSPITAL = "TableForXianDaiEY";

    // 四川省现代医院 高兴
    public static final String TableForXianDaiGaoXinEY_HOSPITAL = "TableForXianDaiGaoXinEY";

    public static final String HOSPITALNAME = "tableForHeZhouGuangJiEY";

    //广西贺州广济本地服务地址
    //http://132.147.165.95:9000
    public static final String HOST_HEZHOUGUANGJISERVER = "http://192.168.43.131:9000";

    //重庆荣昌本地服务地址
    public static final String HOST_RONGCHANGSERVER = "http://127.0.0.1:9000";
    //广西贺州广济His服务地址  测试地址http://132.147.166.192:8035/zlhis_OAAS  真实地址 http://132.147.166.68:8035/zlhis_OAAS
    public static final String HOST_REMOTE_HEZHOUGUANGJISERVER = "http://132.147.166.68:8035/zlhis_OAAS";

    public static final String SPLIT_ITEM_STRING = "_";

    public static final String FILL_ITEM_STRING = "null";

    public static final String MAZUIDOCDEPTCODE = "41201";

    //返回的消息状态
    public static final String KEY_SUCCESS_MSG = "AA";
    public static final String KEY_ERROR_MSG = "AE";
    //发送排班信息失败
    public static final String KEY_INSERT_ERROR_MSG = "IAE";
    //更新排班信息失败
    public static final String KEY_UPDATE_ERROR_MSG = "UAE";
    //更新排班信息执行完成
    public static final String KEY_UPDATE_OVER_MSG = "true";

    //本服务唯一标识
    public static final String TAG_SYSTEM_LOCAL = "OAAS";

    //His唯一标识
    public static final String TAG_SYSTEM_REMOTE = "ZLHIS";

    //获取病人基本信息
    public static final String KEY_PATIENTINFO_CMD = "2001";

    //2.1	获取指定时间范围手术申请单
    public static final String KEY_ASPANOPERATION_CMD = "7001";
    //2.2	OAAS发送手术安排信息
    public static final String KEY_OPERATIONSCHEDULED_CMD = "7002";
    //2.3	OAAS发送手术状态变更信息
    public static final String KEY_OPERATIONSCHEDULESTATUS_CMD = "7003";
    //2.4	HIS发送手术申请信息
    public static final String KEY_OPERATION_CMD = "7006";
    //2.5	HIS发送取消手术申请信息
    public static final String KEY_CANCELOPERATION_CMD = "7007";
    //2.6   OAAS发送手术麻醉相关信息
    public static final String KEY_OPERATIONINFO_CMD = "7008";
    //2.7   OAAS发送手术间基础信息
    public static final String KEY_OPERATIONROOMINFO_CMD = "7009";
    //2.8   OAAS发送麻醉方式基础信息
    public static final String KEY_ANESTHESIAMETHODINFO_CMD = "7010";
    //获取人员信息
    public static final String KEY_ACOUNT_CMD = "1001";
    //获取部门信息
    public static final String KEY_DEPARTMENT_CMD = "1002";
    //获取诊疗项目字典
    public static final String KEY_DIAGNOSIS_CMD = "1003";
    //获取标本采集项目
    public static final String KEY_SPECIMEN_CMD = "1004";
    //获取检验指标项目
    public static final String KEY_INSPECTION_CMD = "1005";
    //获取疾病编码字典
    public static final String KEY_DISEASECODE_CMD = "1006";
    //获取收费项目字典
    public static final String KEY_CHARGEPROJECT_CMD = "1007";
    //人员新增同步
    public static final String KEY_ACOUNTSYNC_CMD = "1011";
    //部门新增同步
    public static final String KEY_DEPARTMENTSYNC_CMD = "1012";
    //诊疗项目新增同步
    public static final String KEY_DIAGNOSISSYNC_CMD = "1013";
    //标本采集项目新增同步
    public static final String KEY_SPECIMENSYNC_CMD = "1014";
    //检验指标项目新增同步
    public static final String KEY_INSPECTIONSYNC_CMD = "1015";
    //疾病编码新增同步
    public static final String KEY_DISEASECODESYNC_CMD = "1016";
    //收费项目新增同步
    public static final String KEY_CHARGEPROJECTSYNC_CMD = "1017";
    //人员修改同步
    public static final String KEY_ACOUNTEDITSYNC_CMD = "1021";
    //部门修改同步
    public static final String KEY_DEPARRTMENTEDITSYNC_CMD = "1022";
    //诊疗项目修改同步
    public static final String KEY_DIAGNOSISEDITSYNC_CMD = "1023";
    //标本采集项目修改同步
    public static final String KEY_SPECIMENEDITSYNC_CMD = "1024";
    //检验指标项目修改同步
    public static final String KEY_INSPECTIONEDITSYNC_CMD = "1025";
    //疾病编码修改同步
    public static final String KEY_DISEASECODEEDITSYNC_CMD = "1026";
    //收费项目修改同步
    public static final String KEY_CHARGEPROJECTEDITSYNC_CMD = "1027";
    //人员停用同步
    public static final String KEY_ACOUNTINVALIDSYNC_CMD = "1031";
    //部门停用同步
    public static final String KEY_DEPARTMENTINVALIDSYNC_CMD = "1032";
    //人员启用同步
    public static final String KEY_ACOUNTVALIDSYNC_CMD = "1041";
    //部门启用同步
    public static final String KEY_DEPARTMENTVALIDSYNC_CMD = "1042";
    //诊疗项目停用同步
    public static final String KEY_DIAGNOSISINVALIDSYNC_CMD = "1033";
    //标本采集项目停用同步
    public static final String KEY_SPECIMENINVALIDSYNC_CMD = "1034";
    //检验指标项目停用同步
    public static final String KEY_INSPECTIONINVALIDSYNC_CMD = "1035";
    //根据病人ID获取最新一条Lis信息
    public static final String KEY_GETLISINFOBYPID_CMD = "4031";
    //根据病人ID获取最新一条Lis详细信息
    public static final String KEY_GETDETAILLISINFOBYPID_CMD = "4032";
    //根据病人ID获取最新一条PACS信息
    public static final String KEY_GETPACSINFOBYPID_CMD = "5012";
    //根据病人ID获取最新一条PACS详细信息
    public static final String KEY_GETDETAILPACSINFOBYPID_CMD = "5013";
}