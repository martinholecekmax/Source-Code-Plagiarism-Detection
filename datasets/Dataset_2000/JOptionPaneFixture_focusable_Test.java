public class JOptionPaneFixture_focusable_Test extends FocusableComponentFixture_TestCase<JOptionPane> {
  private static JOptionPane target;
  private JOptionPaneDriver driver;
  private JOptionPaneFixture fixture;
  @BeforeClass
  public static void setUpTarget() {
    target = optionPane().createNew();
  }
  @Override void onSetUp() {
    driver = createMock(JOptionPaneDriver.class);
    fixture = new JOptionPaneFixture(robot(), target);
    fixture.driver(driver);
  }
  @Override JOptionPaneDriver driver() {  return driver; }
  @Override JOptionPane target() { return target; }
  @Override JOptionPaneFixture fixture() { return fixture; }
}