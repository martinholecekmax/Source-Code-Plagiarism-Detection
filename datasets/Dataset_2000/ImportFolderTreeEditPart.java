public class ImportFolderTreeEditPart  extends AdapterTreeEditPart<ImportFolder> {
	private List<EPackage> imports;
	public ImportFolderTreeEditPart(ImportFolder model) {
		super(model);
		this.imports = model.getImports();
	}
	@Override
	protected String getText() {
		return "Imports";
	}
	@Override
	protected List<EPackage> getModelChildren() {
		return this.imports;
	}
	@Override
	protected void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
	}
	@Override
	protected Image getImage() {
		try {
			return IconUtil.getIcon("importFolder16.png");
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	protected void performOpen() {
		if (this.widget instanceof TreeItem) {
			TreeItem item = (TreeItem) this.widget;
			item.setExpanded(!item.getExpanded());	
		}	
	} 
}