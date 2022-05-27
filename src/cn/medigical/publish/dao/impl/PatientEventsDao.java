package cn.medigical.publish.dao.impl;

import cn.medigical.publish.dao.BaseDao;
import cn.medigical.publish.pojo.patient.PatientEvents;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientEventsDao extends BaseDao<PatientEvents> {

    public List<PatientEvents> getPatientEvents8PatientId(String patientID) {
        Criteria criteria = Criteria.where("PatientID").is(patientID);
        return find(criteria);
    }


}
