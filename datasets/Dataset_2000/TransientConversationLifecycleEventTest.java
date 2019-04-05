@Test(groups = INTEGRATION)
@SpecVersion(spec = "cdi", version = "20091101")
public class TransientConversationLifecycleEventTest extends AbstractTest {
    @ArquillianResource(Servlet.class)
    private URL contextPath;
    @Deployment(testable = false)
    public static WebArchive createTestArchive() {
        return new WebArchiveBuilder()
                .withTestClassDefinition(TransientConversationLifecycleEventTest.class)
                .withClasses(Servlet.class, ConversationScopedObserver.class, ApplicationScopedObserver.class,
                        ConversationScopedBean.class).build();
    }
    @Test
    @SpecAssertions({ @SpecAssertion(section = "6.7.4", id = "ba"), @SpecAssertion(section = "6.7.4", id = "bb") })
    public void testLifecycleEventFiredForTransientConversation() throws Exception {
        WebClient client = new WebClient();
        TextPage page = client.getPage(contextPath + "/display-transient");
        assertTrue(page.getContent().contains("Initialized:true"));         assertTrue(page.getContent().contains("Destroyed:false"));         page = client.getPage(contextPath + "/display");
        assertTrue(page.getContent().contains("Initialized:true"));         assertTrue(page.getContent().contains("Destroyed:true"));     }
}