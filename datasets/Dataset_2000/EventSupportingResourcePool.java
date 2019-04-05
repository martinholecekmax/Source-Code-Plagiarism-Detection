public interface EventSupportingResourcePool extends ResourcePool
{
    
    public void addResourcePoolListener(ResourcePoolListener rpl)
	throws ResourcePoolException;
    public void removeResourcePoolListener(ResourcePoolListener rpl)
	throws ResourcePoolException;
}