public class ScopeAdapterTest extends TestContext
{
    public ScopeAdapterTest()
    {
        super(ScopeAdapterTest.class.getName());
    }
    @Before
    public void init()
    {
        super.init();
    }
    @Test
    public void testDependent()
    {
        clear();
        defineManagedBean(CheckWithCheckPayment.class);
        defineManagedBean(ScopeAdaptorComponent.class);
        defineManagedBean(ScopeAdaptorInjectorComponent.class);
        Object session = getSession();
        ContextFactory contextFactory = WebBeansContext.getInstance().getContextFactory();
        contextFactory.initRequestContext(null);
        contextFactory.initSessionContext(session);
        contextFactory.initApplicationContext(null);
        List<AbstractOwbBean<?>> comps = getComponents();
        Assert.assertEquals(4, getDeployedComponents());
        getManager().getInstance(comps.get(0));
        getManager().getInstance(comps.get(1));
        getInstanceByName("scope");
        getManager().getInstance(comps.get(2));
        contextFactory.destroyApplicationContext(null);
        contextFactory.destroySessionContext(session);
        contextFactory.destroyRequestContext(null);
    }
}