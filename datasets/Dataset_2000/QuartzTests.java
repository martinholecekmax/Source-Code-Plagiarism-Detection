public class QuartzTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(ViewSchedulerEventStagingCommunityQuartzTest.class);
		return testSuite;
	}
}