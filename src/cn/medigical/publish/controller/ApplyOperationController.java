package cn.medigical.publish.controller;

import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigDepartmentsDao;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.PatientLinkTable;
import cn.medigical.publish.pojo.dictionary.ConfigDepartments;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.utils.Constants;
import cn.medigical.publish.utils.DateUtil;
import cn.medigical.publish.utils.SpringUtils;
import cn.medigical.publish.utils.XianDaiYiyUanCollection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * 质控统计 1.入口zhikong.do(275-341) 通过入口加载网页,待网页加载完成后通过网页ajax访问zhikongA.do(349-415) 2.图表 zhikongAjax.do(420-461) 3.跳转详情页 zhikongDetailed.do(482-580)
 *
 * 4.如要加减数据 需要在getValue方法中加入(显示顺序从上到下依次) dataList.add(new ZhikongMessage("显示的名字", m.getXXX(), avg(m, m.getXXX()), m.getPatientLinkCount(), "XXX")); 在静态方法中加入 ContextMessage.zhikongDB.put("XXX", "数据库中的位置  如:qualityPojo.sgssjmcc"); ContextMessage.zhikongzhibiao.put("XXX", "显示的名字"); 在getOneDate(返回long 图表使用)和getOneDate(返回List 详情页使用)和calValue(所有数据的统计) 3个方法中加入统计的方法
 *
 * @author bc_liaoyx
 *
 */





