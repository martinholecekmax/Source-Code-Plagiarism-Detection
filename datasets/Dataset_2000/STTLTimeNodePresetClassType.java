@XmlType(name = "ST_TLTimeNodePresetClassType")
@XmlEnum
public enum STTLTimeNodePresetClassType {
    
    @XmlEnumValue("entr")
    ENTR("entr"),
    
    @XmlEnumValue("exit")
    EXIT("exit"),
    
    @XmlEnumValue("emph")
    EMPH("emph"),
    
    @XmlEnumValue("path")
    PATH("path"),
    
    @XmlEnumValue("verb")
    VERB("verb"),
    
    @XmlEnumValue("mediacall")
    MEDIACALL("mediacall");
    private final String value;
    STTLTimeNodePresetClassType(String v) {
        value = v;
    }
    public String value() {
        return value;
    }
    public static STTLTimeNodePresetClassType fromValue(String v) {
        for (STTLTimeNodePresetClassType c: STTLTimeNodePresetClassType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}