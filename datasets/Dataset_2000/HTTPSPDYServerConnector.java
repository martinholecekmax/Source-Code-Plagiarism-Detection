public class HTTPSPDYServerConnector extends AbstractHTTPSPDYServerConnector
{
    public HTTPSPDYServerConnector()
    {
        this(null, Collections.<Short, PushStrategy>emptyMap());
    }
    public HTTPSPDYServerConnector(Map<Short, PushStrategy> pushStrategies)
    {
        this(null, pushStrategies);
    }
    public HTTPSPDYServerConnector(SslContextFactory sslContextFactory)
    {
        this(sslContextFactory, Collections.<Short, PushStrategy>emptyMap());
    }
    public HTTPSPDYServerConnector(SslContextFactory sslContextFactory, Map<Short, PushStrategy> pushStrategies)
    {
                        super(null, sslContextFactory);
        clearAsyncConnectionFactories();
                putAsyncConnectionFactory("spdy/3", new ServerHTTPSPDYAsyncConnectionFactory(SPDY.V3, getByteBufferPool(), getExecutor(), getScheduler(), this, getPushStrategy(SPDY.V3,pushStrategies)));
                putAsyncConnectionFactory("spdy/2", new ServerHTTPSPDYAsyncConnectionFactory(SPDY.V2, getByteBufferPool(), getExecutor(), getScheduler(), this, getPushStrategy(SPDY.V2,pushStrategies)));
                putAsyncConnectionFactory("http/1.1", new ServerHTTPAsyncConnectionFactory(this));
                setDefaultAsyncConnectionFactory(getAsyncConnectionFactory("http/1.1"));
    }
    private PushStrategy getPushStrategy(short version, Map<Short, PushStrategy> pushStrategies)
    {
        PushStrategy pushStrategy = pushStrategies.get(version);
        if(pushStrategy == null)
            pushStrategy = new PushStrategy.None();
        return pushStrategy;
    }
}