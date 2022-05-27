package cn.medigical.publish.pojo.patientLink;

import org.springframework.data.mongodb.core.mapping.Field;

public class Pacu {
	@Field(value="shuqianwu")
    private Boolean Shuqianwu;
	@Field(value="shuqianyou")
    private Boolean Shuqianyou;
	@Field(value="yibaguan")
    private Boolean Yibaguan;
	@Field(value="weibaguan")
    private Boolean Weibaguan;
	@Field(value="kongzhihuxi")
    private Boolean Kongzhihuxi;
	@Field(value="fuzhuhuxi")
    private Boolean Fuzhuhuxi;
	@Field(value="zizhuhuxi")
    private Boolean Zizhuhuxi;
    /**其他*/
	@Field(value="qita")
    private String Qita;
    /**催醒药物*/
	@Field(value="yaowu")
    private String Yaowu;
    /**总分*/
	@Field(value="zongfen")
    private String Zongfen;
    /**晶体液*/
	@Field(value="jingtiye")
    private String Jingtiye;
    /**胶体液*/
	@Field(value="jiaotiye")
    private String Jiaotiye;
    /**RBC*/
	@Field(value="rbc")
    private String Rbc;
    /**血浆*/
	@Field(value="xuejiang")
    private String Xuejiang;
    /**血小板*/
	@Field(value="xuexiaoban")
    private String Xuexiaoban;
    /**冷沉淀*/
	@Field(value="lengchendian")
    private String Lengchendian;
    /**出血量*/
	@Field(value="chuxueliang")
    private String Chuxueliang;
    /**引流量*/
	@Field(value="yinliuliang")
    private String Yinliuliang;
    /**尿量*/
	@Field(value="niaoliang")
    private String Niaoliang;
    /**其他*/
	@Field(value="churuqita")
    private String Churuqita;
    /**无*/
	@Field(value="pacuwu")
    private Boolean Pacuwu;
    /**PACU转出延迟(入PACU超过3小时)*/
	@Field(value="pacuyanchi")
    private Boolean Pacuyanchi;
    /**PACU入室低体温发生*/
	@Field(value="pacudiwen")
    private Boolean Pacudiwen;
    /**术后躁动*/
	@Field(value="shuhouzaodong")
    private Boolean Shuhouzaodong;
    /**恶心呕吐*/
	@Field(value="exinoutu")
    private Boolean Exinoutu;
    /**低氧血症*/
	@Field(value="diyangxuezheng")
    private Boolean Diyangxuezheng;
    /**拔管后在插管*/
	@Field(value="baguanchaguan")
    private Boolean Baguanchaguan;
    /**苏醒延迟*/
	@Field(value="suxingyanchi")
    private Boolean Suxingyanchi;
    /**寒颤*/
	@Field(value="hanzhan")
    private Boolean Hanzhan;
    /**其他*/
	@Field(value="pacuqita")
    private Boolean Pacuqita;
    /**带管出室*/
	@Field(value="daiguanchushi")
    private Boolean Daiguanchushi;
    /**催醒药物*/
	@Field(value="cuixingyaowu")
    private Boolean Cuixingyaowu;
    /**完全苏醒2*/
	@Field(value="qingxing2")
    private Boolean Qingxing2;
    /**对刺激有反应1*/
	@Field(value="qingxing1")
    private Boolean Qingxing1;
    /**对刺激无反应0*/
	@Field(value="qingxing0")
    private Boolean Qingxing0;
    /**可按医师吩咐咳嗽2*/
	@Field(value="huxi2")
    private Boolean Huxi2;
    /**可自主维持呼吸道通畅1*/
	@Field(value="huxi1")
    private Boolean Huxi1;
    /**呼吸道需要予以支持0*/
	@Field(value="huxi0")
    private Boolean Huxi0;
    /**肢体能做有意识的活动2*/
	@Field(value="zhiti2")
    private Boolean Zhiti2;
    /**肢体无意识运动1*/
	@Field(value="zhiti1")
    private Boolean Zhiti1;
    /**肢体无活动0*/
	@Field(value="zhiti0")
    private Boolean Zhiti0;
	private String mzys1Role;
    private String mzys2Role;
	private String mzys1;
	private String mzys2;

	private String pacuDoctor;

