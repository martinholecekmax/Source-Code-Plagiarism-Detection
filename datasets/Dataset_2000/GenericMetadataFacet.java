public class GenericMetadataFacet
    implements MetadataFacet
{
    private Map<String, String> additionalProperties;
    public static final String FACET_ID = "org.apache.archiva.metadata.generic";
    public String getFacetId()
    {
        return FACET_ID;
    }
    public String getName()
    {
        return "";
    }
    public void fromProperties( Map<String, String> properties )
    {
        if ( additionalProperties == null )
        {
            additionalProperties = new TreeMap<String, String>();
        }
        additionalProperties.putAll( properties );
    }
    public Map<String, String> toProperties()
    {
        Map<String, String> properties = new TreeMap<String, String>();
        if ( additionalProperties != null )
        {
            for ( String key : additionalProperties.keySet() )
            {
                properties.put( key, additionalProperties.get( key ) );
            }
        }
        return properties;
    }
    public Map<String, String> getAdditionalProperties()
    {
        return additionalProperties;
    }
    public void setAdditionalProperties( Map<String, String> additionalProperties )
    {
        this.additionalProperties = additionalProperties;
    }
}