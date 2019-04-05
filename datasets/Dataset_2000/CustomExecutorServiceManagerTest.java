@ContextConfiguration
public class CustomExecutorServiceManagerTest extends AbstractJUnit38SpringContextTests {
    @Autowired
    protected CamelContext context;
    public void testCustomExecutorService() throws Exception {
        Assert.assertTrue(context.getExecutorServiceManager() instanceof CustomExecutorServiceManager);
    }
}