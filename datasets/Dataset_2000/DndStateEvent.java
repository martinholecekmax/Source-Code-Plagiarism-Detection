public class DndStateEvent extends ManagerEvent
{
    
    static final long serialVersionUID = 5906599407896179295L;
    
    private String channel;
    
    private Boolean state;
    
    public DndStateEvent(Object source)
    {
        super(source);
    }
    
    public String getChannel()
    {
        return channel;
    }
    
    public void setChannel(String channel)
    {
        this.channel = channel;
    }
    
    public Boolean getState()
    {
        return state;
    }
    
    public void setState(Boolean state)
    {
        this.state = state;
    }
}