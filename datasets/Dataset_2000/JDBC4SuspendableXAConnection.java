public class JDBC4SuspendableXAConnection extends SuspendableXAConnection {
	private Map<StatementEventListener, StatementEventListener> statementEventListeners;
	public JDBC4SuspendableXAConnection(ConnectionImpl connection) throws SQLException {
		super(connection);
		this.statementEventListeners = new HashMap<StatementEventListener, StatementEventListener>();
	}
	public synchronized void close() throws SQLException {
		super.close();
		if (this.statementEventListeners != null) {
			this.statementEventListeners.clear();
			this.statementEventListeners = null;
		}
	}
	
	public void addStatementEventListener(StatementEventListener listener) {
		synchronized (this.statementEventListeners) {
			this.statementEventListeners.put(listener, listener);
		}
	}
	
	public void removeStatementEventListener(StatementEventListener listener) {
		synchronized (this.statementEventListeners) {
			this.statementEventListeners.remove(listener);
		}
	}
	void fireStatementEvent(StatementEvent event) throws SQLException {
		synchronized (this.statementEventListeners) {
			for (StatementEventListener listener : this.statementEventListeners.keySet()) {
				listener.statementClosed(event);
			}
		}
	}
}