public class TcpLengthFunctionalTestCase extends AbstractServiceAndFlowTestCase
{
    protected static String TEST_MESSAGE = "Test TCP Request";
    private int timeout = 60 * 1000 / 20;
    @ClassRule
    public static DynamicPort dynamicPort1 = new DynamicPort("port1");
    @ClassRule
    public static DynamicPort dynamicPort2 = new DynamicPort("port2");
    @ClassRule
    public static DynamicPort dynamicPort3 = new DynamicPort("port3");
    public TcpLengthFunctionalTestCase(ConfigVariant variant, String configResources)
    {
        super(variant, configResources);        
        setDisposeContextPerClass(true);
    }
    @Parameters
    public static Collection<Object[]> parameters()
    {
        return Arrays.asList(new Object[][]{
            {ConfigVariant.SERVICE, "tcp-length-functional-test-service.xml"},
            {ConfigVariant.FLOW, "tcp-length-functional-test-flow.xml"}
        });
    }
    @Test
    public void testSend() throws Exception
    {
        MuleClient client = new MuleClient(muleContext);
        MuleMessage result = client.send("clientEndpoint", TEST_MESSAGE, null);
        assertEquals(TEST_MESSAGE + " Received", result.getPayloadAsString());
    }
    @Test
    public void testDispatchAndReplyViaStream() throws Exception
    {
        MuleClient client = new MuleClient(muleContext);
        client.dispatch("asyncClientEndpoint1", TEST_MESSAGE, null);
                Thread.sleep(200);
        MuleMessage result =  client.request("asyncClientEndpoint1", timeout);
                assertNull(result);
    }
    @Test
    public void testDispatchAndReply() throws Exception
    {
        MuleClient client = new MuleClient(muleContext);
        client.dispatch("asyncClientEndpoint2", TEST_MESSAGE, null);
                Thread.sleep(200);
        MuleMessage result =  client.request("asyncClientEndpoint2", timeout);
                assertNull(result);
    }
}