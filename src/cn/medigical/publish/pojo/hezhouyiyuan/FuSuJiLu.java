package cn.medigical.publish.pojo.hezhouyiyuan;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FuSuJiLu {
    /**联合*/
    private BooleanProperty mzfs_lh;
    /**全麻*/
    private BooleanProperty mzfs_qm;
    /**椎管内*/
    private BooleanProperty mzfs_zgn;
    /**有*/
    private BooleanProperty xkdh_y;
    /**无*/
    private BooleanProperty xkdh_w;
    /**有*/
    private BooleanProperty dmdg_y;
    /**无*/
    private BooleanProperty dmdg_w;
    /**已拔除*/
    private BooleanProperty dmdg_ybc;
    /**PCIA*/
    private BooleanProperty shzt_pcia;
    /**PCEA*/
    private BooleanProperty shzt_pcya;
    /**无*/
    private BooleanProperty shzt_w;
    /**已接口*/
    private BooleanProperty shzt_yjk;
    /**意识同术前*/
    private BooleanProperty hszbqk_lh;
    /**呼之能应*/
    private BooleanProperty hszbqk_yb;
    /**不能唤醒*/
    private BooleanProperty hszbqk_jc;
    /**是*/
    private BooleanProperty sysy_y;
    /**否*/
    private BooleanProperty sysy_n;
    /**病房*/
    private BooleanProperty bf;
    /**ICU*/
    private BooleanProperty icu;
    /**疼痛*/
    private BooleanProperty tt;
    /**尿管不适*/
    private BooleanProperty ngbs;
    /**寒颤*/
    private BooleanProperty hc;
    /**恶心呕吐*/
    private BooleanProperty exot;
    /**躁动*/
    private BooleanProperty zd;
    /**呼吸抑制*/
    private BooleanProperty hxyz;
    /**再查管*/
    private BooleanProperty zcg;
    /**低体温*/
    private BooleanProperty dtw;
    /**其他*/
    private BooleanProperty qt;
    /**解决*/
    private BooleanProperty jj;
    /**缓解*/
    private BooleanProperty hj;
    /**不能解决*/
    private BooleanProperty bnjj;
    /**科别*/
    private StringProperty ksmc;
    /**姓名:HBox.hgrow=ALWAYS*/
    private StringProperty brxm;
    /**性别:*/
    private StringProperty xb;
    /**年龄:*/
    private StringProperty nl;
    /**床号:*/
    private StringProperty zych;
    /**住院号:*/
    private StringProperty zyh;
    /**日期*/
    private StringProperty rq;
    /**术后诊断:*/
    private StringProperty shzd;
    /**已施手术:*/
    private StringProperty ysss1;
    /**时间*/
    private StringProperty sqqd_nyq;
    /**时间*/
    private StringProperty sqqd_als;
    /**时间*/
    private StringProperty sqqd_dwxg;
    /**时间*/
    private StringProperty sqqd_zwxgq;
    /**时间*/
    private StringProperty sqqd_xwxgq;
    /**时间*/
    private StringProperty sqqd_dzxgq;
    /**时间*/
    private StringProperty sqqd_zzxgq;
    /**时间*/
    private StringProperty sqqd_xzxgq;
    /**时间*/
    private StringProperty sqqd_ywxgq;
    /**时间*/
    private StringProperty sqqd_yzxgq;
    /**时间*/
    private StringProperty sqqd_bjq;
    /**时间*/
    private StringProperty sqqd_czq;
    /**时间*/
    private StringProperty sqqd_db;
    /**血压*/
    private StringProperty gqhd_nyq;
    /**血压*/
    private StringProperty gqhd_als;
    /**血压*/
    private StringProperty gqhd_dwxg;
    /**血压*/
    private StringProperty gqhd_zwxgq;
    /**血压*/
    private StringProperty gqhd_xwxgq;
    /**血压*/
    private StringProperty gqhd_dzxgq;
    /**血压*/
    private StringProperty gqhd_zzxgq;
    /**血压*/
    private StringProperty gqhd_xzxgq;
    /**血压*/
    private StringProperty gqhd_ywxgq;
    /**血压*/
    private StringProperty gqhd_yzxgq;
    /**血压*/
    private StringProperty gqhd_bjq;
    /**血压*/
    private StringProperty gqhd_czq;
    /**血压*/
    private StringProperty gqhd_db;
    /**心率*/
    private StringProperty ghhd_nyq;
    /**心率*/
    private StringProperty ghhd_als;
    /**心率*/
    private StringProperty ghhd_dwxg;
    /**心率*/
    private StringProperty ghhd_zwxgq;
    /**心率*/
    private StringProperty ghhd_xwxgq;
    /**心率*/
    private StringProperty ghhd_dzxgq;
    /**心率*/
    private StringProperty ghhd_zzxgq;
    /**心率*/
    private StringProperty ghhd_xzxgq;
    /**心率*/
    private StringProperty ghhd_ywxgq;
    /**心率*/
    private StringProperty ghhd_yzxgq;
    /**心率*/
    private StringProperty ghhd_bjq;
    /**心率*/
    private StringProperty ghhd_czq;
    /**心率*/
    private StringProperty ghhd_db;
    /**呼吸*/
    private StringProperty sbhd_nyq;
    /**呼吸*/
    private StringProperty sbhd_als;
    /**呼吸*/
    private StringProperty sbhd_dwxg;
    /**呼吸*/
    private StringProperty sbhd_zwxgq;
    /**呼吸*/
    private StringProperty sbhd_xwxgq;
    /**呼吸*/
    private StringProperty sbhd_dzxgq;
    /**呼吸*/
    private StringProperty sbhd_zzxgq;
    /**呼吸*/
    private StringProperty sbhd_xzxgq;
    /**呼吸*/
    private StringProperty sbhd_ywxgq;
    /**呼吸*/
    private StringProperty sbhd_yzxgq;
    /**呼吸*/
    private StringProperty sbhd_bjq;
    /**呼吸*/
    private StringProperty sbhd_czq;
    /**呼吸*/
    private StringProperty sbhd_db;
    /**氧饱和*/
    private StringProperty sqqd_jd;
    /**氧饱和*/
    private StringProperty sqqd_nz;
    /**氧饱和*/
    private StringProperty sqqd_lg;
    /**氧饱和*/
    private StringProperty sqqd_xg;
    /**氧饱和*/
    private StringProperty sqqd_ddt;
    /**氧饱和*/
    private StringProperty sqqd_wq;
    /**氧饱和*/
    private StringProperty sqqd_cq;
    /**氧饱和*/
    private StringProperty sqqd_qsq;
    /**氧饱和*/
    private StringProperty sqqd_ddtz;
    /**氧饱和*/
    private StringProperty sqqd_ddgc;
    /**氧饱和*/
    private StringProperty sqqd_ycxgq;
    /**氧饱和*/
    private StringProperty sqqd_zjwq;
    /**氧饱和*/
    private StringProperty sqqd_ycb;
    /**心电图*/
    private StringProperty gqhd_jd;
    /**心电图*/
    private StringProperty gqhd_nz;
    /**心电图*/
    private StringProperty gqhd_lg;
    /**心电图*/
    private StringProperty gqhd_xg;
    /**心电图*/
    private StringProperty gqhd_ddt;
    /**心电图*/
    private StringProperty gqhd_wq;
    /**心电图*/
    private StringProperty gqhd_cq;
    /**心电图*/
    private StringProperty gqhd_qsq;
    /**心电图*/
    private StringProperty gqhd_ddtz;
    /**心电图*/
    private StringProperty gqhd_ddgc;
    /**心电图*/
    private StringProperty gqhd_ycxgq;
    /**心电图*/
    private StringProperty gqhd_zjwq;
    /**心电图*/
    private StringProperty gqhd_ycb;
    /**氧浓度*/
    private StringProperty ghhd_jd;
    /**氧浓度*/
    private StringProperty ghhd_nz;
    /**氧浓度*/
    private StringProperty ghhd_lg;
    /**氧浓度*/
    private StringProperty ghhd_xg;
    /**氧浓度*/
    private StringProperty ghhd_ddt;
    /**氧浓度*/
    private StringProperty ghhd_wq;
    /**氧浓度*/
    private StringProperty ghhd_cq;
    /**氧浓度*/
    private StringProperty ghhd_qsq;
    /**氧浓度*/
    private StringProperty ghhd_ddtz;
    /**氧浓度*/
    private StringProperty ghhd_ddgc;
    /**氧浓度*/
    private StringProperty ghhd_ycxgq;
    /**氧浓度*/
    private StringProperty ghhd_zjwq;
    /**氧浓度*/
    private StringProperty ghhd_ycb;
    /**用药及备注*/
    private StringProperty sbhd_jd;
    /**用药及备注*/
    private StringProperty sbhd_nz;
    /**用药及备注*/
    private StringProperty sbhd_lg;
    /**用药及备注*/
    private StringProperty sbhd_xg;
    /**用药及备注*/
    private StringProperty sbhd_ddt;
    /**用药及备注*/
    private StringProperty sbhd_wq;
    /**用药及备注*/
    private StringProperty sbhd_cq;
    /**用药及备注*/
    private StringProperty sbhd_qsq;
    /**用药及备注*/
    private StringProperty sbhd_ddtz;
    /**用药及备注*/
    private StringProperty sbhd_ddgc;
    /**用药及备注*/
    private StringProperty sbhd_ycxgq;
    /**用药及备注*/
    private StringProperty sbhd_zjwq;
    /**用药及备注*/
    private StringProperty sbhd_ycb;
    /**通知医生*/
    private StringProperty sbhd_tsqx;
    /**通知医生*/
    private StringProperty sbhd_lsd;
    /**通知医生*/
    private StringProperty sbhd_qt1;
    /**通知医生*/
    private StringProperty sbhd_qt2;
    /**通知医生*/
    private StringProperty sbhd_qt3;
    /**通知医生*/
    private StringProperty sbhd_qt4;
    /**通知医生*/
    private StringProperty sbhd_qt5;
    /**通知医生*/
    private StringProperty sbhd_qt6;
    /**通知医生*/
    private StringProperty sbhd_qt7;
    /**通知医生*/
    private StringProperty sbhd_qt8;
    /**通知医生*/
    private StringProperty sbhd_qt9;
    /**通知医生*/
    private StringProperty sbhd_qt10;
    /**通知医生*/
    private StringProperty sbhd_qt11;
    /**ICU*/
    private StringProperty qx;
    /**VAS*/
    private StringProperty vas;
    /**其他*/
    private StringProperty qttext;
    /**麻醉人员*/
    private StringProperty mzry;
    /**记录人员*/
    private StringProperty jlry;

    public boolean isMzfs_lh() {
        return mzfs_lh.get();
    }
    public BooleanProperty mzfs_lhProperty() {
        if(mzfs_lh==null){
            mzfs_lh = new SimpleBooleanProperty(false);
        }
        return mzfs_lh;
    }
    public void setMzfs_lh(boolean mzfs_lh) {
        this.mzfs_lh.set(mzfs_lh);
    }
    public boolean isMzfs_qm() {
        return mzfs_qm.get();
    }
    public BooleanProperty mzfs_qmProperty() {
        if(mzfs_qm==null){
            mzfs_qm = new SimpleBooleanProperty(false);
        }
        return mzfs_qm;
    }
    public void setMzfs_qm(boolean mzfs_qm) {
        this.mzfs_qm.set(mzfs_qm);
    }
    public boolean isMzfs_zgn() {
        return mzfs_zgn.get();
    }
    public BooleanProperty mzfs_zgnProperty() {
        if(mzfs_zgn==null){
            mzfs_zgn = new SimpleBooleanProperty(false);
        }
        return mzfs_zgn;
    }
    public void setMzfs_zgn(boolean mzfs_zgn) {
        this.mzfs_zgn.set(mzfs_zgn);
    }
    public boolean isXkdh_y() {
        return xkdh_y.get();
    }
    public BooleanProperty xkdh_yProperty() {
        if(xkdh_y==null){
            xkdh_y = new SimpleBooleanProperty(false);
        }
        return xkdh_y;
    }
    public void setXkdh_y(boolean xkdh_y) {
        this.xkdh_y.set(xkdh_y);
    }
    public boolean isXkdh_w() {
        return xkdh_w.get();
    }
    public BooleanProperty xkdh_wProperty() {
        if(xkdh_w==null){
            xkdh_w = new SimpleBooleanProperty(false);
        }
        return xkdh_w;
    }
    public void setXkdh_w(boolean xkdh_w) {
        this.xkdh_w.set(xkdh_w);
    }
    public boolean isDmdg_y() {
        return dmdg_y.get();
    }
    public BooleanProperty dmdg_yProperty() {
        if(dmdg_y==null){
            dmdg_y = new SimpleBooleanProperty(false);
        }
        return dmdg_y;
    }
    public void setDmdg_y(boolean dmdg_y) {
        this.dmdg_y.set(dmdg_y);
    }
    public boolean isDmdg_w() {
        return dmdg_w.get();
    }
    public BooleanProperty dmdg_wProperty() {
        if(dmdg_w==null){
            dmdg_w = new SimpleBooleanProperty(false);
        }
        return dmdg_w;
    }
    public void setDmdg_w(boolean dmdg_w) {
        this.dmdg_w.set(dmdg_w);
    }
    public boolean isDmdg_ybc() {
        return dmdg_ybc.get();
    }
    public BooleanProperty dmdg_ybcProperty() {
        if(dmdg_ybc==null){
            dmdg_ybc = new SimpleBooleanProperty(false);
        }
        return dmdg_ybc;
    }
    public void setDmdg_ybc(boolean dmdg_ybc) {
        this.dmdg_ybc.set(dmdg_ybc);
    }
    public boolean isShzt_pcia() {
        return shzt_pcia.get();
    }
    public BooleanProperty shzt_pciaProperty() {
        if(shzt_pcia==null){
            shzt_pcia = new SimpleBooleanProperty(false);
        }
        return shzt_pcia;
    }
    public void setShzt_pcia(boolean shzt_pcia) {
        this.shzt_pcia.set(shzt_pcia);
    }
    public boolean isShzt_pcya() {
        return shzt_pcya.get();
    }
    public BooleanProperty shzt_pcyaProperty() {
        if(shzt_pcya==null){
            shzt_pcya = new SimpleBooleanProperty(false);
        }
        return shzt_pcya;
    }
    public void setShzt_pcya(boolean shzt_pcya) {
        this.shzt_pcya.set(shzt_pcya);
    }
    public boolean isShzt_w() {
        return shzt_w.get();
    }
    public BooleanProperty shzt_wProperty() {
        if(shzt_w==null){
            shzt_w = new SimpleBooleanProperty(false);
        }
        return shzt_w;
    }
    public void setShzt_w(boolean shzt_w) {
        this.shzt_w.set(shzt_w);
    }
    public boolean isShzt_yjk() {
        return shzt_yjk.get();
    }
    public BooleanProperty shzt_yjkProperty() {
        if(shzt_yjk==null){
            shzt_yjk = new SimpleBooleanProperty(false);
        }
        return shzt_yjk;
    }
    public void setShzt_yjk(boolean shzt_yjk) {
        this.shzt_yjk.set(shzt_yjk);
    }
    public boolean isHszbqk_lh() {
        return hszbqk_lh.get();
    }
    public BooleanProperty hszbqk_lhProperty() {
        if(hszbqk_lh==null){
            hszbqk_lh = new SimpleBooleanProperty(false);
        }
        return hszbqk_lh;
    }
    public void setHszbqk_lh(boolean hszbqk_lh) {
        this.hszbqk_lh.set(hszbqk_lh);
    }
    public boolean isHszbqk_yb() {
        return hszbqk_yb.get();
    }
    public BooleanProperty hszbqk_ybProperty() {
        if(hszbqk_yb==null){
            hszbqk_yb = new SimpleBooleanProperty(false);
        }
        return hszbqk_yb;
    }
    public void setHszbqk_yb(boolean hszbqk_yb) {
        this.hszbqk_yb.set(hszbqk_yb);
    }
    public boolean isHszbqk_jc() {
        return hszbqk_jc.get();
    }
    public BooleanProperty hszbqk_jcProperty() {
        if(hszbqk_jc==null){
            hszbqk_jc = new SimpleBooleanProperty(false);
        }
        return hszbqk_jc;
    }
    public void setHszbqk_jc(boolean hszbqk_jc) {
        this.hszbqk_jc.set(hszbqk_jc);
    }
    public boolean isSysy_y() {
        return sysy_y.get();
    }
    public BooleanProperty sysy_yProperty() {
        if(sysy_y==null){
            sysy_y = new SimpleBooleanProperty(false);
        }
        return sysy_y;
    }
    public void setSysy_y(boolean sysy_y) {
        this.sysy_y.set(sysy_y);
    }
    public boolean isSysy_n() {
        return sysy_n.get();
    }
    public BooleanProperty sysy_nProperty() {
        if(sysy_n==null){
            sysy_n = new SimpleBooleanProperty(false);
        }
        return sysy_n;
    }
    public void setSysy_n(boolean sysy_n) {
        this.sysy_n.set(sysy_n);
    }
    public boolean isBf() {
        return bf.get();
    }
    public BooleanProperty bfProperty() {
        if(bf==null){
            bf = new SimpleBooleanProperty(false);
        }
        return bf;
    }
    public void setBf(boolean bf) {
        this.bf.set(bf);
    }
    public boolean isIcu() {
        return icu.get();
    }
    public BooleanProperty icuProperty() {
        if(icu==null){
            icu = new SimpleBooleanProperty(false);
        }
        return icu;
    }
    public void setIcu(boolean icu) {
        this.icu.set(icu);
    }
    public boolean isTt() {
        return tt.get();
    }
    public BooleanProperty ttProperty() {
        if(tt==null){
            tt = new SimpleBooleanProperty(false);
        }
        return tt;
    }
    public void setTt(boolean tt) {
        this.tt.set(tt);
    }
    public boolean isNgbs() {
        return ngbs.get();
    }
    public BooleanProperty ngbsProperty() {
        if(ngbs==null){
            ngbs = new SimpleBooleanProperty(false);
        }
        return ngbs;
    }
    public void setNgbs(boolean ngbs) {
        this.ngbs.set(ngbs);
    }
    public boolean isHc() {
        return hc.get();
    }
    public BooleanProperty hcProperty() {
        if(hc==null){
            hc = new SimpleBooleanProperty(false);
        }
        return hc;
    }
    public void setHc(boolean hc) {
        this.hc.set(hc);
    }
    public boolean isExot() {
        return exot.get();
    }
    public BooleanProperty exotProperty() {
        if(exot==null){
            exot = new SimpleBooleanProperty(false);
        }
        return exot;
    }
    public void setExot(boolean exot) {
        this.exot.set(exot);
    }
    public boolean isZd() {
        return zd.get();
    }
    public BooleanProperty zdProperty() {
        if(zd==null){
            zd = new SimpleBooleanProperty(false);
        }
        return zd;
    }
    public void setZd(boolean zd) {
        this.zd.set(zd);
    }
    public boolean isHxyz() {
        return hxyz.get();
    }
    public BooleanProperty hxyzProperty() {
        if(hxyz==null){
            hxyz = new SimpleBooleanProperty(false);
        }
        return hxyz;
    }
    public void setHxyz(boolean hxyz) {
        this.hxyz.set(hxyz);
    }
    public boolean isZcg() {
        return zcg.get();
    }
    public BooleanProperty zcgProperty() {
        if(zcg==null){
            zcg = new SimpleBooleanProperty(false);
        }
        return zcg;
    }
    public void setZcg(boolean zcg) {
        this.zcg.set(zcg);
    }
    public boolean isDtw() {
        return dtw.get();
    }
    public BooleanProperty dtwProperty() {
        if(dtw==null){
            dtw = new SimpleBooleanProperty(false);
        }
        return dtw;
    }
    public void setDtw(boolean dtw) {
        this.dtw.set(dtw);
    }
    public boolean isQt() {
        return qt.get();
    }
    public BooleanProperty qtProperty() {
        if(qt==null){
            qt = new SimpleBooleanProperty(false);
        }
        return qt;
    }
    public void setQt(boolean qt) {
        this.qt.set(qt);
    }
    public boolean isJj() {
        return jj.get();
    }
    public BooleanProperty jjProperty() {
        if(jj==null){
            jj = new SimpleBooleanProperty(false);
        }
        return jj;
    }
    public void setJj(boolean jj) {
        this.jj.set(jj);
    }
    public boolean isHj() {
        return hj.get();
    }
    public BooleanProperty hjProperty() {
        if(hj==null){
            hj = new SimpleBooleanProperty(false);
        }
        return hj;
    }
    public void setHj(boolean hj) {
        this.hj.set(hj);
    }
    public boolean isBnjj() {
        return bnjj.get();
    }
    public BooleanProperty bnjjProperty() {
        if(bnjj==null){
            bnjj = new SimpleBooleanProperty(false);
        }
        return bnjj;
    }
    public void setBnjj(boolean bnjj) {
        this.bnjj.set(bnjj);
    }

    public String getKsmc() {
        return ksmc.get();
    }
    public StringProperty ksmcProperty() {
        if(ksmc==null){
            ksmc = new SimpleStringProperty();
        }
        return ksmc;
    }
    public void setKsmc(String ksmc) {
        this.ksmc.set(ksmc);
    }
    public String getBrxm() {
        return brxm.get();
    }
    public StringProperty brxmProperty() {
        if(brxm==null){
            brxm = new SimpleStringProperty();
        }
        return brxm;
    }
    public void setBrxm(String brxm) {
        this.brxm.set(brxm);
    }
    public String getXb() {
        return xb.get();
    }
    public StringProperty xbProperty() {
        if(xb==null){
            xb = new SimpleStringProperty();
        }
        return xb;
    }
    public void setXb(String xb) {
        this.xb.set(xb);
    }
    public String getNl() {
        return nl.get();
    }
    public StringProperty nlProperty() {
        if(nl==null){
            nl = new SimpleStringProperty();
        }
        return nl;
    }
    public void setNl(String nl) {
        this.nl.set(nl);
    }
    public String getZych() {
        return zych.get();
    }
    public StringProperty zychProperty() {
        if(zych==null){
            zych = new SimpleStringProperty();
        }
        return zych;
    }
    public void setZych(String zych) {
        this.zych.set(zych);
    }
    public String getZhuYuanHao() {
        return zyh.get();
    }
    public StringProperty zyhProperty() {
        if(zyh==null){
            zyh = new SimpleStringProperty();
        }
        return zyh;
    }
    public void setZyh(String zyh) {
        this.zyh.set(zyh);
    }
    public String getRq() {
        return rq.get();
    }
    public StringProperty rqProperty() {
        if(rq==null){
            rq = new SimpleStringProperty();
        }
        return rq;
    }
    public void setRq(String rq) {
        this.rq.set(rq);
    }
    public String getShzd() {
        return shzd.get();
    }
    public StringProperty shzdProperty() {
        if(shzd==null){
            shzd = new SimpleStringProperty();
        }
        return shzd;
    }
    public void setShzd(String shzd) {
        this.shzd.set(shzd);
    }
    public String getYsss1() {
        return ysss1.get();
    }
    public StringProperty ysss1Property() {
        if(ysss1==null){
            ysss1 = new SimpleStringProperty();
        }
        return ysss1;
    }
    public void setYsss1(String ysss1) {
        this.ysss1.set(ysss1);
    }
    public String getSqqd_nyq() {
        return sqqd_nyq.get();
    }
    public StringProperty sqqd_nyqProperty() {
        if(sqqd_nyq==null){
            sqqd_nyq = new SimpleStringProperty();
        }
        return sqqd_nyq;
    }
    public void setSqqd_nyq(String sqqd_nyq) {
        this.sqqd_nyq.set(sqqd_nyq);
    }
    public String getSqqd_als() {
        return sqqd_als.get();
    }
    public StringProperty sqqd_alsProperty() {
        if(sqqd_als==null){
            sqqd_als = new SimpleStringProperty();
        }
        return sqqd_als;
    }
    public void setSqqd_als(String sqqd_als) {
        this.sqqd_als.set(sqqd_als);
    }
    public String getSqqd_dwxg() {
        return sqqd_dwxg.get();
    }
    public StringProperty sqqd_dwxgProperty() {
        if(sqqd_dwxg==null){
            sqqd_dwxg = new SimpleStringProperty();
        }
        return sqqd_dwxg;
    }
    public void setSqqd_dwxg(String sqqd_dwxg) {
        this.sqqd_dwxg.set(sqqd_dwxg);
    }
    public String getSqqd_zwxgq() {
        return sqqd_zwxgq.get();
    }
    public StringProperty sqqd_zwxgqProperty() {
        if(sqqd_zwxgq==null){
            sqqd_zwxgq = new SimpleStringProperty();
        }
        return sqqd_zwxgq;
    }
    public void setSqqd_zwxgq(String sqqd_zwxgq) {
        this.sqqd_zwxgq.set(sqqd_zwxgq);
    }
    public String getSqqd_xwxgq() {
        return sqqd_xwxgq.get();
    }
    public StringProperty sqqd_xwxgqProperty() {
        if(sqqd_xwxgq==null){
            sqqd_xwxgq = new SimpleStringProperty();
        }
        return sqqd_xwxgq;
    }
    public void setSqqd_xwxgq(String sqqd_xwxgq) {
        this.sqqd_xwxgq.set(sqqd_xwxgq);
    }
    public String getSqqd_dzxgq() {
        return sqqd_dzxgq.get();
    }
    public StringProperty sqqd_dzxgqProperty() {
        if(sqqd_dzxgq==null){
            sqqd_dzxgq = new SimpleStringProperty();
        }
        return sqqd_dzxgq;
    }
    public void setSqqd_dzxgq(String sqqd_dzxgq) {
        this.sqqd_dzxgq.set(sqqd_dzxgq);
    }
    public String getSqqd_zzxgq() {
        return sqqd_zzxgq.get();
    }
    public StringProperty sqqd_zzxgqProperty() {
        if(sqqd_zzxgq==null){
            sqqd_zzxgq = new SimpleStringProperty();
        }
        return sqqd_zzxgq;
    }
    public void setSqqd_zzxgq(String sqqd_zzxgq) {
        this.sqqd_zzxgq.set(sqqd_zzxgq);
    }
    public String getSqqd_xzxgq() {
        return sqqd_xzxgq.get();
    }
    public StringProperty sqqd_xzxgqProperty() {
        if(sqqd_xzxgq==null){
            sqqd_xzxgq = new SimpleStringProperty();
        }
        return sqqd_xzxgq;
    }
    public void setSqqd_xzxgq(String sqqd_xzxgq) {
        this.sqqd_xzxgq.set(sqqd_xzxgq);
    }
    public String getSqqd_ywxgq() {
        return sqqd_ywxgq.get();
    }
    public StringProperty sqqd_ywxgqProperty() {
        if(sqqd_ywxgq==null){
            sqqd_ywxgq = new SimpleStringProperty();
        }
        return sqqd_ywxgq;
    }
    public void setSqqd_ywxgq(String sqqd_ywxgq) {
        this.sqqd_ywxgq.set(sqqd_ywxgq);
    }
    public String getSqqd_yzxgq() {
        return sqqd_yzxgq.get();
    }
    public StringProperty sqqd_yzxgqProperty() {
        if(sqqd_yzxgq==null){
            sqqd_yzxgq = new SimpleStringProperty();
        }
        return sqqd_yzxgq;
    }
    public void setSqqd_yzxgq(String sqqd_yzxgq) {
        this.sqqd_yzxgq.set(sqqd_yzxgq);
    }
    public String getSqqd_bjq() {
        return sqqd_bjq.get();
    }
    public StringProperty sqqd_bjqProperty() {
        if(sqqd_bjq==null){
            sqqd_bjq = new SimpleStringProperty();
        }
        return sqqd_bjq;
    }
    public void setSqqd_bjq(String sqqd_bjq) {
        this.sqqd_bjq.set(sqqd_bjq);
    }
    public String getSqqd_czq() {
        return sqqd_czq.get();
    }
    public StringProperty sqqd_czqProperty() {
        if(sqqd_czq==null){
            sqqd_czq = new SimpleStringProperty();
        }
        return sqqd_czq;
    }
    public void setSqqd_czq(String sqqd_czq) {
        this.sqqd_czq.set(sqqd_czq);
    }
    public String getSqqd_db() {
        return sqqd_db.get();
    }
    public StringProperty sqqd_dbProperty() {
        if(sqqd_db==null){
            sqqd_db = new SimpleStringProperty();
        }
        return sqqd_db;
    }
    public void setSqqd_db(String sqqd_db) {
        this.sqqd_db.set(sqqd_db);
    }
    public String getGqhd_nyq() {
        return gqhd_nyq.get();
    }
    public StringProperty gqhd_nyqProperty() {
        if(gqhd_nyq==null){
            gqhd_nyq = new SimpleStringProperty();
        }
        return gqhd_nyq;
    }
    public void setGqhd_nyq(String gqhd_nyq) {
        this.gqhd_nyq.set(gqhd_nyq);
    }
    public String getGqhd_als() {
        return gqhd_als.get();
    }
    public StringProperty gqhd_alsProperty() {
        if(gqhd_als==null){
            gqhd_als = new SimpleStringProperty();
        }
        return gqhd_als;
    }
    public void setGqhd_als(String gqhd_als) {
        this.gqhd_als.set(gqhd_als);
    }
    public String getGqhd_dwxg() {
        return gqhd_dwxg.get();
    }
    public StringProperty gqhd_dwxgProperty() {
        if(gqhd_dwxg==null){
            gqhd_dwxg = new SimpleStringProperty();
        }
        return gqhd_dwxg;
    }
    public void setGqhd_dwxg(String gqhd_dwxg) {
        this.gqhd_dwxg.set(gqhd_dwxg);
    }
    public String getGqhd_zwxgq() {
        return gqhd_zwxgq.get();
    }
    public StringProperty gqhd_zwxgqProperty() {
        if(gqhd_zwxgq==null){
            gqhd_zwxgq = new SimpleStringProperty();
        }
        return gqhd_zwxgq;
    }
    public void setGqhd_zwxgq(String gqhd_zwxgq) {
        this.gqhd_zwxgq.set(gqhd_zwxgq);
    }
    public String getGqhd_xwxgq() {
        return gqhd_xwxgq.get();
    }
    public StringProperty gqhd_xwxgqProperty() {
        if(gqhd_xwxgq==null){
            gqhd_xwxgq = new SimpleStringProperty();
        }
        return gqhd_xwxgq;
    }
    public void setGqhd_xwxgq(String gqhd_xwxgq) {
        this.gqhd_xwxgq.set(gqhd_xwxgq);
    }
    public String getGqhd_dzxgq() {
        return gqhd_dzxgq.get();
    }
    public StringProperty gqhd_dzxgqProperty() {
        if(gqhd_dzxgq==null){
            gqhd_dzxgq = new SimpleStringProperty();
        }
        return gqhd_dzxgq;
    }
    public void setGqhd_dzxgq(String gqhd_dzxgq) {
        this.gqhd_dzxgq.set(gqhd_dzxgq);
    }
    public String getGqhd_zzxgq() {
        return gqhd_zzxgq.get();
    }
    public StringProperty gqhd_zzxgqProperty() {
        if(gqhd_zzxgq==null){
            gqhd_zzxgq = new SimpleStringProperty();
        }
        return gqhd_zzxgq;
    }
    public void setGqhd_zzxgq(String gqhd_zzxgq) {
        this.gqhd_zzxgq.set(gqhd_zzxgq);
    }
    public String getGqhd_xzxgq() {
        return gqhd_xzxgq.get();
    }
    public StringProperty gqhd_xzxgqProperty() {
        if(gqhd_xzxgq==null){
            gqhd_xzxgq = new SimpleStringProperty();
        }
        return gqhd_xzxgq;
    }
    public void setGqhd_xzxgq(String gqhd_xzxgq) {
        this.gqhd_xzxgq.set(gqhd_xzxgq);
    }
    public String getGqhd_ywxgq() {
        return gqhd_ywxgq.get();
    }
    public StringProperty gqhd_ywxgqProperty() {
        if(gqhd_ywxgq==null){
            gqhd_ywxgq = new SimpleStringProperty();
        }
        return gqhd_ywxgq;
    }
    public void setGqhd_ywxgq(String gqhd_ywxgq) {
        this.gqhd_ywxgq.set(gqhd_ywxgq);
    }
    public String getGqhd_yzxgq() {
        return gqhd_yzxgq.get();
    }
    public StringProperty gqhd_yzxgqProperty() {
        if(gqhd_yzxgq==null){
            gqhd_yzxgq = new SimpleStringProperty();
        }
        return gqhd_yzxgq;
    }
    public void setGqhd_yzxgq(String gqhd_yzxgq) {
        this.gqhd_yzxgq.set(gqhd_yzxgq);
    }
    public String getGqhd_bjq() {
        return gqhd_bjq.get();
    }
    public StringProperty gqhd_bjqProperty() {
        if(gqhd_bjq==null){
            gqhd_bjq = new SimpleStringProperty();
        }
        return gqhd_bjq;
    }
    public void setGqhd_bjq(String gqhd_bjq) {
        this.gqhd_bjq.set(gqhd_bjq);
    }
    public String getGqhd_czq() {
        return gqhd_czq.get();
    }
    public StringProperty gqhd_czqProperty() {
        if(gqhd_czq==null){
            gqhd_czq = new SimpleStringProperty();
        }
        return gqhd_czq;
    }
    public void setGqhd_czq(String gqhd_czq) {
        this.gqhd_czq.set(gqhd_czq);
    }
    public String getGqhd_db() {
        return gqhd_db.get();
    }
    public StringProperty gqhd_dbProperty() {
        if(gqhd_db==null){
            gqhd_db = new SimpleStringProperty();
        }
        return gqhd_db;
    }
    public void setGqhd_db(String gqhd_db) {
        this.gqhd_db.set(gqhd_db);
    }
    public String getGhhd_nyq() {
        return ghhd_nyq.get();
    }
    public StringProperty ghhd_nyqProperty() {
        if(ghhd_nyq==null){
            ghhd_nyq = new SimpleStringProperty();
        }
        return ghhd_nyq;
    }
    public void setGhhd_nyq(String ghhd_nyq) {
        this.ghhd_nyq.set(ghhd_nyq);
    }
    public String getGhhd_als() {
        return ghhd_als.get();
    }
    public StringProperty ghhd_alsProperty() {
        if(ghhd_als==null){
            ghhd_als = new SimpleStringProperty();
        }
        return ghhd_als;
    }
    public void setGhhd_als(String ghhd_als) {
        this.ghhd_als.set(ghhd_als);
    }
    public String getGhhd_dwxg() {
        return ghhd_dwxg.get();
    }
    public StringProperty ghhd_dwxgProperty() {
        if(ghhd_dwxg==null){
            ghhd_dwxg = new SimpleStringProperty();
        }
        return ghhd_dwxg;
    }
    public void setGhhd_dwxg(String ghhd_dwxg) {
        this.ghhd_dwxg.set(ghhd_dwxg);
    }
    public String getGhhd_zwxgq() {
        return ghhd_zwxgq.get();
    }
    public StringProperty ghhd_zwxgqProperty() {
        if(ghhd_zwxgq==null){
            ghhd_zwxgq = new SimpleStringProperty();
        }
        return ghhd_zwxgq;
    }
    public void setGhhd_zwxgq(String ghhd_zwxgq) {
        this.ghhd_zwxgq.set(ghhd_zwxgq);
    }
    public String getGhhd_xwxgq() {
        return ghhd_xwxgq.get();
    }
    public StringProperty ghhd_xwxgqProperty() {
        if(ghhd_xwxgq==null){
            ghhd_xwxgq = new SimpleStringProperty();
        }
        return ghhd_xwxgq;
    }
    public void setGhhd_xwxgq(String ghhd_xwxgq) {
        this.ghhd_xwxgq.set(ghhd_xwxgq);
    }
    public String getGhhd_dzxgq() {
        return ghhd_dzxgq.get();
    }
    public StringProperty ghhd_dzxgqProperty() {
        if(ghhd_dzxgq==null){
            ghhd_dzxgq = new SimpleStringProperty();
        }
        return ghhd_dzxgq;
    }
    public void setGhhd_dzxgq(String ghhd_dzxgq) {
        this.ghhd_dzxgq.set(ghhd_dzxgq);
    }
    public String getGhhd_zzxgq() {
        return ghhd_zzxgq.get();
    }
    public StringProperty ghhd_zzxgqProperty() {
        if(ghhd_zzxgq==null){
            ghhd_zzxgq = new SimpleStringProperty();
        }
        return ghhd_zzxgq;
    }
    public void setGhhd_zzxgq(String ghhd_zzxgq) {
        this.ghhd_zzxgq.set(ghhd_zzxgq);
    }
    public String getGhhd_xzxgq() {
        return ghhd_xzxgq.get();
    }
    public StringProperty ghhd_xzxgqProperty() {
        if(ghhd_xzxgq==null){
            ghhd_xzxgq = new SimpleStringProperty();
        }
        return ghhd_xzxgq;
    }
    public void setGhhd_xzxgq(String ghhd_xzxgq) {
        this.ghhd_xzxgq.set(ghhd_xzxgq);
    }
    public String getGhhd_ywxgq() {
        return ghhd_ywxgq.get();
    }
    public StringProperty ghhd_ywxgqProperty() {
        if(ghhd_ywxgq==null){
            ghhd_ywxgq = new SimpleStringProperty();
        }
        return ghhd_ywxgq;
    }
    public void setGhhd_ywxgq(String ghhd_ywxgq) {
        this.ghhd_ywxgq.set(ghhd_ywxgq);
    }
    public String getGhhd_yzxgq() {
        return ghhd_yzxgq.get();
    }
    public StringProperty ghhd_yzxgqProperty() {
        if(ghhd_yzxgq==null){
            ghhd_yzxgq = new SimpleStringProperty();
        }
        return ghhd_yzxgq;
    }
    public void setGhhd_yzxgq(String ghhd_yzxgq) {
        this.ghhd_yzxgq.set(ghhd_yzxgq);
    }
    public String getGhhd_bjq() {
        return ghhd_bjq.get();
    }
    public StringProperty ghhd_bjqProperty() {
        if(ghhd_bjq==null){
            ghhd_bjq = new SimpleStringProperty();
        }
        return ghhd_bjq;
    }
    public void setGhhd_bjq(String ghhd_bjq) {
        this.ghhd_bjq.set(ghhd_bjq);
    }
    public String getGhhd_czq() {
        return ghhd_czq.get();
    }
    public StringProperty ghhd_czqProperty() {
        if(ghhd_czq==null){
            ghhd_czq = new SimpleStringProperty();
        }
        return ghhd_czq;
    }
    public void setGhhd_czq(String ghhd_czq) {
        this.ghhd_czq.set(ghhd_czq);
    }
    public String getGhhd_db() {
        return ghhd_db.get();
    }
    public StringProperty ghhd_dbProperty() {
        if(ghhd_db==null){
            ghhd_db = new SimpleStringProperty();
        }
        return ghhd_db;
    }
    public void setGhhd_db(String ghhd_db) {
        this.ghhd_db.set(ghhd_db);
    }
    public String getSbhd_nyq() {
        return sbhd_nyq.get();
    }
    public StringProperty sbhd_nyqProperty() {
        if(sbhd_nyq==null){
            sbhd_nyq = new SimpleStringProperty();
        }
        return sbhd_nyq;
    }
    public void setSbhd_nyq(String sbhd_nyq) {
        this.sbhd_nyq.set(sbhd_nyq);
    }
    public String getSbhd_als() {
        return sbhd_als.get();
    }
    public StringProperty sbhd_alsProperty() {
        if(sbhd_als==null){
            sbhd_als = new SimpleStringProperty();
        }
        return sbhd_als;
    }
    public void setSbhd_als(String sbhd_als) {
        this.sbhd_als.set(sbhd_als);
    }
    public String getSbhd_dwxg() {
        return sbhd_dwxg.get();
    }
    public StringProperty sbhd_dwxgProperty() {
        if(sbhd_dwxg==null){
            sbhd_dwxg = new SimpleStringProperty();
        }
        return sbhd_dwxg;
    }
    public void setSbhd_dwxg(String sbhd_dwxg) {
        this.sbhd_dwxg.set(sbhd_dwxg);
    }
    public String getSbhd_zwxgq() {
        return sbhd_zwxgq.get();
    }
    public StringProperty sbhd_zwxgqProperty() {
        if(sbhd_zwxgq==null){
            sbhd_zwxgq = new SimpleStringProperty();
        }
        return sbhd_zwxgq;
    }
    public void setSbhd_zwxgq(String sbhd_zwxgq) {
        this.sbhd_zwxgq.set(sbhd_zwxgq);
    }
    public String getSbhd_xwxgq() {
        return sbhd_xwxgq.get();
    }
    public StringProperty sbhd_xwxgqProperty() {
        if(sbhd_xwxgq==null){
            sbhd_xwxgq = new SimpleStringProperty();
        }
        return sbhd_xwxgq;
    }
    public void setSbhd_xwxgq(String sbhd_xwxgq) {
        this.sbhd_xwxgq.set(sbhd_xwxgq);
    }
    public String getSbhd_dzxgq() {
        return sbhd_dzxgq.get();
    }
    public StringProperty sbhd_dzxgqProperty() {
        if(sbhd_dzxgq==null){
            sbhd_dzxgq = new SimpleStringProperty();
        }
        return sbhd_dzxgq;
    }
    public void setSbhd_dzxgq(String sbhd_dzxgq) {
        this.sbhd_dzxgq.set(sbhd_dzxgq);
    }
    public String getSbhd_zzxgq() {
        return sbhd_zzxgq.get();
    }
    public StringProperty sbhd_zzxgqProperty() {
        if(sbhd_zzxgq==null){
            sbhd_zzxgq = new SimpleStringProperty();
        }
        return sbhd_zzxgq;
    }
    public void setSbhd_zzxgq(String sbhd_zzxgq) {
        this.sbhd_zzxgq.set(sbhd_zzxgq);
    }
    public String getSbhd_xzxgq() {
        return sbhd_xzxgq.get();
    }
    public StringProperty sbhd_xzxgqProperty() {
        if(sbhd_xzxgq==null){
            sbhd_xzxgq = new SimpleStringProperty();
        }
        return sbhd_xzxgq;
    }
    public void setSbhd_xzxgq(String sbhd_xzxgq) {
        this.sbhd_xzxgq.set(sbhd_xzxgq);
    }
    public String getSbhd_ywxgq() {
        return sbhd_ywxgq.get();
    }
    public StringProperty sbhd_ywxgqProperty() {
        if(sbhd_ywxgq==null){
            sbhd_ywxgq = new SimpleStringProperty();
        }
        return sbhd_ywxgq;
    }
    public void setSbhd_ywxgq(String sbhd_ywxgq) {
        this.sbhd_ywxgq.set(sbhd_ywxgq);
    }
    public String getSbhd_yzxgq() {
        return sbhd_yzxgq.get();
    }
    public StringProperty sbhd_yzxgqProperty() {
        if(sbhd_yzxgq==null){
            sbhd_yzxgq = new SimpleStringProperty();
        }
        return sbhd_yzxgq;
    }
    public void setSbhd_yzxgq(String sbhd_yzxgq) {
        this.sbhd_yzxgq.set(sbhd_yzxgq);
    }
    public String getSbhd_bjq() {
        return sbhd_bjq.get();
    }
    public StringProperty sbhd_bjqProperty() {
        if(sbhd_bjq==null){
            sbhd_bjq = new SimpleStringProperty();
        }
        return sbhd_bjq;
    }
    public void setSbhd_bjq(String sbhd_bjq) {
        this.sbhd_bjq.set(sbhd_bjq);
    }
    public String getSbhd_czq() {
        return sbhd_czq.get();
    }
    public StringProperty sbhd_czqProperty() {
        if(sbhd_czq==null){
            sbhd_czq = new SimpleStringProperty();
        }
        return sbhd_czq;
    }
    public void setSbhd_czq(String sbhd_czq) {
        this.sbhd_czq.set(sbhd_czq);
    }
    public String getSbhd_db() {
        return sbhd_db.get();
    }
    public StringProperty sbhd_dbProperty() {
        if(sbhd_db==null){
            sbhd_db = new SimpleStringProperty();
        }
        return sbhd_db;
    }
    public void setSbhd_db(String sbhd_db) {
        this.sbhd_db.set(sbhd_db);
    }
    public String getSqqd_jd() {
        return sqqd_jd.get();
    }
    public StringProperty sqqd_jdProperty() {
        if(sqqd_jd==null){
            sqqd_jd = new SimpleStringProperty();
        }
        return sqqd_jd;
    }
    public void setSqqd_jd(String sqqd_jd) {
        this.sqqd_jd.set(sqqd_jd);
    }
    public String getSqqd_nz() {
        return sqqd_nz.get();
    }
    public StringProperty sqqd_nzProperty() {
        if(sqqd_nz==null){
            sqqd_nz = new SimpleStringProperty();
        }
        return sqqd_nz;
    }
    public void setSqqd_nz(String sqqd_nz) {
        this.sqqd_nz.set(sqqd_nz);
    }
    public String getSqqd_lg() {
        return sqqd_lg.get();
    }
    public StringProperty sqqd_lgProperty() {
        if(sqqd_lg==null){
            sqqd_lg = new SimpleStringProperty();
        }
        return sqqd_lg;
    }
    public void setSqqd_lg(String sqqd_lg) {
        this.sqqd_lg.set(sqqd_lg);
    }
    public String getSqqd_xg() {
        return sqqd_xg.get();
    }
    public StringProperty sqqd_xgProperty() {
        if(sqqd_xg==null){
            sqqd_xg = new SimpleStringProperty();
        }
        return sqqd_xg;
    }
    public void setSqqd_xg(String sqqd_xg) {
        this.sqqd_xg.set(sqqd_xg);
    }
    public String getSqqd_ddt() {
        return sqqd_ddt.get();
    }
    public StringProperty sqqd_ddtProperty() {
        if(sqqd_ddt==null){
            sqqd_ddt = new SimpleStringProperty();
        }
        return sqqd_ddt;
    }
    public void setSqqd_ddt(String sqqd_ddt) {
        this.sqqd_ddt.set(sqqd_ddt);
    }
    public String getSqqd_wq() {
        return sqqd_wq.get();
    }
    public StringProperty sqqd_wqProperty() {
        if(sqqd_wq==null){
            sqqd_wq = new SimpleStringProperty();
        }
        return sqqd_wq;
    }
    public void setSqqd_wq(String sqqd_wq) {
        this.sqqd_wq.set(sqqd_wq);
    }
    public String getSqqd_cq() {
        return sqqd_cq.get();
    }
    public StringProperty sqqd_cqProperty() {
        if(sqqd_cq==null){
            sqqd_cq = new SimpleStringProperty();
        }
        return sqqd_cq;
    }
    public void setSqqd_cq(String sqqd_cq) {
        this.sqqd_cq.set(sqqd_cq);
    }
    public String getSqqd_qsq() {
        return sqqd_qsq.get();
    }
    public StringProperty sqqd_qsqProperty() {
        if(sqqd_qsq==null){
            sqqd_qsq = new SimpleStringProperty();
        }
        return sqqd_qsq;
    }
    public void setSqqd_qsq(String sqqd_qsq) {
        this.sqqd_qsq.set(sqqd_qsq);
    }
    public String getSqqd_ddtz() {
        return sqqd_ddtz.get();
    }
    public StringProperty sqqd_ddtzProperty() {
        if(sqqd_ddtz==null){
            sqqd_ddtz = new SimpleStringProperty();
        }
        return sqqd_ddtz;
    }
    public void setSqqd_ddtz(String sqqd_ddtz) {
        this.sqqd_ddtz.set(sqqd_ddtz);
    }
    public String getSqqd_ddgc() {
        return sqqd_ddgc.get();
    }
    public StringProperty sqqd_ddgcProperty() {
        if(sqqd_ddgc==null){
            sqqd_ddgc = new SimpleStringProperty();
        }
        return sqqd_ddgc;
    }
    public void setSqqd_ddgc(String sqqd_ddgc) {
        this.sqqd_ddgc.set(sqqd_ddgc);
    }
    public String getSqqd_ycxgq() {
        return sqqd_ycxgq.get();
    }
    public StringProperty sqqd_ycxgqProperty() {
        if(sqqd_ycxgq==null){
            sqqd_ycxgq = new SimpleStringProperty();
        }
        return sqqd_ycxgq;
    }
    public void setSqqd_ycxgq(String sqqd_ycxgq) {
        this.sqqd_ycxgq.set(sqqd_ycxgq);
    }
    public String getSqqd_zjwq() {
        return sqqd_zjwq.get();
    }
    public StringProperty sqqd_zjwqProperty() {
        if(sqqd_zjwq==null){
            sqqd_zjwq = new SimpleStringProperty();
        }
        return sqqd_zjwq;
    }
    public void setSqqd_zjwq(String sqqd_zjwq) {
        this.sqqd_zjwq.set(sqqd_zjwq);
    }
    public String getSqqd_ycb() {
        return sqqd_ycb.get();
    }
    public StringProperty sqqd_ycbProperty() {
        if(sqqd_ycb==null){
            sqqd_ycb = new SimpleStringProperty();
        }
        return sqqd_ycb;
    }
    public void setSqqd_ycb(String sqqd_ycb) {
        this.sqqd_ycb.set(sqqd_ycb);
    }
    public String getGqhd_jd() {
        return gqhd_jd.get();
    }
    public StringProperty gqhd_jdProperty() {
        if(gqhd_jd==null){
            gqhd_jd = new SimpleStringProperty();
        }
        return gqhd_jd;
    }
    public void setGqhd_jd(String gqhd_jd) {
        this.gqhd_jd.set(gqhd_jd);
    }
    public String getGqhd_nz() {
        return gqhd_nz.get();
    }
    public StringProperty gqhd_nzProperty() {
        if(gqhd_nz==null){
            gqhd_nz = new SimpleStringProperty();
        }
        return gqhd_nz;
    }
    public void setGqhd_nz(String gqhd_nz) {
        this.gqhd_nz.set(gqhd_nz);
    }
    public String getGqhd_lg() {
        return gqhd_lg.get();
    }
    public StringProperty gqhd_lgProperty() {
        if(gqhd_lg==null){
            gqhd_lg = new SimpleStringProperty();
        }
        return gqhd_lg;
    }
    public void setGqhd_lg(String gqhd_lg) {
        this.gqhd_lg.set(gqhd_lg);
    }
    public String getGqhd_xg() {
        return gqhd_xg.get();
    }
    public StringProperty gqhd_xgProperty() {
        if(gqhd_xg==null){
            gqhd_xg = new SimpleStringProperty();
        }
        return gqhd_xg;
    }
    public void setGqhd_xg(String gqhd_xg) {
        this.gqhd_xg.set(gqhd_xg);
    }
    public String getGqhd_ddt() {
        return gqhd_ddt.get();
    }
    public StringProperty gqhd_ddtProperty() {
        if(gqhd_ddt==null){
            gqhd_ddt = new SimpleStringProperty();
        }
        return gqhd_ddt;
    }
    public void setGqhd_ddt(String gqhd_ddt) {
        this.gqhd_ddt.set(gqhd_ddt);
    }
    public String getGqhd_wq() {
        return gqhd_wq.get();
    }
    public StringProperty gqhd_wqProperty() {
        if(gqhd_wq==null){
            gqhd_wq = new SimpleStringProperty();
        }
        return gqhd_wq;
    }
    public void setGqhd_wq(String gqhd_wq) {
        this.gqhd_wq.set(gqhd_wq);
    }
    public String getGqhd_cq() {
        return gqhd_cq.get();
    }
    public StringProperty gqhd_cqProperty() {
        if(gqhd_cq==null){
            gqhd_cq = new SimpleStringProperty();
        }
        return gqhd_cq;
    }
    public void setGqhd_cq(String gqhd_cq) {
        this.gqhd_cq.set(gqhd_cq);
    }
    public String getGqhd_qsq() {
        return gqhd_qsq.get();
    }
    public StringProperty gqhd_qsqProperty() {
        if(gqhd_qsq==null){
            gqhd_qsq = new SimpleStringProperty();
        }
        return gqhd_qsq;
    }
    public void setGqhd_qsq(String gqhd_qsq) {
        this.gqhd_qsq.set(gqhd_qsq);
    }
    public String getGqhd_ddtz() {
        return gqhd_ddtz.get();
    }
    public StringProperty gqhd_ddtzProperty() {
        if(gqhd_ddtz==null){
            gqhd_ddtz = new SimpleStringProperty();
        }
        return gqhd_ddtz;
    }
    public void setGqhd_ddtz(String gqhd_ddtz) {
        this.gqhd_ddtz.set(gqhd_ddtz);
    }
    public String getGqhd_ddgc() {
        return gqhd_ddgc.get();
    }
    public StringProperty gqhd_ddgcProperty() {
        if(gqhd_ddgc==null){
            gqhd_ddgc = new SimpleStringProperty();
        }
        return gqhd_ddgc;
    }
    public void setGqhd_ddgc(String gqhd_ddgc) {
        this.gqhd_ddgc.set(gqhd_ddgc);
    }
    public String getGqhd_ycxgq() {
        return gqhd_ycxgq.get();
    }
    public StringProperty gqhd_ycxgqProperty() {
        if(gqhd_ycxgq==null){
            gqhd_ycxgq = new SimpleStringProperty();
        }
        return gqhd_ycxgq;
    }
    public void setGqhd_ycxgq(String gqhd_ycxgq) {
        this.gqhd_ycxgq.set(gqhd_ycxgq);
    }
    public String getGqhd_zjwq() {
        return gqhd_zjwq.get();
    }
    public StringProperty gqhd_zjwqProperty() {
        if(gqhd_zjwq==null){
            gqhd_zjwq = new SimpleStringProperty();
        }
        return gqhd_zjwq;
    }
    public void setGqhd_zjwq(String gqhd_zjwq) {
        this.gqhd_zjwq.set(gqhd_zjwq);
    }
    public String getGqhd_ycb() {
        return gqhd_ycb.get();
    }
    public StringProperty gqhd_ycbProperty() {
        if(gqhd_ycb==null){
            gqhd_ycb = new SimpleStringProperty();
        }
        return gqhd_ycb;
    }
    public void setGqhd_ycb(String gqhd_ycb) {
        this.gqhd_ycb.set(gqhd_ycb);
    }
    public String getGhhd_jd() {
        return ghhd_jd.get();
    }
    public StringProperty ghhd_jdProperty() {
        if(ghhd_jd==null){
            ghhd_jd = new SimpleStringProperty();
        }
        return ghhd_jd;
    }
    public void setGhhd_jd(String ghhd_jd) {
        this.ghhd_jd.set(ghhd_jd);
    }
    public String getGhhd_nz() {
        return ghhd_nz.get();
    }
    public StringProperty ghhd_nzProperty() {
        if(ghhd_nz==null){
            ghhd_nz = new SimpleStringProperty();
        }
        return ghhd_nz;
    }
    public void setGhhd_nz(String ghhd_nz) {
        this.ghhd_nz.set(ghhd_nz);
    }
    public String getGhhd_lg() {
        return ghhd_lg.get();
    }
    public StringProperty ghhd_lgProperty() {
        if(ghhd_lg==null){
            ghhd_lg = new SimpleStringProperty();
        }
        return ghhd_lg;
    }
    public void setGhhd_lg(String ghhd_lg) {
        this.ghhd_lg.set(ghhd_lg);
    }
    public String getGhhd_xg() {
        return ghhd_xg.get();
    }
    public StringProperty ghhd_xgProperty() {
        if(ghhd_xg==null){
            ghhd_xg = new SimpleStringProperty();
        }
        return ghhd_xg;
    }
    public void setGhhd_xg(String ghhd_xg) {
        this.ghhd_xg.set(ghhd_xg);
    }
    public String getGhhd_ddt() {
        return ghhd_ddt.get();
    }
    public StringProperty ghhd_ddtProperty() {
        if(ghhd_ddt==null){
            ghhd_ddt = new SimpleStringProperty();
        }
        return ghhd_ddt;
    }
    public void setGhhd_ddt(String ghhd_ddt) {
        this.ghhd_ddt.set(ghhd_ddt);
    }
    public String getGhhd_wq() {
        return ghhd_wq.get();
    }
    public StringProperty ghhd_wqProperty() {
        if(ghhd_wq==null){
            ghhd_wq = new SimpleStringProperty();
        }
        return ghhd_wq;
    }
    public void setGhhd_wq(String ghhd_wq) {
        this.ghhd_wq.set(ghhd_wq);
    }
    public String getGhhd_cq() {
        return ghhd_cq.get();
    }
    public StringProperty ghhd_cqProperty() {
        if(ghhd_cq==null){
            ghhd_cq = new SimpleStringProperty();
        }
        return ghhd_cq;
    }
    public void setGhhd_cq(String ghhd_cq) {
        this.ghhd_cq.set(ghhd_cq);
    }
    public String getGhhd_qsq() {
        return ghhd_qsq.get();
    }
    public StringProperty ghhd_qsqProperty() {
        if(ghhd_qsq==null){
            ghhd_qsq = new SimpleStringProperty();
        }
        return ghhd_qsq;
    }
    public void setGhhd_qsq(String ghhd_qsq) {
        this.ghhd_qsq.set(ghhd_qsq);
    }
    public String getGhhd_ddtz() {
        return ghhd_ddtz.get();
    }
    public StringProperty ghhd_ddtzProperty() {
        if(ghhd_ddtz==null){
            ghhd_ddtz = new SimpleStringProperty();
        }
        return ghhd_ddtz;
    }
    public void setGhhd_ddtz(String ghhd_ddtz) {
        this.ghhd_ddtz.set(ghhd_ddtz);
    }
    public String getGhhd_ddgc() {
        return ghhd_ddgc.get();
    }
    public StringProperty ghhd_ddgcProperty() {
        if(ghhd_ddgc==null){
            ghhd_ddgc = new SimpleStringProperty();
        }
        return ghhd_ddgc;
    }
    public void setGhhd_ddgc(String ghhd_ddgc) {
        this.ghhd_ddgc.set(ghhd_ddgc);
    }
    public String getGhhd_ycxgq() {
        return ghhd_ycxgq.get();
    }
    public StringProperty ghhd_ycxgqProperty() {
        if(ghhd_ycxgq==null){
            ghhd_ycxgq = new SimpleStringProperty();
        }
        return ghhd_ycxgq;
    }
    public void setGhhd_ycxgq(String ghhd_ycxgq) {
        this.ghhd_ycxgq.set(ghhd_ycxgq);
    }
    public String getGhhd_zjwq() {
        return ghhd_zjwq.get();
    }
    public StringProperty ghhd_zjwqProperty() {
        if(ghhd_zjwq==null){
            ghhd_zjwq = new SimpleStringProperty();
        }
        return ghhd_zjwq;
    }
    public void setGhhd_zjwq(String ghhd_zjwq) {
        this.ghhd_zjwq.set(ghhd_zjwq);
    }
    public String getGhhd_ycb() {
        return ghhd_ycb.get();
    }
    public StringProperty ghhd_ycbProperty() {
        if(ghhd_ycb==null){
            ghhd_ycb = new SimpleStringProperty();
        }
        return ghhd_ycb;
    }
    public void setGhhd_ycb(String ghhd_ycb) {
        this.ghhd_ycb.set(ghhd_ycb);
    }
    public String getSbhd_jd() {
        return sbhd_jd.get();
    }
    public StringProperty sbhd_jdProperty() {
        if(sbhd_jd==null){
            sbhd_jd = new SimpleStringProperty();
        }
        return sbhd_jd;
    }
    public void setSbhd_jd(String sbhd_jd) {
        this.sbhd_jd.set(sbhd_jd);
    }
    public String getSbhd_nz() {
        return sbhd_nz.get();
    }
    public StringProperty sbhd_nzProperty() {
        if(sbhd_nz==null){
            sbhd_nz = new SimpleStringProperty();
        }
        return sbhd_nz;
    }
    public void setSbhd_nz(String sbhd_nz) {
        this.sbhd_nz.set(sbhd_nz);
    }
    public String getSbhd_lg() {
        return sbhd_lg.get();
    }
    public StringProperty sbhd_lgProperty() {
        if(sbhd_lg==null){
            sbhd_lg = new SimpleStringProperty();
        }
        return sbhd_lg;
    }
    public void setSbhd_lg(String sbhd_lg) {
        this.sbhd_lg.set(sbhd_lg);
    }
    public String getSbhd_xg() {
        return sbhd_xg.get();
    }
    public StringProperty sbhd_xgProperty() {
        if(sbhd_xg==null){
            sbhd_xg = new SimpleStringProperty();
        }
        return sbhd_xg;
    }
    public void setSbhd_xg(String sbhd_xg) {
        this.sbhd_xg.set(sbhd_xg);
    }
    public String getSbhd_ddt() {
        return sbhd_ddt.get();
    }
    public StringProperty sbhd_ddtProperty() {
        if(sbhd_ddt==null){
            sbhd_ddt = new SimpleStringProperty();
        }
        return sbhd_ddt;
    }
    public void setSbhd_ddt(String sbhd_ddt) {
        this.sbhd_ddt.set(sbhd_ddt);
    }
    public String getSbhd_wq() {
        return sbhd_wq.get();
    }
    public StringProperty sbhd_wqProperty() {
        if(sbhd_wq==null){
            sbhd_wq = new SimpleStringProperty();
        }
        return sbhd_wq;
    }
    public void setSbhd_wq(String sbhd_wq) {
        this.sbhd_wq.set(sbhd_wq);
    }
    public String getSbhd_cq() {
        return sbhd_cq.get();
    }
    public StringProperty sbhd_cqProperty() {
        if(sbhd_cq==null){
            sbhd_cq = new SimpleStringProperty();
        }
        return sbhd_cq;
    }
    public void setSbhd_cq(String sbhd_cq) {
        this.sbhd_cq.set(sbhd_cq);
    }
    public String getSbhd_qsq() {
        return sbhd_qsq.get();
    }
    public StringProperty sbhd_qsqProperty() {
        if(sbhd_qsq==null){
            sbhd_qsq = new SimpleStringProperty();
        }
        return sbhd_qsq;
    }
    public void setSbhd_qsq(String sbhd_qsq) {
        this.sbhd_qsq.set(sbhd_qsq);
    }
    public String getSbhd_ddtz() {
        return sbhd_ddtz.get();
    }
    public StringProperty sbhd_ddtzProperty() {
        if(sbhd_ddtz==null){
            sbhd_ddtz = new SimpleStringProperty();
        }
        return sbhd_ddtz;
    }
    public void setSbhd_ddtz(String sbhd_ddtz) {
        this.sbhd_ddtz.set(sbhd_ddtz);
    }
    public String getSbhd_ddgc() {
        return sbhd_ddgc.get();
    }
    public StringProperty sbhd_ddgcProperty() {
        if(sbhd_ddgc==null){
            sbhd_ddgc = new SimpleStringProperty();
        }
        return sbhd_ddgc;
    }
    public void setSbhd_ddgc(String sbhd_ddgc) {
        this.sbhd_ddgc.set(sbhd_ddgc);
    }
    public String getSbhd_ycxgq() {
        return sbhd_ycxgq.get();
    }
    public StringProperty sbhd_ycxgqProperty() {
        if(sbhd_ycxgq==null){
            sbhd_ycxgq = new SimpleStringProperty();
        }
        return sbhd_ycxgq;
    }
    public void setSbhd_ycxgq(String sbhd_ycxgq) {
        this.sbhd_ycxgq.set(sbhd_ycxgq);
    }
    public String getSbhd_zjwq() {
        return sbhd_zjwq.get();
    }
    public StringProperty sbhd_zjwqProperty() {
        if(sbhd_zjwq==null){
            sbhd_zjwq = new SimpleStringProperty();
        }
        return sbhd_zjwq;
    }
    public void setSbhd_zjwq(String sbhd_zjwq) {
        this.sbhd_zjwq.set(sbhd_zjwq);
    }
    public String getSbhd_ycb() {
        return sbhd_ycb.get();
    }
    public StringProperty sbhd_ycbProperty() {
        if(sbhd_ycb==null){
            sbhd_ycb = new SimpleStringProperty();
        }
        return sbhd_ycb;
    }
    public void setSbhd_ycb(String sbhd_ycb) {
        this.sbhd_ycb.set(sbhd_ycb);
    }
    public String getSbhd_tsqx() {
        return sbhd_tsqx.get();
    }
    public StringProperty sbhd_tsqxProperty() {
        if(sbhd_tsqx==null){
            sbhd_tsqx = new SimpleStringProperty();
        }
        return sbhd_tsqx;
    }
    public void setSbhd_tsqx(String sbhd_tsqx) {
        this.sbhd_tsqx.set(sbhd_tsqx);
    }
    public String getSbhd_lsd() {
        return sbhd_lsd.get();
    }
    public StringProperty sbhd_lsdProperty() {
        if(sbhd_lsd==null){
            sbhd_lsd = new SimpleStringProperty();
        }
        return sbhd_lsd;
    }
    public void setSbhd_lsd(String sbhd_lsd) {
        this.sbhd_lsd.set(sbhd_lsd);
    }
    public String getSbhd_qt1() {
        return sbhd_qt1.get();
    }
    public StringProperty sbhd_qt1Property() {
        if(sbhd_qt1==null){
            sbhd_qt1 = new SimpleStringProperty();
        }
        return sbhd_qt1;
    }
    public void setSbhd_qt1(String sbhd_qt1) {
        this.sbhd_qt1.set(sbhd_qt1);
    }
    public String getSbhd_qt2() {
        return sbhd_qt2.get();
    }
    public StringProperty sbhd_qt2Property() {
        if(sbhd_qt2==null){
            sbhd_qt2 = new SimpleStringProperty();
        }
        return sbhd_qt2;
    }
    public void setSbhd_qt2(String sbhd_qt2) {
        this.sbhd_qt2.set(sbhd_qt2);
    }
    public String getSbhd_qt3() {
        return sbhd_qt3.get();
    }
    public StringProperty sbhd_qt3Property() {
        if(sbhd_qt3==null){
            sbhd_qt3 = new SimpleStringProperty();
        }
        return sbhd_qt3;
    }
    public void setSbhd_qt3(String sbhd_qt3) {
        this.sbhd_qt3.set(sbhd_qt3);
    }
    public String getSbhd_qt4() {
        return sbhd_qt4.get();
    }
    public StringProperty sbhd_qt4Property() {
        if(sbhd_qt4==null){
            sbhd_qt4 = new SimpleStringProperty();
        }
        return sbhd_qt4;
    }
    public void setSbhd_qt4(String sbhd_qt4) {
        this.sbhd_qt4.set(sbhd_qt4);
    }
    public String getSbhd_qt5() {
        return sbhd_qt5.get();
    }
    public StringProperty sbhd_qt5Property() {
        if(sbhd_qt5==null){
            sbhd_qt5 = new SimpleStringProperty();
        }
        return sbhd_qt5;
    }
    public void setSbhd_qt5(String sbhd_qt5) {
        this.sbhd_qt5.set(sbhd_qt5);
    }
    public String getSbhd_qt6() {
        return sbhd_qt6.get();
    }
    public StringProperty sbhd_qt6Property() {
        if(sbhd_qt6==null){
            sbhd_qt6 = new SimpleStringProperty();
        }
        return sbhd_qt6;
    }
    public void setSbhd_qt6(String sbhd_qt6) {
        this.sbhd_qt6.set(sbhd_qt6);
    }
    public String getSbhd_qt7() {
        return sbhd_qt7.get();
    }
    public StringProperty sbhd_qt7Property() {
        if(sbhd_qt7==null){
            sbhd_qt7 = new SimpleStringProperty();
        }
        return sbhd_qt7;
    }
    public void setSbhd_qt7(String sbhd_qt7) {
        this.sbhd_qt7.set(sbhd_qt7);
    }
    public String getSbhd_qt8() {
        return sbhd_qt8.get();
    }
    public StringProperty sbhd_qt8Property() {
        if(sbhd_qt8==null){
            sbhd_qt8 = new SimpleStringProperty();
        }
        return sbhd_qt8;
    }
    public void setSbhd_qt8(String sbhd_qt8) {
        this.sbhd_qt8.set(sbhd_qt8);
    }
    public String getSbhd_qt9() {
        return sbhd_qt9.get();
    }
    public StringProperty sbhd_qt9Property() {
        if(sbhd_qt9==null){
            sbhd_qt9 = new SimpleStringProperty();
        }
        return sbhd_qt9;
    }
    public void setSbhd_qt9(String sbhd_qt9) {
        this.sbhd_qt9.set(sbhd_qt9);
    }
    public String getSbhd_qt10() {
        return sbhd_qt10.get();
    }
    public StringProperty sbhd_qt10Property() {
        if(sbhd_qt10==null){
            sbhd_qt10 = new SimpleStringProperty();
        }
        return sbhd_qt10;
    }
    public void setSbhd_qt10(String sbhd_qt10) {
        this.sbhd_qt10.set(sbhd_qt10);
    }
    public String getSbhd_qt11() {
        return sbhd_qt11.get();
    }
    public StringProperty sbhd_qt11Property() {
        if(sbhd_qt11==null){
            sbhd_qt11 = new SimpleStringProperty();
        }
        return sbhd_qt11;
    }
    public void setSbhd_qt11(String sbhd_qt11) {
        this.sbhd_qt11.set(sbhd_qt11);
    }
    public String getQx() {
        return qx.get();
    }
    public StringProperty qxProperty() {
        if(qx==null){
            qx = new SimpleStringProperty();
        }
        return qx;
    }
    public void setQx(String qx) {
        this.qx.set(qx);
    }
    public String getVas() {
        return vas.get();
    }
    public StringProperty vasProperty() {
        if(vas==null){
            vas = new SimpleStringProperty();
        }
        return vas;
    }
    public void setVas(String vas) {
        this.vas.set(vas);
    }
    public String getQttext() {
        return qttext.get();
    }
    public StringProperty qttextProperty() {
        if(qttext==null){
            qttext = new SimpleStringProperty();
        }
        return qttext;
    }
    public void setQttext(String qttext) {
        this.qttext.set(qttext);
    }
    public String getMzry() {
        return mzry.get();
    }
    public StringProperty mzryProperty() {
        if(mzry==null){
            mzry = new SimpleStringProperty();
        }
        return mzry;
    }
    public void setMzry(String mzry) {
        this.mzry.set(mzry);
    }
    public String getJlry() {
        return jlry.get();
    }
    public StringProperty jlryProperty() {
        if(jlry==null){
            jlry = new SimpleStringProperty();
        }
        return jlry;
    }
    public void setJlry(String jlry) {
        this.jlry.set(jlry);
    }

}
