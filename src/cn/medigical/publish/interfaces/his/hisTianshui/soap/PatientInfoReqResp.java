 package cn.medigical.publish.interfaces.his.hisTianshui.soap;

 import cn.medigical.publish.interfaces.his.hisTianshui.Util;
 import cn.medigical.publish.interfaces.his.hisTianshui.xml.apply.ITEMType;
 import org.jdom2.Document;
 import org.jdom2.Element;
 import org.jdom2.JDOMException;
 import org.jdom2.Namespace;
 import org.jdom2.input.SAXBuilder;
 import org.xml.sax.InputSource;


 import java.io.*;
 import java.util.ArrayList;
 import java.util.List;


 public class PatientInfoReqResp extends SoapReqResp
 {
   private ITEMType itemType;
   String zyh = "";
 
   public String getSoapReqXml()
   {
     return "<V_OPERINFO_BY_HOSNO xmlns=\"http://tempuri.org/\">\n" +
             "      <hosNo>"+this.zyh+"</hosNo>\n" +
             "    </V_OPERINFO_BY_HOSNO>";
   }
 
   public void parseXML(String xml){
//     xml = getStr();
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
       itemType = new ITEMType();

       for (int i = 0; i < jiedian.size(); i++) {
         et = (Element) jiedian.get(i);//循环依次得到子元素

         String shoushudid = et.getChild("SHOUSHUDID", ns).getText();    //手术单ID
         String shoushuzt = et.getChild("SHOUSHUZT", ns).getText();//手术状态
         String bingrenxm = et.getChild("BINGRENXM", ns).getText();//病人姓名
         String zhuyuanhao = et.getChild("ZHUYUANHAO", ns).getText();//His端住院号
         String xingbie = et.getChild("XINGBIE", ns).getText();//性别
         String nianling = et.getChild("NIANLING", ns).getText();//年龄
         String bingrencw = et.getChild("BINGRENCW", ns).getText();//住院床号
         String shenqingksmc = et.getChild("SHENQINGKSMC", ns).getText();//申请科室名称
         String shenqingks = et.getChild("SHENQINGKS", ns).getText();//申请科室编号
         String shoushumc = et.getChild("SHOUSHUMC", ns).getText();//拟施手术名称
         String shoushumc1 = et.getChild("SHOUSHUMC1", ns).getText();//拟施手术名称1
         String shoushumc2 = et.getChild("SHOUSHUMC2", ns).getText();//拟施手术名称2
         String shoushumc3 = et.getChild("SHOUSHUMC3", ns).getText();//拟施手术名称3
         String yaoqiusj = et.getChild("yaoqiusj", ns).getText();//计划手术时间
         String shenqingsj = et.getChild("SHENQINGSJ", ns).getText();//手术申请时间
         String shoushujb = et.getChild("SHOUSHUJB", ns).getText();//手术级别
         String zhenduanmc1 = et.getChild("ZHENDUANMC1", ns).getText();//术前诊断
         String shoushuys = et.getChild("SHOUSHUYS", ns).getText();//手术医生编号
         String zhuliys1 = et.getChild("ZHULIYS1", ns).getText();//助理医生1编号
         String zhuliys2 = et.getChild("ZHULIYS2", ns).getText();//助理医生2编号
         String zhuliys3 = et.getChild("ZHULIYS3", ns).getText();//助理医生3编号
         String ssshenqingksmc = et.getChild("SSSHENQINGKSMC", ns).getText();//实施科室名称
         String ssshenqingks = et.getChild("SSSHENQINGKS", ns).getText();//实施科室编号
         String shengao = et.getChild("SHENGAO", ns).getText();//身高
         String bingrentz = et.getChild("BINGRENTZ", ns).getText();//体重
         String bqbh = et.getChild("BQBH", ns).getText();//病区编号
         String bqmc = et.getChild("BQMC", ns).getText();//病区名称
//                String type = et.getChild("TYPE", ns).getText(); // 急诊/择期

         itemType.setPatientId(zhuyuanhao);
         itemType.setScheduleId(shoushudid);
         itemType.setKeshiName(shenqingksmc);
         itemType.setBedNO(bingrencw);
         itemType.setDeptStayed(shenqingks);
         itemType.setDiagBeforeOperation(zhenduanmc1);
//                itemType.setType(type);
         itemType.setScheduledDateTime(shenqingsj);
         itemType.setShoushujb(shoushujb);
         itemType.setReqDateTime(yaoqiusj);
         itemType.setSurgeon(shoushuys);
         itemType.setFirstAssistant(zhuliys1);
         itemType.setSecondAssistant(zhuliys2);
         itemType.setSecondAnesthesiaAssistant(zhuliys3);
         itemType.setBrxm(bingrenxm);
         itemType.setXb(xingbie);
         itemType.setNl(nianling);
         itemType.setSg(shengao);
         itemType.setTz(bingrentz);
         itemType.setNsssmc1(shoushumc);
         itemType.setNsssmc2(shoushumc1);
         itemType.setNsssmc3(shoushumc2);
         itemType.setNsssmc4(shoushumc3);
       }

     } catch (JDOMException e) {
       // TODO 自动生成 catch 块
       e.printStackTrace();
     } catch (IOException e) {
       // TODO 自动生成 catch 块
       e.printStackTrace();
     }
   }

 
   public ITEMType getItemType() {
     return this.itemType;
   }

   public String getXmlStartStr()
   {
     return "V_OPERINFO_BY_HOSNOResult";
   }

   public String getZyh() {
     return zyh;
   }

   public void setZyh(String zyh) {
     this.zyh = zyh;
   }

