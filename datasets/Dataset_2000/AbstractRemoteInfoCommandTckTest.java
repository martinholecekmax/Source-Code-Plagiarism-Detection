public abstract class AbstractRemoteInfoCommandTckTest
    extends ScmTckTestCase
{
    protected abstract void checkResult( RemoteInfoScmResult result );
    protected abstract ScmProviderRepository getScmProviderRepository()
        throws Exception;
    public void testRemoteInfoCommand()
        throws Exception
    {
        ScmProvider provider = getScmManager().getProviderByRepository( getScmRepository() );
        RemoteInfoScmResult result =
            provider.remoteInfo( getScmProviderRepository(), new ScmFileSet( getWorkingCopy() ), null );
        checkResult( result );
    }
}