public class ArabicStemTokenFilterFactory extends AbstractTokenFilterFactory {
    @Inject
    public ArabicStemTokenFilterFactory(Index index, @IndexSettings Settings indexSettings, @Assisted String name, @Assisted Settings settings) {
        super(index, indexSettings, name, settings);
    }
    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new ArabicStemFilter(tokenStream);
    }
}