package cn.medigical.publish.interfaces.his.hishezhouguangji.segment;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.v24.datatype.IS;
import ca.uhn.hl7v2.model.v24.datatype.NM;
import ca.uhn.hl7v2.model.v24.datatype.ST;
import ca.uhn.hl7v2.model.v24.datatype.TX;
import ca.uhn.hl7v2.model.v25.datatype.DTM;
import ca.uhn.hl7v2.parser.ModelClassFactory;

public class ZD1 extends AbstractSegment {

    public ZD1(Group parent, ModelClassFactory factory) {
        super(parent, factory);
        this.init(factory);
    }

    private void init(ModelClassFactory factory) {
        try {
            this.add(ST.class, true, 1, 1, new Object[]{this.getMessage()}, "分类");
            this.add(NM.class, true, 1, 4, new Object[]{this.getMessage()}, "序号");
            this.add(NM.class, false, 1, 180, new Object[]{this.getMessage()}, "页号");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "编码");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "上级编码");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "名称");
            this.add(ST.class, true, 1, 26, new Object[]{this.getMessage()}, "附码");
            this.add(TX.class, false, 1, 40, new Object[]{this.getMessage()}, "备注");
            this.add(DTM.class, true, 1, 15, new Object[]{this.getMessage()}, "创建时间");
            this.add(DTM.class, true, 1, 20, new Object[]{this.getMessage()}, "最后更新时间");
            this.add(ST.class, true, 1, 3, new Object[]{this.getMessage()}, "状态(A:新建D:删除U:更新)");
            this.add(IS.class, true, 1, 60, new Object[]{this.getMessage()}, "最后一笔项目");
            this.add(NM.class, false, 1, 15, new Object[]{this.getMessage()}, "id");
            this.add(NM.class, false, 1, 180, new Object[]{this.getMessage()}, "上级id");
        } catch (HL7Exception var3) {
            log.error("Unexpected error creating MSH - this is probably a bug in the source code generator.", var3);
        }

    }

    public ST getDicType(){
        return this.getTypedField(1, 0);
    }

    public NM getSeq(){
        return this.getTypedField(2, 0);
    }

    public NM getPageNo(){
        return this.getTypedField(3, 0);
    }

    public ST getItemNo(){
        return this.getTypedField(4, 0);
    }

    public ST getParentNo(){
        return this.getTypedField(5, 0);
    }

    public ST getItemName(){
        return this.getTypedField(6, 0);
    }

    public ST getAddNo(){
        return this.getTypedField(7, 0);
    }

    public TX getMark(){
        return this.getTypedField(8, 0);
    }

    public DTM getCreateDate(){
        return this.getTypedField(9, 0);
    }

    public DTM getModifyDate(){
        return this.getTypedField(10, 0);
    }

    public ST getItemStat(){
        return this.getTypedField(11, 0);
    }

    public IS getItemEnd(){
        return this.getTypedField(12, 0);
    }

    public NM getItemId(){
        return this.getTypedField(13, 0);
    }

    public NM getParentId(){
        return this.getTypedField(14, 0);
    }

    @Override
    protected Type createNewTypeWithoutReflection(int field) {
        switch(field) {
            case 0:
                return new ST(this.getMessage());
            case 1:
                return new NM(this.getMessage());
            case 2:
                return new NM(this.getMessage());
            case 3:
                return new ST(this.getMessage());
            case 4:
                return new ST(this.getMessage());
            case 5:
                return new ST(this.getMessage());
            case 6:
                return new ST(this.getMessage());
            case 7:
                return new TX(this.getMessage());
            case 8:
                return new DTM(this.getMessage());
            case 9:
                return new DTM(this.getMessage());
            case 10:
                return new ST(this.getMessage());
            case 11:
                return new IS(this.getMessage());
            case 12:
                return new NM(this.getMessage());
            case 13:
                return new NM(this.getMessage());
            default:
                return null;
        }
    }
}