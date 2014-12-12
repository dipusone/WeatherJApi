package weatherapi.openweathermap.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CloudLevel {

    private String description;
    private int percent;
    private String unit;

    public String getDescription() {
        return description;
    }

    @XmlAttribute(name = "value")
    public void setDescription(String description) {
        this.description = description;
    }

    public int getPercent() {
        return percent;
    }

    @XmlAttribute(name = "all")
    public void setPercent(int percent) {
        this.percent = percent;
    }

    public String getUnit() {
        return unit;
    }
    
    @XmlAttribute(name = "unit")
    public void setUnit(String unit) {
        this.unit = unit;
    }

}
