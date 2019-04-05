public class InfoRequiredException extends Exception
{
    private static final long serialVersionUID = 1L;
    public InfoRequiredException(String message)
    {
        super(message);
    }
    public InfoRequiredException(String msg, Throwable t)
    {
        super(msg, t);
    }
}