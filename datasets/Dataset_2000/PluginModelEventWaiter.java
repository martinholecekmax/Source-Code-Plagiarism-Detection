public class PluginModelEventWaiter extends AbstractApiEventWaiter implements IPluginModelListener {
	private int fKind = -1;
	
	public PluginModelEventWaiter(int kind) {
		this.fKind = kind;
		PDECore.getDefault().getModelManager().addPluginModelListener(this);
	}
	
	public synchronized void modelsChanged(PluginModelDelta delta) {
		if(delta.getKind() == fKind) {
			setEvent(delta);
			notifyAll();
			unregister();
		}
	}
	
	protected void unregister() {
		PDECore.getDefault().getModelManager().removePluginModelListener(this);
	}
}