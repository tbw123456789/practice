package cn.medigical.publish.interfaces.his.hisTongliang;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;


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
import cn.medigical.publish.utils.SpringUtils;
import org.apache.log4j.Logger;

public class HisLinkTongLiang extends HisLink {
    private static Logger logger = Logger.getLogger("HisLinkTongLiang");
    String dbIP;
    String driverName;
    String url;
    String username;
    String password;
    PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);
    AccountDao accountDao = (AccountDao) SpringUtils.getBean(AccountDao.class);
    ConfigDepartmentsDao configDepartmentsDao = SpringUtils.getBean(ConfigDepartmentsDao.class);
    ConfigDrugsDao configDrugsDao = SpringUtils.getBean(ConfigDrugsDao.class);
    public HisLinkTongLiang()
    {
        this.dbIP = "1.1.8.114";
        this.driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        this.url = "jdbc:sqlserver://1.1.8.114:1433;databaseName=ph_interface";
        this.username = "ph_interface";
        this.password = "ph_@interface";
    }

    private Connection getConnection()
    {
        Connection connection = null;
        try
        {
            Class.forName(this.driverName);
            connection = DriverManager.getConnection(this.url, this.username, this.password);
            logger.info("Connect to HIS Oracle ok. @" + this.dbIP);
        }
        catch (Exception ex)
        {
            logger.fatal("Could not establish HIS Oracle connection! " + this.dbIP + ex.getMessage(), ex);
        }
        return connection;
    }

    private void closeConnection(Connection connection)
    {
        if (null != connection) {
            try
            {
                connection.close();
            }
            catch (SQLException e)
            {
                logger.error("Could not close connection! " + e.getMessage());
            }
        }
    }

    public List<PatientLink> getOprationFromHis()
    {
        Connection conn = getConnection();
        if (null == conn) {
            return null;
        }
        List<PatientLink> patientLinkList = new ArrayList();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateNow = new Date();
        Date dateFrom = new Date(dateNow.getTime() - 604800000L);
        String threeDaysAgo = sdf.format(dateFrom);
        String strSQL = "SELECT * FROM v_his_sssq WHERE sqsj > '" + threeDaysAgo + "';";
        try
        {
            logger.info("SQL = " + strSQL);
            PreparedStatement preparedStatement = conn.prepareStatement(strSQL);
            ResultSet rs = preparedStatement.executeQuery();
            int count = 1;
            while (rs.next())
            {
                logger.debug("get oper request count = " + count++);
                PatientLink patientLink = getPatientLink(rs);
                if (null != patientLink) {
                    patientLinkList.add(patientLink);
                }
            }
        }
        catch (SQLException e)
        {
            logger.error("Could not read the ssmz_forhis_sssq table ! " + e.getMessage());
        }
        closeConnection(conn);
        return patientLinkList;
    }

    private PatientLink getPatientLink(ResultSet rs)
            throws SQLException
    {
        if (rs == null) {
            return null;
        }
        String id = trimStr(rs.getString("djh"));
        if ((null == id) || (id.trim().length() == 0)) {
            return null;
        }
        PatientLink patientLink = new PatientLink();
        //PatientLink.setBedsideShow(((DefaultBedsideShow)BeanCache.getInstance().getBean("DefaultBedsideShow")).getDefault());
        patientLink.getApplication().setSssqdh(id);
        patientLink.setHisID(id);
        patientLink.getApplication().setSssqdh(id);
        patientLink.getApplication().setDetailstatus(Constants.OR_STATUS_FLAG_APPLIED);
        //手术状态
        patientLink.getApplication().setStatus(Constants.AP_STATUS_MAZUIQIAN);
        //明细状态
        patientLink.getApplication().setDetailstatus(Constants.OR_STATUS_FLAG_APPLIED);
        //患者状态
        patientLink.getPatient().setStatus(Constants.FLAG_VALID);

        patientLink.getPatient().setBrxm(trimStr(rs.getString("病人姓名")));
        patientLink.getPatient().setZyh(trimStr(rs.getString("住院号")));
        String srcSex = rs.getString("性别");
        String sex = srcSex;
        if (null != srcSex) {
            if (srcSex.equals("男")) {
                sex = "男";
            } else if (srcSex.equals("女")) {
                sex = "女 ";
            }
        }
        patientLink.getPatient().setXb(sex);

        String srcSg = trimStr(rs.getString("身高"));
        Float sg = null;
        if (srcSg != null) {
            try
            {
                sg = Float.valueOf(Float.parseFloat(srcSg));
            }
            catch (Exception e) {}
        }
        patientLink.getPatient().setSg(srcSg);


        String srcTz = rs.getString("体重");
        Float tz = null;
        if (srcTz != null) {
            try
            {
                tz = Float.valueOf(Float.parseFloat(srcTz));
            }
            catch (Exception e) {}
        }
        patientLink.getPatient().setTz(srcTz);
        try
        {
            String ageStr = rs.getString("年龄");
            int end = 0;
            if ((null != ageStr) && (ageStr.length() != 0))
            {
                patientLink.getPatient().setNl(ageStr);
                Calendar calendar = Calendar.getInstance();
                if (ageStr.contains("岁"))
                {
                    end = ageStr.indexOf("岁");
                    calendar.add(1, -Integer.valueOf(ageStr.substring(0, end)).intValue());
                    patientLink.getPatient().setNumAge(Integer.valueOf(ageStr.substring(0, end)));
                    patientLink.getPatient().setNldw(Constants.AGE_UNIT_YEAR);
                }
                if (ageStr.contains("月"))
                {
                    calendar.add(2, -Integer.valueOf(ageStr.substring(end == 0 ? 0 : end + 1, ageStr.indexOf("月"))).intValue());
                    end = ageStr.indexOf("月");
                }
                if (ageStr.contains("天")) {
                    calendar.add(6, -Integer.valueOf(ageStr.substring(end == 0 ? 0 : end + 1, ageStr.indexOf("天"))).intValue());
                }
                patientLink.getPatient().setNl(ageStr);
                calendar.set(11, 0);
                calendar.set(12, 0);
                calendar.set(13, 0);
                calendar.set(14, 0);
                patientLink.getPatient().setDob(calendar.getTime());
            }
        }
        catch (Exception e) {}
        patientLink.getPatient().setZych(trimStr(rs.getString("床号")));


        patientLink.getApplication().setSqksmc(trimStr(rs.getString("申请科室名称")));
        patientLink.getApplication().setSqksbh(trimStr(rs.getString("申请科室编号")));
        patientLink.getPatient().setKsmc(trimStr(rs.getString("申请科室名称")));

        patientLink.getPatient().setXx(rs.getString("血型"));

        patientLink.getPatient().setSocialId(trimStr(rs.getString("身份证")));

        patientLink.getPatient().setYblx(trimStr(rs.getString("医保类型")));


        patientLink.getApplication().setPriory(trimStr(rs.getString("手术优先级")));


        patientLink.getApplication().setNsssmc(trimStr(rs.getString("拟施手术名称")));
        try
        {
            Date planOperTime = new Date(rs.getTimestamp("计划手术时间").getTime());
            Date applyOperTime = new Date(rs.getTimestamp("sqsj").getTime());
            patientLink.getApplication().setYysssj(planOperTime);
            patientLink.getApplication().setSssqsj(applyOperTime);
            //PatientLink.getSchedule().setPlanTime(planOperTime);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        patientLink.getApplication().setOperLevel(trimStr(rs.getString("ssjb")));


        patientLink.getApplication().setSqzd1(trimStr(rs.getString("术前诊断")));


        patientLink.getPatient().setGms(trimStr(rs.getString("过敏史")));


        patientLink.getApplication().setSqysbh(trimStr(rs.getString("申请医生")));


        patientLink.getApplication().setSsysxm(trimStr(rs.getString("主刀医生")));


        patientLink.getApplication().setZlysbh1(trimStr(rs.getString("助理医生1")));


        patientLink.getApplication().setZlysbh2(trimStr(rs.getString("助理医生2")));


        patientLink.getApplication().setSqksmc(trimStr(rs.getString("申请科室名称")));

        patientLink.getApplication().setSqksbh(trimStr(rs.getString("申请科室编号")));

        String srcSslx = rs.getString("手术类型");
        String sslx = "schedule";
        if ("急诊".equals(srcSslx)) {
            sslx = "urgent";
        } else {
            sslx = "schedule";
        }
        patientLink.getApplication().setType(sslx);


        patientLink.getStatus().setFlag("applied");

        patientLink.getApplication().setVip(rs.getString("绿色通道"));
        patientLink.getApplication().setZhushu(trimStr(rs.getString("主诉")));

        return patientLink;
    }

    private String trimStr(String str)
    {
        if (null == str) {
            return null;
        }
        return str.trim();
    }

    public LisData getLisData(String zyh, String name)
    {
        Connection conn = getConnection();
        if (null == conn) {
            return null;
        }
        logger.warn("getLisData name = " + name);
        if ((null == name) || (name.trim().length() == 0)) {
            return null;
        }
        LisData lisData = new LisData();



        String strSQL = "SELECT * FROM VIEW_JYJGH a LEFT JOIN View_JYJGD b ON a.jyh = b.JYH where brxm = '" + name + "' ORDER BY a.bgsj DESC";
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        logger.warn("lis sql = " + strSQL);
        try
        {
            preparedStatement = conn.prepareStatement(strSQL);
            rs = preparedStatement.executeQuery();
            while ((rs.next()) &&
                    (!lisData.isFullData())) {
                getLisResult(lisData, rs);
            }
        }
        catch (SQLException e)
        {
            logger.fatal("Could not read the SAM_JY table ! " + e.getMessage(), e);
        }
        closeConnection(conn);
        return lisData;
    }

    public String getMazuiDocDeptCode()
    {
        return "123";
    }

    public String getMazuiDocDeptName()
    {
        return "手术室";
    }

    public String getNurseDeptCode()
    {
        return "123";
    }

    public String getNurseDeptName()
    {
        return "手术室";
    }

    public boolean isBGAEnable()
    {
        return false;
    }

    public ArrayList<PojoBGA> getBGA(String zyh, Date startTime, Date endTime)
    {
        return null;
    }

    private void getLisResult(LisData lisData, ResultSet rs)
            throws SQLException
    {
        if (rs == null) {
            return;
        }
        try
        {
            String MC = rs.getString("MC");
            String sbmc = rs.getString("sbmc");
            String brxm = rs.getString("brxm");
            String itemCode = rs.getString("XMSX");
            String XB = rs.getString("XB");
            String NL = rs.getString("NL");
            String sfzh = rs.getString("sfzh");
            if (itemCode == null) {
                itemCode = "";
            }
            itemCode = itemCode.trim();
            String value = rs.getString("JG");
            if (value == null) {
                value = "";
            }
            value = value.trim();
            setLisData(lisData, itemCode, value);
            logger.warn("brxm=" + brxm + ", XB = " + XB + ",NL= " + NL + ",sfzh= " + sfzh + ", sbmc= " + sbmc + ",MC=" + MC + ",itemCode=" + itemCode + ",JG=" + value);
        }
        catch (SQLException e)
        {
            logger.fatal("SAM_JY_RESULT Table ! " + e.getMessage(), e);
        }
    }

    private void setLisData(LisData lisData, String itemCode, String itemValue)
    {
        switch (itemCode)
        {
            case "20180":
                if (null == lisData.getHb()) {
                    lisData.setHb(itemValue);
                }
                break;
            case "20190":
                if (null == lisData.getHCT()) {
                    lisData.setHCT(itemValue);
                }
                break;
            case "20100":
                if (null == lisData.getWBC()) {
                    lisData.setWBC(itemValue);
                }
                break;
            case "20250":
                if (null == lisData.getPLT()) {
                    lisData.setPLT(itemValue);
                }
                break;
            case "10350":
                if (null == lisData.getK()) {
                    lisData.setK(itemValue);
                }
                break;
            case "10360":
                if (null == lisData.getNA()) {
                    lisData.setNA(itemValue);
                }
                break;
            case "10370":
                if (null == lisData.getCL()) {
                    lisData.setCL(itemValue);
                }
                break;
            case "10412":
                if (null == lisData.getGLU()) {
                    lisData.setGLU(itemValue);
                }
                break;
            case "10220":
                if (null == lisData.getBUN()) {
                    lisData.setBUN(itemValue);
                }
                break;
            case "10240":
                if (null == lisData.getCr()) {
                    lisData.setCr(itemValue);
                }
                break;
            case "40160":
                if (null == lisData.getPT()) {
                    lisData.setPT(itemValue);
                }
                break;
            case "40150":
                if (null == lisData.getAPTT()) {
                    lisData.setAPTT(itemValue);
                }
                break;
            case "10170":
                if (null == lisData.getSGPT()) {
                    lisData.setSGPT(itemValue);
                }
                break;
            case "60230":
                if (null == lisData.getTP()) {
                    lisData.setTP(CaseDispose(itemValue));
                }
                break;
            case "200054":
                if (null == lisData.getTP()) {
                    lisData.setTP(CaseDispose(itemValue));
                }
                break;
            case "200053":
                if (null == lisData.getTP()) {
                    lisData.setTP(CaseDispose(itemValue));
                }
                break;
            case "60220":
                if (null == lisData.getHIV()) {
                    lisData.setHIV(CaseDispose(itemValue));
                }
                break;
            case "200051":
                if (null == lisData.getHIV()) {
                    lisData.setHIV(CaseDispose(itemValue));
                }
                break;
            case "60180":
                if (null == lisData.getHCV()) {
                    lisData.setHCV(CaseDispose(itemValue));
                }
                break;
            case "200052":
                if (null == lisData.getHCV()) {
                    lisData.setHCV(CaseDispose(itemValue));
                }
                break;
            case "200055":
                if (null == lisData.getHBsAg()) {
                    lisData.setHBsAg(CaseDispose(itemValue));
                }
                break;
        }
    }

    private String CaseDispose(String value)
    {
        if ((value.contains("阴性")) || (value.contains("阳性"))) {
            return value;
        }
        if ((value.contains("<")) || (value.contains(">")))
        {
            value = value.substring(1);
            return LisDataConvert(value);
        }
        return LisDataConvert(value);
    }

    private String LisDataConvert(String value)
    {
        try
        {
            float JG = Float.parseFloat(value);
            if (JG < 1.0D) {
                return "阴性(-)";
            }
            return "阳性(+)";
        }
        catch (Exception e) {}
        return "";
    }

    public void updatePatientLinkStatus(String hisOperId, String operStatus) {}

    public List<ConfigDepartments> getDepartmentFromHis()
    {
        Connection conn = getConnection();
        if (null == conn) {
            return null;
        }
        List<ConfigDepartments> departmentList = new ArrayList();
        String strSQL = "SELECT * FROM V_HIS_DEPT";
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        try
        {
            preparedStatement = conn.prepareStatement(strSQL);
            rs = preparedStatement.executeQuery();
            while (rs.next())
            {
                String deptName = rs.getString("NAME");

                String deptCode = rs.getString("code");
                if ((null != deptCode) && (null != deptName) && (deptCode.trim().length() != 0) && (deptName.trim().length() != 0))
                {
                    ConfigDepartments department = new ConfigDepartments();

                    department.setName(deptName);

                    department.setCode(deptCode);

                    department.setDeleted(false);

                    departmentList.add(department);
                }
            }
        }
        catch (SQLException e)
        {
            logger.error("Could not read the lcsm_ksxx table ! " + e.getMessage());
        }
        closeConnection(conn);
        return departmentList;
    }

    public Map<String, ConfigDepartments> getCodeDept()
    {
        Connection conn = getConnection();
        if (null == conn) {
            return null;
        }
        Map<String, ConfigDepartments> applyDoctMap = new HashMap();
        List<ConfigDepartments> departmentFromHis = getDepartmentFromHis();
        for (ConfigDepartments department : departmentFromHis) {
            applyDoctMap.put(department.getCode(), department);
        }
        return applyDoctMap;
    }

    public List<Account> getAccountFromHis()
    {
        Connection conn = getConnection();
        if (null == conn) {
            return null;
        }
        List<Account> accountList = new ArrayList();
        String strSQL = "SELECT * FROM V_HIS_DOCTOR_1";
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        Map<String, ConfigDepartments> codeDeptMap = getCodeDept();
        try
        {
            preparedStatement = conn.prepareStatement(strSQL);
            rs = preparedStatement.executeQuery();
            while (rs.next())
            {
                String DEPT_CODE = trimStr(rs.getString("DEPT_CODE"));
                String DOCTOR_NAME = rs.getString("DOCTOR_NAME");
                String strCode = rs.getString("DOCTOR_CODE");
                if ((null != DEPT_CODE) && (DEPT_CODE.trim().length() != 0) &&
                        (null != DOCTOR_NAME) && (DOCTOR_NAME.trim().length() != 0) &&
                        (null != strCode) && (strCode.trim().length() != 0))
                {
                    Account account = new Account();
                    if ((null != codeDeptMap) &&
                            (codeDeptMap.containsKey(DEPT_CODE))) {
                        account.setOfficeName(((ConfigDepartments)codeDeptMap.get(DEPT_CODE)).getName());
                    }

                    account.setOfficeID(DEPT_CODE);

                    account.setTrueName(DOCTOR_NAME);

                    account.setWorkID(strCode);

                    if(!strCode.equalsIgnoreCase("")){
                        account.setCanLogin(Boolean.valueOf(true));
                    }else{
                        account.setCanLogin(Boolean.valueOf(false));
                    }

                    account.setLoginName(strCode);

                    account.setPwd(accountDao.generatePassword(String.valueOf(strCode)));

                    account.setGender("male");

                    account.setSchoolLevel("本科");
                    try
                    {
                        account.setDob(new Date());
                    }
                    catch (Exception ex) {}
                    try
                    {
                        account.setInDate(new Date());
                    }
                    catch (Exception ex) {}
                    String DOCTOR_TYPE_ID = rs.getString("DOCTOR_TYPE_ID");
                    String ZC = rs.getString("ZC");
                    if (null != DOCTOR_TYPE_ID) {
                        if ("10".equals(DOCTOR_TYPE_ID))
                        {
                            account.setRole("麻醉医生");
                            account.setGender("male");
                            account.setTitle(ZC==null?"麻醉医生":ZC);
                        }
                        else if ("20".equals(DOCTOR_TYPE_ID)||"30".equals(DOCTOR_TYPE_ID))
                        {
                            if(ZC!=null||"".equalsIgnoreCase(ZC)){
                                account.setRole("麻醉医生");
                                account.setGender("female ");
                                account.setTitle(ZC);
                            }else{
                                account.setRole("护士");
                                account.setGender("female ");
                                account.setTitle("护士");
                            }
                        }
                        else
                        {
                            logger.warn(DOCTOR_TYPE_ID + " not found ...");
                        }
                    }
                    account.setStatus("valid");
                    account.setCreateTime(new Date());
                    account.setLastUpdateTime(new Date());

                    accountList.add(account);
                    logger.info("add" + account);
                }
            }
        }
        catch (SQLException e)
        {
            logger.error("Could not read the V_GY_ZHIGONGXX table ! " + e.getMessage());
        }
        catch (Exception e)
        {
            logger.fatal(" GetSet Data Error ", e);
        }
        closeConnection(conn);
        return accountList;
    }

    public static String buildInsertSQL(String tableName, Object object)
    {
        if (null == object) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" INSERT INTO " + tableName + " ( ");

        Field[] fields = object.getClass().getDeclaredFields();
        boolean isFirst = true;
        int count = 0;
        for (Field f : fields)
        {
            String fn = f.getName();
            if (!fn.contains("this"))
            {
                if (isFirst) {
                    isFirst = false;
                } else {
                    stringBuffer.append(",");
                }
                stringBuffer.append(fn);
                count++;
            }
        }
        stringBuffer.append(") VALUES ( ");

        isFirst = true;
        for (int i = 0; i < count; i++)
        {
            if (isFirst) {
                isFirst = false;
            } else {
                stringBuffer.append(",");
            }
            stringBuffer.append(" ? ");
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    public static void putData2PS(PreparedStatement ps, Object pojo)
            throws IllegalAccessException, SQLException
    {
        Field[] fields = pojo.getClass().getDeclaredFields();
        int i = 1;
        for (Field f : fields)
        {
            String fn = f.getName();
            if (!fn.contains("this"))
            {
                String t = f.getGenericType().toString();
                if (t.equals("class java.lang.String"))
                {
                    if (null != f.get(pojo)) {
                        ps.setString(i, (String)f.get(pojo));
                    } else {
                        ps.setString(i, null);
                    }
                }
                else if (t.equalsIgnoreCase("class java.lang.Integer"))
                {
                    if (null != f.get(pojo)) {
                        ps.setInt(i, ((Integer)f.get(pojo)).intValue());
                    } else {
                        ps.setString(i, null);
                    }
                }
                else if (t.equalsIgnoreCase("class java.lang.Float"))
                {
                    if (null != f.get(pojo)) {
                        ps.setFloat(i, ((Float)f.get(pojo)).floatValue());
                    } else {
                        ps.setString(i, null);
                    }
                }
                else if (t.equalsIgnoreCase("class java.util.Date"))
                {
                    if (null != f.get(pojo)) {
                        ps.setTimestamp(i, new Timestamp(((Date)f.get(pojo)).getTime()));
                    } else {
                        ps.setTimestamp(i, null);
                    }
                }
                else
                {
                    System.out.println("xxx");
                    ps.setString(i, null);
                }
                i++;
            }
        }
    }

    public boolean writeEndOper2HIS(PatientLink patientLink)
    {
        if (null == patientLink) {
            return false;
        }
        Connection conn = getConnection();
        if (null == conn) {
            return false;
        }
        PojoHISOper pojo = preparePojo(patientLink);
        if ((null == pojo) || (null == pojo.Zyh) || (null == pojo.sm_yid)) {
            return false;
        }
        String strSQL = buildInsertSQL("Sm_jk_ssxx", pojo);

        Boolean isOK = false;
        PreparedStatement ps = null;
        try
        {
            ps = conn.prepareStatement(strSQL);

            putData2PS(ps, pojo);
            int rs = ps.executeUpdate();
            int updatedCount = ps.getUpdateCount();
            if ((1 == rs) && (updatedCount == 1)) {
                isOK = true;
            } else {
                System.out.println("Update Event fail rs = " + rs + " count =" + updatedCount + ps);
            }
            return false;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            logger.error(ex.getMessage(), ex);
            logger.trace(ex.fillInStackTrace());
        }
        finally
        {
            try
            {
                if (null != ps) {
                    ps.close();
                }
                closeConnection(conn);
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
        return isOK;
    }

    public Integer find(PatientLink patientLink, Connection conn)
            throws SQLException
    {
        String strSQL = "SELECT id from Sm_jk_ssxx WHERE sm_yid = ?";
        PreparedStatement ps = conn.prepareStatement(strSQL);
        ps.setString(1, patientLink.getId());
        ResultSet rs = ps.executeQuery();
        if (null == rs) {
            return null;
        }
        Integer id = null;
        if (rs.next()) {
            id = Integer.valueOf(rs.getInt("id"));
        }
        if (null != rs) {
            rs.close();
        }
        if (null != ps) {
            ps.close();
        }
        return id;
    }

    public boolean addEndOper2HISUpateBatch(List<PatientLink> patientLinks)
    {
        if ((null == patientLinks) || (patientLinks.size() == 0)) {
            return false;
        }
        Connection conn = getConnection();
        if (null == conn) {
            return false;
        }
        try
        {
            conn.setAutoCommit(false);
            PojoHISOper pojo = new PojoHISOper();
            String strSQL = buildInsertSQL("Sm_jk_ssxx", pojo);

            PreparedStatement ps = conn.prepareStatement(strSQL);
            for (PatientLink o : patientLinks)
            {
                Integer hisID = find(o, conn);
                if (null == hisID) {
                    addBatch(o, ps);
                } else {
                    System.out.println("xxxx");
                }
            }
            int[] rs = ps.executeBatch();
            conn.commit();
            int updatedCount = ps.getUpdateCount();
            if (null != conn) {
                try
                {
                    conn.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
            return false;
        }
        catch (Exception e)
        {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
            if (null != conn) {
                try
                {
                    conn.close();
                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        finally
        {
            if (null != conn) {
                try
                {
                    conn.close();
                }
                catch (SQLException e)
                {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    public boolean addBatch(PatientLink patientLink, PreparedStatement ps)
    {
        PojoHISOper pojo = preparePojo(patientLink);
        if (null == pojo) {
            return false;
        }
        try
        {
            putData2PS(ps, pojo);

            ps.addBatch();
        }
        catch (Exception ex)
        {
            ex =




                    ex;logger.error(ex.getMessage(), ex);logger.trace(ex.getStackTrace());boolean bool = false;return bool;
        }
        finally {}
        return true;
    }

    private PojoHISOper preparePojo(PatientLink PatientLink)
    {
        PojoHISOper pojoHISOper = new PojoHISOper();
        pojoHISOper.Sqdh = PatientLink.getHisID();

        pojoHISOper.Zyh = PatientLink.getPatient().getZyh();
        pojoHISOper.Xm = PatientLink.getPatient().getBrxm();
        try
        {
            pojoHISOper.Sg = Integer.valueOf(PatientLink.getPatient().getSg());
            if (0.0F == pojoHISOper.Sg.intValue()) {
                pojoHISOper.Sg = null;
            }
        }
        catch (Exception e) {}
        try
        {
            pojoHISOper.Tz = Float.valueOf(PatientLink.getPatient().getTz());
            if (0.0F == pojoHISOper.Tz.floatValue()) {
                pojoHISOper.Tz = null;
            }
        }
        catch (Exception e) {}
        if (null != PatientLink.getStatus().getOperStartTime()) {
            pojoHISOper.Sskssj = PatientLink.getStatus().getOperStartTime();
        } else {
            pojoHISOper.Sskssj = PatientLink.getStatus().getInRoomTime();
        }
        if (null != PatientLink.getStatus().getOperEndTime()) {
            pojoHISOper.Ssjssj = PatientLink.getStatus().getOperEndTime();
        } else {
            pojoHISOper.Ssjssj = PatientLink.getStatus().getOutRoomTime();
        }
        pojoHISOper.sssc = Integer.valueOf((int)PatientLink.getStatus().getOperSpanTime());
        if (null != PatientLink.getStatus().getMazuiStartTime()) {
            pojoHISOper.mzkssj = PatientLink.getStatus().getMazuiStartTime();
        } else {
            pojoHISOper.mzkssj = PatientLink.getStatus().getInRoomTime();
        }
        if (null != PatientLink.getStatus().getMazuiEndTime()) {
            pojoHISOper.mzjssj = PatientLink.getStatus().getMazuiEndTime();
        } else {
            pojoHISOper.mzjssj = PatientLink.getStatus().getOutRoomTime();
        }
        pojoHISOper.mzsc = Integer.valueOf((int)PatientLink.getStatus().getMazuiSpanTime());

//        pojoHISOper.mzqyy = PatientLink.getOperInfo().getShuQianYongYao();
        pojoHISOper.ssssmc = PatientLink.getAnesthesiaRecord().getYsss1();
        pojoHISOper.Shzd = PatientLink.getAnesthesiaRecord().getShzd1();
        pojoHISOper.Szgr = Integer.valueOf(0);
        pojoHISOper.szgrbw = "";

        pojoHISOper.Sfsx = Integer.valueOf(0);
        pojoHISOper.sxfy = "";

        pojoHISOper.Szxw = Integer.valueOf(0);
        pojoHISOper.sfmzbfz = Integer.valueOf(0);

        pojoHISOper.mzfbz = "";


        pojoHISOper.mzfsmc = PatientLink.getAnesthesiaRecord().getMzff();



        pojoHISOper.xx = PatientLink.getPatient().getXx();

//        AccountDao accountDao = (AccountDao)BeanCache.getInstance().getBean(AccountDao.class);
        if (null != PatientLink.getAnesthesiaRecord().getZmys()) {
            try
            {
                pojoHISOper.mzys1 = accountDao.findAccountById(PatientLink.getAnesthesiaRecord().getZmys()).getTrueName();
            }
            catch (Exception e) {}
        }
        if (null != PatientLink.getAnesthesiaRecord().getFmys1()) {
            try
            {
                pojoHISOper.mzys2 = accountDao.findAccountById(PatientLink.getAnesthesiaRecord().getFmys1()).getTrueName();
            }
            catch (Exception e) {}
        }
        if (null != PatientLink.getAnesthesiaRecord().getFmys2()) {
            try
            {
                pojoHISOper.mzys3 = accountDao.findAccountById(PatientLink.getAnesthesiaRecord().getFmys2()).getTrueName();
            }
            catch (Exception e) {}
        }
        if (null != PatientLink.getAnesthesiaRecord().getFmys3()) {
            try
            {
                pojoHISOper.mzys4 = accountDao.findAccountById(PatientLink.getAnesthesiaRecord().getFmys3()).getTrueName();
            }
            catch (Exception e) {}
        }
        pojoHISOper.ssys1 = PatientLink.getAnesthesiaRecord().getOperDoctor1();


        pojoHISOper.ssys2 = PatientLink.getAnesthesiaRecord().getOperDoctor2();


        pojoHISOper.Ssys3 = PatientLink.getAnesthesiaRecord().getOperDoctor3();


        pojoHISOper.xhhs = PatientLink.getAnesthesiaRecord().getXhhs1();

        if (PatientLink.getAnesthesiaRecord().getPCIA()) {
            pojoHISOper.shztfs = "PCIA";
        } else if (PatientLink.getAnesthesiaRecord().getPCNA()) {
            pojoHISOper.shztfs = "PCNA";
        } else if (PatientLink.getAnesthesiaRecord().getPCEA()) {
            pojoHISOper.shztfs = "PCEA";
        }

        pojoHISOper.sm_yid = PatientLink.getId();

        return pojoHISOper;
    }

    @Override
    public boolean writeOperSchedule2HISUpateBatch(List<PatientLink> patientLinks) {
        return super.writeOperSchedule2HISUpateBatch(patientLinks);
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

    class PojoHISOper
    {
        String Sqdh = null;
        String Shdh = null;
        String Zyh = null;
        String Xm = null;
        Integer Sg = null;
        Float Tz = null;
        Date Sskssj = null;
        Date Ssjssj = null;
        Integer sssc = null;
        Date mzkssj = null;
        Date mzjssj = null;
        Integer mzsc = null;
        String mzqyy = null;
        String ssssmc = null;
        String Shzd = null;
        Integer Szgr = null;
        String szgrbw = null;
        Float sxHxb = null;
        Float sxXxb = null;
        Float sxXj = null;
        Float sxqx = null;
        Float Sxztx = null;
        Float Sxbdb = null;
        Float Sxqt = null;
        Integer Sfsx = null;
        String sxfy = null;
        Integer Szxw = null;
        Integer sfmzbfz = null;
        String mzfbz = null;
        String qkdm = null;
        String yhdm = null;
        Integer wsqyy = null;
        Integer qkyw = null;
        String mzfsdm = null;
        String mzfsmc = null;
        String ssjb = null;
        String xx = null;
        String mzys1 = null;
        String mzysdm1 = null;
        String mzys2 = null;
        String mzysdm2 = null;
        String mzys3 = null;
        String mzysdm3 = null;
        String mzys4 = null;
        String mzysdm4 = null;
        String ssys1 = null;
        String ssysdm1 = null;
        String ssys2 = null;
        String ssysdm2 = null;
        String Ssys3 = null;
        String Ssysdm3 = null;
        String Ssys4 = null;
        String Ssysdm4 = null;
        String xhhs = null;
        String xhhsdm = null;
        String shztfs = null;
        String ylzh = null;
        String sm_yid = null;

        PojoHISOper() {}
    }
}





