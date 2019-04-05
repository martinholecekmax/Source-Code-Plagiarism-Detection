public class EclipseResourceSupport {
	@Inject
	private Provider<EclipseResourceFileSystemAccess2> fileSystemAccessProvider;
	@Inject
	private EclipseOutputConfigurationProvider outputConfigurationProvider;
	
	public EclipseResourceFileSystemAccess2 createProjectFileSystemAccess(
			IProject targetProject) {
		EclipseResourceFileSystemAccess2 fsa = fileSystemAccessProvider.get();
		fsa.setProject(targetProject);
		fsa.setMonitor(new NullProgressMonitor());
		Map<String, OutputConfiguration> outputs = new HashMap<String, OutputConfiguration>(); 
		for (OutputConfiguration conf : outputConfigurationProvider.getOutputConfigurations(targetProject)) {
			outputs.put(conf.getName(), conf);
		}
		fsa.setOutputConfigurations(outputs);
		fsa.setPostProcessor(new EclipseResourceFileSystemAccess2.IFileCallback() {
			public boolean beforeFileDeletion(IFile file) {
				return true;
			}
			public void afterFileUpdate(IFile file) {
				handleFileAccess(file);
			}
			public void afterFileCreation(IFile file) {
				handleFileAccess(file);
			}
			protected void handleFileAccess(IFile file) {
			}
		});
		return fsa;
	}
}