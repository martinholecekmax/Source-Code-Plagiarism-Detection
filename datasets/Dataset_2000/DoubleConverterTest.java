public class DoubleConverterTest {
  private final DoubleConverter _converter = new DoubleConverter();
  @Test
  public void convert() {
    Map<String, Double> expected = new HashMap<String, Double>();
    expected.put("Foo", 5.5);
    Map<String, Double> actual = _converter.convert("Foo", 5.5);
    assertEquals(expected, actual);
  }
  @Test
  public void getConvertedClass() {
    assertEquals(Double.class, _converter.getConvertedClass());  
  }
}