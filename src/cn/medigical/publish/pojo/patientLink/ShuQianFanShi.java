package cn.medigical.publish.pojo.patientLink;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="shuQianFanShi")
public class ShuQianFanShi {
    /**清醒*/
    private Boolean ys_qx;
    /**嗜睡*/
    private Boolean ys_ss;
    /**浅昏迷*/
    private Boolean ys_qhm;
    /**深昏迷*/
    private Boolean ys_shm;
    /**良*/
    private Boolean yyfy_l;
    /**中*/
    private Boolean yyfy_z;
    /**差*/
    private Boolean yyfy_c;
    /**恶病质*/
    private Boolean yyfy_ebz;
    /**正常*/
    private Boolean zkd_zc;
    /**1级*/
    private Boolean zkd_1;
    /**2级*/
    private Boolean zkd_2;
    /**3级*/

    private Boolean zkd_3;
    /**1级*/
    private Boolean xgn_1;
    /**2级*/
    private Boolean xgn_2;
    /**3级*/
    private Boolean xgn_3;
    /**4级*/
    private Boolean xgn_4;
    /**1级*/
    private Boolean asa_1;
    /**2级*/
    private Boolean asa_2;
    /**3级*/
    private Boolean asa_3;
    /**4级*/
    private Boolean asa_4;
    /**5级*/
    private Boolean asa_5;
    /**姓名*/
    private String brxm;
    /**科室*/
    private String ksmc;
    /**床号*/
    private String zych;
    /**住院号*/
    private String zyh;
    /**姓名*/
    private String brxm2;
    /**性別*/
    private String xb;
    /**年齡*/
    private String nl;
    /**住院号*/
    private String zyh2;
    /**床号*/
    private String ch;
    /**科室*/
    private String ks;
    /**体温*/
    private String tw;
    /**呼吸*/
    private String hx;
    /**脉搏*/
    private String mb;
    /**心率*/
    private String xl;
    /**血压*/
    private String xy;
    /**术前诊断*/
    private String sqzd;
    /**拟施手术*/
    private String nsss;
    /**拟施麻醉方法*/
    private String nsmzff;
    /**术前合并疾病*/
    private String sqhbjb;
    /**血常规*/
    private String xcg;
    /**血型*/
    private String xx;
    /**凝血常规*/
    @Field(value="nxcg")
    private String nxcg;
    /**肝功能*/
    @Field(value="ggn")
    private String ggn;
    /**肾功能*/
    private String sgn;
    /**乙肝(*/
    private String yg;
    /**丙肝(*/
    private String bg;
    /**艾v滋病(抗-HIV)(*/
    private String azb;
    /**梅毒(抗-TP)(*/
    private String md;
    /**尿常规*/
    private String ncg;
    /**大便常规*/
    private String dbcg;
    /**电解质*/
    private String djz;
    /**胸片*/
    private String xp;
    /**心电图*/
    private String xdt;
    /**麻药过敏史*/
    private String mygms;
    /**过去麻醉史*/
    private String gqmzs;
    /**访视医师*/
    private String fsys;
    /**访视时间*/
    private String fssj;

    public Boolean getYs_qx() {
        return ys_qx;
    }

    public void setYs_qx(Boolean ys_qx) {
        this.ys_qx = ys_qx;
    }

    public Boolean getYs_ss() {
        return ys_ss;
    }

    public void setYs_ss(Boolean ys_ss) {
        this.ys_ss = ys_ss;
    }

    public Boolean getYs_qhm() {
        return ys_qhm;
    }

    public void setYs_qhm(Boolean ys_qhm) {
        this.ys_qhm = ys_qhm;
    }

    public Boolean getYs_shm() {
        return ys_shm;
    }

    public void setYs_shm(Boolean ys_shm) {
        this.ys_shm = ys_shm;
    }

    public Boolean getYyfy_l() {
        return yyfy_l;
    }

    public void setYyfy_l(Boolean yyfy_l) {
        this.yyfy_l = yyfy_l;
    }

    public Boolean getYyfy_z() {
        return yyfy_z;
    }

    public void setYyfy_z(Boolean yyfy_z) {
        this.yyfy_z = yyfy_z;
    }

    public Boolean getYyfy_c() {
        return yyfy_c;
    }

    public void setYyfy_c(Boolean yyfy_c) {
        this.yyfy_c = yyfy_c;
    }

    public Boolean getYyfy_ebz() {
        return yyfy_ebz;
    }

    public void setYyfy_ebz(Boolean yyfy_ebz) {
        this.yyfy_ebz = yyfy_ebz;
    }

    public Boolean getZkd_zc() {
        return zkd_zc;
    }

    public void setZkd_zc(Boolean zkd_zc) {
        this.zkd_zc = zkd_zc;
    }

    public Boolean getZkd_1() {
        return zkd_1;
    }

    public void setZkd_1(Boolean zkd_1) {
        this.zkd_1 = zkd_1;
    }

    public Boolean getZkd_2() {
        return zkd_2;
    }

    public void setZkd_2(Boolean zkd_2) {
        this.zkd_2 = zkd_2;
    }

    public Boolean getZkd_3() {
        return zkd_3;
    }

    public void setZkd_3(Boolean zkd_3) {
        this.zkd_3 = zkd_3;
    }

    public Boolean getXgn_1() {
        return xgn_1;
    }

    public void setXgn_1(Boolean xgn_1) {
        this.xgn_1 = xgn_1;
    }

    public Boolean getXgn_2() {
        return xgn_2;
    }

    public void setXgn_2(Boolean xgn_2) {
        this.xgn_2 = xgn_2;
    }

