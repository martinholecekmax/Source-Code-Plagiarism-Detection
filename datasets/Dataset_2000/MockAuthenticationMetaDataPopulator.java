public class MockAuthenticationMetaDataPopulator implements
    AuthenticationMetaDataPopulator {
    public Authentication populateAttributes(Authentication authentication,
        Credentials credentials) {
        return authentication;
    }
}