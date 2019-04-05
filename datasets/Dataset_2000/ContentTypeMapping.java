public class ContentTypeMapping {
    
    private String extension;
    
    private String contentType;
    public ContentTypeMapping() {
    }
    public ContentTypeMapping(String extension, String contentType) {
        this.extension = extension;
        this.contentType = contentType;
    }
    public String getExtension() {
        return extension;
    }
    public void setExtension(String extension) {
        this.extension = extension;
    }
    public String getContentType() {
        return contentType;
    }
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}