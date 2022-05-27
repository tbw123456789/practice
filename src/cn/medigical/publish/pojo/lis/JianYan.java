package cn.medigical.publish.pojo.lis;

public class JianYan
{

    private String patientZyh;//住院号

    private String xueChangGui;//血常规
    private String ningXueGongNeng;//凝血功能
    private String ganGongNeng;//肝功
    private String shenGongNeng;//肾功
    private Boolean yiGan;//乙肝
    private Boolean bingGan;//丙肝
    private String hIV;  // 艾滋病抗体1
    private Boolean meiDu;//梅毒
    private String niaoChangGui;//尿常规
    private String dabian;//大便常规
    private String dianJieZhi;//电解质
    private String xiongPian;//胸片

    private String xueChangGuiState;
    private String xinJiMeiPu;//心肌酶谱
    private String ganGongNengState;
    private String shenGongNengState;
    private String ningXueGongNengState;
    private String dianJieZhiState;
    private String xueTang;//血糖
    private String xueTangState;
    private String cFanYingDanBai;//糖化血红蛋白
    private String xinGengSanXiang;
    private String ecg;//1
    private String ecgState;
    private String chaoShengXinDongTu;//超声心动图
    private String chaoShengXDTState;
    private String xiongPianState;
    private String xueQiFenXi;//血气分析
    private String xueQiFenXiState;
    private String feiGongNeng;//肺功能
    private String feiGongNengState;
    private String rbc;
    private String hb;
    private String hct;
    private String plt;//7
    private String wbc;//6
    private Boolean jiaGan;//甲肝
    private Boolean kangHIV;//抗癌

    private String otherJianYan;//其他检验
    private String bloodType;//血型
    private String hbsag;//13
    private String hbeag;//15
    private String hcvab;//12
    private String hcvagab;//1
    private String tpab;//14
    private String trust;//1
    private String jiaGong;
    private String ef;
    private String sv;
    private String ganransixiang;


    private String hCV;  // 艾滋病抗体1
    private String k; //K+8
    private String cL; //CL-10
    private String nA; //NA+9
    private String gLU; //GLU11
    private String aLT;//12
    private String bUN; //BUN13
    private String cr; //Cr14
    private String pT; //PT15
    private String aPTT; //APTT16
    private String pAO2; // 血气里面的17
    private String cREA; // 肌酐

    public String getDabian() {
        return dabian;
    }

    public void setDabian(String dabian) {
        this.dabian = dabian;
    }

    public String getUREA() {
        return uREA;
    }

    public void setUREA(String uREA) {
        this.uREA = uREA;
    }

    private String uREA; //


    public Boolean getJiaGan() {
        return jiaGan;
    }

    public Boolean getYiGan() {
        return yiGan;
    }

    public Boolean getBingGan() {
        return bingGan;
    }

    public Boolean getKangHIV() {
        return kangHIV;
    }

    public Boolean getMeiDu() {
        return meiDu;
    }

    public String getXueChangGui()
    {
        return this.xueChangGui;
    }

    public void setXueChangGui(String xueChangGui) {
        this.xueChangGui = xueChangGui;
    }

    public String getNiaoChangGui() {
        return this.niaoChangGui;
    }

    public void setNiaoChangGui(String niaoChangGui) {
        this.niaoChangGui = niaoChangGui;
    }

    public String getXinJiMeiPu() {
        return this.xinJiMeiPu;
    }

    public void setXinJiMeiPu(String xinJiMeiPu) {
        this.xinJiMeiPu = xinJiMeiPu;
    }

    public String getGanGongNeng() {
        return this.ganGongNeng;
    }

    public void setGanGongNeng(String ganGongNeng) {
        this.ganGongNeng = ganGongNeng;
    }

    public String getShenGongNeng() {
        return this.shenGongNeng;
    }

    public void setShenGongNeng(String shenGongNeng) {
        this.shenGongNeng = shenGongNeng;
    }

    public String getNingXueGongNeng() {
        return this.ningXueGongNeng;
    }

    public void setNingXueGongNeng(String ningXueGongNeng) {
        this.ningXueGongNeng = ningXueGongNeng;
    }

    public String getDianJieZhi() {
        return this.dianJieZhi;
    }

    public void setDianJieZhi(String dianJieZhi) {
        this.dianJieZhi = dianJieZhi;
    }

    public String getXueTang() {
        return this.xueTang;
    }

    public void setXueTang(String xueTang) {
        this.xueTang = xueTang;
    }

    public String getEcg() {
        return this.ecg;
    }

    public void setEcg(String ecg) {
        this.ecg = ecg;
    }

    public String getChaoShengXinDongTu() {
        return this.chaoShengXinDongTu;
    }

    public void setChaoShengXinDongTu(String chaoShengXinDongTu) {
        this.chaoShengXinDongTu = chaoShengXinDongTu;
    }

    public String getXiongPian() {
        return this.xiongPian;
    }

    public void setXiongPian(String xiongPian) {
        this.xiongPian = xiongPian;
    }

    public String getXueQiFenXi() {
        return this.xueQiFenXi;
    }

