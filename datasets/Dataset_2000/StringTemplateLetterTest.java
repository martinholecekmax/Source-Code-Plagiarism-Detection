public class StringTemplateLetterTest extends CamelTestSupport {
        private Exchange createLetter() {
        Exchange exchange = context.getEndpoint("direct:a").createExchange();
        Message msg = exchange.getIn();
        msg.setHeader("firstName", "Claus");
        msg.setHeader("lastName", "Ibsen");
        msg.setHeader("item", "Camel in Action");
        msg.setBody("PS: Next beer is on me, James");
        return exchange;
    }
    @Test
    public void testVelocityLetter() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMessageCount(1);
        mock.expectedBodiesReceived("Dear Ibsen, Claus! Thanks for the order of Camel in Action. Regards Camel Riders Bookstore PS: Next beer is on me, James");
        template.send("direct:a", createLetter());
        mock.assertIsSatisfied();
    }
    protected RouteBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            public void configure() throws Exception {
                from("direct:a").to("string-template:org/apache/camel/component/stringtemplate/letter.tm").to("mock:result");
            }
        };
    }
    }