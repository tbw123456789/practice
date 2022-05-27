package cn.medigical.publish.controller;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigDepartmentsDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigDrugsDao;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.dictionary.ConfigDepartments;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.pojo.zjpa.BaseSelectXml;
import cn.medigical.publish.pojo.zjpa.ResponseMsg;
import cn.medigical.publish.pojo.zjpa.account.AccountHis;
import cn.medigical.publish.pojo.zjpa.dept.DepartHis;
import cn.medigical.publish.pojo.zjpa.patientLink.ConverToPojoUtil;
import cn.medigical.publish.pojo.zjpa.patientLink.OperationHis;
import cn.medigical.publish.pojo.zjpa.patientLink.OperationHisSelectXml;
import cn.medigical.publish.udp.MsgHelper;
import cn.medigical.publish.utils.SpringUtils;
import cn.medigical.publish.xmlUtil.ServicesSign;

import java.io.BufferedReader;
import java.io.StringWriter;
import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/xmlController")
public class XmlController {
	private static Logger logger = Logger.getLogger("XmlController");
	private PatientLinkDao patientLinkDao=SpringUtils.getBean(PatientLinkDao.class);
	private AccountDao accountDao=SpringUtils.getBean(AccountDao.class);
	private ConfigDepartmentsDao configDepartmentsDao=SpringUtils.getBean(ConfigDepartmentsDao.class);

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	@ResponseBody
	public String receiveJson(@RequestBody String requestXml) {

		String IndeInfo = "";
		String infoId = "";
		String returnXML = "the init returnXml";
		String methodId = "";
		boolean resultFlag = false;
		boolean isInto=false;
//		logger.info("a request into the method !");
		
		BufferedReader reader = null;
		try {
//			String data =requestXml = new String(requestXml.getBytes("ISO-8859-1"),"utf-8");//
			String  data=requestXml;
//			logger.info("the recive xml is " + data);
			if (!"".equals(data)) {
				
				Document doc = DocumentHelper.parseText(data); // 将字符串转为XML
				Element root = doc.getRootElement(); // 获
				List<Element> listElement = ((Element) root).elements();
				 infoId = (((Element) listElement.get(0))).attribute(0).getValue();
				 IndeInfo = (((Element) listElement.get(2))).attribute(0).getValue();
				 String all=data;
				// 手术信息新增
				if (all.indexOf(ServicesSign.OPERATION_ADD) > 0 && IndeInfo.equals("S0050")) {
					isInto=true;
					logger.info("this add operation xml is"+all);
					methodId = ServicesSign.OPERATION_ADD;
					// 解析xml得到相应映射类
					OperationHis operationHis = OperationHisSelectXml.getOperatoin(all);
					// 转换成系统的实体类
					PatientLink PatientLink = ConverToPojoUtil.getOperationFromHis(operationHis);
					// 进行数据库操作
					addPatientLink(PatientLink);
					resultFlag = true;
				}
				
				// 注册科室信息
				else if (all.indexOf(ServicesSign.DEPART_ADD) > 0) {
					isInto=true;
					logger.info("this add dept xml is"+all);
					methodId = ServicesSign.DEPART_ADD;
					// 调用功能id对应方法
					BaseSelectXml<DepartHis> baseSelectXml = new BaseSelectXml<>(new DepartHis());
					DepartHis departHis = baseSelectXml.getDataPlatformModel(all, methodId);
					// 转换成系统的实体类
					ConfigDepartments department = ConverToPojoUtil.getDepartFromHis(departHis);
					logger.info("this addUpdate dept code is" + department.getCode());
					configDepartmentsDao.addOne(department);
					resultFlag = true;
				}
				
			
				// 注册医护人员信息新增
				else if (all.indexOf(ServicesSign.ACCCOUNT_ADD) > 0) {
					isInto=true;
					logger.info("this add account xml is"+all);
					methodId = ServicesSign.ACCCOUNT_ADD;
					// 调用功能id对应方法
					BaseSelectXml<AccountHis> baseSelectXml = new BaseSelectXml(new AccountHis());
					AccountHis accountHis = baseSelectXml.getDataPlatformModel(all, methodId);
					// 转换成系统的实体类
					Account account = ConverToPojoUtil.getAccountFromHis(accountHis);
					logger.info("this account addUpdate workId is" + account.getWorkID());
					// 进行数据库操作
					accountDao.addUpdate(account);
					resultFlag = true;
				}
				if (resultFlag) {
					returnXML = ResponseMsg.getOkMsg(infoId);
				} else {
					
					returnXML = ResponseMsg.getFailuMsg(infoId);
				}
			} else {
				returnXML = ResponseMsg.getFailuMsg(infoId);
			}
		} catch (Exception e) {
			returnXML = ResponseMsg.getFailuMsg(infoId);
			e.printStackTrace();
		}
		if (isInto) {
			logger.info("returnXML is" + returnXML);
		}
		return returnXML;
	}

	private void addPatientLink(PatientLink patientLink) {
		List<PatientLink> tempList= patientLinkDao.getScheduleTableOpers();
		boolean falg=true;
		for (PatientLink item : tempList) {
			if (item.getHisID().equals(patientLink.getHisID())) {
				falg=false;
				break;
			}
		}
		if (falg) {
			patientLinkDao.addUpdate(patientLink);
			logger.info("operation add success and this hisID is "+patientLink.getHisID());
		}else {
			logger.info("this add operation exits and is hisID is "+patientLink.getHisID());
		}
	}
	
	}
	