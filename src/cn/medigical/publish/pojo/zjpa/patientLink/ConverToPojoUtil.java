package cn.medigical.publish.pojo.zjpa.patientLink;

import java.text.SimpleDateFormat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.dictionary.ConfigDepartments;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.pojo.zjpa.account.AccountHis;
import cn.medigical.publish.pojo.zjpa.dept.DepartHis;
import cn.medigical.publish.utils.Constants;
import cn.medigical.publish.utils.MyConstants;
import cn.medigical.publish.utils.MyDateFormat;

/**
 * 这个类进行数据转换
 *
 * @author 欧欧欧
 */
public class ConverToPojoUtil {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
	private static Logger logger=Logger.getLogger(ConverToPojoUtil.class);

    // 手术转换operation
    public static PatientLink getOperationFromHis(OperationHis operationHis) {
        PatientLink patientlink = new PatientLink();
        patientlink.getPatient().setStatus(MyConstants.FLAG_VALID);
        patientlink.getApplication().setStatus(Constants.AP_STATUS_MAZUIQIAN);
        patientlink.getApplication().setDetailstatus(MyConstants.OR_STATUS_FLAG_APPLIED);
        patientlink.getApplication().setSssqdh(trimStr(operationHis.getApplyId()));
        patientlink.setHisID(trimStr(operationHis.getApplyId()));
        patientlink.getPatient().setZych(trimStr(operationHis.getBedName()));
        patientlink.setCreateDate(new Date());
        patientlink.getPatient().setKsbh(trimStr(operationHis.getDeptId()));
        patientlink.getPatient().setKsmc(trimStr(operationHis.getDeptName()));
        if (operationHis.getDeptId()==null || ("").equals(operationHis.getDeptId())) {
			patientlink.getPatient().setKsbh(trimStr(operationHis.getApplyDeptId()));
		}
        if (operationHis.getDeptName()==null || ("").equals(operationHis.getDeptName())) {
			patientlink.getPatient().setKsmc(trimStr(operationHis.getApplyDeptName()));
		}
        
        if(operationHis.getOperPlanTimeList().size()>0){
        logger.info("病人名字： "+operationHis.getPatientName()+" 预约时间 ： "+operationHis.getOperPlanTimeList().get(0));
        patientlink.getApplication().setYysssj(parseDate(operationHis.getOperPlanTimeList().get(0)));}
        patientlink.getApplication().setSqksbh(trimStr(operationHis.getApplyDeptId()));
        patientlink.getApplication().setSqksmc(trimStr(operationHis.getApplyDeptName()));
        patientlink.getApplication().setSssqsj(parseDate(operationHis.getApplyTime()));
        logger.info("病人名字： "+operationHis.getPatientName()+" 申请时间 ： "+operationHis.getApplyTime());
        String operationType = trimStr(operationHis.getOperTypeName());
        if (operationType.equals("择期")) {
            patientlink.getApplication().setType(MyConstants.OR_TYPE_SCHEDULE);
        } else if (operationType.endsWith("围期")) {
            patientlink.getApplication().setType(MyConstants.OR_TYPE_URGENT);
        }
        patientlink.getApplication().setSqzd1(trimStr(operationHis.getZhengDuan()));
        patientlink.getSchedule().setMzfs(trimStr(operationHis.getMaZuiMethodName()));
        if (operationHis.getOperPlanTimeList().size() > 0) {
            patientlink.getSchedule().setJhsssj(parseDate(operationHis.getOperPlanTimeList().get(0)));
        }
        patientlink.getApplication().setSssqsj(parseDate(operationHis.getApplyTime()));
        // 手术医生1
        if (operationHis.getOperDocIdList().size() > 0) {
            patientlink.getApplication().setSsysbh(trimStr(operationHis.getOperDocIdList().get(0)));
            patientlink.getApplication().setSsysxm(trimStr(operationHis.getOperDocNameList().get(0)));
        }
        // 手术医生2
        if (operationHis.getOperDocIdList().size() > 1) {
            patientlink.getApplication().setZlysbh1(trimStr(operationHis.getOperDocIdList().get(1)));
            // patientlink.getApplication().setOperDoctor2(trimStr(operationHis.getOperDocNameList().get(1)));
        }
        // 手术医生3
        if (operationHis.getOperDocIdList().size() > 2) {
            patientlink.getApplication().setZlysbh2(trimStr(operationHis.getOperDocIdList().get(2)));
            // patientlink.getApplication().setOperDoctor3(trimStr(operationHis.getOperDocNameList().get(2)));
        }
        patientlink.getPatient().setPatId(trimStr(operationHis.getPatientId()));
        patientlink.getPatient().setBrxm(trimStr(operationHis.getPatientName()));
        patientlink.getPatient().setXb(trimStr(operationHis.getSexName()));
        patientlink.getPatient().setNl(trimStr(operationHis.getAge()));
        patientlink.getPatient().setZyh(trimStr(operationHis.getVisitId()));
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < operationHis.getOperNameList().size(); i++) {
            if (i == operationHis.getOperNameList().size() - 1) {
                buffer.append(trimStr(operationHis.getOperNameList().get(i)));
            }else{
            	buffer.append(trimStr(operationHis.getOperNameList().get(i)) + ",");
            }  
        }
        patientlink.getApplication().setNsssmc(buffer.toString());
        patientlink.getSchedule().setBznr(operationHis.getAttention());
        return patientlink;
    }

    // 医护人员转换account
    public static Account getAccountFromHis(AccountHis accountHis) throws ParseException, NoSuchAlgorithmException {
        MessageDigest MD5 = MessageDigest.getInstance("MD5");
        Account account = new Account();
        account.setNeiBuId(trimStr(accountHis.getIDCard()));
        account.setWorkID(trimStr(accountHis.getWorkID()));
        account.setTrueName(trimStr(accountHis.getTrueName()));
        account.setHisID(trimStr(accountHis.getWorkID()));
        account.setGender(trimStr(accountHis.getGender()));
        account.setOfficeID(trimStr(accountHis.getOfficeID()));
        account.setOfficeName(trimStr(accountHis.getOfficeName()));
        account.setDob(parseDate(trimStr(accountHis.getDob())));
        account.setRole(trimStr(accountHis.getRole()));
        account.setTitle(trimStr(accountHis.getRoleId()));
        account.setInDate(parseDate(accountHis.getInDate()));
        account.setOutDate(parseDate(accountHis.getOutDate()));
        account.setPhone(trimStr(accountHis.getPhone()));
        account.setStatus("valid");
        account.setOrLevel(trimStr(accountHis.getPriorityNumber()));
        account.setLoginName(trimStr(accountHis.getTrueName()));
        account.setSchoolLevel("本科");
        account.setPwd(trimStr(encodeByMD5(accountHis.getWorkID())));
        account.setCreateTime(new Date());
        account.setLastUpdateTime(new Date());
        account.setCanLogin(true);
        return account;
    }

    // 科室转换configdepartment
    public static ConfigDepartments getDepartFromHis(DepartHis departHis) {
        ConfigDepartments department = new ConfigDepartments();
        department.setCode(trimStr(departHis.getCode()));
        department.setName(trimStr(departHis.getName()));
        return department;
    }

    
    
    protected static String trimStr(String str) {
        if (null == str)
            return "";
        return str.trim();
    }

    public static Date parseDate(String str) {
        if ("".equalsIgnoreCase(str)||str==null) {
            return new Date();
        }
        try {
            return MyDateFormat.DATE_FORMAT_YMDHMl.parse(str.trim());
        } catch (ParseException e) {
            try {
                return MyDateFormat.DATE_FORMAT_YMD.parse(str.trim());
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public static String encodeByMD5(final String originString) {
        if (originString != null) {
            try {
                final MessageDigest md = MessageDigest.getInstance("MD5");
                final byte[] results = md.digest(originString.getBytes());
                final StringBuffer resultSb = new StringBuffer();
                for (final byte element : results) {
                    resultSb.append(byteToHexString(element));
                }
                final String resultString = resultSb.toString();
                return resultString.toUpperCase();
            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    private static String byteToHexString(final byte b) {
        int n = b;
        if (n < 0) {
            n = 256 + n;
        }
        final int d1 = n / 16;
        final int d2 = n % 16;
        return HEXDIGITS[d1] + HEXDIGITS[d2];
    }

    private static final String[] HEXDIGITS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

  
}