	/**  血气分析*/
	private boolean xqfx ;
	/**  血气分析内容*/
	private String xqfxnr ;

	public boolean isXqfx() {
		return xqfx;
	}

	public void setXqfx(boolean xqfx) {
		this.xqfx = xqfx;
	}

	public String getXqfxnr() {
		return xqfxnr;
	}

	public void setXqfxnr(String xqfxnr) {
		this.xqfxnr = xqfxnr;
	}

	public String getPacuDoctor() {
		return pacuDoctor;
	}

	public void setPacuDoctor(String pacuDoctor) {
		this.pacuDoctor = pacuDoctor;
	}

	public String getMzys1() {
		return mzys1;
	}

	public void setMzys1(String mzys1) {
		this.mzys1 = mzys1;
	}

	public String getMzys2() {
		return mzys2;
	}

	public void setMzys2(String mzys2) {
		this.mzys2 = mzys2;
	}

	public String getMzys1Role() {
		return mzys1Role;
	}
	public void setMzys1Role(String mzys1Role) {
		this.mzys1Role = mzys1Role;
	}
	public String getMzys2Role() {
		return mzys2Role;
	}
	public void setMzys2Role(String mzys2Role) {
		this.mzys2Role = mzys2Role;
	}
	public Boolean getShuqianwu() {
		return Shuqianwu;
	}
	public void setShuqianwu(Boolean shuqianwu) {
		Shuqianwu = shuqianwu;
	}
	public Boolean getShuqianyou() {
		return Shuqianyou;
	}
	public void setShuqianyou(Boolean shuqianyou) {
		Shuqianyou = shuqianyou;
	}
	public Boolean getYibaguan() {
		return Yibaguan;
	}
	public void setYibaguan(Boolean yibaguan) {
		Yibaguan = yibaguan;
	}
	public Boolean getWeibaguan() {
		return Weibaguan;
	}
	public void setWeibaguan(Boolean weibaguan) {
		Weibaguan = weibaguan;
	}
	public Boolean getKongzhihuxi() {
		return Kongzhihuxi;
	}
	public void setKongzhihuxi(Boolean kongzhihuxi) {
		Kongzhihuxi = kongzhihuxi;
	}
	public Boolean getFuzhuhuxi() {
		return Fuzhuhuxi;
	}
	public void setFuzhuhuxi(Boolean fuzhuhuxi) {
		Fuzhuhuxi = fuzhuhuxi;
	}
	public Boolean getZizhuhuxi() {
		return Zizhuhuxi;
	}
	public void setZizhuhuxi(Boolean zizhuhuxi) {
		Zizhuhuxi = zizhuhuxi;
	}
	public String getQita() {
		return Qita;
	}
	public void setQita(String qita) {
		Qita = qita;
	}
	public String getYaowu() {
		return Yaowu;
	}
	public void setYaowu(String yaowu) {
		Yaowu = yaowu;
	}
	public String getZongfen() {
		return Zongfen;
	}
	public void setZongfen(String zongfen) {
		Zongfen = zongfen;
	}
	public String getJingtiye() {
		return Jingtiye;
	}
	public void setJingtiye(String jingtiye) {
		Jingtiye = jingtiye;
	}
	public String getJiaotiye() {
		return Jiaotiye;
	}
	public void setJiaotiye(String jiaotiye) {
		Jiaotiye = jiaotiye;
	}
	public String getRbc() {
		return Rbc;
	}
	public void setRbc(String rbc) {
		Rbc = rbc;
	}
	public String getXuejiang() {
		return Xuejiang;
	}
	public void setXuejiang(String xuejiang) {
		Xuejiang = xuejiang;
	}
	public String getXuexiaoban() {
		return Xuexiaoban;
	}
	public void setXuexiaoban(String xuexiaoban) {
		Xuexiaoban = xuexiaoban;
	}
	public String getLengchendian() {
		return Lengchendian;
	}
	public void setLengchendian(String lengchendian) {
		Lengchendian = lengchendian;
	}
	public String getChuxueliang() {
		return Chuxueliang;
	}
	public void setChuxueliang(String chuxueliang) {
		Chuxueliang = chuxueliang;
	}
	public String getYinliuliang() {
		return Yinliuliang;
	}
	public void setYinliuliang(String yinliuliang) {
		Yinliuliang = yinliuliang;
	}
	public String getNiaoliang() {
		return Niaoliang;
	}
	public void setNiaoliang(String niaoliang) {
		Niaoliang = niaoliang;
	}
	public String getChuruqita() {
		return Churuqita;
	}
	public void setChuruqita(String churuqita) {
		Churuqita = churuqita;
	}
	public Boolean getPacuwu() {
		return Pacuwu;
	}
	public void setPacuwu(Boolean pacuwu) {
		Pacuwu = pacuwu;
	}
	public Boolean getPacuyanchi() {
		return Pacuyanchi;
	}
	public void setPacuyanchi(Boolean pacuyanchi) {
		Pacuyanchi = pacuyanchi;
	}
	public Boolean getPacudiwen() {
		return Pacudiwen;
	}
	public void setPacudiwen(Boolean pacudiwen) {
		Pacudiwen = pacudiwen;
	}
	public Boolean getShuhouzaodong() {
		return Shuhouzaodong;
	}
	public void setShuhouzaodong(Boolean shuhouzaodong) {
		Shuhouzaodong = shuhouzaodong;
	}
	public Boolean getExinoutu() {
		return Exinoutu;
	}
	public void setExinoutu(Boolean exinoutu) {
		Exinoutu = exinoutu;
	}
	public Boolean getDiyangxuezheng() {
		return Diyangxuezheng;
	}
	public void setDiyangxuezheng(Boolean diyangxuezheng) {
		Diyangxuezheng = diyangxuezheng;
	}
	public Boolean getBaguanchaguan() {
		return Baguanchaguan;
	}
	public void setBaguanchaguan(Boolean baguanchaguan) {
		Baguanchaguan = baguanchaguan;
	}
	public Boolean getSuxingyanchi() {
		return Suxingyanchi;
	}
	public void setSuxingyanchi(Boolean suxingyanchi) {
		Suxingyanchi = suxingyanchi;
	}
	public Boolean getHanzhan() {
		return Hanzhan;
	}
	public void setHanzhan(Boolean hanzhan) {
		Hanzhan = hanzhan;
	}
	public Boolean getPacuqita() {
		return Pacuqita;
	}
	public void setPacuqita(Boolean pacuqita) {
		Pacuqita = pacuqita;
	}
	public Boolean getDaiguanchushi() {
		return Daiguanchushi;
	}
	public void setDaiguanchushi(Boolean daiguanchushi) {
		Daiguanchushi = daiguanchushi;
	}
	public Boolean getCuixingyaowu() {
		return Cuixingyaowu;
	}
	public void setCuixingyaowu(Boolean cuixingyaowu) {
		Cuixingyaowu = cuixingyaowu;
	}
	public Boolean getQingxing2() {
		return Qingxing2;
	}
	public void setQingxing2(Boolean qingxing2) {
		Qingxing2 = qingxing2;
	}
	public Boolean getQingxing1() {
		return Qingxing1;
	}
	public void setQingxing1(Boolean qingxing1) {
		Qingxing1 = qingxing1;
	}
	public Boolean getQingxing0() {
		return Qingxing0;
	}
	public void setQingxing0(Boolean qingxing0) {
		Qingxing0 = qingxing0;
	}
	public Boolean getHuxi2() {
		return Huxi2;
	}
	public void setHuxi2(Boolean huxi2) {
		Huxi2 = huxi2;
	}
	public Boolean getHuxi1() {
		return Huxi1;
	}
	public void setHuxi1(Boolean huxi1) {
		Huxi1 = huxi1;
	}
	public Boolean getHuxi0() {
		return Huxi0;
	}
	public void setHuxi0(Boolean huxi0) {
		Huxi0 = huxi0;
	}
	public Boolean getZhiti2() {
		return Zhiti2;
	}
	public void setZhiti2(Boolean zhiti2) {
		Zhiti2 = zhiti2;
	}
	public Boolean getZhiti1() {
		return Zhiti1;
	}
	public void setZhiti1(Boolean zhiti1) {
		Zhiti1 = zhiti1;
	}
	public Boolean getZhiti0() {
		return Zhiti0;
	}
	public void setZhiti0(Boolean zhiti0) {
		Zhiti0 = zhiti0;
	}
	
}
