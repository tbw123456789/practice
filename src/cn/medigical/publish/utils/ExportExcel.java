package cn.medigical.publish.utils;


import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.pojo.qualitystatic.QualityExport;
import cn.medigical.publish.pojo.qualitystatic.QualityWorkExport;
import cn.medigical.publish.pojo.zhikong.QualityStatistics;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * Created by 博创医疗 on 2016/9/18.
 * Copyright by 博创医疗
 */
public class ExportExcel {
    private static ExportExcel instance = null;
    public final static  String EXCEL_SUFFIX = ".xls";  //后缀名
    public static String desktopPath = "";


    public static ExportExcel getInstance() {
        if (null == instance) {
            instance = new ExportExcel();
        }
        return instance;
    }

    public String getDesktopPath(){
        if (desktopPath.length() == 0){
            File desktopDir = FileSystemView.getFileSystemView().getHomeDirectory();
            desktopPath = desktopDir.getAbsolutePath();
        }
        return desktopPath;
    }

    public String getFileName(String fileName) {
        String firstName = fileName;
        int index = 1;
        while (new File(fileName).exists()){
            fileName = firstName.replaceAll(".xls","");
            fileName = fileName + "(副本"+index+").xls";
            index ++;
        }
        return fileName;
    }

    public void exportZhiKongExcel(String fileName, List<QualityStatistics> resultList, int year) {
        QualityExport.getInstance().exportTongLiangExcel(fileName, resultList,year);//质控管理统计Excel
    }

    public void exportWorkExcel(String fileName, Date startTime, Date endTime, String accountName) {
        QualityWorkExport.getInstance().exportTongLiangExcel(fileName, startTime, endTime, accountName);//工作量统计Excel
    }

    public void exportLiShiExcel(String fileWholeName, List<PatientLink> patientLinkList) {
        //QualityLiShiExport.getInstance().exportTongLiangExcel(fileWholeName,patientLinkList);//工作量统计Excel
    }
}
