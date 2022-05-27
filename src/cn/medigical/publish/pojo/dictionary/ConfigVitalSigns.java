package cn.medigical.publish.pojo.dictionary;

public class ConfigVitalSigns {
    private String id;
    /** 体征名称 */
    private String name;
    /** 简称 */
    private String simpleName;
    private String code;
    /** 数据类型 0：数字 1：字符*/
    private int dataType;
    /** 小数位 */
    private int decimal;
    /** 数据来源 0：体征值 1：血气分析*/
    private int dataSource;
    /** 采集周期 */
    private int capperiod;
    /** 体征单位 */
    private String unitName;
    /** 删除标志 */
    private boolean deleted;
    /** 显示方式 0:折线 1：表格 */
    private int showWay;

    /** 最小警告 */
    private String minWarning;

    /** 最大警告 */
    private String maxWarning;

    public String getMinWarning() {
        return minWarning;
    }

    public void setMinWarning(String minWarning) {
        this.minWarning = minWarning;
    }

    public String getMaxWarning() {
        return maxWarning;
    }

    public void setMaxWarning(String maxWarning) {
        this.maxWarning = maxWarning;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public int getDecimal() {
        return decimal;
    }

    public void setDecimal(int decimal) {
        this.decimal = decimal;
    }

    public int getDataSource() {
        return dataSource;
    }

    public void setDataSource(int dataSource) {
        this.dataSource = dataSource;
    }

    public int getCapperiod() {
        return capperiod;
    }

    public void setCapperiod(int capperiod) {
        this.capperiod = capperiod;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getShowWay() {
        return showWay;
    }

    public void setShowWay(int showWay) {
        this.showWay = showWay;
    }
}
