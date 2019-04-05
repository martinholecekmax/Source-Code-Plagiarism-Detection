public class TableInfoGame extends JTable {
	public class CellRendererInfoGame extends DefaultTableCellRenderer {
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			return this;
		}
	}
	public TableInfoGame(ISimulGameBoard gameBoard){
		super(new TableModelInfoGame(gameBoard));
		setDefaultRenderer(Object.class, new CellRendererInfoGame());
	}
}