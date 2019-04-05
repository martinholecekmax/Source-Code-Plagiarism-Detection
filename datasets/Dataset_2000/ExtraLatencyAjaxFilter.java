public class ExtraLatencyAjaxFilter implements AjaxFilter
{
    
    public Object doFilter(Object obj, Method method, Object[] params, AjaxFilterChain chain) throws Exception
    {
        try
        {
            Thread.sleep(delay/2);
        }
        catch (InterruptedException ex)
        {
            log.warn("Pre-exec interuption", ex);
        }
        Object reply = chain.doFilter(obj, method, params);
        try
        {
            Thread.sleep(delay/2);
        }
        catch (InterruptedException ex)
        {
            log.warn("Post-exec interuption", ex);
        }
        return reply;
    }
    
    public long getDelay()
    {
        return delay;
    }
    
    public void setDelay(long delay)
    {
        this.delay = delay;
    }
    
    private long delay = 100;
    
    private static final Log log = LogFactory.getLog(ExtraLatencyAjaxFilter.class);
}