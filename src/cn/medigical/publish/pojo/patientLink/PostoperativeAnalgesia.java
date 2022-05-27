package cn.medigical.publish.pojo.patientLink;

import java.util.ArrayList;
import java.util.List;

import cn.medigical.publish.pojo.patient.drug.Item;

public class PostoperativeAnalgesia {
	private List<Item> itemList = new ArrayList<Item>();
    private String ztfs = "";
    private String ztbxh = "";
    private String ztbbh = "";
    private String ccd1 = "";
    private String ccd2 = "";
    private String dgsd = "";
    private String ydzl = "";
    private String mxsls = "";
    private String pca = "";
    private String sdsj = "";

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public String getZtfs() {
		return ztfs;
	}

	public void setZtfs(String ztfs) {
		this.ztfs = ztfs;
	}

	public String getZtbxh() {
		return ztbxh;
	}

	public void setZtbxh(String ztbxh) {
		this.ztbxh = ztbxh;
	}

	public String getZtbbh() {
		return ztbbh;
	}

	public void setZtbbh(String ztbbh) {
		this.ztbbh = ztbbh;
	}

	public String getCcd1() {
		return ccd1;
	}

	public void setCcd1(String ccd1) {
		this.ccd1 = ccd1;
	}

	public String getCcd2() {
		return ccd2;
	}

	public void setCcd2(String ccd2) {
		this.ccd2 = ccd2;
	}

	public String getDgsd() {
		return dgsd;
	}

	public void setDgsd(String dgsd) {
		this.dgsd = dgsd;
	}

	public String getYdzl() {
		return ydzl;
	}

	public void setYdzl(String ydzl) {
		this.ydzl = ydzl;
	}

	public String getMxsls() {
		return mxsls;
	}

	public void setMxsls(String mxsls) {
		this.mxsls = mxsls;
	}

	public String getPca() {
		return pca;
	}

	public void setPca(String pca) {
		this.pca = pca;
	}

	public String getSdsj() {
		return sdsj;
	}

	public void setSdsj(String sdsj) {
		this.sdsj = sdsj;
	}
}
