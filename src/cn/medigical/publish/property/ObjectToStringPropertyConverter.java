package cn.medigical.publish.property;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.springframework.core.convert.converter.Converter;

public class ObjectToStringPropertyConverter implements Converter<Object, StringProperty> {
    @Override
    public StringProperty convert(Object o) {
       return new SimpleStringProperty(String.valueOf(o));
    }
}
