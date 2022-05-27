package cn.medigical.publish.pojo.hezhouyiyuan;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class FengXianPingGu {
    /***/
    private BooleanProperty ssqk_a1;
    /***/
    private BooleanProperty ssqk_a2;
    /***/
    private BooleanProperty ssqk_a3;
    /***/
    private BooleanProperty ssqk_a4;
    /***/
    private BooleanProperty asa_a1;
    /***/
    private BooleanProperty asa_a2;
    /***/
    private BooleanProperty asa_a3;
    /***/
    private BooleanProperty asa_a4;
    /***/
    private BooleanProperty asa_a5;
    /***/
    private BooleanProperty qczzss;
    /***/
    private BooleanProperty sbzzss;
    /***/
    private BooleanProperty qgss;
    /** */
    private BooleanProperty jxss;
    /***/
    private BooleanProperty sscx_a1;
    /***/
    private BooleanProperty sscx_a2;
    /**切口甲级愈合*/
    private BooleanProperty qkjjyh;
    /**切口感染一浅层感染*/
    private BooleanProperty qkgryqcgr;
    /**深层感染*/
    private BooleanProperty scgr;
    /***/
    private BooleanProperty jzss;
    /**-0*/
    private BooleanProperty nnis0;
    /**-1*/
    private BooleanProperty nnis1;
    /**-2*/
    private BooleanProperty nnis2;
    /**-3*/
    private BooleanProperty nnis3;
    /**日期:HBox.hgrow=ALWAYS*/
    private StringProperty date;
    /**科别:HBox.hgrow=ALWAYS*/
    private StringProperty ksmc;
    /**床号:HBox.hgrow=ALWAYS*/
    private StringProperty zych;
    /**姓名:HBox.hgrow=ALWAYS*/
    private StringProperty brxm;
    /**住院号:HBox.hgrow=ALWAYS*/
    private StringProperty zyh;
    /**实施手术名称:HBox.hgrow=ALWAYS*/
    private StringProperty ysss1;
    /**手术医生签名HBox.hgrow=ALWAYS*/
    private StringProperty ssys;
    /**麻醉医师签名HBox.hgrow=ALWAYS*/
    private StringProperty mzys;
    /**巡回护士签名HBox.hgrow=ALWAYS*/
    private StringProperty xhhs;
    /**手术风险评估手术切口清洁程度(HBox.hgrow=ALWAYS*/
    private StringProperty ssqkqj;
    /**分）+麻醉ASA分级(HBox.hgrow=ALWAYS*/
    private StringProperty asafj;
    /**分）+手术持续时间(HBox.hgrow=ALWAYS*/
    private StringProperty sscxsj;
    /**分）=总分HBox.hgrow=ALWAYS*/
    private StringProperty zf;

    public boolean isSsqk_a1() {
        return ssqk_a1.get();
    }
    public BooleanProperty ssqk_a1Property() {
        if(ssqk_a1==null){
            ssqk_a1 = new SimpleBooleanProperty(false);
        }
        return ssqk_a1;
    }
    public void setSsqk_a1(boolean ssqk_a1) {
        this.ssqk_a1.set(ssqk_a1);
    }
    public boolean isSsqk_a2() {
        return ssqk_a2.get();
    }
    public BooleanProperty ssqk_a2Property() {
        if(ssqk_a2==null){
            ssqk_a2 = new SimpleBooleanProperty(false);
        }
        return ssqk_a2;
    }
    public void setSsqk_a2(boolean ssqk_a2) {
        this.ssqk_a2.set(ssqk_a2);
    }
    public boolean isSsqk_a3() {
        return ssqk_a3.get();
    }
    public BooleanProperty ssqk_a3Property() {
        if(ssqk_a3==null){
            ssqk_a3 = new SimpleBooleanProperty(false);
        }
        return ssqk_a3;
    }
    public void setSsqk_a3(boolean ssqk_a3) {
        this.ssqk_a3.set(ssqk_a3);
    }
    public boolean isSsqk_a4() {
        return ssqk_a4.get();
    }
    public BooleanProperty ssqk_a4Property() {
        if(ssqk_a4==null){
            ssqk_a4 = new SimpleBooleanProperty(false);
        }
        return ssqk_a4;
    }
    public void setSsqk_a4(boolean ssqk_a4) {
        this.ssqk_a4.set(ssqk_a4);
    }
    public boolean isAsa_a1() {
        return asa_a1.get();
    }
    public BooleanProperty asa_a1Property() {
        if(asa_a1==null){
            asa_a1 = new SimpleBooleanProperty(false);
        }
        return asa_a1;
    }
    public void setAsa_a1(boolean asa_a1) {
        this.asa_a1.set(asa_a1);
    }
    public boolean isAsa_a2() {
        return asa_a2.get();
    }
    public BooleanProperty asa_a2Property() {
        if(asa_a2==null){
            asa_a2 = new SimpleBooleanProperty(false);
        }
        return asa_a2;
    }
    public void setAsa_a2(boolean asa_a2) {
        this.asa_a2.set(asa_a2);
    }
    public boolean isAsa_a3() {
        return asa_a3.get();
    }
    public BooleanProperty asa_a3Property() {
        if(asa_a3==null){
            asa_a3 = new SimpleBooleanProperty(false);
        }
        return asa_a3;
    }
    public void setAsa_a3(boolean asa_a3) {
        this.asa_a3.set(asa_a3);
    }
    public boolean isAsa_a4() {
        return asa_a4.get();
    }
    public BooleanProperty asa_a4Property() {
        if(asa_a4==null){
            asa_a4 = new SimpleBooleanProperty(false);
        }
        return asa_a4;
    }
    public void setAsa_a4(boolean asa_a4) {
        this.asa_a4.set(asa_a4);
    }
    public boolean isAsa_a5() {
        return asa_a5.get();
    }
    public BooleanProperty asa_a5Property() {
        if(asa_a5==null){
            asa_a5 = new SimpleBooleanProperty(false);
        }
        return asa_a5;
    }
    public void setAsa_a5(boolean asa_a5) {
        this.asa_a5.set(asa_a5);
    }
    public boolean isQczzss() {
        return qczzss.get();
    }
    public BooleanProperty qczzssProperty() {
        if(qczzss==null){
            qczzss = new SimpleBooleanProperty(false);
        }
        return qczzss;
    }
    public void setQczzss(boolean qczzss) {
        this.qczzss.set(qczzss);
    }
    public boolean isSbzzss() {
        return sbzzss.get();
    }
    public BooleanProperty sbzzssProperty() {
        if(sbzzss==null){
            sbzzss = new SimpleBooleanProperty(false);
        }
        return sbzzss;
    }
    public void setSbzzss(boolean sbzzss) {
        this.sbzzss.set(sbzzss);
    }
    public boolean isQgss() {
        return qgss.get();
    }
    public BooleanProperty qgssProperty() {
        if(qgss==null){
            qgss = new SimpleBooleanProperty(false);
        }
        return qgss;
    }
    public void setQgss(boolean qgss) {
        this.qgss.set(qgss);
    }
    public boolean isJxss() {
        return jxss.get();
    }
    public BooleanProperty jxssProperty() {
        if(jxss==null){
            jxss = new SimpleBooleanProperty(false);
        }
        return jxss;
    }
    public void setJxss(boolean jxss) {
        this.jxss.set(jxss);
    }
    public boolean isSscx_a1() {
        return sscx_a1.get();
    }
    public BooleanProperty sscx_a1Property() {
        if(sscx_a1==null){
            sscx_a1 = new SimpleBooleanProperty(false);
        }
        return sscx_a1;
    }
    public void setSscx_a1(boolean sscx_a1) {
        this.sscx_a1.set(sscx_a1);
    }
    public boolean isSscx_a2() {
        return sscx_a2.get();
    }
    public BooleanProperty sscx_a2Property() {
        if(sscx_a2==null){
            sscx_a2 = new SimpleBooleanProperty(false);
        }
        return sscx_a2;
    }
    public void setSscx_a2(boolean sscx_a2) {
        this.sscx_a2.set(sscx_a2);
    }
    public boolean isQkjjyh() {
        return qkjjyh.get();
    }
    public BooleanProperty qkjjyhProperty() {
        if(qkjjyh==null){
            qkjjyh = new SimpleBooleanProperty(false);
        }
        return qkjjyh;
    }
    public void setQkjjyh(boolean qkjjyh) {
        this.qkjjyh.set(qkjjyh);
    }
    public boolean isQkgryqcgr() {
        return qkgryqcgr.get();
    }
    public BooleanProperty qkgryqcgrProperty() {
        if(qkgryqcgr==null){
            qkgryqcgr = new SimpleBooleanProperty(false);
        }
        return qkgryqcgr;
    }
    public void setQkgryqcgr(boolean qkgryqcgr) {
        this.qkgryqcgr.set(qkgryqcgr);
    }
    public boolean isScgr() {
        return scgr.get();
    }
    public BooleanProperty scgrProperty() {
        if(scgr==null){
            scgr = new SimpleBooleanProperty(false);
        }
        return scgr;
    }
    public void setScgr(boolean scgr) {
        this.scgr.set(scgr);
    }
    public boolean isJzss() {
        return jzss.get();
    }
    public BooleanProperty jzssProperty() {
        if(jzss==null){
            jzss = new SimpleBooleanProperty(false);
        }
        return jzss;
    }
    public void setJzss(boolean jzss) {
        this.jzss.set(jzss);
    }
    public boolean isNnis0() {
        return nnis0.get();
    }
    public BooleanProperty nnis0Property() {
        if(nnis0==null){
            nnis0 = new SimpleBooleanProperty(false);
        }
        return nnis0;
    }
    public void setNnis0(boolean nnis0) {
        this.nnis0.set(nnis0);
    }
    public boolean isNnis1() {
        return nnis1.get();
    }
    public BooleanProperty nnis1Property() {
        if(nnis1==null){
            nnis1 = new SimpleBooleanProperty(false);
        }
        return nnis1;
    }
    public void setNnis1(boolean nnis1) {
        this.nnis1.set(nnis1);
    }
    public boolean isNnis2() {
        return nnis2.get();
    }
    public BooleanProperty nnis2Property() {
        if(nnis2==null){
            nnis2 = new SimpleBooleanProperty(false);
        }
        return nnis2;
    }
    public void setNnis2(boolean nnis2) {
        this.nnis2.set(nnis2);
    }
    public boolean isNnis3() {
        return nnis3.get();
    }
    public BooleanProperty nnis3Property() {
        if(nnis3==null){
            nnis3 = new SimpleBooleanProperty(false);
        }
        return nnis3;
    }
    public void setNnis3(boolean nnis3) {
        this.nnis3.set(nnis3);
    }

    public String getDate() {
        return date.get();
    }
    public StringProperty dateProperty() {
        if(date==null){
            date = new SimpleStringProperty();
        }
        return date;
    }
    public void setDate(String date) {
        this.date.set(date);
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
    public String getSsys() {
        return ssys.get();
    }
    public StringProperty ssysProperty() {
        if(ssys==null){
            ssys = new SimpleStringProperty();
        }
        return ssys;
    }
    public void setSsys(String ssys) {
        this.ssys.set(ssys);
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
    public String getXhhs() {
        return xhhs.get();
    }
    public StringProperty xhhsProperty() {
        if(xhhs==null){
            xhhs = new SimpleStringProperty();
        }
        return xhhs;
    }
    public void setXhhs(String xhhs) {
        this.xhhs.set(xhhs);
    }
    public String getSsqkqj() {
        return ssqkqj.get();
    }
    public StringProperty ssqkqjProperty() {
        if(ssqkqj==null){
            ssqkqj = new SimpleStringProperty();
        }
        return ssqkqj;
    }
    public void setSsqkqj(String ssqkqj) {
        this.ssqkqj.set(ssqkqj);
    }
    public String getAsafj() {
        return asafj.get();
    }
    public StringProperty asafjProperty() {
        if(asafj==null){
            asafj = new SimpleStringProperty();
        }
        return asafj;
    }
    public void setAsafj(String asafj) {
        this.asafj.set(asafj);
    }
    public String getSscxsj() {
        return sscxsj.get();
    }
    public StringProperty sscxsjProperty() {
        if(sscxsj==null){
            sscxsj = new SimpleStringProperty();
        }
        return sscxsj;
    }
    public void setSscxsj(String sscxsj) {
        this.sscxsj.set(sscxsj);
    }
    public String getZf() {
        return zf.get();
    }
    public StringProperty zfProperty() {
        if(zf==null){
            zf = new SimpleStringProperty();
        }
        return zf;
    }
    public void setZf(String zf) {
        this.zf.set(zf);
    }

}
