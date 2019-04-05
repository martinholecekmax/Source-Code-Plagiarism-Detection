public class AddRegionDialog extends Dialog {
	private XYRegionGraph xyGraph;
	private RegionComposite regionComposite;
	private RegionType type;
	public AddRegionDialog(final Shell parentShell, final XYRegionGraph xyGraph, RegionType type) {
		super(parentShell);	
                setShellStyle(getShellStyle() | SWT.RESIZE);
        this.xyGraph = xyGraph;
        this.type = type;
	}
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Add Region");
	}
	@Override
	protected Control createDialogArea(Composite parent) {
		final Composite parent_composite = (Composite) super.createDialogArea(parent);
        this.regionComposite = new RegionComposite(parent_composite, SWT.NONE, xyGraph, type, false);
		return parent_composite;
	}
	@Override
	protected void okPressed() {	
		try {
		    region = regionComposite.createRegion();
		} catch (Exception ne) {
			MessageDialog.openError(getShell(), "Name in use", "The region cannot be created. "+ne.getMessage()+"\n\nPlease correct this or press cancel.");
			regionComposite.disposeRegion(region);
			return;
		}
		super.okPressed();
	}
	private AbstractSelectionRegion region;
	
	public AbstractSelectionRegion getRegion() {
		return region;
	}
}