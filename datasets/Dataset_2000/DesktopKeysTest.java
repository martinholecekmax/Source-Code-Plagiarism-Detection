@Ignore(products = {CORE, MINI, MOBILE, SDK})
public class DesktopKeysTest extends OperaDesktopDriverTestCase {
  public final List<SystemInputProtos.ModifierPressed> ctrlModifier =
      ImmutableList.of(SystemInputProtos.ModifierPressed.CTRL);
  public int windowCountBefore;
  @Before
  public void beforeEach() {
    windowCountBefore = driver.getQuickWindowCount();
  }
  @Test
  public void keyPress() {
    driver.keyPress("t", ctrlModifier);
    driver.waitForWindowActivated();
    assertEquals(windowCountBefore + 1, driver.getQuickWindowCount());
  }
  @Test
  public void keyDownUp() {
    driver.keyDown("w", ctrlModifier);
    driver.keyUp("w", ctrlModifier);
    assertEquals(windowCountBefore - 1, driver.getQuickWindowCount());
  }
}