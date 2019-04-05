public class InvalidWikiPageException extends TracRemoteException {
	private static final long serialVersionUID = 7505355497334178587L;
	public InvalidWikiPageException() {
	}
	public InvalidWikiPageException(String message) {
		super(message);
	}
	public InvalidWikiPageException(Throwable cause) {
		super(cause);
	}
	public InvalidWikiPageException(String message, Throwable cause) {
		super(message, cause);
	}
}