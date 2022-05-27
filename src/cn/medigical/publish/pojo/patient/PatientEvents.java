package cn.medigical.publish.pojo.patient;

import java.util.Date;
import java.util.Objects;

public class PatientEvents {
    private String id;
    /**
     * 病人ID 关联键
     */
    private String patientID;
    /**
     * 事件编码
     */
    private String code;
    /**
     * 事件名称
     */
    private String name;
    /**
     * 开始时间
     */
    private Date beginTime;
    /**
     * 结束时间
     */
    private Date endTime;

    private boolean deleted;

    private Date inputTime;

    public Date getInputTime() {
        if (inputTime==null){
            inputTime=new Date();
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

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientEvents that = (PatientEvents) o;
//         &&此处事件不比较时间，只需要比较ID和PaitientID，因为ID唯一
//        Objects.equals(endTime, that.endTime) &&
//                Objects.equals(inputTime, that.inputTime)

        return deleted == that.deleted &&
                Objects.equals(id, that.id) &&
                Objects.equals(patientID, that.patientID) &&
                Objects.equals(code, that.code) &&
                Objects.equals(name, that.name) &&
                Objects.equals(beginTime, that.beginTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, patientID, code, name, beginTime, endTime, deleted, inputTime);
    }
}
