package cn.medigical.publish.pojo.patientLink;


import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by 2018-06-07.
 *
 */
@Document(collection="application")
public class Application {

	/*****************************平台新增数据**********************************/
	/**
	 * 手术申请状态 IP-已申请未执行,CA-拒绝执行,SC-正在执行,CM-完全执行
	 */
	private String operStatu;
	/**
	 * 执行手术科室编码
	 */
	private String operDeptCode;
	/**
	 * 执行手术科室名称
	 */
	private String operDeptName;
	/*************************************************************************/
    /**手术类型 急诊，择期*/
	@Field(value="type")
   private String type;
   /**手术申请单号*/
   @Field(value="sssqdh")
   private String sssqdh ;
    /**预约手术时间*/
	@Field(value="yysssj")
    private Date yysssj = null;
	@Field(value="yysssjString")
    private String yysssjString;

	/**手术申请时间*/
	@Field(value="sssqsj")
	private Date sssqsj = null;
	/**申请科室名称*/
	@Field(value="sqksmc")
    private String sqksmc ;
    /**申请科室编号*/
	@Field(value="sqksbh")
    private String sqksbh ;
    /**申请医生编号*/
	@Field(value="sqysbh")
    private String sqysbh ;
    /**拟施手术名称*/
	@Field(value="nsssmc")
    private String nsssmc ;
    /**拟施手术名称1*/
	@Field(value="nsssmc1")
    private String nsssmc1 ;
    /**拟施手术名称2*/
	@Field(value="nsssmc2")
    private String nsssmc2 ;
    /**拟施手术名称3*/
	@Field(value="nsssmc3")
    private String nsssmc3 ;
    /**拟施手术名称4*/
	@Field(value="nsssmc4")
    private String nsssmc4 ;
    /**拟施手术名称5*/
	@Field(value="nsssmc5")
    private String nsssmc5 ;
    /**手术级别ASA*/
	@Field(value="asa")
    private String asa ;
    /**术前诊断1*/
	@Field(value="sqzd1")
    private String sqzd1 ;
    /**术前诊断2*/
	@Field(value="sqzd2")
    private String sqzd2 ;
    /**术前诊断3*/
	@Field(value="sqzd3")
    private String sqzd3 ;
    /**术前诊断4*/
	@Field(value="sqzd4")
    private String sqzd4 ;
    /**术前诊断5*/
	@Field(value="sqzd5")
    private String sqzd5 ;
    /**术前诊断6*/
	@Field(value="sqzd6")
    private String sqzd6 ;
    /**手术医生编号*/
	@Field(value="ssysbh")
    private String ssysbh ;
    /**手术医生姓名*/
	@Field(value="ssysxm")
    private String ssysxm ;
    /**助理医生编号1*/
	@Field(value="zlysbh1")
    private String zlysbh1 ;
    /**助理医生编号2*/
	@Field(value="zlysbh2")
    private String zlysbh2 ;
    /**助理医生编号3*/
	@Field(value="zlysbh3")
    private String zlysbh3 ;

    /**麻醉方式*/
	@Field(value="mzfs")
    private String mzfs ;
    /**切口类型*/
	@Field(value="qklx")
    private String qklx ;
    /**麻醉类别*/
	@Field(value="mzlb")
    private String mzlb ;
    /**手术状态*/
	@Field(value="status")
    private String status ;
    /**明细状态*/
    @Field(value="detailstatus")
    private String detailstatus ;
    /**感染类型*/
	@Field(value="grlx")
    private String Grlx=null;
    /**特殊准备*/
	@Field(value="tszb")
    private String Tszb=null;

    /**HIV*/
	@Field(value="hiv")
    private Boolean hiv;
    /**HBV*/
	@Field(value="hbv")
    private Boolean hbv;
    /**HCV*/
	@Field(value="hcv")
    private Boolean hcv;
    /**梅毒*/
	@Field(value="md")
    private Boolean md;
    /**HbsAg*/
	@Field(value="hbsag")
    private Boolean hbsag;
    /**气性环疽*/
	@Field(value="qxxh")
    private Boolean qxxh;
    /**绿农杆菌*/
	@Field(value="lngj")
    private Boolean lngj;
    /**阮毒体感染*/
	@Field(value="rdtgr")
    private Boolean rdtgr;
	@Field(value="tsgr")

