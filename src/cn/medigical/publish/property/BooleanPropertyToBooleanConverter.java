package cn.medigical.publish.property;

import javafx.beans.property.BooleanProperty;
import org.springframework.core.convert.converter.Converter;

public class BooleanPropertyToBooleanConverter implements Converter<BooleanProperty, Boolean> {
    @Override
    public Boolean convert(BooleanProperty booleanProperty) {
        return booleanProperty.getValue();
    }
}
