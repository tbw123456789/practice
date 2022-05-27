package cn.medigical.publish.pojo.xiandaiyiyuan;

import java.util.ArrayList;
import java.util.List;

public class Data {

    private String kh;

    private int cs = 1;

    private int bj = 1;

    private List<ChargeProject> chargProject;

    public String getKh() {
        return kh;
    }

    public void setKh(String kh) {
        this.kh = kh;
    }

    public int getCs() {
        return cs;
    }

    public void setCs(int cs) {
        this.cs = cs;
    }

    public int getBj() {
        return bj;
    }

    public void setBj(int bj) {
        this.bj = bj;
    }

    public List<ChargeProject> getChargProject() {
        if(chargProject == null){
            chargProject = new ArrayList<>();
        }
        return chargProject;
    }

    public void setChargProject(List<ChargeProject> chargProject) {
        this.chargProject = chargProject;
    }
}
