package cn.medigical.publish.pojo.patientLink;

import javafx.beans.property.StringProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashMap;
import java.util.Map;

@Document(collection = "gongFenXiangQing")
public class GongFenXiangQing {

    @Field(value = "mzfsgf")
    private String mzfsgf;     //麻醉方式工分存储方式为JSON 格式需要解析
    private String zongfen;    //总分
    private String ycdmccjjc;    //有创动脉穿刺及监测
    private String zxjmccjjc;    //中心静脉穿刺及监测
    private String mzsdjc;    //麻醉深度监测
    private String xljc;//血淋监测
    private String szcs;    //术中超声
    private String szxqfx;    //术中血气分析
    private String fsxqfx;    //复苏血气分析
    private String jbysszxqfx;    //血气分析(接班)
    private String shzt;    //术后镇痛
    private String qsmzjcxs;    //全身麻醉监测小时
    private String jbysgf1;    //接班医生工分
    private String fsysjcf;    //复苏医生监测分
    private HashMap<String, Float> mapMzfsgf; //存放一个月的 麻醉方式工分


    private String yylhmz;    //腰硬联合麻醉
    private String ymwmz;    //硬膜外麻醉
    private String fcgqm;    //非插管全麻
    private String qsmz_dqg;    //全身麻醉(单腔管)
    private String qsmz_sqg;    //全身麻醉(双腔管)
    private String zgnmz;    //椎管内麻醉
    private String yylh;    //腰硬联合
    private String ymwm;    //硬膜外
    private String sjzzmz;    //神经阻滞麻醉
    private String fqsmzjcxs;
    private String fhmz;    //复合麻醉
    private String qjqgcg;    //抢救气管插管
    private String wtfm;    //无痛分娩
    //有创动脉穿刺及监测(接班)
    private String jbysycdmccjjc;
    //中心静脉穿刺(接班)
    private String jbyszxjmccjjc;

    public GongFenXiangQing() {
        zongfen = "0";
        mzfsgf = "0";
        zongfen = "0";
        ycdmccjjc = "0";
        zxjmccjjc = "0";
        mzsdjc = "0";
        xljc = "0";
        szcs = "0";
        szxqfx = "0";
        fsxqfx = "0";
        shzt = "0";
        qsmzjcxs = "0";
        jbysgf1 = "0";
        fsysjcf = "0";
        jbysycdmccjjc = "0";
        jbyszxjmccjjc = "0";
        jbysszxqfx = "0";
    }

    public String getMzfsgf() {
        return mzfsgf;
    }

    public void setMzfsgf(String mzfsgf) {
        this.mzfsgf = mzfsgf;
    }

    public String getZongfen() {
        return zongfen;
    }

    public void setZongfen(String zongfen) {
        this.zongfen = zongfen;
    }

    public String getYcdmccjjc() {
        return ycdmccjjc;
    }

    public void setYcdmccjjc(String ycdmccjjc) {
        this.ycdmccjjc = ycdmccjjc;
    }

    public String getZxjmccjjc() {
        return zxjmccjjc;
    }

    public void setZxjmccjjc(String zxjmccjjc) {
        this.zxjmccjjc = zxjmccjjc;
    }

    public String getMzsdjc() {
        return mzsdjc;
    }

    public void setMzsdjc(String mzsdjc) {
        this.mzsdjc = mzsdjc;
    }

    public String getXljc() {
        return xljc;
    }

    public void setXljc(String xljc) {
        this.xljc = xljc;
    }

    public String getSzcs() {
        return szcs;
    }

    public void setSzcs(String szcs) {
        this.szcs = szcs;
    }

    public String getSzxqfx() {
        return szxqfx;
    }

    public void setSzxqfx(String szxqfx) {
        this.szxqfx = szxqfx;
    }

    public String getFsxqfx() {
        return fsxqfx;
    }

    public void setFsxqfx(String fsxqfx) {
        this.fsxqfx = fsxqfx;
    }

    public String getShzt() {
        return shzt;
    }

    public void setShzt(String shzt) {
        this.shzt = shzt;
    }

    public String getQsmzjcxs() {
        return qsmzjcxs;
    }

    public void setQsmzjcxs(String qsmzjcxs) {
        this.qsmzjcxs = qsmzjcxs;
    }

    public String getJbysgf1() {
        return jbysgf1;
    }

    public void setJbysgf1(String jbysgf1) {
        this.jbysgf1 = jbysgf1;
    }

    public String getFsysjcf() {
        return fsysjcf;
    }

    public void setFsysjcf(String fsysjcf) {
        this.fsysjcf = fsysjcf;
    }

    public HashMap<String, Float> getMapMzfsgf() {
        return mapMzfsgf;
    }

    public void setMapMzfsgf(HashMap<String, Float> mapMzfsgf) {
        this.mapMzfsgf = mapMzfsgf;
    }

    public String getYylhmz() {
        return yylhmz;
    }

    public void setYylhmz(String yylhmz) {
        this.yylhmz = yylhmz;
    }

    public String getYmwmz() {
        return ymwmz;
    }

    public void setYmwmz(String ymwmz) {
        this.ymwmz = ymwmz;
    }

    public String getFcgqm() {
        return fcgqm;
    }

    public void setFcgqm(String fcgqm) {
        this.fcgqm = fcgqm;
    }

    public String getQsmz_dqg() {
        return qsmz_dqg;
    }

    public void setQsmz_dqg(String qsmz_dqg) {
        this.qsmz_dqg = qsmz_dqg;
    }

    public String getQsmz_sqg() {
        return qsmz_sqg;
    }

    public void setQsmz_sqg(String qsmz_sqg) {
        this.qsmz_sqg = qsmz_sqg;
    }

    public String getZgnmz() {
        return zgnmz;
    }

    public void setZgnmz(String zgnmz) {
        this.zgnmz = zgnmz;
    }

    public String getYylh() {
        return yylh;
    }

    public void setYylh(String yylh) {
        this.yylh = yylh;
    }

    public String getYmwm() {
        return ymwm;
    }

    public void setYmwm(String ymwm) {
        this.ymwm = ymwm;
    }

    public String getSjzzmz() {
        return sjzzmz;
    }

    public void setSjzzmz(String sjzzmz) {
        this.sjzzmz = sjzzmz;
    }

    public String getFqsmzjcxs() {
        return fqsmzjcxs;
    }

    public void setFqsmzjcxs(String fqsmzjcxs) {
        this.fqsmzjcxs = fqsmzjcxs;
    }

    public String getFhmz() {
        return fhmz;
    }

    public void setFhmz(String fhmz) {
        this.fhmz = fhmz;
    }

    public String getQjqgcg() {
        return qjqgcg;
    }

    public void setQjqgcg(String qjqgcg) {
        this.qjqgcg = qjqgcg;
    }

    public String getWtfm() {
        return wtfm;
    }

    public void setWtfm(String wtfm) {
        this.wtfm = wtfm;
    }

    public String getJbysycdmccjjc() {
        return jbysycdmccjjc;
    }

    public void setJbysycdmccjjc(String jbysycdmccjjc) {
        this.jbysycdmccjjc = jbysycdmccjjc;
    }

    public String getJbyszxjmccjjc() {
        return jbyszxjmccjjc;
    }

    public void setJbyszxjmccjjc(String jbyszxjmccjjc) {
        this.jbyszxjmccjjc = jbyszxjmccjjc;
    }

    public String getJbysszxqfx() {
        return jbysszxqfx;
    }

    public void setJbysszxqfx(String jbysszxqfx) {
        this.jbysszxqfx = jbysszxqfx;
    }
}