public class StartupContext
{
    private static final ThreadLocal<StartupContext> info = new ThreadLocal<StartupContext>()
    {
        @Override
        protected StartupContext initialValue()
        {
            return new StartupContext();
        }
    };
    private Map<String, Object> startupOptions = Collections.emptyMap();
    public static StartupContext get()
    {
        return info.get();
    }
    public Map<String, Object> getStartupOptions()
    {
        return Collections.unmodifiableMap(startupOptions);
    }
    public void setStartupOptions(Map<String, Object> startupOptions)
    {
        this.startupOptions = startupOptions;
    }
}