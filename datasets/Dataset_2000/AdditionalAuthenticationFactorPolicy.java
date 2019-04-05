public interface AdditionalAuthenticationFactorPolicy {
    
    static class PrincipalNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1L;
        public PrincipalNotFoundException(final String message) {
            super(message);
        }
    }
    
    String getAdditionalFactorAuthenticationMethod();
    
    boolean requiresAdditionalAuthenticationFactor(String principalId) throws PrincipalNotFoundException;
}