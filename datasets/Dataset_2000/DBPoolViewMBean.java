public interface DBPoolViewMBean {
    
    public int getNumActive();
    
    public int getNumIdle();
    
    public String getName();
    
    public Map getConnectionUsage();
    
    public void reset();
}