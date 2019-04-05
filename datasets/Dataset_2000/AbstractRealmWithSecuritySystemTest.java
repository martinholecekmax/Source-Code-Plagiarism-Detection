public abstract class AbstractRealmWithSecuritySystemTest
    extends AbstractRealmTest
{
    private SecuritySystem securitySystem;
    private CacheManagerComponent cacheManagerComponent;
    @Override
    protected void customizeContainerConfiguration( final ContainerConfiguration configuration )
    {
        super.customizeContainerConfiguration( configuration );
        configuration.setAutoWiring( true );
        configuration.setClassPathScanning( PlexusConstants.SCANNING_ON );
    }
    @Override
    protected void customizeContext( final Context ctx )
    {
        super.customizeContext( ctx );
        ctx.put( "application-conf", getConfDir().getAbsolutePath() );
        ctx.put( "security-xml-file", getConfDir().getAbsolutePath() + "/security.xml" );
    }
    @Override
    protected Module[] getTestCustomModules()
    {
        return new Module[] { new SecurityModule() };
    }
    @Override
    protected void setUp()
        throws Exception
    {
        super.setUp();
        securitySystem = lookup( SecuritySystem.class );
        cacheManagerComponent = lookup( CacheManagerComponent.class );
    }
    protected void tearDown()
        throws Exception
    {
        if ( securitySystem != null )
        {
            securitySystem.stop();
        }
        if ( cacheManagerComponent != null )
        {
            cacheManagerComponent.shutdown();
        }
        super.tearDown();
    }
    protected abstract File getConfDir();
}