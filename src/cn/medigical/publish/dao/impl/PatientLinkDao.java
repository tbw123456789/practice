package cn.medigical.publish.dao.impl;

import cn.medigical.publish.dao.BaseDao;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.utils.Constants;
import cn.medigical.publish.utils.MyDateFormat;

import com.mongodb.BasicDBObject;

import javafx.beans.property.StringProperty;

import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by 2018/6/7.
 */
@Service
public class PatientLinkDao extends BaseDao<PatientLink> {

    static Logger logger = Logger.getLogger("PatientLinkDao");

    public static final String PatientLink_RECORD_PREFIX = "OR_records_";

    public boolean addUpdate(PatientLink PatientLink) {
        return save(PatientLink);
    }
    public boolean updateInsert(PatientLink patientLink) {
        String hisid = patientLink.getHisID();

        Criteria criteria = Criteria.where("hisID").is(hisid);
        Update update = Update.update("schedule", patientLink.getSchedule());
        Update update2 = Update.update("application", patientLink.getApplication());
        Update update3 = Update.update("patient", patientLink.getPatient());
        Update update4= Update.update("anesthesiaRecord", patientLink.getAnesthesiaRecord());
        findAndUpdate(criteria, update);
        findAndUpdate(criteria, update2);
        findAndUpdate(criteria, update3);
        findAndUpdate(criteria, update4);


        return true;
    }
    public List<PatientLink>  getFinishOperList(){
        Criteria criteriaFlag = Criteria.where("patient.status").ne(Constants.FLAG_IN_VALID);
        Criteria criteriaFlag3 = Criteria.where("application.detailstatus").is(Constants.OR_STATUS_FLAG_OUT_ROOM);
        return find(criteriaFlag.andOperator(criteriaFlag3));
    }

    public List<PatientLink> getRecentOperList (){
        Date dateNow = new Date();
        Calendar cl = Calendar.getInstance();
        cl.setTime(dateNow);
        cl.add(Calendar.DAY_OF_YEAR, -2);	//3天前
        Date dateFrom = cl.getTime();//3天前时间的时间

        Criteria criteriaFlag = Criteria.where("patient.status").ne(Constants.FLAG_IN_VALID);
        Criteria criteriaFlag2 = Criteria.where("status.inRoomTime").gt(dateFrom);
        Criteria criteriaFlag3 = Criteria.where("application.detailstatus").is(Constants.OR_STATUS_FLAG_OUT_ROOM);
        return find(criteriaFlag.andOperator(criteriaFlag3,criteriaFlag2));
    }
    private Update getPatientLinkUpdate(PatientLink patientLink) throws IllegalAccessException {
        Class<?> accountCls = patientLink.getClass();
        Field[] fields =new Field[]{};
        Update update = new Update();
        for(Field field : fields){
            field.setAccessible(true);
            String fieldName = field.getName();
            //if(!"id".equals(fieldName)&&!"pwd".equals(fieldName)) {
                update.set(fieldName, field.get(patientLink));
            //}
        }
        return update;
    }

    public long count(Criteria criteria, String name) {
        // TODO Auto-generated method stub
        return mongoTemplate.count(new Query(criteria), name);
    }

    public List<PatientLink> getPaientLinkbyIndexNo(String patIndexNo) {
        Criteria criteria = getCriteria().and("Patient.PatIndexNo").is(patIndexNo);
        return find(criteria);
    }

    public void addUpdateOneField(PatientLink PatientLink, String fieldName, Object fieldValue) {
        String oid = PatientLink.getId();
        if (null == oid) {
            save(PatientLink);
        } else {
            if (fieldName == null) {
                logger.warn("fieldName is null,can't save.");
                return;
            }
            Criteria criteria = Criteria.where("id").is(new ObjectId(oid));
            Update update = Update.update(fieldName, fieldValue);
            findAndUpdate(criteria, update);
        }
    }

    public void findAndUpdate(Criteria criteria, Update update) {
        updateFirst(criteria, update);
    }

