public class TestAuthAll extends TestCase {
    public TestAuthAll(String testName) {
        super(testName);
    }
    public static Test suite() {
        TestSuite suite = new TestSuite();
        suite.addTest(TestChallengeParser.suite());
        suite.addTest(TestChallengeProcessor.suite());
        suite.addTest(TestBasicAuth.suite());
        suite.addTest(TestDigestAuth.suite());
        suite.addTest(TestNTLMAuth.suite());
        return suite;
    }
    public static void main(String args[]) {
        String[] testCaseName = { TestAuthAll.class.getName() };
        junit.textui.TestRunner.main(testCaseName);
    }
}