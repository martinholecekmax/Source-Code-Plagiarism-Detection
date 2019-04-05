public class TelnetProvider implements INetworkServiceProvider {
	public Class<? extends INetworkService> getServiceClass() {
		return Telnet.class;
	}
	public String getServiceName() {
		return "Telnet";
	}
	public Telnet create(ISocketLocator locator) {
		return new Telnet(locator);
	}
}