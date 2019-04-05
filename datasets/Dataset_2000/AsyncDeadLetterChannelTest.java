public class AsyncDeadLetterChannelTest extends ContextTestSupport {
    @Override
    public boolean isUseRouteBuilder() {
        return false;
    }
    public void testAsyncErrorHandlerWait() throws Exception {
        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                errorHandler(deadLetterChannel("mock:dead").maximumRedeliveries(2).redeliveryDelay(0).logStackTrace(false));
                from("direct:in")
                    .threads(2)
                    .to("mock:foo")
                    .process(new Processor() {
                        public void process(Exchange exchange) throws Exception {
                            throw new Exception("Forced exception by unit test");
                        }
                    });
            }
        });
        context.start();
        getMockEndpoint("mock:foo").expectedBodiesReceived("Hello World");
        getMockEndpoint("mock:dead").expectedMessageCount(1);
        template.requestBody("direct:in", "Hello World");
        assertMockEndpointsSatisfied();
    }
}