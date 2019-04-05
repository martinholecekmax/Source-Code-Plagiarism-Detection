public class NewUsageSummaryEditorWizard extends Wizard implements INewWizard {
	private static final String TITLE = Messages.NewUsageSummaryEditorWizard_New_Usage_Summary_Report;
	private UsageSummaryEditorWizardPage usageSummaryPage;
	private final StudyParameters studyParameters;
	public NewUsageSummaryEditorWizard() {
		super();
		init();
		setWindowTitle(TITLE);
		studyParameters = UiUsageMonitorPlugin.getDefault().getStudyParameters();
	}
	private void init() {
		usageSummaryPage = new UsageSummaryEditorWizardPage();
	}
	@Override
	public boolean performFinish() {
		if (!usageSummaryPage.includePerspective() && !usageSummaryPage.includeViews()) {
			return false;
		}
		List<IUsageCollector> collectors = new ArrayList<IUsageCollector>();
		if (usageSummaryPage.includePerspective()) {
			collectors.add(new PerspectiveUsageCollector());
		}
		if (usageSummaryPage.includeViews()) {
			ViewUsageCollector mylynViewUsageCollector = new ViewUsageCollector();
			collectors.add(mylynViewUsageCollector);
		}
		MonitorFileRolloverJob job = new MonitorFileRolloverJob(collectors, studyParameters);
		job.setPriority(Job.LONG);
		job.schedule();
		return true;
	}
	public void init(IWorkbench workbench, IStructuredSelection selection) {
			}
	@Override
	public void addPages() {
		addPage(usageSummaryPage);
	}
}