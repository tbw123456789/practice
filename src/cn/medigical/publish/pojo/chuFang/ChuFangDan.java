package cn.medigical.publish.pojo.chuFang;

import java.util.ArrayList;
import java.util.List;

public class ChuFangDan {
	private String kaiDanDoc;
    private List<ChuFangItem> chuFangList = new ArrayList<ChuFangItem>();

	public String getKaiDanDoc() {
		return kaiDanDoc;
	}

	public void setKaiDanDoc(String kaiDanDoc) {
		this.kaiDanDoc = kaiDanDoc;
	}

	public List<ChuFangItem> getChuFangList() {
		return chuFangList;
	}

	public void setChuFangList(List<ChuFangItem> chuFangList) {
		this.chuFangList = chuFangList;
	}
}
