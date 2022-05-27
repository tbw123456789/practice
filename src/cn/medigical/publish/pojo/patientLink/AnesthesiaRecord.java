package cn.medigical.publish.pojo.patientLink;

import java.util.Date;
import java.util.Map;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by 2018-06-07.
 *
 */

public class AnesthesiaRecord {
	/** 输血者*/
	private String bloodDonator;
	/** 拟施手术1 */
//	@Field(value="Nsss1")
	private String nsss1;
	/** 拟施手术2 */
//	@Field(value="Nsss2")
	private String nsss2;
	/** 拟施手术3 */
//	@Field(value="Nsss3")
	private String nsss3;
	/** 拟施手术4 */
//	@Field(value="Nsss4")
	private String nsss4;
	/** 拟施手术5 */
//	@Field(value="Nsss5")
	private String nsss5;
	/** 拟施手术6 */
//	@Field(value="Nsss6")
	private String nsss6;

	/** 术前诊断 */
//	@Field(value="Sqzd")
	private String sqzd;
	/** 术中诊断 */
//	@Field(value="Szzd")
	private String szzd;
	/** 主麻医师 Mongo的ID */
//	@Field(value="Zmys")
	private String zmys;
	/** 主麻医师 开始时间 */
	// private Date zmysStartTime =null;
	/** 主麻医师 结束时间 */
	// private Date zmysEndTime =null;
	/** 副麻医师 id号 */
//	@Field(value="Fmys1")
	private String fmys1;
	/** 副麻医师 2id号 */
//	@Field(value="Fmys2")
	private String fmys2;
	/** 副麻医师 3id号 */
//	@Field(value="Fmys3")
	private String fmys3;
	/** 副麻医师 4id号 */
//	@Field(value="Fmys4")
	private String fmys4;
	/** 副麻医师 开始时间 */
	// private Date fmysStartTime =null;
	/** 副麻医师 结束时间 */
	// private Date fmysEndTime =null;
	/** 接班医师1 id */
//	@Field(value="Jbys1")
	private String jbys1;
	/** 接班医师1 结束时间 */
	// private Date jbys1EndTime =null;
	/** 接班医师1 开始时间 */
	// private Date jbys1StartTime =null;
	/** 接班医师2 id */
//	@Field(value="Jbys2")
	private String jbys2;
	/** 接班医师2 开始时间 */
	// private Date jbys2StartTime =null;
	/** 接班医师2 结束时间 */
	// private Date jbys2EndTime =null;
	/** 抢救医师 */
//	@Field(value="Qjys")
	private String qjys;
	/** 专家医师 */
//	@Field(value="Zj")
	private String zj;
	/** 麻醉方法 */
//	@Field(value="Mzff")
	private String mzff;
//	@Field(value="MazuiMethodComp")
	private ComplicatedMethod mazuiMethodComp; // 麻醉方法 复杂的
	/** 手术医师1,主刀 Mongo的ID */
//	@Field(value="OperDoctor1")
	private String operDoctor1;
	/** 手术医师1 开始时间 */
	// private Date operDoctor1StartTime =null;
	/** 手术医师1 结束时间 */
	// private Date operDoctor1EndTime =null;
	/** 助手1 */
//	@Field(value="OperDoctor1Assistant1")
	private String operDoctor1Assistant1;
	/** 助手2 */
//	@Field(value="OperDoctor1Assistant2")
	private String operDoctor1Assistant2;
	/** 助手3 */
//	@Field(value="OperDoctor1Assistant3")
	private String operDoctor1Assistant3;

	/** 主刀医师2 id */
//	@Field(value="OperDoctor2")
	private String operDoctor2;
	/** 主刀医师2 开始时间 */
	// private Date operDoctor2StartTime =null;
	/** 主刀医师2 结束时间 */
	// private Date operDoctor2EndTime =null;
	/** 助手1 */
//	@Field(value="OperDoctor2Assistant1")
	private String operDoctor2Assistant1;
	/** 助手2 */
//	@Field(value="OperDoctor2Assistant2")
	private String operDoctor2Assistant2;
	/** 助手3 */
//	@Field(value="OperDoctor2Assistant3")
	private String operDoctor2Assistant3;

