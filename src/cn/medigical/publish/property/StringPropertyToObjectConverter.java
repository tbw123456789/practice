package cn.medigical.publish.property;

import javafx.beans.property.StringProperty;
import org.springframework.core.convert.converter.Converter;

public class StringPropertyToObjectConverter implements Converter<StringProperty, Object> {
    @Override
    public Object convert(StringProperty stringProperty) {
        return stringProperty.getValue();
    }
}
