public class FailedMethodError extends AssertionError {
	
	public FailedMethodError() {
	}
	
	public FailedMethodError(String message) {
		super(message);
	}
	
	public FailedMethodError(Throwable cause) {
		super(cause);
	}
}