package cn.medigical.publish.pojo.hezhouyiyuan;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ShuQianPingGuHuLi {
    /**病人姓名*/
    private BooleanProperty brxm2;
    /**住院号*/
    private BooleanProperty zyh2;
    /**手术房间号*/
    private BooleanProperty ssfjh2;
    /**手术名称*/
    private BooleanProperty ssmc2;
    /**手术部位*/
    private BooleanProperty ssbw2;
    /**无*/
    private BooleanProperty gms_n;
    /**有*/
    private BooleanProperty gms_y;
    /**无*/
    private BooleanProperty jws_n;
    /**有*/
    private BooleanProperty jws_y;
    /**无*/
    private BooleanProperty mxbs_n;
    /**有*/
    private BooleanProperty mxbs_y;
    /**无*/
    private BooleanProperty crbs_n;
    /**有*/
    private BooleanProperty crbs_y;
    /**禁食、禁饮*/
    private BooleanProperty jsjs;
    /**备皮*/
    private BooleanProperty bp;
    /**手术同意书*/
    private BooleanProperty sstys;
    /**术前用药*/
    private BooleanProperty sqyy;
    /**戴首饰及其它物品*/
    private BooleanProperty dssqt;
    /**隐形眼镜*/
    private BooleanProperty yxyj;
    /**假牙、松动牙*/
    private BooleanProperty jy;
    /**眼影、口红、指甲油*/
    private BooleanProperty yyks;
    /**月经来潮*/
    private BooleanProperty yjlc;
    /**发热*/
    private BooleanProperty fr;
    /**咳嗽*/
    private BooleanProperty ks;
    /**无*/
    private BooleanProperty tlzrw_n;
    /**有*/
    private BooleanProperty tlzrw_y;
    /**义眼*/
    private BooleanProperty yy;
    /**心脏起博器*/
    private BooleanProperty xzqbq;
    /**人工瓣膜*/
    private BooleanProperty zgbm;
    /**假肢*/
    private BooleanProperty jz;
    /**助听器*/
    private BooleanProperty ztq;
    /**其他*/
    private BooleanProperty qt;
    /**清醒*/
    private BooleanProperty qx;
    /**嗜睡*/
    private BooleanProperty ss;
    /**躁动*/
    private BooleanProperty zd;
    /**昏迷*/
    private BooleanProperty hm;
    /**其他*/
    private BooleanProperty ysqt;
    /**平静、稳定*/
    private BooleanProperty pj;
    /**紧张*/
    private BooleanProperty jz2;
    /**焦虑*/
    private BooleanProperty jl;
    /**恐惧*/
    private BooleanProperty kj;
    /**悲哀*/
    private BooleanProperty ba;
    /**压抑*/
    private BooleanProperty yay;
    /**正常*/
    private BooleanProperty pflm_zc;
    /**破损*/
    private BooleanProperty pflm_ps;
    /**正常*/
    private BooleanProperty szgj_zc;
    /**残疾*/
    private BooleanProperty szgj_cj;
    /**瘫痪*/
    private BooleanProperty bw_th;
    /**畸形*/
    private BooleanProperty bw_jx;
    /**其它*/
    private BooleanProperty bw_qt;
    /**手术相关知识*/
    private BooleanProperty ssxgzs;
    /**手术室环境*/
    private BooleanProperty sshj;
    /**参加手术人员*/
    private BooleanProperty ssry;
    /**基本工作流程*/
    private BooleanProperty jbgzlc;
    /**无*/
    private BooleanProperty gzgd_n;
    /**有*/
    private BooleanProperty gzgd_y;
    /**胃管*/
    private BooleanProperty wg;
    /**尿管*/
    private BooleanProperty ng;
    /**引流管*/
    private BooleanProperty ylg;
    /**输液管*/
    private BooleanProperty syg;
    /**通畅、固定*/
    private BooleanProperty tc;
    /**堵塞*/
    private BooleanProperty ds;
    /**松动*/
    private BooleanProperty sd;
    /**低危*/
    private BooleanProperty zcfx_d;
    /**高危*/
    private BooleanProperty zcfx_g;
    /**无*/
    private BooleanProperty dlwp_n;
    /**有*/
    private BooleanProperty dlwp_y;
    /**正常*/
    private BooleanProperty xcg_zc;
    /**异常*/
    private BooleanProperty xcg_yc;
    /**无*/
    private BooleanProperty xx_n;
    /**有*/
    private BooleanProperty xx_y;
    /**正常*/
    private BooleanProperty nxgn_zc;
    /**异常*/
    private BooleanProperty nxgn_yc;
    /**正常*/
    private BooleanProperty ggn_zc;
    /**异常*/
    private BooleanProperty ggn_yc;
    /**正常*/
    private BooleanProperty sgn_zc;
    /**异常*/
    private BooleanProperty sgn_yc;
    /**正常*/
    private BooleanProperty gy_zc;
    /**异常*/
    private BooleanProperty gy_yc;
    /**1.压疮：*/
    private BooleanProperty yc;
    /**①使用抗压软垫*/
    private BooleanProperty kyrd;
    /**②使用防压疮敷料*/
    private BooleanProperty fyfl;
    /**③动态调节手术床*/
    private BooleanProperty ssc;
    /**④使用肩挡减少剪切力*/
    private BooleanProperty jsqp;
    /**⑤保持床单衣服清洁、平整、干燥*/
    private BooleanProperty bcgjzc;
    /**2.低体温：*/
    private BooleanProperty dtw;
    /**①动态监测体温*/
    private BooleanProperty twjc;
    /**②调节室温22°C~25°C*/
    private BooleanProperty tsw;
    /**③使用加温液体*/
    private BooleanProperty jwyt;
    /**④使用加温毯*/
    private BooleanProperty jwt;
    /**⑤减少病人身体暴露*/
    private BooleanProperty jsbl;
    /**3.坠床：*/
    private BooleanProperty zc;
    /**①加强宣教*/
    private BooleanProperty jqxj;
    /**②适当约束*/
    private BooleanProperty sdys;
    /**③密切观察*/
    private BooleanProperty mqgc;
    /**4.脱管：*/
    private BooleanProperty gg;
    /**①加强宣教*/
    private BooleanProperty jqxj2;
    /**②固定妥当*/
    private BooleanProperty gdtd;
    /**③衔接牢固*/
    private BooleanProperty xjlg;
    /**④高风险环节注意保护*/
    private BooleanProperty hjbh;
    /**⑤密切观察*/
    private BooleanProperty mqgc2;
    /**5.术中大出血：*/
    private BooleanProperty szdcx;
    /**①选择18-20F留置针，保持静脉通畅有效*/
    private BooleanProperty jmtc;
    /**②预备无 损伤血管钳、血管缝线等止血用物*/
    private BooleanProperty zxyw;
    /**③密切观察出血量*/
    private BooleanProperty gccxl;
    /**6.其他：*/
    private BooleanProperty qtcs;
    /**姓名*/
    private StringProperty brxm;
    /**性别*/
    private StringProperty xb;
    /**年龄*/
    private StringProperty nl;
    /**科室*/
    private StringProperty ksmc;
    /**床号*/
    private StringProperty zych;
    /**住院号*/
    private StringProperty zyh;
    /**体位:*/
    private StringProperty tw;
    /**手术间*/
    private StringProperty ssj;
    /**诊断:*/
    private StringProperty sqzd;
    /**手术名称:*/
    private StringProperty nsss1;
    /**其他*/
    private StringProperty qttext;
    /**(部位*/
    private StringProperty bw;
    /**性质*/
    private StringProperty xz;
    /**(部位*/
    private StringProperty bw2;
    /**其它*/
    private StringProperty bwqt;
    /**6.其他*/
    private StringProperty qtcsText;
    /**签名*/
    private StringProperty qm;
    /**时间*/
    private StringProperty datetime;

    public boolean isBrxm2() {
        return brxm2.get();
    }
    public BooleanProperty brxm2Property() {
        if(brxm2==null){
            brxm2 = new SimpleBooleanProperty(false);
        }
        return brxm2;
    }
    public void setBrxm2(boolean brxm2) {
        this.brxm2.set(brxm2);
    }
    public boolean isZyh2() {
        return zyh2.get();
    }
    public BooleanProperty zyh2Property() {
        if(zyh2==null){
            zyh2 = new SimpleBooleanProperty(false);
        }
        return zyh2;
    }
    public void setZyh2(boolean zyh2) {
        this.zyh2.set(zyh2);
    }
    public boolean isSsfjh2() {
        return ssfjh2.get();
    }
    public BooleanProperty ssfjh2Property() {
        if(ssfjh2==null){
            ssfjh2 = new SimpleBooleanProperty(false);
        }
        return ssfjh2;
    }
    public void setSsfjh2(boolean ssfjh2) {
        this.ssfjh2.set(ssfjh2);
    }
    public boolean isSsmc2() {
        return ssmc2.get();
    }
    public BooleanProperty ssmc2Property() {
        if(ssmc2==null){
            ssmc2 = new SimpleBooleanProperty(false);
        }
        return ssmc2;
    }
    public void setSsmc2(boolean ssmc2) {
        this.ssmc2.set(ssmc2);
    }
    public boolean isSsbw2() {
        return ssbw2.get();
    }
    public BooleanProperty ssbw2Property() {
        if(ssbw2==null){
            ssbw2 = new SimpleBooleanProperty(false);
        }
        return ssbw2;
    }
    public void setSsbw2(boolean ssbw2) {
        this.ssbw2.set(ssbw2);
    }
    public boolean isGms_n() {
        return gms_n.get();
    }
    public BooleanProperty gms_nProperty() {
        if(gms_n==null){
            gms_n = new SimpleBooleanProperty(false);
        }
        return gms_n;
    }
    public void setGms_n(boolean gms_n) {
        this.gms_n.set(gms_n);
    }
    public boolean isGms_y() {
        return gms_y.get();
    }
    public BooleanProperty gms_yProperty() {
        if(gms_y==null){
            gms_y = new SimpleBooleanProperty(false);
        }
        return gms_y;
    }
    public void setGms_y(boolean gms_y) {
        this.gms_y.set(gms_y);
    }
    public boolean isJws_n() {
        return jws_n.get();
    }
    public BooleanProperty jws_nProperty() {
        if(jws_n==null){
            jws_n = new SimpleBooleanProperty(false);
        }
        return jws_n;
    }
    public void setJws_n(boolean jws_n) {
        this.jws_n.set(jws_n);
    }
    public boolean isJws_y() {
        return jws_y.get();
    }
    public BooleanProperty jws_yProperty() {
        if(jws_y==null){
            jws_y = new SimpleBooleanProperty(false);
        }
        return jws_y;
    }
    public void setJws_y(boolean jws_y) {
        this.jws_y.set(jws_y);
    }
    public boolean isMxbs_n() {
        return mxbs_n.get();
    }
    public BooleanProperty mxbs_nProperty() {
        if(mxbs_n==null){
            mxbs_n = new SimpleBooleanProperty(false);
        }
        return mxbs_n;
    }
    public void setMxbs_n(boolean mxbs_n) {
        this.mxbs_n.set(mxbs_n);
    }
    public boolean isMxbs_y() {
        return mxbs_y.get();
    }
    public BooleanProperty mxbs_yProperty() {
        if(mxbs_y==null){
            mxbs_y = new SimpleBooleanProperty(false);
        }
        return mxbs_y;
    }
    public void setMxbs_y(boolean mxbs_y) {
        this.mxbs_y.set(mxbs_y);
    }
    public boolean isCrbs_n() {
        return crbs_n.get();
    }
    public BooleanProperty crbs_nProperty() {
        if(crbs_n==null){
            crbs_n = new SimpleBooleanProperty(false);
        }
        return crbs_n;
    }
    public void setCrbs_n(boolean crbs_n) {
        this.crbs_n.set(crbs_n);
    }
    public boolean isCrbs_y() {
        return crbs_y.get();
    }
    public BooleanProperty crbs_yProperty() {
        if(crbs_y==null){
            crbs_y = new SimpleBooleanProperty(false);
        }
        return crbs_y;
    }
    public void setCrbs_y(boolean crbs_y) {
        this.crbs_y.set(crbs_y);
    }
    public boolean isJsjs() {
        return jsjs.get();
    }
    public BooleanProperty jsjsProperty() {
        if(jsjs==null){
            jsjs = new SimpleBooleanProperty(false);
        }
        return jsjs;
    }
    public void setJsjs(boolean jsjs) {
        this.jsjs.set(jsjs);
    }
    public boolean isBp() {
        return bp.get();
    }
    public BooleanProperty bpProperty() {
        if(bp==null){
            bp = new SimpleBooleanProperty(false);
        }
        return bp;
    }
    public void setBp(boolean bp) {
        this.bp.set(bp);
    }
    public boolean isSstys() {
        return sstys.get();
    }
    public BooleanProperty sstysProperty() {
        if(sstys==null){
            sstys = new SimpleBooleanProperty(false);
        }
        return sstys;
    }
    public void setSstys(boolean sstys) {
        this.sstys.set(sstys);
    }
    public boolean isSqyy() {
        return sqyy.get();
    }
    public BooleanProperty sqyyProperty() {
        if(sqyy==null){
            sqyy = new SimpleBooleanProperty(false);
        }
        return sqyy;
    }
    public void setSqyy(boolean sqyy) {
        this.sqyy.set(sqyy);
    }
    public boolean isDssqt() {
        return dssqt.get();
    }
    public BooleanProperty dssqtProperty() {
        if(dssqt==null){
            dssqt = new SimpleBooleanProperty(false);
        }
        return dssqt;
    }
    public void setDssqt(boolean dssqt) {
        this.dssqt.set(dssqt);
    }
    public boolean isYxyj() {
        return yxyj.get();
    }
    public BooleanProperty yxyjProperty() {
        if(yxyj==null){
            yxyj = new SimpleBooleanProperty(false);
        }
        return yxyj;
    }
    public void setYxyj(boolean yxyj) {
        this.yxyj.set(yxyj);
    }
    public boolean isJy() {
        return jy.get();
    }
    public BooleanProperty jyProperty() {
        if(jy==null){
            jy = new SimpleBooleanProperty(false);
        }
        return jy;
    }
    public void setJy(boolean jy) {
        this.jy.set(jy);
    }
    public boolean isYyks() {
        return yyks.get();
    }
    public BooleanProperty yyksProperty() {
        if(yyks==null){
            yyks = new SimpleBooleanProperty(false);
        }
        return yyks;
    }
    public void setYyks(boolean yyks) {
        this.yyks.set(yyks);
    }
    public boolean isYjlc() {
        return yjlc.get();
    }
    public BooleanProperty yjlcProperty() {
        if(yjlc==null){
            yjlc = new SimpleBooleanProperty(false);
        }
        return yjlc;
    }
    public void setYjlc(boolean yjlc) {
        this.yjlc.set(yjlc);
    }
    public boolean isFr() {
        return fr.get();
    }
    public BooleanProperty frProperty() {
        if(fr==null){
            fr = new SimpleBooleanProperty(false);
        }
        return fr;
    }
    public void setFr(boolean fr) {
        this.fr.set(fr);
    }
    public boolean isKs() {
        return ks.get();
    }
    public BooleanProperty ksProperty() {
        if(ks==null){
            ks = new SimpleBooleanProperty(false);
        }
        return ks;
    }
    public void setKs(boolean ks) {
        this.ks.set(ks);
    }
    public boolean isTlzrw_n() {
        return tlzrw_n.get();
    }
    public BooleanProperty tlzrw_nProperty() {
        if(tlzrw_n==null){
            tlzrw_n = new SimpleBooleanProperty(false);
        }
        return tlzrw_n;
    }
    public void setTlzrw_n(boolean tlzrw_n) {
        this.tlzrw_n.set(tlzrw_n);
    }
    public boolean isTlzrw_y() {
        return tlzrw_y.get();
    }
    public BooleanProperty tlzrw_yProperty() {
        if(tlzrw_y==null){
            tlzrw_y = new SimpleBooleanProperty(false);
        }
        return tlzrw_y;
    }
    public void setTlzrw_y(boolean tlzrw_y) {
        this.tlzrw_y.set(tlzrw_y);
    }
    public boolean isYy() {
        return yy.get();
    }
    public BooleanProperty yyProperty() {
        if(yy==null){
            yy = new SimpleBooleanProperty(false);
        }
        return yy;
    }
    public void setYy(boolean yy) {
        this.yy.set(yy);
    }
    public boolean isXzqbq() {
        return xzqbq.get();
    }
    public BooleanProperty xzqbqProperty() {
        if(xzqbq==null){
            xzqbq = new SimpleBooleanProperty(false);
        }
        return xzqbq;
    }
    public void setXzqbq(boolean xzqbq) {
        this.xzqbq.set(xzqbq);
    }
    public boolean isZgbm() {
        return zgbm.get();
    }
    public BooleanProperty zgbmProperty() {
        if(zgbm==null){
            zgbm = new SimpleBooleanProperty(false);
        }
        return zgbm;
    }
    public void setZgbm(boolean zgbm) {
        this.zgbm.set(zgbm);
    }
    public boolean isJz() {
        return jz.get();
    }
    public BooleanProperty jzProperty() {
        if(jz==null){
            jz = new SimpleBooleanProperty(false);
        }
        return jz;
    }
    public void setJz(boolean jz) {
        this.jz.set(jz);
    }
    public boolean isZtq() {
        return ztq.get();
    }
    public BooleanProperty ztqProperty() {
        if(ztq==null){
            ztq = new SimpleBooleanProperty(false);
        }
        return ztq;
    }
    public void setZtq(boolean ztq) {
        this.ztq.set(ztq);
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
    public boolean isQx() {
        return qx.get();
    }
    public BooleanProperty qxProperty() {
        if(qx==null){
            qx = new SimpleBooleanProperty(false);
        }
        return qx;
    }
    public void setQx(boolean qx) {
        this.qx.set(qx);
    }
    public boolean isSs() {
        return ss.get();
    }
    public BooleanProperty ssProperty() {
        if(ss==null){
            ss = new SimpleBooleanProperty(false);
        }
        return ss;
    }
    public void setSs(boolean ss) {
        this.ss.set(ss);
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
    public boolean isHm() {
        return hm.get();
    }
    public BooleanProperty hmProperty() {
        if(hm==null){
            hm = new SimpleBooleanProperty(false);
        }
        return hm;
    }
    public void setHm(boolean hm) {
        this.hm.set(hm);
    }
    public boolean isYsqt() {
        return ysqt.get();
    }
    public BooleanProperty ysqtProperty() {
        if(ysqt==null){
            ysqt = new SimpleBooleanProperty(false);
        }
        return ysqt;
    }
    public void setYsqt(boolean ysqt) {
        this.ysqt.set(ysqt);
    }
    public boolean isPj() {
        return pj.get();
    }
    public BooleanProperty pjProperty() {
        if(pj==null){
            pj = new SimpleBooleanProperty(false);
        }
        return pj;
    }
    public void setPj(boolean pj) {
        this.pj.set(pj);
    }
    public boolean isJz2() {
        return jz2.get();
    }
    public BooleanProperty jz2Property() {
        if(jz2==null){
            jz2 = new SimpleBooleanProperty(false);
        }
        return jz2;
    }
    public void setJz2(boolean jz2) {
        this.jz2.set(jz2);
    }
    public boolean isJl() {
        return jl.get();
    }
    public BooleanProperty jlProperty() {
        if(jl==null){
            jl = new SimpleBooleanProperty(false);
        }
        return jl;
    }
    public void setJl(boolean jl) {
        this.jl.set(jl);
    }
    public boolean isKj() {
        return kj.get();
    }
    public BooleanProperty kjProperty() {
        if(kj==null){
            kj = new SimpleBooleanProperty(false);
        }
        return kj;
    }
    public void setKj(boolean kj) {
        this.kj.set(kj);
    }
    public boolean isBa() {
        return ba.get();
    }
    public BooleanProperty baProperty() {
        if(ba==null){
            ba = new SimpleBooleanProperty(false);
        }
        return ba;
    }
    public void setBa(boolean ba) {
        this.ba.set(ba);
    }
    public boolean isYay() {
        return yay.get();
    }
    public BooleanProperty yayProperty() {
        if(yay==null){
            yay = new SimpleBooleanProperty(false);
        }
        return yay;
    }
    public void setYay(boolean yay) {
        this.yay.set(yay);
    }
    public boolean isPflm_zc() {
        return pflm_zc.get();
    }
    public BooleanProperty pflm_zcProperty() {
        if(pflm_zc==null){
            pflm_zc = new SimpleBooleanProperty(false);
        }
        return pflm_zc;
    }
    public void setPflm_zc(boolean pflm_zc) {
        this.pflm_zc.set(pflm_zc);
    }
    public boolean isPflm_ps() {
        return pflm_ps.get();
    }
    public BooleanProperty pflm_psProperty() {
        if(pflm_ps==null){
            pflm_ps = new SimpleBooleanProperty(false);
        }
        return pflm_ps;
    }
    public void setPflm_ps(boolean pflm_ps) {
        this.pflm_ps.set(pflm_ps);
    }
    public boolean isSzgj_zc() {
        return szgj_zc.get();
    }
    public BooleanProperty szgj_zcProperty() {
        if(szgj_zc==null){
            szgj_zc = new SimpleBooleanProperty(false);
        }
        return szgj_zc;
    }
    public void setSzgj_zc(boolean szgj_zc) {
        this.szgj_zc.set(szgj_zc);
    }
    public boolean isSzgj_cj() {
        return szgj_cj.get();
    }
    public BooleanProperty szgj_cjProperty() {
        if(szgj_cj==null){
            szgj_cj = new SimpleBooleanProperty(false);
        }
        return szgj_cj;
    }
    public void setSzgj_cj(boolean szgj_cj) {
        this.szgj_cj.set(szgj_cj);
    }
    public boolean isBw_th() {
        return bw_th.get();
    }
    public BooleanProperty bw_thProperty() {
        if(bw_th==null){
            bw_th = new SimpleBooleanProperty(false);
        }
        return bw_th;
    }
    public void setBw_th(boolean bw_th) {
        this.bw_th.set(bw_th);
    }
    public boolean isBw_jx() {
        return bw_jx.get();
    }
    public BooleanProperty bw_jxProperty() {
        if(bw_jx==null){
            bw_jx = new SimpleBooleanProperty(false);
        }
        return bw_jx;
    }
    public void setBw_jx(boolean bw_jx) {
        this.bw_jx.set(bw_jx);
    }
    public boolean isBw_qt() {
        return bw_qt.get();
    }
    public BooleanProperty bw_qtProperty() {
        if(bw_qt==null){
            bw_qt = new SimpleBooleanProperty(false);
        }
        return bw_qt;
    }
    public void setBw_qt(boolean bw_qt) {
        this.bw_qt.set(bw_qt);
    }
    public boolean isSsxgzs() {
        return ssxgzs.get();
    }
    public BooleanProperty ssxgzsProperty() {
        if(ssxgzs==null){
            ssxgzs = new SimpleBooleanProperty(false);
        }
        return ssxgzs;
    }
    public void setSsxgzs(boolean ssxgzs) {
        this.ssxgzs.set(ssxgzs);
    }
    public boolean isSshj() {
        return sshj.get();
    }
    public BooleanProperty sshjProperty() {
        if(sshj==null){
            sshj = new SimpleBooleanProperty(false);
        }
        return sshj;
    }
    public void setSshj(boolean sshj) {
        this.sshj.set(sshj);
    }
    public boolean isSsry() {
        return ssry.get();
    }
    public BooleanProperty ssryProperty() {
        if(ssry==null){
            ssry = new SimpleBooleanProperty(false);
        }
        return ssry;
    }
    public void setSsry(boolean ssry) {
        this.ssry.set(ssry);
    }
    public boolean isJbgzlc() {
        return jbgzlc.get();
    }
    public BooleanProperty jbgzlcProperty() {
        if(jbgzlc==null){
            jbgzlc = new SimpleBooleanProperty(false);
        }
        return jbgzlc;
    }
    public void setJbgzlc(boolean jbgzlc) {
        this.jbgzlc.set(jbgzlc);
    }
    public boolean isGzgd_n() {
        return gzgd_n.get();
    }
    public BooleanProperty gzgd_nProperty() {
        if(gzgd_n==null){
            gzgd_n = new SimpleBooleanProperty(false);
        }
        return gzgd_n;
    }
    public void setGzgd_n(boolean gzgd_n) {
        this.gzgd_n.set(gzgd_n);
    }
    public boolean isGzgd_y() {
        return gzgd_y.get();
    }
    public BooleanProperty gzgd_yProperty() {
        if(gzgd_y==null){
            gzgd_y = new SimpleBooleanProperty(false);
        }
        return gzgd_y;
    }
    public void setGzgd_y(boolean gzgd_y) {
        this.gzgd_y.set(gzgd_y);
    }
    public boolean isWg() {
        return wg.get();
    }
    public BooleanProperty wgProperty() {
        if(wg==null){
            wg = new SimpleBooleanProperty(false);
        }
        return wg;
    }
    public void setWg(boolean wg) {
        this.wg.set(wg);
    }
    public boolean isNg() {
        return ng.get();
    }
    public BooleanProperty ngProperty() {
        if(ng==null){
            ng = new SimpleBooleanProperty(false);
        }
        return ng;
    }
    public void setNg(boolean ng) {
        this.ng.set(ng);
    }
    public boolean isYlg() {
        return ylg.get();
    }
    public BooleanProperty ylgProperty() {
        if(ylg==null){
            ylg = new SimpleBooleanProperty(false);
        }
        return ylg;
    }
    public void setYlg(boolean ylg) {
        this.ylg.set(ylg);
    }
    public boolean isSyg() {
        return syg.get();
    }
    public BooleanProperty sygProperty() {
        if(syg==null){
            syg = new SimpleBooleanProperty(false);
        }
        return syg;
    }
    public void setSyg(boolean syg) {
        this.syg.set(syg);
    }
    public boolean isTc() {
        return tc.get();
    }
    public BooleanProperty tcProperty() {
        if(tc==null){
            tc = new SimpleBooleanProperty(false);
        }
        return tc;
    }
    public void setTc(boolean tc) {
        this.tc.set(tc);
    }
    public boolean isDs() {
        return ds.get();
    }
    public BooleanProperty dsProperty() {
        if(ds==null){
            ds = new SimpleBooleanProperty(false);
        }
        return ds;
    }
    public void setDs(boolean ds) {
        this.ds.set(ds);
    }
    public boolean isSd() {
        return sd.get();
    }
    public BooleanProperty sdProperty() {
        if(sd==null){
            sd = new SimpleBooleanProperty(false);
        }
        return sd;
    }
    public void setSd(boolean sd) {
        this.sd.set(sd);
    }
    public boolean isZcfx_d() {
        return zcfx_d.get();
    }
    public BooleanProperty zcfx_dProperty() {
        if(zcfx_d==null){
            zcfx_d = new SimpleBooleanProperty(false);
        }
        return zcfx_d;
    }
    public void setZcfx_d(boolean zcfx_d) {
        this.zcfx_d.set(zcfx_d);
    }
    public boolean isZcfx_g() {
        return zcfx_g.get();
    }
    public BooleanProperty zcfx_gProperty() {
        if(zcfx_g==null){
            zcfx_g = new SimpleBooleanProperty(false);
        }
        return zcfx_g;
    }
    public void setZcfx_g(boolean zcfx_g) {
        this.zcfx_g.set(zcfx_g);
    }
    public boolean isDlwp_n() {
        return dlwp_n.get();
    }
    public BooleanProperty dlwp_nProperty() {
        if(dlwp_n==null){
            dlwp_n = new SimpleBooleanProperty(false);
        }
        return dlwp_n;
    }
    public void setDlwp_n(boolean dlwp_n) {
        this.dlwp_n.set(dlwp_n);
    }
    public boolean isDlwp_y() {
        return dlwp_y.get();
    }
    public BooleanProperty dlwp_yProperty() {
        if(dlwp_y==null){
            dlwp_y = new SimpleBooleanProperty(false);
        }
        return dlwp_y;
    }
    public void setDlwp_y(boolean dlwp_y) {
        this.dlwp_y.set(dlwp_y);
    }
    public boolean isXcg_zc() {
        return xcg_zc.get();
    }
    public BooleanProperty xcg_zcProperty() {
        if(xcg_zc==null){
            xcg_zc = new SimpleBooleanProperty(false);
        }
        return xcg_zc;
    }
    public void setXcg_zc(boolean xcg_zc) {
        this.xcg_zc.set(xcg_zc);
    }
    public boolean isXcg_yc() {
        return xcg_yc.get();
    }
    public BooleanProperty xcg_ycProperty() {
        if(xcg_yc==null){
            xcg_yc = new SimpleBooleanProperty(false);
        }
        return xcg_yc;
    }
    public void setXcg_yc(boolean xcg_yc) {
        this.xcg_yc.set(xcg_yc);
    }
    public boolean isXx_n() {
        return xx_n.get();
    }
    public BooleanProperty xx_nProperty() {
        if(xx_n==null){
            xx_n = new SimpleBooleanProperty(false);
        }
        return xx_n;
    }
    public void setXx_n(boolean xx_n) {
        this.xx_n.set(xx_n);
    }
    public boolean isXx_y() {
        return xx_y.get();
    }
    public BooleanProperty xx_yProperty() {
        if(xx_y==null){
            xx_y = new SimpleBooleanProperty(false);
        }
        return xx_y;
    }
    public void setXx_y(boolean xx_y) {
        this.xx_y.set(xx_y);
    }
    public boolean isNxgn_zc() {
        return nxgn_zc.get();
    }
    public BooleanProperty nxgn_zcProperty() {
        if(nxgn_zc==null){
            nxgn_zc = new SimpleBooleanProperty(false);
        }
        return nxgn_zc;
    }
    public void setNxgn_zc(boolean nxgn_zc) {
        this.nxgn_zc.set(nxgn_zc);
    }
    public boolean isNxgn_yc() {
        return nxgn_yc.get();
    }
    public BooleanProperty nxgn_ycProperty() {
        if(nxgn_yc==null){
            nxgn_yc = new SimpleBooleanProperty(false);
        }
        return nxgn_yc;
    }
    public void setNxgn_yc(boolean nxgn_yc) {
        this.nxgn_yc.set(nxgn_yc);
    }
    public boolean isGgn_zc() {
        return ggn_zc.get();
    }
    public BooleanProperty ggn_zcProperty() {
        if(ggn_zc==null){
            ggn_zc = new SimpleBooleanProperty(false);
        }
        return ggn_zc;
    }
    public void setGgn_zc(boolean ggn_zc) {
        this.ggn_zc.set(ggn_zc);
    }
    public boolean isGgn_yc() {
        return ggn_yc.get();
    }
    public BooleanProperty ggn_ycProperty() {
        if(ggn_yc==null){
            ggn_yc = new SimpleBooleanProperty(false);
        }
        return ggn_yc;
    }
    public void setGgn_yc(boolean ggn_yc) {
        this.ggn_yc.set(ggn_yc);
    }
    public boolean isSgn_zc() {
        return sgn_zc.get();
    }
    public BooleanProperty sgn_zcProperty() {
        if(sgn_zc==null){
            sgn_zc = new SimpleBooleanProperty(false);
        }
        return sgn_zc;
    }
    public void setSgn_zc(boolean sgn_zc) {
        this.sgn_zc.set(sgn_zc);
    }
    public boolean isSgn_yc() {
        return sgn_yc.get();
    }
    public BooleanProperty sgn_ycProperty() {
        if(sgn_yc==null){
            sgn_yc = new SimpleBooleanProperty(false);
        }
        return sgn_yc;
    }
    public void setSgn_yc(boolean sgn_yc) {
        this.sgn_yc.set(sgn_yc);
    }
    public boolean isGy_zc() {
        return gy_zc.get();
    }
    public BooleanProperty gy_zcProperty() {
        if(gy_zc==null){
            gy_zc = new SimpleBooleanProperty(false);
        }
        return gy_zc;
    }
    public void setGy_zc(boolean gy_zc) {
        this.gy_zc.set(gy_zc);
    }
    public boolean isGy_yc() {
        return gy_yc.get();
    }
    public BooleanProperty gy_ycProperty() {
        if(gy_yc==null){
            gy_yc = new SimpleBooleanProperty(false);
        }
        return gy_yc;
    }
    public void setGy_yc(boolean gy_yc) {
        this.gy_yc.set(gy_yc);
    }
    public boolean isYc() {
        return yc.get();
    }
    public BooleanProperty ycProperty() {
        if(yc==null){
            yc = new SimpleBooleanProperty(false);
        }
        return yc;
    }
    public void setYc(boolean yc) {
        this.yc.set(yc);
    }
    public boolean isKyrd() {
        return kyrd.get();
    }
    public BooleanProperty kyrdProperty() {
        if(kyrd==null){
            kyrd = new SimpleBooleanProperty(false);
        }
        return kyrd;
    }
    public void setKyrd(boolean kyrd) {
        this.kyrd.set(kyrd);
    }
    public boolean isFyfl() {
        return fyfl.get();
    }
    public BooleanProperty fyflProperty() {
        if(fyfl==null){
            fyfl = new SimpleBooleanProperty(false);
        }
        return fyfl;
    }
    public void setFyfl(boolean fyfl) {
        this.fyfl.set(fyfl);
    }
    public boolean isSsc() {
        return ssc.get();
    }
    public BooleanProperty sscProperty() {
        if(ssc==null){
            ssc = new SimpleBooleanProperty(false);
        }
        return ssc;
    }
    public void setSsc(boolean ssc) {
        this.ssc.set(ssc);
    }
    public boolean isJsqp() {
        return jsqp.get();
    }
    public BooleanProperty jsqpProperty() {
        if(jsqp==null){
            jsqp = new SimpleBooleanProperty(false);
        }
        return jsqp;
    }
    public void setJsqp(boolean jsqp) {
        this.jsqp.set(jsqp);
    }
    public boolean isBcgjzc() {
        return bcgjzc.get();
    }
    public BooleanProperty bcgjzcProperty() {
        if(bcgjzc==null){
            bcgjzc = new SimpleBooleanProperty(false);
        }
        return bcgjzc;
    }
    public void setBcgjzc(boolean bcgjzc) {
        this.bcgjzc.set(bcgjzc);
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
    public boolean isTwjc() {
        return twjc.get();
    }
    public BooleanProperty twjcProperty() {
        if(twjc==null){
            twjc = new SimpleBooleanProperty(false);
        }
        return twjc;
    }
    public void setTwjc(boolean twjc) {
        this.twjc.set(twjc);
    }
    public boolean isTsw() {
        return tsw.get();
    }
    public BooleanProperty tswProperty() {
        if(tsw==null){
            tsw = new SimpleBooleanProperty(false);
        }
        return tsw;
    }
    public void setTsw(boolean tsw) {
        this.tsw.set(tsw);
    }
    public boolean isJwyt() {
        return jwyt.get();
    }
    public BooleanProperty jwytProperty() {
        if(jwyt==null){
            jwyt = new SimpleBooleanProperty(false);
        }
        return jwyt;
    }
    public void setJwyt(boolean jwyt) {
        this.jwyt.set(jwyt);
    }
    public boolean isJwt() {
        return jwt.get();
    }
    public BooleanProperty jwtProperty() {
        if(jwt==null){
            jwt = new SimpleBooleanProperty(false);
        }
        return jwt;
    }
    public void setJwt(boolean jwt) {
        this.jwt.set(jwt);
    }
    public boolean isJsbl() {
        return jsbl.get();
    }
    public BooleanProperty jsblProperty() {
        if(jsbl==null){
            jsbl = new SimpleBooleanProperty(false);
        }
        return jsbl;
    }
    public void setJsbl(boolean jsbl) {
        this.jsbl.set(jsbl);
    }
    public boolean isZc() {
        return zc.get();
    }
    public BooleanProperty zcProperty() {
        if(zc==null){
            zc = new SimpleBooleanProperty(false);
        }
        return zc;
    }
    public void setZc(boolean zc) {
        this.zc.set(zc);
    }
    public boolean isJqxj() {
        return jqxj.get();
    }
    public BooleanProperty jqxjProperty() {
        if(jqxj==null){
            jqxj = new SimpleBooleanProperty(false);
        }
        return jqxj;
    }
    public void setJqxj(boolean jqxj) {
        this.jqxj.set(jqxj);
    }
    public boolean isSdys() {
        return sdys.get();
    }
    public BooleanProperty sdysProperty() {
        if(sdys==null){
            sdys = new SimpleBooleanProperty(false);
        }
        return sdys;
    }
    public void setSdys(boolean sdys) {
        this.sdys.set(sdys);
    }
    public boolean isMqgc() {
        return mqgc.get();
    }
    public BooleanProperty mqgcProperty() {
        if(mqgc==null){
            mqgc = new SimpleBooleanProperty(false);
        }
        return mqgc;
    }
    public void setMqgc(boolean mqgc) {
        this.mqgc.set(mqgc);
    }
    public boolean isGg() {
        return gg.get();
    }
    public BooleanProperty ggProperty() {
        if(gg==null){
            gg = new SimpleBooleanProperty(false);
        }
        return gg;
    }
    public void setGg(boolean gg) {
        this.gg.set(gg);
    }
    public boolean isJqxj2() {
        return jqxj2.get();
    }
    public BooleanProperty jqxj2Property() {
        if(jqxj2==null){
            jqxj2 = new SimpleBooleanProperty(false);
        }
        return jqxj2;
    }
    public void setJqxj2(boolean jqxj2) {
        this.jqxj2.set(jqxj2);
    }
    public boolean isGdtd() {
        return gdtd.get();
    }
    public BooleanProperty gdtdProperty() {
        if(gdtd==null){
            gdtd = new SimpleBooleanProperty(false);
        }
        return gdtd;
    }
    public void setGdtd(boolean gdtd) {
        this.gdtd.set(gdtd);
    }
    public boolean isXjlg() {
        return xjlg.get();
    }
    public BooleanProperty xjlgProperty() {
        if(xjlg==null){
            xjlg = new SimpleBooleanProperty(false);
        }
        return xjlg;
    }
    public void setXjlg(boolean xjlg) {
        this.xjlg.set(xjlg);
    }
    public boolean isHjbh() {
        return hjbh.get();
    }
    public BooleanProperty hjbhProperty() {
        if(hjbh==null){
            hjbh = new SimpleBooleanProperty(false);
        }
        return hjbh;
    }
    public void setHjbh(boolean hjbh) {
        this.hjbh.set(hjbh);
    }
    public boolean isMqgc2() {
        return mqgc2.get();
    }
    public BooleanProperty mqgc2Property() {
        if(mqgc2==null){
            mqgc2 = new SimpleBooleanProperty(false);
        }
        return mqgc2;
    }
    public void setMqgc2(boolean mqgc2) {
        this.mqgc2.set(mqgc2);
    }
    public boolean isSzdcx() {
        return szdcx.get();
    }
    public BooleanProperty szdcxProperty() {
        if(szdcx==null){
            szdcx = new SimpleBooleanProperty(false);
        }
        return szdcx;
    }
    public void setSzdcx(boolean szdcx) {
        this.szdcx.set(szdcx);
    }
    public boolean isJmtc() {
        return jmtc.get();
    }
    public BooleanProperty jmtcProperty() {
        if(jmtc==null){
            jmtc = new SimpleBooleanProperty(false);
        }
        return jmtc;
    }
    public void setJmtc(boolean jmtc) {
        this.jmtc.set(jmtc);
    }
    public boolean isZxyw() {
        return zxyw.get();
    }
    public BooleanProperty zxywProperty() {
        if(zxyw==null){
            zxyw = new SimpleBooleanProperty(false);
        }
        return zxyw;
    }
    public void setZxyw(boolean zxyw) {
        this.zxyw.set(zxyw);
    }
    public boolean isGccxl() {
        return gccxl.get();
    }
    public BooleanProperty gccxlProperty() {
        if(gccxl==null){
            gccxl = new SimpleBooleanProperty(false);
        }
        return gccxl;
    }
    public void setGccxl(boolean gccxl) {
        this.gccxl.set(gccxl);
    }
    public boolean isQtcs() {
        return qtcs.get();
    }
    public BooleanProperty qtcsProperty() {
        if(qtcs==null){
            qtcs = new SimpleBooleanProperty(false);
        }
        return qtcs;
    }
    public void setQtcs(boolean qtcs) {
        this.qtcs.set(qtcs);
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

    public String getZych() {
        return zych.get();
    }

    public StringProperty zychProperty() {
        if(zych == null){
            zych = new SimpleStringProperty();
        }
        return zych;
    }

    public void setZych(String zych) {
        this.zych.set(zych);
    }

    public String getZyh() {
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
    public String getTw() {
        return tw.get();
    }
    public StringProperty twProperty() {
        if(tw==null){
            tw = new SimpleStringProperty();
        }
        return tw;
    }
    public void setTw(String tw) {
        this.tw.set(tw);
    }
    public String getSsj() {
        return ssj.get();
    }
    public StringProperty ssjProperty() {
        if(ssj==null){
            ssj = new SimpleStringProperty();
        }
        return ssj;
    }
    public void setSsj(String ssj) {
        this.ssj.set(ssj);
    }
    public String getSqzd() {
        return sqzd.get();
    }
    public StringProperty sqzdProperty() {
        if(sqzd==null){
            sqzd = new SimpleStringProperty();
        }
        return sqzd;
    }
    public void setSqzd(String sqzd) {
        this.sqzd.set(sqzd);
    }
    public String getNsss1() {
        return nsss1.get();
    }
    public StringProperty nsss1Property() {
        if(nsss1==null){
            nsss1 = new SimpleStringProperty();
        }
        return nsss1;
    }
    public void setNsss1(String nsss1) {
        this.nsss1.set(nsss1);
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
    public String getBw() {
        return bw.get();
    }
    public StringProperty bwProperty() {
        if(bw==null){
            bw = new SimpleStringProperty();
        }
        return bw;
    }
    public void setBw(String bw) {
        this.bw.set(bw);
    }
    public String getXz() {
        return xz.get();
    }
    public StringProperty xzProperty() {
        if(xz==null){
            xz = new SimpleStringProperty();
        }
        return xz;
    }
    public void setXz(String xz) {
        this.xz.set(xz);
    }
    public String getBw2() {
        return bw2.get();
    }
    public StringProperty bw2Property() {
        if(bw2==null){
            bw2 = new SimpleStringProperty();
        }
        return bw2;
    }
    public void setBw2(String bw2) {
        this.bw2.set(bw2);
    }
    public String getBwqt() {
        return bwqt.get();
    }
    public StringProperty bwqtProperty() {
        if(bwqt==null){
            bwqt = new SimpleStringProperty();
        }
        return bwqt;
    }
    public void setBwqt(String bwqt) {
        this.bwqt.set(bwqt);
    }
    public String getQtcsText() {
        return qtcsText.get();
    }
    public StringProperty qtcsTextProperty() {
        if(qtcsText==null){
            qtcsText = new SimpleStringProperty();
        }
        return qtcsText;
    }
    public void setQtcsText(String qtcsText) {
        this.qtcsText.set(qtcsText);
    }
    public String getQm() {
        return qm.get();
    }
    public StringProperty qmProperty() {
        if(qm==null){
            qm = new SimpleStringProperty();
        }
        return qm;
    }
    public void setQm(String qm) {
        this.qm.set(qm);
    }
    public String getDatetime() {
        return datetime.get();
    }
    public StringProperty datetimeProperty() {
        if(datetime==null){
            datetime = new SimpleStringProperty();
        }
        return datetime;
    }
    public void setDatetime(String datetime) {
        this.datetime.set(datetime);
    }

}
