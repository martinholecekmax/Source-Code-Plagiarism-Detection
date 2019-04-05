public class JinxException extends java.lang.Exception {
    private int errorCode;
    private String errorMessage;
    
    public JinxException() {
    }
    
    public JinxException(String msg) {
	super(msg);
    }
    
    public JinxException(String msg, Throwable cause) {
	super(msg, cause);
    }
    public JinxException(String msg, Throwable cause, int errorCode, String errorMessage) {
	super(msg, cause);
	this.errorCode = errorCode;
	this.errorMessage = errorMessage;
    }
    
    public int getErrorCode() {
	return errorCode;
    }
    
    public void setErrorCode(int errorCode) {
	this.errorCode = errorCode;
    }
    
    public String getErrorMessage() {
	return errorMessage;
    }
    
    public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
    }
}