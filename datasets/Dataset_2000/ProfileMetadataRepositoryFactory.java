public class ProfileMetadataRepositoryFactory extends MetadataRepositoryFactory {
	
	public IMetadataRepository create(URI location, String name, String type, Map<String, String> properties) throws ProvisionException {
		return null;
	}
	public IMetadataRepository load(URI location, int flags, IProgressMonitor monitor) throws ProvisionException {
				if ((flags & IRepositoryManager.REPOSITORY_HINT_MODIFIABLE) > 0) {
			return null;
		}
		return new ProfileMetadataRepository(getAgent(), location, monitor);
	}
}