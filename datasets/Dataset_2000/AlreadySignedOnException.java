public class AlreadySignedOnException extends Exception {
    private static final long serialVersionUID = 1L;
    public AlreadySignedOnException() {
        super();
    }
    public AlreadySignedOnException(String message) {
        super(message);
    }
}