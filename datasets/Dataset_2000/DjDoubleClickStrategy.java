public class DjDoubleClickStrategy extends PyDoubleClickStrategy {
    public static final char[] BRACKETS = { '{', '}', '(', ')', '[', ']', '<', '>' };
    public DjDoubleClickStrategy(String contentType) {
        super(contentType);
        fPairMatcher = new PythonPairMatcher(BRACKETS);
    }
}