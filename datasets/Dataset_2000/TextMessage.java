public class TextMessage extends Message {
	private static final long serialVersionUID = 3683547006597423405L;
	private String content;
	public TextMessage(Date date, MessageStatus messageStatus, String content) {
		super(date, messageStatus, MessageType.SMS);
		this.content = content;
	}
	@Override
	public String getTextContent() {
		return content;
	}
	public String toString() {
		return content;
	}
}