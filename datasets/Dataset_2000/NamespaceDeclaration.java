public class NamespaceDeclaration {
    private final String namespace;
    private final List<Attribute> attributes;
    public NamespaceDeclaration(String namespace) {
        this(namespace, Collections.<Attribute>emptyList());
    }
    public NamespaceDeclaration(String namespace, List<Attribute> attributes) {
        this.namespace = namespace;
        this.attributes = Collections.unmodifiableList(attributes);
    }
    public String getNamespace() {
        return namespace;
    }
    public List<Attribute> getAttributes() {
        return attributes;
    }
}