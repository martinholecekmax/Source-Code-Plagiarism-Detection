public interface OrderingResource extends DavResource {
    public String METHODS = "ORDERPATCH";
    
    public boolean isOrderable();
    
    public void orderMembers(OrderPatch orderPatch) throws DavException;
}