package weatherapi.openweathermap.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Location {

    private String name;
    private String location;

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }
    
    @XmlElement
    public void setLocation(String location) {
        this.location = location;
    }

}
