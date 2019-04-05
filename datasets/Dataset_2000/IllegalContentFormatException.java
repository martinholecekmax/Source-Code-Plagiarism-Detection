public class IllegalContentFormatException extends Exception {
	
	private static final long serialVersionUID = 1L;
	public IllegalContentFormatException() {
		super();
			}
	public IllegalContentFormatException(String detailMessage,
			Throwable throwable) {
		super(detailMessage, throwable);
			}
	public IllegalContentFormatException(String detailMessage) {
		super(detailMessage);
			}
	public IllegalContentFormatException(Throwable throwable) {
		super(throwable);
			}
}