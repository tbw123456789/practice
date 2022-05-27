package cn.medigical.publish.pojo.zjpa.patientLink;

import java.util.List;

public class OperationHis {
	private String applyId; //申请单编�?
	private String applyTime; //申请日期
	private String maZuiMethodId; //麻醉方式编码
	private String maZuiMethodName;//
	private String operTypeId;//手术性质编码
	private String operTypeName;//手术性质名称
	private String applyDocId;//申请医师编码
	private String applyDocName;//申请医师姓名
	private String applyDeptId;//申请科室编码
	private String applyDeptName;//申请科室名称
	private String verifierTime;//审核日期
	private String verifierId;//审核人编�?
	private String verifierName;//审核人姓�?
	private List<String> operIdList;//手术编码
	private List<String> operNameList;//手术名称
	private List<String> operLevelIdList;//手术等级编码
	private List<String> operLevelNmeList;//手术等级名称
	private List<String> operPlanTimeList;//预定手术时间
	private List<String> operDocIdList;//手术医师编码
	private List<String> operDocNameList;//手术医师名称
	private List<String> execDeptIdList;//执行科室编码	
	private List<String> execDeptNameList;//执行科室名称
	private String attention;//注意事项
	private String toHos;//就诊次数
	private String toHosId;//就诊流水�?
	private String toHosTypeId;//就诊类别编码
	private String toHosTypeName;//就诊类别名称
	private String toHosTime;//就诊（住院）日期
	private String areaId;//域ID


	private String PatientId; //患�?�id
	private String outPatientId; //门诊�?
	private String VisitId;//住院�?
	private String menID;//身份�?
	private String yiBaokaId;//医保卡号id
	private String patientName;//患�?�姓�?
	private String patientPhoneNum; //患�?�电�?
	private String sexId; //性别id
	private String sexName;//性别名称
	private String birthTime;//出生日期
	private String age;//年龄
	private String address;//地址
	private String bedId;//病床编码
	private String bedName;//病床�?
	private String patRoomId;//病房编号
	private String patRoomName;//病房�?
	private String DeptId;//科室编码
	private String DeptName;//科室名称
	private String bingQuId;//病区编码
	private String bingQuName;//病区名称
	private String zhengDuan;//诊断（手术申请原因）
	private String zhengDuanTypeId;//诊断类别编码
	private String zhengDuanTypeName;//诊断类别名称;
	private String JiBingId;//疾病编码
	private String JiBingName;//疾病名称


