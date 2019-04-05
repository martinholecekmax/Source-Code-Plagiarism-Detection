public class ChromatticIOException extends ChromatticException {
  public ChromatticIOException() {
  }
  public ChromatticIOException(String message) {
    super(message);
  }
  public ChromatticIOException(String message, IOException rootCause) {
    super(message, rootCause);
  }
  public ChromatticIOException(IOException rootCause) {
    super(rootCause);
  }
  @Override
  public Throwable initCause(Throwable cause) {
    if (cause instanceof IOException) {
      return super.initCause(cause);
    } else {
      throw new Error();
    }
  }
  @Override
  public IOException getCause() {
    return (IOException)super.getCause();
  }
}