    public void addUpdateApplication(PatientLink patientLink) {
        String sssqhh = patientLink.getApplication().getSssqdh();
        if (null == sssqhh) {
            save(patientLink);
        } else {
            PatientLink oldPatient = getBySssqdh(sssqhh);
            oldPatient.setApplication(patientLink.getApplication());
            remove(oldPatient);
            insert(oldPatient);
        }

//		String sssqhh = patientLink.getApplication().getSssqdh();
//		if (null == sssqhh) {
//			save(patientLink);
//		} else {
//			Update update=new Update();
//			
//			Criteria criteria = Criteria.where("Application.Sssqdh").is(sssqhh);
//			Update update = Update.update("Application", patientLink.getApplication());
//			findAndUpdate(criteria, update);
//		}

    }
    public void addUpdateOneFields(PatientLink PatientLink, String fieldName, Object fieldValue) {
        String oid = PatientLink.getId();
        if (null == oid) {
            save(PatientLink);
        } else {
            if (fieldName == null) {
                logger.warn("fieldName is null,can't save.");
                return;
            }
            Criteria criteria = Criteria.where("id").is(new ObjectId(oid));
            Update update = Update.update(fieldName, fieldValue);
            findAndUpdate(criteria, update);
        }
    }
    public void addUpdateApplication(PatientLink hispatientLink, PatientLink dbPatientLink) {
        dbPatientLink.setApplication(hispatientLink.getApplication());
        addUpdate(dbPatientLink);
    }

    public void addUpdateSchedule(PatientLink hispatientLink, PatientLink dbPatientLink) {
        dbPatientLink.setSchedule(hispatientLink.getSchedule());
        addUpdate(dbPatientLink);
    }

    public void addUpdatePatient(PatientLink hispatientLink, PatientLink dbPatientLink) {
        dbPatientLink.setPatient(hispatientLink.getPatient());
        addUpdate(dbPatientLink);
    }

    public List<PatientLink> getPatientLinks() {
        Criteria criteria = Criteria.where("application.detailstatus").is("已排班").and("schedule.jhsssj").gte(getEndTime(new Date()));
        criteria.and("patient.status").is(Constants.FLAG_VALID);
        return find(criteria);
    }

