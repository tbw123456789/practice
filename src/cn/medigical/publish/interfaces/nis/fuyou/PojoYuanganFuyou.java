package cn.medigical.publish.interfaces.nis.fuyou;

import java.util.Date;

/**
 * Created by Medicare on 2018/3/21.
 * Copy right by Medicare
 */
public class PojoYuanganFuyou {
    public String ID = "";
    public String ZYID = "";//住院号
    public Integer VISIT_ID = 0;   //住院次数，住院号后四位
    public String PATIENT_ID = "";  //住院号
    public String PATIENT_NAME = "";//病人姓名
    
    public String OPER_ORDER_NO = "";  //手术编号，mongo后台id
    public String OPER_ROOM = ""; //手术室的房间号
    public String OPER_NAME = ""; //手术名称
    public String OPER_ID = ""; //手术的ICD9编码
    public Date OPER_AT = null; //手术日期
    public String OPER_BW="";//手术类型，浅层组织手术、深部组织手术、器官手术、腔隙手术
    
    public String OPEDOC_ID = "";  //主刀医生 姓名(工号)
    
    public String OPEDOC_NAME = "";//主刀医生 姓名
    
    public String ANES_DR_NAME = "";  //麻醉医生(工号)
    
    public String OPER_DIAGNOSE = ""; //手术诊断
    public Integer INCISION_GRADE = 0;  //手术切口类型0、Ⅰ、Ⅱ、Ⅲ、Ⅳ
    
    public Integer HEAL = 0;  //手术愈合等级
    public Integer ASA = 0;   //手术麻醉评分
    public Integer URGENT_OPE = null;  //择期、急诊,手术标志
    public String NARC_KIND = ""; //麻醉方式
    public Date OPER_START_TIME = null;  //手术开始时间
    public Date OPER_END_TIME = null;  //手术结束时间
    public String OPER_LENG_TIME = ""; //手术时长
    public Integer REPLANT = 0;  //是否有植入物：有、无

