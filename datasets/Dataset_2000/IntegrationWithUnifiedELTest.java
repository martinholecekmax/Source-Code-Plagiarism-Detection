@Test(groups = INTEGRATION)
@SpecVersion(spec = "cdi", version = "20091101")
public class IntegrationWithUnifiedELTest extends AbstractTest {
    @ArquillianResource
    private URL contextPath;
    @Deployment(testable = false)
    public static WebArchive createTestArchive() {
        return new WebArchiveBuilder().withTestClassPackage(IntegrationWithUnifiedELTest.class).withWebXml("web.xml")
                .withWebResource("JSFTestPage.jsp", "JSFTestPage.jsp").withWebResource("JSPTestPage.jsp", "JSPTestPage.jsp")
                .withWebResource("faces-config.xml", "/WEB-INF/faces-config.xml").build();
    }
    @Test(groups = { EL })
    @SpecAssertions({ @SpecAssertion(section = "12.5", id = "a"), @SpecAssertion(section = "5.3", id = "d") })
    public void testELResolverRegisteredWithJsf() throws Exception {
        WebClient webclient = new WebClient();
        String content = webclient.getPage(contextPath + "JSFTestPage.jsf").getWebResponse().getContentAsString();
        assert content.contains("Dolly");
    }
    @Test(groups = { EL })
    @SpecAssertions({ @SpecAssertion(section = "12.5", id = "a"), @SpecAssertion(section = "5.3", id = "d") })
    public void testELResolverRegisteredWithServletContainer() throws Exception {
        WebClient webclient = new WebClient();
        String content = webclient.getPage(contextPath + "JSPTestPage.jsp").getWebResponse().getContentAsString();
        assert content.contains("Dolly");
    }
}