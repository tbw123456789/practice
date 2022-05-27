package cn.medigical.publish.pojo.dictionary;

import javafx.beans.property.*;

/**

 */
public class ConfigHisTreatment {
    //编号
    private String id;
    //收费项编码
    private StringProperty treatmentCode;
    //收费项名称
    private StringProperty treatmentName;
    //收费项单位
    private StringProperty treatmentUnite;
    //收费项分类
    private StringProperty treatmentType;
    //编号类型
    private StringProperty treatmentYzzl;

    private IntegerProperty position;
    private BooleanProperty deleted;

    public String getTreatmentYzzl() {
        return treatmentYzzlProperty().get();
    }

    public StringProperty treatmentYzzlProperty() {
        if(treatmentYzzl == null){
            treatmentYzzl = new SimpleStringProperty();
        }
        return treatmentYzzl;
    }

    public void setTreatmentYzzl(String treatmentYzzl) {
        this.treatmentYzzlProperty().set(treatmentYzzl);
    }

    public String getTreatmentCode() {
        return treatmentCodeProperty().get();
    }

    public StringProperty treatmentCodeProperty() {
        if(treatmentCode == null){
            treatmentCode = new SimpleStringProperty();
        }
        return treatmentCode;
    }

    public void setTreatmentCode(String treatmentCode) {
        this.treatmentCodeProperty().set(treatmentCode);
    }

    public String getTreatmentName() {
        return treatmentNameProperty().get();
    }

    public StringProperty treatmentNameProperty() {
        if(treatmentName == null){
            treatmentName = new SimpleStringProperty();
        }
        return treatmentName;
    }

    public void setTreatmentName(String treatmentName) {
        this.treatmentNameProperty().set(treatmentName);
    }

    public String getTreatmentUnite() {
        return treatmentUniteProperty().get();
    }

    public StringProperty treatmentUniteProperty() {
        if(treatmentUnite == null){
            treatmentUnite = new SimpleStringProperty();
        }
        return treatmentUnite;
    }

    public void setTreatmentUnite(String treatmentUnite) {
        this.treatmentUniteProperty().set(treatmentUnite);
    }

    public String getTreatmentType() {
        return treatmentTypeProperty().get();
    }

    public StringProperty treatmentTypeProperty() {
        if(treatmentType == null){
            treatmentType = new SimpleStringProperty();
        }
        return treatmentType;
    }

    public void setTreatmentType(String treatmentType) {
        this.treatmentTypeProperty().set(treatmentType);
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

}
