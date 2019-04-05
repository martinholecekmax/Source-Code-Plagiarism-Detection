/*import org.apache.lenya.cms.repository.metadata.ElementSet;
public class ElementSetWrapper implements org.apache.lenya.cms.metadata.ElementSet {
    	private ElementSet delegate;
    private Map<String, ElementWrapper> elements = new HashMap<String, ElementWrapper>();
    public ElementSetWrapper(ElementSet delegate) {
        super();
        this.delegate = delegate;
    }
    public boolean containsElement(String name) {
        return this.delegate.containsElement(name);
    }
    public Element getElement(String name) throws org.apache.lenya.cms.metadata.MetaDataException {
        ElementWrapper wrapper = this.elements.get(name);
        if (wrapper == null) {
            try {
                wrapper = new ElementWrapper(this.delegate.getElement(name));
            } catch (MetaDataException e) {
                throw new org.apache.lenya.cms.metadata.MetaDataException(e);
            }
            this.elements.put(name, wrapper);
        }
        return wrapper;
    }
    public Element[] getElements() {
            	Element[] elements = this.delegate.getElements();
        Element[] wrappers = new Element[elements.length];
        for (int i = 0; i < elements.length; i++) {
            try {
                wrappers[i] = getElement(elements[i].getName());
            } catch (org.apache.lenya.cms.metadata.MetaDataException e) {
                throw new RuntimeException(e);
            }
        }
        return wrappers;
    }
    public String getNamespaceUri() {
                return null;
    }
}