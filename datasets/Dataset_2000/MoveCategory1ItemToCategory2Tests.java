public class MoveCategory1ItemToCategory2Tests extends BaseTestSuite {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageShoppingTest.class);
		testSuite.addTestSuite(AddPortletShoppingTest.class);
		testSuite.addTestSuite(AddCategory1Test.class);
		testSuite.addTestSuite(AddCategory1ItemTest.class);
		testSuite.addTestSuite(AddCategory2Test.class);
		testSuite.addTestSuite(MoveCategory1ItemToCategory2Test.class);
		testSuite.addTestSuite(TearDownShoppingCategoryTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);
		return testSuite;
	}
}