@RunWith(Arquillian.class)
public class GlassFishManagedDeployWarTest {
    @Deployment(testable = false)
    public static WebArchive getTestArchive() {
        final WebArchive war = ShrinkWrap.create(WebArchive.class, "test.war")
                .addClasses(GreeterServlet.class, Greeter.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
        return war;
    }
    @ArquillianResource
    private URL deploymentUrl;
    @Test
    public void assertWarDeployed() throws Exception {
        final String servletPath = GreeterServlet.class.getAnnotation(WebServlet.class).urlPatterns()[0];
        final URLConnection response = new URL(deploymentUrl.toString() + servletPath.substring(1)).openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(response.getInputStream()));
        final String result = in.readLine();
        assertThat(result, equalTo("Hello"));
    }
}