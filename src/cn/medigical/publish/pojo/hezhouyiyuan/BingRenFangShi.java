package cn.medigical.publish.pojo.hezhouyiyuan;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;

public class BingRenFangShi {
    /**阴*/
    private BooleanProperty hnsag_yin;
    /**阳*/
    private BooleanProperty hnsag_yan;
    /**无*/
    private BooleanProperty jws_n;
    /**有*/
    private BooleanProperty jws_y;
    /**阴*/
    private BooleanProperty azbd_yin;
    /**阳*/
    private BooleanProperty azbd_yan;
    /**阴*/
    private BooleanProperty bgbd_yin;
    /**阳*/
    private BooleanProperty bgbd_yan;
    /**无*/
    private BooleanProperty sss_n;
    /**有*/
    private BooleanProperty sss_y;
    /**无*/
    private BooleanProperty gms_n;
    /**有*/
    private BooleanProperty gms_y;
    /**健康*/
    private BooleanProperty st_jk;
    /**一般*/
    private BooleanProperty st_yb;
    /**虚弱*/
    private BooleanProperty st_xr;
    /**乐观*/
    private BooleanProperty xlzk_lg;
    /**平静*/
    private BooleanProperty xlzk_pj;
    /**紧张*/
    private BooleanProperty xlzk_jz;
    /**有*/
    private BooleanProperty ztyd_y;
    /**无*/
    private BooleanProperty ztyd_n;
    /**充盈*/
    private BooleanProperty xg_cy;
    /**较硬*/
    private BooleanProperty xg_jy;
    /**摸不到*/
    private BooleanProperty xg_mbd;
    /**好*/
    private BooleanProperty js_h;
    /**欠佳*/
    private BooleanProperty js_qj;
    /**萎靡*/
    private BooleanProperty js_wm;
    /**有*/
    private BooleanProperty tt_y;
    /**无*/
    private BooleanProperty tt_n;
    /**正常*/
    private BooleanProperty tw_zc;
    /**较高*/
    private BooleanProperty tw_jg;
    /**高热*/
    private BooleanProperty tw_gr;
    /**良好*/
    private BooleanProperty skyh_lh;
    /**较差*/
    private BooleanProperty skyh_jc;
    /**有*/
    private BooleanProperty pfps_y;
    /**无*/
    private BooleanProperty pfps_n;
    /**很好*/
    private BooleanProperty sspj_hh;
    /**一般*/
    private BooleanProperty sspj_yb;
    /**较差*/
    private BooleanProperty sspj_jc;
    /**欢迎*/
    private BooleanProperty hztd_hy;
    /**不欢迎*/
    private BooleanProperty hztd_bhy;
    /**乐观*/
    private BooleanProperty hzjszt_lg;
    /**平静*/
    private BooleanProperty hzjszt_pj;
    /**紧张*/
    private BooleanProperty hzjszt_jz;
    /**良好*/
    private BooleanProperty hzphqk_lh;
    /**一般*/
    private BooleanProperty hzphqk_yb;
    /**较差*/
    private BooleanProperty hzphqk_jc;
    /**良好*/
    private BooleanProperty hszbqk_lh;
    /**一般*/
    private BooleanProperty hszbqk_yb;
    /**较差*/
    private BooleanProperty hszbqk_jc;
    
    private BooleanProperty tx_p;
    @FXML
    private BooleanProperty tx_zc;
    @FXML
    private BooleanProperty tx_s;
    /**科别*/
    private StringProperty ksmc;
    /**床号:*/
    private StringProperty zych;
    /**姓名:*/
    private StringProperty brxm;
    /**性别:*/
    private StringProperty xb;
    /**年龄:*/
    private StringProperty nl;
    /**住院号:*/
    private StringProperty zyh;
    /**手术日期:*/
    private StringProperty operDoctor1StartTime;
    /**麻醉方式:*/
    private StringProperty mzff;
    /**体位:*/
    private StringProperty tw;
    /**诊断:*/
    private StringProperty sqzd;
    /**手术名称:*/
    private StringProperty nsss1;
    /**术前访视日期*/
    private StringProperty sqfsrq;
    /**有*/
    private StringProperty jwsText;
    /**有*/
    private StringProperty sssText;
    /**有*/
    private StringProperty gmsText;
    /**特殊问题及注意事项*/
    private StringProperty tszywt1;
    /**特殊问题及注意事项*/
    private StringProperty tszywt2;
    /**访视者*/
    private StringProperty fsz;
    /**术后访视日期*/
    private StringProperty shfsrq;
    /**术后第*/
    private StringProperty shdjt;
    /**特殊意见*/
    private StringProperty tsyj1;
    /**特殊意见*/
    private StringProperty tsyj2;
    /**回访者*/
    private StringProperty hfz;
    /**巡回护士签名*/
    private StringProperty xhhsqm;

