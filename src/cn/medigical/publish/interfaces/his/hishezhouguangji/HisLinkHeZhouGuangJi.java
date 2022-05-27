package cn.medigical.publish.interfaces.his.hishezhouguangji;

import cn.medigical.publish.dao.impl.AccountCache;
import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.interfaces.his.hisLink.HisLink;
import cn.medigical.publish.interfaces.his.hisLink.PojoBGA;
import cn.medigical.publish.interfaces.his.hishezhouguangji.utils.MsgDealUtil;
import cn.medigical.publish.interfaces.lis.LisData;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.dictionary.ConfigDepartments;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.utils.Constants;
import cn.medigical.publish.utils.MyConstants;
import cn.medigical.publish.utils.StringUtil;
import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

//@Component
public class HisLinkHeZhouGuangJi extends HisLink {

    private JdbcTemplate template;

    private List<Account> accounts;

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        template = jdbcTemplate;
    }

//    String driverName = "oracle.jdbc.driver.OracleDriver";
//    String dbIP = "10.10.15.1";
//    String url = "jdbc:oracle:thin:@//"+dbIP+":1521/orcl";
//    String username = "sm001";
//    String password = "sm001";

    @Override
    public List<PatientLink> getOprationFromHis() {
        accounts = AccountCache.getInstance().gets();
        Calendar now = Calendar.getInstance();
        Date dateNow = now.getTime();
        Date dateFrom = new Date(dateNow.getTime() - Constants.ONE_DAY_LONG * 3);
        //开始时间
        String startDateTime = simpleDateFormat.format(dateFrom)+" 00:00:00";
        //结束时间
        String endDateTime = simpleDateFormat.format(dateNow)+" 23:59:59";
        String strSQL = "select * from sm_getOperation where operation_jhsj <= to_date('"+endDateTime+"','yyyy-MM-dd hh24:mi:ss') and operation_jhsj >= to_date('"+startDateTime+"','yyyy-MM-dd hh24:mi:ss') and operation_zt != '已执行'";
        List<Map<String, Object>> result = template.queryForList(strSQL);
        List<PatientLink> patientLinkList = new ArrayList<>();
        for (Map<String, Object> item : result) {
            patientLinkList.add(getOperation(item));
        }
        return patientLinkList;
    }

    @Override
    public void updateOperationStatus(String hisOperId, String operStatus) {

    }

    @Override
    public void updateScheduleInfo(String PatientLinkId) {

    }

    @Override
    public void addScheduleInfo(String PatientLinkId) {

    }

    @Override
    public ArrayList<Account> getAccountFromHis() {
        String strSQL = "select * from sm_getstaffall";
        ArrayList<Account> accountList = new ArrayList<>();
        try {
            List<Map<String, Object>> result = template.queryForList(strSQL);
            for (Map item : result) {
                String STAFF_ID = MsgDealUtil.trimStr(String.valueOf(item.get("STAFF_ID")));
                String STAFF_GH = MsgDealUtil.trimStr(String.valueOf(item.get("STAFF_GH")));
                String STAFF_MC = MsgDealUtil.trimStr(String.valueOf(item.get("STAFF_MC")));
                String STAFF_KSBM = MsgDealUtil.trimStr(String.valueOf(item.get("STAFF_KSBM")));
                String STAFF_KSMC = MsgDealUtil.trimStr(String.valueOf(item.get("STAFF_KSMC")));
                String STAFF_XB = MsgDealUtil.trimStr(String.valueOf(item.get("STAFF_XB")));
                String STAFF_ZW = MsgDealUtil.trimStr(String.valueOf(item.get("STAFF_ZW")));
                String STAFF_ZC = MsgDealUtil.trimStr(String.valueOf(item.get("STAFF_ZC")));
                Account account = new Account();
                // 科室名称
                account.setOfficeName(STAFF_KSMC);
                // 职工科室编号
                account.setOfficeID(STAFF_KSBM);
                // 职工姓名
                account.setTrueName(STAFF_MC);
                // 职工工号
                account.setWorkID(STAFF_GH);
                // 登录名
                account.setLoginName(STAFF_GH);
                //登录密码
                account.setPwd(AccountDao.generatePassword(STAFF_GH));
                // 职工性别
                account.setGender(STAFF_XB);
                // 默认都让登陆
                account.setCanLogin(true);
                // 职工职位
                if (null != STAFF_ZC) {
                    if (!STAFF_ZC.contains("护师") && (STAFF_ZC.contains("主任") || STAFF_ZC.contains("医师") || STAFF_ZC.contains("医生") || STAFF_ZC.contains("教授") || STAFF_ZC.contains("医士"))) {
                        if (STAFF_KSBM.equalsIgnoreCase(getMazuiDocDeptCode())) {
                            account.setRole(MyConstants.MAZUI_DOCTOR);
                        } else {
                            account.setRole(MyConstants.DOCTOR);
                        }
                    } else if (STAFF_ZC.contains("护士") || STAFF_ZC.contains("护理") || STAFF_ZC.contains("护师")) {
                        account.setRole(MyConstants.HUSHI);
                    } else {
                        account.setRole(MyConstants.OTHER_STUFF);
                        account.setCanLogin(false);
                    }
                    account.setTitle(STAFF_ZC);
                }
                //学历
                account.setSchoolLevel("本科");
                //出生日期
                try {
                    account.setDob(new Date());
                } catch (Exception ex) {
                }

                account.setStatus("valid");
                account.setCreateTime(new Date());
                account.setLastUpdateTime(new Date());
                accountList.add(account);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return accountList;
    }

    @Override
    public ArrayList<ConfigDepartments> getDepartmentFromHis() {

        String strSQL = "select * from sm_getdepall";
        ArrayList<ConfigDepartments> configDepartmentsList = new ArrayList<>();
        try {
            List<Map<String, Object>> result = template.queryForList(strSQL);
            for (Map item : result) {
                String DEP_ID = MsgDealUtil.trimStr(String.valueOf(item.get("DEP_ID")));
                String DEP_BM = MsgDealUtil.trimStr(String.valueOf(item.get("DEP_BM")));
                String DEP_MC = MsgDealUtil.trimStr(String.valueOf(item.get("DEP_MC")));
                ConfigDepartments configDepartments = new ConfigDepartments();
                configDepartments.setId(DEP_ID);
                configDepartments.setCode(DEP_BM);
                configDepartments.setName(DEP_MC);
                configDepartments.setDeleted(false);
                configDepartmentsList.add(configDepartments);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return configDepartmentsList;
    }

    private PatientLink getOperation(Map<String, Object> operInfoItem) {
        if (operInfoItem == null) {
            return null;
        }
        //手术单ID
        String Operation_Id = StringUtil.trim(String.valueOf(operInfoItem.get("Operation_Id")));
        //手术状态
        String Operation_Zt = StringUtil.trim(String.valueOf(operInfoItem.get("Operation_Zt")));
        //患者姓名
        String Patient_Xm = StringUtil.trim(String.valueOf(operInfoItem.get("Patient_Xm")));
        //患者住院号
        String Patient_Zyh = StringUtil.trim(String.valueOf(operInfoItem.get("Patient_Zyh")));
        //患者性别
        String Patient_Xb = StringUtil.trim(String.valueOf(operInfoItem.get("Patient_Xb")));
        //患者年龄
        String Patient_Nl = StringUtil.trim(String.valueOf(operInfoItem.get("Patient_Nl")));
        //患者床号
        String Patient_Ch = StringUtil.trim(String.valueOf(operInfoItem.get("Patient_Ch")));
        //申请科室名称
        String Dep_Mc = StringUtil.trim(String.valueOf(operInfoItem.get("Dep_Mc")));
        //申请科室编码
        String Dep_Id = StringUtil.trim(String.valueOf(operInfoItem.get("Dep_Id")));
        //医嘱名称(手术名称)
        String DoctorsAdvice_Mc = StringUtil.trim(String.valueOf(operInfoItem.get("DoctorsAdvice_Mc")));
        //计划手术时间
        String Operation_Jhsj = StringUtil.trim(String.valueOf(operInfoItem.get("Operation_Jhsj")));
        //手术申请时间
        String Operation_Sqsj = StringUtil.trim(String.valueOf(operInfoItem.get("Operation_Sqsj")));
        //手术等级
        String Operation_Dj = StringUtil.trim(String.valueOf(operInfoItem.get("Operation_Dj")));
        //ICD10诊断
        String Icd_10 = StringUtil.trim(String.valueOf(operInfoItem.get("Icd_10")));
        //手术医生ID
        String OperationDoctor_Id = StringUtil.trim(String.valueOf(operInfoItem.get("OperationDoctor_Id")));
        //手术医生名称
        String OperationDoctor_Mc = StringUtil.trim(String.valueOf(operInfoItem.get("OperationDoctor_Mc")));
        //手术医生编码
        String OperationDoctor_Bm = StringUtil.trim(String.valueOf(operInfoItem.get("OperationDoctor_Bm")));
        //执行科室编码
        String Dep_Zxksbm = StringUtil.trim(String.valueOf(operInfoItem.get("Dep_Zxksbm")));
        //执行科室名称
        String Dep_Zxksmc = StringUtil.trim(String.valueOf(operInfoItem.get("Dep_Zxksmc")));
        //患者所在病区编码
        String Patient_Bqbm = StringUtil.trim(String.valueOf(operInfoItem.get("Patient_Bqbm")));
        //患者所在病区名称
        String Patient_Bqmc = StringUtil.trim(String.valueOf(operInfoItem.get("Patient_Bqmc")));

        if (null == Operation_Id || Operation_Id.trim().length() == 0) {
            return null;
        }

//        String status = operInfoItem.get("SHOUSHUZT");
//        if ("已作废".equals(status)) {
//            return null;
//        }

        PatientLink patientLink = new PatientLink();
        // 手术申请ID
        patientLink.getApplication().setSssqdh(Operation_Id);// 申请单号

        // PatientLink.setBedsideShow(((DefaultBedsideShow)BeanCache.getInstance().getBean("DefaultBedsideShow")).getDefault());

        patientLink.setHisID(Operation_Id);

        // 手术状态
        patientLink.getApplication().setStatus(Constants.AP_STATUS_MAZUIQIAN);
        // 明细状态
        patientLink.getApplication().setDetailstatus(Constants.OR_STATUS_FLAG_APPLIED);
        // 患者状态
        patientLink.getPatient().setStatus(Constants.FLAG_VALID);

        patientLink.getPatient().setBrxm(Patient_Xm);// 病人姓名
        patientLink.getPatient().setZyh(Patient_Zyh); // HIS端住院号
        patientLink.getPatient().setBqmc(Patient_Bqmc);

        patientLink.getPatient().setXb(Patient_Xb);

        setAge(patientLink,Patient_Nl);

        if (null == patientLink.getPatient().getNldw()) {
            patientLink.getPatient().setNldw(Constants.AGE_UNIT_MONTH);// 年龄单位
        }

        // 住院床号
        if (Patient_Ch.length() > 4) {
            Patient_Ch = Patient_Ch.substring(4, Patient_Ch.length());
        }
        patientLink.getPatient().setZych(Patient_Ch);

        // 住院科室
        patientLink.getApplication().setSqksmc(Dep_Mc);// 申请科室名称
        patientLink.getApplication().setSqksbh(Dep_Id);// 申请科室编号

        // 拟施手术
        patientLink.getApplication().setNsssmc(DoctorsAdvice_Mc);// 拟施手术名称
//        patientLink.getApplication().setNsssmc1(trimStr(operInfoItem.get("SHOUSHUMC1")));
//        patientLink.getApplication().setNsssmc2(trimStr(operInfoItem.get("SHOUSHUMC2")));
//        patientLink.getApplication().setNsssmc3(trimStr(operInfoItem.get("SHOUSHUMC3")));

        // 计划手术时间
        try {
            Date planOperTime = new Date(Timestamp.valueOf(Operation_Jhsj).getTime());// 计划手术时间
            patientLink.getApplication().setYysssj(planOperTime);
            patientLink.getSchedule().setJhsssj(planOperTime);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        try {
            // String applyTime =operInfoItem.get("SHENQINGSJ");
            // Date applyOperTime = MyDateFormat.DATE_FORMAT_YMDHM.parse(applyTime);
            SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = df.format(dfs.parse(Operation_Sqsj));
            Timestamp ts = Timestamp.valueOf(time);
            Date applyOperTime = new Date(ts.getTime());// 手术申请时间
            patientLink.getApplication().setSssqsj(applyOperTime);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }



        // his有3个术前诊断
        patientLink.getApplication().setSqzd1(Icd_10);
        patientLink.getApplication().setMzfs("");

        //手术医师
        if(!"".equals(OperationDoctor_Bm)&&!"".equals(OperationDoctor_Mc)) {
            patientLink.getApplication().setSsysxm(convertNameToId(OperationDoctor_Mc, OperationDoctor_Bm, accounts, "手术医生"));
        }

        // 申请科室名称
        patientLink.getApplication().setSqksmc(Dep_Mc);
        patientLink.getPatient().setKsmc(Dep_Mc);
        // 申请科室编号
        patientLink.getApplication().setSqksbh(Dep_Id);

        return patientLink;
    }

    private void setAge(PatientLink patientLink,String Patient_Nl) {
        // 年龄
        Date now = new Date();
        if (Patient_Nl.contains("岁") || Patient_Nl.contains("月") || Patient_Nl.contains("天")) {
            patientLink.getPatient().setNl(Patient_Nl);// 年龄
            if (Patient_Nl.contains("岁")) {
                try {
                    patientLink.getPatient().setNldw(Constants.AGE_UNIT_YEAR);// 年龄单位
                    Integer numAge = Integer.parseInt(Patient_Nl.substring(0, Patient_Nl.indexOf("岁")));
                    patientLink.getPatient().setNumAge(numAge);
                    now.setYear(now.getYear() - numAge);
                    patientLink.getPatient().setDob(now);
                } catch (Exception e) {
                    patientLink.getPatient().setNumAge(0);
                }
            } else {
                patientLink.getPatient().setNumAge(0);
            }
        } else {
            patientLink.getPatient().setNl(Patient_Nl + "岁");// 年龄
            try {
                Integer numAge = Integer.parseInt(Patient_Nl.trim());
                patientLink.getPatient().setNumAge(numAge);
                patientLink.getPatient().setNldw(Constants.AGE_UNIT_YEAR);// 年龄单位
                now.setYear(now.getYear() - numAge);
                patientLink.getPatient().setDob(now);
            } catch (Exception e) {
            }
        }

    }

    private String convertNameToId(String name, String zhuDaoGH, List<Account> accounts, String role) {
        for (int i = 0; i < accounts.size(); i++) {
            if (name.equals((accounts.get(i)).getTrueName())) {
                return (accounts.get(i)).getId();
            }
        }

        return crtNewAccount(name, zhuDaoGH, role);
    }

    private String crtNewAccount(String name, String zhuDaoGH, String role) {
        Account account = new Account();
        account.setTrueName(name);
        account.setRole(role);
        account.setWorkID(zhuDaoGH);
        account.setLoginName(zhuDaoGH);
        account.setLastUpdateTime(new Date());
        account.setCreateTime(new Date());
        account.setInDate(new Date());
        account.setCanLogin(Boolean.valueOf(true));
        account.setStatus("valid");
        account.setPwd(AccountDao.generatePassword(String.valueOf(zhuDaoGH)));
        account.setSchoolLevel("本科");
        if ("麻醉医生".equalsIgnoreCase(role)) {
            account.setOfficeID(getMazuiDocDeptCode());
            account.setOfficeName(getMazuiDocDeptName());
        }
        if ("护士".equalsIgnoreCase(role)) {
            account.setOfficeID(getNurseDeptCode());
            account.setOfficeName(getNurseDeptName());
        }

        AccountCache.getInstance().setAccountToMap(account);
        accounts.add(account);
        return account.getId();
    }

    @Override
    public boolean writeEndOper2HIS(PatientLink patientLink) {
        return false;
    }

    @Override
    public boolean addEndOper2HISUpateBatch(List<PatientLink> patientLinks) {
        return false;
    }

    @Override
    public LisData getLisData(String zyh, String name) {
        return null;
    }

    @Override
    public String getMazuiDocDeptCode() {
        return "41201";
    }

    @Override
    public String getMazuiDocDeptName() {
        return "麻醉科";
    }

    @Override
    public String getNurseDeptCode() {
        return "41202";
    }

    @Override
    public String getNurseDeptName() {
        return "手术室";
    }

    @Override
    public boolean isBGAEnable() {
        return false;
    }

    @Override
    public List<PojoBGA> getBGA(String zyh, Date startTime, Date endTime) {
        return null;
    }

}