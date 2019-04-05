public abstract class CanMessage extends AbstractOverlayMessage<CanOverlayID> {
	private int hopCount = 0;
	
	public CanMessage(CanOverlayID sender, CanOverlayID receiver) {
		super(sender, receiver);
	}
	public Message getPayload() {
		return this;
	}
	public abstract long getSize();
	public int getHopCount() {
		return this.hopCount;
	}
	public void setHop(int hop) {
		this.hopCount = hop;
	}
}