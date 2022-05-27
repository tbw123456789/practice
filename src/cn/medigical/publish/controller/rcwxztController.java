package cn.medigical.publish.controller;


import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.interfaces.CQ.rongchang.RongChangWxzt;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.utils.SpringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 荣昌医院无线镇痛查询接口
 */

@Controller
@RequestMapping("RcwxztController")
public class rcwxztController {
    PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);
    AccountDao accountDao = SpringUtils.getBean(AccountDao.class);

    //荣昌医院，根据住院号码查询病人其他信息
    @ResponseBody
    @RequestMapping(value = "rcsearch", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public Map<Object, Object> rcsearch(HttpServletRequest request) {
        String zyh = request.getParameter("zyh");

        Map<Object, Object> map = new HashMap<>();
        PatientLink patientLink = patientLinkDao.getPatientLinkByZyh(zyh);
        RongChangWxzt rongchangwxzt = new RongChangWxzt();
        if (patientLink == null) {
            map.put("success", false);
            map.put("wxztpojo", "该住院号无病人,请检查住院号是否正确!");
        } else if (patientLink != null) {
            rongchangwxzt.setBlh(panduan(patientLink.getPatient().getZyh()));
            rongchangwxzt.setZyh(panduan(patientLink.getPatient().getZyh()));
            rongchangwxzt.setXb(panduan(patientLink.getPatient().getXb()));
            rongchangwxzt.setXm(panduan(patientLink.getPatient().getBrxm()));
            rongchangwxzt.setKs(panduan(patientLink.getPatient().getKsmc()));
            rongchangwxzt.setBq(panduan(patientLink.getPatient().getBqmc()));
            rongchangwxzt.setCh(panduan(patientLink.getPatient().getZych()));
            rongchangwxzt.setCsrq(getdate(patientLink.getPatient().getDob()));
            rongchangwxzt.setNl(delyear(panduan(patientLink.getPatient().getNl())));
            rongchangwxzt.setTz(delyear(panduan(patientLink.getPatient().getTz())));
            rongchangwxzt.setSg((delyear(patientLink.getPatient().getSg())));
            rongchangwxzt.setSsmc(panduan(patientLink.getApplication().getNsssmc()));
            rongchangwxzt.setMzys(panduan(accountDao.findAccountById(patientLink.getAnesthesiaRecord().getZmys()).getTrueName()));
            rongchangwxzt.setAsa(panduan(patientLink.getAnesthesiaRecord().getAsa().getLevel()));
            rongchangwxzt.setZtfs((getztfs(patientLink)));
            rongchangwxzt.setZtpf("");
            rongchangwxzt.setSssj(getdate(patientLink.getStatus().getInRoomTime()));
            rongchangwxzt.setFb(panduan(patientLink.getFeiBie()));
            rongchangwxzt.setJzklx(panduan(patientLink.getPatient().getYblx()));
            rongchangwxzt.setJzkkh("");
            rongchangwxzt.setSflx("");
            rongchangwxzt.setSfzh("");
            rongchangwxzt.setHzdz("");
            rongchangwxzt.setLxfs("");
            rongchangwxzt.setShzd(panduan(patientLink.getAnesthesiaRecord().getShzd1()));
            map.put("success", true);
            map.put("wxztpojo", rongchangwxzt);
        }
        return map;
    }

    private String getdate(Date date){
        String da="";
        SimpleDateFormat dateformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(date!=null){
            da=dateformat.format(date);
        }
        return da;
    }
    private String getztfs(PatientLink patientLink){
       String ztfs="";
       if(patientLink.getAnesthesiaRecord().getPCNA()){
           ztfs="PCNA";
       }else if(patientLink.getAnesthesiaRecord().getPCIA()){
           ztfs="PCIA";
       }else if(patientLink.getAnesthesiaRecord().getPCEA()){
           ztfs="PCEA";
       }else if(patientLink.getAnesthesiaRecord().getWyPCA()){
           ztfs="未用PCA";
       }
       return ztfs;
    }
    public String panduan(String string) {
        if (string == null) {
            return "";
        }else {
            return string;
        }
    }

    public int delyear(String string){
        Integer nuber=0;
        if(string.contains("岁")){
            int leng=string.indexOf("岁");

            string=string.substring(0,leng);
        }
            if(!string.equals("")){
              nuber= Integer.parseInt(string) ;
            }

            return nuber;
    }
}