public class XPathWithNamespaceBuilderFilterTest extends ContextTestSupport {
    protected Endpoint startEndpoint;
    protected MockEndpoint resultEndpoint;
    public void testSendMatchingMessage() throws Exception {
        resultEndpoint.expectedMessageCount(1);
        template.sendBody("direct:start",
                "<person xmlns='http:        resultEndpoint.assertIsSatisfied();
    }
    public void testSendNotMatchingMessage() throws Exception {
        resultEndpoint.expectedMessageCount(0);
        template.sendBody("direct:start",
                "<person xmlns='http:        resultEndpoint.assertIsSatisfied();
    }
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        startEndpoint = resolveMandatoryEndpoint("direct:start");
        resultEndpoint = getMockEndpoint("mock:result");
    }
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            public void configure() {
                                                Namespaces ns = new Namespaces("c", "http:                        .add("xsd", "http:                                from("direct:start").
                        filter(ns.xpath("/c:person[@name='James']")).
                        to("mock:result");
                            }
        };
    }
}