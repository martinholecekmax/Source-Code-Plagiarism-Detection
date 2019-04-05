public class JavaSimpleType extends JavaType {
    public JavaSimpleType() {}
    public JavaSimpleType(String name, String initString) {
        super(name, true, initString);
    }
    public JavaSimpleType(JAXBTypeAndAnnotation jtype) {
        super(jtype);
    }
}