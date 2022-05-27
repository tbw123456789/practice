package cn.medigical.publish.dao.impl;


import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import cn.medigical.publish.dao.BaseDao;
import cn.medigical.publish.pojo.patient.PatientVitalSigns;


@Service
public class PatientVitalSignsDao extends BaseDao<PatientVitalSigns>  {

	public PatientVitalSigns findOneSouShuo(String id) {
		// TODO Auto-generated method stub
		Criteria criatira = Criteria.where("PatientID").is(id).and("Name").is("无创收缩压");
		return mongoTemplate.findOne(new Query(criatira).with(new Sort(new Order(Direction.DESC, "CaptureTime"))), PatientVitalSigns.class, "patientVitalSigns");

	}
	public PatientVitalSigns findOneShuZhang(String id) {
		// TODO Auto-generated method stub
		Criteria criatira = Criteria.where("patientID").is(id).and("name").is("无创舒张压");
		return mongoTemplate.findOne(new Query(criatira).with(new Sort(new Order(Direction.DESC, "captureTime"))), PatientVitalSigns.class, "patientVitalSigns");
	}

	public PatientVitalSigns findOneXingLv(String id) {
		// TODO Auto-generated method stub
		Criteria criatira = Criteria.where("PatientID").is(id).and("Name").is("心率");
		return mongoTemplate.findOne(new Query(criatira).with(new Sort(new Order(Direction.DESC, "CaptureTime"))), PatientVitalSigns.class, "patientVitalSigns");

	}

	public PatientVitalSigns findOneXueYang(String id) {
		// TODO Auto-generated method stub
		Criteria criatira = Criteria.where("PatientID").is(id).and("Name").is("血氧饱和度");
		return mongoTemplate.findOne(new Query(criatira).with(new Sort(new Order(Direction.DESC, "CaptureTime"))), PatientVitalSigns.class, "patientVitalSigns");

	}

}
