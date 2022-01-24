package eu.naruciakk.nbpusd.models;

import com.fasterxml.jackson.annotation.JsonSetter;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Rate {
    private StringProperty no;
    private StringProperty effectiveDate;
    private DoubleProperty mid;

    public StringProperty noProperty() {
        if(no == null) no = new SimpleStringProperty(this, "no");
        return no;
    }

    public StringProperty effectiveDateProperty() {
        if(effectiveDate == null) effectiveDate = new SimpleStringProperty(this, "effectiveDate");
        return effectiveDate;
    }

    public DoubleProperty midProperty() {
        if(mid == null) mid = new SimpleDoubleProperty(this, "mid");
        return mid;
    }

    public String getNo() {
        return noProperty().get();
    }

    public String getEffectiveDate() {
        return effectiveDateProperty().get();
    }

    public Double getMid() {
        return midProperty().get();
    }

    @JsonSetter
    public void setNo(String no) {
        noProperty().set(no);
    }

    @JsonSetter
    public void setEffectiveDate(String effectiveDate) {
        effectiveDateProperty().set(effectiveDate);
    }

    @JsonSetter
    public void setMid(Double mid) {
        midProperty().set(mid);
    }
}
