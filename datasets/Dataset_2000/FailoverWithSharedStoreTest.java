public class FailoverWithSharedStoreTest extends ClusterTestBase
{
   public void testNoConnection() throws Exception
   {
      ServerLocator locator = HornetQClient.createServerLocatorWithHA(new TransportConfiguration(NettyConnectorFactory.class.getName()));
      try
      {
         createSessionFactory(locator);
         fail();
      }
      catch(HornetQNotConnectedException nce)
      {
               }
      catch (HornetQException e)
      {
         fail("Invalid Exception type:" + e.getType());
      }
   }
}