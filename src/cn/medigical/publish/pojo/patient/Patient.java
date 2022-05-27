package cn.medigical.publish.pojo.patient;


import java.util.Date;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by 2009/4/16.
 *
 * 病人信息
 */

public class Patient {
    /**病人姓名*/
    private String brxm ;
    /**住院号*/
//	@Field(value="zyh")
    private String zyh ;
	/**病人ID*/
//	@Field(value="patId")
	private String patId ;
    /**性别*/
    private String xb ;
    /**年龄*/
    private String nl ;
    /**年龄单位*/
    private String nldw ;
    /**住院房号*/
    private String zyfh ;
    /**住院床号*/
    private String zych ;
    /**科室编号*/
    private String ksbh ;
    /**科室名称*/
    private String ksmc ;
    /**血型*/
    private String xx ;
    /**身高*/
    private String sg ;
    /**体重*/
    private String tz ;
    /**过敏史*/
    private String gms ;
    /**病区编号*/
    private String bqbh ;
    /**病区名称*/
    private String bqmc ;
    /**医保类型*/
    private String yblx ;
    /**妊娠史*/
    private String rss ;
    /**患者状态*/
    @Field(value="status")
    private String status;
    /**出生日期*/
    private Date dob;
    /**住院次数 */
    private String zycs;
    /** 备注 */
    private String bz;
    /** 传染病*/
    private String crb;
    /** 感染类型 */
    private String grlx;

	private String ssdj;

	private StringProperty sqDoctor =new SimpleStringProperty("");
	private String pbMzfs;

	public String getSqDoctor() {
		return sqDoctor.get();
	}

	public StringProperty sqDoctorProperty() {
		if (sqDoctor == null){
			sqDoctor = new SimpleStringProperty();
		}
		return sqDoctor;
	}

	public void setSqDoctor(String sqDoctor) {
		this.sqDoctor.set(sqDoctor);
	}

	public String getSsdj() {
		return ssdj;
	}

	public void setSsdj(String ssdj) {
		this.ssdj = ssdj;
	}

	private Integer numAge = null; // > 1岁 ，必须填，用于统计
    
    private String socialId; // 身份证号

    private String ylf ;


	public String getBrxm() {

		return brxm;
	}

	public void setBrxm(String brxm) {
		this.brxm = brxm;
	}

	public String getZyh() {
		return zyh;
	}

	public void setZyh(String zyh) {
		this.zyh = zyh;
	}

	public String getPatId() {
		return patId;
	}

	public void setPatId(String patId) {
		this.patId = patId;
	}

	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public String getNl() {
		return nl;
	}

	public void setNl(String nl) {
		this.nl = nl;
	}

	public String getNldw() {
		return nldw;
	}

	public void setNldw(String nldw) {
		this.nldw = nldw;
	}

	public String getZyfh() {
		return zyfh;
	}

	public void setZyfh(String zyfh) {
		this.zyfh = zyfh;
	}

	public String getZych() {
		return zych;
	}

	public void setZych(String zych) {
		this.zych = zych;
	}

	public String getKsbh() {
		return ksbh;
	}

	public void setKsbh(String ksbh) {
		this.ksbh = ksbh;
	}

	public String getKsmc() {
		return ksmc;
	}

	public void setKsmc(String ksmc) {
		this.ksmc = ksmc;
	}

	public String getXx() {
		return xx;
	}

	public void setXx(String xx) {
		this.xx = xx;
	}

	public String getSg() {
		return sg;
	}

	public void setSg(String sg) {
		this.sg = sg;
	}

	public String getTz() {
		return tz;
	}

	public void setTz(String tz) {
		this.tz = tz;
	}

	public String getGms() {
		return gms;
	}

	public void setGms(String gms) {
		this.gms = gms;
	}

	public String getBqbh() {
		return bqbh;
	}

	public void setBqbh(String bqbh) {
		this.bqbh = bqbh;
	}

	public String getBqmc() {
		return bqmc;
	}

	public void setBqmc(String bqmc) {
		this.bqmc = bqmc;
	}

	public String getYblx() {
		return yblx;
	}

	public void setYblx(String yblx) {
		this.yblx = yblx;
	}

	public String getRss() {
		return rss;
	}

	public void setRss(String rss) {
		this.rss = rss;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getZycs() {
		return zycs;
	}

	public void setZycs(String zycs) {
		this.zycs = zycs;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getCrb() {
		return crb;
	}

	public void setCrb(String crb) {
		this.crb = crb;
	}

	public String getGrlx() {
		return grlx;
	}

	public void setGrlx(String grlx) {
		this.grlx = grlx;
	}

	public Integer getNumAge() {
		return numAge;
	}

	public void setNumAge(Integer numAge) {
		this.numAge = numAge;
	}

	public String getSocialId() {
		return socialId;
	}

	public void setSocialId(String socialId) {
		this.socialId = socialId;
	}

	public String getYlf() {
		return ylf;
	}

	public void setYlf(String ylf) {
		this.ylf = ylf;
	}


}
