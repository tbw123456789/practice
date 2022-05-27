package cn.medigical.publish.pojo.patientLink;


import java.util.Date;

import cn.medigical.publish.pojo.Account;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by 2018/6/7.
 *
 * 排班信息
 */
@Document(collection="schedule")
public class Schedule {
	//private String Mazuidocname;

	/*****************************平台新增数据**********************************/
	/**
	 * 排班执行状态 IP-已申请未执行,CA-拒绝执行,SC-正在执行,CM-完全执行
	 */
	@Field(value="operStatu")
	private String operStatu;
	//his同步排班的状态
	@Field(value="syncStatu")
	private String syncStatu;

	/**排班手术间号*/
	@Field(value="pbssjh")
    private String Pbssjh ;
    private int pbtsInt = -1;
    /**排班手术间台数*/
	@Field(value="ts")
    private String Ts ;
    /**排班手术间台数*/
	@Field(value="pbts")
    private String Pbts;
	/**计划手术时间*/
	@Field(value="jhsssj")
    private Date Jhsssj;
	@Field(value="jhsssjs")
    private String Jhsssjs ;
    private String bznr = "";
    private String mzfs = "";
    private Account account;
    /**麻醉医生1编号*/
	@Field(value="mzysbh1")
    private String Mzysbh1 ;
    private String mzysbh1Name = "";
    /**麻醉医生2编号*/
	@Field(value="mzysbh2")
    private String Mzysbh2 ;
    private String mzysbh2Name = "";
    /**麻醉医生3编号*/
	@Field(value="mzysbh3")
    private String Mzysbh3 ;
	private String mzysbh3Name = "";
    /**巡回护士编号1*/
	@Field(value="xhhsbh1")
    private String Xhhsbh1 ;
    private String xhhsbh1Name = "";
    /**巡回护士编号2*/
	@Field(value="xhhsbh2")
    private String Xhhsbh2 ;
    /**巡回护士编号3*/
	@Field(value="xhhsbh3")
    private String Xhhsbh3 ;
    /**器械护士编号1*/
	@Field(value="qxhsbh1")
    private String Qxhsbh1 ;
    private String qxhsbh1Name = "";
    /**器械护士编号2*/
	@Field(value="qxhsbh2")
    private String Qxhsbh2 ;
    /**器械护士编号3*/
	@Field(value="qxhsbh3")
    private String Qxhsbh3 ;
    /**手术医生*/
	@Field(value="ssysbh")
    private String Ssysbh ;
    /**助理医生编号1*/
	@Field(value="zlysbh1")
    private String Zlysbh1 ;
    /**助理医生编号2*/
	@Field(value="zlysbh2")
    private String Zlysbh2 ;
    /**助理医生编号3*/
	@Field(value="zlysbh3")
    private String Zlysbh3 ;
	/**助理医生编号4*/
	@Field(value="zlysbh4")
	private String Zlysbh4 ;

	public String getOperStatu() {
		return operStatu;
	}

	public void setOperStatu(String operStatu) {
		this.operStatu = operStatu;
	}
	public String getSyncStatu() {
		return syncStatu;
	}

	public void setSyncStatu(String syncStatu) {
		this.syncStatu = syncStatu;
	}

	public String getZlysbh4() {
		return Zlysbh4;
	}

	public void setZlysbh4(String zlysbh4) {
		Zlysbh4 = zlysbh4;
	}