    public String DEPT_ID = "";  //申请科室id
    public String DEPT_NAME = "";  //申请科室名称
    public String OPEDOC_NAME2 = "";  //第二助手
    public String OPEDOC_NAME3 = "";  //第三助手
    public Integer WSQYY = 0;  //围术期用药标识
    public String NNIS="";
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getZYID() {
		return ZYID;
	}
	public void setZYID(String zYID) {
		ZYID = zYID;
	}
	public Integer getVISIT_ID() {
		return VISIT_ID;
	}
	public void setVISIT_ID(Integer vISIT_ID) {
		VISIT_ID = vISIT_ID;
	}
	public String getPATIENT_ID() {
		return PATIENT_ID;
	}
	public void setPATIENT_ID(String pATIENT_ID) {
		PATIENT_ID = pATIENT_ID;
	}
	public String getPATIENT_NAME() {
		return PATIENT_NAME;
	}
	public void setPATIENT_NAME(String pATIENT_NAME) {
		PATIENT_NAME = pATIENT_NAME;
	}
	public String getOPER_ORDER_NO() {
		return OPER_ORDER_NO;
	}
	public void setOPER_ORDER_NO(String oPER_ORDER_NO) {
		OPER_ORDER_NO = oPER_ORDER_NO;
	}
	public String getOPER_ROOM() {
		return OPER_ROOM;
	}
	public void setOPER_ROOM(String oPER_ROOM) {
		OPER_ROOM = oPER_ROOM;
	}
	public String getOPER_NAME() {
		return OPER_NAME;
	}
	public void setOPER_NAME(String oPER_NAME) {
		OPER_NAME = oPER_NAME;
	}
	public String getOPER_ID() {
		return OPER_ID;
	}
	public void setOPER_ID(String oPER_ID) {
		OPER_ID = oPER_ID;
	}
	public Date getOPER_AT() {
		return OPER_AT;
	}
	public void setOPER_AT(Date oPER_AT) {
		OPER_AT = oPER_AT;
	}
	public String getOPER_BW() {
		return OPER_BW;
	}
	public void setOPER_BW(String oPER_BW) {
		OPER_BW = oPER_BW;
	}
	public String getOPEDOC_ID() {
		return OPEDOC_ID;
	}
	public void setOPEDOC_ID(String oPEDOC_ID) {
		OPEDOC_ID = oPEDOC_ID;
	}
	public String getOPEDOC_NAME() {
		return OPEDOC_NAME;
	}
	public void setOPEDOC_NAME(String oPEDOC_NAME) {
		OPEDOC_NAME = oPEDOC_NAME;
	}
	public String getANES_DR_NAME() {
		return ANES_DR_NAME;
	}
	public void setANES_DR_NAME(String aNES_DR_NAME) {
		ANES_DR_NAME = aNES_DR_NAME;
	}
	public String getOPER_DIAGNOSE() {
		return OPER_DIAGNOSE;
	}
	public void setOPER_DIAGNOSE(String oPER_DIAGNOSE) {
		OPER_DIAGNOSE = oPER_DIAGNOSE;
	}
	public Integer getINCISION_GRADE() {
		return INCISION_GRADE;
	}
	public void setINCISION_GRADE(Integer iNCISION_GRADE) {
		INCISION_GRADE = iNCISION_GRADE;
	}
	public Integer getHEAL() {
		return HEAL;
	}
	public void setHEAL(Integer hEAL) {
		HEAL = hEAL;
	}
	public Integer getASA() {
		return ASA;
	}
	public void setASA(Integer aSA) {
		ASA = aSA;
	}
	public Integer getURGENT_OPE() {
		return URGENT_OPE;
	}
	public void setURGENT_OPE(Integer uRGENT_OPE) {
		URGENT_OPE = uRGENT_OPE;
	}
	public String getNARC_KIND() {
		return NARC_KIND;
	}
	public void setNARC_KIND(String nARC_KIND) {
		NARC_KIND = nARC_KIND;
	}
	public Date getOPER_START_TIME() {
		return OPER_START_TIME;
	}
	public void setOPER_START_TIME(Date oPER_START_TIME) {
		OPER_START_TIME = oPER_START_TIME;
	}
	public Date getOPER_END_TIME() {
		return OPER_END_TIME;
	}
	public void setOPER_END_TIME(Date oPER_END_TIME) {
		OPER_END_TIME = oPER_END_TIME;
	}
	public String getOPER_LENG_TIME() {
		return OPER_LENG_TIME;
	}
	public void setOPER_LENG_TIME(String oPER_LENG_TIME) {
		OPER_LENG_TIME = oPER_LENG_TIME;
	}
	public Integer getREPLANT() {
		return REPLANT;
	}
	public void setREPLANT(Integer rEPLANT) {
		REPLANT = rEPLANT;
	}
	public String getDEPT_ID() {
		return DEPT_ID;
	}
	public void setDEPT_ID(String dEPT_ID) {
		DEPT_ID = dEPT_ID;
	}
	public String getDEPT_NAME() {
		return DEPT_NAME;
	}
	public void setDEPT_NAME(String dEPT_NAME) {
		DEPT_NAME = dEPT_NAME;
	}
	public String getOPEDOC_NAME2() {
		return OPEDOC_NAME2;
	}
	public void setOPEDOC_NAME2(String oPEDOC_NAME2) {
		OPEDOC_NAME2 = oPEDOC_NAME2;
	}
	public String getOPEDOC_NAME3() {
		return OPEDOC_NAME3;
	}
	public void setOPEDOC_NAME3(String oPEDOC_NAME3) {
		OPEDOC_NAME3 = oPEDOC_NAME3;
	}
	public Integer getWSQYY() {
		return WSQYY;
	}
	public void setWSQYY(Integer wSQYY) {
		WSQYY = wSQYY;
	}
	public String getNNIS() {
		return NNIS;
	}
	public void setNNIS(String nNIS) {
		NNIS = nNIS;
	}
    
    


}
