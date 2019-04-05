public class GprofParserTest extends TestCase{
	private static final String GMON_BINARY_FILE = "a.out"; 
	private static final String GMON_OUTPUT_FILE = "gmon.out"; 
	private static final String GMON_DIRECTORY_SUFFIX = "_gprof_input";
	public GprofParserTest() {
	}
	public static Test suite() {
		TestSuite ats = new TestSuite("Test gmon Parser");
		File[] testDirs = STJunitUtils.getTestDirs("org.eclipse.linuxtools.gprof.test", ".*" + GMON_DIRECTORY_SUFFIX);
		for (File testDir : testDirs) {
			final File logFile = new File(testDir, GMON_OUTPUT_FILE);
			final File binaryFile = new File(testDir, GMON_BINARY_FILE);
			final File parserRefFile = new File(testDir, "testParse.ref");
			final File parserDumpFile = new File(testDir, "testParse.dump");
			ats.addTest(
					new TestCase(testDir.getName() + ":Parser") {
						@Override
						public void runTest() throws Throwable {
							testProcessGmonFile(logFile, binaryFile, parserRefFile, parserDumpFile);
						}
					}
			);
		}	
		return ats;
	}
	public static void testProcessGmonFile(File gmonFile, File binaryFile, File parserRefFile, File parserDumpFile) throws Exception {
		IBinaryObject binary = STSymbolManager.sharedInstance.getBinaryObject(binaryFile.getAbsolutePath());
		final GmonDecoder gmondecoder = new GmonDecoder(binary, new PrintStream(parserDumpFile), null);
		gmondecoder.setShouldDump(true);	
		gmondecoder.read(gmonFile.getAbsolutePath());
		STJunitUtils.compareIgnoreEOL(parserDumpFile.getAbsolutePath(), parserRefFile.getAbsolutePath(), true);
	}
}