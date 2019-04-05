public class ParentFinder_parentOf_Test extends SequentialEDTSafeTestCase {
  private ParentFinder finder;
  @Override protected final void onSetUp() {
    finder = new ParentFinder();
  }
  @Test
  public void should_return_parent_of_Component() {
    final MyWindow window = MyWindow.createNew();
    try {
      Container parent = findParent(finder, window.textField);
      assertThat(parent).isSameAs(contentPaneOf(window));
    } finally {
      window.destroy();
    }
  }
  private static class MyWindow extends TestWindow {
    private static final long serialVersionUID = 1L;
    @RunsInEDT
    static MyWindow createNew() {
      return execute(new GuiQuery<MyWindow>() {
        @Override protected MyWindow executeInEDT() {
          return new MyWindow();
        }
      });
    }
    final JTextField textField = new JTextField();
    private MyWindow() {
      super(ParentFinder_parentOf_Test.class);
      addComponents(textField);
    }
  }
  @Test
  public void should_return_parent_of_JInternalFrame() {
    TestMdiWindow window = TestMdiWindow.createNewWindow(getClass());
    JInternalFrame internalFrame = window.internalFrame();
    try {
      assertThat(findParent(finder, internalFrame)).isNotNull()
                                                   .isSameAs(desktopPaneOf(internalFrame));
    } finally {
      window.destroy();
    }
  }
  @RunsInEDT
  private static Container findParent(final ParentFinder finder, final Component c) {
    return execute(new GuiQuery<Container>() {
      @Override protected Container executeInEDT() {
        return finder.parentOf(c);
      }
    });
  }
  @RunsInEDT
  private static JDesktopPane desktopPaneOf(final JInternalFrame internalFrame) {
    return execute(new GuiQuery<JDesktopPane>() {
      @Override protected JDesktopPane executeInEDT() {
        return internalFrame.getDesktopIcon().getDesktopPane();
      }
    });
  }
}