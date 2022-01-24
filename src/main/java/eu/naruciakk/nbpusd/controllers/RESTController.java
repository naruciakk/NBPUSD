package eu.naruciakk.nbpusd.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import eu.naruciakk.nbpusd.models.RatesResponse;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class RESTController {
    public static String getCurrencyData(Date startDate, String currencyCode) {
        try {
            HttpResponse<JsonNode> apiResponse = Unirest
                    .get("http://api.nbp.pl/api/exchangerates/rates/{table}/{code}/{startDate}/{endDate}/?format=json")
                    .routeParam("table", "A")
                    .routeParam("code", currencyCode)
                    .routeParam("startDate", getDateFormatter().format(startDate))
                    .routeParam("endDate", getDateFormatter().format(new Date()))
                    .asJson();
            return apiResponse.getBody().toString();
        }
        catch (UnirestException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static RatesResponse parseCurrencyData(String apiResponse) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(apiResponse, RatesResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static SimpleDateFormat getDateFormatter() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }
}