    public void setXueQiFenXi(String xueQiFenXi) {
        this.xueQiFenXi = xueQiFenXi;
    }

    public String getFeiGongNeng() {
        return this.feiGongNeng;
    }

    public void setFeiGongNeng(String feiGongNeng) {
        this.feiGongNeng = feiGongNeng;
    }

    public String getcFanYingDanBai() {
        return this.cFanYingDanBai;
    }

    public void setcFanYingDanBai(String cFanYingDanBai) {
        this.cFanYingDanBai = cFanYingDanBai;
    }

    public String getXinGengSanXiang() {
        return this.xinGengSanXiang;
    }

    public void setXinGengSanXiang(String xinGengSanXiang) {
        this.xinGengSanXiang = xinGengSanXiang;
    }

    public String getRbc() {
        return this.rbc;
    }

    public void setRbc(String rbc) {
        this.rbc = rbc;
    }

    public String getHb() {
        return this.hb;
    }

    public void setHb(String hb) {
        this.hb = hb;
    }

    public String getHct() {
        return this.hct;
    }

    public void setHct(String hct) {
        this.hct = hct;
    }

    public String getPlt() {
        return this.plt;
    }

    public void setPlt(String plt) {
        this.plt = plt;
    }

    public String getWbc() {
        return this.wbc;
    }

    public void setWbc(String wbc) {
        this.wbc = wbc;
    }

    public String getOtherJianYan() {
        return this.otherJianYan;
    }

    public void setOtherJianYan(String otherJianYan) {
        this.otherJianYan = otherJianYan;
    }

    public Boolean isJiaGan() {
        return this.jiaGan;
    }

    public void setJiaGan(Boolean jiaGan) {
        this.jiaGan = jiaGan;
    }

    public Boolean isYiGan() {
        return this.yiGan;
    }

    public void setYiGan(Boolean yiGan) {
        this.yiGan = yiGan;
    }

    public Boolean isBingGan() {
        return this.bingGan;
    }

    public void setBingGan(Boolean bingGan) {
        this.bingGan = bingGan;
    }

    public Boolean isKangHIV() {
        return this.kangHIV;
    }

    public void setKangHIV(Boolean kangHIV) {
        this.kangHIV = kangHIV;
    }

    public Boolean isMeiDu() {
        return this.meiDu;
    }

    public void setMeiDu(Boolean meiDu) {
        this.meiDu = meiDu;
    }

    public String getEcgState() {
        return this.ecgState;
    }

    public void setEcgState(String ecgState) {
        this.ecgState = ecgState;
    }

    public String getChaoShengXDTState() {
        return this.chaoShengXDTState;
    }

    public void setChaoShengXDTState(String chaoShengXDTState) {
        this.chaoShengXDTState = chaoShengXDTState;
    }

    public String getXiongPianState() {
        return this.xiongPianState;
    }

    public void setXiongPianState(String xiongPianState) {
        this.xiongPianState = xiongPianState;
    }

    public String getXueQiFenXiState() {
        return this.xueQiFenXiState;
    }

    public void setXueQiFenXiState(String xueQiFenXiState) {
        this.xueQiFenXiState = xueQiFenXiState;
    }

    public String getFeiGongNengState() {
        return this.feiGongNengState;
    }

    public void setFeiGongNengState(String feiGongNengState) {
        this.feiGongNengState = feiGongNengState;
    }

    public String getXueChangGuiState() {
        return this.xueChangGuiState;
    }

    public void setXueChangGuiState(String xueChangGuiState) {
        this.xueChangGuiState = xueChangGuiState;
    }

    public String getGanGongNengState() {
        return this.ganGongNengState;
    }

    public void setGanGongNengState(String ganGongNengState) {
        this.ganGongNengState = ganGongNengState;
    }

    public String getShenGongNengState() {
        return this.shenGongNengState;
    }

    public void setShenGongNengState(String shenGongNengState) {
        this.shenGongNengState = shenGongNengState;
    }

    public String getNingXueGongNengState() {
        return this.ningXueGongNengState;
    }

    public void setNingXueGongNengState(String ningXueGongNengState) {
        this.ningXueGongNengState = ningXueGongNengState;
    }

    public String getDianJieZhiState() {
        return this.dianJieZhiState;
    }

    public void setDianJieZhiState(String dianJieZhiState) {
        this.dianJieZhiState = dianJieZhiState;
    }

    public String getXueTangState() {
        return this.xueTangState;
    }

    public void setXueTangState(String xueTangState) {
        this.xueTangState = xueTangState;
    }

    public String getJiaGong() {
        return this.jiaGong;
    }

    public void setJiaGong(String jiaGong) {
        this.jiaGong = jiaGong;
    }

    public String getTrust() {
        return this.trust;
    }

    public void setTrust(String trust) {
        this.trust = trust;
    }

    public String getTpab() {
        return this.tpab;
    }

    public void setTpab(String tpab) {
        this.tpab = tpab;
    }

    public String getHcvagab() {
        return this.hcvagab;
    }

