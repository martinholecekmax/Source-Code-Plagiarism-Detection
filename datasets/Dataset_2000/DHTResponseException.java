abstract class DHTResponseException extends DHTException {
    private final ResponseMessage response;
    public DHTResponseException(ResponseMessage response) {
        super();
        this.response = response;
    }
    public DHTResponseException(ResponseMessage response, String message, Throwable cause) {
        super(message, cause);
        this.response = response;
    }
    public DHTResponseException(ResponseMessage response, String message) {
        super(message);
        this.response = response;
    }
    public DHTResponseException(ResponseMessage response, Throwable cause) {
        super(cause);
        this.response = response;
    }
    public ResponseMessage getResponse() {
        return response;
    }
}