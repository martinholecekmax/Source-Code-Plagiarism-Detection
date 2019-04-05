public class SpringEnricherRefTest extends ContextTestSupport {
    private MockEndpoint mock;
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mock = getMockEndpoint("mock:result");
    }
    public void testEnrich() throws Exception {
        mock.expectedBodiesReceived("test:blah");
        template.sendBody("direct:start", "test");
        mock.assertIsSatisfied();
    }
    protected CamelContext createCamelContext() throws Exception {
        return createSpringCamelContext(this, "org/apache/camel/spring/processor/enricherref.xml");
    }
}