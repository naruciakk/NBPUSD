package eu.naruciakk.nbpusd.handlers;

import eu.naruciakk.nbpusd.App;
import eu.naruciakk.nbpusd.controllers.RESTController;
import eu.naruciakk.nbpusd.models.Rate;
import eu.naruciakk.nbpusd.models.RatesResponse;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ButtonHandler implements EventHandler {

    private final DatePicker datePicker;
    private final TableView tableView;

    public ButtonHandler(DatePicker datePicker, TableView tableView) {
        this.datePicker = datePicker;
        this.tableView = tableView;
    }

    @Override
    public void handle(Event event) {
        LocalDate value = datePicker.getValue();
        String currency = RESTController.getCurrencyData(convertToDate(value), "USD");
        RatesResponse ratesResponse = RESTController.parseCurrencyData(currency);
        ArrayList<Rate> newRates = ratesResponse.getRates();
        tableView.getItems().clear();
        tableView.getItems().addAll(newRates);
    }

    public static Date convertToDate(LocalDate date) {
        return java.sql.Date.valueOf(date);
    }
}
