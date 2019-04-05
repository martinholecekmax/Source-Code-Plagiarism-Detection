@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CT_Height")
public class CTHeight implements Child
{
    @XmlAttribute(namespace = "http:    protected BigInteger val;
    @XmlAttribute(namespace = "http:    protected STHeightRule hRule;
    @XmlTransient
    private Object parent;
    
    public BigInteger getVal() {
        return val;
    }
    
    public void setVal(BigInteger value) {
        this.val = value;
    }
    
    public STHeightRule getHRule() {
        return hRule;
    }
    
    public void setHRule(STHeightRule value) {
        this.hRule = value;
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