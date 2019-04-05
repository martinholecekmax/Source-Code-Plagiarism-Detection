public class UnitTesting {
  private static AtomicBoolean enabled = new AtomicBoolean(false);
  public static boolean isEnabled() {
    return enabled.get();
  }
  public static void setEnabled(boolean enabled) {
    UnitTesting.enabled.set(enabled);
  }
}