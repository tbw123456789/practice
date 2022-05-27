package cn.medigical.publish.interfaces.his.hishezhouguangji.segment;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.v24.datatype.ID;
import ca.uhn.hl7v2.model.v24.datatype.NM;
import ca.uhn.hl7v2.model.v24.datatype.ST;
import ca.uhn.hl7v2.parser.ModelClassFactory;

public class ZD13 extends AbstractSegment {

    public ZD13(Group parent, ModelClassFactory factory) {
        super(parent, factory);
        this.init(factory);
    }

    private void init(ModelClassFactory factory) {
        try {
            this.add(NM.class, true, 1, 1, new Object[]{this.getMessage()}, "申请id");
            this.add(NM.class, true, 1, 4, new Object[]{this.getMessage()}, "紧急标志");
            this.add(NM.class, false, 1, 180, new Object[]{this.getMessage()}, "病人id");
            this.add(NM.class, false, 1, 180, new Object[]{this.getMessage()}, "就诊标识");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "检验内容");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "检查部位方法");
            this.add(ID.class, true, 1, 180, new Object[]{this.getMessage()}, "申请单状态");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "开单科室编码");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "开单人编码");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "执行科室编码");
            this.add(ST.class, true, 1, 26, new Object[]{this.getMessage()}, "报告审核人");
            this.add(ST.class, false, 1, 40, new Object[]{this.getMessage()}, "报告审核时间");
        } catch (HL7Exception var3) {
            log.error("Unexpected error creating MSH - this is probably a bug in the source code generator.", var3);
        }

    }

    public NM getApplicationId(){
        return this.getTypedField(1, 0);
    }

    public NM getEmergencySigns(){
        return this.getTypedField(2, 0);
    }

    public NM getPatientIdentificationList(){
        return this.getTypedField(3, 0);
    }

    public NM getVisitingSigns(){
        return this.getTypedField(4, 0);
    }

    public ST getInspectionContent(){
        return this.getTypedField(5, 0);
    }

    public ST getSpecimenSite(){
        return this.getTypedField(6, 0);
    }

    public ID getApplicationFormStatus(){
        return this.getTypedField(7, 0);
    }

    public ST getCodingOfSingleDepartment(){
        return this.getTypedField(8, 0);
    }

    public ST getBillboardCoding(){
        return this.getTypedField(9, 0);
    }

    public ST getExecutiveSectionCoding(){
        return this.getTypedField(10, 0);
    }

    public ST getReportAuditor(){
        return this.getTypedField(11, 0);
    }

    public ST getReportReviewTime(){
        return this.getTypedField(12, 0);
    }

    @Override
    protected Type createNewTypeWithoutReflection(int field) {
        switch(field) {
            case 0:
                return new NM(this.getMessage());
            case 1:
                return new NM(this.getMessage());
            case 2:
                return new NM(this.getMessage());
            case 3:
                return new NM(this.getMessage());
            case 4:
                return new ST(this.getMessage());
            case 5:
                return new ST(this.getMessage());
            case 6:
                return new ID(this.getMessage());
            case 7:
                return new ST(this.getMessage());
            case 8:
                return new ST(this.getMessage());
            case 9:
                return new ST(this.getMessage());
            case 10:
                return new ST(this.getMessage());
            case 11:
                return new ST(this.getMessage());
            default:
                return null;
        }
    }
}