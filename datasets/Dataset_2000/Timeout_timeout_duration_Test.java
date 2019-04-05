public class Timeout_timeout_duration_Test {
  @Test
  public void shouldReturnDurationPassedWhenCreated() {
    Timeout timeout = Timeout.timeout(2000);
    assertThat(timeout.duration()).isEqualTo(2000);
  }
  @Test
  public void shouldReturnDurationWhenCreatedWithTimeUnit() {
    Timeout timeout = Timeout.timeout(3, TimeUnit.SECONDS);
    assertThat(timeout.duration()).isEqualTo(3000);
  }
  @Test(expected = NullPointerException.class)
  public void shouldThrowExceptionIfTimeUnitIsNull() {
    Timeout.timeout(0, null);
  }
}