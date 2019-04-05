public class OnExceptionAndDLCErrorHandlerIssueTest extends ContextTestSupport {
    public void testNoOnException() throws Exception {
        getMockEndpoint("mock:foo").expectedMessageCount(1);
        getMockEndpoint("mock:dead").expectedMessageCount(1);
        getMockEndpoint("mock:handled").expectedMessageCount(0);
        template.sendBody("direct:foo", "Hello World");
        assertMockEndpointsSatisfied();
    }
    public void testOnException() throws Exception {
        getMockEndpoint("mock:bar").expectedMessageCount(1);
        getMockEndpoint("mock:dead").expectedMessageCount(0);
        getMockEndpoint("mock:handled").expectedMessageCount(1);
        template.sendBody("direct:bar", "Hello World");
        assertMockEndpointsSatisfied();
    }
    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                errorHandler(deadLetterChannel("mock:dead"));
                from("direct:bar").routeId("bar")
                    .onException(IllegalArgumentException.class)
                        .handled(true)
                        .to("mock:handled")
                    .end()
                    .to("mock:bar")
                    .throwException(new IllegalArgumentException("Damn"));
                from("direct:foo").routeId("foo")
                    .to("mock:foo")
                    .throwException(new IllegalArgumentException("Damn"));
            }
        };
    }
}