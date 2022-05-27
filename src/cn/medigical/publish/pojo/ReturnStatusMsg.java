package cn.medigical.publish.pojo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.mapping.Field;

public class ReturnStatusMsg {
//	@Field(value="WorkId")
	private String workId;
//	@Field(value="Name")
	private String name;
//	@Field(value="ReturnTime")
	private Date returnTime;
//	@Field(value="DeptId")
	private String deptId;
//	@Field(value="DeptName")
	private String deptName;
	
	
	public String getDeptId() {
		return deptId;
	}
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}
	public String getWorkId() {
		return workId;
	}
	public void setWorkId(String workId) {
		this.workId = workId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
}
