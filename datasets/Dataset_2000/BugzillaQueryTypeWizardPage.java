public class BugzillaQueryTypeWizardPage extends WizardPage {
	private static final String BUTTON_LABEL_QUERY = Messages.BugzillaQueryTypeWizardPage_Create_query_from_existing_URL;
	private static final String BUTTON_LABEL_FORM = Messages.BugzillaQueryTypeWizardPage_Create_query_using_form;
	private static final String TITLE = Messages.BugzillaQueryTypeWizardPage_Choose_query_type;
	private static final String DESCRIPTION = Messages.BugzillaQueryTypeWizardPage_Select_from_the_available_query_types;
	private Button buttonCustom;
	private Button buttonForm;
	private Composite composite;
	private final BugzillaCustomQueryWizardPage customPage;
	private final BugzillaSearchPage searchPage;
	public BugzillaQueryTypeWizardPage(TaskRepository repository) {
		super(TITLE);
		setTitle(TITLE);
		setDescription(DESCRIPTION);
		setImageDescriptor(TasksUiImages.BANNER_REPOSITORY);
		customPage = new BugzillaCustomQueryWizardPage(repository);
		searchPage = new BugzillaSearchPage(repository);
		searchPage.setRestoreQueryOptions(false);
	}
	public void createControl(Composite parent) {
		composite = new Composite(parent, SWT.NONE);
		GridData gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.grabExcessVerticalSpace = false;
		composite.setLayoutData(gridData);
		composite.setLayout(new GridLayout(1, false));
		buttonForm = new Button(composite, SWT.RADIO);
		buttonForm.setText(BUTTON_LABEL_FORM);
		buttonForm.setSelection(true);
		buttonCustom = new Button(composite, SWT.RADIO);
		buttonCustom.setText(BUTTON_LABEL_QUERY);
		setPageComplete(true);
		setControl(composite);
		Dialog.applyDialogFont(composite);
	}
	@Override
	public IWizardPage getNextPage() {
		if (buttonForm.getSelection()) {
			searchPage.setWizard(this.getWizard());
			return searchPage;
		}
		customPage.setWizard(this.getWizard());
		return customPage;
	}
}