public class JListFixture_constructor_withRobotAndName_Test extends RobotBasedTestCase {
  private MyWindow window;
  @Override protected void onSetUp() {
    window = MyWindow.createNew();
  }
  @Test
  public void should_lookup_showing_JList_by_name() {
    robot.showWindow(window);
    JListFixture fixture = new JListFixture(robot, "list");
    assertThat(fixture.robot).isSameAs(robot);
    assertThat(fixture.component()).isSameAs(window.list);
  }
  @Test(expected = ComponentLookupException.class)
  public void should_throw_error_if_JList_with_matching_name_is_not_showing() {
    new JListFixture(robot, "list");
  }
  @Test(expected = ComponentLookupException.class)
  public void should_throw_error_if_a_JList_with_matching_name_is_not_found() {
    new JListFixture(robot, "other");
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
    final JList list = new JList(array("One"));
    private MyWindow() {
      super(JListFixture_constructor_withRobotAndName_Test.class);
      list.setName("list");
      list.setPreferredSize(new Dimension(100, 50));
      addComponents(list);
    }
  }
}