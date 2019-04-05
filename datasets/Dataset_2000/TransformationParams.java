public class TransformationParams
{
    private Map<String, TransformationParameter> params = new LinkedHashMap<String, TransformationParameter>();
    public void add( TransformationParameter param )
    {
        params.put( param.getName(), param );
    }
    public boolean notContains( String paramName )
    {
        return !params.containsKey( paramName );
    }
    public boolean contains( String paramName )
    {
        return params.containsKey( paramName );
    }
    public TransformationParameter get( String name )
    {
        return params.get( name );
    }
}