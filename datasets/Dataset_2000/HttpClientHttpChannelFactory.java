public final class HttpClientHttpChannelFactory implements HttpChannelFactory, Disposable {
    
    public static final String HTTP_CLIENT_PROP = HttpClientHttpChannelFactory.class.getName() + HttpClientFactory.HTTP_CLIENT;
    private final HttpClient client;
    
    public HttpClientHttpChannelFactory(HttpClient client) {
        this.client = client;
    }
    
    public HttpClientHttpChannelFactory(CRestConfig crestConfig) {
        this(HttpClientFactory.create(crestConfig, HttpClientHttpChannelFactory.class));
    }
    
    public HttpChannel open(MethodType methodType, String url, Charset charset) {
        HttpUriRequest request;
        switch(methodType) {
            case GET:
                request = new HttpGet(url);
            break;
            case POST:
                request = new HttpPost(url);
            break;
            case PUT:
                request = new HttpPut(url);
            break;
            case DELETE:
                request = new HttpDelete(url);
            break;
            case OPTIONS:
                request = new HttpOptions(url);
            break;
            case HEAD:
                request = new HttpHead(url);
            break;
            default:
                throw new IllegalArgumentException("Method " + methodType + " not supported");
        }
        HttpProtocolParams.setContentCharset(request.getParams(), charset.displayName());
        return new HttpClientHttpChannel(client, request);
    }
    public void dispose() {
        client.getConnectionManager().shutdown();
    }
    @Override
    protected void finalize() throws Throwable {
        try {
            dispose();
        } finally {
            super.finalize();
        }
    }
}