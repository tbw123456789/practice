package cn.medigical.publish.dao.impl.wjzyy;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import cn.medigical.publish.dao.BaseDao;
import cn.medigical.publish.pojo.Charge;
import cn.medigical.publish.pojo.wjzyy.HisAnesMethod;
@Service
public class HisAnesMethodDao extends BaseDao<HisAnesMethod>{

	 public List<HisAnesMethod> getAll() {
	        return super.getAll();
	    }
	 	
	    public boolean addUpdate(HisAnesMethod anesMethod) {
	        return save(anesMethod);
	    }
	    
	    public HisAnesMethod getAnesMethodByName(String name) {
	    	 Criteria criteria = getCriteria().and("Name").is(name);
	         return findOne(criteria);
		}
}
