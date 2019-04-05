public class AxisFIXException extends RuntimeException{
    public AxisFIXException() {
        super();
    }
    public AxisFIXException(String message) {
        super(message);
    }
    public AxisFIXException(String message, Exception e) {
        super(message, e);
    }
}