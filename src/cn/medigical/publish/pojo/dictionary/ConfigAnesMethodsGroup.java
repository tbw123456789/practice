package cn.medigical.publish.pojo.dictionary;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="configAnesMethodsGroup")
public class ConfigAnesMethodsGroup {
//    @Field(value="id")
//    private String id;
    @Field(value="code")
    private String code;
    @Field(value="name")
    private String name;
//    @Field(value="deleted")
//    private Boolean deleted;

//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Boolean getDeleted() {
//        return deleted;
//    }
//
//    public void setDeleted(Boolean deleted) {
//        this.deleted = deleted;
//    }
}
