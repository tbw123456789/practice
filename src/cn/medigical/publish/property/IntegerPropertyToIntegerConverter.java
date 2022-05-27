package cn.medigical.publish.property;

import javafx.beans.property.IntegerProperty;
import org.springframework.core.convert.converter.Converter;

public class IntegerPropertyToIntegerConverter implements Converter<IntegerProperty, Integer> {
    @Override
    public Integer convert(IntegerProperty integerProperty) {
        return integerProperty.getValue();
    }
}
