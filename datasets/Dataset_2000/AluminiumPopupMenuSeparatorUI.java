public class AluminiumPopupMenuSeparatorUI extends BasicSeparatorUI {
    private static final Dimension size = new Dimension(1, 1);
    public static ComponentUI createUI(JComponent c) {
        return new AluminiumPopupMenuSeparatorUI();
    }
    public void paint(Graphics g, JComponent c) {
        boolean horizontal = true;
        if (c instanceof JSeparator) {
            JSeparator sep = ((JSeparator) c);
            horizontal = (sep.getOrientation() == JSeparator.HORIZONTAL);
        }
        if (horizontal) {
            g.setColor(Color.lightGray);
            g.drawLine(0, 0, c.getWidth(), 0);
        } else {
            g.setColor(Color.lightGray);
            g.drawLine(0, 0, 0, c.getHeight());
        }
    }
    public Dimension getPreferredSize(JComponent c) {
        return size;
    }
}