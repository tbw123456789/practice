package cn.medigical.publish.pojo.xiandaiyiyuan;

import java.util.ArrayList;
import java.util.List;

public class RequestChargingData {

    private String jybh = "000001";

    private Data data;

    private boolean checkInStock;

    private List<CheckProject> checkProjects;

    private String plinkId;

    private String flag;

    public boolean isCheckInStock() {
        return checkInStock;
    }

    public void setCheckInStock(boolean checkInStock) {
        this.checkInStock = checkInStock;
    }

    public List<CheckProject> getCheckProjects() {
        if(checkProjects == null){
            checkProjects = new ArrayList<>();
        }
        return checkProjects;
    }

    public void setCheckProjects(List<CheckProject> checkProjects) {
        this.checkProjects = checkProjects;
    }

    public String getPlinkId() {
        return plinkId;
    }

    public void setPlinkId(String plinkId) {
        this.plinkId = plinkId;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getJybh() {
        return jybh;
    }

    public void setJybh(String jybh) {
        this.jybh = jybh;
    }

    public Data getData() {
        if(data == null){
            data = new Data();
        }
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
