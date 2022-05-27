package cn.medigical.publish.interfaces.his.hishezhouguangji.segment;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.v24.datatype.ID;
import ca.uhn.hl7v2.model.v24.datatype.ST;
import ca.uhn.hl7v2.parser.ModelClassFactory;

public class ZM01 extends AbstractSegment {

    public ZM01(Group parent, ModelClassFactory factory) {
        super(parent, factory);
        this.init(factory);
    }

    private void init(ModelClassFactory factory) {
        try {
            this.add(ID.class, true, 1, 25, new Object[]{this.getMessage()}, "手术流水号");
            this.add(ID.class, true, 1, 25, new Object[]{this.getMessage()}, "患者ID");
            this.add(ID.class, true, 1, 25, new Object[]{this.getMessage()}, "住院次数");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术编号");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术代码");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术名称");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术操作日期");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术操作方法");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "是否再次手术");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术级别");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术术前诊断");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术科室");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "床号");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术医生");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "第一手术助手");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "第二手术助手");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "第三手术助手");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "第四手术助手");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "麻醉方式");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "麻醉医生");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "麻醉医师2");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "麻醉医师3");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "麻醉助手");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "麻醉助手2");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "麻醉助手3");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "麻醉助手4");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "第一台上护士");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "第二台上护士");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "第一供应护士");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "第二供应护士");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "第一器械护士");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "第二器械护士");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "拟行有创操作和监测方法");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "拟施麻醉方法代码");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "患者基础疾病");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "是否使用镇痛泵");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "开始时间");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "结束时间");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术时长");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "ASA分级");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术切口类型");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "中西医标识");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "输血者");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "NNIS分级");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "切口愈合等级");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "切口部位");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "是否非预期的二次手术");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "择期急诊");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术位置");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "植入物");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "内镜手术");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术室");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术间");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "台次");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "隔离标志");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "失血量");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "输血量");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "备皮方式");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "备皮时间");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "申请日期及时间");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "录入者");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术单号");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "是否非预期重返手术室");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术风险评估");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术部位类别");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术描述");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "入手术室时间");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "出手术室时间");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "麻醉开始时间");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "麻醉结束时间");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术开始时间");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术结束时间");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "是否体外循环");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "是否术中异物遗留");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术是否成功");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "是否术中死亡");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术安全核查");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "麻醉效果");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "麻醉药品");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "剂量");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "计量单位");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "用法");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "steward评分");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "心肺复苏(单选)");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "进入PAVU");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "术后镇痛");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "是否术前访视");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "是否术后访视");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "术后气管插管拔除");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "入PAVU时间");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "出PAVU时间");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "PACU入室体温");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "麻醉开始后取消手术");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "非计划转入ICU");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "术后转入ICU");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "术中自体血输注");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "自体血输注量");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "已施手术");
        } catch (HL7Exception var3) {
            log.error("Unexpected error creating MSH - this is probably a bug in the source code generator.", var3);
        }

    }

    public ID getSurgerySerialNumber(){
        return this.getTypedField(1, 0);
    }

    public ID getPatientID(){
        return this.getTypedField(2, 0);
    }

    public ID getNumberOfHospitalizations(){
        return this.getTypedField(3, 0);
    }

    public ST getOperationNumber(){
        return this.getTypedField(4, 0);
    }

    public ST getOperationCode(){
        return this.getTypedField(5, 0);
    }

    public ST getNameOfOperation(){
        return this.getTypedField(6, 0);
    }

    public ST getOperationDate(){
        return this.getTypedField(7, 0);
    }

    public ST getOperationMethod(){
        return this.getTypedField(8, 0);
    }

    public ST getWhetherToOperateAgain(){
        return this.getTypedField(9, 0);
    }

    public ST getSurgicalGrade(){
        return this.getTypedField(10, 0);
    }

    public ST getPreoperativeDiagnosis(){
        return this.getTypedField(11, 0);
    }

    public ST getApplyDept(){
        return this.getTypedField(12, 0);
    }

    public ST getBedNo(){
        return this.getTypedField(13, 0);
    }

    public ST getSurgeryDoctor(){
        return this.getTypedField(14, 0);
    }

    public ST getFirstSurgicalAssistant(){
        return this.getTypedField(15, 0);
    }

    public ST getSecondSurgicalAssistant(){
        return this.getTypedField(16, 0);
    }

    public ST getThirdSurgicalAssistant(){
        return this.getTypedField(17, 0);
    }

    public ST getFourthSurgicalAssistant(){
        return this.getTypedField(18, 0);
    }

    public ST getAnesthesia(){
        return this.getTypedField(19, 0);
    }

    public ST getAnesthesiologist(){
        return this.getTypedField(20, 0);
    }

    public ST getAnesthesiologist2(){
        return this.getTypedField(21, 0);
    }

    public ST getAnesthesiologist3(){
        return this.getTypedField(22, 0);
    }

    public ST getAnesthesiaAssistant(){
        return this.getTypedField(23, 0);
    }

    public ST getAnesthesiaAssistant2(){
        return this.getTypedField(24, 0);
    }

    public ST getAnesthesiaAssistant3(){
        return this.getTypedField(25, 0);
    }

    public ST getAnesthesiaAssistant4(){
        return this.getTypedField(26, 0);
    }

    public ST getNurseOnTheFirstStage(){
        return this.getTypedField(27, 0);
    }

    public ST getNurseOnTheSecondStage(){
        return this.getTypedField(28, 0);
    }

    public ST getFirstSupplyNurse(){
        return this.getTypedField(29, 0);
    }

    public ST getSecondSupplyNurse(){
        return this.getTypedField(30, 0);
    }

    public ST getFirstEquipmentNurse(){
        return this.getTypedField(31, 0);
    }

    public ST getSecondEquipmentNurse(){
        return this.getTypedField(32, 0);
    }

    public ST getProposedInvasiveOperation(){
        return this.getTypedField(33, 0);
    }

    public ST getCodeOfProposedAnesthesiaMethod(){
        return this.getTypedField(34, 0);
    }

    public ST getPatientUnderlyingDisease(){
        return this.getTypedField(35, 0);
    }

    public ST getWhetherToUseAnAnalgesicPump(){
        return this.getTypedField(36, 0);
    }

    public ST getStartingTime(){
        return this.getTypedField(37, 0);
    }

    public ST getEndTime(){
        return this.getTypedField(38, 0);
    }

    public ST getLengthOfOperation(){
        return this.getTypedField(39, 0);
    }

    public ST getASARating(){
        return this.getTypedField(40, 0);
    }

    public ST getSurgicalIncisionType(){
        return this.getTypedField(41, 0);
    }

    public ST getChineseAndWesternMedicineLogo(){
        return this.getTypedField(42, 0);
    }

    public ST getBloodTransfusionNumber(){
        return this.getTypedField(43, 0);
    }

    public ST getNNISClassification(){
        return this.getTypedField(44, 0);
    }

    public ST getIncisionHealingGrade(){
        return this.getTypedField(45, 0);
    }

    public ST getIncisionSite(){
        return this.getTypedField(46, 0);
    }

    public ST getWhetherSecondOperUnexpected(){
        return this.getTypedField(47, 0);
    }

    public ST getElectiveEmergency(){
        return this.getTypedField(48, 0);
    }

    public ST getSurgicalLocation(){
        return this.getTypedField(49, 0);
    }

    public ST getImplants(){
        return this.getTypedField(50, 0);
    }

    public ST getEndoscopicSurgery(){
        return this.getTypedField(51, 0);
    }

    public ST getOperatingRoom(){
        return this.getTypedField(52, 0);
    }

    public ST getOperatingRoomNum(){
        return this.getTypedField(53, 0);
    }

    public ST getTaiwan(){
        return this.getTypedField(54, 0);
    }

    public ST getIsolationSign(){
        return this.getTypedField(55, 0);
    }

    public ST getBloodLoss(){
        return this.getTypedField(56, 0);
    }

    public ST getBloodTransfusion(){
        return this.getTypedField(57, 0);
    }

    public ST getSkinPreparationMethod(){
        return this.getTypedField(58, 0);
    }

    public ST getSkinPreparationTime(){
        return this.getTypedField(59, 0);
    }

    public ST getApplicationDateAndTime(){
        return this.getTypedField(60, 0);
    }

    public ST getEntrant(){
        return this.getTypedField(61, 0);
    }

    public ST getSurgicalOrderNumber(){
        return this.getTypedField(62, 0);
    }

    public ST getReturnOpeRoomUnexpectedly(){
        return this.getTypedField(63, 0);
    }

    public ST getSurgicalRiskAssessment(){
        return this.getTypedField(64, 0);
    }

    public ST getSurgicalSiteCategory(){
        return this.getTypedField(65, 0);
    }

    public ST getOperationDescription(){
        return this.getTypedField(66, 0);
    }

    public ST getTimeEnterOperatingRoom(){
        return this.getTypedField(67, 0);
    }

    public ST getTimeOutOperatingRoom(){
        return this.getTypedField(68, 0);
    }

    public ST getAnesthesiaStartTime(){
        return this.getTypedField(69, 0);
    }

    public ST getEndOfAnesthesiaTime(){
        return this.getTypedField(70, 0);
    }

    public ST getSurgeryStartTime(){
        return this.getTypedField(71, 0);
    }

    public ST getSurgeryEndTime(){
        return this.getTypedField(72, 0);
    }

    public ST getCardiopulmonaryBypass(){
        return this.getTypedField(73, 0);
    }

    public ST getRemainsDuringOperation(){
        return this.getTypedField(74, 0);
    }

    public ST getOperationWasSuccessful(){
        return this.getTypedField(75, 0);
    }

    public ST getDiedDuringOperation(){
        return this.getTypedField(76, 0);
    }

    public ST getSurgicalSafetyCheck(){
        return this.getTypedField(77, 0);
    }

    public ST getAnesthesiaEffect(){
        return this.getTypedField(78, 0);
    }

    public ST getNarcoticDrugs(){
        return this.getTypedField(79, 0);
    }

    public ST getDose(){
        return this.getTypedField(80, 0);
    }

    public ST getDoseUnite(){
        return this.getTypedField(81, 0);
    }

    public ST getUsage(){
        return this.getTypedField(82, 0);
    }

    public ST getstewardScore(){
        return this.getTypedField(83, 0);
    }

    public ST getCardiopulmonaryResuscitation(){
        return this.getTypedField(84, 0);
    }

    public ST getEnterPAVU(){
        return this.getTypedField(85, 0);
    }

    public ST getPostoperativeAnalgesia(){
        return this.getTypedField(86, 0);
    }

    public ST getVisitBeforeSurgery(){
        return this.getTypedField(87, 0);
    }

    public ST getVisitAfterSurgery(){
        return this.getTypedField(88, 0);
    }

    public ST getPostoperativeTrachealIntubationRemoval(){
        return this.getTypedField(89, 0);
    }

    public ST getTimeEnterPAVU(){
        return this.getTypedField(90, 0);
    }

    public ST getTimeOutPAVU(){
        return this.getTypedField(91, 0);
    }

    public ST getPACUEntryTemperature(){
        return this.getTypedField(92, 0);
    }

    public ST getCancelOperationAfterAnesthesiStarts(){
        return this.getTypedField(93, 0);
    }

    public ST getUnplannedTransferICU(){
        return this.getTypedField(94, 0);
    }

    public ST getTransferICUAfterSurgery(){
        return this.getTypedField(95, 0);
    }

    public ST getIntraoperativeAutologousBloodTransfusion(){
        return this.getTypedField(96, 0);
    }

    public ST getAutologousBloodTransfusion(){
        return this.getTypedField(97, 0);
    }

    public ST getSurgery(){
        return this.getTypedField(98, 0);
    }

    @Override
    protected Type createNewTypeWithoutReflection(int field) {
        switch(field) {
            case 0:
            case 1:
            case 2:
                return new ID(this.getMessage());
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 75:
            case 76:
            case 77:
            case 78:
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
                return new ST(this.getMessage());
            default:
                return null;
        }
    }
}