//   public String  getStr(){
//     String str = "<Response>\n" +
//             "\t<OperationInfo>\n" +
//             "\t\t<SHOUSHUDID><![CDATA[80809267]]></SHOUSHUDID>\n" +
//             "\t\t<BINGRENXM><![CDATA[魏建平]]></BINGRENXM>\n" +
//             "\t\t<ZHUYUANHAO><![CDATA[442769]]></ZHUYUANHAO>\n" +
//             "\t\t<XINGBIE><![CDATA[男]]></XINGBIE>\n" +
//             "\t\t<NIANLING><![CDATA[35岁]]></NIANLING>\n" +
//             "\t\t<BINGRENCW><![CDATA[2]]></BINGRENCW>\n" +
//             "\t\t<SHENQINGKSMC><![CDATA[南院区外科]]></SHENQINGKSMC>\n" +
//             "\t\t<SHENQINGKS><![CDATA[2223]]></SHENQINGKS>\n" +
//             "\t\t<SHOUSHUJB><![CDATA[]]></SHOUSHUJB>\n" +
//             "\t\t<SHOUSHUYS><![CDATA[]]></SHOUSHUYS>\n" +
//             "\t\t<ZHULIYS1><![CDATA[]]></ZHULIYS1>\n" +
//             "\t\t<ZHULIYS2><![CDATA[]]></ZHULIYS2>\n" +
//             "\t\t<ZHULIYS3><![CDATA[]]></ZHULIYS3>\n" +
//             "\t\t<SSSHENQINGKSMC><![CDATA[南院区外科]]></SSSHENQINGKSMC>\n" +
//             "\t\t<SSSHENQINGKS><![CDATA[2223]]></SSSHENQINGKS>\n" +
//             "\t\t<SHENGAO><![CDATA[]]></SHENGAO>\n" +
//             "\t\t<BINGRENTZ><![CDATA[]]></BINGRENTZ>\n" +
//             "\t\t<BQBH><![CDATA[2223]]></BQBH>\n" +
//             "\t\t<BQMC><![CDATA[南院区外科]]></BQMC>\n" +
//             "\t\t<SHOUSHUMC><![CDATA[腹股沟疝修补术]]></SHOUSHUMC>\n" +
//             "\t\t<SHOUSHUMC1><![CDATA[]]></SHOUSHUMC1>\n" +
//             "\t\t<SHOUSHUMC2><![CDATA[]]></SHOUSHUMC2>\n" +
//             "\t\t<SHOUSHUMC3><![CDATA[]]></SHOUSHUMC3>\n" +
//             "\t\t<yaoqiusj><![CDATA[2019/11/21 8:30:00]]></yaoqiusj>\n" +
//             "\t\t<SHENQINGSJ><![CDATA[2019/11/20 7:50:00]]></SHENQINGSJ>\n" +
//             "\t\t<SHOUSHUZT><![CDATA[已执行]]></SHOUSHUZT>\n" +
//             "\t\t<ZHENDUANMC1><![CDATA[(K40.902)腹股沟直疝（右侧）]]></ZHENDUANMC1>\n" +
//             "\t</OperationInfo>\n" +
//             "</Response>";
//     return str;
//   }
 }

