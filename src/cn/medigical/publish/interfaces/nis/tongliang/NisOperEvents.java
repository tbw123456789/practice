package cn.medigical.publish.interfaces.nis.tongliang;

public class NisOperEvents {
    String PATIENT_ID;//患者ID
    String VISIT_ID;//住院次数
    String OPER_ID;//手术编号
    String EVENTS_ID;//事件编号
    String EVENTS_NAME;//事件名称
    String EVENTS_TIME;//发生时间
    String EVENTS_TYPE;//事件类型
    String ADMINISTRATION;//用药时机

    public String getPATIENT_ID() {
        return PATIENT_ID;
    }

    public void setPATIENT_ID(String PATIENT_ID) {
        this.PATIENT_ID = PATIENT_ID;
    }

    public String getVISIT_ID() {
        return VISIT_ID;
    }

    public void setVISIT_ID(String VISIT_ID) {
        this.VISIT_ID = VISIT_ID;
    }

    public String getOPER_ID() {
        return OPER_ID;
    }

    public void setOPER_ID(String OPER_ID) {
        this.OPER_ID = OPER_ID;
    }

    public String getEVENTS_ID() {
        return EVENTS_ID;
    }

    public void setEVENTS_ID(String EVENTS_ID) {
        this.EVENTS_ID = EVENTS_ID;
    }

    public String getEVENTS_NAME() {
        return EVENTS_NAME;
    }

    public void setEVENTS_NAME(String EVENTS_NAME) {
        this.EVENTS_NAME = EVENTS_NAME;
    }

    public String getEVENTS_TIME() {
        return EVENTS_TIME;
    }

    public void setEVENTS_TIME(String EVENTS_TIME) {
        this.EVENTS_TIME = EVENTS_TIME;
    }

    public String getEVENTS_TYPE() {
        return EVENTS_TYPE;
    }

    public void setEVENTS_TYPE(String EVENTS_TYPE) {
        this.EVENTS_TYPE = EVENTS_TYPE;
    }

    public String getADMINISTRATION() {
        return ADMINISTRATION;
    }

    public void setADMINISTRATION(String ADMINISTRATION) {
        this.ADMINISTRATION = ADMINISTRATION;
    }
}
