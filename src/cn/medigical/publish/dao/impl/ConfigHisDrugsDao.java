package cn.medigical.publish.dao.impl;

import cn.medigical.publish.dao.BaseDao;
import cn.medigical.publish.pojo.dictionary.ConfigHisDrugs;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConfigHisDrugsDao extends BaseDao<ConfigHisDrugs> {

    public  boolean remove_huifu(ConfigHisDrugs configDelivery) {
        configDelivery.deletedProperty().setValue(false);
        return super.save(configDelivery);
    }

    public boolean updateDrug(String drugCode, ConfigHisDrugs configHisDrugs){
        return findAndModify(new Criteria(drugCode), Update.update(drugCode,configHisDrugs));
    }

    public Boolean getCodeIsCu(String name) {
        Criteria criteria = getCriteria();
        criteria.and("drugCode").is(name);
        Criteria criteria2 = getCriteria();
        criteria.and("deleted").is(false);
        Criteria criteria3 = criteria.andOperator(criteria2);
        return find(criteria3).size() == 0 ? true : false;
    }

    @Override
    public List<ConfigHisDrugs> getAll() {
        return super.getAll();
    }

    public List<ConfigHisDrugs> getIsTrue() {
        Criteria criteria = getCriteria();
        criteria.and("deleted").is(false);
        return find(criteria);
    }

    public List<ConfigHisDrugs> getIsFalse() {
        Criteria criteria = getCriteria();
        criteria.and("deleted").is(true);
        return find(criteria);
    }

    public List<ConfigHisDrugs> getTypeNameByCode(String type) {
        Criteria criteria = getCriteria();
        criteria.and("drugGroupTypeCode").is(type);
        Criteria criteria2 = getCriteria();
        criteria.and("deleted").is(false);
        Criteria criteria3 = criteria.andOperator(criteria2);
        return find(criteria3);
    }

    public ConfigHisDrugs getIsCode(String code) {
        Criteria criteria = getCriteria();
        criteria.and("drugCode").is(code);
        return findOne(criteria);
    }

    @Override
    public  boolean remove(ConfigHisDrugs configDelivery) {
        configDelivery.deletedProperty().setValue(true);
        return super.save(configDelivery);
    }



    public Boolean getNameIsCu(String name) {
        Criteria criteria = getCriteria();
        criteria.and("drugName").is(name);
        Criteria criteria2 = getCriteria();
        criteria.and("deleted").is(false);
        Criteria criteria3 = criteria.andOperator(criteria2);
        List list = find(criteria3);
        Boolean b = find(criteria3).size() == 0 ? true : false;
        return find(criteria3).size() == 0 ? true : false;
    }

}
