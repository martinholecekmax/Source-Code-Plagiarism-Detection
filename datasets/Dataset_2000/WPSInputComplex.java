public class WPSInputComplex extends AbstractWPSInput{
    private Object data;
    private String encoding;
    private String schema;
    private String mime;
    private Class clazz;
    
    public WPSInputComplex(final String identifier, final Object obj, final Class complexClass) {
        super(identifier);
        this.data = obj;
        this.encoding = null;
        this.schema = null;
        this.mime = null;
        this.clazz = complexClass;
    }
    
    public WPSInputComplex(final String identifier, final Object data, final Class complexClass, final String encoding, 
            final String schema, final String mime) {
        this(identifier, data, complexClass);
        this.data = data;
        this.encoding = encoding;
        this.schema = schema;
        this.mime = mime;
    }
    
    public String getEncoding() {
        return encoding;
    }
    
    public Object getData() {
        return data;
    }
    
    public String getMime() {
        return mime;
    }
    
    public String getSchema() {
        return schema;
    }
    
    public Class getComplexClass() {
        return clazz;
    }
}