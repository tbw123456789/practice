package cn.medigical.publish.pojo;

public class PatientLinkTable {
    private String id;
    private  String nameN;
    private  String nln;
    private String sg;
    private String xb;
    private  String ksmc;
    private  String zyh;
    private String sqzd;
    private  String nss;
    private  String ssys;
    private String sssqrq;
    private  String zt;
    private String pbssjh;

    public String getPbssjh() {
        if(pbssjh==null){
            pbssjh="";
        }
        return pbssjh;
    }

    public void setPbssjh(String pbssjh) {
        this.pbssjh = pbssjh;
    }

    public String getXb() {
        if(xb==null){
            xb="";
        }
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameN() {
        if(nameN==null){
            nameN="";
        }
        return nameN;
    }

    public void setNameN(String nameN) {
        this.nameN = nameN;
    }

    public String getNln() {
        if(nln==null){
            nln="";
        }
        return nln;
    }

    public void setNln(String nln) {
        this.nln = nln;
    }

    public String getSg() {
        if(sg==null){
            sg="";
        }
        return sg;
    }

    public void setSg(String sg) {
        this.sg = sg;
    }

    public String getKsmc() {
        if(ksmc==null){
            ksmc="";
        }
        return ksmc;
    }

    public void setKsmc(String ksmc) {
        this.ksmc = ksmc;
    }

    public String getZyh() {
        if(zyh==null){
            zyh="";
        }
        return zyh;
    }

    public void setZyh(String zyh) {
        this.zyh = zyh;
    }

    public String getSqzd() {
        if(sqzd==null){
            sqzd="";
        }
        return sqzd;
    }

    public void setSqzd(String sqzd) {
        this.sqzd = sqzd;
    }

    public String getNss() {
        if(nss==null){
            nss="";
        }
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getSsys() {
        if(ssys==null){
            ssys="";
        }
        return ssys;
    }

    public void setSsys(String ssys) {
        this.ssys = ssys;
    }

    public String getSssqrq() {
        if(sssqrq==null){
            sssqrq="";
        }
        return sssqrq;
    }

    public void setSssqrq(String sssqrq) {
        this.sssqrq = sssqrq;
    }

    public String getZt() {
        if(zt==null){
            zt="";
        }
        return zt;
    }

    public void setZt(String zt) {
        this.zt = zt;
    }
}
