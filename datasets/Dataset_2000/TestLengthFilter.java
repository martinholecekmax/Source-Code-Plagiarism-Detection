public class TestLengthFilter extends BaseTokenStreamTestCase {
  public void testFilterNoPosIncr() throws Exception {
    TokenStream stream = new MockTokenizer(
        new StringReader("short toolong evenmuchlongertext a ab toolong foo"), MockTokenizer.WHITESPACE, false);
    LengthFilter filter = new LengthFilter(false, stream, 2, 6);
    assertTokenStreamContents(filter,
      new String[]{"short", "ab", "foo"},
      new int[]{1, 1, 1}
    );
  }
  public void testFilterWithPosIncr() throws Exception {
    TokenStream stream = new MockTokenizer(
        new StringReader("short toolong evenmuchlongertext a ab toolong foo"), MockTokenizer.WHITESPACE, false);
    LengthFilter filter = new LengthFilter(true, stream, 2, 6);
    assertTokenStreamContents(filter,
      new String[]{"short", "ab", "foo"},
      new int[]{1, 4, 2}
    );
  }
  public void testEmptyTerm() throws IOException {
    Analyzer a = new Analyzer() {
      @Override
      protected TokenStreamComponents createComponents(String fieldName, Reader reader) {
        Tokenizer tokenizer = new KeywordTokenizer(reader);
        return new TokenStreamComponents(tokenizer, new LengthFilter(true, tokenizer, 0, 5));
      }
    };
    checkOneTermReuse(a, "", "");
  }
}