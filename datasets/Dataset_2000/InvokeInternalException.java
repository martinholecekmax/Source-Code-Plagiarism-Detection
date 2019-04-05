public class InvokeInternalException extends AbstractException {
  
  private static final long serialVersionUID = 1L;
  public InvokeInternalException(final Throwable cause) {
    this(cause.getMessage(), cause);
  }
  public InvokeInternalException(final String message) {
    super(Constants.ERROR_INTERNAL);
    setStringValue(message);
  }
  public InvokeInternalException(final String message, final Throwable cause) {
    super(Constants.ERROR_INTERNAL, cause);
    setStringValue(message);
  }
  public String getMessage() {
    return getStringValue();
  }
}