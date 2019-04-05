@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "http:public class CTTwipsMeasure
    implements Child
{
    @XmlAttribute(namespace = "http:    protected BigInteger val;
    @XmlTransient
    private Object parent;
    
    public BigInteger getVal() {
        return val;
    }
    
    public void setVal(BigInteger value) {
        this.val = value;
    }
    
    public Object getParent() {
        return this.parent;
    }
    public void setParent(Object parent) {
        this.parent = parent;
    }
    
    public void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
        setParent(parent);
    }
}