 package cn.medigical.publish.interfaces.his.hisTianshui.soap;

 import cn.medigical.publish.interfaces.his.hisTianshui.Util;
 import cn.medigical.publish.interfaces.his.hisTianshui.xml.dept.ITEMType;
 import cn.medigical.publish.pojo.Account;
 import org.jdom2.JDOMException;
 import org.xml.sax.InputSource;

 import java.io.*;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.regex.Matcher;
 import java.util.regex.Pattern;


 import org.jdom2.Document;
 import org.jdom2.Element;
 import org.jdom2.JDOMException;
 import org.jdom2.Namespace;
 import org.jdom2.input.SAXBuilder;
 import org.xml.sax.InputSource;



 public class DeptDictReqResp extends SoapReqResp
 {
   private List<ITEMType> itemTypeList;

   public String getSoapReqXml()
   {
     return "<V_DEPT xmlns=\"http://tempuri.org/\" />";
   }

   public String getXmlStartStr()
   {
     return "V_DEPTResult";
   }

     public void parseXML(String xml){
//         xml = getStr();
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
//             System.out.println(root.getName());//输出根元素的名称（测试）
             //得到根元素所有子元素的集合
             List jiedian = root.getChildren();
             //获得XML中的命名空间（XML中未定义可不写）
             Namespace ns = root.getNamespace();
             Element et = null;
             itemTypeList = new ArrayList<>();
             for(int i=0;i<jiedian.size();i++){
                 et = (Element) jiedian.get(i);//循环依次得到子元素
                 ITEMType itemType = new ITEMType();

                 itemType.setDeptCode(et.getChild("KESHIID",ns).getText());
                 itemType.setDeptName(et.getChild("KESHIMC",ns).getText());
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
//   public void parseXML(String xml)
//   {
//     JAXBContext jc = null;
//     try {
//       jc = JAXBContext.newInstance("cn.medigical.publish.interfaces.his.hisTianshui.xml.dept");
//       Unmarshaller u = jc.createUnmarshaller();
//
//       InputStream stream = null;
//       try
//       {
//         stream = new ByteArrayInputStream(xml.getBytes("gb2312"));
//       } catch (UnsupportedEncodingException e) {
//         this.logger.warn("UnsupportedEncodingException", e);
//         e.printStackTrace();
//         return;
//       }
//
//       if (null == stream) {
//         this.logger.warn("stream = null");
//         return;
//       }
//
//       JAXBElement customerE = (JAXBElement)u.unmarshal(stream);
//
//       RESULTType contentType = (RESULTType)customerE.getValue();
//
//       DEPTROOTType deptrootType = contentType.getDEPTROOT();
//
//       List list = deptrootType.getITEM();
//
//       if (null == list) {
//         this.itemTypeList = null;
//       } else {
//         if (null == this.itemTypeList) {
//           this.itemTypeList = new ArrayList();
//         }
//         this.itemTypeList.clear();
//         this.itemTypeList.addAll(list);
//       }
//     }
//     catch (JAXBException e) {
//       e.printStackTrace();
//       this.logger.warn("JAXBException，itemTypeList=null", e);
//       this.itemTypeList = null;
//     }
//   }

   public List<ITEMType> getItemTypeList() {
     return this.itemTypeList;
   }

//   public String getStr(){
//        String  returnXml = "<Response><dept><KESHIID><![CDATA[121]]></KESHIID><KESHIMC><![CDATA[麻醉科]]></KESHIMC></dept><dept><KESHIID><![CDATA[2439]]></KESHIID><KESHIMC><![CDATA[美沙酮门诊]]></KESHIMC></dept><dept><KESHIID><![CDATA[2440]]></KESHIID><KESHIMC><![CDATA[美沙酮药房]]></KESHIMC></dept><dept><KESHIID><![CDATA[2441]]></KESHIID><KESHIMC><![CDATA[美沙酮药房1]]></KESHIMC></dept></Response>";
//
//       return returnXml;
//   }
 }

