public class PortUnavailableException
    extends MojoFailureException
{
    private static final long serialVersionUID = -7410759462209491374L;
    public PortUnavailableException( String message, Exception cause )
    {
        super( message );
        initCause( cause );
    }
}