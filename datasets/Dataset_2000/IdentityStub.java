public class IdentityStub extends Identity {
    
    public IdentityStub() {
        super();        
    }
    
    public IdentityStub(String name) {
        super(name);        
    }
    
    public IdentityStub(String name, IdentityScope scope)
            throws KeyManagementException {
        super(name, scope);
    }
    
    public IdentityStub(String name, PublicKey key) throws KeyManagementException{
        this(name);
        setPublicKey(key);
    }
}