	/** 主刀医师3 id */
//	@Field(value="OperDoctor3")
	private String operDoctor3;
	/** 主刀医师3 开始时间 */
//	@Field(value="OperDoctor3StartTime")
	private Date operDoctor3StartTime = null;
	/** 主刀医师3 结束时间 */
//	@Field(value="OperDoctor3EndTime")
	private Date operDoctor3EndTime = null;
	/** 助手1 */
//	@Field(value="OperDoctor3Assistant1")
	private String operDoctor3Assistant1;
	/** 助手2 */
//	@Field(value="OperDoctor3Assistant2")
	private String operDoctor3Assistant2;
	/** 助手3 */
//	@Field(value="OperDoctor3Assistant3")
	private String operDoctor3Assistant3;
	/** 手术时体位 */
//	@Field(value="Sstw")
	private String sstw;
	/** 洗手护士1 id */
//	@Field(value="Xshs1")
	private String xshs1;
	/** 洗手护士1 开始时间 */
	// private Date xshs1StartTime =null;
	/** 洗手护士1 结束时间 */
	// private Date xshs1EndTime =null;
	/** 洗手护士2 id */
//	@Field(value="Xshs2")
	private String xshs2;
	/** 洗手护士2 开始时间 */
	// private Date xshs2StartTime =null;
	/** 洗手护士2 结束时间 */
	// private Date xshs2EndTime =null;
	/** 洗手护士3 id */
//	@Field(value="Xshs3")
	private String xshs3;
	/** 洗手护士3 开始时间 */
	// private Date xshs3StartTime =null;
	/** 洗手护士3 结束时间 */
	// private Date xshs3EndTime =null;
	/** 巡回护士1 id */
//	@Field(value="Xhhs1")
	private String xhhs1;
	/** 巡回护士1 开始时间 */
	// private Date xhhs1StartTime =null;
	/** 巡回护士1 结束时间 */
	// private Date xhhs1EndTime =null;
	/** 巡回护士2 id */
//	@Field(value="Xhhs2")
	private String xhhs2 = null; // 巡回护士
	/** 巡回护士2 开始时间 */
	// private Date xhhs2StartTime =null;
	/** 巡回护士2 结束时间 */
	// private Date xhhs2EndTime =null;
	/** 巡回护士3 id */
//	@Field(value="Xhhs3")
	private String xhhs3 = null; // 巡回护士
	/** 巡回护士3 开始时间 */
	// private Date xhhs3StartTime =null;
	/** 巡回护士3 结束时间 */
	// private Date xhhs3EndTime =null;
//	/** 收缩压 */
//	private String strIbpS;
//	/** 舒张压 */
//	private String strIbpD;
//	/** 体温 */
//	private String strTemp;
//	/** 脉率 */
//	private String strPR;
//	/** 呼吸 */
//	private String strResp;
//	/** 心率 */
//	private String strHR;
	/** 麻醉号 */
//	@Field(value="Mzbh")
	private String mzbh;
	/** 已施手术1 */
//	@Field(value="Ysss1")
	private String ysss1;
	/** 已施手术2 */
//	@Field(value="Ysss2")
	private String ysss2;
	/** 已施手术3 */
//	@Field(value="Ysss3")
	private String ysss3;
	/** 已施手术4 */
//	@Field(value="Ysss4")
	private String ysss4;
	/** 已施手术5 */
//	@Field(value="Ysss5")
	private String ysss5;
	/** 已施手术6 */
//	@Field(value="ysss6")
	private String ysss6;

	/** 术后诊断1 */
//	@Field(value="Shzd1")
	private String shzd1;
	/** 术后诊断2 */
//	@Field(value="Shzd2")
	private String shzd2;
	/** 术后诊断3 */
//	@Field(value="Shzd3")
	private String shzd3;
	/** 术后诊断4 */
//	@Field(value="Shzd4")
	private String shzd4;
	/** 术后诊断5 */
//	@Field(value="Shzd5")
	private String shzd5;

