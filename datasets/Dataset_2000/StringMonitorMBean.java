public interface StringMonitorMBean extends MonitorMBean {
            
    @Deprecated
    public String getDerivedGauge();
    
    @Deprecated
    public long getDerivedGaugeTimeStamp();
    
    public String getDerivedGauge(ObjectName object);
    
    public long getDerivedGaugeTimeStamp(ObjectName object);
    
    public String getStringToCompare();
    
    public void setStringToCompare(String value) throws java.lang.IllegalArgumentException;
    
    public boolean getNotifyMatch();
    
    public void setNotifyMatch(boolean value);
    
    public boolean getNotifyDiffer();
    
    public void setNotifyDiffer(boolean value);
}