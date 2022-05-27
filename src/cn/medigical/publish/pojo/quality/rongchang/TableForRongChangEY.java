package cn.medigical.publish.pojo.quality.rongchang;

import cn.medigical.publish.pojo.patientLink.GanRanXinXi;
import cn.medigical.publish.pojo.patientLink.GongFenXiangQing;
import cn.medigical.publish.pojo.patientLink.ShuQianFanShi;
import org.springframework.data.mongodb.core.mapping.Field;

public class TableForRongChangEY {

    @Field(value="zhiKongXinXi")
    private ZhiKongXinXi zhiKongXinXi;

    @Field(value = "gongFenXiangQing")
    private GongFenXiangQing gongFenXiangQing;
    @Field(value = "shuQianFanShi")
    private ShuQianFanShi shuQianFanShi;

    private GanRanXinXi ganRanXinXi;

    public GanRanXinXi getGanRanXinXi() {
        if (ganRanXinXi == null){
            ganRanXinXi = new GanRanXinXi();
        }
        return ganRanXinXi;
    }

    public void setGanRanXinXi(GanRanXinXi ganRanXinXi) {
        this.ganRanXinXi = ganRanXinXi;
    }

    public ShuQianFanShi getShuQianFanShi() {
        if (shuQianFanShi == null){
            shuQianFanShi = new ShuQianFanShi();
        }
        return shuQianFanShi;
    }

    public void setShuQianFanShi(ShuQianFanShi shuQianFanShi) {
        this.shuQianFanShi = shuQianFanShi;
    }

    public ZhiKongXinXi getZhiKongXinXi() {

        if(zhiKongXinXi == null)
        {
            zhiKongXinXi = new ZhiKongXinXi();
        }
        return zhiKongXinXi;
    }

    public void setZhiKongXinXi(ZhiKongXinXi zhiKongXinXi) {
        this.zhiKongXinXi = zhiKongXinXi;
    }

    public GongFenXiangQing getGongFenXiangQing() {
        if (gongFenXiangQing == null) {
            gongFenXiangQing = new GongFenXiangQing();
        }
        return gongFenXiangQing;
    }

    public void setGongFenXiangQing(GongFenXiangQing gongFenXiangQing) {
        this.gongFenXiangQing = gongFenXiangQing;
    }
}
