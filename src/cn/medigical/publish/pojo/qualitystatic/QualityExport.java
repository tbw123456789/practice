package cn.medigical.publish.pojo.qualitystatic;


import cn.medigical.publish.pojo.zhikong.QualityStatistics;
import cn.medigical.publish.utils.ExportExcel;
import jxl.Workbook;
import jxl.format.UnderlineStyle;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by 博创医疗 on 2016/9/18.
 * Copyright by 博创医疗
 * 铜梁Excel
 */
public class QualityExport {
    private static QualityExport instance = null;
    private Map<Integer, Map<Integer, Integer>> rowMonthMapColData = new HashMap<>();
    public static QualityExport getInstance() {
        if (null == instance) {
            instance = new QualityExport();
        }
        return instance;
    }
    private void calMazuiIndexData(WritableSheet sheet, WritableCellFormat wcf_cell, List<QualityStatistics> resultList, int year) {
        rowMonthMapColData.clear();
        if (null == resultList || resultList.size() == 0) return;
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.YEAR,year);
        Date startTime = calendar.getTime();
        calendar.set(Calendar.MONTH, Calendar.DECEMBER);
        Date endTime = calendar.getTime();
        for (QualityStatistics mazuiZhiKongTJ : resultList) {
            Date time=mazuiZhiKongTJ.getDate();
            if (time.getTime() < startTime.getTime() || time.getTime() > endTime.getTime()) continue;
            calendar.setTime(time);
            int month = calendar.get(Calendar.MONTH);
            Map<Integer, Integer> colData = rowMonthMapColData.get(month);
            if (null == colData) {
                colData = new HashMap<>();
                rowMonthMapColData.put(month, colData);
            }
            for (int i = 0; i< TblZhiKongLeftModel.methods.length; i++){
                Integer ret=0;
                String method=TblZhiKongLeftModel.methods[i];
                Method method1[]= mazuiZhiKongTJ.getClass().getMethods();
                for (int j=0;j<method1.length;j++){
                    if (method1[j].getName().contains("get")){
                        String val=method1[j].getName().substring(3);
                        if (val.equalsIgnoreCase(method)){
                            String getMethodnName=method1[j].getName();
                            Object object;
                            try {
                                object= method1[j].invoke(mazuiZhiKongTJ,(Object[])null);
                                if (object!=null){
                                    ret = ((Integer) object);
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }

                            colData.put(i,ret);
                        }
                    }
                }
            }
        }
        for (int month=0;month<=11;month++){
            Map<Integer,Integer> colData=rowMonthMapColData.get(month);
            if (null == colData || colData.size() == 0) continue;
            for (int row=0;row<=TblZhiKongLeftModel.titles.length;row++){
                Integer cellData = colData.get(row);
                if (null == cellData) continue;
                Label data = new Label(4+month, row+4, String.valueOf(cellData), wcf_cell);
                try {
                    sheet.addCell(data);
                } catch (WriteException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public void exportTongLiangExcel(String fileName, List<QualityStatistics> resultList , int year) {
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

            WritableFont fontPS = new WritableFont(WritableFont.createFont("黑体"), 12, WritableFont.NO_BOLD);
            WritableCellFormat wcf_ps = new WritableCellFormat(fontPS); // 单元格定义
            wcf_ps.setAlignment(jxl.format.Alignment.CENTRE); // 设置对齐方式
            wcf_ps.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);

            WritableFont fontDate = new WritableFont(WritableFont.createFont("宋体"), 18, WritableFont.BOLD);
            WritableCellFormat wcf_date = new WritableCellFormat(fontDate); // 单元格定义
            wcf_date.setAlignment(jxl.format.Alignment.CENTRE); // 设置对齐方式
            wcf_date.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);

            WritableFont fontCell = new WritableFont(WritableFont.createFont("宋体"), 11, WritableFont.NO_BOLD);
            WritableCellFormat wcf_cell = new WritableCellFormat(fontCell); // 单元格定义
            wcf_cell.setAlignment(jxl.format.Alignment.CENTRE); // 设置对齐方式
            wcf_cell.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
            wcf_cell.setWrap(true);
            //设置行高列宽
            for (int row = 0; row <=TblZhiKongLeftModel.titles.length+4; row++) {
                sheet.setRowView(row, 400);
            }

            Label title = new Label(0, 0, String.valueOf(year) +  "年麻醉质量检测指标", wcf_title); //XMLConfigReader.getInstance().getHospital()
            sheet.addCell(title);
            Label ps = new Label(0, 2, "资料来源于手术室", wcf_ps);
            sheet.addCell(ps);

            Label labdata=new Label(0,3,"指标名称/日期",wcf_date);
            sheet.addCell(labdata);

            //1月——12月
            for (int month=1;month<=12;month++){
                Label indexWorkZhiLiangCnt = new Label(month+3, 3, String.valueOf(month)+"月",wcf_cell);
                sheet.addCell(indexWorkZhiLiangCnt);
            }
            //写入指标数据
            calMazuiIndexData(sheet, wcf_cell, resultList,year);
            //合并单元格
            sheet.mergeCells(0, 0, 15, 1); //麻醉质量检测指标
            sheet.mergeCells(0, 2, 3, 2);  //资料来源于手术室
            sheet.mergeCells(0, 3, 3, 3);  //指标名称/日期

            for (int i=0;i< TblZhiKongLeftModel.titles.length;i++){
                sheet.mergeCells(0,4+i,3,4+i);
                Label name=new Label(0,4+i,TblZhiKongLeftModel.titles[i],wcf_date);
                sheet.addCell(name);
            }


            //写入数据
            book.write();
            //关闭文件
            book.close();
        } catch (RowsExceededException e) {
            e.printStackTrace();
        } catch (WriteException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

