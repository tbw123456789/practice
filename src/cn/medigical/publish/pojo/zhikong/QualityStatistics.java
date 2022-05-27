package cn.medigical.publish.pojo.zhikong;


import java.util.Date;


/**
 * Created by 博创医疗 on 2015/7/12.
 * Copyright by 博创医疗
 * 麻醉质控过程统计MazuiZhiKongTJ
 */
public class QualityStatistics {
    private String id;
    private Date date;   //统计的月份
    private Date lastEditTime; // 上次计算的时间
    private int mzksh24xsnsw; //围手术期死亡例数
    private int mzksh24xsnxtzt; //围手术期心跳骤停例数
    private int Mzhssqx; //麻醉后手术取消例数
    private int mzqjyzgmfy; //麻醉期间严重过敏反应发生例数
    private int zgnmzhyzsjxtbfzfs; //椎管内麻醉后严重神经系统并发症发生例数
    private int zxjmccyzbf; //中心静脉穿刺严重并发症发生例数
    private int zxjmcc; //中心静脉穿刺数   //!!!
    private int jnjmcc; //静脉静脉穿刺数
    private int ndmcc; //桡动脉穿刺数
    private int qmqgbghssfs; //全麻气管插管后声嘶发生例数
    private int mzsshxfhmfs; //麻醉手术后新发昏迷发生例数
    private int pACUrsdtwfs; //PACU入室低体温发生例数
    private int fjhzrICUfs; //非计划转入ICU发生例数
    private int fjhecqgbg; //非计划二次插管例数
    private int fjhecss; //非计划二次手术数
    private int fjhgbmzfs; //非计划改变麻醉方式数
    private int fjhecmz; //非计划二次麻醉数
    private int szsxsyfy; //术中输血输液反应数
    private int weiZhong; //危重患者例数   //!!!!
    private int hongXiBaoHuiShu; //红细胞回输例数   //!!!!
    private int ywsw; //意外死亡数
    private int wyqysza; //未预期意识障碍数
    private int spo2JiangDi; //氧饱和度重度降低数
    private int jsssycxyw; //结束时使用催醒药物数
    private int ywywxyfhxdgz; //因误咽误吸引发呼吸道梗阻数
    private int qtfyqxgsj; //其他非预期相关事件数
    private int xffs; //心肺复苏数
    private int xffscg; //复苏成功数
    private int zongfen; //Steward评分≥4数   //!!!
    private int PatientLinkCount;  //总手术数
    private int maZuiCount;     //总麻醉数
    private int asa1;    //ASA一级
    private int asaSw1; //ASA一级死亡数
    private int asa2;    //ASA二级
    private int asaSw2; //ASA二级死亡数
    private int asa3;    //ASA三级
    private int asaSw3; //ASA三级死亡数
    private int asa4;    //ASA四级
    private int asaSw4; //ASA四级死亡数
    private int asa5;    //ASA五级
    private int asaSw5; //ASA五级死亡数
    private int asa6;    //ASA六级
    private int ssqkfl1;  //手术分类1
    private int ssqkfl2;  //手术分类2
    private int ssqkfl3;  //手术分类3
    private int ssqkfl4;  //手术分类4
    private int jczzsh;  //浅层组织手术
    private int sczzss;  //深层组织手术
    private int qgss;  //器官手术
    private int kxnss; //腔隙内手术
    private int twxh; //体外循环

    private int shenJingZuZhi; //神经阻滞 //!!!
    private int jz;   //急诊

    private int zhuiGuanNeiMaZauiCount;  //椎管内麻醉 //!!!
    private int chaGuanQuanMaCount;    //插管全麻/全麻气管插管 //!!!
    private int feiChaGuanQuanMaCount;  //非插管全麻 //!!!
    private int chaGuanQuanMaAndZhuiGuan; //插管全麻+椎管内麻醉
    private int fuHeMaZuiCount;//复合麻醉 //!!!
    private int jingMaiMaZuiConut;//静脉麻醉例数 //!!!
    private int qiTaMaZuiCount;    //其它麻醉 //!!!
    private int jianHuMaZuiCount; // 监护麻醉
    private int yingmowai;//硬膜外


    private int shuHouZhenTong; //术后镇痛
    private int pACUzryc;   //PACU转出延迟
    private int ziTiXueShuZhu;    //字体血输注 400ml以上  //!!!!
    private int shuXueCount;           //输血400ml以上  //!!!!
    private int shqgbgbc;   //术后气管插管拔除
    private int ycdmccyzbfz;    //全麻相关并发症
    private int icuCount;     //转入ICU
    private int szsxblfy;        //术中输血不良反应
    private int dmdgtl; //动脉导管脱落
    private int other; //其他
    private int tsqgcg;//特殊气管插管

    public int getTsqgcg() {
        return tsqgcg;
    }

    public void setTsqgcg(int tsqgcg) {
        this.tsqgcg = tsqgcg;
    }

    public int getOther() {
        return other;
    }

    public void setOther(int other) {
        this.other = other;
    }

