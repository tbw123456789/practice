package cn.medigical.publish.udp;

import java.io.Serializable;

public class UdpModel implements Serializable {

    public String PatientId;
    public String Zyh;
    public String PatId;
    public String Zycs;
    public String JianYan;
    public String UpdateDate;
    public String AccountID;
    
    public String getAccountID() {
		return AccountID;
	}

	public void setAccountID(String accountID) {
		AccountID = accountID;
	}

	public String getUpdateDate() {
		return UpdateDate;
	}

	public void setUpdateDate(String updateDate) {
		UpdateDate = updateDate;
	}

	public String getPatientId() {
        return PatientId;
    }

    public void setPatientId(String patientId) {
        PatientId = patientId;
    }
    
    public String getJianYan() {
        return JianYan;
    }

    public void setJianYan(String jianYan) {
        JianYan = jianYan;
    }

    public String getZyh() {
        return Zyh;
    }

    public void setZyh(String zyh) {
        Zyh = zyh;
    }

    public String getPatId() {
        return PatId;
    }

    public void setPatId(String patId) {
        PatId = patId;
    }

    public String getZycs() {
        return Zycs;
    }

    public void setZycs(String zycs) {
        Zycs = zycs;
    }
}
