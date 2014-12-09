package weatherapi.openweathermap.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Symbol {
	private String description;

	public String getDescription() {
		return description;
	}
	
	@XmlAttribute(name="name")
	public void setDescription(String description) {
		this.description = description;
	}
}