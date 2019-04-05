public class OutEventDispatcher implements MethodCallEventDispatcher {
	private MethodCallEventDispatcher outEventDispatcher = null;
	private FireEventFilter fireEventFilter = null;
	public OutEventDispatcher(String identifier) {
		fireEventFilter = new FireEventFilter();
		outEventDispatcher = new MethodCallEventDispatcherImpl(identifier);
	}
	public void catchEventOnce(MethodCallEvent methodCallEvent) {
		fireEventFilter.add(methodCallEvent);
	}
	
	public void addListener(MethodCallEventHandler methodCallEventHandler) {
		outEventDispatcher.addListener(methodCallEventHandler);
	}
	
	public void fireEvent(MethodCallEvent methodCallEvent) {
		if (fireEventFilter.isAccepted(methodCallEvent)) {
			outEventDispatcher.fireEvent(methodCallEvent);
		}
	}
	
	public String getIdentifier() {
		return outEventDispatcher.getIdentifier();
	}
	
	public boolean isActive() {
		return outEventDispatcher.isActive();
	}
	
	public void removeListener(MethodCallEventHandler methodCallEventHandler) {
		outEventDispatcher.removeListener(methodCallEventHandler);
	}
}