    public static Date getEndTime(Date d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public void addUpdateSchedule(PatientLink patientLink) {
        String sssqhh = patientLink.getApplication().getSssqdh();
        if (null == sssqhh) {
            save(patientLink);
        } else {
            Criteria criteria = Criteria.where("Application.Sssqdh").is(sssqhh);
            Update update = Update.update("Schedule", patientLink.getSchedule());
            findAndUpdate(criteria, update);
        }
    }

    public List<PatientLink> findinroom() {
        Criteria criteria = Criteria.where("application.detailstatus").is(Constants.OR_STATUS_FLAG_IN_ROOM);
        criteria.and("patient.status").is(Constants.FLAG_VALID);
        return find(criteria);
    }

    // 获取排班手术数据
    public List<PatientLink> getScheduleTableOpers() {
        Criteria criteriaFlag = getCriteria().and("patient.status").ne(Constants.FLAG_IN_VALID);
        Date dateNow = new Date();
        Calendar cl = Calendar.getInstance();
        cl.setTime(dateNow);
        cl.add(Calendar.DAY_OF_YEAR, -5);//3天前
        Date dateFrom = cl.getTime();//3天前时间的时间
        Criteria criteriaFlag2 = getCriteria().and("application.sssqsj").gt(dateFrom);
        return find(criteriaFlag.andOperator(criteriaFlag2));
    }

    public List<PatientLink> getScheduleTableOpersNT() {
        Criteria criteriaFlag = getCriteria().and("patient.status").ne(Constants.FLAG_IN_VALID);
        Date dateNow = new Date();
        Calendar cl = Calendar.getInstance();
        cl.setTime(dateNow);
        cl.add(Calendar.DAY_OF_YEAR, -5); // 3天前
        Date dateFrom = cl.getTime();// 3天前时间的时间
        Criteria criteriaFlag2 = getCriteria().and("application.yysssj").gt(dateFrom);
        return find(criteriaFlag2.andOperator(criteriaFlag));
    }

    public List<PatientLink> getScheduleTableOpersNTBySssqdh( String sssqdh) {
        Criteria criteria = getCriteria().and("application.sssqdh").is(sssqdh);
        return find(criteria);
    }
    public List<PatientLink> getTableOpersBrxm( String brxm) {
        Criteria criteria = getCriteria().and("patient.brxm").is(brxm);
        return find(criteria);
    }
    // 获取排班手术数据
    public List<PatientLink> getScheduleTableOpersNS() {
        Date dateNow = new Date();
        Calendar cl = Calendar.getInstance();
        cl.setTime(dateNow);
        cl.add(Calendar.DAY_OF_YEAR, -5); // 3天前
        Date dateFrom = cl.getTime();// 3天前时间的时间
        Criteria criteriaFlag2 = getCriteria().and("application.sssqsj").gt(dateFrom);
        return find(criteriaFlag2);

    }

    public PatientLink getOnePatient(String pid) {
        Criteria criteria = getCriteria().and("patient.patId").is(pid);
        return findOne(criteria);
    }

    public PatientLink getPatientLinkforHisId(String hisID) {
        Criteria criteria = getCriteria().and("hisID").is(hisID);
        return findOne(criteria);
    }

    public PatientLink getPatientLinkforZyh(String zyh) {
        Criteria criteria = getCriteria().and("patient.zyh").is(zyh);
        return findOne(criteria);
    }
    public PatientLink getScheduleByPLinkId(String id) {
        Criteria criteria = getCriteria().and("_id").is(id);
        return findOne(criteria);
    }

    public PatientLink getNoSysAddSchedule() {
        Criteria criteria = null;
        return findOne(criteria);
    }

    public PatientLink getNoSysUpdateSchedule() {
        Criteria criteria = null;
        return findOne(criteria);
    }

    public PatientLink getPatientById(String id) {
        Criteria criteria = getCriteria().and("_id").is(id);
        return findOne(criteria);
    }

    /**
     * 通过住院号查个病人消息
     *
     * @param zyh
     * @return
     */
    public List<PatientLink> getzyh(String zyh) {
        Criteria criteria = getCriteria().and("patient.zyh").is(zyh);
        return find(criteria);
    }

    /**
     * 通过His流手术水号查个病人消息（his唯一标识）
     *
     * @param sssqdh
     * @return
     */
    public PatientLink getPatientLinkBySssqdh(String sssqdh) {
        Criteria criteria = getCriteria().and("application.sssqdh").is(sssqdh);
        return findOne(criteria);
    }
    //通过申请单号和住院号查找病人

    public PatientLink getPatientLinkBySssqdhZyh(String sssqdh,String zyh) {
        Criteria criteria = Criteria.where("patient.status").ne(Constants.FLAG_IN_VALID);
        Criteria criteria2 = getCriteria().and("application.sssqdh").is(sssqdh);

        Criteria criteriaSearch = null;
        Criteria criteria3 = getCriteria().and("patient.zyh").is(zyh);
        criteriaSearch=criteria.andOperator(criteria2.andOperator(criteria3));
        return findOne(criteriaSearch);
    }
    public PatientLink getPatientLinkBySssqdhz(String sssqdh) {
        Criteria criteria = Criteria.where("patient.status").ne(Constants.FLAG_IN_VALID);
        Criteria criteria2 = getCriteria().and("application.sssqdh").is(sssqdh);

        Criteria criteriaSearch = null;

        criteriaSearch=criteria.andOperator(criteria2);
        return findOne(criteriaSearch);

    }
    public PatientLink getPatientLinkByZyh(String zyh) {
        Criteria criteria = Criteria.where("patient.status").ne(Constants.FLAG_IN_VALID).and("patient.zyh").is(zyh);
//        //Criteria criteriaSearch = null;
//        Criteria criteria3 = Criteria.where("patient.zyh").is(zyh);
//        criteriaSearch=criteria.andOperator(criteria3);
        return findOne(criteria);
    }
    public PatientLink getPatientLinkByZyh2(String zyh) {
        Criteria criteria = Criteria.where("patient.status").ne(Constants.FLAG_IN_VALID).and("patient.zyh").is(zyh).and("application.status").is("麻醉术后");
//        //Criteria criteriaSearch = null;
//        Criteria criteria3 = Criteria.where("patient.zyh").is(zyh);
//        criteriaSearch=criteria.andOperator(criteria3);
        return findOne(criteria);
    }
    /**
     * 通过住院号,住院次数查个病人消息
     *
     * @param zyh
     * @param zycs
     * @return
     */
    public PatientLink getByZyhZycs(String zyh, String zycs) {
        Criteria criteria = Criteria.where("patient.status").ne(Constants.FLAG_IN_VALID);
        Criteria criteria1 = new Criteria();
        criteria1.orOperator(Criteria.where("application.detailstatus").is(Constants.OR_STATUS_FLAG_OUT_ROOM), Criteria.where("application.detailstatus").is(Constants.OR_STATUS_FLAG_OUT_PCU));
        Criteria criteriaSearch = null;
        Criteria criteria2 = getCriteria().and("patient.zyh").is(zyh);
        // Criteria criteria3 = getCriteria().and("patient.zycs").is(zycs);, criteria3
        criteriaSearch = criteria.andOperator(criteria1.andOperator(criteria2));
        return findOne(criteriaSearch);
    }

    public PatientLink getSubmitBySssqdh(String Sssqdh) {
        Criteria criteria = Criteria.where("patient.status").ne(Constants.FLAG_IN_VALID);
        Criteria criteriaSearch = null;
        Criteria criteria2 = getCriteria().and("application.sssqdh").is(Sssqdh);
        // Criteria criteria3 = getCriteria().and("patient.zycs").is(zycs);, criteria3
        criteriaSearch = criteria.andOperator(criteria2);
        return findOne(criteriaSearch);
    }

    public PatientLink getBySssqdh(String Sssqdh) {
        Criteria criteria = Criteria.where("patient.status").ne(Constants.FLAG_IN_VALID);
        Criteria criteria1 = new Criteria();
        criteria1.orOperator(Criteria.where("application.detailstatus").is(Constants.OR_STATUS_FLAG_OUT_ROOM), Criteria.where("application.detailstatus").is(Constants.OR_STATUS_FLAG_OUT_PCU));
        Criteria criteriaSearch = null;
        Criteria criteria2 = getCriteria().and("application.sssqdh").is(Sssqdh);
        // Criteria criteria3 = getCriteria().and("patient.zycs").is(zycs);, criteria3
        criteriaSearch = criteria.andOperator(criteria1.andOperator(criteria2));
        return findOne(criteriaSearch);
    }

    public List<PatientLink> find(Criteria criteria) {
        // TODO Auto-generated method stub
        return (List<PatientLink>) mongoTemplate.find(new Query(criteria), PatientLink.class, "patientLink");
    }

    /**
     * 根据日期获取某一天（已排班、进手术间、出手术间、进复苏室、出复苏室）状态下的手术数据
     *
     * @param time
     * @return
     */
    public List<PatientLink> getArrangedOpers8TimeAndRoom(Date time) {
        Criteria criteriaFlag = getCriteria().and("patient.status").ne(Constants.FLAG_IN_VALID);
        Calendar cl = Calendar.getInstance();
        cl.setTime(time);
        cl.set(Calendar.HOUR_OF_DAY, 0);
        cl.set(Calendar.MINUTE, 0);
        cl.set(Calendar.SECOND, 0);
        cl.set(Calendar.MILLISECOND, 0);
        Date startTime = cl.getTime();
        cl.add(Calendar.DAY_OF_YEAR, 1);
        cl.add(Calendar.SECOND, -1);
        Date endTime = cl.getTime();

        criteriaFlag = criteriaFlag.andOperator(
                Criteria.where("schedule.jhsssj").gte(startTime),
                Criteria.where("schedule.jhsssj").lte(endTime));

        List<String> statusList = new ArrayList<String>();
        statusList.add(Constants.OR_STATUS_FLAG_SCHEDULED);
        statusList.add(Constants.OR_STATUS_FLAG_IN_ROOM);
        statusList.add(Constants.OR_STATUS_FLAG_OUT_ROOM);
        statusList.add(Constants.OR_STATUS_FLAG_IN_PCU);
        statusList.add(Constants.OR_STATUS_FLAG_OUT_PCU);

        Criteria criteria = getCriteria().and("application.detailstatus").in(statusList);
        return find(criteria.andOperator(criteriaFlag));
    }

    /**
     * 布尔型count
     */
    public long getFinishOperByTimeCount(Date start, Date end, String name, Boolean val, String accountID) {
        Criteria criteria = Criteria.where("Status.inRoomTime").gte(start).lte(end);
        Criteria criteria1 = new Criteria();
        Criteria criteria2 = Criteria.where("Patient.Status").is(Constants.FLAG_VALID);
        setFinish(criteria1);
        criteria2.and(name).is(val);
        if (accountID != null && accountID != "") {
            setDoctor(criteria2 , accountID);
        }
        return count(criteria.andOperator(criteria1.andOperator(criteria2)), "patientLink");
    }

    public List<PatientLink> getFinishOperByTime(Date start, Date end, String accountID) {
        SimpleDateFormat s = new SimpleDateFormat(Constants.DateY);
        String s1 = s.format(start);
        String s2 = s.format(end);
        Criteria criteria = Criteria.where("status.inRoomTime").gte(start).lte(end);
        Criteria criteria1 = new Criteria();
        Criteria criteria2 = Criteria.where("patient.status").is(Constants.FLAG_VALID);
        setFinish(criteria1);
        if (accountID != null && accountID != "") {
            setDoctor(criteria2 , accountID);
        }
        return find(criteria.andOperator(criteria1.andOperator(criteria2)));
//	 return find(criteria);
    }

    public List<PatientLink> getFinishOperByTimeB(Date start, Date end, String name, Boolean val, String accountID) {
        Criteria criteria = Criteria.where("patient.status").is(Constants.FLAG_VALID);
        Criteria criteria1 = new Criteria();
        Criteria criteria2 = Criteria.where("status.inRoomTime").gte(start).lte(end);
        setFinish(criteria1);
        criteria2.and(name).is(val);
        if (accountID != null && accountID != "") {
            setDoctor(criteria2 , accountID);
        }
        return find(criteria.andOperator(criteria1.andOperator(criteria2)));
    }

    /**
     * 字符串型count
     */
    public long getFinishOperByTimeCount2(Date start, Date end, String name, String val, String accountID) {
        Criteria criteria = Criteria.where("status.inRoomTime").gte(start).lte(end);
        Criteria criteria1 = new Criteria();
        Criteria criteria2 = Criteria.where("patient.status").is(Constants.FLAG_VALID);
        setFinish(criteria1);
        criteria2.and(name).is(val);
        if (accountID != null && accountID != "") {
            setDoctor(criteria2 , accountID);
        }
        return count(criteria.andOperator(criteria1.andOperator(criteria2)), "patientLink");
    }

    public List<PatientLink> getFinishOperByTimeS(Date start, Date end, String name, String val, String accountID) {
        Criteria criteria = Criteria.where("status.inRoomTime").gte(start).lte(end);
        Criteria criteria1 = new Criteria();
        Criteria criteria2 = Criteria.where("patient.status").is(Constants.FLAG_VALID);
        setFinish(criteria1);
        criteria2.and(name).is(val);
        if (accountID != null && accountID != "") {
            setDoctor(criteria2 , accountID);
        }
        return find(criteria.andOperator(criteria1.andOperator(criteria2)));
    }

    /**
     * 模糊String List
     */
    public List<PatientLink> getFinishOperByTimeSList(Date start, Date end, String name, String val, String accountID) {
        Criteria criteria = Criteria.where("status.inRoomTime").gte(start).lte(end);
        Criteria criteria1 = new Criteria();
        Criteria criteria2 = Criteria.where("patient.status").is(Constants.FLAG_VALID);
        setFinish(criteria1);
        criteria2.and(name).regex(Pattern.compile("^.*" + val + ".*$", Pattern.CASE_INSENSITIVE));
        if (accountID != null && accountID != "") {
            setDoctor(criteria2 , accountID);
        }
        return find(criteria.andOperator(criteria1.andOperator(criteria2)));
    }

    /**
     * 模糊String long
     */
    public long getFinishOperByTimeSLong(Date start, Date end, String name, String val, String accountID) {
        Criteria criteria = Criteria.where("status.inRoomTime").gte(start).lte(end);
        Criteria criteria1 = new Criteria();
        Criteria criteria2 = Criteria.where("patient.status").is(Constants.FLAG_VALID);
        setFinish(criteria1);
        criteria2.and(name).regex(Pattern.compile("^.*" + val + ".*$", Pattern.CASE_INSENSITIVE));
        if (accountID != null && accountID != "") {
            setDoctor(criteria2 , accountID);
        }
        return count(criteria.andOperator(criteria1.andOperator(criteria2)), "patientLink");
    }

    public List<PatientLink> getOperByInRoomTime(Date start, Date end) {
        Criteria criteria = Criteria.where("status.inRoomTime").gte(start).lte(end);
        return find(criteria);
    }

    public List<PatientLink> getByPlanTime(Date startTime, Date endTime) {
        Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("application.yysssj").gte(startTime), Criteria.where("application.yysssj").lte(endTime));
        criteria.and("patient.status").is(Constants.FLAG_VALID);
        return find(criteria);
    }

