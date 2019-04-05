public class ToolbarDockStationSample implements DropSample{
	private ToolbarDockStation station;
	private Dockable dockable = new ToolbarItemDockable();
	public ToolbarDockStationSample(){
		station = new ToolbarDockStation();
		DockController controller = new DockController();
		controller.add( station );
	}
	@Override
	public ToolbarDockStation getStation(){
		return station;
	}
	@Override
	public Component getComponent(){
		return station.getComponent();
	}
	@Override
	public Color dropAt( int mouseX, int mouseY ){
		StationDropItem item = new StationDropItem( mouseX, mouseY, mouseX, mouseY, dockable );
		StationDropOperation operation = station.prepareDrop( item );
		if( operation == null ){
			return Color.BLACK;
		}
		else{
			ToolbarDropInfo info = (ToolbarDropInfo)operation;
			int index = info.getIndex();
			index %= 2;
			if( index == 0 ){
				return Color.RED;
			}
			else if( index == 1 ){
				return Color.BLUE;
			}
			return Color.WHITE;
		}
	}
}