package cn.medigical.publish.interfaces.his.hisLink;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 博创医疗 on 2010/5/20.
 * Copyright by 博创医疗
 */
public class HospitalConst {
    //软件版本
    public static final String SOFTVER_ZHEJIANG_HUZHOU = "softVer_ZheJiang_HuZhou"; //浙江湖州
    public static final String SOFTVER_SICHUN_GONGXIAN = "softVeer_SiChuan_GongXian"; //四川珙县

    //湖州市第一人民医院
    public static final String ZHEJIANG_HUZHOU_YIYUAN_CODE = "zheJiang_huZhou_yiYuan";
    public static final String ZHEJIANG_HUZHOU_YIYUAN_NAME = "湖州市第一人民医院";
    //四川珙县中医院
    public static final String SICHUAN_GONGXIAN_ZHONGYIYUAN_CODE = "siChuan_gongXian_zhongYiYuan";
    public static final String SICHUAN_GONGXIAN_ZHONGYIYUAN_NAME = "珙县中医院";
    //重庆垫江县中医院
    public static final String CHONGQING_DIANJIANG_ZHONGYIYUAN_CODE = "chongQing_dianJiang_zhongYiYuan";
    public static final String CHONGQING_DIANJIANG_ZHONGYIYUAN_NAME = "重庆垫江县中医院";
    //四川井研县人民医院
    public static final String SICHUAN_JINGYAN_RENMINYIYUAN_CODE = "siChuan_jingYan_renminYiYuan";
    public static final String SICHUAN_JINGYAN_RENMINYIYUAN_NAME = "浙江省龙泉市人民医院";
    //浙江龙泉市人民医院
//    public static final String ZHEJIANG_LONGQUAN_RENMINYIYUAN_CODE = "siChuan_jingYan_renminYiYuan";
//    public static final String ZHEJIANG_LONGQUAN_RENMINYIYUAN_NAME = "浙江省龙泉市人民医院";


    public static Map<String, String> codeMapSoftVer = new HashMap<>(); //医院代码和软件版本号的影身
    public static Map<String, String> codeMapName = new HashMap<>(); //医院代码和医院名称的映射

    static {
        codeMapSoftVer.put(ZHEJIANG_HUZHOU_YIYUAN_CODE, SOFTVER_ZHEJIANG_HUZHOU);
        codeMapName.put(ZHEJIANG_HUZHOU_YIYUAN_CODE, ZHEJIANG_HUZHOU_YIYUAN_NAME);

        codeMapSoftVer.put(SICHUAN_GONGXIAN_ZHONGYIYUAN_CODE, SOFTVER_SICHUN_GONGXIAN);
        codeMapName.put(SICHUAN_GONGXIAN_ZHONGYIYUAN_CODE, SICHUAN_GONGXIAN_ZHONGYIYUAN_NAME);

        codeMapSoftVer.put(SICHUAN_JINGYAN_RENMINYIYUAN_CODE, SOFTVER_SICHUN_GONGXIAN);
        codeMapName.put(SICHUAN_JINGYAN_RENMINYIYUAN_CODE, SICHUAN_JINGYAN_RENMINYIYUAN_NAME);

        codeMapSoftVer.put(CHONGQING_DIANJIANG_ZHONGYIYUAN_CODE, SOFTVER_SICHUN_GONGXIAN);
        codeMapName.put(CHONGQING_DIANJIANG_ZHONGYIYUAN_CODE, CHONGQING_DIANJIANG_ZHONGYIYUAN_NAME);

//        codeMapSoftVer.put(ZHEJIANG_LONGQUAN_RENMINYIYUAN_CODE, SOFTVER_SICHUN_GONGXIAN);
//        codeMapName.put(ZHEJIANG_LONGQUAN_RENMINYIYUAN_CODE, ZHEJIANG_LONGQUAN_RENMINYIYUAN_NAME);

    }
}
