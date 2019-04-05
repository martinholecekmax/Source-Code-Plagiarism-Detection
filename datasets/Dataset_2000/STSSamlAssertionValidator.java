public class STSSamlAssertionValidator extends SamlAssertionValidator {
    private boolean trustVerificationSucceeded;
    
    public Credential validate(Credential credential, RequestData data) throws WSSecurityException {
        return super.validate(credential, data);
    }
    
    @Override
    protected Credential verifySignedAssertion(
        AssertionWrapper assertion,
        RequestData data
    ) throws WSSecurityException {
        try {
            Credential credential = super.verifySignedAssertion(assertion, data);
            trustVerificationSucceeded = true;
            return credential;
        } catch (WSSecurityException ex) {
            trustVerificationSucceeded = false;
            return null;
        }
    }
    
    public boolean isTrustVerificationSucceeded() {
        return trustVerificationSucceeded;
    }
}