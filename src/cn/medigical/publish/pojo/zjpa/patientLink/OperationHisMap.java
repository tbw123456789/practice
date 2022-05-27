package cn.medigical.publish.pojo.zjpa.patientLink;

import java.util.HashMap;

public class OperationHisMap {

    public static HashMap<String, String> operMap=new HashMap<String, String>();
    public static String cycle="component2";

    public static String rootpath="controlActProcess/subject/procedureRequest";
    public static String [] path;
    static{
        path=rootpath.split("/");
        operMap.put("applyId", "/controlActProcess/subject/procedureRequest/id/item/@extension");
        operMap.put("applyTime", "/controlActProcess/subject/procedureRequest/effectiveTime/low/@value");
        operMap.put("maZuiMethodId", "/controlActProcess/subject/procedureRequest/methodCode/item/@code");
        operMap.put("maZuiMethodName", "/controlActProcess/subject/procedureRequest/methodCode/item/displayName/@value");
        operMap.put("operTypeId", "/controlActProcess/subject/procedureRequest/methodCode/item/@code");
        operMap.put("operTypeName", "/controlActProcess/subject/procedureRequest/methodCode/item/displayName/@value");
        operMap.put("applyDocId", "/controlActProcess/subject/procedureRequest/author/assignedEntity/id/item/@extension");
        operMap.put("applyDocName", "/controlActProcess/subject/procedureRequest/author/assignedEntity/assignedPerson/name/item/part/@value");
        operMap.put("applyDeptId", "/controlActProcess/subject/procedureRequest/author/assignedEntity/representedOrganization/id/item/@extension");
        operMap.put("applyDeptName", "/controlActProcess/subject/procedureRequest/author/assignedEntity/representedOrganization/name/item/part/@value");
        operMap.put("verifierTime", "/controlActProcess/subject/procedureRequest/verifier/time/@value");
        operMap.put("verifierId", "/controlActProcess/subject/procedureRequest/verifier/assignedEntity/id/item/@extension");
        operMap.put("verifierName", "/controlActProcess/subject/procedureRequest/verifier/assignedEntity/assignedPerson/name");
        operMap.put("operId", "/controlActProcess/subject/procedureRequest/component2/procedureRequest/code/@code");
        operMap.put("operName", "/controlActProcess/subject/procedureRequest/component2/procedureRequest/code/displayName/@value");
        operMap.put("operLevelId", "/controlActProcess/subject/procedureRequest/component2/procedureRequest/priorityCode/@code");
        operMap.put("operLevelNme", "/controlActProcess/subject/procedureRequest/component2/procedureRequest/priorityCode/displayName/@value");
        operMap.put("operPlanTime", "/controlActProcess/subject/procedureRequest/component2/procedureRequest/performer/time/low/@value");
        operMap.put("operDocId", "/controlActProcess/subject/procedureRequest/component2/procedureRequest/performer/assignedEntity/id/item/@extension");
        operMap.put("operDocName", "/controlActProcess/subject/procedureRequest/component2/procedureRequest/performer/assignedEntity/assigEnedPrson/name/item/part/@value");
        operMap.put("execDeptId", "/controlActProcess/subject/procedureRequest/component2/procedureRequest/performer/assignedEntity/representedOrganization/id/ite/@extension");
        operMap.put("execDeptName", "/controlActProcess/subject/procedureRequest/component2/procedureRequest/performer/assignedEntity/representedOrganization/name");
        operMap.put("attention", "/controlActProcess/subject/procedureRequest/subjectOf6/annotation/text/@value");
        operMap.put("toHos", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/id/item/@extension");
        operMap.put("toHosId", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/id/item/@extension");
        operMap.put("toHosTypeId", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/code/@code");
        operMap.put("toHosTypeName", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/code/displayName/@value");
        operMap.put("toHosTime", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/effectiveTime/low/@value");
        operMap.put("areaId", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/subject/patient/id/item/@extension");
        operMap.put("PatientId", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/subject/patient/id/item/@extension");
        operMap.put("outPatientId", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/subject/patient/id/item/@extension");
        operMap.put("VisitId", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/subject/patient/id/item/@extension");
        operMap.put("menID", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/subject/patient/patientPerson/id/item/@extension");
        operMap.put("yiBaokaId", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/subject/patient/patientPerson/id/item/@extension");
        operMap.put("patientName", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/subject/patient/patientPerson/name/item/part/@value");
        operMap.put("patientPhoneNum", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/subject/patient/patientPerson/telecom/@value");
        operMap.put("sexId", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/subject/patient/patientPerson/administrativeGenderCode/@code");
        operMap.put("sexName", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/subject/patient/patientPerson/administrativeGenderCode/displayName/@value");
        operMap.put("birthTime", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/subject/patient/patientPerson/birthTime/@value");
        operMap.put("age", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/subject/patient/patientPerson/birthTime/originalText/@value");
        operMap.put("address", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/subject/patient/patientPerson/addr/item/part/@value");
        operMap.put("bedId", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/location/serviceDeliveryLocation/location/id/item/@extension");
        operMap.put("bedName", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/location/serviceDeliveryLocation/location/name");
        operMap.put("patRoomId", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/location/serviceDeliveryLocation/location/asLocatedEntityPartOf/location/id/item/@extension");
        operMap.put("patRoomName", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/location/serviceDeliveryLocation/location/asLocatedEntityPartOf/location/name");
        operMap.put("DeptId", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/location/serviceDeliveryLocation/serviceProviderOrganization/id/item/@extension");
        operMap.put("DeptName", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/location/serviceDeliveryLocation/serviceProviderOrganization/name/item/part/@value");
        operMap.put("bingQuId", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/location/serviceDeliveryLocation/serviceProviderOrganization/asOrganizationPartOf/wholeOrganization/id/item/@extension");
        operMap.put("bingQuName", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/location/serviceDeliveryLocation/serviceProviderOrganization/asOrganizationPartOf/wholeOrganization/name");
        operMap.put("zhengDuan", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/pertinentInformation1");
        operMap.put("zhengDuanTypeId", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/pertinentInformation1/observationDx/code/@code");
        operMap.put("zhengDuanTypeName", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/pertinentInformation1/observationDx/code/displayName/@value");
        operMap.put("JiBingId", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/pertinentInformation1/observationDx/value/@code");
        operMap.put("JiBingName", "/controlActProcess/subject/procedureRequest/componentOf1/encounter/pertinentInformation1/observationDx/value/displayName/@value");

        

    }



}
