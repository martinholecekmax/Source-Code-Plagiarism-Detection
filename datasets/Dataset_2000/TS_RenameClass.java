public class TS_RenameClass extends FileTestSuite {
	public static TestSuite suite() {
		TestSuite suite = createSuite("Rename Class", "rename_class_test_*active*source", ClassRenameTester.class);	
		suite.addTestSuite(TC_ClassFinder.class);
		suite.addTestSuite(TC_ClassInstanciationFinder.class);
		suite.addTest(TS_RenameClassChecks.suite());
		return suite;
	}
}