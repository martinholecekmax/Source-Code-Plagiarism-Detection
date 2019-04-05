public class STHideShowColAction extends Action {
	private final AbstractSTViewer stViewer;
	
	public STHideShowColAction(AbstractSTViewer stViewer) {
		super(STDataViewersMessages.hideshowAction_title);
		this.stViewer = stViewer;
		Image img = STDataViewersImages.getImage(STDataViewersImages.IMG_EDIT_PROPERTIES); 
		super.setImageDescriptor(ImageDescriptor.createFromImage(img));
		setEnabled(true);
	}
	
	@Override
	public void run(){
		STDataViewersHideShowColumnsDialog dialog =
			new STDataViewersHideShowColumnsDialog(stViewer);
		if (dialog.open() == Window.OK && dialog.isDirty()) {
			if (dialog.getManager() != null) {
				stViewer.setHideShowManager(dialog.getManager());
			}
		}
	}
}