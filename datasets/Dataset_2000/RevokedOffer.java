public class RevokedOffer {
    private String userJID;
    private String userID;
    private String workgroupName;
    private String sessionID;
    private String reason;
    private Date timestamp;
    
    RevokedOffer(String userJID, String userID, String workgroupName, String sessionID,
            String reason, Date timestamp) {
        super();
        this.userJID = userJID;
        this.userID = userID;
        this.workgroupName = workgroupName;
        this.sessionID = sessionID;
        this.reason = reason;
        this.timestamp = timestamp;
    }
    public String getUserJID() {
        return userJID;
    }
    
    public String getUserID() {
        return this.userID;
    }
    
    public String getWorkgroupName() {
        return this.workgroupName;
    }
    
    public String getSessionID() {
        return this.sessionID;
    }
    
    public String getReason() {
        return this.reason;
    }
    
    public Date getTimestamp() {
        return this.timestamp;
    }
}