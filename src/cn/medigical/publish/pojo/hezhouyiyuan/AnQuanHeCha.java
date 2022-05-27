package cn.medigical.publish.pojo.hezhouyiyuan;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AnQuanHeCha {
    /**
     * 姓名
     */
    private StringProperty ksmc;
    
    /** 患者姓名:*/
    private StringProperty brxm;
    
    /** 性别:*/
    private StringProperty xb;
    
    /** 年龄:*/
    private StringProperty nl;
    
    /** 住院号:*/
    private StringProperty zyh;
    
    /** 麻醉方式:*/
    private StringProperty mzff;
    
    /** 手术日期:*/
    private StringProperty operDoctor1StartTime;
    
    /** 手术方式:*/
    private StringProperty nsss1;

    private StringProperty operDoctor1;
    /**
     * 麻醉前其他
     */
    private StringProperty maZuiQianQiTa;
    /**
     * 手术前其他
     */
    private StringProperty shouShuQianQiTa;
    /**
     * 出手术室前其他
     */
    private StringProperty chuShiQianQiTa;


    /**
     * 是
     */
    private BooleanProperty shuQianXInXi_Yes;
    /**
     * 否
     */
    private BooleanProperty shuQianXInXi_No;
    /**
     * 是
     */
    private BooleanProperty shuQianShouShuFangShi_Yes;
    /**
     * 否
     */
    private BooleanProperty shuQianShouShuFangShi_No;
    /**
     * 是
     */
    private BooleanProperty ShuQIanBuWeiBiaoShi_Yes;
    /**
     * 否
     */
    private BooleanProperty ShuQIanBuWeiBiaoShi_No;
    /**
     * 是
     */
    private BooleanProperty maZuiFengXIanYuJi_Yes;
    /**
     * 否
     */
    private BooleanProperty maZuiFengXIanYuJi_No;
    /**
     * 预计手术时间
     */
    private BooleanProperty yuJiShouShuShiJian;
    /**
     * 预计失血量
     */
    private BooleanProperty yuJiShiXueLiang;
    /**
     * 手术关注点
     */
    private BooleanProperty shouShuGuanZhuDIan;
    /**
     * 其他
     */
    private BooleanProperty shouShuYiShiChenShuQiTa;
    /**
     * 麻醉关注点
     */
    private BooleanProperty maZuiGuanZhuDian;
    /**
     * 其他
     */
    private BooleanProperty maZuiYiShiChenShiQiTa;
    /**
     * 手术所需物品准备
     */
    private BooleanProperty shouShuXuYaoSheBei;
    /**
     * 物品灭菌合格
     */
    private BooleanProperty wuPinMieJunHeGe;
    /**
     * 仪器设备
     */
    private BooleanProperty yiQiSheBei;
    /**
     * 术前术中特殊情况
     */
    private BooleanProperty shuQianShuZHongTeShuQingKuang;
    /**
     * 其它
     */
    private BooleanProperty huShiChenShuQiTa;
    /**
     * 是
     */
    private BooleanProperty shuQianYingXiang_Yes;
    /**
     * 否
     */
    private BooleanProperty shuQianYingXiang_No;
    /**
     * 是
     */
    private BooleanProperty liShiXinXi_Yes;
    /**
     * 否
     */
    private BooleanProperty liShiXinXi_No;
    /**
     * 是
     */
    private BooleanProperty shiJiShouShuFanfgShi_Yes;
    /**
     * 否
     */
    private BooleanProperty shiJiShouShuFanfgShi_No;
    /**
     * 是
     */
    private BooleanProperty yongYaoShuXue_Yes;
    /**
     * 否
     */
    private BooleanProperty yongYaoShuXue_No;
    /**
     * 是
     */
    private BooleanProperty yongWuQingDian_Yes;
    /**
     * 否
     */
    private BooleanProperty yongWuQingDian_No;
    /**
     * 是
     */
    private BooleanProperty biaoBenQueRen_Yes;
    /**
     * 否
     */
    private BooleanProperty biaoBenQueRen_No;
    /**
     * 是
     */
    private BooleanProperty liShiPiFuWanZheng_Yes;
    /**
     * 否
     */
    private BooleanProperty liShiPiFuWanZheng_No;
    /**
     * 外周静脉通路
     */
    private BooleanProperty waiZhouJingMaiTongLu;
    /**
     * 中心静脉通路
     */
    private BooleanProperty jingMaiTongLu;
    /**
     * 动脉通路
     */
    private BooleanProperty dongMaiTongLu;
    /**
     * 气管插管
     */
    private BooleanProperty qiGUanChaGuan;
    /**
     * 伤口引流
     */
    private BooleanProperty shangKouYinLiu;
    /**
     * 胃管
     */
    private BooleanProperty weiGuan;
    /**
     * 尿管
     */
    private BooleanProperty niaoGuan;
    /**
     * 其他
     */
    private BooleanProperty guanLuQiTa;
    /**
     * 复苏室
     */
    private BooleanProperty huiFuShi;
    /**
     * 病房
     */
    private BooleanProperty bingFang;
    /**
     * ICU
     */
    private BooleanProperty ICU;
    /**
     * 急诊
     */
    private BooleanProperty jiZhen;
    /**
     * 离院
     */
    private BooleanProperty liYuan;
    /**
     * 是
     */
    private BooleanProperty geRenXinXi_Yes;
    /**
     * 否
     */
    private BooleanProperty geRenXinXi_No;
    /**
     * 是
     */
    private BooleanProperty shoushuFangShi_Yes;
    /**
     * 否
     */
    private BooleanProperty shoushuFangShi_No;
    /**
     * 是
     */
    private BooleanProperty buWeiBiaoShi_Yes;
    /**
     * 否
     */
    private BooleanProperty buWeiBiaoShi_No;
    /**
     * 是
     */
    private BooleanProperty shouShuTIngYi_Yes;
    /**
     * 否
     */
    private BooleanProperty shouShuTIngYi_No;
    /**
     * 是
     */
    private BooleanProperty zhiQIngTongYi_Yes;
    /**
     * 否
     */
    private BooleanProperty zhiQIngTongYi_No;
    /**
     * 是
     */
    private BooleanProperty maZuiFangShi_Yes;
    /**
     * 否
     */
    private BooleanProperty maZuiFangShi_No;
    /**
     * 是
     */
    private BooleanProperty sheBeiJianCha_Yes;
    /**
     * 否
     */
    private BooleanProperty sheBeiJianCha_No;
    /**
     * 是
     */
    private BooleanProperty piFuWanZheng_Yes;
    /**
     * 否
     */
    private BooleanProperty piFuWanZheng_No;
    /**
     * 是
     */
    private BooleanProperty tiNeiZhiRuWu_yes;
    /**
     * 是
     */
    private BooleanProperty shuYePiFu_Yes;
    /**
     * 否
     */
    private BooleanProperty shuYePiFu_No;
    /**
     * 是
     */
    private BooleanProperty jingMaiTongDao_Yes;
    /**
     * 否
     */
    private BooleanProperty jingMaiTongDao_No;
    /**
     * 是
     */
    private BooleanProperty guoMinShi_Yes;
    /**
     * 否
     */
    private BooleanProperty guoMinShi_No;
    /**
     * 是
     */
    private BooleanProperty kangJunYaoWu_Yes;
    /**
     * 否
     */
    private BooleanProperty kangJunYaoWu_No;
    /**
     * 是
     */
    private BooleanProperty shuQianBeiXue_Yes;
    /**
     * 否
     */
    private BooleanProperty shuQianBeiXue_No;
    /**
     * 是
     */
    private BooleanProperty jiaTi_Yes;
    /**
     * 否
     */
    private BooleanProperty jiaTi_No;
    /**
     * 是
     */
    private BooleanProperty yingXiangXue_Yes;
    /**
     * 否
     */
    private BooleanProperty yingXiangXue_No;
    /**
     * 否
     */

    private BooleanProperty tiNeiZhiRuWu_no;

    /**手术医生签名*/
    private StringProperty ssysqm;
    /**麻醉医生签名*/
    private StringProperty mzysqm;
    /**手术护士签名*/
    private StringProperty sshuqm;
    private  StringProperty qttext;
    private  StringProperty ssyscs_qt;
    private  StringProperty mzyscs_qt;
    private  StringProperty mzyscs_qt1;
    private  StringProperty sshscs_qt;
    private  StringProperty yjsssj;

    public String getYjsssj() {
        return yjsssj.get();
    }

    public StringProperty yjsssjProperty() {
        if(yjsssj==null){
            yjsssj=new SimpleStringProperty();
        }
        return yjsssj;
    }

    public void setYjsssj(String yjsssj) {
        this.yjsssj.set(yjsssj);
    }

    public String getMzyscs_qt1() {
        return mzyscs_qt1.get();
    }

    public StringProperty mzyscs_qt1Property() {
        if(mzyscs_qt1==null){
            mzyscs_qt1=new SimpleStringProperty();
        }
        return mzyscs_qt1;
    }

    public void setMzyscs_qt1(String mzyscs_qt1) {
        this.mzyscs_qt1.set(mzyscs_qt1);
    }

    public String getSsyscs_qt() {
        return ssyscs_qt.get();
    }

    public StringProperty ssyscs_qtProperty() {
        if(ssyscs_qt==null){
            ssyscs_qt=new SimpleStringProperty();
        }
        return ssyscs_qt;
    }

    public void setSsyscs_qt(String ssyscs_qt) {
        this.ssyscs_qt.set(ssyscs_qt);
    }

    public String getMzyscs_qt() {
        return mzyscs_qt.get();
    }

    public StringProperty mzyscs_qtProperty() {
        if(mzyscs_qt==null){
            mzyscs_qt=new SimpleStringProperty();
        }
        return mzyscs_qt;
    }

    public void setMzyscs_qt(String mzyscs_qt) {
        this.mzyscs_qt.set(mzyscs_qt);
    }

    public String getSshscs_qt() {
        return sshscs_qt.get();
    }

    public StringProperty sshscs_qtProperty() {
        if(sshscs_qt==null){
            sshscs_qt=new SimpleStringProperty();
        }
        return sshscs_qt;
    }

    public void setSshscs_qt(String sshscs_qt) {
        this.sshscs_qt.set(sshscs_qt);
    }

    public String getQttext() {
        return qttext.get();
    }

    public StringProperty qttextProperty() {
        if(qttext==null){
            qttext=new SimpleStringProperty();
        }
        return qttext;
    }

    public void setQttext(String qttext) {
        this.qttext.set(qttext);
    }

    public String getKsmc() {
        return ksmc.get();
    }

    public StringProperty ksmcProperty() {
        if(ksmc==null){
           ksmc=new SimpleStringProperty();
        }
        return ksmc;
    }

    public void setKsmc(String ksmc) {
        this.ksmc.set(ksmc);
    }

    public String getBrxm() {
        return brxm.get();
    }

    public StringProperty brxmProperty() {
        if(brxm==null){
            brxm=new SimpleStringProperty();
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
            xb=new SimpleStringProperty();
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
            nl=new SimpleStringProperty();
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
            zyh=new SimpleStringProperty();
        }
        return zyh;
    }

    public void setZyh(String zyh) {
        this.zyh.set(zyh);
    }

    public String getMzff() {
        return mzff.get();
    }

    public StringProperty mzffProperty() {
        if(mzff==null){
            mzff=new SimpleStringProperty();
        }
        return mzff;
    }

    public void setMzff(String mzff) {
        this.mzff.set(mzff);
    }

    public String getOperDoctor1StartTime() {
        return operDoctor1StartTime.get();
    }

    public StringProperty operDoctor1StartTimeProperty() {
        if(operDoctor1StartTime==null){
            operDoctor1StartTime=new SimpleStringProperty();
        }
        return operDoctor1StartTime;
    }

    public void setOperDoctor1StartTime(String operDoctor1StartTime) {
        this.operDoctor1StartTime.set(operDoctor1StartTime);
    }

    public String getNsss1() {
        return nsss1.get();
    }

    public StringProperty nsss1Property() {
        if(nsss1==null){
            nsss1=new SimpleStringProperty();
        }
        return nsss1;
    }

    public void setNsss1(String nsss1) {
        this.nsss1.set(nsss1);
    }

    public String getOperDoctor1() {
        return operDoctor1.get();
    }

    public StringProperty operDoctor1Property() {
        if(operDoctor1==null){
            operDoctor1=new SimpleStringProperty();
        }
        return operDoctor1;
    }

    public void setOperDoctor1(String operDoctor1) {
        this.operDoctor1.set(operDoctor1);
    }

    public boolean isShuQianXInXi_Yes() {
        return shuQianXInXi_Yes.get();
    }

    public BooleanProperty shuQianXInXi_YesProperty() {
        if (shuQianXInXi_Yes == null) {
            shuQianXInXi_Yes = new SimpleBooleanProperty(false);
        }
        return shuQianXInXi_Yes;
    }

    public void setShuQianXInXi_Yes(boolean shuQianXInXi_Yes) {
        this.shuQianXInXi_Yes.set(shuQianXInXi_Yes);
    }

    public boolean isShuQianXInXi_No() {
        return shuQianXInXi_No.get();
    }

    public BooleanProperty shuQianXInXi_NoProperty() {
        if (shuQianXInXi_No == null) {
            shuQianXInXi_No = new SimpleBooleanProperty(false);
        }
        return shuQianXInXi_No;
    }

    public void setShuQianXInXi_No(boolean shuQianXInXi_No) {
        this.shuQianXInXi_No.set(shuQianXInXi_No);
    }

    public boolean isShuQianShouShuFangShi_Yes() {
        return shuQianShouShuFangShi_Yes.get();
    }

    public BooleanProperty shuQianShouShuFangShi_YesProperty() {
        if (shuQianShouShuFangShi_Yes == null) {
            shuQianShouShuFangShi_Yes = new SimpleBooleanProperty(false);
        }
        return shuQianShouShuFangShi_Yes;
    }

    public void setShuQianShouShuFangShi_Yes(boolean shuQianShouShuFangShi_Yes) {
        this.shuQianShouShuFangShi_Yes.set(shuQianShouShuFangShi_Yes);
    }

    public boolean isShuQianShouShuFangShi_No() {
        return shuQianShouShuFangShi_No.get();
    }

    public BooleanProperty shuQianShouShuFangShi_NoProperty() {
        if (shuQianShouShuFangShi_No == null) {
            shuQianShouShuFangShi_No = new SimpleBooleanProperty(false);
        }
        return shuQianShouShuFangShi_No;
    }

    public void setShuQianShouShuFangShi_No(boolean shuQianShouShuFangShi_No) {
        this.shuQianShouShuFangShi_No.set(shuQianShouShuFangShi_No);
    }

    public boolean isShuQIanBuWeiBiaoShi_Yes() {
        return ShuQIanBuWeiBiaoShi_Yes.get();
    }

    public BooleanProperty shuQIanBuWeiBiaoShi_YesProperty() {
        if (ShuQIanBuWeiBiaoShi_Yes == null) {
            ShuQIanBuWeiBiaoShi_Yes = new SimpleBooleanProperty(false);
        }
        return ShuQIanBuWeiBiaoShi_Yes;
    }

    public void setShuQIanBuWeiBiaoShi_Yes(boolean shuQIanBuWeiBiaoShi_Yes) {
        this.ShuQIanBuWeiBiaoShi_Yes.set(shuQIanBuWeiBiaoShi_Yes);
    }

    public boolean isShuQIanBuWeiBiaoShi_No() {
        return ShuQIanBuWeiBiaoShi_No.get();
    }

    public BooleanProperty shuQIanBuWeiBiaoShi_NoProperty() {
        if (ShuQIanBuWeiBiaoShi_No == null) {
            ShuQIanBuWeiBiaoShi_No = new SimpleBooleanProperty(false);
        }
        return ShuQIanBuWeiBiaoShi_No;
    }

    public void setShuQIanBuWeiBiaoShi_No(boolean shuQIanBuWeiBiaoShi_No) {
        this.ShuQIanBuWeiBiaoShi_No.set(shuQIanBuWeiBiaoShi_No);
    }

    public boolean isMaZuiFengXIanYuJi_Yes() {
        return maZuiFengXIanYuJi_Yes.get();
    }

    public BooleanProperty maZuiFengXIanYuJi_YesProperty() {
        if (maZuiFengXIanYuJi_Yes == null) {
            maZuiFengXIanYuJi_Yes = new SimpleBooleanProperty(false);
        }
        return maZuiFengXIanYuJi_Yes;
    }

    public void setMaZuiFengXIanYuJi_Yes(boolean maZuiFengXIanYuJi_Yes) {
        this.maZuiFengXIanYuJi_Yes.set(maZuiFengXIanYuJi_Yes);
    }

    public boolean isMaZuiFengXIanYuJi_No() {
        return maZuiFengXIanYuJi_No.get();
    }

    public BooleanProperty maZuiFengXIanYuJi_NoProperty() {
        if (maZuiFengXIanYuJi_No == null) {
            maZuiFengXIanYuJi_No = new SimpleBooleanProperty(false);
        }
        return maZuiFengXIanYuJi_No;
    }

    public void setMaZuiFengXIanYuJi_No(boolean maZuiFengXIanYuJi_No) {
        this.maZuiFengXIanYuJi_No.set(maZuiFengXIanYuJi_No);
    }

    public boolean isYuJiShouShuShiJian() {
        return yuJiShouShuShiJian.get();
    }

    public BooleanProperty yuJiShouShuShiJianProperty() {
        if (yuJiShouShuShiJian == null) {
            yuJiShouShuShiJian = new SimpleBooleanProperty(false);
        }
        return yuJiShouShuShiJian;
    }

    public void setYuJiShouShuShiJian(boolean yuJiShouShuShiJian) {
        this.yuJiShouShuShiJian.set(yuJiShouShuShiJian);
    }

    public boolean isYuJiShiXueLiang() {
        return yuJiShiXueLiang.get();
    }

    public BooleanProperty yuJiShiXueLiangProperty() {
        if (yuJiShiXueLiang == null) {
            yuJiShiXueLiang = new SimpleBooleanProperty(false);
        }
        return yuJiShiXueLiang;
    }

    public void setYuJiShiXueLiang(boolean yuJiShiXueLiang) {
        this.yuJiShiXueLiang.set(yuJiShiXueLiang);
    }

    public boolean isShouShuGuanZhuDIan() {
        return shouShuGuanZhuDIan.get();
    }

    public BooleanProperty shouShuGuanZhuDIanProperty() {
        if (shouShuGuanZhuDIan == null) {
            shouShuGuanZhuDIan = new SimpleBooleanProperty(false);
        }
        return shouShuGuanZhuDIan;
    }

    public void setShouShuGuanZhuDIan(boolean shouShuGuanZhuDIan) {
        this.shouShuGuanZhuDIan.set(shouShuGuanZhuDIan);
    }

    public boolean isShouShuYiShiChenShuQiTa() {
        return shouShuYiShiChenShuQiTa.get();
    }

    public BooleanProperty shouShuYiShiChenShuQiTaProperty() {
        if (shouShuYiShiChenShuQiTa == null) {
            shouShuYiShiChenShuQiTa = new SimpleBooleanProperty(false);
        }
        return shouShuYiShiChenShuQiTa;
    }

    public void setShouShuYiShiChenShuQiTa(boolean shouShuYiShiChenShuQiTa) {
        this.shouShuYiShiChenShuQiTa.set(shouShuYiShiChenShuQiTa);
    }

    public boolean isMaZuiGuanZhuDian() {
        return maZuiGuanZhuDian.get();
    }

    public BooleanProperty maZuiGuanZhuDianProperty() {
        if (maZuiGuanZhuDian == null) {
            maZuiGuanZhuDian = new SimpleBooleanProperty(false);
        }
        return maZuiGuanZhuDian;
    }

    public void setMaZuiGuanZhuDian(boolean maZuiGuanZhuDian) {
        this.maZuiGuanZhuDian.set(maZuiGuanZhuDian);
    }

    public boolean isMaZuiYiShiChenShiQiTa() {
        return maZuiYiShiChenShiQiTa.get();
    }

    public BooleanProperty maZuiYiShiChenShiQiTaProperty() {
        if (maZuiYiShiChenShiQiTa == null) {
            maZuiYiShiChenShiQiTa = new SimpleBooleanProperty(false);
        }
        return maZuiYiShiChenShiQiTa;
    }

    public void setMaZuiYiShiChenShiQiTa(boolean maZuiYiShiChenShiQiTa) {
        this.maZuiYiShiChenShiQiTa.set(maZuiYiShiChenShiQiTa);
    }

    public boolean isShouShuXuYaoSheBei() {
        return shouShuXuYaoSheBei.get();
    }

    public BooleanProperty shouShuXuYaoSheBeiProperty() {
        if (shouShuXuYaoSheBei == null) {
            shouShuXuYaoSheBei = new SimpleBooleanProperty(false);
        }
        return shouShuXuYaoSheBei;
    }

    public void setShouShuXuYaoSheBei(boolean shouShuXuYaoSheBei) {
        this.shouShuXuYaoSheBei.set(shouShuXuYaoSheBei);
    }

    public boolean isWuPinMieJunHeGe() {
        return wuPinMieJunHeGe.get();
    }

    public BooleanProperty wuPinMieJunHeGeProperty() {
        if (wuPinMieJunHeGe == null) {
            wuPinMieJunHeGe = new SimpleBooleanProperty(false);
        }
        return wuPinMieJunHeGe;
    }

    public void setWuPinMieJunHeGe(boolean wuPinMieJunHeGe) {
        this.wuPinMieJunHeGe.set(wuPinMieJunHeGe);
    }

    public boolean isYiQiSheBei() {
        return yiQiSheBei.get();
    }

    public BooleanProperty yiQiSheBeiProperty() {
        if (yiQiSheBei == null) {
            yiQiSheBei = new SimpleBooleanProperty(false);
        }
        return yiQiSheBei;
    }

    public void setYiQiSheBei(boolean yiQiSheBei) {
        this.yiQiSheBei.set(yiQiSheBei);
    }

    public boolean isShuQianShuZHongTeShuQingKuang() {
        return shuQianShuZHongTeShuQingKuang.get();
    }

    public BooleanProperty shuQianShuZHongTeShuQingKuangProperty() {
        if (shuQianShuZHongTeShuQingKuang == null) {
            shuQianShuZHongTeShuQingKuang = new SimpleBooleanProperty(false);
        }
        return shuQianShuZHongTeShuQingKuang;
    }

    public void setShuQianShuZHongTeShuQingKuang(boolean shuQianShuZHongTeShuQingKuang) {
        this.shuQianShuZHongTeShuQingKuang.set(shuQianShuZHongTeShuQingKuang);
    }

    public boolean isHuShiChenShuQiTa() {
        return huShiChenShuQiTa.get();
    }

    public BooleanProperty huShiChenShuQiTaProperty() {
        if (huShiChenShuQiTa == null) {
            huShiChenShuQiTa = new SimpleBooleanProperty(false);
        }
        return huShiChenShuQiTa;
    }

    public void setHuShiChenShuQiTa(boolean huShiChenShuQiTa) {
        this.huShiChenShuQiTa.set(huShiChenShuQiTa);
    }

    public boolean isShuQianYingXiang_Yes() {
        return shuQianYingXiang_Yes.get();
    }

    public BooleanProperty shuQianYingXiang_YesProperty() {
        if (shuQianYingXiang_Yes == null) {
            shuQianYingXiang_Yes = new SimpleBooleanProperty(false);
        }
        return shuQianYingXiang_Yes;
    }

    public void setShuQianYingXiang_Yes(boolean shuQianYingXiang_Yes) {
        this.shuQianYingXiang_Yes.set(shuQianYingXiang_Yes);
    }

    public boolean isShuQianYingXiang_No() {
        return shuQianYingXiang_No.get();
    }

    public BooleanProperty shuQianYingXiang_NoProperty() {
        if (shuQianYingXiang_No == null) {
            shuQianYingXiang_No = new SimpleBooleanProperty(false);
        }
        return shuQianYingXiang_No;
    }

    public void setShuQianYingXiang_No(boolean shuQianYingXiang_No) {
        this.shuQianYingXiang_No.set(shuQianYingXiang_No);
    }

    public boolean isLiShiXinXi_Yes() {
        return liShiXinXi_Yes.get();
    }

    public BooleanProperty liShiXinXi_YesProperty() {
        if (liShiXinXi_Yes == null) {
            liShiXinXi_Yes = new SimpleBooleanProperty(false);
        }
        return liShiXinXi_Yes;
    }

    public void setLiShiXinXi_Yes(boolean liShiXinXi_Yes) {
        this.liShiXinXi_Yes.set(liShiXinXi_Yes);
    }

    public boolean isLiShiXinXi_No() {
        return liShiXinXi_No.get();
    }

    public BooleanProperty liShiXinXi_NoProperty() {
        if (liShiXinXi_No == null) {
            liShiXinXi_No = new SimpleBooleanProperty(false);
        }
        return liShiXinXi_No;
    }

    public void setLiShiXinXi_No(boolean liShiXinXi_No) {
        this.liShiXinXi_No.set(liShiXinXi_No);
    }

    public boolean isShiJiShouShuFanfgShi_Yes() {
        return shiJiShouShuFanfgShi_Yes.get();
    }

    public BooleanProperty shiJiShouShuFanfgShi_YesProperty() {
        if (shiJiShouShuFanfgShi_Yes == null) {
            shiJiShouShuFanfgShi_Yes = new SimpleBooleanProperty(false);
        }
        return shiJiShouShuFanfgShi_Yes;
    }

    public void setShiJiShouShuFanfgShi_Yes(boolean shiJiShouShuFanfgShi_Yes) {
        this.shiJiShouShuFanfgShi_Yes.set(shiJiShouShuFanfgShi_Yes);
    }

    public boolean isShiJiShouShuFanfgShi_No() {
        return shiJiShouShuFanfgShi_No.get();
    }

    public BooleanProperty shiJiShouShuFanfgShi_NoProperty() {
        if (shiJiShouShuFanfgShi_No == null) {
            shiJiShouShuFanfgShi_No = new SimpleBooleanProperty(false);
        }
        return shiJiShouShuFanfgShi_No;
    }

    public void setShiJiShouShuFanfgShi_No(boolean shiJiShouShuFanfgShi_No) {
        this.shiJiShouShuFanfgShi_No.set(shiJiShouShuFanfgShi_No);
    }

    public boolean isYongYaoShuXue_Yes() {
        return yongYaoShuXue_Yes.get();
    }

    public BooleanProperty yongYaoShuXue_YesProperty() {
        if (yongYaoShuXue_Yes == null) {
            yongYaoShuXue_Yes = new SimpleBooleanProperty(false);
        }
        return yongYaoShuXue_Yes;
    }

    public void setYongYaoShuXue_Yes(boolean yongYaoShuXue_Yes) {
        this.yongYaoShuXue_Yes.set(yongYaoShuXue_Yes);
    }

    public boolean isYongYaoShuXue_No() {
        return yongYaoShuXue_No.get();
    }

    public BooleanProperty yongYaoShuXue_NoProperty() {
        if (yongYaoShuXue_No == null) {
            yongYaoShuXue_No = new SimpleBooleanProperty(false);
        }
        return yongYaoShuXue_No;
    }

    public void setYongYaoShuXue_No(boolean yongYaoShuXue_No) {
        this.yongYaoShuXue_No.set(yongYaoShuXue_No);
    }

    public boolean isYongWuQingDian_Yes() {
        return yongWuQingDian_Yes.get();
    }

    public BooleanProperty yongWuQingDian_YesProperty() {
        if (yongWuQingDian_Yes == null) {
            yongWuQingDian_Yes = new SimpleBooleanProperty(false);
        }
        return yongWuQingDian_Yes;
    }

    public void setYongWuQingDian_Yes(boolean yongWuQingDian_Yes) {
        this.yongWuQingDian_Yes.set(yongWuQingDian_Yes);
    }

    public boolean isYongWuQingDian_No() {
        return yongWuQingDian_No.get();
    }

    public BooleanProperty yongWuQingDian_NoProperty() {
        if (yongWuQingDian_No == null) {
            yongWuQingDian_No = new SimpleBooleanProperty(false);
        }
        return yongWuQingDian_No;
    }

    public void setYongWuQingDian_No(boolean yongWuQingDian_No) {
        this.yongWuQingDian_No.set(yongWuQingDian_No);
    }

    public boolean isBiaoBenQueRen_Yes() {
        return biaoBenQueRen_Yes.get();
    }

    public BooleanProperty biaoBenQueRen_YesProperty() {
        if (biaoBenQueRen_Yes == null) {
            biaoBenQueRen_Yes = new SimpleBooleanProperty(false);
        }
        return biaoBenQueRen_Yes;
    }

    public void setBiaoBenQueRen_Yes(boolean biaoBenQueRen_Yes) {
        this.biaoBenQueRen_Yes.set(biaoBenQueRen_Yes);
    }

    public boolean isBiaoBenQueRen_No() {
        return biaoBenQueRen_No.get();
    }

    public BooleanProperty biaoBenQueRen_NoProperty() {
        if (biaoBenQueRen_No == null) {
            biaoBenQueRen_No = new SimpleBooleanProperty(false);
        }
        return biaoBenQueRen_No;
    }

    public void setBiaoBenQueRen_No(boolean biaoBenQueRen_No) {
        this.biaoBenQueRen_No.set(biaoBenQueRen_No);
    }

    public boolean isLiShiPiFuWanZheng_Yes() {
        return liShiPiFuWanZheng_Yes.get();
    }

    public BooleanProperty liShiPiFuWanZheng_YesProperty() {
        if (liShiPiFuWanZheng_Yes == null) {
            liShiPiFuWanZheng_Yes = new SimpleBooleanProperty(false);
        }
        return liShiPiFuWanZheng_Yes;
    }

    public void setLiShiPiFuWanZheng_Yes(boolean liShiPiFuWanZheng_Yes) {
        this.liShiPiFuWanZheng_Yes.set(liShiPiFuWanZheng_Yes);
    }

    public boolean isLiShiPiFuWanZheng_No() {
        return liShiPiFuWanZheng_No.get();
    }

    public BooleanProperty liShiPiFuWanZheng_NoProperty() {
        if (liShiPiFuWanZheng_No == null) {
            liShiPiFuWanZheng_No = new SimpleBooleanProperty(false);
        }
        return liShiPiFuWanZheng_No;
    }

    public void setLiShiPiFuWanZheng_No(boolean liShiPiFuWanZheng_No) {
        this.liShiPiFuWanZheng_No.set(liShiPiFuWanZheng_No);
    }

    public boolean isWaiZhouJingMaiTongLu() {
        return waiZhouJingMaiTongLu.get();
    }

    public BooleanProperty waiZhouJingMaiTongLuProperty() {
        if (waiZhouJingMaiTongLu == null) {
            waiZhouJingMaiTongLu = new SimpleBooleanProperty();
        }
        return waiZhouJingMaiTongLu;
    }

    public void setWaiZhouJingMaiTongLu(boolean waiZhouJingMaiTongLu) {
        this.waiZhouJingMaiTongLu.set(waiZhouJingMaiTongLu);
    }

    public boolean isJingMaiTongLu() {
        return jingMaiTongLu.get();
    }

    public BooleanProperty jingMaiTongLuProperty() {
        if (jingMaiTongLu == null) {
            jingMaiTongLu = new SimpleBooleanProperty(false);
        }
        return jingMaiTongLu;
    }

    public void setJingMaiTongLu(boolean jingMaiTongLu) {
        this.jingMaiTongLu.set(jingMaiTongLu);
    }

    public boolean isDongMaiTongLu() {
        return dongMaiTongLu.get();
    }

    public BooleanProperty dongMaiTongLuProperty() {
        if (dongMaiTongLu == null) {
            dongMaiTongLu = new SimpleBooleanProperty(false);
        }
        return dongMaiTongLu;
    }

    public void setDongMaiTongLu(boolean dongMaiTongLu) {
        this.dongMaiTongLu.set(dongMaiTongLu);
    }

    public boolean isQiGUanChaGuan() {
        return qiGUanChaGuan.get();
    }

    public BooleanProperty qiGUanChaGuanProperty() {
        if (qiGUanChaGuan == null) {
            qiGUanChaGuan = new SimpleBooleanProperty(false);
        }
        return qiGUanChaGuan;
    }

    public void setQiGUanChaGuan(boolean qiGUanChaGuan) {
        this.qiGUanChaGuan.set(qiGUanChaGuan);
    }

    public boolean isShangKouYinLiu() {
        return shangKouYinLiu.get();
    }

    public BooleanProperty shangKouYinLiuProperty() {
        if (shangKouYinLiu == null) {
            shangKouYinLiu = new SimpleBooleanProperty(false);
        }
        return shangKouYinLiu;
    }

    public BooleanProperty ICUProperty() {
        if (ICU == null) {
            ICU = new SimpleBooleanProperty(false);
        }
        return ICU;
    }

    public void setShangKouYinLiu(boolean shangKouYinLiu) {
        this.shangKouYinLiu.set(shangKouYinLiu);
    }

    public boolean isWeiGuan() {
        return weiGuan.get();
    }

    public BooleanProperty weiGuanProperty() {
        if (weiGuan == null) {
            weiGuan = new SimpleBooleanProperty(false);
        }
        return weiGuan;
    }

    public void setWeiGuan(boolean weiGuan) {
        this.weiGuan.set(weiGuan);
    }

    public boolean isNiaoGuan() {
        return niaoGuan.get();
    }

    public BooleanProperty niaoGuanProperty() {
        if (niaoGuan == null) {
            niaoGuan = new SimpleBooleanProperty(false);
        }
        return niaoGuan;
    }

    public void setNiaoGuan(boolean niaoGuan) {
        this.niaoGuan.set(niaoGuan);
    }

    public boolean isGuanLuQiTa() {
        return guanLuQiTa.get();
    }

    public BooleanProperty guanLuQiTaProperty() {
        if (guanLuQiTa == null) {
            guanLuQiTa = new SimpleBooleanProperty(false);
        }
        return guanLuQiTa;
    }

    public void setGuanLuQiTa(boolean guanLuQiTa) {
        this.guanLuQiTa.set(guanLuQiTa);
    }

    public boolean isHuiFuShi() {
        return huiFuShi.get();
    }

    public BooleanProperty huiFuShiProperty() {
        if (huiFuShi == null) {
            huiFuShi = new SimpleBooleanProperty(false);
        }
        return huiFuShi;
    }

    public void setHuiFuShi(boolean huiFuShi) {
        this.huiFuShi.set(huiFuShi);
    }

    public boolean isBingFang() {
        return bingFang.get();
    }

    public BooleanProperty bingFangProperty() {
        if (bingFang == null) {
            bingFang = new SimpleBooleanProperty(false);
        }
        return bingFang;
    }

    public void setBingFang(boolean bingFang) {
        this.bingFang.set(bingFang);
    }

    public boolean isICU() {
        return ICU.get();
    }

    public BooleanProperty iCUProperty() {
        if (ICU == null) {
            ICU = new SimpleBooleanProperty(false);
        }
        return ICU;
    }

    public void setICU(boolean iCU) {
        this.ICU.set(iCU);
    }

    public boolean isJiZhen() {
        return jiZhen.get();
    }

    public BooleanProperty jiZhenProperty() {
        if (jiZhen == null) {
            jiZhen = new SimpleBooleanProperty(false);
        }
        return jiZhen;
    }

    public void setJiZhen(boolean jiZhen) {
        this.jiZhen.set(jiZhen);
    }

    public boolean isLiYuan() {
        return liYuan.get();
    }

    public BooleanProperty liYuanProperty() {
        if (liYuan == null) {
            liYuan = new SimpleBooleanProperty(false);
        }
        return liYuan;
    }

    public void setLiYuan(boolean liYuan) {
        this.liYuan.set(liYuan);
    }

    public boolean isGeRenXinXi_Yes() {
        return geRenXinXi_Yes.get();
    }

    public BooleanProperty geRenXinXi_YesProperty() {
        if (geRenXinXi_Yes == null) {
            geRenXinXi_Yes = new SimpleBooleanProperty(false);
        }
        return geRenXinXi_Yes;
    }

    public void setGeRenXinXi_Yes(boolean geRenXinXi_Yes) {
        this.geRenXinXi_Yes.set(geRenXinXi_Yes);
    }

    public boolean isGeRenXinXi_No() {
        return geRenXinXi_No.get();
    }

    public BooleanProperty geRenXinXi_NoProperty() {
        if (geRenXinXi_No == null) {
            geRenXinXi_No = new SimpleBooleanProperty(false);
        }
        return geRenXinXi_No;
    }

    public void setGeRenXinXi_No(boolean geRenXinXi_No) {
        this.geRenXinXi_No.set(geRenXinXi_No);
    }

    public boolean isShoushuFangShi_Yes() {
        return shoushuFangShi_Yes.get();
    }

    public BooleanProperty shoushuFangShi_YesProperty() {
        if (shoushuFangShi_Yes == null) {
            shoushuFangShi_Yes = new SimpleBooleanProperty(false);
        }
        return shoushuFangShi_Yes;
    }

    public void setShoushuFangShi_Yes(boolean shoushuFangShi_Yes) {
        this.shoushuFangShi_Yes.set(shoushuFangShi_Yes);
    }

    public boolean isShoushuFangShi_No() {
        return shoushuFangShi_No.get();
    }

    public BooleanProperty shoushuFangShi_NoProperty() {
        if (shoushuFangShi_No == null) {
            shoushuFangShi_No = new SimpleBooleanProperty(false);
        }
        return shoushuFangShi_No;
    }

    public void setShoushuFangShi_No(boolean shoushuFangShi_No) {
        this.shoushuFangShi_No.set(shoushuFangShi_No);
    }

    public boolean isBuWeiBiaoShi_Yes() {
        return buWeiBiaoShi_Yes.get();
    }

    public BooleanProperty buWeiBiaoShi_YesProperty() {
        if (buWeiBiaoShi_Yes == null) {
            buWeiBiaoShi_Yes = new SimpleBooleanProperty(false);
        }
        return buWeiBiaoShi_Yes;
    }

    public void setBuWeiBiaoShi_Yes(boolean buWeiBiaoShi_Yes) {
        this.buWeiBiaoShi_Yes.set(buWeiBiaoShi_Yes);
    }

    public boolean isBuWeiBiaoShi_No() {
        return buWeiBiaoShi_No.get();
    }

    public BooleanProperty buWeiBiaoShi_NoProperty() {
        if (buWeiBiaoShi_No == null) {
            buWeiBiaoShi_No = new SimpleBooleanProperty(false);
        }
        return buWeiBiaoShi_No;
    }

    public void setBuWeiBiaoShi_No(boolean buWeiBiaoShi_No) {
        this.buWeiBiaoShi_No.set(buWeiBiaoShi_No);
    }

    public boolean isShouShuTIngYi_Yes() {
        return shouShuTIngYi_Yes.get();
    }

    public BooleanProperty shouShuTIngYi_YesProperty() {
        if (shouShuTIngYi_Yes == null) {
            shouShuTIngYi_Yes = new SimpleBooleanProperty(false);
        }
        return shouShuTIngYi_Yes;
    }

    public void setShouShuTIngYi_Yes(boolean shouShuTIngYi_Yes) {
        this.shouShuTIngYi_Yes.set(shouShuTIngYi_Yes);
    }

    public boolean isShouShuTIngYi_No() {
        return shouShuTIngYi_No.get();
    }

    public BooleanProperty shouShuTIngYi_NoProperty() {
        if (shouShuTIngYi_No == null) {
            shouShuTIngYi_No = new SimpleBooleanProperty(false);
        }
        return shouShuTIngYi_No;
    }

    public void setShouShuTIngYi_No(boolean shouShuTIngYi_No) {
        this.shouShuTIngYi_No.set(shouShuTIngYi_No);
    }

    public boolean isZhiQIngTongYi_Yes() {
        return zhiQIngTongYi_Yes.get();
    }

    public BooleanProperty zhiQIngTongYi_YesProperty() {
        if (zhiQIngTongYi_Yes == null) {
            zhiQIngTongYi_Yes = new SimpleBooleanProperty(false);
        }
        return zhiQIngTongYi_Yes;
    }

    public void setZhiQIngTongYi_Yes(boolean zhiQIngTongYi_Yes) {
        this.zhiQIngTongYi_Yes.set(zhiQIngTongYi_Yes);
    }

    public boolean isZhiQIngTongYi_No() {
        return zhiQIngTongYi_No.get();
    }

    public BooleanProperty zhiQIngTongYi_NoProperty() {
        if (zhiQIngTongYi_No == null) {
            zhiQIngTongYi_No = new SimpleBooleanProperty(false);
        }
        return zhiQIngTongYi_No;
    }

    public void setZhiQIngTongYi_No(boolean zhiQIngTongYi_No) {
        this.zhiQIngTongYi_No.set(zhiQIngTongYi_No);
    }

    public boolean isMaZuiFangShi_Yes() {
        return maZuiFangShi_Yes.get();
    }

    public BooleanProperty maZuiFangShi_YesProperty() {
        if (maZuiFangShi_Yes == null) {
            maZuiFangShi_Yes = new SimpleBooleanProperty(false);
        }
        return maZuiFangShi_Yes;
    }

    public void setMaZuiFangShi_Yes(boolean maZuiFangShi_Yes) {
        this.maZuiFangShi_Yes.set(maZuiFangShi_Yes);
    }

    public boolean isMaZuiFangShi_No() {
        return maZuiFangShi_No.get();
    }

    public BooleanProperty maZuiFangShi_NoProperty() {
        if (maZuiFangShi_No == null) {
            maZuiFangShi_No = new SimpleBooleanProperty(false);
        }
        return maZuiFangShi_No;
    }

    public void setMaZuiFangShi_No(boolean maZuiFangShi_No) {
        this.maZuiFangShi_No.set(maZuiFangShi_No);
    }

    public boolean isSheBeiJianCha_Yes() {
        return sheBeiJianCha_Yes.get();
    }

    public BooleanProperty sheBeiJianCha_YesProperty() {
        if (sheBeiJianCha_Yes == null) {
            sheBeiJianCha_Yes = new SimpleBooleanProperty(false);
        }
        return sheBeiJianCha_Yes;
    }

    public void setSheBeiJianCha_Yes(boolean sheBeiJianCha_Yes) {
        this.sheBeiJianCha_Yes.set(sheBeiJianCha_Yes);
    }

    public boolean isSheBeiJianCha_No() {
        return sheBeiJianCha_No.get();
    }

    public BooleanProperty sheBeiJianCha_NoProperty() {
        if (sheBeiJianCha_No == null) {
            sheBeiJianCha_No = new SimpleBooleanProperty(false);
        }
        return sheBeiJianCha_No;
    }

    public void setSheBeiJianCha_No(boolean sheBeiJianCha_No) {
        this.sheBeiJianCha_No.set(sheBeiJianCha_No);
    }

    public boolean isPiFuWanZheng_Yes() {
        return piFuWanZheng_Yes.get();
    }

    public BooleanProperty piFuWanZheng_YesProperty() {
        if (piFuWanZheng_Yes == null) {
            piFuWanZheng_Yes = new SimpleBooleanProperty(false);
        }
        return piFuWanZheng_Yes;
    }

    public void setPiFuWanZheng_Yes(boolean piFuWanZheng_Yes) {
        this.piFuWanZheng_Yes.set(piFuWanZheng_Yes);
    }

    public boolean isPiFuWanZheng_No() {
        return piFuWanZheng_No.get();
    }

    public BooleanProperty piFuWanZheng_NoProperty() {
        if (piFuWanZheng_No == null) {
            piFuWanZheng_No = new SimpleBooleanProperty(false);
        }
        return piFuWanZheng_No;
    }

    public void setPiFuWanZheng_No(boolean piFuWanZheng_No) {
        this.piFuWanZheng_No.set(piFuWanZheng_No);
    }

    public boolean isTiNeiZhiRuWu_yes() {
        return tiNeiZhiRuWu_yes.get();
    }

    public BooleanProperty tiNeiZhiRuWu_yesProperty() {
        if (tiNeiZhiRuWu_yes == null) {
            tiNeiZhiRuWu_yes = new SimpleBooleanProperty(false);
        }
        return tiNeiZhiRuWu_yes;
    }

    public void setTiNeiZhiRuWu_yes(boolean tiNeiZhiRuWu_yes) {
        this.tiNeiZhiRuWu_yes.set(tiNeiZhiRuWu_yes);
    }

    public boolean isShuYePiFu_Yes() {
        return shuYePiFu_Yes.get();
    }

    public BooleanProperty shuYePiFu_YesProperty() {
        if (shuYePiFu_Yes == null) {
            shuYePiFu_Yes = new SimpleBooleanProperty(false);
        }
        return shuYePiFu_Yes;
    }

    public void setShuYePiFu_Yes(boolean shuYePiFu_Yes) {
        this.shuYePiFu_Yes.set(shuYePiFu_Yes);
    }

    public boolean isShuYePiFu_No() {
        return shuYePiFu_No.get();
    }

    public BooleanProperty shuYePiFu_NoProperty() {
        if (shuYePiFu_No == null) {
            shuYePiFu_No = new SimpleBooleanProperty(false);
        }
        return shuYePiFu_No;
    }

    public void setShuYePiFu_No(boolean shuYePiFu_No) {
        this.shuYePiFu_No.set(shuYePiFu_No);
    }

    public boolean isJingMaiTongDao_Yes() {
        return jingMaiTongDao_Yes.get();
    }

    public BooleanProperty jingMaiTongDao_YesProperty() {
        if (jingMaiTongDao_Yes == null) {
            jingMaiTongDao_Yes = new SimpleBooleanProperty(false);
        }
        return jingMaiTongDao_Yes;
    }

    public void setJingMaiTongDao_Yes(boolean jingMaiTongDao_Yes) {
        this.jingMaiTongDao_Yes.set(jingMaiTongDao_Yes);
    }

    public boolean isJingMaiTongDao_No() {
        return jingMaiTongDao_No.get();
    }

    public BooleanProperty jingMaiTongDao_NoProperty() {
        if (jingMaiTongDao_No == null) {
            jingMaiTongDao_No = new SimpleBooleanProperty(false);
        }
        return jingMaiTongDao_No;
    }

    public void setJingMaiTongDao_No(boolean jingMaiTongDao_No) {
        this.jingMaiTongDao_No.set(jingMaiTongDao_No);
    }

    public boolean isGuoMinShi_Yes() {
        return guoMinShi_Yes.get();
    }

    public BooleanProperty guoMinShi_YesProperty() {
        if (guoMinShi_Yes == null) {
            guoMinShi_Yes = new SimpleBooleanProperty(false);
        }
        return guoMinShi_Yes;
    }

    public void setGuoMinShi_Yes(boolean guoMinShi_Yes) {
        this.guoMinShi_Yes.set(guoMinShi_Yes);
    }

    public boolean isGuoMinShi_No() {
        return guoMinShi_No.get();
    }

    public BooleanProperty guoMinShi_NoProperty() {
        if (guoMinShi_No == null) {
            guoMinShi_No = new SimpleBooleanProperty(false);
        }
        return guoMinShi_No;
    }

    public void setGuoMinShi_No(boolean guoMinShi_No) {
        this.guoMinShi_No.set(guoMinShi_No);
    }

    public boolean isKangJunYaoWu_Yes() {
        return kangJunYaoWu_Yes.get();
    }

    public BooleanProperty kangJunYaoWu_YesProperty() {
        if (kangJunYaoWu_Yes == null) {
            kangJunYaoWu_Yes = new SimpleBooleanProperty(false);
        }
        return kangJunYaoWu_Yes;
    }

    public void setKangJunYaoWu_Yes(boolean kangJunYaoWu_Yes) {
        this.kangJunYaoWu_Yes.set(kangJunYaoWu_Yes);
    }

    public boolean isKangJunYaoWu_No() {
        return kangJunYaoWu_No.get();
    }

    public BooleanProperty kangJunYaoWu_NoProperty() {
        if (kangJunYaoWu_No == null) {
            kangJunYaoWu_No = new SimpleBooleanProperty(false);
        }
        return kangJunYaoWu_No;
    }

    public void setKangJunYaoWu_No(boolean kangJunYaoWu_No) {
        this.kangJunYaoWu_No.set(kangJunYaoWu_No);
    }

    public boolean isShuQianBeiXue_Yes() {
        return shuQianBeiXue_Yes.get();
    }

    public BooleanProperty shuQianBeiXue_YesProperty() {
        if (shuQianBeiXue_Yes == null) {
            shuQianBeiXue_Yes = new SimpleBooleanProperty(false);
        }
        return shuQianBeiXue_Yes;
    }

    public void setShuQianBeiXue_Yes(boolean shuQianBeiXue_Yes) {
        this.shuQianBeiXue_Yes.set(shuQianBeiXue_Yes);
    }

    public boolean isShuQianBeiXue_No() {
        return shuQianBeiXue_No.get();
    }

    public BooleanProperty shuQianBeiXue_NoProperty() {
        if (shuQianBeiXue_No == null) {
            shuQianBeiXue_No = new SimpleBooleanProperty(false);
        }
        return shuQianBeiXue_No;
    }

    public void setShuQianBeiXue_No(boolean shuQianBeiXue_No) {
        this.shuQianBeiXue_No.set(shuQianBeiXue_No);
    }

    public boolean isJiaTi_Yes() {
        return jiaTi_Yes.get();
    }

    public BooleanProperty jiaTi_YesProperty() {
        if (jiaTi_Yes == null) {
            jiaTi_Yes = new SimpleBooleanProperty(false);
        }
        return jiaTi_Yes;
    }

    public void setJiaTi_Yes(boolean jiaTi_Yes) {
        this.jiaTi_Yes.set(jiaTi_Yes);
    }

    public boolean isJiaTi_No() {
        return jiaTi_No.get();
    }

    public BooleanProperty jiaTi_NoProperty() {
        if (jiaTi_No == null) {
            jiaTi_No = new SimpleBooleanProperty(false);
        }
        return jiaTi_No;
    }

    public void setJiaTi_No(boolean jiaTi_No) {
        this.jiaTi_No.set(jiaTi_No);
    }

    public boolean isYingXiangXue_Yes() {
        return yingXiangXue_Yes.get();
    }

    public BooleanProperty yingXiangXue_YesProperty() {
        if (yingXiangXue_Yes == null) {
            yingXiangXue_Yes = new SimpleBooleanProperty(false);
        }
        return yingXiangXue_Yes;
    }

    public void setYingXiangXue_Yes(boolean yingXiangXue_Yes) {
        this.yingXiangXue_Yes.set(yingXiangXue_Yes);
    }

    public boolean isYingXiangXue_No() {
        return yingXiangXue_No.get();
    }

    public BooleanProperty yingXiangXue_NoProperty() {
        if (yingXiangXue_No == null) {
            yingXiangXue_No = new SimpleBooleanProperty(false);
        }
        return yingXiangXue_No;
    }

    public void setYingXiangXue_No(boolean yingXiangXue_No) {
        this.yingXiangXue_No.set(yingXiangXue_No);
    }

    public boolean isTiNeiZhiRuWu_no() {
        return tiNeiZhiRuWu_no.get();
    }

    public BooleanProperty tiNeiZhiRuWu_noProperty() {
        if (tiNeiZhiRuWu_no == null) {
            tiNeiZhiRuWu_no = new SimpleBooleanProperty(false);
        }
        return tiNeiZhiRuWu_no;
    }

    public void setTiNeiZhiRuWu_no(boolean tiNeiZhiRuWu_no) {
        this.tiNeiZhiRuWu_no.set(tiNeiZhiRuWu_no);
    }



    public String getShouShuQianQiTa() {
        return shouShuQianQiTa.get();
    }

    public StringProperty shouShuQianQiTaProperty() {
        if (shouShuQianQiTa == null) {
            shouShuQianQiTa = new SimpleStringProperty();
        }
        return shouShuQianQiTa;
    }

    public void setShouShuQianQiTa(String shouShuQianQiTa) {
        this.shouShuQianQiTa.set(shouShuQianQiTa);
    }

    public String getChuShiQianQiTa() {
        return chuShiQianQiTa.get();
    }

    public StringProperty chuShiQianQiTaProperty() {
        if (chuShiQianQiTa == null) {
            chuShiQianQiTa = new SimpleStringProperty();
        }
        return chuShiQianQiTa;
    }

    public void setChuShiQianQiTa(String chuShiQianQiTa) {
        this.chuShiQianQiTa.set(chuShiQianQiTa);
    }

    public String getMaZuiQianQiTa() {
        return maZuiQianQiTa.get();
    }

    public StringProperty maZuiQianQiTaProperty() {
        if (maZuiQianQiTa == null) {
            maZuiQianQiTa = new SimpleStringProperty();
        }
        return maZuiQianQiTa;
    }

    public void setMaZuiQianQiTa(String maZuiQianQiTa) {
        this.maZuiQianQiTa.set(maZuiQianQiTa);
    }
    public String getSsysqm() {
        return ssysqm.get();
    }
    public StringProperty ssysqmProperty() {
        if(ssysqm==null){
            ssysqm = new SimpleStringProperty();
        }
        return ssysqm;
    }
    public void setSsysqm(String ssysqm) {
        this.ssysqm.set(ssysqm);
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
    public String getSshuqm() {
        return sshuqm.get();
    }
    public StringProperty sshuqmProperty() {
        if(sshuqm==null){
            sshuqm = new SimpleStringProperty();
        }
        return sshuqm;
    }
    public void setSshuqm(String sshuqm) {
        this.sshuqm.set(sshuqm);
    }

}
