package cn.medigical.publish.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.medigical.publish.utils.AjaxMsg;
import cn.medigical.publish.utils.SpringUtils;
import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.dao.impl.PatientVitalSignsDao;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.daPing.Operation1;
import cn.medigical.publish.pojo.patient.PatientVitalSigns;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.pojo.vitalSign.VitalSignCache;
import cn.medigical.publish.pojo.vitalSign.WorkStation;

@Controller
@RequestMapping("ZhurengongzuozhanController")
public class ZhurengongzuozhanController {
	private AjaxMsg ajax = AjaxMsg.newInstance();

	AccountDao accountDao = (AccountDao) SpringUtils.getBean(AccountDao.class);
	PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);
	PatientVitalSignsDao patientVitalSignsDao = SpringUtils.getBean(PatientVitalSignsDao.class);;

	@RequestMapping("Zhurengongzuozhan")
	public String Zhurengongzuozhan(Model m) {
		try {
			List<PatientLink> patientLinks = patientLinkDao.findinroom();
			List<WorkStation> workStations = new ArrayList<WorkStation>();
			WorkStation workStation = null;
			for (PatientLink op : patientLinks) {
				workStation = new WorkStation();
				if (op.getAnesthesiaRecord().getOperDoctor1() != null && !op.getAnesthesiaRecord().getOperDoctor1().equals("")) {
					Account account=accountDao.findById(op.getAnesthesiaRecord().getOperDoctor1());
					if(account==null){
						workStation.setDocname("");
					}
					else{
						workStation.setDocname(account.getTrueName());
					}	
				}
				workStation.setPbssjh(op.getSchedule().getPbssjh());
				workStation.setPid(op.getId());
				workStation.setNurname(getNurseName(op));
				PatientVitalSigns b = patientVitalSignsDao.findOneShuZhang(op.getId());
				if (b != null) {
					workStation.setShuzhangya(b.getModValue());
				} else {
					workStation.setShuzhangya("");
				}
				PatientVitalSigns b1 = patientVitalSignsDao.findOneSouShuo(op.getId());
				if (b1 != null) {
					workStation.setShousuoya(b1.getModValue());
				} else {
					workStation.setShousuoya("");
				}
				PatientVitalSigns b2 = patientVitalSignsDao.findOneXingLv(op.getId());
				if (b2 != null) {
					workStation.setXinglv(b2.getModValue());
				} else {
					workStation.setXinglv("");
				}
				PatientVitalSigns b3 = patientVitalSignsDao.findOneXueYang(op.getId());
				if (b3 != null) {
					workStation.setXueyang(b3.getModValue());
				} else {
					workStation.setXueyang("");
				}
			}
			workStations.add(workStation);
			Collections.sort(patientLinks, new Comparator<PatientLink>() {
				@Override
				public int compare(PatientLink o1, PatientLink o2) {
					int i = 0;
					if (o1.getSchedule().getPbssjh() != null && o1.getSchedule().getPbssjh() != "" && o2.getSchedule().getPbssjh() != null && o2.getSchedule().getPbssjh() != "") {
						i = Integer.parseInt(o1.getSchedule().getPbssjh()) - Integer.parseInt(o2.getSchedule().getPbssjh());
						if (i == 0) {
							return Integer.parseInt(o1.getSchedule().getPbssjh()) - Integer.parseInt(o2.getSchedule().getPbssjh());
						}
					}
					return i;
				}
			});
			m.addAttribute("operations", workStations);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "zhurengongzuozhan/zhurengongzuozhan";
	}

	@ResponseBody
	@RequestMapping("ZhurengongzuozhanAjax")
	public Object ZhurengongzuozhanAjax(Model m) {
		try {
			ajax.clear();
			List<PatientLink> operation1s = patientLinkDao.findinroom();
			List<WorkStation> workStations = new ArrayList<WorkStation>();
			WorkStation workStation = null;
			for (PatientLink op : operation1s) {
				workStation = new WorkStation();
				if (op.getAnesthesiaRecord().getOperDoctor1() != null && !op.getAnesthesiaRecord().getOperDoctor1().equals("")) {
					Account account=accountDao.findById(op.getAnesthesiaRecord().getOperDoctor1());
					if(account==null){
						workStation.setDocname("");
					}
					else{
						workStation.setDocname(account.getTrueName());
					}					
				}
				workStation.setPbssjh(op.getSchedule().getPbssjh());
				workStation.setPid(op.getId());
				workStation.setNurname(getNurseName(op));
				PatientVitalSigns b = patientVitalSignsDao.findOneShuZhang(op.getId());
				if (b != null) {
					workStation.setShuzhangya(b.getModValue());
				} else {
					workStation.setShuzhangya("");
				}
				PatientVitalSigns b1 = patientVitalSignsDao.findOneSouShuo(op.getId());
				if (b1 != null) {
					workStation.setShousuoya(b1.getModValue());
				} else {
					workStation.setShousuoya("");
				}
				PatientVitalSigns b2 = patientVitalSignsDao.findOneXingLv(op.getId());
				if (b2 != null) {
					workStation.setXinglv(b2.getModValue());
				} else {
					workStation.setXinglv("");
				}
				PatientVitalSigns b3 = patientVitalSignsDao.findOneXueYang(op.getId());
				if (b3 != null) {
					workStation.setXueyang(b3.getModValue());
				} else {
					workStation.setXueyang("");
				}
			}
			workStations.add(workStation);
			Collections.sort(operation1s, new Comparator<PatientLink>() {
				@Override
				public int compare(PatientLink o1, PatientLink o2) {
					int i = 0;
					if (o1.getSchedule().getPbssjh() != null && o1.getSchedule().getPbssjh() != "" && o2.getSchedule().getPbssjh() != null && o2.getSchedule().getPbssjh() != "") {
						i = Integer.parseInt(o1.getSchedule().getPbssjh()) - Integer.parseInt(o2.getSchedule().getPbssjh());
						if (i == 0) {
							return Integer.parseInt(o1.getSchedule().getPbssjh()) - Integer.parseInt(o2.getSchedule().getPbssjh());
						}
					}
					return i;
				}
			});
			ajax.addMap(workStations);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ajax;
	}

	public String getNurseName(PatientLink p) {
		String name = "";
		if (p.getSchedule().getXhhsbh1() != null && p.getSchedule().getXhhsbh1().length() > 20) {
			Account c = accountDao.findById(p.getSchedule().getXhhsbh1());
			name = c.getTrueName();
		}
		if (p.getSchedule().getXhhsbh2() != null && p.getSchedule().getXhhsbh2().length() > 20) {
			Account c = accountDao.findById(p.getSchedule().getXhhsbh2());
			if (c != null) {
				name = name + "," + c.getTrueName();
			}
		}
		if (p.getSchedule().getXhhsbh3() != null && p.getSchedule().getXhhsbh3().length() > 20) {
			Account c = accountDao.findById(p.getSchedule().getXhhsbh3());
			if (c != null) {
				name = name + "," + c.getTrueName();
			}
		}
		if (p.getSchedule().getQxhsbh1() != null && p.getSchedule().getQxhsbh1().length() > 20) {
			Account c = accountDao.findById(p.getSchedule().getQxhsbh1());
			if (c != null) {
				name = name + "," + c.getTrueName();
			}
		}
		if (p.getSchedule().getQxhsbh2() != null && p.getSchedule().getQxhsbh2().length() > 20) {
			Account c = accountDao.findById(p.getSchedule().getQxhsbh2());
			if (c != null) {
				name = name + "," + c.getTrueName();
			}
		}
		if (p.getSchedule().getQxhsbh3() != null && p.getSchedule().getQxhsbh3().length() > 20) {
			Account c = accountDao.findById(p.getSchedule().getQxhsbh3());
			if (c != null) {
				name = name + "," + c.getTrueName();
			}
		}
		return name;
	}
}