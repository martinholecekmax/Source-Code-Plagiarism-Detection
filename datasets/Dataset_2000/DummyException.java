public class DummyException extends Exception {
    String reason = "dummyReason";
    public String getReason() {
        return reason;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }
}