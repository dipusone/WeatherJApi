package weatherapi.openweathermap.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Temperature {
	private double minimum;
	private double maximum;
	private double morning;
	private double evening;
	
	public double getMinimum() {
		return minimum;
	}
	@XmlAttribute(name="min")
	public void setMinimum(double minimum) {
		this.minimum = minimum;
	}
	public double getMaximum() {
		return maximum;
	}
	@XmlAttribute(name="max")
	public void setMaximum(double maximum) {
		this.maximum = maximum;
	}
	public double getMorning() {
		return morning;
	}
	@XmlAttribute(name="morn")
	public void setMorning(double morning) {
		this.morning = morning;
	}
	public double getEvening() {
		return evening;
	}
	@XmlAttribute(name="eve")
	public void setEvening(double evening) {
		this.evening = evening;
	}
}