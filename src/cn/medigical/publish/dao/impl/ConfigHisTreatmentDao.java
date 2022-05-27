package cn.medigical.publish.dao.impl;

import cn.medigical.publish.dao.BaseDao;
import cn.medigical.publish.pojo.dictionary.ConfigHisTreatment;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConfigHisTreatmentDao extends BaseDao<ConfigHisTreatment> {

    public  boolean remove_huifu(ConfigHisTreatment configDelivery) {
        configDelivery.deletedProperty().setValue(false);
        return super.save(configDelivery);
    }

    public boolean updateDrug(String drugCode, ConfigHisTreatment configHisDrugs){
        return findAndModify(new Criteria(drugCode), Update.update(drugCode,configHisDrugs));
    }

    public Boolean getCodeIsCu(String name) {
        Criteria criteria = getCriteria();
        criteria.and("treatmentCode").is(name);
        Criteria criteria2 = getCriteria();
        criteria.and("deleted").is(false);
        Criteria criteria3 = criteria.andOperator(criteria2);
        return find(criteria3).size() == 0 ? true : false;
    }

    @Override
    public List<ConfigHisTreatment> getAll() {
        return super.getAll();
    }

    public List<ConfigHisTreatment> getIsTrue() {
        Criteria criteria = getCriteria();
        criteria.and("deleted").is(false);
        return find(criteria);
    }

    public List<ConfigHisTreatment> getIsFalse() {
        Criteria criteria = getCriteria();
        criteria.and("deleted").is(true);
        return find(criteria);
    }


    public ConfigHisTreatment getIsCode(String code) {
        Criteria criteria = getCriteria();
        criteria.and("treatmentCode").is(code);
        return findOne(criteria);
    }

    @Override
    public  boolean remove(ConfigHisTreatment configDelivery) {
        configDelivery.deletedProperty().setValue(true);
        return super.save(configDelivery);
    }



    public Boolean getNameIsCu(String name) {
        Criteria criteria = getCriteria();
        criteria.and("treatmentName").is(name);
        Criteria criteria2 = getCriteria();
        criteria.and("deleted").is(false);
        Criteria criteria3 = criteria.andOperator(criteria2);
        List list = find(criteria3);
        Boolean b = find(criteria3).size() == 0 ? true : false;
        return find(criteria3).size() == 0 ? true : false;
    }

}
