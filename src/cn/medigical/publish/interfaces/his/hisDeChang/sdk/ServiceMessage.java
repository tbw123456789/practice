package cn.medigical.publish.interfaces.his.hisDeChang.sdk;

public class ServiceMessage {

    //科室视图
    public static String ANES_DEPARTMENT = "BS02001";
    //职工视图
    public static String ANES_ACCOUNT = "BS02004";
    //药品
    public static String ANES_DRUG = "BS35010";
    //手术申请单
    public static String ANES_OPERATION = "BS35008";
    //lis报告视图
    public static String ANES_LIS_REPORT = "BS20003";
    //lis报告明细视图
    public static String ANES_LIS_REPORT_DETAIL = "BS20004";

    // 手术申请请求数据   820504775375
    public static String operationString = "<ESBEntry>\n" +
            "         \t<AccessControl>\n" +
            "         \t\t<UserName>sm</UserName>\n" +
            "         \t\t<Password>sm</Password>\n" +
            "         \t\t<SysFlag>2</SysFlag>\n" +
            "         \t\t<Fid>BS35008</Fid>\n" +
            "         \t</AccessControl>\n" +
            "         \t<MessageHeader>\n" +
            "         \t\t<Fid>BS35008</Fid>\n" +
            "         \t\t<SourceSysCode>S09</SourceSysCode>\n" +
            "         \t\t<TargetSysCode>S00</TargetSysCode>\n" +
            "         \t\t<MsgDate></MsgDate>\n" +
            "         \t</MessageHeader>\n" +
            "         \t<RequestOption>\n" +
            "         \t\t<triggerData>0</triggerData>\n" +
            "         \t\t<dataAmount>0</dataAmount>\n" +
            "              <currentPage>1</currentPage>\n" +
            "              <pageSize>0</pageSize>\n" +
            "         \t</RequestOption>\n" +
            "         \t<MsgInfo flag=\"1\" >\n" +
            "         \t\t<Msg></Msg>\n" +
            "         \t\t<distinct value=\"0\"/>\n" +
            "         \t\t<query item=\"SHENQINGSJ\" compy=\"&gt;\" value=\"to_date('dateFrom', 'yyyy-MM-dd HH24:mi:ss')\" splice=\"and\"/>\n" +
//                "         \t\t<query item=\"sex\" compy=\" = \" value=\"男\" splice=\"and\"/>\n" +
            "         \t\t<order item=\"YAOQIUSJ\" sort=\" asc \" />\n" +
            "         \t</MsgInfo>\n" +
            "         \t<GroupInfo flag=\"1\">\n" +
            "         \t<AS ID=\"AS10003\" linkField=\"ZHUYUANHAO\"/>\n"+
            "         \t</GroupInfo>\n" +
            "         \t\n" +
            "  </ESBEntry>\n";

    // 手术申请请求数据   820504775375
    public static String operationString2 = "<ESBEntry>\n" +
            "         \t<AccessControl>\n" +
            "         \t\t<UserName>sm</UserName>\n" +
            "         \t\t<Password>sm</Password>\n" +
            "         \t\t<SysFlag>2</SysFlag>\n" +
            "         \t\t<Fid>BS35008</Fid>\n" +
            "         \t</AccessControl>\n" +
            "         \t<MessageHeader>\n" +
            "         \t\t<Fid>BS35008</Fid>\n" +
            "         \t\t<SourceSysCode>S09</SourceSysCode>\n" +
            "         \t\t<TargetSysCode>S00</TargetSysCode>\n" +
            "         \t\t<MsgDate></MsgDate>\n" +
            "         \t</MessageHeader>\n" +
            "         \t<RequestOption>\n" +
            "         \t\t<triggerData>0</triggerData>\n" +
            "         \t\t<dataAmount>0</dataAmount>\n" +
            "              <currentPage>1</currentPage>\n" +
            "              <pageSize>0</pageSize>\n" +
            "         \t</RequestOption>\n" +
            "         \t<MsgInfo flag=\"1\" >\n" +
            "         \t\t<Msg></Msg>\n" +
            "         \t\t<distinct value=\"0\"/>\n" +
//            "         \t\t<query item=\"SHENQINGSJ\" compy=\"&gt;\" value=\"to_date('dateFrom', 'yyyy-MM-dd HH24:mi:ss')\" splice=\"and\"/>\n" +
            "         \t\t<query item=\"ZHUYUANHAO\" compy=\" = \" value=\"ZYH\" splice=\"and\"/>\n" +
            "         \t\t<order item=\"YAOQIUSJ\" sort=\" asc \" />\n" +
            "         \t</MsgInfo>\n" +
            "         \t<GroupInfo flag=\"1\">\n" +
            "         \t<AS ID=\"AS10003\" linkField=\"ZHUYUANHAO\"/>\n"+
            "         \t</GroupInfo>\n" +
            "         \t\n" +
            "  </ESBEntry>\n";


