package cn.medigical.publish.interfaces.his.hisLink;


import cn.medigical.publish.interfaces.lis.LisData;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.dictionary.ConfigDepartments;
import cn.medigical.publish.pojo.patientLink.PatientLink;

import org.apache.log4j.Logger;

import java.util.Date;
import java.util.List;

/**
 * Created by 博创医疗 on 2010/5/20.
 * Copyright by 博创医疗
 * HIS连接基本抽象类
 */
public abstract class HisLink {
    protected Logger logger = Logger.getLogger("HisLink");

    //获取手术申请
    public abstract List<PatientLink> getOprationFromHis();

    //修改手术申请状态,手术状态operStatus对应着MyConstants中的OR_STATUS_FLAG_SCHEDULED、OR_STATUS_FLAG_OUT_ROOM等等
    public abstract void updateOperationStatus(String hisOperId, String operStatus);

    public abstract void updateScheduleInfo(String PatientLinkId);

    public abstract void addScheduleInfo(String PatientLinkId);

    //获取麻醉科医生（职工）字典表
    public abstract List<Account> getAccountFromHis();
    //获取科室字典表
    public abstract List<ConfigDepartments> getDepartmentFromHis();
    //手术结束后，给HIS反写一些信息
    public abstract boolean writeEndOper2HIS(PatientLink patientLink);

    public abstract boolean addEndOper2HISUpateBatch(List<PatientLink> patientLinks);

    public abstract LisData getLisData(String zyh, String name);

    public abstract String getMazuiDocDeptCode();

    public abstract String getMazuiDocDeptName();

    public abstract String getNurseDeptCode();

    public abstract String getNurseDeptName();

    public abstract boolean isBGAEnable();

    public abstract List<PojoBGA> getBGA(String zyh, Date startTime, Date endTime);

    public boolean writeOperSchedule2HISUpateBatch(List<PatientLink> patientLinks) {
        return false;
    }

}
