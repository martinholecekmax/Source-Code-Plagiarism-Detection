public class HostObjectComponent {
    private static final Log log = LogFactory.getLog(HostObjectComponent.class);
    private static APIManagerConfiguration configuration = null;
    protected void activate(ComponentContext componentContext) {
       if (log.isDebugEnabled()){
           log.debug("HostObjectComponent activated");
       }
    }
    protected void deactivate(ComponentContext componentContext) {
       if (log.isDebugEnabled()){
           log.debug("HostObjectComponent deactivated");
       }
    }
    protected void setAPIManagerConfigurationService(APIManagerConfigurationService amcService) {
        if (log.isDebugEnabled()) {
            log.debug("API manager configuration service bound to the API host objects");
        }
        configuration = amcService.getAPIManagerConfiguration();
    }
    protected void unsetAPIManagerConfigurationService(APIManagerConfigurationService amcService) {
        if (log.isDebugEnabled()) {
            log.debug("API manager configuration service unbound from the API host objects");
        }
        configuration = null;
    }
    public static APIManagerConfiguration getAPIManagerConfiguration() {
        return configuration;
    }
}