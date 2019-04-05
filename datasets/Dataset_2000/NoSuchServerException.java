public class NoSuchServerException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private final int serverId;
	
	public NoSuchServerException(int serverId) {
		this.serverId = serverId;
	}
	
	public int getServerId() {
		return serverId;
	}
}