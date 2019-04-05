public class BloombergFXOptionVolatilitySurfaceInstrumentProviderBuilderFudgeEncodingTest extends FinancialTestBase {
  private static final String PREFIX = "EURJPY";
  private static final String POSTFIX = "Curncy";
  private static final String DATA_FIELD_NAME = "PX_LAST";
  @Test
  public void testCycle() {
    final BloombergFXOptionVolatilitySurfaceInstrumentProvider provider = new BloombergFXOptionVolatilitySurfaceInstrumentProvider(PREFIX, POSTFIX, DATA_FIELD_NAME);
    assertEquals(provider, cycleObject(BloombergFXOptionVolatilitySurfaceInstrumentProvider.class, provider));
  }
}