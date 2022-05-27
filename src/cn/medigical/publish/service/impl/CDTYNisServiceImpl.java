package cn.medigical.publish.service.impl;

import cn.medigical.publish.dao.impl.PatientEventsDao;
import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigEventsDao;
import cn.medigical.publish.interfaces.nis.tongliang.NisOperEvents;
import cn.medigical.publish.interfaces.nis.tongliang.NisOperInfo;
import cn.medigical.publish.pojo.patient.Patient;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.utils.MyDateFormat;
import cn.medigical.publish.utils.SpringUtils;
import cn.medigical.publish.xmlUtil.ServicesSign;
import cn.medigical.publish.xmlUtil.tongliang.NISRequestXml;
import cn.medigical.publish.xmlUtil.tongliang.NISResponseXml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CDTYNisServiceImpl {
	String methodIdString = null;
	PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);
	PatientEventsDao patientEventsDao = SpringUtils.getBean(PatientEventsDao.class);
	ConfigEventsDao configEventsDao = SpringUtils.getBean(ConfigEventsDao.class);

	public String progress(String XmlString) {
		String responseXml = "";
		NISRequestXml yuanGanInfoXml = new NISRequestXml();
		Map map = yuanGanInfoXml.readRequestXML(XmlString);
		Iterator<String> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			String key1 = iterator.next();
			this.methodIdString = (String) map.get(key1);
			String key2 = iterator.next();
			List<Patient> patientList = (List<Patient>) map.get(key2);
			List<NisOperInfo> nisOperInfoList = new ArrayList();
			List<NisOperEvents> nisOperEventsList = new ArrayList();
			if (methodIdString.equalsIgnoreCase(ServicesSign.GETNIS_OPERATIONBBYPATIENTID)) {
				for (Patient patient : patientList) {
					NisOperInfo nisOperInfo = setNisOperInfo(patient.getZyh(), patient.getZycs());
					nisOperInfoList.add(nisOperInfo);
				}
				responseXml = new NISResponseXml().getNisOperInfoResponseXml(nisOperInfoList);
			}
		}
		return responseXml;
	}

	public NisOperInfo setNisOperInfo(String zyh, String zycs) {
		NisOperInfo nisOperInfo = new NisOperInfo();
		try {
			PatientLink patientLink = patientLinkDao.getByZyhZycs(zyh, zycs);
			if (patientLink != null) {

				nisOperInfo.setHIS_ID(patientLink.getHisID());
				nisOperInfo.setPATIENT_TYPE("1");
				nisOperInfo.setSSBH("");
//				nisOperInfo.setCUT_GRADE(patientLink.getFengXianPingGu().getSsqkqj());
				nisOperInfo.setOFFICE(patientLink.getPatient().getKsmc());
				nisOperInfo.setOFFICE_ID(patientLink.getPatient().getKsbh());
				
				nisOperInfo.setPATIENT_ID(patientLink.getPatient().getZyh());//住院号

				nisOperInfo.setVISIT_ID(patientLink.getPatient().getZycs());//住院次数

				nisOperInfo.setOPER_ID(patientLink.getHisID());

				nisOperInfo.setOPER_NAME(patientLink.getAnesthesiaRecord().getYsss1());

				nisOperInfo.setOPER_CODE(patientLink.getHisID());//?

				nisOperInfo.setOPER_DIAGNOSIS(patientLink.getAnesthesiaRecord().getShzd1());

				nisOperInfo.setSURGEON(patientLink.getAnesthesiaRecord().getOperDoctor1());

				nisOperInfo.setFIRSTAS(patientLink.getAnesthesiaRecord().getOperDoctor1Assistant1());
				nisOperInfo.setSSEZ(patientLink.getAnesthesiaRecord().getOperDoctor1Assistant2());
				nisOperInfo.setSSSZ(patientLink.getAnesthesiaRecord().getOperDoctor1Assistant3());

				nisOperInfo.setANESTHESTA(patientLink.getAnesthesiaRecord().getZmys());

				nisOperInfo.setANESTHESTA_METHOD(patientLink.getAnesthesiaRecord().getMzff());

				nisOperInfo.setSTART_DATE_TIME(MyDateFormat.DATE_FORMAT_YMDHMS.format(patientLink.getStatus().getOperStartTime()));

				nisOperInfo.setEND_DATE_TIME(MyDateFormat.DATE_FORMAT_YMDHMS.format(patientLink.getStatus().getOperEndTime()));

				nisOperInfo.setOPER_QUANTUM(patientLink.getStatus().getOperSpanTime() + "");

				if (patientLink.getQualityPojo().getSsqkfl1()) {
					nisOperInfo.setWOUND_GRADE("Ⅰ");
				} else if (patientLink.getQualityPojo().getSsqkfl1()) {
					nisOperInfo.setWOUND_GRADE("Ⅱ");
				} else if (patientLink.getQualityPojo().getSsqkfl1()) {
					nisOperInfo.setWOUND_GRADE("Ⅲ");
				} else if (patientLink.getQualityPojo().getSsqkfl1()) {
					nisOperInfo.setWOUND_GRADE("Ⅳ");
				} else {
					nisOperInfo.setWOUND_GRADE("0");
				}

				nisOperInfo.setASA(patientLink.getAnesthesiaRecord().getAsa().getLevel());

				nisOperInfo.setNNIS("");

				nisOperInfo.setHEAL("");

				nisOperInfo.setLOCATION(patientLink.getAnesthesiaRecord().getSstw());

				nisOperInfo.setOPER_TYPE(patientLink.getApplication().getType());

				nisOperInfo.setEMBED("");

				nisOperInfo.setENDOSCOPIC("");

				nisOperInfo.setOPER_ROOM(patientLink.getSchedule().getPbssjh());

				nisOperInfo.setBLOOD_OUT(patientLink.getAnesthesiaRecord().getLiquidInAndOut().getChuXueLiang());

				nisOperInfo.setBLOOD_IN(patientLink.getAnesthesiaRecord().getLiquidInAndOut().getXueJiang());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return nisOperInfo;
	}
//
//	public List<NisOperEvents> setNisOperEvent(String zyh, String zycs) {
//		List<NisOperEvents> list = new ArrayList();
//		try {
//			PatientLink patientLink = patientLinkDao.getByZyhZycs(zyh, zycs);
//			// String pid=patientLink.getId();
//			if (patientLink != null) {
//				List<PatientEvents> eventsLists = patientEventsDao.getEventExe8Time(patientLink.getId(), patientLink.getStatus().getInRoomTime(), patientLink.getStatus().getOutRoomTime());
//				for (PatientEvents event : eventsLists) {
//					NisOperEvents nisOperEvents = new NisOperEvents();
//					nisOperEvents.setPATIENT_ID(patientLink.getPatient().getZyh());
//
//					nisOperEvents.setVISIT_ID(patientLink.getPatient().getZycs());
//
//					nisOperEvents.setOPER_ID(patientLink.getHisID());
//
//					nisOperEvents.setEVENTS_ID(event.getId());
//
//					if (event.getCode().contains("event")) {
//						nisOperEvents.setEVENTS_NAME(configEventsDao.getName(event.getCode()).getName());
//					} else {
//						nisOperEvents.setEVENTS_NAME(event.getCode());
//
//					}
//					nisOperEvents.setEVENTS_TIME(MyDateFormat.DATE_FORMAT_YMDHMS.format(event.getBeginTime()));
//
//					nisOperEvents.setEVENTS_TYPE("");
//
//					nisOperEvents.setADMINISTRATION("术中");
//
//					list.add(nisOperEvents);
//				}
//				List<PatientDrugs> drugsLists = patientDrugsDao.getPatientDrugs8Time(zyh, patientLink.getStatus().getInRoomTime(), patientLink.getStatus().getOutRoomTime());
//				for (PatientDrugs drug : drugsLists) {
//					NisOperEvents nisOperEvents = new NisOperEvents();
//					nisOperEvents.setPATIENT_ID(patientLink.getPatient().getZyh());
//
//					nisOperEvents.setVISIT_ID(patientLink.getPatient().getZycs());
//
//					nisOperEvents.setOPER_ID(patientLink.getHisID());
//
//					nisOperEvents.setEVENTS_ID(drug.getId());
//
//					nisOperEvents.setEVENTS_NAME(drug.getDrugs().getFullName());
//
//					nisOperEvents.setEVENTS_TIME(MyDateFormat.DATE_FORMAT_YMDHMS.format(drug.getBeginTime()));
//
//					nisOperEvents.setEVENTS_TYPE("");
//
//					nisOperEvents.setADMINISTRATION("术中");
//
//					list.add(nisOperEvents);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return list;
//
//	}
}
