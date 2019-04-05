public abstract class AbstractEarTestCase
{
   public static EnterpriseArchive createDeployment(String[]... deployments) throws Exception
   {
      EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class);
            ear.addManifest();
            ear.addAsModule(AbstractWarTestCase.createDeployment());
            for (String[] deployment : deployments)
      {
         WebArchive war = AbstractWarTestCase.createDeployment(deployment[0], deployment[1], deployment[2]);
         ear.addAsModule(war);
      }
            JavaArchive classes = ShrinkWrap.create(JavaArchive.class);
      classes.addClasses(
         PortalTestServlet.class,
         PortletTestServlet.class,
         PortletUtilsTestCase.class,
         StringCodec.class,
         StringCodecTestCase.class,
         TestPortletApplicationDeployer.class
      );
      classes.addPackages(
         true,
         "org.gatein.pc.test.bootstrap",
         "org.gatein.pc.test.controller",
         "org.gatein.pc.test.portlet.framework",
         "org.gatein.pc.test.tck",
         "org.gatein.pc.test.unit",
         "org.gatein.pc.test.url",
         "org.jboss.unit");
            ear.addAsLibrary(classes);
                        ear.addAsLibraries(DependencyResolvers.
         use(MavenDependencyResolver.class).
         loadEffectivePom("../dependencies/pom.xml").importAllDependencies().
         resolveAsFiles());
            return ear;
   }
   
   private final String version;
   
   private final String type;
   
   private final String suite;
   
   private final String name;
   protected AbstractEarTestCase(String version, String type, String suite, String name)
   {
      this.version = version;
      this.type = type;
      this.suite = suite;
      this.name = name;
   }
   @Test
   public final void test() throws Exception
   {
      new Conversation(getBaseURL(), name).performInteractions();
   }
   
   protected abstract URL getBaseURL();
}