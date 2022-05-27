package cn.medigical.publish.interfaces.his.hishezhouguangji.segment;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.v24.datatype.*;
import ca.uhn.hl7v2.parser.ModelClassFactory;

public class Z01 extends AbstractSegment {

    public Z01(Group parent, ModelClassFactory factory) {
        super(parent, factory);
        this.init(factory);
    }

    private void init(ModelClassFactory factory) {
        try {
            this.add(ID.class, true, 1, 1, new Object[]{this.getMessage()}, "手术流水号");
            this.add(ID.class, true, 1, 4, new Object[]{this.getMessage()}, "手术代码");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术名称");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术等级");
            this.add(ID.class, false, 1, 180, new Object[]{this.getMessage()}, "手术标志");
            this.add(OD.class, false, 1, 180, new Object[]{this.getMessage()}, "手术申请状态");
            this.add(CX.class, true, 1, 26, new Object[]{this.getMessage()}, "患者标识列表");
            this.add(TS.class, false, 1, 40, new Object[]{this.getMessage()}, "手术日期及时间");
            this.add(CE.class, true, 1, 15, new Object[]{this.getMessage()}, "手术室");
            this.add(ST.class, true, 1, 20, new Object[]{this.getMessage()}, "手术间");
            this.add(TQ.class, true, 1, 3, new Object[]{this.getMessage()}, "台次");
            this.add(ID.class, true, 1, 60, new Object[]{this.getMessage()}, "隔离标志");
            this.add(PL.class, false, 1, 15, new Object[]{this.getMessage()}, "手术科室");
            this.add(XCN.class, false, 1, 180, new Object[]{this.getMessage()}, "手术者");
            this.add(XCN.class, false, 1, 2, new Object[]{this.getMessage()}, "第一手术助手");
            this.add(XCN.class, false, 1, 2, new Object[]{this.getMessage()}, "第二手术助手");
            this.add(XCN.class, false, 1, 3, new Object[]{this.getMessage()}, "第三手术助手");
            this.add(XCN.class, false, 0, 16, new Object[]{this.getMessage()}, "第四手术助手");
            this.add(ST.class, false, 1, 250, new Object[]{this.getMessage()}, "麻醉方法");
            this.add(XCN.class, false, 1, 20, new Object[]{this.getMessage()}, "麻醉医师");
            this.add(XCN.class, false, 0, 10, new Object[]{this.getMessage()}, "麻醉医师2");
            this.add(XCN.class, false, 0, 10, new Object[]{this.getMessage()}, "麻醉医师3");
            this.add(XCN.class, false, 0, 10, new Object[]{this.getMessage()}, "麻醉助手");
            this.add(XCN.class, false, 0, 10, new Object[]{this.getMessage()}, "麻醉助手2");
            this.add(XCN.class, false, 0, 10, new Object[]{this.getMessage()}, "麻醉助手3");
            this.add(XCN.class, false, 0, 10, new Object[]{this.getMessage()}, "麻醉助手4");
            this.add(XCN.class, false, 0, 10, new Object[]{this.getMessage()}, "输血者");
            this.add(XCN.class, false, 0, 10, new Object[]{this.getMessage()}, "第一台上护士");
            this.add(XCN.class, false, 0, 10, new Object[]{this.getMessage()}, "第二台上护士");
            this.add(XCN.class, false, 0, 10, new Object[]{this.getMessage()}, "第一供应护士");
            this.add(XCN.class, false, 0, 10, new Object[]{this.getMessage()}, "第二供应护士");
            this.add(XCN.class, false, 0, 10, new Object[]{this.getMessage()}, "第三供应护士");
            this.add(ST.class, false, 0, 10, new Object[]{this.getMessage()}, "备注");
            this.add(TS.class, false, 0, 10, new Object[]{this.getMessage()}, "申请日期及时间");
            this.add(XCN.class, false, 0, 10, new Object[]{this.getMessage()}, "录入者");
            this.add(XCN.class, false, 0, 10, new Object[]{this.getMessage()}, "术前诊断");
            this.add(XCN.class, false, 0, 10, new Object[]{this.getMessage()}, "手术路径");
        } catch (HL7Exception var3) {
            log.error("Unexpected error creating MSH - this is probably a bug in the source code generator.", var3);
        }

    }

    public ID getOperativeFlowNumber(){
        return this.getTypedField(1, 0);
    }

    public ID getOperationCode(){
        return this.getTypedField(2, 0);
    }

    public ST getNameOfOperation(){
        return this.getTypedField(3, 0);
    }

    public ST getSurgicalGrade(){
        return this.getTypedField(4, 0);
    }

    public ID getSurgicalMarkers(){
        return this.getTypedField(5, 0);
    }

    public OD getStatusOfApplicationForOperation(){
        return this.getTypedField(6, 0);
    }

    public CX getPatientIdentificationList(){
        return this.getTypedField(7, 0);
    }

    public TS getDateAndTimeOfOperation(){
        return this.getTypedField(8, 0);
    }

    public CE getOperationRoom(){
        return this.getTypedField(9, 0);
    }

    public ST getOperatingRoom(){
        return this.getTypedField(10, 0);
    }

    public TQ getTableNumber(){
        return this.getTypedField(11, 0);
    }

    public ID getIsolationMark(){
        return this.getTypedField(12, 0);
    }

    public PL getOperatingDepartments(){
        return this.getTypedField(13, 0);
    }

    public XCN getSurgeon(){
        return this.getTypedField(14, 0);
    }

    public XCN getFirstOperativeAssistant(){
        return this.getTypedField(15, 0);
    }

    public XCN getSecondOperativeAssistant(){
        return this.getTypedField(16, 0);
    }

    public XCN getThirdOperativeAssistant(){
        return this.getTypedField(17, 0);
    }

    public XCN getFourthOperativeAssistant(){
        return this.getTypedField(18, 0);
    }

    public ST getAnesthesiaMethod(){
        return this.getTypedField(19, 0);
    }

    public XCN getAnesthesiologist(){
        return this.getTypedField(20, 0);
    }

    public XCN getAnesthesiologist2(){
        return this.getTypedField(21, 0);
    }

    public XCN getAnesthesiologist3(){
        return this.getTypedField(22, 0);
    }

    public XCN getAnesthesiaAssistant(){
        return this.getTypedField(23, 0);
    }

    public XCN getAnesthesiaAssistant2(){
        return this.getTypedField(24, 0);
    }

    public XCN getAnesthesiaAssistant3(){
        return this.getTypedField(25, 0);
    }

    public XCN getAnesthesiaAssistant4(){
        return this.getTypedField(26, 0);
    }

    public XCN getBloodDonator(){
        return this.getTypedField(27, 0);
    }

    public XCN getFirstNurseOnBoard(){
        return this.getTypedField(28, 0);
    }

    public XCN getSecondNurseOnBoard(){
        return this.getTypedField(29, 0);
    }

    public XCN getFirstSupplyNurse(){
        return this.getTypedField(30, 0);
    }

    public XCN getSecondSupplyNurse(){
        return this.getTypedField(31, 0);
    }

    public XCN getThirdSupplyNurse(){
        return this.getTypedField(32, 0);
    }

    public ST getRemarks(){
        return this.getTypedField(33, 0);
    }

    public TS getDateAndTimeOfApplication(){
        return this.getTypedField(34, 0);
    }

    public XCN getInputer(){
        return this.getTypedField(35, 0);
    }

    public XCN getPreoperativeDiagnosis(){
        return this.getTypedField(36, 0);
    }

    public XCN getOperativePath(){
        return this.getTypedField(37, 0);
    }

    @Override
    protected Type createNewTypeWithoutReflection(int field) {
        switch(field) {
            case 0:
                return new ID(this.getMessage());
            case 1:
                return new ID(this.getMessage());
            case 2:
                return new ST(this.getMessage());
            case 3:
                return new ST(this.getMessage());
            case 4:
                return new ID(this.getMessage());
            case 5:
                return new OD(this.getMessage());
            case 6:
                return new CX(this.getMessage());
            case 7:
                return new TS(this.getMessage());
            case 8:
                return new CE(this.getMessage());
            case 9:
                return new ST(this.getMessage());
            case 10:
                return new TQ(this.getMessage());
            case 11:
                return new ID(this.getMessage());
            case 12:
                return new PL(this.getMessage());
            case 13:
                return new XCN(this.getMessage());
            case 14:
                return new XCN(this.getMessage());
            case 15:
                return new XCN(this.getMessage());
            case 16:
                return new XCN(this.getMessage());
            case 17:
                return new XCN(this.getMessage());
            case 18:
                return new ST(this.getMessage());
            case 19:
                return new XCN(this.getMessage());
            case 20:
                return new XCN(this.getMessage());
            case 21:
                return new XCN(this.getMessage());
            case 22:
                return new XCN(this.getMessage());
            case 23:
                return new XCN(this.getMessage());
            case 24:
                return new XCN(this.getMessage());
            case 25:
                return new XCN(this.getMessage());
            case 26:
                return new XCN(this.getMessage());
            case 27:
                return new XCN(this.getMessage());
            case 28:
                return new XCN(this.getMessage());
            case 29:
                return new XCN(this.getMessage());
            case 30:
                return new XCN(this.getMessage());
            case 31:
                return new XCN(this.getMessage());
            case 32:
                return new ST(this.getMessage());
            case 33:
                return new TS(this.getMessage());
            case 34:
                return new XCN(this.getMessage());
            case 35:
                return new XCN(this.getMessage());
            case 36:
                return new XCN(this.getMessage());
            default:
                return null;
        }
    }

}
