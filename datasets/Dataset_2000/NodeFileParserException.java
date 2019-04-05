public class NodeFileParserException extends Exception {
    public NodeFileParserException() {
        super();
    }
    public NodeFileParserException(final String msg) {
        super(msg);
    }
    public NodeFileParserException(final Exception cause) {
        super(cause);
    }
    public NodeFileParserException(final String msg, final Exception cause) {
        super(msg, cause);
    }
}