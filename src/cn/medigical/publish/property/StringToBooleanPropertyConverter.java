package cn.medigical.publish.property;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import org.springframework.core.convert.converter.Converter;

public class StringToBooleanPropertyConverter implements Converter<String, BooleanProperty> {
    @Override
    public BooleanProperty convert(String s) {
        boolean b = Boolean.valueOf(s);
        return new SimpleBooleanProperty( b);
    }
}
