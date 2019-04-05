public interface AssetEncounter
{
	
	Resource getResource();
	
	String getNamepace();
	
	NamespaceManager.Namespace getNamespaceObject();
	
	String getPath();
	
	boolean isProduction();
	
	Resource getCached(String id);
	
	AssetEncounter cache(String id, Resource resource);
	
	AssetEncounter replaceWith(Resource resource);
	
	AssetEncounter rename(String name);
}