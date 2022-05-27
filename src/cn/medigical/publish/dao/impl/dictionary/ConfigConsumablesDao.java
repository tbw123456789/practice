package cn.medigical.publish.dao.impl.dictionary;

import cn.medigical.publish.dao.BaseDao;
import cn.medigical.publish.pojo.dictionary.ConfigConsumables;
import org.springframework.stereotype.Service;

@Service
public class ConfigConsumablesDao extends BaseDao<ConfigConsumables> {

    public void addUpdate(ConfigConsumables account) {
        save(account);
    }
}
