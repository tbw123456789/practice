package cn.medigical.publish.interfaces.his.hishezhouguangji.segment;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.v24.datatype.ST;
import ca.uhn.hl7v2.parser.ModelClassFactory;

public class ZM03 extends AbstractSegment {

    public ZM03(Group parent, ModelClassFactory factory) {
        super(parent, factory);
        this.init(factory);
    }

    private void init(ModelClassFactory factory) {
        try {
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "麻醉用药编码");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "麻醉药品名称");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "剂量");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "计量单位");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "用法");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "剂型");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术编号");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "患者ID");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "住院次数");
        } catch (HL7Exception var3) {
            log.error("Unexpected error creating MSH - this is probably a bug in the source code generator.", var3);
        }

    }

    public ST getAnesthesiaMedicationCode(){
        return this.getTypedField(1, 0);
    }

    public ST getNameOfNarcoticDrug(){
        return this.getTypedField(2, 0);
    }

    public ST getTimeOccurrence(){
        return this.getTypedField(3, 0);
    }

    public ST getDose(){
        return this.getTypedField(4, 0);
    }

    public ST getUnitOfMeasurement(){
        return this.getTypedField(5, 0);
    }

    public ST getUsage(){
        return this.getTypedField(6, 0);
    }

    public ST getDosageForm(){return this.getTypedField(7, 0);}

    public ST getPatientID(){
        return this.getTypedField(8, 0);
    }

    public ST getNumberHospitalizations(){
        return this.getTypedField(9, 0);
    }

    @Override
    protected Type createNewTypeWithoutReflection(int field) {
        switch(field) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return new ST(this.getMessage());
            default:
                return null;
        }
    }
}
