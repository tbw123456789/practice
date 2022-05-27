package cn.medigical.publish.property;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import org.springframework.core.convert.converter.Converter;

public class FloatToFloatPropertyConverter implements Converter<Float, FloatProperty> {
    @Override
    public FloatProperty convert(Float aFloat) {
        return new SimpleFloatProperty(aFloat);
    }
}
