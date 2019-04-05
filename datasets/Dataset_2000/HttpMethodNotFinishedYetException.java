public class HttpMethodNotFinishedYetException extends HttpMethodException {
    
    public HttpMethodNotFinishedYetException(String msg) {
        super(msg);
    }
    public HttpMethodNotFinishedYetException(String msg, Throwable e) {
        super(msg, e);
    }
}