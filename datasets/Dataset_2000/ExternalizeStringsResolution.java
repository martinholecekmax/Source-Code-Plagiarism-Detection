public class ExternalizeStringsResolution extends AbstractPDEMarkerResolution {
	public ExternalizeStringsResolution(int type) {
		super(type);
	}
	public void run(final IMarker marker) {
		BusyIndicator.showWhile(SWTUtil.getStandardDisplay(), new Runnable() {
			public void run() {
				GetNonExternalizedStringsAction fGetExternAction = new GetNonExternalizedStringsAction();
				IStructuredSelection selection = new StructuredSelection(marker.getResource().getProject());
				fGetExternAction.selectionChanged(null, selection);
				fGetExternAction.run(null);
			}
		});
	}
	protected void createChange(IBaseModel model) {
			}
	public String getDescription() {
		return PDEUIMessages.ExternalizeStringsResolution_desc;
	}
	public String getLabel() {
		return PDEUIMessages.ExternalizeStringsResolution_label;
	}
}