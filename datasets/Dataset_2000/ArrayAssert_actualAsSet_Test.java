public class ArrayAssert_actualAsSet_Test {
  private static IntArrayAssert assertions;
  @BeforeClass public static void setUpOnce() {
    int[] actual = { 6, 8, 10 };
    assertions = new IntArrayAssert(actual);
  }
  @Test public void should_return_Set_with_contents_in_actual() {
    List<Object> list = new ArrayList<Object>(assertions.actualAsSet());
    int size = assertions.actual.length;
    for (int i = 0; i < size; i++)
      assertEquals(new Integer(assertions.actual[i]), list.get(i));
  }
}