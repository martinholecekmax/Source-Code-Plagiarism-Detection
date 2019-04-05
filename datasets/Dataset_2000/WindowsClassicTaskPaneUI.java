public class WindowsClassicTaskPaneUI extends BasicTaskPaneUI {
  public static ComponentUI createUI(JComponent c) {
    return new WindowsClassicTaskPaneUI();
  }
  @Override
protected void installDefaults() {
    super.installDefaults();
    LookAndFeel.installProperty(group, "opaque", false);
  }
  @Override
protected Border createPaneBorder() {
    return new ClassicPaneBorder();
  }
  
  class ClassicPaneBorder extends PaneBorder {
    @Override
protected void paintExpandedControls(JXTaskPane group, Graphics g, int x,
      int y, int width, int height) {
      ((Graphics2D)g).setRenderingHint(
        RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
      paintRectAroundControls(group, g, x, y, width, height, Color.white,
        Color.gray);
      g.setColor(getPaintColor(group));
      paintChevronControls(group, g, x, y, width, height);
      ((Graphics2D)g).setRenderingHint(
        RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_OFF);
    }
  }
}