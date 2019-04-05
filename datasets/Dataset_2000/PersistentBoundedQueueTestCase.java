public class PersistentBoundedQueueTestCase extends AbstractServiceAndFlowTestCase
{
        private static final int SLEEP = 100;
    public PersistentBoundedQueueTestCase(ConfigVariant variant, String configResources)
    {
        super(variant, configResources);
    }
    @Parameters
    public static Collection<Object[]> parameters()
    {
        return Arrays.asList(new Object[][]{
            {ConfigVariant.SERVICE, "vm/persistent-bounded-vm-queue-test-service.xml"},
            {ConfigVariant.FLOW, "vm/persistent-bounded-vm-queue-test-flow.xml"}});
    }
    @Test
    public void testBoundedQueue() throws Exception
    {
        MuleClient client = new MuleClient(muleContext);
        client.dispatch("vm:        Thread.sleep(SLEEP);
        client.dispatch("vm:        Thread.sleep(SLEEP);
        client.dispatch("vm:        Thread.sleep(SLEEP);
                Thread.sleep(muleContext.getConfiguration().getDefaultQueueTimeout());
                                Set<String> results = new HashSet<String>();
        pollOutQueue(client, results);
        pollOutQueue(client, results);
        assertTrue(results.contains("Test1"));
        assertTrue(results.contains("Test2"));
        Thread.sleep(SLEEP);
        MuleMessage result = client.request("vm:        if (result != null)
        {
            System.out.println("result = " + result.getPayloadAsString());
        }
        assertNull(result);
    }
    private void pollOutQueue(MuleClient client, Set<String> results) throws Exception
    {
        MuleMessage result = client.request("vm:        assertNotNull(result);
        results.add(result.getPayloadAsString());
    }
}