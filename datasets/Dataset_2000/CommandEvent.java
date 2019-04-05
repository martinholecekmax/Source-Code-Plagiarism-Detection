public class CommandEvent extends ActionEvent
{
    public CommandEvent (Object source, String command, Object argument)
    {
        super(source, ActionEvent.ACTION_PERFORMED, command);
        _argument = argument;
    }
    public CommandEvent (
        Object source, String command, Object argument,
        long when, int modifiers)
    {
        super(source, ActionEvent.ACTION_PERFORMED, command, when, modifiers);
        _argument = argument;
    }
    
    public Object getArgument ()
    {
        return _argument;
    }
    @Override
    public String toString ()
    {
        return "[cmd=" + getActionCommand() + ", src=" + getSource() +
            ", arg=" + _argument + "]";
    }
    
    protected Object _argument;
}