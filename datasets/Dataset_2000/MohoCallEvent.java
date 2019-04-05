public abstract class MohoCallEvent extends MohoEvent<Call> implements CallEvent {
  protected MohoCallEvent(final Call source) {
    super(source);
  }
  public abstract boolean isProcessed();
  protected synchronized void checkState() {
    if (isProcessed()) {
      throw new IllegalStateException("Event is already processed and can not be processed.");
    }
  }
}