package cn.medigical.publish.interfaces.lis;

/**
 * Created by  on 2016/6/12.
 * Copyright by
 */
public class LisData {

    private String BG;
    private String RH;
    private String WBC;
    private String HGB;
    private String HCT;
    private String PLT;
    private String PT; //PT
    private String APTT; //APTT
    private String D_DIMER; //D-DIMER
    private String GLU; //GLU
    private String BNP; //BNP
    private String ALT;
    private String BUN; //BUN
    private String Cr; //Cr
    private String K; //K+
    private String CA; //CA2-
    private String HBsAg ;  // 乙肝表面抗原
    private String PAO2; // 血气里面的
    private String TNI; // TNI

    private String SGPT;
    private String Hb;
    private String CL; //CL-
    private String NA; //NA+
    private String HIV;  // 艾滋病抗体
    private String HCV;  //  丙肝抗体
    private String TP;  // 梅毒螺旋体特异性抗体 TP-Ab TPHA TPPA

    public String getBG() {
        return BG;
    }

    public void setBG(String BG) {
        this.BG = BG;
    }

    public String getRH() {
        return RH;
    }

    public void setRH(String RH) {
        this.RH = RH;
    }

    public String getHGB() {
        return HGB;
    }


    public String getALT() {
        return ALT;
    }

    public void setALT(String ALT) {
        this.ALT = ALT;
    }

    public void setHGB(String HGB) {
        this.HGB = HGB;
    }

    public String getD_DIMER() {
        return D_DIMER;
    }

    public void setD_DIMER(String d_DIMER) {
        D_DIMER = d_DIMER;
    }

    public String getBNP() {
        return BNP;
    }

    public void setBNP(String BNP) {
        this.BNP = BNP;
    }

    public String getCA() {
        return CA;
    }

    public void setCA(String CA) {
        this.CA = CA;
    }

    public String getTNI() {
        return TNI;
    }

    public void setTNI(String TNI) {
        this.TNI = TNI;
    }

    public String getHb() {
        return Hb;
    }

    public void setHb(String hb) {
        Hb = hb;
    }

    public String getHCT() {
        return HCT;
    }

    public void setHCT(String HCT) {
        this.HCT = HCT;
    }

    public String getWBC() {
        return WBC;
    }

    public void setWBC(String WBC) {
        this.WBC = WBC;
    }

    public String getPLT() {
        return PLT;
    }

    public void setPLT(String PLT) {
        this.PLT = PLT;
    }

    public String getK() {
        return K;
    }

    public void setK(String k) {
        K = k;
    }

    public String getNA() {
        return NA;
    }

    public void setNA(String NA) {
        this.NA = NA;
    }

    public String getCL() {
        return CL;
    }

    public void setCL(String CL) {
        this.CL = CL;
    }

    public String getGLU() {
        return GLU;
    }

    public void setGLU(String GLU) {
        this.GLU = GLU;
    }

    public String getBUN() {
        return BUN;
    }

    public void setBUN(String BUN) {
        this.BUN = BUN;
    }

    public String getCr() {
        return Cr;
    }

    public void setCr(String cr) {
        Cr = cr;
    }

    public String getPT() {
        return PT;
    }

    public void setPT(String PT) {
        this.PT = PT;
    }

    public String getAPTT() {
        return APTT;
    }

    public void setAPTT(String APTT) {
        this.APTT = APTT;
    }

    public String getSGPT() {
        return SGPT;
    }

    public void setSGPT(String SGPT) {
        this.SGPT = SGPT;
    }

    public String getPAO2() {
        return PAO2;
    }

    public void setPAO2(String PAO2) {
        this.PAO2 = PAO2;
    }

    public String getHIV() {
        return HIV;
    }

    public void setHIV(String HIV) {
        this.HIV = HIV;
    }

    public String getHCV() {
        return HCV;
    }

    public void setHCV(String HCV) {
        this.HCV = HCV;
    }

    public String getTP() {
        return TP;
    }

    public void setTP(String TP) {
        this.TP = TP;
    }

    public String getHBsAg() {
        return HBsAg;
    }

    public void setHBsAg(String HBsAg) {
        this.HBsAg = HBsAg;
    }

    public boolean isFullData() {
        if (getHb() == null || getHCT() == null || getWBC() == null || getPLT() == null
                || getK() == null || getNA() == null || getCL() == null || getGLU() == null
                || getBUN() == null || getCr() == null || getPT() == null || getAPTT() == null
                || getSGPT() == null || getPAO2() == null || getHIV() == null || getHCV() == null
                || getHBsAg() == null || getTP() == null|| getBG() == null || getHGB() == null
                || getD_DIMER() == null || getBNP() == null || getCA() == null || getTNI() == null
                || getRH() == null) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "LisData [BG=" + BG + ", RH=" + RH + ", WBC=" + WBC + ", HGB=" + HGB + ", HCT=" + HCT + ", PLT=" + PLT
				+ ", PT=" + PT + ", APTT=" + APTT + ", D_DIMER=" + D_DIMER + ", GLU=" + GLU + ", BNP=" + BNP + ", ALT="
				+ ALT + ", BUN=" + BUN + ", Cr=" + Cr + ", K=" + K + ", CA=" + CA + ", HBsAg=" + HBsAg + ", PAO2="
				+ PAO2 + ", TNI=" + TNI + ", SGPT=" + SGPT + ", Hb=" + Hb + ", CL=" + CL + ", NA=" + NA + ", HIV=" + HIV
				+ ", HCV=" + HCV + ", TP=" + TP + ", getBG()=" + getBG() + ", getRH()=" + getRH() + ", getHGB()="
				+ getHGB() + ", getALT()=" + getALT() + ", getD_DIMER()=" + getD_DIMER() + ", getBNP()=" + getBNP()
				+ ", getCA()=" + getCA() + ", getTNI()=" + getTNI() + ", getHb()=" + getHb() + ", getHCT()=" + getHCT()
				+ ", getWBC()=" + getWBC() + ", getPLT()=" + getPLT() + ", getK()=" + getK() + ", getNA()=" + getNA()
				+ ", getCL()=" + getCL() + ", getGLU()=" + getGLU() + ", getBUN()=" + getBUN() + ", getCr()=" + getCr()
				+ ", getPT()=" + getPT() + ", getAPTT()=" + getAPTT() + ", getSGPT()=" + getSGPT() + ", getPAO2()="
				+ getPAO2() + ", getHIV()=" + getHIV() + ", getHCV()=" + getHCV() + ", getTP()=" + getTP()
				+ ", getHBsAg()=" + getHBsAg() + ", isFullData()=" + isFullData() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
    
    
}
