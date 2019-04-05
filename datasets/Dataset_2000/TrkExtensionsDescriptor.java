public class TrkExtensionsDescriptor extends net.sourceforge.gpstools.gpx.descriptors.ExtensionsTypeDescriptor {
                   
    private boolean _elementDefinition;
    
    private java.lang.String _nsPrefix;
    
    private java.lang.String _nsURI;
    
    private java.lang.String _xmlName;
    
    private org.exolab.castor.xml.XMLFieldDescriptor _identity;
                   public TrkExtensionsDescriptor() {
        super();
        setExtendsWithoutFlatten(new net.sourceforge.gpstools.gpx.descriptors.ExtensionsTypeDescriptor());
        _nsURI = "http:        _xmlName = "extensions";
        _elementDefinition = true;
    }
                   
    @Override()
    public org.exolab.castor.mapping.AccessMode getAccessMode(
    ) {
        return null;
    }
    
    @Override()
    public org.exolab.castor.mapping.FieldDescriptor getIdentity(
    ) {
        if (_identity == null) {
            return super.getIdentity();
        }
        return _identity;
    }
    
    @Override()
    public java.lang.Class getJavaClass(
    ) {
        return net.sourceforge.gpstools.gpx.TrkExtensions.class;
    }
    
    @Override()
    public java.lang.String getNameSpacePrefix(
    ) {
        return _nsPrefix;
    }
    
    @Override()
    public java.lang.String getNameSpaceURI(
    ) {
        return _nsURI;
    }
    
    @Override()
    public org.exolab.castor.xml.TypeValidator getValidator(
    ) {
        return this;
    }
    
    @Override()
    public java.lang.String getXMLName(
    ) {
        return _xmlName;
    }
    
    public boolean isElementDefinition(
    ) {
        return _elementDefinition;
    }
}