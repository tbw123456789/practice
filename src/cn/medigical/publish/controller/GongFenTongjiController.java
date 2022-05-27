package cn.medigical.publish.controller;

import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.PatientEventsDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigAnesMethodsDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigAnesMethodsGroupDao;
import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigEventsDao;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.dictionary.ConfigAnesMethods;
import cn.medigical.publish.pojo.dictionary.ConfigAnesMethodsGroup;
import cn.medigical.publish.pojo.dictionary.ConfigEvents;
import cn.medigical.publish.pojo.patient.PatientEvents;
import cn.medigical.publish.pojo.patientLink.GongFenXiangQing;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.utils.AjaxMsg;
import cn.medigical.publish.utils.Constants;
import cn.medigical.publish.utils.FrontHelper;
import cn.medigical.publish.utils.SpringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("gongFenTongjiController")
public class GongFenTongjiController {
    PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);
    AccountDao accountDao = (AccountDao) SpringUtils.getBean(AccountDao.class);
    ConfigAnesMethodsGroupDao configAnesMethodsGroupDao = SpringUtils.getBean(ConfigAnesMethodsGroupDao.class);
    ConfigAnesMethodsDao configAnesMethodsDao = SpringUtils.getBean(ConfigAnesMethodsDao.class);

    public Map<String, String> configAnesMethodsMap = new HashMap<>();
    public Map<String, String> basicMessage = new HashMap<>();

    public String getConfigAnesMethodsGroupCode(String code) {
        if (configAnesMethodsMap.get(code) == null) {
            configAnesMethodsMap.clear();
            List<ConfigAnesMethods> list = configAnesMethodsDao.getIsTrue();
            for (ConfigAnesMethods c : list) {
                configAnesMethodsMap.put(c.getCode(), c.getGroupCode());
            }
            return configAnesMethodsMap.get(code);
        } else {
            return configAnesMethodsMap.get(code);
        }
    }

    @RequestMapping(value = "gongFenTongJi", method = RequestMethod.GET)
    public Object gongFenTongJi(HttpServletRequest request) {
        basicMessage.clear();
        Map<String, Object> params = FrontHelper.transfParams(request);
        if (params.get("starttime") != null && !params.get("starttime").toString().equals("")){
            basicMessage.put("startDate", params.get("starttime").toString());
        }
        if (params.get("endtime") != null && !params.get("endtime").toString().equals("")){
            basicMessage.put("endDate", params.get("endtime").toString());
        }
        if (params.get("docname") != null && !params.get("docname").toString().equals("")){
            basicMessage.put("doctorNameID", params.get("docname").toString());
        }
        return "gongfentongji/gongFenTongJi";
    }

    @ResponseBody
    @RequestMapping(value = "gongFenTongJiName", method = RequestMethod.GET)
    public Object getUser() {
        List<ConfigAnesMethodsGroup> list = configAnesMethodsGroupDao.getDateIsFalse();
        return list;
    }

    private void getXqfx(){
        eventCode.clear();
        List<ConfigEvents> list = SpringUtils.getBean(ConfigEventsDao.class).getAll();
        for (ConfigEvents c : list){
            if (c.getName() != null && c.getName().contains("查动脉血气")){
                eventCode.add(c.getCode());
            }
        }
    }

    @ResponseBody
    @RequestMapping(value = "index")
    public Object index() throws ParseException {
        getXqfx();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
//        Calendar c = Calendar.getInstance();String.valueOf(c.get(Calendar.MONTH) + 1
        Date startDate = getStartDateByMonth(f.format(new Date()));
        Date endDate = new Date();
        String doctorNameID = "";
        if (basicMessage.get("startDate") != null && !basicMessage.get("startDate").equals("")){
            startDate = f.parse(basicMessage.get("startDate"));
        }
        if (basicMessage.get("endDate") != null && !basicMessage.get("endDate").equals("")){
            endDate = nextDay(basicMessage.get("endDate") , +1);
        }
        if (basicMessage.get("doctorNameID") != null && !basicMessage.get("doctorNameID").equals("")){
            doctorNameID = basicMessage.get("doctorNameID");
        }
        Map<String, Object> result = new HashMap<>();
        if (doctorNameID.equals("admin")){
            List<Map<String, String>> resultList = new ArrayList<>();
            for (Map<String, String> entry : nameIsNull(startDate, endDate)){
                resultList.add(entry);
            }
            List<Account> list = accountDao.findAccountInMazui();
            for (Account a : list) {
                for (Map<String, String> entry : nameIsNotNull(startDate , endDate , accountDao.findAccountListByNameAll(a.getTrueName()))) {
                    String name = a.getTrueName() + entry.get("date");
                    entry.put("date", name);
                    resultList.add(entry);
                }
            }
            result.put("rows",resultList);
            result.put("total", 0);
        }else if (!doctorNameID.equals("")){
            result.put("total", 0);
            Account account = accountDao.findAccountById(doctorNameID);
            result.put("rows", nameIsNotNull(startDate , endDate , accountDao.findAccountListByNameAll(account.getTrueName())));
        }else{
            result.put("total", 0);
            result.put("rows",nameIsNull(startDate, endDate));
        }
        return result;
    }

    private List<Map<String, String>> nameIsNull(Date startDate , Date endDate){
        Map<String, List<GongFenXiangQing>> map = new HashMap<>();
        List<PatientLink> patientLinkList = new ArrayList<>();
        List<PatientLink> patientLinkLists = patientLinkDao.getAllGongFengTongJi(startDate, endDate);
        for (PatientLink pa : patientLinkLists){
//            System.out.println(patientLinkList.size());
            GongFenXiangQing g = new GongFenXiangQing();
            calWorkPoints(g , pa);
            patientLinkList.add(pa);
        }
        inDateSort(patientLinkList, map);
        HashSet<String> set = new HashSet<>();
        for (Map.Entry<String, List<GongFenXiangQing>> entry : map.entrySet()) {
            set.add(entry.getKey());
        }
        Map<String, GongFenXiangQing> map1 = new HashMap<>();
        for (String entry : set){
            if (map.size() > 0 && map.get(entry) != null) {
                GongFenXiangQing gongFenXiangQing = new GongFenXiangQing();
                HashMap<String, Float> mapMzfsgf = new HashMap<>();
                for (GongFenXiangQing g : map.get(entry)) {
                    if (g.getMzfsgf() != null && !g.getMzfsgf().equals("") && g.getMzfsgf().contains(":")) {
                        String[] str = g.getMzfsgf().split(":");
                        String name = getConfigAnesMethodsGroupCode(str[0]);
                        float value = getFloat(str[1]);
                        if (mapMzfsgf.get(name) == null) {
                            mapMzfsgf.put(name, value);
                        } else {
                            mapMzfsgf.put(name, mapMzfsgf.get(name) + value);
                        }
                    }
                    float zongfen = getFloat(gongFenXiangQing.getZongfen()) + getFloat(g.getZongfen());
                    gongFenXiangQing.setZongfen(String.valueOf(zongfen));
                    float ycdmccjjc = getFloat(gongFenXiangQing.getYcdmccjjc()) + getFloat(g.getYcdmccjjc()) + getFloat(g.getJbysycdmccjjc());
                    gongFenXiangQing.setYcdmccjjc(String.valueOf(ycdmccjjc));
                    float zxjmccjjc = getFloat(gongFenXiangQing.getZxjmccjjc()) + getFloat(g.getZxjmccjjc()) + getFloat(g.getJbyszxjmccjjc());
                    gongFenXiangQing.setZxjmccjjc(String.valueOf(zxjmccjjc));
                    float mzsdjc = getFloat(gongFenXiangQing.getMzsdjc()) + getFloat(g.getMzsdjc());
                    gongFenXiangQing.setMzsdjc(String.valueOf(mzsdjc));
                    float xljc = getFloat(gongFenXiangQing.getXljc()) + getFloat(g.getXljc());
                    gongFenXiangQing.setXljc(String.valueOf(xljc));
                    float szcs = getFloat(gongFenXiangQing.getSzcs()) + getFloat(g.getSzcs());
                    gongFenXiangQing.setSzcs(String.valueOf(szcs));
                    float szxqfx = getFloat(gongFenXiangQing.getSzxqfx()) + getFloat(g.getSzxqfx());
                    gongFenXiangQing.setSzxqfx(String.valueOf(szxqfx));
                    float fsxqfx = getFloat(gongFenXiangQing.getFsxqfx()) + getFloat(g.getFsxqfx());
                    gongFenXiangQing.setFsxqfx(String.valueOf(fsxqfx));
                    float shzt = getFloat(gongFenXiangQing.getShzt()) + getFloat(g.getShzt());
                    gongFenXiangQing.setShzt(String.valueOf(shzt));
                    float qsmzjcxs = getFloat(gongFenXiangQing.getQsmzjcxs()) + (getFloat(g.getQsmzjcxs()) + getFloat(g.getJbysgf1()));
                    gongFenXiangQing.setQsmzjcxs(String.valueOf(qsmzjcxs));
                    float fsysjcf = getFloat(gongFenXiangQing.getFsysjcf()) + getFloat(g.getFsysjcf());
                    gongFenXiangQing.setFsysjcf(String.valueOf(fsysjcf));
                }
                gongFenXiangQing.setMapMzfsgf(mapMzfsgf);
                map1.put(entry, gongFenXiangQing);
            }
        }
        List<Map<String, String>> list = new ArrayList<>();
        resultValue(list , map1);
        return list;
    }

    private List<Map<String, String>> nameIsNotNull(Date startDate , Date endDate , List<Account> doctorList){
        Map<String, List<GongFenXiangQing>> map = new HashMap<>();
        Map<String, List<GongFenXiangQing>> Jbmap = new HashMap<>();
        Map<String, List<GongFenXiangQing>> Fsmap = new HashMap<>();
        List<PatientLink> patientLinkList = new ArrayList<>();
        List<PatientLink> JBpatientLinkList = new ArrayList<>();
        List<PatientLink> FspatientLinkList = new ArrayList<>();
        for (Account account : doctorList){
            List<PatientLink> p = patientLinkDao.getGongFengTongJi(startDate, endDate, account.getId());
            for (PatientLink pa : p){
                GongFenXiangQing g = new GongFenXiangQing();
                calWorkPoints(g , pa);
                patientLinkList.add(pa);
            }
            List<PatientLink> JBp = patientLinkDao.getJBGongFengTongJi(startDate, endDate, account.getId());
            for (PatientLink pa : JBp){
                GongFenXiangQing g = new GongFenXiangQing();
                calWorkPoints(g , pa);
                JBpatientLinkList.add(pa);
            }
            List<PatientLink> Fsp = patientLinkDao.getFSGongFengTongJi(startDate, endDate, account.getId());
            for (PatientLink pa : Fsp){
                GongFenXiangQing g = new GongFenXiangQing();
                calWorkPoints(g , pa);
                FspatientLinkList.add(pa);
            }
        }

        if (patientLinkList.size() > 0){
            inDateSort(patientLinkList, map);
        }
        if (JBpatientLinkList.size() > 0) {
            inDateSort(JBpatientLinkList, Jbmap);
        }
        if (FspatientLinkList.size() > 0) {
            inDateSort(FspatientLinkList, Fsmap);
        }
        Map<String, GongFenXiangQing> map1 = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (Map.Entry<String, List<GongFenXiangQing>> entry : map.entrySet()) {
            set.add(entry.getKey());
        }
        for (Map.Entry<String, List<GongFenXiangQing>> entry : Jbmap.entrySet()) {
            set.add(entry.getKey());
        }
        for (Map.Entry<String, List<GongFenXiangQing>> entry : Fsmap.entrySet()) {
            set.add(entry.getKey());
        }
        for (String entry : set) {
            GongFenXiangQing gongFenXiangQing = new GongFenXiangQing();
            HashMap<String, Float> mapMzfsgf = new HashMap<>();
            if (map.size() > 0 && map.get(entry) != null) {
                for (GongFenXiangQing g : map.get(entry)) {
                    if (g.getMzfsgf() != null && !g.getMzfsgf().equals("")  && g.getMzfsgf().contains(":")) {
                        String[] str = g.getMzfsgf().split(":");
                        String name = getConfigAnesMethodsGroupCode(str[0]);
                        float value = getFloat(str[1]);
                        if (mapMzfsgf.get(name) == null) {
                            mapMzfsgf.put(name, value);
                        } else {
                            mapMzfsgf.put(name, mapMzfsgf.get(name) + value);
                        }
                    }
                    float zongfen = getFloat(gongFenXiangQing.getZongfen()) +
                            (getFloat(g.getZongfen()) - getFloat(g.getJbysgf1()) - getFloat(g.getJbyszxjmccjjc()) - getFloat(g.getJbysycdmccjjc()) - getFloat(g.getFsysjcf()) - getFloat(g.getFsxqfx()) - getFloat(g.getJbysszxqfx()));
                    gongFenXiangQing.setZongfen(String.valueOf(zongfen));
                    float ycdmccjjc = getFloat(gongFenXiangQing.getYcdmccjjc()) + getFloat(g.getYcdmccjjc());
                    gongFenXiangQing.setYcdmccjjc(String.valueOf(ycdmccjjc));
                    float zxjmccjjc = getFloat(gongFenXiangQing.getZxjmccjjc()) + getFloat(g.getZxjmccjjc());
                    gongFenXiangQing.setZxjmccjjc(String.valueOf(zxjmccjjc));
                    float mzsdjc = getFloat(gongFenXiangQing.getMzsdjc()) + getFloat(g.getMzsdjc());
                    gongFenXiangQing.setMzsdjc(String.valueOf(mzsdjc));
                    float xljc = getFloat(gongFenXiangQing.getXljc()) + getFloat(g.getXljc());
                    gongFenXiangQing.setXljc(String.valueOf(xljc));
                    float szcs = getFloat(gongFenXiangQing.getSzcs()) + getFloat(g.getSzcs());
                    gongFenXiangQing.setSzcs(String.valueOf(szcs));
                    float szxqfx = getFloat(gongFenXiangQing.getSzxqfx()) + getFloat(g.getSzxqfx());
                    gongFenXiangQing.setSzxqfx(String.valueOf(szxqfx));
                    float shzt = getFloat(gongFenXiangQing.getShzt()) + getFloat(g.getShzt());
                    gongFenXiangQing.setShzt(String.valueOf(shzt));
                    float test = getFloat(g.getQsmzjcxs());
                    float qsmzjcxs = getFloat(gongFenXiangQing.getQsmzjcxs()) + getFloat(g.getQsmzjcxs());
                    gongFenXiangQing.setQsmzjcxs(String.valueOf(qsmzjcxs));
                }
            }
            gongFenXiangQing.setMapMzfsgf(mapMzfsgf);

            if (Jbmap.size() > 0 && Jbmap.get(entry) != null) {
                for (GongFenXiangQing g : Jbmap.get(entry)) {
                    float zongfen = getFloat(gongFenXiangQing.getZongfen()) + getFloat(g.getJbysgf1()) + getFloat(g.getJbysycdmccjjc()) + getFloat(g.getJbyszxjmccjjc()) + getFloat(g.getJbysszxqfx());
                    gongFenXiangQing.setZongfen(String.valueOf(zongfen));
                    float ycdmccjjc = getFloat(gongFenXiangQing.getYcdmccjjc()) + getFloat(g.getJbysycdmccjjc());
                    gongFenXiangQing.setYcdmccjjc(String.valueOf(ycdmccjjc));
                    float zxjmccjjc = getFloat(gongFenXiangQing.getZxjmccjjc()) + getFloat(g.getJbyszxjmccjjc());
                    gongFenXiangQing.setZxjmccjjc(String.valueOf(zxjmccjjc));
                    float jbysszxqfx = getFloat(gongFenXiangQing.getSzxqfx()) + getFloat(g.getJbysszxqfx());
                    gongFenXiangQing.setSzxqfx(String.valueOf(jbysszxqfx));
                    float qsmzjcxs = getFloat(gongFenXiangQing.getQsmzjcxs()) + getFloat(g.getJbysgf1());
                    gongFenXiangQing.setQsmzjcxs(String.valueOf(qsmzjcxs));
                }
            }
            if (Fsmap.size() > 0 && Fsmap.get(entry) != null) {
                for (GongFenXiangQing g : Fsmap.get(entry)) {
                    float fsxqfx = getFloat(gongFenXiangQing.getFsxqfx()) + getFloat(g.getFsxqfx());
                    gongFenXiangQing.setFsxqfx(String.valueOf(fsxqfx));
                    float fsysjcf = getFloat(gongFenXiangQing.getFsysjcf()) + getFloat(g.getFsysjcf());
                    gongFenXiangQing.setFsysjcf(String.valueOf(fsysjcf));
                    float zongfen = getFloat(gongFenXiangQing.getZongfen()) + getFloat(g.getFsxqfx()) + getFloat(g.getFsysjcf());
                    gongFenXiangQing.setZongfen(String.valueOf(zongfen));
                }
            }
            map1.put(entry, gongFenXiangQing);
        }
        List<Map<String, String>> list = new ArrayList<>();
        resultValue(list , map1);
        return list;
    }

    //返回 bootstarp table 需要的list
    private void resultValue(List<Map<String, String>> list ,  Map<String, GongFenXiangQing> map1){
        for (Map.Entry<String, GongFenXiangQing> entry : map1.entrySet()) {
            Map<String, String> map2 = new HashMap<>();
            map2.put("date", entry.getKey());
            map2.put("zongfen", entry.getValue().getZongfen());
            map2.put("ycdmccjjc", entry.getValue().getYcdmccjjc());
            map2.put("zxjmccjjc", entry.getValue().getZxjmccjjc());
            map2.put("mzsdjc", entry.getValue().getMzsdjc());
            map2.put("xljc", entry.getValue().getXljc());
            map2.put("szcs", entry.getValue().getSzcs());
            map2.put("szxqfx", entry.getValue().getSzxqfx());
            map2.put("fsxqfx", entry.getValue().getFsxqfx());
            map2.put("shzt", entry.getValue().getShzt());
            map2.put("qsmzjcxs", entry.getValue().getQsmzjcxs());
            map2.put("fsysjcf", entry.getValue().getFsysjcf());
            if (entry.getValue().getMapMzfsgf() != null){
                for (Map.Entry<String, Float> entry1 : entry.getValue().getMapMzfsgf().entrySet()) {
                    String key = entry1.getKey();
                    map2.put(key, String.valueOf(entry1.getValue()));
                }
            }
            list.add(map2);
        }
    }


    private Float getFloat(String str) {
        return Float.parseFloat(str);
    }

    private void inDateSort(List<PatientLink> patientLinkList, Map<String, List<GongFenXiangQing>> map) {
        for (PatientLink p : patientLinkList) {
            if (p.getAnesthesiaRecord().getMzff() == null || p.getAnesthesiaRecord().getMzff().equals("局麻") || p.getAnesthesiaRecord().getMzff().equals("") || p.getAnesthesiaRecord().getZmys() == null || p.getAnesthesiaRecord().getZmys().equals("")){
                continue;
            }
            String time = getDateString(p.getStatus().getOutRoomTime());
            GongFenXiangQing gfxq = p.getTableForRongChangEY().getGongFenXiangQing();
            if (gfxq != null) {
                if (map.get(time) != null) {
                    List<GongFenXiangQing> list = map.get(time);
                    list.add(gfxq);
                    map.put(time, list);
                } else {
                    List<GongFenXiangQing> list = new ArrayList<>();
                    list.add(gfxq);
                    map.put(time, list);
                }
            }
        }
    }

    private String getDateString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        return sdf.format(date);
    }
    /**
     * 返回起始+天数时间　格式：yyyy-MM-dd
     *
     * @return String
     */
    public static Date nextDay(String beginDate, int day) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar c = Calendar.getInstance();
        try {

            c.setTime(sdf.parse(beginDate));
            c.add(Calendar.DATE, day);

        } catch (ParseException e) {

            throw new RuntimeException("日期格式化异常");
        }

        return c.getTime();
    }

    public static Date getStartDateByMonth(String nowdate) throws ParseException{
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateFormatter.parse(nowdate));
        cal.set(Calendar.DAY_OF_MONTH,Calendar.MONTH-1);
        Date date = cal.getTime();
        return date;
    }

    @ResponseBody
    @RequestMapping(value = "index1")
    public Object index1(HttpServletRequest request) throws ParseException {
        Date startDate = new Date();
        Date endDate = new Date();
        String doctorNameID = "";
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        if (basicMessage.get("start") != null && !basicMessage.get("start").equals("")){
            startDate = f.parse(basicMessage.get("start"));
        }
        if (basicMessage.get("end") != null && !basicMessage.get("end").equals("")){
            endDate = nextDay(basicMessage.get("end") , +1);
        }
        if (basicMessage.get("docID") != null && !basicMessage.get("docID").equals("")){
            doctorNameID = basicMessage.get("docID");
        }
        Map<String, Object> result = new HashMap<>();
        result.put("rows",nameIsNotNull1(startDate , endDate , doctorNameID));
        return result;
    }

    private List<Map<String, String>> nameIsNotNull1(Date startDate , Date endDate , String doctorNameID){
        try {
            doctorNameID=new String(doctorNameID.getBytes("iso8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<Account> listAccount = accountDao.findAccountListByNameAll(doctorNameID);
        StringBuilder doctorName = new StringBuilder();
        for (Account account1 : listAccount){
            doctorName.append("," + account1.getId());
        }
        String ifDoc = doctorName.toString();
        Map<String, GongFenXiangQing> map1 = new HashMap<>();
        List<PatientLink> patientLinkList1 = patientLinkDao.getAllGongFengTongJi(startDate, endDate);
        List<PatientLink> patientLinkList = new ArrayList<>();
        for (PatientLink p : patientLinkList1){
            if (p.getAnesthesiaRecord().getMzff() == null || p.getAnesthesiaRecord().getMzff().equals("局麻") || p.getAnesthesiaRecord().getMzff().equals("") || p.getAnesthesiaRecord().getZmys() == null || p.getAnesthesiaRecord().getZmys().equals("")){
                continue;
            }
            if (doctorNameID == null || doctorNameID.equals("")){
                patientLinkList.add(p);
                continue;
            }
            String zmys = p.getAnesthesiaRecord().getZmys() == null ? "" : p.getAnesthesiaRecord().getZmys();
            String jbys = p.getAnesthesiaRecord().getJbys1() == null ? "" : p.getAnesthesiaRecord().getJbys1() ;
            String mzys = p.getPacu().getMzys1() == null ? "" : p.getPacu().getMzys1();
            if (ifDoc.contains(zmys) && !zmys.equals("")){
                patientLinkList.add(p);
                continue;
            }
            if (ifDoc.contains(jbys) && !jbys.equals("")){
                patientLinkList.add(p);
                continue;
            }
            if (ifDoc.contains(mzys) && !mzys.equals("")){
                patientLinkList.add(p);
                continue;
            }

        }
        GongFenXiangQing gf = new GongFenXiangQing();
        for(PatientLink p : patientLinkList){
//            if (p.getAnesthesiaRecord().getMzff() == null || p.getAnesthesiaRecord().getMzff().equals("局麻") || p.getAnesthesiaRecord().getMzff().equals("") || p.getAnesthesiaRecord().getZmys() == null || p.getAnesthesiaRecord().getZmys().equals("")){
//                continue;
//            }
            GongFenXiangQing g = p.getTableForRongChangEY().getGongFenXiangQing();
            HashMap<String, Float> mapMzfsgf = new HashMap<>();
            if (g.getMzfsgf() != null && !g.getMzfsgf().equals("")  && g.getMzfsgf().contains(":")) {
                String[] str = g.getMzfsgf().split(":");
                String name = getConfigAnesMethodsGroupCode(str[0]);
                float value = getFloat(str[1]);
                if (mapMzfsgf.get(name) == null) {
                    mapMzfsgf.put(name, value);
                } else {
                    mapMzfsgf.put(name, mapMzfsgf.get(name) + value);
                }
            }
            g.setMapMzfsgf(mapMzfsgf);
            map1.put(p.getPatient().getBrxm(), g);
            float zongfen = getFloat(gf.getZongfen()) + getFloat(gf.getZongfen());
            gf.setZongfen(String.valueOf(zongfen));
        }
//        List<PatientLink> JBpatientLinkList = patientLinkDao.getJBGongFengTongJi(startDate, endDate, doctorNameID);
//        List<PatientLink> FspatientLinkList = patientLinkDao.getFSGongFengTongJi(startDate, endDate, doctorNameID);
        List<Map<String, String>> list = new ArrayList<>();
        resultValue(list , map1);
        return list;
    }

    @RequestMapping(value = "gongFenTongJi1", method = RequestMethod.GET)
    public Object gongFenTongJi1(HttpServletRequest request) {
        basicMessage.clear();
        Map<String, Object> params = FrontHelper.transfParams(request);
        if (params.get("start") != null && !params.get("start").toString().equals("")){
            basicMessage.put("start", params.get("start").toString());
        }
        if (params.get("end") != null && !params.get("end").toString().equals("")){
            basicMessage.put("end", params.get("end").toString());
        }
        if (params.get("docID") != null && !params.get("docID").toString().equals("")){
            basicMessage.put("docID", params.get("docID").toString());
        }
        return "gongfentongji/gongFenTongJi1";
    }

    private static float jbysgf = 0;
    private static float zmysjhf = 0;
    private static long oneHour = 1000 * 60 * 60;
    private static long oneMinute = 1000 * 60;
    private static SimpleDateFormat s = new SimpleDateFormat("HH:mm:ss");
    private PatientEventsDao patientEventsDao = SpringUtils.getBean(PatientEventsDao.class);
    private static List<String> eventCode = new ArrayList<>();

    public void calWorkPoints(GongFenXiangQing gongFenXiangQing, PatientLink patientLink) {
        List<ConfigAnesMethods> drugMethodsPojo = configAnesMethodsDao.getIsTrue();
        String status = patientLink.getApplication().getDetailstatus();
        if (status.equals(Constants.OR_STATUS_FLAG_OUT_ROOM) || status.equals(Constants.OR_STATUS_FLAG_IN_PCU) || status.equals(Constants.OR_STATUS_FLAG_OUT_PCU)) {
            for (ConfigAnesMethods configAnesMethods : drugMethodsPojo) {
                if (configAnesMethods.getName().equals(patientLink.getAnesthesiaRecord().getMzff())) {
                    float gfc = configAnesMethods.getGfc();
                    float gfxs = configAnesMethods.getGfxs();
                    String mzfsgf = configAnesMethods.getCode() + ":" + gfc;
                    gongFenXiangQing.setMzfsgf(mzfsgf);
                    List<Integer> zmjbsjList = getZmjbsjList(patientLink);
                    if (zmjbsjList.size() > 0) {
                        if (zmjbsjList.size() > 1) {
                            int zmsj = zmjbsjList.get(0);
                            int jbsj = zmjbsjList.get(1);
                            jbysgf = jbsj * gfxs;
                            zmysjhf = zmsj * gfxs;
                            gongFenXiangQing.setQsmzjcxs(Float.toString(zmysjhf));
                            gongFenXiangQing.setJbysgf1(Float.toString(jbysgf));
                        } else {
                            int zmsj = zmjbsjList.get(0);

                            gongFenXiangQing.setQsmzjcxs(Float.toString(zmsj * gfxs));
                        }
                        if (patientLink.getStatus().getInPacuTime() != null) {
                            gongFenXiangQing.setFsysjcf(Float.toString(gfxs));
                        }
//                        int fssjList = getfssjList(patientLink);
//                        if (fssjList != -100) {
//                            int fssj =fssjList;
//                            gongFenXiangQing.setFsysjcf(Float.toString(fssj * gfxs));
//                        }
                    }
                    break;
                }
            }
            Date jbysjbsj = patientLink.getAnesthesiaRecord().getJbys1StartTime();

            if (patientLink.getAnesthesiaRecord().getDmcc()) {
                if (jbysjbsj != null && patientLink.getAnesthesiaRecord().getDmcc_sj() != null && contrastTime(s.format(jbysjbsj), patientLink.getAnesthesiaRecord().getDmcc_sj())) {
                    gongFenXiangQing.setJbysycdmccjjc("3");
                    gongFenXiangQing.setYcdmccjjc("0");
                } else {
                    gongFenXiangQing.setYcdmccjjc("3");
                    gongFenXiangQing.setJbysycdmccjjc("0");
                }
            }
            if (patientLink.getAnesthesiaRecord().getZxjmcc()) {
                if (jbysjbsj != null && contrastTime(s.format(jbysjbsj), patientLink.getAnesthesiaRecord().getZxjmcc_sj())) {
                    gongFenXiangQing.setZxjmccjjc("0");
                    gongFenXiangQing.setJbyszxjmccjjc("3");
                } else {
                    gongFenXiangQing.setZxjmccjjc("3");
                    gongFenXiangQing.setJbyszxjmccjjc("0");
                }
            }

            if (patientLink.getAnesthesiaRecord().getTeg()) {
                gongFenXiangQing.setXljc("1");
            }
            if (patientLink.getAnesthesiaRecord().getBis()) {
                gongFenXiangQing.setMzsdjc("1");
            }
            if (patientLink.getStatus().getOutPacuTime() != null) {
                if (patientLink.getPacu().isXqfx()) {
                    if (patientLink.getPacu().getXqfxnr() != null && !patientLink.getPacu().getXqfxnr().equals("")) {
                        float xqfx = Float.parseFloat(patientLink.getPacu().getXqfxnr()) / 2;
                        gongFenXiangQing.setFsxqfx(String.valueOf(xqfx));
                    } else {
                        gongFenXiangQing.setFsxqfx("0");
                    }
                }
            }
//            if (patientLink.getAnesthesiaRecord().getXqfx()) {
//                List<PatientEvents> events = patientEventsDao.getPatientEvents8PatientId(patientLink.getId());
//                float szxqfx = 0;
//                float jbysszxqfx = 0;
//                for (PatientEvents patientEvents : events){
//                    if (eventCode.contains(patientEvents.getCode())) {
//                        if (contrastTime(s.format(jbysjbsj),s.format(patientEvents.getEndTime()))){
//                            jbysszxqfx+=0.5;
//                        }else{
//                            szxqfx+=0.5;
//                        }
//                    }
//                }
//                gongFenXiangQing.setSzxqfx(String.valueOf(szxqfx));
//                gongFenXiangQing.setJbysszxqfx(String.valueOf(jbysszxqfx));
//            }

            if (patientLink.getAnesthesiaRecord().getXqfx()) {
                if (jbysjbsj != null){
                    List<PatientEvents> events = patientEventsDao.getPatientEvents8PatientId(patientLink.getId());
                    float szxqfx = 0;
                    float jbysszxqfx = 0;
                    for (PatientEvents patientEvents : events){
                        if (eventCode.contains(patientEvents.getCode())) {
                            if (contrastTime(s.format(jbysjbsj),s.format(patientEvents.getEndTime()))){
                                jbysszxqfx+=0.5;
                            }else{
                                szxqfx+=0.5;
                            }
                        }
                    }
                    gongFenXiangQing.setSzxqfx(String.valueOf(szxqfx));
                    gongFenXiangQing.setJbysszxqfx(String.valueOf(jbysszxqfx));
                }else {
                    if (patientLink.getAnesthesiaRecord().getXqfxnr() != null && !patientLink.getAnesthesiaRecord().getXqfxnr().equals("")) {
                        float xqfx = 0;

                            List<PatientEvents> events = patientEventsDao.getPatientEvents8PatientId(patientLink.getId());
                            for (PatientEvents patientEvents : events){
                                if (eventCode.contains(patientEvents.getCode())) {
                                    xqfx += 0.5;
                                }
                            }
                        gongFenXiangQing.setSzxqfx(String.valueOf(xqfx));
                    } else {
                        gongFenXiangQing.setSzxqfx("0");
                    }
                }
            }
            if (patientLink.getAnesthesiaRecord().getPCEA() || patientLink.getAnesthesiaRecord().getPCIA() || patientLink.getAnesthesiaRecord().getPCNA()) {
                gongFenXiangQing.setShzt("1");
            }

        }

        String[] str = gongFenXiangQing.getMzfsgf().split(":");
        float gfc = Float.valueOf(str.length > 1 ? str[1] : "0");
        float total =
                Float.valueOf(gfc) +
                        Float.valueOf(gongFenXiangQing.getQsmzjcxs()) +
                        Float.valueOf(gongFenXiangQing.getJbysgf1()) +
                        Float.valueOf(gongFenXiangQing.getFsysjcf()) +
                        Float.valueOf(gongFenXiangQing.getYcdmccjjc()) +
                        Float.valueOf(gongFenXiangQing.getJbysycdmccjjc()) +
                        Float.valueOf(gongFenXiangQing.getZxjmccjjc()) +
                        Float.valueOf(gongFenXiangQing.getJbyszxjmccjjc()) +
                        Float.valueOf(gongFenXiangQing.getXljc()) +
                        Float.valueOf(gongFenXiangQing.getMzsdjc()) +
                        Float.valueOf(gongFenXiangQing.getFsxqfx()) +
                        Float.valueOf(gongFenXiangQing.getSzxqfx()) +
                        Float.valueOf(gongFenXiangQing.getJbysszxqfx()) +
                        Float.valueOf(gongFenXiangQing.getShzt());
        gongFenXiangQing.setZongfen(String.valueOf(total));
        patientLink.getTableForRongChangEY().setGongFenXiangQing(gongFenXiangQing);
    }

    private static List<Integer> getZmjbsjList(PatientLink patientLink) {
        List<Integer> zmjbsj = new ArrayList<Integer>();
        if (patientLink.getStatus().getInRoomTime() != null && patientLink.getStatus().getOutRoomTime() != null) {
            Date startTime = patientLink.getStatus().getInRoomTime();
            Date endTime = patientLink.getStatus().getOutRoomTime();
            Date jbStartTime = patientLink.getAnesthesiaRecord().getJbys1StartTime();
            if (jbStartTime != null) {
                long zmysTime = jbStartTime.getTime() - startTime.getTime();
                long jbysTime = endTime.getTime() - jbStartTime.getTime();
                long zmhour = zmysTime / oneHour;
                zmhour = zmysTime / oneMinute % 60 >= 30 ? zmhour + 1 : zmhour;
                long jbhour = jbysTime / oneHour;
                jbhour = jbysTime / oneMinute % 60 >= 30 ? jbhour + 1 : jbhour;
                zmjbsj.add((int) zmhour);
                zmjbsj.add((int) jbhour);
                return zmjbsj;
            } else {
                long time = endTime.getTime() - startTime.getTime();
                long hour = time / oneHour;
                hour = time / oneMinute % 60 >= 30 ? hour + 1 : hour;
                //long min=time-hour*halfHour*2;
                zmjbsj.add((int) hour);
                return zmjbsj;
            }
        }
        return zmjbsj;
    }

    /**
     * 对比字符串时间
     *
     * @param time1 接班医生接班时间
     * @param time2 穿刺时间
     * @return
     */
    private static boolean contrastTime(String time1, String time2) {
        int res = time1.compareTo(time2);
        if (res == 0) {
            return true;
        } else if (res < 0) {
            return true;
        }
        return false;
    }
}
