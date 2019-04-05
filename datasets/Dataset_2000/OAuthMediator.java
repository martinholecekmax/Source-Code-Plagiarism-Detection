public class OAuthMediator extends AbstractMediator {
    private String remoteServiceUrl;
    private static final QName PROP_NAME_SERVICE_EPR = new QName("remoteServiceUrl");
    public String getRemoteServiceUrl() {
        return remoteServiceUrl;
    }
    public void setRemoteServiceUrl(String remoteServiceUrl) {
        this.remoteServiceUrl = remoteServiceUrl;
    }
    
    public OMElement serialize(OMElement parent) {
        OMElement oauthService = fac.createOMElement("oauthService", synNS);
        if (remoteServiceUrl != null) {
        	oauthService.addAttribute(fac.createOMAttribute("remoteServiceUrl", nullNS,
                    remoteServiceUrl));
        } else {
            throw new MediatorException(
                    "Invalid Entitlement mediator.OAuth service epr required");
        }
        saveTracingState(oauthService, this);
        if (parent != null) {
            parent.addChild(oauthService);
        }
        return oauthService;
    }
    
    public void build(OMElement elem) {
        OMAttribute attRemoteServiceUri = elem.getAttribute(PROP_NAME_SERVICE_EPR);
        if (attRemoteServiceUri != null) {
            remoteServiceUrl = attRemoteServiceUri.getAttributeValue();
        } else {
            throw new MediatorException(
                    "The 'remoteServiceUrl' attribute is required for the Entitlement mediator");
        }
    }
    
    public String getTagLocalName() {
        return "oauthService";
    }
}