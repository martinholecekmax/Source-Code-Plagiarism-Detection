@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PathToUnindexedFieldType")
public class PathToUnindexedFieldType
    extends BasePathToElementType
{
    @XmlAttribute(name = "FieldURI", required = true)
    protected UnindexedFieldURIType fieldURI;
    
    public UnindexedFieldURIType getFieldURI() {
        return fieldURI;
    }
    
    public void setFieldURI(UnindexedFieldURIType value) {
        this.fieldURI = value;
    }
}