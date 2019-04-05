public interface FIDMapperFactory {
    
    public FIDMapper getMapper(String catalog, String schema, String typeName,
        Connection connection) throws IOException;
    
    FIDMapper getMapper(SimpleFeatureType featureType);
}