public class OperationTimedOutException extends Exception
{
    private static final long serialVersionUID = 1L;
    public OperationTimedOutException ()
    {
        super ( Messages.getString ( "OperationTimedOutException.Message" ) );     }
}