package cn.medigical.publish.interfaces.his.hisLink;

import cn.medigical.publish.pojo.patient.PatientVitalSigns;

import java.util.Date;
import java.util.HashMap;

/**
 * Created by 博创医疗 on 2016/9/29.5:46
 * Copyright by 博创医疗
 */
public class PojoBGA {
    public Date time = new Date();
    public HashMap<String ,PatientVitalSigns> bedsideHashMap = new HashMap<>();

    public String orderID = ""; // 医嘱号
    public String specID = ""; // 标本号
    public String reportID = "";
    public String notes = null;

    @Override
    public String toString() {
        return "PojoBGA{" +
                "time=" + time +
                ", bedsideHashMap=" + bedsideHashMap +
                ", orderID='" + orderID + '\'' +
                ", specID='" + specID + '\'' +
                ", reportID='" + reportID + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
