package cn.medigical.publish.property;

import javafx.beans.property.StringProperty;
import org.springframework.core.convert.converter.Converter;

public class StringPropertyToStringConverter implements Converter<StringProperty, String> {
    @Override
    public String convert(StringProperty stringProperty) {
        return stringProperty.getValue();
    }
}
