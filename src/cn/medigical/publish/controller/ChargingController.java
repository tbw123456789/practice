package cn.medigical.publish.controller;

import cn.medigical.publish.dao.impl.ConfigHisConsumesDao;
import cn.medigical.publish.dao.impl.ConfigHisDrugsDao;
import cn.medigical.publish.dao.impl.ConfigHisTreatmentDao;
import cn.medigical.publish.dao.impl.RequestChargingDataDao;
import cn.medigical.publish.pojo.dictionary.ConfigHisConsumes;
import cn.medigical.publish.pojo.dictionary.ConfigHisDrugs;
import cn.medigical.publish.pojo.dictionary.ConfigHisTreatment;
import cn.medigical.publish.pojo.xiandaiyiyuan.*;
import cn.medigical.publish.utils.Constants;
import cn.medigical.publish.utils.HttpUtils;
import cn.medigical.publish.utils.SpringUtils;
import cn.medigical.publish.utils.StringUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping("ChargingController")
public class ChargingController {

    RequestChargingDataDao chargingDataDao = SpringUtils.getBean(RequestChargingDataDao.class);

    ConfigHisConsumesDao configHisConsumesDao = SpringUtils.getBean(ConfigHisConsumesDao.class);

    ConfigHisDrugsDao configHisDrugsDao = SpringUtils.getBean(ConfigHisDrugsDao.class);

    ConfigHisTreatmentDao configHisTreatmentDao = SpringUtils.getBean(ConfigHisTreatmentDao.class);

    private Map<String,String> drugTypes = new ConcurrentHashMap<>();

    private Map<String,String> consumeTypes = new ConcurrentHashMap<>();

    private Map<String,String> treatmentTypes = new ConcurrentHashMap<>();

