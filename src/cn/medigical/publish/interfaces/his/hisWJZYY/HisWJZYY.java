package cn.medigical.publish.interfaces.his.hisWJZYY;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.mysql.jdbc.CallableStatement;
import com.sun.org.apache.regexp.internal.recompile;

import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigDepartmentsDao;
import cn.medigical.publish.dao.impl.wjzyy.HisAnesMethodDao;
import cn.medigical.publish.interfaces.his.hisLink.HisLink;
import cn.medigical.publish.interfaces.his.hisLink.PojoBGA;
import cn.medigical.publish.interfaces.his.hisLink.StatustToHis;
import cn.medigical.publish.interfaces.his.hisPLXYY.HisLinkPLXYY;
import cn.medigical.publish.interfaces.lis.LisData;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.dictionary.ConfigDepartments;
import cn.medigical.publish.pojo.lis.JianYan;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.pojo.wjzyy.HisAnesMethod;
import cn.medigical.publish.utils.Constants;
import cn.medigical.publish.utils.MyConstants;
import cn.medigical.publish.utils.MyDateFormat;
import cn.medigical.publish.utils.SpringUtils;

public class HisWJZYY extends HisLink {

	public static final String MAZUIKEMINGCHENG = "手术麻醉科";// 麻醉科名称
    public static final String SHOUSHUSHI = "手术室";
    private static HisWJZYY instance;