	public String getPbssjh() {
		if(Pbssjh==null){
			Pbssjh="";
		}
		return Pbssjh;

	}
	public void setPbssjh(String pbssjh) {
		Pbssjh = pbssjh;
	}
	public String getTs() {
		return Ts;
	}
	public void setTs(String ts) {
		Ts = ts;
	}
	public Date getJhsssj() {
		return Jhsssj;
	}
	public void setJhsssj(Date jhsssj) {
		Jhsssj = jhsssj;
	}
	public String getJhsssjs() {
		return Jhsssjs;
	}
	public void setJhsssjs(String jhsssjs) {
		Jhsssjs = jhsssjs;
	}
	public String getMzysbh1() {
		return Mzysbh1;
	}
	public void setMzysbh1(String mzysbh1) {
		Mzysbh1 = mzysbh1;
	}
	public String getMzysbh2() {
		return Mzysbh2;
	}
	public void setMzysbh2(String mzysbh2) {
		Mzysbh2 = mzysbh2;
	}
	public String getMzysbh3() {
		return Mzysbh3;
	}
	public void setMzysbh3(String mzysbh3) {
		Mzysbh3 = mzysbh3;
	}
	public String getXhhsbh1() {
		return Xhhsbh1;
	}
	public void setXhhsbh1(String xhhsbh1) {
		Xhhsbh1 = xhhsbh1;
	}
	public String getXhhsbh2() {
		return Xhhsbh2;
	}
	public void setXhhsbh2(String xhhsbh2) {
		Xhhsbh2 = xhhsbh2;
	}
	public String getXhhsbh3() {
		return Xhhsbh3;
	}
	public void setXhhsbh3(String xhhsbh3) {
		Xhhsbh3 = xhhsbh3;
	}
	public String getQxhsbh1() {
		return Qxhsbh1;
	}
	public void setQxhsbh1(String qxhsbh1) {
		Qxhsbh1 = qxhsbh1;
	}
	public String getQxhsbh2() {
		return Qxhsbh2;
	}
	public void setQxhsbh2(String qxhsbh2) {
		Qxhsbh2 = qxhsbh2;
	}
	public String getQxhsbh3() {
		return Qxhsbh3;
	}
	public void setQxhsbh3(String qxhsbh3) {
		Qxhsbh3 = qxhsbh3;
	}
	public String getSsysbh() {
		return Ssysbh;
	}
	public void setSsysbh(String ssysbh) {
		Ssysbh = ssysbh;
	}
	public String getZlysbh1() {
		return Zlysbh1;
	}
	public void setZlysbh1(String zlysbh1) {
		Zlysbh1 = zlysbh1;
	}
	public String getZlysbh2() {
		return Zlysbh2;
	}
	public String getPbts() {
		return Pbts;
	}
	public void setPbts(String pbts) {
		Pbts = pbts;
	}
	public void setZlysbh2(String zlysbh2) {
		Zlysbh2 = zlysbh2;
	}
	public String getZlysbh3() {
		return Zlysbh3;
	}
	public void setZlysbh3(String zlysbh3) {
		Zlysbh3 = zlysbh3;
	}
	public int getPbtsInt() {
		return pbtsInt;
	}
	public void setPbtsInt(int pbtsInt) {
		this.pbtsInt = pbtsInt;
	}
	public String getBznr() {
		return bznr;
	}
	public void setBznr(String bznr) {
		this.bznr = bznr;
	}
	public String getMzfs() {
		return mzfs;
	}
	public void setMzfs(String mzfs) {
		this.mzfs = mzfs;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getMzysbh1Name() {
		return mzysbh1Name;
	}
	public void setMzysbh1Name(String mzysbh1Name) {
		this.mzysbh1Name = mzysbh1Name;
	}
	public String getMzysbh2Name() {
		return mzysbh2Name;
	}
	public void setMzysbh2Name(String mzysbh2Name) {
		this.mzysbh2Name = mzysbh2Name;
	}
	public String getXhhsbh1Name() {
		return xhhsbh1Name;
	}
	public void setXhhsbh1Name(String xhhsbh1Name) {
		this.xhhsbh1Name = xhhsbh1Name;
	}
	public String getQxhsbh1Name() {
		return qxhsbh1Name;
	}
	public void setQxhsbh1Name(String qxhsbh1Name) {
		this.qxhsbh1Name = qxhsbh1Name;
	}

	public String getMzysbh3Name() {
		return mzysbh3Name;
	}

	public void setMzysbh3Name(String mzysbh3Name) {
		this.mzysbh3Name = mzysbh3Name;
	}
}