	public String getApplyId() {
		return applyId;
	}
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}
	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	public String getMaZuiMethodId() {
		return maZuiMethodId;
	}
	public void setMaZuiMethodId(String maZuiMethodId) {
		this.maZuiMethodId = maZuiMethodId;
	}
	public String getMaZuiMethodName() {
		return maZuiMethodName;
	}
	public void setMaZuiMethodName(String maZuiMethodName) {
		this.maZuiMethodName = maZuiMethodName;
	}
	public String getOperTypeId() {
		return operTypeId;
	}
	public void setOperTypeId(String operTypeId) {
		this.operTypeId = operTypeId;
	}
	public String getOperTypeName() {
		return operTypeName;
	}
	public void setOperTypeName(String operTypeName) {
		this.operTypeName = operTypeName;
	}
	public String getApplyDocId() {
		return applyDocId;
	}
	public void setApplyDocId(String applyDocId) {
		this.applyDocId = applyDocId;
	}
	public String getApplyDocName() {
		return applyDocName;
	}
	public void setApplyDocName(String applyDocName) {
		this.applyDocName = applyDocName;
	}
	public String getApplyDeptId() {
		return applyDeptId;
	}
	public void setApplyDeptId(String applyDeptId) {
		this.applyDeptId = applyDeptId;
	}
	public String getApplyDeptName() {
		return applyDeptName;
	}
	public void setApplyDeptName(String applyDeptName) {
		this.applyDeptName = applyDeptName;
	}
	public String getVerifierTime() {
		return verifierTime;
	}
	public void setVerifierTime(String verifierTime) {
		this.verifierTime = verifierTime;
	}
	public String getVerifierId() {
		return verifierId;
	}
	public void setVerifierId(String verifierId) {
		this.verifierId = verifierId;
	}
	public String getVerifierName() {
		return verifierName;
	}
	public void setVerifierName(String verifierName) {
		this.verifierName = verifierName;
	}
	public List<String> getOperIdList() {
		return operIdList;
	}
	public void setOperIdList(List<String> operIdList) {
		this.operIdList = operIdList;
	}
	public List<String> getOperNameList() {
		return operNameList;
	}
	public void setOperNameList(List<String> operNameList) {
		this.operNameList = operNameList;
	}
	public List<String> getOperLevelIdList() {
		return operLevelIdList;
	}
	public void setOperLevelIdList(List<String> operLevelIdList) {
		this.operLevelIdList = operLevelIdList;
	}
	public List<String> getOperLevelNmeList() {
		return operLevelNmeList;
	}
	public void setOperLevelNmeList(List<String> operLevelNmeList) {
		this.operLevelNmeList = operLevelNmeList;
	}
	public List<String> getOperPlanTimeList() {
		return operPlanTimeList;
	}
	public void setOperPlanTimeList(List<String> operPlanTimeList) {
		this.operPlanTimeList = operPlanTimeList;
	}
	public List<String> getOperDocIdList() {
		return operDocIdList;
	}
	public void setOperDocIdList(List<String> operDocIdList) {
		this.operDocIdList = operDocIdList;
	}
	public List<String> getOperDocNameList() {
		return operDocNameList;
	}
	public void setOperDocNameList(List<String> operDocNameList) {
		this.operDocNameList = operDocNameList;
	}
	public List<String> getExecDeptIdList() {
		return execDeptIdList;
	}
	public void setExecDeptIdList(List<String> execDeptIdList) {
		this.execDeptIdList = execDeptIdList;
	}
	public List<String> getExecDeptNameList() {
		return execDeptNameList;
	}
	public void setExecDeptNameList(List<String> execDeptNameList) {
		this.execDeptNameList = execDeptNameList;
	}
	public String getAttention() {
		return attention;
	}
	public void setAttention(String attention) {
		this.attention = attention;
	}
	public String getToHos() {
		return toHos;
	}
	public void setToHos(String toHos) {
		this.toHos = toHos;
	}
	public String getToHosId() {
		return toHosId;
	}
	public void setToHosId(String toHosId) {
		this.toHosId = toHosId;
	}
	public String getToHosTypeId() {
		return toHosTypeId;
	}
	public void setToHosTypeId(String toHosTypeId) {
		this.toHosTypeId = toHosTypeId;
	}
	public String getToHosTypeName() {
		return toHosTypeName;
	}
	public void setToHosTypeName(String toHosTypeName) {
		this.toHosTypeName = toHosTypeName;
	}
	public String getToHosTime() {
		return toHosTime;
	}
	public void setToHosTime(String toHosTime) {
		this.toHosTime = toHosTime;
	}
	public String getAreaId() {
		return areaId;
	}
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}
	public String getPatientId() {
		return PatientId;
	}
	public void setPatientId(String patientId) {
		PatientId = patientId;
	}
	public String getOutPatientId() {
		return outPatientId;
	}
	public void setOutPatientId(String outPatientId) {
		this.outPatientId = outPatientId;
	}
	public String getVisitId() {
		return VisitId;
	}
	public void setVisitId(String visitId) {
		VisitId = visitId;
	}
	public String getMenID() {
		return menID;
	}
	public void setMenID(String menID) {
		this.menID = menID;
	}
	public String getYiBaokaId() {
		return yiBaokaId;
	}
	public void setYiBaokaId(String yiBaokaId) {
		this.yiBaokaId = yiBaokaId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientPhoneNum() {
		return patientPhoneNum;
	}
	public void setPatientPhoneNum(String patientPhoneNum) {
		this.patientPhoneNum = patientPhoneNum;
	}
	public String getSexId() {
		return sexId;
	}
	public void setSexId(String sexId) {
		this.sexId = sexId;
	}
	public String getSexName() {
		return sexName;
	}
	public void setSexName(String sexName) {
		this.sexName = sexName;
	}
	public String getBirthTime() {
		return birthTime;
	}
	public void setBirthTime(String birthTime) {
		this.birthTime = birthTime;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBedId() {
		return bedId;
	}
	public void setBedId(String bedId) {
		this.bedId = bedId;
	}
	public String getBedName() {
		return bedName;
	}
	public void setBedName(String bedName) {
		this.bedName = bedName;
	}
	public String getPatRoomId() {
		return patRoomId;
	}
	public void setPatRoomId(String patRoomId) {
		this.patRoomId = patRoomId;
	}
	public String getPatRoomName() {
		return patRoomName;
	}
	public void setPatRoomName(String patRoomName) {
		this.patRoomName = patRoomName;
	}
	public String getDeptId() {
		return DeptId;
	}
	public void setDeptId(String deptId) {
		DeptId = deptId;
	}
	public String getDeptName() {
		return DeptName;
	}
	public void setDeptName(String deptName) {
		DeptName = deptName;
	}
	public String getBingQuId() {
		return bingQuId;
	}
	public void setBingQuId(String bingQuId) {
		this.bingQuId = bingQuId;
	}
	public String getBingQuName() {
		return bingQuName;
	}
	public void setBingQuName(String bingQuName) {
		this.bingQuName = bingQuName;
	}
	public String getZhengDuan() {
		return zhengDuan;
	}
	public void setZhengDuan(String zhengDuan) {
		this.zhengDuan = zhengDuan;
	}
	public String getZhengDuanTypeId() {
		return zhengDuanTypeId;
	}
	public void setZhengDuanTypeId(String zhengDuanTypeId) {
		this.zhengDuanTypeId = zhengDuanTypeId;
	}
	public String getZhengDuanTypeName() {
		return zhengDuanTypeName;
	}
	public void setZhengDuanTypeName(String zhengDuanTypeName) {
		this.zhengDuanTypeName = zhengDuanTypeName;
	}
	public String getJiBingId() {
		return JiBingId;
	}
	public void setJiBingId(String jiBingId) {
		JiBingId = jiBingId;
	}
	public String getJiBingName() {
		return JiBingName;
	}
	public void setJiBingName(String jiBingName) {
		JiBingName = jiBingName;
	}
	@Override
	public String toString() {
		return "OperationHis [applyId=" + applyId + ", applyTime=" + applyTime + ", maZuiMethodId=" + maZuiMethodId
				+ ", maZuiMethodName=" + maZuiMethodName + ", operTypeId=" + operTypeId + ", operTypeName="
				+ operTypeName + ", applyDocId=" + applyDocId + ", applyDocName=" + applyDocName + ", applyDeptId="
				+ applyDeptId + ", applyDeptName=" + applyDeptName + ", verifierTime=" + verifierTime + ", verifierId="
				+ verifierId + ", verifierName=" + verifierName + ", operIdList=" + operIdList + ", operNameList="
				+ operNameList + ", operLevelIdList=" + operLevelIdList + ", operLevelNmeList=" + operLevelNmeList
				+ ", operPlanTimeList=" + operPlanTimeList + ", operDocIdList=" + operDocIdList + ", operDocNameList="
				+ operDocNameList + ", execDeptIdList=" + execDeptIdList + ", execDeptNameList=" + execDeptNameList
				+ ", attention=" + attention + ", toHos=" + toHos + ", toHosId=" + toHosId + ", toHosTypeId="
				+ toHosTypeId + ", toHosTypeName=" + toHosTypeName + ", toHosTime=" + toHosTime + ", areaId=" + areaId
				+ ", PatientId=" + PatientId + ", outPatientId=" + outPatientId + ", VisitId=" + VisitId + ", menID="
				+ menID + ", yiBaokaId=" + yiBaokaId + ", patientName=" + patientName + ", patientPhoneNum="
				+ patientPhoneNum + ", sexId=" + sexId + ", sexName=" + sexName + ", birthTime=" + birthTime + ", age="
				+ age + ", address=" + address + ", bedId=" + bedId + ", bedName=" + bedName + ", patRoomId="
				+ patRoomId + ", patRoomName=" + patRoomName + ", DeptId=" + DeptId + ", DeptName=" + DeptName
				+ ", bingQuId=" + bingQuId + ", bingQuName=" + bingQuName + ", zhengDuan=" + zhengDuan
				+ ", zhengDuanTypeId=" + zhengDuanTypeId + ", zhengDuanTypeName=" + zhengDuanTypeName + ", JiBingId="
				+ JiBingId + ", JiBingName=" + JiBingName + "]";
	}
	
}
