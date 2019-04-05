public abstract class AbstractTraceConcern extends ConcernOf<InvocationHandler>
    implements InvocationHandler
{
    @Structure private Qi4j api;
    @Optional @Service protected TraceService traceService;
    private Composite thisComposite;
    private Class compositeType;
    public AbstractTraceConcern( Composite thisComposite )
    {
        this.thisComposite = thisComposite;
        compositeType = thisComposite.getClass().getInterfaces()[ 0 ];
    }
    public Object invoke( Object proxy, Method method, Object[] args )
        throws Throwable
    {
        boolean doTrace = traceService != null && doTrace();
        Object result;
        long entryTime = 0;
        long timeStamp = 0;
        try
        {
            if( doTrace )
            {
                entryTime = System.currentTimeMillis();
                timeStamp = System.nanoTime();
            }
            result = next.invoke( proxy, method, args );
            if( doTrace )
            {
                long duration = System.nanoTime() - timeStamp;
                traceService.traceSuccess( compositeType, api.dereference( thisComposite ), method, args, result, entryTime, duration );
            }
        }
        catch( Throwable t )
        {
            if( doTrace )
            {
                long duration = System.nanoTime() - timeStamp;
                Composite object = api.dereference( thisComposite );
                traceService.traceException( compositeType, object, method, args, t, entryTime, duration );
            }
            throw t;
        }
        return result;
    }
    protected boolean doTrace()
    {
        return true;
    }
}