public class TextEditorProperties implements ITextEditorProperties {
  private final IResources resources;
  public TextEditorProperties(IResources resources) {
    this.resources = resources;
  }
  @Override
  public void initBoldAction(Action action) {
    initWithIcon(action, new Font("Serif", Font.BOLD, 12), resources.getString("TextEditor.BoldLetter"));   }
  @Override
  public void initItalicAction(Action action) {
    initWithIcon(action, new Font("Serif", Font.ITALIC, 12), resources.getString("TextEditor.ItalicsLetter"));   }
  @Override
  public void initUnderlineAction(Action action) {
    action.putValue(Action.SMALL_ICON, new PlotUI(resources).getUnderlineButtonIcon());
  }
  private void initWithIcon(final Action action, final Font font, final String letter) {
    action.putValue(Action.SMALL_ICON, new Icon() {
      private static final int SIZE = 16;
      @Override
      public int getIconHeight() {
        return SIZE;
      }
      @Override
      public int getIconWidth() {
        return SIZE;
      }
      @Override
      public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setFont(font);
        if (action.isEnabled()) {
          g.setColor(SystemColor.textText);
        }
        else {
          g.setColor(SystemColor.textInactiveText);
        }
        FontMetrics fontMetrics = g.getFontMetrics(font);
        int width = (int) fontMetrics.getStringBounds(letter, g).getWidth();
        int xpos = x + (SIZE - width) / 2;
        int ypos = y - 3 + SIZE - (SIZE - fontMetrics.getAscent()) / 2;
        g.drawString(letter, xpos, ypos);
      }
    });
  }
}