    public Connection getConnection() {
        Connection connection = null;
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://172.168.3.12:1433;databaseName=scxdyycsk";
        String username = "sa";
        String password = "xd098039";
        System.out.println("driverName:" + driverName + "\n url:" + url + "\n username:" + username + "\n password:" + password);
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connect to his SQLServer ok.");
        } catch (Exception ex) {
            System.out.println("Could not establish his SQLServer connection! " + ex.getMessage());
        }
        return connection;
    }

    public void closeConnection(Connection connection, Statement statement, ResultSet resultSet) {
        if (null != resultSet) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("Could not close resultSet! " + e.getMessage());
            }
        }
        if (null != statement) {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Could not close statement! " + e.getMessage());
            }
        }
        if (null != connection) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Could not close connection! " + e.getMessage());
            }
        }
    }

    private StringBuffer getSql(String flag, CheckProject project, Map<String, String> strSqlMap){
        StringBuffer buffer = new StringBuffer();
        ChargeProject chargeProject = project.getChargeProject();
        if(chargeProject != null) {
            switch (chargeProject.getYzzl()) {
                case Constants.HIS_DRUGS_CODE:
                    if (flag.contains(Constants.HIS_COURTYARDA_CODE)) {
                        sqlBuffer(chargeProject, strSqlMap, buffer, "84");
                    } else if (flag.contains(Constants.HIS_COURTYARDB_CODE)) {
                        sqlBuffer(chargeProject, strSqlMap, buffer, "85");
                    }
                    break;
                case Constants.HIS_CONSUMES_CODE:
                    if (flag.contains(Constants.HIS_COURTYARDA_CODE)) {
                        sqlBuffer(chargeProject, strSqlMap, buffer, "60");
                    } else if (flag.contains(Constants.HIS_COURTYARDB_CODE)) {
                        sqlBuffer(chargeProject, strSqlMap, buffer, "M6");
                    }
                    break;
                default:
                    buffer.append("-1");
                    break;
            }
        }
        return buffer;
    }

    private void sqlBuffer(ChargeProject project, Map<String, String> strSqlMap, StringBuffer buffer, String key) {
        buffer.append(strSqlMap.get(project.getYzzl()));
        buffer.append(" kfbm = '").append(key).append("' and ypbm = '").append(project.getBh()).append("' ");
        buffer.append(" and kcsl < '").append(project.getSl_zl()).append("' ");
        buffer.append(" union all ");
        buffer.append(" select case when EXISTS(");
        buffer.append(strSqlMap.get(project.getYzzl()));
        buffer.append(" kfbm ='").append(key).append("'");
        buffer.append(" and ypbm = '").append(project.getBh()).append("') then '' else '").append(project.getBh()).append("' end as ypbm,");
        buffer.append("case when EXISTS(");
        buffer.append(strSqlMap.get(project.getYzzl()));
        buffer.append(" kfbm ='").append(key).append("'");
        buffer.append(" and ypbm = '").append(project.getBh()).append("') then '' else '").append(key).append("' end as kfbm,");
        buffer.append("case when EXISTS(");
        buffer.append(strSqlMap.get(project.getYzzl()));
        buffer.append(" kfbm ='").append(key).append("'");
        buffer.append(" and ypbm = '").append(project.getBh()).append("') then '' else 0 end as kcsl");
    }

    /**
     *
     * @param checkProjectList
     * @param flag
     * @return
     *  success 库存是否有剩
     *  list 所有库存不足材料、药品
     *  Msg 核查库存不足返回消息
     */
    public Map<String, Object> checkDataBase(List<CheckProject> checkProjectList, String flag) {
        Map<String,Object> map = new HashMap<>();
        if (checkProjectList != null&&checkProjectList.size()>0){
            ResultSet resultSet = null;
            Statement statement = null;
            Connection connection = getConnection();
            List<CheckProject> checkProjects = new ArrayList<>();
            Map<String,String> strSqlMap = new HashMap<>();
            strSqlMap.put(Constants.HIS_DRUGS_CODE,"select xybm.ypbm,xybm.kfbm,xybm.kcsl,xybm.jm,xybm.ypmc,xybm.cj,xybm.gyzz,ypjldw.mc as dwmc,ypjx.mc from V_XYBM xybm LEFT JOIN V_YPJLDW ypjldw on xybm.JLDW1 = ypjldw.bh LEFT JOIN V_YPJX ypjx on xybm.JX = ypjx.BH where");
            strSqlMap.put(Constants.HIS_CONSUMES_CODE,"select clbm.ypbm,clbm.kfbm,clbm.kcsl,clbm.JM,clbm.ypmc,ypjldw.mc as dwmc,clbm.cj,bmbmbb.mc from V_CLBM clbm LEFT JOIN V_YPJLDW ypjldw on clbm.JLDW1 = ypjldw.bh left join v_bmbmbb bmbmbb on bmbmbb.bh = clbm.kfbm where");
            StringBuffer buffer = null;
            try {
                for (CheckProject project : checkProjectList) {
                    buffer = getSql(flag, project, strSqlMap);
                    if(StringUtil.isEmpty(buffer.toString())){
                        map.put("Msg", "没有计费项需要校验或者计费！！！");
                        map.put("success", false);
                        return map;
                    }else if("-1".equals(buffer.toString())){
                        continue;//如果为收费项，不用校验
                    }
                    if (connection != null) {
                        if(statement != null){
                            statement.close();
                        }
                        if(resultSet != null){
                            resultSet.close();
                        }
                        statement = connection.createStatement();
                        resultSet = statement.executeQuery(buffer.toString());
                        while (resultSet.next()) {
                            if(!StringUtil.isEmpty(resultSet.getString("ypbm"))) {
                                project.getChargeProject().setSl_zl(resultSet.getInt("kcsl"));
                                checkProjects.add(project);
                            }
                        }
                    } else {
                        map.put("Msg", "His数据库连接失败！！！");
                    }
                }
            }catch (Exception e){
                if(buffer !=null) {
                    map.put("Msg", "sql执行失败！！！"+buffer.toString());
                }
                e.printStackTrace();
            }finally {
                closeConnection(connection,statement,resultSet);
            }
            if(checkProjects.size() > 0) {
                map.put("Msg", "有"+checkProjects.size()+"项用药或耗材库存不足！！！");
                map.put("list", checkProjects);
                map.put("success", false);
            }else{
                map.put("success", true);
            }
            return map;
        }else{
            map.put("Msg", "计费失败，没有计费项目！");
        }
        map.put("success",false);
        return map;
    }

        /**
         *
         * @param jsonStr
         * @return
         * Msg 所有返回消息
         * OutData 所有His返回数据
         * Code 返回错误、正确代码
         * success 是否计费成功
         */
    @ResponseBody
    @RequestMapping(value = "charging", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Map<String, Object> searchOperApply(@RequestBody String jsonStr) {
        Map<String, Object> map = new HashMap<>();
        if (!StringUtil.isEmpty(jsonStr)) {
            RequestChargingData chargingData = JSONObject.parseObject(jsonStr, RequestChargingData.class);
            Map<String, String> reqMap = new HashMap<>();
            reqMap.put("jybh", JSONObject.toJSON(chargingData.getJybh()).toString());
            reqMap.put("data", JSONObject.toJSON(chargingData.getData()).toString());
            String plinkId = chargingData.getPlinkId();
            String flag = chargingData.getFlag();
            if(chargingData.isCheckInStock()) {
                Map<String, Object> checkResult = checkDataBase(chargingData.getCheckProjects(), flag);
                if (!Boolean.parseBoolean(checkResult.get("success").toString())) {
                    return checkResult;
                }
            }
            synchronized (this){
                RequestChargingData cacheData = chargingDataDao.findByPlinkId(plinkId);
                if (cacheData == null) {
                    String retData = HttpUtils.sendPost(Constants.HIS_CHARGING_URL, reqMap);
                    if (!StringUtil.isEmpty(retData)) {
                        ResultChargingData resultChargingData = JSONObject.parseObject(retData, ResultChargingData.class);
                        int code = resultChargingData.getCode();
                        if (code == 1) {
                            boolean result = chargingDataDao.save(chargingData);
                            if (!result) {
                                map.put("Msg", "计费失败，请联系手麻系统管理员！");
                                map.put("success", false);
                                return map;
                            }
                            map.put("success", true);
                        } else {
                            map.put("success", false);
                        }
                        String outData = resultChargingData.getOutData();
                        String msg = resultChargingData.getMsg();
                        map.put("retJson",retData);
                        map.put("Msg", "His接口返回消息是："+msg);
                        map.put("OutData", outData);
                        map.put("Code", code);
                        return map;
                    }
                    map.put("Msg", "His计费系统未返回值！");
                } else {
                    map.put("Msg", "计费失败，请别重复计费！");
                }
            }
            map.put("success", false);
            return map;
        }
        map.put("Msg", "计费失败,接收到手麻客户端的空消息！");
        map.put("success", false);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "syncConfigHisDrugs", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public boolean syncConfigHisDrugs(@RequestBody String jsonStr) {
        JSONArray typeParams;
        StringBuilder builder = new StringBuilder();
        builder.append("select xybmzd.ypbm,xybmzd.jm,xybmzd.ypmc,xybmzd.cj,xybmzd.gyzz,ypjldw.mc dwmc,ypjx.mc as yplb,xybmzd.ypdl from V_XYBM_ZD xybmzd LEFT JOIN V_YPJLDW ypjldw on xybmzd.JLDW1 = ypjldw.bh LEFT JOIN V_YPJX ypjx on xybmzd.JX = ypjx.BH where 1=1 ");
        if (!StringUtil.isEmpty(jsonStr)) {
            JSONObject object = JSON.parseObject(jsonStr);
            typeParams = object.getJSONArray("data");
            if (typeParams != null && typeParams.size() > 0) {
                builder.append(" and ypjx.bh in (");
                for (Object item : typeParams) {
                    builder.append("N'").append(StringUtil.nullToSpace(drugTypes.get(item.toString()))).append("',");
                }
                builder.deleteCharAt(builder.length() - 1);
                builder.append(")");
            }
            builder.append(" and ypdl = '01'");
        }
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = getConnection();
        try {
            if (connection == null) {
                return false;
            } else {
                List<ConfigHisDrugs> localHisDrugs = configHisDrugsDao.getAll();
                statement = connection.createStatement();
                resultSet = statement.executeQuery(builder.toString());
                while (resultSet.next()) {
                    ConfigHisDrugs hisDrugs = new ConfigHisDrugs();
                    hisDrugs.setId(StringUtil.trim(StringUtil.nullToSpace(resultSet.getString("ypbm"))));
                    hisDrugs.setDrugCode(StringUtil.trim(StringUtil.nullToSpace(resultSet.getString("ypbm"))));
                    hisDrugs.setDrugName(StringUtil.trim(StringUtil.nullToSpace(resultSet.getString("ypmc"))));
                    hisDrugs.setDrugShortCode(StringUtil.trim(StringUtil.nullToSpace(resultSet.getString("jm"))));
                    hisDrugs.setDrugCMS(StringUtil.trim(StringUtil.nullToSpace(resultSet.getString("gyzz"))));
                    hisDrugs.setDrugType(StringUtil.trim(StringUtil.nullToSpace(resultSet.getString("yplb"))));
                    hisDrugs.setManufactor(StringUtil.trim(StringUtil.nullToSpace(resultSet.getString("cj"))));
                    hisDrugs.setDrugUnite(StringUtil.trim(StringUtil.nullToSpace(resultSet.getString("dwmc"))));
                    hisDrugs.setDeleted(true);
                    boolean flag = false;
                    for (ConfigHisDrugs item : localHisDrugs){
                        if(hisDrugs.getDrugCode().equals(item.getDrugCode())){
                            flag = true;
                            break;
                        }
                    }
                    if(!flag){
                        configHisDrugsDao.save(hisDrugs);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection(connection,statement,resultSet);
        }
        return true;
    }

    @ResponseBody
    @RequestMapping(value = "syncConfigHisDrugsType", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public List<String> syncConfigHisDrugsType() {
        List<String> type = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = getConnection();
        try {
            if (connection == null) {
                return type;
            } else {
                statement = connection.createStatement();
                resultSet = statement.executeQuery("select ypjx.mc as yplb,ypjx.bh as ypbh from V_XYBM_ZD xybmzd LEFT JOIN V_YPJLDW ypjldw on xybmzd.JLDW1 = ypjldw.bh LEFT JOIN V_YPJX ypjx on xybmzd.JX = ypjx.BH where ypdl = '01' group by ypjx.mc,ypjx.bh");
                while (resultSet.next()) {
                    String yplbValue = resultSet.getString("yplb");
                    String yplb = StringUtil.trim(StringUtil.nullToSpace(yplbValue));
                    if (!StringUtils.isEmpty(yplb)) {
                        type.add(yplb);
                        if(StringUtil.isEmpty(drugTypes.get(yplb))) {
                            drugTypes.put(yplb, resultSet.getString("ypbh"));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection(connection,statement,resultSet);
        }
        return type;
    }

    @ResponseBody
    @RequestMapping(value = "syncConfigHisConsumes", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public boolean syncConfigHisConsumes(@RequestBody String jsonStr) {
        JSONArray typeParams;
        StringBuilder builder = new StringBuilder();
        builder.append("select xybmzd.ypbm,xybmzd.jm,xybmzd.ypmc,xybmzd.cj,xybmzd.gyzz,ypjldw.mc dwmc,ypjx.mc as yplb,xybmzd.ypdl from V_XYBM_ZD xybmzd LEFT JOIN V_YPJLDW ypjldw on xybmzd.JLDW1 = ypjldw.bh LEFT JOIN V_YPJX ypjx on xybmzd.JX = ypjx.BH where 1=1");
        if (!StringUtil.isEmpty(jsonStr)) {
            JSONObject object = JSON.parseObject(jsonStr);
            typeParams = object.getJSONArray("data");
            if (typeParams != null && typeParams.size() > 0) {
                builder.append(" and ypjx.bh in (");
                for (Object item : typeParams) {
                    builder.append("N'").append(StringUtil.nullToSpace(consumeTypes.get(item.toString()))).append("',");
                }
                builder.deleteCharAt(builder.length() - 1);
                builder.append(")");
            }
            builder.append(" and ypdl = '03'");
        }
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = getConnection();
        try {
            if (connection == null) {
                return false;
            } else {
                List<ConfigHisConsumes> localHisConsumes = configHisConsumesDao.getAll();
                statement = connection.createStatement();
                resultSet = statement.executeQuery(builder.toString());
                while (resultSet.next()) {
                    ConfigHisConsumes hisConsumes = new ConfigHisConsumes();
                    hisConsumes.setId(StringUtil.trim(StringUtil.nullToSpace(resultSet.getString("ypbm"))));
                    hisConsumes.setConsumeCode(StringUtil.trim(StringUtil.nullToSpace(resultSet.getString("ypbm"))));
                    hisConsumes.setConsumeName(StringUtil.trim(StringUtil.nullToSpace(resultSet.getString("ypmc"))));
                    hisConsumes.setConsumeShortCode(StringUtil.trim(StringUtil.nullToSpace(resultSet.getString("jm"))));
                    hisConsumes.setConsumeType(StringUtil.trim(StringUtil.nullToSpace(resultSet.getString("yplb"))));
                    hisConsumes.setManufactor(StringUtil.trim(StringUtil.nullToSpace(resultSet.getString("cj"))));
                    hisConsumes.setConsumeUnite(StringUtil.trim(StringUtil.nullToSpace(resultSet.getString("dwmc"))));
                    hisConsumes.setDeleted(true);
                    boolean flag = false;
                    for (ConfigHisConsumes item : localHisConsumes) {
                        if (hisConsumes.getConsumeCode().equals(item.getConsumeCode())) {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        configHisConsumesDao.save(hisConsumes);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            closeConnection(connection,statement,resultSet);
        }
        return true;
    }

    @ResponseBody
    @RequestMapping(value = "syncConfigHisConsumesType", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public List<String> syncConfigHisConsumesType() {
        List<String> type = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = getConnection();
        try {
            if (connection == null) {
                return type;
            } else {
                statement = connection.createStatement();
                resultSet = statement.executeQuery("select ypjx.mc as yplb,ypjx.bh as ypbh from V_XYBM_ZD xybmzd LEFT JOIN V_YPJLDW ypjldw on xybmzd.JLDW1 = ypjldw.bh LEFT JOIN V_YPJX ypjx on xybmzd.JX = ypjx.BH where ypdl = '03' group by ypjx.mc,ypjx.bh");
                while (resultSet.next()) {
                    String yplbValue = resultSet.getString("yplb");
                    String yplb = StringUtil.trim(StringUtil.nullToSpace(yplbValue));
                    if (!StringUtils.isEmpty(yplb)) {
                        type.add(yplb);
                        if(StringUtil.isEmpty(consumeTypes.get(yplb))) {
                            consumeTypes.put(yplb, resultSet.getString("ypbh"));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection(connection,statement,resultSet);
        }
        return type;
    }

    @ResponseBody
    @RequestMapping(value = "syncConfigHisTreatmentType", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public List<String> syncConfigHisTreatmentType() {
        List<String> type = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = getConnection();
        try {
            if (connection == null) {
                return type;
            } else {
                statement = connection.createStatement();
                resultSet = statement.executeQuery("select fyzl.MC as zllb,fyzl.BH as zlbh from V_ZLXM zlxm LEFT JOIN V_FYZL fyzl on zlxm.fyzl = fyzl.BH group by fyzl.MC,fyzl.BH");
                while (resultSet.next()) {
                    String zllb = StringUtil.trim(StringUtil.nullToSpace(resultSet.getString("zllb")));
                    if (!StringUtils.isEmpty(zllb)) {
                        type.add(zllb);
                        if(StringUtil.isEmpty(treatmentTypes.get(zllb))) {
                            treatmentTypes.put(zllb, resultSet.getString("zlbh"));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection(connection,statement,resultSet);
        }
        return type;
    }

    @ResponseBody
    @RequestMapping(value = "syncConfigHisTreatment", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public boolean syncConfigHisTreatment(@RequestBody String jsonStr) {
        JSONArray typeParams = null;
        if (!StringUtil.isEmpty(jsonStr)) {
            JSONObject object = JSONObject.parseObject(jsonStr);
            typeParams = object.getJSONArray("data");
        }
        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = getConnection();
        try {
            StringBuilder builder = new StringBuilder();
            builder.append("select zlxm.yzzl,zlxm.mc as zlmc,zlxm.newbh as Newbh,zlxm.dw as zldw,fyzl.mc as zllb from V_ZLXM zlxm LEFT JOIN V_FYZL fyzl on zlxm.fyzl = fyzl.BH");
            if (typeParams != null && typeParams.size() > 0) {
                builder.append(" where fyzl.bh in (");
                for (Object item : typeParams) {
                    builder.append("N'").append(StringUtil.nullToSpace(treatmentTypes.get(item.toString()))).append("',");
                }
                builder.deleteCharAt(builder.length() - 1);
                builder.append(")");
            }
            if (connection == null) {
                return false;
            } else {
                List<ConfigHisTreatment> localHisTreatment = configHisTreatmentDao.getAll();
                statement = connection.createStatement();
                resultSet = statement.executeQuery(builder.toString());
                while (resultSet.next()) {
                    ConfigHisTreatment hisTreatment = new ConfigHisTreatment();
                    hisTreatment.setId(StringUtil.trim(StringUtil.nullToSpace(resultSet.getString("Newbh"))));
                    hisTreatment.setTreatmentCode(StringUtil.trim(StringUtil.nullToSpace(resultSet.getString("Newbh"))));
                    hisTreatment.setTreatmentName(StringUtil.trim(StringUtil.nullToSpace(resultSet.getString("zlmc"))));
                    hisTreatment.setTreatmentType(StringUtil.trim(StringUtil.nullToSpace(resultSet.getString("zllb"))));
                    hisTreatment.setTreatmentUnite(StringUtil.trim(StringUtil.nullToSpace(resultSet.getString("zldw"))));
                    hisTreatment.setTreatmentYzzl(StringUtil.trim(StringUtil.nullToSpace(resultSet.getString("yzzl"))));
                    hisTreatment.setDeleted(true);
                    boolean flag = false;
                    for (ConfigHisTreatment item : localHisTreatment){
                        if(hisTreatment.getTreatmentCode().equals(item.getTreatmentCode())){
                            flag = true;
                            break;
                        }
                    }
                    if(!flag){
                        configHisTreatmentDao.save(hisTreatment);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeConnection(connection,statement,resultSet);
        }
        return true;
    }

}
