public class ChartHttpSessionListener implements HttpSessionListener
{
	
	public void sessionCreated( HttpSessionEvent event )
	{
	}
	
	public void sessionDestroyed( HttpSessionEvent event )
	{
		String sessionId = event.getSession( ).getId( );
		ChartImageManager.clearSessionFiles( sessionId, event.getSession( )
				.getServletContext( ) );
	}
}