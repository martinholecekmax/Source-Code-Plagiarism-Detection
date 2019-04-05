public class ListAssert_usingComparator_Test extends ListAssertBaseTest {
  @Mock
  private Comparator<List<String>> comparator;
  @Before
  public void before() {
    initMocks(this);
  }
  @Override
  protected ListAssert<String> invoke_api_method() {
    return assertions.usingComparator(comparator);
  }
  @Override
  protected void verify_internal_effects() {
    assertSame(getObjects(assertions).getComparator(), comparator);
  }
}