    public int getDmdgtl() {
        return dmdgtl;
    }

    public void setDmdgtl(int dmdgtl) {
        this.dmdgtl = dmdgtl;
    }

    public int getSzsxblfy() {
        return szsxblfy;
    }

    public void setSzsxblfy(int szsxblfy) {
        this.szsxblfy = szsxblfy;
    }

    public int getYjss() {
        return yjss;
    }

    public void setYjss(int yjss) {
        this.yjss = yjss;
    }

    public int getEjss() {
        return ejss;
    }

    public void setEjss(int ejss) {
        this.ejss = ejss;
    }

    public int getSjss() {
        return sjss;
    }

    public void setSjss(int sjss) {
        this.sjss = sjss;
    }

    public int getSsss() {
        return ssss;
    }

    public void setSsss(int ssss) {
        this.ssss = ssss;
    }

    private int yjss;    //一级手术
    private int ejss;    //二级手术
    private int sjss;    //三级手术
    private int ssss;    //四级手术


    public int getAsa1() {
        return asa1;
    }

    public void setAsa1(int asa1) {
        this.asa1 = asa1;
    }

    public int getAsa2() {
        return asa2;
    }

    public void setAsa2(int asa2) {
        this.asa2 = asa2;
    }


    public int getAsa3() {
        return asa3;
    }

    public void setAsa3(int asa3) {
        this.asa3 = asa3;
    }


    public int getAsa4() {
        return asa4;
    }

    public void setAsa4(int asa4) {
        this.asa4 = asa4;
    }


    public int getAsa5() {
        return asa5;
    }

    public void setAsa5(int asa5) {
        this.asa5 = asa5;
    }

    public int getAsa6() {
        return asa6;
    }

    public void setAsa6(int asa6) {
        this.asa6 = asa6;
    }

    public int getAsaSw1() {
        return asaSw1;
    }

    public void setAsaSw1(int asaSw1) {
        this.asaSw1 = asaSw1;
    }

    public int getAsaSw2() {
        return asaSw2;
    }

    public void setAsaSw2(int asaSw2) {
        this.asaSw2 = asaSw2;
    }

    public int getAsaSw3() {
        return asaSw3;
    }

    public void setAsaSw3(int asaSw3) {
        this.asaSw3 = asaSw3;
    }

    public int getAsaSw4() {
        return asaSw4;
    }

    public void setAsaSw4(int asaSw4) {
        this.asaSw4 = asaSw4;
    }

    public int getAsaSw5() {
        return asaSw5;
    }

    public void setAsaSw5(int asaSw5) {
        this.asaSw5 = asaSw5;
    }


    public int getIcuCount() {
        return icuCount;
    }

    public void setIcuCount(int icuCount) {
        this.icuCount = icuCount;
    }

    public int getPacuCount() {
        return pacuCount;
    }

    public void setPacuCount(int pacuCount) {
        this.pacuCount = pacuCount;
    }

    public int getMzpd_y() {
        return mzpd_y;
    }

    public void setMzpd_y(int mzpd_y) {
        this.mzpd_y = mzpd_y;
    }

    public int getMzpd_l() {
        return mzpd_l;
    }

    public void setMzpd_l(int mzpd_l) {
        this.mzpd_l = mzpd_l;
    }

    public int getMzpd_bq() {
        return mzpd_bq;
    }

    public void setMzpd_bq(int mzpd_bq) {
        this.mzpd_bq = mzpd_bq;
    }

    public int getMzpd_wx() {
        return mzpd_wx;
    }

    public void setMzpd_wx(int mzpd_wx) {
        this.mzpd_wx = mzpd_wx;
    }

    public int getZhuiGuanNeiXiaoGuo1() {
        return zhuiGuanNeiXiaoGuo1;
    }

    public void setZhuiGuanNeiXiaoGuo1(int zhuiGuanNeiXiaoGuo1) {
        this.zhuiGuanNeiXiaoGuo1 = zhuiGuanNeiXiaoGuo1;
    }

    public int getZhuiGuanNeiXiaoGuo2() {
        return zhuiGuanNeiXiaoGuo2;
    }

    public void setZhuiGuanNeiXiaoGuo2(int zhuiGuanNeiXiaoGuo2) {
        this.zhuiGuanNeiXiaoGuo2 = zhuiGuanNeiXiaoGuo2;
    }

    public int getZhuiGuanNeiXiaoGuo3() {
        return zhuiGuanNeiXiaoGuo3;
    }

    public void setZhuiGuanNeiXiaoGuo3(int zhuiGuanNeiXiaoGuo3) {
        this.zhuiGuanNeiXiaoGuo3 = zhuiGuanNeiXiaoGuo3;
    }

    public int getZhuiGuanNeiXiaoGuo4() {
        return zhuiGuanNeiXiaoGuo4;
    }

    public void setZhuiGuanNeiXiaoGuo4(int zhuiGuanNeiXiaoGuo4) {
        this.zhuiGuanNeiXiaoGuo4 = zhuiGuanNeiXiaoGuo4;
    }


