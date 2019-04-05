public class MarkAsAnswerCategoryMessageQuestionReplyTests extends BaseTests {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageMBTest.class);
		testSuite.addTestSuite(AddPortletMBTest.class);
		testSuite.addTestSuite(AddCategoryTest.class);
		testSuite.addTestSuite(AddCategoryMessageQuestionTest.class);
		testSuite.addTestSuite(AddCategoryMessageQuestionReplyTest.class);
		testSuite.addTestSuite(
			MarkAsAnswerCategoryMessageQuestionReplyTest.class);
		testSuite.addTestSuite(TearDownMBCategoryTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);
		return testSuite;
	}
}