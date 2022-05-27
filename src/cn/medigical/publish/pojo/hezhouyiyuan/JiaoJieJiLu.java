package cn.medigical.publish.pojo.hezhouyiyuan;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class JiaoJieJiLu {
    /**有*/
    private BooleanProperty wdbs_y;
    /**无*/
    private BooleanProperty wdbs_n;
    /**有*/
    private BooleanProperty bwbs_y;
    /**无*/
    private BooleanProperty bwbs_w;
    /**不需要*/
    private BooleanProperty bwbs_bxy;
    /**清醒*/
    private BooleanProperty szqx;
    /**模糊*/
    private BooleanProperty szmh;
    /**嗜睡*/
    private BooleanProperty szss;
    /**谵妄*/
    private BooleanProperty szzw;
    /**昏睡*/
    private BooleanProperty szhs;
    /**昏迷*/
    private BooleanProperty szhm;
    /**完成*/
    private BooleanProperty sqyz_wc;
    /**未完成*/
    private BooleanProperty sqyz_wwc;
    /***/
    private BooleanProperty dxb;
    /***/
    private BooleanProperty yczsp;
    /**无*/
    private BooleanProperty yc_w;
    /**有（见背面）*/
    private BooleanProperty yc_y;
    /**无*/
    private BooleanProperty gd_w;
    /**尿管*/
    private BooleanProperty ng;
    /**胃管*/
    private BooleanProperty wg;
    /**氧管*/
    private BooleanProperty yg;
    /**引流管*/
    private BooleanProperty ylg;
    /**通畅*/
    private BooleanProperty tc;
    /**不通畅*/
    private BooleanProperty btc;
    /**病历*/
    private BooleanProperty wybl;
    /**无*/
    private BooleanProperty yxzl_w;
    /**有*/
    private BooleanProperty yxzl_y;
    /**无*/
    private BooleanProperty px_w;
    /**有*/
    private BooleanProperty px_y;
    /**领血证*/
    private BooleanProperty px_lxz;
    /**血液*/
    private BooleanProperty xy;
    /**无*/
    private BooleanProperty yp_w;
    /**有:见医嘱*/
    private BooleanProperty yp_y;
    /**其他物品*/
    private BooleanProperty qtwp;
    /**无*/
    private BooleanProperty zdy_w;
    /**有*/
    private BooleanProperty zdy_y;
    /**有*/
    private BooleanProperty wdbs_y2;
    /**无*/
    private BooleanProperty wdbs_n2;
    /**麻醉状态*/
    private BooleanProperty mzzt2;
    /**清醒*/
    private BooleanProperty szqx2;
    /**模糊*/
    private BooleanProperty szmh2;
    /**嗜睡*/
    private BooleanProperty szss2;
    /**谵妄*/
    private BooleanProperty szzw2;
    /**昏睡*/
    private BooleanProperty szhs2;
    /**昏迷*/
    private BooleanProperty szhm2;
    /**清洁干燥*/
    private BooleanProperty skfl_qj;
    /**渗出*/
    private BooleanProperty skfl_sc;
    /**无*/
    private BooleanProperty gd_w2;
    /**尿管*/
    private BooleanProperty ng2;
    /**胃管*/
    private BooleanProperty wg2;
    /**氧管*/
    private BooleanProperty yg2;
    /**引流管*/
    private BooleanProperty ylg2;
    /**通畅*/
    private BooleanProperty tc2;
    /**不通畅*/
    private BooleanProperty btc2;
    /**无*/
    private BooleanProperty gdbs_w;
    /**有*/
    private BooleanProperty gdbs_y;
    /**通畅*/
    private BooleanProperty tc3;
    /**不通畅*/
    private BooleanProperty btc3;
    /**无*/
    private BooleanProperty ztb_w;
    /**有*/
    private BooleanProperty ztw_y;
    /**无*/
    private BooleanProperty yc_w2;
    /**有（见背面）*/
    private BooleanProperty yc_y2;
    /**病历*/
    private BooleanProperty wpyp_bl;
    /**药品*/
    private BooleanProperty wpyp_yp;
    /**血液*/
    private BooleanProperty xy2;
    /**无*/
    private BooleanProperty yxzl_w2;
    /**有*/
    private BooleanProperty yxzl_y2;
    /**其他物品：*/
    private BooleanProperty qtwp2;
    /**有*/
    private BooleanProperty wdbs_y3;
    /**无*/
    private BooleanProperty wdbs_n3;
    /**麻醉状态*/
    private BooleanProperty mzzt3;
    /**清醒*/
    private BooleanProperty szqx3;
    /**模糊*/
    private BooleanProperty szmh3;
    /**嗜睡*/
    private BooleanProperty szss3;
    /**谵妄*/
    private BooleanProperty szzw3;
    /**昏睡*/
    private BooleanProperty szhs3;
    /**昏迷*/
    private BooleanProperty szhm3;
    /**清洁干燥*/
    private BooleanProperty skfl_qj2;
    /**渗出*/
    private BooleanProperty skfl_sc2;
    /**无*/
    private BooleanProperty gd_w3;
    /**尿管*/
    private BooleanProperty ng3;
    /**胃管*/
    private BooleanProperty wg3;
    /**氧管*/
    private BooleanProperty yg3;
    /**引流管*/
    private BooleanProperty ylg3;
    /**通畅*/
    private BooleanProperty tc4;
    /**不通畅*/
    private BooleanProperty btc4;
    /**无*/
    private BooleanProperty gdbs_w2;
    /**有*/
    private BooleanProperty gdbs_y2;
    /**通畅*/
    private BooleanProperty tc5;
    /**不通畅*/
    private BooleanProperty btc5;
    /**无*/
    private BooleanProperty ztb_w2;
    /**有*/
    private BooleanProperty ztw_y2;
    /**无*/
    private BooleanProperty yc_w3;
    /**有（见背面）*/
    private BooleanProperty yc_y3;
    /**病历*/
    private BooleanProperty wpyp_bl2;
    /**药品*/
    private BooleanProperty wpyp_yp2;
    /**血液*/
    private BooleanProperty xy3;
    /**无*/
    private BooleanProperty yxzl_w3;
    /**有*/
    private BooleanProperty yxzl_y3;
    /**其他物品：*/
    private BooleanProperty qtwp3;
    /**有*/
    private BooleanProperty wdbs_y4;
    /**无*/
    private BooleanProperty wdbs_n4;
    /**麻醉状态*/
    private BooleanProperty mzzt4;
    /**清醒*/
    private BooleanProperty szqx4;
    /**模糊*/
    private BooleanProperty szmh4;
    /**嗜睡*/
    private BooleanProperty szss4;
    /**谵妄*/
    private BooleanProperty szzw4;
    /**昏睡*/
    private BooleanProperty szhs4;
    /**昏迷*/
    private BooleanProperty szhm4;
    /**清洁干燥*/
    private BooleanProperty skfl_qj4;
    /**渗出*/
    private BooleanProperty skfl_sc4;
    /**无*/
    private BooleanProperty gd_w4;
    /**尿管*/
    private BooleanProperty ng4;
    /**胃管*/
    private BooleanProperty wg4;
    /**氧管*/
    private BooleanProperty yg4;
    /**引流管*/
    private BooleanProperty ylg4;
    /**通畅*/
    private BooleanProperty tc6;
    /**不通畅*/
    private BooleanProperty btc6;
    /**无*/
    private BooleanProperty gdbs_w3;
    /**有*/
    private BooleanProperty gdbs_y3;
    /**通畅*/
    private BooleanProperty tc7;
    /**不通畅*/
    private BooleanProperty btc7;
    /**无*/
    private BooleanProperty ztb_w3;
    /**有*/
    private BooleanProperty ztw_y3;
    /**无*/
    private BooleanProperty yc_w4;
    /**有（见背面）*/
    private BooleanProperty yc_y4;
    /**病历*/
    private BooleanProperty wpyp_bl3;
    /**药品*/
    private BooleanProperty wpyp_yp3;
    /**血液*/
    private BooleanProperty xy4;
    /**无*/
    private BooleanProperty yxzl_w4;
    /**有*/
    private BooleanProperty yxzl_y4;
    /**其他物品：*/
    private BooleanProperty qtwp4;
    /**有*/
    private BooleanProperty wdbs_y5;
    /**无*/
    private BooleanProperty wdbs_n5;
    /**麻醉状态*/
    private BooleanProperty mzzt5;
    /**清醒*/
    private BooleanProperty szqx5;
    /**模糊*/
    private BooleanProperty szmh5;
    /**嗜睡*/
    private BooleanProperty szss5;
    /**谵妄*/
    private BooleanProperty szzw5;
    /**昏睡*/
    private BooleanProperty szhs5;
    /**昏迷*/
    private BooleanProperty szhm5;
    /**清洁干燥*/
    private BooleanProperty skfl_qj5;
    /**渗出*/
    private BooleanProperty skfl_sc5;
    /**无*/
    private BooleanProperty gd_w5;
    /**尿管*/
    private BooleanProperty ng5;
    /**胃管*/
    private BooleanProperty wg5;
    /**氧管*/
    private BooleanProperty yg5;
    /**引流管*/
    private BooleanProperty ylg5;
    /**通畅*/
    private BooleanProperty tc8;
    /**不通畅*/
    private BooleanProperty btc8;
    /**无*/
    private BooleanProperty gdbs_w5;
    /**有*/
    private BooleanProperty gdbs_y5;
    /**通畅*/
    private BooleanProperty tc9;
    /**不通畅*/
    private BooleanProperty btc9;
    /**无*/
    private BooleanProperty ztb_w5;
    /**有*/
    private BooleanProperty ztw_y5;
    /**无*/
    private BooleanProperty yc_w5;
    /**有（见背面）*/
    private BooleanProperty yc_y5;
    /**病历*/
    private BooleanProperty wpyp_bl5;
    /**药品*/
    private BooleanProperty wpyp_yp5;
    /**血液*/
    private BooleanProperty xy5;
    /**无*/
    private BooleanProperty yxzl_w5;
    /**有*/
    private BooleanProperty yxzl_y5;
    /**其他物品：*/
    private BooleanProperty qtwp5;
    //
    private  BooleanProperty ssbf;
    private  BooleanProperty hfbf;

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
    /**拟行手术名称:*/
    private StringProperty nsss1;
    /**手术日期*/
    private StringProperty ssrq;
    /**3.T*/
    private StringProperty tw;
    /**P*/
    private StringProperty mb;
    /**R*/
    private StringProperty hx;
    /**体重*/
    private StringProperty tz;
    /**BP*/
    private StringProperty bp1;
    /***/
    private StringProperty bp2;
    /**引流管*/
    private StringProperty ylgt;
    /**病历*/
    private StringProperty bl;
    /**血型*/
    private StringProperty xx;
    /**品种*/
    private StringProperty pz;
    /**血量*/
    private StringProperty xl;
    /**12.其他*/
    private StringProperty qt;
    /**交接时间*/
    private StringProperty jjsj;
    /**交班者*/
    private StringProperty jiaobz;
    /**接班时间*/
    private StringProperty jbsj;
    /**接管者*/
    private StringProperty jiebz;
    /**2.麻醉方式*/
    private StringProperty mzfs;
    /**3.手术名称*/
    private StringProperty nnssmc;
    /**引流管*/
    private StringProperty ylgt2;
    /**7.静脉置管部位*/
    private StringProperty jmzgbw;
    /**8.滴注液体名称*/
    private StringProperty dzmc;
    /**血型*/
    private StringProperty xx2;
    /**品种*/
    private StringProperty pz2;
    /**血量*/
    private StringProperty xl2;
    /**其他物品*/
    private StringProperty qtwpt;
    /**交接时间*/
    private StringProperty jjsj2;
    /**交班者*/
    private StringProperty jiaobz2;
    /**接管者*/
    private StringProperty jiebz2;
    /**引流管*/
    private StringProperty ylgt3;
    /**7.静脉置管部位*/
    private StringProperty jmzgbw2;
    /**8.滴注液体名称*/
    private StringProperty dzmc2;
    /**血型*/
    private StringProperty xx3;
    /**品种*/
    private StringProperty pz3;
    /**血量*/
    private StringProperty xl3;
    /**其他物品*/
    private StringProperty qtwpt3;
    /**交接时间*/
    private StringProperty jjsj3;
    /**交班者*/
    private StringProperty jiaobz3;
    /**接管者*/
    private StringProperty jiebz3;
    /**引流管*/
    private StringProperty ylgt4;
    /**7.静脉置管部位*/
    private StringProperty jmzgbw3;
    /**8.滴注液体名称*/
    private StringProperty dzmc3;
    /**血型*/
    private StringProperty xx4;
    /**品种*/
    private StringProperty pz4;
    /**血量*/
    private StringProperty xl4;
    /**其他物品*/
    private StringProperty qtwpt4;
    /**交接时间*/
    private StringProperty jjsj4;
    /**交班者*/
    private StringProperty jiaobz4;
    /**接管者*/
    private StringProperty jiebz4;
    /**引流管*/
    private StringProperty ylgt5;
    /**7.静脉置管部位*/
    private StringProperty jmzgbw5;
    /**8.滴注液体名称*/
    private StringProperty dzmc5;
    /**血型*/
    private StringProperty xx5;
    /**品种*/
    private StringProperty pz5;
    /**血量*/
    private StringProperty xl5;
    /**其他物品*/
    private StringProperty qtwpt5;
    /**交接时间*/
    private StringProperty jjsj5;
    /**交班者*/
    private StringProperty jiaobz5;
    /**接管者*/
    private StringProperty jiebz5;

    public boolean isSsbf() {
        return ssbf.get();
    }

    public BooleanProperty ssbfProperty() {
        if(ssbf==null){
            ssbf=new SimpleBooleanProperty();
        }
        return ssbf;
    }

    public void setSsbf(boolean ssbf) {
        this.ssbf.set(ssbf);
    }

    public boolean isHfbf() {
        return hfbf.get();
    }

    public BooleanProperty hfbfProperty() {
        if(hfbf==null){
            hfbf=new SimpleBooleanProperty();
        }
        return hfbf;
    }

    public void setHfbf(boolean hfbf) {
        this.hfbf.set(hfbf);
    }

    public boolean isWdbs_y() {
        return wdbs_y.get();
    }
    public BooleanProperty wdbs_yProperty() {
        if(wdbs_y==null){
            wdbs_y = new SimpleBooleanProperty(false);
        }
        return wdbs_y;
    }
    public void setWdbs_y(boolean wdbs_y) {
        this.wdbs_y.set(wdbs_y);
    }
    public boolean isWdbs_n() {
        return wdbs_n.get();
    }
    public BooleanProperty wdbs_nProperty() {
        if(wdbs_n==null){
            wdbs_n = new SimpleBooleanProperty(false);
        }
        return wdbs_n;
    }
    public void setWdbs_n(boolean wdbs_n) {
        this.wdbs_n.set(wdbs_n);
    }
    public boolean isBwbs_y() {
        return bwbs_y.get();
    }
    public BooleanProperty bwbs_yProperty() {
        if(bwbs_y==null){
            bwbs_y = new SimpleBooleanProperty(false);
        }
        return bwbs_y;
    }
    public void setBwbs_y(boolean bwbs_y) {
        this.bwbs_y.set(bwbs_y);
    }
    public boolean isBwbs_w() {
        return bwbs_w.get();
    }
    public BooleanProperty bwbs_wProperty() {
        if(bwbs_w==null){
            bwbs_w = new SimpleBooleanProperty(false);
        }
        return bwbs_w;
    }
    public void setBwbs_w(boolean bwbs_w) {
        this.bwbs_w.set(bwbs_w);
    }
    public boolean isBwbs_bxy() {
        return bwbs_bxy.get();
    }
    public BooleanProperty bwbs_bxyProperty() {
        if(bwbs_bxy==null){
            bwbs_bxy = new SimpleBooleanProperty(false);
        }
        return bwbs_bxy;
    }
    public void setBwbs_bxy(boolean bwbs_bxy) {
        this.bwbs_bxy.set(bwbs_bxy);
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
    public boolean isSzmh() {
        return szmh.get();
    }
    public BooleanProperty szmhProperty() {
        if(szmh==null){
            szmh = new SimpleBooleanProperty(false);
        }
        return szmh;
    }
    public void setSzmh(boolean szmh) {
        this.szmh.set(szmh);
    }
    public boolean isSzss() {
        return szss.get();
    }
    public BooleanProperty szssProperty() {
        if(szss==null){
            szss = new SimpleBooleanProperty(false);
        }
        return szss;
    }
    public void setSzss(boolean szss) {
        this.szss.set(szss);
    }
    public boolean isSzzw() {
        return szzw.get();
    }
    public BooleanProperty szzwProperty() {
        if(szzw==null){
            szzw = new SimpleBooleanProperty(false);
        }
        return szzw;
    }
    public void setSzzw(boolean szzw) {
        this.szzw.set(szzw);
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
    public boolean isSqyz_wc() {
        return sqyz_wc.get();
    }
    public BooleanProperty sqyz_wcProperty() {
        if(sqyz_wc==null){
            sqyz_wc = new SimpleBooleanProperty(false);
        }
        return sqyz_wc;
    }
    public void setSqyz_wc(boolean sqyz_wc) {
        this.sqyz_wc.set(sqyz_wc);
    }
    public boolean isSqyz_wwc() {
        return sqyz_wwc.get();
    }
    public BooleanProperty sqyz_wwcProperty() {
        if(sqyz_wwc==null){
            sqyz_wwc = new SimpleBooleanProperty(false);
        }
        return sqyz_wwc;
    }
    public void setSqyz_wwc(boolean sqyz_wwc) {
        this.sqyz_wwc.set(sqyz_wwc);
    }
    public boolean isDxb() {
        return dxb.get();
    }
    public BooleanProperty dxbProperty() {
        if(dxb==null){
            dxb = new SimpleBooleanProperty(false);
        }
        return dxb;
    }
    public void setDxb(boolean dxb) {
        this.dxb.set(dxb);
    }
    public boolean isYczsp() {
        return yczsp.get();
    }
    public BooleanProperty yczspProperty() {
        if(yczsp==null){
            yczsp = new SimpleBooleanProperty(false);
        }
        return yczsp;
    }
    public void setYczsp(boolean yczsp) {
        this.yczsp.set(yczsp);
    }
    public boolean isYc_w() {
        return yc_w.get();
    }
    public BooleanProperty yc_wProperty() {
        if(yc_w==null){
            yc_w = new SimpleBooleanProperty(false);
        }
        return yc_w;
    }
    public void setYc_w(boolean yc_w) {
        this.yc_w.set(yc_w);
    }
    public boolean isYc_y() {
        return yc_y.get();
    }
    public BooleanProperty yc_yProperty() {
        if(yc_y==null){
            yc_y = new SimpleBooleanProperty(false);
        }
        return yc_y;
    }
    public void setYc_y(boolean yc_y) {
        this.yc_y.set(yc_y);
    }
    public boolean isGd_w() {
        return gd_w.get();
    }
    public BooleanProperty gd_wProperty() {
        if(gd_w==null){
            gd_w = new SimpleBooleanProperty(false);
        }
        return gd_w;
    }
    public void setGd_w(boolean gd_w) {
        this.gd_w.set(gd_w);
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
    public boolean isYg() {
        return yg.get();
    }
    public BooleanProperty ygProperty() {
        if(yg==null){
            yg = new SimpleBooleanProperty(false);
        }
        return yg;
    }
    public void setYg(boolean yg) {
        this.yg.set(yg);
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
    public boolean isBtc() {
        return btc.get();
    }
    public BooleanProperty btcProperty() {
        if(btc==null){
            btc = new SimpleBooleanProperty(false);
        }
        return btc;
    }
    public void setBtc(boolean btc) {
        this.btc.set(btc);
    }
    public boolean isWybl() {
        return wybl.get();
    }
    public BooleanProperty wyblProperty() {
        if(wybl==null){
            wybl = new SimpleBooleanProperty(false);
        }
        return wybl;
    }
    public void setWybl(boolean wybl) {
        this.wybl.set(wybl);
    }
    public boolean isYxzl_w() {
        return yxzl_w.get();
    }
    public BooleanProperty yxzl_wProperty() {
        if(yxzl_w==null){
            yxzl_w = new SimpleBooleanProperty(false);
        }
        return yxzl_w;
    }
    public void setYxzl_w(boolean yxzl_w) {
        this.yxzl_w.set(yxzl_w);
    }
    public boolean isYxzl_y() {
        return yxzl_y.get();
    }
    public BooleanProperty yxzl_yProperty() {
        if(yxzl_y==null){
            yxzl_y = new SimpleBooleanProperty(false);
        }
        return yxzl_y;
    }
    public void setYxzl_y(boolean yxzl_y) {
        this.yxzl_y.set(yxzl_y);
    }
    public boolean isPx_w() {
        return px_w.get();
    }
    public BooleanProperty px_wProperty() {
        if(px_w==null){
            px_w = new SimpleBooleanProperty(false);
        }
        return px_w;
    }
    public void setPx_w(boolean px_w) {
        this.px_w.set(px_w);
    }
    public boolean isPx_y() {
        return px_y.get();
    }
    public BooleanProperty px_yProperty() {
        if(px_y==null){
            px_y = new SimpleBooleanProperty(false);
        }
        return px_y;
    }
    public void setPx_y(boolean px_y) {
        this.px_y.set(px_y);
    }
    public boolean isPx_lxz() {
        return px_lxz.get();
    }
    public BooleanProperty px_lxzProperty() {
        if(px_lxz==null){
            px_lxz = new SimpleBooleanProperty(false);
        }
        return px_lxz;
    }
    public void setPx_lxz(boolean px_lxz) {
        this.px_lxz.set(px_lxz);
    }
    public boolean isXy() {
        return xy.get();
    }
    public BooleanProperty xyProperty() {
        if(xy==null){
            xy = new SimpleBooleanProperty(false);
        }
        return xy;
    }
    public void setXy(boolean xy) {
        this.xy.set(xy);
    }
    public boolean isYp_w() {
        return yp_w.get();
    }
    public BooleanProperty yp_wProperty() {
        if(yp_w==null){
            yp_w = new SimpleBooleanProperty(false);
        }
        return yp_w;
    }
    public void setYp_w(boolean yp_w) {
        this.yp_w.set(yp_w);
    }
    public boolean isYp_y() {
        return yp_y.get();
    }
    public BooleanProperty yp_yProperty() {
        if(yp_y==null){
            yp_y = new SimpleBooleanProperty(false);
        }
        return yp_y;
    }
    public void setYp_y(boolean yp_y) {
        this.yp_y.set(yp_y);
    }
    public boolean isQtwp() {
        return qtwp.get();
    }
    public BooleanProperty qtwpProperty() {
        if(qtwp==null){
            qtwp = new SimpleBooleanProperty(false);
        }
        return qtwp;
    }
    public void setQtwp(boolean qtwp) {
        this.qtwp.set(qtwp);
    }
    public boolean isZdy_w() {
        return zdy_w.get();
    }
    public BooleanProperty zdy_wProperty() {
        if(zdy_w==null){
            zdy_w = new SimpleBooleanProperty(false);
        }
        return zdy_w;
    }
    public void setZdy_w(boolean zdy_w) {
        this.zdy_w.set(zdy_w);
    }
    public boolean isZdy_y() {
        return zdy_y.get();
    }
    public BooleanProperty zdy_yProperty() {
        if(zdy_y==null){
            zdy_y = new SimpleBooleanProperty(false);
        }
        return zdy_y;
    }
    public void setZdy_y(boolean zdy_y) {
        this.zdy_y.set(zdy_y);
    }
    public boolean isWdbs_y2() {
        return wdbs_y2.get();
    }
    public BooleanProperty wdbs_y2Property() {
        if(wdbs_y2==null){
            wdbs_y2 = new SimpleBooleanProperty(false);
        }
        return wdbs_y2;
    }
    public void setWdbs_y2(boolean wdbs_y2) {
        this.wdbs_y2.set(wdbs_y2);
    }
    public boolean isWdbs_n2() {
        return wdbs_n2.get();
    }
    public BooleanProperty wdbs_n2Property() {
        if(wdbs_n2==null){
            wdbs_n2 = new SimpleBooleanProperty(false);
        }
        return wdbs_n2;
    }
    public void setWdbs_n2(boolean wdbs_n2) {
        this.wdbs_n2.set(wdbs_n2);
    }
    public boolean isMzzt2() {
        return mzzt2.get();
    }
    public BooleanProperty mzzt2Property() {
        if(mzzt2==null){
            mzzt2 = new SimpleBooleanProperty(false);
        }
        return mzzt2;
    }
    public void setMzzt2(boolean mzzt2) {
        this.mzzt2.set(mzzt2);
    }
    public boolean isSzqx2() {
        return szqx2.get();
    }
    public BooleanProperty szqx2Property() {
        if(szqx2==null){
            szqx2 = new SimpleBooleanProperty(false);
        }
        return szqx2;
    }
    public void setSzqx2(boolean szqx2) {
        this.szqx2.set(szqx2);
    }
    public boolean isSzmh2() {
        return szmh2.get();
    }
    public BooleanProperty szmh2Property() {
        if(szmh2==null){
            szmh2 = new SimpleBooleanProperty(false);
        }
        return szmh2;
    }
    public void setSzmh2(boolean szmh2) {
        this.szmh2.set(szmh2);
    }
    public boolean isSzss2() {
        return szss2.get();
    }
    public BooleanProperty szss2Property() {
        if(szss2==null){
            szss2 = new SimpleBooleanProperty(false);
        }
        return szss2;
    }
    public void setSzss2(boolean szss2) {
        this.szss2.set(szss2);
    }
    public boolean isSzzw2() {
        return szzw2.get();
    }
    public BooleanProperty szzw2Property() {
        if(szzw2==null){
            szzw2 = new SimpleBooleanProperty(false);
        }
        return szzw2;
    }
    public void setSzzw2(boolean szzw2) {
        this.szzw2.set(szzw2);
    }
    public boolean isSzhs2() {
        return szhs2.get();
    }
    public BooleanProperty szhs2Property() {
        if(szhs2==null){
            szhs2 = new SimpleBooleanProperty(false);
        }
        return szhs2;
    }
    public void setSzhs2(boolean szhs2) {
        this.szhs2.set(szhs2);
    }
    public boolean isSzhm2() {
        return szhm2.get();
    }
    public BooleanProperty szhm2Property() {
        if(szhm2==null){
            szhm2 = new SimpleBooleanProperty(false);
        }
        return szhm2;
    }
    public void setSzhm2(boolean szhm2) {
        this.szhm2.set(szhm2);
    }
    public boolean isSkfl_qj() {
        return skfl_qj.get();
    }
    public BooleanProperty skfl_qjProperty() {
        if(skfl_qj==null){
            skfl_qj = new SimpleBooleanProperty(false);
        }
        return skfl_qj;
    }
    public void setSkfl_qj(boolean skfl_qj) {
        this.skfl_qj.set(skfl_qj);
    }
    public boolean isSkfl_sc() {
        return skfl_sc.get();
    }
    public BooleanProperty skfl_scProperty() {
        if(skfl_sc==null){
            skfl_sc = new SimpleBooleanProperty(false);
        }
        return skfl_sc;
    }
    public void setSkfl_sc(boolean skfl_sc) {
        this.skfl_sc.set(skfl_sc);
    }
    public boolean isGd_w2() {
        return gd_w2.get();
    }
    public BooleanProperty gd_w2Property() {
        if(gd_w2==null){
            gd_w2 = new SimpleBooleanProperty(false);
        }
        return gd_w2;
    }
    public void setGd_w2(boolean gd_w2) {
        this.gd_w2.set(gd_w2);
    }
    public boolean isNg2() {
        return ng2.get();
    }
    public BooleanProperty ng2Property() {
        if(ng2==null){
            ng2 = new SimpleBooleanProperty(false);
        }
        return ng2;
    }
    public void setNg2(boolean ng2) {
        this.ng2.set(ng2);
    }
    public boolean isWg2() {
        return wg2.get();
    }
    public BooleanProperty wg2Property() {
        if(wg2==null){
            wg2 = new SimpleBooleanProperty(false);
        }
        return wg2;
    }
    public void setWg2(boolean wg2) {
        this.wg2.set(wg2);
    }
    public boolean isYg2() {
        return yg2.get();
    }
    public BooleanProperty yg2Property() {
        if(yg2==null){
            yg2 = new SimpleBooleanProperty(false);
        }
        return yg2;
    }
    public void setYg2(boolean yg2) {
        this.yg2.set(yg2);
    }
    public boolean isYlg2() {
        return ylg2.get();
    }
    public BooleanProperty ylg2Property() {
        if(ylg2==null){
            ylg2 = new SimpleBooleanProperty(false);
        }
        return ylg2;
    }
    public void setYlg2(boolean ylg2) {
        this.ylg2.set(ylg2);
    }
    public boolean isTc2() {
        return tc2.get();
    }
    public BooleanProperty tc2Property() {
        if(tc2==null){
            tc2 = new SimpleBooleanProperty(false);
        }
        return tc2;
    }
    public void setTc2(boolean tc2) {
        this.tc2.set(tc2);
    }
    public boolean isBtc2() {
        return btc2.get();
    }
    public BooleanProperty btc2Property() {
        if(btc2==null){
            btc2 = new SimpleBooleanProperty(false);
        }
        return btc2;
    }
    public void setBtc2(boolean btc2) {
        this.btc2.set(btc2);
    }
    public boolean isGdbs_w() {
        return gdbs_w.get();
    }
    public BooleanProperty gdbs_wProperty() {
        if(gdbs_w==null){
            gdbs_w = new SimpleBooleanProperty(false);
        }
        return gdbs_w;
    }
    public void setGdbs_w(boolean gdbs_w) {
        this.gdbs_w.set(gdbs_w);
    }
    public boolean isGdbs_y() {
        return gdbs_y.get();
    }
    public BooleanProperty gdbs_yProperty() {
        if(gdbs_y==null){
            gdbs_y = new SimpleBooleanProperty(false);
        }
        return gdbs_y;
    }
    public void setGdbs_y(boolean gdbs_y) {
        this.gdbs_y.set(gdbs_y);
    }
    public boolean isTc3() {
        return tc3.get();
    }
    public BooleanProperty tc3Property() {
        if(tc3==null){
            tc3 = new SimpleBooleanProperty(false);
        }
        return tc3;
    }
    public void setTc3(boolean tc3) {
        this.tc3.set(tc3);
    }
    public boolean isBtc3() {
        return btc3.get();
    }
    public BooleanProperty btc3Property() {
        if(btc3==null){
            btc3 = new SimpleBooleanProperty(false);
        }
        return btc3;
    }
    public void setBtc3(boolean btc3) {
        this.btc3.set(btc3);
    }
    public boolean isZtb_w() {
        return ztb_w.get();
    }
    public BooleanProperty ztb_wProperty() {
        if(ztb_w==null){
            ztb_w = new SimpleBooleanProperty(false);
        }
        return ztb_w;
    }
    public void setZtb_w(boolean ztb_w) {
        this.ztb_w.set(ztb_w);
    }
    public boolean isZtw_y() {
        return ztw_y.get();
    }
    public BooleanProperty ztw_yProperty() {
        if(ztw_y==null){
            ztw_y = new SimpleBooleanProperty(false);
        }
        return ztw_y;
    }
    public void setZtw_y(boolean ztw_y) {
        this.ztw_y.set(ztw_y);
    }
    public boolean isYc_w2() {
        return yc_w2.get();
    }
    public BooleanProperty yc_w2Property() {
        if(yc_w2==null){
            yc_w2 = new SimpleBooleanProperty(false);
        }
        return yc_w2;
    }
    public void setYc_w2(boolean yc_w2) {
        this.yc_w2.set(yc_w2);
    }
    public boolean isYc_y2() {
        return yc_y2.get();
    }
    public BooleanProperty yc_y2Property() {
        if(yc_y2==null){
            yc_y2 = new SimpleBooleanProperty(false);
        }
        return yc_y2;
    }
    public void setYc_y2(boolean yc_y2) {
        this.yc_y2.set(yc_y2);
    }
    public boolean isWpyp_bl() {
        return wpyp_bl.get();
    }
    public BooleanProperty wpyp_blProperty() {
        if(wpyp_bl==null){
            wpyp_bl = new SimpleBooleanProperty(false);
        }
        return wpyp_bl;
    }
    public void setWpyp_bl(boolean wpyp_bl) {
        this.wpyp_bl.set(wpyp_bl);
    }
    public boolean isWpyp_yp() {
        return wpyp_yp.get();
    }
    public BooleanProperty wpyp_ypProperty() {
        if(wpyp_yp==null){
            wpyp_yp = new SimpleBooleanProperty(false);
        }
        return wpyp_yp;
    }
    public void setWpyp_yp(boolean wpyp_yp) {
        this.wpyp_yp.set(wpyp_yp);
    }
    public boolean isXy2() {
        return xy2.get();
    }
    public BooleanProperty xy2Property() {
        if(xy2==null){
            xy2 = new SimpleBooleanProperty(false);
        }
        return xy2;
    }
    public void setXy2(boolean xy2) {
        this.xy2.set(xy2);
    }
    public boolean isYxzl_w2() {
        return yxzl_w2.get();
    }
    public BooleanProperty yxzl_w2Property() {
        if(yxzl_w2==null){
            yxzl_w2 = new SimpleBooleanProperty(false);
        }
        return yxzl_w2;
    }
    public void setYxzl_w2(boolean yxzl_w2) {
        this.yxzl_w2.set(yxzl_w2);
    }
    public boolean isYxzl_y2() {
        return yxzl_y2.get();
    }
    public BooleanProperty yxzl_y2Property() {
        if(yxzl_y2==null){
            yxzl_y2 = new SimpleBooleanProperty(false);
        }
        return yxzl_y2;
    }
    public void setYxzl_y2(boolean yxzl_y2) {
        this.yxzl_y2.set(yxzl_y2);
    }
    public boolean isQtwp2() {
        return qtwp2.get();
    }
    public BooleanProperty qtwp2Property() {
        if(qtwp2==null){
            qtwp2 = new SimpleBooleanProperty(false);
        }
        return qtwp2;
    }
    public void setQtwp2(boolean qtwp2) {
        this.qtwp2.set(qtwp2);
    }
    public boolean isWdbs_y3() {
        return wdbs_y3.get();
    }
    public BooleanProperty wdbs_y3Property() {
        if(wdbs_y3==null){
            wdbs_y3 = new SimpleBooleanProperty(false);
        }
        return wdbs_y3;
    }
    public void setWdbs_y3(boolean wdbs_y3) {
        this.wdbs_y3.set(wdbs_y3);
    }
    public boolean isWdbs_n3() {
        return wdbs_n3.get();
    }
    public BooleanProperty wdbs_n3Property() {
        if(wdbs_n3==null){
            wdbs_n3 = new SimpleBooleanProperty(false);
        }
        return wdbs_n3;
    }
    public void setWdbs_n3(boolean wdbs_n3) {
        this.wdbs_n3.set(wdbs_n3);
    }
    public boolean isMzzt3() {
        return mzzt3.get();
    }
    public BooleanProperty mzzt3Property() {
        if(mzzt3==null){
            mzzt3 = new SimpleBooleanProperty(false);
        }
        return mzzt3;
    }
    public void setMzzt3(boolean mzzt3) {
        this.mzzt3.set(mzzt3);
    }
    public boolean isSzqx3() {
        return szqx3.get();
    }
    public BooleanProperty szqx3Property() {
        if(szqx3==null){
            szqx3 = new SimpleBooleanProperty(false);
        }
        return szqx3;
    }
    public void setSzqx3(boolean szqx3) {
        this.szqx3.set(szqx3);
    }
    public boolean isSzmh3() {
        return szmh3.get();
    }
    public BooleanProperty szmh3Property() {
        if(szmh3==null){
            szmh3 = new SimpleBooleanProperty(false);
        }
        return szmh3;
    }
    public void setSzmh3(boolean szmh3) {
        this.szmh3.set(szmh3);
    }
    public boolean isSzss3() {
        return szss3.get();
    }
    public BooleanProperty szss3Property() {
        if(szss3==null){
            szss3 = new SimpleBooleanProperty(false);
        }
        return szss3;
    }
    public void setSzss3(boolean szss3) {
        this.szss3.set(szss3);
    }
    public boolean isSzzw3() {
        return szzw3.get();
    }
    public BooleanProperty szzw3Property() {
        if(szzw3==null){
            szzw3 = new SimpleBooleanProperty(false);
        }
        return szzw3;
    }
    public void setSzzw3(boolean szzw3) {
        this.szzw3.set(szzw3);
    }
    public boolean isSzhs3() {
        return szhs3.get();
    }
    public BooleanProperty szhs3Property() {
        if(szhs3==null){
            szhs3 = new SimpleBooleanProperty(false);
        }
        return szhs3;
    }
    public void setSzhs3(boolean szhs3) {
        this.szhs3.set(szhs3);
    }
    public boolean isSzhm3() {
        return szhm3.get();
    }
    public BooleanProperty szhm3Property() {
        if(szhm3==null){
            szhm3 = new SimpleBooleanProperty(false);
        }
        return szhm3;
    }
    public void setSzhm3(boolean szhm3) {
        this.szhm3.set(szhm3);
    }
    public boolean isSkfl_qj2() {
        return skfl_qj2.get();
    }
    public BooleanProperty skfl_qj2Property() {
        if(skfl_qj2==null){
            skfl_qj2 = new SimpleBooleanProperty(false);
        }
        return skfl_qj2;
    }
    public void setSkfl_qj2(boolean skfl_qj2) {
        this.skfl_qj2.set(skfl_qj2);
    }
    public boolean isSkfl_sc2() {
        return skfl_sc2.get();
    }
    public BooleanProperty skfl_sc2Property() {
        if(skfl_sc2==null){
            skfl_sc2 = new SimpleBooleanProperty(false);
        }
        return skfl_sc2;
    }
    public void setSkfl_sc2(boolean skfl_sc2) {
        this.skfl_sc2.set(skfl_sc2);
    }
    public boolean isGd_w3() {
        return gd_w3.get();
    }
    public BooleanProperty gd_w3Property() {
        if(gd_w3==null){
            gd_w3 = new SimpleBooleanProperty(false);
        }
        return gd_w3;
    }
    public void setGd_w3(boolean gd_w3) {
        this.gd_w3.set(gd_w3);
    }
    public boolean isNg3() {
        return ng3.get();
    }
    public BooleanProperty ng3Property() {
        if(ng3==null){
            ng3 = new SimpleBooleanProperty(false);
        }
        return ng3;
    }
    public void setNg3(boolean ng3) {
        this.ng3.set(ng3);
    }
    public boolean isWg3() {
        return wg3.get();
    }
    public BooleanProperty wg3Property() {
        if(wg3==null){
            wg3 = new SimpleBooleanProperty(false);
        }
        return wg3;
    }
    public void setWg3(boolean wg3) {
        this.wg3.set(wg3);
    }
    public boolean isYg3() {
        return yg3.get();
    }
    public BooleanProperty yg3Property() {
        if(yg3==null){
            yg3 = new SimpleBooleanProperty(false);
        }
        return yg3;
    }
    public void setYg3(boolean yg3) {
        this.yg3.set(yg3);
    }
    public boolean isYlg3() {
        return ylg3.get();
    }
    public BooleanProperty ylg3Property() {
        if(ylg3==null){
            ylg3 = new SimpleBooleanProperty(false);
        }
        return ylg3;
    }
    public void setYlg3(boolean ylg3) {
        this.ylg3.set(ylg3);
    }
    public boolean isTc4() {
        return tc4.get();
    }
    public BooleanProperty tc4Property() {
        if(tc4==null){
            tc4 = new SimpleBooleanProperty(false);
        }
        return tc4;
    }
    public void setTc4(boolean tc4) {
        this.tc4.set(tc4);
    }
    public boolean isBtc4() {
        return btc4.get();
    }
    public BooleanProperty btc4Property() {
        if(btc4==null){
            btc4 = new SimpleBooleanProperty(false);
        }
        return btc4;
    }
    public void setBtc4(boolean btc4) {
        this.btc4.set(btc4);
    }
    public boolean isGdbs_w2() {
        return gdbs_w2.get();
    }
    public BooleanProperty gdbs_w2Property() {
        if(gdbs_w2==null){
            gdbs_w2 = new SimpleBooleanProperty(false);
        }
        return gdbs_w2;
    }
    public void setGdbs_w2(boolean gdbs_w2) {
        this.gdbs_w2.set(gdbs_w2);
    }
    public boolean isGdbs_y2() {
        return gdbs_y2.get();
    }
    public BooleanProperty gdbs_y2Property() {
        if(gdbs_y2==null){
            gdbs_y2 = new SimpleBooleanProperty(false);
        }
        return gdbs_y2;
    }
    public void setGdbs_y2(boolean gdbs_y2) {
        this.gdbs_y2.set(gdbs_y2);
    }
    public boolean isTc5() {
        return tc5.get();
    }
    public BooleanProperty tc5Property() {
        if(tc5==null){
            tc5 = new SimpleBooleanProperty(false);
        }
        return tc5;
    }
    public void setTc5(boolean tc5) {
        this.tc5.set(tc5);
    }
    public boolean isBtc5() {
        return btc5.get();
    }
    public BooleanProperty btc5Property() {
        if(btc5==null){
            btc5 = new SimpleBooleanProperty(false);
        }
        return btc5;
    }
    public void setBtc5(boolean btc5) {
        this.btc5.set(btc5);
    }
    public boolean isZtb_w2() {
        return ztb_w2.get();
    }
    public BooleanProperty ztb_w2Property() {
        if(ztb_w2==null){
            ztb_w2 = new SimpleBooleanProperty(false);
        }
        return ztb_w2;
    }
    public void setZtb_w2(boolean ztb_w2) {
        this.ztb_w2.set(ztb_w2);
    }
    public boolean isZtw_y2() {
        return ztw_y2.get();
    }
    public BooleanProperty ztw_y2Property() {
        if(ztw_y2==null){
            ztw_y2 = new SimpleBooleanProperty(false);
        }
        return ztw_y2;
    }
    public void setZtw_y2(boolean ztw_y2) {
        this.ztw_y2.set(ztw_y2);
    }
    public boolean isYc_w3() {
        return yc_w3.get();
    }
    public BooleanProperty yc_w3Property() {
        if(yc_w3==null){
            yc_w3 = new SimpleBooleanProperty(false);
        }
        return yc_w3;
    }
    public void setYc_w3(boolean yc_w3) {
        this.yc_w3.set(yc_w3);
    }
    public boolean isYc_y3() {
        return yc_y3.get();
    }
    public BooleanProperty yc_y3Property() {
        if(yc_y3==null){
            yc_y3 = new SimpleBooleanProperty(false);
        }
        return yc_y3;
    }
    public void setYc_y3(boolean yc_y3) {
        this.yc_y3.set(yc_y3);
    }
    public boolean isWpyp_bl2() {
        return wpyp_bl2.get();
    }
    public BooleanProperty wpyp_bl2Property() {
        if(wpyp_bl2==null){
            wpyp_bl2 = new SimpleBooleanProperty(false);
        }
        return wpyp_bl2;
    }
    public void setWpyp_bl2(boolean wpyp_bl2) {
        this.wpyp_bl2.set(wpyp_bl2);
    }
    public boolean isWpyp_yp2() {
        return wpyp_yp2.get();
    }
    public BooleanProperty wpyp_yp2Property() {
        if(wpyp_yp2==null){
            wpyp_yp2 = new SimpleBooleanProperty(false);
        }
        return wpyp_yp2;
    }
    public void setWpyp_yp2(boolean wpyp_yp2) {
        this.wpyp_yp2.set(wpyp_yp2);
    }
    public boolean isXy3() {
        return xy3.get();
    }
    public BooleanProperty xy3Property() {
        if(xy3==null){
            xy3 = new SimpleBooleanProperty(false);
        }
        return xy3;
    }
    public void setXy3(boolean xy3) {
        this.xy3.set(xy3);
    }
    public boolean isYxzl_w3() {
        return yxzl_w3.get();
    }
    public BooleanProperty yxzl_w3Property() {
        if(yxzl_w3==null){
            yxzl_w3 = new SimpleBooleanProperty(false);
        }
        return yxzl_w3;
    }
    public void setYxzl_w3(boolean yxzl_w3) {
        this.yxzl_w3.set(yxzl_w3);
    }
    public boolean isYxzl_y3() {
        return yxzl_y3.get();
    }
    public BooleanProperty yxzl_y3Property() {
        if(yxzl_y3==null){
            yxzl_y3 = new SimpleBooleanProperty(false);
        }
        return yxzl_y3;
    }
    public void setYxzl_y3(boolean yxzl_y3) {
        this.yxzl_y3.set(yxzl_y3);
    }
    public boolean isQtwp3() {
        return qtwp3.get();
    }
    public BooleanProperty qtwp3Property() {
        if(qtwp3==null){
            qtwp3 = new SimpleBooleanProperty(false);
        }
        return qtwp3;
    }
    public void setQtwp3(boolean qtwp3) {
        this.qtwp3.set(qtwp3);
    }
    public boolean isWdbs_y4() {
        return wdbs_y4.get();
    }
    public BooleanProperty wdbs_y4Property() {
        if(wdbs_y4==null){
            wdbs_y4 = new SimpleBooleanProperty(false);
        }
        return wdbs_y4;
    }
    public void setWdbs_y4(boolean wdbs_y4) {
        this.wdbs_y4.set(wdbs_y4);
    }
    public boolean isWdbs_n4() {
        return wdbs_n4.get();
    }
    public BooleanProperty wdbs_n4Property() {
        if(wdbs_n4==null){
            wdbs_n4 = new SimpleBooleanProperty(false);
        }
        return wdbs_n4;
    }
    public void setWdbs_n4(boolean wdbs_n4) {
        this.wdbs_n4.set(wdbs_n4);
    }
    public boolean isMzzt4() {
        return mzzt4.get();
    }
    public BooleanProperty mzzt4Property() {
        if(mzzt4==null){
            mzzt4 = new SimpleBooleanProperty(false);
        }
        return mzzt4;
    }
    public void setMzzt4(boolean mzzt4) {
        this.mzzt4.set(mzzt4);
    }
    public boolean isSzqx4() {
        return szqx4.get();
    }
    public BooleanProperty szqx4Property() {
        if(szqx4==null){
            szqx4 = new SimpleBooleanProperty(false);
        }
        return szqx4;
    }
    public void setSzqx4(boolean szqx4) {
        this.szqx4.set(szqx4);
    }
    public boolean isSzmh4() {
        return szmh4.get();
    }
    public BooleanProperty szmh4Property() {
        if(szmh4==null){
            szmh4 = new SimpleBooleanProperty(false);
        }
        return szmh4;
    }
    public void setSzmh4(boolean szmh4) {
        this.szmh4.set(szmh4);
    }
    public boolean isSzss4() {
        return szss4.get();
    }
    public BooleanProperty szss4Property() {
        if(szss4==null){
            szss4 = new SimpleBooleanProperty(false);
        }
        return szss4;
    }
    public void setSzss4(boolean szss4) {
        this.szss4.set(szss4);
    }
    public boolean isSzzw4() {
        return szzw4.get();
    }
    public BooleanProperty szzw4Property() {
        if(szzw4==null){
            szzw4 = new SimpleBooleanProperty(false);
        }
        return szzw4;
    }
    public void setSzzw4(boolean szzw4) {
        this.szzw4.set(szzw4);
    }
    public boolean isSzhs4() {
        return szhs4.get();
    }
    public BooleanProperty szhs4Property() {
        if(szhs4==null){
            szhs4 = new SimpleBooleanProperty(false);
        }
        return szhs4;
    }
    public void setSzhs4(boolean szhs4) {
        this.szhs4.set(szhs4);
    }
    public boolean isSzhm4() {
        return szhm4.get();
    }
    public BooleanProperty szhm4Property() {
        if(szhm4==null){
            szhm4 = new SimpleBooleanProperty(false);
        }
        return szhm4;
    }
    public void setSzhm4(boolean szhm4) {
        this.szhm4.set(szhm4);
    }
    public boolean isSkfl_qj4() {
        return skfl_qj4.get();
    }
    public BooleanProperty skfl_qj4Property() {
        if(skfl_qj4==null){
            skfl_qj4 = new SimpleBooleanProperty(false);
        }
        return skfl_qj4;
    }
    public void setSkfl_qj4(boolean skfl_qj4) {
        this.skfl_qj4.set(skfl_qj4);
    }
    public boolean isSkfl_sc4() {
        return skfl_sc4.get();
    }
    public BooleanProperty skfl_sc4Property() {
        if(skfl_sc4==null){
            skfl_sc4 = new SimpleBooleanProperty(false);
        }
        return skfl_sc4;
    }
    public void setSkfl_sc4(boolean skfl_sc4) {
        this.skfl_sc4.set(skfl_sc4);
    }
    public boolean isGd_w4() {
        return gd_w4.get();
    }
    public BooleanProperty gd_w4Property() {
        if(gd_w4==null){
            gd_w4 = new SimpleBooleanProperty(false);
        }
        return gd_w4;
    }
    public void setGd_w4(boolean gd_w4) {
        this.gd_w4.set(gd_w4);
    }
    public boolean isNg4() {
        return ng4.get();
    }
    public BooleanProperty ng4Property() {
        if(ng4==null){
            ng4 = new SimpleBooleanProperty(false);
        }
        return ng4;
    }
    public void setNg4(boolean ng4) {
        this.ng4.set(ng4);
    }
    public boolean isWg4() {
        return wg4.get();
    }
    public BooleanProperty wg4Property() {
        if(wg4==null){
            wg4 = new SimpleBooleanProperty(false);
        }
        return wg4;
    }
    public void setWg4(boolean wg4) {
        this.wg4.set(wg4);
    }
    public boolean isYg4() {
        return yg4.get();
    }
    public BooleanProperty yg4Property() {
        if(yg4==null){
            yg4 = new SimpleBooleanProperty(false);
        }
        return yg4;
    }
    public void setYg4(boolean yg4) {
        this.yg4.set(yg4);
    }
    public boolean isYlg4() {
        return ylg4.get();
    }
    public BooleanProperty ylg4Property() {
        if(ylg4==null){
            ylg4 = new SimpleBooleanProperty(false);
        }
        return ylg4;
    }
    public void setYlg4(boolean ylg4) {
        this.ylg4.set(ylg4);
    }
    public boolean isTc6() {
        return tc6.get();
    }
    public BooleanProperty tc6Property() {
        if(tc6==null){
            tc6 = new SimpleBooleanProperty(false);
        }
        return tc6;
    }
    public void setTc6(boolean tc6) {
        this.tc6.set(tc6);
    }
    public boolean isBtc6() {
        return btc6.get();
    }
    public BooleanProperty btc6Property() {
        if(btc6==null){
            btc6 = new SimpleBooleanProperty(false);
        }
        return btc6;
    }
    public void setBtc6(boolean btc6) {
        this.btc6.set(btc6);
    }
    public boolean isGdbs_w3() {
        return gdbs_w3.get();
    }
    public BooleanProperty gdbs_w3Property() {
        if(gdbs_w3==null){
            gdbs_w3 = new SimpleBooleanProperty(false);
        }
        return gdbs_w3;
    }
    public void setGdbs_w3(boolean gdbs_w3) {
        this.gdbs_w3.set(gdbs_w3);
    }
    public boolean isGdbs_y3() {
        return gdbs_y3.get();
    }
    public BooleanProperty gdbs_y3Property() {
        if(gdbs_y3==null){
            gdbs_y3 = new SimpleBooleanProperty(false);
        }
        return gdbs_y3;
    }
    public void setGdbs_y3(boolean gdbs_y3) {
        this.gdbs_y3.set(gdbs_y3);
    }
    public boolean isTc7() {
        return tc7.get();
    }
    public BooleanProperty tc7Property() {
        if(tc7==null){
            tc7 = new SimpleBooleanProperty(false);
        }
        return tc7;
    }
    public void setTc7(boolean tc7) {
        this.tc7.set(tc7);
    }
    public boolean isBtc7() {
        return btc7.get();
    }
    public BooleanProperty btc7Property() {
        if(btc7==null){
            btc7 = new SimpleBooleanProperty(false);
        }
        return btc7;
    }
    public void setBtc7(boolean btc7) {
        this.btc7.set(btc7);
    }
    public boolean isZtb_w3() {
        return ztb_w3.get();
    }
    public BooleanProperty ztb_w3Property() {
        if(ztb_w3==null){
            ztb_w3 = new SimpleBooleanProperty(false);
        }
        return ztb_w3;
    }
    public void setZtb_w3(boolean ztb_w3) {
        this.ztb_w3.set(ztb_w3);
    }
    public boolean isZtw_y3() {
        return ztw_y3.get();
    }
    public BooleanProperty ztw_y3Property() {
        if(ztw_y3==null){
            ztw_y3 = new SimpleBooleanProperty(false);
        }
        return ztw_y3;
    }
    public void setZtw_y3(boolean ztw_y3) {
        this.ztw_y3.set(ztw_y3);
    }
    public boolean isYc_w4() {
        return yc_w4.get();
    }
    public BooleanProperty yc_w4Property() {
        if(yc_w4==null){
            yc_w4 = new SimpleBooleanProperty(false);
        }
        return yc_w4;
    }
    public void setYc_w4(boolean yc_w4) {
        this.yc_w4.set(yc_w4);
    }
    public boolean isYc_y4() {
        return yc_y4.get();
    }
    public BooleanProperty yc_y4Property() {
        if(yc_y4==null){
            yc_y4 = new SimpleBooleanProperty(false);
        }
        return yc_y4;
    }
    public void setYc_y4(boolean yc_y4) {
        this.yc_y4.set(yc_y4);
    }
    public boolean isWpyp_bl3() {
        return wpyp_bl3.get();
    }
    public BooleanProperty wpyp_bl3Property() {
        if(wpyp_bl3==null){
            wpyp_bl3 = new SimpleBooleanProperty(false);
        }
        return wpyp_bl3;
    }
    public void setWpyp_bl3(boolean wpyp_bl3) {
        this.wpyp_bl3.set(wpyp_bl3);
    }
    public boolean isWpyp_yp3() {
        return wpyp_yp3.get();
    }
    public BooleanProperty wpyp_yp3Property() {
        if(wpyp_yp3==null){
            wpyp_yp3 = new SimpleBooleanProperty(false);
        }
        return wpyp_yp3;
    }
    public void setWpyp_yp3(boolean wpyp_yp3) {
        this.wpyp_yp3.set(wpyp_yp3);
    }
    public boolean isXy4() {
        return xy4.get();
    }
    public BooleanProperty xy4Property() {
        if(xy4==null){
            xy4 = new SimpleBooleanProperty(false);
        }
        return xy4;
    }
    public void setXy4(boolean xy4) {
        this.xy4.set(xy4);
    }
    public boolean isYxzl_w4() {
        return yxzl_w4.get();
    }
    public BooleanProperty yxzl_w4Property() {
        if(yxzl_w4==null){
            yxzl_w4 = new SimpleBooleanProperty(false);
        }
        return yxzl_w4;
    }
    public void setYxzl_w4(boolean yxzl_w4) {
        this.yxzl_w4.set(yxzl_w4);
    }
    public boolean isYxzl_y4() {
        return yxzl_y4.get();
    }
    public BooleanProperty yxzl_y4Property() {
        if(yxzl_y4==null){
            yxzl_y4 = new SimpleBooleanProperty(false);
        }
        return yxzl_y4;
    }
    public void setYxzl_y4(boolean yxzl_y4) {
        this.yxzl_y4.set(yxzl_y4);
    }
    public boolean isQtwp4() {
        return qtwp4.get();
    }
    public BooleanProperty qtwp4Property() {
        if(qtwp4==null){
            qtwp4 = new SimpleBooleanProperty(false);
        }
        return qtwp4;
    }
    public void setQtwp4(boolean qtwp4) {
        this.qtwp4.set(qtwp4);
    }
    public boolean isWdbs_y5() {
        return wdbs_y5.get();
    }
    public BooleanProperty wdbs_y5Property() {
        if(wdbs_y5==null){
            wdbs_y5 = new SimpleBooleanProperty(false);
        }
        return wdbs_y5;
    }
    public void setWdbs_y5(boolean wdbs_y5) {
        this.wdbs_y5.set(wdbs_y5);
    }
    public boolean isWdbs_n5() {
        return wdbs_n5.get();
    }
    public BooleanProperty wdbs_n5Property() {
        if(wdbs_n5==null){
            wdbs_n5 = new SimpleBooleanProperty(false);
        }
        return wdbs_n5;
    }
    public void setWdbs_n5(boolean wdbs_n5) {
        this.wdbs_n5.set(wdbs_n5);
    }
    public boolean isMzzt5() {
        return mzzt5.get();
    }
    public BooleanProperty mzzt5Property() {
        if(mzzt5==null){
            mzzt5 = new SimpleBooleanProperty(false);
        }
        return mzzt5;
    }
    public void setMzzt5(boolean mzzt5) {
        this.mzzt5.set(mzzt5);
    }
    public boolean isSzqx5() {
        return szqx5.get();
    }
    public BooleanProperty szqx5Property() {
        if(szqx5==null){
            szqx5 = new SimpleBooleanProperty(false);
        }
        return szqx5;
    }
    public void setSzqx5(boolean szqx5) {
        this.szqx5.set(szqx5);
    }
    public boolean isSzmh5() {
        return szmh5.get();
    }
    public BooleanProperty szmh5Property() {
        if(szmh5==null){
            szmh5 = new SimpleBooleanProperty(false);
        }
        return szmh5;
    }
    public void setSzmh5(boolean szmh5) {
        this.szmh5.set(szmh5);
    }
    public boolean isSzss5() {
        return szss5.get();
    }
    public BooleanProperty szss5Property() {
        if(szss5==null){
            szss5 = new SimpleBooleanProperty(false);
        }
        return szss5;
    }
    public void setSzss5(boolean szss5) {
        this.szss5.set(szss5);
    }
    public boolean isSzzw5() {
        return szzw5.get();
    }
    public BooleanProperty szzw5Property() {
        if(szzw5==null){
            szzw5 = new SimpleBooleanProperty(false);
        }
        return szzw5;
    }
    public void setSzzw5(boolean szzw5) {
        this.szzw5.set(szzw5);
    }
    public boolean isSzhs5() {
        return szhs5.get();
    }
    public BooleanProperty szhs5Property() {
        if(szhs5==null){
            szhs5 = new SimpleBooleanProperty(false);
        }
        return szhs5;
    }
    public void setSzhs5(boolean szhs5) {
        this.szhs5.set(szhs5);
    }
    public boolean isSzhm5() {
        return szhm5.get();
    }
    public BooleanProperty szhm5Property() {
        if(szhm5==null){
            szhm5 = new SimpleBooleanProperty(false);
        }
        return szhm5;
    }
    public void setSzhm5(boolean szhm5) {
        this.szhm5.set(szhm5);
    }
    public boolean isSkfl_qj5() {
        return skfl_qj5.get();
    }
    public BooleanProperty skfl_qj5Property() {
        if(skfl_qj5==null){
            skfl_qj5 = new SimpleBooleanProperty(false);
        }
        return skfl_qj5;
    }
    public void setSkfl_qj5(boolean skfl_qj5) {
        this.skfl_qj5.set(skfl_qj5);
    }
    public boolean isSkfl_sc5() {
        return skfl_sc5.get();
    }
    public BooleanProperty skfl_sc5Property() {
        if(skfl_sc5==null){
            skfl_sc5 = new SimpleBooleanProperty(false);
        }
        return skfl_sc5;
    }
    public void setSkfl_sc5(boolean skfl_sc5) {
        this.skfl_sc5.set(skfl_sc5);
    }
    public boolean isGd_w5() {
        return gd_w5.get();
    }
    public BooleanProperty gd_w5Property() {
        if(gd_w5==null){
            gd_w5 = new SimpleBooleanProperty(false);
        }
        return gd_w5;
    }
    public void setGd_w5(boolean gd_w5) {
        this.gd_w5.set(gd_w5);
    }
    public boolean isNg5() {
        return ng5.get();
    }
    public BooleanProperty ng5Property() {
        if(ng5==null){
            ng5 = new SimpleBooleanProperty(false);
        }
        return ng5;
    }
    public void setNg5(boolean ng5) {
        this.ng5.set(ng5);
    }
    public boolean isWg5() {
        return wg5.get();
    }
    public BooleanProperty wg5Property() {
        if(wg5==null){
            wg5 = new SimpleBooleanProperty(false);
        }
        return wg5;
    }
    public void setWg5(boolean wg5) {
        this.wg5.set(wg5);
    }
    public boolean isYg5() {
        return yg5.get();
    }
    public BooleanProperty yg5Property() {
        if(yg5==null){
            yg5 = new SimpleBooleanProperty(false);
        }
        return yg5;
    }
    public void setYg5(boolean yg5) {
        this.yg5.set(yg5);
    }
    public boolean isYlg5() {
        return ylg5.get();
    }
    public BooleanProperty ylg5Property() {
        if(ylg5==null){
            ylg5 = new SimpleBooleanProperty(false);
        }
        return ylg5;
    }
    public void setYlg5(boolean ylg5) {
        this.ylg5.set(ylg5);
    }
    public boolean isTc8() {
        return tc8.get();
    }
    public BooleanProperty tc8Property() {
        if(tc8==null){
            tc8 = new SimpleBooleanProperty(false);
        }
        return tc8;
    }
    public void setTc8(boolean tc8) {
        this.tc8.set(tc8);
    }
    public boolean isBtc8() {
        return btc8.get();
    }
    public BooleanProperty btc8Property() {
        if(btc8==null){
            btc8 = new SimpleBooleanProperty(false);
        }
        return btc8;
    }
    public void setBtc8(boolean btc8) {
        this.btc8.set(btc8);
    }
    public boolean isGdbs_w5() {
        return gdbs_w5.get();
    }
    public BooleanProperty gdbs_w5Property() {
        if(gdbs_w5==null){
            gdbs_w5 = new SimpleBooleanProperty(false);
        }
        return gdbs_w5;
    }
    public void setGdbs_w5(boolean gdbs_w5) {
        this.gdbs_w5.set(gdbs_w5);
    }
    public boolean isGdbs_y5() {
        return gdbs_y5.get();
    }
    public BooleanProperty gdbs_y5Property() {
        if(gdbs_y5==null){
            gdbs_y5 = new SimpleBooleanProperty(false);
        }
        return gdbs_y5;
    }
    public void setGdbs_y5(boolean gdbs_y5) {
        this.gdbs_y5.set(gdbs_y5);
    }
    public boolean isTc9() {
        return tc9.get();
    }
    public BooleanProperty tc9Property() {
        if(tc9==null){
            tc9 = new SimpleBooleanProperty(false);
        }
        return tc9;
    }
    public void setTc9(boolean tc9) {
        this.tc9.set(tc9);
    }
    public boolean isBtc9() {
        return btc9.get();
    }
    public BooleanProperty btc9Property() {
        if(btc9==null){
            btc9 = new SimpleBooleanProperty(false);
        }
        return btc9;
    }
    public void setBtc9(boolean btc9) {
        this.btc9.set(btc9);
    }
    public boolean isZtb_w5() {
        return ztb_w5.get();
    }
    public BooleanProperty ztb_w5Property() {
        if(ztb_w5==null){
            ztb_w5 = new SimpleBooleanProperty(false);
        }
        return ztb_w5;
    }
    public void setZtb_w5(boolean ztb_w5) {
        this.ztb_w5.set(ztb_w5);
    }
    public boolean isZtw_y5() {
        return ztw_y5.get();
    }
    public BooleanProperty ztw_y5Property() {
        if(ztw_y5==null){
            ztw_y5 = new SimpleBooleanProperty(false);
        }
        return ztw_y5;
    }
    public void setZtw_y5(boolean ztw_y5) {
        this.ztw_y5.set(ztw_y5);
    }
    public boolean isYc_w5() {
        return yc_w5.get();
    }
    public BooleanProperty yc_w5Property() {
        if(yc_w5==null){
            yc_w5 = new SimpleBooleanProperty(false);
        }
        return yc_w5;
    }
    public void setYc_w5(boolean yc_w5) {
        this.yc_w5.set(yc_w5);
    }
    public boolean isYc_y5() {
        return yc_y5.get();
    }
    public BooleanProperty yc_y5Property() {
        if(yc_y5==null){
            yc_y5 = new SimpleBooleanProperty(false);
        }
        return yc_y5;
    }
    public void setYc_y5(boolean yc_y5) {
        this.yc_y5.set(yc_y5);
    }
    public boolean isWpyp_bl5() {
        return wpyp_bl5.get();
    }
    public BooleanProperty wpyp_bl5Property() {
        if(wpyp_bl5==null){
            wpyp_bl5 = new SimpleBooleanProperty(false);
        }
        return wpyp_bl5;
    }
    public void setWpyp_bl5(boolean wpyp_bl5) {
        this.wpyp_bl5.set(wpyp_bl5);
    }
    public boolean isWpyp_yp5() {
        return wpyp_yp5.get();
    }
    public BooleanProperty wpyp_yp5Property() {
        if(wpyp_yp5==null){
            wpyp_yp5 = new SimpleBooleanProperty(false);
        }
        return wpyp_yp5;
    }
    public void setWpyp_yp5(boolean wpyp_yp5) {
        this.wpyp_yp5.set(wpyp_yp5);
    }
    public boolean isXy5() {
        return xy5.get();
    }
    public BooleanProperty xy5Property() {
        if(xy5==null){
            xy5 = new SimpleBooleanProperty(false);
        }
        return xy5;
    }
    public void setXy5(boolean xy5) {
        this.xy5.set(xy5);
    }
    public boolean isYxzl_w5() {
        return yxzl_w5.get();
    }
    public BooleanProperty yxzl_w5Property() {
        if(yxzl_w5==null){
            yxzl_w5 = new SimpleBooleanProperty(false);
        }
        return yxzl_w5;
    }
    public void setYxzl_w5(boolean yxzl_w5) {
        this.yxzl_w5.set(yxzl_w5);
    }
    public boolean isYxzl_y5() {
        return yxzl_y5.get();
    }
    public BooleanProperty yxzl_y5Property() {
        if(yxzl_y5==null){
            yxzl_y5 = new SimpleBooleanProperty(false);
        }
        return yxzl_y5;
    }
    public void setYxzl_y5(boolean yxzl_y5) {
        this.yxzl_y5.set(yxzl_y5);
    }
    public boolean isQtwp5() {
        return qtwp5.get();
    }
    public BooleanProperty qtwp5Property() {
        if(qtwp5==null){
            qtwp5 = new SimpleBooleanProperty(false);
        }
        return qtwp5;
    }
    public void setQtwp5(boolean qtwp5) {
        this.qtwp5.set(qtwp5);
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
    public String getSsrq() {
        return ssrq.get();
    }
    public StringProperty ssrqProperty() {
        if(ssrq==null){
            ssrq = new SimpleStringProperty();
        }
        return ssrq;
    }
    public void setSsrq(String ssrq) {
        this.ssrq.set(ssrq);
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
    public String getYlgt() {
        return ylgt.get();
    }
    public StringProperty ylgtProperty() {
        if(ylgt==null){
            ylgt = new SimpleStringProperty();
        }
        return ylgt;
    }
    public void setYlgt(String ylgt) {
        this.ylgt.set(ylgt);
    }
    public String getBl() {
        return bl.get();
    }
    public StringProperty blProperty() {
        if(bl==null){
            bl = new SimpleStringProperty();
        }
        return bl;
    }
    public void setBl(String bl) {
        this.bl.set(bl);
    }
    public String getXx() {
        return xx.get();
    }
    public StringProperty xxProperty() {
        if(xx==null){
            xx = new SimpleStringProperty();
        }
        return xx;
    }
    public void setXx(String xx) {
        this.xx.set(xx);
    }
    public String getPz() {
        return pz.get();
    }
    public StringProperty pzProperty() {
        if(pz==null){
            pz = new SimpleStringProperty();
        }
        return pz;
    }
    public void setPz(String pz) {
        this.pz.set(pz);
    }
    public String getXl() {
        return xl.get();
    }
    public StringProperty xlProperty() {
        if(xl==null){
            xl = new SimpleStringProperty();
        }
        return xl;
    }
    public void setXl(String xl) {
        this.xl.set(xl);
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
    public String getJjsj() {
        return jjsj.get();
    }
    public StringProperty jjsjProperty() {
        if(jjsj==null){
            jjsj = new SimpleStringProperty();
        }
        return jjsj;
    }
    public void setJjsj(String jjsj) {
        this.jjsj.set(jjsj);
    }
    public String getJiaobz() {
        return jiaobz.get();
    }
    public StringProperty jiaobzProperty() {
        if(jiaobz==null){
            jiaobz = new SimpleStringProperty();
        }
        return jiaobz;
    }
    public void setJiaobz(String jiaobz) {
        this.jiaobz.set(jiaobz);
    }
    public String getJbsj() {
        return jbsj.get();
    }
    public StringProperty jbsjProperty() {
        if(jbsj==null){
            jbsj = new SimpleStringProperty();
        }
        return jbsj;
    }
    public void setJbsj(String jbsj) {
        this.jbsj.set(jbsj);
    }
    public String getJiebz() {
        return jiebz.get();
    }
    public StringProperty jiebzProperty() {
        if(jiebz==null){
            jiebz = new SimpleStringProperty();
        }
        return jiebz;
    }
    public void setJiebz(String jiebz) {
        this.jiebz.set(jiebz);
    }
    public String getMzfs() {
        return mzfs.get();
    }
    public StringProperty mzfsProperty() {
        if(mzfs==null){
            mzfs = new SimpleStringProperty();
        }
        return mzfs;
    }
    public void setMzfs(String mzfs) {
        this.mzfs.set(mzfs);
    }
    public String getNnssmc() {
        return nnssmc.get();
    }
    public StringProperty nnssmcProperty() {
        if(nnssmc==null){
            nnssmc = new SimpleStringProperty();
        }
        return nnssmc;
    }
    public void setNnssmc(String nnssmc) {
        this.nnssmc.set(nnssmc);
    }
    public String getYlgt2() {
        return ylgt2.get();
    }
    public StringProperty ylgt2Property() {
        if(ylgt2==null){
            ylgt2 = new SimpleStringProperty();
        }
        return ylgt2;
    }
    public void setYlgt2(String ylgt2) {
        this.ylgt2.set(ylgt2);
    }
    public String getJmzgbw() {
        return jmzgbw.get();
    }
    public StringProperty jmzgbwProperty() {
        if(jmzgbw==null){
            jmzgbw = new SimpleStringProperty();
        }
        return jmzgbw;
    }
    public void setJmzgbw(String jmzgbw) {
        this.jmzgbw.set(jmzgbw);
    }
    public String getDzmc() {
        return dzmc.get();
    }
    public StringProperty dzmcProperty() {
        if(dzmc==null){
            dzmc = new SimpleStringProperty();
        }
        return dzmc;
    }
    public void setDzmc(String dzmc) {
        this.dzmc.set(dzmc);
    }
    public String getXx2() {
        return xx2.get();
    }
    public StringProperty xx2Property() {
        if(xx2==null){
            xx2 = new SimpleStringProperty();
        }
        return xx2;
    }
    public void setXx2(String xx2) {
        this.xx2.set(xx2);
    }
    public String getPz2() {
        return pz2.get();
    }
    public StringProperty pz2Property() {
        if(pz2==null){
            pz2 = new SimpleStringProperty();
        }
        return pz2;
    }
    public void setPz2(String pz2) {
        this.pz2.set(pz2);
    }
    public String getXl2() {
        return xl2.get();
    }
    public StringProperty xl2Property() {
        if(xl2==null){
            xl2 = new SimpleStringProperty();
        }
        return xl2;
    }
    public void setXl2(String xl2) {
        this.xl2.set(xl2);
    }
    public String getQtwpt() {
        return qtwpt.get();
    }
    public StringProperty qtwptProperty() {
        if(qtwpt==null){
            qtwpt = new SimpleStringProperty();
        }
        return qtwpt;
    }
    public void setQtwpt(String qtwpt) {
        this.qtwpt.set(qtwpt);
    }
    public String getJjsj2() {
        return jjsj2.get();
    }
    public StringProperty jjsj2Property() {
        if(jjsj2==null){
            jjsj2 = new SimpleStringProperty();
        }
        return jjsj2;
    }
    public void setJjsj2(String jjsj2) {
        this.jjsj2.set(jjsj2);
    }
    public String getJiaobz2() {
        return jiaobz2.get();
    }
    public StringProperty jiaobz2Property() {
        if(jiaobz2==null){
            jiaobz2 = new SimpleStringProperty();
        }
        return jiaobz2;
    }
    public void setJiaobz2(String jiaobz2) {
        this.jiaobz2.set(jiaobz2);
    }
    public String getJiebz2() {
        return jiebz2.get();
    }
    public StringProperty jiebz2Property() {
        if(jiebz2==null){
            jiebz2 = new SimpleStringProperty();
        }
        return jiebz2;
    }
    public void setJiebz2(String jiebz2) {
        this.jiebz2.set(jiebz2);
    }
    public String getYlgt3() {
        return ylgt3.get();
    }
    public StringProperty ylgt3Property() {
        if(ylgt3==null){
            ylgt3 = new SimpleStringProperty();
        }
        return ylgt3;
    }
    public void setYlgt3(String ylgt3) {
        this.ylgt3.set(ylgt3);
    }
    public String getJmzgbw2() {
        return jmzgbw2.get();
    }
    public StringProperty jmzgbw2Property() {
        if(jmzgbw2==null){
            jmzgbw2 = new SimpleStringProperty();
        }
        return jmzgbw2;
    }
    public void setJmzgbw2(String jmzgbw2) {
        this.jmzgbw2.set(jmzgbw2);
    }
    public String getDzmc2() {
        return dzmc2.get();
    }
    public StringProperty dzmc2Property() {
        if(dzmc2==null){
            dzmc2 = new SimpleStringProperty();
        }
        return dzmc2;
    }
    public void setDzmc2(String dzmc2) {
        this.dzmc2.set(dzmc2);
    }
    public String getXx3() {
        return xx3.get();
    }
    public StringProperty xx3Property() {
        if(xx3==null){
            xx3 = new SimpleStringProperty();
        }
        return xx3;
    }
    public void setXx3(String xx3) {
        this.xx3.set(xx3);
    }
    public String getPz3() {
        return pz3.get();
    }
    public StringProperty pz3Property() {
        if(pz3==null){
            pz3 = new SimpleStringProperty();
        }
        return pz3;
    }
    public void setPz3(String pz3) {
        this.pz3.set(pz3);
    }
    public String getXl3() {
        return xl3.get();
    }
    public StringProperty xl3Property() {
        if(xl3==null){
            xl3 = new SimpleStringProperty();
        }
        return xl3;
    }
    public void setXl3(String xl3) {
        this.xl3.set(xl3);
    }
    public String getQtwpt3() {
        return qtwpt3.get();
    }
    public StringProperty qtwpt3Property() {
        if(qtwpt3==null){
            qtwpt3 = new SimpleStringProperty();
        }
        return qtwpt3;
    }
    public void setQtwpt3(String qtwpt3) {
        this.qtwpt3.set(qtwpt3);
    }
    public String getJjsj3() {
        return jjsj3.get();
    }
    public StringProperty jjsj3Property() {
        if(jjsj3==null){
            jjsj3 = new SimpleStringProperty();
        }
        return jjsj3;
    }
    public void setJjsj3(String jjsj3) {
        this.jjsj3.set(jjsj3);
    }
    public String getJiaobz3() {
        return jiaobz3.get();
    }
    public StringProperty jiaobz3Property() {
        if(jiaobz3==null){
            jiaobz3 = new SimpleStringProperty();
        }
        return jiaobz3;
    }
    public void setJiaobz3(String jiaobz3) {
        this.jiaobz3.set(jiaobz3);
    }
    public String getJiebz3() {
        return jiebz3.get();
    }
    public StringProperty jiebz3Property() {
        if(jiebz3==null){
            jiebz3 = new SimpleStringProperty();
        }
        return jiebz3;
    }
    public void setJiebz3(String jiebz3) {
        this.jiebz3.set(jiebz3);
    }
    public String getYlgt4() {
        return ylgt4.get();
    }
    public StringProperty ylgt4Property() {
        if(ylgt4==null){
            ylgt4 = new SimpleStringProperty();
        }
        return ylgt4;
    }
    public void setYlgt4(String ylgt4) {
        this.ylgt4.set(ylgt4);
    }
    public String getJmzgbw3() {
        return jmzgbw3.get();
    }
    public StringProperty jmzgbw3Property() {
        if(jmzgbw3==null){
            jmzgbw3 = new SimpleStringProperty();
        }
        return jmzgbw3;
    }
    public void setJmzgbw3(String jmzgbw3) {
        this.jmzgbw3.set(jmzgbw3);
    }
    public String getDzmc3() {
        return dzmc3.get();
    }
    public StringProperty dzmc3Property() {
        if(dzmc3==null){
            dzmc3 = new SimpleStringProperty();
        }
        return dzmc3;
    }
    public void setDzmc3(String dzmc3) {
        this.dzmc3.set(dzmc3);
    }
    public String getXx4() {
        return xx4.get();
    }
    public StringProperty xx4Property() {
        if(xx4==null){
            xx4 = new SimpleStringProperty();
        }
        return xx4;
    }
    public void setXx4(String xx4) {
        this.xx4.set(xx4);
    }
    public String getPz4() {
        return pz4.get();
    }
    public StringProperty pz4Property() {
        if(pz4==null){
            pz4 = new SimpleStringProperty();
        }
        return pz4;
    }
    public void setPz4(String pz4) {
        this.pz4.set(pz4);
    }
    public String getXl4() {
        return xl4.get();
    }
    public StringProperty xl4Property() {
        if(xl4==null){
            xl4 = new SimpleStringProperty();
        }
        return xl4;
    }
    public void setXl4(String xl4) {
        this.xl4.set(xl4);
    }
    public String getQtwpt4() {
        return qtwpt4.get();
    }
    public StringProperty qtwpt4Property() {
        if(qtwpt4==null){
            qtwpt4 = new SimpleStringProperty();
        }
        return qtwpt4;
    }
    public void setQtwpt4(String qtwpt4) {
        this.qtwpt4.set(qtwpt4);
    }
    public String getJjsj4() {
        return jjsj4.get();
    }
    public StringProperty jjsj4Property() {
        if(jjsj4==null){
            jjsj4 = new SimpleStringProperty();
        }
        return jjsj4;
    }
    public void setJjsj4(String jjsj4) {
        this.jjsj4.set(jjsj4);
    }
    public String getJiaobz4() {
        return jiaobz4.get();
    }
    public StringProperty jiaobz4Property() {
        if(jiaobz4==null){
            jiaobz4 = new SimpleStringProperty();
        }
        return jiaobz4;
    }
    public void setJiaobz4(String jiaobz4) {
        this.jiaobz4.set(jiaobz4);
    }
    public String getJiebz4() {
        return jiebz4.get();
    }
    public StringProperty jiebz4Property() {
        if(jiebz4==null){
            jiebz4 = new SimpleStringProperty();
        }
        return jiebz4;
    }
    public void setJiebz4(String jiebz4) {
        this.jiebz4.set(jiebz4);
    }
    public String getYlgt5() {
        return ylgt5.get();
    }
    public StringProperty ylgt5Property() {
        if(ylgt5==null){
            ylgt5 = new SimpleStringProperty();
        }
        return ylgt5;
    }
    public void setYlgt5(String ylgt5) {
        this.ylgt5.set(ylgt5);
    }
    public String getJmzgbw5() {
        return jmzgbw5.get();
    }
    public StringProperty jmzgbw5Property() {
        if(jmzgbw5==null){
            jmzgbw5 = new SimpleStringProperty();
        }
        return jmzgbw5;
    }
    public void setJmzgbw5(String jmzgbw5) {
        this.jmzgbw5.set(jmzgbw5);
    }
    public String getDzmc5() {
        return dzmc5.get();
    }
    public StringProperty dzmc5Property() {
        if(dzmc5==null){
            dzmc5 = new SimpleStringProperty();
        }
        return dzmc5;
    }
    public void setDzmc5(String dzmc5) {
        this.dzmc5.set(dzmc5);
    }
    public String getXx5() {
        return xx5.get();
    }
    public StringProperty xx5Property() {
        if(xx5==null){
            xx5 = new SimpleStringProperty();
        }
        return xx5;
    }
    public void setXx5(String xx5) {
        this.xx5.set(xx5);
    }
    public String getPz5() {
        return pz5.get();
    }
    public StringProperty pz5Property() {
        if(pz5==null){
            pz5 = new SimpleStringProperty();
        }
        return pz5;
    }
    public void setPz5(String pz5) {
        this.pz5.set(pz5);
    }
    public String getXl5() {
        return xl5.get();
    }
    public StringProperty xl5Property() {
        if(xl5==null){
            xl5 = new SimpleStringProperty();
        }
        return xl5;
    }
    public void setXl5(String xl5) {
        this.xl5.set(xl5);
    }
    public String getQtwpt5() {
        return qtwpt5.get();
    }
    public StringProperty qtwpt5Property() {
        if(qtwpt5==null){
            qtwpt5 = new SimpleStringProperty();
        }
        return qtwpt5;
    }
    public void setQtwpt5(String qtwpt5) {
        this.qtwpt5.set(qtwpt5);
    }
    public String getJjsj5() {
        return jjsj5.get();
    }
    public StringProperty jjsj5Property() {
        if(jjsj5==null){
            jjsj5 = new SimpleStringProperty();
        }
        return jjsj5;
    }
    public void setJjsj5(String jjsj5) {
        this.jjsj5.set(jjsj5);
    }
    public String getJiaobz5() {
        return jiaobz5.get();
    }
    public StringProperty jiaobz5Property() {
        if(jiaobz5==null){
            jiaobz5 = new SimpleStringProperty();
        }
        return jiaobz5;
    }
    public void setJiaobz5(String jiaobz5) {
        this.jiaobz5.set(jiaobz5);
    }
    public String getJiebz5() {
        return jiebz5.get();
    }
    public StringProperty jiebz5Property() {
        if(jiebz5==null){
            jiebz5 = new SimpleStringProperty();
        }
        return jiebz5;
    }
    public void setJiebz5(String jiebz5) {
        this.jiebz5.set(jiebz5);
    }

}
