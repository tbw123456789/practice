package cn.medigical.publish.dao;



import cn.medigical.publish.utils.MyObservable;
import com.mongodb.DB;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;




import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseDao<T> {
	@Autowired
	protected MongoTemplate mongoTemplate;
	Class<T> cls;
	public Map<T , MyObservable> myListenersMap = new HashMap<>();

	Logger logger;

	@SuppressWarnings("unchecked")
	public BaseDao() {
		logger = Logger.getLogger("BaseDao");
		java.lang.reflect.Type type = this.getClass().getGenericSuperclass();
		if (type instanceof sun.reflect.generics.reflectiveObjects.ParameterizedTypeImpl) {
			java.lang.reflect.Type trueType = ((java.lang.reflect.ParameterizedType) type).getActualTypeArguments()[0];
			this.cls = (Class<T>) trueType;
		}
	}

	protected DB getDb() {
		return (DB) mongoTemplate.getDb();
	}
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public List<T> getAll() {
		try {
			return (List<T>) mongoTemplate.findAll(cls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public T findById(String Id) {
		try {
			return mongoTemplate.findById(Id, cls);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal(e.getMessage(), e);
		}

		return null;
	}

	protected List<T> find(Criteria criteria) {
		try {
			return (List<T>) mongoTemplate.find(new Query(criteria), cls);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal(e.getMessage(), e);
		}
		return null;
	}

	protected List<T> find(Query query) {
		try {
			return mongoTemplate.find(query, cls);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal(e.getMessage(), e);
		}

		return null;

	}

	protected T findOne(Criteria criteria) {
		try {
			return mongoTemplate.findOne(new Query(criteria), cls);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal(e.getMessage(), e);
		}

		return null;
	}

	protected void insert(T t) {
		try {
			mongoTemplate.insert(t);
		} catch (Exception e) {
			e.printStackTrace();
			logger.fatal(e.getMessage(), e);
		}

		fireChanges(t);
	}

	public boolean save(T t) {
		try {
			mongoTemplate.save(t);
			fireChanges(t);
			return true;
		} catch (Exception ex) {
			try {
				ex.printStackTrace();
				logger.fatal(ex.getMessage(), ex);
			} catch (Exception ex2) {
				ex2.printStackTrace();
			}

			return false;
		}
	}
	//更新第一个所匹配的
	protected boolean updateFirst(Criteria criteria, Update update) {
		try {
			mongoTemplate.updateFirst(new Query(criteria), update, cls);
			return true;
		} catch (Exception ex) {
			try {
				ex.printStackTrace();
				logger.fatal(ex.getMessage(), ex);
			} catch (Exception ex2) {
			}

			return false;
		}
	}
	//更新所有匹配的
	protected boolean updateMulti(Criteria criteria, Update update) {
		try {
			mongoTemplate.updateMulti(new Query(criteria), update, cls);
			return true;
		} catch (Exception ex) {
			try {
				ex.printStackTrace();
				logger.fatal(ex.getMessage(), ex);
			} catch (Exception ex2) {
			}

			return false;
		}
	}
	//存在就更新，不存在就插入
	protected boolean updateInsert(Criteria criteria, Update update) {
		try {
			mongoTemplate.upsert(new Query(criteria), update, cls);
			return true;
		} catch (Exception ex) {
			try {
				ex.printStackTrace();
				logger.fatal(ex.getMessage(), ex);
			} catch (Exception ex2) {
			}

			return false;
		}
	}

	protected boolean findAndModify(Criteria criteria, Update update) {
		try {
			mongoTemplate.findAndModify(new Query(criteria), update, cls);
			return true;
		} catch (Exception ex) {
			try {
				ex.printStackTrace();
				logger.fatal(ex.getMessage(), ex);
			} catch (Exception ex2) {
			}

			return false;
		}
	}


	protected boolean remove(T t) {
		try {
			mongoTemplate.remove(t);
			fireChanges(t);
			return true;
		} catch (Exception ex) {
			try {
				ex.printStackTrace();
				logger.fatal(ex.getMessage(), ex);
			} catch (Exception ex2) {
			}

			return false;
		}
	}

	protected long count(Query query) {
		try {
			return mongoTemplate.count(query, cls);
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.fatal(ex.getMessage(), ex);
			return 0;
		}

	}

	// protected MongoDatabase getDb() {
	// try {
	// return mongoTemplate.getDb();
	// } catch (Exception ex) {
	// e.printStackTrace();logger.fatal(ex.getMessage(), ex);
	// return null;
	// }
	//
	// }

	protected Criteria getCriteria() {
		return Criteria.where("0").exists(false);
	}

	// protected MongoCollection<Document> getDBCollection(String collectionName) {
	// try {
	// return mongoTemplate.getCollection(collectionName);
	// } catch (Exception ex) {
	// e.printStackTrace();logger.fatal(ex.getMessage(), ex);
	// return null;
	// }
	// }

	// public void addListener(T t, Observer observer) {
	// MyObservable myObservable = myListenersMap.get(t);
	// if (null == myObservable) {
	// myObservable = new MyObservable();
	// myListenersMap.put(t, myObservable);
	// }
	//
	// myObservable.addObserver(observer);
	// }
	//
	protected void fireChanges(T t) {
		MyObservable myObservable = myListenersMap.get(t);
		if (null != myObservable) {
			myObservable.setChanged();
			myObservable.notifyObservers(t);
		}

	}

	public boolean addAll(List<T> list) {
		try {
			mongoTemplate.insertAll(list);
			
			return true;
		} catch (Exception ex) {
			try {
				ex.printStackTrace();
				logger.fatal(ex.getMessage(), ex);
			} catch (Exception ex2) {
			}

			return false;
		}
	}
	
}
