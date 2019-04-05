public class ExposeAnnotationSerializationExclusionStrategyTest extends TestCase {
  private ExposeAnnotationSerializationExclusionStrategy strategy;
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    strategy = new ExposeAnnotationSerializationExclusionStrategy();
  }
  public void testNeverSkipClasses() throws Exception {
    assertFalse(strategy.shouldSkipClass(MockObject.class));
  }
  public void testSkipNonAnnotatedFields() throws Exception {
    Field f = MockObject.class.getField("hiddenField");
    assertTrue(strategy.shouldSkipField(new FieldAttributes(f)));
  }
  public void testSkipExplicitlySkippedFields() throws Exception {
    Field f = MockObject.class.getField("explicitlyHiddenField");
    assertTrue(strategy.shouldSkipField(new FieldAttributes(f)));
  }
  public void testNeverSkipExposedAnnotatedFields() throws Exception {
    Field f = MockObject.class.getField("exposedField");
    assertFalse(strategy.shouldSkipField(new FieldAttributes(f)));
  }
  public void testNeverSkipExplicitlyExposedAnnotatedFields() throws Exception {
    Field f = MockObject.class.getField("explicitlyExposedField");
    assertFalse(strategy.shouldSkipField(new FieldAttributes(f)));
  }
  @SuppressWarnings("unused")
  private static class MockObject {
    @Expose
    public final int exposedField = 0;
    @Expose(serialize=true)
    public final int explicitlyExposedField = 0;
    @Expose(serialize=false)
    public final int explicitlyHiddenField = 0;
    public final int hiddenField = 0;
  }
}