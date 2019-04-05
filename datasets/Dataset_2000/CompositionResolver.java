public interface CompositionResolver
{
    public static final char SEPARATOR_CHAR = ':';
    
    void addComponentDescriptor( ComponentDescriptor<?> componentDescriptor ) 
        throws CycleDetectedInComponentGraphException;
    
    List getRequirements( String role, String roleHint );
    
    List findRequirements( String role, String roleHint );
}