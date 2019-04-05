public class ExampleRefactoringAction extends Action implements IActionDelegate {
	private IFile fFile;
	
	public void run(IAction action) {
		if (fFile != null) {
			try {
				ExampleRefactoring refactoring= new ExampleRefactoring(fFile);
				ExampleRefactoringWizard refactoringWizard= new ExampleRefactoringWizard(refactoring, RefactoringWizard.WIZARD_BASED_USER_INTERFACE);
				Shell shell= PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
				RefactoringWizardOpenOperation op= new RefactoringWizardOpenOperation(refactoringWizard);
				op.run(shell, "Example refactoring");
			} catch (InterruptedException e) {
							}
		}
	}
	
	public void selectionChanged(IAction action, ISelection selection) {
		fFile= null;
		if (selection instanceof IStructuredSelection) {
			Object object= ((IStructuredSelection) selection).getFirstElement();
			if (object instanceof IFile) {
				fFile= (IFile) object;
			}
		}
	}
}