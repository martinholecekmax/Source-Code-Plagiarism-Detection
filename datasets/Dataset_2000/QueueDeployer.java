public class QueueDeployer extends XmlDeployer
{
   private final HornetQServer server;
   private final FileConfigurationParser parser = new FileConfigurationParser();
   public QueueDeployer(final DeploymentManager deploymentManager, final HornetQServer server)
   {
      super(deploymentManager);
      this.server = server;
   }
   
   @Override
   public String[] getElementTagName()
   {
      return new String[] { "queue" };
   }
   @Override
   public void validate(final Node rootNode) throws Exception
   {
      org.hornetq.utils.XMLUtil.validate(rootNode, "schema/hornetq-configuration.xsd");
   }
   
   @Override
   public void deploy(final Node node) throws Exception
   {
      CoreQueueConfiguration queueConfig = parser.parseQueueConfiguration(node);
      server.deployQueue(SimpleString.toSimpleString(queueConfig.getAddress()),
                         SimpleString.toSimpleString(queueConfig.getName()),
                         SimpleString.toSimpleString(queueConfig.getFilterString()),
                         queueConfig.isDurable(),
                         false);
   }
   @Override
   public void undeploy(final Node node) throws Exception
   {
         }
   
   @Override
   public String[] getDefaultConfigFileNames()
   {
      return new String[] { "hornetq-configuration.xml", "hornetq-queues.xml" };
   }
}