package cn.medigical.publish.property;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import org.springframework.core.convert.converter.Converter;

public class DoubleToFloatPropertyConverter implements Converter<Double, FloatProperty> {
    @Override
    public FloatProperty convert(Double aDouble) {
        return new SimpleFloatProperty(aDouble.floatValue());
    }
}
