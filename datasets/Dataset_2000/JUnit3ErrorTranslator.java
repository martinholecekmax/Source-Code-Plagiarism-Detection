public class JUnit3ErrorTranslator implements ExpectationErrorTranslator {
    public static final JUnit3ErrorTranslator INSTANCE = new JUnit3ErrorTranslator();
    public Error translate(ExpectationError e) {
        return new AssertionFailedError(StringDescription.toString(e));
    }
    private JUnit3ErrorTranslator() {}
}