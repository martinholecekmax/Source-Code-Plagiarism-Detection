public class CxfSimpleRouterAddressOverrideTest extends CxfSimpleRouterTest {    
    private String routerEndpointURI = "cxf:    private String serviceEndpointURI = "cxf:    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            public void configure() {
                errorHandler(noErrorHandler());
                from(routerEndpointURI).to("log:org.apache.camel?level=DEBUG")
                .setHeader(Exchange.DESTINATION_OVERRIDE_URL, constant(getServiceAddress()))
                .to(serviceEndpointURI);
            }
        };
    }
}