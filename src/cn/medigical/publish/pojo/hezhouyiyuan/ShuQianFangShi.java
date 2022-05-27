package cn.medigical.publish.pojo.hezhouyiyuan;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ShuQianFangShi {

    /**是*/
    private BooleanProperty gxy_y;
    /**否*/
    private BooleanProperty gxy_n;
    /**是*/
    private BooleanProperty gxb_y;
    /**否*/
    private BooleanProperty gxb_n;
    /**是*/
    private BooleanProperty tnb_y;
    /**否*/
    private BooleanProperty tnb_n;
    /**是*/
    private BooleanProperty xc_y;
    /**否*/
    private BooleanProperty xc_n;
    /**是*/
    private BooleanProperty mxzsxfy_y;
    /**否*/
    private BooleanProperty mxzsxfy_n;
    /**是*/
    private BooleanProperty nxs_y;
    /**否*/
    private BooleanProperty nxs_n;
    /**是*/
    private BooleanProperty ncx_y;
    /**否*/
    private BooleanProperty ncx_n;
    /**是*/
    private BooleanProperty dx_y;
    /**否*/
    private BooleanProperty dx_n;
    /**是*/
    private BooleanProperty ywgms_y;
    /**否*/
    private BooleanProperty ywgms_n;
    /**是*/
    private BooleanProperty ywcy_y;
    /**否*/
    private BooleanProperty ywcy_n;
    /**是*/
    private BooleanProperty mzs_y;
    /**否*/
    private BooleanProperty mzs_n;
    /**是*/
    private BooleanProperty sss_y;
    /**否*/
    private BooleanProperty sss_n;
    /**是*/
    private BooleanProperty yys_y;
    /**否*/
    private BooleanProperty yys_n;
    /**清醒*/
    private BooleanProperty szqx;
    /**模糊*/
    private BooleanProperty szhs;
    /**昏迷*/
    private BooleanProperty szhm;
    /**有    /*/
    private BooleanProperty hxkn_y;
    /**无*/
    private BooleanProperty hxkn_n;
    /**有      /*/
    private BooleanProperty zg_y;
    /**无*/
    private BooleanProperty zg_n;
    /**正常    /*/
    private BooleanProperty kkd_zc;
    /**异常*/
    private BooleanProperty kkd_yc;
    /**有    /*/
    private BooleanProperty jyy;
    /**无*/
    private BooleanProperty jyw;
    /**正常    /*/
    private BooleanProperty tjhdzc;
    /**异常*/
    private BooleanProperty tjhdsx;
    /**有    /*/
    private BooleanProperty qdwkn;
    /**无    */
    private BooleanProperty cgkn;
    /**正常    /*/
    private BooleanProperty xzzc;
    /**异常*/
    private BooleanProperty xzyc;
    /**正常    /*/
    private BooleanProperty fbzc;
    /**异常*/
    private BooleanProperty fbyc;
    /**有    /*/
    private BooleanProperty jzjx;
    /**无*/
    private BooleanProperty jzjxyw;
    /**是  /*/
    private BooleanProperty zhjx_y;
    /**否清楚,*/
    private BooleanProperty zhjx_n;
    /**有/*/
    private BooleanProperty ccd_y;
    /**无    */
    private BooleanProperty ccd_n;
    /**正常    /*/
    private BooleanProperty ztzc;
    /**异常*/
    private BooleanProperty ztyc;
    /**正常    /*/
    private BooleanProperty xcgzc;
    /**异常*/
    private BooleanProperty xcgyc;
    /**正常    /*/
    private BooleanProperty ncgzc;
    /**异常*/
    private BooleanProperty ncgyc;
    /**正常    /*/
    private BooleanProperty xpzc;
    /**异常*/
    private BooleanProperty xpyc;
    /**正常    /*/
    private BooleanProperty csdtzc;
    /**异常*/
    private BooleanProperty csdtyc;
    /**正常    /*/
    private BooleanProperty ecgzc;
    /**异常*/
    private BooleanProperty ecgyc;
    /**正常    /*/
    private BooleanProperty gzxpzc;
    /**异常*/
    private BooleanProperty gzxpyc;
    /**正常    /*/
    private BooleanProperty fgnzc;
    /**异常*/
    private BooleanProperty fgnyc;
    /**正常    /*/
    private BooleanProperty xqfxzc;
    /**异常*/
    private BooleanProperty xqfxyc;
    /**正常    /*/
    private BooleanProperty ggnzc;
    /**异常*/
    private BooleanProperty ggnyc;
    /**正常    /*/
    private BooleanProperty sgnzc;
    /**异常*/
    private BooleanProperty sgnyc;
    /**正常    /*/
    private BooleanProperty nxgnzc;
    /**异常*/
    private BooleanProperty nxgnyc;
    /**正常    /*/
    private BooleanProperty djzzc;
    /**异常*/
    private BooleanProperty djzyc;
    /**1*/
    private BooleanProperty xgn1;
    /**2*/
    private BooleanProperty xgn2;
    /**3*/
    private BooleanProperty xgn3;
    /**4      级*/
    private BooleanProperty xgn4;
    /**I*/
    private BooleanProperty asa1;
    /**II*/
    private BooleanProperty asa2;
    /**III*/
    private BooleanProperty asa3;
    /**IV*/
    private BooleanProperty asa4;
    /**V*/
    private BooleanProperty asa5;
    /**VI*/
    private BooleanProperty asa6;
    /**E*/
    private BooleanProperty asae;
    /**：风险较小；*/
    private BooleanProperty fx1;
    /**：有一定的风险；*/
    private BooleanProperty fx2;
    /**：风险较大；*/
    private BooleanProperty fx3;
    /**：风险很大；*/
    private BooleanProperty fx4;
    /**：病情危重、濒临死亡、异常危险*/
    private BooleanProperty fx5;
    /*无*/
    private BooleanProperty qk_y;
    /**麻醉适应症，可否按期进行手术麻醉：*/
    private BooleanProperty qk_w;
    /**按期*/
    private BooleanProperty aq;
    /**延期*/
    private BooleanProperty yq;
    /**麻醉*/
    private BooleanProperty mz;
    /**全麻*/
    private BooleanProperty qm;
    /**气管插管   ） */
    private BooleanProperty qm_qg;
    /**硬膜外    /*/
    private BooleanProperty ymw;
    /**腰硬联合麻醉*/
    private BooleanProperty yylhmz;
    /**颈*/
    private BooleanProperty jc;
    /*臂丛*/
    private BooleanProperty bc;
    /**神经阻滞*/
    private BooleanProperty sjzz;
    /**监护麻醉   )*/
    private BooleanProperty jbmz;
    /**丙泊酚*/
    private BooleanProperty bbf;
    /**依托咪酯*/
    private BooleanProperty ytmz;
    /**咪达唑仑*/
    private BooleanProperty mdzl;
    /**瑞/*/
    private BooleanProperty rftn;
    /**舒/*/
    private BooleanProperty sftn;
    /**芬太尼*/
    private BooleanProperty ftn;
    /**顺阿曲库胺*/
    private BooleanProperty saqka;
    /**罗溴库胺*/
    private BooleanProperty lxka;
    /**七氟烷*/
    private BooleanProperty wkxa;
    /**利多卡因*/
    private BooleanProperty ldky;
    /**罗哌卡因*/
    private BooleanProperty lpky;
    /**左旋布比卡因*/
    private BooleanProperty zxky;
    /**布比卡因*/
    private BooleanProperty bbky;
    /**NIBP*/
    private BooleanProperty nibp;
    /**ECG*/
    private BooleanProperty ecg2;
    /**Spo2 */
    private BooleanProperty spo2;
    /**PetCO2*/
    private BooleanProperty petco2;
    /**尿量*/
    private BooleanProperty niaoliang;
    /**体温*/
    private BooleanProperty tw;
    /**IBP*/
    private BooleanProperty ibp;
    /**CVP*/
    private BooleanProperty cvo;
    /**血气分析*/
    private BooleanProperty xqfxnjc;
    /**电解质*/
    private BooleanProperty djz2;
    /**血糖*/
    private BooleanProperty xt1;
    /**住院号*/
    private StringProperty zyh;

    /**床位*/
    private StringProperty zych;
    /**姓名*/
    private StringProperty brxm;
    /**性别*/
    private StringProperty xb;
    /**年龄*/
    private StringProperty nl;
    /**体重*/
    private StringProperty tz;
    /**身高*/
    private StringProperty sg;
    /**简要病史*/
    private StringProperty jybs;
    /**否*/
    private StringProperty ywsText;
    /**其他HBox.hgrow=ALWAYS*/
    private StringProperty jbsqt;
    /**否*/
    private StringProperty mzsText;
    /**否*/
    private StringProperty sssText;
    /**否*/
    private StringProperty yysText;
    /**BP*/
    private StringProperty bp1;
    /***/
    private StringProperty bp2;
    /**P*/
    private StringProperty mb;
    /**R*/
    private StringProperty hx;
    /**T*/
    private StringProperty twt;
    /**甲颏间距*/
    private StringProperty jhjj;
    /**异常fx:id=xzyc*/
    private StringProperty xzjc;
    /**异常*/
    private StringProperty fbjc;
    /**异常*/
    private StringProperty zttext;
    /**其他*/
    private StringProperty sxzqt;
    /**异常fx:id=xcgyc*/
    private StringProperty xcgtext;
    /**异常*/
    private StringProperty xcg;
    /**异常fx:id=xpyc*/
    private StringProperty xpText;
    /**异常*/
    private StringProperty chsxdt;
    /**异常*/
    private StringProperty ecg;
    /**异常*/
    private StringProperty gzxpText;
    /**异常*/
    private StringProperty fgntext;
    /**异常fx:id=xqfxyc*/
    private StringProperty xueqifx;
    /**异常*/
    private StringProperty ggn;
    /**异常*/
    private StringProperty sgntext;
    /**异常*/
    private StringProperty nxgn;
    /**异常*/
    private StringProperty djz;
    /**其他*/
    private StringProperty qt;
    /**术前诊断*/
    private StringProperty sqzd;
    /**拟行手术*/
    private StringProperty nsss1;
    /**4.延期手术麻醉原因*/
    private StringProperty yqyy;
    /**5.术前麻醉医嘱*/
    private StringProperty mzyz;
    /**6.麻醉科麻醉前会诊讨论意见*/
    private StringProperty tlyj;
    /**(穿刺点:*/
    private StringProperty ccd;
    /**其他药物*/
    private StringProperty qtyw;
    /**其他*/
    private StringProperty njcqt;
    /**拟准备特殊急救药品及设备*/
    private StringProperty jjyp1;
    /**拟准备特殊急救药品及设备*/
    private StringProperty jjyp2;
    /**麻醉医师签名*/
    private StringProperty mzys;
    /**日期*/
    private StringProperty datetime;
    private  StringProperty fj;

    public String getFj() {
        return fj.get();
    }

    public StringProperty fjProperty() {
        if(fj==null){
            fj=new SimpleStringProperty();
        }
        return fj;
    }

    public void setFj(String fj) {
        this.fj.set(fj);
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
    public boolean isGxb_y() {
        return gxb_y.get();
    }
    public BooleanProperty gxb_yProperty() {
        if(gxb_y==null){
            gxb_y = new SimpleBooleanProperty(false);
        }
        return gxb_y;
    }
    public void setGxb_y(boolean gxb_y) {
        this.gxb_y.set(gxb_y);
    }
    public boolean isGxb_n() {
        return gxb_n.get();
    }
    public BooleanProperty gxb_nProperty() {
        if(gxb_n==null){
            gxb_n = new SimpleBooleanProperty(false);
        }
        return gxb_n;
    }
    public void setGxb_n(boolean gxb_n) {
        this.gxb_n.set(gxb_n);
    }
    public boolean isTnb_y() {
        return tnb_y.get();
    }
    public BooleanProperty tnb_yProperty() {
        if(tnb_y==null){
            tnb_y = new SimpleBooleanProperty(false);
        }
        return tnb_y;
    }
    public void setTnb_y(boolean tnb_y) {
        this.tnb_y.set(tnb_y);
    }
    public boolean isTnb_n() {
        return tnb_n.get();
    }
    public BooleanProperty tnb_nProperty() {
        if(tnb_n==null){
            tnb_n = new SimpleBooleanProperty(false);
        }
        return tnb_n;
    }
    public void setTnb_n(boolean tnb_n) {
        this.tnb_n.set(tnb_n);
    }
    public boolean isXc_y() {
        return xc_y.get();
    }
    public BooleanProperty xc_yProperty() {
        if(xc_y==null){
            xc_y = new SimpleBooleanProperty(false);
        }
        return xc_y;
    }
    public void setXc_y(boolean xc_y) {
        this.xc_y.set(xc_y);
    }
    public boolean isXc_n() {
        return xc_n.get();
    }
    public BooleanProperty xc_nProperty() {
        if(xc_n==null){
            xc_n = new SimpleBooleanProperty(false);
        }
        return xc_n;
    }
    public void setXc_n(boolean xc_n) {
        this.xc_n.set(xc_n);
    }
    public boolean isMxzsxfy_y() {
        return mxzsxfy_y.get();
    }
    public BooleanProperty mxzsxfy_yProperty() {
        if(mxzsxfy_y==null){
            mxzsxfy_y = new SimpleBooleanProperty(false);
        }
        return mxzsxfy_y;
    }
    public void setMxzsxfy_y(boolean mxzsxfy_y) {
        this.mxzsxfy_y.set(mxzsxfy_y);
    }
    public boolean isMxzsxfy_n() {
        return mxzsxfy_n.get();
    }
    public BooleanProperty mxzsxfy_nProperty() {
        if(mxzsxfy_n==null){
            mxzsxfy_n = new SimpleBooleanProperty(false);
        }
        return mxzsxfy_n;
    }
    public void setMxzsxfy_n(boolean mxzsxfy_n) {
        this.mxzsxfy_n.set(mxzsxfy_n);
    }
    public boolean isNxs_y() {
        return nxs_y.get();
    }
    public BooleanProperty nxs_yProperty() {
        if(nxs_y==null){
            nxs_y = new SimpleBooleanProperty(false);
        }
        return nxs_y;
    }
    public void setNxs_y(boolean nxs_y) {
        this.nxs_y.set(nxs_y);
    }
    public boolean isNxs_n() {
        return nxs_n.get();
    }
    public BooleanProperty nxs_nProperty() {
        if(nxs_n==null){
            nxs_n = new SimpleBooleanProperty(false);
        }
        return nxs_n;
    }
    public void setNxs_n(boolean nxs_n) {
        this.nxs_n.set(nxs_n);
    }
    public boolean isNcx_y() {
        return ncx_y.get();
    }
    public BooleanProperty ncx_yProperty() {
        if(ncx_y==null){
            ncx_y = new SimpleBooleanProperty(false);
        }
        return ncx_y;
    }
    public void setNcx_y(boolean ncx_y) {
        this.ncx_y.set(ncx_y);
    }
    public boolean isNcx_n() {
        return ncx_n.get();
    }
    public BooleanProperty ncx_nProperty() {
        if(ncx_n==null){
            ncx_n = new SimpleBooleanProperty(false);
        }
        return ncx_n;
    }
    public void setNcx_n(boolean ncx_n) {
        this.ncx_n.set(ncx_n);
    }
    public boolean isDx_y() {
        return dx_y.get();
    }
    public BooleanProperty dx_yProperty() {
        if(dx_y==null){
            dx_y = new SimpleBooleanProperty(false);
        }
        return dx_y;
    }
    public void setDx_y(boolean dx_y) {
        this.dx_y.set(dx_y);
    }
    public boolean isDx_n() {
        return dx_n.get();
    }
    public BooleanProperty dx_nProperty() {
        if(dx_n==null){
            dx_n = new SimpleBooleanProperty(false);
        }
        return dx_n;
    }
    public void setDx_n(boolean dx_n) {
        this.dx_n.set(dx_n);
    }
    public boolean isYwgms_y() {
        return ywgms_y.get();
    }
    public BooleanProperty ywgms_yProperty() {
        if(ywgms_y==null){
            ywgms_y = new SimpleBooleanProperty(false);
        }
        return ywgms_y;
    }
    public void setYwgms_y(boolean ywgms_y) {
        this.ywgms_y.set(ywgms_y);
    }
    public boolean isYwgms_n() {
        return ywgms_n.get();
    }
    public BooleanProperty ywgms_nProperty() {
        if(ywgms_n==null){
            ywgms_n = new SimpleBooleanProperty(false);
        }
        return ywgms_n;
    }
    public void setYwgms_n(boolean ywgms_n) {
        this.ywgms_n.set(ywgms_n);
    }
    public boolean isYwcy_y() {
        return ywcy_y.get();
    }
    public BooleanProperty ywcy_yProperty() {
        if(ywcy_y==null){
            ywcy_y = new SimpleBooleanProperty(false);
        }
        return ywcy_y;
    }
    public void setYwcy_y(boolean ywcy_y) {
        this.ywcy_y.set(ywcy_y);
    }
    public boolean isYwcy_n() {
        return ywcy_n.get();
    }
    public BooleanProperty ywcy_nProperty() {
        if(ywcy_n==null){
            ywcy_n = new SimpleBooleanProperty(false);
        }
        return ywcy_n;
    }
    public void setYwcy_n(boolean ywcy_n) {
        this.ywcy_n.set(ywcy_n);
    }
    public boolean isMzs_y() {
        return mzs_y.get();
    }
    public BooleanProperty mzs_yProperty() {
        if(mzs_y==null){
            mzs_y = new SimpleBooleanProperty(false);
        }
        return mzs_y;
    }
    public void setMzs_y(boolean mzs_y) {
        this.mzs_y.set(mzs_y);
    }
    public boolean isMzs_n() {
        return mzs_n.get();
    }
    public BooleanProperty mzs_nProperty() {
        if(mzs_n==null){
            mzs_n = new SimpleBooleanProperty(false);
        }
        return mzs_n;
    }
    public void setMzs_n(boolean mzs_n) {
        this.mzs_n.set(mzs_n);
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
    public boolean isYys_y() {
        return yys_y.get();
    }
    public BooleanProperty yys_yProperty() {
        if(yys_y==null){
            yys_y = new SimpleBooleanProperty(false);
        }
        return yys_y;
    }
    public void setYys_y(boolean yys_y) {
        this.yys_y.set(yys_y);
    }
    public boolean isYys_n() {
        return yys_n.get();
    }
    public BooleanProperty yys_nProperty() {
        if(yys_n==null){
            yys_n = new SimpleBooleanProperty(false);
        }
        return yys_n;
    }
    public void setYys_n(boolean yys_n) {
        this.yys_n.set(yys_n);
    }
    public boolean isSzqx() {
        return szqx.get();
    }
    public BooleanProperty szqxProperty() {
        if(szqx==null){
            szqx = new SimpleBooleanProperty(false);
        }
        return szqx;
    }
    public void setSzqx(boolean szqx) {
        this.szqx.set(szqx);
    }
    public boolean isSzhs() {
        return szhs.get();
    }
    public BooleanProperty szhsProperty() {
        if(szhs==null){
            szhs = new SimpleBooleanProperty(false);
        }
        return szhs;
    }
    public void setSzhs(boolean szhs) {
        this.szhs.set(szhs);
    }
    public boolean isSzhm() {
        return szhm.get();
    }
    public BooleanProperty szhmProperty() {
        if(szhm==null){
            szhm = new SimpleBooleanProperty(false);
        }
        return szhm;
    }
    public void setSzhm(boolean szhm) {
        this.szhm.set(szhm);
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
    public boolean isZg_y() {
        return zg_y.get();
    }
    public BooleanProperty zg_yProperty() {
        if(zg_y==null){
            zg_y = new SimpleBooleanProperty(false);
        }
        return zg_y;
    }
    public void setZg_y(boolean zg_y) {
        this.zg_y.set(zg_y);
    }
    public boolean isZg_n() {
        return zg_n.get();
    }
    public BooleanProperty zg_nProperty() {
        if(zg_n==null){
            zg_n = new SimpleBooleanProperty(false);
        }
        return zg_n;
    }
    public void setZg_n(boolean zg_n) {
        this.zg_n.set(zg_n);
    }
    public boolean isKkd_zc() {
        return kkd_zc.get();
    }
    public BooleanProperty kkd_zcProperty() {
        if(kkd_zc==null){
            kkd_zc = new SimpleBooleanProperty(false);
        }
        return kkd_zc;
    }
    public void setKkd_zc(boolean kkd_zc) {
        this.kkd_zc.set(kkd_zc);
    }
    public boolean isKkd_yc() {
        return kkd_yc.get();
    }
    public BooleanProperty kkd_ycProperty() {
        if(kkd_yc==null){
            kkd_yc = new SimpleBooleanProperty(false);
        }
        return kkd_yc;
    }
    public void setKkd_yc(boolean kkd_yc) {
        this.kkd_yc.set(kkd_yc);
    }
    public boolean isJyy() {
        return jyy.get();
    }
    public BooleanProperty jyyProperty() {
        if(jyy==null){
            jyy = new SimpleBooleanProperty(false);
        }
        return jyy;
    }
    public void setJyy(boolean jyy) {
        this.jyy.set(jyy);
    }
    public boolean isJyw() {
        return jyw.get();
    }
    public BooleanProperty jywProperty() {
        if(jyw==null){
            jyw = new SimpleBooleanProperty(false);
        }
        return jyw;
    }
    public void setJyw(boolean jyw) {
        this.jyw.set(jyw);
    }
    public boolean isTjhdzc() {
        return tjhdzc.get();
    }
    public BooleanProperty tjhdzcProperty() {
        if(tjhdzc==null){
            tjhdzc = new SimpleBooleanProperty(false);
        }
        return tjhdzc;
    }
    public void setTjhdzc(boolean tjhdzc) {
        this.tjhdzc.set(tjhdzc);
    }
    public boolean isTjhdsx() {
        return tjhdsx.get();
    }
    public BooleanProperty tjhdsxProperty() {
        if(tjhdsx==null){
            tjhdsx = new SimpleBooleanProperty(false);
        }
        return tjhdsx;
    }
    public void setTjhdsx(boolean tjhdsx) {
        this.tjhdsx.set(tjhdsx);
    }
    public boolean isQdwkn() {
        return qdwkn.get();
    }
    public BooleanProperty qdwknProperty() {
        if(qdwkn==null){
            qdwkn = new SimpleBooleanProperty(false);
        }
        return qdwkn;
    }
    public void setQdwkn(boolean qdwkn) {
        this.qdwkn.set(qdwkn);
    }
    public boolean isCgkn() {
        return cgkn.get();
    }
    public BooleanProperty cgknProperty() {
        if(cgkn==null){
            cgkn = new SimpleBooleanProperty(false);
        }
        return cgkn;
    }
    public void setCgkn(boolean cgkn) {
        this.cgkn.set(cgkn);
    }
    public boolean isXzzc() {
        return xzzc.get();
    }
    public BooleanProperty xzzcProperty() {
        if(xzzc==null){
            xzzc = new SimpleBooleanProperty(false);
        }
        return xzzc;
    }
    public void setXzzc(boolean xzzc) {
        this.xzzc.set(xzzc);
    }
    public boolean isXzyc() {
        return xzyc.get();
    }
    public BooleanProperty xzycProperty() {
        if(xzyc==null){
            xzyc = new SimpleBooleanProperty(false);
        }
        return xzyc;
    }
    public void setXzyc(boolean xzyc) {
        this.xzyc.set(xzyc);
    }
    public boolean isFbzc() {
        return fbzc.get();
    }
    public BooleanProperty fbzcProperty() {
        if(fbzc==null){
            fbzc = new SimpleBooleanProperty(false);
        }
        return fbzc;
    }
    public void setFbzc(boolean fbzc) {
        this.fbzc.set(fbzc);
    }
    public boolean isFbyc() {
        return fbyc.get();
    }
    public BooleanProperty fbycProperty() {
        if(fbyc==null){
            fbyc = new SimpleBooleanProperty(false);
        }
        return fbyc;
    }
    public void setFbyc(boolean fbyc) {
        this.fbyc.set(fbyc);
    }
    public boolean isJzjx() {
        return jzjx.get();
    }
    public BooleanProperty jzjxProperty() {
        if(jzjx==null){
            jzjx = new SimpleBooleanProperty(false);
        }
        return jzjx;
    }
    public void setJzjx(boolean jzjx) {
        this.jzjx.set(jzjx);
    }
    public boolean isJzjxyw() {
        return jzjxyw.get();
    }
    public BooleanProperty jzjxywProperty() {
        if(jzjxyw==null){
            jzjxyw = new SimpleBooleanProperty(false);
        }
        return jzjxyw;
    }
    public void setJzjxyw(boolean jzjxyw) {
        this.jzjxyw.set(jzjxyw);
    }
    public boolean isZhjx_y() {
        return zhjx_y.get();
    }
    public BooleanProperty zhjx_yProperty() {
        if(zhjx_y==null){
            zhjx_y = new SimpleBooleanProperty(false);
        }
        return zhjx_y;
    }
    public void setZhjx_y(boolean zhjx_y) {
        this.zhjx_y.set(zhjx_y);
    }
    public boolean isZhjx_n() {
        return zhjx_n.get();
    }
    public BooleanProperty zhjx_nProperty() {
        if(zhjx_n==null){
            zhjx_n = new SimpleBooleanProperty(false);
        }
        return zhjx_n;
    }
    public void setZhjx_n(boolean zhjx_n) {
        this.zhjx_n.set(zhjx_n);
    }
    public boolean isCcd_y() {
        return ccd_y.get();
    }
    public BooleanProperty ccd_yProperty() {
        if(ccd_y==null){
            ccd_y = new SimpleBooleanProperty(false);
        }
        return ccd_y;
    }
    public void setCcd_y(boolean ccd_y) {
        this.ccd_y.set(ccd_y);
    }
    public boolean isCcd_n() {
        return ccd_n.get();
    }
    public BooleanProperty ccd_nProperty() {
        if(ccd_n==null){
            ccd_n = new SimpleBooleanProperty(false);
        }
        return ccd_n;
    }
    public void setCcd_n(boolean ccd_n) {
        this.ccd_n.set(ccd_n);
    }
    public boolean isZtzc() {
        return ztzc.get();
    }
    public BooleanProperty ztzcProperty() {
        if(ztzc==null){
            ztzc = new SimpleBooleanProperty(false);
        }
        return ztzc;
    }
    public void setZtzc(boolean ztzc) {
        this.ztzc.set(ztzc);
    }
    public boolean isZtyc() {
        return ztyc.get();
    }
    public BooleanProperty ztycProperty() {
        if(ztyc==null){
            ztyc = new SimpleBooleanProperty(false);
        }
        return ztyc;
    }
    public void setZtyc(boolean ztyc) {
        this.ztyc.set(ztyc);
    }
    public boolean isXcgzc() {
        return xcgzc.get();
    }
    public BooleanProperty xcgzcProperty() {
        if(xcgzc==null){
            xcgzc = new SimpleBooleanProperty(false);
        }
        return xcgzc;
    }
    public void setXcgzc(boolean xcgzc) {
        this.xcgzc.set(xcgzc);
    }
    public boolean isXcgyc() {
        return xcgyc.get();
    }
    public BooleanProperty xcgycProperty() {
        if(xcgyc==null){
            xcgyc = new SimpleBooleanProperty(false);
        }
        return xcgyc;
    }
    public void setXcgyc(boolean xcgyc) {
        this.xcgyc.set(xcgyc);
    }
    public boolean isNcgzc() {
        return ncgzc.get();
    }
    public BooleanProperty ncgzcProperty() {
        if(ncgzc==null){
            ncgzc = new SimpleBooleanProperty(false);
        }
        return ncgzc;
    }
    public void setNcgzc(boolean ncgzc) {
        this.ncgzc.set(ncgzc);
    }
    public boolean isNcgyc() {
        return ncgyc.get();
    }
    public BooleanProperty ncgycProperty() {
        if(ncgyc==null){
            ncgyc = new SimpleBooleanProperty(false);
        }
        return ncgyc;
    }
    public void setNcgyc(boolean ncgyc) {
        this.ncgyc.set(ncgyc);
    }
    public boolean isXpzc() {
        return xpzc.get();
    }
    public BooleanProperty xpzcProperty() {
        if(xpzc==null){
            xpzc = new SimpleBooleanProperty(false);
        }
        return xpzc;
    }
    public void setXpzc(boolean xpzc) {
        this.xpzc.set(xpzc);
    }
    public boolean isXpyc() {
        return xpyc.get();
    }
    public BooleanProperty xpycProperty() {
        if(xpyc==null){
            xpyc = new SimpleBooleanProperty(false);
        }
        return xpyc;
    }
    public void setXpyc(boolean xpyc) {
        this.xpyc.set(xpyc);
    }
    public boolean isCsdtzc() {
        return csdtzc.get();
    }
    public BooleanProperty csdtzcProperty() {
        if(csdtzc==null){
            csdtzc = new SimpleBooleanProperty(false);
        }
        return csdtzc;
    }
    public void setCsdtzc(boolean csdtzc) {
        this.csdtzc.set(csdtzc);
    }
    public boolean isCsdtyc() {
        return csdtyc.get();
    }
    public BooleanProperty csdtycProperty() {
        if(csdtyc==null){
            csdtyc = new SimpleBooleanProperty(false);
        }
        return csdtyc;
    }
    public void setCsdtyc(boolean csdtyc) {
        this.csdtyc.set(csdtyc);
    }
    public boolean isEcgzc() {
        return ecgzc.get();
    }
    public BooleanProperty ecgzcProperty() {
        if(ecgzc==null){
            ecgzc = new SimpleBooleanProperty(false);
        }
        return ecgzc;
    }
    public void setEcgzc(boolean ecgzc) {
        this.ecgzc.set(ecgzc);
    }
    public boolean isEcgyc() {
        return ecgyc.get();
    }
    public BooleanProperty ecgycProperty() {
        if(ecgyc==null){
            ecgyc = new SimpleBooleanProperty(false);
        }
        return ecgyc;
    }
    public void setEcgyc(boolean ecgyc) {
        this.ecgyc.set(ecgyc);
    }
    public boolean isGzxpzc() {
        return gzxpzc.get();
    }
    public BooleanProperty gzxpzcProperty() {
        if(gzxpzc==null){
            gzxpzc = new SimpleBooleanProperty(false);
        }
        return gzxpzc;
    }
    public void setGzxpzc(boolean gzxpzc) {
        this.gzxpzc.set(gzxpzc);
    }
    public boolean isGzxpyc() {
        return gzxpyc.get();
    }
    public BooleanProperty gzxpycProperty() {
        if(gzxpyc==null){
            gzxpyc = new SimpleBooleanProperty(false);
        }
        return gzxpyc;
    }
    public void setGzxpyc(boolean gzxpyc) {
        this.gzxpyc.set(gzxpyc);
    }
    public boolean isFgnzc() {
        return fgnzc.get();
    }
    public BooleanProperty fgnzcProperty() {
        if(fgnzc==null){
            fgnzc = new SimpleBooleanProperty(false);
        }
        return fgnzc;
    }
    public void setFgnzc(boolean fgnzc) {
        this.fgnzc.set(fgnzc);
    }
    public boolean isFgnyc() {
        return fgnyc.get();
    }
    public BooleanProperty fgnycProperty() {
        if(fgnyc==null){
            fgnyc = new SimpleBooleanProperty(false);
        }
        return fgnyc;
    }
    public void setFgnyc(boolean fgnyc) {
        this.fgnyc.set(fgnyc);
    }
    public boolean isXqfxzc() {
        return xqfxzc.get();
    }
    public BooleanProperty xqfxzcProperty() {
        if(xqfxzc==null){
            xqfxzc = new SimpleBooleanProperty(false);
        }
        return xqfxzc;
    }
    public void setXqfxzc(boolean xqfxzc) {
        this.xqfxzc.set(xqfxzc);
    }
    public boolean isXqfxyc() {
        return xqfxyc.get();
    }
    public BooleanProperty xqfxycProperty() {
        if(xqfxyc==null){
            xqfxyc = new SimpleBooleanProperty(false);
        }
        return xqfxyc;
    }
    public void setXqfxyc(boolean xqfxyc) {
        this.xqfxyc.set(xqfxyc);
    }
    public boolean isGgnzc() {
        return ggnzc.get();
    }
    public BooleanProperty ggnzcProperty() {
        if(ggnzc==null){
            ggnzc = new SimpleBooleanProperty(false);
        }
        return ggnzc;
    }
    public void setGgnzc(boolean ggnzc) {
        this.ggnzc.set(ggnzc);
    }
    public boolean isGgnyc() {
        return ggnyc.get();
    }
    public BooleanProperty ggnycProperty() {
        if(ggnyc==null){
            ggnyc = new SimpleBooleanProperty(false);
        }
        return ggnyc;
    }
    public void setGgnyc(boolean ggnyc) {
        this.ggnyc.set(ggnyc);
    }
    public boolean isSgnzc() {
        return sgnzc.get();
    }
    public BooleanProperty sgnzcProperty() {
        if(sgnzc==null){
            sgnzc = new SimpleBooleanProperty(false);
        }
        return sgnzc;
    }
    public void setSgnzc(boolean sgnzc) {
        this.sgnzc.set(sgnzc);
    }
    public boolean isSgnyc() {
        return sgnyc.get();
    }
    public BooleanProperty sgnycProperty() {
        if(sgnyc==null){
            sgnyc = new SimpleBooleanProperty(false);
        }
        return sgnyc;
    }
    public void setSgnyc(boolean sgnyc) {
        this.sgnyc.set(sgnyc);
    }
    public boolean isNxgnzc() {
        return nxgnzc.get();
    }
    public BooleanProperty nxgnzcProperty() {
        if(nxgnzc==null){
            nxgnzc = new SimpleBooleanProperty(false);
        }
        return nxgnzc;
    }
    public void setNxgnzc(boolean nxgnzc) {
        this.nxgnzc.set(nxgnzc);
    }
    public boolean isNxgnyc() {
        return nxgnyc.get();
    }
    public BooleanProperty nxgnycProperty() {
        if(nxgnyc==null){
            nxgnyc = new SimpleBooleanProperty(false);
        }
        return nxgnyc;
    }
    public void setNxgnyc(boolean nxgnyc) {
        this.nxgnyc.set(nxgnyc);
    }
    public boolean isDjzzc() {
        return djzzc.get();
    }
    public BooleanProperty djzzcProperty() {
        if(djzzc==null){
            djzzc = new SimpleBooleanProperty(false);
        }
        return djzzc;
    }
    public void setDjzzc(boolean djzzc) {
        this.djzzc.set(djzzc);
    }
    public boolean isDjzyc() {
        return djzyc.get();
    }
    public BooleanProperty djzycProperty() {
        if(djzyc==null){
            djzyc = new SimpleBooleanProperty(false);
        }
        return djzyc;
    }
    public void setDjzyc(boolean djzyc) {
        this.djzyc.set(djzyc);
    }
    public boolean isXgn1() {
        return xgn1.get();
    }
    public BooleanProperty xgn1Property() {
        if(xgn1==null){
            xgn1 = new SimpleBooleanProperty(false);
        }
        return xgn1;
    }
    public void setXgn1(boolean xgn1) {
        this.xgn1.set(xgn1);
    }
    public boolean isXgn2() {
        return xgn2.get();
    }
    public BooleanProperty xgn2Property() {
        if(xgn2==null){
            xgn2 = new SimpleBooleanProperty(false);
        }
        return xgn2;
    }
    public void setXgn2(boolean xgn2) {
        this.xgn2.set(xgn2);
    }
    public boolean isXgn3() {
        return xgn3.get();
    }
    public BooleanProperty xgn3Property() {
        if(xgn3==null){
            xgn3 = new SimpleBooleanProperty(false);
        }
        return xgn3;
    }
    public void setXgn3(boolean xgn3) {
        this.xgn3.set(xgn3);
    }
    public boolean isXgn4() {
        return xgn4.get();
    }
    public BooleanProperty xgn4Property() {
        if(xgn4==null){
            xgn4 = new SimpleBooleanProperty(false);
        }
        return xgn4;
    }
    public void setXgn4(boolean xgn4) {
        this.xgn4.set(xgn4);
    }
    public boolean isAsa1() {
        return asa1.get();
    }
    public BooleanProperty asa1Property() {
        if(asa1==null){
            asa1 = new SimpleBooleanProperty(false);
        }
        return asa1;
    }
    public void setAsa1(boolean asa1) {
        this.asa1.set(asa1);
    }
    public boolean isAsa2() {
        return asa2.get();
    }
    public BooleanProperty asa2Property() {
        if(asa2==null){
            asa2 = new SimpleBooleanProperty(false);
        }
        return asa2;
    }
    public void setAsa2(boolean asa2) {
        this.asa2.set(asa2);
    }
    public boolean isAsa3() {
        return asa3.get();
    }
    public BooleanProperty asa3Property() {
        if(asa3==null){
            asa3 = new SimpleBooleanProperty(false);
        }
        return asa3;
    }
    public void setAsa3(boolean asa3) {
        this.asa3.set(asa3);
    }
    public boolean isAsa4() {
        return asa4.get();
    }
    public BooleanProperty asa4Property() {
        if(asa4==null){
            asa4 = new SimpleBooleanProperty(false);
        }
        return asa4;
    }
    public void setAsa4(boolean asa4) {
        this.asa4.set(asa4);
    }
    public boolean isAsa5() {
        return asa5.get();
    }
    public BooleanProperty asa5Property() {
        if(asa5==null){
            asa5 = new SimpleBooleanProperty(false);
        }
        return asa5;
    }
    public void setAsa5(boolean asa5) {
        this.asa5.set(asa5);
    }
    public boolean isAsa6() {
        return asa6.get();
    }
    public BooleanProperty asa6Property() {
        if(asa6==null){
            asa6 = new SimpleBooleanProperty(false);
        }
        return asa6;
    }
    public void setAsa6(boolean asa6) {
        this.asa6.set(asa6);
    }
    public boolean isAsae() {
        return asae.get();
    }
    public BooleanProperty asaeProperty() {
        if(asae==null){
            asae = new SimpleBooleanProperty(false);
        }
        return asae;
    }
    public void setAsae(boolean asae) {
        this.asae.set(asae);
    }
    public boolean isFx1() {
        return fx1.get();
    }
    public BooleanProperty fx1Property() {
        if(fx1==null){
            fx1 = new SimpleBooleanProperty(false);
        }
        return fx1;
    }
    public void setFx1(boolean fx1) {
        this.fx1.set(fx1);
    }
    public boolean isFx2() {
        return fx2.get();
    }
    public BooleanProperty fx2Property() {
        if(fx2==null){
            fx2 = new SimpleBooleanProperty(false);
        }
        return fx2;
    }
    public void setFx2(boolean fx2) {
        this.fx2.set(fx2);
    }
    public boolean isFx3() {
        return fx3.get();
    }
    public BooleanProperty fx3Property() {
        if(fx3==null){
            fx3 = new SimpleBooleanProperty(false);
        }
        return fx3;
    }
    public void setFx3(boolean fx3) {
        this.fx3.set(fx3);
    }
    public boolean isFx4() {
        return fx4.get();
    }
    public BooleanProperty fx4Property() {
        if(fx4==null){
            fx4 = new SimpleBooleanProperty(false);
        }
        return fx4;
    }
    public void setFx4(boolean fx4) {
        this.fx4.set(fx4);
    }
    public boolean isFx5() {
        return fx5.get();
    }
    public BooleanProperty fx5Property() {
        if(fx5==null){
            fx5 = new SimpleBooleanProperty(false);
        }
        return fx5;
    }
    public void setFx5(boolean fx5) {
        this.fx5.set(fx5);
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
    public boolean isQk_w() {
        return qk_w.get();
    }
    public BooleanProperty qk_wProperty() {
        if(qk_w==null){
            qk_w = new SimpleBooleanProperty(false);
        }
        return qk_w;
    }
    public void setQk_w(boolean qk_w) {
        this.qk_w.set(qk_w);
    }
    public boolean isAq() {
        return aq.get();
    }
    public BooleanProperty aqProperty() {
        if(aq==null){
            aq = new SimpleBooleanProperty(false);
        }
        return aq;
    }
    public void setAq(boolean aq) {
        this.aq.set(aq);
    }
    public boolean isYq() {
        return yq.get();
    }
    public BooleanProperty yqProperty() {
        if(yq==null){
            yq = new SimpleBooleanProperty(false);
        }
        return yq;
    }
    public void setYq(boolean yq) {
        this.yq.set(yq);
    }
    public boolean isMz() {
        return mz.get();
    }
    public BooleanProperty mzProperty() {
        if(mz==null){
            mz = new SimpleBooleanProperty(false);
        }
        return mz;
    }
    public void setMz(boolean mz) {
        this.mz.set(mz);
    }
    public boolean isQm() {
        return qm.get();
    }
    public BooleanProperty qmProperty() {
        if(qm==null){
            qm = new SimpleBooleanProperty(false);
        }
        return qm;
    }
    public void setQm(boolean qm) {
        this.qm.set(qm);
    }
    public boolean isQm_qg() {
        return qm_qg.get();
    }
    public BooleanProperty qm_qgProperty() {
        if(qm_qg==null){
            qm_qg = new SimpleBooleanProperty(false);
        }
        return qm_qg;
    }
    public void setQm_qg(boolean qm_qg) {
        this.qm_qg.set(qm_qg);
    }
    public boolean isYmw() {
        return ymw.get();
    }
    public BooleanProperty ymwProperty() {
        if(ymw==null){
            ymw = new SimpleBooleanProperty(false);
        }
        return ymw;
    }
    public void setYmw(boolean ymw) {
        this.ymw.set(ymw);
    }
    public boolean isYylhmz() {
        return yylhmz.get();
    }
    public BooleanProperty yylhmzProperty() {
        if(yylhmz==null){
            yylhmz = new SimpleBooleanProperty(false);
        }
        return yylhmz;
    }
    public void setYylhmz(boolean yylhmz) {
        this.yylhmz.set(yylhmz);
    }
    public boolean isJc() {
        return jc.get();
    }
    public BooleanProperty jcProperty() {
        if(jc==null){
            jc = new SimpleBooleanProperty(false);
        }
        return jc;
    }
    public void setJc(boolean jc) {
        this.jc.set(jc);
    }
    public boolean isBc() {
        return bc.get();
    }
    public BooleanProperty bcProperty() {
        if(bc==null){
            bc = new SimpleBooleanProperty(false);
        }
        return bc;
    }
    public void setBc(boolean bc) {
        this.bc.set(bc);
    }
    public boolean isSjzz() {
        return sjzz.get();
    }
    public BooleanProperty sjzzProperty() {
        if(sjzz==null){
            sjzz = new SimpleBooleanProperty(false);
        }
        return sjzz;
    }
    public void setSjzz(boolean sjzz) {
        this.sjzz.set(sjzz);
    }
    public boolean isJbmz() {
        return jbmz.get();
    }
    public BooleanProperty jbmzProperty() {
        if(jbmz==null){
            jbmz = new SimpleBooleanProperty(false);
        }
        return jbmz;
    }
    public void setJbmz(boolean jbmz) {
        this.jbmz.set(jbmz);
    }
    public boolean isBbf() {
        return bbf.get();
    }
    public BooleanProperty bbfProperty() {
        if(bbf==null){
            bbf = new SimpleBooleanProperty(false);
        }
        return bbf;
    }
    public void setBbf(boolean bbf) {
        this.bbf.set(bbf);
    }
    public boolean isYtmz() {
        return ytmz.get();
    }
    public BooleanProperty ytmzProperty() {
        if(ytmz==null){
            ytmz = new SimpleBooleanProperty(false);
        }
        return ytmz;
    }
    public void setYtmz(boolean ytmz) {
        this.ytmz.set(ytmz);
    }
    public boolean isMdzl() {
        return mdzl.get();
    }
    public BooleanProperty mdzlProperty() {
        if(mdzl==null){
            mdzl = new SimpleBooleanProperty(false);
        }
        return mdzl;
    }
    public void setMdzl(boolean mdzl) {
        this.mdzl.set(mdzl);
    }
    public boolean isRftn() {
        return rftn.get();
    }
    public BooleanProperty rftnProperty() {
        if(rftn==null){
            rftn = new SimpleBooleanProperty(false);
        }
        return rftn;
    }
    public void setRftn(boolean rftn) {
        this.rftn.set(rftn);
    }
    public boolean isSftn() {
        return sftn.get();
    }
    public BooleanProperty sftnProperty() {
        if(sftn==null){
            sftn = new SimpleBooleanProperty(false);
        }
        return sftn;
    }
    public void setSftn(boolean sftn) {
        this.sftn.set(sftn);
    }
    public boolean isFtn() {
        return ftn.get();
    }
    public BooleanProperty ftnProperty() {
        if(ftn==null){
            ftn = new SimpleBooleanProperty(false);
        }
        return ftn;
    }
    public void setFtn(boolean ftn) {
        this.ftn.set(ftn);
    }
    public boolean isSaqka() {
        return saqka.get();
    }
    public BooleanProperty saqkaProperty() {
        if(saqka==null){
            saqka = new SimpleBooleanProperty(false);
        }
        return saqka;
    }
    public void setSaqka(boolean saqka) {
        this.saqka.set(saqka);
    }
    public boolean isLxka() {
        return lxka.get();
    }
    public BooleanProperty lxkaProperty() {
        if(lxka==null){
            lxka = new SimpleBooleanProperty(false);
        }
        return lxka;
    }
    public void setLxka(boolean lxka) {
        this.lxka.set(lxka);
    }
    public boolean isWkxa() {
        return wkxa.get();
    }
    public BooleanProperty wkxaProperty() {
        if(wkxa==null){
            wkxa = new SimpleBooleanProperty(false);
        }
        return wkxa;
    }
    public void setWkxa(boolean wkxa) {
        this.wkxa.set(wkxa);
    }
    public boolean isLdky() {
        return ldky.get();
    }
    public BooleanProperty ldkyProperty() {
        if(ldky==null){
            ldky = new SimpleBooleanProperty(false);
        }
        return ldky;
    }
    public void setLdky(boolean ldky) {
        this.ldky.set(ldky);
    }
    public boolean isLpky() {
        return lpky.get();
    }
    public BooleanProperty lpkyProperty() {
        if(lpky==null){
            lpky = new SimpleBooleanProperty(false);
        }
        return lpky;
    }
    public void setLpky(boolean lpky) {
        this.lpky.set(lpky);
    }
    public boolean isZxky() {
        return zxky.get();
    }
    public BooleanProperty zxkyProperty() {
        if(zxky==null){
            zxky = new SimpleBooleanProperty(false);
        }
        return zxky;
    }
    public void setZxky(boolean zxky) {
        this.zxky.set(zxky);
    }
    public boolean isBbky() {
        return bbky.get();
    }
    public BooleanProperty bbkyProperty() {
        if(bbky==null){
            bbky = new SimpleBooleanProperty(false);
        }
        return bbky;
    }
    public void setBbky(boolean bbky) {
        this.bbky.set(bbky);
    }
    public boolean isNibp() {
        return nibp.get();
    }
    public BooleanProperty nibpProperty() {
        if(nibp==null){
            nibp = new SimpleBooleanProperty(false);
        }
        return nibp;
    }
    public void setNibp(boolean nibp) {
        this.nibp.set(nibp);
    }
    public boolean isEcg2() {
        return ecg2.get();
    }
    public BooleanProperty ecg2Property() {
        if(ecg2==null){
            ecg2 = new SimpleBooleanProperty(false);
        }
        return ecg2;
    }
    public void setEcg2(boolean ecg2) {
        this.ecg2.set(ecg2);
    }
    public boolean isSpo2() {
        return spo2.get();
    }
    public BooleanProperty spo2Property() {
        if(spo2==null){
            spo2 = new SimpleBooleanProperty(false);
        }
        return spo2;
    }
    public void setSpo2(boolean spo2) {
        this.spo2.set(spo2);
    }
    public boolean isPetco2() {
        return petco2.get();
    }
    public BooleanProperty petco2Property() {
        if(petco2==null){
            petco2 = new SimpleBooleanProperty(false);
        }
        return petco2;
    }
    public void setPetco2(boolean petco2) {
        this.petco2.set(petco2);
    }
    public boolean isNiaoliang() {
        return niaoliang.get();
    }
    public BooleanProperty niaoliangProperty() {
        if(niaoliang==null){
            niaoliang = new SimpleBooleanProperty(false);
        }
        return niaoliang;
    }
    public void setNiaoliang(boolean niaoliang) {
        this.niaoliang.set(niaoliang);
    }
    public boolean isTw() {
        return tw.get();
    }
    public BooleanProperty twProperty() {
        if(tw==null){
            tw = new SimpleBooleanProperty(false);
        }
        return tw;
    }
    public void setTw(boolean tw) {
        this.tw.set(tw);
    }
    public boolean isIbp() {
        return ibp.get();
    }
    public BooleanProperty ibpProperty() {
        if(ibp==null){
            ibp = new SimpleBooleanProperty(false);
        }
        return ibp;
    }
    public void setIbp(boolean ibp) {
        this.ibp.set(ibp);
    }
    public boolean isCvo() {
        return cvo.get();
    }
    public BooleanProperty cvoProperty() {
        if(cvo==null){
            cvo = new SimpleBooleanProperty(false);
        }
        return cvo;
    }
    public void setCvo(boolean cvo) {
        this.cvo.set(cvo);
    }
    public boolean isXqfxnjc() {
        return xqfxnjc.get();
    }
    public BooleanProperty xqfxnjcProperty() {
        if(xqfxnjc==null){
            xqfxnjc = new SimpleBooleanProperty(false);
        }
        return xqfxnjc;
    }
    public void setXqfxnjc(boolean xqfxnjc) {
        this.xqfxnjc.set(xqfxnjc);
    }
    public boolean isDjz2() {
        return djz2.get();
    }
    public BooleanProperty djz2Property() {
        if(djz2==null){
            djz2 = new SimpleBooleanProperty(false);
        }
        return djz2;
    }
    public void setDjz2(boolean djz2) {
        this.djz2.set(djz2);
    }
    public boolean isXt1() {
        return xt1.get();
    }
    public BooleanProperty xt1Property() {
        if(xt1==null){
            xt1 = new SimpleBooleanProperty(false);
        }
        return xt1;
    }
    public void setXt1(boolean xt1) {
        this.xt1.set(xt1);
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
    public String getTz() {
        return tz.get();
    }
    public StringProperty tzProperty() {
        if(tz==null){
            tz = new SimpleStringProperty();
        }
        return tz;
    }
    public void setTz(String tz) {
        this.tz.set(tz);
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
    public String getJybs() {
        return jybs.get();
    }
    public StringProperty jybsProperty() {
        if(jybs==null){
            jybs = new SimpleStringProperty();
        }
        return jybs;
    }
    public void setJybs(String jybs) {
        this.jybs.set(jybs);
    }
    public String getYwsText() {
        return ywsText.get();
    }
    public StringProperty ywsTextProperty() {
        if(ywsText==null){
            ywsText = new SimpleStringProperty();
        }
        return ywsText;
    }
    public void setYwsText(String ywsText) {
        this.ywsText.set(ywsText);
    }
    public String getJbsqt() {
        return jbsqt.get();
    }
    public StringProperty jbsqtProperty() {
        if(jbsqt==null){
            jbsqt = new SimpleStringProperty();
        }
        return jbsqt;
    }
    public void setJbsqt(String jbsqt) {
        this.jbsqt.set(jbsqt);
    }
    public String getMzsText() {
        return mzsText.get();
    }
    public StringProperty mzsTextProperty() {
        if(mzsText==null){
            mzsText = new SimpleStringProperty();
        }
        return mzsText;
    }
    public void setMzsText(String mzsText) {
        this.mzsText.set(mzsText);
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
    public String getYysText() {
        return yysText.get();
    }
    public StringProperty yysTextProperty() {
        if(yysText==null){
            yysText = new SimpleStringProperty();
        }
        return yysText;
    }
    public void setYysText(String yysText) {
        this.yysText.set(yysText);
    }
    public String getBp1() {
        return bp1.get();
    }
    public StringProperty bp1Property() {
        if(bp1==null){
            bp1 = new SimpleStringProperty();
        }
        return bp1;
    }
    public void setBp1(String bp1) {
        this.bp1.set(bp1);
    }
    public String getBp2() {
        return bp2.get();
    }
    public StringProperty bp2Property() {
        if(bp2==null){
            bp2 = new SimpleStringProperty();
        }
        return bp2;
    }
    public void setBp2(String bp2) {
        this.bp2.set(bp2);
    }
    public String getMb() {
        return mb.get();
    }
    public StringProperty mbProperty() {
        if(mb==null){
            mb = new SimpleStringProperty();
        }
        return mb;
    }
    public void setMb(String mb) {
        this.mb.set(mb);
    }
    public String getHx() {
        return hx.get();
    }
    public StringProperty hxProperty() {
        if(hx==null){
            hx = new SimpleStringProperty();
        }
        return hx;
    }
    public void setHx(String hx) {
        this.hx.set(hx);
    }
    public String getTwt() {
        return twt.get();
    }
    public StringProperty twtProperty() {
        if(twt==null){
            twt = new SimpleStringProperty();
        }
        return twt;
    }
    public void setTwt(String twt) {
        this.twt.set(twt);
    }
    public String getJhjj() {
        return jhjj.get();
    }
    public StringProperty jhjjProperty() {
        if(jhjj==null){
            jhjj = new SimpleStringProperty();
        }
        return jhjj;
    }
    public void setJhjj(String jhjj) {
        this.jhjj.set(jhjj);
    }
    public String getXzjc() {
        return xzjc.get();
    }
    public StringProperty xzjcProperty() {
        if(xzjc==null){
            xzjc = new SimpleStringProperty();
        }
        return xzjc;
    }
    public void setXzjc(String xzjc) {
        this.xzjc.set(xzjc);
    }
    public String getFbjc() {
        return fbjc.get();
    }
    public StringProperty fbjcProperty() {
        if(fbjc==null){
            fbjc = new SimpleStringProperty();
        }
        return fbjc;
    }
    public void setFbjc(String fbjc) {
        this.fbjc.set(fbjc);
    }
    public String getZttext() {
        return zttext.get();
    }
    public StringProperty zttextProperty() {
        if(zttext==null){
            zttext = new SimpleStringProperty();
        }
        return zttext;
    }
    public void setZttext(String zttext) {
        this.zttext.set(zttext);
    }
    public String getSxzqt() {
        return sxzqt.get();
    }
    public StringProperty sxzqtProperty() {
        if(sxzqt==null){
            sxzqt = new SimpleStringProperty();
        }
        return sxzqt;
    }
    public void setSxzqt(String sxzqt) {
        this.sxzqt.set(sxzqt);
    }
    public String getXcgtext() {
        return xcgtext.get();
    }
    public StringProperty xcgtextProperty() {
        if(xcgtext==null){
            xcgtext = new SimpleStringProperty();
        }
        return xcgtext;
    }
    public void setXcgtext(String xcgtext) {
        this.xcgtext.set(xcgtext);
    }
    public String getXcg() {
        return xcg.get();
    }
    public StringProperty xcgProperty() {
        if(xcg==null){
            xcg = new SimpleStringProperty();
        }
        return xcg;
    }
    public void setXcg(String xcg) {
        this.xcg.set(xcg);
    }
    public String getXpText() {
        return xpText.get();
    }
    public StringProperty xpTextProperty() {
        if(xpText==null){
            xpText = new SimpleStringProperty();
        }
        return xpText;
    }
    public void setXpText(String xpText) {
        this.xpText.set(xpText);
    }
    public String getChsxdt() {
        return chsxdt.get();
    }
    public StringProperty chsxdtProperty() {
        if(chsxdt==null){
            chsxdt = new SimpleStringProperty();
        }
        return chsxdt;
    }
    public void setChsxdt(String chsxdt) {
        this.chsxdt.set(chsxdt);
    }
    public String getEcg() {
        return ecg.get();
    }
    public StringProperty ecgProperty() {
        if(ecg==null){
            ecg = new SimpleStringProperty();
        }
        return ecg;
    }
    public void setEcg(String ecg) {
        this.ecg.set(ecg);
    }
    public String getGzxpText() {
        return gzxpText.get();
    }
    public StringProperty gzxpTextProperty() {
        if(gzxpText==null){
            gzxpText = new SimpleStringProperty();
        }
        return gzxpText;
    }
    public void setGzxpText(String gzxpText) {
        this.gzxpText.set(gzxpText);
    }
    public String getFgntext() {
        return fgntext.get();
    }
    public StringProperty fgntextProperty() {
        if(fgntext==null){
            fgntext = new SimpleStringProperty();
        }
        return fgntext;
    }
    public void setFgntext(String fgntext) {
        this.fgntext.set(fgntext);
    }
    public String getXueqifx() {
        return xueqifx.get();
    }
    public StringProperty xueqifxProperty() {
        if(xueqifx==null){
            xueqifx = new SimpleStringProperty();
        }
        return xueqifx;
    }
    public void setXueqifx(String xueqifx) {
        this.xueqifx.set(xueqifx);
    }
    public String getGgn() {
        return ggn.get();
    }
    public StringProperty ggnProperty() {
        if(ggn==null){
            ggn = new SimpleStringProperty();
        }
        return ggn;
    }
    public void setGgn(String ggn) {
        this.ggn.set(ggn);
    }
    public String getSgntext() {
        return sgntext.get();
    }
    public StringProperty sgntextProperty() {
        if(sgntext==null){
            sgntext = new SimpleStringProperty();
        }
        return sgntext;
    }
    public void setSgntext(String sgntext) {
        this.sgntext.set(sgntext);
    }
    public String getNxgn() {
        return nxgn.get();
    }
    public StringProperty nxgnProperty() {
        if(nxgn==null){
            nxgn = new SimpleStringProperty();
        }
        return nxgn;
    }
    public void setNxgn(String nxgn) {
        this.nxgn.set(nxgn);
    }
    public String getDjz() {
        return djz.get();
    }
    public StringProperty djzProperty() {
        if(djz==null){
            djz = new SimpleStringProperty();
        }
        return djz;
    }
    public void setDjz(String djz) {
        this.djz.set(djz);
    }
    public String getQt() {
        return qt.get();
    }
    public StringProperty qtProperty() {
        if(qt==null){
            qt = new SimpleStringProperty();
        }
        return qt;
    }
    public void setQt(String qt) {
        this.qt.set(qt);
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
    public String getYqyy() {
        return yqyy.get();
    }
    public StringProperty yqyyProperty() {
        if(yqyy==null){
            yqyy = new SimpleStringProperty();
        }
        return yqyy;
    }
    public void setYqyy(String yqyy) {
        this.yqyy.set(yqyy);
    }
    public String getMzyz() {
        return mzyz.get();
    }
    public StringProperty mzyzProperty() {
        if(mzyz==null){
            mzyz = new SimpleStringProperty();
        }
        return mzyz;
    }
    public void setMzyz(String mzyz) {
        this.mzyz.set(mzyz);
    }
    public String getTlyj() {
        return tlyj.get();
    }
    public StringProperty tlyjProperty() {
        if(tlyj==null){
            tlyj = new SimpleStringProperty();
        }
        return tlyj;
    }
    public void setTlyj(String tlyj) {
        this.tlyj.set(tlyj);
    }
    public String getCcd() {
        return ccd.get();
    }
    public StringProperty ccdProperty() {
        if(ccd==null){
            ccd = new SimpleStringProperty();
        }
        return ccd;
    }
    public void setCcd(String ccd) {
        this.ccd.set(ccd);
    }
    public String getQtyw() {
        return qtyw.get();
    }
    public StringProperty qtywProperty() {
        if(qtyw==null){
            qtyw = new SimpleStringProperty();
        }
        return qtyw;
    }
    public void setQtyw(String qtyw) {
        this.qtyw.set(qtyw);
    }
    public String getNjcqt() {
        return njcqt.get();
    }
    public StringProperty njcqtProperty() {
        if(njcqt==null){
            njcqt = new SimpleStringProperty();
        }
        return njcqt;
    }
    public void setNjcqt(String njcqt) {
        this.njcqt.set(njcqt);
    }
    public String getJjyp1() {
        return jjyp1.get();
    }
    public StringProperty jjyp1Property() {
        if(jjyp1==null){
            jjyp1 = new SimpleStringProperty();
        }
        return jjyp1;
    }
    public void setJjyp1(String jjyp1) {
        this.jjyp1.set(jjyp1);
    }
    public String getJjyp2() {
        return jjyp2.get();
    }
    public StringProperty jjyp2Property() {
        if(jjyp2==null){
            jjyp2 = new SimpleStringProperty();
        }
        return jjyp2;
    }
    public void setJjyp2(String jjyp2) {
        this.jjyp2.set(jjyp2);
    }
    public String getMzys() {
        return mzys.get();
    }
    public StringProperty mzysProperty() {
        if(mzys==null){
            mzys = new SimpleStringProperty();
        }
        return mzys;
    }
    public void setMzys(String mzys) {
        this.mzys.set(mzys);
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
