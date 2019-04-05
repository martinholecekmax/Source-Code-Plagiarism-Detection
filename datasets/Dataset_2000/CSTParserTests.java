public class CSTParserTests extends AbstractCSTParserTests {
	private static Bundle bundle;
	@BeforeClass
	public static void setUp() throws Exception {
		bundle = Platform.getBundle("org.eclipse.acceleo.parser.tests"); 	}
	@AfterClass
	public static void tearDown() throws Exception {
		bundle = null;
	}
	private File createFile(String pathName) {
		try {
			String fileLocation = FileLocator.resolve(bundle.getEntry(pathName)).getPath();
			return new File(fileLocation);
		} catch (IOException e) {
			throw new AssertionFailedError(e.getMessage());
		} catch (NullPointerException e) {
			
			throw new AssertionFailedError(e.getMessage());
		}
	}
	@Test
	public void testParseFileLibrary2textAcceleo() {
		File file = createFile("/data/template/cstParserLibrary2text.mtl"); 		checkCSTParsing(file, 0, 3, 0);
	}
	@Test
	public void testParseEmptyBuffer() {
		StringBuffer buffer = new StringBuffer(""); 		checkCSTInvalidParsing(buffer, 0, 0, 1);
	}
																												}