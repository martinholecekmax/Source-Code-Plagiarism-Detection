public interface IStateUpdateListener {
	
	public void stateSaveUpdatesBegin(Object input);
	
	public void stateSaveUpdatesComplete(Object input);
	
    public void stateRestoreUpdatesBegin(Object input);
    
    public void stateRestoreUpdatesComplete(Object input);
	
	public void stateUpdateStarted(Object input, IViewerUpdate update);
	
	public void stateUpdateComplete(Object input, IViewerUpdate update);
}