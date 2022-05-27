package cn.medigical.publish.pojo.hezhouyiyuan;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PiFuPingGu {
    /**耳廓*/
    private BooleanProperty ek;
    /**额部*/
    private BooleanProperty hb;
    /**下颌部*/
    private BooleanProperty xhb;
    /**枕外隆凸部*/
    private BooleanProperty zwltb;
    /**肩胛部*/
    private BooleanProperty jjb;
    /**肩峰部*/
    private BooleanProperty jfb;
    /**肋缘突出部*/
    private BooleanProperty nytcb;
    /**肘部*/
    private BooleanProperty zb;
    /**髋部*/
    private BooleanProperty kb;
    /**骶尾部*/
    private BooleanProperty dwb;
    /**膝前部*/
    private BooleanProperty xqb;
    /**膝部（内踝、外踝）*/
    private BooleanProperty xh;
    /**足踝（内踝、外踝）*/
    private BooleanProperty zh;
    /**足跟*/
    private BooleanProperty zg;
    /**足趾*/
    private BooleanProperty zz;
    /**其他部位*/
    private BooleanProperty qtbw;
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
    /**日期*/
    private StringProperty rq;
    /**压疮部位*/
    private StringProperty ycbw;
    /**大小（cmxcm)*/
    private StringProperty dx;
    /**分期*/
    private StringProperty fq;
    /**交班者*/
    private StringProperty jiaobz;
    /**接班者*/
    private StringProperty jiebz;

    public boolean isEk() {
        return ek.get();
    }
    public BooleanProperty ekProperty() {
        if(ek==null){
            ek = new SimpleBooleanProperty(false);
        }
        return ek;
    }
    public void setEk(boolean ek) {
        this.ek.set(ek);
    }
    public boolean isHb() {
        return hb.get();
    }
    public BooleanProperty hbProperty() {
        if(hb==null){
            hb = new SimpleBooleanProperty(false);
        }
        return hb;
    }
    public void setHb(boolean hb) {
        this.hb.set(hb);
    }
    public boolean isXhb() {
        return xhb.get();
    }
    public BooleanProperty xhbProperty() {
        if(xhb==null){
            xhb = new SimpleBooleanProperty(false);
        }
        return xhb;
    }
    public void setXhb(boolean xhb) {
        this.xhb.set(xhb);
    }
    public boolean isZwltb() {
        return zwltb.get();
    }
    public BooleanProperty zwltbProperty() {
        if(zwltb==null){
            zwltb = new SimpleBooleanProperty(false);
        }
        return zwltb;
    }
    public void setZwltb(boolean zwltb) {
        this.zwltb.set(zwltb);
    }
    public boolean isJjb() {
        return jjb.get();
    }
    public BooleanProperty jjbProperty() {
        if(jjb==null){
            jjb = new SimpleBooleanProperty(false);
        }
        return jjb;
    }
    public void setJjb(boolean jjb) {
        this.jjb.set(jjb);
    }
    public boolean isJfb() {
        return jfb.get();
    }
    public BooleanProperty jfbProperty() {
        if(jfb==null){
            jfb = new SimpleBooleanProperty(false);
        }
        return jfb;
    }
    public void setJfb(boolean jfb) {
        this.jfb.set(jfb);
    }
    public boolean isNytcb() {
        return nytcb.get();
    }
    public BooleanProperty nytcbProperty() {
        if(nytcb==null){
            nytcb = new SimpleBooleanProperty(false);
        }
        return nytcb;
    }
    public void setNytcb(boolean nytcb) {
        this.nytcb.set(nytcb);
    }
    public boolean isZb() {
        return zb.get();
    }
    public BooleanProperty zbProperty() {
        if(zb==null){
            zb = new SimpleBooleanProperty(false);
        }
        return zb;
    }
    public void setZb(boolean zb) {
        this.zb.set(zb);
    }
    public boolean isKb() {
        return kb.get();
    }
    public BooleanProperty kbProperty() {
        if(kb==null){
            kb = new SimpleBooleanProperty(false);
        }
        return kb;
    }
    public void setKb(boolean kb) {
        this.kb.set(kb);
    }
    public boolean isDwb() {
        return dwb.get();
    }
    public BooleanProperty dwbProperty() {
        if(dwb==null){
            dwb = new SimpleBooleanProperty(false);
        }
        return dwb;
    }
    public void setDwb(boolean dwb) {
        this.dwb.set(dwb);
    }
    public boolean isXqb() {
        return xqb.get();
    }
    public BooleanProperty xqbProperty() {
        if(xqb==null){
            xqb = new SimpleBooleanProperty(false);
        }
        return xqb;
    }
    public void setXqb(boolean xqb) {
        this.xqb.set(xqb);
    }
    public boolean isXh() {
        return xh.get();
    }
    public BooleanProperty xhProperty() {
        if(xh==null){
            xh = new SimpleBooleanProperty(false);
        }
        return xh;
    }
    public void setXh(boolean xh) {
        this.xh.set(xh);
    }
    public boolean isZh() {
        return zh.get();
    }
    public BooleanProperty zhProperty() {
        if(zh==null){
            zh = new SimpleBooleanProperty(false);
        }
        return zh;
    }
    public void setZh(boolean zh) {
        this.zh.set(zh);
    }
    public boolean isZg() {
        return zg.get();
    }
    public BooleanProperty zgProperty() {
        if(zg==null){
            zg = new SimpleBooleanProperty(false);
        }
        return zg;
    }
    public void setZg(boolean zg) {
        this.zg.set(zg);
    }
    public boolean isZz() {
        return zz.get();
    }
    public BooleanProperty zzProperty() {
        if(zz==null){
            zz = new SimpleBooleanProperty(false);
        }
        return zz;
    }
    public void setZz(boolean zz) {
        this.zz.set(zz);
    }
    public boolean isQtbw() {
        return qtbw.get();
    }
    public BooleanProperty qtbwProperty() {
        if(qtbw==null){
            qtbw = new SimpleBooleanProperty(false);
        }
        return qtbw;
    }
    public void setQtbw(boolean qtbw) {
        this.qtbw.set(qtbw);
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
    public String getYcbw() {
        return ycbw.get();
    }
    public StringProperty ycbwProperty() {
        if(ycbw==null){
            ycbw = new SimpleStringProperty();
        }
        return ycbw;
    }
    public void setYcbw(String ycbw) {
        this.ycbw.set(ycbw);
    }
    public String getDx() {
        return dx.get();
    }
    public StringProperty dxProperty() {
        if(dx==null){
            dx = new SimpleStringProperty();
        }
        return dx;
    }
    public void setDx(String dx) {
        this.dx.set(dx);
    }
    public String getFq() {
        return fq.get();
    }
    public StringProperty fqProperty() {
        if(fq==null){
            fq = new SimpleStringProperty();
        }
        return fq;
    }
    public void setFq(String fq) {
        this.fq.set(fq);
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

}
