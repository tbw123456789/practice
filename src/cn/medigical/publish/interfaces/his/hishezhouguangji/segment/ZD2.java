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

public class ZD2 extends AbstractSegment {

    public ZD2(Group parent, ModelClassFactory factory) {
        super(parent, factory);
        this.init(factory);
    }

    private void init(ModelClassFactory factory) {
        try {
            this.add(NM.class, true, 1, 1, new Object[]{this.getMessage()}, "序号");
            this.add(NM.class, true, 1, 4, new Object[]{this.getMessage()}, "页号");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "人员简码");
            this.add(IS.class, false, 1, 180, new Object[]{this.getMessage()}, "性别");
            this.add(DTM.class, false, 1, 180, new Object[]{this.getMessage()}, "出生日期");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "身份证号");
            this.add(ST.class, true, 1, 26, new Object[]{this.getMessage()}, "用户名");
            this.add(ST.class, false, 1, 40, new Object[]{this.getMessage()}, "院区");
            this.add(ST.class, true, 1, 15, new Object[]{this.getMessage()}, "管理职务");
            this.add(ST.class, true, 1, 20, new Object[]{this.getMessage()}, "专业技术职务");
            this.add(ST.class, true, 1, 3, new Object[]{this.getMessage()}, "聘任职务");
            this.add(ST.class, true, 1, 60, new Object[]{this.getMessage()}, "执业类别");
            this.add(ST.class, false, 1, 15, new Object[]{this.getMessage()}, "执业范围");
            this.add(ST.class, false, 1, 180, new Object[]{this.getMessage()}, "办公电话");
            this.add(ST.class, false, 1, 2, new Object[]{this.getMessage()}, "手机号");
            this.add(ST.class, false, 1, 2, new Object[]{this.getMessage()}, "民族");
            this.add(DTM.class, false, 1, 3, new Object[]{this.getMessage()}, "参加工作时间");
            this.add(ST.class, false, 0, 16, new Object[]{this.getMessage()}, "电子邮箱");
            this.add(ST.class, false, 1, 250, new Object[]{this.getMessage()}, "学历");
            this.add(ST.class, false, 1, 20, new Object[]{this.getMessage()}, "所学专业");
            this.add(TX.class, false, 0, 10, new Object[]{this.getMessage()}, "个人简介");
            this.add(ST.class, false, 0, 10, new Object[]{this.getMessage()}, "执业证号");
            this.add(ST.class, false, 0, 10, new Object[]{this.getMessage()}, "资格证书号");
            this.add(DTM.class, false, 0, 10, new Object[]{this.getMessage()}, "执业开始日期");
            this.add(ST.class, false, 0, 10, new Object[]{this.getMessage()}, "抗菌药物权限");
            this.add(ST.class, false, 0, 10, new Object[]{this.getMessage()}, "手术级别");
            this.add(ST.class, false, 0, 10, new Object[]{this.getMessage()}, "科室编码");
            this.add(ST.class, false, 0, 10, new Object[]{this.getMessage()}, "科室名称");
            this.add(IS.class, false, 0, 10, new Object[]{this.getMessage()}, "缺省标志");
            this.add(IS.class, false, 0, 10, new Object[]{this.getMessage()}, "岗位性质");
            this.add(ST.class, false, 0, 10, new Object[]{this.getMessage()}, "签名图片");
        } catch (HL7Exception var3) {
            log.error("Unexpected error creating MSH - this is probably a bug in the source code generator.", var3);
        }

    }

    public NM getSeq(){
        return this.getTypedField(1, 0);
    }

    public NM getPageNo(){
        return this.getTypedField(2, 0);
    }

    public ST getStaffShortName(){
        return this.getTypedField(3, 0);
    }

    public IS getStaffSex(){
        return this.getTypedField(4, 0);
    }

    public DTM getBirthDate(){
        return this.getTypedField(5, 0);
    }

    public ST getIdCard(){
        return this.getTypedField(6, 0);
    }

    public ST getUserName(){
        return this.getTypedField(7, 0);
    }

    public ST getSite(){
        return this.getTypedField(8, 0);
    }

    public ST getManagerPost(){
        return this.getTypedField(9, 0);
    }

    public ST getProTech(){
        return this.getTypedField(10, 0);
    }

    public ST getJobTitle(){
        return this.getTypedField(11, 0);
    }

    public ST getPraCate(){
        return this.getTypedField(12, 0);
    }

    public ST getPracticeAreas(){
        return this.getTypedField(13, 0);
    }

    public ST getOfficaeTel(){
        return this.getTypedField(14, 0);
    }

    public ST getMobile(){
        return this.getTypedField(15, 0);
    }

    public ST getNation(){
        return this.getTypedField(16, 0);
    }

    public DTM getWorkDate(){
        return this.getTypedField(17, 0);
    }

    public ST getEmail(){
        return this.getTypedField(18, 0);
    }

    public ST getEducation(){
        return this.getTypedField(19, 0);
    }

    public ST getProfession(){
        return this.getTypedField(20, 0);
    }

    public TX getPersonalProfile(){
        return this.getTypedField(21, 0);
    }

    public ST getLicense(){
        return this.getTypedField(22, 0);
    }

    public ST getCertificate(){
        return this.getTypedField(23, 0);
    }

    public DTM getPracticeDate(){
        return this.getTypedField(24, 0);
    }

    public ST getAntiLevel(){
        return this.getTypedField(25, 0);
    }

    public ST getSurgeryLevel(){
        return this.getTypedField(26, 0);
    }

    public ST getDeptNo(){
        return this.getTypedField(27, 0);
    }

    public ST getDeptName(){
        return this.getTypedField(28, 0);
    }

    public IS getDefaultSign(){
        return this.getTypedField(29, 0);
    }

    public IS getPostType(){
        return this.getTypedField(30, 0);
    }

    public ST getSignPhoto(){
        return this.getTypedField(31, 0);
    }

    @Override
    protected Type createNewTypeWithoutReflection(int field) {
        switch(field) {
            case 0:
                return new NM(this.getMessage());
            case 1:
                return new NM(this.getMessage());
            case 2:
                return new ST(this.getMessage());
            case 3:
                return new IS(this.getMessage());
            case 4:
                return new DTM(this.getMessage());
            case 5:
                return new ST(this.getMessage());
            case 6:
                return new ST(this.getMessage());
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
            case 12:
                return new ST(this.getMessage());
            case 13:
                return new ST(this.getMessage());
            case 14:
                return new ST(this.getMessage());
            case 15:
                return new ST(this.getMessage());
            case 16:
                return new DTM(this.getMessage());
            case 17:
                return new ST(this.getMessage());
            case 18:
                return new ST(this.getMessage());
            case 19:
                return new ST(this.getMessage());
            case 20:
                return new TX(this.getMessage());
            case 21:
                return new ST(this.getMessage());
            case 22:
                return new ST(this.getMessage());
            case 23:
                return new DTM(this.getMessage());
            case 24:
                return new ST(this.getMessage());
            case 25:
                return new ST(this.getMessage());
            case 26:
                return new ST(this.getMessage());
            case 27:
                return new ST(this.getMessage());
            case 28:
                return new IS(this.getMessage());
            case 29:
                return new IS(this.getMessage());
            case 30:
                return new ST(this.getMessage());
            default:
                return null;
        }
    }
}