    public void setHcvagab(String hcvagab) {
        this.hcvagab = hcvagab;
    }

    public String getHcvab() {
        return this.hcvab;
    }

    public void setHcvab(String hcvab) {
        this.hcvab = hcvab;
    }

    public String getHbeag() {
        return this.hbeag;
    }

    public void setHbeag(String hbeag) {
        this.hbeag = hbeag;
    }

    public String getHbsag() {
        return this.hbsag;
    }

    public void setHbsag(String hbsag) {
        this.hbsag = hbsag;
    }

    public String getEf() {
        return this.ef;
    }

    public void setEf(String ef) {
        this.ef = ef;
    }

    public String getSv() {
        return this.sv;
    }

    public void setSv(String sv) {
        this.sv = sv;
    }

    public String getGanransixiang() {
        return this.ganransixiang;
    }

    public void setGanransixiang(String ganransixiang) {
        this.ganransixiang = ganransixiang;
    }

    public String getBloodType() {
        return this.bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getHIV() {
        return hIV;
    }

    public void setHIV(String hIV) {
        this.hIV = hIV;
    }

    public String getHCV() {
        return hCV;
    }

    public void setHCV(String hCV) {
        this.hCV = hCV;
    }

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getCL() {
        return cL;
    }

    public void setCL(String cL) {
        this.cL = cL;
    }

    public String getNA() {
        return nA;
    }

    public void setNA(String nA) {
        this.nA = nA;
    }

    public String getGLU() {
        return gLU;
    }

    public void setGLU(String gLU) {
        this.gLU = gLU;
    }

    public String getALT() {
        return aLT;
    }

    public void setALT(String aLT) {
        this.aLT = aLT;
    }

    public String getBUN() {
        return bUN;
    }

    public void setBUN(String bUN) {
        this.bUN = bUN;
    }

    public String getCr() {
        return cr;
    }

    public void setCr(String cr) {
        this.cr = cr;
    }

    public String getPT() {
        return pT;
    }

    public void setPT(String pT) {
        this.pT = pT;
    }

    public String getAPTT() {
        return aPTT;
    }

    public void setAPTT(String aPTT) {
        this.aPTT = aPTT;
    }

    public String getPAO2() {
        return pAO2;
    }

    public void setPAO2(String pAO2) {
        this.pAO2 = pAO2;
    }

    public String getCREA() {
        return cREA;
    }

    public void setCREA(String cREA) {
        this.cREA = cREA;
    }

	@Override
	public String toString() {
		return "JianYan [xueChangGui=" + xueChangGui + ", xueChangGuiState=" + xueChangGuiState + ", niaoChangGui="
				+ niaoChangGui + ", xinJiMeiPu=" + xinJiMeiPu + ", ganGongNeng=" + ganGongNeng + ", ganGongNengState="
				+ ganGongNengState + ", shenGongNeng=" + shenGongNeng + ", shenGongNengState=" + shenGongNengState
				+ ", ningXueGongNeng=" + ningXueGongNeng + ", ningXueGongNengState=" + ningXueGongNengState
				+ ", dianJieZhi=" + dianJieZhi + ", dianJieZhiState=" + dianJieZhiState + ", xueTang=" + xueTang
				+ ", xueTangState=" + xueTangState + ", cFanYingDanBai=" + cFanYingDanBai + ", xinGengSanXiang="
				+ xinGengSanXiang + ", ecg=" + ecg + ", ecgState=" + ecgState + ", chaoShengXinDongTu="
				+ chaoShengXinDongTu + ", chaoShengXDTState=" + chaoShengXDTState + ", xiongPian=" + xiongPian
				+ ", xiongPianState=" + xiongPianState + ", xueQiFenXi=" + xueQiFenXi + ", xueQiFenXiState="
				+ xueQiFenXiState + ", feiGongNeng=" + feiGongNeng + ", feiGongNengState=" + feiGongNengState + ", rbc="
				+ rbc + ", hb=" + hb + ", hct=" + hct + ", plt=" + plt + ", wbc=" + wbc + ", jiaGan=" + jiaGan
				+ ", yiGan=" + yiGan + ", bingGan=" + bingGan + ", kangHIV=" + kangHIV + ", meiDu=" + meiDu
				+ ", otherJianYan=" + otherJianYan + ", bloodType=" + bloodType + ", hbsag=" + hbsag + ", hbeag="
				+ hbeag + ", hcvab=" + hcvab + ", hcvagab=" + hcvagab + ", tpab=" + tpab + ", trust=" + trust
				+ ", jiaGong=" + jiaGong + ", ef=" + ef + ", sv=" + sv + ", ganransixiang=" + ganransixiang + ", hIV="
				+ hIV + ", hCV=" + hCV + ", k=" + k + ", cL=" + cL + ", nA=" + nA + ", gLU=" + gLU + ", aLT=" + aLT
				+ ", bUN=" + bUN + ", cr=" + cr + ", pT=" + pT + ", aPTT=" + aPTT + ", pAO2=" + pAO2 + ", cREA=" + cREA
				+ ", uREA=" + uREA + "]";
	}


}