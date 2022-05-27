package cn.medigical.publish.pojo.patient;

import cn.medigical.publish.pojo.patient.drug.DrugSpeed;
import cn.medigical.publish.pojo.patient.drug.Drugs;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class PatientDrugs {
    private String id;
    /**
     * 病人ID 关联键
     */
    private String patientID;
    /**
     * 用药详情
     */
    private Drugs drugs;
    /**
     * 用药速度
     */
    private List<DrugSpeed> drugSpeeds;
    /**
     * 开始时间
     */
    private Date beginTime;
    /**
     * 结束时间
     */
    private Date endTime;
    /**
     * 用药理由
     */
    private String drugReason;
    /**
     * 给药方法
     */
    private String drugMethod;
    /**
     * 单次用药还是持续用药
     */
    private boolean single;
    /**
     * 类型
     */
    private String type;
    /**
     * 是否带走
     */
    private boolean takeOut;
    /**
     * 通道
     */
    private String chanel;
    /**
     * 液体类型
     */
    private String liquidType;
    /**
     * 总量
     */
    private float totalAmount;

    /**
     * 总量
     */
    private String totalAmount1;

    /**
     * 总量单位
     */
    private String totalAmountUnit;
    //带走量
    private String dzl;

    private Date inputTime;

    public boolean isTakeOut() {
        return takeOut;
    }

    public void setTakeOut(boolean takeOut) {
        this.takeOut = takeOut;
    }

    public String getChanel() {
        return chanel;
    }

    public void setChanel(String chanel) {
        this.chanel = chanel;
    }

    public String getLiquidType() {
        return liquidType;
    }

    public void setLiquidType(String liquidType) {
        this.liquidType = liquidType;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTotalAmount1() {
        return totalAmount1;
    }

    public void setTotalAmount1(String totalAmount1) {
        this.totalAmount1 = totalAmount1;
    }

    public String getTotalAmountUnit() {
        return totalAmountUnit;
    }

    public void setTotalAmountUnit(String totalAmountUnit) {
        this.totalAmountUnit = totalAmountUnit;
    }

    public String getDzl() {
        return dzl;
    }

    public void setDzl(String dzl) {
        this.dzl = dzl;
    }

    public Date getInputTime() {
        if (inputTime == null) {
            inputTime = new Date();
        }
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
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

    public Drugs getDrugs() {
        if(drugs == null){
            drugs = new Drugs();
        }
        return drugs;
    }

    public void setDrugs(Drugs drugs) {
        this.drugs = drugs;
    }

    public List<DrugSpeed> getDrugSpeeds() {
        if (null == drugSpeeds) {
            drugSpeeds = new ArrayList<>();
        }
        return drugSpeeds;
    }

    public void setDrugSpeeds(List<DrugSpeed> drugSpeeds) {
        this.drugSpeeds = drugSpeeds;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDrugReason() {
        return drugReason;
    }

    public void setDrugReason(String drugReason) {
        this.drugReason = drugReason;
    }

    public String getDrugMethod() {
        return drugMethod;
    }

    public void setDrugMethod(String drugMethod) {
        this.drugMethod = drugMethod;
    }

    public boolean isSingle() {
        return single;
    }

    public void setSingle(boolean single) {
        this.single = single;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientDrugs that = (PatientDrugs) o;
        return single == that.single &&
                Objects.equals(id, that.id) &&
                Objects.equals(patientID, that.patientID) &&
                drugs.equals(that.drugs) &&
                drugSpeeds.containsAll(that.drugSpeeds) &&
                that.drugSpeeds.containsAll(drugSpeeds) &&
                Objects.equals(beginTime, that.beginTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(drugReason, that.drugReason) &&
                Objects.equals(drugMethod, that.drugMethod) &&
                Objects.equals(type, that.type) &&
                Objects.equals(isTakeOut(), that.isTakeOut()) &&
                Objects.equals(getChanel(), that.getChanel()) &&
                Objects.equals(getLiquidType(), that.getLiquidType()) &&
                Objects.equals(getTotalAmount(), that.getTotalAmount()) &&
                Objects.equals(getTotalAmount1(), that.getTotalAmount1()) &&
                Objects.equals(getTotalAmountUnit(), that.getTotalAmountUnit()) &&
                Objects.equals(getDzl(), that.getDzl()) &&
                Objects.equals(inputTime, that.inputTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientID, drugs, drugSpeeds, beginTime, endTime, drugReason, drugMethod, single, type, takeOut, chanel, liquidType, totalAmount, totalAmount1, totalAmountUnit, dzl, inputTime);
    }

}
