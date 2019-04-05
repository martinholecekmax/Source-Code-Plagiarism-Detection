public class CarbonHttpResponse {
    
    private Map<String, String> headerMap = new HashMap<String, String>();
    
    private OutputStream os;
    
    private PrintWriter writer;
    
    private int statusCode = 200;
    
    private String statusMessage;
    
    private boolean error = false;
    
    private boolean redirect = false;
    
    private String sendRedirect;
    
    public CarbonHttpResponse(OutputStream os) {
        this.os = os;
    }
    public void addHeader(String name, String value) {
        headerMap.put(name, value);
    }
    public void removeHeader(String name) {
        headerMap.remove(name);
    }
    public Map<String, String> getHeaders() {
        return headerMap;
    }
    public void setStatus(int statusCode) {        
        this.statusCode = statusCode;
    }
    public int getStatusCode() {
        return statusCode;
    }
    public OutputStream getOutputStream() {
        return os;
    }
    public PrintWriter getWriter() {
        return new PrintWriter(writer);
    }
    public void setWriter(PrintWriter out) {
        this.writer = out;
    }
    
    public boolean isError() {
        return error;
    }
    
    public void setError(boolean error) {
        this.error = error;
    }
    public void setError(int errorCode, String errorMessage) {
        error = true;
        this.statusCode = errorCode;
        this.statusMessage = errorMessage;
    }
    public void setError(int errorCode) {
        error = true;
        this.statusCode = errorCode;
    }
    public boolean isRedirect() {
        return redirect;
    }
    public String getRedirect() {
        return sendRedirect;
    }
    public void setRedirect(String sendRedirect) {
        redirect = true;
        this.sendRedirect = sendRedirect;
    }
    public String getStatusMessage() {
        return statusMessage;
    }
}