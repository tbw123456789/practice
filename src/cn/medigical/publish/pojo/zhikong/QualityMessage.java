package cn.medigical.publish.pojo.zhikong;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="qualityMessage")
public class QualityMessage { 

	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private Date lastUpdateTime;
	
	private List<QualityStatistics> resultList=new ArrayList<QualityStatistics>();

	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public List<QualityStatistics> getResultList() {
		return resultList;
	}

	public void setResultList(List<QualityStatistics> resultList) {
		this.resultList = resultList;
	}
	
	
}
