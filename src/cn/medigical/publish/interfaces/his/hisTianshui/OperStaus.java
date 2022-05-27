package cn.medigical.publish.interfaces.his.hisTianshui;

import cn.medigical.publish.dao.impl.AccountCache;
import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.utils.MyDateFormat;
import cn.medigical.publish.utils.SpringUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OperStaus {
	private static OperStaus instance;
	PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);
	AccountDao accountDao = SpringUtils.getBean(AccountDao.class);
	Account account=null;
	public static OperStaus getInstance() {
		if (instance == null) {
			instance = new OperStaus();
		}
		return instance;
	}

	public String writeEndOper2HIS(String patientId) {
		PatientLink patientLink = patientLinkDao.findById(patientId);
		reqRespData(stausMessage(patientLink));
		return "succes";
	}

	public void updateOperationStatus(String dateStr,String workId)  {
		Date date = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			date =simpleDateFormat.parse(dateStr);
			if(date==null)return;
			account=accountDao.findAccountByWorkID(workId);
			List<PatientLink> patientLinks = patientLinkDao.getArrangedOpers8TimeAndRoom(date);
			for (PatientLink p : patientLinks) {
				System.out.println(p.getPatient().getBrxm());
				reqRespData(paibanMessage(p));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String paibanMessage(PatientLink p) {
		String m = "<GetReturnScheduleTable xmlns=\"http://tempuri.org/\">\n   " +
                "    <ScheduleDate>" +  p.getSchedule().getPbssjh()  + "</ScheduleDate>\n" + 
				"    <shoushuhao>" +  p.getApplication().getSssqdh()  + "</shoushuhao>\n" + 
                "    <OperatingRoomNo>" + p.getSchedule().getPbssjh() + "</OperatingRoomNo>\n" + 
				"    <ChuangHao>" + p.getSchedule().getJhsssj() + "</ChuangHao>\n" + 
                "    <DeptStayed>" + p.getPatient().getKsmc() + "</DeptStayed>\n" + 
				"    <BedNO>" + p.getPatient().getZych() + "</BedNO>\n" + 
                "    <PatientName>" + p.getPatient().getBrxm() + "</PatientName>\n" + 
				"    <PatientSex>" + p.getPatient().getXb() + "</PatientSex>\n" + 
                "    <PatientAge>" + p.getPatient().getNl() + "</PatientAge>\n" + 
				"    <PatientId>" + p.getPatient().getZyh() + "</PatientId>\n" + 
                "    <NishiOperation>" + p.getApplication().getNsssmc()  + "</NishiOperation>\n" + 
				"    <OperDoctor>" + p.getApplication().getSsysxm() + "</OperDoctor>\n" + 
                "    <AnesthesiaMethod>" + p.getSchedule().getMzfs() + "</AnesthesiaMethod>\n" + 
				"    <FirstAnesthesiaDoctor>" + p.getSchedule().getMzysbh1() + "</FirstAnesthesiaDoctor>\n" + 
                "    <SecondAnesthesiaDoctor>" +  p.getSchedule().getMzysbh1()  + "</SecondAnesthesiaDoctor>\n" + 
				"    <QiXieNurse>" +  p.getSchedule().getQxhsbh1()  + "</QiXieNurse>\n" + 
                "    <XunHuiNurse>" +  p.getSchedule().getXhhsbh1()  + "</XunHuiNurse>\n" + 
				"    <ChuanRanBing>" + p.getApplication().getGrlx() + "</ChuanRanBing>\n" + 
                "    <TeShuZhunBei>" + p.getApplication().getTszb() + "</TeShuZhunBei>\n" + 
				"    <Remark>" + "" + "</Remark>\n" +
                "    <caozuoyonghuid>" + account.getWorkID() + "</caozuoyonghuid>\n" + 
				"    <caozuoyonghuming>" + account.getTrueName() + "</caozuoyonghuming>\n" + 
                "    <caozuokeshiid>" + "SSS" + "</caozuokeshiid>\n" +
            "</GetReturnScheduleTable>";
		return m;
	}
	public String stausMessage(PatientLink p) {
		String m = "<GetReturnShouMaXinXi xmlns=\"http://tempuri.org/\">" +
				"<OPER_ORDER_NO>" + p.getApplication().getSssqdh() + "</OPER_ORDER_NO>" +
				"<PatientId>" + p.getPatient().getZyh() + "</PatientId>" +
				"<OPER_ROOM>" + p.getSchedule().getPbssjh() + "</OPER_ROOM>" +
				"<OPER_NAME>" + p.getAnesthesiaRecord().getYsss1() + "</OPER_NAME>" +
				"<OPER_ID>" + p.getApplication().getSssqdh() + "</OPER_ID>" +
				"<OPER_AT>" + MyDateFormat.DATE_FORMAT_YMDHMS.format(p.getStatus().getInRoomTime()) + "</OPER_AT>" +
				"<OPEDOC_ID>" + AccountCache.getInstance().getAccount8Id(p.getAnesthesiaRecord().getOperDoctor1()).getWorkID() + "</OPEDOC_ID>" +
				"<OPEDOC_NAME>" + AccountCache.getInstance().getAccount8Id(p.getAnesthesiaRecord().getOperDoctor1()).getTrueName() + "</OPEDOC_NAME>" +
				"<ANES_DR_ID>" + AccountCache.getInstance().getAccount8Id(p.getAnesthesiaRecord().getZmys()).getWorkID() + "</ANES_DR_ID>" +
				"<ANES_DR_NAME>" + AccountCache.getInstance().getAccount8Id(p.getAnesthesiaRecord().getZmys()).getTrueName() + "</ANES_DR_NAME>" +
				"<OPER_DIAGNOSE>" + p.getAnesthesiaRecord().getShzd1() + "</OPER_DIAGNOSE>" +
				"<INCISION_GRADE>" + getIncision(p) + "</INCISION_GRADE>" +
				"<ASA>" + getASA(p) + "</ASA>" +
				"<NNIS>" + "" + "</NNIS>" +
				"<URGENT_OPE>" + getjz(p) + "</URGENT_OPE>" +
				"<NARC_KIND>" + p.getAnesthesiaRecord().getMzff() + "</NARC_KIND>" +
				"<OPER_START_TIME>" +MyDateFormat.DATE_FORMAT_YMDHMS.format( p.getStatus().getOperStartTime()) + "</OPER_START_TIME>" +
				"<OPER_END_TIME>" +MyDateFormat.DATE_FORMAT_YMDHMS.format( p.getStatus().getOperEndTime()) + "</OPER_END_TIME>" +
				"<OPER_LENG_TIME>" + p.getStatus().getOperSpanTime() + "</OPER_LENG_TIME>" +
				"<DEPT_ID>" + p.getApplication().getSqksbh() + "</DEPT_ID>" +
				"<DEPT_NAME>" + p.getApplication().getSqksmc() + "</DEPT_NAME>" +
				"<OPEDOC_NAME2>" + AccountCache.getInstance().getAccount8Id(p.getAnesthesiaRecord().getOperDoctor2()).getTrueName() + "</OPEDOC_NAME2>" +
				"<OPEDOC_NAME3>" + AccountCache.getInstance().getAccount8Id(p.getAnesthesiaRecord().getOperDoctor3()).getTrueName() + "</OPEDOC_NAME3>" +
				"<NURSE_NAME1>" + AccountCache.getInstance().getAccount8Id(p.getAnesthesiaRecord().getXhhs1()).getTrueName() + "</NURSE_NAME1>" +
				"<NURSE_NAME2>" + AccountCache.getInstance().getAccount8Id(p.getAnesthesiaRecord().getXshs1()).getTrueName() + "</NURSE_NAME2>" +
				"</GetReturnShouMaXinXi>";
		return m;
	}
	
	public String getjz(PatientLink p) {
		if (p.getAnesthesiaRecord() != null && p.getAnesthesiaRecord().getAsa() != null && p.getAnesthesiaRecord().getAsa().getJz()) {
			return "0";
		}
		return "1";
	}

	public String getASA(PatientLink p) {
		if (p.getAnesthesiaRecord() != null && p.getAnesthesiaRecord().getAsa() != null) {
			return p.getAnesthesiaRecord().getAsa().getLevel();
		}
		return "";
	}
	public String getIncision(PatientLink p) {
		String qklx = "";
		if (p.getQualityPojo() != null) {
			if (p.getQualityPojo().getSsqkfl1()) {
				qklx = "Ⅰ级";
			} else if (p.getQualityPojo().getSsqkfl2()) {
				qklx = "Ⅱ级";
			} else if (p.getQualityPojo().getSsqkfl3()) {
				qklx = "Ⅲ级";
			} else if (p.getQualityPojo().getSsqkfl4()) {
				qklx = "Ⅳ级";
			}
		}
		return qklx;
	}
	public String getMessage(String paibanMessage) {
		String message = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" + "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">" + "<soap12:Body>" + paibanMessage + "</soap12:Body>" + "</soap12:Envelope>";
		return message;
	}
	
	public String reqRespData(String message) {
		String xml = getMessage(message);
		System.out.println(xml);
		String urlString = "http://192.168.2.224/crds3/ShouMaHisWebService.asmx";
		HttpURLConnection httpConn = null;
		OutputStream out = null;
		String returnXml = "";
		BufferedReader reader;
		try {
			httpConn = (HttpURLConnection) new URL(urlString).openConnection();
			httpConn.setRequestProperty("Content-Type", "application/soap+xml; charset=utf-8");
			httpConn.setRequestMethod("POST");
			httpConn.setDoOutput(true);
			httpConn.setDoInput(true);
			httpConn.connect();
			out = httpConn.getOutputStream();
			httpConn.getOutputStream().write(xml.getBytes());
			out.flush();
			out.close();
			int code = httpConn.getResponseCode();
			String tempString = null;
			StringBuffer sb1 = new StringBuffer();
			if (code == 200) {
				reader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
				while ((tempString = reader.readLine()) != null) {
					sb1.append(tempString);
				}
				if (null != reader)
					reader.close();
			} else {
				reader = new BufferedReader(new InputStreamReader(httpConn.getErrorStream(), "UTF-8"));
				while ((tempString = reader.readLine()) != null) {
					sb1.append(tempString);
				}
				if (null != reader) {
					reader.close();
				}
			}
			returnXml = sb1.toString();
		} catch (Exception e) {
			e.getMessage();
		}
		System.out.println(returnXml);
		return returnXml;
	}

}
