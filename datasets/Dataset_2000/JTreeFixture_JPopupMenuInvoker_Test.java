public class JTreeFixture_JPopupMenuInvoker_Test extends JPopupMenuInvokerFixture_TestCase<JTree> {
  private static JTree target;
  private JTreeDriver driver;
  private JTreeFixture fixture;
  @BeforeClass
  public static void setUpTarget() {
    target = tree().createNew();
  }
  @Override void onSetUp() {
    driver = createMock(JTreeDriver.class);
    fixture = new JTreeFixture(robot(), target);
    fixture.driver(driver);
  }
  @Override JTreeDriver driver() {  return driver; }
  @Override JTree target() { return target; }
  @Override JTreeFixture fixture() { return fixture; }
}