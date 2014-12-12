package weatherapi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Locale;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import weatherapi.openweathermap.jaxb.Forecast;
import weatherapi.openweathermap.jaxb.Temperature;
import weatherapi.openweathermap.jaxb.Weatherdata;

public class WeatherApi {

    public static void main(String[] arg) throws Exception {
        Weatherdata weather = null;
        System.out.println("Getting data");
        try {
            weather = WeatherApi.retrieveWeatherData();
        } catch (JAXBException e) {
            System.out.println(e);
        }

        if (weather != null ) {
            for (Forecast forecats : weather.getForecasts()){
                System.out.println("Day: " + forecats.getDate());
                
            }
        }else{
            System.err.println("Error");
            
        }

    }

    static URL WEATHER_DATA_URL;
    final static String API_KEY = "f838f38bc7d05a5d974922ac35a2e4d9";
    
    
        
    

    public static Weatherdata retrieveWeatherData() throws JAXBException {
        URL urlResult;
        try {
            urlResult = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q=Milano&mode=xml&units=metric&cnt=7"+"&APIID="+API_KEY);

        } catch (MalformedURLException e) {
            urlResult = null;
        }
        WEATHER_DATA_URL = urlResult;
        
        System.out.println("FullUrl= "+WEATHER_DATA_URL);
        Weatherdata result;

        JAXBContext context = JAXBContext.newInstance(Weatherdata.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        result = (Weatherdata) unmarshaller.unmarshal(WEATHER_DATA_URL);
        return result;
    }

}
