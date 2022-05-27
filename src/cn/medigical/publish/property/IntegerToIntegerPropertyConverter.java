package cn.medigical.publish.property;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.springframework.core.convert.converter.Converter;

public class IntegerToIntegerPropertyConverter implements Converter<Integer, IntegerProperty> {
    @Override
    public IntegerProperty convert(Integer integer) {
        return new SimpleIntegerProperty(integer);
    }
}
