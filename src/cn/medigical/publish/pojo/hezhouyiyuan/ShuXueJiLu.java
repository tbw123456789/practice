package cn.medigical.publish.pojo.hezhouyiyuan;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ShuXueJiLu {
    /**常规*/
    private BooleanProperty sxxz_cg;
    /**术中（麻醉状态）*/
    private BooleanProperty sxxz_sz;
    /**术后*/
    private BooleanProperty sxxz_sh;
    /**紧急*/
    private BooleanProperty sxxz_jj;
    /**大量*/
    private BooleanProperty sxxz_dl;
    /**特殊*/
    private BooleanProperty sxxz_ts;
    /**清醒*/
    private BooleanProperty szqx;
    /**嗜睡*/
    private BooleanProperty szss;
    /**昏迷*/
    private BooleanProperty szhm;
    /**正常*/
    private BooleanProperty swzc;
    /**异常*/
    private BooleanProperty swyc;
    /**正常*/
    private BooleanProperty swzc3;
    /**异常*/
    private BooleanProperty swyc3;
    /**正常*/
    private BooleanProperty swzc4;
    /**异常*/
    private BooleanProperty swyc4;
    /**正常*/
    private BooleanProperty swzc5;
    /**异常*/
    private BooleanProperty swyc5;
    /**正常*/
    private BooleanProperty swzc6;
    /**异常*/
    private BooleanProperty swyc6;
    /**正常*/
    private BooleanProperty swzc7;
    /**异常*/
    private BooleanProperty swyc7;
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
    /**ABO型血:*/
    private StringProperty aboxx;
    /**Rh血型:*/
    private StringProperty rhxx;
    /**供血者编号:*/
    private StringProperty sqzd;
    /**ABO型血:*/
    private StringProperty aboxx2;
    /**Rh血型:*/
    private StringProperty rhxx2;
    /**血液的种类:*/
    private StringProperty xyzl;
    /**规格:*/
    private StringProperty guig;
    /**核对者:*/
    private StringProperty hdz;
    /**输血核对时间:*/
    private StringProperty sxhdsj;
    /**执行者:*/
    private StringProperty zxz;
    /**输血开始时间:*/
    private StringProperty sxkssj;
    /**体温*/
    private StringProperty tw;
    /**脉搏*/
    private StringProperty mb;
    /**呼吸*/
    private StringProperty hx;
    /**血压*/
    private StringProperty xy1;
    /***/
    private StringProperty xyn1;
    /**体温*/
    private StringProperty tw2;
    /**脉搏*/
    private StringProperty mb2;
    /**呼吸*/
    private StringProperty hx2;
    /**血压*/
    private StringProperty xy2;
    /***/
    private StringProperty xyn2;
    /**监测人的姓名*/
    private StringProperty jcrxm;
    /**体温*/
    private StringProperty tw3;
    /**脉搏*/
    private StringProperty mb3;
    /**呼吸*/
    private StringProperty hx3;
    /**血压*/
    private StringProperty xy3;
    /***/
    private StringProperty xyn3;
    /**监测人的姓名*/
    private StringProperty jcrxm3;
    /**体温*/
    private StringProperty tw4;
    /**脉搏*/
    private StringProperty mb4;
    /**呼吸*/
    private StringProperty hx4;
    /**血压*/
    private StringProperty xy4;
    /***/
    private StringProperty xyn4;
    /**监测人的姓名*/
    private StringProperty jcrxm4;
    /**体温*/
    private StringProperty tw5;
    /**脉搏*/
    private StringProperty mb5;
    /**呼吸*/
    private StringProperty hx5;
    /**血压*/
    private StringProperty xy5;
    /***/
    private StringProperty xyn5;
    /**监测人的姓名*/
    private StringProperty jcrxm5;
    /**体温*/
    private StringProperty tw6;
    /**脉搏*/
    private StringProperty mb6;
    /**呼吸*/
    private StringProperty hx6;
    /**血压*/
    private StringProperty xy6;
    /***/
    private StringProperty xyn6;
    /**监测人的姓名*/
    private StringProperty jcrxm6;
    /**体温*/
    private StringProperty tw7;
    /**脉搏*/
    private StringProperty mb7;
    /**呼吸*/
    private StringProperty hx7;
    /**血压*/
    private StringProperty xy7;
    /***/
    private StringProperty xyn7;
    /**监测人的姓名*/
    private StringProperty jcrxm7;
    /**输血结束时间*/
    private StringProperty sxjssj;
    //麻醉状态
    private  BooleanProperty mzzt;

    public void setZyh(String zyh) {
        this.zyh.set(zyh);
    }

    public boolean isMzzt() {
        return mzzt.get();
    }

    public BooleanProperty mzztProperty() {
        if(mzzt==null){
            mzzt=new SimpleBooleanProperty();
        }
        return mzzt;
    }

    public void setMzzt(boolean mzzt) {
        this.mzzt.set(mzzt);
    }

    public boolean isSxxz_cg() {
        return sxxz_cg.get();
    }
    public BooleanProperty sxxz_cgProperty() {
        if(sxxz_cg==null){
            sxxz_cg = new SimpleBooleanProperty(false);
        }
        return sxxz_cg;
    }
    public void setSxxz_cg(boolean sxxz_cg) {
        this.sxxz_cg.set(sxxz_cg);
    }
    public boolean isSxxz_sz() {
        return sxxz_sz.get();
    }
    public BooleanProperty sxxz_szProperty() {
        if(sxxz_sz==null){
            sxxz_sz = new SimpleBooleanProperty(false);
        }
        return sxxz_sz;
    }
    public void setSxxz_sz(boolean sxxz_sz) {
        this.sxxz_sz.set(sxxz_sz);
    }
    public boolean isSxxz_sh() {
        return sxxz_sh.get();
    }
    public BooleanProperty sxxz_shProperty() {
        if(sxxz_sh==null){
            sxxz_sh = new SimpleBooleanProperty(false);
        }
        return sxxz_sh;
    }
    public void setSxxz_sh(boolean sxxz_sh) {
        this.sxxz_sh.set(sxxz_sh);
    }
    public boolean isSxxz_jj() {
        return sxxz_jj.get();
    }
    public BooleanProperty sxxz_jjProperty() {
        if(sxxz_jj==null){
            sxxz_jj = new SimpleBooleanProperty(false);
        }
        return sxxz_jj;
    }
    public void setSxxz_jj(boolean sxxz_jj) {
        this.sxxz_jj.set(sxxz_jj);
    }
    public boolean isSxxz_dl() {
        return sxxz_dl.get();
    }
    public BooleanProperty sxxz_dlProperty() {
        if(sxxz_dl==null){
            sxxz_dl = new SimpleBooleanProperty(false);
        }
        return sxxz_dl;
    }
    public void setSxxz_dl(boolean sxxz_dl) {
        this.sxxz_dl.set(sxxz_dl);
    }
    public boolean isSxxz_ts() {
        return sxxz_ts.get();
    }
    public BooleanProperty sxxz_tsProperty() {
        if(sxxz_ts==null){
            sxxz_ts = new SimpleBooleanProperty(false);
        }
        return sxxz_ts;
    }
    public void setSxxz_ts(boolean sxxz_ts) {
        this.sxxz_ts.set(sxxz_ts);
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
    public boolean isSwzc() {
        return swzc.get();
    }
    public BooleanProperty swzcProperty() {
        if(swzc==null){
            swzc = new SimpleBooleanProperty(false);
        }
        return swzc;
    }
    public void setSwzc(boolean swzc) {
        this.swzc.set(swzc);
    }
    public boolean isSwyc() {
        return swyc.get();
    }
    public BooleanProperty swycProperty() {
        if(swyc==null){
            swyc = new SimpleBooleanProperty(false);
        }
        return swyc;
    }
    public void setSwyc(boolean swyc) {
        this.swyc.set(swyc);
    }
    public boolean isSwzc3() {
        return swzc3.get();
    }
    public BooleanProperty swzc3Property() {
        if(swzc3==null){
            swzc3 = new SimpleBooleanProperty(false);
        }
        return swzc3;
    }
    public void setSwzc3(boolean swzc3) {
        this.swzc3.set(swzc3);
    }
    public boolean isSwyc3() {
        return swyc3.get();
    }
    public BooleanProperty swyc3Property() {
        if(swyc3==null){
            swyc3 = new SimpleBooleanProperty(false);
        }
        return swyc3;
    }
    public void setSwyc3(boolean swyc3) {
        this.swyc3.set(swyc3);
    }
    public boolean isSwzc4() {
        return swzc4.get();
    }
    public BooleanProperty swzc4Property() {
        if(swzc4==null){
            swzc4 = new SimpleBooleanProperty(false);
        }
        return swzc4;
    }
    public void setSwzc4(boolean swzc4) {
        this.swzc4.set(swzc4);
    }
    public boolean isSwyc4() {
        return swyc4.get();
    }
    public BooleanProperty swyc4Property() {
        if(swyc4==null){
            swyc4 = new SimpleBooleanProperty(false);
        }
        return swyc4;
    }
    public void setSwyc4(boolean swyc4) {
        this.swyc4.set(swyc4);
    }
    public boolean isSwzc5() {
        return swzc5.get();
    }
    public BooleanProperty swzc5Property() {
        if(swzc5==null){
            swzc5 = new SimpleBooleanProperty(false);
        }
        return swzc5;
    }
    public void setSwzc5(boolean swzc5) {
        this.swzc5.set(swzc5);
    }
    public boolean isSwyc5() {
        return swyc5.get();
    }
    public BooleanProperty swyc5Property() {
        if(swyc5==null){
            swyc5 = new SimpleBooleanProperty(false);
        }
        return swyc5;
    }
    public void setSwyc5(boolean swyc5) {
        this.swyc5.set(swyc5);
    }
    public boolean isSwzc6() {
        return swzc6.get();
    }
    public BooleanProperty swzc6Property() {
        if(swzc6==null){
            swzc6 = new SimpleBooleanProperty(false);
        }
        return swzc6;
    }
    public void setSwzc6(boolean swzc6) {
        this.swzc6.set(swzc6);
    }
    public boolean isSwyc6() {
        return swyc6.get();
    }
    public BooleanProperty swyc6Property() {
        if(swyc6==null){
            swyc6 = new SimpleBooleanProperty(false);
        }
        return swyc6;
    }
    public void setSwyc6(boolean swyc6) {
        this.swyc6.set(swyc6);
    }
    public boolean isSwzc7() {
        return swzc7.get();
    }
    public BooleanProperty swzc7Property() {
        if(swzc7==null){
            swzc7 = new SimpleBooleanProperty(false);
        }
        return swzc7;
    }
    public void setSwzc7(boolean swzc7) {
        this.swzc7.set(swzc7);
    }
    public boolean isSwyc7() {
        return swyc7.get();
    }
    public BooleanProperty swyc7Property() {
        if(swyc7==null){
            swyc7 = new SimpleBooleanProperty(false);
        }
        return swyc7;
    }
    public void setSwyc7(boolean swyc7) {
        this.swyc7.set(swyc7);
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
    public void setzyh(String zyh) {
        this.zyh.set(zyh);
    }
    public String getAboxx() {
        return aboxx.get();
    }
    public StringProperty aboxxProperty() {
        if(aboxx==null){
            aboxx = new SimpleStringProperty();
        }
        return aboxx;
    }
    public void setAboxx(String aboxx) {
        this.aboxx.set(aboxx);
    }
    public String getRhxx() {
        return rhxx.get();
    }
    public StringProperty rhxxProperty() {
        if(rhxx==null){
            rhxx = new SimpleStringProperty();
        }
        return rhxx;
    }
    public void setRhxx(String rhxx) {
        this.rhxx.set(rhxx);
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
    public String getAboxx2() {
        return aboxx2.get();
    }
    public StringProperty aboxx2Property() {
        if(aboxx2==null){
            aboxx2 = new SimpleStringProperty();
        }
        return aboxx2;
    }
    public void setAboxx2(String aboxx2) {
        this.aboxx2.set(aboxx2);
    }
    public String getRhxx2() {
        return rhxx2.get();
    }
    public StringProperty rhxx2Property() {
        if(rhxx2==null){
            rhxx2 = new SimpleStringProperty();
        }
        return rhxx2;
    }
    public void setRhxx2(String rhxx2) {
        this.rhxx2.set(rhxx2);
    }
    public String getXyzl() {
        return xyzl.get();
    }
    public StringProperty xyzlProperty() {
        if(xyzl==null){
            xyzl = new SimpleStringProperty();
        }
        return xyzl;
    }
    public void setXyzl(String xyzl) {
        this.xyzl.set(xyzl);
    }
    public String getGuig() {
        return guig.get();
    }
    public StringProperty guigProperty() {
        if(guig==null){
            guig = new SimpleStringProperty();
        }
        return guig;
    }
    public void setGuig(String guig) {
        this.guig.set(guig);
    }
    public String getHdz() {
        return hdz.get();
    }
    public StringProperty hdzProperty() {
        if(hdz==null){
            hdz = new SimpleStringProperty();
        }
        return hdz;
    }
    public void setHdz(String hdz) {
        this.hdz.set(hdz);
    }
    public String getSxhdsj() {
        return sxhdsj.get();
    }
    public StringProperty sxhdsjProperty() {
        if(sxhdsj==null){
            sxhdsj = new SimpleStringProperty();
        }
        return sxhdsj;
    }
    public void setSxhdsj(String sxhdsj) {
        this.sxhdsj.set(sxhdsj);
    }
    public String getZxz() {
        return zxz.get();
    }
    public StringProperty zxzProperty() {
        if(zxz==null){
            zxz = new SimpleStringProperty();
        }
        return zxz;
    }
    public void setZxz(String zxz) {
        this.zxz.set(zxz);
    }
    public String getSxkssj() {
        return sxkssj.get();
    }
    public StringProperty sxkssjProperty() {
        if(sxkssj==null){
            sxkssj = new SimpleStringProperty();
        }
        return sxkssj;
    }
    public void setSxkssj(String sxkssj) {
        this.sxkssj.set(sxkssj);
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
    public String getXy1() {
        return xy1.get();
    }
    public StringProperty xy1Property() {
        if(xy1==null){
            xy1 = new SimpleStringProperty();
        }
        return xy1;
    }
    public void setXy1(String xy1) {
        this.xy1.set(xy1);
    }
    public String getXyn1() {
        return xyn1.get();
    }
    public StringProperty xyn1Property() {
        if(xyn1==null){
            xyn1 = new SimpleStringProperty();
        }
        return xyn1;
    }
    public void setXyn1(String xyn1) {
        this.xyn1.set(xyn1);
    }
    public String getTw2() {
        return tw2.get();
    }
    public StringProperty tw2Property() {
        if(tw2==null){
            tw2 = new SimpleStringProperty();
        }
        return tw2;
    }
    public void setTw2(String tw2) {
        this.tw2.set(tw2);
    }
    public String getMb2() {
        return mb2.get();
    }
    public StringProperty mb2Property() {
        if(mb2==null){
            mb2 = new SimpleStringProperty();
        }
        return mb2;
    }
    public void setMb2(String mb2) {
        this.mb2.set(mb2);
    }
    public String getHx2() {
        return hx2.get();
    }
    public StringProperty hx2Property() {
        if(hx2==null){
            hx2 = new SimpleStringProperty();
        }
        return hx2;
    }
    public void setHx2(String hx2) {
        this.hx2.set(hx2);
    }
    public String getXy2() {
        return xy2.get();
    }
    public StringProperty xy2Property() {
        if(xy2==null){
            xy2 = new SimpleStringProperty();
        }
        return xy2;
    }
    public void setXy2(String xy2) {
        this.xy2.set(xy2);
    }
    public String getXyn2() {
        return xyn2.get();
    }
    public StringProperty xyn2Property() {
        if(xyn2==null){
            xyn2 = new SimpleStringProperty();
        }
        return xyn2;
    }
    public void setXyn2(String xyn2) {
        this.xyn2.set(xyn2);
    }
    public String getJcrxm() {
        return jcrxm.get();
    }
    public StringProperty jcrxmProperty() {
        if(jcrxm==null){
            jcrxm = new SimpleStringProperty();
        }
        return jcrxm;
    }
    public void setJcrxm(String jcrxm) {
        this.jcrxm.set(jcrxm);
    }
    public String getTw3() {
        return tw3.get();
    }
    public StringProperty tw3Property() {
        if(tw3==null){
            tw3 = new SimpleStringProperty();
        }
        return tw3;
    }
    public void setTw3(String tw3) {
        this.tw3.set(tw3);
    }
    public String getMb3() {
        return mb3.get();
    }
    public StringProperty mb3Property() {
        if(mb3==null){
            mb3 = new SimpleStringProperty();
        }
        return mb3;
    }
    public void setMb3(String mb3) {
        this.mb3.set(mb3);
    }
    public String getHx3() {
        return hx3.get();
    }
    public StringProperty hx3Property() {
        if(hx3==null){
            hx3 = new SimpleStringProperty();
        }
        return hx3;
    }
    public void setHx3(String hx3) {
        this.hx3.set(hx3);
    }
    public String getXy3() {
        return xy3.get();
    }
    public StringProperty xy3Property() {
        if(xy3==null){
            xy3 = new SimpleStringProperty();
        }
        return xy3;
    }
    public void setXy3(String xy3) {
        this.xy3.set(xy3);
    }
    public String getXyn3() {
        return xyn3.get();
    }
    public StringProperty xyn3Property() {
        if(xyn3==null){
            xyn3 = new SimpleStringProperty();
        }
        return xyn3;
    }
    public void setXyn3(String xyn3) {
        this.xyn3.set(xyn3);
    }
    public String getJcrxm3() {
        return jcrxm3.get();
    }
    public StringProperty jcrxm3Property() {
        if(jcrxm3==null){
            jcrxm3 = new SimpleStringProperty();
        }
        return jcrxm3;
    }
    public void setJcrxm3(String jcrxm3) {
        this.jcrxm3.set(jcrxm3);
    }
    public String getTw4() {
        return tw4.get();
    }
    public StringProperty tw4Property() {
        if(tw4==null){
            tw4 = new SimpleStringProperty();
        }
        return tw4;
    }
    public void setTw4(String tw4) {
        this.tw4.set(tw4);
    }
    public String getMb4() {
        return mb4.get();
    }
    public StringProperty mb4Property() {
        if(mb4==null){
            mb4 = new SimpleStringProperty();
        }
        return mb4;
    }
    public void setMb4(String mb4) {
        this.mb4.set(mb4);
    }
    public String getHx4() {
        return hx4.get();
    }
    public StringProperty hx4Property() {
        if(hx4==null){
            hx4 = new SimpleStringProperty();
        }
        return hx4;
    }
    public void setHx4(String hx4) {
        this.hx4.set(hx4);
    }
    public String getXy4() {
        return xy4.get();
    }
    public StringProperty xy4Property() {
        if(xy4==null){
            xy4 = new SimpleStringProperty();
        }
        return xy4;
    }
    public void setXy4(String xy4) {
        this.xy4.set(xy4);
    }
    public String getXyn4() {
        return xyn4.get();
    }
    public StringProperty xyn4Property() {
        if(xyn4==null){
            xyn4 = new SimpleStringProperty();
        }
        return xyn4;
    }
    public void setXyn4(String xyn4) {
        this.xyn4.set(xyn4);
    }
    public String getJcrxm4() {
        return jcrxm4.get();
    }
    public StringProperty jcrxm4Property() {
        if(jcrxm4==null){
            jcrxm4 = new SimpleStringProperty();
        }
        return jcrxm4;
    }
    public void setJcrxm4(String jcrxm4) {
        this.jcrxm4.set(jcrxm4);
    }
    public String getTw5() {
        return tw5.get();
    }
    public StringProperty tw5Property() {
        if(tw5==null){
            tw5 = new SimpleStringProperty();
        }
        return tw5;
    }
    public void setTw5(String tw5) {
        this.tw5.set(tw5);
    }
    public String getMb5() {
        return mb5.get();
    }
    public StringProperty mb5Property() {
        if(mb5==null){
            mb5 = new SimpleStringProperty();
        }
        return mb5;
    }
    public void setMb5(String mb5) {
        this.mb5.set(mb5);
    }
    public String getHx5() {
        return hx5.get();
    }
    public StringProperty hx5Property() {
        if(hx5==null){
            hx5 = new SimpleStringProperty();
        }
        return hx5;
    }
    public void setHx5(String hx5) {
        this.hx5.set(hx5);
    }
    public String getXy5() {
        return xy5.get();
    }
    public StringProperty xy5Property() {
        if(xy5==null){
            xy5 = new SimpleStringProperty();
        }
        return xy5;
    }
    public void setXy5(String xy5) {
        this.xy5.set(xy5);
    }
    public String getXyn5() {
        return xyn5.get();
    }
    public StringProperty xyn5Property() {
        if(xyn5==null){
            xyn5 = new SimpleStringProperty();
        }
        return xyn5;
    }
    public void setXyn5(String xyn5) {
        this.xyn5.set(xyn5);
    }
    public String getJcrxm5() {
        return jcrxm5.get();
    }
    public StringProperty jcrxm5Property() {
        if(jcrxm5==null){
            jcrxm5 = new SimpleStringProperty();
        }
        return jcrxm5;
    }
    public void setJcrxm5(String jcrxm5) {
        this.jcrxm5.set(jcrxm5);
    }
    public String getTw6() {
        return tw6.get();
    }
    public StringProperty tw6Property() {
        if(tw6==null){
            tw6 = new SimpleStringProperty();
        }
        return tw6;
    }
    public void setTw6(String tw6) {
        this.tw6.set(tw6);
    }
    public String getMb6() {
        return mb6.get();
    }
    public StringProperty mb6Property() {
        if(mb6==null){
            mb6 = new SimpleStringProperty();
        }
        return mb6;
    }
    public void setMb6(String mb6) {
        this.mb6.set(mb6);
    }
    public String getHx6() {
        return hx6.get();
    }
    public StringProperty hx6Property() {
        if(hx6==null){
            hx6 = new SimpleStringProperty();
        }
        return hx6;
    }
    public void setHx6(String hx6) {
        this.hx6.set(hx6);
    }
    public String getXy6() {
        return xy6.get();
    }
    public StringProperty xy6Property() {
        if(xy6==null){
            xy6 = new SimpleStringProperty();
        }
        return xy6;
    }
    public void setXy6(String xy6) {
        this.xy6.set(xy6);
    }
    public String getXyn6() {
        return xyn6.get();
    }
    public StringProperty xyn6Property() {
        if(xyn6==null){
            xyn6 = new SimpleStringProperty();
        }
        return xyn6;
    }
    public void setXyn6(String xyn6) {
        this.xyn6.set(xyn6);
    }
    public String getJcrxm6() {
        return jcrxm6.get();
    }
    public StringProperty jcrxm6Property() {
        if(jcrxm6==null){
            jcrxm6 = new SimpleStringProperty();
        }
        return jcrxm6;
    }
    public void setJcrxm6(String jcrxm6) {
        this.jcrxm6.set(jcrxm6);
    }
    public String getTw7() {
        return tw7.get();
    }
    public StringProperty tw7Property() {
        if(tw7==null){
            tw7 = new SimpleStringProperty();
        }
        return tw7;
    }
    public void setTw7(String tw7) {
        this.tw7.set(tw7);
    }
    public String getMb7() {
        return mb7.get();
    }
    public StringProperty mb7Property() {
        if(mb7==null){
            mb7 = new SimpleStringProperty();
        }
        return mb7;
    }
    public void setMb7(String mb7) {
        this.mb7.set(mb7);
    }
    public String getHx7() {
        return hx7.get();
    }
    public StringProperty hx7Property() {
        if(hx7==null){
            hx7 = new SimpleStringProperty();
        }
        return hx7;
    }
    public void setHx7(String hx7) {
        this.hx7.set(hx7);
    }
    public String getXy7() {
        return xy7.get();
    }
    public StringProperty xy7Property() {
        if(xy7==null){
            xy7 = new SimpleStringProperty();
        }
        return xy7;
    }
    public void setXy7(String xy7) {
        this.xy7.set(xy7);
    }
    public String getXyn7() {
        return xyn7.get();
    }
    public StringProperty xyn7Property() {
        if(xyn7==null){
            xyn7 = new SimpleStringProperty();
        }
        return xyn7;
    }
    public void setXyn7(String xyn7) {
        this.xyn7.set(xyn7);
    }
    public String getJcrxm7() {
        return jcrxm7.get();
    }
    public StringProperty jcrxm7Property() {
        if(jcrxm7==null){
            jcrxm7 = new SimpleStringProperty();
        }
        return jcrxm7;
    }
    public void setJcrxm7(String jcrxm7) {
        this.jcrxm7.set(jcrxm7);
    }
    public String getSxjssj() {
        return sxjssj.get();
    }
    public StringProperty sxjssjProperty() {
        if(sxjssj==null){
            sxjssj = new SimpleStringProperty();
        }
        return sxjssj;
    }
    public void setSxjssj(String sxjssj) {
        this.sxjssj.set(sxjssj);
    }

}
