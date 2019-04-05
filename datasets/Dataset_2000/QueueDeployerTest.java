public class QueueDeployerTest extends ServiceTestBase
{
         private QueueDeployer deployer;
   private HornetQServer server;
   public void testParseQueueConfiguration() throws Exception
   {
      String xml = "<configuration xmlns='urn:hornetq'>"
                   + "   <queues>"
                   + "      <queue name='foo'>"
                   + "         <address>bar</address>"
                   + "         <filter string='speed > 88' />"
                   + "         <durable>false</durable>"
                   + "      </queue>"
                   + "   </queues>"
                   + "</configuration>";
      Element rootNode = org.hornetq.utils.XMLUtil.stringToElement(xml);
      deployer.validate(rootNode);
      NodeList queueNodes = rootNode.getElementsByTagName("queue");
      assertEquals(1, queueNodes.getLength());
      deployer.deploy(queueNodes.item(0));
      Bindings bindings = server.getPostOffice().getBindingsForAddress(SimpleString.toSimpleString("bar"));
      assertEquals(1, bindings.getBindings().size());
      Binding binding = bindings.getBindings().iterator().next();
      assertTrue(binding instanceof LocalQueueBinding);
      LocalQueueBinding queueBinding = (LocalQueueBinding)binding;
      assertEquals("foo", queueBinding.getQueue().getName().toString());
      assertEquals("speed > 88", queueBinding.getQueue().getFilter().getFilterString().toString());
      assertEquals(false, queueBinding.getQueue().isDurable());
   }
         @Override
   protected void setUp() throws Exception
   {
      super.setUp();
      server = createServer(true);
      DeploymentManager deploymentManager = new FileDeploymentManager(500);
      deployer = new QueueDeployer(deploymentManager, server);
      server.start();
   }
}