	/** 评分 */
//	@Field(value="Sxpf")
	private String sxpf;
	/** 麻醉效果 */
//	@Field(value="Mzxg")
	private String mzxg;
	/** PCA */
	private String PCA;
	/** 病人去往 */
//	@Field(value="Brqw")
	private String brqw;
	/** 禁食 */
	@Field(value="Js")
	private Boolean js;
	/** 不禁食 */
	@Field(value="Bjs")
	private Boolean bjs;
	/** 困难气道等级 */
	@Field(value="Knqd")
	private String knqd;
	/** 非计划二次手术 */
	@Field(value="Fjhss")
	private Boolean fjhss;
	/** 计划二次手术 */
	@Field(value="Jhss")
	private Boolean jhss;
	/** 特殊情况 */
	@Field(value="Tsqk")
	private String tsqk;
	/**
	 * 接班麻醉医生
	 */
	@Field(value="Mzjbys")
	private String mzjbys;
	/**
	 * 接班时间
	 */
	// private Date mzjbysStartTime;

	/** 静脉病人自控镇痛 */
	private Boolean PCIA;
	/** 硬膜外病人自控镇痛 */
	private Boolean PCEA;
	/** 神经丛病人自控镇痛 */
	private Boolean PCNA;
	/** 经皮病人自控镇痛 */
	private Boolean PCSA;
	/** 未用 */
//	@Field(value="WyPCA")
	private Boolean wyPCA;
	/** 动脉穿刺 */
//	@Field(value="Dmcc")
	private Boolean dmcc; // 动脉穿刺
	/** 血气分析 */
//	@Field(value="Xqfx")
	private Boolean xqfx; // 血气分析
	/** 血气分析内容 */
//	@Field(value="Xqfxnr")
	private String xqfxnr; // 血气分析内容
	/** 中心静脉穿刺 */
//	@Field(value="Zxjmcc")
	private Boolean zxjmcc;
	@Field(value = "tsqgcg")
	private Boolean tsqgcg;//特殊气管插管
	/** 超声引导 */
//	@Field(value="Csyd")
	private Boolean csyd;
	/** 使用工作站 */
//	@Field(value="Sygzz")
	private Boolean sygzz;
	/** 加温治疗 */
//	@Field(value="Jwzl")
	private Boolean jwzl;
	/** 降压治疗 */
//	@Field(value="Jyzl")
	private Boolean jyzl;
	/** teg */
//	@Field(value="Teg")
	private Boolean teg;
	/** teg */
//	@Field(value="Bis")
	private Boolean bis;
//	@Field(value="IsZiTiXue")
	private Boolean isZiTiXue;

	/** 麻醉效果 */
//	@Field(value="ComplicatedMethod")
	private ComplicatedMethod complicatedMethod;
//	@Field(value="Asa")
	private Asa asa; // ASA评分
//	@Field(value="LiquidInAndOut")
	private LiquidInAndOut liquidInAndOut; // 术中出入量

//	@Field(value="Mzxj")
	private String mzxj; // 麻醉小结

//	@Field(value="Zxjmsj")
	private Date zxjmsj;
//	@Field(value="Dmccsj")
    private Date dmccsj;
//	@Field(value="ZxjmRlz")
    private String zxjmRlz;
//	@Field(value="ZxjmRly")
    private String zxjmRly;
//	@Field(value="Jnjm")
    private String jnjm;
//	@Field(value="Gjm")
    private String gjm;
//	@Field(value="Zxqt")
    private String zxqt;
//	@Field(value="ZxqtText")
    private String zxqtText;
//	@Field(value="Zgsd")
    private String zgsd;
//	@Field(value="Zxjmbfz")
    private String zxjmbfz;
//	@Field(value="DmccRlz")
    private String dmccRlz;
//	@Field(value="DmccRly")
    private String dmccRly;
//	@Field(value="Rdm")
    private String rdm;
//	@Field(value="Zjdm")
    private String zjdm;
//	@Field(value="Dmccqt")
    private String dmccqt;
//	@Field(value="DmccqtText")
    private String dmccqtText;
//	@Field(value="Dmccbfz")
    private String dmccbfz;
//	@Field(value="Fmys1Role")
	private String fmys1Role;
//	@Field(value="Fmys2Role")
	private String fmys2Role;
//	@Field(value="Fmys3Role")
	private String fmys3Role;
//	@Field(value="ZmysRole")
	private String zmysRole;
//	@Field(value="Mzqyy")
	private String mzqyy;

