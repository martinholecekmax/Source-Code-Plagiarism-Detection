public class TestFileStore extends FileStore {
	URI uri;
	public TestFileStore(URI uri) {
		this.uri = uri;
	}
	public String[] childNames(int options, IProgressMonitor monitor)
			throws CoreException {
		return null;
	}
	public IFileInfo fetchInfo(int options, IProgressMonitor monitor)
			throws CoreException {
		return new FileInfo();
	}
	public IFileStore getChild(String name) {
		if (name.equals(".project"))
			return new TestFileStore(this.uri);
		return new TestFileStore(null);
	}
	public String getName() {
		return null;
	}
	public IFileStore getParent() {
		return new TestFileStore(this.uri);
	}
	public IFileStore mkdir(int options, IProgressMonitor monitor) throws CoreException {
		return new TestFileStore(this.uri);
	}
	public InputStream openInputStream(int options, IProgressMonitor monitor)
			throws CoreException {
		return null;
	}
	public OutputStream openOutputStream(int options, IProgressMonitor monitor)
			throws CoreException {
		return new OutputStream() {
			public void write(int b) throws IOException {
			}
		};
	}
	public URI toURI() {
		return this.uri;
	}
}