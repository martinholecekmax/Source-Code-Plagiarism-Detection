public abstract class AbstractSWRLTestCase extends AbstractJenaTestCase {
    protected SWRLFactory factory;
    protected void setUp() throws Exception {
        super.setUp();
        loadRemoteOntology("importSWRL.owl");
        assertTrue(owlModel.getFrameFactory() instanceof SWRLJavaFactory);
        factory = new SWRLFactory(owlModel);
    }
}