    private int pacuCount;     //转入PACU
    private int pcia; //静脉PCA，PCIA
    private int pcsa; //皮下PCA，PCSA
    private int pcea; //硬膜外，PCEA
    private int Pcna; //神经丛，PCNA
    private int otherPCA; //其他PCA  //!!!!
    private int sgssjmcc; //锁骨上静脉穿刺数
    private int sgxsjmcc; //锁骨下静脉穿刺数
    private int gjmcc; //股静脉穿刺数
    private int zbdmcc; //足背动脉穿刺数
    private int mzhtt; //麻醉后头痛数 //!!!
    private int ccdhzly; //穿刺点红肿数
    private int dccg; //多次插管数
    private int dccc; //多次穿刺数
    private int exot; //恶心呕吐数
    private int zthdza; //肢体障碍数
    private int zdss; //重大手术数
    private int cpyjm;
    private int szzx;
    private int szyzdxy;
    private int ycdmccyzbfzfs;
    private int yongXueShu;
    private int yxhs;
    private int ghssfs;
    private int sssylgy;
    private int jxsx;
    private int pgcsssj;
    private int fssfwqgjzzss;
    private int csyd;
    private int dmcc;
    private int sygzz;
    private int jwzl;
    private int jyzl;
    private int teg;
    private int noPca;
    private int mzpd_y;
    private int mzpd_l;
    private int mzpd_bq;
    private int mzpd_wx;
    private int zhuiGuanNeiXiaoGuo1;
    private int zhuiGuanNeiXiaoGuo2;
    private int zhuiGuanNeiXiaoGuo3;
    private int zhuiGuanNeiXiaoGuo4;
    private int patToBf;
    private int patToPacu;
    private int patToIcu;
    private int laoNianHuanZhe;
    private int qiTa;  //!!!!
    private int ztfmzpgc;

    public String getId() {
        return id;
    }

    public int getZtfmzpgc() {
        return ztfmzpgc;
    }

