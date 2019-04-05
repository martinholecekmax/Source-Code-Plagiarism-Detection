public class ObjectArrayAssert_actualAsList_Test {
  private static ObjectArrayAssert assertions;
  @BeforeClass public static void setUpOnce() {
    Object[] actual = { "Luke", "Yoda", "Leia" };
    assertions = new ObjectArrayAssert(actual);
  }
  @Test public void should_return_List_with_contents_in_actual() {
    List<Object> list = assertions.actualAsList();
    assertEquals(list(assertions.actual), list);
  }
}