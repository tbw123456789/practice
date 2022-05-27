package cn.medigical.publish.dao.impl.dictionary;



import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import cn.medigical.publish.dao.BaseDao;
import cn.medigical.publish.pojo.dictionary.ConfigVitalSigns;

import java.util.List;

@Service
public class ConfigVitalSignsDao extends BaseDao<ConfigVitalSigns> {

    public List<ConfigVitalSigns> getIsTrue() {
        Criteria criteria = getCriteria();
        criteria.and("Deleted").is(false);
        return find(criteria);
    }

    public List<ConfigVitalSigns> getIsFalse() {
        Criteria criteria = getCriteria();
        criteria.and("Deleted").is(true);
        return find(criteria);
    }

}
