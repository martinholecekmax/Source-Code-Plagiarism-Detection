public class ColocWrappedDocLitTest extends AbstractWrappedDocLitTest {
    static final String TRANSPORT_URI = "http:    private Log logger = LogFactory.getLog(ColocWrappedDocLitTest.class);
    protected Log getLogger() {
        return logger;
    }
    protected String getTransportURI() {
        return TRANSPORT_URI;
    }
    @Test
    public void testDummy() { }
}