    public boolean isTx_p() {
        return tx_p.get();
    }

    public BooleanProperty tx_pProperty() {
        if(tx_p==null){
            tx_p=new SimpleBooleanProperty(false);
        }
        return tx_p;
    }

    public void setTx_p(boolean tx_p) {
        this.tx_p.set(tx_p);
    }

    public boolean isTx_zc() {
        return tx_zc.get();
    }

    public BooleanProperty tx_zcProperty() {
        if(tx_zc==null){
            tx_zc=new SimpleBooleanProperty(false);
        }
        return tx_zc;
    }

    public void setTx_zc(boolean tx_zc) {
        this.tx_zc.set(tx_zc);
    }

    public boolean isTx_s() {
        return tx_s.get();
    }

    public BooleanProperty tx_sProperty() {
        if(tx_s==null){
            tx_s=new SimpleBooleanProperty(false);
        }
        return tx_s;
    }

    public void setTx_s(boolean tx_s) {
        this.tx_s.set(tx_s);
    }

    public boolean isHnsag_yin() {
        return hnsag_yin.get();
    }
    public BooleanProperty hnsag_yinProperty() {
        if(hnsag_yin==null){
            hnsag_yin = new SimpleBooleanProperty(false);
        }
        return hnsag_yin;
    }
    public void setHnsag_yin(boolean hnsag_yin) {
        this.hnsag_yin.set(hnsag_yin);
    }
    public boolean isHnsag_yan() {
        return hnsag_yan.get();
    }
    public BooleanProperty hnsag_yanProperty() {
        if(hnsag_yan==null){
            hnsag_yan = new SimpleBooleanProperty(false);
        }
        return hnsag_yan;
    }
    public void setHnsag_yan(boolean hnsag_yan) {
        this.hnsag_yan.set(hnsag_yan);
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
    public boolean isAzbd_yin() {
        return azbd_yin.get();
    }
    public BooleanProperty azbd_yinProperty() {
        if(azbd_yin==null){
            azbd_yin = new SimpleBooleanProperty(false);
        }
        return azbd_yin;
    }
    public void setAzbd_yin(boolean azbd_yin) {
        this.azbd_yin.set(azbd_yin);
    }
    public boolean isAzbd_yan() {
        return azbd_yan.get();
    }
    public BooleanProperty azbd_yanProperty() {
        if(azbd_yan==null){
            azbd_yan = new SimpleBooleanProperty(false);
        }
        return azbd_yan;
    }
    public void setAzbd_yan(boolean azbd_yan) {
        this.azbd_yan.set(azbd_yan);
    }
    public boolean isBgbd_yin() {
        return bgbd_yin.get();
    }
    public BooleanProperty bgbd_yinProperty() {
        if(bgbd_yin==null){
            bgbd_yin = new SimpleBooleanProperty(false);
        }
        return bgbd_yin;
    }
    public void setBgbd_yin(boolean bgbd_yin) {
        this.bgbd_yin.set(bgbd_yin);
    }
    public boolean isBgbd_yan() {
        return bgbd_yan.get();
    }
    public BooleanProperty bgbd_yanProperty() {
        if(bgbd_yan==null){
            bgbd_yan = new SimpleBooleanProperty(false);
        }
        return bgbd_yan;
    }
    public void setBgbd_yan(boolean bgbd_yan) {
        this.bgbd_yan.set(bgbd_yan);
    }
    public boolean isSss_n() {
        return sss_n.get();
    }
    public BooleanProperty sss_nProperty() {
        if(sss_n==null){
            sss_n = new SimpleBooleanProperty(false);
        }
        return sss_n;
    }
    public void setSss_n(boolean sss_n) {
        this.sss_n.set(sss_n);
    }
    public boolean isSss_y() {
        return sss_y.get();
    }
    public BooleanProperty sss_yProperty() {
        if(sss_y==null){
            sss_y = new SimpleBooleanProperty(false);
        }
        return sss_y;
    }
    public void setSss_y(boolean sss_y) {
        this.sss_y.set(sss_y);
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
    public boolean isSt_jk() {
        return st_jk.get();
    }
    public BooleanProperty st_jkProperty() {
        if(st_jk==null){
            st_jk = new SimpleBooleanProperty(false);
        }
        return st_jk;
    }
    public void setSt_jk(boolean st_jk) {
        this.st_jk.set(st_jk);
    }
    public boolean isSt_yb() {
        return st_yb.get();
    }
    public BooleanProperty st_ybProperty() {
        if(st_yb==null){
            st_yb = new SimpleBooleanProperty(false);
        }
        return st_yb;
    }
    public void setSt_yb(boolean st_yb) {
        this.st_yb.set(st_yb);
    }
    public boolean isSt_xr() {
        return st_xr.get();
    }
    public BooleanProperty st_xrProperty() {
        if(st_xr==null){
            st_xr = new SimpleBooleanProperty(false);
        }
        return st_xr;
    }
    public void setSt_xr(boolean st_xr) {
        this.st_xr.set(st_xr);
    }
    public boolean isXlzk_lg() {
        return xlzk_lg.get();
    }
    public BooleanProperty xlzk_lgProperty() {
        if(xlzk_lg==null){
            xlzk_lg = new SimpleBooleanProperty(false);
        }
        return xlzk_lg;
    }
    public void setXlzk_lg(boolean xlzk_lg) {
        this.xlzk_lg.set(xlzk_lg);
    }
    public boolean isXlzk_pj() {
        return xlzk_pj.get();
    }
    public BooleanProperty xlzk_pjProperty() {
        if(xlzk_pj==null){
            xlzk_pj = new SimpleBooleanProperty(false);
        }
        return xlzk_pj;
    }
    public void setXlzk_pj(boolean xlzk_pj) {
        this.xlzk_pj.set(xlzk_pj);
    }
    public boolean isXlzk_jz() {
        return xlzk_jz.get();
    }
    public BooleanProperty xlzk_jzProperty() {
        if(xlzk_jz==null){
            xlzk_jz = new SimpleBooleanProperty(false);
        }
        return xlzk_jz;
    }
    public void setXlzk_jz(boolean xlzk_jz) {
        this.xlzk_jz.set(xlzk_jz);
    }
    public boolean isZtyd_y() {
        return ztyd_y.get();
    }
    public BooleanProperty ztyd_yProperty() {
        if(ztyd_y==null){
            ztyd_y = new SimpleBooleanProperty(false);
        }
        return ztyd_y;
    }
    public void setZtyd_y(boolean ztyd_y) {
        this.ztyd_y.set(ztyd_y);
    }
    public boolean isZtyd_n() {
        return ztyd_n.get();
    }
    public BooleanProperty ztyd_nProperty() {
        if(ztyd_n==null){
            ztyd_n = new SimpleBooleanProperty(false);
        }
        return ztyd_n;
    }
    public void setZtyd_n(boolean ztyd_n) {
        this.ztyd_n.set(ztyd_n);
    }
    public boolean isXg_cy() {
        return xg_cy.get();
    }
    public BooleanProperty xg_cyProperty() {
        if(xg_cy==null){
            xg_cy = new SimpleBooleanProperty(false);
        }
        return xg_cy;
    }
    public void setXg_cy(boolean xg_cy) {
        this.xg_cy.set(xg_cy);
    }
    public boolean isXg_jy() {
        return xg_jy.get();
    }
    public BooleanProperty xg_jyProperty() {
        if(xg_jy==null){
            xg_jy = new SimpleBooleanProperty(false);
        }
        return xg_jy;
    }
    public void setXg_jy(boolean xg_jy) {
        this.xg_jy.set(xg_jy);
    }
    public boolean isXg_mbd() {
        return xg_mbd.get();
    }
    public BooleanProperty xg_mbdProperty() {
        if(xg_mbd==null){
            xg_mbd = new SimpleBooleanProperty(false);
        }
        return xg_mbd;
    }
    public void setXg_mbd(boolean xg_mbd) {
        this.xg_mbd.set(xg_mbd);
    }
    public boolean isJs_h() {
        return js_h.get();
    }
    public BooleanProperty js_hProperty() {
        if(js_h==null){
            js_h = new SimpleBooleanProperty(false);
        }
        return js_h;
    }
    public void setJs_h(boolean js_h) {
        this.js_h.set(js_h);
    }
    public boolean isJs_qj() {
        return js_qj.get();
    }
    public BooleanProperty js_qjProperty() {
        if(js_qj==null){
            js_qj = new SimpleBooleanProperty(false);
        }
        return js_qj;
    }
    public void setJs_qj(boolean js_qj) {
        this.js_qj.set(js_qj);
    }
    public boolean isJs_wm() {
        return js_wm.get();
    }
    public BooleanProperty js_wmProperty() {
        if(js_wm==null){
            js_wm = new SimpleBooleanProperty(false);
        }
        return js_wm;
    }
    public void setJs_wm(boolean js_wm) {
        this.js_wm.set(js_wm);
    }
    public boolean isTt_y() {
        return tt_y.get();
    }
    public BooleanProperty tt_yProperty() {
        if(tt_y==null){
            tt_y = new SimpleBooleanProperty(false);
        }
        return tt_y;
    }
    public void setTt_y(boolean tt_y) {
        this.tt_y.set(tt_y);
    }
    public boolean isTt_n() {
        return tt_n.get();
    }
    public BooleanProperty tt_nProperty() {
        if(tt_n==null){
            tt_n = new SimpleBooleanProperty(false);
        }
        return tt_n;
    }
    public void setTt_n(boolean tt_n) {
        this.tt_n.set(tt_n);
    }
    public boolean isTw_zc() {
        return tw_zc.get();
    }
    public BooleanProperty tw_zcProperty() {
        if(tw_zc==null){
            tw_zc = new SimpleBooleanProperty(false);
        }
        return tw_zc;
    }
    public void setTw_zc(boolean tw_zc) {
        this.tw_zc.set(tw_zc);
    }
    public boolean isTw_jg() {
        return tw_jg.get();
    }
    public BooleanProperty tw_jgProperty() {
        if(tw_jg==null){
            tw_jg = new SimpleBooleanProperty(false);
        }
        return tw_jg;
    }
    public void setTw_jg(boolean tw_jg) {
        this.tw_jg.set(tw_jg);
    }
    public boolean isTw_gr() {
        return tw_gr.get();
    }
    public BooleanProperty tw_grProperty() {
        if(tw_gr==null){
            tw_gr = new SimpleBooleanProperty(false);
        }
        return tw_gr;
    }
    public void setTw_gr(boolean tw_gr) {
        this.tw_gr.set(tw_gr);
    }
    public boolean isSkyh_lh() {
        return skyh_lh.get();
    }
    public BooleanProperty skyh_lhProperty() {
        if(skyh_lh==null){
            skyh_lh = new SimpleBooleanProperty(false);
        }
        return skyh_lh;
    }
    public void setSkyh_lh(boolean skyh_lh) {
        this.skyh_lh.set(skyh_lh);
    }
    public boolean isSkyh_jc() {
        return skyh_jc.get();
    }
    public BooleanProperty skyh_jcProperty() {
        if(skyh_jc==null){
            skyh_jc = new SimpleBooleanProperty(false);
        }
        return skyh_jc;
    }
    public void setSkyh_jc(boolean skyh_jc) {
        this.skyh_jc.set(skyh_jc);
    }
    public boolean isPfps_y() {
        return pfps_y.get();
    }
    public BooleanProperty pfps_yProperty() {
        if(pfps_y==null){
            pfps_y = new SimpleBooleanProperty(false);
        }
        return pfps_y;
    }
    public void setPfps_y(boolean pfps_y) {
        this.pfps_y.set(pfps_y);
    }
    public boolean isPfps_n() {
        return pfps_n.get();
    }
    public BooleanProperty pfps_nProperty() {
        if(pfps_n==null){
            pfps_n = new SimpleBooleanProperty(false);
        }
        return pfps_n;
    }
    public void setPfps_n(boolean pfps_n) {
        this.pfps_n.set(pfps_n);
    }
    public boolean isSspj_hh() {
        return sspj_hh.get();
    }
    public BooleanProperty sspj_hhProperty() {
        if(sspj_hh==null){
            sspj_hh = new SimpleBooleanProperty(false);
        }
        return sspj_hh;
    }
    public void setSspj_hh(boolean sspj_hh) {
        this.sspj_hh.set(sspj_hh);
    }
    public boolean isSspj_yb() {
        return sspj_yb.get();
    }
    public BooleanProperty sspj_ybProperty() {
        if(sspj_yb==null){
            sspj_yb = new SimpleBooleanProperty(false);
        }
        return sspj_yb;
    }
    public void setSspj_yb(boolean sspj_yb) {
        this.sspj_yb.set(sspj_yb);
    }
    public boolean isSspj_jc() {
        return sspj_jc.get();
    }
    public BooleanProperty sspj_jcProperty() {
        if(sspj_jc==null){
            sspj_jc = new SimpleBooleanProperty(false);
        }
        return sspj_jc;
    }
    public void setSspj_jc(boolean sspj_jc) {
        this.sspj_jc.set(sspj_jc);
    }
    public boolean isHztd_hy() {
        return hztd_hy.get();
    }
    public BooleanProperty hztd_hyProperty() {
        if(hztd_hy==null){
            hztd_hy = new SimpleBooleanProperty(false);
        }
        return hztd_hy;
    }
    public void setHztd_hy(boolean hztd_hy) {
        this.hztd_hy.set(hztd_hy);
    }
    public boolean isHztd_bhy() {
        return hztd_bhy.get();
    }
    public BooleanProperty hztd_bhyProperty() {
        if(hztd_bhy==null){
            hztd_bhy = new SimpleBooleanProperty(false);
        }
        return hztd_bhy;
    }
    public void setHztd_bhy(boolean hztd_bhy) {
        this.hztd_bhy.set(hztd_bhy);
    }
    public boolean isHzjszt_lg() {
        return hzjszt_lg.get();
    }
    public BooleanProperty hzjszt_lgProperty() {
        if(hzjszt_lg==null){
            hzjszt_lg = new SimpleBooleanProperty(false);
        }
        return hzjszt_lg;
    }
    public void setHzjszt_lg(boolean hzjszt_lg) {
        this.hzjszt_lg.set(hzjszt_lg);
    }
    public boolean isHzjszt_pj() {
        return hzjszt_pj.get();
    }
    public BooleanProperty hzjszt_pjProperty() {
        if(hzjszt_pj==null){
            hzjszt_pj = new SimpleBooleanProperty(false);
        }
        return hzjszt_pj;
    }
    public void setHzjszt_pj(boolean hzjszt_pj) {
        this.hzjszt_pj.set(hzjszt_pj);
    }
    public boolean isHzjszt_jz() {
        return hzjszt_jz.get();
    }
    public BooleanProperty hzjszt_jzProperty() {
        if(hzjszt_jz==null){
            hzjszt_jz = new SimpleBooleanProperty(false);
        }
        return hzjszt_jz;
    }
    public void setHzjszt_jz(boolean hzjszt_jz) {
        this.hzjszt_jz.set(hzjszt_jz);
    }
    public boolean isHzphqk_lh() {
        return hzphqk_lh.get();
    }
    public BooleanProperty hzphqk_lhProperty() {
        if(hzphqk_lh==null){
            hzphqk_lh = new SimpleBooleanProperty(false);
        }
        return hzphqk_lh;
    }
    public void setHzphqk_lh(boolean hzphqk_lh) {
        this.hzphqk_lh.set(hzphqk_lh);
    }
    public boolean isHzphqk_yb() {
        return hzphqk_yb.get();
    }
    public BooleanProperty hzphqk_ybProperty() {
        if(hzphqk_yb==null){
            hzphqk_yb = new SimpleBooleanProperty(false);
        }
        return hzphqk_yb;
    }
    public void setHzphqk_yb(boolean hzphqk_yb) {
        this.hzphqk_yb.set(hzphqk_yb);
    }
    public boolean isHzphqk_jc() {
        return hzphqk_jc.get();
    }
    public BooleanProperty hzphqk_jcProperty() {
        if(hzphqk_jc==null){
            hzphqk_jc = new SimpleBooleanProperty(false);
        }
        return hzphqk_jc;
    }
    public void setHzphqk_jc(boolean hzphqk_jc) {
        this.hzphqk_jc.set(hzphqk_jc);
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
        if(zych==null){
            zych = new SimpleStringProperty();
        }
        return zych;
    }
    public void setZych(String zych) {
        this.zych.set(zych);
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
    public String getOperDoctor1StartTime() {
        return operDoctor1StartTime.get();
    }
    public StringProperty operDoctor1StartTimeProperty() {
        if(operDoctor1StartTime==null){
            operDoctor1StartTime = new SimpleStringProperty();
        }
        return operDoctor1StartTime;
    }
    public void setOperDoctor1StartTime(String operDoctor1StartTime) {
        this.operDoctor1StartTime.set(operDoctor1StartTime);
    }
    public String getMzff() {
        return mzff.get();
    }
    public StringProperty mzffProperty() {
        if(mzff==null){
            mzff = new SimpleStringProperty();
        }
        return mzff;
    }
    public void setMzff(String mzff) {
        this.mzff.set(mzff);
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
    public String getSqfsrq() {
        return sqfsrq.get();
    }
    public StringProperty sqfsrqProperty() {
        if(sqfsrq==null){
            sqfsrq = new SimpleStringProperty();
        }
        return sqfsrq;
    }
    public void setSqfsrq(String sqfsrq) {
        this.sqfsrq.set(sqfsrq);
    }
    public String getJwsText() {
        return jwsText.get();
    }
    public StringProperty jwsTextProperty() {
        if(jwsText==null){
            jwsText = new SimpleStringProperty();
        }
        return jwsText;
    }
    public void setJwsText(String jwsText) {
        this.jwsText.set(jwsText);
    }
    public String getSssText() {
        return sssText.get();
    }
    public StringProperty sssTextProperty() {
        if(sssText==null){
            sssText = new SimpleStringProperty();
        }
        return sssText;
    }
    public void setSssText(String sssText) {
        this.sssText.set(sssText);
    }
    public String getGmsText() {
        return gmsText.get();
    }
    public StringProperty gmsTextProperty() {
        if(gmsText==null){
            gmsText = new SimpleStringProperty();
        }
        return gmsText;
    }
    public void setGmsText(String gmsText) {
        this.gmsText.set(gmsText);
    }
    public String getTszywt1() {
        return tszywt1.get();
    }
    public StringProperty tszywt1Property() {
        if(tszywt1==null){
            tszywt1 = new SimpleStringProperty();
        }
        return tszywt1;
    }
    public void setTszywt1(String tszywt1) {
        this.tszywt1.set(tszywt1);
    }
    public String getTszywt2() {
        return tszywt2.get();
    }
    public StringProperty tszywt2Property() {
        if(tszywt2==null){
            tszywt2 = new SimpleStringProperty();
        }
        return tszywt2;
    }
    public void setTszywt2(String tszywt2) {
        this.tszywt2.set(tszywt2);
    }
    public String getFsz() {
        return fsz.get();
    }
    public StringProperty fszProperty() {
        if(fsz==null){
            fsz = new SimpleStringProperty();
        }
        return fsz;
    }
    public void setFsz(String fsz) {
        this.fsz.set(fsz);
    }
    public String getShfsrq() {
        return shfsrq.get();
    }
    public StringProperty shfsrqProperty() {
        if(shfsrq==null){
            shfsrq = new SimpleStringProperty();
        }
        return shfsrq;
    }
    public void setShfsrq(String shfsrq) {
        this.shfsrq.set(shfsrq);
    }
    public String getShdjt() {
        return shdjt.get();
    }
    public StringProperty shdjtProperty() {
        if(shdjt==null){
            shdjt = new SimpleStringProperty();
        }
        return shdjt;
    }
    public void setShdjt(String shdjt) {
        this.shdjt.set(shdjt);
    }
    public String getTsyj1() {
        return tsyj1.get();
    }
    public StringProperty tsyj1Property() {
        if(tsyj1==null){
            tsyj1 = new SimpleStringProperty();
        }
        return tsyj1;
    }
    public void setTsyj1(String tsyj1) {
        this.tsyj1.set(tsyj1);
    }
    public String getTsyj2() {
        return tsyj2.get();
    }
    public StringProperty tsyj2Property() {
        if(tsyj2==null){
            tsyj2 = new SimpleStringProperty();
        }
        return tsyj2;
    }
    public void setTsyj2(String tsyj2) {
        this.tsyj2.set(tsyj2);
    }
    public String getHfz() {
        return hfz.get();
    }
    public StringProperty hfzProperty() {
        if(hfz==null){
            hfz = new SimpleStringProperty();
        }
        return hfz;
    }
    public void setHfz(String hfz) {
        this.hfz.set(hfz);
    }
    public String getXhhsqm() {
        return xhhsqm.get();
    }
    public StringProperty xhhsqmProperty() {
        if(xhhsqm==null){
            xhhsqm = new SimpleStringProperty();
        }
        return xhhsqm;
    }
    public void setXhhsqm(String xhhsqm) {
        this.xhhsqm.set(xhhsqm);
    }

}
