package cn.medigical.publish.pojo.zjpa.dept;

import org.apache.commons.lang.builder.HashCodeBuilder;
/*
 *  平台部门科室类
 */
public class DepartHis {
    String  code;//科室代码
    String  name;//科室名称

    String departjianma;//科室简码
    String departmiaoshu;//描述
    String departzhangtai;//科室状态(启用active，禁用disable)
    String shangjidepartdiama;//上级科室编码
    String shangjidepartmingcheng;//(上级科室代码有则为必填)，科室代码OID，固定值 "2.16.156.10011.1.26”

    @Override
    public String toString() {
        return "DepartHis{" +
                "code=//科室代码'" + code + '\'' +
                ", name=//科室名称'" + name + '\'' +
                ", departjianma=//科室简码'" + departjianma + '\'' +
                ", departmiaoshu=//描述'" + departmiaoshu + '\'' +
                ", departzhangtai=//科室状态'" + departzhangtai + '\'' +
                ", shangjidepartdiama=//上级科室编码'" + shangjidepartdiama + '\'' +
                ", shangjidepartmingcheng=//(上级科室代码有则为必填)'" + shangjidepartmingcheng + '\'' +
                '}';
    }
// Constructors

    /** default constructor */
    public DepartHis() {
    }



    // Property accessors


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

//	@Override
//	public String toString() {
//		return Utility.toString(this);
//	}

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDepartjianma() {
        return departjianma;
    }

    public void setDepartjianma(String departjianma) {
        this.departjianma = departjianma;
    }

    public String getDepartmiaoshu() {
        return departmiaoshu;
    }

    public void setDepartmiaoshu(String departmiaoshu) {
        this.departmiaoshu = departmiaoshu;
    }

    public String getDepartzhangtai() {
        return departzhangtai;
    }

    public void setDepartzhangtai(String departzhangtai) {
        this.departzhangtai = departzhangtai;
    }

    public String getShangjidepartdiama() {
        return shangjidepartdiama;
    }

    public void setShangjidepartdiama(String shangjidepartdiama) {
        this.shangjidepartdiama = shangjidepartdiama;
    }

    public String getShangjidepartmingcheng() {
        return shangjidepartmingcheng;
    }

    public void setShangjidepartmingcheng(String shangjidepartmingcheng) {
        this.shangjidepartmingcheng = shangjidepartmingcheng;
    }

}
