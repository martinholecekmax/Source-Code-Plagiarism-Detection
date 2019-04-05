public class RecompileAction extends BaseNavajoAction {
    public RecompileAction() {
        super();
    }
    
    public void run(IAction action) {
            new WorkspaceJob("Recompiling..."){
               @Override
			public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
                   try {
                       for (Iterator iter = selectionList.iterator(); iter.hasNext();) {
                           IResource element = (IResource) iter.next();
                           element.touch(null);
                           if (element instanceof IFolder) {
                               IFolder ff = (IFolder)element;
                               touchRecursive(ff);
                           }
                       }
                       } catch (CoreException e) {
                           NavajoScriptPluginPlugin.getDefault().log("Touching failed. That is unexpected. Maybe refresh?",e);
                       }
                    return Status.OK_STATUS;
                }}.schedule();
     }
    	private void touchRecursive(IFolder fold) throws CoreException {
            IResource[] ir =  fold.members();
    	    for (int i = 0; i < ir.length; i++) {
                if (ir[i] instanceof IFolder) {
                    touchRecursive(((IFolder)ir[i]));
                } 
                ir[i].touch(null);
            }
    	}
}