    // 科室请求数据   820504775375
    public static String departmentString = "<ESBEntry>\n" +
            "         \t<AccessControl>\n" +
            "         \t\t<UserName>sm</UserName>\n" +
            "         \t\t<Password>sm</Password>\n" +
            "         \t\t<SysFlag>2</SysFlag>\n" +
            "         \t\t<Fid>BS02001</Fid>\n" +
            "         \t</AccessControl>\n" +
            "         \t<MessageHeader>\n" +
            "         \t\t<Fid>BS02001</Fid>\n" +
            "         \t\t<SourceSysCode>S09</SourceSysCode>\n" +
            "         \t\t<TargetSysCode>S00</TargetSysCode>\n" +
            "         \t\t<MsgDate></MsgDate>\n" +
            "         \t</MessageHeader>\n" +
            "         \t<RequestOption>\n" +
            "         \t\t<triggerData>0</triggerData>\n" +
            "         \t\t<dataAmount>0</dataAmount>\n" +
            "              <currentPage>1</currentPage>\n" +
            "              <pageSize>0</pageSize>\n" +
            "         \t</RequestOption>\n" +
            "         \t<MsgInfo flag=\"1\" >\n" +
            "         \t\t<Msg></Msg>\n" +
            "         \t\t<distinct value=\"0\"/>\n" +
            "         \t\t<query item=\"KESHIID\" compy=\" is not \" value=\"null\" splice=\"and\"/>\n" +
//                "         \t\t<query item=\"sex\" compy=\" = \" value=\"男\" splice=\"and\"/>\n" +
            "         \t</MsgInfo>\n" +
            "         \t<GroupInfo flag=\"0\">\n" +
            "         \t</GroupInfo>\n" +
            "         \t\n" +
            "  </ESBEntry>\n";

    // 职工请求数据
    public static String accountString = "<ESBEntry>\n" +
            "         \t<AccessControl>\n" +
            "         \t\t<UserName>sm</UserName>\n" +
            "         \t\t<Password>sm</Password>\n" +
            "         \t\t<SysFlag>2</SysFlag>\n" +
            "         \t\t<Fid>BS02004</Fid>\n" +
            "         \t</AccessControl>\n" +
            "         \t<MessageHeader>\n" +
            "         \t\t<Fid>BS02004</Fid>\n" +
            "         \t\t<SourceSysCode>S09</SourceSysCode>\n" +
            "         \t\t<TargetSysCode>S00</TargetSysCode>\n" +
            "         \t\t<MsgDate></MsgDate>\n" +
            "         \t</MessageHeader>\n" +
            "         \t<RequestOption>\n" +
            "         \t\t<triggerData>0</triggerData>\n" +
            "         \t\t<dataAmount>0</dataAmount>\n" +
            "              <currentPage>1</currentPage>\n" +
            "              <pageSize>0</pageSize>\n" +
            "         \t</RequestOption>\n" +
            "         \t<MsgInfo flag=\"1\" >\n" +
            "         \t\t<Msg></Msg>\n" +
            "         \t\t<distinct value=\"0\"/>\n" +
            "         \t\t<query item=\"ZHIGONGGH\" compy=\" is not \" value=\"null\" splice=\"and\"/>\n" +
//                "         \t\t<query item=\"sex\" compy=\" = \" value=\"男\" splice=\"and\"/>\n" +
            "         \t</MsgInfo>\n" +
            "         \t<GroupInfo flag=\"0\">\n" +
            "         \t</GroupInfo>\n" +
            "         \t\n" +
            "  </ESBEntry>\n";

