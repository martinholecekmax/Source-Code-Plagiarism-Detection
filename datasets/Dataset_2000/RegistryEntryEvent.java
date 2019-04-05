public class RegistryEntryEvent extends ResponseEvent
{
    
   private static final long serialVersionUID = -7158046719541054868L;
   private Integer port;
    private String username;
    private String state;
    private Integer refresh;
    private String host;
    private Long registrationTime;
    
    public RegistryEntryEvent(Object source)
    {
        super(source);
    }
    
    public Long getRegistrationTime()
    {
        return registrationTime;
    }
    
    public void setRegistrationTime(String registrationTime)
    {
        this.registrationTime = Long.valueOf(registrationTime);
    }
    
    public Integer getPort()
    {
        return port;
    }
    
    public void setPort(Integer port)
    {
        this.port = port;
    }
    
    public String getUsername()
    {
        return username;
    }
    
    public void setUsername(String username)
    {
        this.username = username;
    }
    
    public String getHost()
    {
        return host;
    }
    
    public void setHost(String host)
    {
        this.host = host;
    }
    
    public String getState()
    {
        return state;
    }
    
    public void setState(String state)
    {
        this.state = state;
    }
    
    public Integer getRefresh()
    {
        return refresh;
    }
    
    public void setRefresh(Integer refresh)
    {
        this.refresh = refresh;
    }
}