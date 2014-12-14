package weatherapi.openweathermap.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Location {

    private String name;
    private String location;
    private String country;

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
    
    
    public String getCountry() {
        return country;
    }
    
    @XmlElement(name = "country")
    public void setCountry(String country) {
        this.country = country;
    }
    
    
    
    public boolean  hasName(){
        return this.getName() != null;        
    }

    public boolean hasLocation(){
        return this.getLocation() != null;
    }
    
    public boolean hasCountry(){
        return this.getCountry() != null;
    }
}
