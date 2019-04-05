public class FileNameFilter extends ViewerFilter {
	private String fTargetName;
	public FileNameFilter(String targetName) {
		fTargetName = targetName;
	}
	public boolean select(Viewer viewer, Object parent, Object element) {
		if (element instanceof IFile) {
			return fTargetName.equals(((IFile) element).getName());
		}
		if (element instanceof IProject && !((IProject) element).isOpen())
			return false;
		if (element instanceof IContainer) { 			try {
				IResource[] resources = ((IContainer) element).members();
				for (int i = 0; i < resources.length; i++) {
					if (select(viewer, parent, resources[i]))
						return true;
				}
			} catch (CoreException e) {
			}
		}
		return false;
	}
}