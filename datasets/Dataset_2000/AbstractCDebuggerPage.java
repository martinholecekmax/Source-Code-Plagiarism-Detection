abstract public class AbstractCDebuggerPage extends AbstractLaunchConfigurationTab 
    implements ICDebuggerPage, ICDebuggerPageExtension {
	private String fDebuggerID = null;
	private ListenerList fContentListeners;
    public AbstractCDebuggerPage() {
        super();
        fContentListeners = new ListenerList();
    }
    
	@Override
	public void init(String debuggerID) {
		fDebuggerID = debuggerID;
	}
    
    @Override
    public void dispose() {
        fContentListeners.clear();
        super.dispose();
    }
    
	@Override
	public String getDebuggerIdentifier() {
		return fDebuggerID;
	}
    
    
    @Override
	public void addContentChangeListener(IContentChangeListener listener) {
        fContentListeners.add(listener);
    }
    
    
    @Override
	public void removeContentChangeListener(IContentChangeListener listener) {
        fContentListeners.remove(listener);
    }
    
    protected void contentChanged() {
        for (Object listener : fContentListeners.getListeners())
            ((IContentChangeListener) listener).contentChanged();
    }
}