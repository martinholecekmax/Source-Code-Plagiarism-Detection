public interface IReferentResolver {
	
	public ImageRecord getImageRecord(String rftId) throws ResolverException;
	
	public ImageRecord getImageRecord(Referent rft) throws ResolverException;
	
	public void setProperties(Properties props) throws ResolverException;
	
	public int getStatus(String rftId);
	
	public IReferentMigrator getReferentMigrator();
}