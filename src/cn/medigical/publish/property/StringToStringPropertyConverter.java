package cn.medigical.publish.property;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.springframework.core.convert.converter.Converter;

public class StringToStringPropertyConverter implements Converter<String, StringProperty> {
    @Override
    public StringProperty convert(String s) {
        return new SimpleStringProperty(s);
    }
}