	/**接班医师1 开始时间*/
	private Date jbys1StartTime =null;

	/**
	 * 动脉时间
	 */
	private String dmcc_sj;

	public Boolean getTsqgcg() {
		return tsqgcg;
	}

	public void setTsqgcg(Boolean tsqgcg) {
		this.tsqgcg = tsqgcg;
	}

	/**
	 * 中心静脉时间
	 */

	private String zxjmcc_sj;


	public String getZxjmcc_sj() {
		return zxjmcc_sj;
	}

	public void setZxjmcc_sj(String zxjmcc_sj) {
		this.zxjmcc_sj = zxjmcc_sj;
	}

	public String getDmcc_sj() {
		return dmcc_sj;
	}

	public void setDmcc_sj(String dmcc_sj) {
		this.dmcc_sj = dmcc_sj;
	}

	public Date getJbys1StartTime() {
		return jbys1StartTime;
	}

	public void setJbys1StartTime(Date jbys1StartTime) {
		this.jbys1StartTime = jbys1StartTime;
	}

	public String getMzqyy() {
		return mzqyy;
	}

	public void setMzqyy(String mzqyy) {
		this.mzqyy = mzqyy;
	}
	public Date getZxjmsj() {
		return zxjmsj;
	}

	public void setZxjmsj(Date zxjmsj) {
		this.zxjmsj = zxjmsj;
	}

	public Date getDmccsj() {
		return dmccsj;
	}

	public void setDmccsj(Date dmccsj) {
		this.dmccsj = dmccsj;
	}

	public String getZxjmRlz() {
		return zxjmRlz;
	}

	public void setZxjmRlz(String zxjmRlz) {
		this.zxjmRlz = zxjmRlz;
	}

	public String getZxjmRly() {
		return zxjmRly;
	}

	public void setZxjmRly(String zxjmRly) {
		this.zxjmRly = zxjmRly;
	}

	public String getJnjm() {
		return jnjm;
	}

	public void setJnjm(String jnjm) {
		this.jnjm = jnjm;
	}

	public String getGjm() {
		return gjm;
	}

	public void setGjm(String gjm) {
		this.gjm = gjm;
	}

	public String getZxqt() {
		return zxqt;
	}

	public void setZxqt(String zxqt) {
		this.zxqt = zxqt;
	}

	public String getZxqtText() {
		return zxqtText;
	}

	public void setZxqtText(String zxqtText) {
		this.zxqtText = zxqtText;
	}

	public String getZgsd() {
		return zgsd;
	}

	public void setZgsd(String zgsd) {
		this.zgsd = zgsd;
	}

	public String getZxjmbfz() {
		return zxjmbfz;
	}

	public void setZxjmbfz(String zxjmbfz) {
		this.zxjmbfz = zxjmbfz;
	}

	public String getDmccRlz() {
		return dmccRlz;
	}

	public void setDmccRlz(String dmccRlz) {
		this.dmccRlz = dmccRlz;
	}

	public String getDmccRly() {
		return dmccRly;
	}

	public void setDmccRly(String dmccRly) {
		this.dmccRly = dmccRly;
	}

	public String getRdm() {
		return rdm;
	}

	public void setRdm(String rdm) {
		this.rdm = rdm;
	}

	public String getZjdm() {
		return zjdm;
	}

	public void setZjdm(String zjdm) {
		this.zjdm = zjdm;
	}

	public String getDmccqt() {
		return dmccqt;
	}

	public void setDmccqt(String dmccqt) {
		this.dmccqt = dmccqt;
	}

	public String getDmccqtText() {
		return dmccqtText;
	}

	public void setDmccqtText(String dmccqtText) {
		this.dmccqtText = dmccqtText;
	}

	public String getDmccbfz() {
		return dmccbfz;
	}

	public void setDmccbfz(String dmccbfz) {
		this.dmccbfz = dmccbfz;
	}

	public String getNsss1() {
		return nsss1;
	}

