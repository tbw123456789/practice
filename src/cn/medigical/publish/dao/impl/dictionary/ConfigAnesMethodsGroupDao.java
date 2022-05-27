package cn.medigical.publish.dao.impl.dictionary;

import cn.medigical.publish.dao.BaseDao;
import cn.medigical.publish.pojo.dictionary.ConfigAnesMethodsGroup;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigAnesMethodsGroupDao extends BaseDao<ConfigAnesMethodsGroup> {

    public List<ConfigAnesMethodsGroup> getPatientEvents8PatientId(String patientID) {
        Criteria criteria = Criteria.where("patientID").is(patientID);
        return find(criteria);
    }
    public List<ConfigAnesMethodsGroup> getDateIsFalse() {
        Criteria criteria = Criteria.where("deleted").is(false);
        return find(criteria);
    }
}
