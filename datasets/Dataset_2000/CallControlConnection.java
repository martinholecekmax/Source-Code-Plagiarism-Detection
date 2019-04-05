public abstract interface CallControlConnection extends Connection {
	public static final int IDLE = 80;
	public static final int OFFERED = 81;
	public static final int QUEUED = 82;
	public static final int ALERTING = 83;
	public static final int INITIATED = 84;
	public static final int DIALING = 85;
	public static final int NETWORK_REACHED = 86;
	public static final int NETWORK_ALERTING = 87;
	public static final int ESTABLISHED = 88;
	public static final int DISCONNECTED = 89;
	public static final int FAILED = 90;
	public static final int UNKNOWN = 91;
	
	public static final int OFFERING = 81;
	public abstract int getCallControlState();
	public abstract void accept() throws InvalidStateException,
			MethodNotSupportedException, PrivilegeViolationException,
			ResourceUnavailableException;
	public abstract void reject() throws InvalidStateException,
			MethodNotSupportedException, PrivilegeViolationException,
			ResourceUnavailableException;
	public abstract Connection redirect(String paramString)
			throws InvalidStateException, InvalidPartyException,
			MethodNotSupportedException, PrivilegeViolationException,
			ResourceUnavailableException;
	public abstract void addToAddress(String paramString)
			throws InvalidStateException, MethodNotSupportedException,
			PrivilegeViolationException, ResourceUnavailableException;
	public abstract Connection park(String paramString)
			throws InvalidStateException, MethodNotSupportedException,
			PrivilegeViolationException, InvalidPartyException,
			ResourceUnavailableException;
}