    public List<PatientLink> getByPlanTimeDept(Date startTime, Date endTime,String dept) {
        Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("application.sssqsj").gte(startTime), Criteria.where("application.sssqsj").lte(endTime));
        criteria.and("patient.status").is(Constants.FLAG_VALID);
        criteria.and("patient.ksmc").is(dept);
        return find(criteria);
    }
    private void setFinish(Criteria criteria){
        criteria.orOperator(
                Criteria.where("application.detailstatus").is(Constants.OR_STATUS_FLAG_OUT_ROOM),
                Criteria.where("application.detailstatus").is(Constants.OR_STATUS_FLAG_OUT_PCU)
        );

    }
    private void setDoctor(Criteria criteria , String accountID) {
        criteria.orOperator(
                Criteria.where("anesthesiaRecord.zmys").is(accountID),
                Criteria.where("anesthesiaRecord.fmys1").is(accountID),
                Criteria.where("anesthesiaRecord.fmys2").is(accountID),
                Criteria.where("anesthesiaRecord.fmys3").is(accountID),
                Criteria.where("anesthesiaRecord.jbys1").is(accountID),
                Criteria.where("anesthesiaRecord.jbys2").is(accountID)
        );

    }

    public List<PatientLink> getGongFengTongJi(Date startDate , Date endDate , String doctorNameID) {
        Criteria criteria2 = Criteria.where("Patient.Status").is(Constants.FLAG_VALID);
        Criteria criteriaw = Criteria.where("anesthesiaRecord.zmys").is(doctorNameID);
        return find(Criteria.where("status.outRoomTime").gte(startDate).lte(endDate).andOperator(criteriaw.andOperator(criteria2)));
    }
    public List<PatientLink> getJBGongFengTongJi(Date startDate , Date endDate , String doctorNameID) {
        Criteria criteria2 = Criteria.where("Patient.Status").is(Constants.FLAG_VALID);
        Criteria criteriaw = Criteria.where("anesthesiaRecord.jbys1").is(doctorNameID);
        return find(Criteria.where("status.outRoomTime").gte(startDate).lte(endDate).andOperator(criteriaw.andOperator(criteria2)));
    }
    public List<PatientLink> getFSGongFengTongJi(Date startDate , Date endDate , String doctorNameID) {
        Criteria criteria2 = Criteria.where("Patient.Status").is(Constants.FLAG_VALID);
        Criteria criteriaw = Criteria.where("pacu.mzys1").is(doctorNameID);
        return find(Criteria.where("status.outRoomTime").gte(startDate).lte(endDate).andOperator(criteriaw.andOperator(criteria2)));
    }
    public List<PatientLink> getAllGongFengTongJi(Date startDate , Date endDate ){
        Criteria criteria2 = Criteria.where("Patient.Status").is(Constants.FLAG_VALID);
        return find(Criteria.where("status.outRoomTime").gte(startDate).lte(endDate).andOperator(criteria2));
    }

    /**
     * 根据时间获取当天已排班手术数据
     *
     * @param time
     * @return
     */
    public List<PatientLink> getScheduledOpers8Time(Date time) {
        Query query = new Query();
        Criteria criteriaFlag = getCriteria().and("patient.status").ne(Constants.FLAG_IN_VALID);
        Calendar cl = Calendar.getInstance();
        cl.setTime(time);
        cl.set(Calendar.HOUR_OF_DAY, 0);
        cl.set(Calendar.MINUTE, 0);
        cl.set(Calendar.SECOND, 0);
        cl.set(Calendar.MILLISECOND,0);
        Date startTime = cl.getTime();

        cl.set(Calendar.HOUR_OF_DAY, 23);
        cl.set(Calendar.MINUTE, 59);
        cl.set(Calendar.SECOND, 59);
        Date endTime = cl.getTime();
        criteriaFlag = criteriaFlag.andOperator(
                Criteria.where("schedule.jhsssj").gte(startTime),
                Criteria.where("schedule.jhsssj").lte(endTime));

        List<String> statusList = new ArrayList<String>();
        statusList.add(Constants.OR_STATUS_FLAG_SCHEDULED);
        Criteria criteria = getCriteria().and("application.detailstatus").in(statusList);
        return find(query.addCriteria(criteria.andOperator(criteriaFlag)));
    }

