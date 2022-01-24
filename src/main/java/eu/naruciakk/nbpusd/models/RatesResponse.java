package eu.naruciakk.nbpusd.models;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RatesResponse {
    private String table;
    private String currency;
    private String code;
    private ArrayList<Rate> rates;

    public String getTable() {
        return table;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public ArrayList<Rate> getRates() {
        return rates;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setRates(Rate[] rates) {
        this.rates = new ArrayList<Rate>(Arrays.asList(rates));
    }
}
