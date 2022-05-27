//package cn.medigical.publish.interfaces.his.hisDeChang;
//
//import cn.medigical.publish.dao.impl.PatientLinkDao;
//import cn.medigical.publish.pojo.lis.LisReport;
//import cn.medigical.publish.pojo.patientLink.PatientLink;
//import cn.medigical.publish.utils.SpringUtils;
//import cn.medigical.publish.interfaces.his.hisDeChang.sdk.*;
//
//import java.math.BigDecimal;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class HisLinkDeChang {
//    private static HisLinkDeChang instance;
//    static PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);
//
//    public static HisLinkDeChang getInstance() {
//        if (instance == null) {
//            instance = new HisLinkDeChang();
//        }
//        return instance;
//    }
//
//    public void getOperationFromHis() {
//
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date dateNow = new Date();
//        Date dateFrom = new Date(dateNow.getTime() - 604800000L);
//        String sevenDaysAgo = sdf.format(dateFrom);
//        String operationString = ServiceMessage.operationString;
//        String message = operationString.replace("dateFrom", sevenDaysAgo);
//        SDKHelper.getInstance().SendMsg(ServiceMessage.ANES_OPERATION, message);
//    }
//
//    public void getAccountFromHis() {
//        SDKHelper.getInstance().SendMsg(ServiceMessage.ANES_ACCOUNT, ServiceMessage.accountString);
//    }
//
//    public void getDepartmentFromHis() {
//        SDKHelper.getInstance().SendMsg(ServiceMessage.ANES_DEPARTMENT, ServiceMessage.departmentString);
//    }
//
//    public void getLisReportFromHis( String patId) {
//        String lisReportString = ServiceMessage.lisReportString.replace("ZHUYUANHAO", patId);
//        SDKHelper.getInstance().SendMsg(ServiceMessage.ANES_LIS_REPORT, lisReportString);
//    }
//
//    public Map<String, LisReport> getReportList(List<LisReport> list) {
//        Map<String, LisReport> map = new HashMap();
//        for (LisReport lisReport : list) {
//            LisReport lisReportold = map.get(lisReport.getREPORTID());
//
//            if (null == lisReportold) {  //新增exe
//                map.put(lisReport.getREPORTID(), lisReport);
//            } else {
//                Date reportTime = lisReport.getAUTHTIME();
//                Date reportTimeold = lisReportold.getAUTHTIME();
//                if (reportTimeold.getTime() > reportTime.getTime()) {
//                    System.out.println("dt1 在dt2前");
//                    map.put(lisReportold.getREPORTID(), lisReportold);
//                } else {
//                    map.put(lisReport.getREPORTID(), lisReport);
//                }
//                if (map.size() > 4) {
//                    return map;
//                }
//            }
//        }
//
////        LisReport lisReport = null;
////        for (Map.Entry<String, LisReport> entry : map.entrySet()) {
//////        System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
////            lisReport = entry.getValue();
////        }
//        return map;
//    }
//
//    public String keepDecimal(String s) {
//
//        String rs = null;
//        try {
//            int scale = 2;//设置位数
//            int roundingMode = 4;//表示四舍五入，可以选择其他舍值方式，例如去尾，等等.
//            BigDecimal bd = new BigDecimal(Double.parseDouble(s));
//            bd = bd.setScale(scale, roundingMode);
//            float ft = bd.floatValue();
//            rs = String.valueOf(ft);
//            return rs;
//        } catch (NumberFormatException e) {
//            //e.printStackTrace();
//            return rs;
//        }
//    }
//}
