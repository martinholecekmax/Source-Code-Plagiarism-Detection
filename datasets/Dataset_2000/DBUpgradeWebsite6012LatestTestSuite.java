public class DBUpgradeWebsite6012LatestTestSuite extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTest(LoginTests.suite());
		testSuite.addTest(Website6012LatestTestPlan.suite());
		testSuite.addTestSuite(StopSeleniumTest.class);
		return testSuite;
	}
}