public abstract class MockAuditableObject implements AuditableObject {
    private static final ThreadLocal<MessageDigest> etagDigestLocal = new ThreadLocal<MessageDigest>();
    private static final Base64 etagEncoder = new Base64();
    private static final EntityFactory FACTORY = new MockEntityFactory();
    private Date creationDate;
    private Date modifiedDate;
    private String etag = "";
    
    public Date getCreationDate() {
        return creationDate;
    }
    
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
    
    public Date getModifiedDate() {
        return modifiedDate;
    }
    
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    
    public void updateTimestamp() {
        modifiedDate = new Date();
    }
    
    public String getEntityTag() {
        return etag;
    }
    
    public void setEntityTag(String etag) {
        this.etag = etag;
    }
    
    public String calculateEntityTag() {
        return "";
    }
    
    protected static String encodeEntityTag(byte[] bytes) {
                        MessageDigest md = etagDigestLocal.get();
        if(md==null) {
            try {
                                md = MessageDigest.getInstance("sha1");
                etagDigestLocal.set(md);
            } catch (Exception e) {
                throw new RuntimeException("Platform does not support sha1?", e);
            }
        }
        return new String(etagEncoder.encode(md.digest(bytes)));
    }
    public EntityFactory getFactory() {
        return FACTORY;
    }
}