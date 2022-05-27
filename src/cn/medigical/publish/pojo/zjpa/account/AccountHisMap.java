package cn.medigical.publish.pojo.zjpa.account;

import java.util.HashMap;

public class AccountHisMap {

    public static HashMap<String, String> accountMap=new HashMap<String, String>();
    public static String cycle="subject1";

    public static String rootpath="controlActProcess/subject/registrationRequest";
    public static String [] path;
    static{
        path=rootpath.split("/");

        accountMap.put("workID","/controlActProcess/subject/registrationRequest/subject1/healthCareProvider/id/item/@extension");//员工编号
        accountMap.put("roleId","/controlActProcess/subject/registrationRequest/subject1/healthCareProvider/code/@code");//专业技术职务类别代码
        accountMap.put("role","/controlActProcess/subject/registrationRequest/subject1/healthCareProvider/code/displayName/@value");//专业技能职务代码对应的名称
        accountMap.put("inDate","/controlActProcess/subject/registrationRequest/subject1/healthCareProvider/effectiveTime/high/@value");//角色有效期间（起始）
        accountMap.put("outDate","/controlActProcess/subject/registrationRequest/subject1/healthCareProvider/effectiveTime/low/@value");//角色有效期间（结束）
        accountMap.put("IDCard","/controlActProcess/subject/registrationRequest/subject1/healthCareProvider/healthCarePrincipalPerson/id/item/@extension");//身份证号
        accountMap.put("documentID","/controlActProcess/subject/registrationRequest/subject1/healthCareProvider/healthCarePrincipalPerson/idCategory/@codeSystemName");//证件类别代码
        accountMap.put("documentDescription","/controlActProcess/subject/registrationRequest/subject1/healthCareProvider/healthCarePrincipalPerson/idCategory/displayName/@value");//证件类别描述
        accountMap.put("address","/controlActProcess/subject/registrationRequest/subjectl/healthCareProvider/addr/@type");//联系地址
        accountMap.put("phone","/controlActProcess/subject/registrationRequest/subjectl/healthCareProvider/telecom/@type");//工作联系方式：电话、邮箱地址等.手机type=MOB，座机=TEL，邮箱=EMA
        accountMap.put("status","/controlActProcess/subject/registrationRequest/subject1/healthCareProvider/statusCode/@code");//人员状态
        accountMap.put("description","/controlActProcess'subjecVregistrationReqiiest'subjectl/healthCareProvider/certificateText");//描述
        accountMap.put("trueName","/controlActProcess/subject/registrationRequest/subject1/healthCareProvider/healthCarePrincipalPerson/name/item/part/@value");//员工姓名
        accountMap.put("genderID","/controlActProcess/subject/registrationRequest/subject1/healthCareProvider/healthCarePrincipalPerson/administrativeGenderCode/@code");//性别代码
        accountMap.put("gender","/controlActProcess/subject/registrationRequest/subject1/healthCareProvider/healthCarePrincipalPerson/administrativeGenderCode/displayName/@value");//性别代码对应的名字
        accountMap.put("dob","/controlActProcess/subject/registrationRequest/subject1/healthCareProvider/healthCarePrincipalPerson/birthTime/@value");//出生日期
        accountMap.put("officeID","/controlActProcess/subject/registrationRequest/subject1/healthCareProvider/healthCarePrincipalPerson/asAffiliate/affiliatedPrincipalOrganization/id/item/@extension");//科室号
        accountMap.put("officeName","/controlActProcess/subject/registrationRequest/subject1/healthCareProvider/healthCarePrincipalPerson/asAffiliate/affiliatedPrincipalOrganization/name/item/part/@value");//科室名称
        accountMap.put("priorityNumber","/controlActProcess/subject/registrationRequest/subject1/healthCareProvider/healthCarePrincipalPerson/asAffiliate/affiliatedPrincipalOrganization/priorityNumber/@value");//优先号 1是主要科室，0是非主要科室

    }

    @Override
    public String toString() {
        return "AccountHisMap{}";
    }
}
