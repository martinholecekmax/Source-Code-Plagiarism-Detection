public class TheTestWizard extends Wizard {
	public TheTestWizardPage page1;
	public TheTestWizardPage page2;
	public TheTestWizardPage page3;
	public final String page1Name = "PAGE1";
	public final String page2Name = "PAGE2";
	public final String page3Name = "PAGE3";
	private boolean throwExceptionOnDispose; 
	public TheTestWizard() {
		super();
		setNeedsProgressMonitor(true);
	}
	
	public void addPages() {
		page1 = new TheTestWizardPage(page1Name);
		addPage(page1);
		page2 = new TheTestWizardPage(page2Name);
		addPage(page2);
		page3 = new TheTestWizardPage(page3Name);
		addPage(page3);
	}
	
	public boolean performFinish() {
		WizardTest.DID_FINISH = true;
		return true;
	}
	
	public void setThrowExceptionOnDispose(boolean throwExceptionOnDispose) {
		this.throwExceptionOnDispose = throwExceptionOnDispose;
	}
	
	public void dispose() {
		super.dispose();
		if(throwExceptionOnDispose)
			throw new NullPointerException();
	}
}