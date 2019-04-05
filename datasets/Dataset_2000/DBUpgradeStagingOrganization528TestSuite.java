public class DBUpgradeStagingOrganization528TestSuite extends BaseTests {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTest(Login52xTests.suite());
		testSuite.addTest(StagingOrganizationTests.suite());
		testSuite.addTestSuite(StopSeleniumTest.class);
		return testSuite;
	}
}