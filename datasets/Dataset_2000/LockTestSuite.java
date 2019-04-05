public class LockTestSuite extends TestSuite
{
    public static Test suite() 
    {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(LockBehaviourImplTest.class);
        suite.addTestSuite(LockServiceImplTest.class);
        return suite;
    }
}