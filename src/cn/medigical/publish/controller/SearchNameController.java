package cn.medigical.publish.controller;

import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.utils.SpringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("SearchNameController")
public class SearchNameController {
    AccountDao accountDao = (AccountDao) SpringUtils.getBean(AccountDao.class);
    PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);
    @RequestMapping(value = "display", method = RequestMethod.GET)
    public String showView(Model m, HttpServletRequest request){

        return "searchpatient/searchpatient";
    }
    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String SearchList(Model m, HttpServletRequest request){
        String brxm=request.getParameter("brxm");
        List<PatientLink> patientLinks=patientLinkDao.getTableOpersBrxm(brxm);
        System.out.println( "查询结果--"+patientLinks.size());
        m.addAttribute("patientLinks",patientLinks);
        m.addAttribute("test","收到后台传过来的只");

        return "searchpatient/searchpatient";
    }


}