	public void setNsss1(String nsss1) {
		this.nsss1 = nsss1;
	}

	public String getNsss2() {
		return nsss2;
	}

	public void setNsss2(String nsss2) {
		this.nsss2 = nsss2;
	}

	public String getNsss3() {
		return nsss3;
	}

	public void setNsss3(String nsss3) {
		this.nsss3 = nsss3;
	}

	public String getNsss4() {
		return nsss4;
	}

	public void setNsss4(String nsss4) {
		this.nsss4 = nsss4;
	}

	public String getNsss5() {
		return nsss5;
	}

	public void setNsss5(String nsss5) {
		this.nsss5 = nsss5;
	}

	public String getNsss6() {
		return nsss6;
	}

	public void setNsss6(String nsss6) {
		this.nsss6 = nsss6;
	}

	public String getSqzd() {
		return sqzd;
	}

	public void setSqzd(String sqzd) {
		this.sqzd = sqzd;
	}

	public String getSzzd() {
		return szzd;
	}

	public void setSzzd(String szzd) {
		this.szzd = szzd;
	}

	public String getZmys() {
		return zmys;
	}

	public void setZmys(String zmys) {
		this.zmys = zmys;
	}

	public String getFmys1() {
		return fmys1;
	}

	public void setFmys1(String fmys1) {
		this.fmys1 = fmys1;
	}

	public String getFmys2() {
		return fmys2;
	}

	public void setFmys2(String fmys2) {
		this.fmys2 = fmys2;
	}

	public String getFmys3() {
		return fmys3;
	}

	public void setFmys3(String fmys3) {
		this.fmys3 = fmys3;
	}

	public String getJbys1() {
		return jbys1;
	}

	public void setJbys1(String jbys1) {
		this.jbys1 = jbys1;
	}

	public String getJbys2() {
		return jbys2;
	}

	public void setJbys2(String jbys2) {
		this.jbys2 = jbys2;
	}

	
	public String getQjys() {
		return qjys;
	}

	public void setQjys(String qjys) {
		this.qjys = qjys;
	}

	public String getZj() {
		return zj;
	}

	public void setZj(String zj) {
		this.zj = zj;
	}

	public String getMzff() {
		return mzff;
	}

	public void setMzff(String mzff) {
		this.mzff = mzff;
	}

	public ComplicatedMethod getMazuiMethodComp() {
		return mazuiMethodComp;
	}

	public void setMazuiMethodComp(ComplicatedMethod mazuiMethodComp) {
		this.mazuiMethodComp = mazuiMethodComp;
	}

	public String getOperDoctor1() {
		return operDoctor1;
	}

	public void setOperDoctor1(String operDoctor1) {
		this.operDoctor1 = operDoctor1;
	}

	

	public String getOperDoctor1Assistant1() {
		return operDoctor1Assistant1;
	}

	public void setOperDoctor1Assistant1(String operDoctor1Assistant1) {
		this.operDoctor1Assistant1 = operDoctor1Assistant1;
	}

	public String getOperDoctor1Assistant2() {
		return operDoctor1Assistant2;
	}

	public void setOperDoctor1Assistant2(String operDoctor1Assistant2) {
		this.operDoctor1Assistant2 = operDoctor1Assistant2;
	}

	public String getOperDoctor1Assistant3() {
		return operDoctor1Assistant3;
	}

	public void setOperDoctor1Assistant3(String operDoctor1Assistant3) {
		this.operDoctor1Assistant3 = operDoctor1Assistant3;
	}

	public String getOperDoctor2() {
		return operDoctor2;
	}

	public void setOperDoctor2(String operDoctor2) {
		this.operDoctor2 = operDoctor2;
	}

	
	
	public String getOperDoctor2Assistant1() {
		return operDoctor2Assistant1;
	}

	public void setOperDoctor2Assistant1(String operDoctor2Assistant1) {
		this.operDoctor2Assistant1 = operDoctor2Assistant1;
	}

	public String getOperDoctor2Assistant2() {
		return operDoctor2Assistant2;
	}

	public void setOperDoctor2Assistant2(String operDoctor2Assistant2) {
		this.operDoctor2Assistant2 = operDoctor2Assistant2;
	}

