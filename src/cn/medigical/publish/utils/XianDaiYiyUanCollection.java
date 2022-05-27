package cn.medigical.publish.utils;

import cn.medigical.publish.dao.impl.AccountCache;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.patientLink.PatientLink;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

public class XianDaiYiyUanCollection {
    SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public Connection getConnection() {
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://172.168.3.10:1433;databaseName=scxdyy";
        String username = "cxt1111";
        String password = "123456";
        Connection connection = null;

       // logger.info("driverName:"+driverName+"\n url:"+url+"\n username:"+username+"\n password:"+password);
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connect to his SQLServer ok.");
           // logger.info("Connect to his SQLServer ok.");
        } catch (Exception ex) {
            System.out.println("Could not establish lis SQLServer connection! " + ex.getMessage());
            //System.out.println("Could not establish lis SQLServer connection! " + ex.getMessage());
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
    public PatientLink getPatientInfoFromHisByID(String zyh) {
        Connection connection = getConnection();
        PatientLink patientLink = new PatientLink();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from v_smjk_hzbm where Patient_Zyh = '"+zyh+"'");
            if (resultSet.next()){
                //患者ID
                String Patient_Id = trimStr(String.valueOf(resultSet.getString("Patient_Id")));
                //患者住院登记ID
                String Patient_Zydj_Id = trimStr(String.valueOf(resultSet.getString("Patient_Zydj_Id")));
                //患者姓名
                String Patient_Xm = trimStr(resultSet.getString("Patient_Xm"));
                //患者住院号
                String Patient_Zyh = trimStr(String.valueOf(resultSet.getString("Patient_Zyh")));
                //患者门诊号
                String Patient_Mzh = trimStr(resultSet.getString("Patient_Mzh"));
                //患者性别
                String Patient_Xb = trimStr(resultSet.getString("Patient_Xb"));
                //患者年龄
                String Patient_Nl = trimStr(String.valueOf(resultSet.getString("Patient_Nl")));
                //患者年龄单位
                String Patient_Nldw = trimStr(resultSet.getString("Patient_Nldw"));
                //患者房号
                String Patient_Fh = trimStr(String.valueOf(resultSet.getString("Patient_Fh")));
                //患者床号
                String Patient_Ch = trimStr(String.valueOf(resultSet.getString("Patient_Ch")));
                //患者住院科室名称
                String Patient_Jzksmc = trimStr(resultSet.getString("Patient_Jzksmc"));
                //患者住院科室编码
                String Patient_JzksBm = trimStr(resultSet.getString("Patient_JzksBm"));
                //患者病区名称
//                String Patient_Bqmc = resultSet.getString("Patient_Bqmc");
//                if (Patient_Jzksmc == null){
//                    Patient_Jzksmc = Patient_Bqmc;
//                }
                //患者病区编码
                //String Patient_Bqbm = trimStr(String.valueOf(resultSet.getString("Patient_Bqbm")));
                //患者出生日期
                String Patient_Csrq = trimStr(resultSet.getString("Patient_Csrq"));
                //身份证号
                String Patient_Sfzh=trimStr(resultSet.getString("Patient_Sfzh"));
                patientLink.getPatient().setBrxm(quchukongge(Patient_Xm));
                patientLink.getPatient().setZyh(quchukongge(Patient_Zyh));
                patientLink.getPatient().setSocialId(Patient_Sfzh);
                setAge(patientLink,Patient_Nl);
                if(!"".equals(Patient_Csrq)) {
                    try {
                        patientLink.getPatient().setDob(dfs.parse(Patient_Csrq));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                patientLink.getPatient().setKsbh(quchukongge(Patient_JzksBm));
                //patientLink.getPatient().setBqbh(Patient_Bqbm);
                //patientLink.getPatient().setBqmc(Patient_Jzksmc);
                patientLink.getPatient().setKsmc(quchukongge(Patient_Jzksmc));
                patientLink.getPatient().setZyfh(quchukongge(Patient_Fh));
               patientLink.getPatient().setNldw(quchukongge(Patient_Nldw));
               patientLink.getPatient().setXb(quchukongge(Patient_Xb));
               //setXB(patientLink , Patient_Xb);
                patientLink.getPatient().setZych(quchukongge(Patient_Ch));
            }
            closeConnection(connection,statement,resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patientLink;
    }
    /**
     * 获取手术申请
     * @return
     */

    public PatientLink getOprationFromHis(String zyh) {
        Connection connection = getConnection();
        PatientLink patientLink = null;
        try {
            Statement statement = connection.createStatement();
            String sqlStr = "select * from v_smjk_sssqd where Patient_Zyh = '"+zyh+"'";
            ResultSet resultSet = statement.executeQuery(sqlStr);
            while (resultSet.next()){
                patientLink = getOperation(resultSet);
                break;
            }
            closeConnection(connection,statement,resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patientLink;
    }
    public String quchukongge(String str){
        return str.replaceAll("\\s+", " ");
    }
    private PatientLink getOperation(ResultSet resultSet) {
        if (resultSet == null) {
            return null;
        }
        //手术单ID
        String Operation_Id = null;
        try {
            Operation_Id = trimStr(String.valueOf(resultSet.getString("Operation_Id")));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //手术状态
        try {
            String Operation_Zt = trimStr(String.valueOf(resultSet.getString("Operation_Zt")));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //患者姓名
        String Patient_Xm = null;
        try {
            Patient_Xm = trimStr(resultSet.getString("Patient_Xm"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //患者住院号
        String Patient_Zyh = null;
        try {
            Patient_Zyh = trimStr(resultSet.getString("Patient_Zyh"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //患者性别
        String Patient_Xb = null;
        try {
            Patient_Xb = trimStr(resultSet.getString("Patient_Xb"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //患者年龄
        String Patient_Nl = null;
        try {
            Patient_Nl = trimStr(String.valueOf(resultSet.getString("Patient_Nl")));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //患者床号
        String Patient_Ch = null;
        try {
            Patient_Ch = trimStr(resultSet.getString("Patient_Ch"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //申请科室名称
        String Dep_Mc = null;
        try {
            Dep_Mc = trimStr(resultSet.getString("Dep_Mc"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //申请科室编码
        String Dep_Id = null;
        try {
            Dep_Id = trimStr(String.valueOf(resultSet.getString("Dep_Id")));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //医嘱名称(手术名称)
        String DoctorsAdvice_Mc = null;
        try {
            DoctorsAdvice_Mc = trimStr(resultSet.getString("DoctorsAdvice_Mc"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //计划手术时间
        String Operation_Jhsj = null;
        try {
            Operation_Jhsj = trimStr(resultSet.getString("Operation_Jhsj"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //手术申请时间
        String Operation_Sqsj = null;
        try {
            Operation_Sqsj = trimStr(resultSet.getString("Operation_Sqsj"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //手术等级
        try {
            String Operation_Dj = trimStr(resultSet.getString("Operation_Dj"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //ICD10诊断
        String Icd_10 = null;
        try {
            Icd_10 = trimStr(resultSet.getString("Icd_10"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //手术医生ID
        try {
            String OperationDoctor_Id = trimStr(String.valueOf(resultSet.getString("OperationDoctor_Id")));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //手术医生名称
        String OperationDoctor_Mc = null;
        try {
            OperationDoctor_Mc = trimStr(resultSet.getString("OperationDoctor_Id"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //手术医生编码
        String OperationDoctor_Bm = null;
        try {
            OperationDoctor_Bm = trimStr(resultSet.getString("OperationDoctor_Bm"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //执行科室编码
        try {
            String Dep_Zxksbm = trimStr(String.valueOf(resultSet.getString("Dep_Zxksbm")));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //执行科室名称
        try {
            String Dep_Zxksmc = trimStr(resultSet.getString("Dep_Zxksmc"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        //患者所在病区编码
        try {
            String Patient_Bqbm = trimStr(String.valueOf(resultSet.getString("Patient_Bqbm")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //患者所在病区名称
//        String Patient_Bqmc = null;
//        try {
//            Patient_Bqmc = trimStr(resultSet.getString("Patient_Bqmc"));
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }

//        String Patient_SqDoctor = null;
//        try {
//            Patient_SqDoctor = trimStr(resultSet.getString("SURGEON"));
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }

//        String Patient_Mzfs = null;
//        try {
//            Patient_Mzfs = trimStr(resultSet.getString("ANESTHESIA_METHOD"));
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }

        if (null == Operation_Id || Operation_Id.trim().length() == 0) {
            return null;
        }

        PatientLink patientLink = new PatientLink();
        // 手术申请ID
        patientLink.getApplication().setSssqdh(Operation_Id);// 申请单号

        patientLink.setHisID(Operation_Id);

        // 手术状态
        patientLink.getApplication().setStatus(Constants.AP_STATUS_MAZUIQIAN);
        // 明细状态
        patientLink.getApplication().setDetailstatus(Constants.OR_STATUS_FLAG_APPLIED);
        // 患者状态
        patientLink.getPatient().setStatus(Constants.FLAG_VALID);

        patientLink.getPatient().setBrxm(Patient_Xm);// 病人姓名
        patientLink.getPatient().setZyh(Patient_Zyh); // HIS端住院号
        //patientLink.getPatient().setBqmc(Patient_Bqmc);

        patientLink.getPatient().setXb(Patient_Xb);

        setAge(patientLink,Patient_Nl);

        if (null == patientLink.getPatient().getNldw()) {
            patientLink.getPatient().setNldw(Constants.AGE_UNIT_MONTH);// 年龄单位
        }

        // 住院床号
//        if (Patient_Ch.length() > 4) {
//            Patient_Ch = Patient_Ch.substring(4, Patient_Ch.length());
//        }
        patientLink.getPatient().setZych(Patient_Ch);

        // 住院科室
        patientLink.getApplication().setSqksmc(Dep_Mc);// 申请科室名称
        patientLink.getApplication().setSqksbh(Dep_Id);// 申请科室编号

        // 拟施手术
        patientLink.getApplication().setNsssmc(DoctorsAdvice_Mc);// 拟施手术名称



        // 计划手术时间
        try {

            patientLink.getApplication().setYysssj(df.parse(Operation_Jhsj));
            patientLink.getSchedule().setJhsssj(df.parse(Operation_Jhsj));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            String time = df.format(dfs.parse(Operation_Sqsj));
            Timestamp ts = Timestamp.valueOf(time);
            Date applyOperTime = new Date(ts.getTime());// 手术申请时间
            patientLink.getApplication().setSssqsj(applyOperTime);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //patientLink.getPatient().setSqDoctor(Patient_SqDoctor);
        //patientLink.getPatient().setPbMzfs(Patient_Mzfs);

        // his有3个术前诊断
        patientLink.getApplication().setSqzd1(Icd_10);
        patientLink.getApplication().setMzfs("");

        //手术医师
        if(!"".equals(OperationDoctor_Mc)) {
            patientLink.getApplication().setSsysxm(OperationDoctor_Mc);
        }
//        else if(!"".equals(Patient_SqDoctor)&&!"".equals(Patient_SqDoctor)){
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateFormat.DATE_FORMAT_STR_YMD);
//            Date d = new Date();
//            patientLink.getApplication().setSsysxm(convertNameToId(Patient_SqDoctor, FirstLetterUtil.getFirstLetter(Patient_SqDoctor) + simpleDateFormat.format(d), accounts, "手术医生"));
//        }
        // 申请科室名称
        patientLink.getApplication().setSqksmc(Dep_Mc);
        patientLink.getPatient().setKsmc(Dep_Mc);
        // 申请科室编号
        patientLink.getApplication().setSqksbh(Dep_Id);
        return patientLink;
    }
    private void setXB(PatientLink patientLink , String xb){
        if (xb != null || !xb.equals("")){
            if (xb.equals("1")){
                patientLink.getPatient().setXb("男");
            }else if (xb.equals("2")){
                patientLink.getPatient().setXb("女");
            }else{
                patientLink.getPatient().setXb("");
            }
        }
    }
    private void setAge(PatientLink patientLink,String Patient_Nl) {
        // 年龄
        Date now = new Date();
        if (Patient_Nl.contains("岁") || Patient_Nl.contains("月") || Patient_Nl.contains("天")) {
            patientLink.getPatient().setNl(Patient_Nl);// 年龄
            if (Patient_Nl.contains("岁")) {
                try {
                    patientLink.getPatient().setNldw(Constants.AGE_UNIT_YEAR);// 年龄单位
                    Integer numAge = Integer.parseInt(Patient_Nl.substring(0, Patient_Nl.indexOf("岁")));
                    patientLink.getPatient().setNumAge(numAge);
                    now.setYear(now.getYear() - numAge);
                    patientLink.getPatient().setDob(now);
                } catch (Exception e) {
                    patientLink.getPatient().setNumAge(0);
                }
            } else {
                patientLink.getPatient().setNumAge(0);
            }
        } else {
            patientLink.getPatient().setNl(Patient_Nl + "岁");// 年龄
            try {
                Integer numAge = Integer.parseInt(Patient_Nl.trim());
                patientLink.getPatient().setNumAge(numAge);
                patientLink.getPatient().setNldw(Constants.AGE_UNIT_YEAR);// 年龄单位
                now.setYear(now.getYear() - numAge);
                patientLink.getPatient().setDob(now);
            } catch (Exception e) {
            }
        }

    }
    private static String trimStr(String str) {
        if (null == str) {
            return "";
        }
        return str.trim();
    }
}
