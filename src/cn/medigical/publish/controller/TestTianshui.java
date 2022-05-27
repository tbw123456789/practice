package cn.medigical.publish.controller;

import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigDepartmentsDao;
import cn.medigical.publish.interfaces.his.hisTianshui.HisLinkTianshui;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.dictionary.ConfigDepartments;
import cn.medigical.publish.utils.FrontHelper;
import cn.medigical.publish.utils.SpringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Tianshui")
public class TestTianshui {

    private  HisLinkTianshui hisLinkTianshui = new HisLinkTianshui();

    @RequestMapping(value = "getDepartmentFromHis", method = RequestMethod.GET)
    public void getDepartmentFromHis(){
        List<ConfigDepartments> newAcconutList=new ArrayList<>();
        List<ConfigDepartments> departmentListFromHis =  hisLinkTianshui.getDepartmentFromHis();
        List<ConfigDepartments> departmentListFromDb= SpringUtils.getBean(ConfigDepartmentsDao.class).getAll();
        for (int i=0;i<departmentListFromHis.size();i++){
            boolean flag=false;
            for (int j=0;j<departmentListFromDb.size();j++){
                if (departmentListFromDb.get(j).getCode().equals(departmentListFromHis.get(i).getCode())){
                    flag=true;
                }
            }
            if (!flag){
                newAcconutList.add(departmentListFromHis.get(i));
            }
        }
        SpringUtils.getBean(ConfigDepartmentsDao.class).addAll(newAcconutList);
    }

    @RequestMapping(value = "getAccountFromHis", method = RequestMethod.GET)
    public void getAccountFromHis(){
        List<Account> newAcconutList = new ArrayList<>();

        List<Account> accountListFromHis =  hisLinkTianshui.getAccountFromHis();

        Map<String, Account> filterAccountMap = new HashMap<>();
        for (Account accountFrom : accountListFromHis) {
            filterAccountMap.put(accountFrom.getWorkID(),accountFrom);
        }

        if (null == filterAccountMap || filterAccountMap.size() == 0) {
            return;
        }
        List<Account> accountListFromDb = SpringUtils.getBean(AccountDao.class).gets();

        if (accountListFromDb != null) {
            for(String workID : filterAccountMap.keySet()){
                boolean flag = false;
                for (int j = 0; j < accountListFromDb.size(); j++) {
                    if (null != accountListFromDb.get(j).getWorkID())
                        if (accountListFromDb.get(j).getWorkID().equals(filterAccountMap.get(workID).getWorkID())) {
                            flag = true;
                        }
                }
                if (!flag) {
                    newAcconutList.add(filterAccountMap.get(workID));
                }
            }
        }

        SpringUtils.getBean(AccountDao.class).addAll(newAcconutList);
    }

    @RequestMapping(value="getOperationFromHis" , method = RequestMethod.GET)
    public void getOperationFromHis(){
        hisLinkTianshui.getOperationFromHis();
    }

    private String patientID;
    private String id;
    private String zyh;

    @RequestMapping(value="getJianYanFromHisForLis" , method = RequestMethod.GET)
    public void getJianYanFromHisForLis(HttpServletRequest request){
        Map<String, Object> params = FrontHelper.transfParams(request);
        Map<String, String> map = new HashMap<>();
        if (params.get("patientID") != null && !params.get("patientID").toString().equals("")){
            patientID =  params.get("patientID").toString();
        }
        if (params.get("id") != null && !params.get("id").toString().equals("")){
            id =  params.get("id").toString();
        }
        hisLinkTianshui.JianYanFromHisForLis(patientID , id);
    }
    @RequestMapping(value="getPatientInfoFromHisByID" , method = RequestMethod.GET)
    public void getPatientInfoFromHisByID(HttpServletRequest request){
        Map<String, Object> params = FrontHelper.transfParams(request);
        Map<String, String> map = new HashMap<>();
        if (params.get("zyh") != null && !params.get("zyh").toString().equals("")){
            zyh =  params.get("zyh").toString();
        }

        hisLinkTianshui.getPatientInfoFromHisByID(zyh);
    }
}
