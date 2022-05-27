package cn.medigical.publish.dao.impl.dictionary;




import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import cn.medigical.publish.dao.BaseDao;
import cn.medigical.publish.pojo.dictionary.ConfigEvents;

import java.util.List;

@Service
public class ConfigEventsDao extends BaseDao<ConfigEvents> {

    @Override
    public List<ConfigEvents> getAll() {
        return super.getAll();
    }

    public List<ConfigEvents> getIsTrue() {
        Criteria criteria = getCriteria();
        criteria.and("deleted").is(false);
        return find(criteria);
    }

    public ConfigEvents getName(String name) {
        Criteria criteria = getCriteria();
        criteria.and("name").is(name);
        Criteria criteria2 = getCriteria();
        criteria.and("deleted").is(false);
        Criteria criteria3 = criteria.andOperator(criteria2);
        return findOne(criteria3);
    }

    public ConfigEvents getIsCode(String code) {
        Criteria criteria = getCriteria();
        criteria.and("code").is(code);
        return findOne(criteria);
    }

    public List<ConfigEvents> getIsFalse() {
        Criteria criteria = getCriteria();
        criteria.and("deleted").is(true);
        return find(criteria);
    }

    @Override
    public  boolean remove(ConfigEvents configDelivery) {
        configDelivery.setDeleted(true);
        return super.save(configDelivery);
    }

    public  boolean remove_huifu(ConfigEvents configDelivery) {
        configDelivery.setDeleted(false);
        return super.save(configDelivery);
    }

    public Boolean getNameIsCu(String name) {
        Criteria criteria = getCriteria();
        criteria.and("name").is(name);
        Criteria criteria2 = getCriteria();
        criteria.and("deleted").is(false);
        Criteria criteria3 = criteria.andOperator(criteria2);
        List list = find(criteria3);
        Boolean b = find(criteria3).size() == 0 ? true : false;
        return find(criteria3).size() == 0 ? true : false;
    }

    public Boolean getCodeIsCu(String name) {
        Criteria criteria = getCriteria();
        criteria.and("code").is(name);
        Criteria criteria2 = getCriteria();
        criteria.and("deleted").is(false);
        Criteria criteria3 = criteria.andOperator(criteria2);
        List list = find(criteria3);
        Boolean b = find(criteria3).size() == 0 ? true : false;
        return find(criteria3).size() == 0 ? true : false;
    }
}
