package cn.medigical.publish.pojo.dictionary;

import javafx.beans.property.*;

/**

 */
public class ConfigHisConsumes {
    //编号
    private String id;
    //耗材编码
    private StringProperty consumeCode;
    //耗材简码
    private StringProperty consumeShortCode;
    //耗材名称
    private StringProperty consumeName;
    //厂家
    private StringProperty manufactor;
    //耗材单位
    private StringProperty consumeUnite;
    //耗材分类
    private StringProperty consumeType;
    //耗材分组
    private StringProperty consumesGroupTypeCode;

    private IntegerProperty position;
    private BooleanProperty deleted;

    public String getConsumesGroupTypeCode() {
        return consumesGroupTypeCodeProperty().get();
    }

    public StringProperty consumesGroupTypeCodeProperty() {
        if(consumesGroupTypeCode == null){
            consumesGroupTypeCode = new SimpleStringProperty();
        }
        return consumesGroupTypeCode;
    }

    public void setConsumesGroupTypeCode(String consumesGroupTypeCode) {
        this.consumesGroupTypeCodeProperty().set(consumesGroupTypeCode);
    }

    public String getConsumeCode() {
        return consumeCodeProperty().get();
    }

    public StringProperty consumeCodeProperty() {
        if(consumeCode == null){
            consumeCode = new SimpleStringProperty();
        }
        return consumeCode;
    }

    public void setConsumeCode(String consumeCode) {
        this.consumeCodeProperty().set(consumeCode);
    }

    public String getConsumeShortCode() {
        return consumeShortCodeProperty().get();
    }

    public StringProperty consumeShortCodeProperty() {
        if(consumeShortCode == null){
            consumeShortCode = new SimpleStringProperty();
        }
        return consumeShortCode;
    }

    public void setConsumeShortCode(String consumeShortCode) {
        this.consumeShortCodeProperty().set(consumeShortCode);
    }

    public String getConsumeName() {
        return consumeNameProperty().get();
    }

    public StringProperty consumeNameProperty() {
        if(consumeName == null){
            consumeName = new SimpleStringProperty();
        }
        return consumeName;
    }

    public void setConsumeName(String consumeName) {
        this.consumeNameProperty().set(consumeName);
    }

    public String getConsumeUnite() {
        return consumeUniteProperty().get();
    }

    public StringProperty consumeUniteProperty() {
        if(consumeUnite == null){
            consumeUnite = new SimpleStringProperty();
        }
        return consumeUnite;
    }

    public void setConsumeUnite(String consumeUnite) {
        this.consumeUniteProperty().set(consumeUnite);
    }

    public String getConsumeType() {
        return consumeTypeProperty().get();
    }

    public StringProperty consumeTypeProperty() {
        if(consumeType == null){
            consumeType = new SimpleStringProperty();
        }
        return consumeType;
    }

    public void setConsumeType(String consumeType) {
        this.consumeTypeProperty().set(consumeType);
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

}
