public class VirtualHostDeleteMapping extends ClusteringMessage {
    private static final Log log = LogFactory.getLog(VirtualHostDeleteMapping.class);
    private String hostName;
    public VirtualHostDeleteMapping(String hostName) {
         this.hostName = hostName;
    }
    @Override
    public ClusteringCommand getResponse() {
        return null;
    }
    @Override
    public void execute(ConfigurationContext configurationContext) throws ClusteringFault {
        VirtualHostClusterUtil.removeVirtualHost(this.hostName);
        ApplicationContext.getCurrentApplicationContext().removeUrlMappingMap(this.hostName);
    }
}