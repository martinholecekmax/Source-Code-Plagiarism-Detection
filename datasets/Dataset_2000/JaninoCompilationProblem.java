public final class JaninoCompilationProblem implements CompilationProblem {
    private final Location location;
    private final String fileName;
    private final String message;
    private final boolean error;
    public JaninoCompilationProblem(final LocatedException pLocatedException) {
        this(pLocatedException.getLocation(), pLocatedException.getMessage(), true);
    }
    public JaninoCompilationProblem(final Location pLocation, final String pMessage, final boolean pError) {
      this(pLocation.getFileName(), pLocation, pMessage, pError);
    }
    public JaninoCompilationProblem(final String pFilename, final String pMessage, final boolean pError) {
        this(pFilename, null, pMessage, pError);
    }
    public JaninoCompilationProblem(final String pFilename, final Location pLocation, final String pMessage, final boolean pError) {
        location = pLocation;
        fileName = pFilename;
        message = pMessage;
        error = pError;
    }
    public boolean isError() {
        return error;
    }
    public String getFileName() {
        return fileName;
    }
    public int getStartLine() {
        if (location == null) {
            return 0;
        }
        return location.getLineNumber();
    }
    public int getStartColumn() {
        if (location == null) {
            return 0;
        }
        return location.getColumnNumber();
    }
    public int getEndLine() {
        return getStartLine();
    }
    public int getEndColumn() {
        return getStartColumn();
    }
    public String getMessage() {
        return message;
    }
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(getFileName()).append(" (");
        sb.append(getStartLine());
        sb.append(":");
        sb.append(getStartColumn());
        sb.append(") : ");
        sb.append(getMessage());
        return sb.toString();
    }
}