    //Lis项目报告请求数据
    public static String lisReportString = "<ESBEntry>\n" +
            "         \t<AccessControl>\n" +
            "         \t\t<UserName>sm</UserName>\n" +
            "         \t\t<Password>sm</Password>\n" +
            "         \t\t<SysFlag>2</SysFlag>\n" +
            "         \t\t<Fid>BS20003</Fid>\n" +
            "         \t</AccessControl>\n" +
            "         \t<MessageHeader>\n" +
            "         \t\t<Fid>BS20003</Fid>\n" +
            "         \t\t<SourceSysCode>S09</SourceSysCode>\n" +
            "         \t\t<TargetSysCode>S00</TargetSysCode>\n" +
            "         \t\t<MsgDate></MsgDate>\n" +
            "         \t</MessageHeader>\n" +
            "         \t<RequestOption>\n" +
            "         \t\t<triggerData>0</triggerData>\n" +
            "         \t\t<dataAmount>0</dataAmount>\n" +
            "              <currentPage>1</currentPage>\n" +
            "              <pageSize>0</pageSize>\n" +
            "         \t</RequestOption>\n" +
            "         \t<MsgInfo flag=\"1\" >\n" +
            "         \t\t<Msg></Msg>\n" +
            "         \t\t<distinct value=\"0\"/>\n" +
            "         \t\t<query item=\"MRN\" compy=\" = \" value=\"ZHUYUANHAO\" splice=\"and\"/>\n" +
            /*<order item="字段名"  sort="asc/desc"/>*/
//            "         \t\t<query item=\"AUTHTIME\" compy=\" is not \" value=\"null\" splice=\"and\"/>\n" +
            "         \t\t<order item=\"AUTHTIME\" sort=\" asc \" />\n" +
            "         \t</MsgInfo>\n" +
            "         \t<GroupInfo flag=\"0\">\n" +
            "         \t</GroupInfo>\n" +
            "         \t\n" +
            "  </ESBEntry>\n";

    // Lis详细报告请求数据
    public static String lisReportDetailString = "<ESBEntry>\n" +
            "         \t<AccessControl>\n" +
            "         \t\t<UserName>sm</UserName>\n" +
            "         \t\t<Password>sm</Password>\n" +
            "         \t\t<SysFlag>2</SysFlag>\n" +
            "         \t\t<Fid>BS20004</Fid>\n" +
            "         \t</AccessControl>\n" +
            "         \t<MessageHeader>\n" +
            "         \t\t<Fid>BS20004</Fid>\n" +
            "         \t\t<SourceSysCode>S09</SourceSysCode>\n" +
            "         \t\t<TargetSysCode>S00</TargetSysCode>\n" +
            "         \t\t<MsgDate></MsgDate>\n" +
            "         \t</MessageHeader>\n" +
            "         \t<RequestOption>\n" +
            "         \t\t<triggerData>0</triggerData>\n" +
            "         \t\t<dataAmount>0</dataAmount>\n" +
            "              <currentPage>1</currentPage>\n" +
            "              <pageSize>0</pageSize>\n" +
            "         \t</RequestOption>\n" +
            "         \t<MsgInfo flag=\"1\" >\n" +
            "         \t\t<Msg></Msg>\n" +
            "         \t\t<distinct value=\"0\"/>\n" +
//            "         \t\t<query item=\"EXAMID\" compy=\" is not \" value=\"null\" splice=\"and\"/>\n" +
            "         \t\t<query item=\"EXAMID\" compy=\" = \" value=\"REPORTID\" splice=\"and\"/>\n" +
//            "         \t\t<query item=\"AUTHTIME\" compy=\"=\" value=\"to_date('LatestReport', 'yyyy-MM-dd HH24:mi:ss')\" splice=\"and\"/>\n" +
            "         \t\t<order item=\"TESTSHORTNAME\" sort=\" asc \" />\n" +

            "         \t</MsgInfo>\n" +
            "         \t<GroupInfo flag=\"0\">\n" +
            "         \t</GroupInfo>\n" +
            "         \t\n" +
            "  </ESBEntry>\n";
}
