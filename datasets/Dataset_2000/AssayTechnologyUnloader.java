public class AssayTechnologyUnloader extends AbstractOntologyEntryUnloader<AssayTechnology>
{
	private final static Association [] referringAssociations = new Association [] {
		new Association ( Assay.class, "technology" )
	};  
	public AssayTechnologyUnloader ( UnloadManager unloadManager ) {
		super ( unloadManager );
	}
	@Override
	protected Association [] getReferringAssociations () {
		return referringAssociations; 
	}
}