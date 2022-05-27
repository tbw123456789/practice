package cn.medigical.publish.dao.impl.dictionary;




import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import cn.medigical.publish.dao.BaseDao;
import cn.medigical.publish.pojo.dictionary.ConfigUnitTypes;

import java.util.List;

@Service
public class ConfigUnitTypesDao extends BaseDao<ConfigUnitTypes> {
    public  boolean remove_huifu(ConfigUnitTypes configDelivery) {
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
    public List<ConfigUnitTypes> getAll() {
        return super.getAll();
    }

    public List<ConfigUnitTypes> getIsTrue() {
        Criteria criteria = getCriteria();
        criteria.and("Deleted").is(false);
        return find(criteria);
    }

    public ConfigUnitTypes getName(String name) {
        Criteria criteria = getCriteria();
        criteria.and("Name").is(name);
        Criteria criteria2 = getCriteria();
        criteria.and("Deleted").is(false);
        Criteria criteria3 = criteria.andOperator(criteria2);
        return findOne(criteria3);
    }
    public ConfigUnitTypes getIsCode(String code) {
        Criteria criteria = getCriteria();
        criteria.and("Code").is(code);
        return findOne(criteria);
    }
    public List<ConfigUnitTypes> getIsFalse() {
        Criteria criteria = getCriteria();
        criteria.and("Deleted").is(true);
        return find(criteria);
    }

    @Override
    public  boolean remove(ConfigUnitTypes configDelivery) {
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
}
