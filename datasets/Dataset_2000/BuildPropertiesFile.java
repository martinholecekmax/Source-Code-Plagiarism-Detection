public class BuildPropertiesFile extends TextFile implements GenerationAvailableFile {
	public BuildPropertiesFile() {
		super();
	}
	public BuildPropertiesFile(File f, BuildPropertiesResource resource) {
		super(f);
		try {
			setFlexoResource(resource);
		} catch (DuplicateResourceException e) {
			e.printStackTrace();
		}
	}
	@Override
	public BuildPropertiesResource getFlexoResource() {
		return (BuildPropertiesResource) super.getFlexoResource();
	}
	@Override
	public FlexoResourceGenerator getGenerator() {
		return getFlexoResource().getGenerator();
	}
}