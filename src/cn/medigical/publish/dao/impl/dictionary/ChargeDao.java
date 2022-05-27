package cn.medigical.publish.dao.impl.dictionary;


import cn.medigical.publish.dao.BaseDao;


import cn.medigical.publish.pojo.Charge;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ChargeDao extends BaseDao<Charge> {

    public List<Charge> getAll() {
        return super.getAll();
    }

    public Charge getOneChargeByShoufeiID(String id){
        Criteria criteria=Criteria.where("Shoufeiid").is(id);
        return findOne(criteria);
    }

    public Charge getOneChargeByName(String name){
        Criteria criteria=Criteria.where("Name").is(name);
        return findOne(criteria);
    }
    public boolean addUpdate(Charge charge) {
        return save(charge);
    }
}
