public class ConnectionEventsSupervisor implements StanzaReceivedEvent.Handler, StanzaSentEvent.Handler, ConnectionStateChangedEvent.Handler {
	private final PingPongDisplay display;
	@Inject
	public ConnectionEventsSupervisor(final XmppConnection connection, final PingPongDisplay display) {
		this.display = display;
		connection.addStanzaReceivedHandler(this);
		connection.addStanzaSentHandler(this);
		connection.addConnectionStateChangedHandler(this);
	}
	@Override
	public void onStanzaReceived(final StanzaReceivedEvent event) {
		display.print("IN: " + event.getStanza(), Style.stanzaReceived);
	}
	@Override
	public void onStanzaSent(final StanzaSentEvent event) {
		display.print("OUT: " + event.getStanza(), Style.stanzaSent);
	}
	@Override
	public void onConnectionStateChanged(final ConnectionStateChangedEvent event) {
		display.print("Connection state: " + event.getState(), Style.info);
	}
}