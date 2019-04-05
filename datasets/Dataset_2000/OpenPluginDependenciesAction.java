public class OpenPluginDependenciesAction extends Action {
	private IPluginModelBase fModel = null;
	public OpenPluginDependenciesAction(IPluginModelBase base) {
		fModel = base;
	}
	public void run() {
		try {
			IViewPart view = PDEPlugin.getActivePage().showView(IPDEUIConstants.DEPENDENCIES_VIEW_ID);
			((DependenciesView) view).openCalleesFor(fModel);
		} catch (PartInitException e) {
			PDEPlugin.logException(e);
		}
	}
}