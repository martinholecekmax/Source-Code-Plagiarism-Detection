public class MissingTypeWSDLTest extends AbstractAegisTest {
    @Test
    public void testMissingTransliteration() throws Exception {
        Server server = createService(MissingType.class, new MissingTypeImpl(), null);
        Service service = server.getEndpoint().getService();
        service.setInvoker(new BeanInvoker(new MissingTypeImpl()));
        ClientProxyFactoryBean proxyFac = new ClientProxyFactoryBean();
        proxyFac.setAddress("local:        proxyFac.setBus(getBus());
        setupAegis(proxyFac.getClientFactoryBean());
        Document wsdl = getWSDLDocument("MissingType");
        assertValid("/wsdl:definitions/wsdl:types"
                    + "/xsd:schema[@targetNamespace='urn:org:apache:cxf:aegis:type:missing']"
                    + "/xsd:complexType[@name=\"Inner\"]", wsdl);
    }
}