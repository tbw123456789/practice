package cn.medigical.publish.pojo.hezhouyiyuan;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MaZuiJiHua {
    /**必要*/
    private BooleanProperty by;
    /**不必要*/
    private BooleanProperty bby;
    /**实施*/
    private BooleanProperty ss;
    /**不实施*/
    private BooleanProperty bss;
    /**PCEA*/
    private BooleanProperty pcea;
    /**PCIA*/
    private BooleanProperty pcia;
    /**麻醉回复室*/
    private BooleanProperty mzhf;
    /**返病房*/
    private BooleanProperty fbf;
    /**ICU*/
    private BooleanProperty icu;
    /**离院*/
    private BooleanProperty ly;
    /**姓名*/
    private StringProperty brxm;
    /**性别*/
    private StringProperty xb;
    /**年龄*/
    private StringProperty nl;
    /**病房*/
    private StringProperty ksmc;
    /**住院号*/
    private StringProperty zyh;
    /**手术间*/
    private StringProperty ssj;
    /**诊断*/
    private StringProperty sqzd;
    /**体重*/
    private StringProperty tz;
    /**身高*/
    private StringProperty sg;
    /**手术*/
    private StringProperty nsss1;
    /**ASA*/
    private StringProperty asa;
    /**血型*/
    private StringProperty xx;
    /**麻醉方法:*/
    private StringProperty mzff;
    /**配药者:*/
    private StringProperty pyz;
    /**给药者:*/
    private StringProperty gyz;
    /**1.*/
    private StringProperty czyy1;
    /**2.*/
    private StringProperty czyy2;
    /**1.丙泊酚*/
    private StringProperty bbf;
    /**2.依托咪酯*/
    private StringProperty ytmz;
    /**3.咪达唑仑*/
    private StringProperty mdzl;
    /**4.瑞芬太尼*/
    private StringProperty rftn;
    /**5.舒芬太尼*/
    private StringProperty sftn;
    /**6.芬太尼*/
    private StringProperty ftn;
    /**7.七氟烷*/
    private StringProperty qfw;
    /**8.肌松剂*/
    private StringProperty jsj;
    /**神经阻滞*/
    private StringProperty sjzuz;
    /**蛛网膜下腔:*/
    private StringProperty zwmxq;
    /**硬膜外*/
    private StringProperty ymw;
    /**静脉:1.*/
    private StringProperty jm1;
    /**吸入N2O*/
    private StringProperty n2o;
    /**2.*/
    private StringProperty jm2;
    /**七氟烷*/
    private StringProperty qfw2;
    /**肌松剂*/
    private StringProperty jsj2;
    /**Enflurane*/
    private StringProperty efr;
    /**硬膜外*/
    private StringProperty ymw2;
    /**神经阻滞*/
    private StringProperty sjzz2;
    /**1.*/
    private StringProperty yttj1;
    /**2.*/
    private StringProperty yttj2;
    /**3.*/
    private StringProperty yttj3;
    /**4.*/
    private StringProperty yttj4;
    /**5.*/
    private StringProperty yttj5;
    /**1.*/
    private StringProperty tscl1;
    /**2.*/
    private StringProperty tscl2;
    /**3.*/
    private StringProperty tscl3;
    /**4.*/
    private StringProperty tscl4;
    /**5.*/
    private StringProperty tscl5;
    /**Ⅵ.监测*/
    private StringProperty jc1;
    /**.*/
    private StringProperty jc2;
    /**.*/
    private StringProperty jc3;
    /**.*/
    private StringProperty jc4;
    /**.*/
    private StringProperty jc5;
    /**.*/
    private StringProperty jc6;
    /**.*/
    private StringProperty jc7;
    /**.*/
    private StringProperty jc8;
    /**.*/
    private StringProperty jc9;
    /**麻醉医师*/
    private StringProperty mzys1;
    /***/
    private StringProperty mzys2;
    /**时间*/
    private StringProperty si;

    public boolean isBy() {
        return by.get();
    }
    public BooleanProperty byProperty() {
        if(by==null){
            by = new SimpleBooleanProperty(false);
        }
        return by;
    }
    public void setBy(boolean by) {
        this.by.set(by);
    }
    public boolean isBby() {
        return bby.get();
    }
    public BooleanProperty bbyProperty() {
        if(bby==null){
            bby = new SimpleBooleanProperty(false);
        }
        return bby;
    }
    public void setBby(boolean bby) {
        this.bby.set(bby);
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
    public boolean isBss() {
        return bss.get();
    }
    public BooleanProperty bssProperty() {
        if(bss==null){
            bss = new SimpleBooleanProperty(false);
        }
        return bss;
    }
    public void setBss(boolean bss) {
        this.bss.set(bss);
    }
    public boolean isPcea() {
        return pcea.get();
    }
    public BooleanProperty pceaProperty() {
        if(pcea==null){
            pcea = new SimpleBooleanProperty(false);
        }
        return pcea;
    }
    public void setPcea(boolean pcea) {
        this.pcea.set(pcea);
    }
    public boolean isPcia() {
        return pcia.get();
    }
    public BooleanProperty pciaProperty() {
        if(pcia==null){
            pcia = new SimpleBooleanProperty(false);
        }
        return pcia;
    }
    public void setPcia(boolean pcia) {
        this.pcia.set(pcia);
    }
    public boolean isMzhf() {
        return mzhf.get();
    }
    public BooleanProperty mzhfProperty() {
        if(mzhf==null){
            mzhf = new SimpleBooleanProperty(false);
        }
        return mzhf;
    }
    public void setMzhf(boolean mzhf) {
        this.mzhf.set(mzhf);
    }
    public boolean isFbf() {
        return fbf.get();
    }
    public BooleanProperty fbfProperty() {
        if(fbf==null){
            fbf = new SimpleBooleanProperty(false);
        }
        return fbf;
    }
    public void setFbf(boolean fbf) {
        this.fbf.set(fbf);
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
    public boolean isLy() {
        return ly.get();
    }
    public BooleanProperty lyProperty() {
        if(ly==null){
            ly = new SimpleBooleanProperty(false);
        }
        return ly;
    }
    public void setLy(boolean ly) {
        this.ly.set(ly);
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
    public String getAsa() {
        return asa.get();
    }
    public StringProperty asaProperty() {
        if(asa==null){
            asa = new SimpleStringProperty();
        }
        return asa;
    }
    public void setAsa(String asa) {
        this.asa.set(asa);
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
    public String getPyz() {
        return pyz.get();
    }
    public StringProperty pyzProperty() {
        if(pyz==null){
            pyz = new SimpleStringProperty();
        }
        return pyz;
    }
    public void setPyz(String pyz) {
        this.pyz.set(pyz);
    }
    public String getGyz() {
        return gyz.get();
    }
    public StringProperty gyzProperty() {
        if(gyz==null){
            gyz = new SimpleStringProperty();
        }
        return gyz;
    }
    public void setGyz(String gyz) {
        this.gyz.set(gyz);
    }
    public String getCzyy1() {
        return czyy1.get();
    }
    public StringProperty czyy1Property() {
        if(czyy1==null){
            czyy1 = new SimpleStringProperty();
        }
        return czyy1;
    }
    public void setCzyy1(String czyy1) {
        this.czyy1.set(czyy1);
    }
    public String getCzyy2() {
        return czyy2.get();
    }
    public StringProperty czyy2Property() {
        if(czyy2==null){
            czyy2 = new SimpleStringProperty();
        }
        return czyy2;
    }
    public void setCzyy2(String czyy2) {
        this.czyy2.set(czyy2);
    }
    public String getBbf() {
        return bbf.get();
    }
    public StringProperty bbfProperty() {
        if(bbf==null){
            bbf = new SimpleStringProperty();
        }
        return bbf;
    }
    public void setBbf(String bbf) {
        this.bbf.set(bbf);
    }
    public String getYtmz() {
        return ytmz.get();
    }
    public StringProperty ytmzProperty() {
        if(ytmz==null){
            ytmz = new SimpleStringProperty();
        }
        return ytmz;
    }
    public void setYtmz(String ytmz) {
        this.ytmz.set(ytmz);
    }
    public String getMdzl() {
        return mdzl.get();
    }
    public StringProperty mdzlProperty() {
        if(mdzl==null){
            mdzl = new SimpleStringProperty();
        }
        return mdzl;
    }
    public void setMdzl(String mdzl) {
        this.mdzl.set(mdzl);
    }
    public String getRftn() {
        return rftn.get();
    }
    public StringProperty rftnProperty() {
        if(rftn==null){
            rftn = new SimpleStringProperty();
        }
        return rftn;
    }
    public void setRftn(String rftn) {
        this.rftn.set(rftn);
    }
    public String getSftn() {
        return sftn.get();
    }
    public StringProperty sftnProperty() {
        if(sftn==null){
            sftn = new SimpleStringProperty();
        }
        return sftn;
    }
    public void setSftn(String sftn) {
        this.sftn.set(sftn);
    }
    public String getFtn() {
        return ftn.get();
    }
    public StringProperty ftnProperty() {
        if(ftn==null){
            ftn = new SimpleStringProperty();
        }
        return ftn;
    }
    public void setFtn(String ftn) {
        this.ftn.set(ftn);
    }
    public String getQfw() {
        return qfw.get();
    }
    public StringProperty qfwProperty() {
        if(qfw==null){
            qfw = new SimpleStringProperty();
        }
        return qfw;
    }
    public void setQfw(String qfw) {
        this.qfw.set(qfw);
    }
    public String getJsj() {
        return jsj.get();
    }
    public StringProperty jsjProperty() {
        if(jsj==null){
            jsj = new SimpleStringProperty();
        }
        return jsj;
    }
    public void setJsj(String jsj) {
        this.jsj.set(jsj);
    }
    public String getSjzuz() {
        return sjzuz.get();
    }
    public StringProperty sjzuzProperty() {
        if(sjzuz==null){
            sjzuz = new SimpleStringProperty();
        }
        return sjzuz;
    }
    public void setSjzuz(String sjzuz) {
        this.sjzuz.set(sjzuz);
    }
    public String getZwmxq() {
        return zwmxq.get();
    }
    public StringProperty zwmxqProperty() {
        if(zwmxq==null){
            zwmxq = new SimpleStringProperty();
        }
        return zwmxq;
    }
    public void setZwmxq(String zwmxq) {
        this.zwmxq.set(zwmxq);
    }
    public String getYmw() {
        return ymw.get();
    }
    public StringProperty ymwProperty() {
        if(ymw==null){
            ymw = new SimpleStringProperty();
        }
        return ymw;
    }
    public void setYmw(String ymw) {
        this.ymw.set(ymw);
    }
    public String getJm1() {
        return jm1.get();
    }
    public StringProperty jm1Property() {
        if(jm1==null){
            jm1 = new SimpleStringProperty();
        }
        return jm1;
    }
    public void setJm1(String jm1) {
        this.jm1.set(jm1);
    }
    public String getN2o() {
        return n2o.get();
    }
    public StringProperty n2oProperty() {
        if(n2o==null){
            n2o = new SimpleStringProperty();
        }
        return n2o;
    }
    public void setN2o(String n2o) {
        this.n2o.set(n2o);
    }
    public String getJm2() {
        return jm2.get();
    }
    public StringProperty jm2Property() {
        if(jm2==null){
            jm2 = new SimpleStringProperty();
        }
        return jm2;
    }
    public void setJm2(String jm2) {
        this.jm2.set(jm2);
    }
    public String getQfw2() {
        return qfw2.get();
    }
    public StringProperty qfw2Property() {
        if(qfw2==null){
            qfw2 = new SimpleStringProperty();
        }
        return qfw2;
    }
    public void setQfw2(String qfw2) {
        this.qfw2.set(qfw2);
    }
    public String getJsj2() {
        return jsj2.get();
    }
    public StringProperty jsj2Property() {
        if(jsj2==null){
            jsj2 = new SimpleStringProperty();
        }
        return jsj2;
    }
    public void setJsj2(String jsj2) {
        this.jsj2.set(jsj2);
    }
    public String getEfr() {
        return efr.get();
    }
    public StringProperty efrProperty() {
        if(efr==null){
            efr = new SimpleStringProperty();
        }
        return efr;
    }
    public void setEfr(String efr) {
        this.efr.set(efr);
    }
    public String getYmw2() {
        return ymw2.get();
    }
    public StringProperty ymw2Property() {
        if(ymw2==null){
            ymw2 = new SimpleStringProperty();
        }
        return ymw2;
    }
    public void setYmw2(String ymw2) {
        this.ymw2.set(ymw2);
    }
    public String getSjzz2() {
        return sjzz2.get();
    }
    public StringProperty sjzz2Property() {
        if(sjzz2==null){
            sjzz2 = new SimpleStringProperty();
        }
        return sjzz2;
    }
    public void setSjzz2(String sjzz2) {
        this.sjzz2.set(sjzz2);
    }
    public String getYttj1() {
        return yttj1.get();
    }
    public StringProperty yttj1Property() {
        if(yttj1==null){
            yttj1 = new SimpleStringProperty();
        }
        return yttj1;
    }
    public void setYttj1(String yttj1) {
        this.yttj1.set(yttj1);
    }
    public String getYttj2() {
        return yttj2.get();
    }
    public StringProperty yttj2Property() {
        if(yttj2==null){
            yttj2 = new SimpleStringProperty();
        }
        return yttj2;
    }
    public void setYttj2(String yttj2) {
        this.yttj2.set(yttj2);
    }
    public String getYttj3() {
        return yttj3.get();
    }
    public StringProperty yttj3Property() {
        if(yttj3==null){
            yttj3 = new SimpleStringProperty();
        }
        return yttj3;
    }
    public void setYttj3(String yttj3) {
        this.yttj3.set(yttj3);
    }
    public String getYttj4() {
        return yttj4.get();
    }
    public StringProperty yttj4Property() {
        if(yttj4==null){
            yttj4 = new SimpleStringProperty();
        }
        return yttj4;
    }
    public void setYttj4(String yttj4) {
        this.yttj4.set(yttj4);
    }
    public String getYttj5() {
        return yttj5.get();
    }
    public StringProperty yttj5Property() {
        if(yttj5==null){
            yttj5 = new SimpleStringProperty();
        }
        return yttj5;
    }
    public void setYttj5(String yttj5) {
        this.yttj5.set(yttj5);
    }
    public String getTscl1() {
        return tscl1.get();
    }
    public StringProperty tscl1Property() {
        if(tscl1==null){
            tscl1 = new SimpleStringProperty();
        }
        return tscl1;
    }
    public void setTscl1(String tscl1) {
        this.tscl1.set(tscl1);
    }
    public String getTscl2() {
        return tscl2.get();
    }
    public StringProperty tscl2Property() {
        if(tscl2==null){
            tscl2 = new SimpleStringProperty();
        }
        return tscl2;
    }
    public void setTscl2(String tscl2) {
        this.tscl2.set(tscl2);
    }
    public String getTscl3() {
        return tscl3.get();
    }
    public StringProperty tscl3Property() {
        if(tscl3==null){
            tscl3 = new SimpleStringProperty();
        }
        return tscl3;
    }
    public void setTscl3(String tscl3) {
        this.tscl3.set(tscl3);
    }
    public String getTscl4() {
        return tscl4.get();
    }
    public StringProperty tscl4Property() {
        if(tscl4==null){
            tscl4 = new SimpleStringProperty();
        }
        return tscl4;
    }
    public void setTscl4(String tscl4) {
        this.tscl4.set(tscl4);
    }
    public String getTscl5() {
        return tscl5.get();
    }
    public StringProperty tscl5Property() {
        if(tscl5==null){
            tscl5 = new SimpleStringProperty();
        }
        return tscl5;
    }
    public void setTscl5(String tscl5) {
        this.tscl5.set(tscl5);
    }
    public String getJc1() {
        return jc1.get();
    }
    public StringProperty jc1Property() {
        if(jc1==null){
            jc1 = new SimpleStringProperty();
        }
        return jc1;
    }
    public void setJc1(String jc1) {
        this.jc1.set(jc1);
    }
    public String getJc2() {
        return jc2.get();
    }
    public StringProperty jc2Property() {
        if(jc2==null){
            jc2 = new SimpleStringProperty();
        }
        return jc2;
    }
    public void setJc2(String jc2) {
        this.jc2.set(jc2);
    }
    public String getJc3() {
        return jc3.get();
    }
    public StringProperty jc3Property() {
        if(jc3==null){
            jc3 = new SimpleStringProperty();
        }
        return jc3;
    }
    public void setJc3(String jc3) {
        this.jc3.set(jc3);
    }
    public String getJc4() {
        return jc4.get();
    }
    public StringProperty jc4Property() {
        if(jc4==null){
            jc4 = new SimpleStringProperty();
        }
        return jc4;
    }
    public void setJc4(String jc4) {
        this.jc4.set(jc4);
    }
    public String getJc5() {
        return jc5.get();
    }
    public StringProperty jc5Property() {
        if(jc5==null){
            jc5 = new SimpleStringProperty();
        }
        return jc5;
    }
    public void setJc5(String jc5) {
        this.jc5.set(jc5);
    }
    public String getJc6() {
        return jc6.get();
    }
    public StringProperty jc6Property() {
        if(jc6==null){
            jc6 = new SimpleStringProperty();
        }
        return jc6;
    }
    public void setJc6(String jc6) {
        this.jc6.set(jc6);
    }
    public String getJc7() {
        return jc7.get();
    }
    public StringProperty jc7Property() {
        if(jc7==null){
            jc7 = new SimpleStringProperty();
        }
        return jc7;
    }
    public void setJc7(String jc7) {
        this.jc7.set(jc7);
    }
    public String getJc8() {
        return jc8.get();
    }
    public StringProperty jc8Property() {
        if(jc8==null){
            jc8 = new SimpleStringProperty();
        }
        return jc8;
    }
    public void setJc8(String jc8) {
        this.jc8.set(jc8);
    }
    public String getJc9() {
        return jc9.get();
    }
    public StringProperty jc9Property() {
        if(jc9==null){
            jc9 = new SimpleStringProperty();
        }
        return jc9;
    }
    public void setJc9(String jc9) {
        this.jc9.set(jc9);
    }
    public String getMzys1() {
        return mzys1.get();
    }
    public StringProperty mzys1Property() {
        if(mzys1==null){
            mzys1 = new SimpleStringProperty();
        }
        return mzys1;
    }
    public void setMzys1(String mzys1) {
        this.mzys1.set(mzys1);
    }
    public String getMzys2() {
        return mzys2.get();
    }
    public StringProperty mzys2Property() {
        if(mzys2==null){
            mzys2 = new SimpleStringProperty();
        }
        return mzys2;
    }
    public void setMzys2(String mzys2) {
        this.mzys2.set(mzys2);
    }
    public String getSi() {
        return si.get();
    }
    public StringProperty siProperty() {
        if(si==null){
            si = new SimpleStringProperty();
        }
        return si;
    }
    public void setSi(String si) {
        this.si.set(si);
    }

}
