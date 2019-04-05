public interface ConnectorAdminMBean {
    
    String getRole() throws IOException;
    
    void stop(boolean force) throws IOException;
    
    void stop() throws IOException;
    
    TabularData getSessions() throws IOException;
    
    String  getHostName() throws IOException;
    
    int getQueueSize();
}