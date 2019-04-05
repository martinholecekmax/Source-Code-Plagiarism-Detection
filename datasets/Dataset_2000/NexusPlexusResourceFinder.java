public class NexusPlexusResourceFinder
    extends PlexusResourceFinder
{
    private PlexusResource plexusResource;
    private Context context;
    public NexusPlexusResourceFinder( Context context, PlexusResource resource )
    {
        super( context, resource );
        this.plexusResource = resource;
        this.context = context;
    }
    @Override
    public Handler createTarget( Request request, Response response )
    {
        RestletResource restletResource = new NexusRestletResource( getContext(), request, response, plexusResource );
                restletResource.setContext( context );
        restletResource.setRequest( request );
        restletResource.setResponse( response );
        return restletResource;
    }
}