@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_TextField")
public class CTTextField {
    @XmlAttribute
    protected STExternalConnectionType type;
    @XmlAttribute
    @XmlSchemaType(name = "unsignedInt")
    protected Long position;
    
    public STExternalConnectionType getType() {
        if (type == null) {
            return STExternalConnectionType.GENERAL;
        } else {
            return type;
        }
    }
    
    public void setType(STExternalConnectionType value) {
        this.type = value;
    }
    
    public long getPosition() {
        if (position == null) {
            return  0L;
        } else {
            return position;
        }
    }
    
    public void setPosition(Long value) {
        this.position = value;
    }
}