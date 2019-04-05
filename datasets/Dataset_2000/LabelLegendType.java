@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "label-legend-type")
public class LabelLegendType
    extends LegendType
{
    @XmlAttribute(name = "font-size", required = true)
    protected int fontSize;
    @XmlAttribute(name = "field-font-size")
    protected String fieldFontSize;
    @XmlAttribute(name = "field-name", required = true)
    protected String fieldName;
    @XmlAttribute(name = "smart-placing", required = true)
    protected boolean smartPlacing;
    
    public int getFontSize() {
        return fontSize;
    }
    
    public void setFontSize(int value) {
        this.fontSize = value;
    }
    
    public String getFieldFontSize() {
        return fieldFontSize;
    }
    
    public void setFieldFontSize(String value) {
        this.fieldFontSize = value;
    }
    
    public String getFieldName() {
        return fieldName;
    }
    
    public void setFieldName(String value) {
        this.fieldName = value;
    }
    
    public boolean isSmartPlacing() {
        return smartPlacing;
    }
    
    public void setSmartPlacing(boolean value) {
        this.smartPlacing = value;
    }
}