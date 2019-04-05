public class KunderaException extends RuntimeException
{
    private static final long serialVersionUID = 3855497974944993364L;
    
    public KunderaException()
    {
    }
    
    public KunderaException(String arg0)
    {
        super(arg0);
    }
    
    public KunderaException(Throwable arg0)
    {
        super(arg0);
    }
    
    public KunderaException(String arg0, Throwable arg1)
    {
        super(arg0, arg1);
    }
}