	public String getOperDoctor2Assistant3() {
		return operDoctor2Assistant3;
	}

	public void setOperDoctor2Assistant3(String operDoctor2Assistant3) {
		this.operDoctor2Assistant3 = operDoctor2Assistant3;
	}

	public String getOperDoctor3() {
		return operDoctor3;
	}

	public void setOperDoctor3(String operDoctor3) {
		this.operDoctor3 = operDoctor3;
	}

	public Date getOperDoctor3StartTime() {
		return operDoctor3StartTime;
	}

	public void setOperDoctor3StartTime(Date operDoctor3StartTime) {
		this.operDoctor3StartTime = operDoctor3StartTime;
	}

	public Date getOperDoctor3EndTime() {
		return operDoctor3EndTime;
	}

	public void setOperDoctor3EndTime(Date operDoctor3EndTime) {
		this.operDoctor3EndTime = operDoctor3EndTime;
	}

	public String getOperDoctor3Assistant1() {
		return operDoctor3Assistant1;
	}

	public void setOperDoctor3Assistant1(String operDoctor3Assistant1) {
		this.operDoctor3Assistant1 = operDoctor3Assistant1;
	}

	public String getOperDoctor3Assistant2() {
		return operDoctor3Assistant2;
	}

	public void setOperDoctor3Assistant2(String operDoctor3Assistant2) {
		this.operDoctor3Assistant2 = operDoctor3Assistant2;
	}

	public String getOperDoctor3Assistant3() {
		return operDoctor3Assistant3;
	}

	public void setOperDoctor3Assistant3(String operDoctor3Assistant3) {
		this.operDoctor3Assistant3 = operDoctor3Assistant3;
	}

	public String getSstw() {
		return sstw;
	}

	public void setSstw(String sstw) {
		this.sstw = sstw;
	}

	public String getXshs1() {
		return xshs1;
	}

	public void setXshs1(String xshs1) {
		this.xshs1 = xshs1;
	}

	

	public String getXshs2() {
		return xshs2;
	}

	public void setXshs2(String xshs2) {
		this.xshs2 = xshs2;
	}

	
	public String getXshs3() {
		return xshs3;
	}

	public void setXshs3(String xshs3) {
		this.xshs3 = xshs3;
	}

	
	public String getXhhs1() {
		return xhhs1;
	}

	public void setXhhs1(String xhhs1) {
		this.xhhs1 = xhhs1;
	}

	
	
	public String getXhhs2() {
		return xhhs2;
	}

	public void setXhhs2(String xhhs2) {
		this.xhhs2 = xhhs2;
	}

	

	public String getXhhs3() {
		return xhhs3;
	}

	public void setXhhs3(String xhhs3) {
		this.xhhs3 = xhhs3;
	}
	
//	public String getStrIbpS() {
//		return strIbpS;
//	}
//
//	public void setStrIbpS(String strIbpS) {
//		this.strIbpS = strIbpS;
//	}
//
//	public String getStrIbpD() {
//		return strIbpD;
//	}
//
//	public void setStrIbpD(String strIbpD) {
//		this.strIbpD = strIbpD;
//	}
//
//	public String getStrTemp() {
//		return strTemp;
//	}
//
//	public void setStrTemp(String strTemp) {
//		this.strTemp = strTemp;
//	}
//
//	public String getStrPR() {
//		return strPR;
//	}
//
//	public void setStrPR(String strPR) {
//		this.strPR = strPR;
//	}
//
//	public String getStrResp() {
//		return strResp;
//	}
//
//	public void setStrResp(String strResp) {
//		this.strResp = strResp;
//	}
//
//	public String getStrHR() {
//		return strHR;
//	}
//
//	public void setStrHR(String strHR) {
//		this.strHR = strHR;
//	}

	public String getMzbh() {
		return mzbh;
	}

	public void setMzbh(String mzbh) {
		this.mzbh = mzbh;
	}

	public String getYsss1() {
		return ysss1;
	}

	public void setYsss1(String ysss1) {
		this.ysss1 = ysss1;
	}

	public String getYsss2() {
		return ysss2;
	}

