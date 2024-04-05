/**
 * @author Kaczor Wiktor S27599
 */

package zad1;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Currency;
import java.util.Locale;
import java.util.stream.Collectors;

public class Service {

    String country;

    public Service(String country) {
        this.country = country;
    }

    public String getWeather(String cityName) {
        String apiKey = "6f4f757da50cab18f8d30ec405cbabdb";
        String countryCode = localeFromName(country).getCountry();
        String url = String.format("https://api.openweathermap.org/data/2.5/weather?q=%s,%s&appid=%s&units=metric",
                cityName,
                countryCode,
                apiKey);
        return getJsonForURL(url);
    }

    public Double getRateFor(String currency) {
        String url = String.format("https://open.er-api.com/v6/latest/%s",
                Currency.getInstance(localeFromName(country)));
        String json = getJsonForURL(url);
        try {
            JSONObject parse = (JSONObject) new JSONParser().parse(json);
            JSONObject rates = (JSONObject) parse.get("rates");
           return (Double) rates.get(currency);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public Double getNBPRate() {
        return null;
    }
    private Locale localeFromName(String countryName) {
        for (Locale availableLocale : Locale.getAvailableLocales()) {
            if (availableLocale.getDisplayCountry(Locale.ENGLISH).equals(countryName)) {
                return availableLocale;
            }
        }
        return Locale.US;
    }
    private String getJsonForURL(String url){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new URI(url).toURL().openConnection().getInputStream()))) {
            return reader.lines().collect(Collectors.joining());

        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        throw new IllegalArgumentException("No such city/currency");
    }
}  
