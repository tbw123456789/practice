package cn.medigical.publish.interfaces.his.hisLink;

import java.util.Date;

/**
 * 回传提供his数据实体类
 * @author bc_ouzm
 *
 */
public class StatustToHis {
	/**
	 *手术id
	 */
	private String operId;
	/**
	 * 手术执行状态
	 */
	private int status;
	/**
	 * 手术台次
	 */
	private int pbts;
	/**
	 * 手术预计开始时间
	 */
	private Date operPlanStartTime;
	/**
	 * 手术间
	 */
	private String operRoom;
	/**
	 * 主麻医师id
	 */
	private String anesDoctorId;
	/**
	 * 主麻医师名字
	 */
	private String anesDoctorName;
	/**
	 * 副麻医师Id
	 */
	private String anesDoctor1Id;
	/**
	 * 副麻医师名字
	 */
	private String anesDoctor1Name;
	/**
	 * 手术医师id
	 */
	private String operDoctorId;
	/**
	 * 手术医师名字
	 */
	private String operDoctorName;
	/**
	 * 手术第一助手id
	 */
	private String operDoctor1Id;
	/**
	 * 手术第一助手名字
	 */
	private String operDoctor1Name;
	/**
	 * 手术第二助手id
	 */
	private String operDoctor2Id;
	/**
	 * 手术第二助手名字
	 */
	private String operDoctor2Name;
	/**
	 * 取消原因
	 */
	private String cancelReason;
	/**
	 * 取消人id
	 */
	private String cancelPeopleId;
	/**
	 * 取消人名字
	 */
	private String cancelPeopleName;
	/**
	 * 手术开始时间
	 */
	private Date operStartTime;
	/**
	 * 手术结束时间
	 */
	private Date operEndTime;
	/**
	 * 手术名字
	 */
	private String operName;
	/**
	 * 麻醉开始时间
	 */
	private Date anesStartTime;
	/**
	 * 麻醉结束时间
	 */
	private Date anesEndTime;
	/**
	 * 麻醉方法
	 */
	private String anesMethod;
	/**
	 * 麻醉类别
	 */
	private String anesType;
	/**
	 * 手术切口 eg：Ⅰ~Ⅳ
	 */
	private String operQiekou;
	/**
	 * 手术切口部位
	 */
	private String qieKouBuwei;
	/**
	 * 手术类别（急诊，择期，限期）
	 */
	private String operType;
	/**
	 * asa分级
	 */
	private String asa;
	
	
	public String getOperId() {
		return operId;
	}
	public void setOperId(String operId) {
		this.operId = operId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getPbts() {
		return pbts;
	}
	public void setPbts(int pbts) {
		this.pbts = pbts;
	}
	public Date getOperPlanStartTime() {
		return operPlanStartTime;
	}
	public void setOperPlanStartTime(Date operPlanStartTime) {
		this.operPlanStartTime = operPlanStartTime;
	}
	public String getOperRoom() {
		return operRoom;
	}
	public void setOperRoom(String operRoom) {
		this.operRoom = operRoom;
	}
	public String getAnesDoctorId() {
		return anesDoctorId;
	}
	public void setAnesDoctorId(String anesDoctorId) {
		this.anesDoctorId = anesDoctorId;
	}
	public String getAnesDoctorName() {
		return anesDoctorName;
	}
	public void setAnesDoctorName(String anesDoctorName) {
		this.anesDoctorName = anesDoctorName;
	}
	public String getAnesDoctor1Id() {
		return anesDoctor1Id;
	}
	public void setAnesDoctor1Id(String anesDoctor1Id) {
		this.anesDoctor1Id = anesDoctor1Id;
	}
	public String getAnesDoctor1Name() {
		return anesDoctor1Name;
	}
	public void setAnesDoctor1Name(String anesDoctor1Name) {
		this.anesDoctor1Name = anesDoctor1Name;
	}
	public String getOperDoctorId() {
		return operDoctorId;
	}
	public void setOperDoctorId(String operDoctorId) {
		this.operDoctorId = operDoctorId;
	}
	public String getOperDoctorName() {
		return operDoctorName;
	}
	public void setOperDoctorName(String operDoctorName) {
		this.operDoctorName = operDoctorName;
	}
	public String getOperDoctor1Id() {
		return operDoctor1Id;
	}
	public void setOperDoctor1Id(String operDoctor1Id) {
		this.operDoctor1Id = operDoctor1Id;
	}
	public String getOperDoctor1Name() {
		return operDoctor1Name;
	}
	public void setOperDoctor1Name(String operDoctor1Name) {
		this.operDoctor1Name = operDoctor1Name;
	}
	public String getOperDoctor2Id() {
		return operDoctor2Id;
	}
	public void setOperDoctor2Id(String operDoctor2Id) {
		this.operDoctor2Id = operDoctor2Id;
	}
	public String getOperDoctor2Name() {
		return operDoctor2Name;
	}
	public void setOperDoctor2Name(String operDoctor2Name) {
		this.operDoctor2Name = operDoctor2Name;
	}
	public String getCancelReason() {
		return cancelReason;
	}
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
	public String getCancelPeopleId() {
		return cancelPeopleId;
	}
	public void setCancelPeopleId(String cancelPeopleId) {
		this.cancelPeopleId = cancelPeopleId;
	}
	public String getCancelPeopleName() {
		return cancelPeopleName;
	}
	public void setCancelPeopleName(String cancelPeopleName) {
		this.cancelPeopleName = cancelPeopleName;
	}
	public Date getOperStartTime() {
		return operStartTime;
	}
	public void setOperStartTime(Date operStartTime) {
		this.operStartTime = operStartTime;
	}
	public Date getOperEndTime() {
		return operEndTime;
	}
	public void setOperEndTime(Date operEndTime) {
		this.operEndTime = operEndTime;
	}
	public String getOperName() {
		return operName;
	}
	public void setOperName(String operName) {
		this.operName = operName;
	}
	public Date getAnesStartTime() {
		return anesStartTime;
	}
	public void setAnesStartTime(Date anesStartTime) {
		this.anesStartTime = anesStartTime;
	}
	public Date getAnesEndTime() {
		return anesEndTime;
	}
	public void setAnesEndTime(Date anesEndTime) {
		this.anesEndTime = anesEndTime;
	}
	public String getAnesMethod() {
		return anesMethod;
	}
	public void setAnesMethod(String anesMethod) {
		this.anesMethod = anesMethod;
	}
	public String getAnesType() {
		return anesType;
	}
	public void setAnesType(String anesType) {
		this.anesType = anesType;
	}
	public String getOperQiekou() {
		return operQiekou;
	}
	public void setOperQiekou(String operQiekou) {
		this.operQiekou = operQiekou;
	}
	public String getQieKouBuwei() {
		return qieKouBuwei;
	}
	public void setQieKouBuwei(String qieKouBuwei) {
		this.qieKouBuwei = qieKouBuwei;
	}
	public String getOperType() {
		return operType;
	}
	public void setOperType(String operType) {
		this.operType = operType;
	}
	public String getAsa() {
		return asa;
	}
	public void setAsa(String asa) {
		this.asa = asa;
	}
	
	
	
	
	
}
