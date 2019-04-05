abstract class JarPackageActionDelegate implements IObjectActionDelegate {
	private IStructuredSelection fSelection;
	private Shell fShell;
	
	protected Shell getShell() {
		if (fShell != null)
			return fShell;
		return JavaPlugin.getActiveWorkbenchShell();
	}
	
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		IWorkbenchPartSite site= targetPart.getSite();
		fShell= site != null ? site.getShell() : null;
	}
	
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection)
			fSelection= (IStructuredSelection)selection;
		else
			fSelection= StructuredSelection.EMPTY;
	}
	
	protected IFile getDescriptionFile(IStructuredSelection selection) {
		return (IFile)selection.getFirstElement();
	}
	
	protected IFile[] getDescriptionFiles(IStructuredSelection selection) {
		IFile[] files= new IFile[selection.size()];
		Iterator<?> iter= selection.iterator();
		int i= 0;
		while (iter.hasNext())
			files[i++]= (IFile)iter.next();
		return files;
	}
	protected IWorkbench getWorkbench() {
		return PlatformUI.getWorkbench();
	}
	protected IStructuredSelection getSelection() {
		return fSelection;
	}
}