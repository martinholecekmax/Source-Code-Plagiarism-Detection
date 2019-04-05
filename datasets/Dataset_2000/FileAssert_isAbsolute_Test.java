public class FileAssert_isAbsolute_Test {
  private Files files;
  private FileAssert assertions;
  @Before public void setUp() {
    files = mock(Files.class);
    assertions = new FileAssert(new File("abc"));
    assertions.files = files;
  }
  @Test public void should_verify_that_actual_is_absolute_path() {
    assertions.isAbsolute();
    verify(files).assertIsAbsolute(assertions.info, assertions.actual);
  }
  @Test public void should_return_this() {
    FileAssert returned = assertions.isAbsolute();
    assertSame(assertions, returned);
  }
}