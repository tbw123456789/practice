package cn.medigical.publish.pojo.dictionary;

import java.util.Date;


/**

 */
public class ConfigDrugs {
    private String id;
    /**
     * 药物名称
     */
    private String Name;
    /**
     * 药物类别 对应DrugType的ID
     */
    private String PatientsId;//病人的本地id
    private String Specifications;//药品规格 一盒、一瓶等
    private String PackageUnit;//包装单位
    private String Place;//产地
    private String Manufacturer;//生产厂家
    private String ManufacturerCode;//生产厂家代码
    private String DoseUnit;//剂量单位
    private String SpecCount;//规格数量
    private String SpecUnit;//规格单位
    private int DrugShow;//类型  0：注射剂 1：乳剂 2：片剂 3：胶囊 4：溶液剂
    private Boolean IsLiquid;//固体、液体标记  False ：固体  True：液体
    private String DrugType;//如：抗生素、镇静药、麻醉剂等
    private Date InsertDate;//插入本地时间

    private String DrugTypeCode;
    /**
     * 药品分组 对应DrugGroupTypes的ID
     */
    private String DrugGroupTypeCode;
    /**
     * 处方名
     */
    private String PrescriptionTypeCode;


    private String PrescriptionName;
    /**
     * 处方类型 关联Prescriptions的id
     */
    /** 剂量 */
    private String Dose;
    /** 单位 关联units的id */
    private String UnitName;
    /** 规格 */
    private String Spec;
    /** 容器单位 关联Containers的id*/
    private String ContainerName;
    /** 用法 */
    private String Usage;
    private Integer Position;
    private Boolean Deleted;

    private String Code;
    /**
     * 药品大类（磐安）
     */
    private String DrugTypeForPanAn;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPatientsId() {
		return PatientsId;
	}
	public void setPatientsId(String patientsId) {
		PatientsId = patientsId;
	}
	public String getSpecifications() {
		return Specifications;
	}
	public void setSpecifications(String specifications) {
		Specifications = specifications;
	}
	public String getPackageUnit() {
		return PackageUnit;
	}
	public void setPackageUnit(String packageUnit) {
		PackageUnit = packageUnit;
	}
	public String getPlace() {
		return Place;
	}
	public void setPlace(String place) {
		Place = place;
	}
	public String getManufacturer() {
		return Manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		Manufacturer = manufacturer;
	}
	public String getManufacturerCode() {
		return ManufacturerCode;
	}
	public void setManufacturerCode(String manufacturerCode) {
		ManufacturerCode = manufacturerCode;
	}
	public String getDoseUnit() {
		return DoseUnit;
	}
	public void setDoseUnit(String doseUnit) {
		DoseUnit = doseUnit;
	}
	public String getSpecCount() {
		return SpecCount;
	}
	public void setSpecCount(String specCount) {
		SpecCount = specCount;
	}
	public String getSpecUnit() {
		return SpecUnit;
	}
	public void setSpecUnit(String specUnit) {
		SpecUnit = specUnit;
	}
	public int getDrugShow() {
		return DrugShow;
	}
	public void setDrugShow(int drugShow) {
		DrugShow = drugShow;
	}
	public Boolean getIsLiquid() {
		return IsLiquid;
	}
	public void setIsLiquid(Boolean isLiquid) {
		IsLiquid = isLiquid;
	}
	public String getDrugType() {
		return DrugType;
	}
	public void setDrugType(String drugType) {
		DrugType = drugType;
	}
	public Date getInsertDate() {
		return InsertDate;
	}
	public void setInsertDate(Date insertDate) {
		InsertDate = insertDate;
	}
	public String getDrugTypeCode() {
		return DrugTypeCode;
	}
	public void setDrugTypeCode(String drugTypeCode) {
		DrugTypeCode = drugTypeCode;
	}
	public String getDrugGroupTypeCode() {
		return DrugGroupTypeCode;
	}
	public void setDrugGroupTypeCode(String drugGroupTypeCode) {
		DrugGroupTypeCode = drugGroupTypeCode;
	}
	public String getPrescriptionTypeCode() {
		return PrescriptionTypeCode;
	}
	public void setPrescriptionTypeCode(String prescriptionTypeCode) {
		PrescriptionTypeCode = prescriptionTypeCode;
	}
	public String getPrescriptionName() {
		return PrescriptionName;
	}
	public void setPrescriptionName(String prescriptionName) {
		PrescriptionName = prescriptionName;
	}
	public String getDose() {
		return Dose;
	}
	public void setDose(String dose) {
		Dose = dose;
	}
	public String getUnitName() {
		return UnitName;
	}
	public void setUnitName(String unitName) {
		UnitName = unitName;
	}
	public String getSpec() {
		return Spec;
	}
	public void setSpec(String spec) {
		Spec = spec;
	}
	public String getContainerName() {
		return ContainerName;
	}
	public void setContainerName(String containerName) {
		ContainerName = containerName;
	}
	public String getUsage() {
		return Usage;
	}
	public void setUsage(String usage) {
		Usage = usage;
	}
	public Integer getPosition() {
		return Position;
	}
	public void setPosition(Integer position) {
		Position = position;
	}
	public Boolean getDeleted() {
		return Deleted;
	}
	public void setDeleted(Boolean deleted) {
		Deleted = deleted;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getDrugTypeForPanAn() {
		return DrugTypeForPanAn;
	}
	public void setDrugTypeForPanAn(String drugTypeForPanAn) {
		DrugTypeForPanAn = drugTypeForPanAn;
	}

    
}
