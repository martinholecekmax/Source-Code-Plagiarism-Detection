public class SearchUserDropDownAllCCTests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddSOUserTest.class);
		testSuite.addTestSuite(SelectRegularRolesSOUserTest.class);
		testSuite.addTestSuite(EditSOUserPasswordTest.class);
		testSuite.addTestSuite(SearchUserDropDownAllCCTest.class);
		testSuite.addTestSuite(TearDownSOUserTest.class);
		return testSuite;
	}
}