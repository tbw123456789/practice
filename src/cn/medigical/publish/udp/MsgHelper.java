package cn.medigical.publish.udp;

import java.util.UUID;

public class MsgHelper {

    public  static String MSG="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
            "<!-- type，区分手麻还是icu-->\n" +
            "<root type=”Anes”>\n" +
            "<!-- 功能id，对应2.1服务列表-->\n" +
            "<MethodId>{0}</MethodId>\n" +
            "<!—自定义内容-->\n" +
            "<CustomContent></CustomContent>\n" +
            "<!—业务id，如果手术相关的接口就是手术申请id集合-->\n" +
            "<businessIds>{1}</businessIds>" +
            "</root>\n";

    public static String getXML(String methodId,String [] strings){
        StringBuffer buffer=new StringBuffer();
        StringBuffer bufferId=new StringBuffer();
        if(strings.length>0){
            for (int i=0;i<strings.length;i++){
                bufferId.append("<id>"+strings[i]+"</id>");
            }
        }else{
            bufferId.append("<id>"+""+"</id>");
        }
        buffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<!-- type，区分手麻还是icu-->\n" +
                "<root type=\"Anes\">\n" +
                "<!-- 功能id，对应2.1服务列表-->\n" +
                "<MethodId>" +methodId+
                "</MethodId>\n" +
                "<!--自定义内容-->\n" +
                "<CustomContent></CustomContent>\n" +
                "<!--业务id，如果手术相关的接口就是手术申请id集合-->\n" +
                "<businessIds>" +bufferId.toString()+
                "</businessIds>" +
                "</root>");


 //       String xml=String.format("1{0}{1}{2}",2,3,4);
        //String xml=String.format("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><root type=”Anes”><MethodId>{0}</MethodId><CustomContent></CustomContent><businessIds>{1}</businessIds></root>", methodId,buffer.toString());
        return buffer.toString();
    }
    public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr=str.replace("-", "");
        return uuidStr;
    }
}
