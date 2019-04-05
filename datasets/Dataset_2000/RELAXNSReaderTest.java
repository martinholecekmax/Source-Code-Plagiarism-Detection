public class RELAXNSReaderTest extends TestCase
{
    public RELAXNSReaderTest( String name ) { super(name); }
    public static void main(java.lang.String[] args) {
        junit.textui.TestRunner.run(suite());
    }
    public static Test suite() {
        return new TestSuite(RELAXNSReaderTest.class);
    }
    
    public void testMessages() throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        final RELAXNSReader reader = new RELAXNSReader(null,factory,null);
        Checker checker = new Checker(){
            public void check( String propertyName ) {
                                System.out.println(
                    reader.localizeMessage(propertyName,new Object[]{"@@@","@@@","@@@","@@@","@@@"}));
            }
        };
        String prefixes[] = new String[]{"ERR_","WRN_"};
        for( int i=0; i<prefixes.length; i++ ) {
            ResourceChecker.check( RELAXNSReader.class, prefixes[i], checker );
            ResourceChecker.check( RELAXReader.class, prefixes[i], checker );
            ResourceChecker.check( GrammarReader.class, prefixes[i], checker );
        }
    }
}