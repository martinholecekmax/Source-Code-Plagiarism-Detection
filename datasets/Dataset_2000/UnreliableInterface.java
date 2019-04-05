public interface UnreliableInterface {
  public static class UnreliableException extends Exception {
      }
  public static class FatalException extends UnreliableException {
      }
  void alwaysSucceeds() throws UnreliableException;
  void alwaysFailsWithFatalException() throws FatalException;
  void alwaysFailsWithRemoteFatalException() throws RemoteException;
  void failsOnceThenSucceeds() throws UnreliableException;
  boolean failsOnceThenSucceedsWithReturnValue() throws UnreliableException;
  void failsTenTimesThenSucceeds() throws UnreliableException;
}