public class Longs_assertGreaterThanOrEqualTo_Test {
  @Rule public ExpectedException thrown = none();
  private Failures failures;
  private Longs longs;
  @Before public void setUp() {
    failures = spy(new Failures());
    longs = new Longs();
    longs.failures = failures;
  }
  @Test public void should_fail_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull());
    longs.assertGreaterThanOrEqualTo(someInfo(), null, 8L);
  }
  @Test public void should_pass_if_actual_is_greater_than_other() {
    longs.assertGreaterThanOrEqualTo(someInfo(), 8L, 6L);
  }
  @Test public void should_pass_if_actual_is_equal_to_other() {
    longs.assertGreaterThanOrEqualTo(someInfo(), 6L, 6L);
  }
  @Test public void should_fail_if_actual_is_less_than_other() {
    AssertionInfo info = someInfo();
    try {
      longs.assertGreaterThanOrEqualTo(info, 6L, 8L);
    } catch (AssertionError e) {
      verify(failures).failure(info, shouldBeGreaterOrEqual(6L, 8L));
      return;
    }
    throw expectedAssertionErrorNotThrown();
  }
}