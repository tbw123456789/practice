package cn.medigical.publish.pojo.quality;

import org.springframework.data.mongodb.core.mapping.Field;


public class QualityPojo {
//	@Field(value="Sfbdj")
    private boolean sfbdj = false;
    /**
     * 其他内容
     */
//	@Field(value="QtText")
    private String qtText;
    /**
     * 麻醉后手术取消
     */
//	@Field(value="Mzhssqx")
    private Boolean mzhssqx= false ;
    /**
     * 非计划转入ICU发生
     */
//	@Field(value="FjhzrICUfs")
    private Boolean fjhzrICUfs= false ;
    /**
     * 非计划二次气管插管
     */
//	@Field(value="Fjhecqgcg")
    private Boolean fjhecqgcg = false;
    /**
     * 非计划改变麻醉方式
     */
//	@Field(value="Fjhgbmzfs")
    private Boolean fjhgbmzfs= false ;
    /**
     * 麻醉开始后24小时内死亡
     */
//	@Field(value="Mzksh24xsnsw")
    private Boolean mzksh24xsnsw = false;
    /**
     * 麻醉开始后24小时内心跳骤停
     */
//	@Field(value="Mzksh24xsnxtzt")
    private Boolean mzksh24xsnxtzt= false ;
    /**
     * 麻醉手术后新发昏迷发生
     */
//	@Field(value="Mzsshxfhmfs")
    private Boolean mzsshxfhmfs = false;
    /**
     * 成功
     */
//	@Field(value="Xffscg")
    private Boolean xffscg = false;
    /**
     * 不成功
     */
//	@Field(value="Xffsbcg")
    private Boolean xffsbcg = false;
    /**
     * 其他
     */
//	@Field(value="Qtyy")
    private Boolean qtyy = false;
    /**
     * 穿破硬脊膜
     */
//	@Field(value="Cpyjm")
    private Boolean cpyjm = false;
    /**
     * 麻醉后头痛
     */
//	@Field(value="Mzhtt")
    private Boolean mzhtt = false;
    /**
     * 术中知晓
     */
//	@Field(value="Szzx")
    private Boolean szzx = false;
    /**
     * 麻醉期间严重过敏反应发生
     */
//	@Field(value="Mzqjyzgmfyfs")
    private Boolean mzqjyzgmfyfs = false ;
    /**
     * 椎管内麻醉后严重神经系统并发症发生
     */
//	@Field(value="Zgnmzhyzsjxtbfzfs")
    private Boolean zgnmzhyzsjxtbfzfs = false;
    /**
     * 全麻气管插管后声嘶发生
     */
//	@Field(value="Qmqgcghssfs")
    private Boolean qmqgcghssfs = false;
    /**
     * 麻醉期间氧饱和度严重降低
     */
//	@Field(value="Mzqjybhdyzjd")
    private Boolean mzqjybhdyzjd = false;
    /**
     * 术中严重低血压
     */
//	@Field(value="Szyzdxy")
    private Boolean szyzdxy = false;
    /**
     * 颈内静脉穿刺
     */
//	@Field(value="Jnjmcc")
    private Boolean jnjmcc = false;
    /**
     * 锁骨上深静脉穿刺
     */
//	@Field(value="Sgssjmcc")
    private Boolean sgssjmcc = false;
    /**
     * 锁骨下深静脉穿刺
     */
//	@Field(value="Sgxsjmcc")
    private Boolean sgxsjmcc = false;
    /**
     * 股静脉穿刺
     */
//	@Field(value="Gjmcc")
    private Boolean gjmcc = false;
    /**
     * 中心静脉穿刺严重并发症发生
     */
//	@Field(value="Zxjmccyzbfzfs")
    private Boolean zxjmccyzbfzfs = false;
    /**
     * 桡动脉穿刺
     */
//	@Field(value="Ndmcc")
    private Boolean ndmcc = false;
    /**
     * 足背动脉穿刺
     */
//	@Field(value="Zbdmcc")
    private Boolean zbdmcc = false;
    /**
     * 有创动脉穿刺严重并发症发生
     */
//	@Field(value="Ycdmccyzbfzfs")
    private Boolean ycdmccyzbfzfs = false;
    /**
     * 术中输血不良反应
     */
//	@Field(value="Szsxblfy")
    private Boolean szsxblfy = false;
    /**
     * 合适
     */
//	@Field(value="Yxhs")
    private Boolean yxhs = false;
    /**
     * 不合适
     */
//	@Field(value="Yxbhs")
    private Boolean yxbhs = false;
    /**
     * 手术室内医疗干预(手术、抢救、台上检查、观察等)&gt;8小时
     */
//	@Field(value="Sssylgy")
    private Boolean sssylgy = false;
    /**
     * 非计划二次手术
     */
//	@Field(value="Fjhecss")
    private Boolean fjhecss = false;
    /**
     * 更改手术方式
     */
//	@Field(value="Ggssfs")
    private Boolean ggssfs = false;
    /**
     * 急性失血&gt;1600ml
     */
//	@Field(value="Jxsx")
    private Boolean jxsx = false;
    /**
     * 剖宫产手术时间&gt;3小时
     */
//	@Field(value="Pgcsssj")
    private Boolean pgcsssj = false;
    /**
     * 非手术范围器官及组织损伤
     */
//	@Field(value="Fssfwqgjzzss")
    private Boolean fssfwqgjzzss = false;
    /**
     * 手术切口分类I
     */
//	@Field(value="Ssqkfl1")
    private Boolean ssqkfl1 = false;
    /**
     * 手术切口分类II
     */
//	@Field(value="Ssqkfl2")
    private Boolean ssqkfl2 = false;
    /**
     * 手术切口分类III
     */
//	@Field(value="Ssqkfl3")
    private Boolean ssqkfl3 = false;
    /**
     * 手术切口分类IV
     */
//	@Field(value="Ssqkfl4")
    private Boolean ssqkfl4 = false;
    /**
     * 器官手术
     */
//	@Field(value="Qgss")
    private Boolean qgss = false;
    /**
     * 浅层组织手术
     */
//	@Field(value="Jczzsh")
    private Boolean jczzsh = false;
    /**
     * 深层组织手术
     */
//	@Field(value="Sczzss")
    private Boolean sczzss = false;
    /**
     * 腔隙内手术(打错字了)
     */
	//@Field(value="kxnss")
    private Boolean qxnss = false;

