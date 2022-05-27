package cn.medigical.publish.interfaces.his.hishezhouguangji.segment;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.v24.datatype.ID;
import ca.uhn.hl7v2.model.v24.datatype.SI;
import ca.uhn.hl7v2.model.v24.datatype.ST;
import ca.uhn.hl7v2.parser.ModelClassFactory;

public class Z02 extends AbstractSegment {

    public Z02(Group parent, ModelClassFactory factory) {
        super(parent, factory);
        this.init(factory);
    }

    private void init(ModelClassFactory factory) {
        try {
            this.add(SI.class, true, 1, 1, new Object[]{this.getMessage()}, "设置ID(Set ID – Z02)");
            this.add(ID.class, true, 1, 4, new Object[]{this.getMessage()}, "主手术申请流水号");
            this.add(ID.class, false, 1, 180, new Object[]{this.getMessage()}, "次手术编码");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "次手术名称");
        } catch (HL7Exception var3) {
            log.error("Unexpected error creating MSH - this is probably a bug in the source code generator.", var3);
        }

    }

    public SI getSettingID(){
        return this.getTypedField(1, 0);
    }

    public ID getMainOperationApplicationFlowNumber(){
        return this.getTypedField(2, 0);
    }

    public ID getSecondaryOperationCoding(){
        return this.getTypedField(3, 0);
    }

    public ST getNameOfSecondaryOperation(){
        return this.getTypedField(4, 0);
    }

    @Override
    protected Type createNewTypeWithoutReflection(int field) {
        switch(field) {
            case 0:
                return new SI(this.getMessage());
            case 1:
                return new ID(this.getMessage());
            case 2:
                return new ID(this.getMessage());
            case 3:
                return new ST(this.getMessage());
            default:
                return null;
        }
    }
}
