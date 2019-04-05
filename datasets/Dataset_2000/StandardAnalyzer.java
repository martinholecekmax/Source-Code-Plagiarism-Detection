public final class StandardAnalyzer extends StopwordAnalyzerBase {
  
  public static final int DEFAULT_MAX_TOKEN_LENGTH = 255;
  private int maxTokenLength = DEFAULT_MAX_TOKEN_LENGTH;
  
  public static final CharArraySet STOP_WORDS_SET = StopAnalyzer.ENGLISH_STOP_WORDS_SET; 
  
  public StandardAnalyzer(Version matchVersion, CharArraySet stopWords) {
    super(matchVersion, stopWords);
  }
  
  public StandardAnalyzer(Version matchVersion) {
    this(matchVersion, STOP_WORDS_SET);
  }
  
  public StandardAnalyzer(Version matchVersion, Reader stopwords) throws IOException {
    this(matchVersion, loadStopwordSet(stopwords, matchVersion));
  }
  
  public void setMaxTokenLength(int length) {
    maxTokenLength = length;
  }
  
  public int getMaxTokenLength() {
    return maxTokenLength;
  }
  @Override
  protected TokenStreamComponents createComponents(final String fieldName, final Reader reader) {
    final StandardTokenizer src = new StandardTokenizer(matchVersion, reader);
    src.setMaxTokenLength(maxTokenLength);
    TokenStream tok = new StandardFilter(matchVersion, src);
    tok = new LowerCaseFilter(matchVersion, tok);
    tok = new StopFilter(matchVersion, tok, stopwords);
    return new TokenStreamComponents(src, tok) {
      @Override
      protected void setReader(final Reader reader) throws IOException {
        src.setMaxTokenLength(StandardAnalyzer.this.maxTokenLength);
        super.setReader(reader);
      }
    };
  }
}