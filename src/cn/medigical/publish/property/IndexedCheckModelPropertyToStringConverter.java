package cn.medigical.publish.property;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import org.controlsfx.control.IndexedCheckModel;
import org.springframework.core.convert.converter.Converter;

public class IndexedCheckModelPropertyToStringConverter implements Converter<Property<IndexedCheckModel<String>>,String> {
    @Override
    public String convert(Property<IndexedCheckModel<String>> o) {
        StringBuffer buffer = new StringBuffer();
        IndexedCheckModel<String> item = o.getValue();
        if(item != null){
            ObservableList<String> list = item.getCheckedItems();
            for(int i = 0;i<list.size();i++){
                if(i != list.size() -1) {
                    buffer.append(list.get(i)).append(",");
                }else{
                    buffer.append(list.get(i));
                }
            }
        }
        return buffer.toString();
    }
}
