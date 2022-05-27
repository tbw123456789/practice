package cn.medigical.publish.pojo.daPing;


import java.util.Date;

/**
 * Created by YY on 2017/12/9.
 */
public class Operation1 {
	private int pageNum;
	private int PageSize;
    private String flag; //"applied","inRoom","scheduled","outRoom","cancel"
    private String type; // "schedule" ,"urgent"
    private Date jhdate;   // 计划时间
    private String planTime;//时间
	private Date operDate;   // 手术开始时间
    private String openRoom;  // 手术间
    private String visitID;//  
    private String BEname;  // 病人名字
    private String sex;   //性别
    private String strAge;  //年龄
    private String keshi;  //科室
    private String bingshi; //病室
    private String shoushuName1;//手术名称
    private String operDoctor1;  //主刀医生
    private String mazuiMethod; //麻醉方式
    private String mazuiDoc1;//麻醉医生
    private String mechaNurse1; //护士
    private String zhuangtai; //状态
    private String maZuiType;//麻醉方式
    private String xhhs;//巡回护士
    private String xshs;//洗手护士
    
    
	public String getXhhs() {
		return xhhs;
	}
	public void setXhhs(String xhhs) {
		this.xhhs = xhhs;
	}
	public String getXshs() {
		return xshs;
	}
	public void setXshs(String xshs) {
		this.xshs = xshs;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getJhdate() {
		return jhdate;
	}
	public void setJhdate(Date jhdate) {
		this.jhdate = jhdate;
	}
	public String getPlanTime() {
		return planTime;
	}
	public void setPlanTime(String planTime) {
		this.planTime = planTime;
	}
	public Date getOperDate() {
		return operDate;
	}
	public void setOperDate(Date operDate) {
		this.operDate = operDate;
	}
	public String getOpenRoom() {
		return openRoom;
	}
	public void setOpenRoom(String openRoom) {
		this.openRoom = openRoom;
	}
	public String getVisitID() {
		return visitID;
	}
	public void setVisitID(String visitID) {
		this.visitID = visitID;
	}
	public String getBEname() {
		return BEname;
	}
	public void setBEname(String bEname) {
		BEname = bEname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getStrAge() {
		return strAge;
	}
	public void setStrAge(String strAge) {
		this.strAge = strAge;
	}
	public String getKeshi() {
		return keshi;
	}
	public void setKeshi(String keshi) {
		this.keshi = keshi;
	}
	public String getBingshi() {
		return bingshi;
	}
	public void setBingshi(String bingshi) {
		this.bingshi = bingshi;
	}
	public String getShoushuName1() {
		return shoushuName1;
	}
	public void setShoushuName1(String shoushuName1) {
		this.shoushuName1 = shoushuName1;
	}
	public String getOperDoctor1() {
		return operDoctor1;
	}
	public void setOperDoctor1(String operDoctor1) {
		this.operDoctor1 = operDoctor1;
	}
	public String getMazuiMethod() {
		return mazuiMethod;
	}
	public void setMazuiMethod(String mazuiMethod) {
		this.mazuiMethod = mazuiMethod;
	}
	public String getMazuiDoc1() {
		return mazuiDoc1;
	}
	public void setMazuiDoc1(String mazuiDoc1) {
		this.mazuiDoc1 = mazuiDoc1;
	}
	public String getMechaNurse1() {
		return mechaNurse1;
	}
	public void setMechaNurse1(String mechaNurse1) {
		this.mechaNurse1 = mechaNurse1;
	}
	public String getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	public String getMaZuiType() {
		return maZuiType;
	}
	public void setMaZuiType(String maZuiType) {
		this.maZuiType = maZuiType;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return PageSize;
	}
	public void setPageSize(int pageSize) {
		PageSize = pageSize;
	}

    
}
