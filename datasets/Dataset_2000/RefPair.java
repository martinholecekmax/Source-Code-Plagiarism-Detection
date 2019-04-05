public class RefPair
{
    private final ServiceReference ref;
    private Object serviceObject;
    public RefPair( ServiceReference ref, Object serviceObject )
    {
        this.ref = ref;
        this.serviceObject = serviceObject;
    }
    public ServiceReference getRef()
    {
        return ref;
    }
    public Object getServiceObject()
    {
        return serviceObject;
    }
    public void setServiceObject( Object serviceObject )
    {
        this.serviceObject = serviceObject;
    }
}