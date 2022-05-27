package cn.medigical.publish.controller;

import java.io.File;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.swing.filechooser.FileSystemView;

import cn.medigical.publish.dao.impl.dictionary.ConfigAnesMethodsDao;
import cn.medigical.publish.dao.impl.dictionary.ConfigAnesMethodsGroupDao;
import cn.medigical.publish.pojo.dictionary.ConfigAnesMethods;
import cn.medigical.publish.pojo.dictionary.ConfigAnesMethodsGroup;
import cn.medigical.publish.pojo.patientLink.GanRanXinXi;
import cn.medigical.publish.pojo.quality.rongchang.ZhiKongXinXi;
import cn.medigical.publish.utils.*;
import javafx.stage.DirectoryChooser;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.medigical.publish.dao.impl.AccountDao;
import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.dao.impl.QualityMessageDao;
import cn.medigical.publish.pojo.Account;
import cn.medigical.publish.pojo.daPing.KeShiTJ;
import cn.medigical.publish.pojo.highcharts.Highchart;
import cn.medigical.publish.pojo.patientLink.AnesthesiaRecord;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.pojo.zhikong.QualityMessage;
import cn.medigical.publish.pojo.zhikong.QualityStatistics;
import cn.medigical.publish.pojo.zhikong.SeriesData;
import cn.medigical.publish.pojo.zhikong.ZhikongMessage;

/**
 *
 * 质控统计 1.入口zhikong.do(275-341) 通过入口加载网页,待网页加载完成后通过网页ajax访问zhikongA.do(349-415) 2.图表 zhikongAjax.do(420-461) 3.跳转详情页 zhikongDetailed.do(482-580)
 *
 * 4.如要加减数据 需要在getValue方法中加入(显示顺序从上到下依次) dataList.add(new ZhikongMessage("显示的名字", m.getXXX(), avg(m, m.getXXX()), m.getPatientLinkCount(), "XXX")); 在静态方法中加入 ContextMessage.zhikongDB.put("XXX", "数据库中的位置  如:qualityPojo.sgssjmcc"); ContextMessage.zhikongzhibiao.put("XXX", "显示的名字"); 在getOneDate(返回long 图表使用)和getOneDate(返回List 详情页使用)和calValue(所有数据的统计) 3个方法中加入统计的方法
 *
 * @author bc_liaoyx
 *
 */
@Controller
@RequestMapping("ZhikongController")
public class ZhikongController {

    private String Name = PropertyUtil.getProperty("Hospital.Name");

    {
        ContextMessage.zhikongDB.put("SiWang", Name + ".zhiKongXinXi.Ywsw");
        ContextMessage.zhikongDB.put("Mzksh24xsnxtzt", Name + ".zhiKongXinXi.mzksh24xsnxtzt");
        ContextMessage.zhikongDB.put("Mzhssqx", Name + ".zhiKongXinXi.mzhssqx");
        ContextMessage.zhikongDB.put("Mzqjyzgmfy", Name + ".zhiKongXinXi.mzqjyzgmfy");
        ContextMessage.zhikongDB.put("Zgnmzhyzsjxtbfzfs", Name + ".zhiKongXinXi.zgnmzhyzsjxtbfzfs");
        ContextMessage.zhikongDB.put("Zxjmccyzbf", Name + ".zhiKongXinXi.zxjmccyzbf");
        ContextMessage.zhikongDB.put("Jnjmcc", Name + ".zhiKongXinXi.jnjmcc");
        ContextMessage.zhikongDB.put("Ndmcc", Name + ".zhiKongXinXi.ndmcc");
        ContextMessage.zhikongDB.put("Qmqgbghssfs", Name + ".zhiKongXinXi.qmqgbghssfs");
        ContextMessage.zhikongDB.put("Mzsshxfhmfs", Name + ".zhiKongXinXi.mzsshxfhmfs");
        ContextMessage.zhikongDB.put("FjhzrICUfs", Name + ".zhiKongXinXi.fjhzrICUfs");
        ContextMessage.zhikongDB.put("Fjhecqgbg", Name + ".zhiKongXinXi.fjhecqgbg");
        ContextMessage.zhikongDB.put("Fjhecss", Name + ".zhiKongXinXi.fjhecss");
        ContextMessage.zhikongDB.put("Fjhecmz", Name + ".zhiKongXinXi.fjhecmz");
        ContextMessage.zhikongDB.put("Szsxsyfy", Name + ".zhiKongXinXi.szsxsyfy");
        ContextMessage.zhikongDB.put("Weizhong", Name + ".zhiKongXinXi.szsxsyfy");
        ContextMessage.zhikongDB.put("Ywsw", Name + ".zhiKongXinXi.ywsw");
        ContextMessage.zhikongDB.put("DuoCiChaGuan",Name + ".zhiKongXinXi.dccg");
        ContextMessage.zhikongDB.put("Wyqysza", Name + ".zhiKongXinXi.wyqysza");
        ContextMessage.zhikongDB.put("Spo2jiangdi", Name + ".zhiKongXinXi.ybhhdzdjd");
        ContextMessage.zhikongDB.put("Jsssycxyw", Name + ".zhiKongXinXi.jsssycxyw");
        ContextMessage.zhikongDB.put("Ywywxyfhxdgz", Name + ".zhiKongXinXi.ywywxyfhxdgz");
        ContextMessage.zhikongDB.put("Xffs", Name + ".zhiKongXinXi.xffs");// tableForRongChangEY.zhiKongXinXi.Xffsbcg
        ContextMessage.zhikongDB.put("Xffscg", Name + ".zhiKongXinXi.xffscg");
        ContextMessage.zhikongDB.put("Stewardbig4", Name + ".zhiKongXinXi.stewardpf");
        ContextMessage.zhikongDB.put("Asa1", Name + ".anesthesiaRecord.asa.Asa1");
        ContextMessage.zhikongDB.put("Asa2", Name + ".anesthesiaRecord.asa.Asa2");
        ContextMessage.zhikongDB.put("Asa3", Name + ".anesthesiaRecord.asa.Asa3");
        ContextMessage.zhikongDB.put("Asa4", Name + ".anesthesiaRecord.asa.Asa4");
        ContextMessage.zhikongDB.put("Asa5", Name + ".anesthesiaRecord.asa.Asa5");
        ContextMessage.zhikongDB.put("Asa6", Name + ".anesthesiaRecord.asa.Asa6");
        ContextMessage.zhikongDB.put("AsaSw1", Name + ".zhiKongXinXi.aSAsw1");
        ContextMessage.zhikongDB.put("AsaSw2", Name + ".zhiKongXinXi.aSAsw2");
        ContextMessage.zhikongDB.put("AsaSw3", Name + ".zhiKongXinXi.aSAsw3");
        ContextMessage.zhikongDB.put("AsaSw4", Name + ".zhiKongXinXi.aSAsw4");
        ContextMessage.zhikongDB.put("AsaSw5", Name + ".zhiKongXinXi.aSAsw5");
        ContextMessage.zhikongDB.put("AsaSw6", Name + ".zhiKongXinXi.aSAsw6");
        ContextMessage.zhikongDB.put("PACUrsdtwfs",Name + ".zhiKongXinXi.pACUrsdtwfs");
        ContextMessage.zhikongDB.put("Ssqkfl1", Name + ".zhiKongXinXi.ssqkfl1");
        ContextMessage.zhikongDB.put("Ssqkfl2", Name + ".zhiKongXinXi.ssqkfl2");
        ContextMessage.zhikongDB.put("Ssqkfl3", Name + ".zhiKongXinXi.ssqkfl3");
        ContextMessage.zhikongDB.put("Ssqkfl4", Name + ".zhiKongXinXi.ssqkfl4");
        ContextMessage.zhikongDB.put("Jczzsh", Name + ".zhiKongXinXi.jczzsh");
        ContextMessage.zhikongDB.put("Sczzss", Name + ".zhiKongXinXi.sczzss");
        ContextMessage.zhikongDB.put("Qgss", Name + ".zhiKongXinXi.qgss");
        ContextMessage.zhikongDB.put("Kxnss", Name + ".zhiKongXinXi.kxnss");
        ContextMessage.zhikongDB.put("Twxh", Name + ".zhiKongXinXi.twxh");
        ContextMessage.zhikongDB.put("PACUzryc", Name + ".zhiKongXinXi.pACUzryc");
        ContextMessage.zhikongDB.put("Shqgbgbc", Name + ".zhiKongXinXi.shqgbgbc");
        ContextMessage.zhikongDB.put("Sgssjmcc", Name + ".zhiKongXinXi.sgssjmcc");
        ContextMessage.zhikongDB.put("Gjmcc", Name + ".zhiKongXinXi.gjmcc");
        ContextMessage.zhikongDB.put("Zbdmcc", Name + ".zhiKongXinXi.zbdmcc");
        ContextMessage.zhikongDB.put("Mzhtt", Name + ".zhiKongXinXi.mzhtt");
        ContextMessage.zhikongDB.put("MaZuiQiJianYangBaoHeDu",Name + ".zhiKongXinXi.mzqjybhdyzjd");
        ContextMessage.zhikongDB.put("Ccdhzly", Name + ".zhiKongXinXi.ccdhzly");
        ContextMessage.zhikongDB.put("Dccg", Name + ".zhiKongXinXi.dccg");
        ContextMessage.zhikongDB.put("Sgxsjmcc", Name + ".zhiKongXinXi.sgxsjmcc");
        ContextMessage.zhikongDB.put("Dccc", Name + ".zhiKongXinXi.dccc");
        ContextMessage.zhikongDB.put("Exot", Name + ".zhiKongXinXi.exot");
        ContextMessage.zhikongDB.put("Zthdza", Name + ".zhiKongXinXi.zthdza");
        ContextMessage.zhikongDB.put("Zdss", Name + ".zhiKongXinXi.zdss");
        ContextMessage.zhikongDB.put("Cpyjm", Name + ".zhiKongXinXi.cpyjm");
        ContextMessage.zhikongDB.put("Szzx", Name + ".zhiKongXinXi.szzx");
        ContextMessage.zhikongDB.put("Szyzdxy", Name + ".zhiKongXinXi.szyzdxy");
        ContextMessage.zhikongDB.put("ycdmccyzbfz", Name + ".zhiKongXinXi.ycdmccyzbfz");
        ContextMessage.zhikongDB.put("FeiJiHuaGaiBianMaZui",Name + ".zhiKongXinXi.fjhgbmzfs");
        ContextMessage.zhikongDB.put("YinWuYanWuXiHuXiDaoGengSe",Name + ".zhiKongXinXi.ywywxyfhxdgz");
        ContextMessage.zhikongDB.put("Mzksh24xsnsw",Name + ".zhiKongXinXi.mzksh24xsnsw");
        ContextMessage.zhikongDB.put("Ycdmccyzbfzfs", Name + ".zhiKongXinXi.ycdmccyzbfzfs");
        ContextMessage.zhikongDB.put("Dmdgtl",Name + ".zhiKongXinXi.dmdgtl");
        ContextMessage.zhikongDB.put("Yxhs", Name + ".zhiKongXinXi.yxhs");
        ContextMessage.zhikongDB.put("Yongxueshu", "Yongxueshu");// Yxbhs
        ContextMessage.zhikongDB.put("Ghssfs", Name + ".zhiKongXinXi.ghssfs");
        ContextMessage.zhikongDB.put("Sssylgy", Name + ".zhiKongXinXi.sssylgy");
        ContextMessage.zhikongDB.put("Jxsx", Name + ".zhiKongXinXi.jxsx");
        ContextMessage.zhikongDB.put("Pgcsssj", Name + ".zhiKongXinXi.pgcsssj");
        ContextMessage.zhikongDB.put("Ztfmzpgc", Name + ".zhiKongXinXi.ztfmzpgc");
        ContextMessage.zhikongDB.put("Fssfwqgjzzss", Name + ".zhiKongXinXi.fssfwqgjzzss");
        ContextMessage.zhikongDB.put("Qtfyqxgsj",Name + ".zhiKongXinXi.qtfyqxgsj");
        ContextMessage.zhikongDB.put("Szsxblfy",Name + ".zhiKongXinXi.szsxblfy");
        ContextMessage.zhikongDB.put("Yjss", Name + ".zhiKongXinXi.yjss");
        ContextMessage.zhikongDB.put("Ejss", Name + ".zhiKongXinXi.yjss");
        ContextMessage.zhikongDB.put("Sjss", Name + ".zhiKongXinXi.sjss");
        ContextMessage.zhikongDB.put("Ssss", Name + ".zhiKongXinXi.ssss");
        ContextMessage.zhikongDB.put("Other",Name + ".zhiKongXinXi.qtyy");//其他


        ContextMessage.zhikongDB.put("MaZuiCount", "MaZuiCount");// 麻醉总数
        ContextMessage.zhikongDB.put("Csyd", "anesthesiaRecord.csyd");
        ContextMessage.zhikongDB.put("Dmcc", "anesthesiaRecord.dmcc");
        ContextMessage.zhikongDB.put("Pcea", "anesthesiaRecord.PCEA");
        ContextMessage.zhikongDB.put("Jwzl", "anesthesiaRecord.jwzl");
        ContextMessage.zhikongDB.put("zxg_y", "anesthesiaRecord.mzxg_y");
        ContextMessage.zhikongDB.put("Mzpd_l", "anesthesiaRecord.mzpd_l");
        ContextMessage.zhikongDB.put("Mzpd_bq", "anesthesiaRecord.mzpd_bq");
        ContextMessage.zhikongDB.put("Mzpd_wx", "anesthesiaRecord.mzpd_wx");
        ContextMessage.zhikongDB.put("Jyzl", "anesthesiaRecord.jyzl");
        ContextMessage.zhikongDB.put("Pcia", "anesthesiaRecord.PCIA");
        ContextMessage.zhikongDB.put("Pcsa", "anesthesiaRecord.PCSA");
        ContextMessage.zhikongDB.put("Pcna", "anesthesiaRecord.PCNA");
        ContextMessage.zhikongDB.put("Zxjmcc", "anesthesiaRecord.zxjmcc");
        ContextMessage.zhikongDB.put("Tsqgcg","anesthesiaRecord.tsqgcg");
//        ContextMessage.zhikongDB.put("Zhuiguanneixiaoguo1", "anesthesiaRecord.mazuiMethodComp.zm1");
//        ContextMessage.zhikongDB.put("Zhuiguanneixiaoguo2", "anesthesiaRecord.mazuiMethodComp.zm2");
//        ContextMessage.zhikongDB.put("Zhuiguanneixiaoguo3", "anesthesiaRecord.mazuiMethodComp.zm3");
//        ContextMessage.zhikongDB.put("Zhuiguanneixiaoguo4", "anesthesiaRecord.mazuiMethodComp.zm4");
        ContextMessage.zhikongDB.put("Sygzz", "anesthesiaRecord.sygzz");
        ContextMessage.zhikongDB.put("Jz", "anesthesiaRecord.asa.jz");
        ContextMessage.zhikongDB.put("Zhuiguanneimazauicount", "zhuiguanneimazauicount");
        ContextMessage.zhikongDB.put("Zongfen", "pacu.zongfen");
        ContextMessage.zhikongDB.put("Chaguanquanmacount", "chaguanquanmacount");
        ContextMessage.zhikongDB.put("Feichaguanquanmacount", "feichaguanquanmacount");
        ContextMessage.zhikongDB.put("Chaguanquanmaandzhuiguan", "chaguanquanmaandzhuiguan");
        ContextMessage.zhikongDB.put("Fuhemazuicount", "fuhemazuicount");
//        ContextMessage.zhikongDB.put("Jingmaimazuiconut", "jingmaimazuiconut");
        ContextMessage.zhikongDB.put("Qitamazuicount", "qitamazuicount");
        ContextMessage.zhikongDB.put("Yingmowai", "yingmowai");
        ContextMessage.zhikongDB.put("Jianhumazuicount", "jianhumazuicount");
        ContextMessage.zhikongDB.put("Shuhouzhentong", "shuhouzhentong");
        ContextMessage.zhikongDB.put("Shenjingzuzhi", "shenjingzuzhi");
        ContextMessage.zhikongDB.put("PatientLinkCount", "patientLinkCount");// 总数
        ContextMessage.zhikongDB.put("Hongxibaohuishu", "hongxibaohuishu");
        ContextMessage.zhikongDB.put("Fjhgbmzfs", Name + ".zhiKongXinXi.fjhgbmzfs");
        ContextMessage.zhikongDB.put("Zitixueshuzhu", "zitixueshuzhu");
        ContextMessage.zhikongDB.put("Shuxuecount", "shuxuecount");
        ContextMessage.zhikongDB.put("Icucount", "icucount");
        ContextMessage.zhikongDB.put("Pacucount", "pacucount");
        ContextMessage.zhikongDB.put("Otherpca", "otherpca");


        ContextMessage.zhikongzhibiao.put("MaZuiCount", "总麻醉数");

        ContextMessage.zhikongzhibiao.put("Mzksh24xsnsw", "围手术期死亡例数");
        ContextMessage.zhikongzhibiao.put("Mzksh24xsnxtzt", "围手术期心跳骤停例数");
        ContextMessage.zhikongzhibiao.put("Mzhssqx", "麻醉后手术取消例数");
        ContextMessage.zhikongzhibiao.put("Mzqjyzgmfy", "麻醉期间严重过敏反应发生例数");
        ContextMessage.zhikongzhibiao.put("Zgnmzhyzsjxtbfzfs", "椎管内麻醉后严重神经系统并发症");
        ContextMessage.zhikongzhibiao.put("MaZuiQiJianYangBaoHeDu","麻醉期间氧饱和度严重降低");
        ContextMessage.zhikongzhibiao.put("YinWuYanWuXiHuXiDaoGengSe","因误咽误吸引发呼吸道梗阻");
        ContextMessage.zhikongzhibiao.put("FeiJiHuaGaiBianMaZui","非计划改变麻醉方式");
        ContextMessage.zhikongzhibiao.put("PACUrsdtwfs","PACU入室低体温发生");
        ContextMessage.zhikongzhibiao.put("Zxjmccyzbf", "中心静脉穿刺严重并发症");
        ContextMessage.zhikongzhibiao.put("Zxjmcc", "中心静脉穿刺数");
        ContextMessage.zhikongzhibiao.put("Tsqgcg","特殊气管插管");
        ContextMessage.zhikongzhibiao.put("Jnjmcc", "静脉穿刺数");
        ContextMessage.zhikongzhibiao.put("Ndmcc", "桡动脉穿刺数");
        ContextMessage.zhikongzhibiao.put("Qmqgbghssfs", "全麻气管插管后声嘶发生例数");
        ContextMessage.zhikongzhibiao.put("Mzsshxfhmfs", "麻醉手术后新发昏迷发生例数");
        ContextMessage.zhikongzhibiao.put("Dmdgtl","动脉导管脱落");
        ContextMessage.zhikongzhibiao.put("FjhzrICUfs", "非计划转入ICU发生例数");
        ContextMessage.zhikongzhibiao.put("Fjhecqgbg", "非计划二次插管例数");
        ContextMessage.zhikongzhibiao.put("24XiaoShiNeiSiWang","麻醉开始后24小时内死亡");
        ContextMessage.zhikongzhibiao.put("Fjhecss", "非计划二次手术数");
        ContextMessage.zhikongzhibiao.put("Fjhgbmzfs", "非计划改变麻醉方式数");
        ContextMessage.zhikongzhibiao.put("Fjhecmz", "非计划二次麻醉数");
        ContextMessage.zhikongzhibiao.put("Szsxsyfy", "术中输血输液反应数");
        ContextMessage.zhikongzhibiao.put("Szsxblfy","术中输血不良反应");
        ContextMessage.zhikongzhibiao.put("Weizhong", "危重患者例数");
        ContextMessage.zhikongzhibiao.put("Hongxibaohuishu", "红细胞回输例数");
        ContextMessage.zhikongzhibiao.put("Ywsw", "意外死亡数");
        ContextMessage.zhikongzhibiao.put("Wyqysza", "未预期意识障碍数");
        ContextMessage.zhikongzhibiao.put("Spo2jiangdi", "氧饱和度重度降低数");
        ContextMessage.zhikongzhibiao.put("Jsssycxyw", "结束时使用催醒药物数");
        ContextMessage.zhikongzhibiao.put("Ywywxyfhxdgz", "因误咽误吸引发呼吸道梗阻数");
        ContextMessage.zhikongzhibiao.put("Qtfyqxgsj", "其他非预期相关事件数");
        ContextMessage.zhikongzhibiao.put("Xffs", "心肺复苏数");
        ContextMessage.zhikongzhibiao.put("Xffscg", "心肺复苏成功数");
        ContextMessage.zhikongzhibiao.put("Zongfen", "Steward评分≥4数");
        ContextMessage.zhikongzhibiao.put("PatientLinkCount", "总手术数");
        ContextMessage.zhikongzhibiao.put("Asa1", "ASA一级");
        ContextMessage.zhikongzhibiao.put("Asa2", "ASA二级");
        ContextMessage.zhikongzhibiao.put("Asa3", "ASA三级");
        ContextMessage.zhikongzhibiao.put("Asa4", "ASA四级");
        ContextMessage.zhikongzhibiao.put("Asa5", "ASA五级");
        ContextMessage.zhikongzhibiao.put("Asa6", "ASA六级");
        ContextMessage.zhikongzhibiao.put("AsaSw1", "ASA一级死亡数");
        ContextMessage.zhikongzhibiao.put("AsaSw2", "ASA二级死亡数");
        ContextMessage.zhikongzhibiao.put("AsaSw3", "ASA三级死亡数");
        ContextMessage.zhikongzhibiao.put("AsaSw4", "ASA四级死亡数");
        ContextMessage.zhikongzhibiao.put("AsaSw5", "ASA五级死亡数");
//        ContextMessage.zhikongzhibiao.put("Ssqkfl1", "手术分类1");
//        ContextMessage.zhikongzhibiao.put("Ssqkfl2", "手术分类2");
//        ContextMessage.zhikongzhibiao.put("Ssqkfl3", "手术分类3");
//        ContextMessage.zhikongzhibiao.put("Ssqkfl4", "手术分类4");
        ContextMessage.zhikongzhibiao.put("Jczzsh", "浅层组织手术");
        ContextMessage.zhikongzhibiao.put("Sczzss", "深层组织手术");
        ContextMessage.zhikongzhibiao.put("Qgss", "器官手术");
        ContextMessage.zhikongzhibiao.put("Kxnss", "腔隙内手术");
        ContextMessage.zhikongzhibiao.put("Twxh", "体外循环");
        ContextMessage.zhikongzhibiao.put("Shenjingzuzhi", "神经阻滞");
        ContextMessage.zhikongzhibiao.put("ycdmccyzbfz", "全麻相关并发症");
        ContextMessage.zhikongzhibiao.put("Jz", "急诊");
        ContextMessage.zhikongzhibiao.put("Zhuiguanneimazauicount", "椎管内麻醉");
        ContextMessage.zhikongzhibiao.put("Chaguanquanmacount", "插管全麻/全麻气管插管");
        ContextMessage.zhikongzhibiao.put("Feichaguanquanmacount", "非插管全麻");
        ContextMessage.zhikongzhibiao.put("Chaguanquanmaandzhuiguan", "插管全麻+椎管内麻醉");
        ContextMessage.zhikongzhibiao.put("Fuhemazuicount", "复合麻醉");
//        ContextMessage.zhikongzhibiao.put("Jingmaimazuiconut", "静脉麻醉例数");
        ContextMessage.zhikongzhibiao.put("Qitamazuicount", "其它麻醉");
        ContextMessage.zhikongzhibiao.put("Yingmowai", "硬膜外");
        ContextMessage.zhikongzhibiao.put("Jianhumazuicount", "监护麻醉");

        ContextMessage.zhikongzhibiao.put("Shuhouzhentong", "术后镇痛");
        ContextMessage.zhikongzhibiao.put("PACUzryc", "PACU转出延迟");
        ContextMessage.zhikongzhibiao.put("Ztfmzpgc", "镇痛分娩转剖宫产");
        ContextMessage.zhikongzhibiao.put("Zitixueshuzhu", "自体血输注 400ml以上");
        ContextMessage.zhikongzhibiao.put("Shuxuecount", "输血400ml以上");
        ContextMessage.zhikongzhibiao.put("Shqgbgbc", "术后气管插管拔除");
        ContextMessage.zhikongzhibiao.put("Icucount", "转入ICU");
        ContextMessage.zhikongzhibiao.put("Pacucount", "转入PACU");
        ContextMessage.zhikongzhibiao.put("Pcia", "静脉PCA，PCIA");
        ContextMessage.zhikongzhibiao.put("Pcsa", "皮下PCA，PCSA");
        ContextMessage.zhikongzhibiao.put("Pcea", "硬膜外，PCEA");
        ContextMessage.zhikongzhibiao.put("Pcna", "神经丛，PCNA");
        ContextMessage.zhikongzhibiao.put("Otherpca", "其他pca");
        ContextMessage.zhikongzhibiao.put("Sgssjmcc", "锁骨上静脉穿刺数");
        ContextMessage.zhikongzhibiao.put("Gjmcc", "股静脉穿刺数");
        ContextMessage.zhikongzhibiao.put("Zbdmcc", "足背动脉穿刺数");
        ContextMessage.zhikongzhibiao.put("Mzhtt", "麻醉后头痛数");
        ContextMessage.zhikongzhibiao.put("Ccdhzly", "穿刺点红肿数");
        ContextMessage.zhikongzhibiao.put("Dccg", "多次插管数");
        ContextMessage.zhikongzhibiao.put("Sgxsjmcc", "锁骨下静脉穿刺数");
        ContextMessage.zhikongzhibiao.put("Dccc", "多次穿刺数");
        ContextMessage.zhikongzhibiao.put("Exot", "恶心呕吐数");
        ContextMessage.zhikongzhibiao.put("Zthdza", "肢体障碍数");
        ContextMessage.zhikongzhibiao.put("Zdss", "重大手术数");
        ContextMessage.zhikongzhibiao.put("Jyzl", "控制性降压");
        ContextMessage.zhikongzhibiao.put("Cpyjm", "穿破硬脊膜");
        ContextMessage.zhikongzhibiao.put("Szzx", "术中知晓");
        ContextMessage.zhikongzhibiao.put("Szyzdxy", "术中低血压");
        ContextMessage.zhikongzhibiao.put("Ycdmccyzbfzfs", "有创动脉穿刺并发");
        ContextMessage.zhikongzhibiao.put("Yongxueshu", "用血数");
        ContextMessage.zhikongzhibiao.put("Yxhs", "用血合适例数");
        ContextMessage.zhikongzhibiao.put("Ghssfs", "更改手术方式");
        ContextMessage.zhikongzhibiao.put("Sssylgy", "手术室医疗干预");
        ContextMessage.zhikongzhibiao.put("Jxsx", "急性失血");
        ContextMessage.zhikongzhibiao.put("Pgcsssj", "剖宫产手术时间大于3小时");
        ContextMessage.zhikongzhibiao.put("Fssfwqgjzzss", "非手术范围器官损伤");
        ContextMessage.zhikongzhibiao.put("Csyd", "超声引导");
        ContextMessage.zhikongzhibiao.put("Dmcc", "动脉穿刺");
        ContextMessage.zhikongzhibiao.put("Sygzz", "使用输注工作站");
        ContextMessage.zhikongzhibiao.put("Jwzl", "血液加温治疗");
        ContextMessage.zhikongzhibiao.put("Mzxg_y", "麻醉效果优");
        ContextMessage.zhikongzhibiao.put("Mzpd_l", "麻醉效果良");
        ContextMessage.zhikongzhibiao.put("Mzpd_bq", "麻醉效果不全");
        ContextMessage.zhikongzhibiao.put("Mzpd_wx", "麻醉效果无效");
//        ContextMessage.zhikongzhibiao.put("Zhuiguanneixiaoguo1", "椎管内效果1");
//        ContextMessage.zhikongzhibiao.put("Zhuiguanneixiaoguo2", "椎管内效果2");
//        ContextMessage.zhikongzhibiao.put("Zhuiguanneixiaoguo3", "椎管内效果3");
//        ContextMessage.zhikongzhibiao.put("Zhuiguanneixiaoguo4", "椎管内效果4");

        ContextMessage.zhikongzhibiao.put("Yjss", "一级手术");
        ContextMessage.zhikongzhibiao.put("Ejss", "二级手术");
        ContextMessage.zhikongzhibiao.put("Sjss", "三级手术");
        ContextMessage.zhikongzhibiao.put("Ssss", "四级手术");
        ContextMessage.zhikongzhibiao.put("Other","其他");


    }
    private AjaxMsg ajax = AjaxMsg.newInstance();

