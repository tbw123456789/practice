package cn.medigical.publish.property;

import javafx.beans.property.BooleanProperty;
import org.springframework.core.convert.converter.Converter;

public class BooleanPropertyToStringConverter implements Converter<BooleanProperty, String> {
    @Override
    public String convert(BooleanProperty booleanProperty) {
        return String.valueOf(booleanProperty.getValue());
    }
}
