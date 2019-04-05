@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "pingInput"
        })
@XmlRootElement(name = "pingStringInput")
public class PingStringInput {
    @XmlElement(required = true)
    protected String pingInput;
    
    public String getPingInput() {
        return pingInput;
    }
    
    public void setPingInput(String value) {
        this.pingInput = value;
    }
}