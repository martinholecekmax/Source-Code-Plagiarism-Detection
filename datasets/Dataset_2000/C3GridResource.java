@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "C3GridResource", namespace = "http:    "site",
    "any"
})
public class C3GridResource {
    @XmlElement(namespace = "http:    protected List<Site> site;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    
    public List<Site> getSite() {
        if (site == null) {
            site = new ArrayList<Site>();
        }
        return this.site;
    }
    
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }
    
    @Override
    public String toString() {
        return JAXBToStringBuilder.valueOf(this, JAXBToStringStyle.MULTI_LINE_STYLE);
    }
}