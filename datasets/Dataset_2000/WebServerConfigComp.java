public final class WebServerConfigComp implements WebServerConfig {
    private final String host;
    private final int port;
    public WebServerConfigComp(String host, int port) {
        this.host = host;
        this.port = port;
    }
    public String getHost() {
        return host;
    }
    public int getPort() {
        return port;
    }
}