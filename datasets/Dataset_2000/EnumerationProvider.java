public interface EnumerationProvider
{
    
	<T extends IObject> T getEnumeration(Class<T> klass, String value,
		               boolean loaded);
    
	<T extends IObject> HashMap<String, T> getEnumerations(Class<T> klass);
}