	private boolean sbzzss = false;
    /**
     * PACU转入延迟(入PACU超过3小时)
     */
//	@Field(value="PACUzryc")
    private Boolean pACUzryc = false;
    /**
     * 深层组织手术
     */
//	@Field(value="Dbzzss")
    private Boolean dbzzss = false;
    /**
     * PACU入室低体温发生
     */
//	@Field(value="PACUrsdtwfs")
    private Boolean pACUrsdtwfs= false ;
    /**
     * 恶心呕吐
     */
//	@Field(value="Exot")
    private Boolean exot = false;
    /**
     * 未预期意识障碍
     */
//	@Field(value="Wyqysza")
    private Boolean wyqysza = false;
    /**
     * 术后气管插管拔除
     */
//	@Field(value="Shqgbgbc")
    private Boolean shqgbgbc= false ;
    /**
     * 肢体活动障碍
     */
//	@Field(value="Zthdza")
    private Boolean zthdza = false;
    /**
     * Steward评分≥4
     */
//	@Field(value="Stewardpf")
    private Boolean stewardpf = false;
    /**
     * 结束时使用催醒药物
     */
//	@Field(value="Jsssycxyw")
    private Boolean jsssycxyw = false;
    /**
     * ASA-I死亡
     */
//	@Field(value="ASAsw1")
    private Boolean aSAsw1 = false;
    /**
     * ASA-II死亡
     */
//	@Field(value="ASAsw2")
    private Boolean aSAsw2 = false;
    /**
     * ASA-III死亡
     */
//	@Field(value="ASAsw3")
    private Boolean aSAsw3 = false;
    /**
     * ASA-IV死亡
     */
//	@Field(value="ASAsw4")
    private Boolean aSAsw4 = false;
    /**
     * ASA-V死亡
     */
//	@Field(value="ASAsw5")
    private Boolean aSAsw5 = false;
    /**
     * 氧饱和合度重度降低
     */
//	@Field(value="Ybhhdzdjd")
    private Boolean ybhhdzdjd = false;
    /**
     * 复苏成功
     */
//	@Field(value="Fscg")
    private Boolean fscg = false;
    /**
     * 术中更换气管导管
     */
//	@Field(value="Szghqgdg")
    private Boolean szghqgdg = false;
    /**
     * 意外死亡
     */
//	@Field(value="Ywsw")
    private Boolean ywsw = false;
    /**
     * 体外循环
     */
//	@Field(value="Twxh")
    private Boolean twxh = false;
    /**
     * 术中输血、输液反应
     */
//	@Field(value="Szsxsyfy")
    private Boolean szsxsyfy = false;
    /**
     * 重大手术
     */
//	@Field(value="Zdss")
    private Boolean zdss = false;
    /**
     * 一级手术
     */
//	@Field(value="Yjss")
    private Boolean yjss = false;
    /**
     * 二级手术
     */
//	@Field(value="Ejss")
    private Boolean ejss = false;
    /**
     * 三级手术
     */
//	@Field(value="Sjss")
    private Boolean sjss = false;
    /**
     * 四级手术
     */
//	@Field(value="Ssss")
    private Boolean ssss = false;
    /**
     * 中心静脉穿刺
     */
//	@Field(value="Zxjmcc")
    private Boolean zxjmcc= false ;
    /**
     * 中心V导管脱落
     */
//	@Field(value="ZxVddtl")
    private Boolean zxVddtl = false;
    /**
     * 动脉导管脱落
     */
//	@Field(value="Dmdgtl")
    private Boolean dmdgtl = false;
    /**
     * 多次穿刺
     */
//	@Field(value="Dccc")
    private Boolean dccc = false;
    /**
     * 穿刺点红肿流液
     */
//	@Field(value="Ccdhzly")
    private Boolean ccdhzly = false;
    /**
     * 非计划二次麻醉
     */
//	@Field(value="Fjhecmz")
    private Boolean fjhecmz = false;
    /**
     * 多次插管(错别字)
     */
//	@Field(value="Dcbg")
    private Boolean dcbg = false;
    public Boolean getRdmcc() {
		return rdmcc;
	}
	public void setRdmcc(Boolean rdmcc) {
		this.rdmcc = rdmcc;
	}
	/**
     * 其他非预期相关事件
     */
	//@Field(value="Qtfyqxgsj")
    private Boolean qtfyqxgsj = false;

