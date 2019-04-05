public class LockFolderDocumentTests extends BaseTests {
	public static Test suite() {
		TestSuite testSuite = new TestSuite();
		testSuite.addTestSuite(AddPageDLTest.class);
		testSuite.addTestSuite(AddPortletDLTest.class);
		testSuite.addTestSuite(AddFolderTest.class);
		testSuite.addTestSuite(AddFolderDocumentTest.class);
		testSuite.addTestSuite(LockFolderDocumentTest.class);
		testSuite.addTestSuite(AssertLockFolderDocumentTest.class);
		testSuite.addTestSuite(TearDownDLFolderTest.class);
		testSuite.addTestSuite(TearDownDocumentTest.class);
		testSuite.addTestSuite(TearDownPageTest.class);
		return testSuite;
	}
}