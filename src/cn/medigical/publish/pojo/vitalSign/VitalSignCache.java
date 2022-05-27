package cn.medigical.publish.pojo.vitalSign;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by 2018/6/8.
 *
 */
@Document(collection="vitalSignCache")
public class VitalSignCache {
	
	private String id;
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
     * 手术间号
     */
    private String roomNo;
    /**
     * 编码
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 简称
     */
    private String simpleName;
    /**
     * 原始值
     */
    private String initValue;
    /**
     * 修改值
     */
    private String modValue;
    /**
     * 数据类型
     */
    private int dataType;
    /**
     * 小数位
     */
    private int decimal;
    /**
     * 单位名称
     */
    private String unitName;
    /**
     * 采集时间
     */
    private Date captureTime;

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

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

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getInitValue() {
        return initValue;
    }

    public void setInitValue(String initValue) {
        this.initValue = initValue;
    }

    public String getModValue() {
        return modValue;
    }

    public void setModValue(String modValue) {
        this.modValue = modValue;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public Date getCaptureTime() {
        return captureTime;
    }

    public void setCaptureTime(Date captureTime) {
        this.captureTime = captureTime;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public int getDecimal() {
        return decimal;
    }

    public void setDecimal(int decimal) {
        this.decimal = decimal;
    }
}
