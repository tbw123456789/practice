package cn.medigical.publish.pojo.delPojo;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import cn.medigical.publish.pojo.patientLink.PatientLink;

@Document(collection="patintLinkCopy")
public class PatientLinkCopy {
	private String id;
	@Field( value="LastModifyTime")
	private Date lastModifyTime;
	
	
	
	public Date getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Date lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
}
