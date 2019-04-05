public class TargetConfiguration extends BaseConfiguration {
    private HttpProcessor httpProcessor = null;
    private int maxConnections = Integer.MAX_VALUE;
    
    private boolean preserveUserAgentHeader = false;
    
    private boolean preserveServerHeader = true;
    private TargetConnections connections = null;
    public TargetConfiguration(ConfigurationContext configurationContext,
                               ParameterInclude parameters,
                               WorkerPool pool) {
        super(configurationContext, parameters, pool);
        httpProcessor = new ImmutableHttpProcessor(
                new HttpRequestInterceptor[] {
                        new RequestContent(),
                        new RequestTargetHost(),
                        new RequestConnControl(),
                        new RequestUserAgent(),
                        new RequestExpectContinue()
         });
    }
    public void build() throws AxisFault {
        super.build();
        maxConnections = conf.getIntProperty(PassThroughConfigPNames.MAX_CONNECTION_PER_HOST_PORT,
                Integer.MAX_VALUE);
        preserveUserAgentHeader = conf.isPreserveUserAgentHeader();
        preserveServerHeader = conf.isPreserveServerHeader();
    }
    public HttpParams getHttpParameters() {
        return httpParameters;
    }
    public HttpProcessor getHttpProcessor() {
        return httpProcessor;
    }
    public int getMaxConnections() {
        return maxConnections;
    }
    public boolean isPreserveUserAgentHeader() {
        return preserveUserAgentHeader;
    }
    public boolean isPreserveServerHeader() {
        return preserveServerHeader;
    }
    public TargetConnections getConnections() {
        return connections;
    }
    public void setConnections(TargetConnections connections) {
        this.connections = connections;
    }
}