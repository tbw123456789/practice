package cn.medigical.publish.interfaces.his.hishezhouguangji.segment;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.v24.datatype.ST;
import ca.uhn.hl7v2.parser.ModelClassFactory;

public class MZ01 extends AbstractSegment {

    public MZ01(Group parent, ModelClassFactory factory) {
        super(parent, factory);
        this.init(factory);
    }

    private void init(ModelClassFactory factory) {
        try {
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "编码");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "麻醉方式");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "拼音码");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "自定义码");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "麻醉类型");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "显示顺序");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "默认标志");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "创建时间");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "更新时间");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "记录状态");
        } catch (HL7Exception var3) {
            log.error("Unexpected error creating MSH - this is probably a bug in the source code generator.", var3);
        }

    }

    public ST getCoding() {
        return this.getTypedField(1, 0);
    }

    public ST getAnesthesia() {
        return this.getTypedField(2, 0);
    }

    public ST getPinyinCode() {
        return this.getTypedField(3, 0);
    }

    public ST getCustomCode() {
        return this.getTypedField(4, 0);
    }

    public ST getAnesthesiaType() {
        return this.getTypedField(5, 0);
    }

    public ST getDisplayOrder() {
        return this.getTypedField(6, 0);
    }

    public ST getDefaultFlag() {
        return this.getTypedField(7, 0);
    }

    public ST getCreateTime() {
        return this.getTypedField(8, 0);
    }

    public ST getUpdateTime() {
        return this.getTypedField(9, 0);
    }

    public ST getRecordStatus() {
        return this.getTypedField(10, 0);
    }

    @Override
    protected Type createNewTypeWithoutReflection(int field) {
        switch (field) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                return new ST(this.getMessage());
            default:
                return null;
        }
    }
}