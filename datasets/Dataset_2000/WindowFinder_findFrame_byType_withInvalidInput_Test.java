public class WindowFinder_findFrame_byType_withInvalidInput_Test {
  @Test(expected = NullPointerException.class)
  public void should_throw_error_if_type_is_null() {
    Class<WindowToLaunch> type = null;
    WindowFinder.findFrame(type);
  }
  @Test(expected = IllegalArgumentException.class)
  public void should_throw_error_if_timeout_is_negative() {
    WindowFinder.findFrame(JFrame.class).withTimeout(-20);
  }
  @Test(expected = NullPointerException.class)
  public void should_throw_error_if_time_unit_is_null() {
    WindowFinder.findFrame(JFrame.class).withTimeout(10, null);
  }
}