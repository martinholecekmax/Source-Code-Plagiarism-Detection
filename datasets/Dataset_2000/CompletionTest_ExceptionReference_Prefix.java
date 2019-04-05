public class CompletionTest_ExceptionReference_Prefix  extends CompletionProposalsBaseTest{
	private final String fileName = "CompletionTestStart22.cpp";
	private final String fileFullPath ="resources/contentassist/" + fileName;
	private final String headerFileName = "CompletionTestStart.h";
	private final String headerFileFullPath ="resources/contentassist/" + headerFileName;
	private final String expectedPrefix = "a"; 
	private final String[] expectedResults = {
			"aClass",
			"anotherClass",
			"aNamespace",
			"anEnumeration",
			"AStruct",
			"AMacro(x)"
	};
	public CompletionTest_ExceptionReference_Prefix(String name) {
		super(name);
					}
	public static Test suite() {
		TestSuite suite= new TestSuite(CompletionTest_ExceptionReference_Prefix.class.getName());
		suite.addTest(new CompletionTest_ExceptionReference_Prefix("testCompletionProposals"));
		return suite;
	}		
	
	@Override
	protected int getCompletionPosition() {
		return getBuffer().indexOf(" a ") + 2;
	}
	
	@Override
	protected String getExpectedPrefix() {
		return expectedPrefix;
	}
	
	@Override
	protected String[] getExpectedResultsValues() {
		return expectedResults;
	}
	
	@Override
	protected String getFileName() {
		return fileName;
	}
	
	@Override
	protected String getFileFullPath() {
		return fileFullPath;
	}
	
	@Override
	protected String getHeaderFileFullPath() {
		return headerFileFullPath;
	}
	
	@Override
	protected String getHeaderFileName() {
		return headerFileName;
	}
}