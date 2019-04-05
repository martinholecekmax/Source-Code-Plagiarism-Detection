public class JavaCCPrintVisitorTest extends AbstractNParser {
	@Before
	public void setUp() throws Exception {
	}
	@Test
	public void testJavaCCPrinterFJ() throws FileNotFoundException, ParseException{
		NGrammar g = parseFile("test/fj_fst.gcide");
		JavaCCPrintVisitor printVisitor=new JavaCCPrintVisitor(new PrintStream(new FileOutputStream("test/fj_fst.jj")));
		g.accept(new FSTInlineVisitor());
		g.accept(printVisitor);
	}
	@Test
	public void testJavaCCPrinterJava() throws FileNotFoundException, ParseException{
		NGrammar g = parseFile("test/java15_fst.gcide");
		JavaCCPrintVisitor printVisitor=new JavaCCPrintVisitor(new PrintStream(new FileOutputStream("test/java15_fst.jj")));
		g.accept(new FSTInlineVisitor());
		g.accept(printVisitor);
	}
}