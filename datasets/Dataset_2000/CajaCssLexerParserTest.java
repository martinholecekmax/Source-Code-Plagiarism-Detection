public class CajaCssLexerParserTest extends Assert {
  private CajaCssLexerParser cajaCssParser;
  private static final String CSS = "@import url('www.example.org/someother.css');\n" +
      ".xyz { background-image : url(http:      "A { color : #7f7f7f }\n";
  @Before
  public void setUp() throws Exception {
    cajaCssParser = new CajaCssLexerParser();
  }
  @Test
  public void testBasicCssParse() throws Exception {
    String css = ".xyz { font : bold; } A { color : #7f7f7f }";
    List<Object> styleSheet = cajaCssParser.parse(css);
    assertEquals(cajaCssParser.serialize(styleSheet), css); 
  }
  @Test
  public void testClone() throws Exception {
        cajaCssParser.setCacheProvider(new LruCacheProvider(100));
        List<Object> styleSheet = cajaCssParser.parseImpl(CSS);
    List<Object> styleSheet2 = cajaCssParser.parse(CSS);
    assertEquals(cajaCssParser.serialize(styleSheet), cajaCssParser.serialize(styleSheet2));
  }
  @Test
  public void testCache() throws Exception {
    cajaCssParser.setCacheProvider(new LruCacheProvider(100));
            List<Object> styleSheet = cajaCssParser.parse(CSS);
    List<Object> styleSheet2 = cajaCssParser.parse(CSS);
    assertFalse(styleSheet.equals(styleSheet2));
    assertEquals(cajaCssParser.serialize(styleSheet), cajaCssParser.serialize(styleSheet2));
  }
}