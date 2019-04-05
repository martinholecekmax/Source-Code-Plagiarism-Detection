public class JSliderFixture_constructor_withRobotAndName_Test extends RobotBasedTestCase {
  private MyWindow window;
  @Override protected void onSetUp() {
    window = MyWindow.createNew();
  }
  @Test
  public void should_lookup_showing_JSlider_by_name() {
    robot.showWindow(window);
    JSliderFixture fixture = new JSliderFixture(robot, "slider");
    assertThat(fixture.robot).isSameAs(robot);
    assertThat(fixture.component()).isSameAs(window.slider);
  }
  @Test(expected = ComponentLookupException.class)
  public void should_throw_error_if_JSlider_with_matching_name_is_not_showing() {
    new JSliderFixture(robot, "slider");
  }
  @Test(expected = ComponentLookupException.class)
  public void should_throw_error_if_a_JSlider_with_matching_name_is_not_found() {
    new JSliderFixture(robot, "other");
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
    final JSlider slider = new JSlider(6, 10, 8);
    private MyWindow() {
      super(JSliderFixture_constructor_withRobotAndName_Test.class);
      slider.setName("slider");
      addComponents(slider);
    }
  }
}