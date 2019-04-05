@Command(scope = "cxf", name = "start-endpoint", 
    description = "Starts a CXF Endpoint on a Bus.")
public class StartEndpointCommand extends OsgiCommandSupport {
    @Argument(index = 0, name = "bus", 
        description = "The CXF bus name where to look for the Endpoint", 
        required = true, multiValued = false)
    String busName;
    @Argument(index = 1, name = "endpoint", 
        description = "The Endpoint name to start", 
        required = true, multiValued = false)
    String endpoint;
    private CXFController cxfController;
    public void setController(CXFController controller) {
        this.cxfController = controller;
    }
    protected Object doExecute() throws Exception {
        Bus b = cxfController.getBus(busName);
        ServerRegistry reg = b.getExtension(ServerRegistry.class);
        List<Server> servers = reg.getServers();
        for (Server serv : servers) {
            if (endpoint.equals(serv.getEndpoint().getEndpointInfo().getName().getLocalPart())) {
                serv.start();
            }
        }
        return null;
    } 
}