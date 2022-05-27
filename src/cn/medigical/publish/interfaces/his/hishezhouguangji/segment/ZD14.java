package cn.medigical.publish.interfaces.his.hishezhouguangji.segment;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.v24.datatype.*;
import ca.uhn.hl7v2.model.v25.datatype.DTM;
import ca.uhn.hl7v2.parser.ModelClassFactory;

public class ZD14 extends AbstractSegment {

    public ZD14(Group parent, ModelClassFactory factory) {
        super(parent, factory);
        this.init(factory);
    }

    private void init(ModelClassFactory factory) {
        try {
            this.add(SI.class, true, 1, 1, new Object[]{this.getMessage()}, "设置ID");
            this.add(ID.class, true, 1, 4, new Object[]{this.getMessage()}, "值类型");
            this.add(CWE.class, false, 1, 180, new Object[]{this.getMessage()}, "观察标识符");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "观察子项");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "观察值");
            this.add(CE.class, false, 1, 180, new Object[]{this.getMessage()}, "结果值单位");
            this.add(ST.class, true, 1, 26, new Object[]{this.getMessage()}, "参考区间");
            this.add(CWE.class, false, 1, 40, new Object[]{this.getMessage()}, "异常标志");
            this.add(ID.class, false, 1, 180, new Object[]{this.getMessage()}, "补齐位");
            this.add(ID.class, true, 1, 26, new Object[]{this.getMessage()}, "补齐位");
            this.add(ID.class, true, 1, 1, new Object[]{this.getMessage()}, "观察结果状态");
            this.add(ID.class, false, 1, 40, new Object[]{this.getMessage()}, "补齐位");
            this.add(ID.class, false, 1, 180, new Object[]{this.getMessage()}, "补齐位");
            this.add(ID.class, true, 1, 26, new Object[]{this.getMessage()}, "补齐位");
            this.add(ID.class, false, 1, 40, new Object[]{this.getMessage()}, "补齐位");
            this.add(XCN.class, true, 1, 4, new Object[]{this.getMessage()}, "观察负责人");
            this.add(CWE.class, false, 1, 180, new Object[]{this.getMessage()}, "补齐位");
            this.add(EI.class, false, 1, 180, new Object[]{this.getMessage()}, "补齐位");
            this.add(DTM.class, false, 1, 180, new Object[]{this.getMessage()}, "分析日期/时间");
        } catch (HL7Exception var3) {
            log.error("Unexpected error creating MSH - this is probably a bug in the source code generator.", var3);
        }

    }

    public SI getSettingID(){
        return this.getTypedField(1, 0);
    }

    public ID getValueType(){
        return this.getTypedField(2, 0);
    }

    public CWE getObservationIdentifier(){
        return this.getTypedField(3, 0);
    }

    public ST getObservationSubitem(){
        return this.getTypedField(4, 0);
    }

    public ST getObservationValue(){
        return this.getTypedField(5, 0);
    }

    public CE getResultValueUnit(){
        return this.getTypedField(6, 0);
    }

    public ST getReferenceInterval(){
        return this.getTypedField(7, 0);
    }

    public CWE getAbnormalMarkers(){
        return this.getTypedField(8, 0);
    }

    public ID getObservationStatus(){
        return this.getTypedField(11, 0);
    }

    public XCN getAbnormalMarkersHeadOfObservation(){
        return this.getTypedField(16, 0);
    }

    public DTM getAnalysisDate(){
        return this.getTypedField(19, 0);
    }

    @Override
    protected Type createNewTypeWithoutReflection(int field) {
        switch(field) {
            case 0:
                return new SI(this.getMessage());
            case 1:
                return new ID(this.getMessage());
            case 2:
                return new CWE(this.getMessage());
            case 3:
                return new ST(this.getMessage());
            case 4:
                return new ST(this.getMessage());
            case 5:
                return new CE(this.getMessage());
            case 6:
                return new ST(this.getMessage());
            case 7:
                return new CWE(this.getMessage());
            case 8:
                return new ID(this.getMessage());
            case 9:
                return new ID(this.getMessage());
            case 10:
                return new ID(this.getMessage());
            case 11:
                return new ID(this.getMessage());
            case 12:
                return new ID(this.getMessage());
            case 13:
                return new ID(this.getMessage());
            case 14:
                return new ID(this.getMessage());
            case 15:
                return new XCN(this.getMessage());
            case 16:
                return new CWE(this.getMessage());
            case 17:
                return new EI(this.getMessage());
            case 18:
                return new DTM(this.getMessage());
            default:
                return null;
        }
    }
}
