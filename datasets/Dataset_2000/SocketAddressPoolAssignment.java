public class SocketAddressPoolAssignment extends PoolAssignment<InetSocketAddress> {
	private static final Logger log = Logger.getLogger(SocketAddressPoolAssignment.class);
	@Override
	protected InetSocketAddress map(Properties properties) {
		AddressModel addressModel = AddressModel.build(properties);
		int port = Integer.parseInt(properties.getProperty("port"));
		String addressString = addressModel.getAddress();
		if (addressString == null) {
			return new InetSocketAddress(port);
		} else {
			InetAddress address;
			try {
				address = InetAddresses.forString(addressString);
			} catch (IllegalArgumentException e) {
				throw new IllegalStateException("Error mapping address: " + addressString);
			}
			return new InetSocketAddress(address, port);
		}
	}
}