    AccountDao accountDao = (AccountDao) SpringUtils.getBean(AccountDao.class);
    PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);
    QualityMessageDao qualityMessageDao=SpringUtils.getBean(QualityMessageDao.class);
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
    private SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    private SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    private SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static List<QualityStatistics> zhiKongList= new ArrayList<>();
    private static Logger logger=Logger.getLogger(ZhikongController.class);
    private Map<String, String> methodGroup = new HashMap<>();
    ConfigAnesMethodsDao configAnesMethodsDao = SpringUtils.getBean(ConfigAnesMethodsDao.class);
    ConfigAnesMethodsGroupDao configAnesMethodsGroupDao = SpringUtils.getBean(ConfigAnesMethodsGroupDao.class);

    private void groupMethod(){
        methodGroup.clear();
        List<ConfigAnesMethods> list = configAnesMethodsDao.getIsTrue();
        List<ConfigAnesMethodsGroup> listGroup = configAnesMethodsGroupDao.getDateIsFalse();
//        methodGroup
        Map<String, String> map = new HashMap<>();
        if(listGroup != null) {
            for (ConfigAnesMethodsGroup c : listGroup) {
                map.put(c.getCode(), c.getName());
            }
        }
        if(list != null) {
            for (ConfigAnesMethods c : list) {
                String groupName = map.get(c.getGroupCode());
                methodGroup.put(c.getName(), groupName);
            }
        }
    }

    @RequestMapping(value = "zhikong", method = RequestMethod.GET)
    public Object zhikong(Model m, HttpServletRequest request) {
        groupMethod();
        try {
            ContextMessage.zhikong.clear();
            Map<String, Object> params = FrontHelper.transfParams(request);
            Date start = DateUtil.getDateByConditions(new Date(), DateUtil.FIRST_DAY_OF_CUR_MONTH);
            start = getStartDate(start);
            Date end = new Date();
            end = getMaxMonthDate(end);

            if (params.get("starttime") != null && !params.get("starttime").toString().equals("")){
                start = new SimpleDateFormat("yyyy-MM-dd").parse(params.get("starttime").toString());
            }
            if (params.get("endtime") != null && !params.get("endtime").toString().equals("")){
                end = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(params.get("endtime").toString() + " 23:59:59");
            }
            String name = "";
            if (params.get("docname") != null && !params.get("docname").toString().equals("")){
                name = params.get("docname").toString();
                name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
            }
            // 如果没有?data={.....}
            if (params.get(ParameterConstants.DATA) != null) {
                String data = params.get(ParameterConstants.DATA).toString();
                JSONObject jsonObj = new JSONObject(data);
                String starttime = jsonObj.get("starttime").toString();
                String endtime = jsonObj.get("endtime").toString();
                name = jsonObj.get("name").toString();
                if (!starttime.equals("") && !endtime.equals("")) {
                    start = sdf1.parse(starttime);
                    System.out.println("质控入参开始时间："+sdf1.format(start));
                    end = sdf2.parse(endtime);
                    System.out.println("质控入参结束时间："+sdf2.format(end));
                }
//                end = getMaxMonthDate(end);
            }

            Date[] times= checkDate(start,end);
            start=times[0];
            end=times[1];
//            start=getStartDate(start);
//            end = getMaxMonthDate(end);
            String accountId = "";
            List<Account> selAccountList = accountDao.findAccountListByName(name);
            List<String> accountIdList = new ArrayList<>();
            if (null != selAccountList && selAccountList.size() > 0) {// 筛选该医生参与手术
                for (int i = 0; i < selAccountList.size(); i++) {
                    accountIdList.add(selAccountList.get(i).getId());
                }
                accountId = selAccountList.get(0).getId();
            }
            zhiKongList.clear();
            // 获取统计数据
            zhiKongList = calValue(accountIdList, start, end, accountId);
            save2DB4excel();
            //汇总数据
            QualityStatistics wholeTJ = refresh(zhiKongList);
            // 处理数据（显示内容）
            ContextMessage.zhikong = getValue(wholeTJ);
            // 时间内的月份
            List<ZhikongMessage> categorie = getAllMonth1(start, end);
            List<ZhikongMessage> zhikong1 = new ArrayList<ZhikongMessage>();// 下方左边质控信息
            Map<String, List<String>> zhikong2 = new HashMap<String, List<String>>();// 下方右边质控信息
            for (int i = 0; i < ContextMessage.zhikong.size(); i++) {
                if (zhikong1.size() < 12) {
                    zhikong1.add(ContextMessage.zhikong.get(i));
                    // 查询时间段内指定内容次数
                    List<String> SeriesDate = new ArrayList<String>();
                    for (int j = 0; j < categorie.size(); j++) {
                    	 long date =getOneMonthData(agomonth(j,start),ContextMessage.zhikong.get(i).getNa(),zhiKongList);
                        SeriesDate.add(date + "");
                    }
                    zhikong2.put(ContextMessage.zhikong.get(i).getNa(), SeriesDate);
                } else {
                    break;
                }
            }
            m.addAttribute("starttime", sdf1.format(start));
            m.addAttribute("endtime", sdf2.format(end));
            m.addAttribute("datetime", categorie);
            m.addAttribute("zhikong", ContextMessage.zhikong);
            m.addAttribute("zhikong1", zhikong1);
            m.addAttribute("zhikong2", zhikong2);
            m.addAttribute("docname", name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "zhikong/zhikong";
    }

    private Date[] checkDate(Date start, Date end) {
	   Date[] time=new Date[]{start,end};
	   Calendar startTime=Calendar.getInstance();
	   startTime.setTime(start);
	   int startYear=startTime.get(Calendar.YEAR);

	   Calendar endTime=Calendar.getInstance();
	   endTime.setTime(end);
	   int endYear=endTime.get(Calendar.YEAR);

	   if (endYear!=startYear) {
		  endTime.set(Calendar.YEAR, startYear);
		  endTime.set(Calendar.MONTH, 12);
		  endTime.set(Calendar.DAY_OF_MONTH, endTime.getActualMaximum(Calendar.DAY_OF_MONTH));
		  endTime.set(Calendar.HOUR_OF_DAY, 23);
		  endTime.set(Calendar.MINUTE, 59);
		  endTime.set(Calendar.SECOND, 59);
		  time[1]=endTime.getTime();
	   }
	   return time;

	}

	private void save2DB4excel() {
	 QualityMessage qualityMessage=new QualityMessage();
	 qualityMessage.setLastUpdateTime(new Date());
	 qualityMessage.setResultList(zhiKongList);
	 qualityMessageDao.addUpdate(qualityMessage);
	 logger.info("add one QualityMessage= = = ");
	}

	private long getOneMonthData(Date agomonth, String n, List<QualityStatistics> zhiKongList) {

    	if (n==null ||("").equals(n)) {
			return 0;
		}
        String[] names = n.split("\\.");
    	String name = n.contains(".") ? names[names.length-1].toLowerCase() : n.toLowerCase();
    	int data =0;
    	QualityStatistics oneMonthTj=new QualityStatistics();
    	Calendar calendar=Calendar.getInstance();
    	calendar.setTime(agomonth);
    	int curMonth=calendar.get(Calendar.MONTH);
    	try {	if (zhiKongList!=null && zhiKongList.size()>0) {
    		for (QualityStatistics qualityStatistics : zhiKongList) {
    			if (qualityStatistics!=null && qualityStatistics.getDate()!=null) {
    				calendar.setTime(qualityStatistics.getDate());
    				int month=calendar.get(Calendar.MONTH);
    				if (curMonth==month) {
						oneMonthTj=qualityStatistics;
						break;
					}
				}
    		}
    		Class class1=oneMonthTj.getClass();
    		java.lang.reflect.Field[] fs = class1.getDeclaredFields();
    		for (int i = 0; i < fs.length; i++) {
//                String str = fs[i].getName().toLowerCase();
//                System.out.println(str);
				if ((name).equals(fs[i].getName().toLowerCase())) {
					fs[i].setAccessible(true);
				Object obj=fs[i].getInt(oneMonthTj);
					data=(int) obj;
				}
			}

		}
    	} catch (Exception e) {

			e.printStackTrace();
		}

		return data;
	}

	@RequestMapping(value = "a", method = RequestMethod.GET)
    public Object ss(Model m) {
        return "zhikong/NewFile";
    }

    /**
     * 质控翻页
     *
     * json格式数据要求数据data
     *            ={"starttime":"2018-10","endtime":"2018-10","name":""} 名字可以为空
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "zhikongA", method = RequestMethod.GET)
    public Object zhikongA(HttpServletRequest request) {
        ajax.clear();
        try {
            Map<String, Object> params = FrontHelper.transfParams(request);
            Date start = agomonth(-6, new Date());
            Date end = new Date();
            start = DateUtil.getDateByConditions(start, DateUtil.FIRST_DAY_OF_CUR_MONTH);
            end = getMaxMonthDate(end);
            int page = 0;
            // 如果没有?data={.....}
            String name = "";
            if (params.get(ParameterConstants.DATA) != null) {
                String data = params.get(ParameterConstants.DATA).toString();
                JSONObject jsonObj = new JSONObject(data);
                String starttime = jsonObj.get("starttime").toString();
                String endtime = jsonObj.get("endtime").toString();
                page = Integer.parseInt(jsonObj.get("page").toString());
                name = jsonObj.get("name").toString();
                if (page < 0) {
                    page = 0;
                }
                if (ContextMessage.zhikong.size() / 12 <= page - 1) {
                    page = 0;
                }
                if (!starttime.equals("") && !endtime.equals("")) {
                    start = sdf.parse(starttime);
                    end = sdf.parse(endtime);
                }
            }
            String accountId = "";
            List<Account> selAccountList = accountDao.findAccountListByName(name);
            if (selAccountList!=null&&selAccountList.size() > 0) {
                accountId = selAccountList.get(0).getId();
            }
            // 时间内的月份
            List<ZhikongMessage> categorie = getAllMonth1(start, end);
            List<ZhikongMessage> zhikong1 = new ArrayList<ZhikongMessage>();// 下方左边质控信息
            List<List<String>> zhikong2 = new ArrayList<List<String>>();// 下方右边质控信息
            for (int i = page * 12; i < ContextMessage.zhikong.size(); i++) {
                if (zhikong1.size() < 12) {
                    zhikong1.add(ContextMessage.zhikong.get(i));
                    // 查询时间段内指定内容次数
                    List<String> SeriesDate = new ArrayList<String>();
                    for (int j = 0; j < categorie.size(); j++) {
                        try {
                           long date =getOneMonthData(agomonth(j,start),ContextMessage.zhikong.get(i).getNa(),zhiKongList);
                            SeriesDate.add(date + "");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    zhikong2.add(SeriesDate);
                } else {
                    break;
                }
            }
            ajax.addData("datetime", categorie);
            ajax.addData("zhikong1", zhikong1);
            ajax.addData("zhikong2", zhikong2);
            ajax.addData("page", page);
            ajax.addData("docname", name);
            ajax.addCount(ContextMessage.zhikong.size());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ajax;
    }

    // highchart图
    @ResponseBody
    @RequestMapping(value = "zhikongAjax", method = RequestMethod.GET)
    public Object zhikongAjax(HttpServletRequest request) {
        ajax.clear();
        Map<String, Object> params = FrontHelper.transfParams(request);
        String data = params.get(ParameterConstants.DATA).toString();
        JSONObject jsonObj = new JSONObject(data);
        String starttime = jsonObj.get("starttime").toString();
        String endtime = jsonObj.get("endtime").toString();
        String name = jsonObj.get("name").toString();
        String docname = jsonObj.get("docname").toString();
        try {
            Date start;
            Date end;
            start = sdf.parse(starttime);
            end = sdf.parse(endtime);
            start = DateUtil.getDateByConditions(start, DateUtil.FIRST_DAY_OF_CUR_MONTH);
            end = getMaxMonthDate(end);
            String accountId = "";
            List<Account> selAccountList = accountDao.findAccountListByName(docname);
            if (selAccountList.size() > 0) {
                accountId = selAccountList.get(0).getId();
            }
            List<String> categorie = getAllMonth(start, end);
            List<SeriesData> SeriesDate = new ArrayList<SeriesData>();
            // 查询时间段内指定内容次数
            List<ZhikongMessage> list1 = ContextMessage.zhikong;
            for (int i = 0; i < categorie.size(); i++) {
            	 long date =getOneMonthData(agomonth(i,start),ContextMessage.zhikongDB.get(name),zhiKongList);
                SeriesDate.add(new SeriesData(date, ContextMessage.color[i]));
            }
            String subtitle = "(" + sdf.format(start) + "-" + sdf.format(end) + ")";
            String[] categories = new String[categorie.size()];
            // List转换成数组
            for (int i = 0; i < categorie.size(); i++) {
                categories[i] = categorie.get(i);
            }
            Highchart s = new Highchart(ContextMessage.zhikongzhibiao.get(name), subtitle, categories);
            ajax.addData("data", s);
            ajax.addData("SeriesDate", SeriesDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ajax;
    }

    @ResponseBody
    @RequestMapping(value = "DocName", method = RequestMethod.GET)
    public Object DocName(HttpServletRequest request) {
        ajax.clear();
        Map<String, Object> params = FrontHelper.transfParams(request);
        String data = params.get(ParameterConstants.DATA).toString();
        JSONObject jsonObj = new JSONObject(data);
        String name = jsonObj.get("name").toString();
        List<String> nameList = new ArrayList<>();
        for (Account account : accountDao.gets()) {
            if (PinYinUtil.pinyin(account.getTrueName()).contains(name) || account.getTrueName().contains(name)) {
                nameList.add(account.getTrueName() + "   (" + account.getTitle() + ")");
            }
        }
        ajax.addMap(nameList);
        return ajax;
    }

    @RequestMapping(value = "zhikongDetailed", method = RequestMethod.GET)
    public String zhikongDetailed(Model m, HttpServletRequest request) {
        try {
            Map<String, Object> params = FrontHelper.transfParams(request);
            String data = params.get(ParameterConstants.DATA).toString();
            JSONObject jsonObj = new JSONObject(data);
            String starttime = jsonObj.get("starttime").toString();
            String endtime = jsonObj.get("endtime").toString();
            String type = jsonObj.get("type").toString();
            String docname = jsonObj.get("name").toString();
            Date start = sdf1.parse(starttime);
            Date end = sdf2.parse(endtime);
//            start = DateUtil.getDateByConditions(start, DateUtil.FIRST_DAY_OF_CUR_MONTH);
//            end = getMaxMonthDate(end);

            String accountId = "";
            List<Account> selAccountList = accountDao.findAccountListByName(docname);
            if (selAccountList.size() > 0) {
                accountId = selAccountList.get(0).getId();
            }
            List<PatientLink> patientLink = getOneData(start, end, ContextMessage.zhikongDB.get(type), true, accountId);
            for (PatientLink s : patientLink) {
                if (s.getStatus().getMazuiStartTime() != null) {
                    s.getStatus().setMazuiStartTimeString(sdf1.format(s.getStatus().getMazuiStartTime()));
                }
                if (s.getStatus().getInRoomTime() != null) {
                    s.getApplication().setYysssjString(sdf1.format(s.getStatus().getInRoomTime()));
                }
                String mazuidocname = "";
                if (s.getAnesthesiaRecord() != null) {
                    if (s.getAnesthesiaRecord().getZmys() != null && !"".equalsIgnoreCase(s.getAnesthesiaRecord().getZmys())) {
                        String mazuiys1 = "";
                        String mazuiys2 = "";
                        Account ac = accountDao.findById(s.getAnesthesiaRecord().getZmys());
                        if (ac != null) {
                            mazuiys1 = ac.getTrueName();
                        }
                        if (s.getAnesthesiaRecord().getFmys1() != null && !"".equalsIgnoreCase(s.getAnesthesiaRecord().getFmys1())) {
                            Account ac1 = accountDao.findById(s.getAnesthesiaRecord().getFmys1());
                            if (ac1 != null) {
                                mazuiys2 = "," + ac1.getTrueName();
                            }
                        }
                        mazuidocname = mazuiys1 + mazuiys2;
                    } else {
                        mazuidocname = s.getSchedule().getMzysbh1();
                    }
                }
                String ssszString = "";
                String operDoctor1 = "";
                String operDoctor2 = "";
                if (s.getAnesthesiaRecord() != null) {
                    if (s.getAnesthesiaRecord().getOperDoctor1() != null && !s.getAnesthesiaRecord().getOperDoctor1().equals("")) {
                        Account a = accountDao.findById(s.getAnesthesiaRecord().getOperDoctor1());
                        if (a != null) {
                            operDoctor1 = a.getTrueName();
                        }
                        if (s.getAnesthesiaRecord().getOperDoctor2() != null && !s.getAnesthesiaRecord().getOperDoctor2().equals("")) {
                            Account ac = accountDao.findById(s.getAnesthesiaRecord().getOperDoctor2());
                            if (ac != null) {
                                operDoctor2 = "," + ac.getTrueName();
                            }
                        }
                        ssszString = operDoctor1 + operDoctor2;
                    } else {
                        ssszString = s.getApplication().getSsysxm();
                    }
                    s.getApplication().setSsysxm(ssszString);
                }
                s.getSchedule().setMzysbh1Name(mazuidocname);

                String mzys = "";
                String mzys1Str = "";
                String mzys2Str = "";
                if (s.getPacu() != null){
                    if (s.getPacu().getMzys1() != null && !"".equals(s.getPacu().getMzys1())){
                        Account a = accountDao.findById(s.getPacu().getMzys1());
                        if (a != null) {
                            mzys1Str = a.getTrueName();
                        }
                        if (s.getPacu().getMzys2() != null && !"".equals(s.getPacu().getMzys2())){
                            Account a2 = accountDao.findById(s.getPacu().getMzys2());
                            mzys2Str = "," + a2.getTrueName();
                        }
                        mzys = mzys1Str + mzys2Str;
                    }else{
                        mzys = s.getPacu().getMzys1();
                    }
                    s.getPacu().setPacuDoctor(mzys);
                }
            }
            Map<String, Integer> ks = new HashMap<String, Integer>();
            for (PatientLink p : patientLink) {
                if (ks.get(p.getPatient().getKsmc()) != null) {
                    ks.put(p.getPatient().getKsmc(), ks.get(p.getPatient().getKsmc()) + 1);
                } else {
                    ks.put(p.getPatient().getKsmc(), 1);
                }
            }
            List<KeShiTJ> keshi = new ArrayList<KeShiTJ>();
            for (String k : ks.keySet()) {
                KeShiTJ s = new KeShiTJ();
                s.setKsmc(k);
                s.setNum(ks.get(k));
                keshi.add(s);
            }
            m.addAttribute("keshi", keshi);
            m.addAttribute("starttime", starttime);
            m.addAttribute("endtime", endtime);
            m.addAttribute("docname", docname);
            m.addAttribute("patientLink", patientLink);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "zhikong/zhikongDetailed";
    }

    // 统计一个类型的所有数据
    private List<PatientLink> getOneData(Date agomonth, Date agomonth2, String string, Object b, String accountID) {
        List<PatientLink> num = new ArrayList<PatientLink>();
        if (string == null){
            return num;
        }else if (string.equalsIgnoreCase("Yongxueshu") ) {
            List<PatientLink> n1 = patientLinkDao.getFinishOperByTimeB(agomonth, agomonth2, Name + ".zhiKongXinXi.yxhs", true, accountID);
            num = patientLinkDao.getFinishOperByTimeB(agomonth, agomonth2, Name + ".zhiKongXinXi.yxbhs", true, accountID);
            for (PatientLink n : n1) {
                num.add(n);
            }
        } else if (string.equalsIgnoreCase(Name + ".zhiKongXinXi.xffs")) {
            num = patientLinkDao.getFinishOperByTimeB(agomonth, agomonth2, Name + ".zhiKongXinXi.xffscg", true, accountID);
            List<PatientLink> n1 = patientLinkDao.getFinishOperByTimeB(agomonth, agomonth2, Name + ".zhiKongXinXi.xffsbcg", true, accountID);
            for (PatientLink n : n1) {
                num.add(n);
            }
        } else if (string.equalsIgnoreCase("application.type")) {
            num = patientLinkDao.getFinishOperByTimeS(agomonth, agomonth2, "application.Type", "urgent", accountID);
        } else if (string.equalsIgnoreCase("chaguanquanmaandzhuiguan")) {
            num = patientLinkDao.getFinishOperByTimeS(agomonth, agomonth2, "AnesthesiaRecord.Mzff", "插管全麻+椎管内麻醉", accountID);
        } else if (string.equalsIgnoreCase("Pacucount")) {
            num = patientLinkDao.getFinishOperByTimeS(agomonth, agomonth2, "AnesthesiaRecord.Brqw", "复苏室", accountID);
        } else if (string.equalsIgnoreCase("Icucount")) {
            num = patientLinkDao.getFinishOperByTimeS(agomonth, agomonth2, "AnesthesiaRecord.Brqw", "ICU", accountID);
        }  else if (string.equalsIgnoreCase("Shuhouzhentong")) {
            List<PatientLink> n1 = patientLinkDao.getFinishOperByTimeB(agomonth, agomonth2, "AnesthesiaRecord.PCEA", true, accountID);
            num = patientLinkDao.getFinishOperByTimeB(agomonth, agomonth2, "AnesthesiaRecord.PCIA", true, accountID);
            List<PatientLink> n2 = patientLinkDao.getFinishOperByTimeB(agomonth, agomonth2, "AnesthesiaRecord.PCNA", true, accountID);
            List<PatientLink> n3 = patientLinkDao.getFinishOperByTimeB(agomonth, agomonth2, "AnesthesiaRecord.PCSA", true, accountID);
            for (PatientLink n : n1) {
                num.add(n);
            }
            for (PatientLink n : n2) {
                num.add(n);
            }
            for (PatientLink n : n3) {
                num.add(n);
            }
        } else if (string.equalsIgnoreCase("Jingmaimazuiconut")) {
            num = patientLinkDao.getFinishOperByTimeSList(agomonth, agomonth2, "AnesthesiaRecord.Mzff", "静脉麻醉", accountID);
        }else if (string.equalsIgnoreCase("PatientLinkCount") ) {
            Criteria criteria = Criteria.where("Status.InRoomTime").gte(agomonth).lte(agomonth2);
            Criteria criteria1 = new Criteria();
            Criteria criteria2 = Criteria.where("Patient.Status").is(Constants.FLAG_VALID);
            criteria1.orOperator(Criteria.where("Application.Detailstatus").is(Constants.OR_STATUS_FLAG_OUT_ROOM), Criteria.where("Application.Detailstatus").is(Constants.OR_STATUS_FLAG_OUT_PCU));
            if (accountID != null && accountID != "") {
                criteria2.orOperator(Criteria.where("AnesthesiaRecord.Zmys").is(accountID), Criteria.where("AnesthesiaRecord.Fmys1").is(accountID), Criteria.where("AnesthesiaRecord.Fmys2").is(accountID), Criteria.where("AnesthesiaRecord.Fmys3").is(accountID), Criteria.where("AnesthesiaRecord.Fzjbys").is(accountID), Criteria.where("AnesthesiaRecord.Xhhs1").is(accountID), Criteria.where("AnesthesiaRecord.Xhhs2").is(accountID), Criteria.where("AnesthesiaRecord.Xhhs3").is(accountID), Criteria.where("AnesthesiaRecord.Xshs1").is(accountID), Criteria.where("AnesthesiaRecord.Xshs2").is(accountID), Criteria.where("AnesthesiaRecord.Xshs3").is(accountID), Criteria.where("AnesthesiaRecord.XperDoctor1").is(accountID), Criteria.where("AnesthesiaRecord.XperDoctor2").is(accountID), Criteria.where("AnesthesiaRecord.XperDoctor3").is(accountID));
            }
            num = patientLinkDao.find(criteria.andOperator(criteria1.andOperator(criteria2)));
        } else if (string.equalsIgnoreCase("qitamazuicount")) {
            List<PatientLink> patientLinkList = patientLinkDao.getFinishOperByTime(agomonth, agomonth2, accountID);
            QualityStatistics qualityStatistics = new QualityStatistics();
            for (PatientLink patientLink : patientLinkList) {
                if (patientLink.getAnesthesiaRecord() != null) {
                    String mazuiMethod = patientLink.getAnesthesiaRecord().getMzff();
                    if (mazuiMethod.indexOf("复合麻醉") >= 0) { // 复合麻醉
                        qualityStatistics.setFuHeMaZuiCount(qualityStatistics.getFuHeMaZuiCount() + 1);
                    } else if (mazuiMethod.indexOf("非插管全麻") >= 0) { // 非插管全麻
                        qualityStatistics.setFeiChaGuanQuanMaCount(qualityStatistics.getFeiChaGuanQuanMaCount() + 1);
                    } else if (mazuiMethod.indexOf("插管全麻+椎管内麻醉") >= 0) { // 插管全麻+椎管内麻醉
                        qualityStatistics.setChaGuanQuanMaAndZhuiGuan(qualityStatistics.getChaGuanQuanMaAndZhuiGuan() + 1);
                    } else if (mazuiMethod.indexOf("椎管内麻醉(") >= 0) { // 椎管内麻醉
                        qualityStatistics.setZhuiGuanNeiMaZauiCount(qualityStatistics.getZhuiGuanNeiMaZauiCount() + 1);
                    } else if (mazuiMethod.indexOf("插管全麻") >= 0) { // 插管全麻
                        qualityStatistics.setChaGuanQuanMaCount(qualityStatistics.getChaGuanQuanMaCount() + 1);
                    } else if (mazuiMethod.indexOf("神经阻滞") >= 0) { // 神经阻滞麻醉
                        qualityStatistics.setShenJingZuZhi(qualityStatistics.getShenJingZuZhi() + 1);
                    } else if (mazuiMethod.equalsIgnoreCase("静脉麻醉")) {
                        qualityStatistics.setJingMaiMaZuiConut(qualityStatistics.getJingMaiMaZuiConut() + 1);
                    } else { // 其它麻醉
                        qualityStatistics.setQiTaMaZuiCount(qualityStatistics.getQiTaMaZuiCount() + 1);
                        num.add(patientLink);
                    }
                }
            }
        }  else if (string.equalsIgnoreCase(Name + ".anesthesiaRecord.asa.Asa1")) {
            num = patientLinkDao.getFinishOperByTimeS(agomonth, agomonth2, "anesthesiaRecord.asa.Level", "Ⅰ", accountID);
        } else if (string.equalsIgnoreCase(Name + ".anesthesiaRecord.asa.Asa2")) {
            num = patientLinkDao.getFinishOperByTimeS(agomonth, agomonth2, "anesthesiaRecord.asa.Level", "Ⅱ", accountID);
        } else if (string.equalsIgnoreCase(Name + ".anesthesiaRecord.asa.Asa3")) {
            num = patientLinkDao.getFinishOperByTimeS(agomonth, agomonth2, "anesthesiaRecord.asa.Level", "Ⅲ", accountID);
        } else if (string.equalsIgnoreCase(Name + ".anesthesiaRecord.asa.Asa4")) {
            num = patientLinkDao.getFinishOperByTimeS(agomonth, agomonth2, "anesthesiaRecord.asa.Level", "Ⅳ", accountID);
        } else if (string.equalsIgnoreCase(Name + ".anesthesiaRecord.asa.Asa5")) {
            num = patientLinkDao.getFinishOperByTimeS(agomonth, agomonth2, "anesthesiaRecord.asa.Level", "Ⅴ", accountID);
        } else if (string.equalsIgnoreCase(Name + ".anesthesiaRecord.asa.Asa6")) {
            num = patientLinkDao.getFinishOperByTimeS(agomonth, agomonth2, "anesthesiaRecord.asa.Level", "Ⅵ", accountID);
        } else if (string.equalsIgnoreCase(Name + ".zhiKongXinXi.aSAsw1")) {
            num = patientLinkDao.getFinishOperByTimeB(agomonth, agomonth2, Name + ".zhiKongXinXi.aSAsw1", true, accountID);
        } else if (string.equalsIgnoreCase(Name + ".zhiKongXinXi.aSAsw2")) {
            num = patientLinkDao.getFinishOperByTimeB(agomonth, agomonth2, Name + ".zhiKongXinXi.aSAsw2", true, accountID);
        } else if (string.equalsIgnoreCase(Name + ".zhiKongXinXi.aSAsw3")) {
            num = patientLinkDao.getFinishOperByTimeB(agomonth, agomonth2, Name + ".zhiKongXinXi.aSAsw3", true, accountID);
        } else if (string.equalsIgnoreCase(Name + ".zhiKongXinXi.aSAsw4")) {
            num = patientLinkDao.getFinishOperByTimeB(agomonth, agomonth2, Name + ".zhiKongXinXi.aSAsw4", true, accountID);
        } else if (string.equalsIgnoreCase(Name + ".zhiKongXinXi.aSAsw5")) {
            num = patientLinkDao.getFinishOperByTimeB(agomonth, agomonth2, Name + ".zhiKongXinXi.aSAsw5", true, accountID);
        } else if (string.equalsIgnoreCase(Name + ".zhiKongXinXi.ssqkfl1")) {
            num = patientLinkDao.getFinishOperByTimeB(agomonth, agomonth2, Name + ".ganRanXinXi.JCB5", true, accountID);
        } else if (string.equalsIgnoreCase(Name + ".zhiKongXinXi.ssqkfl2")) {
            num = patientLinkDao.getFinishOperByTimeB(agomonth, agomonth2, Name + ".ganRanXinXi.JCB6", true, accountID);
        } else if (string.equalsIgnoreCase(Name + ".zhiKongXinXi.ssqkfl3")) {
            num = patientLinkDao.getFinishOperByTimeB(agomonth, agomonth2, Name + ".ganRanXinXi.JCB7", true, accountID);
        } else if (string.equalsIgnoreCase(Name + ".zhiKongXinXi.ssqkfl4")) {
            num = patientLinkDao.getFinishOperByTimeB(agomonth, agomonth2, Name + ".ganRanXinXi.JCB8", true, accountID);
        }else if (string.equalsIgnoreCase("pacu.zongfen")) {
            List<PatientLink> patientLinkList = patientLinkDao.getFinishOperByTime(agomonth, agomonth2, accountID);
            for (PatientLink patientLink : patientLinkList) {
                if(patientLink.getPacu() == null){
                    continue;
                }
                try {
                    if ((patientLink.getPacu().getZongfen().equals("≥4")) || (patientLink.getPacu() != null && patientLink.getPacu().getZongfen() != null && !patientLink.getPacu().getZongfen().equals("/")&& !patientLink.getPacu().getZongfen().equals("") && Integer.parseInt(patientLink.getPacu().getZongfen()) > 4)) {
                        num.add(patientLink);
                    }
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }
        } else if(string.equalsIgnoreCase("Shenjingzuzhi")){ //神经阻滞
            num = patientLinkDao.getFinishOperByTime(agomonth, agomonth2,accountID);
            groupAnesMethod(num , "神经阻滞麻醉");
        } else if(string.equalsIgnoreCase("Zhuiguanneimazauicount")){//椎管内麻醉
            num = patientLinkDao.getFinishOperByTime(agomonth, agomonth2,accountID);
            groupAnesMethod(num , "椎管内麻醉");
        }else if(string.equalsIgnoreCase("Chaguanquanmacount")){//全麻
            num = patientLinkDao.getFinishOperByTime(agomonth, agomonth2,accountID);
            groupAnesMethod(num , "插管全麻");
        }else if(string.equalsIgnoreCase("Fuhemazuicount")){//复合麻醉
            num = patientLinkDao.getFinishOperByTime(agomonth, agomonth2,accountID);
            groupAnesMethod(num , "复合麻醉");
        }else if(string.equalsIgnoreCase("Feichaguanquanmacount")){//非插管全麻
            num = patientLinkDao.getFinishOperByTime(agomonth, agomonth2,accountID);
            groupAnesMethod(num , "非插管全麻");
        }else if(string.equalsIgnoreCase("Jianhumazuicount")){//监护麻醉
            num = patientLinkDao.getFinishOperByTime(agomonth, agomonth2,accountID);
            groupAnesMethod(num , "监护麻醉");
        }else if(string.equalsIgnoreCase("MaZuiCount")){//麻醉总数
            num = patientLinkDao.getFinishOperByTime(agomonth, agomonth2,accountID);
            zonggroupAnesMethod(num);
        }else {
            num = patientLinkDao.getFinishOperByTimeB(agomonth, agomonth2, string, true, accountID);
        }
        return num;
    }

    private void zonggroupAnesMethod( List<PatientLink> patientLinks){
        List<PatientLink> removeList = new ArrayList<>();
        for (PatientLink p : patientLinks){
            String mzff = p.getAnesthesiaRecord().getMzff();
            if (mzff == null || mzff.equals("") || mzff.equals("局麻")){
                removeList.add(p);
            }
        }
        patientLinks.removeAll(removeList);
    }

    private void groupAnesMethod( List<PatientLink> patientLinks , String name){
//        groupMethod();
        List<PatientLink> removeList = new ArrayList<>();
        for (PatientLink p : patientLinks){
            String mzff = p.getAnesthesiaRecord().getMzff();
            String isMzff = methodGroup.get(mzff);
            if (mzff == null || isMzff == null || mzff.equals("") || !isMzff.equals(name)){
                removeList.add(p);
            }
        }
        patientLinks.removeAll(removeList);
    }

    public List<QualityStatistics> calValue(List<String> accountIdList, Date startTime, Date endTime, String accountId) {
        Map<Date, QualityStatistics> mapNewZhiKong = null;
        try {
            System.out.println("质控查询开始时间："+sdf2.format(startTime));
            System.out.println("质控查询结束时间："+sdf2.format(endTime));
            List<PatientLink> patientLinkList = patientLinkDao.getFinishOperByTime(startTime, endTime, accountId);
            logger.info("此次查询手术条数为: "+patientLinkList.size()+"条");
            mapNewZhiKong = new HashMap<>();
            List<PatientLink> patientLinks = new ArrayList<>();
            if (null != accountIdList && accountIdList.size() > 0) {
                for (int i = 0; i < patientLinkList.size(); i++) {
                    for (int j = 0; j < accountIdList.size(); j++) {
                        if (isOperOfAllDoctor(patientLinkList.get(i), accountIdList.get(j))) {
                            patientLinks.add(patientLinkList.get(i));
                        }
                    }
                }
            } else {
                patientLinks.addAll(patientLinkList);
            }
            int num = 0;
            for (PatientLink patientLink : patientLinks) {
                num++;
                if (patientLink.getStatus() == null || patientLink.getPatient().getBrxm().equals("")) {
                    continue;
                }
                ZhiKongXinXi zhiKongXinXi = patientLink.getTableForRongChangEY().getZhiKongXinXi();
                Date monthDate = getMonthDate(patientLink.getStatus().getOutRoomTime());
                QualityStatistics qualityStatistics = mapNewZhiKong.get(monthDate);
                if (null == qualityStatistics) {
                    qualityStatistics = new QualityStatistics();
                    qualityStatistics.setDate(monthDate);
                    qualityStatistics.setLastEditTime(new Date());
                    mapNewZhiKong.put(monthDate, qualityStatistics);
                }
                qualityStatistics.setPatientLinkCount(qualityStatistics.getPatientLinkCount() + 1);
//                String str2 = patientLink.getPatient().getBrxm();
//                if (str2.contains("叶倩")){
//
//                }
//                String str3 = patientLink.getAnesthesiaRecord().getMzff();
//                System.err.println(str2 + " -->" + str3);
                if (patientLink.getAnesthesiaRecord().getMzff().equals("局麻") || patientLink.getAnesthesiaRecord().getMzff().equals("")){
                    System.out.println();
                    continue;
                }
//                String str = patientLink.getPatient().getBrxm();
//                String str1 = patientLink.getAnesthesiaRecord().getMzff();
//                System.out.println(str + " -->" + str1);

                if (patientLink.getAnesthesiaRecord() != null) {
                    if (patientLink.getAnesthesiaRecord().getZxjmcc() != null && patientLink.getAnesthesiaRecord().getZxjmcc()) {
                        qualityStatistics.setZxjmcc(qualityStatistics.getZxjmcc() + 1); // 中心静脉穿刺总数
                    }
                    if (patientLink.getAnesthesiaRecord().getCsyd() != null && patientLink.getAnesthesiaRecord().getCsyd()) {
                        qualityStatistics.setCsyd(qualityStatistics.getCsyd() + 1);
                    }
                    if (patientLink.getAnesthesiaRecord().getSygzz() != null && patientLink.getAnesthesiaRecord().getSygzz()) {
                        qualityStatistics.setSygzz(qualityStatistics.getSygzz() + 1);
                    }
                    if (patientLink.getAnesthesiaRecord().getJwzl() != null && patientLink.getAnesthesiaRecord().getJwzl()) {
                        qualityStatistics.setJwzl(qualityStatistics.getJwzl() + 1);
                    }
                    if (patientLink.getAnesthesiaRecord().getJyzl() != null && patientLink.getAnesthesiaRecord().getJyzl()) {
                        qualityStatistics.setJyzl(qualityStatistics.getJyzl() + 1);
                    }

                    if (patientLink.getAnesthesiaRecord().getMzxg_y()) {
                        qualityStatistics.setMzpd_y(qualityStatistics.getMzpd_y() + 1);
                    }
                    if (patientLink.getAnesthesiaRecord().getMzpd_l()) {
                        qualityStatistics.setMzpd_l(qualityStatistics.getMzpd_l() + 1);
                    }
                    if (patientLink.getAnesthesiaRecord().getMzpd_bq()) {
                        qualityStatistics.setMzpd_bq(qualityStatistics.getMzpd_bq() + 1);
                    }
                    if (patientLink.getAnesthesiaRecord().getMzpd_wx()) {
                        qualityStatistics.setMzpd_wx(qualityStatistics.getMzpd_wx() + 1);
                    }
                    if (patientLink.getAnesthesiaRecord().getDmcc() != null && patientLink.getAnesthesiaRecord().getDmcc()) {
                        qualityStatistics.setDmcc(qualityStatistics.getDmcc() + 1); // 动脉穿刺总数
                    }
                    if(patientLink.getAnesthesiaRecord().getTsqgcg() != null&&patientLink.getAnesthesiaRecord().getTsqgcg()){
                        qualityStatistics.setTsqgcg(qualityStatistics.getTsqgcg()+1);//特殊气管插管
                    }
//                    if (patientLink.getAnesthesiaRecord().getTeg() != null && patientLink.getAnesthesiaRecord().getTeg()) {
//                        qualityStatistics.setTeg(qualityStatistics.getTeg() + 1);
//                    }
//                    if (patientLink.getAnesthesiaRecord().getPCEA() != null && patientLink.getAnesthesiaRecord().getPCEA()) {
//                        qualityStatistics.setPcea(qualityStatistics.getPcea() + 1);
//                    }
//                    if (patientLink.getAnesthesiaRecord().getPCIA() != null && patientLink.getAnesthesiaRecord().getPCIA()) {
//                        qualityStatistics.setPcia(qualityStatistics.getPcia() + 1);
//                    }
//                    if (patientLink.getAnesthesiaRecord().getWyPCA() != null && patientLink.getAnesthesiaRecord().getWyPCA()) {
//                        qualityStatistics.setNoPca(qualityStatistics.getNoPca() + 1);
//                    }
//                    if (null != patientLink.getAnesthesiaRecord().getBrqw() && patientLink.getAnesthesiaRecord().getBrqw().equalsIgnoreCase("病房")) {
//                        qualityStatistics.setPatToBf(qualityStatistics.getPatToBf() + 1);
//                    }
//                    if (null != patientLink.getAnesthesiaRecord().getBrqw() && patientLink.getAnesthesiaRecord().getBrqw().equalsIgnoreCase("PACU")) {
//                        qualityStatistics.setPatToPacu(qualityStatistics.getPatToPacu() + 1);
//                    }
//                    if (null != patientLink.getAnesthesiaRecord().getBrqw() && patientLink.getAnesthesiaRecord().getBrqw().equalsIgnoreCase("ICU")) {
//                        qualityStatistics.setPatToIcu(qualityStatistics.getPatToIcu() + 1);
//                    }
                }

                if (zhiKongXinXi != null) {
                    // 质控信息录入计算
                    if (zhiKongXinXi.getMzksh24xsnsw()) {
                        qualityStatistics.setMzksh24xsnsw(qualityStatistics.getMzksh24xsnsw() + 1); // 死亡
                    }
                    if (zhiKongXinXi.getMzksh24xsnxtzt()) {
                        qualityStatistics.setMzksh24xsnxtzt(qualityStatistics.getMzksh24xsnxtzt() + 1); // 心脏骤停
                    }
                    if (zhiKongXinXi.getMzhssqx()) {
                        qualityStatistics.setMzhssqx(qualityStatistics.getMzhssqx() + 1); // 手术取消
                    }
                    if (zhiKongXinXi.getMzqjyzgmfy()) {
                        qualityStatistics.setMzqjyzgmfy(qualityStatistics.getMzqjyzgmfy() + 1); // 过敏
                    }
                    if (zhiKongXinXi.getZgnmzhyzsjxtbfzfs()) {
                        qualityStatistics.setZgnmzhyzsjxtbfzfs(qualityStatistics.getZgnmzhyzsjxtbfzfs() + 1); // 椎管内麻醉并发症
                    }
                    if (zhiKongXinXi.getZxjmccyzbf()) {
                        qualityStatistics.setZxjmccyzbf(qualityStatistics.getZxjmccyzbf() + 1); // 中心静脉穿刺并发症
                    }
                    if (zhiKongXinXi.getJnjmcc()) {
                        qualityStatistics.setJnjmcc(qualityStatistics.getJnjmcc() + 1);
                    }
                    if (zhiKongXinXi.getNdmcc()) {//桡动脉 rdm
                        qualityStatistics.setNdmcc(qualityStatistics.getNdmcc() + 1);
                    }
                    if (zhiKongXinXi.getQmqgbghssfs()) {
                        qualityStatistics.setQmqgbghssfs(qualityStatistics.getQmqgbghssfs() + 1); // 全麻气管插管后声嘶发生
                    }
                    if (zhiKongXinXi.getZtfmzpgc()) {
                        qualityStatistics.setZtfmzpgc(qualityStatistics.getZtfmzpgc() + 1); // 死亡
                    }
                    if (zhiKongXinXi.getMzsshxfhmfs()) {
                        qualityStatistics.setMzsshxfhmfs(qualityStatistics.getMzsshxfhmfs() + 1); // 麻醉手术后新发昏迷发生
                    }
                    if (zhiKongXinXi.getFjhzrICUfs()) {
                        qualityStatistics.setFjhzrICUfs(qualityStatistics.getFjhzrICUfs() + 1); // 非计划转入ICU发生
                    }
                    if (zhiKongXinXi.getFjhecqgbg()) {
                        qualityStatistics.setFjhecqgbg(qualityStatistics.getFjhecqgbg() + 1); // 非计划二次插管次数
                    }
                    if (zhiKongXinXi.getFjhecss()) {
                        qualityStatistics.setFjhecss(qualityStatistics.getFjhecss() + 1);
                    }
                    if (zhiKongXinXi.getFjhecmz()) {
                        qualityStatistics.setFjhecmz(qualityStatistics.getFjhecmz() + 1);
                    }
                     if (zhiKongXinXi.getFjhgbmzfs()) {
                        qualityStatistics.setFjhgbmzfs(qualityStatistics.getFjhgbmzfs() + 1);
                     }
                    if (zhiKongXinXi.getShqgbgbc()) {
                        qualityStatistics.setShqgbgbc(qualityStatistics.getShqgbgbc() + 1); // 术后插管拔除次数
                    }
                    if (zhiKongXinXi.getpACUzryc()) {
                        qualityStatistics.setpACUzryc(qualityStatistics.getpACUzryc() + 1); // PACU转出延迟
                    }
                    if (zhiKongXinXi.getTwxh()) {
                        qualityStatistics.setTwxh(qualityStatistics.getTwxh() + 1);
                    }
                    if (zhiKongXinXi.getYwsw()) {
                        qualityStatistics.setYwsw(qualityStatistics.getYwsw() + 1);
                    }
                    if (zhiKongXinXi.getWyqysza()) {
                        qualityStatistics.setWyqysza(qualityStatistics.getWyqysza() + 1);
                    }
                    if (zhiKongXinXi.getMzqjybhdyzjd()) {
                        qualityStatistics.setSpo2JiangDi(qualityStatistics.getSpo2JiangDi() + 1);
                    }
                    if (zhiKongXinXi.getJsssycxyw()) {
                        qualityStatistics.setJsssycxyw(qualityStatistics.getJsssycxyw() + 1);
                    }
//                    if (zhiKongXinXi.getSsqkfl1()) {
//                        qualityStatistics.setSsqkfl1(qualityStatistics.getSsqkfl1() + 1);
//                    }
//                    if (zhiKongXinXi.getSsqkfl2()) {
//                        qualityStatistics.setSsqkfl2(qualityStatistics.getSsqkfl2() + 1);
//                    }
//                    if (zhiKongXinXi.getSsqkfl3()) {
//                        qualityStatistics.setSsqkfl3(qualityStatistics.getSsqkfl3() + 1);
//                    }
//                    if (zhiKongXinXi.getSsqkfl4()) {
//                        qualityStatistics.setSsqkfl4(qualityStatistics.getSsqkfl4() + 1);
//                    }
                    if (zhiKongXinXi.getYjss()) {
                        qualityStatistics.setYjss(qualityStatistics.getYjss() + 1);
                    }
                    if (zhiKongXinXi.getEjss()) {
                        qualityStatistics.setEjss(qualityStatistics.getEjss() + 1);
                    }
                    if (zhiKongXinXi.getSjss()) {
                        qualityStatistics.setSjss(qualityStatistics.getSjss() + 1);
                    }
                    if (zhiKongXinXi.getSsss()) {
                        qualityStatistics.setSsss(qualityStatistics.getSsss() + 1);
                    }
                    if (zhiKongXinXi.getJczzsh()) {
                        qualityStatistics.setJczzsh(qualityStatistics.getJczzsh() + 1);
                    }
                    if (zhiKongXinXi.getSczzss()) {
                        qualityStatistics.setSczzss(qualityStatistics.getSczzss() + 1);
                    }
                    if (zhiKongXinXi.getQgss()) {
                        qualityStatistics.setQgss(qualityStatistics.getQgss() + 1);
                    }
                    if (zhiKongXinXi.getKxnss()) {
                        qualityStatistics.setKxnss(qualityStatistics.getKxnss() + 1);
                    }
                    if (zhiKongXinXi.getSgssjmcc()) { // 锁骨上深静脉穿刺
                        qualityStatistics.setSgssjmcc(qualityStatistics.getSgssjmcc() + 1);
                    }
                    if (zhiKongXinXi.getSgxsjmcc()) {
                        qualityStatistics.setSgxsjmcc(qualityStatistics.getSgxsjmcc() + 1);
                    }
                    if (zhiKongXinXi.getGjmcc()) {
                        qualityStatistics.setGjmcc(qualityStatistics.getGjmcc() + 1);
                    }
                    if (zhiKongXinXi.getZbdmcc()) {
                        qualityStatistics.setZbdmcc(qualityStatistics.getZbdmcc() + 1);
                    }
                    if (zhiKongXinXi.getMzhtt()) {
                        qualityStatistics.setMzhtt(qualityStatistics.getMzhtt() + 1);
                    }
                    if (zhiKongXinXi.getCpyjm()) {
                        qualityStatistics.setCpyjm(qualityStatistics.getCpyjm() + 1);
                    }
                    if (zhiKongXinXi.getSzzx()) {
                        qualityStatistics.setSzzx(qualityStatistics.getSzzx() + 1);
                    }
                    if (zhiKongXinXi.getSzyzdxy()) {
                        qualityStatistics.setSzyzdxy(qualityStatistics.getSzyzdxy() + 1);
                    }
                    if (zhiKongXinXi.getYcdmccyzbfzfs()) {
                        qualityStatistics.setYcdmccyzbfzfs(qualityStatistics.getYcdmccyzbfzfs() + 1);
                    }
                    if (zhiKongXinXi.getYxhs() || zhiKongXinXi.getYxbhs()) {
                        qualityStatistics.setYongXueShu(qualityStatistics.getYongXueShu() + 1);
                    }
                    if (zhiKongXinXi.getYxhs()) {
                        qualityStatistics.setYxhs(qualityStatistics.getYxhs() + 1);
                    }
                    if (zhiKongXinXi.getSssylgy()) {
                        qualityStatistics.setSssylgy(qualityStatistics.getSssylgy() + 1);
                    }
                    if (zhiKongXinXi.getJxsx()) {
                        qualityStatistics.setJxsx(qualityStatistics.getJxsx() + 1);
                    }
                    if (zhiKongXinXi.getPgcsssj()) {
                        qualityStatistics.setPgcsssj(qualityStatistics.getPgcsssj() + 1);
                    }
                    if (zhiKongXinXi.getFssfwqgjzzss()) {
                        qualityStatistics.setFssfwqgjzzss(qualityStatistics.getFssfwqgjzzss() + 1);
                    }
                    if (zhiKongXinXi.getGhssfs()) {//更改手术方式
                        qualityStatistics.setGhssfs(qualityStatistics.getGhssfs() + 1);
                    }
                    if (zhiKongXinXi.getCcdhzly()) {
                        qualityStatistics.setCcdhzly(qualityStatistics.getCcdhzly() + 1);
                    }
                    if (zhiKongXinXi.getDccg()) {
                        qualityStatistics.setDccg(qualityStatistics.getDccg() + 1);
                    }
                    if (zhiKongXinXi.getDccc()) {
                        qualityStatistics.setDccc(qualityStatistics.getDccc() + 1);
                    }
                    if (zhiKongXinXi.getExot()) {
                        qualityStatistics.setExot(qualityStatistics.getExot() + 1);
                    }
                    if (zhiKongXinXi.getZthdza()) {
                        qualityStatistics.setZthdza(qualityStatistics.getZthdza() + 1);
                    }
                    if (zhiKongXinXi.getZdss()) {
                        qualityStatistics.setZdss(qualityStatistics.getZdss() + 1);
                    }
                    if (zhiKongXinXi.getQtyy()) {
                        qualityStatistics.setQiTa(qualityStatistics.getQiTa() + 1);
                    }
                    if (zhiKongXinXi.getYcdmccyzbfzfs()) {
                        qualityStatistics.setYcdmccyzbfz(qualityStatistics.getYcdmccyzbfz() + 1);
                    }

                    //补
                    if(zhiKongXinXi.getaSAsw1()){
                        qualityStatistics.setAsaSw1(qualityStatistics.getAsaSw1() + 1);
                    }
                    if(zhiKongXinXi.getaSAsw2()){
                        qualityStatistics.setAsaSw2(qualityStatistics.getAsaSw2() + 1);
                    }
                    if(zhiKongXinXi.getaSAsw3()){
                        qualityStatistics.setAsaSw3(qualityStatistics.getAsaSw3() + 1);
                    }
                    if(zhiKongXinXi.getaSAsw4()){
                        qualityStatistics.setAsaSw4(qualityStatistics.getAsaSw4() + 1);
                    }
                    if(zhiKongXinXi.getaSAsw5()){
                        qualityStatistics.setAsaSw5(qualityStatistics.getAsaSw5() + 1);
                    }
                    //缺失
                    if (zhiKongXinXi.getSzsxblfy()) {
                        qualityStatistics.setSzsxblfy(qualityStatistics.getSzsxblfy() + 1);
                    }
                    if(zhiKongXinXi.getYwywxyfhxdgz()){
                        qualityStatistics.setYwywxyfhxdgz(qualityStatistics.getYwywxyfhxdgz() + 1);
                    }
                    if(zhiKongXinXi.getXffsbcg() || zhiKongXinXi.getXffscg()){
                        qualityStatistics.setXffs(qualityStatistics.getXffs() + 1);
                    }
                    if (zhiKongXinXi.getXffscg()){
                        qualityStatistics.setXffscg(qualityStatistics.getXffscg() + 1);
                    }
                    if(zhiKongXinXi.getpACUrsdtwfs()){
                        qualityStatistics.setpACUrsdtwfs(qualityStatistics.getpACUrsdtwfs() + 1);
                    }
                    if(zhiKongXinXi.getSzsxsyfy()){
                        qualityStatistics.setSzsxsyfy(qualityStatistics.getSzsxsyfy() + 1);// 术中输血输液反应数
                    }
                    if(!(patientLink.getAnesthesiaRecord() != null) && !(patientLink.getAnesthesiaRecord().getZxjmcc() != null && patientLink.getAnesthesiaRecord().getZxjmcc()) && (zhiKongXinXi.getZxjmcc())){
                        qualityStatistics.setZxjmcc(qualityStatistics.getZxjmcc() + 1);
                    }
                    if(zhiKongXinXi.getDmdgtl()){
                        qualityStatistics.setDmdgtl(qualityStatistics.getDmdgtl() + 1);
                    }
                    if(zhiKongXinXi.getStewardpf()){
                        qualityStatistics.setZongfen(qualityStatistics.getZongfen() + 1);
                    }else if (patientLink.getPacu() != null && patientLink.getPacu().getZongfen() != null ) {
                        try {

                            if ((patientLink.getPacu().getZongfen().equals("≥4"))||(!patientLink.getPacu().getZongfen().equals("") && !patientLink.getPacu().getZongfen().equals("/") && Integer.parseInt(patientLink.getPacu().getZongfen()) > 4)) {
//                                String str = patientLink.getPacu().getZongfen();
//                                System.out.println(str);
                                qualityStatistics.setZongfen(qualityStatistics.getZongfen() + 1);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if(zhiKongXinXi.getQtfyqxgsj()) {
                        qualityStatistics.setQtfyqxgsj(qualityStatistics.getQtfyqxgsj() + 1);
                    }
                    if (zhiKongXinXi.getQtyy()) {
                        qualityStatistics.setOther(qualityStatistics.getOther() + 1);
                    }
                }
                GanRanXinXi ganRanXinXi = patientLink.getTableForRongChangEY().getGanRanXinXi();
                if (ganRanXinXi != null){
                    if (ganRanXinXi.isJCB5()) {
                        qualityStatistics.setSsqkfl1(qualityStatistics.getSsqkfl1() + 1);
                    }
                    if (ganRanXinXi.isJCB6()) {
                        qualityStatistics.setSsqkfl2(qualityStatistics.getSsqkfl2() + 1);
                    }
                    if (ganRanXinXi.isJCB7()) {
                        qualityStatistics.setSsqkfl3(qualityStatistics.getSsqkfl3() + 1);
                    }
                    if (ganRanXinXi.isJCB8()) {
                        qualityStatistics.setSsqkfl4(qualityStatistics.getSsqkfl4() + 1);
                    }
                }

                // 麻醉方式,
                if (patientLink.getAnesthesiaRecord() != null) {
                    String mazuiMethod = patientLink.getAnesthesiaRecord().getMzff();
                    String mazuiGroup = methodGroup.get(mazuiMethod);
                    if (mazuiMethod.contains("非插管")){

                    }
                    if (null == mazuiGroup || mazuiGroup.equals("") || mazuiGroup.equals("局麻")) { // 无麻醉
                    } else {
                        qualityStatistics.setMaZuiCount(qualityStatistics.getMaZuiCount() + 1); // 麻醉总数
                        if (mazuiGroup.contains("椎管内")) {
                            qualityStatistics.setZhuiGuanNeiMaZauiCount(qualityStatistics.getZhuiGuanNeiMaZauiCount() + 1);
                        } else if (mazuiGroup.contains("复合麻醉")) { // 复合麻醉
                            qualityStatistics.setFuHeMaZuiCount(qualityStatistics.getFuHeMaZuiCount() + 1);
                        } else if (mazuiGroup.contains("插管全麻")) { //
                            qualityStatistics.setChaGuanQuanMaCount(qualityStatistics.getChaGuanQuanMaCount()+ 1);
                        }  else if (mazuiGroup.contains("神经阻滞")) { // 插管全麻
                            qualityStatistics.setShenJingZuZhi(qualityStatistics.getShenJingZuZhi() + 1);
                        }else if(mazuiGroup.contains("非插管全麻")){
                            qualityStatistics.setFeiChaGuanQuanMaCount(qualityStatistics.getFeiChaGuanQuanMaCount() + 1);
                        } else if (mazuiGroup.contains("硬膜外")) {
                            qualityStatistics.setYingmowai(qualityStatistics.getYingmowai() + 1);
                        }else if (mazuiGroup.contains("监护麻醉")) {
                            qualityStatistics.setJianHuMaZuiCount(qualityStatistics.getJianHuMaZuiCount() + 1);
                        } else { // 其它麻醉
                            qualityStatistics.setQiTaMaZuiCount(qualityStatistics.getQiTaMaZuiCount() + 1);
                        }

                    }
                    // 术后镇痛、PCA
                    boolean shuHouZhenTong = false;
                    if (patientLink.getAnesthesiaRecord().getPCIA()) {
                        qualityStatistics.setPcia(qualityStatistics.getPcia() + 1);
                        shuHouZhenTong = true;
                    } else if (patientLink.getAnesthesiaRecord().getPCEA()) {
                        qualityStatistics.setPcea(qualityStatistics.getPcea() + 1);
                        shuHouZhenTong = true;
                    } else if (patientLink.getAnesthesiaRecord().getPCNA()) {
                        qualityStatistics.setPcna(qualityStatistics.getPcna() + 1);
                        shuHouZhenTong = true;
                    } else if (patientLink.getAnesthesiaRecord().getPCSA()) {
                        qualityStatistics.setPcsa(qualityStatistics.getPcsa() + 1);
                        shuHouZhenTong = true;
                    }
                    if (shuHouZhenTong) {
                        qualityStatistics.setShuHouZhenTong(qualityStatistics.getShuHouZhenTong() + 1);
                    }
                    // 是否急诊
                    if (patientLink.getAnesthesiaRecord().getAsa().getJz()) {
                        int numJz =  qualityStatistics.getJz() + 1;
                        qualityStatistics.setJz(numJz); // 急诊
                    }
                    // ASA分级
                    if (patientLink.getAnesthesiaRecord().getAsa() != null) {
                        String asa = patientLink.getAnesthesiaRecord().getAsa().getLevel();
                        if (Constants.ASA_1.equalsIgnoreCase(asa) || "I".equalsIgnoreCase(asa)) {
                            qualityStatistics.setAsa1(qualityStatistics.getAsa1() + 1);
                        } else if (Constants.ASA_2.equalsIgnoreCase(asa) || "II".equalsIgnoreCase(asa)) {
                            qualityStatistics.setAsa2(qualityStatistics.getAsa2() + 1);
                        } else if (Constants.ASA_3.equalsIgnoreCase(asa) || "III".equalsIgnoreCase(asa)) {
                            qualityStatistics.setAsa3(qualityStatistics.getAsa3() + 1);
                        } else if (Constants.ASA_4.equalsIgnoreCase(asa) || "IV".equalsIgnoreCase(asa)) {
                            qualityStatistics.setAsa4(qualityStatistics.getAsa4() + 1);
                        } else if (Constants.ASA_5.equalsIgnoreCase(asa) || "V".equalsIgnoreCase(asa)) {
                            qualityStatistics.setAsa5(qualityStatistics.getAsa5() + 1);
                        } else if (Constants.ASA_6.equalsIgnoreCase(asa) || "VI".equalsIgnoreCase(asa)) {
                            qualityStatistics.setAsa6(qualityStatistics.getAsa6() + 1);
                        }
                    }

                    if (patientLink.getPatient().getBrxm().equals("肖成碧")){
                        System.out.println();
                    }
                    // 术后去向
                    String patQuWang = patientLink.getAnesthesiaRecord().getBrqw();
                    Date isInfus = patientLink.getStatus().getInPacuTime();
                    if (Constants.ICU.equalsIgnoreCase(patQuWang)) {
                        qualityStatistics.setIcuCount(qualityStatistics.getIcuCount() + 1);
                    } else if (Constants.PACU.equalsIgnoreCase(patQuWang) || "PACU".equals(patQuWang) || isInfus != null) {
                        qualityStatistics.setPacuCount(qualityStatistics.getPacuCount() + 1);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<QualityStatistics> dataList = new ArrayList<>();
        for (QualityStatistics one : mapNewZhiKong.values()) {
            dataList.add(one);
        }

        return dataList;
    }

    // 获取月份
    private Date getMonthDate(Date src) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(src);
        setFirstDay(calendar);
        return calendar.getTime();
    }

    private void setFirstDay(Calendar calendar) {
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    // 判断X人是不是医生
    public static boolean isOperOfAllDoctor(PatientLink patientLink, String accountID) {
        try {
            AnesthesiaRecord anesthesiaRecord = patientLink.getAnesthesiaRecord();
            if (accountID.equalsIgnoreCase(anesthesiaRecord.getZmys())) {
                return true;
            } else if (accountID.equalsIgnoreCase(anesthesiaRecord.getFmys1())) {
                return true;
            } else if (accountID.equalsIgnoreCase(anesthesiaRecord.getFmys2())) {
                return true;
            } else if (accountID.equalsIgnoreCase(anesthesiaRecord.getFmys3())) {
                return true;
            } else if (accountID.equalsIgnoreCase(anesthesiaRecord.getMzjbys())) {
                return true;
            } else if (accountID.equalsIgnoreCase(anesthesiaRecord.getXhhs1())) {
                return true;
            } else if (accountID.equalsIgnoreCase(anesthesiaRecord.getXhhs2())) {
                return true;
            } else if (accountID.equalsIgnoreCase(anesthesiaRecord.getXhhs3())) {
                return true;
            } else if (accountID.equalsIgnoreCase(anesthesiaRecord.getXshs1())) {
                return true;
            } else if (accountID.equalsIgnoreCase(anesthesiaRecord.getXshs2())) {
                return true;
            } else if (accountID.equalsIgnoreCase(anesthesiaRecord.getXshs3())) {
                return true;
            } else if (accountID.equalsIgnoreCase(anesthesiaRecord.getOperDoctor1())) {
                return true;
            } else if (accountID.equalsIgnoreCase(anesthesiaRecord.getOperDoctor2())) {
                return true;
            } else if (accountID.equalsIgnoreCase(anesthesiaRecord.getOperDoctor3())) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    // n个月以前
    public Date agomonth(int num, Date date) {
        // 获取前月的第一天
        Calendar cal_1 = Calendar.getInstance();// 获取当前日期
        cal_1.setTime(date);
        cal_1.add(Calendar.MONTH, num);
        cal_1.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        return cal_1.getTime();
    }

    // 转换数据
    private List<ZhikongMessage> getValue(QualityStatistics m) {
        List<ZhikongMessage> dataList = new ArrayList<ZhikongMessage>();
        dataList.add(new ZhikongMessage("总手术数", m.getPatientLinkCount(), avgZl(m, m.getPatientLinkCount()), m.getPatientLinkCount(), "PatientLinkCount"));
        dataList.add(new ZhikongMessage("总麻醉数", m.getMaZuiCount(), avgZl(m, m.getMaZuiCount()), m.getPatientLinkCount(), "MaZuiCount"));
        dataList.add(new ZhikongMessage("急诊", m.getJz(), avg(m, m.getJz()), m.getPatientLinkCount(), "Jz"));
        dataList.add(new ZhikongMessage("术后镇痛", m.getShuHouZhenTong(), avg(m, m.getShuHouZhenTong()), m.getPatientLinkCount(), "Shuhouzhentong"));
        dataList.add(new ZhikongMessage("心肺复苏数", m.getXffs(), avg(m, m.getXffs()), m.getPatientLinkCount(), "Xffs"));
        dataList.add(new ZhikongMessage("心肺复苏成功数", m.getXffscg(), avg(m, m.getXffscg()), m.getPatientLinkCount(), "Xffscg"));
        dataList.add(new ZhikongMessage("麻醉复苏室列数", m.getPacuCount(), avg(m, m.getPacuCount()), m.getPatientLinkCount(), "Pacucount"));
        dataList.add(new ZhikongMessage("ASAⅠ级", m.getAsa1(), avg(m, m.getAsa1()), m.getPatientLinkCount(), "Asa1"));
        dataList.add(new ZhikongMessage("ASAⅡ级", m.getAsa2(), avg(m, m.getAsa2()), m.getPatientLinkCount(), "Asa2"));
        dataList.add(new ZhikongMessage("ASAⅢ级", m.getAsa3(), avg(m, m.getAsa3()), m.getPatientLinkCount(), "Asa3"));
        dataList.add(new ZhikongMessage("ASAⅣ级", m.getAsa4(), avg(m, m.getAsa4()), m.getPatientLinkCount(), "Asa4"));
        dataList.add(new ZhikongMessage("ASAⅤ级", m.getAsa5(), avg(m, m.getAsa5()), m.getPatientLinkCount(), "Asa5"));
        dataList.add(new ZhikongMessage("ASAⅥ级", m.getAsa6(), avg(m, m.getAsa6()), m.getPatientLinkCount(), "Asa6"));
        dataList.add(new ZhikongMessage("神经阻滞", m.getShenJingZuZhi(), avg(m, m.getShenJingZuZhi()), m.getPatientLinkCount(), "Shenjingzuzhi"));
        dataList.add(new ZhikongMessage("椎管内麻醉", m.getZhuiGuanNeiMaZauiCount(), avg(m, m.getZhuiGuanNeiMaZauiCount()), m.getPatientLinkCount(), "Zhuiguanneimazauicount"));
        dataList.add(new ZhikongMessage("插管全麻", m.getChaGuanQuanMaCount(), avg(m, m.getChaGuanQuanMaCount()), m.getPatientLinkCount(), "Chaguanquanmacount"));
        dataList.add(new ZhikongMessage("复合麻醉", m.getFuHeMaZuiCount(), avg(m, m.getFuHeMaZuiCount()), m.getPatientLinkCount(), "Fuhemazuicount"));
         dataList.add(new ZhikongMessage("非插管全麻", m.getFeiChaGuanQuanMaCount(), avg(m, m.getFeiChaGuanQuanMaCount()), m.getPatientLinkCount(), "Feichaguanquanmacount"));
        dataList.add(new ZhikongMessage("监护麻醉", m.getJianHuMaZuiCount(), avg(m, m.getJianHuMaZuiCount()), m.getPatientLinkCount(), "Jianhumazuicount"));
        dataList.add(new ZhikongMessage("麻醉后手术取消例数", m.getMzhssqx(), avg(m, m.getMzhssqx()), m.getPatientLinkCount(), "Mzhssqx"));
        dataList.add(new ZhikongMessage("中心静脉穿刺数", m.getZxjmcc(), avg(m, m.getZxjmcc()), m.getPatientLinkCount(), "Zxjmcc"));
        dataList.add(new ZhikongMessage("颈内静脉穿刺", m.getJnjmcc(), avg(m, m.getJnjmcc()), m.getPatientLinkCount(), "Jnjmcc"));
        dataList.add(new ZhikongMessage("桡动脉穿刺数", m.getNdmcc(), avg(m, m.getNdmcc()), m.getPatientLinkCount(), "Ndmcc"));
        dataList.add(new ZhikongMessage("锁骨上深静脉穿刺数", m.getSgssjmcc(), avg(m, m.getSgssjmcc()), m.getPatientLinkCount(), "Sgssjmcc"));
        dataList.add(new ZhikongMessage("锁骨下静脉穿刺数", m.getSgxsjmcc(), avg(m, m.getSgxsjmcc()), m.getPatientLinkCount(), "Sgxsjmcc"));
        dataList.add(new ZhikongMessage("股静脉穿刺数", m.getGjmcc(), avg(m, m.getGjmcc()), m.getPatientLinkCount(), "Gjmcc"));
        dataList.add(new ZhikongMessage("足背动脉穿刺数", m.getZbdmcc(), avg(m, m.getZbdmcc()), m.getPatientLinkCount(), "Zbdmcc"));
        dataList.add(new ZhikongMessage("PACU转出延迟", m.getpACUzryc(), avg(m, m.getpACUzryc()), m.getPatientLinkCount(), "PACUzryc"));
        dataList.add(new ZhikongMessage("非计划转入ICU发生例数", m.getFjhzrICUfs(), avg(m, m.getFjhzrICUfs()), m.getPatientLinkCount(), "FjhzrICUfs"));
        dataList.add(new ZhikongMessage("非计划二次插管例数", m.getFjhecqgbg(), avg(m, m.getFjhecqgbg()), m.getPatientLinkCount(), "Fjhecqgbg"));
        dataList.add(new ZhikongMessage("围手术期死亡例数", m.getMzksh24xsnsw(), avg(m, m.getMzksh24xsnsw()), m.getPatientLinkCount(), "Mzksh24xsnsw"));
        dataList.add(new ZhikongMessage("Steward评分≥4数", m.getZongfen(), avg(m, m.getZongfen()), m.getPatientLinkCount(), "Zongfen"));
        dataList.add(new ZhikongMessage("手术分类1", m.getSsqkfl1(), avg(m, m.getSsqkfl1()), m.getPatientLinkCount(), "Ssqkfl1"));
        dataList.add(new ZhikongMessage("手术分类2", m.getSsqkfl2(), avg(m, m.getSsqkfl2()), m.getPatientLinkCount(), "Ssqkfl2"));
        dataList.add(new ZhikongMessage("手术分类3", m.getSsqkfl3(), avg(m, m.getSsqkfl3()), m.getPatientLinkCount(), "Ssqkfl3"));
        dataList.add(new ZhikongMessage("手术分类4", m.getSsqkfl4(), avg(m, m.getSsqkfl4()), m.getPatientLinkCount(), "Ssqkfl4"));
        dataList.add(new ZhikongMessage("未预期意识障碍数", m.getWyqysza(), avg(m, m.getWyqysza()), m.getPatientLinkCount(), "Wyqysza"));
        dataList.add(new ZhikongMessage("因误咽误吸引发呼吸道梗阻数", m.getYwywxyfhxdgz(), avg(m, m.getYwywxyfhxdgz()), m.getPatientLinkCount(), "Ywywxyfhxdgz"));
        dataList.add(new ZhikongMessage("多次插管数", m.getDccg(), avg(m, m.getDccg()), m.getPatientLinkCount(), "Dccg"));
        dataList.add(new ZhikongMessage("多次穿刺数", m.getDccc(), avg(m, m.getDccc()), m.getPatientLinkCount(), "Dccc"));
        dataList.add(new ZhikongMessage("麻醉期间严重过敏反应发生例数", m.getMzqjyzgmfy(), avg(m, m.getMzqjyzgmfy()), m.getPatientLinkCount(), "Mzqjyzgmfy"));
        dataList.add(new ZhikongMessage("椎管内麻醉并发症", m.getZgnmzhyzsjxtbfzfs(), avg(m, m.getZgnmzhyzsjxtbfzfs()), m.getPatientLinkCount(), "Zgnmzhyzsjxtbfzfs"));
        dataList.add(new ZhikongMessage("中心静脉穿刺严重并发症发生", m.getZxjmccyzbf(), avg(m, m.getZxjmccyzbf()), m.getPatientLinkCount(), "Zxjmccyzbf"));
        dataList.add(new ZhikongMessage("全麻气管插管后声嘶发生例数", m.getQmqgbghssfs(), avg(m, m.getQmqgbghssfs()), m.getPatientLinkCount(), "Qmqgbghssfs"));
        dataList.add(new ZhikongMessage("麻醉效果优", m.getMzpd_y(), avg(m, m.getMzpd_y()), m.getPatientLinkCount(), "Mzxg_y"));
        dataList.add(new ZhikongMessage("麻醉效果良", m.getMzpd_l(), avg(m, m.getMzpd_l()), m.getPatientLinkCount(), "Mzpd_l"));
        dataList.add(new ZhikongMessage("麻醉效果不全", m.getMzpd_bq(), avg(m, m.getMzpd_bq()), m.getPatientLinkCount(), "Mzpd_bq"));
        dataList.add(new ZhikongMessage("麻醉效果无效", m.getMzpd_wx(), avg(m, m.getMzpd_wx()), m.getPatientLinkCount(), "Mzpd_wx"));
        dataList.add(new ZhikongMessage("围手术期心跳骤停例数", m.getMzksh24xsnxtzt(), avg(m, m.getMzksh24xsnxtzt()), m.getPatientLinkCount(), "Mzksh24xsnxtzt"));
        dataList.add(new ZhikongMessage("麻醉手术后新发昏迷发生例数", m.getMzsshxfhmfs(), avg(m, m.getMzsshxfhmfs()), m.getPatientLinkCount(), "Mzsshxfhmfs"));
        dataList.add(new ZhikongMessage("PACU入室低体温发生例数", m.getpACUrsdtwfs(), avg(m, m.getpACUrsdtwfs()), m.getPatientLinkCount(), "PACUrsdtwfs"));
        dataList.add(new ZhikongMessage("非计划二次手术数", m.getFjhecss(), avg(m, m.getFjhecss()), m.getPatientLinkCount(), "Fjhecss"));
        dataList.add(new ZhikongMessage("非计划改变麻醉方式数", m.getFjhgbmzfs(), avg(m, m.getFjhgbmzfs()), m.getPatientLinkCount(), "Fjhgbmzfs"));
        dataList.add(new ZhikongMessage("非计划二次麻醉数", m.getFjhecmz(), avg(m, m.getFjhecmz()), m.getPatientLinkCount(), "Fjhecmz"));
        dataList.add(new ZhikongMessage("术中输血输液反应数", m.getSzsxsyfy(), avg(m, m.getSzsxsyfy()), m.getPatientLinkCount(), "Szsxsyfy"));
        dataList.add(new ZhikongMessage("意外死亡数", m.getYwsw(), avg(m, m.getYwsw()), m.getPatientLinkCount(), "Ywsw"));
        dataList.add(new ZhikongMessage("结束时使用催醒药物数", m.getJsssycxyw(), avg(m, m.getJsssycxyw()), m.getPatientLinkCount(), "Jsssycxyw"));
        dataList.add(new ZhikongMessage("其他非预期相关事件数", m.getQtfyqxgsj(), avg(m, m.getQtfyqxgsj()), m.getPatientLinkCount(), "Qtfyqxgsj"));
        dataList.add(new ZhikongMessage("ASAⅠ级死亡数", m.getAsaSw1(), avg(m,m.getAsaSw1()), m.getPatientLinkCount(), "AsaSw1"));
        dataList.add(new ZhikongMessage("ASAⅡ级死亡数", m.getAsaSw2(), avg(m,m.getAsaSw2()), m.getPatientLinkCount(), "AsaSw2"));
        dataList.add(new ZhikongMessage("ASAⅢ级死亡数", m.getAsaSw3(), avg(m,m.getAsaSw3()), m.getPatientLinkCount(), "AsaSw3"));
        dataList.add(new ZhikongMessage("ASAⅣ级死亡数", m.getAsaSw4(), avg(m,m.getAsaSw4()), m.getPatientLinkCount(), "AsaSw4"));
        dataList.add(new ZhikongMessage("ASAⅤ级死亡数", m.getAsaSw5(), avg(m,m.getAsaSw5()), m.getPatientLinkCount(), "AsaSw5"));
        dataList.add(new ZhikongMessage("浅层组织手术", m.getJczzsh(), avg(m, m.getJczzsh()), m.getPatientLinkCount(), "Jczzsh"));
        dataList.add(new ZhikongMessage("深层组织手术", m.getSczzss(), avg(m, m.getSczzss()), m.getPatientLinkCount(), "Sczzss"));
        dataList.add(new ZhikongMessage("器官手术", m.getQgss(), avg(m, m.getQgss()), m.getPatientLinkCount(), "Qgss"));
        dataList.add(new ZhikongMessage("腔隙内手术", m.getKxnss(), avg(m, m.getKxnss()), m.getPatientLinkCount(), "Kxnss"));
        dataList.add(new ZhikongMessage("体外循环", m.getTwxh(), avg(m, m.getTwxh()), m.getPatientLinkCount(), "Twxh"));
        dataList.add(new ZhikongMessage("术后气管插管拔除", m.getShqgbgbc(), avg(m, m.getShqgbgbc()), m.getPatientLinkCount(), "Shqgbgbc"));
        dataList.add(new ZhikongMessage("转入ICU", m.getIcuCount(), avg(m, m.getIcuCount()), m.getPatientLinkCount(), "Icucount"));
        dataList.add(new ZhikongMessage("静脉PCA，PCIA", m.getPcia(), avg(m, m.getPcia()), m.getPatientLinkCount(), "Pcia"));
        dataList.add(new ZhikongMessage("皮下PCA，PCSA", m.getPcsa(), avg(m, m.getPcsa()), m.getPatientLinkCount(), "Pcsa")); // 麻醉单中没有。
        dataList.add(new ZhikongMessage("硬膜外，PCEA", m.getPcea(), avg(m, m.getPcea()), m.getPatientLinkCount(), "Pcea"));
        dataList.add(new ZhikongMessage("神经丛，PCNA", m.getPcna(), avg(m, m.getPcna()), m.getPatientLinkCount(), "Pcna"));
        dataList.add(new ZhikongMessage("麻醉后头痛数", m.getMzhtt(), avg(m, m.getMzhtt()), m.getPatientLinkCount(), "Mzhtt"));
        dataList.add(new ZhikongMessage("穿刺点红肿数", m.getCcdhzly(), avg(m, m.getCcdhzly()), m.getPatientLinkCount(), "Ccdhzly"));
        dataList.add(new ZhikongMessage("恶心呕吐数", m.getExot(), avg(m, m.getExot()), m.getPatientLinkCount(), "Exot"));
        dataList.add(new ZhikongMessage("肢体障碍数", m.getZthdza(), avg(m, m.getZthdza()), m.getPatientLinkCount(), "Zthdza"));
        dataList.add(new ZhikongMessage("重大手术数", m.getZdss(), avg(m, m.getZdss()), m.getPatientLinkCount(), "Zdss"));
        dataList.add(new ZhikongMessage("控制性降压", m.getJyzl(), avg(m, m.getJyzl()), m.getPatientLinkCount(), "Jyzl"));
        dataList.add(new ZhikongMessage("穿破硬脊膜", m.getCpyjm(), avg(m, m.getCpyjm()), m.getPatientLinkCount(), "Cpyjm"));
        dataList.add(new ZhikongMessage("术中知晓", m.getSzzx(), avg(m, m.getSzzx()), m.getPatientLinkCount(), "Szzx"));
        dataList.add(new ZhikongMessage("术中低血压", m.getSzyzdxy(), avg(m, m.getSzyzdxy()), m.getPatientLinkCount(), "Szyzdxy"));
        dataList.add(new ZhikongMessage("有创动脉穿刺并发", m.getYcdmccyzbfzfs(), avg(m, m.getYcdmccyzbfzfs()), m.getPatientLinkCount(), "Ycdmccyzbfzfs"));
        dataList.add(new ZhikongMessage("用血数", m.getYongXueShu(), avg(m, m.getYongXueShu()), m.getPatientLinkCount(), "Yongxueshu"));
        dataList.add(new ZhikongMessage("用血合适例数", m.getYxhs(), avg(m, m.getYxhs()), m.getPatientLinkCount(), "Yxhs"));
        dataList.add(new ZhikongMessage("更改手术方式", m.getGhssfs(), avg(m, m.getGhssfs()), m.getPatientLinkCount(), "Ghssfs"));
        dataList.add(new ZhikongMessage("手术室医疗干预", m.getSssylgy(), avg(m, m.getSssylgy()), m.getPatientLinkCount(), "Sssylgy"));
        dataList.add(new ZhikongMessage("急性失血", m.getJxsx(), avg(m, m.getJxsx()), m.getPatientLinkCount(), "Jxsx"));
        dataList.add(new ZhikongMessage("剖宫产手术时间大于3小时", m.getPgcsssj(), avg(m, m.getPgcsssj()), m.getPatientLinkCount(), "Pgcsssj"));
        dataList.add(new ZhikongMessage("镇痛分娩转剖宫产", m.getZtfmzpgc(), avg(m, m.getZtfmzpgc()), m.getPatientLinkCount(),"Ztfmzpgc"));
        dataList.add(new ZhikongMessage("非手术范围器官损伤", m.getFssfwqgjzzss(), avg(m, m.getFssfwqgjzzss()), m.getPatientLinkCount(), "Fssfwqgjzzss"));
        dataList.add(new ZhikongMessage("超声引导", m.getCsyd(), avg(m, m.getCsyd()), m.getPatientLinkCount(), "Csyd"));
        dataList.add(new ZhikongMessage("动脉穿刺", m.getDmcc(), avg(m, m.getDmcc()), m.getPatientLinkCount(), "Dmcc"));
        dataList.add(new ZhikongMessage("使用输注工作站", m.getSygzz(), avg(m, m.getSygzz()), m.getPatientLinkCount(), "Sygzz"));
        dataList.add(new ZhikongMessage("血液加温治疗", m.getJwzl(), avg(m, m.getJwzl()), m.getPatientLinkCount(), "Jwzl"));
        dataList.add(new ZhikongMessage("术中输血不良反应", m.getSzsxblfy(), avg(m, m.getSzsxblfy()), m.getPatientLinkCount(), "Szsxblfy"));
        dataList.add(new ZhikongMessage("动脉导管脱落", m.getDmdgtl(), avg(m, m.getDmdgtl()), m.getPatientLinkCount(), "Dmdgtl"));
         dataList.add(new ZhikongMessage("自体血输注 400ml以上", m.getZiTiXueShuZhu(), avg(m, m.getZiTiXueShuZhu()), m.getPatientLinkCount(), "Zitixueshuzhu"));
         dataList.add(new ZhikongMessage("全麻相关并发症", m.getYcdmccyzbfz(), avg(m, m.getYcdmccyzbfz()), m.getPatientLinkCount(), "ycdmccyzbfz"));
         dataList.add(new ZhikongMessage("输血400ml以上", m.getShuXueCount(), avg(m, m.getShuXueCount()), m.getPatientLinkCount(), "Shuxuecount"));
         dataList.add(new ZhikongMessage("危重患者例数", m.getWeiZhong(), avg(m, m.getWeiZhong()), m.getPatientLinkCount(), "Weizhong"));
         dataList.add(new ZhikongMessage("其他PCA", m.getOtherPCA(), avg(m, m.getOtherPCA()), m.getPatientLinkCount(), "Otherpca"));
        dataList.add(new ZhikongMessage("特殊气管插管",m.getTsqgcg(),avg(m,m.getTsqgcg()),m.getPatientLinkCount(),"Tsqgcg"));


        //找不到来源
        //        dataList.add(new ZhikongMessage("氧饱和度重度降低数", m.getSpo2JiangDi(), avg(m, m.getSpo2JiangDi()), m.getPatientLinkCount(), "Spo2jiangdi"));
        //        dataList.add(new ZhikongMessage("红细胞回输例数", m.getHongXiBaoHuiShu(), avg(m, m.getHongXiBaoHuiShu()), m.getPatientLinkCount(), "Hongxibaohuishu"));


        //重复


        //         dataList.add(new ZhikongMessage("椎管内效果1", m.getZhuiGuanNeiXiaoGuo1(), avg(m, m.getZhuiGuanNeiXiaoGuo1()), m.getPatientLinkCount(), "Zhuiguanneixiaoguo1"));
//         dataList.add(new ZhikongMessage("椎管内效果2", m.getZhuiGuanNeiXiaoGuo2(), avg(m, m.getZhuiGuanNeiXiaoGuo2()), m.getPatientLinkCount(), "Zhuiguanneixiaoguo2"));
//         dataList.add(new ZhikongMessage("椎管内效果3", m.getZhuiGuanNeiXiaoGuo3(), avg(m, m.getZhuiGuanNeiXiaoGuo3()), m.getPatientLinkCount(), "Zhuiguanneixiaoguo3"));
//         dataList.add(new ZhikongMessage("椎管内效果4", m.getZhuiGuanNeiXiaoGuo4(), avg(m, m.getZhuiGuanNeiXiaoGuo4()), m.getPatientLinkCount(), "Zhuiguanneixiaoguo4"));

        //        dataList.add(new ZhikongMessage("转入PACU", m.getPacuCount(), avg(m, m.getPacuCount()), m.getPatientLinkCount(), "Pacucount"));

//        dataList.add(new ZhikongMessage("其它麻醉", m.getQiTaMaZuiCount(), avg(m, m.getQiTaMaZuiCount()), m.getPatientLinkCount(), "Qitamazuicount"));
//         dataList.add(new ZhikongMessage("插管全麻+椎管内麻醉", m.getChaGuanQuanMaAndZhuiGuan(), avg(m, m.getChaGuanQuanMaAndZhuiGuan()), m.getPatientLinkCount(), "Chaguanquanmaandzhuiguan"));
//        dataList.add(new ZhikongMessage("硬膜外", m.getYingmowai(), avg(m, m.getYingmowai()), m.getPatientLinkCount(), "Yingmowai"));
        //        dataList.add(new ZhikongMessage("静脉麻醉例数", m.getJingMaiMaZuiConut(), avg(m, m.getJingMaiMaZuiConut()), m.getPatientLinkCount(), "Jingmaimazuiconut"));


        return dataList;
    }

        /**
         * 获取时间段内那些月份
         *
         * @param start
         * @param end
         * @return
         */
    private List<ZhikongMessage> getAllMonth1(Date start, Date end) {
        int max = 0;
        for (;;) {
            Date now = agomonth(max, start);
            if (now.getTime() > end.getTime()) {
                break;
            }
            max = max + 1;
            if (max > 48) {
                break;
            }
        }
        List<ZhikongMessage> categorie = new ArrayList<ZhikongMessage>();
        for (int j = 0; j < max; j++) {
            categorie.add(new ZhikongMessage(sdf.format(agomonth((j), start)), (char) (65 + j) + ""));

        }
        return categorie;
    }

    private List<String> getAllMonth(Date start, Date end) {
        int max = 0;
        for (;;) {
            Date now = agomonth(max, start);
            if (now.getTime() > end.getTime()) {
                break;
            }
            max = max + 1;
            if (max > 48) {
                break;
            }
        }
        List<String> categorie = new ArrayList<String>();
        for (int j = 0; j < max; j++) {
            categorie.add(sdf.format(agomonth((j), start)));

        }
        return categorie;
    }

    // 汇总数据
    public QualityStatistics refresh(List<QualityStatistics> resultList) {
        QualityStatistics whole = new QualityStatistics(); // 全部
        for (QualityStatistics t : resultList) {
            whole.setMaZuiCount(whole.getMaZuiCount() + t.getMaZuiCount()); // 麻醉总数
            whole.setMzksh24xsnsw(whole.getMzksh24xsnsw() + t.getMzksh24xsnsw()); // 死亡
            whole.setMzksh24xsnxtzt(whole.getMzksh24xsnxtzt() + t.getMzksh24xsnxtzt()); // 心脏骤停
            whole.setPcea(whole.getPcea() + t.getPcea());
            whole.setJczzsh(whole.getJczzsh() + t.getJczzsh());
            whole.setWeiZhong(whole.getWeiZhong() + t.getWeiZhong());// 危重患者例数
            whole.setMzhssqx(whole.getMzhssqx() + t.getMzhssqx()); // 手术取消
            whole.setMzqjyzgmfy(whole.getMzqjyzgmfy() + t.getMzqjyzgmfy()); // 过敏
            whole.setZgnmzhyzsjxtbfzfs(whole.getZgnmzhyzsjxtbfzfs() + t.getZgnmzhyzsjxtbfzfs()); // 椎管内麻醉并发症
            whole.setZxjmccyzbf(whole.getZxjmccyzbf() + t.getZxjmccyzbf()); // 中心静脉穿刺并发症
            whole.setZxjmcc(whole.getZxjmcc() + t.getZxjmcc()); // 中心静脉穿刺并发症
            whole.setJnjmcc(whole.getJnjmcc() + t.getJnjmcc());
            whole.setNdmcc(whole.getNdmcc() + t.getNdmcc());
            whole.setQmqgbghssfs(whole.getQmqgbghssfs() + t.getQmqgbghssfs()); // 全麻气管插管后声嘶发生
            whole.setSczzss(whole.getSczzss() + t.getSczzss());// 深部组织
            whole.setDmcc(whole.getDmcc() + t.getDmcc());// 动脉穿刺
            whole.setSgssjmcc(whole.getSgssjmcc() + t.getSgssjmcc());// 锁骨上静脉穿刺数
            whole.setGjmcc(whole.getGjmcc() + t.getGjmcc());// 股静脉穿刺数
            whole.setZbdmcc(whole.getZbdmcc() + t.getZbdmcc());// 足背动脉穿刺数
            whole.setMzhtt(whole.getMzhtt() + t.getMzhtt());// 麻醉后头痛数
            whole.setSgxsjmcc(whole.getSgxsjmcc() + t.getSgxsjmcc());// 锁骨下静脉穿刺数
            whole.setJyzl(whole.getJyzl() + t.getJyzl());// 控制性降压
            whole.setSzzx(whole.getSzzx() + t.getSzzx());// 术中知晓
            whole.setSzyzdxy(whole.getSzyzdxy() + t.getSzyzdxy());// 术中低血压
            whole.setYongXueShu(whole.getYongXueShu() + t.getYongXueShu());// 用血数
            whole.setYxhs(whole.getYxhs() + t.getYxhs());// 用血和例数
            whole.setGhssfs(whole.getGhssfs() + t.getGhssfs());// 更改手术方式
            whole.setSssylgy(whole.getSssylgy() + t.getSssylgy());// 手术室医疗干预
            whole.setJxsx(whole.getJxsx() + t.getJxsx());// 急性失血
            whole.setPgcsssj(whole.getPgcsssj() + t.getPgcsssj());// 剖宫产手术时间大于3小时
            whole.setZtfmzpgc(whole.getZtfmzpgc() + t.getZtfmzpgc());
            whole.setFeiChaGuanQuanMaCount(whole.getFeiChaGuanQuanMaCount() + t.getFeiChaGuanQuanMaCount());// 非手术范围器官损伤
            whole.setYingmowai(whole.getYingmowai() + t.getYingmowai());
            whole.setJianHuMaZuiCount(whole.getJianHuMaZuiCount() + t.getJianHuMaZuiCount());
            whole.setCsyd(whole.getCsyd() + t.getCsyd());// 超声引导
            whole.setMzsshxfhmfs(whole.getMzsshxfhmfs() + t.getMzsshxfhmfs()); // 麻醉手术后新发昏迷发生
            whole.setpACUrsdtwfs(whole.getpACUrsdtwfs() + t.getpACUrsdtwfs()); // PACU入室低体温发生
            whole.setFjhzrICUfs(whole.getFjhzrICUfs() + t.getFjhzrICUfs());// 非计划转入ICU发生
            whole.setFjhecqgbg(whole.getFjhecqgbg() + t.getFjhecqgbg()); // 非计划二次插管次数
            whole.setFjhecss(whole.getFjhecss() + t.getFjhecss());
            whole.setFjhecmz(whole.getFjhecmz() + t.getFjhecmz());
            whole.setFjhgbmzfs(whole.getFjhgbmzfs() + t.getFjhgbmzfs());
            whole.setSzsxsyfy(whole.getSzsxsyfy() + t.getSzsxsyfy());
            whole.setpACUzryc(whole.getpACUzryc() + t.getpACUzryc()); // PACU转出延迟
            whole.setYwsw(whole.getYwsw() + t.getYwsw());
            whole.setWyqysza(whole.getWyqysza() + t.getWyqysza());
            whole.setSpo2JiangDi(whole.getSpo2JiangDi() + t.getSpo2JiangDi());
            whole.setJsssycxyw(whole.getJsssycxyw() + t.getJsssycxyw());
            whole.setYwywxyfhxdgz(whole.getYwywxyfhxdgz() + t.getYwywxyfhxdgz());
            whole.setQtfyqxgsj(whole.getQtfyqxgsj() + t.getQtfyqxgsj());
            whole.setXffs(whole.getXffs() + t.getXffs());
            whole.setXffscg(whole.getXffscg() + t.getXffscg());
            whole.setZongfen(whole.getZongfen() + t.getZongfen());
            whole.setPatientLinkCount(whole.getPatientLinkCount() + t.getPatientLinkCount()); // 总手术例数

            whole.setChaGuanQuanMaCount(whole.getChaGuanQuanMaCount() + t.getChaGuanQuanMaCount());
            whole.setFeiChaGuanQuanMaCount(whole.getFeiChaGuanQuanMaCount() + t.getFeiChaGuanQuanMaCount());
            whole.setTwxh(whole.getTwxh() + t.getTwxh());

            whole.setZhuiGuanNeiMaZauiCount(whole.getZhuiGuanNeiMaZauiCount() + t.getZhuiGuanNeiMaZauiCount());
            whole.setChaGuanQuanMaAndZhuiGuan(whole.getChaGuanQuanMaAndZhuiGuan() + t.getChaGuanQuanMaAndZhuiGuan());
            whole.setShenJingZuZhi(whole.getShenJingZuZhi() + t.getShenJingZuZhi());
            whole.setFuHeMaZuiCount(whole.getFuHeMaZuiCount() + t.getFuHeMaZuiCount());
            whole.setJingMaiMaZuiConut(whole.getJingMaiMaZuiConut()+t.getJingMaiMaZuiConut());
            whole.setQiTaMaZuiCount(whole.getQiTaMaZuiCount() + t.getQiTaMaZuiCount());

            whole.setTsqgcg(whole.getTsqgcg()+t.getTsqgcg());
            whole.setJz(whole.getJz() + t.getJz()); // 急诊 //ASA分级
            whole.setAsa1(whole.getAsa1() + t.getAsa1());
            whole.setAsa2(whole.getAsa2() + t.getAsa2());
            whole.setAsa3(whole.getAsa3() + t.getAsa3());
            whole.setAsa4(whole.getAsa4() + t.getAsa4());
            whole.setAsa5(whole.getAsa5() + t.getAsa5());
            whole.setAsa6(whole.getAsa6() + t.getAsa6());
            whole.setShuHouZhenTong(whole.getShuHouZhenTong() + t.getShuHouZhenTong());// 术后镇痛
            whole.setPcia(whole.getPcia() + t.getPcia());
            whole.setPcsa(whole.getPcsa() + t.getPcsa());
            whole.setPcna(whole.getPcna() + t.getPcna());
            whole.setOtherPCA(whole.getOtherPCA() + t.getOtherPCA()); // 术后去向
            whole.setIcuCount(whole.getIcuCount() + t.getIcuCount());
            whole.setPacuCount(whole.getPacuCount() + t.getPacuCount());
            whole.setShqgbgbc(whole.getShqgbgbc() + t.getShqgbgbc());
            whole.setZiTiXueShuZhu(whole.getZiTiXueShuZhu() + t.getZiTiXueShuZhu());// 输血、自体血
            whole.setShuXueCount(whole.getShuXueCount() + t.getShuXueCount());
            whole.setSygzz(whole.getSygzz() + t.getSygzz());
            whole.setJwzl(whole.getJwzl() + t.getJwzl());
            whole.setSsqkfl1(whole.getSsqkfl1() + t.getSsqkfl1());
            whole.setSsqkfl2(whole.getSsqkfl2() + t.getSsqkfl2());
            whole.setSsqkfl3(whole.getSsqkfl3() + t.getSsqkfl3());
            whole.setSsqkfl4(whole.getSsqkfl4() + t.getSsqkfl4());
            whole.setQgss(whole.getQgss() + t.getQgss());
            whole.setKxnss(whole.getKxnss() + t.getKxnss());
            whole.setCpyjm(whole.getCpyjm() + t.getCpyjm());
            whole.setHongXiBaoHuiShu(whole.getHongXiBaoHuiShu() + t.getHongXiBaoHuiShu());
            whole.setCcdhzly(whole.getCcdhzly() + t.getCcdhzly());
            whole.setDccg(whole.getDccg() + t.getDccg());
            whole.setDccc(whole.getDccc() + t.getDccc());
            whole.setExot(whole.getExot() + t.getExot());
            whole.setZthdza(whole.getZthdza() + t.getZthdza());
            whole.setZdss(whole.getZdss() + t.getZdss());
            whole.setYcdmccyzbfzfs(whole.getYcdmccyzbfzfs() + t.getYcdmccyzbfzfs());
            whole.setMzpd_y(whole.getMzpd_y() + t.getMzpd_y());
            whole.setMzpd_l(whole.getMzpd_l() + t.getMzpd_l());
            whole.setMzpd_bq(whole.getMzpd_bq() + t.getMzpd_bq());
            whole.setMzpd_wx(whole.getMzpd_wx() + t.getMzpd_wx());
            whole.setZhuiGuanNeiXiaoGuo1(whole.getZhuiGuanNeiXiaoGuo1() + t.getZhuiGuanNeiXiaoGuo1());
            whole.setZhuiGuanNeiXiaoGuo2(whole.getZhuiGuanNeiXiaoGuo2() + t.getZhuiGuanNeiXiaoGuo2());
            whole.setZhuiGuanNeiXiaoGuo3(whole.getZhuiGuanNeiXiaoGuo3() + t.getZhuiGuanNeiXiaoGuo3());
            whole.setZhuiGuanNeiXiaoGuo4(whole.getZhuiGuanNeiXiaoGuo4() + t.getZhuiGuanNeiXiaoGuo4());
            whole.setFssfwqgjzzss(whole.getFssfwqgjzzss()+t.getFssfwqgjzzss());
            whole.setYjss(whole.getYjss() + t.getYjss());
            whole.setEjss(whole.getEjss() + t.getEjss());
            whole.setSjss(whole.getSjss() + t.getSjss());
            whole.setSsss(whole.getSsss() + t.getSsss());
            whole.setYcdmccyzbfz(whole.getYcdmccyzbfz() + t.getYcdmccyzbfz());

            //缺失
            whole.setSzsxblfy(whole.getSzsxblfy() + t.getSzsxblfy());
            whole.setAsaSw1(whole.getAsaSw1() + t.getAsaSw1());
            whole.setAsaSw2(whole.getAsaSw2() + t.getAsaSw2());
            whole.setAsaSw3(whole.getAsaSw3() + t.getAsaSw3());
            whole.setAsaSw4(whole.getAsaSw4() + t.getAsaSw4());
            whole.setAsaSw5(whole.getAsaSw5() + t.getAsaSw5());
            whole.setDmdgtl(whole.getDmdgtl() + t.getDmdgtl());

            whole.setOther(whole.getOther() + t.getOther());
        }
        return whole;
    }

    // 求平均数（根据手术总量）
    private Double avgZl(QualityStatistics m, int num) {
        Double d = null;
        try {
            if (m.getPatientLinkCount() == 0) {

            } else {
                DecimalFormat df = new DecimalFormat("#.00");
                d = Double.parseDouble(df.format(100 * (double) num / m.getPatientLinkCount()));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return d;
    }
    // 求平均数
    private Double avg(QualityStatistics m, int num) {
        Double d = null;
        try {
            if (m.getPatientLinkCount() == 0) {

            } else {
                DecimalFormat df = new DecimalFormat("#.00");
                d = Double.parseDouble(df.format(m.getMaZuiCount()==0?m.getMaZuiCount():100 * (double) num / m.getMaZuiCount()));
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return d;
    }


    public static Date getMaxMonthDate(Date d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }

    public static Date getStartDate(Date d) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    //导出质控统计信息
    @RequestMapping(value = "zhiKongExcel", method = RequestMethod.GET)
    public void zhiKongExcel(Model m, HttpServletRequest request) {
        //制作统计Excel
        try {
            System.out.println("导出文件开始");
            ContextMessage.zhikong.clear();
            Map<String, Object> params = FrontHelper.transfParams(request);
            Date start= DateUtil.getDateByConditions(new Date(), DateUtil.FIRST_DAY_OF_CUR_MONTH);
            Date end = new Date();
            if (params.get("starttime") != null && !params.get("starttime").toString().equals("")){
                start = new SimpleDateFormat("yyyy-MM-dd").parse(params.get("starttime").toString());
            }
            if (params.get("endtime") != null && !params.get("endtime").toString().equals("")){
                end = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(params.get("endtime").toString() + " 23:59:59");
            }
            String name = "";
            if (params.get("name") != null && !params.get("name").toString().equals("")){
                name = params.get("name").toString();
                name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
            }
            // 如果没有?data={.....}
            if (params.get(ParameterConstants.DATA) != null) {
                String data = params.get(ParameterConstants.DATA).toString();
                JSONObject jsonObj = new JSONObject(data);
                String starttime = jsonObj.get("starttime").toString();
                String endtime = jsonObj.get("endtime").toString();
                name = jsonObj.get("name").toString();
                start = sdf1.parse(starttime);
                end = sdf2.parse(endtime);
//                end = getMaxMonthDate(end);
            }
            String startTime = sdf1.format(start);
            String endTime = sdf2.format(end);
            onCal(startTime,endTime,name);
            try{
                System.out.println("try开始");
                FileSystemView fsv = FileSystemView.getFileSystemView();
                File file=fsv.getHomeDirectory();
                if(file!=null){
                    int year = start.getYear() + 1900;
                    String  selectPath=file.getPath();
                    String fileWholeName = selectPath + "/" + "麻醉质量检测指标" + ExportExcel.getInstance().EXCEL_SUFFIX;
                    System.out.println("导出文件位置："+fileWholeName);
                    ExportExcel.getInstance().exportZhiKongExcel(fileWholeName, this.zhiKongList, year);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("导出文件结束");
        //zhikong()
    }

    //取出质控统计的值
    private void onCal(String startTime, String endTime, String accountName)  {
        try {

            Date startDate = sdf1.parse(startTime);
            Date endDate = sdf2.parse(endTime);
            List<Account> selAccountList = accountDao.findAccountListByName(accountName);
            String accountId = "";
            List<String> accountIdList = new ArrayList<>();
            if (null != selAccountList && selAccountList.size() > 0) {
                for (int i = 0; i < selAccountList.size(); i++) {
                    accountIdList.add(selAccountList.get(i).getId());
                }
                accountId = selAccountList.get(0).getId();
            }

            List<QualityStatistics> zhiKongList = calValue(accountIdList, startDate, endDate, accountId);
            this.zhiKongList.clear();
            this.zhiKongList.addAll(zhiKongList);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //导出质控统计信息
    @RequestMapping(value = "workExcel", method = RequestMethod.GET)
    public void workExcel(Model m, HttpServletRequest request) {
        //制作统计Excel
        try {
            ContextMessage.zhikong.clear();
            Map<String, Object> params = FrontHelper.transfParams(request);
            Date start= DateUtil.getDateByConditions(new Date(), DateUtil.FIRST_DAY_OF_CUR_MONTH);
            Date end = new Date();
            if (params.get("starttime") != null && !params.get("starttime").toString().equals("")){
                start = new SimpleDateFormat("yyyy-MM-dd").parse(params.get("starttime").toString());
            }
            if (params.get("endtime") != null && !params.get("endtime").toString().equals("")){
                end = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(params.get("endtime").toString() + " 23:59:59");
            }
            String name = "";
            if (params.get("name") != null && !params.get("name").toString().equals("")){
                name = params.get("name").toString();
                name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
            }
            // 如果没有?data={.....}
            if (params.get(ParameterConstants.DATA) != null) {
                String data = params.get(ParameterConstants.DATA).toString();
                JSONObject jsonObj = new JSONObject(data);
                String starttime = jsonObj.get("starttime").toString();
                String endtime = jsonObj.get("endtime").toString();
                name = jsonObj.get("name").toString();
                start = sdf1.parse(starttime);
                end = sdf2.parse(endtime);
            }
            try{
                FileSystemView fsv = FileSystemView.getFileSystemView();
                File file=fsv.getHomeDirectory();
                if(file!=null){
                    String  selectPath=file.getPath();
                    String fileWholeName = selectPath + "/"+"麻醉工作量统计" + ExportExcel.getInstance().EXCEL_SUFFIX;
                    ExportExcel.getInstance().exportWorkExcel(fileWholeName,start,end,name);
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        //zhikong()
    }
}