    AccountDao accountDao = SpringUtils.getBean(AccountDao.class);
    ConfigDepartmentsDao configDepartmentsDao=SpringUtils.getBean(ConfigDepartmentsDao.class);
    PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);
    HisAnesMethodDao hisAnesMethodDao=SpringUtils.getBean(HisAnesMethodDao.class);
    String keShiID;// 科室编号
    String driverName = "oracle.jdbc.driver.OracleDriver";
    String dbIP = "192.168.0.2";
    String url = "jdbc:oracle:thin:@//192.168.0.2:1521/orcl";
    String username = "bcsm";
    String password = "bcsm";

    public static HisWJZYY getInstance() {
        if (instance == null) {
            instance = new HisWJZYY();
        }
        return instance;
    }

    @Override
    public List<PatientLink> getOprationFromHis() {
        Connection conn = getConnection();
        if (null == conn) {
            return null;
        }
        List<PatientLink> operationList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateNow = new Date();
        Date dateFrom = new Date(dateNow.getTime() - MyConstants.ONE_DAY_LONG * 3);// 3天前时间的时间
        String threeDaysAgo = sdf.format(dateFrom);
        // String strSQL = "select a.* from djhis.v_ssmz_operation_apply a WHERE cc TO_DATE('"+threeDaysAgo+"','YYYY-MM-DD HH24:MI:SS')";
        // WHERE SHENQINGSJ > TO_DATE('"+threeDaysAgo+"','YYYY-MM-DD HH24:MI:SS')
        // String strSQL = "SELECT * FROM V_OPERINFO where SHENQINGSJ > dateadd(day,-3,convert(varchar(100),getdate(),20))";//sql server
      //  String strSQL = "SELECT * FROM V_OPERINFO where TO_DATE(SHENQINGSJ, 'yyyy-mm-dd HH24:MI:SS') > sysdate-3 ORDER BY SHENQINGSJ DESC";// sql server
        // String strSQL = "SELECT * FROM V_OPERINFO WHERE CONVERT (VARCHAR (12),SHENQINGSJ,112)>CONVERT (VARCHAR (12),GETDATE()-3,112 )";
        // String strSQL = "SELECT * FROM V_OPERINFO ";
        //接口为Orccale，条件为时间类型
         String strSQL="select * from V_OPERINFO where SHENQINGSJ >= trunc(sysdate - 12)";
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(strSQL);
            logger.info(strSQL);
            rs = preparedStatement.executeQuery();
            int count = 0;
            List<Account> accountList = accountDao.getAll();
            while (rs.next()) {
                PatientLink patientLink = getOperation(rs, conn, accountList);
                if (null != patientLink) {
                    operationList.add(patientLink);
                }
                count++;
            }
            logger.info("get oper request count = " + count);
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        closeConnection(conn);
        updateAnesMethodFromHis();
        return operationList;
    }

    //温江中医院更新his麻醉方式
    private void updateAnesMethodFromHis() {
    	 Connection conn = getConnection();
         if (null == conn) {
             return;
         }
         List<HisAnesMethod> anesMethodList=new ArrayList<>();
         String strSQL = "SELECT a.* FROM v_anesthesia a";
         ResultSet rs = null;
         PreparedStatement preparedStatement = null;
         try {
        	  
        	   preparedStatement = conn.prepareStatement(strSQL);
               rs = preparedStatement.executeQuery();
               while (rs.next()) {
               String code=rs.getString("ID");
               String name=rs.getString("名称");
               String unit=rs.getString("计算单位");
               String type=rs.getString("操作类型");
               HisAnesMethod anesMethod=new HisAnesMethod();
               anesMethod.setCode(trimStr(code));
               anesMethod.setName(trimStr(name));
               anesMethod.setUnit(trimStr(unit));
               anesMethod.setType(trimStr(type));
              if (!exitAnesMethod(anesMethod)) {
				hisAnesMethodDao.addUpdate(anesMethod);
			}
        	  }
		} catch (SQLException e) {
            logger.error(e.getMessage(), e);
		}
	}

	private boolean exitAnesMethod(HisAnesMethod anesMethod) {
		List<HisAnesMethod> list=hisAnesMethodDao.getAll();
		boolean flag=false;
		if (list!=null && list.size()>0) {
			for (HisAnesMethod hisAnesMethod : list) {
				if (anesMethod.getCode().equals(hisAnesMethod.getCode())) {
					flag=true;
					break;
				}
			}
		}
		return flag;
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

    public void updateOperationStatus(String id) {
    	PatientLink patientLink=patientLinkDao.getPatientById(id);
    	if (patientLink==null || !isEmpty(patientLink)) {
			return;
		}
    	logger.info("the patient is return hisid:"+patientLink.getHisID()+"===名字："+patientLink.getPatient().getBrxm());
    	 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	StatustToHis statustToHis=getStatusForHis(patientLink);
    	logger.info("wjzyy updateOperSatusing this staus="+statustToHis.getStatus()+"//状态 1-完全执行;2-拒绝执行;3-正在执行;4-取消拒绝执行");
    	Connection connection=	getConnection();
    	java.sql.CallableStatement statement =null;
    	String sql="";
			sql="{call zl_cbsm_status(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			try {
				StringBuffer buffer=new StringBuffer();
				statement=connection.prepareCall(sql);
				statement.setInt(1, Integer.parseInt(statustToHis.getOperId()));
				buffer.append(statustToHis.getOperId());
				
				statement.setInt(2, statustToHis.getStatus());
				buffer.append(","+statustToHis.getStatus());
				
				statement.setInt(3, statustToHis.getPbts());
				buffer.append(","+statustToHis.getPbts());
				
				statement.setString(4, getStringTime(statustToHis.getOperPlanStartTime()));
//				statement.setDate(4,  new java.sql.Date(statustToHis.getOperPlanStartTime().getTime()) );
				buffer.append(",'"+ getStringTime(statustToHis.getOperPlanStartTime()));
				
				
				statement.setString(5, getStringTime(statustToHis.getOperStartTime()));
//				statement.setDate(5,  new java.sql.Date(statustToHis.getOperStartTime().getTime()) );
				buffer.append("','"+getStringTime(statustToHis.getOperStartTime()));
				
				statement.setString(6,  getStringTime(statustToHis.getOperEndTime()));
//				statement.setDate(6,  new java.sql.Date(statustToHis.getOperEndTime().getTime()) );
				buffer.append("','"+getStringTime(statustToHis.getOperEndTime()));
				
				statement.setString(7,  statustToHis.getOperRoom());
				buffer.append("','"+statustToHis.getOperRoom());
				
				statement.setString(8, statustToHis.getAnesDoctorName());
				buffer.append("','"+statustToHis.getAnesDoctorName());
				
				statement.setString(9, statustToHis.getAnesDoctor1Name());
				buffer.append("','"+statustToHis.getAnesDoctor1Name());
				
				statement.setString(10,  getStringTime(statustToHis.getAnesStartTime()));
//				statement.setDate(10,  new java.sql.Date(statustToHis.getAnesStartTime().getTime()) );
				buffer.append("','"+getStringTime(statustToHis.getAnesStartTime()));
				
				statement.setString(11, getStringTime(statustToHis.getAnesEndTime()));
//				statement.setDate(11,  new java.sql.Date(statustToHis.getAnesEndTime().getTime()) );
				buffer.append("','"+getStringTime(statustToHis.getAnesEndTime()));
				
				statement.setString(12,statustToHis.getAnesMethod());
				buffer.append("','"+statustToHis.getAnesMethod());
				
				statement.setString(13,statustToHis.getAnesType());
				buffer.append("','"+statustToHis.getAnesType());
				
				statement.setString(14, statustToHis.getOperDoctorName());
				buffer.append("','"+statustToHis.getOperDoctorName());
				
				statement.setString(15, statustToHis.getOperDoctor1Name());
				buffer.append("','"+statustToHis.getAnesDoctor1Name());
				
				statement.setString(16,statustToHis.getOperDoctor2Name());
				buffer.append("','"+statustToHis.getOperDoctor2Name());
				
				statement.setString(17, statustToHis.getCancelReason());
				buffer.append("','"+statustToHis.getCancelReason());
				
				statement.setString(18, statustToHis.getCancelPeopleName());
				buffer.append("','"+statustToHis.getCancelPeopleName());
				
				statement.setString(19,statustToHis.getOperQiekou());
				buffer.append("','"+statustToHis.getOperQiekou());
				
				statement.setString(20, statustToHis.getOperType());
				buffer.append("','"+statustToHis.getOperType());
				
				statement.setString(21,statustToHis.getAsa());
				buffer.append("','"+statustToHis.getAsa());
				
				statement.setString(22,statustToHis.getOperName());
				buffer.append("','"+statustToHis.getOperName());
				
				statement.setString(23, statustToHis.getQieKouBuwei());
				buffer.append("','"+statustToHis.getQieKouBuwei()+"'");
				logger.info("sql:"+"{call zl_cbsm_status("+buffer.toString()+")}");
//				statement.execute(sql);
				statement.execute();
				logger.info("执行完成！");
				connection.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    private boolean isEmpty(PatientLink patientLink) {
		if (patientLink==null) {
			return false;
		}
		if (patientLink.getHisID()==null || ("").equals(patientLink.getHisID())) {
			return false;
		}else {
			return true;
		}
	}

	//状态 1-完全执行;2-拒绝执行;3-正在执行;4-取消拒绝执行
    private StatustToHis getStatusForHis(PatientLink patientLink) {
		StatustToHis statustToHis=new StatustToHis();
		statustToHis.setOperId(trimStr(patientLink.getHisID()));
		if (patientLink.getApplication().getDetailstatus().equals(Constants.OR_STATUS_FLAG_IN_ROOM)) {
			statustToHis.setStatus(3);
		}
		if (patientLink.getApplication().getDetailstatus().equals(Constants.OR_STATUS_FLAG_OUT_ROOM)) {
			statustToHis.setStatus(1);
		}
		if (patientLink.getApplication().getDetailstatus().equals(Constants.OR_STATUS_FLAG_DISCHARGED)) {
			statustToHis.setStatus(2);
		}
		statustToHis.setPbts(patientLink.getSchedule().getPbtsInt());
		statustToHis.setOperPlanStartTime(patientLink.getSchedule().getJhsssj());
		statustToHis.setOperRoom(trimStr(patientLink.getSchedule().getPbssjh()));
		statustToHis.setAnesDoctorName(getTrueNameByid(patientLink.getAnesthesiaRecord().getZmys()));
		statustToHis.setAnesDoctor1Name(getTrueNameByid(patientLink.getAnesthesiaRecord().getFmys1()));
		statustToHis.setOperDoctorName(getTrueNameByid(patientLink.getAnesthesiaRecord().getOperDoctor1()));
		statustToHis.setOperDoctor1Name(getTrueNameByid(patientLink.getAnesthesiaRecord().getOperDoctor2()));
		statustToHis.setOperDoctor2Name(getTrueNameByid(patientLink.getAnesthesiaRecord().getOperDoctor3()));
		statustToHis.setCancelReason("");
		statustToHis.setCancelPeopleName("");
		statustToHis.setOperStartTime(patientLink.getStatus().getInRoomTime());
		statustToHis.setOperEndTime(patientLink.getStatus().getOutRoomTime());
		statustToHis.setOperName(patientLink.getAnesthesiaRecord().getYsss1());
		statustToHis.setAnesStartTime(patientLink.getStatus().getMazuiStartTime());
		statustToHis.setAnesEndTime(patientLink.getStatus().getMazuiEndTime());
		statustToHis.setAnesMethod(getAnesMethodCodeByName(patientLink.getAnesthesiaRecord().getMzff()));
		statustToHis.setAnesType(getAnesMethodTypeByName(patientLink.getAnesthesiaRecord().getMzff()));
		statustToHis.setOperQiekou("");
		if (patientLink.getAnesthesiaRecord().getAsa().getJz()) {
			statustToHis.setOperType("急诊");
		}else {
			statustToHis.setOperType("择期");
		}
		statustToHis.setAsa(patientLink.getAnesthesiaRecord().getAsa().getLevel());
		statustToHis.setQieKouBuwei("");
		return statustToHis;
	}

	private String getAnesMethodCodeByName(String mzff) {
		if (mzff==null || ("").equals(mzff)) {
			return "";
		}
		else {
			HisAnesMethod hisAnesMethod= hisAnesMethodDao.getAnesMethodByName(mzff);
			if (hisAnesMethod==null) {
				return "";
			}else {
				if (hisAnesMethod.getCode()==null || ("").equals(hisAnesMethod.getCode())) {
					return "";
				}else {
					return hisAnesMethod.getCode();
				}
			}
		}
	}
	private String getAnesMethodTypeByName(String mzff) {
		if (mzff==null || ("").equals(mzff)) {
			return "";
		}
		else {
			HisAnesMethod hisAnesMethod= hisAnesMethodDao.getAnesMethodByName(mzff);
			if (hisAnesMethod==null) {
				return "";
			}else {
				if (hisAnesMethod.getCode()==null || ("").equals(hisAnesMethod.getCode())) {
					return "";
				}else {
					return hisAnesMethod.getType();
				}
			}
		}
	}

	@Override
    public List<ConfigDepartments> getDepartmentFromHis() {
        Connection conn = getConnection();
        if (null == conn) {
            return null;
        }
        List<ConfigDepartments> departmentList = new ArrayList<>();
        String strSQL = "SELECT a.* FROM V_DEPT a";
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(strSQL);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // 科室ID
                String KESHIID = rs.getString("KESHIID");
                String KESHIMC = rs.getString("KESHIMC");
                if (KESHIID == null || KESHIID.equals("")) {
                    continue;
                }
                if (KESHIMC == null || KESHIMC.equals("")) {
                    continue;
                }
                ConfigDepartments department = new ConfigDepartments();
                // 科室名称
                department.setName(KESHIMC);
                // 科室编号
                department.setCode(KESHIID);
                department.setDeleted(false);
                boolean exit=someDepts(department);
                if (exit) {
                	 departmentList.add(department);
				}
               //System.out.println(department);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }

        closeConnection(conn);
        configDepartmentsDao.addAll(departmentList);
        return departmentList;
    }

    private boolean someDepts(ConfigDepartments configDepartments) {
    	boolean flag=true;
    	if (configDepartmentsDao.getAll()!=null && configDepartmentsDao.getAll().size()>0) {
	
    	for (ConfigDepartments configDepartments2 : configDepartmentsDao.getAll()) {
			if (configDepartments.getCode().equals(configDepartments2.getCode())) {
				flag=false;
				break;
			}
		}
    	}
		return flag;
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
    public List<Account> getAccountFromHis() {
        Connection conn = getConnection();
        if (null == conn) {
            return null;
        }
        List<Account> accountList = new ArrayList<>();
        keShiID = getDeptCode();
        String strSQL = "SELECT a.* FROM V_EMP a ";
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(strSQL);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Account account = getOneAccount(rs);
                System.out.println(account);
                if (null != account) {
                	boolean exit= someAccount(account);
                	if (exit) {
                		accountList.add(account);
					}
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }

        closeConnection(conn);
        accountDao.addAll(accountList);
        return accountList;
    }

    private boolean someAccount(Account account) {
		boolean flag=true;
		if (accountDao.getAll()!=null && accountDao.getAll().size()>0) {
		for (Account account2 : accountDao.getAll()) {
			if (account.getWorkID().equals(account2.getWorkID())) {
				flag=false;
				break;
			}
		}
		}
		return flag;
	}

	private Account getOneAccountFromHis(String accountCode, Connection conn) {
        if (null == conn || null == accountCode || accountCode.length() == 0) {
            return null;
        }

        String strSQL = "SELECT a.* FROM V_EMP a WHERE a.ZHIGONGGH = " + accountCode;
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(strSQL);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Account account = getOneAccount(rs);
                if (null != account) {
                    return account;
                }
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }

        return null;
    }

    private Account getOneAccount(ResultSet rs) throws SQLException {
        if (rs == null) {
            return null;
        }

        String ZHIGONGXM = rs.getString("ZHIGONGXM");
        String strCode = rs.getString("ZHIGONGGH");
        String strDept = rs.getString("KESHIMC");// 部门名称
        String strDeptCode = rs.getString("KESHIID");// 部门编号

        if (null == strCode || null == ZHIGONGXM ||
                /*
                 * null == strDept || null == strDeptCode ||
                 */
                ZHIGONGXM.trim().length() == 0 || strCode.trim().length() == 0
            /*
             * strDept.trim().length() == 0|| strDeptCode.trim().length() == 0
             */
                ) {
            return null;
        }

        Account account = new Account();

        // 科室名称
        account.setOfficeName(strDept);

        // 职工科室编号
        account.setOfficeID(strDeptCode);

        // 职工姓名
        account.setTrueName(ZHIGONGXM);
        // 职工工号
        account.setWorkID(strCode);
        // 登录名
        account.setLoginName(strCode);
        account.setPwd(accountDao.generatePassword(String.valueOf(strCode)));

        // 职工性别
        String srcSex = trimStr(rs.getString("XINGBIE"));
        String sex = null;
        if (null != srcSex) {
            if (srcSex.equalsIgnoreCase("男")) {
                sex = MyConstants.MALE;
            } else if (srcSex.equalsIgnoreCase("女")) {
                sex = MyConstants.FEMALE;
            }
        }
        account.setGender(sex);

        // 默认都让登陆
        account.setCanLogin(true);

        // 职工职位
        String zgzw = trimStr(rs.getString("ZHIGONGLB"));
        if (null != zgzw) {
            if (!zgzw.contains("护师") && (zgzw.contains("主任") || zgzw.contains("医师") || zgzw.contains("医生") || zgzw.contains("教授") || zgzw.contains("医士"))) {
                if (keShiID == null || "".equals(keShiID))
                    try {
                        new Exception();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                if (strDeptCode.equalsIgnoreCase(keShiID)) {
                    account.setRole(MyConstants.MAZUI_DOCTOR);
                } else {
                    account.setRole(MyConstants.DOCTOR);
                }
            } else if (zgzw.contains("护士") || zgzw.contains("护理") || zgzw.contains("护师")) {
                account.setRole(MyConstants.HUSHI);
            } else {
                account.setRole(MyConstants.OTHER_STUFF);
                account.setCanLogin(false);
            }
            account.setTitle(zgzw);
        }

        // //学历
        account.setSchoolLevel("本科");
        // //出生日期
        try {
            // java.util.Date dob = new java.util.Date(rs.getTimestamp("CSRQ").getTime());
            account.setDob(new Date());
        } catch (Exception ex) {
        }
        // 入职日期
        // try {
        // Timestamp t = rs.getTimestamp("CJGZSJ");
        // if( null != t){
        // account.setInDate( new Date(t.getTime()));
        // }
        // } catch (Exception ex) {
        // }

        account.setStatus("valid");
        account.setCreateTime(new Date());
        account.setLastUpdateTime(new Date());

        return account;
    }

    @Override
    public LisData getLisData(String zyh, String name) {
        Connection conn = getConnection();
        if (null == conn) {
            return null;
        }
        LisData lisData = new LisData();
        String strSQL = "SELECT * FROM V_LIS_REP where MRN = '" + zyh + "' ORDER BY AUTHTIME desc";
        // String strSQL = "SELECT * FROM `1` where MRN = '" + zyh + "' ORDER BY AUTHTIME desc";
        ResultSet rs = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(strSQL);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                if (lisData.isFullData())
                    break;
                getLisResult(conn, lisData, rs);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        closeConnection(conn);
        return lisData;
    }

    private void getLisResult(Connection conn, LisData lisData, ResultSet rs) throws SQLException {
        if (rs == null)
            return;
        String jy_id = rs.getString("REPORTID");
        if (jy_id == null)
            jy_id = "";
        jy_id = jy_id.trim();
        String strSQL = "SELECT * FROM V_LIS_REPITEMS where EXAMID = '" + jy_id + "' ORDER BY AUTHTIME DESC";
        // String strSQL = "SELECT * FROM `2` where EXAMID = '" + jy_id + "'";
        ResultSet rsRet = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(strSQL);
            rsRet = preparedStatement.executeQuery();
            while (rsRet.next()) {
                String itemCode = rsRet.getString("ITEMSHORTNAME");
                if (itemCode == null)
                    itemCode = "";
                itemCode = itemCode.trim();
                String value = rsRet.getString("RESULT");
                if (value == null)
                    value = "";
                value = value.trim();
            }
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    /*
     * private void setLisData(LisData lisData, String itemCode, String itemValue) { switch (itemCode) { case "W_HGB": if(null==lisData.getHb()){ lisData.setHb(itemValue); } break; case "W_HCT": if(null==lisData.getHCT()){ lisData.setHCT(itemValue); } break; case "W_WBC": if(null==lisData.getWBC()){ lisData.setWBC(itemValue); } break; case "W_PLT": if(null==lisData.getPLT()){ lisData.setPLT(itemValue); } break; case "SH_K": if(null==lisData.getK()){ lisData.setK(itemValue); } break; case "SH_Na": if(null==lisData.getNa()){ lisData.setNa(itemValue); } break; case "SH_Cl": if(null==lisData.getCL()){ lisData.setCL(itemValue); } break; case "SH_GLU": if(null==lisData.getGLU()){ lisData.setGLU(itemValue); } break; case "SH_ALT": if(null==lisData.getSGPT()){ lisData.setSGPT(itemValue); } break;
     * case "SH_BUN": if(null==lisData.getBUN()){ lisData.setBUN(itemValue); } break; case "SH_CREA": if(null==lisData.getCr()){ lisData.setCr(itemValue); } break; case "XN_PT": if(null==lisData.getPT()){ lisData.setPT(itemValue); } break; case "XN_APTT": if(null==lisData.getAPTT()) { lisData.setAPTT(itemValue); } break; // case "XQ_pO2": // if(null==lisData.getPAO2()) { // lisData.setPAO2(itemValue); // } // break; default: break; } }
     */

    @Override
    public String getMazuiDocDeptCode() {
        String value = getDeptCode();
        if (value == null || "".equals(value))
            try {
                new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        return value;
    }

    /**
     * 获取麻醉科（手术）的编号
     *
     * @return
     */
    private String getDeptCode() {
        Connection conn = getConnection();
        if (null == conn) {
            return null;
        }

        String strSQL = "SELECT KESHIID from V_DEPT WHERE KESHIMC='" + MAZUIKEMINGCHENG + "'";
        ResultSet rs = null;
        String value = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conn.prepareStatement(strSQL);
            rs = preparedStatement.executeQuery();
            rs.next();
            value = rs.getString("KESHIID");
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        closeConnection(conn);
        return value;
    }

    @Override
    public String getMazuiDocDeptName() {
        return MAZUIKEMINGCHENG;
    }

    @Override
    public String getNurseDeptCode() {
        String value = getDeptCode();
        if (value == null || "".equals(value))
            try {
                new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        return value;
    }

    @Override
    public String getNurseDeptName() {
        return SHOUSHUSHI;
    }

    @Override
    public boolean isBGAEnable() {
        return false;
    }

    @Override
    public List<PojoBGA> getBGA(String zyh, Date startTime, Date endTime) {
        return null;
    }

    private Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driverName.trim());
            connection = DriverManager.getConnection(url, username, password);
            logger.info("Connect to HIS Oracle ok. @" + dbIP);
        } catch (Exception ex) {
            logger.fatal(ex.getMessage(), ex);
        }

        return connection;
    }

    private void closeConnection(Connection connection) {
        if (null != connection) {
            try {
                connection.close();
            } catch (SQLException e) {
                logger.error(e.getMessage(), e);
            }
        }
    }

    private PatientLink getOperation(ResultSet rs, Connection conn, List<Account> accountList) throws SQLException {
        if (rs == null) {
            return null;
        }
        String id = rs.getString("SHOUSHUDID");// 手术单ID
        if (null == id || id.trim().length() == 0) {
            return null;
        }

        String status = rs.getString("SHOUSHUZT");
        if ("已作废".equals(status)) {
            return null;
        }

        PatientLink patientLink = new PatientLink();
        // 手术申请ID
        patientLink.getApplication().setSssqdh(id);// 申请单号

        // PatientLink.setBedsideShow(((DefaultBedsideShow)BeanCache.getInstance().getBean("DefaultBedsideShow")).getDefault());

        patientLink.setHisID(id);

        // 手术状态
        patientLink.getApplication().setStatus(Constants.AP_STATUS_MAZUIQIAN);
        // 明细状态
        patientLink.getApplication().setDetailstatus(Constants.OR_STATUS_FLAG_APPLIED);
        // 患者状态
        patientLink.getPatient().setStatus(Constants.FLAG_VALID);

        patientLink.getPatient().setBrxm(trimStr(rs.getString("BINGRENXM")));// 病人姓名
        patientLink.getPatient().setZyh(trimStr(rs.getString("ZHUYUANHAO"))); // HIS端住院号
        String bingqu = rs.getString("BQMC");
        patientLink.getPatient().setBqmc(bingqu);

        String srcSex = trimStr(rs.getString("XINGBIE"));// 性别
        patientLink.getPatient().setXb(srcSex);

        Date now = new Date();

        // 年龄
        String strAge = trimStr(rs.getString("NIANLING"));
        if (strAge.contains("岁") || strAge.contains("月") || strAge.contains("天")) {
            patientLink.getPatient().setNl(strAge);// 年龄
            if (strAge.contains("岁")) {
                try {
                    patientLink.getPatient().setNldw(MyConstants.AGE_UNIT_YEAR);// 年龄单位
                    Integer numAge = Integer.parseInt(strAge.substring(0, strAge.indexOf("岁")));
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
            patientLink.getPatient().setNl(strAge + "岁");// 年龄
            try {
                Integer numAge = Integer.parseInt(strAge.trim());
                patientLink.getPatient().setNumAge(numAge);
                patientLink.getPatient().setNldw(MyConstants.AGE_UNIT_YEAR);// 年龄单位
                now.setYear(now.getYear() - numAge);
                patientLink.getPatient().setDob(now);
            } catch (Exception e) {
            }
        }
        if (null == patientLink.getPatient().getNldw()) {
            patientLink.getPatient().setNldw(MyConstants.AGE_UNIT_MONTH);// 年龄单位
        }

        // 住院床号
        String b = trimStr(rs.getString("BINGRENCW"));
        if (b.length() > 4) {
            b = b.substring(4, b.length());
        }
        patientLink.getPatient().setZych(b);

        // 住院科室
        patientLink.getApplication().setSqksmc(trimStr(rs.getString("SHENQINGKSMC")));// 申请科室名称
        patientLink.getApplication().setSqksbh(trimStr(rs.getString("SHENQINGKS")));// 申请科室编号

        // 拟施手术
        patientLink.getApplication().setNsssmc(trimStr(rs.getString("SHOUSHUMC")));// 拟施手术名称
        patientLink.getApplication().setNsssmc1(trimStr(rs.getString("SHOUSHUMC1")));
        patientLink.getApplication().setNsssmc2(trimStr(rs.getString("SHOUSHUMC2")));
        patientLink.getApplication().setNsssmc3(trimStr(rs.getString("SHOUSHUMC3")));

        // 计划手术时间
        try {
            Date planOperTime = new Date(Timestamp.valueOf(rs.getString("yaoqiusj")).getTime());// 计划手术时间
            patientLink.getApplication().setYysssj(planOperTime);
            patientLink.getSchedule().setJhsssj(planOperTime);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        try {
            // String applyTime =rs.getString("SHENQINGSJ");
            // Date applyOperTime = MyDateFormat.DATE_FORMAT_YMDHM.parse(applyTime);
            SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = df.format(dfs.parse(rs.getString("SHENQINGSJ")));
            Timestamp ts = Timestamp.valueOf(time);
            Date applyOperTime = new Date(ts.getTime());// 手术申请时间
            patientLink.getApplication().setSssqsj(applyOperTime);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        

        // his有3个术前诊断
        patientLink.getApplication().setSqzd1(trimStr(rs.getString("ZHENDUANMC1")));
        patientLink.getApplication().setMzfs("");
        try {
            String applyDoctorID = rs.getString("SHOUSHUYS").trim();
            patientLink.getApplication().setSsysxm(convertCodeToId(applyDoctorID, accountList, conn));
        } catch (Exception e) {
        }
        try {
            String Doctor1ID = rs.getString("ZHULIYS1").trim();
            patientLink.getApplication().setZlysbh1(convertCodeToId(Doctor1ID, accountList, conn));// 主刀医生
        } catch (Exception e) {
        }
        try {
            String Doctor2ID = rs.getString("ZHULIYS2").trim();
            patientLink.getApplication().setZlysbh2(convertCodeToId(Doctor2ID, accountList, conn));
        } catch (Exception e) {
        }
        try {
            String Doctor3ID = rs.getString("ZHULIYS3").trim();
            patientLink.getApplication().setZlysbh3(convertCodeToId(Doctor3ID, accountList, conn));
        } catch (Exception e) {
        }

        // 宁陕医院在his进行排班
        // 麻醉医生
//        try {
//            String MaZuiDC1ID = rs.getString("MAZUIDC1").trim();
//            patientLink.getSchedule().setMzysbh1(convertCodeToId(MaZuiDC1ID, accountList, conn));
//        } catch (Exception e) { 
//        }
//        try {
//            String MaZuiDC2ID = rs.getString("MAZUIDC2").trim();
//            patientLink.getSchedule().setMzysbh2(convertCodeToId(MaZuiDC2ID, accountList, conn));
//        } catch (Exception e) {
//        }
//        try {
//            String MaZuiDC3ID = rs.getString("MAZUIDC3").trim();
//            patientLink.getSchedule().setMzysbh3(convertCodeToId(MaZuiDC3ID, accountList, conn));
//        } catch (Exception e) {
//        }
//        // 机械护士
//        try {
//            String JXnurse1ID = rs.getString("JXHS1").trim();
//            patientLink.getSchedule().setQxhsbh1(convertCodeToId(JXnurse1ID, accountList, conn));
//        } catch (Exception e) {
//        }
//        try {
//            String JXnurse2ID = rs.getString("JXHS2").trim();
//            patientLink.getAnesthesiaRecord().setXshs1(convertCodeToId(JXnurse2ID, accountList, conn));
//        } catch (Exception e) {
//        }
//        try {
//            String JXnurse3ID = rs.getString("JXHS3").trim();
//            patientLink.getAnesthesiaRecord().setXshs2(convertCodeToId(JXnurse3ID, accountList, conn));
//        } catch (Exception e) {
//        }
//        // 巡回护士
//        try {
//            String XHnurse1ID = rs.getString("XHHS1").trim();
//            patientLink.getSchedule().setXhhsbh1(convertCodeToId(XHnurse1ID, accountList, conn));
//        } catch (Exception e) {
//        }
//        try {
//            String XHnurse2ID = rs.getString("XHHS2").trim();
//            patientLink.getAnesthesiaRecord().setXhhs1(convertCodeToId(XHnurse2ID, accountList, conn));
//        } catch (Exception e) {
//        }
//        try {
//            String XHnurse3ID = rs.getString("XHHS3").trim();
//            patientLink.getAnesthesiaRecord().setXhhs2(convertCodeToId(XHnurse3ID, accountList, conn));
//        } catch (Exception e) {
//        }
//        // 手术间号
//        String op = rs.getString("OPERROOMID");
//        patientLink.getSchedule().setPbssjh(covertOperRoom(trimStr(rs.getString("OPERROOMID"))));
//        // 手术次序
//        patientLink.getSchedule().setTs(covertOperts(trimStr(rs.getString("OPERROOMINDEX"))) );
//        patientLink.getSchedule().setPbts((covertOperts(trimStr(rs.getString("OPERROOMINDEX")))));
//        // 麻醉访视
//        patientLink.getSchedule().setMzfs(trimStr(rs.getString("MAZUIMETHOD")));

        // 申请科室名称
        patientLink.getApplication().setSqksmc(trimStr(rs.getString("SHENQINGKSMC")));
        patientLink.getPatient().setKsmc(trimStr(rs.getString("SHENQINGKSMC")));
        // 申请科室编号
        patientLink.getApplication().setSqksbh(trimStr(rs.getString("SHENQINGKS")));

        String SHENGAO = rs.getString("SHENGAO");
        if (null != SHENGAO) {
            patientLink.getPatient().setSg(SHENGAO.trim());
        }

        String BINGRENTZ = rs.getString("BINGRENTZ");
        if (null != BINGRENTZ) {
            patientLink.getPatient().setTz(BINGRENTZ.trim());
        }

        return patientLink;
    }

    private String trimStr(String str) {
        if (null == str)
            return "";
        return str.trim();
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

    public static String buildInsertSQL(String tableName, Object object) {
        if (null == object)
            return "";

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" INSERT INTO " + tableName + " ( ");

        Field[] fields = object.getClass().getDeclaredFields();
        boolean isFirst = true;
        int count = 0;
        for (Field f : fields) {
            String fn = f.getName();
            if (fn.contains("this"))
                continue;
            if (isFirst) {
                isFirst = false;
            } else {
                stringBuffer.append(",");
            }
            stringBuffer.append(fn);
            count++;
        }
        stringBuffer.append(") VALUES ( ");

        isFirst = true;
        for (int i = 0; i < count; i++) {
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

    public static void putData2PS(PreparedStatement ps, Object pojo) throws IllegalAccessException, SQLException {
        Field[] fields = pojo.getClass().getDeclaredFields();
        int i = 1;
        for (Field f : fields) {
            String fn = f.getName();
            if (fn.contains("this")) {
                continue;
            }

            String t = f.getGenericType().toString();
            if (t.equals("class java.lang.String")) {
                if (null != f.get(pojo))
                    ps.setString(i, (String) f.get(pojo));
                else
                    ps.setString(i, null);
            } else if (t.equalsIgnoreCase("class java.lang.Integer")) {
                if (null != f.get(pojo))
                    ps.setInt(i, (Integer) f.get(pojo));
                else
                    ps.setString(i, null);
            } else if (t.equalsIgnoreCase("class java.lang.Float")) {
                if (null != f.get(pojo))
                    ps.setFloat(i, (Float) f.get(pojo));
                else
                    ps.setString(i, null);
            } else if (t.equalsIgnoreCase("class java.util.Date")) {
                if (null != f.get(pojo))
                    ps.setTimestamp(i, new Timestamp(((Date) f.get(pojo)).getTime()));
                else
                    ps.setTimestamp(i, null);
            } else {
                ps.setString(i, null);
            }

            i++;
        }
    }

    public Boolean getOperationFromHis() {
    	try{
    	
        Boolean flag;
        // 获取his端的手术申请
        List<PatientLink> hisPatientLinkList = getOprationFromHis();
       
        System.out.println("hisPatientLinkList:" + hisPatientLinkList.size());
        // 获取当前数据库的手术申请
        List<PatientLink> patientLinkList = patientLinkDao.getScheduleTableOpersNS();
        System.out.println("patientLinkList:" + patientLinkList.size());
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
                            patientLinkDao.addUpdateApplication(hisPatientLinkList.get(i),patientLinkList.get(j));
                           patientLinkDao.addUpdateSchedule(hisPatientLinkList.get(i),patientLinkList.get(j));
							}
                           /* patientLinkDao.findAndUpdate(Criteria.where("application.ssssdh").is(hisPatientLinkList.get(i).getApplication().getSssqdh()), Update.update("application", hisPatientLinkList.get(i).getApplication()));
                            patientLinkDao.findAndUpdate(new Criteria(hisPatientLinkList.get(i).getApplication().getSssqdh()), Update.update("schedule", hisPatientLinkList.get(i).getSchedule()));*/
                            break;
                        }
                    }
                    if (addFlag) {
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
        return flag;
    	}catch(Exception e){
    		e.printStackTrace();
    		return false;
    	}
    }
    public String covertOperRoom(String room) {
		if ("".equals(room)) {
			return "";
		}else {
			if (room.contains("手术间")) {
				return room.replace("手术间", " ").trim();
			}else {
				return room;
			}
		}
	}
    
    public String covertOperts(String ts) {
		if ("".equals(ts)) {
			return "";
		}else {
			if (ts.contains("号")) {
				return ts.replace("号", " ").trim();
			}else {
				return ts;
			}
		}
	}
    
    public String getWorkIdByid(String id){
    	if (id==null ||("").equals(id)) {
			return "";
		}
    	Account account=accountDao.findAccountById(id);
    	if (account==null) {
			return "";
		}else {
			return trimStr(account.getWorkID());
		}
    }
    
    public String getTrueNameByid(String id){
    	if (id==null ||("").equals(id)) {
			return "";
		}
    	Account account=accountDao.findAccountById(id);
    	if (account==null) {
			return "";
		}else {
			return trimStr(account.getTrueName());
		}
    }
    
    public String getStringTime(Date date){
    	Calendar calendar=Calendar.getInstance();
    	calendar.setTime(date);
    	int year=calendar.get(Calendar.YEAR);
    	if (date==null ||year==0001) {
			return "";
		}else {
			return MyDateFormat.DATE_FORMAT_YMDHMS.format(date);
		}
    }


}
