package cn.medigical.publish.controller;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import cn.medigical.publish.dao.impl.dictionary.ConfigDepartmentsDao;
import cn.medigical.publish.pojo.dictionary.ConfigDepartments;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.medigical.publish.dao.PeiZhiDao;
import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.daPing.JiaShu;
import cn.medigical.publish.pojo.daPing.Operation1;
import cn.medigical.publish.pojo.daPing.PaiBanTable;
import cn.medigical.publish.pojo.daPing.PeiZhi;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.utils.*;
import cn.medigical.publish.utils.ConstantEnum.MsgType;

@Controller
@RequestMapping("commandController")
public class CommandController {
	PeiZhiDao peiZhiDaoImpl = SpringUtils.getBean(PeiZhiDao.class);
	AccountDao accountDao = SpringUtils.getBean(AccountDao.class);
	PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);
	private String hosname = PropertyUtil.getProperty("Hospital.Name");
	private AjaxMsg ajax = AjaxMsg.newInstance();
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss");
	private final static int paibanNum = 10;
	private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	ConfigDepartmentsDao configDepartmentsDao = SpringUtils.getBean(ConfigDepartmentsDao.class);

	@RequestMapping(value = "index", method = RequestMethod.GET)
	public Object index(Model m) {
		return "index";
	}

	@ResponseBody
	@RequestMapping(value = "paibanAjax", method = RequestMethod.GET)
	public Object paibanAjax(HttpServletRequest request) throws Exception {
		Map<String, Object> params = FrontHelper.transfParams(request);
		String Pdata = params.get(ParameterConstants.DATA).toString();
		Operation1 O = (Operation1) JsonUtilTool.json2Object(Pdata, Operation1.class);
		PeiZhi peizhi = peiZhiDaoImpl.getAll().get(0);
		Date start = DateUtil.oneDaystart(new Date());
		Date end = DateUtil.oneDayend(new Date());
		String dept =params.get(ParameterConstants.DEPT).toString();
		List<PatientLink> opList=new ArrayList<PatientLink>();
		if("请选择科室".equals(dept)||dept==null||"".equals(dept)){
			opList=patientLinkDao.getByPlanTime(start,end);
		}else {
			opList = patientLinkDao.getByPlanTimeDept(start, end,dept);
		}
		List<Operation1> Oper = JsonToDate1(opList);
		Collections.sort(Oper, new Comparator<Operation1>() {
			@Override
			public int compare(Operation1 o1, Operation1 o2) {
				int i = 0;
				if (o1.getOpenRoom() != null && !("").equals(o1.getOpenRoom()) && !(" ").equals(o1.getOpenRoom()) && !("").equals(o2.getOpenRoom()) && o2.getOpenRoom() != null && !(" ").equals(o2.getOpenRoom())) {
					i = Integer.parseInt(o1.getOpenRoom().trim()) - Integer.parseInt(o2.getOpenRoom().trim());
					if (i == 0) {
						return Integer.parseInt(o1.getOpenRoom().trim()) - Integer.parseInt(o2.getOpenRoom().trim().trim());
					}
				}
				return i;
			}
		});
		List<Operation1> operation1s = new ArrayList<Operation1>();
		int page = Oper.size() / paibanNum;
		if (Oper.size() % paibanNum > 0) {
			page = page + 1;
		}
		// 设置分页
		if (O.getPageNum() < 0 || page <= O.getPageNum()) {
			O.setPageNum(0);
		}
		for (int i = paibanNum * O.getPageNum(); i < paibanNum * O.getPageNum() + paibanNum; i++) {
			if (i == Oper.size()) {
				break;
			}
			operation1s.add(Oper.get(i));

		}
		for (;;) {
			if (operation1s.size() < paibanNum) {
				Operation1 Opera = new Operation1();
				operation1s.add(Opera);
			} else {
				break;
			}
		}
		ajax.addHashMap("paiBanTable", peizhi.getPaiBanTable());
		ajax.addHeader(MsgType.SUCCESS, "ok");
		ajax.addMap(operation1s);
		ajax.addCount(Oper.size());
		//ajax.addData("data",operation1s);
		ajax.addHashMap("page", O.getPageNum());
		return ajax;
	}
	@RequestMapping(value = "paibanDeptAjax", method = RequestMethod.GET)
	public Object paibanDeptAjax(HttpServletRequest request) throws Exception {
		Map<String, Object> params = FrontHelper.transfParams(request);
		String Pdata = params.get(ParameterConstants.DATA).toString();
		String dept =params.get(ParameterConstants.DEPT).toString();
		Operation1 O = (Operation1) JsonUtilTool.json2Object(Pdata, Operation1.class);
		PeiZhi peizhi = peiZhiDaoImpl.getAll().get(0);
		Date start = DateUtil.oneDaystart(new Date());
		Date end = DateUtil.oneDayend(new Date());
		List<PatientLink> opList=new ArrayList<>();
		if("undefined".equals(dept)||dept==null||"".equals(dept)){
			opList=patientLinkDao.getByPlanTime(start,end);
		}else {
			opList = patientLinkDao.getByPlanTimeDept(start, end,dept);
		}

		List<Operation1> Oper = JsonToDate1(opList);
		Collections.sort(Oper, new Comparator<Operation1>() {
			@Override
			public int compare(Operation1 o1, Operation1 o2) {
				int i = 0;
				if (o1.getOpenRoom() != null && !("").equals(o1.getOpenRoom()) && !(" ").equals(o1.getOpenRoom()) && !("").equals(o2.getOpenRoom()) && o2.getOpenRoom() != null && !(" ").equals(o2.getOpenRoom())) {
					i = Integer.parseInt(o1.getOpenRoom().trim()) - Integer.parseInt(o2.getOpenRoom().trim());
					if (i == 0) {
						return Integer.parseInt(o1.getOpenRoom().trim()) - Integer.parseInt(o2.getOpenRoom().trim().trim());
					}
				}
				return i;
			}
		});
		List<Operation1> Operation1 = new ArrayList<Operation1>();
		int page = Oper.size() / paibanNum;
		if (Oper.size() % paibanNum > 0) {
			page = page + 1;
		}
		// 设置分页
		if (O.getPageNum() < 0 || page <= O.getPageNum()) {
			O.setPageNum(0);
		}
		for (int i = paibanNum * O.getPageNum(); i < paibanNum * O.getPageNum() + paibanNum; i++) {
			if (i == Oper.size()) {
				break;
			}
			Operation1.add(Oper.get(i));

		}
		for (;;) {
			if (Operation1.size() < paibanNum) {
				Operation1 Opera = new Operation1();
				Operation1.add(Opera);
			} else {
				break;
			}
		}
		ajax.addHashMap("paiBanTable", peizhi.getPaiBanTable());
		ajax.addHeader(MsgType.SUCCESS, "ok");
		ajax.addMap(Operation1);
		ajax.addCount(Oper.size());
		ajax.addHashMap("page", O.getPageNum());
		return ajax;
	}

	@RequestMapping(value = "paibanA", method = RequestMethod.GET)
	public String paibanA(Model m) throws Exception {
		String n = "";
		if (hosname.equals("TL")) {
			n = "重庆市铜梁区人民医院";
		} else if (hosname.equals("NT")) {
			n = "重庆市南桐总医院";
		} else if (hosname.equals("FY")) {
			n = "重庆市妇幼保健院";
		} else if (hosname.equals("NS")) {
			n = "宁陕县人民医院";
		} else if (hosname.equals("LS")) {
			n = "灵山县第二人民医院";
		} else if (hosname.equals("DC")) {
			n = "德昌县人民医院";
		}else if (hosname.equals("GXDL")) {
			n = "广西东兰县人民医院";
		}else if(hosname.equals("tableForRongChangEY")){
			n = "重庆市荣昌区人民医院";
		}else if(hosname.equals("GSTS")){
			n = "天水市第二人民医院";
		}else if(hosname.equals("tableForChongQiJiangEY")){
			n = "重庆市綦江区妇幼保健院";
		}
		List<ConfigDepartments> configDepartmentsList=configDepartmentsDao.getAll();
		m.addAttribute("page", 0);
		m.addAttribute("Hospital", n);
		m.addAttribute("configDepartmentsList",configDepartmentsList);
		return "hospital/paibanAjax";
	}

	@RequestMapping(value = "jiashuA", method = RequestMethod.GET)
	public String jiashuA(Model m) throws Exception {
		String n = "";
		if (hosname.equals("TL")) {
			n = "重庆市铜梁区人民医院";
		} else if (hosname.equals("NT")) {
			n = "重庆市南桐总医院";
		} else if (hosname.equals("FY")) {
			n = "重庆市妇幼保健院";
		} else if (hosname.equals("NS")) {
			n = "宁陕县人民医院";
		} else if (hosname.equals("LS")) {
			n = "灵山县第二人民医院";
		} else if (hosname.equals("DC")) {
			n = "德昌县人民医院";
		}else if (hosname.equals("GXDL")) {
			n = "广西东兰县人民医院";
		}else if(hosname.equals("tableForRongChangEY")){
			n = "重庆市荣昌区人民医院";
		}else if(hosname.equals("GSTS")){
			n = "天水市第二人民医院";
		}else if(hosname.equals("tableForChongQiJiangEY")){
			n = "重庆市綦江区妇幼保健院";
		}
		m.addAttribute("page", 0);
		m.addAttribute("Hospital", n);
		return "hospital/jiashuAjax";
	}

	@ResponseBody
	@RequestMapping(value = "jiashuAjax", method = RequestMethod.GET)
	public Object jiashuAjax(HttpServletRequest request) throws Exception {
		Map<String, Object> params = FrontHelper.transfParams(request);
		String Pdata = params.get(ParameterConstants.DATA).toString();
		Operation1 O = (Operation1) JsonUtilTool.json2Object(Pdata, Operation1.class);
		PeiZhi peizhi = peiZhiDaoImpl.getAll().get(0);
		Date start = DateUtil.oneDaystart(new Date());
		Date end = DateUtil.oneDayend(new Date());
		List<PatientLink> opList = patientLinkDao.getByPlanTime(start, end);
		List<PatientLink> deleteOp = new ArrayList<>();
		for (PatientLink p : opList){
			if (p.getApplication().getDetailstatus().equals(Constants.OR_STATUS_FLAG_SCHEDULED) || p.getApplication().getDetailstatus().equals(Constants.OR_STATUS_FLAG_APPLIED) ){
				deleteOp.add(p);
			}
		}
		opList.removeAll(deleteOp);
		List<Operation1> Oper = JsonToDate(opList);
		Collections.sort(Oper, new Comparator<Operation1>() {
			@Override
			public int compare(Operation1 o1, Operation1 o2) {
				int i = 0;
				if (o1.getOpenRoom() != null && !("").equals(o1.getOpenRoom()) && !(" ").equals(o1.getOpenRoom()) && !("").equals(o2.getOpenRoom()) && o2.getOpenRoom() != null && !(" ").equals(o2.getOpenRoom())) {
					i = Integer.parseInt(o1.getOpenRoom().trim()) - Integer.parseInt(o2.getOpenRoom().trim());
					if (i == 0) {
						return Integer.parseInt(o1.getOpenRoom().trim()) - Integer.parseInt(o2.getOpenRoom().trim().trim());
					}
				}
				return i;
			}
		});
		System.out.println(Oper.size());
		List<Operation1> Operation1 = new ArrayList<Operation1>();
		int page = Oper.size() / paibanNum;
		if (Oper.size() % paibanNum > 0) {
			page = page + 1;
		}
		// 设置分页
		if (O.getPageNum() < 0 || page <= O.getPageNum()) {
			O.setPageNum(0);
		}
		for (int i = paibanNum * O.getPageNum(); i < paibanNum * O.getPageNum() + paibanNum; i++) {
			if (i == Oper.size()) {
				break;
			}
			Operation1.add(Oper.get(i));
		}
		for (;;) {
			if (Operation1.size() < paibanNum) {
				Operation1 Opera = new Operation1();
				Operation1.add(Opera);
			} else {
				break;
			}
		}
		ajax.addHashMap("jiashu", peizhi.getJiaShu());
		ajax.addHeader(MsgType.SUCCESS, "ok");
		ajax.addMap(Operation1);
		ajax.addCount(Oper.size());
		ajax.addHashMap("page", O.getPageNum());
		return ajax;
	}

	@RequestMapping(value = "paibanPZ", method = RequestMethod.GET)
	public String paibanPZ(Model m) throws Exception {
		PeiZhi peizhi = peiZhiDaoImpl.getAll().get(0);
		m.addAttribute("paiban", peizhi.getPaiBanTable());
		return "hospital/paibanPZ";
	}

	@RequestMapping(value = "jiashuPZ", method = RequestMethod.GET)
	public String jiashuPZ(Model m) throws Exception {
		PeiZhi peizhi = peiZhiDaoImpl.getAll().get(0);
		m.addAttribute("jiashu", peizhi.getJiaShu());
		return "hospital/jiashuPZ";
	}

	@RequestMapping(value = "jiashuUp", method = RequestMethod.GET)
	public String jiashuUp(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> params = FrontHelper.transfParams(request);
		String data = params.get(ParameterConstants.DATA).toString();
//		String name = new String(data.getBytes("ISO-8859-1"), "UTF-8");
		String name = data;
		JiaShu peizhi = (JiaShu) JsonUtilTool.json2Object(name, JiaShu.class);
		peiZhiDaoImpl.updateJiashu(peizhi);
		return "redirect:/commandController/jiashuPZ.do";
	}

	@RequestMapping(value = "paibanUp", method = RequestMethod.GET)
	public String paibanUp(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
		Map<String, Object> params = FrontHelper.transfParams(request);
		String data = params.get(ParameterConstants.DATA).toString();
//		String name = new String(data.getBytes("ISO-8859-1"), "UTF-8");
		String name = data;
		PaiBanTable peizhi = (PaiBanTable) JsonUtilTool.json2Object(name, PaiBanTable.class);
		peiZhiDaoImpl.updatePaiban(peizhi);
		return "redirect:/commandController/paibanPZ.do";

	}

	private List<Operation1> JsonToDate(List<PatientLink> opList) throws Exception {
		List<Operation1> Operation1 = new ArrayList<Operation1>();
		for (PatientLink o : opList) {
			Operation1 op = new Operation1();
			// 姓名
			String name = o.getPatient().getBrxm();
			if (name.length() > 1) {
				name = name.substring(0, 1) + "*" + name.substring(2);
				op.setBEname(name);
			} else {
				continue;
			}
			// 性别
			String sex = o.getPatient().getXb();
			op.setSex(sex);
			// 年龄
			String age = o.getPatient().getNl();
			op.setStrAge(age);
			// 科室
			String ksmc = o.getPatient().getKsmc();
			op.setKeshi(ksmc);
			op.setBingshi(ksmc);
			if (o.getSchedule() != null) {
				// 手术间号
				String operoom = o.getSchedule().getPbssjh();
				op.setOpenRoom(operoom);
			}
			// 手术名称
			String nishiOper = o.getApplication().getNsssmc();
			if (nishiOper.length() > 15) {
				nishiOper = nishiOper.substring(0, 15) + "..";
			}
			op.setShoushuName1(nishiOper);
			// 状态
			if (o.getAnesthesiaRecord().getZmys() != null && !"".equals(o.getAnesthesiaRecord().getZmys())){
				op.setMazuiDoc1(covertId2Name(o.getAnesthesiaRecord().getZmys()));
			}
			if (o.getAnesthesiaRecord().getOperDoctor1() != null && !"".equals(o.getAnesthesiaRecord().getOperDoctor1())) {
				op.setOperDoctor1(covertId2Name(o.getAnesthesiaRecord().getOperDoctor1()));
			}
			String status = o.getApplication().getStatus();
			if (status.equals("手术前")) {
				if (!o.getApplication().getType().equals("schedule")) {
					status = "手 术 前";
				}
			}
			String flag = o.getApplication().getDetailstatus();
			
			if (("NT").equals(hosname)) {
				if (!status.equals("麻醉术中")) {
					continue;
				}
				if (o.getStatus().getInRoomTime() != null) {
					flag = "入手术室";
				}
				if (o.getStatus().getOperStartTime() != null) {
					flag = "手术中";
				}
				if (o.getStatus().getMazuiStartTime() != null) {
					flag = "麻醉术中";
				}
				if (o.getStatus().getMazuiEndTime() != null) {
					flag = "麻醉结束";
				}
				if (o.getStatus().getOperEndTime() != null) {
					flag = "手术结束";
				}
				if (o.getStatus().getOutRoomTime() != null) {
					flag = "出手术间";
				}
				if (o.getStatus().getInPacuTime() != null) {
					flag = "入复苏室";
				}
				if (o.getStatus().getOutPacuTime() != null) {
					flag = "出复苏室";
				}
			}
			if (flag.equals(Constants.OR_STATUS_FLAG_APPLIED)) {
				flag="手术前";
			}
			if (flag.equals(Constants.OR_STATUS_FLAG_IN_ROOM)) {
				flag="手术中";
			}
			if (flag.equals(Constants.OR_STATUS_FLAG_OUT_ROOM)) {
				flag="手术后";
			}
			if (("tableForRongChangEY").equals(hosname)||("tableForChongQiJiangEY").equals(hosname)){
				if (o.getStatus().getInRoomTime() != null) {
					flag = "入手术室";
				}
				if (o.getStatus().getMazuiStartTime() != null) {
					flag = "麻醉开始";
				}
				if (o.getStatus().getOperStartTime() != null) {
					flag = "手术开始";
				}
				if (o.getStatus().getOperEndTime() != null) {
					flag = "手术结束";
				}
				if (o.getStatus().getMazuiEndTime() != null) {
					flag = "麻醉结束";
				}
				if (o.getStatus().getOutRoomTime() != null) {
					flag = "出手术间";
				}
				if (o.getStatus().getInPacuTime() != null) {
					flag = "入复苏室";
				}
				if (o.getStatus().getOutPacuTime() != null) {
					flag = "出复苏室";
				}
//				if (o.getStatus().getOutPacuTime() != null){
//					Date outPacutime = nextTime(o.getStatus().getOutPacuTime() , 5);
//					if (new Date().after(outPacutime)){
//						continue;
//					}
//				}else if(o.getStatus().getOutRoomTime() != null){
//					Date outPacutime = nextTime(o.getStatus().getOutRoomTime() , 5);
//					if (new Date().after(outPacutime)){
//						continue;
//					}
//				}
			}
			op.setFlag(flag);
			if (status.equals("未排班")) {
				op.setFlag(status);
				continue;
			}
			// 手术时间
			Date date = o.getApplication().getYysssj();
			String planTimeStr = simpleDateFormat.format(date);
			op.setPlanTime(planTimeStr);
			Operation1.add(op);
		}
		return Operation1;
	}
	/**
	 * 返回起始 + 分钟　格式：yyyy-MM-dd hh:mm:ss
	 *
	 * @return String
	 */
	public static Date nextTime(Date beginDate, int num) {
		Calendar c = Calendar.getInstance();
		c.setTime(beginDate);
		c.add(Calendar.MINUTE, num);
		return c.getTime();
	}

	// 排班
	private List<Operation1> JsonToDate1(List<PatientLink> opList) throws Exception {
		List<Operation1> operation1s = new ArrayList<Operation1>();
		for (PatientLink o : opList) {
			Operation1 op = new Operation1();
			// 姓名
			String name = o.getPatient().getBrxm();
			op.setBEname(name);
			// 性别
			String sex = o.getPatient().getXb();
			op.setSex(sex);
			// 年龄
			String age = o.getPatient().getNl();
			op.setStrAge(age);
			// 科室
			String ksmc = o.getPatient().getKsmc();
			op.setKeshi(ksmc);
			op.setBingshi(ksmc);
			if (o.getSchedule() != null) {
				// 手术间号
				String operoom = o.getSchedule().getPbssjh();
				op.setOpenRoom(operoom);
			}
			// 手术名称
			String nishiOper = o.getApplication().getNsssmc();
			if (nishiOper.length() > 15) {
				nishiOper = nishiOper.substring(0, 15) + "..";
			}
			op.setShoushuName1(nishiOper);
			// 状态
			String status = o.getApplication().getDetailstatus();
			if (status.equals("手术前")) {
				if (!o.getApplication().getType().equals("schedule")) {
					status = "手 术 前";
				}
			}
			op.setFlag(status);
			if (status.equals("未排班")) {
				continue;
			}
			// 手术时间
			Date date = o.getApplication().getYysssj();
			String planTimeStr = simpleDateFormat.format(date);
			op.setPlanTime(planTimeStr);
			// 麻醉医师
//			if (o.getSchedule().getMzysbh1() != null && !"".equals(o.getSchedule().getMzysbh1())) {
//				op.setMazuiDoc1(covertId2Name( o.getSchedule().getMzysbh1()));
//			}
			if (o.getAnesthesiaRecord().getZmys() != null && !"".equals(o.getAnesthesiaRecord().getZmys())){
				op.setMazuiDoc1(covertId2Name(o.getAnesthesiaRecord().getZmys()));
			}

			// 麻醉方式
			if ((o.getAnesthesiaRecord() != null && (o.getAnesthesiaRecord().getMzff() != null && !"".equals(o.getAnesthesiaRecord().getMzff())))) {
				op.setMazuiMethod(o.getAnesthesiaRecord().getMzff());
			} else {
				if (o.getSchedule().getMzfs() != null && !"".equals(o.getSchedule().getMzfs())) {
					op.setMazuiMethod(o.getSchedule().getMzfs());
				} else {
					op.setMazuiMethod("");
				}
			}
			// 洗手护士
			if (o.getSchedule().getQxhsbh1() != null && !"".equals(o.getSchedule().getQxhsbh1())) {
				op.setXshs(covertId2Name(o.getSchedule().getQxhsbh1()));
			}// 巡回护士
			if (o.getSchedule().getXhhsbh1() != null && !"".equals(o.getSchedule().getXhhsbh1())) {
				op.setXhhs(covertId2Name(o.getSchedule().getXhhsbh1()) );
			}
			// 主刀医生
//			if (o.getApplication().getSsysxm() != null && !"".equals(o.getApplication().getSsysxm())) {
//				op.setOperDoctor1(o.getApplication().getSsysxm());
//			}
			if (o.getAnesthesiaRecord().getOperDoctor1() != null && !"".equals(o.getAnesthesiaRecord().getOperDoctor1())) {
				op.setOperDoctor1(covertId2Name(o.getAnesthesiaRecord().getOperDoctor1()));
			}

			operation1s.add(op);
		}
		return operation1s;
	}
	
	public String  covertId2Name(String id) {
		if (id==null || "".equals(id)) {
			return "";
		}else {
			Account account= accountDao.findById(id);
			if (account==null) {
				return "";
			}else {
				return account.getTrueName();
			}
		}
	}

}
