public class AccuRevLoginCommand
    extends AbstractAccuRevCommand
{
    public AccuRevLoginCommand( ScmLogger logger )
    {
        super( logger );
    }
    @Override
    protected ScmResult executeAccurevCommand( AccuRevScmProviderRepository repository, ScmFileSet fileSet,
                                               CommandParameters parameters )
        throws ScmException, AccuRevException
    {
        boolean result = false;
        AccuRev accurev = repository.getAccuRev();
        AccuRevInfo info = accurev.info( null );
        String providerMessage = "";
        if ( info == null )
        {
            providerMessage = "Unable to retrieve accurev info";
        }
        else if ( repository.getUser() != null )
        {
                        result = repository.getUser().equals( info.getUser() );
            if ( result )
            {
                providerMessage = "Skipping login - already logged in as " + repository.getUser();
            }
            else
            {
                result = accurev.login( repository.getUser(), repository.getPassword() );
                providerMessage = ( result ? "Success" : "Failure" ) + " logging in as " + repository.getUser();
            }
        }
        else
        {
            result = info.isLoggedIn();
            providerMessage = result ? ( "Logged in externally as " + info.getUser() ) : "Not logged in";
        }
        getLogger().debug( providerMessage );
        return new LoginScmResult( accurev.getCommandLines(), providerMessage, accurev.getErrorOutput(), result );
    }
    public LoginScmResult login( ScmProviderRepository repository, ScmFileSet fileSet, CommandParameters parameters )
        throws ScmException
    {
        return (LoginScmResult) execute( repository, fileSet, parameters );
    }
}