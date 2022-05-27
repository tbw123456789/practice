package cn.medigical.publish.property;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import org.apache.commons.lang.StringUtils;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.IndexedCheckModel;
import org.springframework.core.convert.converter.Converter;

public class StringToIndexedCheckModelPropertyConverter implements Converter<String, Property<IndexedCheckModel<String>>> {
    @Override
    public Property<IndexedCheckModel<String>> convert(String stringProperty) {
        CheckComboBox<String> checkComboBox = new CheckComboBox<>();
        Property<IndexedCheckModel<String>> objectProperty = new SimpleObjectProperty<>();
        if (!StringUtils.isEmpty(stringProperty)) {
            String[] values = stringProperty.split(",");
            checkComboBox.getItems().addAll(values);
            checkComboBox.getCheckModel().checkAll();
        }
        objectProperty.setValue(checkComboBox.getCheckModel());
        return objectProperty;
    }
}
