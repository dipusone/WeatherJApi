package weatherapi.openweathermap.jaxb;

import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Forecast {

    private Date date;
    private Date from;
    private Date to;
    private Symbol symbol;
    private Temperature temperature;
    private CloudLevel cloudLevel;

    public Date getDate() {
        return date;
    }

    @XmlAttribute(name = "day")
    public void setDate(Date date) {
        this.date = date;
    }

    public Date getFrom() {
        return from;
    }
    
    @XmlAttribute(name= "from")
    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    @XmlAttribute(name = "to")
    public void setTo(Date to) {
        this.to = to;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    @XmlElement(name = "temperature")
    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    @XmlElement(name = "symbol")
    /**
     * symbol is holding the wheater text...
     *
     * @param symbol
     */
    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public CloudLevel getCloudLevel() {
        return cloudLevel;
    }

    @XmlElement(name = "clouds")
    public void setCloudLevel(CloudLevel cloudLevel) {
        this.cloudLevel = cloudLevel;
    }
}
