package cn.medigical.publish.pojo.patient;

import cn.medigical.publish.pojo.lis.JianYan;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

public class PatientLisData {
    private String id;
    /**
     * 病人ID 关联键
     */
    @Field(value="PatientID")
    private String patientID;
    /**
     * 病人住院号
     */
    private String Zyh;

    /**
     * 查询结果
     */
    private boolean Result;
    /**
     * 检验内容
     */
    private JianYan JianYan;

    /**
     * 更新时间
     */
    private Date BeginTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public String getZyh() {
		return Zyh;
	}

	public void setZyh(String zyh) {
		Zyh = zyh;
	}

	public boolean isResult() {
		return Result;
	}

	public void setResult(boolean result) {
		Result = result;
	}

	public JianYan getJianYan() {
		return JianYan;
	}

	public void setJianYan(JianYan jianYan) {
		JianYan = jianYan;
	}

	public Date getBeginTime() {
		return BeginTime;
	}

	public void setBeginTime(Date beginTime) {
		BeginTime = beginTime;
	}   
}
