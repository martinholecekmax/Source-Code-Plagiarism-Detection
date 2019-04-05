public class DBUpgradeAnnouncementsDelivery523TestSuite extends BaseTests {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTest(Login52xTests.suite());
		testSuite.addTest(AnnouncementsDeliveryTests.suite());
		testSuite.addTestSuite(StopSeleniumTest.class);
		return testSuite;
	}
}