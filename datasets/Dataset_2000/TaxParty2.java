@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaxParty2", propOrder = {
    "taxId",
    "regnId",
    "taxTp",
    "authstn"
})
public class TaxParty2 {
    @XmlElement(name = "TaxId")
    protected String taxId;
    @XmlElement(name = "RegnId")
    protected String regnId;
    @XmlElement(name = "TaxTp")
    protected String taxTp;
    @XmlElement(name = "Authstn")
    protected TaxAuthorisation1 authstn;
    
    public String getTaxId() {
        return taxId;
    }
    
    public void setTaxId(String value) {
        this.taxId = value;
    }
    
    public String getRegnId() {
        return regnId;
    }
    
    public void setRegnId(String value) {
        this.regnId = value;
    }
    
    public String getTaxTp() {
        return taxTp;
    }
    
    public void setTaxTp(String value) {
        this.taxTp = value;
    }
    
    public TaxAuthorisation1 getAuthstn() {
        return authstn;
    }
    
    public void setAuthstn(TaxAuthorisation1 value) {
        this.authstn = value;
    }
}