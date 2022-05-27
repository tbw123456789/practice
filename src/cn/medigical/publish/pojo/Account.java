package cn.medigical.publish.pojo;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import cn.medigical.publish.utils.Constants;

import java.util.Date;

/**
 * Created by  on 2010/5/20, 13:42.
 * Copy right by
 */
@Document(collection="account")
public class Account {
	@Field(value="_id")
    private String id;
	@Field(value = "neiBuId")
	private String neiBuId;//职工唯一标识
	@Field(value="loginName")
    private String loginName;
//    @Field(value="WrkID")
    private String workID;
//	@Field(value = "TrueName")
	private String trueName;
	@Field(value = "hisID")
	private String hisID = null; // HIS那边的后台ID
	@Field(value = "gender")
	private String gender;
	@Field(value = "officeID")
	private String officeID;
	@Field(value = "officeName")
	private String officeName = "";
	@Field(value="dob")
    private Date dob;
	@Field(value = "role")
	private String role;//职务
	@Field(value = "title")
	private String title;//职称
	@Field(value="schoolLevel")
    private String schoolLevel;//学历
	@Field(value="inDate")
	private Date inDate;
	@Field(value = "outDate")
	private Date outDate;  //离职时间
	@Field(value = "pwd")
	private String pwd;
	@Field(value = "createTime")
	private Date createTime;
	@Field(value = "lastUpdateTime")
	private Date lastUpdateTime;
	@Field(value="status")
    private String status;
	@Field(value = "invalidDate")
	private Date invalidDate = null; // 无效时间
	@Field(value = "invalidReason")
	private String invalidReason = null; // 无效的原因，是本地删除，还是HIS那边?
	@Field(value = "canLogin")
	private Boolean canLogin = false;  // 不能登录，就是后台使用，例如手术医生
	@Field(value = "phone")
	private String phone;
	@Field(value = "latestSignedPic")
	private String latestSignedPic;
	@Field(value = "orLevel")
	private String orLevel;
	@Field(value = "roleId")
	private String roleId;
	@Field(value="zhiCheng")
    private String zhiCheng;
	public Account(String name){
		this.trueName=name;
	}
	public Account(){

	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNeiBuId() {
		return this.neiBuId;
	}
	public void setNeiBuId(String neiBuId) {
		this.neiBuId = neiBuId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getWorkID() {
		return workID;
	}
	public void setWorkID(String workID) {
		this.workID = workID;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	public String getHisID() {
		return hisID;
	}
	public void setHisID(String hisID) {
		this.hisID = hisID;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOfficeID() {
		return officeID;
	}
	public void setOfficeID(String officeID) {
		this.officeID = officeID;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSchoolLevel() {
		return schoolLevel;
	}
	public void setSchoolLevel(String schoolLevel) {
		this.schoolLevel = schoolLevel;
	}
	public Date getInDate() {
		return inDate;
	}
	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}
	public Date getOutDate() {
		return outDate;
	}
	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getInvalidDate() {
		return invalidDate;
	}
	public void setInvalidDate(Date invalidDate) {
		this.invalidDate = invalidDate;
	}
	public String getInvalidReason() {
		return invalidReason;
	}
	public void setInvalidReason(String invalidReason) {
		this.invalidReason = invalidReason;
	}
	public Boolean getCanLogin() {
		return canLogin;
	}
	public void setCanLogin(Boolean canLogin) {
		this.canLogin = canLogin;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLatestSignedPic() {
		return latestSignedPic;
	}
	public void setLatestSignedPic(String latestSignedPic) {
		this.latestSignedPic = latestSignedPic;
	}
	public String getOrLevel() {
		return orLevel;
	}
	public void setOrLevel(String orLevel) {
		this.orLevel = orLevel;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getZhiCheng() {
		return zhiCheng;
	}
	public void setZhiCheng(String zhiCheng) {
		this.zhiCheng = zhiCheng;
	}



}
