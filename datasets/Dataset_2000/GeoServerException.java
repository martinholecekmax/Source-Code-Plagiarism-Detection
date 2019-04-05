public class GeoServerException extends Exception implements IGeoServerException {
    
    private static final long serialVersionUID = 1L;
    
    String id;
    
    Object[] args;
    
    String message;
    public GeoServerException() {
        super();
    }
    public GeoServerException(String message, Throwable cause) {
        super(message, cause);
    }
    public GeoServerException(String message) {
        super(message);
    }
    public GeoServerException(Throwable cause) {
        super(cause);
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public GeoServerException id(String id) {
        setId(id);
        return this;
    }
    public Object[] getArgs() {
        return args;
    }
    public void setArgs(Object... args) {
        this.args = args;
    }
    public GeoServerException args(Object... args) {
        setArgs(args);
        return this;
    }
    @Override
    public String getMessage() {
        if (id == null) {
            return super.getMessage();
        }
        String localized = GeoServerExceptions.localize(this);
        return localized != null ? localized : super.getMessage();
    }
    void setMessage(String message) {
        this.message = message;
    }
}