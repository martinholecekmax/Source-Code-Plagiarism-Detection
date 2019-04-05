public class SearchFuture extends ResponseFuture<Response>
{
    
        @SuppressWarnings("PMD.UselessOverridingMethod")
    public SearchFuture( LdapConnection connection, int messageId )
    {
        super( connection, messageId );
    }
    
    @SuppressWarnings("PMD.UselessOverridingMethod")
    public Response get() throws InterruptedException, ExecutionException
    {
        return super.get();
    }
    
    public Response get( long timeout, TimeUnit unit ) throws InterruptedException, ExecutionException,
        TimeoutException
    {
        return super.get( timeout, unit );
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append( "SearchFuture" ).append( super.toString() );
        return sb.toString();
    }
}