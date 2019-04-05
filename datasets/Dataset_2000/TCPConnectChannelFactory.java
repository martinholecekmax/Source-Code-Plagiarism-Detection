public class TCPConnectChannelFactory implements IChannelFactory {
	private ILogger logger;
	private final ConfigParser configParser = new ConfigParser(ITCPConnectServer.CHANNEL_TYPE);
	public IChannelConnecter createConnecter(
			IClientDispatcher clientDispatcher, String channelConfig) {
		final int port = configParser.configToPort(channelConfig);
		if(port == ConfigParser.INVALID_PORT)
			return null;
		TCPConnectConnecter connecter = new TCPConnectConnecter(clientDispatcher, logger);
		connecter.setConnectbackPort(port);
		return connecter;
	}
	public IChannelServer createServer(IServerDispatcher serverDispatcher,
			String channelConfig) {
		logger.info("Creating a TCP connect back server with config  " + channelConfig);
		final InetSocketAddress address = configParser.configToAddress("connectback:" + channelConfig);
		if(address == null)
			return null;
		final TCPConnectServer server = new TCPConnectServer(serverDispatcher,logger);
		server.setAddress(address);
		return server;
	}
	public String getType() {
		return ITCPConnectServer.CHANNEL_TYPE;
	}
	protected void setLogManager(ILogManager logManager) {
		logger = logManager.getLogger("TCP Connect back Channel");
	}
	protected void unsetLogManager(ILogManager logManager) {
	}
}