package cn.medigical.publish.interfaces.his.hisRongchang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigDepartmentsDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigDrugsDao;
import cn.medigical.publish.interfaces.his.hisLink.HisLink;
import cn.medigical.publish.interfaces.his.hisLink.PojoBGA;
import cn.medigical.publish.interfaces.lis.LisData;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.dictionary.ConfigDepartments;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.utils.Constants;
import cn.medigical.publish.utils.MyUtility;
import cn.medigical.publish.utils.SpringUtils;

public class HisLinkRongChang extends HisLink  {
	PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);
    AccountDao accountDao = (AccountDao) SpringUtils.getBean(AccountDao.class);
    ConfigDepartmentsDao configDepartmentsDao =  SpringUtils.getBean(ConfigDepartmentsDao.class);
    ConfigDrugsDao configDrugsDao = SpringUtils.getBean(ConfigDrugsDao.class);
    private static HisLinkRongChang instance;
    private Logger logger=Logger.getLogger(HisLinkRongChang.class);

    String dbIP = "192.168.169.247";
    String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String url = "jdbc:sqlserver://192.168.169.247:1433;databaseName=healthone";
    String username = "sa";
    String password = "xxk_123";
    String opersViewSQLStr = "select\n       A.patient_id,                                       --病人ID (住院号)\n       A.visit_id,                                         --本次住院标示\n       A.schedule_id,                                      --手术申请ID\n       C.NAME,                                             --名称\n       c.sex,                                              --性别\n       C.INP_NO,                                           --住院号\n       C.DATE_OF_BIRTH,                                    --出生日期\n       C.NATION,                                           --民族\n       C.CHARGE_TYPE,                                      --医保\n       C.PHONE_NUMBER_HOME,\n\t\t\t --病人所在科室编码\n       A.dept_stayed AS dept_stayed_code,\n       --病人所在科室\n       (select V_DEPT_DICT.DEPT_NAME   from V_DEPT_DICT where V_DEPT_DICT.dept_code = a.dept_stayed ) as dept_stayed,\n       A.bed_no,                                           --床号\n       A.scheduled_date_time,                              --手术日期及时间\n       --手术室\n       a.operating_room,\n       (select V_DEPT_DICT.DEPT_NAME   from V_DEPT_DICT where V_DEPT_DICT.dept_code = a.operating_room ) as operating_room_name,\n        A.operating_room_no,                                --手术间\n       A.sequence,                                         --台次\n       A.diag_before_operation,                            --术前诊断\n       A.patient_condition,                                --特殊情况\n       b.operation ,                                       --手术名称\n       A.operation_scale,                                  --手术等级\n        --手术科室\n       (select V_DEPT_DICT.DEPT_NAME   from V_DEPT_DICT where V_DEPT_DICT.dept_code = a.operating_dept ) as operating_dept,\n       --手术者ID\n       (select 工号 from 员工信息 where 员工信息.ID = a.surgeon_id) as surgeon_id,\n       --手术者\n       --( select  v_his_users.USER_NAME from v_his_users where v_his_users.USER_ID = a.surgeon ) as surgeon,\n\t\t\t --一助ID\n\t\t   (select 工号 from 员工信息 where 员工信息.ID = a.first_assistant) as first_assistant_id,\n       --第一手术助手\n       --( select  v_his_users.USER_NAME from v_his_users where v_his_users.USER_ID = a.first_assistant ) as first_assistant,\n       --二助ID\n\t\t   (select 工号 from 员工信息 where 员工信息.ID = a.second_assistant) as second_assistant_id,\n\t\t\t --第二手术助手\n       --( select  v_his_users.USER_NAME from v_his_users where v_his_users.USER_ID = a.second_assistant ) as second_assistant,\n       --三助ID\n\t\t   A.third_assistant AS third_assistant_id,\n\t\t\t --第三手术助手\n       --( select  v_his_users.USER_NAME from v_his_users where v_his_users.USER_ID = a.third_assistant ) as third_assistant,\n       --第四手术助手\n       --( select  v_his_users.USER_NAME from v_his_users where v_his_users.USER_ID = a.fourth_assistant ) as fourth_assistant,\n       A.anesthesia_method,                                --麻醉方法\n       --麻醉医生\n       --( select  v_his_users.USER_NAME from v_his_users where v_his_users.USER_ID = a.anesthesia_doctor ) as anesthesia_doctor,\n       --第一麻醉助手\n       --( select  v_his_users.USER_NAME from v_his_users where v_his_users.USER_ID = a.anesthesia_assistant ) as anesthesia_assistant,\n       --第二麻醉助手\n       --( select  v_his_users.USER_NAME from v_his_users where v_his_users.USER_ID = a.second_anesthesia_doctor ) as second_anesthesia_doctor,\n       --第三麻醉助手\n       --( select  v_his_users.USER_NAME from v_his_users where v_his_users.USER_ID = a.third_anesthesia_doctor ) as third_anesthesia_doctor,\n       --第四麻醉助手\n       --( select  v_his_users.USER_NAME from v_his_users where v_his_users.USER_ID = a.fourth_anesthesia_assistant ) as fourth_anesthesia_assistant,\n       --第一洗手护士\n       --( select  v_his_users.USER_NAME from v_his_users where v_his_users.USER_ID = a.first_operation_nurse ) as first_operation_nurse,\n       --第二洗手护士\n       --( select  v_his_users.USER_NAME from v_his_users where v_his_users.USER_ID = a.second_operation_nurse ) as second_operation_nurse,\n       --第一巡回护士\n       --( select  v_his_users.USER_NAME from v_his_users where v_his_users.USER_ID = a.first_supply_nurse ) as first_supply_nurse,\n       --第二巡回护士\n       --( select  v_his_users.USER_NAME from v_his_users where v_his_users.USER_ID = a.second_supply_nurse ) as second_supply_nurse,\n       --第三巡回护士\n       --( select  v_his_users.USER_NAME from v_his_users where v_his_users.USER_ID = a.third_supply_nurse ) as third_supply_nurse,\n       A.notes_on_operation,                               --备注\n       A.entered_by,                                       --录入者\n       A.req_date_time,                                    --申请日期时间\n       A.emergency_indicator                              --急诊标志\n       --A.operation_position                               --体位\n       --A.reserved4,                                        --备血\n       --A.reserved5                                         --感染情况\n       --TO_CHAR(SYSDATE,'YYYY') - TO_CHAR(c.DATE_OF_BIRTH,'YYYY') AS PAT_AGE\n from V_OPERATION_SCHEDULE A , V_SCHEDULED_OPERATION_NAME B , V_PAT_MASTER_INDEX C\n where a.patient_id = b.patient_id                            and\n       a.visit_id   = b.visit_id                              and\n       a.schedule_id= b.schedule_id                           and\n       a.patient_id = c.patient_id";
    String patBasicInfoSQLStr = "SELECT a.VAA04 as visit_id, a.VAA05 as NAME, a.ABW01 as SEX, a.VAA12 as DATE_OF_BIRTH, \na.VAA10 as AGE, a.AAU01 as AGE_UNIT, b.BCK01B as DEPT_CODE,\n--科室名称\n(SELECT DEPT_NAME from V_DEPT_DICT where b.BCK01B = DEPT_CODE) as DEPT_NAME, b.BCQ04A as BED\nFROM VAA1 a, VAE1 b WHERE a.VAA01 = b.VAA01";

    public static String[] niaoChangGui = {"PRO", "GLU", "KET", "BLD"};
    public static String[] ganGongNeng = {"TP", "ALB", "GLB", "ALT", "AST"};
    public static String[] shenGongNeng = {"UREA", "CREA", "UA"};
    public static String[] dianJieZhi = {"K", "NA", "CA", "MG", "P"};
    public static String[] ningXueGongNeng = {"PT", "PT-INR", "APTT", "FIB", "TT", "D-Dimer"};
    public static String[] xueTang = {"GLU"};
    public static String[] cFanYingDanBai = {"HbA1C"};
    public static String[] rbc = {"RBC"};
    public static String[] hb = {"HGB"};
    public static String[] hct = {"HCT"};
    public static String[] plt = {"PLT"};
    public static String[] wbc = {"WBC"};
    public static String[] bloodType = {"ABO", "RH"};

    public static String[] bigName1 = {"血常规"};
    public static String[] bigName2 = {"尿分析"};
    public static String[] bigName3 = {"急诊生化", "生化"};
    public static String[] bigName4 = {"血凝"};
    public static String[] bigName5 = {"生化"};

    public static Map<String, String[]> ItemCodeMap = new HashMap();
    public static Map<String, String[]> ItemCodeMap4BigName = new HashMap();
    public static Map<String, String[]> XueChangGuiItemCodeMap = new HashMap();

    List<String> existItemList = new ArrayList();
    
    public static HisLinkRongChang getInstance() {
    	if (instance==null) {
			instance=new HisLinkRongChang();
		}
		return instance;
	}

    private Connection getConnection() {

        Connection connection = null;
        try {
            Class.forName(this.driverName);
            connection = DriverManager.getConnection(this.url, this.username, this.password);
        } catch (Exception ex) {
            this.logger.fatal(ex.getMessage(), ex);
        }
        logger.info("connect His ok!");
        return connection;
    }

    private void closeConnection(Connection connection) {
        if (null != connection)
            try {
                connection.close();
            } catch (SQLException e) {
                this.logger.error(e.getMessage(), e);
            }
    }

    private String trimStr(String str) {
        if (null == str) return "";
        return str.trim();
    }

    public List<PatientLink> getOprationFromHis() {
        Connection conn = getConnection();
        if (null == conn) {
            return null;
        }

        List operationList = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateNow = new Date();
        Date dateFrom = new Date(dateNow.getTime() - 259200000L);
        String threeDaysAgo = sdf.format(dateFrom);
        String strSQL = this.opersViewSQLStr + " and req_date_time > '" + threeDaysAgo + "'";

        Map hisOperIdMapBoolean = new HashMap();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(strSQL);
            ResultSet rs = preparedStatement.executeQuery();
            this.logger.info(strSQL);
            int count = 1;

            List accountList = accountDao.getAllAccount();
            while (rs.next()) {
                PatientLink patientLink = getPatientLink(rs, conn, accountList);
                if ((null != patientLink) &&
                        (!hisOperIdMapBoolean.containsKey(patientLink.getHisID()))) {
                    operationList.add(patientLink);
                    hisOperIdMapBoolean.put(patientLink.getHisID(), Boolean.valueOf(true));
                    count++;
//                    this.logger.info("operation applyid = " + patientLink.getHisID());
                }
            }
        } catch (SQLException e) {
            this.logger.error(e.getMessage(), e);
        }

        closeConnection(conn);
        return operationList;
    }

    private PatientLink getPatientLink(ResultSet rs, Connection conn, List<Account> accountList) throws SQLException {
        if (rs == null) {
            return null;
        }
        String patient_id = trimStr(rs.getString("PATIENT_ID"));
        String schedule_id = trimStr(rs.getString("SCHEDULE_ID"));
        if ((patient_id.length() == 0) || (schedule_id.length() == 0)) return null;
        String id = patient_id + "_" + schedule_id;

        PatientLink patientLink = new PatientLink();
        patientLink.setCreateDate(new Date());
        //patientLink.setBedsideShow(((DefaultBedsideShow) SpringCache.getInstance().getBean("DefaultBedsideShow")).getDefault());

        patientLink.setHisID(schedule_id);
        if (schedule_id!=null && schedule_id.equals("100023925522")) {
			return null;
		}
        patientLink.getApplication().setSssqdh(schedule_id);
        patientLink.getPatient().setBrxm(trimStr(rs.getString("NAME")));
        patientLink.getPatient().setZyh(patient_id);
        //patientLink.getPatient().setZyh(patientLink.getHisVisitID());

        String srcSex = trimStr(rs.getString("SEX"));
        String sex = srcSex;
       /* if (null != srcSex) {
            if (srcSex.equalsIgnoreCase("男"))
                sex = "male";
            else if (srcSex.equalsIgnoreCase("女")) {
                sex = "female ";
            }
        }*/
        patientLink.getApplication().setDetailstatus(Constants.OR_STATUS_FLAG_APPLIED);
        //手术状态
        patientLink.getApplication().setStatus(Constants.AP_STATUS_MAZUIQIAN);
        //明细状态
        patientLink.getApplication().setDetailstatus(Constants.OR_STATUS_FLAG_APPLIED);
        //患者状态
        patientLink.getPatient().setStatus(Constants.FLAG_VALID);
        patientLink.getPatient().setXb(sex);
        try {
            Date date = rs.getTimestamp("DATE_OF_BIRTH");
            patientLink.getPatient().setDob(date);
        } catch (Exception ex) {
        }
        try {
            Date applyOperTime = patientLink.getCreateDate();
            Date dob = patientLink.getPatient().getDob();
            int ageInt = MyUtility.getIntAge(dob, applyOperTime);
            patientLink.getPatient().setNumAge(Integer.valueOf(ageInt));
            patientLink.getPatient().setNl(ageInt + "岁");
            patientLink.getPatient().setNldw(Constants.AGE_UNIT_YEAR);
        } catch (Exception ex) {
        }
        String b = trimStr(rs.getString("BED_NO"));
        patientLink.getPatient().setZych(b);
        //patientLink.getOperInfo().setSrcBed(b);

        patientLink.getApplication().setNsssmc(trimStr(rs.getString("OPERATION")));
        //patientLink.getOperInfo().setNishiOper(patientLink.getAppliedInfo().getNishiOper());
        try {
            Date planOperTime = new Date(Timestamp.valueOf(rs.getString("scheduled_date_time")).getTime());
            patientLink.getApplication().setYysssj(planOperTime);
            //patientLink.getSchedule().setPlanTime(planOperTime);
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
        }
        try {
            Date applyOperTime = new Date(Timestamp.valueOf(rs.getString("req_date_time")).getTime());
            patientLink.getApplication().setSssqsj(applyOperTime);
        } catch (Exception e) {
            this.logger.error(e.getMessage(), e);
        }

        patientLink.getPatient().setYblx(trimStr(rs.getString("CHARGE_TYPE")));
        
        patientLink.getApplication().setSqzd1(trimStr(rs.getString("diag_before_operation")));
        //patientLink.getOperInfo().setShuQianZhenDuan(patientLink.getAppliedInfo().getShuQianZhenDuan());

        patientLink.getApplication().setMzfs(trimStr(rs.getString("anesthesia_method")));
        try {
            String applyDoctorID = trimStr(rs.getString("surgeon_id"));
            patientLink.getApplication().setSqysbh(convertCodeToId(applyDoctorID, accountList, conn));
        } catch (Exception e) {
        }
        try {
            String Doctor1ID = trimStr(rs.getString("first_assistant_id"));
            patientLink.getApplication().setSsysxm(convertCodeToId(Doctor1ID, accountList, conn));
        } catch (Exception e) {
        }
        try {
            String Doctor2ID = trimStr(rs.getString("second_assistant_id"));
            patientLink.getApplication().setZlysbh1(convertCodeToId(Doctor2ID, accountList, conn));
        } catch (Exception e) {
        }
        patientLink.getApplication().setSqksmc(trimStr(rs.getString("DEPT_STAYED")));
        patientLink.getPatient().setKsmc(trimStr(rs.getString("DEPT_STAYED")));
        patientLink.getApplication().setSqksbh(trimStr(rs.getString("DEPT_STAYED_CODE")));

//        patientLink.getOperInfo().setSrcDeptName(operation.getAppliedInfo().getSrcDeptName());
//        patientLink.getOperInfo().setSrcDeptCode(operation.getAppliedInfo().getSrcDeptCode());

        String srcSslx = trimStr(rs.getString("emergency_indicator"));
        String sslx = "schedule";
        if ("1".equals(srcSslx)) {
            sslx = "urgent";
        }
        patientLink.getApplication().setType(sslx);
        patientLink.getStatus().setFlag("applied");
        //patientLink.getPatient().setPhone(trimStr(rs.getString("PHONE_NUMBER_HOME")));
        return patientLink;
    }

    public PatientLink getBasicPatInfoOperation(String zyh) {
        Connection conn = getConnection();
        if (null == conn) {
            return null;
        }
        PatientLink patientLink = null;
        String strSQL = this.patBasicInfoSQLStr + " and a.VAA04 = '" + zyh + "'";
        logger.info("sql is "+strSQL);
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(strSQL);
            rs = preparedStatement.executeQuery();
            this.logger.info(strSQL);
            if (rs.next()) {
                patientLink = new PatientLink();
                patientLink.getApplication().setDetailstatus(Constants.OR_STATUS_FLAG_APPLIED);
                patientLink.getApplication().setStatus(Constants.AP_STATUS_MAZUIQIAN);
                patientLink.setCreateDate(new Date());
                patientLink.getPatient().setBrxm(trimStr(rs.getString("NAME")));
                patientLink.getPatient().setStatus(Constants.FLAG_VALID);
                String patient_id = trimStr(rs.getString("visit_id"));
  //              String schedule_id = trimStr(rs.getString("SCHEDULE_ID"));
                patientLink.getPatient().setZyh(patient_id);
    //            patientLink.setHisID(schedule_id);

                String srcSex = trimStr(rs.getString("SEX"));
                String sex = srcSex;
                if (null != srcSex) {
                    if (srcSex.equalsIgnoreCase("1"))
                        sex = "男";
                    else if (srcSex.equalsIgnoreCase("2")) {
                        sex = "女";
                    }
                }
                patientLink.getPatient().setXb(sex);
                try {
                    Date date = rs.getTimestamp("DATE_OF_BIRTH");
                    patientLink.getPatient().setDob(date);
                } catch (Exception ex) {
                }
                String strAge = trimStr(rs.getString("AGE"));
                try {
                    Integer numAge = Integer.valueOf(Integer.parseInt(strAge));
                    patientLink.getPatient().setNumAge(numAge);
                } catch (Exception e) {
                    patientLink.getPatient().setNumAge(Integer.valueOf(0));
                }
                String strAgeUnit = trimStr(rs.getString("AGE_UNIT"));
                if ((null != strAgeUnit) && (strAgeUnit.length() > 0)) {
                    if (strAgeUnit.equalsIgnoreCase("Y"))
                        patientLink.getPatient().setNldw(Constants.AGE_UNIT_YEAR);
                    else if (strAgeUnit.equalsIgnoreCase("M"))
                        patientLink.getPatient().setNldw(Constants.AGE_UNIT_MONTH);
                    else
                        patientLink.getPatient().setNldw(Constants.AGE_UNIT_DAY);
                } else {
                    patientLink.getPatient().setNldw(Constants.AGE_UNIT_YEAR);
                }
                patientLink.getPatient().setNl(patientLink.getPatient().getNumAge() + patientLink
                        .getPatient().getNldw());

                String bed = trimStr(rs.getString("BED"));
                patientLink.getPatient().setZych(bed);

                patientLink.getPatient().setKsmc(trimStr(rs.getString("DEPT_NAME")));
                patientLink.getPatient().setKsbh(trimStr(rs.getString("DEPT_CODE")));
            }
        } catch (SQLException e) {
            this.logger.error(e.getMessage(), e);
        }

        closeConnection(conn);
        patientLinkDao.addUpdate(patientLink);
        return patientLink;
    }

    public void updateOperationStatus(String hisOperId, String operStatus) {
    }

    @Override
    public void updateScheduleInfo(String PatientLinkId) {

    }

    @Override
    public void addScheduleInfo(String PatientLinkId) {

    }

    public List<ConfigDepartments> getDepartmentFromHis() {
        Connection conn = getConnection();
        if (null == conn) {
            return null;
        }
        List<ConfigDepartments> departmentList = new ArrayList();
        String strSQL = "SELECT * FROM V_DEPT_DICT";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(strSQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String deptName = rs.getString("DEPT_NAME");

                String deptCode = rs.getString("DEPT_CODE");
                if ((null == deptCode) || (null == deptName) || (deptCode.trim().length() == 0) || (deptName.trim().length() == 0))
                    continue;
                ConfigDepartments department = new ConfigDepartments();

                department.setName(deptName);

                department.setCode(deptCode);

                department.setDeleted(false);

                departmentList.add(department);
            }
        } catch (SQLException e) {
            this.logger.error(e.getMessage());
        }
        int count=0;
        List<ConfigDepartments> tempList=configDepartmentsDao.getAll();
       	if (tempList==null || tempList.size()==0) {
       		configDepartmentsDao.addAll(departmentList);
       		count=departmentList.size();
		}else {
			 for(int i=0;i<departmentList.size();i++){
		        	boolean flag=true;
		        	for (int j = 0; j < tempList.size(); j++) {
						if (tempList.get(j).getCode().equals(departmentList.get(i).getCode())) {
							flag=false;
						}
					}
		        	if (flag) {
						configDepartmentsDao.addOne(departmentList.get(i));
						count++;
					}
		        }	
		}
        logger.info("new dept count is "+count);
        closeConnection(conn);
        return departmentList;
    }

    public List<Account> getAccountFromHis() {
        Connection conn = getConnection();
        if (null == conn) {
            return null;
        }
        List<Account> accountList = new ArrayList();
        String strSQL = "SELECT * FROM V_HIS_USERS";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(strSQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Account account = getOneAccount(rs);
                if (null != account)
                    accountList.add(account);
            }
        } catch (SQLException e) {
            this.logger.error(e.getMessage());
        } catch (Exception e) {
            this.logger.fatal(e);
        }
        java.util.Map<String, Account> filterAccountMap = new HashMap<String, Account>();
		for (Account accountFrom : accountList) {
			if (accountFrom.getWorkID() != null) {
				filterAccountMap.put(accountFrom.getWorkID(), accountFrom);
			}
		}
        List<Account> accountListFromDb = accountDao.gets();
		logger.info("现有账号数量:" + accountListFromDb.size());
		Boolean flag;
		List<Account> newAcconutList = new ArrayList<Account>();
		if (accountListFromDb != null) {
			for (String workID : filterAccountMap.keySet()) {
				flag = false;
				for (int j = 0; j < accountListFromDb.size(); j++) {
					if (null != accountListFromDb.get(j).getWorkID())
						if (accountListFromDb.get(j).getWorkID().equals(filterAccountMap.get(workID).getWorkID())) {
							flag = true;
						}
				}
				if (!flag) {
					newAcconutList.add(filterAccountMap.get(workID));
				}
			}
		}
        closeConnection(conn);
        logger.info("new account is "+newAcconutList.size());
        accountDao.addAll(newAcconutList);
        return newAcconutList;
        }

    private Account getOneAccountFromHis(String accountCode, Connection conn) {
        if ((null == conn) || (null == accountCode) || (accountCode.length() == 0)) {
            return null;
        }
        String strSQL = "SELECT * FROM V_HIS_USERS";
        strSQL = strSQL + " where USER_ID = '" + accountCode + "'";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(strSQL);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Account account = getOneAccount(rs);
                if (null != account)
                    return account;
            }
        } catch (SQLException e) {
            this.logger.error(e.getMessage(), e);
        }

        return null;
    }

    private Account getOneAccount(ResultSet rs) throws SQLException {
        if (rs == null) {
            return null;
        }

        String DEPT_CODE = trimStr(rs.getString("USER_DEPT"));
        String DOCTOR_NAME = trimStr(rs.getString("USER_NAME"));
        String strCode = rs.getString("USER_ID");
        if ((null == DEPT_CODE) || (DEPT_CODE.trim().length() == 0)) return null;
        if ((null == DOCTOR_NAME) || (DOCTOR_NAME.trim().length() == 0)) return null;
        if ((null == strCode) || (strCode.trim().length() == 0)) return null;

        Account account = new Account();

        account.setOfficeID(DEPT_CODE);

        if (DEPT_CODE.equals(getMazuiDocDeptCode()))
            account.setOfficeName(getMazuiDocDeptName());
        else {
            account.setOfficeName(getOfficeNameByCode(DEPT_CODE));
        }

        account.setTrueName(DOCTOR_NAME);

        account.setWorkID(strCode);
        account.setCanLogin(true);
        account.setLoginName(strCode);
        account.setPwd(accountDao.generatePassword(String.valueOf(strCode)));

        String user_job = trimStr(rs.getString("USER_JOB"));
        if ("26".equals(DEPT_CODE)) {
            if (user_job.contains("护士")) {
                account.setRole("护士");
                account.setTitle("护士");
                account.setGender("女 ");
            } else {
                account.setRole("麻醉医生");
                account.setTitle("麻醉医生");
                account.setGender("男");
            }
        } else if (user_job.contains("护士")) {
            account.setRole("护士");
            account.setTitle("护士");
            account.setGender("女 ");
        } else {
            account.setRole("医生");
            account.setTitle("医生");
            account.setGender("男");
        }
        account.setSchoolLevel("本科");
        try {
            account.setDob(new Date());
        } catch (Exception ex) {
        }
        try {
            account.setInDate(new Date());
        } catch (Exception ex) {
        }
        account.setStatus("valid");
        account.setCreateTime(new Date());
        account.setLastUpdateTime(new Date());
        return account;
    }

    private String getOfficeNameByCode(String dEPT_CODE) {
    	if (dEPT_CODE==null) {
			dEPT_CODE="";
		}
		List<ConfigDepartments> list=configDepartmentsDao.getAll();
		String name="其他";
		for (ConfigDepartments configDepartments : list) {
			if (dEPT_CODE.equals(configDepartments.getCode())) {
				name=configDepartments.getName();
				break;
			}
		}
		return name;
	}

	private String convertCodeToId(String code, List<Account> accountList, Connection conn) {
    	for (int i = 0; i < accountList.size(); i++) {
			if (code.equals(accountList.get(i).getWorkID())) {
				return accountList.get(i).getTrueName();
			}
		}
		Account account = getOneAccountFromHis(code, conn);
		if (null != account) {
			accountDao.save(account);
			accountList.add(account);
		}
		return account.getTrueName();
    }

   






    public List<String> getExistItemList() {
        return this.existItemList;
    }

    public Map<String, String> getListDataFromHis(String zyh) {
        Connection conn = getConnection();
        if (null == conn) {
            return null;
        }
        Map examineMap = new HashMap();

        String strSQL = "SELECT B.Bey03,B.BBX05,B.BFC03,B.Lac10,B.BDG02,B.LAC11,B.HISID FROM [dbo].[V_LisRequestNote] A RIGHT JOIN [dbo].[V_LisToHisData] B ON A.PID = B.Lab09 WHERE A.PID = '" + zyh + "' AND Bey03 in('血常规','尿分析','急诊生化','生化','血凝') ORDER BY A.SfTime,B.LAB20 DESC";

        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        this.existItemList.clear();
        try {
            preparedStatement = conn.prepareStatement(strSQL);
            rs = preparedStatement.executeQuery();
            while (rs.next())
                getLisResult(rs, examineMap);
        } catch (SQLException e) {
            this.logger.error(e.getMessage());
        }
        closeConnection(conn);
        System.out.println(examineMap);
        return examineMap;
    }

    private void getLisResult(ResultSet rs, Map<String, String> examineMap) throws SQLException {
        if (rs == null) return;
        String itemCode = rs.getString("BFC03");
        if (null == itemCode) {
            return;
        }
        itemCode = itemCode.trim();

        String itemName = rs.getString("BBX05");
        if (null != itemName) {
            itemName = itemName.trim();
        }

        String itemBigName = rs.getString("Bey03");
        if (null != itemBigName) {
            itemBigName = itemBigName.trim();
        }

        String value = rs.getString("Lac10");
        if (null == value) {
            return;
        }
        value = value.trim();

        if (examineMap.containsKey(itemCode)) {
            return;
        }

        if (!this.existItemList.contains(itemCode + itemBigName))
            this.existItemList.add(itemCode + itemBigName);
        else {
            return;
        }

        String status = rs.getString("LAC11");

        if ("血常规".equals(itemBigName)) {
            for (Entry entry : XueChangGuiItemCodeMap.entrySet()) {
                for (int i = 0; i < ((String[]) entry.getValue()).length; i++) {
                    if (itemCode.equals(((String[]) entry.getValue())[i])) {
                        if ((null == status) || ("".equals(status.trim()))) {
                            if ((itemCode.equals("ABO")) || (itemCode.equals("RH")))
                                if (value.contains("型"))
                                    value = value.replace("型", "").trim();
                                else if (value.contains("阳性(+)"))
                                    value = "Rh﹢";
                                else if (value.contains("阴性(-)"))
                                    value = "Rh﹣";
                        } else {
                            status = status.trim();
                            value = value + status;
                        }
                        examineMap.put(itemCode + itemBigName, value);
                        return;
                    }
                }
            }

        }

        if ((null == status) || ("".equals(status.trim()))) {
            return;
        }
        value = value + status;

        for (Entry<String, String[]> entry : ItemCodeMap.entrySet()) {
            for (int i = 0; i < ((String[]) entry.getValue()).length; i++)
                if (itemCode.equals(((String[]) entry.getValue())[i])) {
                    examineMap.put(itemCode + itemBigName, value);
                    return;
                }
        }
    }

    public String getMazuiDocDeptCode() {
        return "26";
    }

    public String getMazuiDocDeptName() {
        return "麻醉科";
    }

    public String getNurseDeptCode() {
        return "26";
    }

    public String getNurseDeptName() {
        return "麻醉科";
    }

    public boolean isBGAEnable() {
        return false;
    }

   

    static {
        ItemCodeMap.put("niaoChangGui", niaoChangGui);
        ItemCodeMap.put("ganGongNeng", ganGongNeng);
        ItemCodeMap.put("shenGongNeng", shenGongNeng);
        ItemCodeMap.put("dianJieZhi", dianJieZhi);
        ItemCodeMap.put("ningXueGongNeng", ningXueGongNeng);
        ItemCodeMap.put("xueTang", xueTang);
        ItemCodeMap.put("cFanYingDanBai", cFanYingDanBai);
        ItemCodeMap.put("rbc", rbc);
        ItemCodeMap.put("hb", hb);
        ItemCodeMap.put("hct", hct);
        ItemCodeMap.put("plt", plt);
        ItemCodeMap.put("wbc", wbc);
        ItemCodeMap.put("bloodType", bloodType);

        ItemCodeMap4BigName.put("niaoChangGui", bigName2);
        ItemCodeMap4BigName.put("ganGongNeng", bigName3);
        ItemCodeMap4BigName.put("shenGongNeng", bigName3);
        ItemCodeMap4BigName.put("dianJieZhi", bigName3);
        ItemCodeMap4BigName.put("ningXueGongNeng", bigName4);
        ItemCodeMap4BigName.put("xueTang", bigName3);
        ItemCodeMap4BigName.put("cFanYingDanBai", bigName5);
        ItemCodeMap4BigName.put("rbc", bigName1);
        ItemCodeMap4BigName.put("hb", bigName1);
        ItemCodeMap4BigName.put("hct", bigName1);
        ItemCodeMap4BigName.put("plt", bigName1);
        ItemCodeMap4BigName.put("wbc", bigName1);
        ItemCodeMap4BigName.put("bloodType", bigName1);

        XueChangGuiItemCodeMap.put("rbc", rbc);
        XueChangGuiItemCodeMap.put("hb", hb);
        XueChangGuiItemCodeMap.put("hct", hct);
        XueChangGuiItemCodeMap.put("plt", plt);
        XueChangGuiItemCodeMap.put("wbc", wbc);
        XueChangGuiItemCodeMap.put("bloodType", bloodType);
    }
    public Boolean getOperationFromHis() {
		Boolean flag;
		// 获取his端的手术申请
		List<PatientLink> hisPatientLinkList = getOprationFromHis();
		logger.info("hisPatientLinkList:" + hisPatientLinkList.size());
		// 获取当前数据库的手术申请
		List<PatientLink> patientLinkList = patientLinkDao.getScheduleTableOpersNS();
		int count=0;
		if (null == hisPatientLinkList || hisPatientLinkList.size() == 0) {
			flag = false;
			return flag;
		} else {
            if (null != patientLinkList && patientLinkList.size() != 0) {
                for (int i = 0; i < hisPatientLinkList.size(); i++) {
                    // System.out.println("hisPatientLinkList:"+hisPatientLinkList.get(i).getPatient().getBrxm());
                    boolean addFlag = true;
                    for (int j = 0; j < patientLinkList.size(); j++) {
                        if (hisPatientLinkList.get(i).getApplication().getSssqdh().equals(patientLinkList.get(j).getApplication().getSssqdh())) {
                            addFlag = false;
                            // 更新数据库
                           if (patientLinkList.get(j).getApplication().getDetailstatus()!=null && patientLinkList.get(j).getApplication().getDetailstatus().equals(Constants.OR_STATUS_FLAG_APPLIED)) {
 //                           patientLinkDao.addUpdateApplication(hisPatientLinkList.get(i),patientLinkList.get(j));
    //                       patientLinkDao.addUpdateSchedule(hisPatientLinkList.get(i),patientLinkList.get(j));
							}
                            break;
                        }
                    }
                    if (addFlag) {
                    	count++;
                        patientLinkDao.addUpdate(hisPatientLinkList.get(i));
                    }
                }
            } else {
                for (PatientLink patientLink : hisPatientLinkList) {
                    patientLinkDao.addUpdate(patientLink);
                }
            }
        }
		flag = true;
		logger.info("new patientLinks count is  "+count);
		return flag;
	}

	@Override
	public boolean writeEndOper2HIS(PatientLink patientLink) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addEndOper2HISUpateBatch(List<PatientLink> patientLinks) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<PojoBGA> getBGA(String zyh, Date startTime, Date endTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LisData getLisData(String zyh, String name) {
		// TODO Auto-generated method stub
		return null;
	}
}

