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
        run();

    }

    final protected static URL WEATHER_DATA_URL;

    static {
        URL urlResult;
        try {
            urlResult = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q=Munich&cnt=2&mode=xml&lang=de&units=metric");

        } catch (MalformedURLException e) {
            urlResult = null;
        }
        WEATHER_DATA_URL = urlResult;
    }

    public static void run() {
        Weatherdata weather = null;
        try {
            weather = retrieveWeatherData();
        } catch (JAXBException e) {
            System.out.println(e);
        }

        if (weather != null && weather.getForecasts().length == 2) {
            Forecast forecast = weather.getForecasts()[1];
            Temperature temperature = forecast.getTemperature();
            String dayOfWeek = forecast.getDate().getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.GERMAN);
            String line1 = String.format("%s:   %02.0f - %02.0f  C",
                    String.format("%2s", dayOfWeek), //2 signs of the day, "Mo", "Di", "Mi"...
                    temperature.getMinimum(),
                    temperature.getMaximum());
            String line2 = forecast.getSymbol().getDescription();
            System.out.println(line1);
            System.out.println(line2);
            System.out.println(forecast.getSymbol().getIcon());
        }
    }

    protected static Weatherdata retrieveWeatherData() throws JAXBException {
        Weatherdata result = null;

        JAXBContext context = JAXBContext.newInstance(Weatherdata.class);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        result = (Weatherdata) unmarshaller.unmarshal(WEATHER_DATA_URL);
        return result;
    }

}
