package cn.medigical.publish.interfaces.his.hishezhouguangji.segment;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.AbstractSegment;
import ca.uhn.hl7v2.model.Group;
import ca.uhn.hl7v2.model.Type;
import ca.uhn.hl7v2.model.v24.datatype.IS;
import ca.uhn.hl7v2.model.v24.datatype.NM;
import ca.uhn.hl7v2.model.v24.datatype.ST;
import ca.uhn.hl7v2.parser.ModelClassFactory;

public class ZQ1 extends AbstractSegment {

    public ZQ1(Group parent, ModelClassFactory factory) {
        super(parent, factory);
        this.init(factory);
    }

    private void init(ModelClassFactory factory) {
        try {
            this.add(ST.class, true, 1, 1, new Object[]{this.getMessage()}, "查询分类");
            this.add(ST.class, true, 1, 4, new Object[]{this.getMessage()}, "要查询的项目编码或ID");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "要查询的项目上级编码");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "要查询的项目名称");
            this.add(IS.class, false, 1, 180, new Object[]{this.getMessage()}, "是否模糊查找");
            this.add(NM.class, false, 1, 180, new Object[]{this.getMessage()}, "查询第几页,大0的整数");
            this.add(NM.class, true, 1, 26, new Object[]{this.getMessage()}, "查询结果返回行数");
            this.add(ST.class, false, 1, 40, new Object[]{this.getMessage()}, "项目类别，针对某一字典的项目类别查询");
        } catch (HL7Exception var3) {
            log.error("Unexpected error creating MSH - this is probably a bug in the source code generator.", var3);
        }

    }

    public ST getDicType(){
        return this.getTypedField(1, 0);
    }

    public ST getItemNo(){
        return this.getTypedField(2, 0);
    }

    public ST getParentNo(){
        return this.getTypedField(3, 0);
    }

    public ST getItemName(){
        return this.getTypedField(4, 0);
    }

    public IS getIsLike(){
        return this.getTypedField(5, 0);
    }

    public NM getPageNo(){
        return this.getTypedField(6, 0);
    }

    public NM getPageCount(){
        return this.getTypedField(7, 0);
    }

    public ST getItemType(){
        return this.getTypedField(8, 0);
    }

    @Override
    protected Type createNewTypeWithoutReflection(int field) {
        switch(field) {
            case 0:
                return new ST(this.getMessage());
            case 1:
                return new ST(this.getMessage());
            case 2:
                return new ST(this.getMessage());
            case 3:
                return new ST(this.getMessage());
            case 4:
                return new IS(this.getMessage());
            case 5:
                return new NM(this.getMessage());
            case 6:
                return new NM(this.getMessage());
            case 7:
                return new ST(this.getMessage());
            default:
                return null;
        }
    }
}