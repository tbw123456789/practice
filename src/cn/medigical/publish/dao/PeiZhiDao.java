package cn.medigical.publish.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import cn.medigical.publish.pojo.daPing.JiaShu;
import cn.medigical.publish.pojo.daPing.PaiBanTable;
import cn.medigical.publish.pojo.daPing.PeiZhi;
import cn.medigical.publish.utils.PropertyUtil;

@Service
public class PeiZhiDao extends BaseDao<PeiZhi>  {

	static final String DBName = PropertyUtil.getProperty("mongo.dbname");
	static final String ServerAddress = PropertyUtil.getProperty("mongo.host");
	static final int PORT = Integer.parseInt(PropertyUtil.getProperty("mongo.port"));
	static final String UserName = PropertyUtil.getProperty("mongo.username");
	static final String PassWord = PropertyUtil.getProperty("mongo.password");

	public void updateJiashu(JiaShu jiaShu) {
		MongoClient mongoClient =getMongoClient();
		DB db1 = mongoClient.getDB(DBName);
		//db1.addUser(UserName, PassWord.toCharArray());
		DBCollection dbcol = db1.getCollection("peiZhi");
		BasicDBObject odBdb = new BasicDBObject();
		BasicDBObject upbas = new BasicDBObject();
		upbas.put("jiaShu.shoushujian", jiaShu.isShoushujian());
		upbas.put("jiaShu.taishu", jiaShu.isTaishu());
		upbas.put("jiaShu.keshi", jiaShu.isKeshi());
		upbas.put("jiaShu.bingren", jiaShu.isBingren());
		upbas.put("jiaShu.shoushumingcheng", jiaShu.isShoushumingcheng());
		upbas.put("jiaShu.zhudaoyisheng", jiaShu.isZhudaoyisheng());
		upbas.put("jiaShu.mazuiyisheng", jiaShu.isMazuiyisheng());
		upbas.put("jiaShu.kaishishijian", jiaShu.isKaishishijian());
		upbas.put("jiaShu.zhuantai", jiaShu.isZhuantai());
		upbas.put("jiaShu.notice", jiaShu.getNotice());
		odBdb.put("$set", upbas);
		dbcol.update(new BasicDBObject(), odBdb, true, true);
		System.out.println("排班更新成功");

	}

	public void updatePaiban(PaiBanTable paiban) {
		MongoClient mongoClient = getMongoClient();
		DB db1 = mongoClient.getDB(DBName);
		DBCollection dbcol = db1.getCollection("peiZhi");
		BasicDBObject odBdb = new BasicDBObject();
		BasicDBObject upbas = new BasicDBObject();
		upbas.put("paiBanTable.shijian", paiban.isShijian());
		upbas.put("paiBanTable.shoushujian", paiban.isShoushujian());
		upbas.put("paiBanTable.zhuyuanhao", paiban.isZhuyuanhao());
		upbas.put("paiBanTable.xingming", paiban.isXingming());
		upbas.put("paiBanTable.xingbie", paiban.isXingbie());
		upbas.put("paiBanTable.nianling", paiban.isNianling());
		upbas.put("paiBanTable.bingshi", paiban.isBingshi());
		upbas.put("paiBanTable.shoushuneirong", paiban.isShoushuneirong());
		upbas.put("paiBanTable.shoushuzhe", paiban.isShoushuzhe());
		upbas.put("paiBanTable.mazuifangfa", paiban.isMazuifangfa());
		upbas.put("paiBanTable.mazuizhe", paiban.isMazuizhe());
		upbas.put("paiBanTable.hushi", paiban.isHushi());
		upbas.put("paiBanTable.huangtai", paiban.isHuangtai());
		upbas.put("paiBanTable.notice", paiban.getNotice());
		odBdb.put("$set", upbas);
		dbcol.update(new BasicDBObject(), odBdb, true, true);
		System.out.println("排班更新成功");

		// TODO Auto-generated method stub
	}

		public MongoClient getMongoClient() {
		MongoClient mongoClient = null;
		try {
			ServerAddress sainfo = new ServerAddress(ServerAddress, PORT);
			List<MongoCredential> mgauth = new ArrayList<>();
			mgauth.add(MongoCredential.createCredential(UserName, DBName, PassWord.toCharArray()));
			// 连接到 mongodb 服务
			mongoClient = new MongoClient(sainfo, mgauth);
			System.out.println("Connect to mongodb successfully");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return mongoClient;
	}
}
