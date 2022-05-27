package cn.medigical.publish.pojo.patient.drug;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class DrugSpeed {
    private float speed;
    private Date beginTime;
    private String unit;

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrugSpeed drugSpeed = (DrugSpeed) o;
        return Objects.equals(getSpeed(), drugSpeed.getSpeed()) &&
                Objects.equals(beginTime, drugSpeed.beginTime) &&
                Objects.equals(getUnit(), drugSpeed.getUnit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(speed, beginTime, unit);
    }
}
