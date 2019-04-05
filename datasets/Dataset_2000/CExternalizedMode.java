public class CExternalizedMode extends ExternalizedMode<CExternalizedModeArea> implements CLocationMode {
	
	private LocationModeActionProvider externalize;
	
	private LocationModeActionProvider unmaximize;
	
	public CExternalizedMode( CControl control ){
		externalize = new KeyedLocationModeActionProvider( CDockable.ACTION_KEY_EXTERNALIZE, new CExternalizeAction( control ));
		unmaximize = new KeyedLocationModeActionProvider( CDockable.ACTION_KEY_UNMAXIMIZE_EXTERNALIZED, new CUnmaximizeExternalizedAction( control ));
		setActionProvider( new MappingLocationModeActionProvider() {
			protected LocationModeActionProvider getProvider( Dockable dockable, Mode<Location> currentMode, DockActionSource currentSource ){
				if( currentMode instanceof CMaximizedMode ){
					if( ((CMaximizedMode)currentMode).getUnmaximizedMode( dockable ) instanceof CExternalizedMode ){
						return unmaximize;
					}
				}
				return externalize;
			}
		});
	}
	public CLocation getCLocation( Dockable dockable ){
		CExternalizedModeArea area = get( dockable );
		if( area == null )
			return null;
		return area.getCLocation( dockable );
	}
	public CLocation getCLocation( Dockable dockable, Location location ){
		CModeArea area = get( location.getRoot() );
		if( area == null )
			return null;
		return area.getCLocation( dockable, location );
	}
	public boolean isBasicMode(){
		return true;
	}
	public boolean respectWorkingAreas( DockStation station ){
		CModeArea area = get( station );
		if( area == null ){
			return true;
		}
		return area.respectWorkingAreas();
	}
	public LocationModePerspective createPerspective(){
		return new CExternalizedModePerspective();
	}
}