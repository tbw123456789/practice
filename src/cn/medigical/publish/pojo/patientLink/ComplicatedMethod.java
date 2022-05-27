package cn.medigical.publish.pojo.patientLink;

import org.springframework.data.mongodb.core.mapping.Field;


/**
 * Created by 2018/5/12.
 *
 */

public class ComplicatedMethod {
    /** 全麻1 */
	@Field(value="Qm1")
    private Boolean qm1 = false;
    /** 全麻2 */
	@Field(value="Qm2")
    private Boolean qm2 = false;
    /** 全麻3 */
	@Field(value="Qm3")
    private Boolean qm3 = false;
    /** 全麻4 */
	@Field(value="Qm4")
    private Boolean qm4 = false;
    /** 椎麻 1 */
	@Field(value="Zm1")
    private Boolean zm1 = false;
    /** 椎麻 2 */
	@Field(value="Zm2")
    private Boolean zm2 = false;
    /** 椎麻 3 */
	@Field(value="Zm3")
    private Boolean zm3 = false;
    /** 椎麻 4 */
	@Field(value="Zm4")
    private Boolean zm4 = false;
	public Boolean getQm1() {
		return qm1;
	}
	public void setQm1(Boolean qm1) {
		this.qm1 = qm1;
	}
	public Boolean getQm2() {
		return qm2;
	}
	public void setQm2(Boolean qm2) {
		this.qm2 = qm2;
	}
	public Boolean getQm3() {
		return qm3;
	}
	public void setQm3(Boolean qm3) {
		this.qm3 = qm3;
	}
	public Boolean getQm4() {
		return qm4;
	}
	public void setQm4(Boolean qm4) {
		this.qm4 = qm4;
	}
	public Boolean getZm1() {
		return zm1;
	}
	public void setZm1(Boolean zm1) {
		this.zm1 = zm1;
	}
	public Boolean getZm2() {
		return zm2;
	}
	public void setZm2(Boolean zm2) {
		this.zm2 = zm2;
	}
	public Boolean getZm3() {
		return zm3;
	}
	public void setZm3(Boolean zm3) {
		this.zm3 = zm3;
	}
	public Boolean getZm4() {
		return zm4;
	}
	public void setZm4(Boolean zm4) {
		this.zm4 = zm4;
	}
	
	
	
}
