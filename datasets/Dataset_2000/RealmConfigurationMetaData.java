public interface RealmConfigurationMetaData
{
   
   String getId();
   
   String getIdentityRepositoryIdRef();
   
   String getIdentityMapping();
   
   Map<String, String> getGroupTypeMappings();
   
   Map<String, List<String>> getOptions();
}