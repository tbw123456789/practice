package cn.medigical.publish.pojo.qualitystatic;



import cn.medigical.publish.pojo.common.MyDefaultTableModel;
import cn.medigical.publish.pojo.zhikong.QualityStatistics;

import java.lang.reflect.Method;

/**
 * Created by 博创医疗 on 2016/12/29.
 */
public class TblZhiKongLeftModel extends MyDefaultTableModel {

    QualityStatistics data = new QualityStatistics();

    public static String[] titles = {"总手术数",
            "总麻醉数",
            "急诊",
            "术后镇痛",
            "心肺复苏数",
            "心肺复苏成功数",
            "麻醉复苏室列数",
            "ASAⅠ级",
            "ASAⅡ级",
            "ASAⅢ级",
            "ASAⅣ级",
            "ASAⅤ级",
            "ASAⅥ级",
            "神经阻滞",
            "椎管内麻醉",
            "插管全麻",
            "复合麻醉",
            "非插管全麻",
            "监护麻醉",
            "麻醉后手术取消例数",
            "中心静脉穿刺数",
            "颈内静脉穿刺",
            "桡动脉穿刺数",
            "锁骨上深静脉穿刺数",
            "锁骨下静脉穿刺数",
            "股静脉穿刺数",
            "足背动脉穿刺数",
            "PACU转出延迟",
            "非计划转入ICU发生例数",
            "非计划二次插管例数",
            "围手术期死亡例数",
            "Steward评分≥4数",
            "手术分类1",
            "手术分类2",
            "手术分类3",
            "手术分类4",
            "未预期意识障碍数",
            "因误咽误吸引发呼吸道梗阻数",
            "多次插管数",
            "多次穿刺数",
            "麻醉期间严重过敏反应发生例数",
            "椎管内麻醉并发症",
            "中心静脉穿刺严重并发症发生",
            "全麻气管插管后声嘶发生例数",
            "麻醉效果优",
            "麻醉效果良",
            "麻醉效果不全",
            "麻醉效果无效",
            "围手术期心跳骤停例数",
            "麻醉手术后新发昏迷发生例数",
            "PACU入室低体温发生例数",
            "非计划二次手术数",
            "非计划改变麻醉方式数",
            "非计划二次麻醉数",
            "术中输血输液反应数",
            "意外死亡数",
            "结束时使用催醒药物数",
            "其他非预期相关事件数",
            "ASAⅠ级死亡数",
            "ASAⅡ级死亡数",
            "ASAⅢ级死亡数",
            "ASAⅣ级死亡数",
            "ASAⅤ级死亡数",
            "浅层组织手术",
            "深层组织手术",
            "器官手术",
            "腔隙内手术",
            "体外循环",
            "术后气管插管拔除",
            "转入ICU",
            "静脉PCA，PCIA",
            "皮下PCA，PCSA",
            "硬膜外，PCEA",
            "神经丛，PCNA",
            "麻醉后头痛数",
            "穿刺点红肿数",
            "恶心呕吐数",
            "肢体障碍数",
            "重大手术数",
            "控制性降压",
            "穿破硬脊膜",
            "术中知晓",
            "术中低血压",
            "有创动脉穿刺并发",
            "用血数",
            "用血合适例数",
            "更改手术方式",
            "手术室医疗干预",
            "急性失血",
            "剖宫产手术时间大于3小时",
            "镇痛分娩转剖宫产",
            "非手术范围器官损伤",
            "超声引导",
            "动脉穿刺",
            "使用输注工作站",
            "血液加温治疗",
            "术中输血不良反应",
            "动脉导管脱落",
            "自体血输注 400ml以上",
            "全麻相关并发症",
            "输血400ml以上",
            "危重患者例数",
            "其他PCA"
    };

