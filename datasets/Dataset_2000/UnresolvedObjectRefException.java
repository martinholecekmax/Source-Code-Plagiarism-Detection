public class UnresolvedObjectRefException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public UnresolvedObjectRefException() {
        super();
    }
    
    public UnresolvedObjectRefException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public UnresolvedObjectRefException(Throwable cause) {
        super(cause);
    }
    
    public UnresolvedObjectRefException(String s) {
        super(s);
    }
}