package weatherapi.openweathermap.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Weatherdata {
	private Location location;


	private Forecast[] forecasts;
	
	public Forecast[] getForecasts() {
		return forecasts;
	}

	@XmlElementWrapper(name="forecast")
	@XmlElement(name="time")
	public void setForecasts(Forecast[] forecasts) {
		this.forecasts = forecasts;
	}

	public Location getLocation() {
		return location;
	}

	@XmlElement
	public void setLocation(Location location) {
		this.location = location;
	}
	
        
        public boolean hasForecast(){
            return this.getForecasts() != null;
        }
        
        public boolean hasLocation(){
            return this.getLocation() != null;
        }
}