package weatherapi.openweathermap.jaxb;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Forecast {
	private Calendar date;
	private Symbol symbol;
	private Temperature temperature;
	private CloudLevel cloudLevel;
	
	public Calendar getDate() {
		return date;
	}
	
	@XmlAttribute(name="day")
	public void setDate(Calendar date) {
		this.date = date;
	}

	public Temperature getTemperature() {
		return temperature;
	}
	@XmlElement(name="temperature")
	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}

	public Symbol getSymbol() {
		return symbol;
	}

	@XmlElement(name="symbol")
	/**
	 * symbol is holding the wheater text...
	 * @param symbol
	 */
	public void setSymbol(Symbol symbol) {
		this.symbol = symbol;
	}

	public CloudLevel getCloudLevel() {
		return cloudLevel;
	}
	
	@XmlElement(name="clouds")
	public void setCloudLevel(CloudLevel cloudLevel) {
		this.cloudLevel = cloudLevel;
	}
}