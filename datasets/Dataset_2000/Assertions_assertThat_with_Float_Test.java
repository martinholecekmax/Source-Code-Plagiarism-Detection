public class Assertions_assertThat_with_Float_Test {
  @Test public void should_create_Assert() {
    Float zero = 0f;
    FloatAssert assertions = Assertions.assertThat(zero);
    assertNotNull(assertions);
  }
  @Test public void should_pass_actual() {
    Float eight = 8f;
    FloatAssert assertions = Assertions.assertThat(eight);
    assertSame(eight, assertions.actual);
  }
}