	public void setYsss2(String ysss2) {
		this.ysss2 = ysss2;
	}

	public String getYsss3() {
		return ysss3;
	}

	public void setYsss3(String ysss3) {
		this.ysss3 = ysss3;
	}

	public String getYsss4() {
		return ysss4;
	}

	public void setYsss4(String ysss4) {
		this.ysss4 = ysss4;
	}

	public String getYsss5() {
		return ysss5;
	}

	public void setYsss5(String ysss5) {
		this.ysss5 = ysss5;
	}

	public String getYsss6() {
		return ysss6;
	}

	public void setYsss6(String ysss6) {
		this.ysss6 = ysss6;
	}

	public String getShzd1() {
		return shzd1;
	}

	public void setShzd1(String shzd1) {
		this.shzd1 = shzd1;
	}

	public String getShzd2() {
		return shzd2;
	}

	public void setShzd2(String shzd2) {
		this.shzd2 = shzd2;
	}

	public String getShzd3() {
		return shzd3;
	}

	public void setShzd3(String shzd3) {
		this.shzd3 = shzd3;
	}

	public String getShzd4() {
		return shzd4;
	}

	public void setShzd4(String shzd4) {
		this.shzd4 = shzd4;
	}

	public String getShzd5() {
		return shzd5;
	}

	public void setShzd5(String shzd5) {
		this.shzd5 = shzd5;
	}

	public String getSxpf() {
		return sxpf;
	}

	public void setSxpf(String sxpf) {
		this.sxpf = sxpf;
	}

	public String getMzxg() {
		return mzxg;
	}

	public void setMzxg(String mzxg) {
		this.mzxg = mzxg;
	}

	public String getPCA() {
		return PCA;
	}

	public void setPCA(String pCA) {
		PCA = pCA;
	}

	public String getBrqw() {
		return brqw;
	}

	public void setBrqw(String brqw) {
		this.brqw = brqw;
	}

	public Boolean getJs() {
		return js;
	}

	public void setJs(Boolean js) {
		this.js = js;
	}

	public Boolean getBjs() {
		return bjs;
	}

	public void setBjs(Boolean bjs) {
		this.bjs = bjs;
	}

	public String getKnqd() {
		return knqd;
	}

	public void setKnqd(String knqd) {
		this.knqd = knqd;
	}

	public Boolean getFjhss() {
		return fjhss;
	}

	public void setFjhss(Boolean fjhss) {
		this.fjhss = fjhss;
	}

	public Boolean getJhss() {
		return jhss;
	}

	public void setJhss(Boolean jhss) {
		this.jhss = jhss;
	}

	public String getTsqk() {
		return tsqk;
	}

	public void setTsqk(String tsqk) {
		this.tsqk = tsqk;
	}

	public String getMzjbys() {
		return mzjbys;
	}

	public void setMzjbys(String mzjbys) {
		this.mzjbys = mzjbys;
	}

	

	public Boolean getPCIA() {
		return PCIA;
	}

	public void setPCIA(Boolean pCIA) {
		PCIA = pCIA;
	}

	public Boolean getPCEA() {
		return PCEA;
	}

	public void setPCEA(Boolean pCEA) {
		PCEA = pCEA;
	}

	public Boolean getPCNA() {
		return PCNA;
	}

	public void setPCNA(Boolean pCNA) {
		PCNA = pCNA;
	}

	public Boolean getPCSA() {
		return PCSA;
	}

	public void setPCSA(Boolean pCSA) {
		PCSA = pCSA;
	}

	public Boolean getWyPCA() {
		return wyPCA;
	}

	public void setWyPCA(Boolean wyPCA) {
		this.wyPCA = wyPCA;
	}

	public Boolean getDmcc() {
		return dmcc;
	}

	public void setDmcc(Boolean dmcc) {
		this.dmcc = dmcc;
	}

	public Boolean getXqfx() {
		return xqfx;
	}

	public void setXqfx(Boolean xqfx) {
		this.xqfx = xqfx;
	}

	public String getXqfxnr() {
		return xqfxnr;
	}

	public void setXqfxnr(String xqfxnr) {
		this.xqfxnr = xqfxnr;
	}

