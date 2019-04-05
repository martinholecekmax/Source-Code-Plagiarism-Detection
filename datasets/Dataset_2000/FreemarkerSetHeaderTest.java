public class FreemarkerSetHeaderTest extends CamelSpringTestSupport {
    @Test
    public void testSendingApple() throws Exception {
        assertRespondsWith("apple", "I am an apple");
    }
    @Test
    public void testSendingOrgane() throws Exception {
        assertRespondsWith("orange", "I am an orange");
    }
    protected void assertRespondsWith(final String value, String expectedBody) throws InvalidPayloadException, InterruptedException {
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMessageCount(1);
                mock.expectedBodiesReceived(expectedBody);
        template.request("direct:start", new Processor() {
            public void process(Exchange exchange) throws Exception {
                Message in = exchange.getIn();
                in.setBody(value);
            }
        });
        mock.assertIsSatisfied();
    }
    @Override
    protected ClassPathXmlApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("org/apache/camel/component/freemarker/camel-context.xml");
    }
}