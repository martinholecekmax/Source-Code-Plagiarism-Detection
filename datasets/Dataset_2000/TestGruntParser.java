public class TestGruntParser {
  private GruntParser parser;
  private Map<String, String> override;
  @SuppressWarnings("serial")
  @Before
  public void setUp() {
    override = new HashMap<String, String>() {{
      put("STORE", "");
      put("DUMP", "");
    }};
    parser = new GruntParser(new StringReader(""), override);
  }
  @Test
  public void testRemoveStores() throws IOException {
    Assert.assertEquals("", parser.override("STORE output INTO '/path';"));
    override.remove("STORE");
    Assert.assertEquals(
        "STORE output INTO '/path';", parser.override("STORE output INTO '/path';"));
  }
  @Test
  public void testRemoveDumps() throws IOException {
    Assert.assertEquals("", parser.override("DUMP output;"));
    override.remove("DUMP");
    Assert.assertEquals("DUMP output;", parser.override("DUMP output;"));
  }
  @Test
  public void testReplaceLoad() throws IOException {
    override.put("A", "A = LOAD 'file';");
    Assert.assertEquals(
        "A = LOAD 'file';",
        parser.override("A = LOAD 'input.txt' AS (query:CHARARRAY);"));
  }
  @Test
  public void testGetStoreAlias() throws IOException {
    override.remove("STORE");
    parser.override("STORE output INTO '/path'");
    Assert.assertEquals("output", override.get("LAST_STORE_ALIAS"));
  }
}