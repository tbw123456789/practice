package cn.medigical.publish.property;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import org.springframework.core.convert.converter.Converter;

public class BooleanToBooleanPropertyConverter implements Converter<Boolean, BooleanProperty> {

    @Override
    public BooleanProperty convert(Boolean aBoolean) {
        return new SimpleBooleanProperty(aBoolean);
    }

}
