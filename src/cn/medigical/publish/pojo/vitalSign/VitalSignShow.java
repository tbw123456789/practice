package cn.medigical.publish.pojo.vitalSign;

import java.util.ArrayList;
import java.util.List;

import cn.medigical.publish.pojo.dictionary.ConfigVitalSigns;

public class VitalSignShow {
	private List<String> notAutoShow = new ArrayList<String>();
	private List<ConfigVitalSigns> vitalSign = new ArrayList<ConfigVitalSigns>();
	private List<ConfigVitalSigns> bloodGas = new ArrayList<ConfigVitalSigns>();

	public List<String> getNotAutoShow() {
		return notAutoShow;
	}

	public void setNotAutoShow(List<String> notAutoShow) {
		this.notAutoShow = notAutoShow;
	}

	public List<ConfigVitalSigns> getVitalSign() {
		return vitalSign;
	}

	public void setVitalSign(List<ConfigVitalSigns> vitalSign) {
		this.vitalSign = vitalSign;
	}

	public List<ConfigVitalSigns> getBloodGas() {
		return bloodGas;
	}

	public void setBloodGas(List<ConfigVitalSigns> bloodGas) {
		this.bloodGas = bloodGas;
	}
}