    public static String[] methods = {"PatientLinkCount",
            "MaZuiCount",
            "Jz",
            "Shuhouzhentong",
            "Xffs",
            "Xffscg",
            "Pacucount",
            "Asa1",
            "Asa2",
            "Asa3",
            "Asa4",
            "Asa5",
            "Asa6",
            "Shenjingzuzhi",
            "Zhuiguanneimazauicount",
            "Chaguanquanmacount",
            "Fuhemazuicount",
            "Feichaguanquanmacount",
            "Jianhumazuicount",
            "Mzhssqx",
            "Zxjmcc",
            "Jnjmcc",
            "Ndmcc",
            "Sgssjmcc",
            "Sgxsjmcc",
            "Gjmcc",
            "Zbdmcc",
            "PACUzryc",
            "FjhzrICUfs",
            "Fjhecqgbg",
            "Mzksh24xsnsw",
            "Zongfen",
            "Ssqkfl1",
            "Ssqkfl2",
            "Ssqkfl3",
            "Ssqkfl4",
            "Wyqysza",
            "Ywywxyfhxdgz",
            "Dccg",
            "Dccc",
            "Mzqjyzgmfy",
            "Zgnmzhyzsjxtbfzfs",
            "Zxjmccyzbf",
            "Qmqgbghssfs",
            "Mzxg_y",
            "Mzpd_l",
            "Mzpd_bq",
            "Mzpd_wx",
            "Mzksh24xsnxtzt",
            "Mzsshxfhmfs",
            "PACUrsdtwfs",
            "Fjhecss",
            "Fjhgbmzfs",
            "Fjhecmz",
            "Szsxsyfy",
            "Ywsw",
            "Jsssycxyw",
            "Qtfyqxgsj",
            "AsaSw1",
            "AsaSw2",
            "AsaSw3",
            "AsaSw4",
            "AsaSw5",
            "Jczzsh",
            "Sczzss",
            "Qgss",
            "Kxnss",
            "Twxh",
            "Shqgbgbc",
            "Icucount",
            "Pcia",
            "Pcsa",
            "Pcea",
            "Pcna",
            "Mzhtt",
            "Ccdhzly",
            "Exot",
            "Zthdza",
            "Zdss",
            "Jyzl",
            "Cpyjm",
            "Szzx",
            "Szyzdxy",
            "Ycdmccyzbfzfs",
            "Yongxueshu",
            "Yxhs",
            "Ghssfs",
            "Sssylgy",
            "Jxsx",
            "Pgcsssj",
            "Ztfmzpgc",
            "Fssfwqgjzzss",
            "Csyd",
            "Dmcc",
            "Sygzz",
            "Jwzl",
            "Szsxblfy",
            "Dmdgtl",
            "Zitixueshuzhu",
            "ycdmccyzbfz",
            "Shuxuecount",
            "Weizhong",
            "Otherpca"};

    @Override
    public Object getValueAt(int row, int col) {
        String ret= "";
        if( 0 == col){
            return titles[row];
        }else if( 1 == col){
            try {
                String methodName = "get" + methods[row];
                Method[] methods = data.getClass().getMethods();
                ret = Integer.toString(0);
                for( Method m: methods){
                    if( m.getName().equalsIgnoreCase(methodName)){
                        Object o = m.invoke(data ,(Object[])null);
                        if( null != o){
                            ret = ((Integer) o).toString();
                        }
                        break;
                    }
                }
            } catch (Exception ex) {
                ret = Integer.toString(0);
            }
        }
        return ret;
    }

    public void setData(QualityStatistics data) {
        this.data = data;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return methods.length;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    public String getColumnName(int col) {
        switch (col){
            case 0:{
                return "指标详情";
            }
            case 1:{
                return "汇总";
            }

        }
        return " ss";
    }

    @Override
    public Class getColumnClass(int c)  {
        Object value = getValueAt(0, c);
        if(value!=null)
            return value.getClass();
        else return super.getClass();
    }

    public void setValueAt(Object aValue, int row, int column) {
        super.setValueAt(aValue , row , column);
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }
}
