package cn.medigical.publish.pojo.lis;

import java.util.Date;

public class LisReportDetail {
    private String EXAMID;
    private Date AUTHTIME;
    private String ITEMSHORTNAME  ;
    private String RESULT;
    private String patIndexNo;

    public String getEXAMID() {
        return EXAMID;
    }

    public void setEXAMID(String EXAMID) {
        this.EXAMID = EXAMID;
    }

    public Date getAUTHTIME() {
        return AUTHTIME;
    }

    public void setAUTHTIME(Date AUTHTIME) {
        this.AUTHTIME = AUTHTIME;
    }

    public String getITEMSHORTNAME() {
        return ITEMSHORTNAME;
    }

    public void setITEMSHORTNAME(String ITEMSHORTNAME) {
        this.ITEMSHORTNAME = ITEMSHORTNAME;
    }

    public String getRESULT() {
        return RESULT;
    }

    public void setRESULT(String RESULT) {
        this.RESULT = RESULT;
    }

    public String getPatIndexNo() {
        return patIndexNo;
    }

    public void setPatIndexNo(String patIndexNo) {
        this.patIndexNo = patIndexNo;
    }
}
