@Immutable
public class DefaultHttpRequestParserFactory implements NHttpMessageParserFactory<HttpRequest> {
    public static final NHttpMessageParserFactory<HttpRequest> INSTANCE = new DefaultHttpRequestParserFactory();
    private final LineParser lineParser;
    private final HttpRequestFactory requestFactory;
    public DefaultHttpRequestParserFactory(final LineParser lineParser,
            final HttpRequestFactory requestFactory) {
        super();
        this.lineParser = lineParser != null ? lineParser : BasicLineParser.INSTANCE;
        this.requestFactory = requestFactory != null ? requestFactory
                : DefaultHttpRequestFactory.INSTANCE;
    }
    public DefaultHttpRequestParserFactory() {
        this(null, null);
    }
    public NHttpMessageParser<HttpRequest> create(final SessionInputBuffer buffer,
            final MessageConstraints constraints) {
        return new DefaultHttpRequestParser(buffer, lineParser, requestFactory, constraints);
    }
}