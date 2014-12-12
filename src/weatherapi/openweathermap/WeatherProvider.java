/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherapi.openweathermap;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import sun.util.calendar.CalendarUtils;
import weatherapi.openweathermap.jaxb.Forecast;
import weatherapi.openweathermap.jaxb.Weatherdata;

/**
 *
 * @author jacopo
 */
public final class WeatherProvider {
    
    private URL openWeatherUrl;
    private String apyKey;
    private String format;
    private String Units;
    private static final String dailyUrlString="forecast";
    
    
    
    public WeatherProvider() {
        this.setApyKey(null);
        this.setFormat(null);
        this.setOpenWeatherUrl(null);
        this.setUnits(null);
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

    public void setApyKey(String apyKey) {
        this.apyKey = apyKey;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getUnits() {
        return Units;
    }

    public void setUnits(String Units) {
        this.Units = Units;
    }
    
    public Weatherdata getForecast(String City, String Nation, int spanntime) throws MalformedURLException, JAXBException{
        Weatherdata weather =null;
        String weatherUrlString = this.getOpenWeatherUrl().toString();
        weatherUrlString += dailyUrlString;
        weatherUrlString += "?q=" + City +","+ Nation;
        weatherUrlString += "&mode="+this.getFormat();
        weatherUrlString += "&units="+this.getUnits();
        weatherUrlString += "&cnt="+spanntime;
        weatherUrlString += "&APIID=" + this.getApyKey();
        
        URL weaterUrl = new URL(weatherUrlString);
        
        System.out.println("URL: "+ weaterUrl);
        
        JAXBContext context = JAXBContext.newInstance(Weatherdata.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();
        weather = (Weatherdata) unmarshaller.unmarshal(weaterUrl);
               
        return weather;
        
    }
    
 
    
}
