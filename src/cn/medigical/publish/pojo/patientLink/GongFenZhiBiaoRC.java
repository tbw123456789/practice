package cn.medigical.publish.pojo.patientLink;

import org.springframework.data.mongodb.core.mapping.Field;

public class GongFenZhiBiaoRC {
	@Field(value="total")
	private int Total;
	@Field(value="quanMaDanQiang")
	private int QuanMaDanQiang;
	@Field(value = "quanMaShuangQiang")
	private int QuanMaShuangQiang;
	@Field(value = "yaoYingLianHe")
	private int YaoYingLianHe;
	@Field(value = "yingMoWai")
	private int YingMoWai;
	@Field(value = "shenJingZuZhi")
	private int ShenJingZuZhi;
	@Field(value = "dongMaiChuanCi")
	private int DongMaiChuanCi;
	@Field(value = "zhongXinJingMaiChuanCi")
	private int ZhongXinJingMaiChuanCi;
	@Field(value = "shuZhongXueQiFenXi")
	private int ShuZhongXueQiFenXi;
	@Field(value = "shuHouZhenTong")
	private int ShuHouZhenTong;
	@Field(value = "quanMaJianCe")
	private int QuanMaJianCe;
	@Field(value="feiQuanMaJianCe")
	private int FeiQuanMaJianCe;

	public int getTotal() {
		return Total;
	}

	public void setTotal(int total) {
		Total = total;
	}

	public int getQuanMaDanQiang() {
		return QuanMaDanQiang;
	}

	public void setQuanMaDanQiang(int quanMaDanQiang) {
		QuanMaDanQiang = quanMaDanQiang;
	}

	public int getQuanMaShuangQiang() {
		return QuanMaShuangQiang;
	}

	public void setQuanMaShuangQiang(int quanMaShuangQiang) {
		QuanMaShuangQiang = quanMaShuangQiang;
	}

	public int getYaoYingLianHe() {
		return YaoYingLianHe;
	}

	public void setYaoYingLianHe(int yaoYingLianHe) {
		YaoYingLianHe = yaoYingLianHe;
	}

	public int getYingMoWai() {
		return YingMoWai;
	}

	public void setYingMoWai(int yingMoWai) {
		YingMoWai = yingMoWai;
	}

	public int getShenJingZuZhi() {
		return ShenJingZuZhi;
	}

	public void setShenJingZuZhi(int shenJingZuZhi) {
		ShenJingZuZhi = shenJingZuZhi;
	}

	public int getDongMaiChuanCi() {
		return DongMaiChuanCi;
	}

	public void setDongMaiChuanCi(int dongMaiChuanCi) {
		DongMaiChuanCi = dongMaiChuanCi;
	}

	public int getZhongXinJingMaiChuanCi() {
		return ZhongXinJingMaiChuanCi;
	}

	public void setZhongXinJingMaiChuanCi(int zhongXinJingMaiChuanCi) {
		ZhongXinJingMaiChuanCi = zhongXinJingMaiChuanCi;
	}

	public int getShuZhongXueQiFenXi() {
		return ShuZhongXueQiFenXi;
	}

	public void setShuZhongXueQiFenXi(int shuZhongXueQiFenXi) {
		ShuZhongXueQiFenXi = shuZhongXueQiFenXi;
	}

	public int getShuHouZhenTong() {
		return ShuHouZhenTong;
	}

	public void setShuHouZhenTong(int shuHouZhenTong) {
		ShuHouZhenTong = shuHouZhenTong;
	}

	public int getQuanMaJianCe() {
		return QuanMaJianCe;
	}

	public void setQuanMaJianCe(int quanMaJianCe) {
		QuanMaJianCe = quanMaJianCe;
	}

	public int getFeiQuanMaJianCe() {
		return FeiQuanMaJianCe;
	}

	public void setFeiQuanMaJianCe(int feiQuanMaJianCe) {
		FeiQuanMaJianCe = feiQuanMaJianCe;
	}

}
