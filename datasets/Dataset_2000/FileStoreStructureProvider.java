public class FileStoreStructureProvider implements IImportStructureProvider {
	
	public final static FileStoreStructureProvider INSTANCE = new FileStoreStructureProvider();
	
	public List getChildren(Object element) {
		try {
			return Arrays.asList(((IFileStore) element).childStores(EFS.NONE,
					new NullProgressMonitor()));
		} catch (CoreException exception) {
			logException(exception);
			return new ArrayList();
		}
	}
	
	private void logException(CoreException exception) {
		IDEWorkbenchPlugin.log(exception.getLocalizedMessage(), exception);
	}
	
	public InputStream getContents(Object element) {
		try {
			return ((IFileStore) element).openInputStream(EFS.NONE,
					new NullProgressMonitor());
		} catch (CoreException exception) {
			logException(exception);
			return null;
		}
	}
	
	public String getFullPath(Object element) {
		return ((IFileStore) element).toURI().getSchemeSpecificPart();
	}
	
	public String getLabel(Object element) {
		return ((IFileStore) element).getName();
	}
	
	public boolean isFolder(Object element) {
		return ((IFileStore) element).fetchInfo().isDirectory();
	}
}