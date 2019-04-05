public class LogEntryImpl
    implements LogEntry
{
    private long m_time;
    private WeakReference m_bundle;
    private WeakReference m_service;
    private int m_level;
    private String m_message;
    private Throwable m_exception;
    public LogEntryImpl( Bundle bundle, ServiceReference service, int level, String message, Throwable exception )
    {
        if( bundle != null )
        {
            m_bundle = new WeakReference( bundle );
        }
        if( service != null )
        {
            m_service = new WeakReference( service );
        }
        m_level = level;
        m_message = message;
        m_exception = exception;
        m_time = System.currentTimeMillis();
    }
    public Bundle getBundle()
    {
        if( m_bundle == null )
        {
            return null;
        }
        return (Bundle) m_bundle.get();
    }
    public ServiceReference getServiceReference()
    {
        if( m_service == null )
        {
            return null;
        }
        return (ServiceReference) m_service.get();
    }
    public int getLevel()
    {
        return m_level;
    }
    public String getMessage()
    {
        return m_message;
    }
    public Throwable getException()
    {
        return m_exception;
    }
    public long getTime()
    {
        return m_time;
    }
}