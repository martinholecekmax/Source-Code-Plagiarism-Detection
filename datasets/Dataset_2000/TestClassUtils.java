public class TestClassUtils {
  public static class MyCollection extends AbstractList<String> {
    private final String val;
    public MyCollection() {
      this.val = "null";
    }
    public MyCollection(String a) {
      this.val = a;
    }
    public MyCollection(String a, String b) {
      this.val = a + b;
    }
    public MyCollection(Integer i, Integer j, Integer k) {
      this.val = "i" + (i + j + k);
    }
    public String get(int i) {
      if ( i == 0 ) {
        return this.val;
      } else {
        throw new IndexOutOfBoundsException();
      }
    }
    public Iterator<String> iterator() {
      return Collections.singleton(this.val).iterator();
    }
    public int size() {
      return 1;
    }
  }
  @Test public void testNewInstanceOfWithStringArguments() {
    assertEquals(Arrays.asList(new String[]{"a"}),
                 ClassUtils.newInstanceOf("org.wikimedia.revdiffsearch.TestClassUtils$MyCollection(a)", Arrays.asList(new String[]{"fail"}),
                                          Collection.class));
    assertEquals(Arrays.asList(new String[]{"xy"}),
                 ClassUtils.newInstanceOf("org.wikimedia.revdiffsearch.TestClassUtils$MyCollection(x,y)", Arrays.asList(new String[]{"fail"}),
                                          Collection.class));
    assertEquals(Arrays.asList(new String[]{"fail"}),
                 ClassUtils.newInstanceOf("org.wikimedia.revdiffsearch.TestClassUtils$MyCollectionX(a)", Arrays.asList(new String[]{"fail"}),
                                          Collection.class));
  }
  @Test public void testNewInstanceOfWithIntegerArguments() {
              }
  @Test public void testParseValue() {
    assertEquals(2,   ClassUtils.parseValue("2", int.class));
    assertEquals(new Integer(2),  ClassUtils.parseValue("2", Integer.class));
    assertEquals("2", ClassUtils.parseValue("2", String.class));
  }
}