public interface CatalogFinder {
    
    List<String> getCatalogNames(
        RolapConnection connection);
    
    Map<String, RolapSchema> getRolapSchemas(
        RolapConnection connection,
        String catalogName);
}