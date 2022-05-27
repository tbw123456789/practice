package cn.medigical.publish.pojo.wjzyy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.mapping.Field;

public class HisAnesMethod {
	/**
	 * His麻醉方式Code
	 * */
	@Field(value="Code")
	private String code;
	/**
	 * His麻醉方式名称
	 * */
	@Field(value="Name")
	private String name;
	/**
	 * His麻醉方式单位
	 * */
	@Field(value="Unit")
	private String unit;
	/**
	 * His麻醉方式类型
	 * */
	@Field(value="Type")
	private String type;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
