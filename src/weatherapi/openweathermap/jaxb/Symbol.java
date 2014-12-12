package weatherapi.openweathermap.jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Symbol {

    private String description;
    private String icon;
    private Integer conditionCode;
    
    
    public String getDescription() {
        return description;
    }

    @XmlAttribute(name = "name")
    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    @XmlAttribute(name = "var")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getConditionCode() {
        return conditionCode;
    }

    @XmlAttribute(name = "number")
    public void setConditionCode(Integer conditionCode) {
        this.conditionCode = conditionCode;
    }
    
    //Checkers
    
    
    public boolean hasDescription(){
        return this.getDescription() != null ;
    }
    
    public boolean  hasIcon(){
        return this.getIcon() != null;
        
    }
    
    public boolean hasConditionCode(){
        return this.getConditionCode() != null;
        
    }
    
    

}
