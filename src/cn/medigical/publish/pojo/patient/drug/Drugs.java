package cn.medigical.publish.pojo.patient.drug;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Drugs {
    List<Item> items = null;
    private String fullName;
    private String hashCode;

    public List<Item> getItems() {
        if (null == items){
            items = new ArrayList<>();
        }
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drugs drugs = (Drugs) o;
        return items.containsAll(drugs.items) &&
                drugs.items.containsAll(items) &&
                Objects.equals(fullName, drugs.fullName) &&
                Objects.equals(hashCode, drugs.hashCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items, fullName, hashCode);
    }
}
