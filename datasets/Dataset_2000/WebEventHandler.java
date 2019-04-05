public class WebEventHandler implements WebListener {
	private final Map<Long, WebEvent> bundleEvents = new HashMap<Long, WebEvent>();
	
	@Override
	public void webEvent(WebEvent event) {
		bundleEvents.put(event.getBundle().getBundleId(), event);
	}
	public Map<Long, WebEvent> getBundleEvents() {
		return bundleEvents;
	}
}