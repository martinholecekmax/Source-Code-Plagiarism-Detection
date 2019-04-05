public class JTabbedPaneFixture_stateVerification_Test extends StateVerificationFixture_TestCase<JTabbedPane> {
  private static JTabbedPane target;
  private JTabbedPaneDriver driver;
  private JTabbedPaneFixture fixture;
  @BeforeClass
  public static void setUpTarget() {
    target = tabbedPane().createNew();
  }
  @Override void onSetUp() {
    driver = createMock(JTabbedPaneDriver.class);
    fixture = new JTabbedPaneFixture(robot(), target);
    fixture.driver(driver);
  }
  @Override JTabbedPaneDriver driver() {  return driver; }
  @Override JTabbedPane target() { return target; }
  @Override JTabbedPaneFixture fixture() { return fixture; }
}