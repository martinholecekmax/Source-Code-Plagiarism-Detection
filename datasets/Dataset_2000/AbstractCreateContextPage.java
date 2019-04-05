public abstract class AbstractCreateContextPage extends WizardPage {
	
	public AbstractCreateContextPage(String pageName) {
		super(pageName);
	}
	
	public AbstractCreateContextPage(String pageName, String title, ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
	}
	@Override
	public CreateContextWizard getWizard() {
		return (CreateContextWizard)super.getWizard();
	}
}