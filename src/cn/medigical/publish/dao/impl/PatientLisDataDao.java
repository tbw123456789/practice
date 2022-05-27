package cn.medigical.publish.dao.impl;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import cn.medigical.publish.dao.BaseDao;
import cn.medigical.publish.pojo.patient.PatientLisData;


@Service
public class PatientLisDataDao extends BaseDao<PatientLisData> {

	public boolean addUpdate(PatientLisData PatientLisData) {
		return save(PatientLisData);
	}

	public PatientLisData getPatientLisData8PatientId(String patientID) {
		Criteria criteria = Criteria.where("patientID").is(patientID);
		return findOne(criteria);
	}

}
