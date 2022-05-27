package cn.medigical.publish.pojo.dictionary;

import javafx.beans.property.*;

/**

 */
public class ConfigHisDrugs {
    //编号
    private String id;
    //用药编码
    private StringProperty drugCode;
    //药品简码
    private StringProperty drugShortCode;
    //药名称
    private StringProperty drugName;
    //厂家
    private StringProperty manufactor;
    //国药准字
    private StringProperty drugCMS;
    //药品单位
    private StringProperty drugUnite;
    //药品分类
    private StringProperty drugType;

    private IntegerProperty position;
    private BooleanProperty deleted;

    /**
     * 药品分组 对应DrugGroupTypes的ID
     */
    private StringProperty drugGroupTypeCode;

    public String getDrugGroupTypeCode() {
        return drugGroupTypeCodeProperty().get();
    }

    public StringProperty drugGroupTypeCodeProperty() {
        if(drugGroupTypeCode == null){
            drugGroupTypeCode = new SimpleStringProperty();
        }
        return drugGroupTypeCode;
    }

    public void setDrugGroupTypeCode(String drugGroupTypeCode) {
        this.drugGroupTypeCodeProperty().set(drugGroupTypeCode);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPosition() {
        return positionProperty().get();
    }

    public IntegerProperty positionProperty() {
        if(position == null){
            position = new SimpleIntegerProperty();
        }
        return position;
    }

    public void setPosition(int position) {
        positionProperty().set(position);
    }

    public boolean isDeleted() {
        return deletedProperty().get();
    }

    public BooleanProperty deletedProperty() {
        if(deleted == null){
            deleted = new SimpleBooleanProperty();
        }
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        deletedProperty().set(deleted);
    }

    public String getDrugCode() {
        return drugCodeProperty().get();
    }

    public StringProperty drugCodeProperty() {
        if(drugCode == null){
            drugCode = new SimpleStringProperty();
        }
        return drugCode;
    }

    public void setDrugCode(String drugCode) {
        this.drugCodeProperty().set(drugCode);
    }

    public String getDrugShortCode() {
        return drugShortCodeProperty().get();
    }

    public StringProperty drugShortCodeProperty() {
        if(drugShortCode == null){
            drugShortCode = new SimpleStringProperty();
        }
        return drugShortCode;
    }

    public void setDrugShortCode(String drugShortCode) {
        this.drugShortCodeProperty().set(drugShortCode);
    }

    public String getDrugName() {
        return drugNameProperty().get();
    }

    public StringProperty drugNameProperty() {
        if(drugName == null){
            drugName = new SimpleStringProperty();
        }
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugNameProperty().set(drugName);
    }

    public String getManufactor() {
        return manufactorProperty().get();
    }

    public StringProperty manufactorProperty() {
        if(manufactor == null){
            manufactor = new SimpleStringProperty();
        }
        return manufactor;
    }

    public void setManufactor(String manufactor) {
        this.manufactorProperty().set(manufactor);
    }

    public String getDrugCMS() {
        return drugCMSProperty().get();
    }

    public StringProperty drugCMSProperty() {
        if(drugCMS == null){
            drugCMS = new SimpleStringProperty();
        }
        return drugCMS;
    }

    public void setDrugCMS(String drugCMS) {
        this.drugCMSProperty().set(drugCMS);
    }

    public String getDrugUnite() {
        return drugUniteProperty().get();
    }

    public StringProperty drugUniteProperty() {
        if(drugUnite == null){
            drugUnite = new SimpleStringProperty();
        }
        return drugUnite;
    }

    public void setDrugUnite(String drugUnite) {
        this.drugUniteProperty().set(drugUnite);
    }

    public String getDrugType() {
        return drugTypeProperty().get();
    }

    public StringProperty drugTypeProperty() {
        if(drugType == null){
            drugType = new SimpleStringProperty();
        }
        return drugType;
    }

    public void setDrugType(String drugType) {
        this.drugTypeProperty().set(drugType);
    }
}
