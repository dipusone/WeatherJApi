package weatherapi.openweathermap.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Temperature {

    private Double minimum;
    private Double maximum;
    private Double morning;
    private Double evening;
    private Double day;
    private Double night;

    public Double getMinimum() {
        return minimum;
    }

    @XmlAttribute(name = "min")
    public void setMinimum(Double minimum) {
        this.minimum = minimum;
    }

    public Double getMaximum() {
        return maximum;
    }

    @XmlAttribute(name = "max")
    public void setMaximum(Double maximum) {
        this.maximum = maximum;
    }

    public Double getMorning() {
        return morning;
    }

    @XmlAttribute(name = "morn")
    public void setMorning(Double morning) {
        this.morning = morning;
    }

    public Double getEvening() {
        return evening;
    }

    @XmlAttribute(name = "eve")
    public void setEvening(Double evening) {
        this.evening = evening;
    }

    public Double getDay() {
        return day;
    }
    
    @XmlAttribute(name= "day")
    public void setDay(Double day) {
        this.day = day;
    }

    public Double getNight() {
        return night;
    }

    @XmlAttribute(name = "night")
    public void setNight(Double night) {
        this.night = night;
    }
    
    public boolean hasDay(){
        return this.getDay() != null;
    }

    public boolean hasEvening(){
        return this.getEvening() != null;
    }
    
    public boolean hasMaximum(){
        return this.getMaximum() != null;
    }
    
    public boolean hasMinimum(){
        return this.getMinimum() != null;
    }
    
    public boolean hasMorning(){
        return this.getMorning() != null;
    }
    
    public boolean hasNight(){
        return this.getNight() != null;
    }
    
}
