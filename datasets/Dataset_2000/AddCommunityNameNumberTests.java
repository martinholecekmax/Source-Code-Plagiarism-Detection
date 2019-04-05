public class AddCommunityNameNumberTests extends BaseTests {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddCommunityNameNumberTest.class);
		testSuite.addTestSuite(TearDownCommunityTest.class);
		return testSuite;
	}
}