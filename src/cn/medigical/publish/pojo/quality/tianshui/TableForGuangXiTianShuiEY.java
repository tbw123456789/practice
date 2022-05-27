package cn.medigical.publish.pojo.quality.tianshui;

import cn.medigical.publish.pojo.patientLink.ShuQianFanShi;

public class TableForGuangXiTianShuiEY {
    private ShuQianFanShi shuQianFanShi;

    public ShuQianFanShi getShuQianFanShi() {
        if (shuQianFanShi == null) {
            shuQianFanShi = new ShuQianFanShi();
        }
        return shuQianFanShi;
    }

    public void setShuQianFanShi(ShuQianFanShi shuQianFanShi) {
        this.shuQianFanShi = shuQianFanShi;
    }
}
