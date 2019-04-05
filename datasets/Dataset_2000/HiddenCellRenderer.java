public class HiddenCellRenderer implements KTableCellRenderer {
  @Override
  public int getOptimalWidth(GC gc, int col, int row, Object content,
      boolean fixed, KTableModel model) {
    return 0;
  }
  @Override
  public void drawCell(GC gc, Rectangle rect, int col, int row, Object content,
      boolean focus, boolean header, boolean clicked, KTableModel model) {
      }
}