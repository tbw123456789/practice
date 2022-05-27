package cn.medigical.publish.pojo.patientLink;

import org.springframework.data.mongodb.core.mapping.Field;


/**
 * Created by 2018-06-07.
 *
 */
public class Asa {
    /**级别*/
	@Field(value="level")
    private String level;
    /**是否急诊病人（yes代表是）*/
	@Field(value="jz")
    private Boolean jz ;
    /**是否择期病人（yes代表是）*/
	@Field(value="zq")
    private Boolean zq ;
	@Field
	private Boolean mz;

	public Boolean getMz() {
		return mz;
	}

	public void setMz(Boolean mz) {
		this.mz = mz;
	}

	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Boolean getJz() {
		return jz;
	}
	public void setJz(Boolean jz) {
		this.jz = jz;
	}
	public Boolean getZq() {
		return zq;
	}
	public void setZq(Boolean zq) {
		this.zq = zq;
	}
	
	
}
