package cn.medigical.publish.property;

import javafx.beans.property.FloatProperty;
import org.springframework.core.convert.converter.Converter;

public class FloatPropertyToFloatConverter implements Converter<FloatProperty, Float> {
    @Override
    public Float convert(FloatProperty floatProperty) {
        return floatProperty.getValue();
    }
}
