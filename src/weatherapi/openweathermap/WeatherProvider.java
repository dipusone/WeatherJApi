/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapi.openweathermap;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import weatherapi.openweathermap.jaxb.Weatherdata;

/**
 *
 * @author jacopo
 */
public final class WeatherProvider {
    
        
    private static final String[] FORMATS = {"xml", "json"};
    private static final String[] UNITS = {"metric", "imperial"};
    
    public static String FORMAT_XML = FORMATS[0];
    
    public static String UNIT_METRIC = UNITS[0];
    public static String UNIT_IMPERIAL = UNITS[1];


    private URL openWeatherUrl;
    private String apyKey;
    private String format;
    private String unit;
    private static final String dailyUrlString = "forecast/daily";
    private static final String detailedDailyString = "forecast";

    public WeatherProvider() {
    }

    public URL getOpenWeatherUrl() {
        return openWeatherUrl;
    }

    public void setOpenWeatherUrl(URL openWeatherUrl) {
        this.openWeatherUrl = openWeatherUrl;
    }

    public String getApyKey() {
        return apyKey;
    }

    public void setApyKey(String apyKey) throws IllegalArgumentException {
        if (apyKey == null || apyKey.isEmpty()) {
            throw new IllegalArgumentException("Apikey null or empty");
        }
        this.apyKey = apyKey;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) throws IllegalArgumentException {
        if (!Arrays.asList(FORMATS).contains(format)) {
            throw new IllegalArgumentException("Invalid format");
        }
        this.format = format;
    }

    public String getUnits() {
        return unit;
    }

    public void setUnits(String unit) throws IllegalArgumentException {
        if (!Arrays.asList(UNITS).contains(unit)) {
            throw new IllegalArgumentException("invalid unit");
        }
        this.unit = unit;
    }

    public Weatherdata getDailyForecast(String city, String country, int spantime) throws MalformedURLException, JAXBException, IllegalArgumentException {
        return this.getForecast(city, country, spantime, true);

    }

    public Weatherdata getDetailedForecast(String city, String country, int spantime) throws MalformedURLException, JAXBException, IllegalArgumentException {
        return this.getForecast(city, country, spantime, false);

    }

    private Weatherdata getForecast(String city, String nation, int spantime, boolean daily) throws MalformedURLException, JAXBException, IllegalArgumentException {
        if (city == null || city.isEmpty()) {
            throw new IllegalArgumentException("City");
        }
        if (spantime <= 0 || spantime > 16) {
            throw new IllegalArgumentException("Spantime");
        }
        if (apyKey == null || apyKey.isEmpty()) {
            throw new IllegalArgumentException("Apikey must be set before calling this method");
        }
        if (!Arrays.asList(FORMATS).contains(format)) {
            throw new IllegalArgumentException("Format must be set before calling this method");
        }
        if (!Arrays.asList(UNITS).contains(unit)) {
            throw new IllegalArgumentException("Units must be set before calling this method");
        }
        if (this.openWeatherUrl == null){
            throw new IllegalArgumentException("OpenWeather must be set before calling this method");
        }
        
        
        
        

        Weatherdata weather;
        String weatherUrlString = this.getOpenWeatherUrl().toString();
        weatherUrlString += daily ? dailyUrlString : detailedDailyString;
        weatherUrlString += "?q=" + city + (nation.isEmpty() ? "" : ("," + nation));
        weatherUrlString += "&mode=" + this.getFormat();
        weatherUrlString += "&units=" + this.getUnits();
        weatherUrlString += "&cnt=" + spantime;
        weatherUrlString += "&APIID=" + this.getApyKey();

        URL weaterUrl = new URL(weatherUrlString);

        System.out.println("URL: " + weaterUrl);

        JAXBContext context = JAXBContext.newInstance(Weatherdata.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();
        weather = (Weatherdata) unmarshaller.unmarshal(weaterUrl);

        return weather;

    }

}
