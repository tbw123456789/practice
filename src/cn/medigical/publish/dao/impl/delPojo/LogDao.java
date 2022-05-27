package cn.medigical.publish.dao.impl.delPojo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import cn.medigical.publish.dao.BaseDao;
import cn.medigical.publish.pojo.delPojo.LogDBModel;
import cn.medigical.publish.pojo.wjzyy.HisAnesMethod;
import cn.medigical.publish.utils.DelDataRunning;

@Service
public class LogDao extends BaseDao<LogDBModel> {
	private Logger logger=Logger.getLogger(LogDao.class);
    /**
     * 
     * @param time 当前时间
     * @param days 时间段
     */
    public void delLogByTime(Date time,int days) {
    	Calendar calendar=Calendar.getInstance();
    	logger.info("日志删除周期:"+days);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	logger.info("当前时间："+sdf2.format(calendar.getTime()));
    	List<LogDBModel> list=getAll();
    	calendar.add(Calendar.DATE, -days);
    	Date delTime=calendar.getTime();
    	logger.info("日志删除截止时间："+sdf2.format(delTime));
    	logger.info("日志正在删除中······");
		for (LogDBModel log : list) {
			try {
				if (log.getCreateTime()==null) {
					remove(log);
				}
				else if (log.getCreateTime().getTime()<delTime.getTime()) {
//					logger.info("正在删除日志，该条日志创建时间为："+sdf2.format(log.getCreateTime()));
					remove(log);
				}
			} catch (Exception e) {
//				logger.info("正在删除日志，该条日志创建时间为："+sdf2.format(log.getCreateTime()));
				remove(log);
			}
			
		}
	}
}
