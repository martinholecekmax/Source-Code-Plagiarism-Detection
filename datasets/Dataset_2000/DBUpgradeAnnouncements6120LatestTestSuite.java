public class DBUpgradeAnnouncements6120LatestTestSuite extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTest(LoginTests.suite());
		testSuite.addTest(Announcements6120LatestTestPlan.suite());
		testSuite.addTestSuite(StopSeleniumTest.class);
		return testSuite;
	}
}