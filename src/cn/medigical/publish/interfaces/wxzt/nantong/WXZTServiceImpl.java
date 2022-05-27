package cn.medigical.publish.interfaces.wxzt.nantong;

import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.PatientEventsDao;
import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.interfaces.wxzt.WXZTInfo;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.patient.Patient;
import cn.medigical.publish.pojo.patient.PatientEvents;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.utils.SpringUtils;
import cn.medigical.publish.xmlUtil.nantong.WXZTResponseXml;
import cn.medigical.publish.xmlUtil.tongliang.NISRequestXml;

import java.util.*;

public class WXZTServiceImpl {
    String methodIdString = null;
    PatientEventsDao patientEventsDao = SpringUtils.getBean(PatientEventsDao.class);
    PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);
    AccountDao accountDao = SpringUtils.getBean(AccountDao.class);

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
            List<WXZTInfo> nisOperInfoList = new ArrayList<WXZTInfo>();
            for (Patient patient : patientList) {
                WXZTInfo nisOperInfo = setWXZTInfo(patient.getZyh(), patient.getZycs());
                nisOperInfoList.add(nisOperInfo);
            }
            responseXml = new WXZTResponseXml().getWXZTResponseXml(nisOperInfoList);

        }
        return responseXml;
    }

    public WXZTInfo setWXZTInfo(String zyh, String zycs) {
        WXZTInfo WXZTInfo = new WXZTInfo();
        try {
            PatientLink patientLink = patientLinkDao.getByZyhZycs(zyh, zycs);
            if (patientLink != null) {
                // 11)麻醉医师（字段名：MZYS，字符型：如：李四）（注：不是手术医生）
                WXZTInfo.setZHY(patientLink.getPatient().getZyh());
                WXZTInfo.setXM(patientLink.getPatient().getBrxm());
                WXZTInfo.setXB(patientLink.getPatient().getXb());
                WXZTInfo.setBQ(patientLink.getPatient().getBqmc());
                WXZTInfo.setCH(patientLink.getPatient().getZych());
                WXZTInfo.setNL(patientLink.getPatient().getNl());
                WXZTInfo.setTZ(patientLink.getPatient().getTz());
                WXZTInfo.setSG(patientLink.getPatient().getSg());
                WXZTInfo.setSSMC(patientLink.getAnesthesiaRecord().getYsss1());
                WXZTInfo.setASA(patientLink.getAnesthesiaRecord().getAsa().getLevel());
                Account account = accountDao.findAccountById(patientLink.getAnesthesiaRecord().getZmys());
                if (account != null) {
                    WXZTInfo.setMZYS(account.getTrueName());
                }
                WXZTInfo.setZTFS(getZtfs(patientLink));
                List<PatientEvents> patientEvents = patientEventsDao.getPatientEvents8PatientId(patientLink.getId());
                for (PatientEvents patientEvent : patientEvents) {
                    if (!patientEvent.getCode().contains("术后镇痛：")) continue;
                    WXZTInfo.setPF(patientEvent.getCode());
                    break;
                }
                WXZTInfo.setFB("");
                WXZTInfo.setSFZH(patientLink.getPatient().getSocialId());
                WXZTInfo.setKS(patientLink.getPatient().getKsmc());
                WXZTInfo.setHKDZ("");
                WXZTInfo.setBQZZ(patientLink.getAnesthesiaRecord().getShzd1());
                WXZTInfo.setSSSJ(patientLink.getStatus().getInRoomTime());
                WXZTInfo.setZYSJ("");
                WXZTInfo.setOPERID(patientLink.getHisID());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return WXZTInfo;
    }

    public String getZtfs(PatientLink p) {
        String qklx = "";
        if (p.getQualityPojo() != null) {
            if (p.getAnesthesiaRecord().getPCIA()) {
                qklx = "PCIA";
            } else if (p.getAnesthesiaRecord().getPCEA()) {
                qklx = "PCEA";
            } else if (p.getAnesthesiaRecord().getPCNA()) {
                qklx = "PCNA";
            } else if (p.getAnesthesiaRecord().getWyPCA()) {
                qklx = "未用PCA";
            }
        }
        return qklx;
    }

}
