public class CxfSoapClientServerTest {
    @org.junit.Test
    public void test1() throws Exception {
        ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext( "classpath:beans-test.xml" );
        SOAPMessage soapMessage = MessageFactory.newInstance().createMessage();
        SOAPBody body = soapMessage.getSOAPPart().getEnvelope().getBody();
        QName payloadName = new QName( "http:                                       "execute",
                                       "ns1" );
        body.addBodyElement( payloadName );
        String cmd = "";
        cmd += "<batch-execution lookup=\"ksession1\">\n";
        cmd += "  <insert out-identifier=\"message\">\n";
        cmd += "      <org.test.Message>\n";
        cmd += "         <text>Helllo World</text>\n";
        cmd += "      </org.test.Message>\n";
        cmd += "   </insert>\n";
        cmd += "</batch-execution>\n";
        body.addTextNode( cmd );
        CamelServerApp test = new CamelServerApp();
        String response = test.execute( soapMessage,
                                        (CamelContext) springContext.getBean( "camel-client-ctx" ) );
        assertTrue( response.contains( "execution-results" ) );
        assertTrue( response.contains( "echo" ) );
        springContext.stop();
    }
}