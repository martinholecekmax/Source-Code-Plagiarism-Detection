public class IdentityArchiveServiceRemoteTest extends IdentityArchiveServiceTest {
    public void setUp() throws Exception {
		super.setUp();
	}
    private int getConfigIntProp(String intPropKey) {
		return Integer.parseInt(getConfigProp(intPropKey));
	}
	private String getConfigProp(String propKey) {
		return ConfigContext.getCurrentContextConfig().getProperty(propKey);
	}
    
	protected Object getKimService(String svcName) throws Exception {
		ServiceBus serviceBus = KsbApiServiceLocator.getServiceBus();
		List<Endpoint> endpoints = serviceBus.getRemoteEndpoints(
                new QName(KimApiConstants.Namespaces.KIM_NAMESPACE_2_0, svcName));
		if (endpoints.size() > 1) {
			fail("Found more than one RemotedServiceHolder for " + svcName);
		}
		Endpoint endpoint = endpoints.get(0);
		return endpoint.getService();
	}
}