    public Boolean getXgn_3() {
        return xgn_3;
    }

    public void setXgn_3(Boolean xgn_3) {
        this.xgn_3 = xgn_3;
    }

    public Boolean getXgn_4() {
        return xgn_4;
    }

    public void setXgn_4(Boolean xgn_4) {
        this.xgn_4 = xgn_4;
    }

    public Boolean getAsa_1() {
        return asa_1;
    }

    public void setAsa_1(Boolean asa_1) {
        this.asa_1 = asa_1;
    }

    public Boolean getAsa_2() {
        return asa_2;
    }

    public void setAsa_2(Boolean asa_2) {
        this.asa_2 = asa_2;
    }

    public Boolean getAsa_3() {
        return asa_3;
    }

    public void setAsa_3(Boolean asa_3) {
        this.asa_3 = asa_3;
    }

    public Boolean getAsa_4() {
        return asa_4;
    }

    public void setAsa_4(Boolean asa_4) {
        this.asa_4 = asa_4;
    }

    public Boolean getAsa_5() {
        return asa_5;
    }

    public void setAsa_5(Boolean asa_5) {
        this.asa_5 = asa_5;
    }

    public String getBrxm() {
        return brxm;
    }

    public void setBrxm(String brxm) {
        this.brxm = brxm;
    }

    public String getKsmc() {
        return ksmc;
    }

    public void setKsmc(String ksmc) {
        this.ksmc = ksmc;
    }

    public String getZych() {
        return zych;
    }

    public void setZych(String zych) {
        this.zych = zych;
    }

    public String getZyh() {
        return zyh;
    }

    public void setZyh(String zyh) {
        this.zyh = zyh;
    }

    public String getBrxm2() {
        return brxm2;
    }

    public void setBrxm2(String brxm2) {
        this.brxm2 = brxm2;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public String getNl() {
        return nl;
    }

    public void setNl(String nl) {
        this.nl = nl;
    }

    public String getZyh2() {
        return zyh2;
    }

    public void setZyh2(String zyh2) {
        this.zyh2 = zyh2;
    }

    public String getCh() {
        return ch;
    }

    public void setCh(String ch) {
        this.ch = ch;
    }

    public String getKs() {
        return ks;
    }

    public void setKs(String ks) {
        this.ks = ks;
    }

    public String getTw() {
        return tw;
    }

    public void setTw(String tw) {
        this.tw = tw;
    }

    public String getHx() {
        return hx;
    }

    public void setHx(String hx) {
        this.hx = hx;
    }

    public String getMb() {
        return mb;
    }

    public void setMb(String mb) {
        this.mb = mb;
    }

    public String getXl() {
        return xl;
    }

    public void setXl(String xl) {
        this.xl = xl;
    }

    public String getXy() {
        return xy;
    }

    public void setXy(String xy) {
        this.xy = xy;
    }

    public String getSqzd() {
        return sqzd;
    }

    public void setSqzd(String sqzd) {
        this.sqzd = sqzd;
    }

    public String getNsss() {
        return nsss;
    }

    public void setNsss(String nsss) {
        this.nsss = nsss;
    }

    public String getNsmzff() {
        return nsmzff;
    }

    public void setNsmzff(String nsmzff) {
        this.nsmzff = nsmzff;
    }

    public String getSqhbjb() {
        return sqhbjb;
    }

    public void setSqhbjb(String sqhbjb) {
        this.sqhbjb = sqhbjb;
    }

    public String getXcg() {
        return xcg;
    }

    public void setXcg(String xcg) {
        this.xcg = xcg;
    }

    public String getXx() {
        return xx;
    }

    public void setXx(String xx) {
        this.xx = xx;
    }

    public String getNxcg() {
        return nxcg;
    }

    public void setNxcg(String nxcg) {
        this.nxcg = nxcg;
    }

    public String getGgn() {
        return ggn;
    }

    public void setGgn(String ggn) {
        this.ggn = ggn;
    }

    public String getSgn() {
        return sgn;
    }

    public void setSgn(String sgn) {
        this.sgn = sgn;
    }

    public String getYg() {
        return yg;
    }

    public void setYg(String yg) {
        this.yg = yg;
    }

    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }

    public String getAzb() {
        return azb;
    }

    public void setAzb(String azb) {
        this.azb = azb;
    }

    public String getMd() {
        return md;
    }

    public void setMd(String md) {
        this.md = md;
    }

    public String getNcg() {
        return ncg;
    }

    public void setNcg(String ncg) {
        this.ncg = ncg;
    }

    public String getDbcg() {
        return dbcg;
    }

    public void setDbcg(String dbcg) {
        this.dbcg = dbcg;
    }

    public String getDjz() {
        return djz;
    }

    public void setDjz(String djz) {
        this.djz = djz;
    }

    public String getXp() {
        return xp;
    }

    public void setXp(String xp) {
        this.xp = xp;
    }

    public String getXdt() {
        return xdt;
    }

    public void setXdt(String xdt) {
        this.xdt = xdt;
    }

    public String getMygms() {
        return mygms;
    }

    public void setMygms(String mygms) {
        this.mygms = mygms;
    }

    public String getGqmzs() {
        return gqmzs;
    }

    public void setGqmzs(String gqmzs) {
        this.gqmzs = gqmzs;
    }

    public String getFsys() {
        return fsys;
    }

    public void setFsys(String fsys) {
        this.fsys = fsys;
    }

    public String getFssj() {
        return fssj;
    }

    public void setFssj(String fssj) {
        this.fssj = fssj;
    }
}