	/**
     * 分娩镇痛转剖宫产
     */
	//@Field(value="Ztfmzpgc")
	private Boolean ztfmzpgc= false;

	/**
     * 心肺复苏
     */
	//@Field(value="Xffs")
	private Boolean xffs= false;

	/**
     * 桡动脉穿刺数
     */
	//@Field(value="Rdmcc")
	private Boolean rdmcc= false;


	/**
     * 自体血回收
     */
	//@Field(value="Ztxhs")
	private Boolean ztxhs= false;

	public Boolean getZtxhs() {
		return ztxhs;
	}
	public void setZtxhs(Boolean ztxhs) {
		this.ztxhs = ztxhs;
	}
	public Boolean getXffs() {
		return xffs;
	}
	public void setXffs(Boolean xffs) {
		this.xffs = xffs;
	}
	public Boolean getZtfmzpgc() {
		return ztfmzpgc;
	}
	public void setZtfmzpgc(Boolean ztfmzpgc) {
		this.ztfmzpgc = ztfmzpgc;
	}
	public boolean isSfbdj() {
		return sfbdj;
	}
	public void setSfbdj(boolean sfbdj) {
		this.sfbdj = sfbdj;
	}
	public String getQtText() {
		return qtText;
	}
	public void setQtText(String qtText) {
		this.qtText = qtText;
	}
	public Boolean getMzhssqx() {
		return mzhssqx;
	}
	public void setMzhssqx(Boolean mzhssqx) {
		this.mzhssqx = mzhssqx;
	}
	public Boolean getFjhzrICUfs() {
		return fjhzrICUfs;
	}
	public void setFjhzrICUfs(Boolean fjhzrICUfs) {
		this.fjhzrICUfs = fjhzrICUfs;
	}
	public Boolean getFjhecqgcg() {
		return fjhecqgcg;
	}
	public void setFjhecqgcg(Boolean fjhecqgcg) {
		this.fjhecqgcg = fjhecqgcg;
	}
	public Boolean getFjhgbmzfs() {
		return fjhgbmzfs;
	}
	public void setFjhgbmzfs(Boolean fjhgbmzfs) {
		this.fjhgbmzfs = fjhgbmzfs;
	}
	public Boolean getMzksh24xsnsw() {
		return mzksh24xsnsw;
	}
	public void setMzksh24xsnsw(Boolean mzksh24xsnsw) {
		this.mzksh24xsnsw = mzksh24xsnsw;
	}
	public Boolean getMzksh24xsnxtzt() {
		return mzksh24xsnxtzt;
	}
	public void setMzksh24xsnxtzt(Boolean mzksh24xsnxtzt) {
		this.mzksh24xsnxtzt = mzksh24xsnxtzt;
	}
	public Boolean getMzsshxfhmfs() {
		return mzsshxfhmfs;
	}
	public void setMzsshxfhmfs(Boolean mzsshxfhmfs) {
		this.mzsshxfhmfs = mzsshxfhmfs;
	}
	public Boolean getXffscg() {
		return xffscg;
	}
	public void setXffscg(Boolean xffscg) {
		this.xffscg = xffscg;
	}
	public Boolean getXffsbcg() {
		return xffsbcg;
	}
	public void setXffsbcg(Boolean xffsbcg) {
		this.xffsbcg = xffsbcg;
	}
	public Boolean getQtyy() {
		return qtyy;
	}
	public void setQtyy(Boolean qtyy) {
		this.qtyy = qtyy;
	}
	public Boolean getCpyjm() {
		return cpyjm;
	}
	public void setCpyjm(Boolean cpyjm) {
		this.cpyjm = cpyjm;
	}
	public Boolean getMzhtt() {
		return mzhtt;
	}
	public void setMzhtt(Boolean mzhtt) {
		this.mzhtt = mzhtt;
	}
	public Boolean getSzzx() {
		return szzx;
	}
	public void setSzzx(Boolean szzx) {
		this.szzx = szzx;
	}
	public Boolean getMzqjyzgmfyfs() {
		return mzqjyzgmfyfs;
	}
	public void setMzqjyzgmfyfs(Boolean mzqjyzgmfyfs) {
		this.mzqjyzgmfyfs = mzqjyzgmfyfs;
	}
	public Boolean getZgnmzhyzsjxtbfzfs() {
		return zgnmzhyzsjxtbfzfs;
	}
	public void setZgnmzhyzsjxtbfzfs(Boolean zgnmzhyzsjxtbfzfs) {
		this.zgnmzhyzsjxtbfzfs = zgnmzhyzsjxtbfzfs;
	}
	public Boolean getQmqgcghssfs() {
		return qmqgcghssfs;
	}
	public void setQmqgcghssfs(Boolean qmqgcghssfs) {
		this.qmqgcghssfs = qmqgcghssfs;
	}
	public Boolean getMzqjybhdyzjd() {
		return mzqjybhdyzjd;
	}
	public void setMzqjybhdyzjd(Boolean mzqjybhdyzjd) {
		this.mzqjybhdyzjd = mzqjybhdyzjd;
	}
	public Boolean getSzyzdxy() {
		return szyzdxy;
	}
	public void setSzyzdxy(Boolean szyzdxy) {
		this.szyzdxy = szyzdxy;
	}
	public Boolean getJnjmcc() {
		return jnjmcc;
	}
	public void setJnjmcc(Boolean jnjmcc) {
		this.jnjmcc = jnjmcc;
	}
	public Boolean getSgssjmcc() {
		return sgssjmcc;
	}
	public void setSgssjmcc(Boolean sgssjmcc) {
		this.sgssjmcc = sgssjmcc;
	}
	public Boolean getSgxsjmcc() {
		return sgxsjmcc;
	}
	public void setSgxsjmcc(Boolean sgxsjmcc) {
		this.sgxsjmcc = sgxsjmcc;
	}
	public Boolean getGjmcc() {
		return gjmcc;
	}
	public void setGjmcc(Boolean gjmcc) {
		this.gjmcc = gjmcc;
	}
	public Boolean getZxjmccyzbfzfs() {
		return zxjmccyzbfzfs;
	}
	public void setZxjmccyzbfzfs(Boolean zxjmccyzbfzfs) {
		this.zxjmccyzbfzfs = zxjmccyzbfzfs;
	}
	public Boolean getNdmcc() {
		return ndmcc;
	}
	public void setNdmcc(Boolean ndmcc) {
		this.ndmcc = ndmcc;
	}
	public Boolean getZbdmcc() {
		return zbdmcc;
	}
	public void setZbdmcc(Boolean zbdmcc) {
		this.zbdmcc = zbdmcc;
	}
	public Boolean getYcdmccyzbfzfs() {
		return ycdmccyzbfzfs;
	}
	public void setYcdmccyzbfzfs(Boolean ycdmccyzbfzfs) {
		this.ycdmccyzbfzfs = ycdmccyzbfzfs;
	}
	public Boolean getSzsxblfy() {
		return szsxblfy;
	}
	public void setSzsxblfy(Boolean szsxblfy) {
		this.szsxblfy = szsxblfy;
	}
	public Boolean getYxhs() {
		return yxhs;
	}
	public void setYxhs(Boolean yxhs) {
		this.yxhs = yxhs;
	}
	public Boolean getYxbhs() {
		return yxbhs;
	}
	public void setYxbhs(Boolean yxbhs) {
		this.yxbhs = yxbhs;
	}
	public Boolean getSssylgy() {
		return sssylgy;
	}
	public void setSssylgy(Boolean sssylgy) {
		this.sssylgy = sssylgy;
	}
	public Boolean getFjhecss() {
		return fjhecss;
	}
	public void setFjhecss(Boolean fjhecss) {
		this.fjhecss = fjhecss;
	}
	public Boolean getGgssfs() {
		return ggssfs;
	}
	public void setGgssfs(Boolean ggssfs) {
		this.ggssfs = ggssfs;
	}
	public Boolean getJxsx() {
		return jxsx;
	}
	public void setJxsx(Boolean jxsx) {
		this.jxsx = jxsx;
	}
	public Boolean getPgcsssj() {
		return pgcsssj;
	}
	public void setPgcsssj(Boolean pgcsssj) {
		this.pgcsssj = pgcsssj;
	}
	public Boolean getFssfwqgjzzss() {
		return fssfwqgjzzss;
	}
	public void setFssfwqgjzzss(Boolean fssfwqgjzzss) {
		this.fssfwqgjzzss = fssfwqgjzzss;
	}
	public Boolean getSsqkfl1() {
		return ssqkfl1;
	}
	public void setSsqkfl1(Boolean ssqkfl1) {
		this.ssqkfl1 = ssqkfl1;
	}
	public Boolean getSsqkfl2() {
		return ssqkfl2;
	}
	public void setSsqkfl2(Boolean ssqkfl2) {
		this.ssqkfl2 = ssqkfl2;
	}
	public Boolean getSsqkfl3() {
		return ssqkfl3;
	}
	public void setSsqkfl3(Boolean ssqkfl3) {
		this.ssqkfl3 = ssqkfl3;
	}
	public Boolean getSsqkfl4() {
		return ssqkfl4;
	}
	public void setSsqkfl4(Boolean ssqkfl4) {
		this.ssqkfl4 = ssqkfl4;
	}
	public Boolean getQgss() {
		return qgss;
	}
	public void setQgss(Boolean qgss) {
		this.qgss = qgss;
	}
	public Boolean getJczzsh() {
		return jczzsh;
	}
	public void setJczzsh(Boolean jczzsh) {
		this.jczzsh = jczzsh;
	}
	public Boolean getSczzss() {
		return sczzss;
	}
	public void setSczzss(Boolean sczzss) {
		this.sczzss = sczzss;
	}
	public Boolean getQxnss() {
		return qxnss;
	}
	public void setQxnss(Boolean qxnss) {
		this.qxnss = qxnss;
	}
	public Boolean getpACUzryc() {
		return pACUzryc;
	}
	public void setpACUzryc(Boolean pACUzryc) {
		this.pACUzryc = pACUzryc;
	}
	public Boolean getDbzzss() {
		return dbzzss;
	}
	public void setDbzzss(Boolean dbzzss) {
		this.dbzzss = dbzzss;
	}
	public Boolean getpACUrsdtwfs() {
		return pACUrsdtwfs;
	}
	public void setpACUrsdtwfs(Boolean pACUrsdtwfs) {
		this.pACUrsdtwfs = pACUrsdtwfs;
	}
	public Boolean getExot() {
		return exot;
	}
	public void setExot(Boolean exot) {
		this.exot = exot;
	}
	public Boolean getWyqysza() {
		return wyqysza;
	}
	public void setWyqysza(Boolean wyqysza) {
		this.wyqysza = wyqysza;
	}
	public Boolean getShqgbgbc() {
		return shqgbgbc;
	}
	public void setShqgbgbc(Boolean shqgbgbc) {
		this.shqgbgbc = shqgbgbc;
	}
	public Boolean getZthdza() {
		return zthdza;
	}
	public void setZthdza(Boolean zthdza) {
		this.zthdza = zthdza;
	}
	public Boolean getStewardpf() {
		return stewardpf;
	}
	public void setStewardpf(Boolean stewardpf) {
		this.stewardpf = stewardpf;
	}
	public Boolean getJsssycxyw() {
		return jsssycxyw;
	}
	public void setJsssycxyw(Boolean jsssycxyw) {
		this.jsssycxyw = jsssycxyw;
	}
	public Boolean getaSAsw1() {
		return aSAsw1;
	}
	public void setaSAsw1(Boolean aSAsw1) {
		this.aSAsw1 = aSAsw1;
	}
	public Boolean getaSAsw2() {
		return aSAsw2;
	}
	public void setaSAsw2(Boolean aSAsw2) {
		this.aSAsw2 = aSAsw2;
	}
	public Boolean getaSAsw3() {
		return aSAsw3;
	}
	public void setaSAsw3(Boolean aSAsw3) {
		this.aSAsw3 = aSAsw3;
	}
	public Boolean getaSAsw4() {
		return aSAsw4;
	}
	public void setaSAsw4(Boolean aSAsw4) {
		this.aSAsw4 = aSAsw4;
	}
	public Boolean getaSAsw5() {
		return aSAsw5;
	}
	public void setaSAsw5(Boolean aSAsw5) {
		this.aSAsw5 = aSAsw5;
	}
	public Boolean getYbhhdzdjd() {
		return ybhhdzdjd;
	}
	public void setYbhhdzdjd(Boolean ybhhdzdjd) {
		this.ybhhdzdjd = ybhhdzdjd;
	}
	public Boolean getFscg() {
		return fscg;
	}
	public void setFscg(Boolean fscg) {
		this.fscg = fscg;
	}
	public Boolean getSzghqgdg() {
		return szghqgdg;
	}
	public void setSzghqgdg(Boolean szghqgdg) {
		this.szghqgdg = szghqgdg;
	}
	public Boolean getYwsw() {
		return ywsw;
	}
	public void setYwsw(Boolean ywsw) {
		this.ywsw = ywsw;
	}
	public Boolean getTwxh() {
		return twxh;
	}
	public void setTwxh(Boolean twxh) {
		this.twxh = twxh;
	}
	public Boolean getSzsxsyfy() {
		return szsxsyfy;
	}
	public void setSzsxsyfy(Boolean szsxsyfy) {
		this.szsxsyfy = szsxsyfy;
	}
	public Boolean getZdss() {
		return zdss;
	}
	public void setZdss(Boolean zdss) {
		this.zdss = zdss;
	}
	public Boolean getYjss() {
		return yjss;
	}
	public void setYjss(Boolean yjss) {
		this.yjss = yjss;
	}
	public Boolean getEjss() {
		return ejss;
	}
	public void setEjss(Boolean ejss) {
		this.ejss = ejss;
	}
	public Boolean getSjss() {
		return sjss;
	}
	public void setSjss(Boolean sjss) {
		this.sjss = sjss;
	}
	public Boolean getSsss() {
		return ssss;
	}
	public void setSsss(Boolean ssss) {
		this.ssss = ssss;
	}
	public Boolean getZxjmcc() {
		return zxjmcc;
	}
	public void setZxjmcc(Boolean zxjmcc) {
		this.zxjmcc = zxjmcc;
	}
	public Boolean getZxVddtl() {
		return zxVddtl;
	}
	public void setZxVddtl(Boolean zxVddtl) {
		this.zxVddtl = zxVddtl;
	}
	public Boolean getDmdgtl() {
		return dmdgtl;
	}
	public void setDmdgtl(Boolean dmdgtl) {
		this.dmdgtl = dmdgtl;
	}
	public Boolean getDccc() {
		return dccc;
	}
	public void setDccc(Boolean dccc) {
		this.dccc = dccc;
	}
	public Boolean getCcdhzly() {
		return ccdhzly;
	}
	public void setCcdhzly(Boolean ccdhzly) {
		this.ccdhzly = ccdhzly;
	}
	public Boolean getFjhecmz() {
		return fjhecmz;
	}
	public void setFjhecmz(Boolean fjhecmz) {
		this.fjhecmz = fjhecmz;
	}
	public Boolean getDcbg() {
		return dcbg;
	}
	public void setDcbg(Boolean dcbg) {
		this.dcbg = dcbg;
	}
	public Boolean getQtfyqxgsj() {
		return qtfyqxgsj;
	}
	public void setQtfyqxgsj(Boolean qtfyqxgsj) {
		this.qtfyqxgsj = qtfyqxgsj;
	}

	public boolean getSbzzss() {
		return sbzzss;
	}

	public void setSbzzss(boolean sbzzss) {
		this.sbzzss = sbzzss;
	}
}
