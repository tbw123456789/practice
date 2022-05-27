package cn.medigical.publish.interfaces.his.hishezhouguangji.segment;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.v24.datatype.ST;
import ca.uhn.hl7v2.parser.ModelClassFactory;

public class ZM02 extends AbstractSegment {

    public ZM02(Group parent, ModelClassFactory factory) {
        super(parent, factory);
        this.init(factory);
    }

    private void init(ModelClassFactory factory) {
        try {
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "事件编号");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "事件名称");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "发生时间");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "事件类型");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "用药时机");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "手术编号");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "患者ID");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "住院次数");
        } catch (HL7Exception var3) {
            log.error("Unexpected error creating MSH - this is probably a bug in the source code generator.", var3);
        }

    }

    public ST getEventNumber(){
        return this.getTypedField(1, 0);
    }

    public ST getEventName(){
        return this.getTypedField(2, 0);
    }

    public ST getTimeOccurrence(){
        return this.getTypedField(3, 0);
    }

    public ST getEventType(){
        return this.getTypedField(4, 0);
    }

    public ST getTimingMedication(){
        return this.getTypedField(5, 0);
    }

    public ST getOperationNumber(){
        return this.getTypedField(6, 0);
    }

    public ST getPatientID(){
        return this.getTypedField(7, 0);
    }

    public ST getNumberHospitalizations(){
        return this.getTypedField(8, 0);
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
                return new ST(this.getMessage());
            default:
                return null;
        }
    }
}
