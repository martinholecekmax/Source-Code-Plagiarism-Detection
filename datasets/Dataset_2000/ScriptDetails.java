public class ScriptDetails extends TitleAreaDialog {
	private DirectoryFieldEditor dirText;
	private FileFieldEditor scriptText;
	public ScriptDetails(Shell parent) {
		super(parent);
	}
	@Override
	public void create() {
		super.create();
		setTitle(Messages.ScriptDetails_Title);
		setMessage(Messages.ScriptDetails_Choose_Directory);
	}
	@Override
	protected Control createDialogArea(Composite parent) {
		super.createDialogArea(parent);
		Composite newParent = new Composite(parent, SWT.NULL);
		newParent.setLayoutData(new GridData(GridData.FILL_BOTH));
		dirText = new DirectoryFieldEditor("", Messages.ScriptDetails_Directory, newParent); 		dirText.setStringValue((DashboardPlugin.getDefault()
				.getPreferenceStore()
				.getString(DashboardPreferenceConstants.P_DASHBOARD_EXAMPLES_DIR)));
		scriptText = new FileFieldEditor("", Messages.ScriptDetails_Script, newParent); 		return newParent;
	}
	@Override
	protected void okPressed() {
		DashboardPlugin
				.getDefault()
				.getPreferenceStore()
				.setValue(
						DashboardPreferenceConstants.P_DASHBOARD_EXAMPLES_DIR,
						dirText.getStringValue());
		DashboardPlugin
				.getDefault()
				.getPreferenceStore()
				.setValue(DashboardPreferenceConstants.P_DASHBOARD_SCRIPT,
						scriptText.getStringValue());
		super.okPressed();
	}
}