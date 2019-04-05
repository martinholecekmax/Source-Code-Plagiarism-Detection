public class MultiRepositoryAwareWizard extends Wizard implements INewWizard {
	private final SelectRepositoryPage selectRepositoryPage;
	public MultiRepositoryAwareWizard(SelectRepositoryPage page, String title) {
		selectRepositoryPage = page;
		setForcePreviousAndNextButtons(true);
		setNeedsProgressMonitor(true);
		setWindowTitle(title);
		setDefaultPageImageDescriptor(TasksUiImages.BANNER_REPOSITORY);
	}
	public void init(IWorkbench workbench, IStructuredSelection selection) {
			}
	@Override
	public void addPages() {
		addPage(selectRepositoryPage);
	}
	@Override
	public boolean canFinish() {
		return selectRepositoryPage.canFinish();
	}
	@Override
	public boolean performFinish() {
		return selectRepositoryPage.performFinish();
	}
}