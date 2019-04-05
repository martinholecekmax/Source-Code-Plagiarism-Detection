public class SafeHtmlBuilderTest extends GwtSafeHtmlBuilderTest {
    @Override
  public String getModuleName() {
    return null;
  }
  @Override
  protected void gwtSetUp() throws Exception {
    super.gwtSetUp();
                SafeHtmlHostedModeUtils.setForceCheckCompleteHtml(true);
  }
}