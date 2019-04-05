public class ConnectorRemoved extends OEDataModification {
	public ConnectorRemoved(ViewConnector connector) {
		super(connector, null);
	}
	public ViewShape getFromShape() {
		return ((ViewConnector) oldValue()).getStartShape();
	}
	public ViewShape getToShape() {
		return ((ViewConnector) oldValue()).getEndShape();
	}
}