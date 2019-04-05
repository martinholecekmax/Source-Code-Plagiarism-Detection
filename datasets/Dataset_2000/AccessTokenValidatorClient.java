public class AccessTokenValidatorClient implements AccessTokenValidator {
    private WebClient tokenValidatorClient;
    public List<String> getSupportedAuthorizationSchemes() {
        return Collections.singletonList(OAuthConstants.ALL_AUTH_SCHEMES);
    }
    public AccessTokenValidation validateAccessToken(MessageContext mc,
                                                     String authScheme, 
                                                     String authSchemeData) 
        throws OAuthServiceException {
        WebClient client = WebClient.fromClient(tokenValidatorClient, true);
        client.header(HttpHeaders.AUTHORIZATION, authScheme + " " + authSchemeData);
        return client.get(AccessTokenValidation.class);
    }
    public void setTokenValidatorClient(WebClient tokenValidatorClient) {
        this.tokenValidatorClient = tokenValidatorClient;
    }
}