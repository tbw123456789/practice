package cn.medigical.publish.pojo.hezhouyiyuan;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ShuHouFangShi {
    /**是/*/
    private BooleanProperty qm_y;
    /**否;*/
    private BooleanProperty qm_n;
    /**是/*/
    private BooleanProperty flwx_y;
    /**否;*/
    private BooleanProperty flwx_n;
    /**是/*/
    private BooleanProperty hxgdzs_y;
    /**否;*/
    private BooleanProperty hxgdzs_n;
    /**有/*/
    private BooleanProperty hzqg_y;
    /**无;*/
    private BooleanProperty hzqg_n;
    /**是/*/
    private BooleanProperty qgbg_y;
    /**否/*/
    private BooleanProperty qgbg_n;
    /**是/*/
    private BooleanProperty qghx_y;
    /**否*/
    private BooleanProperty qghx_n;
    /**有/*/
    private BooleanProperty zgnz_y;
    /**无;*/
    private BooleanProperty zgnz_n;
    /**有/*/
    private BooleanProperty tpg_y;
    /**无*/
    private BooleanProperty tpg_n;
    /**有/*/
    private BooleanProperty zlxt_y;
    /**无;*/
    private BooleanProperty zlxt_n;
    /**有/*/
    private BooleanProperty cx_y;
    /**无;*/
    private BooleanProperty cx_n;
    /**有/*/
    private BooleanProperty chuac_y;
    /**无;*/
    private BooleanProperty chuac_n;
    /**有/*/
    private BooleanProperty fy_y;
    /**否;*/
    private BooleanProperty fy_n;
    /**有/*/
    private BooleanProperty ym_y;
    /**无;*/
    private BooleanProperty ym_n;
    /**有/*/
    private BooleanProperty qjm_y;
    /**无;*/
    private BooleanProperty qjm_n;
    /**完善/*/
    private BooleanProperty mzxg_ws;
    /**不完善/*/
    private BooleanProperty mzxg_nws;
    /**失败*/
    private BooleanProperty mzxg_n;
    /**完善/*/
    private BooleanProperty mzxiaog_ws1;
    /**不完善/*/
    private BooleanProperty mzxiaog_nws1;
    /**失败;*/
    private BooleanProperty mzxiaog_n1;
    /**是/*/
    private BooleanProperty zt_y1;
    /**否;  改全麻（*/
    private BooleanProperty zt_n1;
    /**是/*/
    private BooleanProperty ztqm_y1;
    /**否） 顺利;*/
    private BooleanProperty ztqm_n1;
    /**是/*/
    private BooleanProperty shjzz_y;
    /**否;*/
    private BooleanProperty shjzz_n;
    /**有/*/
    private BooleanProperty jbmz_y;
    /**无;*/
    private BooleanProperty jbmz_n;
    /**有/*/
    private BooleanProperty zuzhiss_y;
    /**无;*/
    private BooleanProperty zuzhiss_n;
    /**完善/*/
    private BooleanProperty mzxiaog_ws;
    /**不完善/*/
    private BooleanProperty mzxiaog_nws;
    /**失败;*/
    private BooleanProperty mzxiaog_n;
    /**是/*/
    private BooleanProperty zt_y;
    /**否; 改全麻*/
    private BooleanProperty zt_n;
    /**是/*/
    private BooleanProperty ztqm_y;
    /**否 顺利;*/
    private BooleanProperty ztqm_n;
    /**是/*/
    private BooleanProperty jm_y;
    /**否*/
    private BooleanProperty jm_n;
    /**是/*/
    private BooleanProperty zrsl_y;
    /**否;*/
    private BooleanProperty zrsl_n;
    /**是/*/
    private BooleanProperty hxtc_y;
    /**否;*/
    private BooleanProperty hxtc_n;
    /**有/*/
    private BooleanProperty wcdm_y;
    /**无;*/
    private BooleanProperty wcdm_n;
    /**有/*/
    private BooleanProperty brbs_y;
    /**无*/
    private BooleanProperty sbrbs_n;
    /**阴性/*/
    private BooleanProperty dmci_y;
    /**阳性。*/
    private BooleanProperty dmci_n;
    /**是/*/
    private BooleanProperty sl_y;
    /**否。*/
    private BooleanProperty sl_n;
    /**是/*/
    private BooleanProperty smtz_y;
    /**否;*/
    private BooleanProperty smtz_n;
    /**有/*/
    private BooleanProperty xy_y;
    /**无；*/
    private BooleanProperty xy_n;
    /**有/*/
    private BooleanProperty dyz_y;
    /**无；*/
    private BooleanProperty dyz_n;
    /**有/*/
    private BooleanProperty gtsxz_y;
    /**无；*/
    private BooleanProperty gtsxz_n;
    /**有/*/
    private BooleanProperty szzd_y;
    /**无；*/
    private BooleanProperty szzd_n;
    /**有/*/
    private BooleanProperty szcx_y;
    /**无；*/
    private BooleanProperty szcx_n;
    /**有/*/
    private BooleanProperty ywgm_y;
    /**无；*/
    private BooleanProperty ywgm_n;
    /**是/*/
    private BooleanProperty qk_y;
    /**否;*/
    private BooleanProperty qk_n;
    /**送至病房/*/
    private BooleanProperty qk_szbf;
    /**PACU/*/
    private BooleanProperty qk_pacu;
    /**ICU时;    BP*/
    private BooleanProperty qk_icu;
    /**吸氧/*/
    private BooleanProperty sp_xy;
    /**空气口),   T*/
    private BooleanProperty sp_kq;
    /**是/*/
    private BooleanProperty qx_y;
    /**否;*/
    private BooleanProperty qx_n;
    /**正常/*/
    private BooleanProperty jl_y;
    /**不正常；*/
    private BooleanProperty jl_n;
    /**是/*/
    private BooleanProperty smtzpw_y;
    /**否;*/
    private BooleanProperty smtzpw_n;
    /**清醒/*/
    private BooleanProperty sz_qx;
    /**嗜睡/*/
    private BooleanProperty sz_ss;
    /**昏迷/*/
    private BooleanProperty sz_hm;
    /**模糊,*/
    private BooleanProperty sz_mh;
    /**满意/*/
    private BooleanProperty pca_my;
    /**不满意;*/
    private BooleanProperty pca_bmy;
    /**正常/*/
    private BooleanProperty xfjc_y;
    /**异常*/
    private BooleanProperty xfjc_n;
    /**有/*/
    private BooleanProperty hxxt_y;
    /**无;*/
    private BooleanProperty hxxt_n;
    /**有/*/
    private BooleanProperty fbgr_y;
    /**无；*/
    private BooleanProperty fbgr_n;
    /**有/*/
    private BooleanProperty hxkn_y;
    /**无；*/
    private BooleanProperty hxkn_n;
    /**有/*/
    private BooleanProperty dyxz_y;
    /**无；*/
    private BooleanProperty dyxz_n;
    /**有/*/
    private BooleanProperty hxsj_y;
    /**无；*/
    private BooleanProperty hxsj_n;
    /**有/*/
    private BooleanProperty gxy_y;
    /**无;*/
    private BooleanProperty gxy_n;
    /**有/*/
    private BooleanProperty yzxl_y;
    /**无；*/
    private BooleanProperty yzxl_n;
    /**有/*/
    private BooleanProperty xjt_y;
    /**无；*/
    private BooleanProperty xjt_n;
    /**有/*/
    private BooleanProperty xlsj_y;
    /**无；*/
    private BooleanProperty xlsj_n;
    /**有/*/
    private BooleanProperty rzgn_y;
    /**无;*/
    private BooleanProperty rzgn_n;
    /**有/*/
    private BooleanProperty szzx_y;
    /**无；*/
    private BooleanProperty szzx_n;
    /**正常/*/
    private BooleanProperty ztgj_y;
    /**异常；*/
    private BooleanProperty ztgj_n;
    /**有/*/
    private BooleanProperty jz_y;
    /**无;*/
    private BooleanProperty jz_n;
    /**有/*/
    private BooleanProperty exot_y;
    /**无;*/
    private BooleanProperty exot_n;
    /**有/*/
    private BooleanProperty nzl_y;
    /**无；*/
    private BooleanProperty nzl_n;
    /**是/*/
    private BooleanProperty mzmy_y;
    /**否；*/
    private BooleanProperty mzmy_n;
    /**有/*/
    private BooleanProperty bfz_y;
    /**无*/
    private BooleanProperty bfz_n;
    /**有/*/
    private BooleanProperty yj_y;
    /**无*/
    private BooleanProperty yj_n;
    /**姓名*/
    private StringProperty brxm;
    /**性别*/
    private StringProperty xb;
    /**科室*/
    private StringProperty ksmc;
    /**科室*/
    private StringProperty sg;
    /**床号*/
    private StringProperty zych;
    /**住院号*/
    private StringProperty zyh;
    /**术前阻滞平面:HBox.hgrow=ALWAYS*/
    private StringProperty zzhipm;
    /**术毕阻滞平面:*/
    private StringProperty sbzzhipm;
    /**4.*/
    private StringProperty jmText;
    /**进针:*/
    private StringProperty jzText;
    /**置入*/
    private StringProperty zrText;
    /**F导管:*/
    private StringProperty dgText;
    /**5.*/
    private StringProperty dmciText;
    /**无；*/
    private StringProperty ywxzp;
    /**ICU时;BP*/
    private StringProperty bptext;
    /**P*/
    private StringProperty ptext;
    /**R*/
    private StringProperty rtext;
    /**Sp02*/
    private StringProperty spo2text;
    /**空气口),T*/
    private StringProperty ttext;
    /**清醒时间:*/
    private StringProperty qxsj;
    /**8.特殊情况（必要时在病程记录上详细记录抢救经过）:*/
    private StringProperty tsqkText;
    /**麻醉医师签名:*/
    private StringProperty mzysqm;
    /**护送者签名:*/
    private StringProperty hszqm;
    /**日期:*/
    private StringProperty rq;
    /**特殊主诉:*/
    private StringProperty tszs;
    /**异常fx:id=xfjc_n*/
    private StringProperty xfjctext;
    /**投诉意见:*/
    private StringProperty mzmyText;
    /**无*/
    private StringProperty bfzText;
    /**无*/
    private StringProperty bfzText2;
    /**无*/
    private StringProperty bfzText3;
    /**无*/
    private StringProperty yjText;
    /**无*/
    private StringProperty yjText2;
    /**无*/
    private StringProperty yjText3;
    /**麻醉医师签名:*/
    private StringProperty mzysqm2;
    /**日期:*/
    private StringProperty rq2;
    private boolean flag;

    private StringProperty shzt_a;
    private StringProperty shzt_b;
    private StringProperty shzt_c;
    private StringProperty shzt_d;
    private StringProperty shzt_e;
    private StringProperty shzt_f;
    private StringProperty shzt_g;

    public String getShzt_a() {
        return shzt_a.get();
    }

    public StringProperty shzt_aProperty() {
        if(shzt_a==null){
            shzt_a = new SimpleStringProperty();
        }
        return shzt_a;
    }

    public void setShzt_a(String shzt_a) {
        this.shzt_a.set(shzt_a);
    }

    public String getShzt_b() {
        return shzt_b.get();
    }

    public StringProperty shzt_bProperty() {
        if(shzt_b==null){
            shzt_b = new SimpleStringProperty();
        }
        return shzt_b;
    }

    public void setShzt_b(String shzt_b) {
        this.shzt_b.set(shzt_b);
    }

    public String getShzt_c() {
        return shzt_c.get();
    }

    public StringProperty shzt_cProperty() {
        if(shzt_c==null){
            shzt_c = new SimpleStringProperty();
        }
        return shzt_c;
    }

    public void setShzt_c(String shzt_c) {
        this.shzt_c.set(shzt_c);
    }

    public String getShzt_d() {
        return shzt_d.get();
    }

    public StringProperty shzt_dProperty() {
        if(shzt_d==null){
            shzt_d = new SimpleStringProperty();
        }
        return shzt_d;
    }

    public void setShzt_d(String shzt_d) {
        this.shzt_d.set(shzt_d);
    }

    public String getShzt_e() {
        return shzt_e.get();
    }

    public StringProperty shzt_eProperty() {
        if(shzt_e==null){
            shzt_e = new SimpleStringProperty();
        }
        return shzt_e;
    }

    public void setShzt_e(String shzt_e) {
        this.shzt_e.set(shzt_e);
    }

    public String getShzt_f() {
        return shzt_f.get();
    }

    public StringProperty shzt_fProperty() {
        if(shzt_f==null){
            shzt_f = new SimpleStringProperty();
        }
        return shzt_f;
    }

    public void setShzt_f(String shzt_f) {
        this.shzt_f.set(shzt_f);
    }

    public String getShzt_g() {
        return shzt_g.get();
    }

    public StringProperty shzt_gProperty() {
        if(shzt_g==null){
            shzt_g = new SimpleStringProperty();
        }
        return shzt_g;
    }

    public void setShzt_g(String shzt_g) {
        this.shzt_g.set(shzt_g);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isQm_y() {
        return qm_y.get();
    }
    public BooleanProperty qm_yProperty() {
        if(qm_y==null){
            qm_y = new SimpleBooleanProperty(false);
        }
        return qm_y;
    }
    public void setQm_y(boolean qm_y) {
        this.qm_y.set(qm_y);
    }
    public boolean isQm_n() {
        return qm_n.get();
    }
    public BooleanProperty qm_nProperty() {
        if(qm_n==null){
            qm_n = new SimpleBooleanProperty(false);
        }
        return qm_n;
    }
    public void setQm_n(boolean qm_n) {
        this.qm_n.set(qm_n);
    }
    public boolean isFlwx_y() {
        return flwx_y.get();
    }
    public BooleanProperty flwx_yProperty() {
        if(flwx_y==null){
            flwx_y = new SimpleBooleanProperty(false);
        }
        return flwx_y;
    }
    public void setFlwx_y(boolean flwx_y) {
        this.flwx_y.set(flwx_y);
    }
    public boolean isFlwx_n() {
        return flwx_n.get();
    }
    public BooleanProperty flwx_nProperty() {
        if(flwx_n==null){
            flwx_n = new SimpleBooleanProperty(false);
        }
        return flwx_n;
    }
    public void setFlwx_n(boolean flwx_n) {
        this.flwx_n.set(flwx_n);
    }
    public boolean isHxgdzs_y() {
        return hxgdzs_y.get();
    }
    public BooleanProperty hxgdzs_yProperty() {
        if(hxgdzs_y==null){
            hxgdzs_y = new SimpleBooleanProperty(false);
        }
        return hxgdzs_y;
    }
    public void setHxgdzs_y(boolean hxgdzs_y) {
        this.hxgdzs_y.set(hxgdzs_y);
    }
    public boolean isHxgdzs_n() {
        return hxgdzs_n.get();
    }
    public BooleanProperty hxgdzs_nProperty() {
        if(hxgdzs_n==null){
            hxgdzs_n = new SimpleBooleanProperty(false);
        }
        return hxgdzs_n;
    }
    public void setHxgdzs_n(boolean hxgdzs_n) {
        this.hxgdzs_n.set(hxgdzs_n);
    }
    public boolean isHzqg_y() {
        return hzqg_y.get();
    }
    public BooleanProperty hzqg_yProperty() {
        if(hzqg_y==null){
            hzqg_y = new SimpleBooleanProperty(false);
        }
        return hzqg_y;
    }
    public void setHzqg_y(boolean hzqg_y) {
        this.hzqg_y.set(hzqg_y);
    }
    public boolean isHzqg_n() {
        return hzqg_n.get();
    }
    public BooleanProperty hzqg_nProperty() {
        if(hzqg_n==null){
            hzqg_n = new SimpleBooleanProperty(false);
        }
        return hzqg_n;
    }
    public void setHzqg_n(boolean hzqg_n) {
        this.hzqg_n.set(hzqg_n);
    }
    public boolean isQgbg_y() {
        return qgbg_y.get();
    }
    public BooleanProperty qgbg_yProperty() {
        if(qgbg_y==null){
            qgbg_y = new SimpleBooleanProperty(false);
        }
        return qgbg_y;
    }
    public void setQgbg_y(boolean qgbg_y) {
        this.qgbg_y.set(qgbg_y);
    }
    public boolean isQgbg_n() {
        return qgbg_n.get();
    }
    public BooleanProperty qgbg_nProperty() {
        if(qgbg_n==null){
            qgbg_n = new SimpleBooleanProperty(false);
        }
        return qgbg_n;
    }
    public void setQgbg_n(boolean qgbg_n) {
        this.qgbg_n.set(qgbg_n);
    }
    public boolean isQghx_y() {
        return qghx_y.get();
    }
    public BooleanProperty qghx_yProperty() {
        if(qghx_y==null){
            qghx_y = new SimpleBooleanProperty(false);
        }
        return qghx_y;
    }
    public void setQghx_y(boolean qghx_y) {
        this.qghx_y.set(qghx_y);
    }
    public boolean isQghx_n() {
        return qghx_n.get();
    }
    public BooleanProperty qghx_nProperty() {
        if(qghx_n==null){
            qghx_n = new SimpleBooleanProperty(false);
        }
        return qghx_n;
    }
    public void setQghx_n(boolean qghx_n) {
        this.qghx_n.set(qghx_n);
    }
    public boolean isZgnz_y() {
        return zgnz_y.get();
    }
    public BooleanProperty zgnz_yProperty() {
        if(zgnz_y==null){
            zgnz_y = new SimpleBooleanProperty(false);
        }
        return zgnz_y;
    }
    public void setZgnz_y(boolean zgnz_y) {
        this.zgnz_y.set(zgnz_y);
    }
    public boolean isZgnz_n() {
        return zgnz_n.get();
    }
    public BooleanProperty zgnz_nProperty() {
        if(zgnz_n==null){
            zgnz_n = new SimpleBooleanProperty(false);
        }
        return zgnz_n;
    }
    public void setZgnz_n(boolean zgnz_n) {
        this.zgnz_n.set(zgnz_n);
    }
    public boolean isTpg_y() {
        return tpg_y.get();
    }
    public BooleanProperty tpg_yProperty() {
        if(tpg_y==null){
            tpg_y = new SimpleBooleanProperty(false);
        }
        return tpg_y;
    }
    public void setTpg_y(boolean tpg_y) {
        this.tpg_y.set(tpg_y);
    }
    public boolean isTpg_n() {
        return tpg_n.get();
    }
    public BooleanProperty tpg_nProperty() {
        if(tpg_n==null){
            tpg_n = new SimpleBooleanProperty(false);
        }
        return tpg_n;
    }
    public void setTpg_n(boolean tpg_n) {
        this.tpg_n.set(tpg_n);
    }
    public boolean isZlxt_y() {
        return zlxt_y.get();
    }
    public BooleanProperty zlxt_yProperty() {
        if(zlxt_y==null){
            zlxt_y = new SimpleBooleanProperty(false);
        }
        return zlxt_y;
    }
    public void setZlxt_y(boolean zlxt_y) {
        this.zlxt_y.set(zlxt_y);
    }
    public boolean isZlxt_n() {
        return zlxt_n.get();
    }
    public BooleanProperty zlxt_nProperty() {
        if(zlxt_n==null){
            zlxt_n = new SimpleBooleanProperty(false);
        }
        return zlxt_n;
    }
    public void setZlxt_n(boolean zlxt_n) {
        this.zlxt_n.set(zlxt_n);
    }
    public boolean isCx_y() {
        return cx_y.get();
    }
    public BooleanProperty cx_yProperty() {
        if(cx_y==null){
            cx_y = new SimpleBooleanProperty(false);
        }
        return cx_y;
    }
    public void setCx_y(boolean cx_y) {
        this.cx_y.set(cx_y);
    }
    public boolean isCx_n() {
        return cx_n.get();
    }
    public BooleanProperty cx_nProperty() {
        if(cx_n==null){
            cx_n = new SimpleBooleanProperty(false);
        }
        return cx_n;
    }
    public void setCx_n(boolean cx_n) {
        this.cx_n.set(cx_n);
    }
    public boolean isChuac_y() {
        return chuac_y.get();
    }
    public BooleanProperty chuac_yProperty() {
        if(chuac_y==null){
            chuac_y = new SimpleBooleanProperty(false);
        }
        return chuac_y;
    }
    public void setChuac_y(boolean chuac_y) {
        this.chuac_y.set(chuac_y);
    }
    public boolean isChuac_n() {
        return chuac_n.get();
    }
    public BooleanProperty chuac_nProperty() {
        if(chuac_n==null){
            chuac_n = new SimpleBooleanProperty(false);
        }
        return chuac_n;
    }
    public void setChuac_n(boolean chuac_n) {
        this.chuac_n.set(chuac_n);
    }
    public boolean isFy_y() {
        return fy_y.get();
    }
    public BooleanProperty fy_yProperty() {
        if(fy_y==null){
            fy_y = new SimpleBooleanProperty(false);
        }
        return fy_y;
    }
    public void setFy_y(boolean fy_y) {
        this.fy_y.set(fy_y);
    }
    public boolean isFy_n() {
        return fy_n.get();
    }
    public BooleanProperty fy_nProperty() {
        if(fy_n==null){
            fy_n = new SimpleBooleanProperty(false);
        }
        return fy_n;
    }
    public void setFy_n(boolean fy_n) {
        this.fy_n.set(fy_n);
    }
    public boolean isYm_y() {
        return ym_y.get();
    }
    public BooleanProperty ym_yProperty() {
        if(ym_y==null){
            ym_y = new SimpleBooleanProperty(false);
        }
        return ym_y;
    }
    public void setYm_y(boolean ym_y) {
        this.ym_y.set(ym_y);
    }
    public boolean isYm_n() {
        return ym_n.get();
    }
    public BooleanProperty ym_nProperty() {
        if(ym_n==null){
            ym_n = new SimpleBooleanProperty(false);
        }
        return ym_n;
    }
    public void setYm_n(boolean ym_n) {
        this.ym_n.set(ym_n);
    }
    public boolean isQjm_y() {
        return qjm_y.get();
    }
    public BooleanProperty qjm_yProperty() {
        if(qjm_y==null){
            qjm_y = new SimpleBooleanProperty(false);
        }
        return qjm_y;
    }
    public void setQjm_y(boolean qjm_y) {
        this.qjm_y.set(qjm_y);
    }
    public boolean isQjm_n() {
        return qjm_n.get();
    }
    public BooleanProperty qjm_nProperty() {
        if(qjm_n==null){
            qjm_n = new SimpleBooleanProperty(false);
        }
        return qjm_n;
    }
    public void setQjm_n(boolean qjm_n) {
        this.qjm_n.set(qjm_n);
    }
    public boolean isMzxg_ws() {
        return mzxg_ws.get();
    }
    public BooleanProperty mzxg_wsProperty() {
        if(mzxg_ws==null){
            mzxg_ws = new SimpleBooleanProperty(false);
        }
        return mzxg_ws;
    }
    public void setMzxg_ws(boolean mzxg_ws) {
        this.mzxg_ws.set(mzxg_ws);
    }
    public boolean isMzxg_nws() {
        return mzxg_nws.get();
    }
    public BooleanProperty mzxg_nwsProperty() {
        if(mzxg_nws==null){
            mzxg_nws = new SimpleBooleanProperty(false);
        }
        return mzxg_nws;
    }
    public void setMzxg_nws(boolean mzxg_nws) {
        this.mzxg_nws.set(mzxg_nws);
    }
    public boolean isMzxg_n() {
        return mzxg_n.get();
    }
    public BooleanProperty mzxg_nProperty() {
        if(mzxg_n==null){
            mzxg_n = new SimpleBooleanProperty(false);
        }
        return mzxg_n;
    }
    public void setMzxg_n(boolean mzxg_n) {
        this.mzxg_n.set(mzxg_n);
    }
    public boolean isMzxiaog_ws1() {
        return mzxiaog_ws1.get();
    }
    public BooleanProperty mzxiaog_ws1Property() {
        if(mzxiaog_ws1==null){
            mzxiaog_ws1 = new SimpleBooleanProperty(false);
        }
        return mzxiaog_ws1;
    }
    public void setMzxiaog_ws1(boolean mzxiaog_ws1) {
        this.mzxiaog_ws1.set(mzxiaog_ws1);
    }
    public boolean isMzxiaog_nws1() {
        return mzxiaog_nws1.get();
    }
    public BooleanProperty mzxiaog_nws1Property() {
        if(mzxiaog_nws1==null){
            mzxiaog_nws1 = new SimpleBooleanProperty(false);
        }
        return mzxiaog_nws1;
    }
    public void setMzxiaog_nws1(boolean mzxiaog_nws1) {
        this.mzxiaog_nws1.set(mzxiaog_nws1);
    }
    public boolean isMzxiaog_n1() {
        return mzxiaog_n1.get();
    }
    public BooleanProperty mzxiaog_n1Property() {
        if(mzxiaog_n1==null){
            mzxiaog_n1 = new SimpleBooleanProperty(false);
        }
        return mzxiaog_n1;
    }
    public void setMzxiaog_n1(boolean mzxiaog_n1) {
        this.mzxiaog_n1.set(mzxiaog_n1);
    }
    public boolean isZt_y1() {
        return zt_y1.get();
    }
    public BooleanProperty zt_y1Property() {
        if(zt_y1==null){
            zt_y1 = new SimpleBooleanProperty(false);
        }
        return zt_y1;
    }
    public void setZt_y1(boolean zt_y1) {
        this.zt_y1.set(zt_y1);
    }
    public boolean isZt_n1() {
        return zt_n1.get();
    }
    public BooleanProperty zt_n1Property() {
        if(zt_n1==null){
            zt_n1 = new SimpleBooleanProperty(false);
        }
        return zt_n1;
    }
    public void setZt_n1(boolean zt_n1) {
        this.zt_n1.set(zt_n1);
    }
    public boolean isZtqm_y1() {
        return ztqm_y1.get();
    }
    public BooleanProperty ztqm_y1Property() {
        if(ztqm_y1==null){
            ztqm_y1 = new SimpleBooleanProperty(false);
        }
        return ztqm_y1;
    }
    public void setZtqm_y1(boolean ztqm_y1) {
        this.ztqm_y1.set(ztqm_y1);
    }
    public boolean isZtqm_n1() {
        return ztqm_n1.get();
    }
    public BooleanProperty ztqm_n1Property() {
        if(ztqm_n1==null){
            ztqm_n1 = new SimpleBooleanProperty(false);
        }
        return ztqm_n1;
    }
    public void setZtqm_n1(boolean ztqm_n1) {
        this.ztqm_n1.set(ztqm_n1);
    }
    public boolean isShjzz_y() {
        return shjzz_y.get();
    }
    public BooleanProperty shjzz_yProperty() {
        if(shjzz_y==null){
            shjzz_y = new SimpleBooleanProperty(false);
        }
        return shjzz_y;
    }
    public void setShjzz_y(boolean shjzz_y) {
        this.shjzz_y.set(shjzz_y);
    }
    public boolean isShjzz_n() {
        return shjzz_n.get();
    }
    public BooleanProperty shjzz_nProperty() {
        if(shjzz_n==null){
            shjzz_n = new SimpleBooleanProperty(false);
        }
        return shjzz_n;
    }
    public void setShjzz_n(boolean shjzz_n) {
        this.shjzz_n.set(shjzz_n);
    }
    public boolean isJbmz_y() {
        return jbmz_y.get();
    }
    public BooleanProperty jbmz_yProperty() {
        if(jbmz_y==null){
            jbmz_y = new SimpleBooleanProperty(false);
        }
        return jbmz_y;
    }
    public void setJbmz_y(boolean jbmz_y) {
        this.jbmz_y.set(jbmz_y);
    }
    public boolean isJbmz_n() {
        return jbmz_n.get();
    }
    public BooleanProperty jbmz_nProperty() {
        if(jbmz_n==null){
            jbmz_n = new SimpleBooleanProperty(false);
        }
        return jbmz_n;
    }
    public void setJbmz_n(boolean jbmz_n) {
        this.jbmz_n.set(jbmz_n);
    }
    public boolean isZuzhiss_y() {
        return zuzhiss_y.get();
    }
    public BooleanProperty zuzhiss_yProperty() {
        if(zuzhiss_y==null){
            zuzhiss_y = new SimpleBooleanProperty(false);
        }
        return zuzhiss_y;
    }
    public void setZuzhiss_y(boolean zuzhiss_y) {
        this.zuzhiss_y.set(zuzhiss_y);
    }
    public boolean isZuzhiss_n() {
        return zuzhiss_n.get();
    }
    public BooleanProperty zuzhiss_nProperty() {
        if(zuzhiss_n==null){
            zuzhiss_n = new SimpleBooleanProperty(false);
        }
        return zuzhiss_n;
    }
    public void setZuzhiss_n(boolean zuzhiss_n) {
        this.zuzhiss_n.set(zuzhiss_n);
    }
    public boolean isMzxiaog_ws() {
        return mzxiaog_ws.get();
    }
    public BooleanProperty mzxiaog_wsProperty() {
        if(mzxiaog_ws==null){
            mzxiaog_ws = new SimpleBooleanProperty(false);
        }
        return mzxiaog_ws;
    }
    public void setMzxiaog_ws(boolean mzxiaog_ws) {
        this.mzxiaog_ws.set(mzxiaog_ws);
    }
    public boolean isMzxiaog_nws() {
        return mzxiaog_nws.get();
    }
    public BooleanProperty mzxiaog_nwsProperty() {
        if(mzxiaog_nws==null){
            mzxiaog_nws = new SimpleBooleanProperty(false);
        }
        return mzxiaog_nws;
    }
    public void setMzxiaog_nws(boolean mzxiaog_nws) {
        this.mzxiaog_nws.set(mzxiaog_nws);
    }
    public boolean isMzxiaog_n() {
        return mzxiaog_n.get();
    }
    public BooleanProperty mzxiaog_nProperty() {
        if(mzxiaog_n==null){
            mzxiaog_n = new SimpleBooleanProperty(false);
        }
        return mzxiaog_n;
    }
    public void setMzxiaog_n(boolean mzxiaog_n) {
        this.mzxiaog_n.set(mzxiaog_n);
    }
    public boolean isZt_y() {
        return zt_y.get();
    }
    public BooleanProperty zt_yProperty() {
        if(zt_y==null){
            zt_y = new SimpleBooleanProperty(false);
        }
        return zt_y;
    }
    public void setZt_y(boolean zt_y) {
        this.zt_y.set(zt_y);
    }
    public boolean isZt_n() {
        return zt_n.get();
    }
    public BooleanProperty zt_nProperty() {
        if(zt_n==null){
            zt_n = new SimpleBooleanProperty(false);
        }
        return zt_n;
    }
    public void setZt_n(boolean zt_n) {
        this.zt_n.set(zt_n);
    }
    public boolean isZtqm_y() {
        return ztqm_y.get();
    }
    public BooleanProperty ztqm_yProperty() {
        if(ztqm_y==null){
            ztqm_y = new SimpleBooleanProperty(false);
        }
        return ztqm_y;
    }
    public void setZtqm_y(boolean ztqm_y) {
        this.ztqm_y.set(ztqm_y);
    }
    public boolean isZtqm_n() {
        return ztqm_n.get();
    }
    public BooleanProperty ztqm_nProperty() {
        if(ztqm_n==null){
            ztqm_n = new SimpleBooleanProperty(false);
        }
        return ztqm_n;
    }
    public void setZtqm_n(boolean ztqm_n) {
        this.ztqm_n.set(ztqm_n);
    }
    public boolean isJm_y() {
        return jm_y.get();
    }
    public BooleanProperty jm_yProperty() {
        if(jm_y==null){
            jm_y = new SimpleBooleanProperty(false);
        }
        return jm_y;
    }
    public void setJm_y(boolean jm_y) {
        this.jm_y.set(jm_y);
    }
    public boolean isJm_n() {
        return jm_n.get();
    }
    public BooleanProperty jm_nProperty() {
        if(jm_n==null){
            jm_n = new SimpleBooleanProperty(false);
        }
        return jm_n;
    }
    public void setJm_n(boolean jm_n) {
        this.jm_n.set(jm_n);
    }
    public boolean isZrsl_y() {
        return zrsl_y.get();
    }
    public BooleanProperty zrsl_yProperty() {
        if(zrsl_y==null){
            zrsl_y = new SimpleBooleanProperty(false);
        }
        return zrsl_y;
    }
    public void setZrsl_y(boolean zrsl_y) {
        this.zrsl_y.set(zrsl_y);
    }
    public boolean isZrsl_n() {
        return zrsl_n.get();
    }
    public BooleanProperty zrsl_nProperty() {
        if(zrsl_n==null){
            zrsl_n = new SimpleBooleanProperty(false);
        }
        return zrsl_n;
    }
    public void setZrsl_n(boolean zrsl_n) {
        this.zrsl_n.set(zrsl_n);
    }
    public boolean isHxtc_y() {
        return hxtc_y.get();
    }
    public BooleanProperty hxtc_yProperty() {
        if(hxtc_y==null){
            hxtc_y = new SimpleBooleanProperty(false);
        }
        return hxtc_y;
    }
    public void setHxtc_y(boolean hxtc_y) {
        this.hxtc_y.set(hxtc_y);
    }
    public boolean isHxtc_n() {
        return hxtc_n.get();
    }
    public BooleanProperty hxtc_nProperty() {
        if(hxtc_n==null){
            hxtc_n = new SimpleBooleanProperty(false);
        }
        return hxtc_n;
    }
    public void setHxtc_n(boolean hxtc_n) {
        this.hxtc_n.set(hxtc_n);
    }
    public boolean isWcdm_y() {
        return wcdm_y.get();
    }
    public BooleanProperty wcdm_yProperty() {
        if(wcdm_y==null){
            wcdm_y = new SimpleBooleanProperty(false);
        }
        return wcdm_y;
    }
    public void setWcdm_y(boolean wcdm_y) {
        this.wcdm_y.set(wcdm_y);
    }
    public boolean isWcdm_n() {
        return wcdm_n.get();
    }
    public BooleanProperty wcdm_nProperty() {
        if(wcdm_n==null){
            wcdm_n = new SimpleBooleanProperty(false);
        }
        return wcdm_n;
    }
    public void setWcdm_n(boolean wcdm_n) {
        this.wcdm_n.set(wcdm_n);
    }
    public boolean isBrbs_y() {
        return brbs_y.get();
    }
    public BooleanProperty brbs_yProperty() {
        if(brbs_y==null){
            brbs_y = new SimpleBooleanProperty(false);
        }
        return brbs_y;
    }
    public void setBrbs_y(boolean brbs_y) {
        this.brbs_y.set(brbs_y);
    }
    public boolean isSbrbs_n() {
        return sbrbs_n.get();
    }
    public BooleanProperty sbrbs_nProperty() {
        if(sbrbs_n==null){
            sbrbs_n = new SimpleBooleanProperty(false);
        }
        return sbrbs_n;
    }
    public void setSbrbs_n(boolean sbrbs_n) {
        this.sbrbs_n.set(sbrbs_n);
    }
    public boolean isDmci_y() {
        return dmci_y.get();
    }
    public BooleanProperty dmci_yProperty() {
        if(dmci_y==null){
            dmci_y = new SimpleBooleanProperty(false);
        }
        return dmci_y;
    }
    public void setDmci_y(boolean dmci_y) {
        this.dmci_y.set(dmci_y);
    }
    public boolean isDmci_n() {
        return dmci_n.get();
    }
    public BooleanProperty dmci_nProperty() {
        if(dmci_n==null){
            dmci_n = new SimpleBooleanProperty(false);
        }
        return dmci_n;
    }
    public void setDmci_n(boolean dmci_n) {
        this.dmci_n.set(dmci_n);
    }
    public boolean isSl_y() {
        return sl_y.get();
    }
    public BooleanProperty sl_yProperty() {
        if(sl_y==null){
            sl_y = new SimpleBooleanProperty(false);
        }
        return sl_y;
    }
    public void setSl_y(boolean sl_y) {
        this.sl_y.set(sl_y);
    }
    public boolean isSl_n() {
        return sl_n.get();
    }
    public BooleanProperty sl_nProperty() {
        if(sl_n==null){
            sl_n = new SimpleBooleanProperty(false);
        }
        return sl_n;
    }
    public void setSl_n(boolean sl_n) {
        this.sl_n.set(sl_n);
    }
    public boolean isSmtz_y() {
        return smtz_y.get();
    }
    public BooleanProperty smtz_yProperty() {
        if(smtz_y==null){
            smtz_y = new SimpleBooleanProperty(false);
        }
        return smtz_y;
    }
    public void setSmtz_y(boolean smtz_y) {
        this.smtz_y.set(smtz_y);
    }
    public boolean isSmtz_n() {
        return smtz_n.get();
    }
    public BooleanProperty smtz_nProperty() {
        if(smtz_n==null){
            smtz_n = new SimpleBooleanProperty(false);
        }
        return smtz_n;
    }
    public void setSmtz_n(boolean smtz_n) {
        this.smtz_n.set(smtz_n);
    }
    public boolean isXy_y() {
        return xy_y.get();
    }
    public BooleanProperty xy_yProperty() {
        if(xy_y==null){
            xy_y = new SimpleBooleanProperty(false);
        }
        return xy_y;
    }
    public void setXy_y(boolean xy_y) {
        this.xy_y.set(xy_y);
    }
    public boolean isXy_n() {
        return xy_n.get();
    }
    public BooleanProperty xy_nProperty() {
        if(xy_n==null){
            xy_n = new SimpleBooleanProperty(false);
        }
        return xy_n;
    }
    public void setXy_n(boolean xy_n) {
        this.xy_n.set(xy_n);
    }
    public boolean isDyz_y() {
        return dyz_y.get();
    }
    public BooleanProperty dyz_yProperty() {
        if(dyz_y==null){
            dyz_y = new SimpleBooleanProperty(false);
        }
        return dyz_y;
    }
    public void setDyz_y(boolean dyz_y) {
        this.dyz_y.set(dyz_y);
    }
    public boolean isDyz_n() {
        return dyz_n.get();
    }
    public BooleanProperty dyz_nProperty() {
        if(dyz_n==null){
            dyz_n = new SimpleBooleanProperty(false);
        }
        return dyz_n;
    }
    public void setDyz_n(boolean dyz_n) {
        this.dyz_n.set(dyz_n);
    }
    public boolean isGtsxz_y() {
        return gtsxz_y.get();
    }
    public BooleanProperty gtsxz_yProperty() {
        if(gtsxz_y==null){
            gtsxz_y = new SimpleBooleanProperty(false);
        }
        return gtsxz_y;
    }
    public void setGtsxz_y(boolean gtsxz_y) {
        this.gtsxz_y.set(gtsxz_y);
    }
    public boolean isGtsxz_n() {
        return gtsxz_n.get();
    }
    public BooleanProperty gtsxz_nProperty() {
        if(gtsxz_n==null){
            gtsxz_n = new SimpleBooleanProperty(false);
        }
        return gtsxz_n;
    }
    public void setGtsxz_n(boolean gtsxz_n) {
        this.gtsxz_n.set(gtsxz_n);
    }
    public boolean isSzzd_y() {
        return szzd_y.get();
    }
    public BooleanProperty szzd_yProperty() {
        if(szzd_y==null){
            szzd_y = new SimpleBooleanProperty(false);
        }
        return szzd_y;
    }
    public void setSzzd_y(boolean szzd_y) {
        this.szzd_y.set(szzd_y);
    }
    public boolean isSzzd_n() {
        return szzd_n.get();
    }
    public BooleanProperty szzd_nProperty() {
        if(szzd_n==null){
            szzd_n = new SimpleBooleanProperty(false);
        }
        return szzd_n;
    }
    public void setSzzd_n(boolean szzd_n) {
        this.szzd_n.set(szzd_n);
    }
    public boolean isSzcx_y() {
        return szcx_y.get();
    }
    public BooleanProperty szcx_yProperty() {
        if(szcx_y==null){
            szcx_y = new SimpleBooleanProperty(false);
        }
        return szcx_y;
    }
    public void setSzcx_y(boolean szcx_y) {
        this.szcx_y.set(szcx_y);
    }
    public boolean isSzcx_n() {
        return szcx_n.get();
    }
    public BooleanProperty szcx_nProperty() {
        if(szcx_n==null){
            szcx_n = new SimpleBooleanProperty(false);
        }
        return szcx_n;
    }
    public void setSzcx_n(boolean szcx_n) {
        this.szcx_n.set(szcx_n);
    }
    public boolean isYwgm_y() {
        return ywgm_y.get();
    }
    public BooleanProperty ywgm_yProperty() {
        if(ywgm_y==null){
            ywgm_y = new SimpleBooleanProperty(false);
        }
        return ywgm_y;
    }
    public void setYwgm_y(boolean ywgm_y) {
        this.ywgm_y.set(ywgm_y);
    }
    public boolean isYwgm_n() {
        return ywgm_n.get();
    }
    public BooleanProperty ywgm_nProperty() {
        if(ywgm_n==null){
            ywgm_n = new SimpleBooleanProperty(false);
        }
        return ywgm_n;
    }
    public void setYwgm_n(boolean ywgm_n) {
        this.ywgm_n.set(ywgm_n);
    }
    public boolean isQk_y() {
        return qk_y.get();
    }
    public BooleanProperty qk_yProperty() {
        if(qk_y==null){
            qk_y = new SimpleBooleanProperty(false);
        }
        return qk_y;
    }
    public void setQk_y(boolean qk_y) {
        this.qk_y.set(qk_y);
    }
    public boolean isQk_n() {
        return qk_n.get();
    }
    public BooleanProperty qk_nProperty() {
        if(qk_n==null){
            qk_n = new SimpleBooleanProperty(false);
        }
        return qk_n;
    }
    public void setQk_n(boolean qk_n) {
        this.qk_n.set(qk_n);
    }
    public boolean isQk_szbf() {
        return qk_szbf.get();
    }
    public BooleanProperty qk_szbfProperty() {
        if(qk_szbf==null){
            qk_szbf = new SimpleBooleanProperty(false);
        }
        return qk_szbf;
    }
    public void setQk_szbf(boolean qk_szbf) {
        this.qk_szbf.set(qk_szbf);
    }
    public boolean isQk_pacu() {
        return qk_pacu.get();
    }
    public BooleanProperty qk_pacuProperty() {
        if(qk_pacu==null){
            qk_pacu = new SimpleBooleanProperty(false);
        }
        return qk_pacu;
    }
    public void setQk_pacu(boolean qk_pacu) {
        this.qk_pacu.set(qk_pacu);
    }
    public boolean isQk_icu() {
        return qk_icu.get();
    }
    public BooleanProperty qk_icuProperty() {
        if(qk_icu==null){
            qk_icu = new SimpleBooleanProperty(false);
        }
        return qk_icu;
    }
    public void setQk_icu(boolean qk_icu) {
        this.qk_icu.set(qk_icu);
    }
    public boolean isSp_xy() {
        return sp_xy.get();
    }
    public BooleanProperty sp_xyProperty() {
        if(sp_xy==null){
            sp_xy = new SimpleBooleanProperty(false);
        }
        return sp_xy;
    }
    public void setSp_xy(boolean sp_xy) {
        this.sp_xy.set(sp_xy);
    }
    public boolean isSp_kq() {
        return sp_kq.get();
    }
    public BooleanProperty sp_kqProperty() {
        if(sp_kq==null){
            sp_kq = new SimpleBooleanProperty(false);
        }
        return sp_kq;
    }
    public void setSp_kq(boolean sp_kq) {
        this.sp_kq.set(sp_kq);
    }
    public boolean isQx_y() {
        return qx_y.get();
    }
    public BooleanProperty qx_yProperty() {
        if(qx_y==null){
            qx_y = new SimpleBooleanProperty(false);
        }
        return qx_y;
    }
    public void setQx_y(boolean qx_y) {
        this.qx_y.set(qx_y);
    }
    public boolean isQx_n() {
        return qx_n.get();
    }
    public BooleanProperty qx_nProperty() {
        if(qx_n==null){
            qx_n = new SimpleBooleanProperty(false);
        }
        return qx_n;
    }
    public void setQx_n(boolean qx_n) {
        this.qx_n.set(qx_n);
    }
    public boolean isJl_y() {
        return jl_y.get();
    }
    public BooleanProperty jl_yProperty() {
        if(jl_y==null){
            jl_y = new SimpleBooleanProperty(false);
        }
        return jl_y;
    }
    public void setJl_y(boolean jl_y) {
        this.jl_y.set(jl_y);
    }
    public boolean isJl_n() {
        return jl_n.get();
    }
    public BooleanProperty jl_nProperty() {
        if(jl_n==null){
            jl_n = new SimpleBooleanProperty(false);
        }
        return jl_n;
    }
    public void setJl_n(boolean jl_n) {
        this.jl_n.set(jl_n);
    }
    public boolean isSmtzpw_y() {
        return smtzpw_y.get();
    }
    public BooleanProperty smtzpw_yProperty() {
        if(smtzpw_y==null){
            smtzpw_y = new SimpleBooleanProperty(false);
        }
        return smtzpw_y;
    }
    public void setSmtzpw_y(boolean smtzpw_y) {
        this.smtzpw_y.set(smtzpw_y);
    }
    public boolean isSmtzpw_n() {
        return smtzpw_n.get();
    }
    public BooleanProperty smtzpw_nProperty() {
        if(smtzpw_n==null){
            smtzpw_n = new SimpleBooleanProperty(false);
        }
        return smtzpw_n;
    }
    public void setSmtzpw_n(boolean smtzpw_n) {
        this.smtzpw_n.set(smtzpw_n);
    }
    public boolean isSz_qx() {
        return sz_qx.get();
    }
    public BooleanProperty sz_qxProperty() {
        if(sz_qx==null){
            sz_qx = new SimpleBooleanProperty(false);
        }
        return sz_qx;
    }
    public void setSz_qx(boolean sz_qx) {
        this.sz_qx.set(sz_qx);
    }
    public boolean isSz_ss() {
        return sz_ss.get();
    }
    public BooleanProperty sz_ssProperty() {
        if(sz_ss==null){
            sz_ss = new SimpleBooleanProperty(false);
        }
        return sz_ss;
    }
    public void setSz_ss(boolean sz_ss) {
        this.sz_ss.set(sz_ss);
    }
    public boolean isSz_hm() {
        return sz_hm.get();
    }
    public BooleanProperty sz_hmProperty() {
        if(sz_hm==null){
            sz_hm = new SimpleBooleanProperty(false);
        }
        return sz_hm;
    }
    public void setSz_hm(boolean sz_hm) {
        this.sz_hm.set(sz_hm);
    }
    public boolean isSz_mh() {
        return sz_mh.get();
    }
    public BooleanProperty sz_mhProperty() {
        if(sz_mh==null){
            sz_mh = new SimpleBooleanProperty(false);
        }
        return sz_mh;
    }
    public void setSz_mh(boolean sz_mh) {
        this.sz_mh.set(sz_mh);
    }
    public boolean isPca_my() {
        return pca_my.get();
    }
    public BooleanProperty pca_myProperty() {
        if(pca_my==null){
            pca_my = new SimpleBooleanProperty(false);
        }
        return pca_my;
    }
    public void setPca_my(boolean pca_my) {
        this.pca_my.set(pca_my);
    }
    public boolean isPca_bmy() {
        return pca_bmy.get();
    }
    public BooleanProperty pca_bmyProperty() {
        if(pca_bmy==null){
            pca_bmy = new SimpleBooleanProperty(false);
        }
        return pca_bmy;
    }
    public void setPca_bmy(boolean pca_bmy) {
        this.pca_bmy.set(pca_bmy);
    }
    public boolean isXfjc_y() {
        return xfjc_y.get();
    }
    public BooleanProperty xfjc_yProperty() {
        if(xfjc_y==null){
            xfjc_y = new SimpleBooleanProperty(false);
        }
        return xfjc_y;
    }
    public void setXfjc_y(boolean xfjc_y) {
        this.xfjc_y.set(xfjc_y);
    }
    public boolean isXfjc_n() {
        return xfjc_n.get();
    }
    public BooleanProperty xfjc_nProperty() {
        if(xfjc_n==null){
            xfjc_n = new SimpleBooleanProperty(false);
        }
        return xfjc_n;
    }
    public void setXfjc_n(boolean xfjc_n) {
        this.xfjc_n.set(xfjc_n);
    }
    public boolean isHxxt_y() {
        return hxxt_y.get();
    }
    public BooleanProperty hxxt_yProperty() {
        if(hxxt_y==null){
            hxxt_y = new SimpleBooleanProperty(false);
        }
        return hxxt_y;
    }
    public void setHxxt_y(boolean hxxt_y) {
        this.hxxt_y.set(hxxt_y);
    }
    public boolean isHxxt_n() {
        return hxxt_n.get();
    }
    public BooleanProperty hxxt_nProperty() {
        if(hxxt_n==null){
            hxxt_n = new SimpleBooleanProperty(false);
        }
        return hxxt_n;
    }
    public void setHxxt_n(boolean hxxt_n) {
        this.hxxt_n.set(hxxt_n);
    }
    public boolean isFbgr_y() {
        return fbgr_y.get();
    }
    public BooleanProperty fbgr_yProperty() {
        if(fbgr_y==null){
            fbgr_y = new SimpleBooleanProperty(false);
        }
        return fbgr_y;
    }
    public void setFbgr_y(boolean fbgr_y) {
        this.fbgr_y.set(fbgr_y);
    }
    public boolean isFbgr_n() {
        return fbgr_n.get();
    }
    public BooleanProperty fbgr_nProperty() {
        if(fbgr_n==null){
            fbgr_n = new SimpleBooleanProperty(false);
        }
        return fbgr_n;
    }
    public void setFbgr_n(boolean fbgr_n) {
        this.fbgr_n.set(fbgr_n);
    }
    public boolean isHxkn_y() {
        return hxkn_y.get();
    }
    public BooleanProperty hxkn_yProperty() {
        if(hxkn_y==null){
            hxkn_y = new SimpleBooleanProperty(false);
        }
        return hxkn_y;
    }
    public void setHxkn_y(boolean hxkn_y) {
        this.hxkn_y.set(hxkn_y);
    }
    public boolean isHxkn_n() {
        return hxkn_n.get();
    }
    public BooleanProperty hxkn_nProperty() {
        if(hxkn_n==null){
            hxkn_n = new SimpleBooleanProperty(false);
        }
        return hxkn_n;
    }
    public void setHxkn_n(boolean hxkn_n) {
        this.hxkn_n.set(hxkn_n);
    }
    public boolean isDyxz_y() {
        return dyxz_y.get();
    }
    public BooleanProperty dyxz_yProperty() {
        if(dyxz_y==null){
            dyxz_y = new SimpleBooleanProperty(false);
        }
        return dyxz_y;
    }
    public void setDyxz_y(boolean dyxz_y) {
        this.dyxz_y.set(dyxz_y);
    }
    public boolean isDyxz_n() {
        return dyxz_n.get();
    }
    public BooleanProperty dyxz_nProperty() {
        if(dyxz_n==null){
            dyxz_n = new SimpleBooleanProperty(false);
        }
        return dyxz_n;
    }
    public void setDyxz_n(boolean dyxz_n) {
        this.dyxz_n.set(dyxz_n);
    }
    public boolean isHxsj_y() {
        return hxsj_y.get();
    }
    public BooleanProperty hxsj_yProperty() {
        if(hxsj_y==null){
            hxsj_y = new SimpleBooleanProperty(false);
        }
        return hxsj_y;
    }
    public void setHxsj_y(boolean hxsj_y) {
        this.hxsj_y.set(hxsj_y);
    }
    public boolean isHxsj_n() {
        return hxsj_n.get();
    }
    public BooleanProperty hxsj_nProperty() {
        if(hxsj_n==null){
            hxsj_n = new SimpleBooleanProperty(false);
        }
        return hxsj_n;
    }
    public void setHxsj_n(boolean hxsj_n) {
        this.hxsj_n.set(hxsj_n);
    }
    public boolean isGxy_y() {
        return gxy_y.get();
    }
    public BooleanProperty gxy_yProperty() {
        if(gxy_y==null){
            gxy_y = new SimpleBooleanProperty(false);
        }
        return gxy_y;
    }
    public void setGxy_y(boolean gxy_y) {
        this.gxy_y.set(gxy_y);
    }
    public boolean isGxy_n() {
        return gxy_n.get();
    }
    public BooleanProperty gxy_nProperty() {
        if(gxy_n==null){
            gxy_n = new SimpleBooleanProperty(false);
        }
        return gxy_n;
    }
    public void setGxy_n(boolean gxy_n) {
        this.gxy_n.set(gxy_n);
    }
    public boolean isYzxl_y() {
        return yzxl_y.get();
    }
    public BooleanProperty yzxl_yProperty() {
        if(yzxl_y==null){
            yzxl_y = new SimpleBooleanProperty(false);
        }
        return yzxl_y;
    }
    public void setYzxl_y(boolean yzxl_y) {
        this.yzxl_y.set(yzxl_y);
    }
    public boolean isYzxl_n() {
        return yzxl_n.get();
    }
    public BooleanProperty yzxl_nProperty() {
        if(yzxl_n==null){
            yzxl_n = new SimpleBooleanProperty(false);
        }
        return yzxl_n;
    }
    public void setYzxl_n(boolean yzxl_n) {
        this.yzxl_n.set(yzxl_n);
    }
    public boolean isXjt_y() {
        return xjt_y.get();
    }
    public BooleanProperty xjt_yProperty() {
        if(xjt_y==null){
            xjt_y = new SimpleBooleanProperty(false);
        }
        return xjt_y;
    }
    public void setXjt_y(boolean xjt_y) {
        this.xjt_y.set(xjt_y);
    }
    public boolean isXjt_n() {
        return xjt_n.get();
    }
    public BooleanProperty xjt_nProperty() {
        if(xjt_n==null){
            xjt_n = new SimpleBooleanProperty(false);
        }
        return xjt_n;
    }
    public void setXjt_n(boolean xjt_n) {
        this.xjt_n.set(xjt_n);
    }
    public boolean isXlsj_y() {
        return xlsj_y.get();
    }
    public BooleanProperty xlsj_yProperty() {
        if(xlsj_y==null){
            xlsj_y = new SimpleBooleanProperty(false);
        }
        return xlsj_y;
    }
    public void setXlsj_y(boolean xlsj_y) {
        this.xlsj_y.set(xlsj_y);
    }
    public boolean isXlsj_n() {
        return xlsj_n.get();
    }
    public BooleanProperty xlsj_nProperty() {
        if(xlsj_n==null){
            xlsj_n = new SimpleBooleanProperty(false);
        }
        return xlsj_n;
    }
    public void setXlsj_n(boolean xlsj_n) {
        this.xlsj_n.set(xlsj_n);
    }
    public boolean isRzgn_y() {
        return rzgn_y.get();
    }
    public BooleanProperty rzgn_yProperty() {
        if(rzgn_y==null){
            rzgn_y = new SimpleBooleanProperty(false);
        }
        return rzgn_y;
    }
    public void setRzgn_y(boolean rzgn_y) {
        this.rzgn_y.set(rzgn_y);
    }
    public boolean isRzgn_n() {
        return rzgn_n.get();
    }
    public BooleanProperty rzgn_nProperty() {
        if(rzgn_n==null){
            rzgn_n = new SimpleBooleanProperty(false);
        }
        return rzgn_n;
    }
    public void setRzgn_n(boolean rzgn_n) {
        this.rzgn_n.set(rzgn_n);
    }
    public boolean isSzzx_y() {
        return szzx_y.get();
    }
    public BooleanProperty szzx_yProperty() {
        if(szzx_y==null){
            szzx_y = new SimpleBooleanProperty(false);
        }
        return szzx_y;
    }
    public void setSzzx_y(boolean szzx_y) {
        this.szzx_y.set(szzx_y);
    }
    public boolean isSzzx_n() {
        return szzx_n.get();
    }
    public BooleanProperty szzx_nProperty() {
        if(szzx_n==null){
            szzx_n = new SimpleBooleanProperty(false);
        }
        return szzx_n;
    }
    public void setSzzx_n(boolean szzx_n) {
        this.szzx_n.set(szzx_n);
    }
    public boolean isZtgj_y() {
        return ztgj_y.get();
    }
    public BooleanProperty ztgj_yProperty() {
        if(ztgj_y==null){
            ztgj_y = new SimpleBooleanProperty(false);
        }
        return ztgj_y;
    }
    public void setZtgj_y(boolean ztgj_y) {
        this.ztgj_y.set(ztgj_y);
    }
    public boolean isZtgj_n() {
        return ztgj_n.get();
    }
    public BooleanProperty ztgj_nProperty() {
        if(ztgj_n==null){
            ztgj_n = new SimpleBooleanProperty(false);
        }
        return ztgj_n;
    }
    public void setZtgj_n(boolean ztgj_n) {
        this.ztgj_n.set(ztgj_n);
    }
    public boolean isJz_y() {
        return jz_y.get();
    }
    public BooleanProperty jz_yProperty() {
        if(jz_y==null){
            jz_y = new SimpleBooleanProperty(false);
        }
        return jz_y;
    }
    public void setJz_y(boolean jz_y) {
        this.jz_y.set(jz_y);
    }
    public boolean isJz_n() {
        return jz_n.get();
    }
    public BooleanProperty jz_nProperty() {
        if(jz_n==null){
            jz_n = new SimpleBooleanProperty(false);
        }
        return jz_n;
    }
    public void setJz_n(boolean jz_n) {
        this.jz_n.set(jz_n);
    }
    public boolean isExot_y() {
        return exot_y.get();
    }
    public BooleanProperty exot_yProperty() {
        if(exot_y==null){
            exot_y = new SimpleBooleanProperty(false);
        }
        return exot_y;
    }
    public void setExot_y(boolean exot_y) {
        this.exot_y.set(exot_y);
    }
    public boolean isExot_n() {
        return exot_n.get();
    }
    public BooleanProperty exot_nProperty() {
        if(exot_n==null){
            exot_n = new SimpleBooleanProperty(false);
        }
        return exot_n;
    }
    public void setExot_n(boolean exot_n) {
        this.exot_n.set(exot_n);
    }
    public boolean isNzl_y() {
        return nzl_y.get();
    }
    public BooleanProperty nzl_yProperty() {
        if(nzl_y==null){
            nzl_y = new SimpleBooleanProperty(false);
        }
        return nzl_y;
    }
    public void setNzl_y(boolean nzl_y) {
        this.nzl_y.set(nzl_y);
    }
    public boolean isNzl_n() {
        return nzl_n.get();
    }
    public BooleanProperty nzl_nProperty() {
        if(nzl_n==null){
            nzl_n = new SimpleBooleanProperty(false);
        }
        return nzl_n;
    }
    public void setNzl_n(boolean nzl_n) {
        this.nzl_n.set(nzl_n);
    }
    public boolean isMzmy_y() {
        return mzmy_y.get();
    }
    public BooleanProperty mzmy_yProperty() {
        if(mzmy_y==null){
            mzmy_y = new SimpleBooleanProperty(false);
        }
        return mzmy_y;
    }
    public void setMzmy_y(boolean mzmy_y) {
        this.mzmy_y.set(mzmy_y);
    }
    public boolean isMzmy_n() {
        return mzmy_n.get();
    }
    public BooleanProperty mzmy_nProperty() {
        if(mzmy_n==null){
            mzmy_n = new SimpleBooleanProperty(false);
        }
        return mzmy_n;
    }
    public void setMzmy_n(boolean mzmy_n) {
        this.mzmy_n.set(mzmy_n);
    }
    public boolean isBfz_y() {
        return bfz_y.get();
    }
    public BooleanProperty bfz_yProperty() {
        if(bfz_y==null){
            bfz_y = new SimpleBooleanProperty(false);
        }
        return bfz_y;
    }
    public void setBfz_y(boolean bfz_y) {
        this.bfz_y.set(bfz_y);
    }
    public boolean isBfz_n() {
        return bfz_n.get();
    }
    public BooleanProperty bfz_nProperty() {
        if(bfz_n==null){
            bfz_n = new SimpleBooleanProperty(false);
        }
        return bfz_n;
    }
    public void setBfz_n(boolean bfz_n) {
        this.bfz_n.set(bfz_n);
    }
    public boolean isYj_y() {
        return yj_y.get();
    }
    public BooleanProperty yj_yProperty() {
        if(yj_y==null){
            yj_y = new SimpleBooleanProperty(false);
        }
        return yj_y;
    }
    public void setYj_y(boolean yj_y) {
        this.yj_y.set(yj_y);
    }
    public boolean isYj_n() {
        return yj_n.get();
    }
    public BooleanProperty yj_nProperty() {
        if(yj_n==null){
            yj_n = new SimpleBooleanProperty(false);
        }
        return yj_n;
    }
    public void setYj_n(boolean yj_n) {
        this.yj_n.set(yj_n);
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
    public String getSg() {
        return sg.get();
    }
    public StringProperty sgProperty() {
        if(sg==null){
            sg = new SimpleStringProperty();
        }
        return sg;
    }
    public void setSg(String sg) {
        this.sg.set(sg);
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
    public String getZzhipm() {
        return zzhipm.get();
    }
    public StringProperty zzhipmProperty() {
        if(zzhipm==null){
            zzhipm = new SimpleStringProperty();
        }
        return zzhipm;
    }
    public void setZzhipm(String zzhipm) {
        this.zzhipm.set(zzhipm);
    }
    public String getSbzzhipm() {
        return sbzzhipm.get();
    }
    public StringProperty sbzzhipmProperty() {
        if(sbzzhipm==null){
            sbzzhipm = new SimpleStringProperty();
        }
        return sbzzhipm;
    }
    public void setSbzzhipm(String sbzzhipm) {
        this.sbzzhipm.set(sbzzhipm);
    }
    public String getJmText() {
        return jmText.get();
    }
    public StringProperty jmTextProperty() {
        if(jmText==null){
            jmText = new SimpleStringProperty();
        }
        return jmText;
    }
    public void setJmText(String jmText) {
        this.jmText.set(jmText);
    }
    public String getJzText() {
        return jzText.get();
    }
    public StringProperty jzTextProperty() {
        if(jzText==null){
            jzText = new SimpleStringProperty();
        }
        return jzText;
    }
    public void setJzText(String jzText) {
        this.jzText.set(jzText);
    }
    public String getZrText() {
        return zrText.get();
    }
    public StringProperty zrTextProperty() {
        if(zrText==null){
            zrText = new SimpleStringProperty();
        }
        return zrText;
    }
    public void setZrText(String zrText) {
        this.zrText.set(zrText);
    }
    public String getDgText() {
        return dgText.get();
    }
    public StringProperty dgTextProperty() {
        if(dgText==null){
            dgText = new SimpleStringProperty();
        }
        return dgText;
    }
    public void setDgText(String dgText) {
        this.dgText.set(dgText);
    }
    public String getDmciText() {
        return dmciText.get();
    }
    public StringProperty dmciTextProperty() {
        if(dmciText==null){
            dmciText = new SimpleStringProperty();
        }
        return dmciText;
    }
    public void setDmciText(String dmciText) {
        this.dmciText.set(dmciText);
    }
    public String getYwxzp() {
        return ywxzp.get();
    }
    public StringProperty ywxzpProperty() {
        if(ywxzp==null){
            ywxzp = new SimpleStringProperty();
        }
        return ywxzp;
    }
    public void setYwxzp(String ywxzp) {
        this.ywxzp.set(ywxzp);
    }
    public String getBptext() {
        return bptext.get();
    }
    public StringProperty bptextProperty() {
        if(bptext==null){
            bptext = new SimpleStringProperty();
        }
        return bptext;
    }
    public void setBptext(String bptext) {
        this.bptext.set(bptext);
    }
    public String getPtext() {
        return ptext.get();
    }
    public StringProperty ptextProperty() {
        if(ptext==null){
            ptext = new SimpleStringProperty();
        }
        return ptext;
    }
    public void setPtext(String ptext) {
        this.ptext.set(ptext);
    }
    public String getRtext() {
        return rtext.get();
    }
    public StringProperty rtextProperty() {
        if(rtext==null){
            rtext = new SimpleStringProperty();
        }
        return rtext;
    }
    public void setRtext(String rtext) {
        this.rtext.set(rtext);
    }
    public String getSpo2text() {
        return spo2text.get();
    }
    public StringProperty spo2textProperty() {
        if(spo2text==null){
            spo2text = new SimpleStringProperty();
        }
        return spo2text;
    }
    public void setSpo2text(String spo2text) {
        this.spo2text.set(spo2text);
    }
    public String getTtext() {
        return ttext.get();
    }
    public StringProperty ttextProperty() {
        if(ttext==null){
            ttext = new SimpleStringProperty();
        }
        return ttext;
    }
    public void setTtext(String ttext) {
        this.ttext.set(ttext);
    }
    public String getQxsj() {
        return qxsj.get();
    }
    public StringProperty qxsjProperty() {
        if(qxsj==null){
            qxsj = new SimpleStringProperty();
        }
        return qxsj;
    }
    public void setQxsj(String qxsj) {
        this.qxsj.set(qxsj);
    }
    public String getTsqkText() {
        return tsqkText.get();
    }
    public StringProperty tsqkTextProperty() {
        if(tsqkText==null){
            tsqkText = new SimpleStringProperty();
        }
        return tsqkText;
    }
    public void setTsqkText(String tsqkText) {
        this.tsqkText.set(tsqkText);
    }
    public String getMzysqm() {
        return mzysqm.get();
    }
    public StringProperty mzysqmProperty() {
        if(mzysqm==null){
            mzysqm = new SimpleStringProperty();
        }
        return mzysqm;
    }
    public void setMzysqm(String mzysqm) {
        this.mzysqm.set(mzysqm);
    }
    public String getHszqm() {
        return hszqm.get();
    }
    public StringProperty hszqmProperty() {
        if(hszqm==null){
            hszqm = new SimpleStringProperty();
        }
        return hszqm;
    }
    public void setHszqm(String hszqm) {
        this.hszqm.set(hszqm);
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
    public String getTszs() {
        return tszs.get();
    }
    public StringProperty tszsProperty() {
        if(tszs==null){
            tszs = new SimpleStringProperty();
        }
        return tszs;
    }
    public void setTszs(String tszs) {
        this.tszs.set(tszs);
    }
    public String getXfjctext() {
        return xfjctext.get();
    }
    public StringProperty xfjctextProperty() {
        if(xfjctext==null){
            xfjctext = new SimpleStringProperty();
        }
        return xfjctext;
    }
    public void setXfjctext(String xfjctext) {
        this.xfjctext.set(xfjctext);
    }
    public String getMzmyText() {
        return mzmyText.get();
    }
    public StringProperty mzmyTextProperty() {
        if(mzmyText==null){
            mzmyText = new SimpleStringProperty();
        }
        return mzmyText;
    }
    public void setMzmyText(String mzmyText) {
        this.mzmyText.set(mzmyText);
    }
    public String getBfzText() {
        return bfzText.get();
    }
    public StringProperty bfzTextProperty() {
        if(bfzText==null){
            bfzText = new SimpleStringProperty();
        }
        return bfzText;
    }
    public void setBfzText(String bfzText) {
        this.bfzText.set(bfzText);
    }
    public String getBfzText2() {
        return bfzText2.get();
    }
    public StringProperty bfzText2Property() {
        if(bfzText2==null){
            bfzText2 = new SimpleStringProperty();
        }
        return bfzText2;
    }
    public void setBfzText2(String bfzText2) {
        this.bfzText2.set(bfzText2);
    }
    public String getBfzText3() {
        return bfzText3.get();
    }
    public StringProperty bfzText3Property() {
        if(bfzText3==null){
            bfzText3 = new SimpleStringProperty();
        }
        return bfzText3;
    }
    public void setBfzText3(String bfzText3) {
        this.bfzText3.set(bfzText3);
    }
    public String getYjText() {
        return yjText.get();
    }
    public StringProperty yjTextProperty() {
        if(yjText==null){
            yjText = new SimpleStringProperty();
        }
        return yjText;
    }
    public void setYjText(String yjText) {
        this.yjText.set(yjText);
    }
    public String getYjText2() {
        return yjText2.get();
    }
    public StringProperty yjText2Property() {
        if(yjText2==null){
            yjText2 = new SimpleStringProperty();
        }
        return yjText2;
    }
    public void setYjText2(String yjText2) {
        this.yjText2.set(yjText2);
    }
    public String getYjText3() {
        return yjText3.get();
    }
    public StringProperty yjText3Property() {
        if(yjText3==null){
            yjText3 = new SimpleStringProperty();
        }
        return yjText3;
    }
    public void setYjText3(String yjText3) {
        this.yjText3.set(yjText3);
    }
    public String getMzysqm2() {
        return mzysqm2.get();
    }
    public StringProperty mzysqm2Property() {
        if(mzysqm2==null){
            mzysqm2 = new SimpleStringProperty();
        }
        return mzysqm2;
    }
    public void setMzysqm2(String mzysqm2) {
        this.mzysqm2.set(mzysqm2);
    }
    public String getRq2() {
        return rq2.get();
    }
    public StringProperty rq2Property() {
        if(rq2==null){
            rq2 = new SimpleStringProperty();
        }
        return rq2;
    }
    public void setRq2(String rq2) {
        this.rq2.set(rq2);
    }

}
