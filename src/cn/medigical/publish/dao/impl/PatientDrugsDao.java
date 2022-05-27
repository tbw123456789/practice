package cn.medigical.publish.dao.impl;

import cn.medigical.publish.dao.BaseDao;
import cn.medigical.publish.pojo.patient.PatientDrugs;
import cn.medigical.publish.utils.Constants;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PatientDrugsDao extends BaseDao<PatientDrugs> {

    public List<PatientDrugs> getPatientDrugs8PatientId(String patientID) {
        Criteria criteria = Criteria.where("patientID").is(patientID);
        return find(criteria);
    }

    public PatientDrugs getPatientDrugs8PatientIdAndEventCode(String patientID, String code) {
        Criteria criteria = Criteria.where("patientID").is(patientID);
        Criteria criteria1= Criteria.where("code").is(code);
        return findOne(criteria.andOperator(criteria1));
    }
    public List<PatientDrugs> getFinishOperByTime(String patientID, Date start, Date end, String code) {
        Criteria criteria = Criteria.where("patientID").is(patientID);
        Criteria criteria1 = Criteria.where("status").ne(Constants.FLAG_IN_VALID);
        Criteria criteria2 = Criteria.where("beginTime").gte(start).lte(end);
        criteria2.andOperator(Criteria.where("drugMethod").is(code));
        Criteria criteriaSearch = null;
        criteriaSearch = criteria.andOperator(criteria1.andOperator(criteria2));
        return find(criteriaSearch);
    }

}
