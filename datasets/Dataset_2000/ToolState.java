public class ToolState {
	private boolean busy = true;
	private boolean added = true;
	
	public void taskEnd(boolean success) {
		busy = false;
		added = success;
	}
	
	public boolean isBusy() {
		return busy;
	}
	
	public boolean isAdded() {
		return added;
	}
}