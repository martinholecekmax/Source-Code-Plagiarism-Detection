@RunWith(Arquillian.class)
public class Ra15outIronJacamarAdminObjectTestCase
{
            
   @Deployment
   public static ResourceAdapterArchive createDeployment() throws Exception
   {
      String archiveName = "ra15outironjacamaradminobject.rar";
      String packageName = "org.jboss.jca.test.deployers.spec.rars.ra15out";
      ResourceAdapterArchive raa = ArquillianJCATestUtils.buidShrinkwrapRa(archiveName, packageName);
      raa.addAsManifestResource(archiveName + "/META-INF/ra.xml", "ra.xml");
      raa.addAsManifestResource(archiveName + "/META-INF/ironjacamar.xml", "ironjacamar.xml");
      return raa;
   }
            @Resource(mappedName = "java:/TestAdminObject")
   private TestAdminObject adminObject;
            
   @Test
   public void testBasic() throws Throwable
   {
      assertNotNull(adminObject);
      assertThat(adminObject.getMyStringProperty(), is("MyPropertyValue"));
   }
}