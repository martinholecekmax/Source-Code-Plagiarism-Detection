@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sessionId",
    "productId",
    "identifierType"
})
@XmlRootElement(name = "catalogProductDeleteRequestParam")
public class CatalogProductDeleteRequestParam {
    @XmlElement(required = true)
    protected String sessionId;
    @XmlElement(required = true)
    protected String productId;
    protected String identifierType;
    
    public String getSessionId() {
        return sessionId;
    }
    
    public void setSessionId(String value) {
        this.sessionId = value;
    }
    
    public String getProductId() {
        return productId;
    }
    
    public void setProductId(String value) {
        this.productId = value;
    }
    
    public String getIdentifierType() {
        return identifierType;
    }
    
    public void setIdentifierType(String value) {
        this.identifierType = value;
    }
}