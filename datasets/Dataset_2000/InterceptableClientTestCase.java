public class InterceptableClientTestCase extends XMLTestCase {
    private InvocationControllerFactory oldFactory;
    private TestClientInvocationControllerFactory newFactory;
    private TestClientInvocationController testController;
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        InvocationControllerFactory icf = (InvocationControllerFactory) FactoryRegistry.getFactory(InvocationControllerFactory.class);
        oldFactory = icf;
        testController = new TestClientInvocationController();
        newFactory = new TestClientInvocationControllerFactory();
        newFactory.setInvocationController(testController);
        FactoryRegistry.setFactory(InvocationControllerFactory.class, newFactory);
    }
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        FactoryRegistry.setFactory(InvocationControllerFactory.class, oldFactory);
    }
    protected TestClientInvocationController getInvocationController() {
        return testController;
    }
}