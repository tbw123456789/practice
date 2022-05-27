package cn.medigical.publish.pojo.zjpa.dept;

import java.util.HashMap;

public class DepartHisMap {

    public static HashMap<String, String> deptMap=new HashMap<String, String>();
    public static String cycle="subject1";

    public static String rootpath="controlActProcess/subject/registrationRequest";
    public static String [] path;
    static{
        path=rootpath.split("/");

        deptMap.put("code", "/controlActProcess/subject/registrationRequest/subject1/assignedEntity/id/item/@extension");
        deptMap.put("name","/controlActProcess/subject/registrationRequest/subject1/assignedEntity/name/item/part/@value");
        deptMap.put("departjianma", "/controlActProcess/subject/registrationRequest/subject1/assignedEntity/confidentialityCode/@value");
        deptMap.put("departmiaoshu","/controlActProcess/subject/registrationRequest/subject1/assignedEntity/certificateText/@value");
        deptMap.put("departzhangtai", "/controlActProcess/subject/registrationRequest/subject1/assignedEntity/statusCode/@code");
        deptMap.put("shangjidepartdiama","/controlActProcess/subject/registrationRequest/subject1/assignedEntity/assignedPrincipalOrganization/id/item/@extension");
        deptMap.put("shangjidepartmingcheng", "/controlActProcess/subject/registrationRequest/subject1/assignedEntity/assignedPrincipalOrganization/name/item/part/@value");

    }



}
