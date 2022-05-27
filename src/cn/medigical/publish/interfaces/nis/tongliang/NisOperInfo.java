package cn.medigical.publish.interfaces.nis.tongliang;

public class NisOperInfo {
    String PATIENT_ID;//患者ID
    String VISIT_ID;//住院次数
    String OPER_ID;//手术编号
    String OPER_NAME;//手术名称
    String OPER_CODE;//ICD9编码
    String OPER_DIAGNOSIS;//手术诊断
    String SURGEON;//手术医生
    String FIRSTAS;//第一助手
    String ANESTHESTA;//麻醉医生
    String ANESTHESTA_METHOD;//麻醉方式
    String START_DATE_TIME;//开始时间
    String END_DATE_TIME;//结束时间
    String OPER_QUANTUM;//手术时长
    String ASA;//ASA评分
    String WOUND_GRADE;//手术切口类型
    String NNIS;//NNIS
    String HEAL;//愈合等级
    String LOCATION;//择期急诊
    String OPER_TYPE;//手术位置
    String EMBED;//植入物
    String ENDOSCOPIC;//内镜手术
    String OPER_ROOM;//手术室
    String BLOOD_OUT;//失血量
    String BLOOD_IN;//输血量

    String HIS_ID;
    String PATIENT_TYPE;//手术类型
    String SSBH;//手术编号
    String SSFJ;//手术房间
    String OPS_DOC_ID;//手术医生编号
    String SSEZ;//手术二助
    String SSSZ;//手术三助
    String CUT_GRADE;//手术切口清洁度
    String OFFICE;//科室名称
    String OFFICE_ID;//科室ID

    String PATIENT_NAME;//病人姓名
    String OPER_AT;//手术日期
    String CREATE_AT;//创建时间

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

    public String getOPER_NAME() {
        return OPER_NAME;
    }

    public void setOPER_NAME(String OPER_NAME) {
        this.OPER_NAME = OPER_NAME;
    }

    public String getOPER_CODE() {
        return OPER_CODE;
    }

    public void setOPER_CODE(String OPER_CODE) {
        this.OPER_CODE = OPER_CODE;
    }

    public String getOPER_DIAGNOSIS() {
        return OPER_DIAGNOSIS;
    }

    public void setOPER_DIAGNOSIS(String OPER_DIAGNOSIS) {
        this.OPER_DIAGNOSIS = OPER_DIAGNOSIS;
    }

    public String getSURGEON() {
        return SURGEON;
    }

    public void setSURGEON(String SURGEON) {
        this.SURGEON = SURGEON;
    }

    public String getFIRSTAS() {
        return FIRSTAS;
    }

    public void setFIRSTAS(String FIRSTAS) {
        this.FIRSTAS = FIRSTAS;
    }

    public String getANESTHESTA() {
        return ANESTHESTA;
    }

    public void setANESTHESTA(String ANESTHESTA) {
        this.ANESTHESTA = ANESTHESTA;
    }

    public String getANESTHESTA_METHOD() {
        return ANESTHESTA_METHOD;
    }

    public void setANESTHESTA_METHOD(String ANESTHESTA_METHOD) {
        this.ANESTHESTA_METHOD = ANESTHESTA_METHOD;
    }

    public String getSTART_DATE_TIME() {
        return START_DATE_TIME;
    }

    public void setSTART_DATE_TIME(String START_DATE_TIME) {
        this.START_DATE_TIME = START_DATE_TIME;
    }

    public String getEND_DATE_TIME() {
        return END_DATE_TIME;
    }

    public void setEND_DATE_TIME(String END_DATE_TIME) {
        this.END_DATE_TIME = END_DATE_TIME;
    }

    public String getOPER_QUANTUM() {
        return OPER_QUANTUM;
    }

    public void setOPER_QUANTUM(String OPER_QUANTUM) {
        this.OPER_QUANTUM = OPER_QUANTUM;
    }

    public String getWOUND_GRADE() {
        return WOUND_GRADE;
    }

