package cn.medigical.publish.interfaces.his.hisNantong;



import cn.medigical.publish.dao.impl.AccountCache;
import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigDepartmentsDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigDrugsDao;
import cn.medigical.publish.interfaces.his.hisLink.HisLink;
import cn.medigical.publish.interfaces.his.hisLink.PojoBGA;
import cn.medigical.publish.interfaces.his.hisNantong.interface4Business.*;
import cn.medigical.publish.interfaces.his.hisNantong.stub.SendCmdSvr;
import cn.medigical.publish.interfaces.his.hisNantong.xml.apply.ITEMType;
import cn.medigical.publish.interfaces.lis.LisData;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.dictionary.ConfigDepartments;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.utils.Constants;
import cn.medigical.publish.utils.MyDateFormat;
import cn.medigical.publish.utils.MyUtility;
import cn.medigical.publish.utils.SpringUtils;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;

import com.mysql.fabric.xmlrpc.base.Data;

import java.text.ParseException;
import java.util.*;

public class HisLinkNantong extends HisLink {
	protected UserInterface userInterface = new UserInterface();
	protected DeptInterface deptInterface = new DeptInterface();
	protected ApplyInterface applyInterface = new ApplyInterface();
	protected PatInfoInterface patInfoInterface = new PatInfoInterface();
	protected OperNameInterface operNameInterface = new OperNameInterface();
	protected String[] ageUnit = { Constants.AGE_UNIT_YEAR, Constants.AGE_UNIT_MONTH, Constants.AGE_UNIT_DAY };
	List<Account> accountList;
	PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);
	AccountDao accountDao = (AccountDao) SpringUtils.getBean(AccountDao.class);
	ConfigDepartmentsDao configDepartmentsDao = SpringUtils.getBean(ConfigDepartmentsDao.class);
	ConfigDrugsDao configDrugsDao = SpringUtils.getBean(ConfigDrugsDao.class);

	private static HisLinkNantong instance;

	public static HisLinkNantong getInstance() {
		if (instance == null) {
			instance = new HisLinkNantong();
		}
		return instance;
	}

	public List<PatientLink> getOprationFromHis() {
		List<PatientLink> operationList = new ArrayList<PatientLink>();
		this.accountList = accountDao.getAllAccount();
		SendCmdSvr sendCmdSvr = new SendCmdSvr("http://201.201.0.17:8088/ExternalServices/ZL_InformationService.asmx", "94887C3968A40CD3E950E02E3D5F0EBA", "034F1DE69C9EE455");
		boolean iniOK = sendCmdSvr.initial();
		if (!iniOK) {
			return null;
		}

		Calendar now = Calendar.getInstance();
		now.add(6, 1);
		Date dateNow = now.getTime();
		Date dateFrom = new Date(dateNow.getTime() - 345600000L);
		this.logger.warn("查询his的开始和结束时间" + MyDateFormat.DATE_FORMAT_YMDHMSsss.format(dateFrom) + "------>" + MyDateFormat.DATE_FORMAT_YMDHMSsss.format(dateNow));
		List<ITEMType> applyItemTypeList = this.applyInterface.getApplySchedule(sendCmdSvr, dateFrom, dateNow);
		if (null == applyItemTypeList) {
			return null;
		}
		this.logger.warn("getOpration Start. getOpration Size=" + applyItemTypeList.size());
		for (ITEMType applyItemType : applyItemTypeList) {
			if (null == applyItemType) {
				continue;
			}
			String visitID = trimStr(applyItemType.getADMNO());
			String zhuYuanCiShu = trimStr(applyItemType.getVISITID());
			String hisOperId = trimStr(applyItemType.getSCHEDULEID());
			String patId = trimStr(applyItemType.getPATIENTID());

			cn.medigical.publish.interfaces.his.hisNantong.xml.patinfo.ITEMType patItemType = this.patInfoInterface.getPatInfo(sendCmdSvr, patId, zhuYuanCiShu);
			if (null == patItemType) {
				continue;
			}
			PatientLink patientLink = new PatientLink();
			// patientLink.setBedsideShow(((DefaultBedsideShow)SpringCache.getInstance().getBean("DefaultBedsideShow")).getDefault());
			patientLink.getPatient().setZyh(visitID);
			patientLink.getPatient().setZycs(zhuYuanCiShu);
			patientLink.getApplication().setSssqdh(hisOperId);
			patientLink.setHisID(hisOperId);
			patientLink.getPatient().setPatId(patId);
			
			String deptName = trimStr(applyItemType.getDEPTSTAYED());
			patientLink.getApplication().setSqksmc(deptName);
			patientLink.getPatient().setKsmc(deptName);
			// patientLink.getApplication().setSqksbh(trimStr(applyItemType.getOPERATINGROOM()));
			patientLink.getPatient().setZych(trimStr(applyItemType.getBEDNO()));
			// patientLink.getOperInfo().setSrcBed(trimStr(applyItemType.getBEDNO()));
			patientLink.getApplication().setSqksmc(trimStr(applyItemType.getDEPTSTAYED()));
			patientLink.getApplication().setSqksbh(trimStr(applyItemType.getOPERATINGROOM()));
			patientLink.setCreateDate(new Date());
			patientLink.getApplication().setYysssj(parseDate(applyItemType.getSCHEDULEDDATETIME()));
			patientLink.getApplication().setSssqsj(parseDate(applyItemType.getREQDATETIME()));
			patientLink.getApplication().setSqzd1(trimStr(applyItemType.getDIAGNOSTICDESCRIPTION()));
			patientLink.getAnesthesiaRecord().setShzd1(trimStr(applyItemType.getDIAGNOSTICDESCRIPTION()));
			patientLink.getApplication().setType(trimStr(applyItemType.getEMERGENCYINDICATOR()).equals("1") ? "urgent" : "schedule");
			patientLink.getPatient().setStatus(Constants.FLAG_VALID);
			patientLink.getApplication().setStatus(Constants.AP_STATUS_MAZUIQIAN);
			patientLink.getApplication().setDetailstatus(Constants.OR_STATUS_FLAG_APPLIED);
			String docName = trimStr(applyItemType.getSURGEON());
			if ((null != docName) && (docName.length() > 0)) {
				patientLink.getApplication().setSsysbh(convertNameToId(docName, this.accountList, "手术医生"));
				patientLink.getApplication().setSsysxm(docName);
			}
			docName = trimStr(applyItemType.getENTEREDBY());
			if ((null != docName) && (docName.length() > 0)) {
				patientLink.getApplication().setSqysbh(convertNameToId(docName, this.accountList, "手术医生"));
			}
			docName = trimStr(applyItemType.getANESTHESIADOCTOR());
			if ((null != docName) && (docName.length() > 0)) {
				patientLink.getSchedule().setMzysbh1(convertNameToId(docName, this.accountList, "手术医生"));
			}
			docName = trimStr(applyItemType.getANESTHESIAASSISTANT());
			if ((null != docName) && (docName.length() > 0)) {
				patientLink.getSchedule().setMzysbh2(convertNameToId(docName, this.accountList, "手术医生"));
			}
			//patientLink.getSchedule().setMazuiMethod(trimStr(applyItemType.getANESTHESIAMETHOD()));
			applyItemType.getSTATUS();
			patientLink.getPatient().setGms(trimStr(applyItemType.getALLERGY()));
			cn.medigical.publish.interfaces.his.hisNantong.xml.surgeryname.ITEMType operNameItem = this.operNameInterface.getOperName(sendCmdSvr, patId, zhuYuanCiShu, hisOperId);
			patientLink.getApplication().setNsssmc(null == operNameItem ? "" : trimStr(operNameItem.getOPERATION()));
			patientLink.getAnesthesiaRecord().setYsss1(null == operNameItem ? "" : trimStr(operNameItem.getOPERATION()));
			patientLink.setHisID(operNameItem.getSCHEDULEID());
			patientLink.getPatient().setBrxm(trimStr(patItemType.getNAME()));
			patientLink.getPatient().setXb(trimStr(patItemType.getSEX()));
			patientLink.getPatient().setSg(trimStr(patItemType.getHEIGHT()));
			patientLink.getPatient().setTz(trimStr(patItemType.getWEIGHT()));
			Date dobDate = parseDateBirthDay(patItemType.getDATEOFBIRTH());
			patientLink.getPatient().setDob(dobDate);
			String ageStr = MyUtility.getAge(dobDate, patientLink.getApplication().getSssqsj());
			if (!"".equals(ageStr)) {
				boolean isContainUnit = false;
				for (String unit : this.ageUnit) {
					if (ageStr.contains(unit)) {
						patientLink.getPatient().setNl(ageStr);
						patientLink.getPatient().setNldw(unit);
						int indexUnit = ageStr.indexOf(unit);
						try {
							Integer numAge = Integer.valueOf(Integer.parseInt(ageStr.substring(0, indexUnit)));
							patientLink.getPatient().setNumAge(numAge);
						} catch (Exception e) {
						}
						isContainUnit = true;
						break;
					}
				}
				if (!isContainUnit) {
					patientLink.getPatient().setNl(ageStr + Constants.AGE_UNIT_YEAR);
					patientLink.getPatient().setNldw(Constants.AGE_UNIT_YEAR);
					try {
						Integer numAge = Integer.valueOf(Integer.parseInt(ageStr));
						patientLink.getPatient().setNumAge(numAge);
					} catch (Exception e) {
					}
				}
			}
			patientLink.getPatient().setSocialId(trimStr(patItemType.getIDNO()));
			System.out.println(patientLink.getPatient().getBrxm()+"++++++++++++++++++++++"+patientLink.getPatient().getPatId());
			operationList.add(patientLink);
		}
		return operationList;
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
		SendCmdSvr sendCmdSvr = new SendCmdSvr("http://201.201.0.17:8088/ExternalServices/ZL_InformationService.asmx", "94887C3968A40CD3E950E02E3D5F0EBA", "034F1DE69C9EE455");
		boolean iniOK = sendCmdSvr.initial();
		if (!iniOK) {
			return null;
		}
		List<ConfigDepartments> departmentList = new ArrayList<ConfigDepartments>();
		List<cn.medigical.publish.interfaces.his.hisNantong.xml.dept.ITEMType> itemTypeList = this.deptInterface.getDepts(sendCmdSvr);
		for (cn.medigical.publish.interfaces.his.hisNantong.xml.dept.ITEMType deptItemType : itemTypeList) {
			ConfigDepartments department = new ConfigDepartments();
			department.setCode(trimStr(deptItemType.getDEPTCODE()));
			department.setName(trimStr(deptItemType.getDEPTNAME()));
			department.setDeleted(false);
			departmentList.add(department);
		}
		List<ConfigDepartments> con = new ArrayList<ConfigDepartments>();
		List<ConfigDepartments> configDepartments = configDepartmentsDao.getAll();
		Boolean flag = false;
		for (ConfigDepartments co : departmentList) {
			for (ConfigDepartments a : configDepartments) {
				if (trimStr(co.getCode()).equals(a.getCode())) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				con.add(co);
			}
		}
		configDepartmentsDao.addAll(con);
		return departmentList;
	}

	public List<Account> getAccountFromHis() {
		String[] deptIds = { "252", "221" };
		List<Account> accountList = new ArrayList<Account>();
		List<cn.medigical.publish.interfaces.his.hisNantong.xml.user.ITEMType> itemTypeList = new ArrayList<cn.medigical.publish.interfaces.his.hisNantong.xml.user.ITEMType>();
		SendCmdSvr sendCmdSvr = new SendCmdSvr("http://201.201.0.17:8088/ExternalServices/ZL_InformationService.asmx", "94887C3968A40CD3E950E02E3D5F0EBA", "034F1DE69C9EE455");
		boolean iniOK = sendCmdSvr.initial();
		if (!iniOK) {
			return null;
		}
		for (int i = 0; i < deptIds.length; i++) {
			itemTypeList.addAll(this.userInterface.getUsers(sendCmdSvr, deptIds[i]));
		}
		for (cn.medigical.publish.interfaces.his.hisNantong.xml.user.ITEMType userItemType : itemTypeList) {
			if (null != userItemType) {
				accountList.add(getOneAccount(userItemType));
			}
		}
		java.util.Map<String, Account> filterAccountMap = new HashMap<String, Account>();
		for (Account accountFrom : accountList) {
			if (accountFrom.getWorkID() != null) {
				filterAccountMap.put(accountFrom.getWorkID(), accountFrom);
			}
		}
		List<Account> accountListFromDb = accountDao.gets();
		System.out.println("现有账号数量:" + accountListFromDb.size());
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
		accountDao.addAll(newAcconutList);
		return accountList;
	}

	protected Account getOneAccount(cn.medigical.publish.interfaces.his.hisNantong.xml.user.ITEMType userItemType) {
		List<Account> accounts = accountDao.getAll();
		for (Account a : accounts) {
			if (trimStr(userItemType.getUSERCODE()).equals(a.getWorkID())) {
				return null;
			}
		}
		Account account = new Account();
		String hisId = trimStr(userItemType.getUSERID());
		int indexG = hisId.indexOf("_");
		if (-1 != indexG) {
			hisId = hisId.substring(0, indexG);
		}
		account.setHisID(hisId);
		String name = trimStr(userItemType.getUSERNAME());
		if (name.contains("（")) {
			name = name.substring(0, name.indexOf("（"));
		}
		account.setTrueName(name);
		account.setGender(trimStr(userItemType.getUSERSEX()));
		account.setCanLogin(Boolean.valueOf(true));
		account.setWorkID(trimStr(userItemType.getUSERCODE()));
		account.setLoginName(trimStr(userItemType.getUSERCODE()));
		account.setPwd(accountDao.generatePassword(trimStr(userItemType.getUSERCODE())));
		String zw = trimStr(userItemType.getUSERJOB());
		account.setOfficeID(trimStr(userItemType.getUSERDEPT()));
		if (zw.equals("医生")) {
			if ((userItemType.getUSERDEPT().equals(getMazuiDocDeptCode())) || (userItemType.getUSERDEPT().equals(getNurseDeptCode()))) {
				account.setOfficeName(getMazuiDocDeptName());
				account.setTitle("麻醉医生");
			} else {
				account.setTitle("医生");
				account.setOfficeName(getNurseDeptName());
			}
		} else if (zw.equals("护士")) {
			if (userItemType.getUSERDEPT().equals(getNurseDeptCode())) {
				account.setOfficeName(getMazuiDocDeptName());
				account.setTitle("手术护士");
			}
			else
			{
				account.setOfficeName(getNurseDeptName());
				account.setTitle("护士");
			}
		} else {
			account.setTitle("其他");
			account.setOfficeName("其他科室");
			account.setCanLogin(Boolean.valueOf(false));
		}
		account.setRole(zw);
		account.setTitle(zw);
		account.setCreateTime(new Date());
		// 因为“27-APR-17”时间暂无法解析 暂用new date（）
		// account.setCreateTime(parseDate(userItemType.getCREATEDATE()));
		account.setSchoolLevel("本科");
		account.setStatus("valid");
		account.setLastUpdateTime(new Date());
		account.setDob(new Date());
		account.setInDate(new Date());
		return account;
	}

	public boolean writeEndOper2HIS(PatientLink patientLink) {
		return false;
	}

	public boolean addEndOper2HISUpateBatch(List<PatientLink> patientLinks) {
		return false;
	}

	public LisData getLisData(String zyh, String name) {
		return null;
	}

	public String getMazuiDocDeptCode() {
		return "1215";
	}

	public String getMazuiDocDeptName() {
		return "麻醉科";
	}

	public String getNurseDeptCode() {
		return "1215";
	}

	public String getNurseDeptName() {
		return "手术室";
	}

	public boolean isBGAEnable() {
		return false;
	}

	public List<PojoBGA> getBGA(String zyh, Date startTime, Date endTime) {
		return null;
	}

	protected String trimStr(String str) {
		if (null == str)
			return "";
		return str.trim();
	}

	protected String convertNameToId(String name, List<Account> accountList, String role) {
		for (int i = 0; i < accountList.size(); i++) {
			if (name.equals(((Account) accountList.get(i)).getTrueName())) {
				return ((Account) accountList.get(i)).getId();
			}
		}

		return crtNewAccount(name, role);
	}

	private String crtNewAccount(String name, String role) {
		Account account = new Account();
		account.setTrueName(name);
		account.setRole(role);
		account.setWorkID(name);
		account.setLoginName(name);
		account.setLastUpdateTime(new Date());
		account.setCreateTime(new Date());
		account.setInDate(new Date());
		account.setCanLogin(Boolean.valueOf(true));
		account.setStatus("valid");
		account.setPwd(accountDao.generatePassword(String.valueOf(name)));
		account.setSchoolLevel("本科");
		if ("麻醉医生".equalsIgnoreCase(role)) {
			HisLink hisLink = new HisLinkNantong();
			account.setOfficeID(hisLink.getMazuiDocDeptCode());
			account.setOfficeName(hisLink.getMazuiDocDeptName());
		}
		if ("护士".equalsIgnoreCase(role)) {
			HisLink hisLink = new HisLinkNantong();
			account.setOfficeID(hisLink.getNurseDeptCode());
			account.setOfficeName(hisLink.getNurseDeptName());
		}

		accountDao.addUpdate(account);
		AccountCache.getInstance().setAccountToMap(account);
		this.accountList.add(account);
		return account.getId();
	}

	protected Date parseDate(String str) {
		try {
			return MyDateFormat.DATE_FORMAT_YMDHMS.parse(str.trim());
		} catch (ParseException e) {
			e.printStackTrace();
			try {
				return MyDateFormat.DATE_FORMAT_YMD.parse(str.trim());
			} catch (ParseException e2) {
				e2.printStackTrace();
			}
		}
		return new Date();
	}

	protected Date parseDateBirthDay(String str) {
		try {
			return MyDateFormat.DATE_FORMAT_YMD.parse(str.trim());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date();
	}

	public Boolean getOperationFromHis() {
		Boolean flag;
		// 获取his端的手术申请
		List<PatientLink> hisPatientLinkList = getOprationFromHis();
		System.out.println("hisPatientLinkList:" + hisPatientLinkList.size());
		// 获取当前数据库的手术申请
		List<PatientLink> patientLinkList = patientLinkDao.getScheduleTableOpersNT();
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
//							 if (patientLinkList.get(j).getApplication().getDetailstatus()!=null && patientLinkList.get(j).getApplication().getDetailstatus().equals(Constants.OR_STATUS_FLAG_APPLIED)) {
//		                            patientLinkDao.addUpdateApplication(hisPatientLinkList.get(i),patientLinkList.get(j));
//									}
							break;
						}
					}
					if (addFlag) {
						this.logger.warn(new Data()+"：正在向数据库插入病人"+hisPatientLinkList.get(i).getPatient().getBrxm());
						patientLinkDao.addUpdate(hisPatientLinkList.get(i));
					}
				}
			} else {
				for (PatientLink patientLink : hisPatientLinkList) {
					this.logger.warn(new Data()+"：正在向数据库插入病人"+patientLink.getPatient().getBrxm());
					patientLinkDao.addUpdate(patientLink);
				}
			}
		}
		flag = true;
		return flag;
	}

	public Boolean getBasicPatInfoOperation(String zyh)
	{
		boolean flag=true;
		PatientLink patientLink = new PatientLink();
		//patientLink.setBedsideShow(((DefaultBedsideShow)BeanCache.getInstance().getBean("DefaultBedsideShow")).getDefault());
		patientLink.getPatient().setZyh(zyh);
		patientLink.setCreateDate(new Date());
		patientLink.getPatient().setStatus(Constants.FLAG_VALID);
		patientLink.getApplication().setStatus(Constants.AP_STATUS_MAZUIQIAN);
		patientLink.getApplication().setDetailstatus(Constants.OR_STATUS_FLAG_APPLIED);
		SendCmdSvr sendCmdSvr = new SendCmdSvr();
		boolean iniOK = sendCmdSvr.initial();
		if (!iniOK) {
			flag=false;
			return flag;
		}
		Calendar now = Calendar.getInstance();
		now.add(6, 1);
		Date dateNow = now.getTime();
		Date dateFrom = new Date(dateNow.getTime() - 604800000L);
		cn.medigical.publish.interfaces.his.hisNantong.xml.patinfo.ITEMType patItemType = this.patInfoInterface.getPatInfoWS(sendCmdSvr, "2", zyh, "", "");

		if (null == patItemType)
		{
			this.logger.error("null == patInfoInterface.getPatInfoWS(sendCmdSvr,\"2\",zyh, \"\", \"\"); ");
			flag=false;
			return flag;
		}
		this.logger.info("patItemType.getNAME()=======================================" + patItemType.getNAME());

		List<ITEMType> applyItemTypeList = this.applyInterface.getApplySchedule(sendCmdSvr, dateFrom, dateNow);
		for (ITEMType applyItemType : applyItemTypeList) {
			if (null == applyItemType) {
				continue;
			}
			if(zyh.equalsIgnoreCase(trimStr(applyItemType.getADMNO()))){
				//String hisOperId = trimStr(applyItemType.getSCHEDULEID());
				patientLink.setHisID(applyItemType.getSCHEDULEID());
				patientLink.getPatient().setZycs(applyItemType.getVISITID());
				patientLink.getPatient().setKsmc(trimStr(applyItemType.getDEPTSTAYED()));
				patientLink.getPatient().setZych(trimStr(applyItemType.getBEDNO()));
				break;
			}
		}
		getPatientInfo(patientLink, patItemType);
		this.logger.warn(new Data()+"：正在向数据库插入病人"+patientLink.getPatient().getBrxm());
		patientLinkDao.addUpdate(patientLink);
		return true;
	}
	private void getPatientInfo(PatientLink patientLink, cn.medigical.publish.interfaces.his.hisNantong.xml.patinfo.ITEMType patItemType)
	{
		if (null == patItemType)
		{
			this.logger.error("null == patItemType ");
			return;
		}
		patientLink.getPatient().setPatId(patItemType.getPATIENTID());
		patientLink.getPatient().setBrxm(trimStr(patItemType.getNAME()));
		patientLink.getPatient().setXb(trimStr(patItemType.getSEX()));
		this.logger.warn("PatientName" + patItemType.getNAME() + "-----------");
		patientLink.getPatient().setYblx(trimStr(patItemType.getCHARGETYPE()));
		patientLink.getPatient().setSg(trimStr(patItemType.getHEIGHT()));
		patientLink.getPatient().setTz(trimStr(patItemType.getWEIGHT()));
		patientLink.getApplication().setSsysxm(trimStr(patItemType.getOPERATOR()));

		//patientLink.getApplication().setSsysbh(convertNameToId(trimStr(patItemType.getOPERATOR()), this.accountList, "手术医生"));
		Date dobDate = parseDate(patItemType.getDATEOFBIRTH());
		patientLink.getPatient().setDob(dobDate);
		String ageStr = MyUtility.getAge(dobDate, patientLink.getApplication().getSssqsj());
		if (!"".equals(ageStr))
		{
			boolean isContainUnit = false;
			for (String unit : this.ageUnit) {
				if (ageStr.contains(unit))
				{
					patientLink.getPatient().setNl(ageStr);
					patientLink.getPatient().setNldw(unit);
					int indexUnit = ageStr.indexOf(unit);
					try
					{
						Integer numAge = Integer.valueOf(Integer.parseInt(ageStr.substring(0, indexUnit)));
						patientLink.getPatient().setNumAge(numAge);
					}
					catch (Exception e) {}
					isContainUnit = true;
					break;
				}
			}
			if (!isContainUnit)
			{
				patientLink.getPatient().setNl(ageStr + Constants.AGE_UNIT_YEAR);
				patientLink.getPatient().setNldw(Constants.AGE_UNIT_YEAR);
				try
				{
					Integer numAge = Integer.valueOf(Integer.parseInt(ageStr));
					patientLink.getPatient().setNumAge(numAge);
				}
				catch (Exception e) {}
			}
		}
		patientLink.getPatient().setSocialId(trimStr(patItemType.getIDNO()));

	}
}
