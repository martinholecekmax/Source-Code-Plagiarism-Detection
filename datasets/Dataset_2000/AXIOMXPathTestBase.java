public class AXIOMXPathTestBase extends JaxenXPathTestBase {
    final OMMetaFactory omMetaFactory;
    public AXIOMXPathTestBase(String name, OMMetaFactory omMetaFactory) {
        super(name);
        this.omMetaFactory = omMetaFactory;
    }
    protected Navigator createNavigator() {
        return new DocumentNavigator();
    }
    protected Object loadDocument(InputStream in) throws Exception {
                        XMLStreamReader reader = new RootWhitespaceFilter(
                StAXUtils.createXMLStreamReader(in));
        return new StAXOMBuilder(omMetaFactory.getOMFactory(), reader).getDocument();
    }
    protected void releaseDocument(Object document) {
        ((OMDocument)document).close(false);
    }
}