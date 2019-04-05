public class CmsSearchDocumentType {
    
    private String m_className;
    
    private List<String> m_mimeTypes;
    
    private String m_name;
    
    private List<String> m_resourceTypes;
    
    public CmsSearchDocumentType() {
        m_resourceTypes = new ArrayList<String>();
        m_mimeTypes = new ArrayList<String>();
    }
    
    public void addMimeType(String mimeType) {
        m_mimeTypes.add(mimeType);
    }
    
    public void addResourceType(String resourceType) {
        m_resourceTypes.add(resourceType);
    }
    
    public String getClassName() {
        return m_className;
    }
    
    public List<String> getMimeTypes() {
        return m_mimeTypes;
    }
    
    public String getName() {
        return m_name;
    }
    
    public List<String> getResourceTypes() {
        return m_resourceTypes;
    }
    
    public void setClassName(String className) {
        m_className = className;
    }
    
    public void setMimeTypes(List<String> mimetypes) {
        m_mimeTypes = mimetypes;
    }
    
    public void setName(String name) {
        m_name = name;
    }
    
    public void setResourceTypes(List<String> resourceTypes) {
        m_resourceTypes = resourceTypes;
    }
}