    public void setWOUND_GRADE(String WOUND_GRADE) {
        this.WOUND_GRADE = WOUND_GRADE;
    }

    public String getASA() {
        return ASA;
    }

    public void setASA(String ASA) {
        this.ASA = ASA;
    }

    public String getNNIS() {
        return NNIS;
    }

    public void setNNIS(String NNIS) {
        this.NNIS = NNIS;
    }

    public String getHEAL() {
        return HEAL;
    }

    public void setHEAL(String HEAL) {
        this.HEAL = HEAL;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    public String getOPER_TYPE() {
        return OPER_TYPE;
    }

    public void setOPER_TYPE(String OPER_TYPE) {
        this.OPER_TYPE = OPER_TYPE;
    }

    public String getEMBED() {
        return EMBED;
    }

    public void setEMBED(String EMBED) {
        this.EMBED = EMBED;
    }

    public String getENDOSCOPIC() {
        return ENDOSCOPIC;
    }

    public void setENDOSCOPIC(String ENDOSCOPIC) {
        this.ENDOSCOPIC = ENDOSCOPIC;
    }

    public String getOPER_ROOM() {
        return OPER_ROOM;
    }

    public void setOPER_ROOM(String OPER_ROOM) {
        this.OPER_ROOM = OPER_ROOM;
    }

    public String getBLOOD_OUT() {
        return BLOOD_OUT;
    }

    public void setBLOOD_OUT(String BLOOD_OUT) {
        this.BLOOD_OUT = BLOOD_OUT;
    }

    public String getBLOOD_IN() {
        return BLOOD_IN;
    }

    public void setBLOOD_IN(String BLOOD_IN) {
        this.BLOOD_IN = BLOOD_IN;
    }
    public String getHIS_ID() {
        return HIS_ID;
    }

    public void setHIS_ID(String hIS_ID) {
        HIS_ID = hIS_ID;
    }

    public String getPATIENT_TYPE() {
        return PATIENT_TYPE;
    }

    public void setPATIENT_TYPE(String pATIENT_TYPE) {
        PATIENT_TYPE = pATIENT_TYPE;
    }

    public String getSSBH() {
        return SSBH;
    }

    public void setSSBH(String sSBH) {
        SSBH = sSBH;
    }

    public String getSSFJ() {
        return SSFJ;
    }

    public void setSSFJ(String sSFJ) {
        SSFJ = sSFJ;
    }

    public String getOPS_DOC_ID() {
        return OPS_DOC_ID;
    }

    public void setOPS_DOC_ID(String oPS_DOC_ID) {
        OPS_DOC_ID = oPS_DOC_ID;
    }

    public String getSSEZ() {
        return SSEZ;
    }

    public void setSSEZ(String sSEZ) {
        SSEZ = sSEZ;
    }

    public String getSSSZ() {
        return SSSZ;
    }

    public void setSSSZ(String sSSZ) {
        SSSZ = sSSZ;
    }

    public String getCUT_GRADE() {
        return CUT_GRADE;
    }

    public void setCUT_GRADE(String cUT_GRADE) {
        CUT_GRADE = cUT_GRADE;
    }

    public String getOFFICE() {
        return OFFICE;
    }

    public void setOFFICE(String oFFICE) {
        OFFICE = oFFICE;
    }

    public String getOFFICE_ID() {
        return OFFICE_ID;
    }

    public void setOFFICE_ID(String oFFICE_ID) {
        OFFICE_ID = oFFICE_ID;
    }
    public String getPATIENT_NAME() {
        return PATIENT_NAME;
    }

    public void setPATIENT_NAME(String pATIENT_NAME) {
        PATIENT_NAME = pATIENT_NAME;
    }

    public String getOPER_AT() {
        return OPER_AT;
    }

    public void setOPER_AT(String oPER_AT) {
        OPER_AT = oPER_AT;
    }

    public String getCREATE_AT() {
        return CREATE_AT;
    }

    public void setCREATE_AT(String cREATE_AT) {
        CREATE_AT = cREATE_AT;
    }

}
