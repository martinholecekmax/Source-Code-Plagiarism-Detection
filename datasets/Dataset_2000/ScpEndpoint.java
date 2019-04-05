public class ScpEndpoint extends RemoteFileEndpoint<ScpFile> {
    public ScpEndpoint() {
    }
    public ScpEndpoint(String uri, JschComponent component, RemoteFileConfiguration configuration) {
        super(uri, component, configuration);
    }
    @Override
    public ScpConfiguration getConfiguration() {
        return (ScpConfiguration) this.configuration;
    }
    @Override
    protected RemoteFileConsumer<ScpFile> buildConsumer(Processor processor) {
        return null;     }
    protected GenericFileProducer<ScpFile> buildProducer() {
        return new ScpProducer(this, createRemoteFileOperations());
    }
    public RemoteFileOperations<ScpFile> createRemoteFileOperations() {
        ScpOperations operations = new ScpOperations();
        operations.setEndpoint(this);
        return operations;
    }
    @Override
    public String getScheme() {
        return "scp";
    }
    @Override
    public Expression getTempFileName() {
        log.debug("Creation of temporary files not supported by the scp: protocol.");
        return null;
    }
}