	private Boolean tsgr;
    /**术中冰冻*/
	@Field(value="szbd")
    private Boolean szbd;
    /**石蜡病理*/
	@Field(value="slbl")
    private Boolean slbl;
    /**术中C臂*/
	@Field(value="szcb")
    private Boolean szcb;

	/** 主诉 */
	@Field(value="zhushu")
	private String zhushu ;
	/** 手术优先级 */
	@Field(value="priory")
	private String priory ;
	/**
	 * 手术等级
	 */
	@Field(value="operLevel")
	private String operLevel;
	@Field(value="vip")
	private String vip;
	@Field(value="zyfs")
	private String zyfs;
	@Field(value="kss")
	private String kss;

	public Boolean getTsgr() {
		return tsgr;
	}

	public void setTsgr(Boolean tsgr) {
		this.tsgr = tsgr;
	}

	public String getKss() {
		return kss;
	}

	public void setKss(String kss) {
		this.kss = kss;
	}

	public String getZyfs() {
		return zyfs;
	}

	public void setZyfs(String zyfs) {
		this.zyfs = zyfs;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSssqdh() {
		return sssqdh;
	}

	public void setSssqdh(String sssqdh) {
		this.sssqdh = sssqdh;
	}

	public Date getYysssj() {
		return yysssj;
	}

	public void setYysssj(Date yysssj) {
		this.yysssj = yysssj;
	}

	public String getYysssjString() {
		return yysssjString;
	}

	public void setYysssjString(String yysssjString) {
		this.yysssjString = yysssjString;
	}

	public Date getSssqsj() {
		return sssqsj;
	}

	public void setSssqsj(Date sssqsj) {
		this.sssqsj = sssqsj;
	}

	public String getSqksmc() {
		return sqksmc;
	}

	public void setSqksmc(String sqksmc) {
		this.sqksmc = sqksmc;
	}

	public String getSqksbh() {
		return sqksbh;
	}

	public void setSqksbh(String sqksbh) {
		this.sqksbh = sqksbh;
	}

	public String getSqysbh() {
		return sqysbh;
	}

	public void setSqysbh(String sqysbh) {
		this.sqysbh = sqysbh;
	}

	public String getNsssmc() {
		return nsssmc;
	}

	public void setNsssmc(String nsssmc) {
		this.nsssmc = nsssmc;
	}

	public String getNsssmc1() {
		return nsssmc1;
	}

	public void setNsssmc1(String nsssmc1) {
		this.nsssmc1 = nsssmc1;
	}

	public String getNsssmc2() {
		return nsssmc2;
	}

	public void setNsssmc2(String nsssmc2) {
		this.nsssmc2 = nsssmc2;
	}

	public String getNsssmc3() {
		return nsssmc3;
	}

	public void setNsssmc3(String nsssmc3) {
		this.nsssmc3 = nsssmc3;
	}

	public String getNsssmc4() {
		return nsssmc4;
	}

	public void setNsssmc4(String nsssmc4) {
		this.nsssmc4 = nsssmc4;
	}

	public String getNsssmc5() {
		return nsssmc5;
	}

	public void setNsssmc5(String nsssmc5) {
		this.nsssmc5 = nsssmc5;
	}

	public String getAsa() {
		return asa;
	}

	public void setAsa(String asa) {
		this.asa = asa;
	}

	public String getSqzd1() {
		return sqzd1;
	}

	public void setSqzd1(String sqzd1) {
		this.sqzd1 = sqzd1;
	}

	public String getSqzd2() {
		return sqzd2;
	}

	public void setSqzd2(String sqzd2) {
		this.sqzd2 = sqzd2;
	}

	public String getSqzd3() {
		return sqzd3;
	}

	public void setSqzd3(String sqzd3) {
		this.sqzd3 = sqzd3;
	}

	public String getSqzd4() {
		return sqzd4;
	}

	public void setSqzd4(String sqzd4) {
		this.sqzd4 = sqzd4;
	}

	public String getSqzd5() {
		return sqzd5;
	}

	public void setSqzd5(String sqzd5) {
		this.sqzd5 = sqzd5;
	}

	public String getSqzd6() {
		return sqzd6;
	}

	public void setSqzd6(String sqzd6) {
		this.sqzd6 = sqzd6;
	}

	public String getSsysbh() {
		return ssysbh;
	}

	public void setSsysbh(String ssysbh) {
		this.ssysbh = ssysbh;
	}

	public String getSsysxm() {
		return ssysxm;
	}

	public void setSsysxm(String ssysxm) {
		this.ssysxm = ssysxm;
	}

	public String getZlysbh1() {
		return zlysbh1;
	}

	public void setZlysbh1(String zlysbh1) {
		this.zlysbh1 = zlysbh1;
	}

	public String getZlysbh2() {
		return zlysbh2;
	}

	public void setZlysbh2(String zlysbh2) {
		this.zlysbh2 = zlysbh2;
	}

	public String getZlysbh3() {
		return zlysbh3;
	}

	public void setZlysbh3(String zlysbh3) {
		this.zlysbh3 = zlysbh3;
	}

	public String getMzfs() {
		return mzfs;
	}

	public void setMzfs(String mzfs) {
		this.mzfs = mzfs;
	}

	public String getQklx() {
		return qklx;
	}

	public void setQklx(String qklx) {
		this.qklx = qklx;
	}

	public String getMzlb() {
		return mzlb;
	}

	public void setMzlb(String mzlb) {
		this.mzlb = mzlb;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDetailstatus() {
		return detailstatus;
	}
	public void setDetailstatus(String detailstatus) {
		this.detailstatus = detailstatus;
	}
	public String getGrlx() {
		return Grlx;
	}
	public void setGrlx(String grlx) {
		Grlx = grlx;
	}
	public String getTszb() {
		return Tszb;
	}
	public void setTszb(String tszb) {
		Tszb = tszb;
	}

	public String getOperStatu() {
		return operStatu;
	}

	public void setOperStatu(String operStatu) {
		this.operStatu = operStatu;
	}

	public String getOperDeptCode() {
		return operDeptCode;
	}

	public void setOperDeptCode(String operDeptCode) {
		this.operDeptCode = operDeptCode;
	}

	public String getOperDeptName() {
		return operDeptName;
	}

	public void setOperDeptName(String operDeptName) {
		this.operDeptName = operDeptName;
	}

	public Boolean getHiv() {
		return hiv;
	}

	public void setHiv(Boolean hiv) {
		this.hiv = hiv;
	}

	public Boolean getHbv() {
		return hbv;
	}

	public void setHbv(Boolean hbv) {
		this.hbv = hbv;
	}

	public Boolean getHcv() {
		return hcv;
	}

	public void setHcv(Boolean hcv) {
		this.hcv = hcv;
	}

	public Boolean getMd() {
		return md;
	}

	public void setMd(Boolean md) {
		this.md = md;
	}

	public Boolean getHbsag() {
		return hbsag;
	}

	public void setHbsag(Boolean hbsag) {
		this.hbsag = hbsag;
	}

	public Boolean getQxxh() {
		return qxxh;
	}

	public void setQxxh(Boolean qxxh) {
		this.qxxh = qxxh;
	}

	public Boolean getLngj() {
		return lngj;
	}

	public void setLngj(Boolean lngj) {
		this.lngj = lngj;
	}

	public Boolean getRdtgr() {
		return rdtgr;
	}

	public void setRdtgr(Boolean rdtgr) {
		this.rdtgr = rdtgr;
	}

	public Boolean getSzbd() {
		return szbd;
	}

	public void setSzbd(Boolean szbd) {
		this.szbd = szbd;
	}

	public Boolean getSlbl() {
		return slbl;
	}

	public void setSlbl(Boolean slbl) {
		this.slbl = slbl;
	}

	public Boolean getSzcb() {
		return szcb;
	}

	public void setSzcb(Boolean szcb) {
		this.szcb = szcb;
	}

	public String getZhushu() {
		return zhushu;
	}

	public void setZhushu(String zhushu) {
		this.zhushu = zhushu;
	}

	public String getPriory() {
		return priory;
	}

	public void setPriory(String priory) {
		this.priory = priory;
	}

	public String getOperLevel() {
		return operLevel;
	}

	public void setOperLevel(String operLevel) {
		this.operLevel = operLevel;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}
}
