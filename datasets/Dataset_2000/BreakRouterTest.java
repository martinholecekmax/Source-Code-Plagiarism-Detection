public class BreakRouterTest extends TestTemplate {
    private static final Log log = LogFactory.getLog(BreakRouterTest.class);
    @Override
    public void init() {
        log.info("Initializing Router Mediator Tests");
        log.debug("Router mediator Tests Initialised");
    }
    @Override
    public void runSuccessCase() {
        log.debug("Running Router mediator SuccessCase ");
        StockQuoteClient stockQuoteClient = new StockQuoteClient();
        OMElement result = null;
        try {
            AuthenticateStub authenticateStub = new AuthenticateStub();
            ConfigServiceAdminStub configServiceAdminStub = new ConfigServiceAdminStub("https:            authenticateStub.authenticateAdminStub(configServiceAdminStub, sessionCookie);
            ArtifactReader artifactReader = new ArtifactReader();
            OMElement omElement = artifactReader.getOMElement(BreakRouterTest.class.getResource("/break_Router/synapse.xml").getPath());
            configServiceAdminStub.updateConfiguration(omElement);
            if (FrameworkSettings.STRATOS.equalsIgnoreCase("false")) {
                result = stockQuoteClient.stockQuoteClientforProxy("http:            } else if (FrameworkSettings.STRATOS.equalsIgnoreCase("true")) {
                result = stockQuoteClient.stockQuoteClientforProxy("http:            }
            log.info(result);
            System.out.println(result);
            assert result != null;
            if (!result.toString().contains("IBM")) {
                Assert.fail("Router Mediator not invoked");
                log.error("Router Mediator not invoked");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            log.error("Router Mediator doesn't work : " + e.getMessage());
        }
    }
    @Override
    public void runFailureCase() {
    }
    @Override
    public void cleanup() {
    }
}