package cn.medigical.publish.pojo.daPing;
public class PaiBanTable {
	private boolean shijian = true;
    private boolean shoushujian = false;
    private boolean zhuyuanhao = false;
    private boolean xingming = false;
    private boolean xingbie = false;
    private boolean nianling = false;
    private boolean bingshi = false;
    private boolean shoushuneirong = false;
    private boolean shoushuzhe = false;
    private boolean mazuifangfa = false;
    private boolean mazuizhe = false;
    private boolean hushi = false;
    private boolean huangtai = false;
//    private boolean mazuifangfa=false;

    private String notice;



    public boolean isShijian() {
        return shijian;
    }

    public void setShijian(boolean shijian) {
        this.shijian = shijian;
    }

    public boolean isShoushujian() {
        return shoushujian;
    }

    public boolean isHuangtai() {
        return huangtai;
    }

    public void setHuangtai(boolean huangtai) {
        this.huangtai = huangtai;
    }

    public void setShoushujian(boolean shoushujian) {
        this.shoushujian = shoushujian;
    }

    public boolean isZhuyuanhao() {
        return zhuyuanhao;
    }

    public void setZhuyuanhao(boolean zhuyuanhao) {
        this.zhuyuanhao = zhuyuanhao;
    }

    public boolean isXingming() {
        return xingming;
    }

    public void setXingming(boolean xingming) {
        this.xingming = xingming;
    }

    public boolean isXingbie() {
        return xingbie;
    }

    public void setXingbie(boolean xingbie) {
        this.xingbie = xingbie;
    }

    public boolean isNianling() {
        return nianling;
    }

    public void setNianling(boolean nianling) {
        this.nianling = nianling;
    }

    public boolean isBingshi() {
        return bingshi;
    }

    public void setBingshi(boolean bingshi) {
        this.bingshi = bingshi;
    }

    public boolean isShoushuneirong() {
        return shoushuneirong;
    }

    public void setShoushuneirong(boolean shoushuneirong) {
        this.shoushuneirong = shoushuneirong;
    }

    public boolean isShoushuzhe() {
        return shoushuzhe;
    }

    public void setShoushuzhe(boolean shoushuzhe) {
        this.shoushuzhe = shoushuzhe;
    }

    public boolean isMazuifangfa() {
        return mazuifangfa;
    }

    public void setMazuifangfa(boolean mazuifangfa) {
        this.mazuifangfa = mazuifangfa;
    }

    public boolean isMazuizhe() {
        return mazuizhe;
    }

    public void setMazuizhe(boolean mazuizhe) {
        this.mazuizhe = mazuizhe;
    }

    public boolean isHushi() {
        return hushi;
    }

    public void setHushi(boolean hushi) {
        this.hushi = hushi;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @Override
    public String toString() {
        return "PaiBanTable{" +
                "shijian=" + shijian +
                ", shoushujian=" + shoushujian +
                ", zhuyuanhao=" + zhuyuanhao +
                ", xingming=" + xingming +
                ", xingbie=" + xingbie +
                ", nianling=" + nianling +
                ", bingshi=" + bingshi +
                ", shoushuneirong=" + shoushuneirong +
                ", shoushuzhe=" + shoushuzhe +
                ", mazuifangfa=" + mazuifangfa +
                ", mazuizhe=" + mazuizhe +
                ", hushi=" + hushi +
                ", notice='" + notice + '\'' +
                '}';
    }
	
}
