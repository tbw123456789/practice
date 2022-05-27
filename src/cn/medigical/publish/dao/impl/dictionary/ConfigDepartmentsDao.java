package cn.medigical.publish.dao.impl.dictionary;

import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.utils.Constants;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import cn.medigical.publish.dao.BaseDao;
import cn.medigical.publish.pojo.dictionary.ConfigDepartments;

import java.lang.reflect.Field;
import java.util.List;


@Service
public class ConfigDepartmentsDao extends BaseDao<ConfigDepartments> {

    public  boolean remove_huifu(ConfigDepartments configDelivery) {
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
    public List<ConfigDepartments> getAll() {
        return super.getAll();
    }

    public List<ConfigDepartments> getIsTrue() {
        Criteria criteria = getCriteria();
        criteria.and("deleted").is(false);
        return find(criteria);
    }

    /**
     * 修改或者添加Account
     * @param configDepartments
     * @return
     */
    public boolean updateInsert(ConfigDepartments configDepartments) {
        Criteria criteria = getCriteria().and("_id").is(configDepartments.getId());
        try {
            return updateInsert(criteria,getConfigDepartmentsUpdate(configDepartments));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Update getConfigDepartmentsUpdate(ConfigDepartments configDepartments) throws IllegalAccessException {
        Class<?> accountCls = configDepartments.getClass();
        Field[] fields = accountCls.getDeclaredFields();
        Update update = new Update();
        for(Field field : fields){
            field.setAccessible(true);
            String fieldName = field.getName();
            if(!"id".equals(fieldName)) {
                update.set(fieldName, field.get(configDepartments));
            }
        }
        return update;
    }

    public List<ConfigDepartments> getIsFalse() {
        Criteria criteria = getCriteria();
        criteria.and("Deleted").is(true);
        return find(criteria);
    }

    public void del(ConfigDepartments configDepartments) {
        Criteria criteria = getCriteria().and("_id").is(configDepartments.getId());
        Update update = new Update().set("deleted", true);
        updateFirst(criteria, update);
    }

    public void undel(ConfigDepartments configDepartments) {
        Criteria criteria = getCriteria().and("_id").is(configDepartments.getId());
        Update update = new Update().set("deleted", false);
        updateFirst(criteria, update);
    }

    public  boolean remove(ConfigDepartments configDelivery) {
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

    public ConfigDepartments getNamebyId(String id) {
        Criteria criteria = Criteria.where("code").is(id);
        return findOne(criteria);
    }

    public boolean addOne(ConfigDepartments department) {
        save(department);
        return true;
    }


}
