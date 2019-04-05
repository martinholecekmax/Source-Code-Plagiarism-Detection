public class ParameterTextChanged {
	private final String from;
	private final String to;
	private final int newPosition;
	private final int originalPosition;
	public String getFrom() {
		return from;
	}
	public String getTo() {
		return to;
	}
	public ParameterTextChanged(int originalPosition, int newPosition, String from, String to) {
		this.originalPosition = originalPosition;
		this.newPosition = newPosition;
		this.from = from;
		this.to = to;
	}
	public int getNewPosition() {
		return newPosition;
	}
	public int getOriginalPosition() {
		return originalPosition;
	}
}