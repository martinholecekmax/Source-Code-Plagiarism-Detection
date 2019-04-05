public class ObjectArrays_assertHasSize_Test {
  @Rule public ExpectedException thrown = none();
  private Failures failures;
  private ObjectArrays arrays;
  @Before public void setUp() {
    failures = spy(new Failures());
    arrays = new ObjectArrays();
    arrays.failures = failures;
  }
  @Test public void should_fail_if_actual_is_null() {
    thrown.expectAssertionError(actualIsNull());
    arrays.assertHasSize(someInfo(), null, 6);
  }
  @Test public void should_fail_if_size_of_actual_is_not_equal_to_expected_size() {
    AssertionInfo info = someInfo();
    Character[] actual = new Character[2];
    try {
      arrays.assertHasSize(info, actual, 6);
    } catch (AssertionError e) {
      verify(failures).failure(info, shouldHaveSize(actual, actual.length, 6));
      return;
    }
    throw expectedAssertionErrorNotThrown();
  }
  @Test public void should_pass_if_size_of_actual_is_equal_to_expected_size() {
    Byte[] actual = new Byte[2];
    arrays.assertHasSize(someInfo(), actual, 2);
  }
}