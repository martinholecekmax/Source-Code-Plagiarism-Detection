public class SetCallerIdCommand extends AbstractAgiCommand
{
    
    private static final long serialVersionUID = 3256721797012404276L;
    
    private String callerId;
    
    public SetCallerIdCommand(String callerId)
    {
        super();
        this.callerId = callerId;
    }
    
    public String getCallerId()
    {
        return callerId;
    }
    
    public void setCallerId(String callerId)
    {
        this.callerId = callerId;
    }
    @Override
   public String buildCommand()
    {
        return "SET CALLERID " + escapeAndQuote(callerId);
    }
}