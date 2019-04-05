@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "userFilter",
    "postalAddressFilter",
    "telephoneNumberFilter",
    "emailAddressFilter",
    "organizationQuery"
})
@XmlRootElement(name = "UserBranch")
public class UserBranch {
    @XmlElement(name = "UserFilter")
    protected FilterType userFilter;
    @XmlElement(name = "PostalAddressFilter")
    protected FilterType postalAddressFilter;
    @XmlElement(name = "TelephoneNumberFilter")
    protected List<FilterType> telephoneNumberFilter;
    @XmlElement(name = "EmailAddressFilter")
    protected List<FilterType> emailAddressFilter;
    @XmlElement(name = "OrganizationQuery")
    protected OrganizationQueryType organizationQuery;
    
    public FilterType getUserFilter() {
        return userFilter;
    }
    
    public void setUserFilter(FilterType value) {
        this.userFilter = value;
    }
    
    public FilterType getPostalAddressFilter() {
        return postalAddressFilter;
    }
    
    public void setPostalAddressFilter(FilterType value) {
        this.postalAddressFilter = value;
    }
    
    public List<FilterType> getTelephoneNumberFilter() {
        if (telephoneNumberFilter == null) {
            telephoneNumberFilter = new ArrayList<FilterType>();
        }
        return this.telephoneNumberFilter;
    }
    
    public List<FilterType> getEmailAddressFilter() {
        if (emailAddressFilter == null) {
            emailAddressFilter = new ArrayList<FilterType>();
        }
        return this.emailAddressFilter;
    }
    
    public OrganizationQueryType getOrganizationQuery() {
        return organizationQuery;
    }
    
    public void setOrganizationQuery(OrganizationQueryType value) {
        this.organizationQuery = value;
    }
}