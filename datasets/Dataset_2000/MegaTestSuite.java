public class MegaTestSuite extends TestSuite {
    
    static public TestSuite suite() {
        return new MegaTestSuite();
    }
    private MegaTestSuite() {
        super( "Jena");
        addTest( TestSuiteRegression.suite() );
        addTest( NewRegression.suite() );
    }
    }