//    public List<PatientLink> getSelTableOpers() {
//        Criteria criteriaFlag = getCriteria().and("patient.status").is(Constants.FLAG_VALID);
//        Date a1 = new Date(convertToDays(false).getTime());
//        Date a2 = convertToDays(true);
//        Criteria criteria1 = Criteria.where("application.detailstatus").is(Constants.OR_STATUS_FLAG_SCHEDULED).andOperator(getCriteria().and("schedule.jhsssj").gte(a1).lt(a2));
//        Criteria criteria5 = Criteria.where("application.detailstatus").is (Constants.OR_STATUS_FLAG_IN_ROOM);
//        return find(criteriaFlag.orOperator(new Criteria[]{criteria1,criteria5})) ;
//    }

    public Date convertToDays(Boolean pd) {
        try {
            if (pd) {
                return MyDateFormat.DATE_FORMAT_YMD.parse(MyDateFormat.DATE_FORMAT_YMD.format(System.currentTimeMillis() +24 * 60 * 60 * 1000));
            } else {
                return MyDateFormat.DATE_FORMAT_YMD.parse(MyDateFormat.DATE_FORMAT_YMD.format(new Date()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return new Date();
        }
    }
    public List<PatientLink> getFinishOperByTime2(Date start, Date end) {
        Criteria criteria = Criteria.where("status.inRoomTime").gte(start).lte(end);
        Criteria criteria1 = new Criteria();
        Criteria criteria2 = Criteria.where("patient.status").is(Constants.FLAG_VALID);
        criteria1.orOperator(Criteria.where("application.detailstatus").is(Constants.OR_STATUS_FLAG_OUT_ROOM), Criteria.where("application.detailstatus").is(Constants.OR_STATUS_FLAG_OUT_PCU));

        return find(criteria.andOperator(criteria1.andOperator(criteria2)));
        // return find(criteria2);
    }


}
