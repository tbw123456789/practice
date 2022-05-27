package cn.medigical.publish.pojo.hezhouyiyuan;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class YaChuangFengXianPingGu {
    /**提式床单移动病人 */
    private BooleanProperty cdyd;
    /**使用过床板*/
    private BooleanProperty srbyf;
    /**床单、衣服干燥，平整、无皱褶*/
    private BooleanProperty cdzj;
    /**保持病人皮肤干燥，防止消毒液、冲洗液等浸湿床单*/
    private BooleanProperty cdzz;
    /**骶尾部*/
    private BooleanProperty yy_gb;
    /**髂部*/
    private BooleanProperty gjd;
    /**凡士林*/
    private BooleanProperty jshzt_jiah;
    /**赛肤润*/
    private BooleanProperty jshzt_ch;
    /** 啫喱垫*/
    private BooleanProperty jshzt_dm;
    /**充气手套*/
    private BooleanProperty cqst;
    /**0形棉圈*/
    private BooleanProperty md;
    /**水垫*/
    private BooleanProperty jdb;
    /**暖风机*/
    private BooleanProperty mqg;
    /**盖被 */
    private BooleanProperty gb;
    /**输液加温*/
    private BooleanProperty jdb2;
    /**冲洗液加温*/
    private BooleanProperty ythw;
    /**棉签醮干 */
    private BooleanProperty qugd;
    /**加垫布巾*/
    private BooleanProperty jshzt_zhai;
    /**保护眼角膜*/
    private BooleanProperty yjm;
    /**耳廓、眼眶不受压*/
    private BooleanProperty ek;
    /**安全稳固*/
    private BooleanProperty xil_pj;
    /**肢体功能位*/
    private BooleanProperty ztgnw;
    /**良好暴露术野*/
    private BooleanProperty nhbusy;
    /**肢体无接触金属*/
    private BooleanProperty ztjs;
    /**各管道、电极线无受压*/
    private BooleanProperty gzgd;
    /**完好*/
    private BooleanProperty wh;
    /**姓名*/
    private StringProperty brxm;
    /**性别*/
    private StringProperty xb;
    /**年龄*/
    private StringProperty nl;
    /**体重*/
    private StringProperty tz;
    /**科室*/
    private StringProperty ksmc;
    /**住院号*/
    private StringProperty zyh;
    /**术前诊断*/
    private StringProperty zd;
    /**手术名称*/
    private StringProperty ssmc;
    /**体重*/
    private StringProperty hxtcd;
    /**白蛋白*/
    private StringProperty jl;
    /**HGB*/
    private StringProperty qxcd;
    /**得分*/
    private StringProperty df1;
    /**得分*/
    private StringProperty df2;
    /**得分*/
    private StringProperty df3;
    /**得分*/
    private StringProperty df4;
    /**得分*/
    private StringProperty df5;
    /**得分*/
    private StringProperty df6;
    /**得分*/
    private StringProperty df7;
    /**得分*/
    private StringProperty df8;
    /**得分*/
    private StringProperty df9;
    /**得分*/
    private StringProperty df10;
    /**得分*/
    private StringProperty df112;
    /**得分*/
    private StringProperty df13;
    /**申报人*/
    private StringProperty hsbfqm;
    /**申报时间*/
    private StringProperty hsqm;
    /**护士长审核签名*/
    private StringProperty sjs;
    /**有压疮，请描述*/
    private StringProperty qtte;
    /**根据压疮风险评估表评分得分是*/
    private StringProperty pf;
    /**告知时间*/
    private StringProperty tzjksj;
    /**病人家属*/
    private StringProperty brjs;
    /**巡回护士*/
    private StringProperty sshsqm;
    /**护士长*/
    private StringProperty bfhsqm;

    public boolean isCdyd() {
        return cdyd.get();
    }
    public BooleanProperty cdydProperty() {
        if(cdyd==null){
            cdyd = new SimpleBooleanProperty(false);
        }
        return cdyd;
    }
    public void setCdyd(boolean cdyd) {
        this.cdyd.set(cdyd);
    }
    public boolean isSrbyf() {
        return srbyf.get();
    }
    public BooleanProperty srbyfProperty() {
        if(srbyf==null){
            srbyf = new SimpleBooleanProperty(false);
        }
        return srbyf;
    }
    public void setSrbyf(boolean srbyf) {
        this.srbyf.set(srbyf);
    }
    public boolean isCdzj() {
        return cdzj.get();
    }
    public BooleanProperty cdzjProperty() {
        if(cdzj==null){
            cdzj = new SimpleBooleanProperty(false);
        }
        return cdzj;
    }
    public void setCdzj(boolean cdzj) {
        this.cdzj.set(cdzj);
    }
    public boolean isCdzz() {
        return cdzz.get();
    }
    public BooleanProperty cdzzProperty() {
        if(cdzz==null){
            cdzz = new SimpleBooleanProperty(false);
        }
        return cdzz;
    }
    public void setCdzz(boolean cdzz) {
        this.cdzz.set(cdzz);
    }
    public boolean isYy_gb() {
        return yy_gb.get();
    }
    public BooleanProperty yy_gbProperty() {
        if(yy_gb==null){
            yy_gb = new SimpleBooleanProperty(false);
        }
        return yy_gb;
    }
    public void setYy_gb(boolean yy_gb) {
        this.yy_gb.set(yy_gb);
    }
    public boolean isGjd() {
        return gjd.get();
    }
    public BooleanProperty gjdProperty() {
        if(gjd==null){
            gjd = new SimpleBooleanProperty(false);
        }
        return gjd;
    }
    public void setGjd(boolean gjd) {
        this.gjd.set(gjd);
    }
    public boolean isJshzt_jiah() {
        return jshzt_jiah.get();
    }
    public BooleanProperty jshzt_jiahProperty() {
        if(jshzt_jiah==null){
            jshzt_jiah = new SimpleBooleanProperty(false);
        }
        return jshzt_jiah;
    }
    public void setJshzt_jiah(boolean jshzt_jiah) {
        this.jshzt_jiah.set(jshzt_jiah);
    }
    public boolean isJshzt_ch() {
        return jshzt_ch.get();
    }
    public BooleanProperty jshzt_chProperty() {
        if(jshzt_ch==null){
            jshzt_ch = new SimpleBooleanProperty(false);
        }
        return jshzt_ch;
    }
    public void setJshzt_ch(boolean jshzt_ch) {
        this.jshzt_ch.set(jshzt_ch);
    }
    public boolean isJshzt_dm() {
        return jshzt_dm.get();
    }
    public BooleanProperty jshzt_dmProperty() {
        if(jshzt_dm==null){
            jshzt_dm = new SimpleBooleanProperty(false);
        }
        return jshzt_dm;
    }
    public void setJshzt_dm(boolean jshzt_dm) {
        this.jshzt_dm.set(jshzt_dm);
    }
    public boolean isCqst() {
        return cqst.get();
    }
    public BooleanProperty cqstProperty() {
        if(cqst==null){
            cqst = new SimpleBooleanProperty(false);
        }
        return cqst;
    }
    public void setCqst(boolean cqst) {
        this.cqst.set(cqst);
    }
    public boolean isMd() {
        return md.get();
    }
    public BooleanProperty mdProperty() {
        if(md==null){
            md = new SimpleBooleanProperty(false);
        }
        return md;
    }
    public void setMd(boolean md) {
        this.md.set(md);
    }
    public boolean isJdb() {
        return jdb.get();
    }
    public BooleanProperty jdbProperty() {
        if(jdb==null){
            jdb = new SimpleBooleanProperty(false);
        }
        return jdb;
    }
    public void setJdb(boolean jdb) {
        this.jdb.set(jdb);
    }
    public boolean isMqg() {
        return mqg.get();
    }
    public BooleanProperty mqgProperty() {
        if(mqg==null){
            mqg = new SimpleBooleanProperty(false);
        }
        return mqg;
    }
    public void setMqg(boolean mqg) {
        this.mqg.set(mqg);
    }
    public boolean isGb() {
        return gb.get();
    }
    public BooleanProperty gbProperty() {
        if(gb==null){
            gb = new SimpleBooleanProperty(false);
        }
        return gb;
    }
    public void setGb(boolean gb) {
        this.gb.set(gb);
    }
    public boolean isJdb2() {
        return jdb2.get();
    }
    public BooleanProperty jdb2Property() {
        if(jdb2==null){
            jdb2 = new SimpleBooleanProperty(false);
        }
        return jdb2;
    }
    public void setJdb2(boolean jdb2) {
        this.jdb2.set(jdb2);
    }
    public boolean isYthw() {
        return ythw.get();
    }
    public BooleanProperty ythwProperty() {
        if(ythw==null){
            ythw = new SimpleBooleanProperty(false);
        }
        return ythw;
    }
    public void setYthw(boolean ythw) {
        this.ythw.set(ythw);
    }
    public boolean isQugd() {
        return qugd.get();
    }
    public BooleanProperty qugdProperty() {
        if(qugd==null){
            qugd = new SimpleBooleanProperty(false);
        }
        return qugd;
    }
    public void setQugd(boolean qugd) {
        this.qugd.set(qugd);
    }
    public boolean isJshzt_zhai() {
        return jshzt_zhai.get();
    }
    public BooleanProperty jshzt_zhaiProperty() {
        if(jshzt_zhai==null){
            jshzt_zhai = new SimpleBooleanProperty(false);
        }
        return jshzt_zhai;
    }
    public void setJshzt_zhai(boolean jshzt_zhai) {
        this.jshzt_zhai.set(jshzt_zhai);
    }
    public boolean isYjm() {
        return yjm.get();
    }
    public BooleanProperty yjmProperty() {
        if(yjm==null){
            yjm = new SimpleBooleanProperty(false);
        }
        return yjm;
    }
    public void setYjm(boolean yjm) {
        this.yjm.set(yjm);
    }
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
    public boolean isXil_pj() {
        return xil_pj.get();
    }
    public BooleanProperty xil_pjProperty() {
        if(xil_pj==null){
            xil_pj = new SimpleBooleanProperty(false);
        }
        return xil_pj;
    }
    public void setXil_pj(boolean xil_pj) {
        this.xil_pj.set(xil_pj);
    }
    public boolean isZtgnw() {
        return ztgnw.get();
    }
    public BooleanProperty ztgnwProperty() {
        if(ztgnw==null){
            ztgnw = new SimpleBooleanProperty(false);
        }
        return ztgnw;
    }
    public void setZtgnw(boolean ztgnw) {
        this.ztgnw.set(ztgnw);
    }
    public boolean isNhbusy() {
        return nhbusy.get();
    }
    public BooleanProperty nhbusyProperty() {
        if(nhbusy==null){
            nhbusy = new SimpleBooleanProperty(false);
        }
        return nhbusy;
    }
    public void setNhbusy(boolean nhbusy) {
        this.nhbusy.set(nhbusy);
    }
    public boolean isZtjs() {
        return ztjs.get();
    }
    public BooleanProperty ztjsProperty() {
        if(ztjs==null){
            ztjs = new SimpleBooleanProperty(false);
        }
        return ztjs;
    }
    public void setZtjs(boolean ztjs) {
        this.ztjs.set(ztjs);
    }
    public boolean isGzgd() {
        return gzgd.get();
    }
    public BooleanProperty gzgdProperty() {
        if(gzgd==null){
            gzgd = new SimpleBooleanProperty(false);
        }
        return gzgd;
    }
    public void setGzgd(boolean gzgd) {
        this.gzgd.set(gzgd);
    }
    public boolean isWh() {
        return wh.get();
    }
    public BooleanProperty whProperty() {
        if(wh==null){
            wh = new SimpleBooleanProperty(false);
        }
        return wh;
    }
    public void setWh(boolean wh) {
        this.wh.set(wh);
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
    public String getZd() {
        return zd.get();
    }
    public StringProperty zdProperty() {
        if(zd==null){
            zd = new SimpleStringProperty();
        }
        return zd;
    }
    public void setZd(String zd) {
        this.zd.set(zd);
    }
    public String getSsmc() {
        return ssmc.get();
    }
    public StringProperty ssmcProperty() {
        if(ssmc==null){
            ssmc = new SimpleStringProperty();
        }
        return ssmc;
    }
    public void setSsmc(String ssmc) {
        this.ssmc.set(ssmc);
    }
    public String getHxtcd() {
        return hxtcd.get();
    }
    public StringProperty hxtcdProperty() {
        if(hxtcd==null){
            hxtcd = new SimpleStringProperty();
        }
        return hxtcd;
    }
    public void setHxtcd(String hxtcd) {
        this.hxtcd.set(hxtcd);
    }
    public String getJl() {
        return jl.get();
    }
    public StringProperty jlProperty() {
        if(jl==null){
            jl = new SimpleStringProperty();
        }
        return jl;
    }
    public void setJl(String jl) {
        this.jl.set(jl);
    }
    public String getQxcd() {
        return qxcd.get();
    }
    public StringProperty qxcdProperty() {
        if(qxcd==null){
            qxcd = new SimpleStringProperty();
        }
        return qxcd;
    }
    public void setQxcd(String qxcd) {
        this.qxcd.set(qxcd);
    }
    public String getDf1() {
        return df1.get();
    }
    public StringProperty df1Property() {
        if(df1==null){
            df1 = new SimpleStringProperty();
        }
        return df1;
    }
    public void setDf1(String df1) {
        this.df1.set(df1);
    }
    public String getDf2() {
        return df2.get();
    }
    public StringProperty df2Property() {
        if(df2==null){
            df2 = new SimpleStringProperty();
        }
        return df2;
    }
    public void setDf2(String df2) {
        this.df2.set(df2);
    }
    public String getDf3() {
        return df3.get();
    }
    public StringProperty df3Property() {
        if(df3==null){
            df3 = new SimpleStringProperty();
        }
        return df3;
    }
    public void setDf3(String df3) {
        this.df3.set(df3);
    }
    public String getDf4() {
        return df4.get();
    }
    public StringProperty df4Property() {
        if(df4==null){
            df4 = new SimpleStringProperty();
        }
        return df4;
    }
    public void setDf4(String df4) {
        this.df4.set(df4);
    }
    public String getDf5() {
        return df5.get();
    }
    public StringProperty df5Property() {
        if(df5==null){
            df5 = new SimpleStringProperty();
        }
        return df5;
    }
    public void setDf5(String df5) {
        this.df5.set(df5);
    }
    public String getDf6() {
        return df6.get();
    }
    public StringProperty df6Property() {
        if(df6==null){
            df6 = new SimpleStringProperty();
        }
        return df6;
    }
    public void setDf6(String df6) {
        this.df6.set(df6);
    }
    public String getDf7() {
        return df7.get();
    }
    public StringProperty df7Property() {
        if(df7==null){
            df7 = new SimpleStringProperty();
        }
        return df7;
    }
    public void setDf7(String df7) {
        this.df7.set(df7);
    }
    public String getDf8() {
        return df8.get();
    }
    public StringProperty df8Property() {
        if(df8==null){
            df8 = new SimpleStringProperty();
        }
        return df8;
    }
    public void setDf8(String df8) {
        this.df8.set(df8);
    }
    public String getDf9() {
        return df9.get();
    }
    public StringProperty df9Property() {
        if(df9==null){
            df9 = new SimpleStringProperty();
        }
        return df9;
    }
    public void setDf9(String df9) {
        this.df9.set(df9);
    }
    public String getDf10() {
        return df10.get();
    }
    public StringProperty df10Property() {
        if(df10==null){
            df10 = new SimpleStringProperty();
        }
        return df10;
    }
    public void setDf10(String df10) {
        this.df10.set(df10);
    }
    public String getDf112() {
        return df112.get();
    }
    public StringProperty df112Property() {
        if(df112==null){
            df112 = new SimpleStringProperty();
        }
        return df112;
    }
    public void setDf112(String df112) {
        this.df112.set(df112);
    }
    public String getDf13() {
        return df13.get();
    }
    public StringProperty df13Property() {
        if(df13==null){
            df13 = new SimpleStringProperty();
        }
        return df13;
    }
    public void setDf13(String df13) {
        this.df13.set(df13);
    }
    public String getHsbfqm() {
        return hsbfqm.get();
    }
    public StringProperty hsbfqmProperty() {
        if(hsbfqm==null){
            hsbfqm = new SimpleStringProperty();
        }
        return hsbfqm;
    }
    public void setHsbfqm(String hsbfqm) {
        this.hsbfqm.set(hsbfqm);
    }
    public String getHsqm() {
        return hsqm.get();
    }
    public StringProperty hsqmProperty() {
        if(hsqm==null){
            hsqm = new SimpleStringProperty();
        }
        return hsqm;
    }
    public void setHsqm(String hsqm) {
        this.hsqm.set(hsqm);
    }
    public String getSjs() {
        return sjs.get();
    }
    public StringProperty sjsProperty() {
        if(sjs==null){
            sjs = new SimpleStringProperty();
        }
        return sjs;
    }
    public void setSjs(String sjs) {
        this.sjs.set(sjs);
    }
    public String getQtte() {
        return qtte.get();
    }
    public StringProperty qtteProperty() {
        if(qtte==null){
            qtte = new SimpleStringProperty();
        }
        return qtte;
    }
    public void setQtte(String qtte) {
        this.qtte.set(qtte);
    }
    public String getPf() {
        return pf.get();
    }
    public StringProperty pfProperty() {
        if(pf==null){
            pf = new SimpleStringProperty();
        }
        return pf;
    }
    public void setPf(String pf) {
        this.pf.set(pf);
    }
    public String getTzjksj() {
        return tzjksj.get();
    }
    public StringProperty tzjksjProperty() {
        if(tzjksj==null){
            tzjksj = new SimpleStringProperty();
        }
        return tzjksj;
    }
    public void setTzjksj(String tzjksj) {
        this.tzjksj.set(tzjksj);
    }
    public String getBrjs() {
        return brjs.get();
    }
    public StringProperty brjsProperty() {
        if(brjs==null){
            brjs = new SimpleStringProperty();
        }
        return brjs;
    }
    public void setBrjs(String brjs) {
        this.brjs.set(brjs);
    }
    public String getSshsqm() {
        return sshsqm.get();
    }
    public StringProperty sshsqmProperty() {
        if(sshsqm==null){
            sshsqm = new SimpleStringProperty();
        }
        return sshsqm;
    }
    public void setSshsqm(String sshsqm) {
        this.sshsqm.set(sshsqm);
    }
    public String getBfhsqm() {
        return bfhsqm.get();
    }
    public StringProperty bfhsqmProperty() {
        if(bfhsqm==null){
            bfhsqm = new SimpleStringProperty();
        }
        return bfhsqm;
    }
    public void setBfhsqm(String bfhsqm) {
        this.bfhsqm.set(bfhsqm);
    }

}
