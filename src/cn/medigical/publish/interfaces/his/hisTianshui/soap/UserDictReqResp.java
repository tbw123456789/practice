package cn.medigical.publish.interfaces.his.hisTianshui.soap;

import cn.medigical.publish.interfaces.his.hisTianshui.Util;
import cn.medigical.publish.interfaces.his.hisTianshui.xml.user.DEPTROOTType;
import cn.medigical.publish.interfaces.his.hisTianshui.xml.user.ITEMType;
import cn.medigical.publish.interfaces.his.hisTianshui.xml.user.RESULTType;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.Namespace;
import org.jdom2.input.SAXBuilder;
import org.xml.sax.InputSource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDictReqResp extends SoapReqResp {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private List<ITEMType> itemTypeList;

    public String getSoapReqXml() {
        return "<V_EMP xmlns=\"http://tempuri.org/\" />";
    }
    public String getXmlStartStr() {
        return "V_EMPResult";
    }
    public void parseXML(String xml) {
//        xml = getStr();
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
            for(int i=0;i<jiedian.size();i++){
                et = (Element) jiedian.get(i);//循环依次得到子元素
                ITEMType itemType = new ITEMType();
                Date date = new Date();
                itemType.setUserID(et.getChild("ZHIGONGGH",ns).getText());
                itemType.setUserName(et.getChild("ZHIGONGXM",ns).getText());
                itemType.setUserJob(et.getChild("ZHIGONGLB",ns).getText());
                itemType.setSex(et.getChild("XINGBIE",ns).getText());
                itemType.setUserDept(et.getChild("KESHIMC",ns).getText());
                itemType.setUserDeptID(et.getChild("KESHIID",ns).getText());
                itemType.setCreateDate(simpleDateFormat.format(date));
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



    public List<ITEMType> getItemTypeList() {
        return this.itemTypeList;
    }


//    public String getStr(){
//        String returnXml = "<Response>\n" +
//                "  <account><ZHIGONGXM><![CDATA[高志宏]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[0034]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[麻醉医生]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[刘荣玺]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[0321]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[男]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[麻醉主任]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[沈天娥]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[0322]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[麻醉医生]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[文永红]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[0324]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[男]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[麻醉主任]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[李华峰]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[0326]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[麻醉医生]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[武爱珍]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[0327]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[护士]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[武晓云]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[0332]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[麻醉医生]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[魏娜]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[0336]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[护士]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[刘欣]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[0721]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[麻醉医生]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[朱丹]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[0808]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[麻醉医生]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[林英]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[0871]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[麻醉医生]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[曹雅欣]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[1208]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[麻醉医生]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[温旭珍]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[1268]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[护士]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[毕文玲]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[1269]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[护士]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[童理伟]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[1270]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[护士]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[叶红娜]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[1271]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[护士]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[李锦萍]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[1272]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[护士]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[秦明霞]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[1273]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[护士]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[赵瑞芳]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[1274]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[护士]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[何甜甜]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[1291]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[护士]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[白玖娟]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[1292]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[护士]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[张雪丹]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[1293]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[护士]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[张婷1]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[1294]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[护士]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[雷旦旦]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[1301]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[护士]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[李向向]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[1423]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[男]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[麻醉医生]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[马忻怡]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[1485]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[护士]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[马建军]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[1486]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[121]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[男]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[护士]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[戴秀莉]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[5150]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[南院区手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[2166]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[护士]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[霍莉珠]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[5152]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[南院区手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[2166]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[麻醉医生]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[侯敏]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[5399]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[南院区手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[2166]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[麻醉医生]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[潘淼]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[5400]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[南院区手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[2166]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[护士]]></ZHIGONGLB></account>\n" +
//                "  <account><ZHIGONGXM><![CDATA[白永芳]]></ZHIGONGXM>\n" +
//                "  <ZHIGONGGH><![CDATA[5402]]></ZHIGONGGH>\n" +
//                "  <KESHIMC><![CDATA[南院区手术麻醉科]]></KESHIMC>\n" +
//                "  <KESHIID><![CDATA[2166]]></KESHIID>\n" +
//                "  <XINGBIE><![CDATA[女]]></XINGBIE>\n" +
//                "  <ZHIGONGLB><![CDATA[护士]]></ZHIGONGLB></account>\n" +
//                "</Response>\n";
//        return returnXml;
//    }
}

