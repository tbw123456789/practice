package cn.medigical.publish.dao.impl.dictionary;


import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import cn.medigical.publish.dao.BaseDao;
import cn.medigical.publish.pojo.dictionary.ConfigDrugs;

import java.util.List;

@Service
public class ConfigDrugsDao extends BaseDao<ConfigDrugs> {

    public  boolean remove_huifu(ConfigDrugs configDelivery) {
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
    public void addUpdate(ConfigDrugs ConfigDrugs) {
        save(ConfigDrugs);
    }

    @Override
    public List<ConfigDrugs> getAll() {
        return super.getAll();
    }

    public List<ConfigDrugs> getIsTrue() {
        Criteria criteria = getCriteria();
        criteria.and("Deleted").is(false);
        return find(criteria);
    }
    public List<ConfigDrugs> getDrugsByNma(String name) {
        Criteria criteria = getCriteria();

        criteria.and("Deleted").is(false).and("Name").is(name);
        return find(criteria);
    }

    public ConfigDrugs getDrugsByCode(String id){
        Criteria criteria = getCriteria();
        criteria.and("id").is(id);
        return findOne(criteria.andOperator(new Criteria().and("Deleted").is(false)));
    }
    public List<ConfigDrugs> getIsFalse() {
        Criteria criteria = getCriteria();
        criteria.and("Deleted").is(true);
        return find(criteria);
    }


    public ConfigDrugs getIsCode(String code) {
        Criteria criteria = getCriteria();
        criteria.and("Code").is(code);
        return findOne(criteria);
    }

    @Override
    public  boolean remove(ConfigDrugs configDelivery) {
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
