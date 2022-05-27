package cn.medigical.publish.dao.impl;

import cn.medigical.publish.dao.BaseDao;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.pojo.xiandaiyiyuan.RequestChargingData;
import cn.medigical.publish.utils.Constants;
import cn.medigical.publish.utils.MyDateFormat;
import org.apache.log4j.Logger;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by 2018/6/7.
 */
@Service
public class RequestChargingDataDao extends BaseDao<RequestChargingData> {

    public boolean saveRequestChargingData(RequestChargingData chargingData){
       return super.save(chargingData);
    }

    public RequestChargingData findByPlinkId(String pLinkId){
        Criteria criteria = new Criteria();
        criteria.orOperator(Criteria.where("pLinkId").is(pLinkId));
        return super.findOne(criteria);
    }

    public boolean remove(RequestChargingData chargingData){
        return super.remove(chargingData);
    }

}