	public Boolean getZxjmcc() {
		return zxjmcc;
	}

	public void setZxjmcc(Boolean zxjmcc) {
		this.zxjmcc = zxjmcc;
	}

	public Boolean getCsyd() {
		return csyd;
	}

	public void setCsyd(Boolean csyd) {
		this.csyd = csyd;
	}

	public Boolean getSygzz() {
		return sygzz;
	}

	public void setSygzz(Boolean sygzz) {
		this.sygzz = sygzz;
	}

	public Boolean getJwzl() {
		return jwzl;
	}

	public void setJwzl(Boolean jwzl) {
		this.jwzl = jwzl;
	}

	public Boolean getJyzl() {
		return jyzl;
	}

	public void setJyzl(Boolean jyzl) {
		this.jyzl = jyzl;
	}

	public Boolean getTeg() {
		return teg;
	}

	public void setTeg(Boolean teg) {
		this.teg = teg;
	}

	public ComplicatedMethod getComplicatedMethod() {
		return complicatedMethod;
	}

	public void setComplicatedMethod(ComplicatedMethod complicatedMethod) {
		this.complicatedMethod = complicatedMethod;
	}

	public Asa getAsa() {
		if(asa==null){
			asa=new Asa();
		}
		return asa;
	}

	public void setAsa(Asa asa) {
		this.asa = asa;
	}

	public LiquidInAndOut getLiquidInAndOut() {
		if(liquidInAndOut == null){
			liquidInAndOut = new LiquidInAndOut();
		}
		return liquidInAndOut;
	}

	public void setLiquidInAndOut(LiquidInAndOut liquidInAndOut) {
		this.liquidInAndOut = liquidInAndOut;
	}

	public String getMzxj() {
		return mzxj;
	}

	public void setMzxj(String mzxj) {
		this.mzxj = mzxj;
	}

	public Boolean getBis() {
		return bis;
	}

	public void setBis(Boolean bis) {
		this.bis = bis;
	}

	public Boolean getIsZiTiXue() {
		return isZiTiXue;
	}

	public void setIsZiTiXue(Boolean isZiTiXue) {
		this.isZiTiXue = isZiTiXue;
	}

	public String getFmys1Role() {
		return fmys1Role;
	}

	public void setFmys1Role(String fmys1Role) {
		this.fmys1Role = fmys1Role;
	}

	public String getFmys2Role() {
		return fmys2Role;
	}

	public void setFmys2Role(String fmys2Role) {
		this.fmys2Role = fmys2Role;
	}

	public String getFmys3Role() {
		return fmys3Role;
	}

	public void setFmys3Role(String fmys3Role) {
		this.fmys3Role = fmys3Role;
	}

	public String getZmysRole() {
		return zmysRole;
	}

	public void setZmysRole(String zmysRole) {
		this.zmysRole = zmysRole;
	}


	private Boolean mzxg_y = false;
	private Boolean mzpd_l = false;
	private Boolean mzpd_bq = false;
	private Boolean mzpd_wx = false;


	public Boolean getMzxg_y() {
		return mzxg_y;
	}

	public void setMzxg_y(Boolean mzxg_y) {
		this.mzxg_y = mzxg_y;
	}

	public Boolean getMzpd_l() {
		return mzpd_l;
	}

	public void setMzpd_l(Boolean mzpd_l) {
		this.mzpd_l = mzpd_l;
	}

	public Boolean getMzpd_bq() {
		return mzpd_bq;
	}

	public void setMzpd_bq(Boolean mzpd_bq) {
		this.mzpd_bq = mzpd_bq;
	}

	public Boolean getMzpd_wx() {
		return mzpd_wx;
	}

	public void setMzpd_wx(Boolean mzpd_wx) {
		this.mzpd_wx = mzpd_wx;
	}

	public String getFmys4() {
		return fmys4;
	}

	public void setFmys4(String fmys4) {
		this.fmys4 = fmys4;
	}

	public String getBloodDonator() {
		return bloodDonator;
	}

	public void setBloodDonator(String bloodDonator) {
		this.bloodDonator = bloodDonator;
	}
}
