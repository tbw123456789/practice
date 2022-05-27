package cn.medigical.publish.pojo.zjpa.account;



/**O
 * Created by 博创医疗 on 2015/3/19, 13:42.
 * Copy right by 博创医疗
 */
public class AccountHis {

    private String workID;//员工编号
    private String description;//描述
    private String address;//地址
    private String genderID;//性别代码
    private String IDCard;//身份证
    private String documentID;//证件类型代码
    private String documentDescription;//证件类型描述
    private String gender;//性别
    private String officeID;//科室id
    private String officeName = "";//科室名称
    private String inDate;
    private String outDate;
    private String dob;//出生日期
    private String role;//职务
    private String trueName;//员工姓名
    private String roleId;//职务代码
    private String phone;
    private String status;
    private String priorityNumber;//优先号

    @Override
    public String toString() {
        return "Account{" +
                "workID//员工编号='" + workID + '\'' +
                ", inDate='" + inDate + '\'' +
                ", outDate//离职时间='" + outDate + '\'' +
                ", IDCard//身份证='" + IDCard + '\'' +
                ", documentID//证件类型代码='" + documentID + '\'' +
                ", documentDescription//证件类型描述='" + documentDescription + '\'' +
                ", address//地址='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", status='" + status + '\'' +
                ", description//描述='" + description + '\'' +
                ", role//职务='" + role + '\'' +
                ", roleId='" + roleId + '\'' +
                ", trueName='" + trueName + '\'' +
                ", genderID//性别代码='" + genderID + '\'' +
                ", gender='" + gender + '\'' +
                ", dob//出生日期='" + dob + '\'' +
                ", officeID//科室id='" + officeID + '\'' +
                ", officeName//科室id='" + officeName + '\'' +
                ", priorityNumber/优先号='" + priorityNumber + '\'' +
                '}';
    }

    public String getWorkID() {
        return workID;
    }

    public void setWorkID(String workID) {
        this.workID = workID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGenderID() {
        return genderID;
    }

    public void setGenderID(String genderID) {
        this.genderID = genderID;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getDocumentID() {
        return documentID;
    }

    public void setDocumentID(String documentID) {
        this.documentID = documentID;
    }

    public String getDocumentDescription() {
        return documentDescription;
    }

    public void setDocumentDescription(String documentDescription) {
        this.documentDescription = documentDescription;
    }

    public String getPriorityNumber() {
        return priorityNumber;
    }

    public void setPriorityNumber(String priorityNumber) {
        this.priorityNumber = priorityNumber;
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

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getOutDate() {
        return outDate;
    }

    public void setOutDate(String outDate) {
        this.outDate = outDate;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
