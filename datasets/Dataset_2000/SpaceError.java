public class SpaceError extends Error {
    private static final long serialVersionUID = 2478239452513511965L;
    public SpaceError() {
        super();
    }
    public SpaceError(String message) {
        super(message);
    }
    public SpaceError(String message, Throwable cause) {
        super(message, cause);
    }
    public SpaceError(Throwable cause) {
        super(cause);
    }
}