    public void setZtfmzpgc(int ztfmzpgc) {
        this.ztfmzpgc = ztfmzpgc;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(Date lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public int getMzksh24xsnsw() {
        return mzksh24xsnsw;
    }

    public void setMzksh24xsnsw(int mzksh24xsnsw) {
        this.mzksh24xsnsw = mzksh24xsnsw;
    }

    public int getMzksh24xsnxtzt() {
        return mzksh24xsnxtzt;
    }

    public void setMzksh24xsnxtzt(int mzksh24xsnxtzt) {
        this.mzksh24xsnxtzt = mzksh24xsnxtzt;
    }

    public int getMzhssqx() {
        return Mzhssqx;
    }

    public void setMzhssqx(int mzhssqx) {
        Mzhssqx = mzhssqx;
    }

    public int getMzqjyzgmfy() {
        return mzqjyzgmfy;
    }

    public void setMzqjyzgmfy(int mzqjyzgmfy) {
        this.mzqjyzgmfy = mzqjyzgmfy;
    }

    public int getZgnmzhyzsjxtbfzfs() {
        return zgnmzhyzsjxtbfzfs;
    }

    public void setZgnmzhyzsjxtbfzfs(int zgnmzhyzsjxtbfzfs) {
        this.zgnmzhyzsjxtbfzfs = zgnmzhyzsjxtbfzfs;
    }

    public int getZxjmccyzbf() {
        return zxjmccyzbf;
    }

    public void setZxjmccyzbf(int zxjmccyzbf) {
        this.zxjmccyzbf = zxjmccyzbf;
    }

    public int getZxjmcc() {
        return zxjmcc;
    }

    public void setZxjmcc(int zxjmcc) {
        this.zxjmcc = zxjmcc;
    }

    public int getJnjmcc() {
        return jnjmcc;
    }

    public void setJnjmcc(int jnjmcc) {
        this.jnjmcc = jnjmcc;
    }

    public int getNdmcc() {
        return ndmcc;
    }

    public void setNdmcc(int ndmcc) {
        this.ndmcc = ndmcc;
    }

    public int getQmqgbghssfs() {
        return qmqgbghssfs;
    }

    public void setQmqgbghssfs(int qmqgbghssfs) {
        this.qmqgbghssfs = qmqgbghssfs;
    }

    public int getMzsshxfhmfs() {
        return mzsshxfhmfs;
    }

    public void setMzsshxfhmfs(int mzsshxfhmfs) {
        this.mzsshxfhmfs = mzsshxfhmfs;
    }

    public int getpACUrsdtwfs() {
        return pACUrsdtwfs;
    }

    public void setpACUrsdtwfs(int pACUrsdtwfs) {
        this.pACUrsdtwfs = pACUrsdtwfs;
    }

    public int getFjhzrICUfs() {
        return fjhzrICUfs;
    }

    public void setFjhzrICUfs(int fjhzrICUfs) {
        this.fjhzrICUfs = fjhzrICUfs;
    }

    public int getFjhecqgbg() {
        return fjhecqgbg;
    }

    public void setFjhecqgbg(int fjhecqgbg) {
        this.fjhecqgbg = fjhecqgbg;
    }

    public int getFjhecss() {
        return fjhecss;
    }

    public void setFjhecss(int fjhecss) {
        this.fjhecss = fjhecss;
    }

    public int getFjhgbmzfs() {
        return fjhgbmzfs;
    }

    public void setFjhgbmzfs(int fjhgbmzfs) {
        this.fjhgbmzfs = fjhgbmzfs;
    }

    public int getFjhecmz() {
        return fjhecmz;
    }

    public void setFjhecmz(int fjhecmz) {
        this.fjhecmz = fjhecmz;
    }

    public int getSzsxsyfy() {
        return szsxsyfy;
    }

    public void setSzsxsyfy(int szsxsyfy) {
        this.szsxsyfy = szsxsyfy;
    }

    public int getWeiZhong() {
        return weiZhong;
    }

    public void setWeiZhong(int weiZhong) {
        this.weiZhong = weiZhong;
    }

    public int getHongXiBaoHuiShu() {
        return hongXiBaoHuiShu;
    }

    public void setHongXiBaoHuiShu(int hongXiBaoHuiShu) {
        this.hongXiBaoHuiShu = hongXiBaoHuiShu;
    }

    public int getYwsw() {
        return ywsw;
    }

    public void setYwsw(int ywsw) {
        this.ywsw = ywsw;
    }

    public int getWyqysza() {
        return wyqysza;
    }

    public void setWyqysza(int wyqysza) {
        this.wyqysza = wyqysza;
    }

    public int getYwywxyfhxdgz() {
        return ywywxyfhxdgz;
    }

    public void setYwywxyfhxdgz(int ywywxyfhxdgz) {
        this.ywywxyfhxdgz = ywywxyfhxdgz;
    }

    public int getSpo2JiangDi() {
        return spo2JiangDi;
    }

    public void setSpo2JiangDi(int spo2JiangDi) {
        this.spo2JiangDi = spo2JiangDi;
    }

    public int getJsssycxyw() {
        return jsssycxyw;
    }

    public void setJsssycxyw(int jsssycxyw) {
        this.jsssycxyw = jsssycxyw;
    }

    public int getQtfyqxgsj() {
        return qtfyqxgsj;
    }

    public void setQtfyqxgsj(int qtfyqxgsj) {
        this.qtfyqxgsj = qtfyqxgsj;
    }

    public int getXffs() {
        return xffs;
    }

    public void setXffs(int xffs) {
        this.xffs = xffs;
    }

    public int getXffscg() {
        return xffscg;
    }

    public void setXffscg(int xffscg) {
        this.xffscg = xffscg;
    }

    public int getZongfen() {
        return zongfen;
    }

    public void setZongfen(int zongfen) {
        this.zongfen = zongfen;
    }

    public int getPatientLinkCount() {
        return PatientLinkCount;
    }

    public void setPatientLinkCount(int patientLinkCount) {
        PatientLinkCount = patientLinkCount;
    }

    public int getMaZuiCount() {
        return maZuiCount;
    }

    public void setMaZuiCount(int maZuiCount) {
        this.maZuiCount = maZuiCount;
    }

    public int getSsqkfl1() {
        return ssqkfl1;
    }

    public void setSsqkfl1(int ssqkfl1) {
        this.ssqkfl1 = ssqkfl1;
    }

    public int getSsqkfl2() {
        return ssqkfl2;
    }

    public void setSsqkfl2(int ssqkfl2) {
        this.ssqkfl2 = ssqkfl2;
    }

    public int getSsqkfl3() {
        return ssqkfl3;
    }

    public void setSsqkfl3(int ssqkfl3) {
        this.ssqkfl3 = ssqkfl3;
    }

    public int getSsqkfl4() {
        return ssqkfl4;
    }

    public void setSsqkfl4(int ssqkfl4) {
        this.ssqkfl4 = ssqkfl4;
    }

    public int getJczzsh() {
        return jczzsh;
    }

    public void setJczzsh(int jczzsh) {
        this.jczzsh = jczzsh;
    }

    public int getSczzss() {
        return sczzss;
    }

    public void setSczzss(int sczzss) {
        this.sczzss = sczzss;
    }

    public int getQgss() {
        return qgss;
    }

    public void setQgss(int qgss) {
        this.qgss = qgss;
    }

    public int getKxnss() {
        return kxnss;
    }

    public void setKxnss(int kxnss) {
        this.kxnss = kxnss;
    }

    public int getTwxh() {
        return twxh;
    }

    public void setTwxh(int twxh) {
        this.twxh = twxh;
    }

    public int getShenJingZuZhi() {
        return shenJingZuZhi;
    }

    public void setShenJingZuZhi(int shenJingZuZhi) {
        this.shenJingZuZhi = shenJingZuZhi;
    }

    public int getZhuiGuanNeiMaZauiCount() {
        return zhuiGuanNeiMaZauiCount;
    }

    public void setZhuiGuanNeiMaZauiCount(int zhuiGuanNeiMaZauiCount) {
        this.zhuiGuanNeiMaZauiCount = zhuiGuanNeiMaZauiCount;
    }

    public int getChaGuanQuanMaCount() {
        return chaGuanQuanMaCount;
    }

    public void setChaGuanQuanMaCount(int chaGuanQuanMaCount) {
        this.chaGuanQuanMaCount = chaGuanQuanMaCount;
    }

    public int getFeiChaGuanQuanMaCount() {
        return feiChaGuanQuanMaCount;
    }

    public void setFeiChaGuanQuanMaCount(int feiChaGuanQuanMaCount) {
        this.feiChaGuanQuanMaCount = feiChaGuanQuanMaCount;
    }

    public int getChaGuanQuanMaAndZhuiGuan() {
        return chaGuanQuanMaAndZhuiGuan;
    }

    public void setChaGuanQuanMaAndZhuiGuan(int chaGuanQuanMaAndZhuiGuan) {
        this.chaGuanQuanMaAndZhuiGuan = chaGuanQuanMaAndZhuiGuan;
    }

    public int getFuHeMaZuiCount() {
        return fuHeMaZuiCount;
    }

    public void setFuHeMaZuiCount(int fuHeMaZuiCount) {
        this.fuHeMaZuiCount = fuHeMaZuiCount;
    }

    public int getJingMaiMaZuiConut() {
        return jingMaiMaZuiConut;
    }

    public void setJingMaiMaZuiConut(int jingMaiMaZuiConut) {
        this.jingMaiMaZuiConut = jingMaiMaZuiConut;
    }

    public int getQiTaMaZuiCount() {
        return qiTaMaZuiCount;
    }

    public void setQiTaMaZuiCount(int qiTaMaZuiCount) {
        this.qiTaMaZuiCount = qiTaMaZuiCount;
    }

    public int getJianHuMaZuiCount() {
        return jianHuMaZuiCount;
    }

    public void setJianHuMaZuiCount(int jianHuMaZuiCount) {
        this.jianHuMaZuiCount = jianHuMaZuiCount;
    }

    public int getYingmowai() {
        return yingmowai;
    }

    public void setYingmowai(int yingmowai) {
        this.yingmowai = yingmowai;
    }

    public int getShuHouZhenTong() {
        return shuHouZhenTong;
    }

    public void setShuHouZhenTong(int shuHouZhenTong) {
        this.shuHouZhenTong = shuHouZhenTong;
    }

    public int getpACUzryc() {
        return pACUzryc;
    }

    public void setpACUzryc(int pACUzryc) {
        this.pACUzryc = pACUzryc;
    }

    public int getZiTiXueShuZhu() {
        return ziTiXueShuZhu;
    }

    public void setZiTiXueShuZhu(int ziTiXueShuZhu) {
        this.ziTiXueShuZhu = ziTiXueShuZhu;
    }

    public int getShuXueCount() {
        return shuXueCount;
    }

    public void setShuXueCount(int shuXueCount) {
        this.shuXueCount = shuXueCount;
    }

    public int getShqgbgbc() {
        return shqgbgbc;
    }

    public void setShqgbgbc(int shqgbgbc) {
        this.shqgbgbc = shqgbgbc;
    }

    public int getPcsa() {
        return pcsa;
    }

    public void setPcsa(int pcsa) {
        this.pcsa = pcsa;
    }

    public int getPcna() {
        return Pcna;
    }

    public void setPcna(int pcna) {
        Pcna = pcna;
    }

    public int getOtherPCA() {
        return otherPCA;
    }

    public void setOtherPCA(int otherPCA) {
        this.otherPCA = otherPCA;
    }

    public int getSgssjmcc() {
        return sgssjmcc;
    }

    public void setSgssjmcc(int sgssjmcc) {
        this.sgssjmcc = sgssjmcc;
    }

    public int getSgxsjmcc() {
        return sgxsjmcc;
    }

    public void setSgxsjmcc(int sgxsjmcc) {
        this.sgxsjmcc = sgxsjmcc;
    }

    public int getYcdmccyzbfz() {
        return ycdmccyzbfz;
    }

    public void setYcdmccyzbfz(int ycdmccyzbfz) {
        this.ycdmccyzbfz = ycdmccyzbfz;
    }

    public int getGjmcc() {
        return gjmcc;
    }

    public void setGjmcc(int gjmcc) {
        this.gjmcc = gjmcc;
    }

    public int getZbdmcc() {
        return zbdmcc;
    }

    public void setZbdmcc(int zbdmcc) {
        this.zbdmcc = zbdmcc;
    }

    public int getMzhtt() {
        return mzhtt;
    }

    public void setMzhtt(int mzhtt) {
        this.mzhtt = mzhtt;
    }

    public int getCcdhzly() {
        return ccdhzly;
    }

    public void setCcdhzly(int ccdhzly) {
        this.ccdhzly = ccdhzly;
    }

    public int getDccg() {
        return dccg;
    }

    public void setDccg(int dccg) {
        this.dccg = dccg;
    }

    public int getDccc() {
        return dccc;
    }

    public void setDccc(int dccc) {
        this.dccc = dccc;
    }

    public int getExot() {
        return exot;
    }

    public void setExot(int exot) {
        this.exot = exot;
    }

    public int getZthdza() {
        return zthdza;
    }

    public void setZthdza(int zthdza) {
        this.zthdza = zthdza;
    }

    public int getZdss() {
        return zdss;
    }

    public void setZdss(int zdss) {
        this.zdss = zdss;
    }

    public int getCpyjm() {
        return cpyjm;
    }

    public void setCpyjm(int cpyjm) {
        this.cpyjm = cpyjm;
    }

    public int getSzzx() {
        return szzx;
    }

    public void setSzzx(int szzx) {
        this.szzx = szzx;
    }

    public int getSzyzdxy() {
        return szyzdxy;
    }

    public void setSzyzdxy(int szyzdxy) {
        this.szyzdxy = szyzdxy;
    }

    public int getYcdmccyzbfzfs() {
        return ycdmccyzbfzfs;
    }

    public void setYcdmccyzbfzfs(int ycdmccyzbfzfs) {
        this.ycdmccyzbfzfs = ycdmccyzbfzfs;
    }

    public int getYongXueShu() {
        return yongXueShu;
    }

    public void setYongXueShu(int yongXueShu) {
        this.yongXueShu = yongXueShu;
    }

    public int getYxhs() {
        return yxhs;
    }

    public void setYxhs(int yxhs) {
        this.yxhs = yxhs;
    }

    public int getGhssfs() {
        return ghssfs;
    }

    public void setGhssfs(int ghssfs) {
        this.ghssfs = ghssfs;
    }

    public int getSssylgy() {
        return sssylgy;
    }

    public void setSssylgy(int sssylgy) {
        this.sssylgy = sssylgy;
    }

    public int getJxsx() {
        return jxsx;
    }

    public void setJxsx(int jxsx) {
        this.jxsx = jxsx;
    }

    public int getPgcsssj() {
        return pgcsssj;
    }

    public void setPgcsssj(int pgcsssj) {
        this.pgcsssj = pgcsssj;
    }

    public int getFssfwqgjzzss() {
        return fssfwqgjzzss;
    }

    public void setFssfwqgjzzss(int fssfwqgjzzss) {
        this.fssfwqgjzzss = fssfwqgjzzss;
    }

    public int getJz() {
        return jz;
    }

    public void setJz(int jz) {
        this.jz = jz;
    }

    public int getCsyd() {
        return csyd;
    }

    public void setCsyd(int csyd) {
        this.csyd = csyd;
    }

    public int getDmcc() {
        return dmcc;
    }

    public void setDmcc(int dmcc) {
        this.dmcc = dmcc;
    }

    public int getSygzz() {
        return sygzz;
    }

    public void setSygzz(int sygzz) {
        this.sygzz = sygzz;
    }

    public int getJwzl() {
        return jwzl;
    }

    public void setJwzl(int jwzl) {
        this.jwzl = jwzl;
    }

    public int getJyzl() {
        return jyzl;
    }

    public void setJyzl(int jyzl) {
        this.jyzl = jyzl;
    }

    public int getTeg() {
        return teg;
    }

    public void setTeg(int teg) {
        this.teg = teg;
    }

    public int getPcia() {
        return pcia;
    }

    public void setPcia(int pcia) {
        this.pcia = pcia;
    }

    public int getPcea() {
        return pcea;
    }

    public void setPcea(int pcea) {
        this.pcea = pcea;
    }

    public int getNoPca() {
        return noPca;
    }

    public void setNoPca(int noPca) {
        this.noPca = noPca;
    }

    public int getPatToBf() {
        return patToBf;
    }

    public void setPatToBf(int patToBf) {
        this.patToBf = patToBf;
    }

    public int getPatToPacu() {
        return patToPacu;
    }

    public void setPatToPacu(int patToPacu) {
        this.patToPacu = patToPacu;
    }

    public int getPatToIcu() {
        return patToIcu;
    }

    public void setPatToIcu(int patToIcu) {
        this.patToIcu = patToIcu;
    }

    public int getLaoNianHuanZhe() {
        return laoNianHuanZhe;
    }

    public void setLaoNianHuanZhe(int laoNianHuanZhe) {
        this.laoNianHuanZhe = laoNianHuanZhe;
    }

    public int getQiTa() {
        return qiTa;
    }

    public void setQiTa(int qiTa) {
        this.qiTa = qiTa;
    }


//    private List<PatientLink> laoNianHuanZheOperList = new ArrayList<>();
//    private List<PatientLink> patToBfOperList = new ArrayList<>();
//    private List<PatientLink> patToPacuOperList = new ArrayList<>();
//    private List<PatientLink> patToIcuOperList = new ArrayList<>();
//    private List<PatientLink> ZhuiGuanNeiXiaoGuo1OperList = new ArrayList<>();
//    private List<PatientLink> ZhuiGuanNeiXiaoGuo2OperList = new ArrayList<>();
//    private List<PatientLink> ZhuiGuanNeiXiaoGuo3OperList = new ArrayList<>();
//    private List<PatientLink> ZhuiGuanNeiXiaoGuo4OperList = new ArrayList<>();
//    private List<PatientLink> QuanMaXiaoGuo1OperList = new ArrayList<>();
//    private List<PatientLink> QuanMaXiaoGuo2OperList = new ArrayList<>();
//    private List<PatientLink> QuanMaXiaoGuo3OperList = new ArrayList<>();
//    private List<PatientLink> pciaOperList = new ArrayList<>();
//    private List<PatientLink> pceaOperList = new ArrayList<>();
//    private List<PatientLink> noPcaOperList = new ArrayList<>();
//    private List<PatientLink> tegOperList = new ArrayList<>();
//    private List<PatientLink> kongZhiXingJiangYaOperList = new ArrayList<>();
//    private List<PatientLink> xueYeJiaWenZhiLiaoOperList = new ArrayList<>();
//    private List<PatientLink> shiYongShuZhuGongZuoZhanOperList = new ArrayList<>();
//    private List<PatientLink> chaoShengYinDaoOperList = new ArrayList<>();
//    private List<PatientLink> dongMaiChuanCiOperList = new ArrayList<>();
//    private List<PatientLink> jiXingShiXueOperList = new ArrayList<>();
//    private List<PatientLink> pouGongChanShouShuOperList = new ArrayList<>();
//    private List<PatientLink> notShouShuFanWeiQiGuanSunShangOperList = new ArrayList<>();
//    private List<PatientLink> shouShuShiYiLiaoGanYuOperList = new ArrayList<>();
//    private List<PatientLink> gengGaiShouShuMethodOperList = new ArrayList<>();
//    private List<PatientLink> yongXueShuOperList = new ArrayList<>();
//    private List<PatientLink> yongXueHeLiShuOperList = new ArrayList<>();
//    private List<PatientLink> youChuangDongMaiCCBingFaOperList = new ArrayList<>();
//    private List<PatientLink> shuZhongDiXueYaOperList = new ArrayList<>();
//    private List<PatientLink> chuanPoYingJiMoOperList = new ArrayList<>();
//    private List<PatientLink> shuZhongZhiXiaoOperList = new ArrayList<>();
//    private List<PatientLink> operType1OperList = new ArrayList<>();
//    private List<PatientLink> operType2OperList = new ArrayList<>();
//    private List<PatientLink> operType3OperList = new ArrayList<>();
//    private List<PatientLink> operType4OperList = new ArrayList<>();
//    private List<PatientLink> qianCengZuZhiOperList = new ArrayList<>();
//    private List<PatientLink> shenBuZuZhiOperList = new ArrayList<>();
//    private List<PatientLink> qiGuanOperList = new ArrayList<>();
//    private List<PatientLink> qiangXiNeiOperList = new ArrayList<>();
//    private List<PatientLink> siWangOperList = new ArrayList<>();
//    private List<PatientLink> xinTiaoStopOperList = new ArrayList<>();
//    private List<PatientLink> cancelShouShuOperList = new ArrayList<>();
//    private List<PatientLink> guoMinYanZhongOperList = new ArrayList<>();
//    private List<PatientLink> shenJingBingFaOperList = new ArrayList<>();
//    private List<PatientLink> jingMaiChuanCiBingFaOperList = new ArrayList<>();
//    private List<PatientLink> zhongXinJingMaiChuanCiOperList = new ArrayList<>();
//    private List<PatientLink> jingNeiJingMaiChuanCiOperList = new ArrayList<>();
//    private List<PatientLink> naoDongMaiChuanCiOperList = new ArrayList<>();
//    private List<PatientLink> qiGuanShengSiOperList = new ArrayList<>();
//    private List<PatientLink> hunMiOperList = new ArrayList<>();
//    private List<PatientLink> diTiWenOperList = new ArrayList<>();
//    private List<PatientLink> zhuanRuICUOperList = new ArrayList<>();
//    private List<PatientLink> erCiChaGuanOperList = new ArrayList<>();
//    private List<PatientLink> notPlan2ShouShuOperList = new ArrayList<>();
//    private List<PatientLink> notPlan2MazuiFangShiOperList = new ArrayList<>();
//    private List<PatientLink> notPlan2MazuiOperList = new ArrayList<>();
//    private List<PatientLink> shuZhongShuXueShuYeFYOperList = new ArrayList<>();
//    private List<PatientLink> weiZhongOperList = new ArrayList<>();
//    private List<PatientLink> hongXiBaoHuiShuOperList = new ArrayList<>();
//    private List<PatientLink> yiWaiDeadOperList = new ArrayList<>();
//    private List<PatientLink> weiYuQiYiShiOperList = new ArrayList<>();
//    private List<PatientLink> spo2JiangDiOperList = new ArrayList<>();
//    private List<PatientLink> useCuiXingDrugOperList = new ArrayList<>();
//    private List<PatientLink> huXiDaoGengZuOperList = new ArrayList<>();
//    private List<PatientLink> otherFeiYuQiShiJianOperList = new ArrayList<>();
//    private List<PatientLink> xinFeiFuSuOperList = new ArrayList<>();
//    private List<PatientLink> fuSuChengGongOperList = new ArrayList<>();
//    private List<PatientLink> StewardBig4OperList = new ArrayList<>();
//    private List<PatientLink> maZuiCountOperList = new ArrayList<>();
//    private List<PatientLink> ASA1OperList = new ArrayList<>();
//    private List<PatientLink> ASA1DeadOperList = new ArrayList<>();
//    private List<PatientLink> ASA2OperList = new ArrayList<>();
//    private List<PatientLink> ASA2DeadOperList = new ArrayList<>();
//    private List<PatientLink> ASA3OperList = new ArrayList<>();
//    private List<PatientLink> ASA3DeadOperList = new ArrayList<>();
//    private List<PatientLink> ASA4OperList = new ArrayList<>();
//    private List<PatientLink> ASA4DeadOperList = new ArrayList<>();
//    private List<PatientLink> ASA5OperList = new ArrayList<>();
//    private List<PatientLink> ASA5DeadOperList = new ArrayList<>();
//    private List<PatientLink> ASA6OperList = new ArrayList<>();
//    private List<PatientLink> ASA6DeadOperList = new ArrayList<>();
//    private List<PatientLink> tiWaiXunHuanOperList = new ArrayList<>();
//    private List<PatientLink> zhuiGuanZuZhiOperList = new ArrayList<>();
//    private List<PatientLink> shenJingZuZhiOperList = new ArrayList<>();
//    private List<PatientLink> jiZhenOperList = new ArrayList<>();
//    private List<PatientLink> zhuiGuanNeiMaZauiCountOperList = new ArrayList<>();
//    private List<PatientLink> jingMaiMaZuiConutOperList = new ArrayList<>();
//    private List<PatientLink> chaGuanQuanMaCountOperList = new ArrayList<>();
//    private List<PatientLink> feiChaGuanQuanMaCountOperList = new ArrayList<>();
//    private List<PatientLink> chaGuanQuanMaAndZhuiGuanOperList = new ArrayList<>();
//    private List<PatientLink> fuHeMaZuiCountOperList = new ArrayList<>();
//    private List<PatientLink> qiTaMaZuiCountOperList = new ArrayList<>();
//    private List<PatientLink> shuHouZhenTongOperList = new ArrayList<>();
//    private List<PatientLink> zhuanChuYanChiOperList = new ArrayList<>();
//    private List<PatientLink> ziTiXueShuZhuOperList = new ArrayList<>();
//    private List<PatientLink> shuXueCountOperList = new ArrayList<>();
//    private List<PatientLink> qiGuanBaChuCountOperList = new ArrayList<>();
//    private List<PatientLink> ICUCountOperList = new ArrayList<>();
//    private List<PatientLink> PACUCountOperList = new ArrayList<>();
//    private List<PatientLink> jingMaiPCAOperList = new ArrayList<>();
//    private List<PatientLink> piXiaPCAOperList = new ArrayList<>();
//    private List<PatientLink> yingMoWaiPCAOperList = new ArrayList<>();
//    private List<PatientLink> shengJingCongPCAOperList = new ArrayList<>();
//    private List<PatientLink> otherPCAOperList = new ArrayList<>();
//    private List<PatientLink> suoGuShangJingMaiChuanCiOperList = new ArrayList<>(); //锁骨上静脉穿刺数
//    private List<PatientLink> suoGuXiaJingMaiChuanCiOperList = new ArrayList<>(); //锁骨下静脉穿刺数
//    private List<PatientLink> guJingMaiChuanCiOperList = new ArrayList<>(); //股静脉穿刺数
//    private List<PatientLink> zuBeiDongMaiChuanCiOperList = new ArrayList<>(); //足背动脉穿刺数
//    private List<PatientLink> mazuiHouTouTongOperList = new ArrayList<>(); //麻醉后头痛数
//    private List<PatientLink> chuanCiDianHongZongOperList = new ArrayList<>(); //穿刺点红肿数
//    private List<PatientLink> duoCiChaGuanOperList = new ArrayList<>(); //多次插管数
//    private List<PatientLink> duoCiChuanCiOperList = new ArrayList<>(); //多次穿刺数
//    private List<PatientLink> eXinOuTuOperList = new ArrayList<>(); //恶心呕吐数
//    private List<PatientLink> zhiTiZangAiOperList = new ArrayList<>(); //肢体障碍数
//    private List<PatientLink> zhongDaShouShuOperList = new ArrayList<>();
//    private List<PatientLink> qiTaOperList = new ArrayList<>();

}
