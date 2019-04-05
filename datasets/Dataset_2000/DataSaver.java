public class DataSaver 
	extends MetadataLoader
{
	
	private Collection<DataObject>	data;
	
	private List<AnnotationData> 	toAdd;
	
	private List<Object> 	toRemove;
	
	private List<Object> 			acquisitionMetadata;
	
    private CallHandle  handle;
	
	public DataSaver(MetadataViewer viewer, SecurityContext ctx,
		Collection<DataObject> data, List<AnnotationData> toAdd,
		List<Object> toRemove, List<Object> acquisitionMetadata)
	{
		super(viewer, ctx, null);
		if (data == null)
			throw new IllegalArgumentException("No object specified.");
		this.data = data;
		this.toAdd = toAdd;
		this.toRemove = toRemove;
		this.acquisitionMetadata = acquisitionMetadata;
	}
	
	public void load()
	{
		long userID = MetadataViewerAgent.getUserDetails().getId();
		handle = mhView.saveData(ctx, data, toAdd, toRemove,
				acquisitionMetadata, userID, this);
	}
	
	public void cancel() { handle.cancel(); }
	
    public void handleResult(Object result) 
    {
    	if (viewer.getState() == MetadataViewer.DISCARDED) return;      	viewer.onDataSave((List) data);
    	boolean post = (toAdd != null && toAdd.size() != 0) || 
				(toRemove != null && toRemove.size() != 0);
    	int count = 0;
    	if (toAdd != null) count += toAdd.size();
    	if (toRemove != null) count -= toRemove.size();
    	if (post) {
			EventBus bus = 
				MetadataViewerAgent.getRegistry().getEventBus();
			bus.post(new AnnotatedEvent((List) data, count));
		}
    }
}