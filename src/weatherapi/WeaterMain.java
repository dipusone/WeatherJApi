package weatherapi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.URL;
import java.text.SimpleDateFormat;

import weatherapi.openweathermap.WeatherProvider;
import weatherapi.openweathermap.jaxb.Forecast;
import weatherapi.openweathermap.jaxb.Weatherdata;

public class WeaterMain {
    
    final static String API_KEY = "f838f38bc7d05a5d974922ac35a2e4d9";

    public static void main(String[] arg) throws Exception {
        WeatherProvider wp = new WeatherProvider();
        wp.setApyKey(API_KEY);
        wp.setOpenWeatherUrl(new URL("http://api.openweathermap.org/data/2.5/"));
        wp.setFormat(WeatherProvider.FORMAT_XML);
        wp.setUnits(WeatherProvider.UNIT_METRIC);
        
        Weatherdata weather = wp.getDailyForecast("Milano", "it", 16);

        if (weather != null ) {
            SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
            Integer conditionCode;
            for (Forecast forecats : weather.getForecasts()){
                System.out.println("\n\nDay: " + dateFormatter.format(forecats.getDate()));
                System.out.println("Forecast: " + forecats.getSymbol().getDescription());
                conditionCode = forecats.getSymbol().getConditionCode()/100;
                System.out.println("Code: " + conditionCode);
                if (conditionCode >= 2 && conditionCode <= 6){
                    System.out.println("BAD");
                }else{
                    System.out.println("GOOD");
                }
                System.out.println("Clouds: " + forecats.getCloudLevel().getDescription());
               
                
                
                
            }
        }else{
            System.err.println("Error");
            
        }

    }
    
    
    
        
    

  
    
}
