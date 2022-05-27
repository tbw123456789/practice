package cn.medigical.publish.dao.impl;

import cn.medigical.publish.dao.BaseDao;
import cn.medigical.publish.pojo.dictionary.ConfigHisConsumes;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConfigHisConsumesDao extends BaseDao<ConfigHisConsumes> {

    public  boolean remove_huifu(ConfigHisConsumes configDelivery) {
        configDelivery.deletedProperty().setValue(false);
        return super.save(configDelivery);
    }

    public boolean updateDrug(String drugCode, ConfigHisConsumes configHisDrugs){
        return findAndModify(new Criteria(drugCode), Update.update(drugCode,configHisDrugs));
    }

    public Boolean getCodeIsCu(String name) {
        Criteria criteria = getCriteria();
        criteria.and("consumeCode").is(name);
        Criteria criteria2 = getCriteria();
        criteria.and("deleted").is(false);
        Criteria criteria3 = criteria.andOperator(criteria2);
        return find(criteria3).size() == 0 ? true : false;
    }

    @Override
    public List<ConfigHisConsumes> getAll() {
        return super.getAll();
    }

    public List<ConfigHisConsumes> getIsTrue() {
        Criteria criteria = getCriteria();
        criteria.and("deleted").is(false);
        return find(criteria);
    }

    public List<ConfigHisConsumes> getIsFalse() {
        Criteria criteria = getCriteria();
        criteria.and("deleted").is(true);
        return find(criteria);
    }


    public ConfigHisConsumes getIsCode(String code) {
        Criteria criteria = getCriteria();
        criteria.and("consumeCode").is(code);
        return findOne(criteria);
    }

    @Override
    public  boolean remove(ConfigHisConsumes configDelivery) {
        configDelivery.deletedProperty().setValue(true);
        return super.save(configDelivery);
    }



    public Boolean getNameIsCu(String name) {
        Criteria criteria = getCriteria();
        criteria.and("consumeName").is(name);
        Criteria criteria2 = getCriteria();
        criteria.and("deleted").is(false);
        Criteria criteria3 = criteria.andOperator(criteria2);
        List list = find(criteria3);
        Boolean b = find(criteria3).size() == 0 ? true : false;
        return find(criteria3).size() == 0 ? true : false;
    }

}
