package cn.medigical.publish.interfaces.his.hisTianshui.soap;

import cn.medigical.publish.interfaces.his.hisTianshui.Util;
import cn.medigical.publish.interfaces.his.hisTianshui.xml.jianyan.ITEMType;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class JianYanReqResp extends SoapReqResp {
    private List<ITEMType> itemTypeList;
    String patientID = "";

    public String getSoapReqXml() {
        return "<V_LIS_REP xmlns=\"http://tempuri.org/\">\n" +
                "      <INP_NO>" + this.patientID + "</INP_NO>\n" +
                "    </V_LIS_REP>";
    }

    public void parseXML(String xml) {
        xml = Util.filtration(xml);
        StringReader read = new StringReader(xml);
        //创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
        InputSource source = new InputSource(read);
        //创建一个新的SAXBuilder
        SAXBuilder sb = new SAXBuilder();
        try {
            //通过输入源构造一个Document
            Document doc = sb.build(source);
            //取的根元素
            Element root = doc.getRootElement();
//            System.out.println(root.getName());//输出根元素的名称（测试）
            //得到根元素所有子元素的集合
            List jiedian = root.getChildren();
            //获得XML中的命名空间（XML中未定义可不写）
            Namespace ns = root.getNamespace();
            Element et = null;
            itemTypeList = new ArrayList<>();
            for (int i = 0; i < jiedian.size(); i++) {
                et = (Element) jiedian.get(i);//循环依次得到子元素

                String zyh = et.getChild("MRN", ns).getText();                     //认证时间
                String time = et.getChild("AUTHTIME", ns).getText();               //报告ID
                String reportid = et.getChild("REPORTID", ns).getText();           //监测大项名
                String name = et.getChild("NAME", ns).getText();
                String sample = et.getChild("SAMPLE", ns).getText();               //标本类型
                String examid = et.getChild("EXAMID", ns).getText();               //监测小项ID
                String itemname = et.getChild("ITEMNAME", ns).getText();           //小项名
                String itemshortname = et.getChild("ITEMSHORTNAME", ns).getText(); //缩写
                String result = et.getChild("RESULT", ns).getText();               //值

                ITEMType itemType = new ITEMType();

                itemType.setZyh(zyh);
                itemType.setTime(time);
                itemType.setReportid(reportid);
                itemType.setName(name);
                itemType.setSample(sample);
                itemType.setExamid(examid);
                itemType.setItemname(itemname);
                itemType.setItemshortname(itemshortname);
                itemType.setResult(result);
                itemTypeList.add(itemType);
            }

        } catch (JDOMException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        }
    }

    public String getXmlStartStr() {
        return "V_LIS_REPResult";
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public List<ITEMType> getItemTypeList() {
        return this.itemTypeList;
    }

    private Map<String, Map<String , String>> jianyanMap;

    public Map<String , Map<String , String>> getJianYanMap(){
        jianyanMap = new HashMap<>();
        Map<String, String> xcg = new LinkedHashMap<>();
        xcg.put("WBC" , "X10^9/L、");
        xcg.put("RBC" , "X10^12/L、");
        xcg.put("HGB" , "g/L、");
        xcg.put("HCT" , "%、");
        xcg.put("PLT" , "X10^9/L。");
        jianyanMap.put("血常规" , xcg);
        Map<String, String> nxcg = new LinkedHashMap<>();
        nxcg.put("APTT" , "秒、");
        nxcg.put("TT" , "秒、");
        nxcg.put("FIB" , "g/L、");
        nxcg.put("PT" , "秒。");
        jianyanMap.put("凝血常规", nxcg);
        Map<String, String> ggn = new LinkedHashMap<>();
        ggn.put("AST" , "IU/L、");
        ggn.put("ALT" , "IU/L、");
        ggn.put("TBIL" , "umol/L、");
        ggn.put("DBIL" , "umol/L、");
        ggn.put("IBLL" , "umol/L、");
        ggn.put("TP" , "g/L、");
        ggn.put("ALB" , "g/L、");
        ggn.put("GLB" , "g/L。");
        jianyanMap.put("肝功能", ggn);
        Map<String, String> sgn = new LinkedHashMap<>();
        sgn.put("GLU", "mmol/L、");
        sgn.put("UREA", "mmol/L、");
        sgn.put("CREA", "mmol/L。");
        jianyanMap.put("肾功能", sgn);
        Map<String, String> djz = new LinkedHashMap<>();
        djz.put("K", "mmol/L、");
        djz.put("Na", "mmol/L、");
        djz.put("Cl", "mmol/L、");
        djz.put("Ca", "mmol/L、");
        djz.put("P", "mmol/L、");
        djz.put("CO2", "mmol/L。");
        jianyanMap.put("电解质", djz);

        return this.jianyanMap;
    }
}

