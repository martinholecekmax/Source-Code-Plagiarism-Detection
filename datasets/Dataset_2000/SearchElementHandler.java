public class SearchElementHandler extends AbstractHandler {
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
		NavigatorSearchDialog dialog = new NavigatorSearchDialog(shell, getSelectedTreeViewer(event));
		dialog.open();
		return null;
	}
	protected TreeViewer getSelectedTreeViewer(ExecutionEvent event) {
		IWorkbenchPart activePart;
						if( event.getApplicationContext() instanceof EvaluationContext) {
			EvaluationContext context = (EvaluationContext)event.getApplicationContext();
						Object site = context.getVariable("activeSite");
			activePart = (IWorkbenchPart)context.getVariable("activePart");
		}
		else {
			activePart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActivePart();
		}
		if(activePart instanceof TreeViewer)
			return (TreeViewer)activePart;
		if( activePart instanceof MultiViewPageBookView)
		{
			MultiViewPageBookView pageBookView =(MultiViewPageBookView)activePart;
			IViewPart viewPart =  pageBookView.getActiveView();
			if(viewPart instanceof ModelExplorerView)
			{
				return ((ModelExplorerView)viewPart).getCommonViewer();
			}
		}
				return null;
	}
	protected CommonNavigator getCommonNavigator() {
		IViewPart part = org.eclipse.papyrus.modelexplorer.NavigatorUtils
				.findViewPart("org.eclipse.papyrus.modelexplorer.modelexplorer");
		if (part instanceof CommonNavigator) {
			return ((CommonNavigator) part);
		}
		return null;
	}
}