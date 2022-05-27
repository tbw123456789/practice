package cn.medigical.publish.pojo.lis;

import java.util.Date;

public class LisReport {
    private String MRN;
    private Date AUTHTIME;
    private String REPORTID  ;
    private String patIndexNo;
  

    public Date getAUTHTIME() {
        return AUTHTIME;
    }

    public void setAUTHTIME(Date AUTHTIME) {
        this.AUTHTIME = AUTHTIME;
    }

    public String getMRN() {
        return MRN;
    }

    public void setMRN(String MRN) {
        this.MRN = MRN;
    }

    public String getREPORTID() {
        return REPORTID;
    }

    public void setREPORTID(String REPORTID) {
        this.REPORTID = REPORTID;
    }

    public String getPatIndexNo() {
        return patIndexNo;
    }

    public void setPatIndexNo(String patIndexNo) {
        this.patIndexNo = patIndexNo;
    }
}
