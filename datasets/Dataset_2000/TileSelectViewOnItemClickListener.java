public class TileSelectViewOnItemClickListener implements AdapterView.OnItemClickListener {
	private AlertDialog dialog;
	private TiledMapView view;
	private int row;
	private int column;
	@Override
	public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		String path = (String) ((ImageAdapter) parent.getAdapter()).getItem(position);
		view.setTile(row, column, path);
		dialog.dismiss();
	}
	
	public void setDialog(AlertDialog dialog) {
		this.dialog = dialog;
	}
	public void setView(TiledMapView view) {
		this.view = view;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public void setColumn(int column) {
		this.column = column;
	}
}