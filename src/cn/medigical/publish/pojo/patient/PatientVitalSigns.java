package cn.medigical.publish.pojo.patient;


import java.util.Date;

public class PatientVitalSigns {
    private String id;
    private String patientID;
    /**
     * 体征编码
     */
    private String code;
    /**
     * 体征简称
     */
    private String simpleName;
    /**
     * 体征名称
     */
    private String name;
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

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModValue() {
		return modValue;
	}

	public void setModValue(String modValue) {
		this.modValue = modValue;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
