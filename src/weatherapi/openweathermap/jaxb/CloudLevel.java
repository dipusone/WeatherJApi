package weatherapi.openweathermap.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CloudLevel {

    private String description;
    private Integer percent;
    private String unit;

    public String getDescription() {
        return description;
    }

    @XmlAttribute(name = "value")
    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPercent() {
        return percent;
    }

    @XmlAttribute(name = "all")
    public void setPercent(Integer percent) {
        this.percent = percent;
    }

    public String getUnit() {
        return unit;
    }
    
    @XmlAttribute(name = "unit")
    public void setUnit(String unit) {
        this.unit = unit;
    }
    
    public boolean hasDescription(){
        return this.getDescription() != null;
    }
    
    public boolean  hasPercent(){
        return this.getPercent() != null;
        
    }
    
    public boolean hasUnit(){
        return this.getUnit() != null;
    }

}
