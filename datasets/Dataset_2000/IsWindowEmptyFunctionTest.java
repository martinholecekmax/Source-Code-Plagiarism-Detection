public class IsWindowEmptyFunctionTest
    extends AbstractPortalFunctionTest
{
    @Override
    protected PortalFunctionsMediator newMediator()
    {
        return Mockito.mock( PortalFunctionsMediator.class );
    }
    @Test
    public void testFunction()
        throws Exception
    {
        Mockito.when( this.mediator.isWindowEmpty( Mockito.anyString(), Mockito.any( String[].class ) ) ).thenReturn( true );
        processTemplate( "isWindowEmpty" );
        Mockito.verify( this.mediator, Mockito.times( 2 ) ).isWindowEmpty( "window-key", new String[0] );
        Mockito.verify( this.mediator, Mockito.times( 1 ) ).isWindowEmpty( "window-key", new String[]{"a", "3"} );
    }
}