package cn.medigical.publish.interfaces.his.hisTianshui;

import cn.medigical.publish.dao.impl.AccountCache;
import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigDepartmentsDao;
import cn.medigical.publish.interfaces.his.hisLink.HisLink;
import cn.medigical.publish.interfaces.his.hisLink.PojoBGA;
import cn.medigical.publish.interfaces.his.hisTianshui.soap.*;
import cn.medigical.publish.interfaces.lis.LisData;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.dictionary.ConfigDepartments;
import cn.medigical.publish.pojo.lis.JianYan;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.pojo.patientLink.ShuQianFanShi;
import cn.medigical.publish.utils.Constants;
import cn.medigical.publish.utils.MyDateFormat;
import cn.medigical.publish.utils.MyUtility;
import cn.medigical.publish.utils.SpringUtils;
import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class HisLinkTianshui extends HisLink {
    private static HisLinkTianshui instance;

    public static HisLinkTianshui getInstance() {
        if (instance == null) {
            instance = new HisLinkTianshui();
        }
        return instance;
    }

    protected String[] ageUnit = {Constants.AGE_UNIT_YEAR, Constants.AGE_UNIT_MONTH, Constants.AGE_UNIT_DAY};
    // List<ConfigDepartments> configDepartmentList = DataDictionary.getInstance().getConfigDepartmentsList();
    List<Account> accountList;
    SimpleDateFormat sdf = new SimpleDateFormat("");
    public Map<String, String> mazuimap = new HashMap();
    AccountDao accountDao = SpringUtils.getBean(AccountDao.class);
    PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);

    /**
     * 急诊
     * @return
     */
    public Boolean getPatientInfoFromHisByID(String zyh) {
        Boolean flag;
        // 获取his端的手术申请
        this.logger.warn(new Date()+"正在获取急诊病人，住院号：" + zyh);
        PatientLink hisPatientLink = getOprationFromHisByzyh(zyh);
        if (null == hisPatientLink ) {
            flag = false;
            return flag;
        } else {
            this.logger.warn(new Date()+"正在向数据库插入急诊病人"+hisPatientLink.getPatient().getBrxm());
            patientLinkDao.addUpdate(hisPatientLink);
        }
        flag = true;
        return flag;
    }

    public PatientLink getOprationFromHisByzyh(String zyh) {
        Map<String, Account> map = getAccount();

        cn.medigical.publish.interfaces.his.hisTianshui.soap.PatientInfoReqResp operationSchedule = new cn.medigical.publish.interfaces.his.hisTianshui.soap.PatientInfoReqResp();
        operationSchedule.setZyh(zyh);
        operationSchedule.reqRespData();

        cn.medigical.publish.interfaces.his.hisTianshui.xml.apply.ITEMType applyItemType = operationSchedule.getItemType();
        if (null == applyItemType) {
            return null;
        }

        PatientLink patientLink = new PatientLink();

        // 患者状态
        patientLink.getPatient().setStatus(Constants.FLAG_VALID);


        String patId = trimStr(applyItemType.getPatientId()); //住院号
        patientLink.getPatient().setZyh(patId);
        String hisID = trimStr(applyItemType.getScheduleId()); //手术单ID
        patientLink.setHisID(hisID);
        patientLink.getApplication().setSssqdh(hisID);
        String zych = trimStr(applyItemType.getBedNO()); // 床号
        patientLink.getPatient().setZych(zych);

        String shoushujb = trimStr(applyItemType.getShoushujb()); // 手术级别
        patientLink.getPatient().setSsdj(shoushujb);

        patientLink.setCreateDate(new Date());

        String ksmc = trimStr(applyItemType.getKeshiName());// 科室名称
        patientLink.getPatient().setKsmc(ksmc);
        patientLink.getApplication().setSqksmc(ksmc);
        String deptCode = trimStr(applyItemType.getDeptStayed());//科室ID
        patientLink.getApplication().setSqksbh(deptCode);

        patientLink.getAnesthesiaRecord().getAsa().setJz(true);
        patientLink.getAnesthesiaRecord().getAsa().setZq(false);

        String sqzd1 = trimStr(applyItemType.getDiagBeforeOperation());
        patientLink.getApplication().setSqzd1(sqzd1);

        String mzfs = trimStr(applyItemType.getAnesthesiaMethod()); // 麻醉方式
        patientLink.getSchedule().setMzfs(mzfs);
        patientLink.getApplication().setMzfs(mzfs);

        patientLink.getApplication().setYysssj(new Date());
        patientLink.getApplication().setSssqsj(new Date());

        // 设置主刀医生姓名和 code

        String zhuDaoGH = trimStr(applyItemType.getSurgeon());
        if (map.get(zhuDaoGH) != null){
            patientLink.getApplication().setSsysbh(map.get(zhuDaoGH).getId());
        }
        String zhuDaoZS1 = trimStr(applyItemType.getFirstAssistant());
        if (map.get(zhuDaoZS1) != null){
            patientLink.getApplication().setZlysbh1(map.get(zhuDaoZS1).getId());
        }
        String zhuDaoZS2 = trimStr(applyItemType.getSecondAssistant());
        if (map.get(zhuDaoZS2) != null){
            patientLink.getApplication().setZlysbh2(map.get(zhuDaoZS2).getId());
        }
        String zhuDaoZS3 = trimStr(applyItemType.getThirdAssistant());
        if (map.get(zhuDaoZS3) != null){
            patientLink.getApplication().setZlysbh3(map.get(zhuDaoZS3).getId());
        }
        String brxm = trimStr(applyItemType.getBrxm());
        patientLink.getPatient().setBrxm(brxm);
        String xb = trimStr(applyItemType.getXb());
        patientLink.getPatient().setXb(xb);
        String nl = trimStr(applyItemType.getNl());
        patientLink.getPatient().setNl(nl);
        String sg = trimStr(applyItemType.getSg());
        patientLink.getPatient().setSg(sg);
        String tz = trimStr(applyItemType.getTz());
        patientLink.getPatient().setTz(tz);


        StringBuilder nsssmc = new StringBuilder();
        nsssmc.append(applyItemType.getNsssmc1());
        if (applyItemType.getNsssmc2() != null && !applyItemType.getNsssmc2().equals("")){
            nsssmc.append("、" + applyItemType.getNsssmc2());
        }
        if (applyItemType.getNsssmc3() != null && !applyItemType.getNsssmc3().equals("")){
            nsssmc.append("、" + applyItemType.getNsssmc3());
        }
        if (applyItemType.getNsssmc4() != null && !applyItemType.getNsssmc4().equals("")){
            nsssmc.append("、" + applyItemType.getNsssmc4());
        }
        patientLink.getApplication().setNsssmc(nsssmc.toString());

        return patientLink;
    }

    /**
     * 获取手术申请
     * @return
     */
    public Boolean getOperationFromHis() {
        Boolean flag;
        // 获取his端的手术申请
        List<PatientLink> hisPatientLinkList = getOprationFromHis();
        if (null == hisPatientLinkList || hisPatientLinkList.size() == 0) {
            flag = false;
            return flag;
        } else {
            for (PatientLink patientLink : hisPatientLinkList   ) {
                List<PatientLink> patientLinkList = patientLinkDao.getScheduleTableOpersNTBySssqdh(patientLink.getApplication().getSssqdh());
                if (patientLinkList.size()>0){
                    this.logger.warn(new Date()+"跳过已存在病人---》"+patientLink.getPatient().getBrxm());
                    continue;
                }else{
                    this.logger.warn(new Date()+"正在向数据库插入病人---》"+patientLink.getPatient().getBrxm());
                    patientLinkDao.addUpdate(patientLink);
                }
            }
        }
        flag = true;
        return flag;
    }
    /**
     * 获取his 的手术申请
     * @return
     */
    public List<PatientLink> getOprationFromHis() {
        Map<String, Account> map = getAccount();
        List operationList = new ArrayList();

//        this.accountList = accountDao.gets();

        Calendar now = Calendar.getInstance();
        now.add(6, 2);
        Date dateNow = now.getTime();
        Date dateFrom = new Date(dateNow.getTime() - 345600000L);

        cn.medigical.publish.interfaces.his.hisTianshui.soap.OperationScheduleReqResp operationSchedule = new cn.medigical.publish.interfaces.his.hisTianshui.soap.OperationScheduleReqResp();
//        operationSchedule.setPid("ALL");
        operationSchedule.setStartTime(MyDateFormat.DATE_FORMAT_YMD.format(dateFrom));
        operationSchedule.setEndtTime(MyDateFormat.DATE_FORMAT_YMD.format(dateNow));
        operationSchedule.reqRespData();

        List<cn.medigical.publish.interfaces.his.hisTianshui.xml.apply.ITEMType> applyItemTypeList = operationSchedule.getItemTypeList();
        if (null == applyItemTypeList) {
            return null;
        }
        this.logger.warn("getOpration Start. getOpration Size=" + applyItemTypeList.size());
        for (cn.medigical.publish.interfaces.his.hisTianshui.xml.apply.ITEMType applyItemType : applyItemTypeList) {
            if (null == applyItemType) {
                continue;
            }
            PatientLink patientLink = new PatientLink();
            // 状态
            patientLink.getApplication().setDetailstatus(Constants.OR_STATUS_FLAG_APPLIED);
            // 手术状态
            patientLink.getApplication().setStatus(Constants.AP_STATUS_MAZUIQIAN);
            // 明细状态
            patientLink.getApplication().setDetailstatus(Constants.OR_STATUS_FLAG_APPLIED);
            // 患者状态
            patientLink.getPatient().setStatus(Constants.FLAG_VALID);

//            String visitID = trimStr(applyItemType.getVisitId());// 住院次数
//            patientLink.getPatient().setZycs(visitID);
            String patId = trimStr(applyItemType.getPatientId()); //住院号
            patientLink.getPatient().setZyh(patId);
            String hisID = trimStr(applyItemType.getScheduleId()); //手术单ID
            patientLink.setHisID(hisID);
            patientLink.getApplication().setSssqdh(hisID);
            String zych = trimStr(applyItemType.getBedNO()); // 床号
            patientLink.getPatient().setZych(zych);

            String shoushujb = trimStr(applyItemType.getShoushujb()); // 手术级别
            patientLink.getPatient().setSsdj(shoushujb);

            patientLink.setCreateDate(new Date());

            String ksmc = trimStr(applyItemType.getKeshiName());// 科室名称
            patientLink.getPatient().setKsmc(ksmc);
            patientLink.getApplication().setSqksmc(ksmc);
            String deptCode = trimStr(applyItemType.getDeptStayed());//科室ID
            patientLink.getApplication().setSqksbh(deptCode);

//            this.logger.info("visitID=" + visitID + "patId=" + patId + "deptCode=" + deptCode);

            String sslx = trimStr(applyItemType.getEmergencyIndicator()); // 急诊择期
            if ("1".equals(sslx)) {
                patientLink.getAnesthesiaRecord().getAsa().setJz(true);
                patientLink.getAnesthesiaRecord().getAsa().setZq(false);
            } else {
                patientLink.getAnesthesiaRecord().getAsa().setJz(false);
                patientLink.getAnesthesiaRecord().getAsa().setZq(true);
            }
            String sqzd1 = trimStr(applyItemType.getDiagBeforeOperation());
            patientLink.getApplication().setSqzd1(sqzd1);
//            this.logger.info("术前诊断" + trimStr(applyItemType.getDiagBeforeOperation()));

            String mzfs = trimStr(applyItemType.getAnesthesiaMethod()); // 麻醉方式
            patientLink.getSchedule().setMzfs(mzfs);
            patientLink.getApplication().setMzfs(mzfs);

            Date yysssj = parseDate(applyItemType.getReqDateTime()); //预约时间/计划手术时间
            patientLink.getApplication().setYysssj(yysssj);
            Date sssqsj = parseDate(applyItemType.getScheduledDateTime());//申请时间
            patientLink.getApplication().setSssqsj(sssqsj);

            // 设置主刀医生姓名和 code

            String zhuDaoGH = trimStr(applyItemType.getSurgeon());
            if (map.get(zhuDaoGH) != null){
                patientLink.getApplication().setSsysbh(map.get(zhuDaoGH).getId());
            }
            String zhuDaoZS1 = trimStr(applyItemType.getFirstAssistant());
            if (map.get(zhuDaoZS1) != null){
                patientLink.getApplication().setZlysbh1(map.get(zhuDaoZS1).getId());
            }
            String zhuDaoZS2 = trimStr(applyItemType.getSecondAssistant());
            if (map.get(zhuDaoZS2) != null){
                patientLink.getApplication().setZlysbh2(map.get(zhuDaoZS2).getId());
            }
            String zhuDaoZS3 = trimStr(applyItemType.getThirdAssistant());
            if (map.get(zhuDaoZS3) != null){
                patientLink.getApplication().setZlysbh3(map.get(zhuDaoZS3).getId());
            }
            String brxm = trimStr(applyItemType.getBrxm());
            patientLink.getPatient().setBrxm(brxm);
            String xb = trimStr(applyItemType.getXb());
            patientLink.getPatient().setXb(xb);
            String nl = trimStr(applyItemType.getNl());
            patientLink.getPatient().setNl(nl);
            String sg = trimStr(applyItemType.getSg());
            patientLink.getPatient().setSg(sg);
            String tz = trimStr(applyItemType.getTz());
            patientLink.getPatient().setTz(tz);


            StringBuilder nsssmc = new StringBuilder();
            nsssmc.append(applyItemType.getNsssmc1());
            if (applyItemType.getNsssmc2() != null && !applyItemType.getNsssmc2().equals("")){
                nsssmc.append("、" + applyItemType.getNsssmc2());
            }
            if (applyItemType.getNsssmc3() != null && !applyItemType.getNsssmc3().equals("")){
                nsssmc.append("、" + applyItemType.getNsssmc3());
            }
            if (applyItemType.getNsssmc4() != null && !applyItemType.getNsssmc4().equals("")){
                nsssmc.append("、" + applyItemType.getNsssmc4());
            }
            patientLink.getApplication().setNsssmc(nsssmc.toString());

            operationList.add(patientLink);
        }
        return operationList;
    }



    /**
     * 获取科室
     * @return
     */
    public List<ConfigDepartments> getDepartmentFromHis() {
        List departmentList = new ArrayList();
        DeptDictReqResp dept = new DeptDictReqResp();
        dept.reqRespData();
        try {
            this.logger.warn("科室共" + dept.getItemTypeList().size());
        } catch (Exception e) {
        }
        List<cn.medigical.publish.interfaces.his.hisTianshui.xml.dept.ITEMType> itemTypeList = dept.getItemTypeList();
        if (null != itemTypeList) {
            this.logger.warn("科室" + itemTypeList.size());
            for (cn.medigical.publish.interfaces.his.hisTianshui.xml.dept.ITEMType itemType : itemTypeList) {
                ConfigDepartments department = new ConfigDepartments();
                department.setCode(trimStr(itemType.getDeptCode()));
                department.setName(trimStr(itemType.getDeptName()));
                department.setDeleted(false);
                departmentList.add(department);
//                System.out.println(department);
            }
        } else {
            this.logger.warn("无科室信息NULL");
        }
        return departmentList;
    }

    /**
     * 获取用户
     * @return
     */
    public List<Account> getAccountFromHis() {
        List accountList = new ArrayList();
        UserDictReqResp user = new UserDictReqResp();
        user.reqRespData();
        List<cn.medigical.publish.interfaces.his.hisTianshui.xml.user.ITEMType> itemTypeList = user.getItemTypeList();
        Map<String , ConfigDepartments> map = getDept();

        if (null != itemTypeList) {
            this.logger.warn("账号" + itemTypeList.size());
            for (cn.medigical.publish.interfaces.his.hisTianshui.xml.user.ITEMType itemType : itemTypeList) {
                Account account = new Account();
                account.setHisID(itemType.getUserID());

                account.setTrueName(itemType.getUserName());
                account.setGender(trimStr(itemType.getSex()).equals("男") ? "male" : "female ");

                String userDeptCode = trimStr(itemType.getUserDeptID());
                account.setOfficeID(userDeptCode);
                account.setCanLogin(Boolean.valueOf(true));

                account.setWorkID(trimStr(itemType.getUserID()));
                account.setLoginName(trimStr(itemType.getUserID()));
                account.setPwd(accountDao.generatePassword(trimStr(itemType.getUserID())));

                if (map.size()>0 && map.get(userDeptCode) != null){
                    ConfigDepartments c = map.get(userDeptCode);
                    account.setOfficeName(c.getName());
                }
                String zw = trimStr(itemType.getUserJob());
                if (zw.contains("医生")) {
                    if (userDeptCode.equals(getMazuiDocDeptCode())) {
                        account.setRole("麻醉医生");
                    } else {
                        account.setRole("医生");
                    }
                } else if (zw.contains("护士")) {
                    account.setRole("护士");
                } else {
                    account.setRole("其他");
                    account.setCanLogin(Boolean.valueOf(true));
                }
                account.setTitle(zw);
                account.setCreateTime(new Date());
                account.setSchoolLevel("");
                account.setStatus("valid");
                account.setLastUpdateTime(new Date());
                accountList.add(account);
            }
        }

        return accountList;
    }

    public  void JianYanFromHisForLis(String patientID , String id){
        PatientLink p = patientLinkDao.getScheduleByPLinkId(id);
//        p.getTableForGuangXiTianShuiEY().getShuQianFanShi().setXcg("11");
//        p.getTableForGuangXiTianShuiEY().getShuQianFanShi().setNxcg("22");
//        p.getTableForGuangXiTianShuiEY().getShuQianFanShi().setGgn("33");
//        p.getTableForGuangXiTianShuiEY().getShuQianFanShi().setSgn("44");
//        p.getTableForGuangXiTianShuiEY().getShuQianFanShi().setDjz("55");
        JianYan jianYan = getJianYanFromHisForLis(patientID);

        p.getTableForGuangXiTianShuiEY().getShuQianFanShi().setXcg(jianYan.getXueChangGui());
        this.logger.warn(new Date()+"正在获取检验数据>>血常规："+jianYan.getXueChangGui());
        p.getTableForGuangXiTianShuiEY().getShuQianFanShi().setNxcg(jianYan.getNingXueGongNeng());
        this.logger.warn(new Date()+"正在获取检验数据>>凝血常规："+jianYan.getNingXueGongNeng());
        p.getTableForGuangXiTianShuiEY().getShuQianFanShi().setGgn(jianYan.getGanGongNeng());
        this.logger.warn(new Date()+"正在获取检验数据>>肝功能："+jianYan.getNingXueGongNeng());
        p.getTableForGuangXiTianShuiEY().getShuQianFanShi().setSgn(jianYan.getShenGongNeng());
        this.logger.warn(new Date()+"正在获取检验数据>>肾功能："+jianYan.getShenGongNeng());
        p.getTableForGuangXiTianShuiEY().getShuQianFanShi().setDjz(jianYan.getDianJieZhi());
        this.logger.warn(new Date()+"正在获取检验数据>>电解质："+jianYan.getDianJieZhi());

        patientLinkDao.addUpdate(p);
    }


    //获取检验数据
    public JianYan getJianYanFromHisForLis(String patientID){
        try{
            JianYanReqResp jianYanReqResp = new JianYanReqResp();
            jianYanReqResp.setPatientID(patientID);
            jianYanReqResp.reqRespData();
            List<cn.medigical.publish.interfaces.his.hisTianshui.xml.jianyan.ITEMType> itemTypeList = jianYanReqResp.getItemTypeList();
            Map<String, List<cn.medigical.publish.interfaces.his.hisTianshui.xml.jianyan.ITEMType>> map = new HashMap<>();
            for (cn.medigical.publish.interfaces.his.hisTianshui.xml.jianyan.ITEMType itemType : itemTypeList ){
//                if (itemType.getSample().contains("尿液") || itemType.getSample().contains("粪")){
//                    continue;
//                }
                if (map.get(itemType.getItemshortname()) == null){
                    List<cn.medigical.publish.interfaces.his.hisTianshui.xml.jianyan.ITEMType> list = new ArrayList<>();
                    list.add(itemType);
                    map.put(itemType.getItemshortname(), list);
                }else{
                    List<cn.medigical.publish.interfaces.his.hisTianshui.xml.jianyan.ITEMType> list = map.get(itemType.getItemshortname());
                    list.add(itemType);
                    map.put(itemType.getItemshortname(), list);
                }
            }
            Map<String, Map<String, String>> JYmap = jianYanReqResp.getJianYanMap();
            Map<String, String> result = new HashMap<>();
            for (Map.Entry<String, Map<String, String>> entry : JYmap.entrySet()) {
                String name = entry.getKey();
                StringBuilder str = new StringBuilder("");
                for (Map.Entry<String , String> entry1 : entry.getValue().entrySet()){
                    if (map.get(entry1.getKey()) != null && map.get(entry1.getKey()).size() > 0) {
                        List<cn.medigical.publish.interfaces.his.hisTianshui.xml.jianyan.ITEMType> list = map.get(entry1.getKey());
                        if (list.size() > 1){
                            shortList(list);
                        }
                        cn.medigical.publish.interfaces.his.hisTianshui.xml.jianyan.ITEMType itemType = list.get(0);
                        str.append(entry1.getKey() + " " + itemType.getResult() + " " + entry1.getValue());
                        result.put(name, str.toString());
                    }
                }
            }
            JianYan jianYan = new JianYan();
            if (result != null){
                for (Map.Entry<String , String> map1 : result.entrySet()){
                    switch (map1.getKey()) {
                        case"血常规":
                            jianYan.setXueChangGui(map1.getValue());
                            break;
                        case"凝血常规":
                            jianYan.setNingXueGongNeng(map1.getValue());
                        case"肝功能":
                            jianYan.setGanGongNeng(map1.getValue());
                            break;
                        case"肾功能":
                            jianYan.setShenGongNeng(map1.getValue());
                            break;
                        case "电解质":
                            jianYan.setDianJieZhi(map1.getValue());
                            break;
                    }
                }
                return jianYan;
            }else{
                return null;
            }
        }catch (Exception e){
            return null;
        }
    }


    private void shortList(List<cn.medigical.publish.interfaces.his.hisTianshui.xml.jianyan.ITEMType> list){
        Collections.sort(list, new Comparator<cn.medigical.publish.interfaces.his.hisTianshui.xml.jianyan.ITEMType>() {
            @Override
            public int compare(cn.medigical.publish.interfaces.his.hisTianshui.xml.jianyan.ITEMType o1, cn.medigical.publish.interfaces.his.hisTianshui.xml.jianyan.ITEMType o2) {
                try {
                    Date dt1 = MyDateFormat.DATE_FORTS_YMDHMS.parse(o1.getTime());
                    Date dt2 = MyDateFormat.DATE_FORTS_YMDHMS.parse(o2.getTime());
                    if (dt1.getTime() > dt2.getTime()) {
                        return 1;
                    } else if (dt1.getTime() < dt2.getTime()) {
                        return -1;
                    } else {
                        return 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 0;
            }
        });
    }



    private Map<String , ConfigDepartments> getDept(){
        Map<String, ConfigDepartments> result = new HashMap<>();
        List<ConfigDepartments> departmentListFromDb= SpringUtils.getBean(ConfigDepartmentsDao.class).getAll();
        for (ConfigDepartments c : departmentListFromDb){
            result.put(c.getCode(), c);
        }
        return result;
    }

    private Map<String , Account>  getAccount(){
        Map<String, Account> result = new HashMap<>();
        List<Account> accountList = accountDao.getAllAccount();
        for (Account a : accountList) {
            result.put(a.getWorkID(), a);
        }
        return result;
    }


    public boolean addEndOper2HISUpateBatch(List<PatientLink> patientLinks) {
        return false;
    }

    public LisData getLisData(String zyh, String name) {
        return null;
    }

    public String getMazuiDocDeptCode() {
        return "121";
    }

    public String getMazuiDocDeptName() {
        return "麻醉科";
    }

    public String getNurseDeptCode() {
        return "SSS";
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

    protected Date parseDate(String str) {

        try {

            return MyDateFormat.DATE_FORTS_YMDHMS.parse(str.trim());

        } catch (ParseException e) {
            e.printStackTrace();
            try {
                return str.equals("") ? new Date() : MyDateFormat.DATE_FORMAT_YMD.parse(str.trim());
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
        }
        return new Date();
    }

    protected String convertNameToId(String name, String zhuDaoGH, List<Account> accountList, String role) {
        for (int i = 0; i < accountList.size(); i++) {
            if (name.equals(((Account) accountList.get(i)).getTrueName())) {
                return ((Account) accountList.get(i)).getId();
            }
        }

        return crtNewAccount(name, zhuDaoGH, role);
    }

    private String crtNewAccount(String name, String zhuDaoGH, String role) {
        Account account = new Account();
        account.setTrueName(name);
        account.setRole(role);
        account.setWorkID(zhuDaoGH);
        account.setLoginName(zhuDaoGH);
        account.setLastUpdateTime(new Date());
        account.setCreateTime(new Date());
        account.setInDate(new Date());
        account.setCanLogin(Boolean.valueOf(true));
        account.setStatus("valid");
        account.setPwd(accountDao.generatePassword(String.valueOf(zhuDaoGH)));
        account.setSchoolLevel("");
        if ("麻醉医生".equalsIgnoreCase(role)) {
            HisLink hisLink = new HisLinkTianshui();
            account.setOfficeID(hisLink.getMazuiDocDeptCode());
            account.setOfficeName(hisLink.getMazuiDocDeptName());
        }
        if ("护士".equalsIgnoreCase(role)) {
            HisLink hisLink = new HisLinkTianshui();
            account.setOfficeID(hisLink.getNurseDeptCode());
            account.setOfficeName(hisLink.getNurseDeptName());
        }

        // ((AccountDao)SpringCache.getInstance().getBean(AccountDao.class)).addUpdate(account);
        AccountCache.getInstance().setAccountToMap(account);
        this.accountList.add(account);
        this.logger.warn("create Account name=" + name + "zhuDaoGH=" + zhuDaoGH + "role" + role + "AccountID" + account.getId());
        return account.getId();
    }

    @Override
    public boolean writeEndOper2HIS(PatientLink patientLink) {
        // TODO Auto-generated method stub
        return false;
    }

    public void writeEndOper2HIS(String patientId) {
        OperStaus.getInstance().writeEndOper2HIS(patientId);

    }

    @Override
    public void updateOperationStatus(String date, String accountID) {
        OperStaus.getInstance().updateOperationStatus(date, accountID);
    }

    @Override
    public void updateScheduleInfo(String PatientLinkId) {

    }

    @Override
    public void addScheduleInfo(String PatientLinkId) {

    }
}
