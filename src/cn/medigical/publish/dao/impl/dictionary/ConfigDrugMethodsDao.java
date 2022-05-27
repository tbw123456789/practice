package cn.medigical.publish.dao.impl.dictionary;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import cn.medigical.publish.dao.BaseDao;
import cn.medigical.publish.pojo.dictionary.ConfigDrugMethods;

import java.util.List;

@Service
public class ConfigDrugMethodsDao extends BaseDao<ConfigDrugMethods> {
    public  boolean remove_huifu(ConfigDrugMethods configDelivery) {
        configDelivery.setDeleted(false);
        return super.save(configDelivery);
    }

    public Boolean getCodeIsCu(String name) {
        Criteria criteria = getCriteria();
        criteria.and("Code").is(name);
        Criteria criteria2 = getCriteria();
        criteria.and("Deleted").is(false);
        Criteria criteria3 = criteria.andOperator(criteria2);
        List list = find(criteria3);
        Boolean b = find(criteria3).size() == 0 ? true : false;
        return find(criteria3).size() == 0 ? true : false;
    }
    @Override
    public List<ConfigDrugMethods> getAll() {
        return super.getAll();
    }

    public List<ConfigDrugMethods> getIsTrue() {
        Criteria criteria = getCriteria();
        criteria.and("Deleted").is(false);
        return find(criteria);
    }

    public List<ConfigDrugMethods> getIsFalse() {
        Criteria criteria = getCriteria();
        criteria.and("Deleted").is(true);
        return find(criteria);
    }

    @Override
    public  boolean remove(ConfigDrugMethods configDelivery) {
        configDelivery.setDeleted(true);
        return super.save(configDelivery);
    }

    public Boolean getNameIsCu(String name) {
        Criteria criteria = getCriteria();
        criteria.and("Name").is(name);
        Criteria criteria2 = getCriteria();
        criteria.and("Deleted").is(false);
        Criteria criteria3 = criteria.andOperator(criteria2);
        List list = find(criteria3);
        Boolean b = find(criteria3).size() == 0 ? true : false;
        return find(criteria3).size() == 0 ? true : false;
    }

    public ConfigDrugMethods getName(String name) {
        Criteria criteria = getCriteria();
        criteria.and("Name").is(name);
        Criteria criteria2 = getCriteria();
        criteria.and("Deleted").is(false);
        Criteria criteria3 = criteria.andOperator(criteria2);
        return findOne(criteria3);
    }
    public ConfigDrugMethods getIsCode(String code) {
        Criteria criteria = getCriteria();
        criteria.and("Code").is(code);
        return findOne(criteria);
    }

}