@Controller
@RequestMapping("ApplyOperationController")
public class ApplyOperationController {
    private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    AccountDao accountDao = (AccountDao) SpringUtils.getBean(AccountDao.class);
    PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);
    ConfigDepartmentsDao configDepartmentsDao = SpringUtils.getBean(ConfigDepartmentsDao.class);
    @ResponseBody
    @RequestMapping(value = "searchOperApply", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Map<String, Object> searchOperApply(Model m, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        String zyh=request.getParameter("zyh");
        PatientLink patientLink=patientLinkDao.getPatientLinkByZyh(zyh);
        if(patientLink==null){
            map.put("success", true);
            map.put("tishi", "当前手术没还没申请");
        }else if(patientLink!=null){
            map.put("success", false);
            map.put("tishi", "当前手术已申请过了");
        }

        return map;
    }
    //根据病人医院id和住院次数或病人唯一id,将病人信息显示在网页上
    @RequestMapping(value = "applyOperation", method = RequestMethod.GET)
    public Object applyOperation(Model m, HttpServletRequest request) {
        String hisid = request.getParameter("hisid");

        String zyh = request.getParameter("zyh");
        XianDaiYiyUanCollection collection = new XianDaiYiyUanCollection();
        PatientLink patientLink=null;
        if(zyh==null){
            zyh="";
        }
        if(!zyh.equals("")){
            //patientLink = patientLinkDao.getPatientLinkforZyh(zyh);
            patientLink = collection.getPatientInfoFromHisByID(zyh);
        }
        if(patientLink!=null){
            hisid=patientLink.getHisID();
        }
        if (hisid == null) {
            hisid = UUID.randomUUID().toString();
        }
        List<Account> accounts = new ArrayList<>();
        List<ConfigDepartments> configDepartmentsList = configDepartmentsDao.getAll();

        if (patientLink == null) {
            patientLink = new PatientLink();
        }
        String name = request.getParameter("name");
        String nl = request.getParameter("nl");
        String sg = request.getParameter("sg");
        String xb = request.getParameter("xb");
        String tz = request.getParameter("tz");
        String ksmc = request.getParameter("ksmc");
        String zych = request.getParameter("zych");
        String xx = request.getParameter("xx");
        String qklx = request.getParameter("qklx");
        String gms = request.getParameter("gms");
        String sqzd = request.getParameter("sqzd");
        String nsss = request.getParameter("nsss");
        String asa = request.getParameter("asa");
        String zdys = request.getParameter("zdys");
        String zl1 = request.getParameter("zl1");
        String zl2 = request.getParameter("zl2");
        String zl3 = request.getParameter("zl3");
        String sqys = request.getParameter("sqys");
        String mzfs = request.getParameter("mzfs");
        String mzlb = request.getParameter("mzlb");
        String sqksmc = request.getParameter("sqksmc");

        // String sqsj=request.getParameter("sqsj");
        patientLink.setHisID(getName(hisid));
        patientLink.getPatient().setBrxm(getName(name).equals("") ? patientLink.getPatient().getBrxm() : name);
        patientLink.getPatient().setNl(getName(nl).equals("") ? patientLink.getPatient().getNl() : nl);
        patientLink.getPatient().setSg(getName(sg).equals("") ? patientLink.getPatient().getSg() : sg);
        patientLink.getPatient().setTz(getName(tz).equals("") ? patientLink.getPatient().getTz() : tz);
        patientLink.getPatient().setZyh(getName(zyh).equals("") ? patientLink.getPatient().getZyh() : zyh);
        patientLink.getPatient().setKsmc(getName(ksmc).equals("") ? patientLink.getPatient().getKsmc() : ksmc);
        patientLink.getPatient().setZych(getName(zych).equals("") ? patientLink.getPatient().getZych() : zych);

        patientLink.getPatient().setXx(getName(xx).equals("") ? patientLink.getPatient().getXx() : xx);
        patientLink.getPatient().setXb(getName(xb).equals("") ? patientLink.getPatient().getXb() : xb);
        patientLink.getApplication().setQklx(getName(qklx).equals("") ? patientLink.getApplication().getQklx() : qklx);
        patientLink.getPatient().setGms(getName(gms).equals("") ? patientLink.getPatient().getGms() : gms);
        patientLink.getApplication().setSqzd1(getName(sqzd).equals("") ? patientLink.getApplication().getSqzd1() : sqzd);
        patientLink.getApplication().setNsssmc(getName(nsss).equals("") ? patientLink.getApplication().getNsssmc() : nsss);
        patientLink.getPatient().setSsdj(getName(asa).equals("") ? patientLink.getPatient().getSsdj() : asa);
        setYs(zdys, patientLink);
        setYs(zl1, patientLink);
        setYs(zl2, patientLink);
        setYs(zl3, patientLink);
        setYs(sqys, patientLink);
        patientLink.getApplication().setMzfs(getName(mzfs).equals("") ? patientLink.getApplication().getMzfs() : mzfs);
        patientLink.getApplication().setMzlb(getName(mzlb).equals("") ? patientLink.getApplication().getMzlb() : mzlb);
        patientLink.getApplication().setSqksmc(getName(sqksmc).equals("") ? patientLink.getApplication().getSqksmc() : sqksmc);
        patientLink.getApplication().setSssqdh(getName(hisid).equals("") ? patientLink.getApplication().getSssqdh() : hisid);
        patientLink.setHisID(hisid);
        if (accountDao.findAccountByName(getName(zdys)) != null) {
            //patientLink.getPatient().setSqDoctor(zdys);
            patientLink.getApplication().setSsysxm(accountDao.findAccountByName(zdys).getId());

        } else {
            accountDao.addUpdate(new Account(zdys));
        }
        //String hospitalid = request.getParameter("hospitalid");
        // String visitid = request.getParameter("visitid");
        String ksmcs=patientLink.getPatient().getKsmc();
        System.out.println(ksmcs);
        if (ksmcs != null &&! ksmcs.equals("")) {
            accounts = getAccountList(accounts,patientLink.getPatient().getKsmc());
        }

        Date sqsj = patientLink.getApplication().getSssqsj();
        if (sqsj == null) {
            sqsj = new Date();
        }
        m.addAttribute("accounts", accounts);
        m.addAttribute("patientLink", patientLink);
        m.addAttribute("sqsj", sdf2.format(sqsj));
        m.addAttribute("configDepartmentsList", configDepartmentsList);


        return "applyoperation/applyoperation";
    }

    //这个将病人信息提交存到数据库
    @ResponseBody
    @RequestMapping(value = "submitOperApply", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Map<String, Object> submitOperApply(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        boolean status = false;
        //PatientLink patientLink = new PatientLink();

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");
        String sex = request.getParameter("sex");
        String blod = request.getParameter("blod");
        String dept = request.getParameter("dept");
        String bednum = request.getParameter("bednum");
        String hospitalid = request.getParameter("hospitalid");
        String applyid = request.getParameter("applyid");
        String incision = request.getParameter("incision");

        String preoperative = request.getParameter("preoperative");
        String hiv = request.getParameter("hiv");
        String hbv = request.getParameter("hbv");
        String hcv = request.getParameter("hcv");
        String syphilis = request.getParameter("syphilis");
        String hbsag = request.getParameter("hbsag");
        String gasgangrene = request.getParameter("gasgangrene");
        String bacillus = request.getParameter("bacillus");
        String infect = request.getParameter("infect");
        String frozen = request.getParameter("frozen");


        String pseudo = request.getParameter("pseudo");
        String asa = request.getParameter("asa");
        String mainknife = request.getParameter("mainknife");
        String assitant1 = request.getParameter("assitant1");
        String assitant2 = request.getParameter("assitant2");
        String assitant3 = request.getParameter("assitant3");
        String applydoctor = request.getParameter("applydoctor");
        String appointment = request.getParameter("appointment");
        String anesthetic = request.getParameter("anesthetic");

       // String applydept = request.getParameter("applydept");
        String sstw=request.getParameter("sstw");
        String zyfs=request.getParameter("zyfs");
        String bz=request.getParameter("bz");
        String kss=request.getParameter("kss");

        PatientLink patientLink = null;
        if (patientLink == null) {
            patientLink = new PatientLink();
            patientLink.setHisID(applyid);
        }


            //病人姓名
            // if(patientLink.getPatient().getBrxm()==null||patientLink.getPatient().getBrxm().equals("")){
            patientLink.getPatient().setBrxm(name);
            // }
            //patientLink.getPatient().setBrxm(name);



            //拟施手术名称
            // if(patientLink.getApplication().getNsssmc()==null||patientLink.getApplication().getNsssmc().equals("")){
            patientLink.getApplication().setNsssmc(pseudo);
            // }



            try {
                //预约时间

                Date yysssj1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(appointment);
                patientLink.getApplication().setYysssj(yysssj1);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        //if(patientLink.getPatient().getNl()==null||patientLink.getPatient().getNl().equals("")){
        if (age.contains("岁")) {
            patientLink.getPatient().setNl(age);
        } else {
            patientLink.getPatient().setNl(age + " 岁");
        }

        // }
        //if(patientLink.getPatient().getXb()==null||patientLink.getPatient().getXb().equals("")){
        if (sex != null) {
            //设置性别
            patientLink.getPatient().setXb(sex);
        } else {
            patientLink.getPatient().setXb("");
        }
        //  }

        /**
         * 判断血型是否选择
         */
        // if(patientLink.getPatient().getXx()==null||patientLink.getPatient().getXx().equals("")) {
        if (blod != null) {
            patientLink.getPatient().setXx(blod);
        } else {
            patientLink.getPatient().setXx("");
        }
        // }
        // if(patientLink.getApplication().getAsa()==null||patientLink.getApplication().getAsa().equals("")){


        // }
        //身高
        //if(patientLink.getPatient().getSg()==null||patientLink.getPatient().getSg().equals("")) {

        patientLink.getPatient().setSg(height);
        // }
        //体重
        //if(patientLink.getPatient().getTz()==null||patientLink.getPatient().getTz().equals("")) {

        patientLink.getPatient().setTz(weight);
        // }
        //手术申请单号
        // if(patientLink.getApplication().getSssqdh()==null||patientLink.getApplication().getSssqdh().equals("")) {

        patientLink.getApplication().setSssqdh(applyid);
        // }
        //科室名称
        // if(patientLink.getPatient().getKsmc()==null||patientLink.getPatient().getKsmc().equals("")) {

        patientLink.getPatient().setKsmc(dept);
        // }
        //申请科室名称
        //if(patientLink.getApplication().getSqksmc()==null||patientLink.getApplication().getSqksmc().equals("")) {

       // patientLink.getApplication().setSqksmc(applydept);
        //}
        //住院号
        //if(patientLink.getPatient().getZyh()==null||patientLink.getPatient().getZyh().equals("")) {

        patientLink.getPatient().setZyh(hospitalid);
        //}
        //住院床号
        //if(patientLink.getPatient().getZych()==null||patientLink.getPatient().getZych().equals("")) {

        patientLink.getPatient().setZych(bednum);
        // }
        //术前诊断
        // if(patientLink.getApplication().getSqzd1()==null||patientLink.getApplication().getSqzd1().equals("")) {

        patientLink.getApplication().setSqzd1(preoperative);
        // }
        //过敏史
        // if(patientLink.getPatient().getGms()==null||patientLink.getPatient().getGms().equals("")) {


        // }
        //申请医生编号
        if (applydoctor != null) {
            if (SpringUtils.getBean(AccountDao.class).findAccountByName(applydoctor) != null) {
                patientLink.getApplication().setSqysbh(SpringUtils.getBean(AccountDao.class).findAccountByName(applydoctor).getId());

            }
            else {
                patientLink.getApplication().setSqysbh("");
            }
        } else {
            patientLink.getApplication().setSqysbh("");
        }
        //手术医生编号
        if (mainknife != null) {
            if (SpringUtils.getBean(AccountDao.class).findAccountByName(mainknife) != null) {
                patientLink.getApplication().setSsysbh(mainknife);
                patientLink.getApplication().setSsysxm(SpringUtils.getBean(AccountDao.class).findAccountByName(mainknife).getId());

            } else {
                patientLink.getApplication().setSsysxm("");
            }
        } else {
            patientLink.getApplication().setSsysxm("");
        }
        //助理医生标号1
        if (assitant1 != null) {
            if (SpringUtils.getBean(AccountDao.class).findAccountByName(assitant1) != null) {
                patientLink.getApplication().setZlysbh1(SpringUtils.getBean(AccountDao.class).findAccountByName(assitant1).getId());
            } else {
                patientLink.getApplication().setZlysbh1("");
            }
        } else {
            patientLink.getApplication().setZlysbh1("");
        }
        //助理医生标号2
        if (assitant2 != null) {
            if (SpringUtils.getBean(AccountDao.class).findAccountByName(assitant2) != null) {
                patientLink.getApplication().setZlysbh2(SpringUtils.getBean(AccountDao.class).findAccountByName(assitant2).getId());
            } else {
                patientLink.getApplication().setZlysbh2("");
            }
        } else {
            patientLink.getApplication().setZlysbh2("");
        }
        //助理医生标号3
        if (assitant3 != null) {
            if (SpringUtils.getBean(AccountDao.class).findAccountByName(assitant3) != null) {
                patientLink.getApplication().setZlysbh3(SpringUtils.getBean(AccountDao.class).findAccountByName(assitant3).getId());
            } else {
                patientLink.getApplication().setZlysbh3("");
            }
        } else {
            patientLink.getApplication().setZlysbh3("");
        }
        //麻醉方法
        //if(patientLink.getApplication().getMzfs()==null||patientLink.getApplication().getMzfs().equals("")) {

        patientLink.getApplication().setMzfs(anesthetic);
        //}
        // if(patientLink.getApplication().getMzfs()==null||patientLink.getApplication().getMzfs().equals("")) {
        //转运方式
        patientLink.getApplication().setZyfs(zyfs);
        //手术体位
        patientLink.getAnesthesiaRecord().setSstw(sstw);
        //抗生素
        patientLink.getApplication().setKss(kss);
        //备注
        patientLink.getSchedule().setBznr(bz);
//手术等级
        if (asa != null) {
            patientLink.getPatient().setSsdj(asa);
        } else {
            patientLink.getApplication().setAsa("");
        }//切口类型
        if (incision != null) {
            patientLink.getApplication().setQklx(incision);
        } else {
            patientLink.getApplication().setQklx("");
        }

        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        patientLink.getApplication().setSssqsj(date);
        patientLink.getApplication().setHiv(Boolean.valueOf(hiv));
        patientLink.getApplication().setHbv(Boolean.valueOf(hbv));
        patientLink.getApplication().setHcv(Boolean.valueOf(hcv));
        patientLink.getApplication().setMd(Boolean.valueOf(syphilis));
        patientLink.getApplication().setHbsag(Boolean.valueOf(hbsag));
        patientLink.getApplication().setQxxh(Boolean.valueOf(gasgangrene));
        patientLink.getApplication().setLngj(Boolean.valueOf(bacillus));
        patientLink.getApplication().setRdtgr(Boolean.valueOf(infect));
        patientLink.getApplication().setSzbd(Boolean.valueOf(frozen));



        //手术状态
        patientLink.getApplication().setStatus(Constants.AP_STATUS_MAZUIQIAN);
        //明细状态
        patientLink.getApplication().setDetailstatus(Constants.OR_STATUS_FLAG_APPLIED);
        //患者状态
        patientLink.getPatient().setStatus(Constants.FLAG_VALID);
        //保存择期状态
        patientLink.getAnesthesiaRecord().getAsa().setZq(true);
        //保存术前禁食状态
        patientLink.getAnesthesiaRecord().setJs(true);
        //保存非计划手术
        patientLink.getAnesthesiaRecord().setFjhss(true);
        PatientLink patientLink2= patientLinkDao.getPatientLinkByZyh(hospitalid);
        if(patientLink2!=null){

            map.put("success", true);
            map.put("tishi","已申请过了");

        }else {

        } if (SpringUtils.getBean(PatientLinkDao.class).addUpdate(patientLink)) {
            status = true;
            map.put("success", status);
            return map;
        }


        map.put("success", status);
        return map;
    }

    //撤销
    @ResponseBody
    @RequestMapping(value = "unSubmitOperApply", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Map<String, Object> unSubmitOperApply(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        boolean status = false;
        String applyid = request.getParameter("applyid");
        if (applyid == null || "".equals(applyid)) {
            map.put("success", status);
            return map;
        }
        PatientLink patientLink = SpringUtils.getBean(PatientLinkDao.class).getSubmitBySssqdh(applyid);
        if (patientLink == null) {
            patientLink = patientLinkDao.getPatientById(applyid);
        }
        if (patientLink == null) {
            map.put("success", status);
            return map;
        }
        patientLink.getApplication().setDetailstatus(Constants.OR_STATUS_FLAG_DISCHARGED);
        patientLink.getPatient().setStatus(Constants.FLAG_IN_VALID);
        patientLink.getStatus().setDischargeTime(new Date());
        if (SpringUtils.getBean(PatientLinkDao.class).updateInsert(patientLink)) {
            status = true;
            map.put("success", status);
            return map;
        }
        return map;
    }
    //选中科室名称查所在选中科室中的医师
    @ResponseBody
    @RequestMapping(value = "change", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Map<String, Object> changeAccountList(Model m, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        String ksmc = request.getParameter("ksmc").trim();
        List<Account> accounts = new ArrayList<Account>();
        if(ksmc!=null&&!ksmc.equals("")){
            accounts=getAccountList(accounts,ksmc);
        }


        System.out.println("查询结果--" + accounts.size());
        //m.addAttribute("patientLinks",patientLinks);
        if (accounts != null) {
            map.put("success", true);
            map.put("accounts", accounts);
        } else {
            map.put("success", false);
        }
        return map;
        //return "applyoperation/applyoperation";
    }
    //修改病人
    @ResponseBody
    @RequestMapping(value = "revise", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Map<String, Object> revisePatientLink(Model m, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();

        boolean status = false;
        //PatientLink patientLink = new PatientLink();
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");
        String sex = request.getParameter("sex");
        String blod = request.getParameter("blod");
        String dept = request.getParameter("dept");
        String bednum = request.getParameter("bednum");
        String hospitalid = request.getParameter("hospitalid");
        String applyid = request.getParameter("applyid");
        String incision = request.getParameter("incision");

        String preoperative = request.getParameter("preoperative");
        String hiv = request.getParameter("hiv");
        String hbv = request.getParameter("hbv");
        String hcv = request.getParameter("hcv");
        String syphilis = request.getParameter("syphilis");
        String hbsag = request.getParameter("hbsag");
        String gasgangrene = request.getParameter("gasgangrene");
        String bacillus = request.getParameter("bacillus");
        String infect = request.getParameter("infect");
        String frozen = request.getParameter("frozen");

        String pseudo = request.getParameter("pseudo");
        String asa = request.getParameter("asa");
        String mainknife = request.getParameter("mainknife");
        String assitant1 = request.getParameter("assitant1");
        String assitant2 = request.getParameter("assitant2");
        String assitant3 = request.getParameter("assitant3");
        String applydoctor = request.getParameter("applydoctor");
        String appointment = request.getParameter("appointment");
        String anesthetic = request.getParameter("anesthetic");

       // String applydept = request.getParameter("applydept");
        String sstw=request.getParameter("sstw");
        String zyfs=request.getParameter("zyfs");
        String bz=request.getParameter("bz");
        String kss=request.getParameter("kss");
        PatientLink patientLink = patientLinkDao.getPatientLinkforHisId(applyid);
        if (patientLink == null) {
            patientLink = new PatientLink();
            patientLink.setHisID(applyid);
        }

        if (name.equals("")) {
            map.put("success", status);
            return map;
        } else {
            //病人姓名
            // if(patientLink.getPatient().getBrxm()==null||patientLink.getPatient().getBrxm().equals("")){
            patientLink.getPatient().setBrxm(name);
            // }
            //patientLink.getPatient().setBrxm(name);
        }
        if (pseudo.equals("")) {
            map.put("success", status);
            return map;
        } else {
            //拟施手术名称
            // if(patientLink.getApplication().getNsssmc()==null||patientLink.getApplication().getNsssmc().equals("")){
            patientLink.getApplication().setNsssmc(pseudo);
            // }

        }
        if (appointment.equals("")) {
            map.put("success", status);
            return map;
        } else {
            try {
                //预约时间
                Date yysssj1 = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(appointment);
                patientLink.getApplication().setYysssj(yysssj1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        //if(patientLink.getPatient().getNl()==null||patientLink.getPatient().getNl().equals("")){
        if (age.contains("岁")) {
            patientLink.getPatient().setNl(age);
        } else {
            patientLink.getPatient().setNl(age + " 岁");
        }

        // }
        //if(patientLink.getPatient().getXb()==null||patientLink.getPatient().getXb().equals("")){
        if (sex != null) {
            //设置性别
            patientLink.getPatient().setXb(sex);
        } else {
            patientLink.getPatient().setXb("");
        }
        //  }

        /**
         * 判断血型是否选择
         */
        // if(patientLink.getPatient().getXx()==null||patientLink.getPatient().getXx().equals("")) {
        if (blod != null) {
            patientLink.getPatient().setXx(blod);
        } else {
            patientLink.getPatient().setXx("");
        }
        // }
        // if(patientLink.getApplication().getAsa()==null||patientLink.getApplication().getAsa().equals("")){

        if (asa != null) {
            patientLink.getPatient().setSsdj(asa);
        } else {
            patientLink.getPatient().setSsdj("");
        }
        // }
        //身高
        //if(patientLink.getPatient().getSg()==null||patientLink.getPatient().getSg().equals("")) {

        patientLink.getPatient().setSg(height);
        // }
        //体重
        //if(patientLink.getPatient().getTz()==null||patientLink.getPatient().getTz().equals("")) {

        patientLink.getPatient().setTz(weight);
        // }
        //手术申请单号
        // if(patientLink.getApplication().getSssqdh()==null||patientLink.getApplication().getSssqdh().equals("")) {

        patientLink.getApplication().setSssqdh(applyid);
        // }
        //科室名称
        // if(patientLink.getPatient().getKsmc()==null||patientLink.getPatient().getKsmc().equals("")) {

        patientLink.getPatient().setKsmc(dept);
        // }
        //申请科室名称
        //if(patientLink.getApplication().getSqksmc()==null||patientLink.getApplication().getSqksmc().equals("")) {

        //patientLink.getApplication().setSqksmc(applydept);
        //}
        //住院号
        //if(patientLink.getPatient().getZyh()==null||patientLink.getPatient().getZyh().equals("")) {

        patientLink.getPatient().setZyh(hospitalid);
        //}
        //住院床号
        //if(patientLink.getPatient().getZych()==null||patientLink.getPatient().getZych().equals("")) {

        patientLink.getPatient().setZych(bednum);
        // }
        //术前诊断
        // if(patientLink.getApplication().getSqzd1()==null||patientLink.getApplication().getSqzd1().equals("")) {

        patientLink.getApplication().setSqzd1(preoperative);
        // }
        //过敏史
        // if(patientLink.getPatient().getGms()==null||patientLink.getPatient().getGms().equals("")) {


        // }
        //申请医生编号
        if (applydoctor != null) {
            if (SpringUtils.getBean(AccountDao.class).findAccountByName(applydoctor) != null) {
                patientLink.getApplication().setSqysbh(SpringUtils.getBean(AccountDao.class).findAccountByName(applydoctor).getId());
            } else {
                patientLink.getApplication().setSqysbh("");
            }
        } else {
            patientLink.getApplication().setSqysbh("");
        }
        //手术医生编号
        if (mainknife != null) {
            if (SpringUtils.getBean(AccountDao.class).findAccountByName(mainknife) != null) {
                patientLink.getApplication().setSsysbh(mainknife);
                patientLink.getApplication().setSsysxm(SpringUtils.getBean(AccountDao.class).findAccountByName(mainknife).getId());
            } else {
                patientLink.getApplication().setSsysxm("");
            }
        } else {
            patientLink.getApplication().setSsysxm("");
        }
        //助理医生标号1
        if (assitant1 != null) {
            if (SpringUtils.getBean(AccountDao.class).findAccountByName(assitant1) != null) {
                patientLink.getApplication().setZlysbh1(SpringUtils.getBean(AccountDao.class).findAccountByName(assitant1).getId());
            } else {
                patientLink.getApplication().setZlysbh1("");
            }
        } else {
            patientLink.getApplication().setZlysbh1("");
        }
        //助理医生标号2
        if (assitant2 != null) {
            if (SpringUtils.getBean(AccountDao.class).findAccountByName(assitant2) != null) {
                patientLink.getApplication().setZlysbh2(SpringUtils.getBean(AccountDao.class).findAccountByName(assitant2).getId());
            } else {
                patientLink.getApplication().setZlysbh2("");
            }
        } else {
            patientLink.getApplication().setZlysbh2("");
        }
        //助理医生标号3
        if (assitant3 != null) {
            if (SpringUtils.getBean(AccountDao.class).findAccountByName(assitant3) != null) {
                patientLink.getApplication().setZlysbh3(SpringUtils.getBean(AccountDao.class).findAccountByName(assitant3).getId());
            } else {
                patientLink.getApplication().setZlysbh3("");
            }
        } else {
            patientLink.getApplication().setZlysbh3("");
        }
        //麻醉方法
        //if(patientLink.getApplication().getMzfs()==null||patientLink.getApplication().getMzfs().equals("")) {

        patientLink.getApplication().setMzfs(anesthetic);
        //}
        // if(patientLink.getApplication().getMzfs()==null||patientLink.getApplication().getMzfs().equals("")) {

        if (incision != null) {
            patientLink.getApplication().setQklx(incision);
        } else {
            patientLink.getApplication().setQklx("");
        }
        //转运方式
        patientLink.getApplication().setZyfs(zyfs);
        //手术体位
        patientLink.getAnesthesiaRecord().setSstw(sstw);
        //抗生素
        patientLink.getApplication().setKss(kss);
        //备注
        patientLink.getSchedule().setBznr(bz);
//手术等级
        if (asa != null) {
            patientLink.getPatient().setSsdj(asa);
        } else {
            patientLink.getApplication().setAsa("");
        }

        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        patientLink.getApplication().setSssqsj(date);
        patientLink.getApplication().setHiv(Boolean.valueOf(hiv));
        patientLink.getApplication().setHbv(Boolean.valueOf(hbv));
        patientLink.getApplication().setHcv(Boolean.valueOf(hcv));
        patientLink.getApplication().setMd(Boolean.valueOf(syphilis));
        patientLink.getApplication().setHbsag(Boolean.valueOf(hbsag));
        patientLink.getApplication().setQxxh(Boolean.valueOf(gasgangrene));
        patientLink.getApplication().setLngj(Boolean.valueOf(bacillus));
        patientLink.getApplication().setRdtgr(Boolean.valueOf(infect));
        patientLink.getApplication().setSzbd(Boolean.valueOf(frozen));

        //手术状态
        patientLink.getApplication().setStatus(Constants.AP_STATUS_MAZUIQIAN);
        //明细状态
        patientLink.getApplication().setDetailstatus(Constants.OR_STATUS_FLAG_APPLIED);
        //患者状态
        patientLink.getPatient().setStatus(Constants.FLAG_VALID);
        //保存择期状态
        patientLink.getAnesthesiaRecord().getAsa().setZq(true);
        //保存术前禁食状态
        patientLink.getAnesthesiaRecord().setJs(true);
        //保存非计划手术
        patientLink.getAnesthesiaRecord().setFjhss(true);
        if (SpringUtils.getBean(PatientLinkDao.class).updateInsert(patientLink)) {
            status = true;
            map.put("success", status);
            return map;
        }
        map.put("success", status);
        return map;
    }

    //查询
    @ResponseBody
    @RequestMapping(value = "search", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Map<String, Object> SearchList(Model m, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();

        String brxm=request.getParameter("brxm");
        Date start = DateUtil.oneDaystart(new Date());
        Date end = DateUtil.oneDayend(new Date());
        List<PatientLinkTable> patientLinks = new ArrayList<PatientLinkTable>();
        List<PatientLink> patientLinks2 = patientLinkDao.getTableOpersBrxm(brxm);
        for (PatientLink patientLink : patientLinks2) {
            PatientLinkTable patientLinkTable = new PatientLinkTable();
            patientLinkTable.setId(patientLink.getId());
            patientLinkTable.setNameN(patientLink.getPatient().getBrxm());
            patientLinkTable.setNln(patientLink.getPatient().getNl());
            patientLinkTable.setXb(patientLink.getPatient().getXb());
            patientLinkTable.setZyh(patientLink.getPatient().getZyh());
            patientLinkTable.setKsmc(patientLink.getPatient().getKsmc());
            patientLinkTable.setSqzd(patientLink.getApplication().getSqzd1());
            patientLinkTable.setNss(patientLink.getApplication().getNsssmc());
            if (patientLink.getApplication().getSsysxm() != null && !patientLink.getApplication().getSsysxm().equals("")) {
                patientLinkTable.setSsys(accountDao.findAccountById(patientLink.getApplication().getSsysxm()).getTrueName());
            }

            patientLinkTable.setSssqrq(sdf2.format(patientLink.getApplication().getSssqsj()));
            patientLinkTable.setZt(patientLink.getApplication().getDetailstatus());
            patientLinks.add(patientLinkTable);
        }
        System.out.println("查询结果--" + patientLinks.size());
        //m.addAttribute("patientLinks",patientLinks);
        if (patientLinks != null) {
            map.put("success", true);
            map.put("patientLinks", patientLinks);
        } else {
            map.put("success", false);
        }
        return map;
        //return "applyoperation/applyoperation";
    }

    @ResponseBody
    @RequestMapping(value = "search2", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Map<String, Object> SearchListc(Model m, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        String ksmc = request.getParameter("ksmc");

        Date start = DateUtil.oneDaystart(new Date());
        Date end = DateUtil.oneDayend(new Date());
        List<PatientLinkTable> patientLinks = new ArrayList<PatientLinkTable>();
        List<PatientLink> patientLinks2 = patientLinkDao.getByPlanTimeDept(start,end,ksmc);
        for (PatientLink patientLink : patientLinks2) {
            PatientLinkTable patientLinkTable = new PatientLinkTable();
            patientLinkTable.setId(patientLink.getId());
            patientLinkTable.setNameN(patientLink.getPatient().getBrxm());
            patientLinkTable.setNln(patientLink.getPatient().getNl());
            patientLinkTable.setXb(patientLink.getPatient().getXb());
            patientLinkTable.setZyh(patientLink.getPatient().getZyh());
            patientLinkTable.setKsmc(patientLink.getPatient().getKsmc());
            patientLinkTable.setSqzd(patientLink.getApplication().getSqzd1());
            patientLinkTable.setNss(patientLink.getApplication().getNsssmc());
            if (patientLink.getApplication().getSsysxm() != null && !patientLink.getApplication().getSsysxm().equals("")) {
                patientLinkTable.setSsys(accountDao.findAccountById(patientLink.getApplication().getSsysxm()).getTrueName());
            }

            patientLinkTable.setSssqrq(sdf2.format(patientLink.getApplication().getSssqsj()));
            patientLinkTable.setZt(patientLink.getApplication().getDetailstatus());
            patientLinks.add(patientLinkTable);
        }
        System.out.println("查询结果--" + patientLinks.size());
        //m.addAttribute("patientLinks",patientLinks);
        if (patientLinks != null) {
            map.put("success", true);
            map.put("patientLinks", patientLinks);
        } else {
            map.put("success", false);
        }
        return map;
        //return "applyoperation/applyoperation";
    }

    public String getName(String str) {
        if (str == null) {
            return "";
        } else {
            return str;
        }
    }

    public void setYs(String idname, PatientLink patientLink) {
        if (idname != null && !idname.equals("")) {
            if (accountDao.findAccountByName(getName(idname)) != null) {
                patientLink.getApplication().setSsysxm(accountDao.findAccountByName(idname).getId());
            } else {
                accountDao.addUpdate(new Account(idname));
            }
        }

    }

    public List<Account> getAccountList(List<Account> accounts, String ksmc) {
        List<Account> accountList = accountDao.getAllAccount();
        for (Account account:accountList) {
            String zhicheng=account.getZhiCheng();
            String ksmcs=account.getOfficeName().trim();

                if(zhicheng!=null&&!zhicheng.equals("")){
                    if (!account.getZhiCheng().contains("护士") &&ksmc.contains(ksmcs)) {
                        accounts.add(account);
                    }
                }else {
                    if(ksmcs!=null&&!ksmcs.equals("")){

                        if (ksmc.contains(ksmcs)) {
                            accounts.add(account);
                        }
                    }
                }


        }
    return accounts;
    }


}