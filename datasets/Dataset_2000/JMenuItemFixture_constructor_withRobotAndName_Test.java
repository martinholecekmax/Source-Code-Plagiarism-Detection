public class JMenuItemFixture_constructor_withRobotAndName_Test extends RobotBasedTestCase {
  private MyWindow window;
  @Override protected void onSetUp() {
    window = MyWindow.createNew();
  }
  @Test
  public void should_lookup_JMenuItem_by_name() {
    robot.showWindow(window);
    JMenuItemFixture fixture = new JMenuItemFixture(robot, "saveMenuItem");
    assertThat(fixture.robot).isSameAs(robot);
    assertThat(fixture.component()).isSameAs(window.menuItem);
  }
  @Test(expected = ComponentLookupException.class)
  public void should_throw_error_if_a_JMenuItem_with_matching_name_is_not_found() {
    new JMenuItemFixture(robot, "other");
  }
  private static class MyWindow extends TestWindow {
    private static final long serialVersionUID = 1L;
    static MyWindow createNew() {
      return execute(new GuiQuery<MyWindow>() {
        @Override protected MyWindow executeInEDT() {
          return new MyWindow();
        }
      });
    }
    final JMenuItem menuItem = new JMenuItem("Save");
    private MyWindow() {
      super(JMenuItemFixture_constructor_withRobotAndName_Test.class);
      menuItem.setName("saveMenuItem");
      setJMenuBar(createMenuBar());
    }
    private JMenuBar createMenuBar() {
      JMenuBar menuBar = new JMenuBar();
      JMenu topMenu = new JMenu("File");
      topMenu.add(menuItem);
      menuBar.add(topMenu);
      return menuBar;
    }
  }
}