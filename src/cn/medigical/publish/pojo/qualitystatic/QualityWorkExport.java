package cn.medigical.publish.pojo.qualitystatic;

import cn.medigical.publish.controller.ZhikongController;
import cn.medigical.publish.dao.impl.AccountCache;
import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigAnesMethodsDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigAnesMethodsGroupDao;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.dictionary.ConfigAnesMethods;
import cn.medigical.publish.pojo.dictionary.ConfigAnesMethodsGroup;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.pojo.quality.QualityPojo;
import cn.medigical.publish.pojo.quality.rongchang.ZhiKongXinXi;
import cn.medigical.publish.utils.ExportExcel;
import cn.medigical.publish.utils.MyDateFormat;
import cn.medigical.publish.utils.MyUtility;
import cn.medigical.publish.utils.SpringUtils;
import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

;


/**
 * Created by 博创医疗 on 2016/11/22.
 * Copyright by 博创医疗
 */
public class QualityWorkExport {

    PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);

    AccountDao accountDao = (AccountDao) SpringUtils.getBean(AccountDao.class);
    private static QualityWorkExport instance = null;
    String[] header = new String[]{"日期", "姓名", "性别", "年龄", "科别+床号", "住院号", "手术名称", "ASA分级",
                                    "急诊", "特殊情况", "麻醉医生", "查对"};
    String[] header1 = new String[]{"麻醉方式", "血管穿刺", "镇痛泵", "病人去向", "麻醉质控","入室时间","出室时间","入室时长（分）","手术开始","手术结束","手术时长(分)"};
    String[] headerMazuiMethod = new String[]{"椎管内麻醉", "复合麻醉", "神经阻滞麻醉", "插管全麻", "非插管全麻",
                                    "局麻", "监护麻醉"};
    String[] headerXueGuanChuanCi = new String[]{"静\n脉", "动\n脉"};
    String[] headerZhenTongBeng = new String[]{"静\n脉", "硬\n膜\n外"};
    String[] headerQuXiang = new String[]{"PACU", "病\n房", "ICU"};
    String[] headerZhiKong = new String[]{"重大\n手术","非计划\n二次手\n术", "非计划\n二次插\n管", "非计划\n改变麻\n醉方式",
                                    "非计划\n二次麻\n醉", "术中输\n血、输\n液反应", "术后意\n识障碍",
                                    "麻醉期\n间氧饱\n和度严\n重降低", "误吸所\n致呼吸\n道梗阻", "术中、\n术后心\n肺复苏", "备注"};

    private Map<Integer, Map<Integer, String>> rowMapColData = new HashMap<>();
    private Map<String, String> methodGroup = new HashMap<>();
    ConfigAnesMethodsDao configAnesMethodsDao = SpringUtils.getBean(ConfigAnesMethodsDao.class);
    ConfigAnesMethodsGroupDao configAnesMethodsGroupDao = SpringUtils.getBean(ConfigAnesMethodsGroupDao.class);

    public static QualityWorkExport getInstance() {
        if (null == instance) {
            instance = new QualityWorkExport();
        }
        return instance;
    }

    private void groupMethod(){
        methodGroup.clear();
        List<ConfigAnesMethods> list = configAnesMethodsDao.getIsTrue();
        List<ConfigAnesMethodsGroup> listGroup = configAnesMethodsGroupDao.getDateIsFalse();
//        methodGroup
        Map<String, String> map = new HashMap<>();
        for (ConfigAnesMethodsGroup c : listGroup){
            map.put(c.getCode(), c.getName());
        }
        for (ConfigAnesMethods c : list){
            String groupName = map.get(c.getGroupCode());
            methodGroup.put(c.getName(), groupName);
        }
    }

    private void calData(Date startTime, Date endTime, String accountName) throws Exception{
        groupMethod();
        rowMapColData.clear();
        if (null == startTime || null == endTime) return;
        //List<PatientLink> patientLinks = SpringCache.getInstance().getBean(PatientLinkDao.class).
              //  getFinishOperByTime(startTime, endTime);
        List<PatientLink> patientLinks=patientLinkDao.getFinishOperByTime2(startTime, endTime);
        List<Account> selAccountList = accountDao.findAccountListByName(accountName);//SpringCache.getInstance().getBean(AccountDao.class).findAccountListByName(accountName);
        List<String> accountIdList=new ArrayList<>();

        if (null!=selAccountList && selAccountList.size()>0){
            for (int i = 0; i <selAccountList.size() ; i++) {
                accountIdList.add(selAccountList.get(i).getId());
            }
        }

        List<PatientLink> patientLinkList = new ArrayList<>();
        if(null !=accountIdList && accountIdList.size()>0){
            for (PatientLink patientLink : patientLinks) {
                for (int j = 0; j <accountIdList.size() ; j++) {
                    if (ZhikongController.isOperOfAllDoctor(patientLink,accountIdList.get(j))){
                        patientLinkList.add(patientLink);
                    }
                }
            }
        }else {
            patientLinkList.addAll(patientLinks);
        }
        if(accountName != null && !accountName.equals("")){
            for(PatientLink oper: patientLinks){
                if (accountName.equals(oper.getPatient().getBrxm())){
                    patientLinkList.add(oper);
                }
            }
        }

        if (null == patientLinkList || patientLinkList.size() == 0) return;
        Collections.sort(patientLinkList, new Comparator<PatientLink>() {
            @Override
            public int compare(PatientLink o1, PatientLink o2) {
                return o1.getStatus().getInRoomTime().compareTo(o2.getStatus().getInRoomTime());
            }
        });
        int row = 0;
        for (int i = 0; i < patientLinkList.size(); i++) {
//            System.out.println("现在是第" + i);
            PatientLink patientLink = patientLinkList.get(i);
            String patName = patientLink.getPatient().getBrxm() == null ? "" : patientLink.getPatient().getBrxm();
            if (patName.length() == 0) continue;

            Map<Integer, String> colMapData = new HashMap<>();
            Date inRoomTime = patientLink.getStatus().getInRoomTime();
            String inRoomTimeStr = null == inRoomTime ? "" : MyDateFormat.DATE_FORMAT_YMD.format(inRoomTime);
            colMapData.put(0, inRoomTimeStr);

            //病人姓名
//            String patName = patientLink.getPatient().getName() == null ? "" : patientLink.getPatient().getName();
            colMapData.put(1, patName);

            //病人性别
            String patSex = patientLink.getPatient().getXb() == null ? "" : patientLink.getPatient().getXb();
            colMapData.put(2, patSex);

            //病人年龄
            String age = MyUtility.getAge(patientLink.getPatient().getDob(), patientLink.getApplication().getSssqsj());
            if (age.length() == 0) age = patientLink.getPatient().getNl();
            if (null == age) age = "";
            colMapData.put(3, age);

            //床号
            String deptName = patientLink.getPatient().getKsmc() == null ? "" : patientLink.getPatient().getKsmc();
            String bed = patientLink.getPatient().getZych() == null ? "" : patientLink.getPatient().getZych();
            colMapData.put(4, deptName+"-"+bed);

            //住院号
            String zyh = patientLink.getPatient().getZyh() == null ? "" : patientLink.getPatient().getZyh();
            colMapData.put(5, zyh);

            //拟施手术
            String operName = getYiShiOper(patientLink);
            if (operName.length() == 0) operName = getNiShiOper(patientLink);
            colMapData.put(6, operName);

            //ASA分级
            String asaLevel = patientLink.getAnesthesiaRecord().getAsa().getLevel() == null ? "" : patientLink.getAnesthesiaRecord().getAsa().getLevel();
            colMapData.put(7, asaLevel);

            //急诊
            if (patientLink.getAnesthesiaRecord().getAsa().getJz()) {
                colMapData.put(8, "√");
            }

            //麻醉方式
            String complicatedMethod = patientLink.getAnesthesiaRecord().getMzff();
            String mzff = methodGroup.get(complicatedMethod) == null ? "" : methodGroup.get(complicatedMethod);
            if (mzff.contains("椎管内麻醉")) {
                colMapData.put(9, "1");
            }
            if (mzff.contains("复合麻醉")) {
                colMapData.put(10, "1");
            }
            if (mzff.contains("神经阻滞麻醉")) {
                colMapData.put(11, "1");
            }
            if (mzff.contains("插管全麻")) {
                colMapData.put(12, "1");
            }
            if (mzff.contains("非插管全麻")) {
                colMapData.put(13, "1");
            }
            if (mzff.contains("局麻")) {
                colMapData.put(14, "1");
            }
            if (mzff.contains("监护麻醉")) {
                colMapData.put(15, "1");
            }


            //血管穿刺
            if (patientLink.getAnesthesiaRecord().getZxjmcc()) {
                colMapData.put(16, "1");
            }
            if (patientLink.getAnesthesiaRecord().getDmcc()) {
                colMapData.put(17, "1");
            }
            //镇痛泵
            if (patientLink.getAnesthesiaRecord().getPCIA()) {
                colMapData.put(18, "√");
            }
            if (patientLink.getAnesthesiaRecord().getPCEA()) {
                colMapData.put(19, "√");
            }

            colMapData.put(20, "");
            //病人去向
            String quXiang = patientLink.getAnesthesiaRecord().getBrqw();
            if (null != quXiang) {
                if (quXiang.equals("复苏室") || quXiang.equals("PACU")) {
                    colMapData.put(21, "√");
                } else if (quXiang.equals("病房")) {
                    colMapData.put(22, "√");
                } else if (quXiang.equals("ICU")) {
                    colMapData.put(23, "√");
                }
            }
            ZhiKongXinXi qualityPojo = patientLink.getTableForRongChangEY().getZhiKongXinXi();
            //质控指标
            if (qualityPojo.getZdss()) { //重大手术
                colMapData.put(24, "√");
            }
            if (qualityPojo.getFjhecss()) {//非计划二次手术
                colMapData.put(25, "√");
            }
            if (qualityPojo.getFjhecqgbg()) {//非计划二次插管
                colMapData.put(26, "√");
            }
            if (qualityPojo.getFjhgbmzfs()) {//非计划改变麻醉方式
                colMapData.put(27, "√");
            }
            if (qualityPojo.getFjhecmz()) {//非计划二次麻醉
                colMapData.put(28, "√");
            }
            if (qualityPojo.getSzsxsyfy()) {//术中输血、输液反应
                colMapData.put(29, "√");
            }
            if (qualityPojo.getWyqysza()) {//意识障碍
                colMapData.put(30, "√");
            }
            if (qualityPojo.getMzqjybhdyzjd()) {
                colMapData.put(31, "√");
            }
            if (qualityPojo.getYwywxyfhxdgz()) {
                colMapData.put(32, "√");
            }
            if (qualityPojo.getXffscg()) {
                colMapData.put(33, "√");
            }else if (qualityPojo.getXffsbcg()){
                colMapData.put(33, "√");
            }

            colMapData.put(34, "");//备注

            //麻醉医生
            String mazuiDoc = patientLink.getAnesthesiaRecord().getZmys() == null ? "" : AccountCache.getInstance().getAccountNameById(patientLink.getAnesthesiaRecord().getZmys());//AccountCache.getInstance()
            String mazuiDoc2 = patientLink.getAnesthesiaRecord().getFmys1() == null ? "" : AccountCache.getInstance().getAccountNameById(patientLink.getAnesthesiaRecord().getFmys1());
            String mazuiDoc3 = patientLink.getAnesthesiaRecord().getFmys2() == null ? "" : AccountCache.getInstance().getAccountNameById(patientLink.getAnesthesiaRecord().getFmys2());
            mazuiDoc = mazuiDoc + " " + mazuiDoc2 + " " + mazuiDoc3;
            colMapData.put(35, mazuiDoc.trim());

            colMapData.put(36, "");//查对

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

//            //入手术室时间
            if(patientLink.getStatus().getInRoomTime() == null){
                colMapData.put(37,"无");
            }else {
                colMapData.put(37, simpleDateFormat.format(patientLink.getStatus().getInRoomTime()));
            }

            //出手术室时间
            if(patientLink.getStatus().getOutRoomTime() == null){
                colMapData.put(38,"无");
            }else{

                colMapData.put(38,simpleDateFormat.format(patientLink.getStatus().getOutRoomTime()) );
            }

            //入室时长
            long totalTime;
            if(patientLink.getStatus().getOutRoomTime() != null && patientLink.getStatus().getInRoomTime() != null){
                totalTime =(patientLink.getStatus().getOutRoomTime().getTime()- patientLink.getStatus().getInRoomTime().getTime())/1000/60;//分钟
            }else{
                totalTime = 0l;
            }
            colMapData.put(39, String.valueOf(totalTime));

            //手术开始时间
            if(patientLink.getStatus().getOperStartTime() == null){
                colMapData.put(40,"无");
            }else {
                colMapData.put(40, simpleDateFormat.format(patientLink.getStatus().getOperStartTime()));
            }
            //手术结束时间
            if(patientLink.getStatus().getOperEndTime() == null){
                colMapData.put(41,"无");
            }else{
                colMapData.put(41,simpleDateFormat.format(patientLink.getStatus().getOperEndTime()) );
            }
//            手术时长
            long operationTime = patientLink.getStatus().getOperSpanTime();//分钟
//            long minites = totalTime % 60;
//            long hour = totalTime / 60;
//            String operTime = hour >0 ? hour + "小时" + minites + "分钟": minites+"分钟";
            colMapData.put(42, String.valueOf(operationTime));

            rowMapColData.put(row, colMapData);
            row++;
        }
    }

    public String getYiShiOper(PatientLink patientLink) {
        StringBuilder nishiOper = new StringBuilder();
        if(null!= patientLink.getAnesthesiaRecord().getYsss1()&&!"".equals(patientLink.getAnesthesiaRecord().getYsss1())&&
                null!= patientLink.getAnesthesiaRecord().getYsss2()&&!"".equals(patientLink.getAnesthesiaRecord().getYsss2()))
            nishiOper.append("①"+ patientLink.getAnesthesiaRecord().getYsss1());
        else if(null!= patientLink.getAnesthesiaRecord().getYsss1()&&!"".equals(patientLink.getAnesthesiaRecord().getYsss1())&&
                null== patientLink.getAnesthesiaRecord().getYsss2()||"".equals(patientLink.getAnesthesiaRecord().getYsss2())){
            nishiOper.append(patientLink.getAnesthesiaRecord().getYsss1());
        }
        else return "";
        if(null!= patientLink.getAnesthesiaRecord().getYsss2()&&!"".equals(patientLink.getAnesthesiaRecord().getYsss2()))
            nishiOper.append(" ②" + patientLink.getAnesthesiaRecord().getYsss2());
        if(null!= patientLink.getAnesthesiaRecord().getYsss3()&&!"".equals(patientLink.getAnesthesiaRecord().getYsss3()))
            nishiOper.append(" ③" + patientLink.getAnesthesiaRecord().getYsss3());
        if(null!= patientLink.getAnesthesiaRecord().getYsss4()&&!"".equals(patientLink.getAnesthesiaRecord().getYsss4()))
            nishiOper.append(" ④" + patientLink.getAnesthesiaRecord().getYsss4());
        return nishiOper.toString();
    }

    public String getNiShiOper(PatientLink patientLink) {
        StringBuilder nishiOper = new StringBuilder();
        if(null!= patientLink.getAnesthesiaRecord().getNsss1()&&!"".equals(patientLink.getAnesthesiaRecord().getNsss1())&&
                null!= patientLink.getAnesthesiaRecord().getNsss2()&&!"".equals(patientLink.getAnesthesiaRecord().getNsss2()))
            nishiOper.append("①"+ patientLink.getAnesthesiaRecord().getNsss1());
        else if(null!= patientLink.getAnesthesiaRecord().getNsss1()&&!"".equals(patientLink.getAnesthesiaRecord().getNsss1())&&
                null== patientLink.getAnesthesiaRecord().getNsss2()||"".equals(patientLink.getAnesthesiaRecord().getNsss2())){
            nishiOper.append(patientLink.getAnesthesiaRecord().getNsss1());
        }
        else return "";
        if(null!= patientLink.getAnesthesiaRecord().getNsss2()&&!"".equals(patientLink.getAnesthesiaRecord().getNsss2()))
            nishiOper.append(" ②" + patientLink.getAnesthesiaRecord().getNsss2());
        if(null!= patientLink.getAnesthesiaRecord().getNsss3()&&!"".equals(patientLink.getAnesthesiaRecord().getNsss3()))
            nishiOper.append(" ③" + patientLink.getAnesthesiaRecord().getNsss3());
        if(null!= patientLink.getAnesthesiaRecord().getNsss4()&&!"".equals(patientLink.getAnesthesiaRecord().getNsss4()))
            nishiOper.append(" ④" + patientLink.getAnesthesiaRecord().getNsss4());
        return nishiOper.toString();
    }

    public void exportTongLiangExcel(String fileName, Date startTime, Date endTime, String accountName) {
        String finalFileName = ExportExcel.getInstance().getFileName(fileName);
        try {
            WritableWorkbook book = Workbook.createWorkbook(new File(finalFileName));
            WritableSheet sheet = book.createSheet("第一页", 0);
            //单元格样式
            WritableFont wf_title = new WritableFont(WritableFont.ARIAL, 22,
                    WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
                    jxl.format.Colour.BLACK);
            WritableCellFormat wcf_title = new WritableCellFormat(wf_title); // 单元格定义
            wcf_title.setAlignment(jxl.format.Alignment.CENTRE); // 设置对齐方式
            wcf_title.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);

            WritableFont fontHeader = new WritableFont(WritableFont.createFont("宋体"), 10, WritableFont.NO_BOLD);
            WritableCellFormat wcf_header = new WritableCellFormat(fontHeader); // 单元格定义
            wcf_header.setAlignment(jxl.format.Alignment.CENTRE); // 设置对齐方式
            wcf_header.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
            wcf_header.setWrap(true);

            WritableFont fontCell = new WritableFont(WritableFont.createFont("宋体"), 11, WritableFont.NO_BOLD);
            WritableCellFormat wcf_cell = new WritableCellFormat(fontCell); // 单元格定义
            wcf_cell.setAlignment(jxl.format.Alignment.CENTRE); // 设置对齐方式
            wcf_cell.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
            wcf_cell.setWrap(true);

            //设置行高列宽
            sheet.setRowView(0, 1000);
            sheet.setRowView(1, 400);
            sheet.setRowView(2, 1200);

            sheet.setColumnView(0, 5);

            Calendar calendar = Calendar.getInstance();
            Label title = new Label(0, 0, String.valueOf(calendar.get(Calendar.YEAR)) + "年麻醉工作量统计", wcf_title);
            sheet.addCell(title);
            sheet.mergeCells(0, 0, 43, 0);

            for (int i = 0; i < 9; i++) {
                int col = i+1;
                Label headerLbl = new Label(col, 1, header[i], wcf_header);
                sheet.addCell(headerLbl);
                sheet.mergeCells(col, 1, col, 2);
            }
            sheet.setColumnView(1, 13);
            sheet.setColumnView(2, 9);
            sheet.setColumnView(3, 5);
            sheet.setColumnView(4, 6);
            sheet.setColumnView(5, 14);
            sheet.setColumnView(6, 10);
            sheet.setColumnView(7, 32);
            sheet.setColumnView(8, 5);
            sheet.setColumnView(9, 5);

            Label mazuiFangShi = new Label(10, 1, header1[0], wcf_header);
            sheet.addCell(mazuiFangShi);
            sheet.mergeCells(10, 1, 16, 1);
            for (int i = 0; i < headerMazuiMethod.length; i++) {
                int col = i+10;
                Label headerLbl = new Label(col, 2, headerMazuiMethod[i], wcf_header);
                sheet.addCell(headerLbl);
                sheet.setColumnView(col, 5);
            }

            Label xueGuanChuanCi = new Label(17, 1, header1[1], wcf_header);
            sheet.addCell(xueGuanChuanCi);
            sheet.mergeCells(17, 1, 18, 1);
            for (int i = 0; i < headerXueGuanChuanCi.length; i++) {
                int col = i+17;
                Label headerLbl = new Label(col, 2, headerXueGuanChuanCi[i], wcf_header);
                sheet.addCell(headerLbl);
                sheet.setColumnView(col, 5);
            }

            Label zhenTongBeng = new Label(19, 1, header1[2], wcf_header);
            sheet.addCell(zhenTongBeng);
            sheet.mergeCells(19, 1, 20, 1);
            for (int i = 0; i < headerZhenTongBeng.length; i++) {
                int col = i+19;
                Label headerLbl = new Label(col, 2, headerZhenTongBeng[i], wcf_header);
                sheet.addCell(headerLbl);
                sheet.setColumnView(col, 5);
            }

            Label teShuQKLbl = new Label(21, 1, header[9], wcf_header);
            sheet.addCell(teShuQKLbl);
            sheet.setColumnView(21, 10);
            sheet.mergeCells(21, 1, 21, 2);

            Label quXiang = new Label(22, 1, header1[3], wcf_header);
            sheet.addCell(quXiang);
            sheet.mergeCells(22, 1, 24, 1);
            for (int i = 0; i < headerQuXiang.length; i++) {
                int col = i+22;
                Label headerLbl = new Label(col, 2, headerQuXiang[i], wcf_header);
                sheet.addCell(headerLbl);
                sheet.setColumnView(col, 5);
            }

            Label zhiKong = new Label(25, 1, header1[4], wcf_header);
            sheet.addCell(zhiKong);
            sheet.mergeCells(25, 1, 34, 1);
            for (int i = 0; i < headerZhiKong.length; i++) {
                int col = i+25;
                Label headerLbl = new Label(col, 2, headerZhiKong[i], wcf_header);
                sheet.addCell(headerLbl);
                sheet.setColumnView(col, 7);
            }

            Label mazuiDocLbl = new Label(36, 1, header[10], wcf_header);
            sheet.addCell(mazuiDocLbl);
            sheet.setColumnView(36, 10);
            sheet.mergeCells(36, 1, 36, 2);

            Label checkLbl = new Label(37, 1, header[11], wcf_header);
            sheet.addCell(checkLbl);
            sheet.setColumnView(37, 5);
            sheet.mergeCells(37, 1, 37, 2);

            Label ruShouShuShiJian = new Label(38, 1, header1[5], wcf_header);
            sheet.addCell(ruShouShuShiJian);
            sheet.setColumnView(38, 20);
            sheet.mergeCells(38, 1, 38, 2);

            Label chuShouShuShiJian = new Label(39, 1, header1[6], wcf_header);
            sheet.addCell(chuShouShuShiJian);
            sheet.setColumnView(39, 20);
            sheet.mergeCells(39, 1, 39, 2);

            Label ruShishiChang = new Label(40, 1, header1[7], wcf_header);
            sheet.addCell(ruShishiChang);
            sheet.setColumnView(40, 20);
            sheet.mergeCells(40, 1, 40, 2);


            Label ShouShuStart = new Label(41, 1, header1[8], wcf_header);
            sheet.addCell(ShouShuStart);
            sheet.setColumnView(41, 20);
            sheet.mergeCells(41, 1, 41, 2);

            Label ShouShuEnd = new Label(42, 1, header1[9], wcf_header);
            sheet.addCell(ShouShuEnd);
            sheet.setColumnView(42, 20);
            sheet.mergeCells(42, 1, 42, 2);

            Label operationShiChang = new Label(43, 1, header1[10], wcf_header);
            sheet.addCell(operationShiChang);
            sheet.setColumnView(43, 20);
            sheet.mergeCells(43, 1, 43, 2);

            calData(startTime, endTime, accountName);
            for (int row = 0; row < rowMapColData.size(); row++) {
                sheet.setRowView(row+3, 400);
                Map<Integer, String> colMapData = rowMapColData.get(row);
                for (int col = 0; col < 47; col++) {
                    String data = colMapData.get(col);
                    if (null == data || data.length() == 0) continue;
                    Label colData = new Label(col+1, row+3, data, wcf_cell);
                    sheet.addCell(colData);
                }
            }

            //写入数据
            book.write();
            //关闭文件
            book.close();
        } catch (RowsExceededException rows) {
            rows.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        } catch (WriteException wr) {
            wr.printStackTrace();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
