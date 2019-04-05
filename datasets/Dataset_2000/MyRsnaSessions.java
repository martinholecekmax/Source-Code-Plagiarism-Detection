public class MyRsnaSessions {
	static final Logger logger = Logger.getLogger(MyRsnaSessions.class);
	private static MyRsnaSessions myRsnaSessions = null;
	private Hashtable<String, MyRsnaSession> sessions;
	
	protected MyRsnaSessions() {
		sessions = new Hashtable<String, MyRsnaSession>();
	}
	
	public static synchronized MyRsnaSessions getInstance() {
		if (myRsnaSessions == null) myRsnaSessions = new MyRsnaSessions();
		return myRsnaSessions;
	}
	
	public synchronized MyRsnaSession getMyRsnaSession(String mircUsername) {
		MyRsnaSession mrs = sessions.get(mircUsername);
		if (mrs != null) {
						if (mrs.isOpen()) return mrs;
						sessions.remove(mircUsername);
			mrs = null;
		}
		if (mrs == null) {
						MyRsnaUser mru = Preferences.getInstance().getMyRsnaUser(mircUsername);
			if (mru != null) {
				mrs = new MyRsnaSession(mru);
				if (mrs.login()) {
					sessions.put(mircUsername, mrs);
					return mrs;
				}
				else logger.warn("Unable to login to myRSNA ("+mircUsername+";"+mrs.username+")");
			}
		}
		return null;
	}
}