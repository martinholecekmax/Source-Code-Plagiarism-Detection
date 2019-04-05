public class 
SearchExecuter 
{
	private Map				context;
	private ResultListener 	listener;
	public 
	SearchExecuter(
		Map				_context,
		ResultListener	_listener ) 
	{
		context		= _context;
		listener 	= _listener;
	}
	public void 
	search(
		final Engine 			engine,
		final SearchParameter[] searchParameters, 
		final String 			headers,
		final int				desired_max_matches )
	{
		new AEThread2( "MetaSearch: " + engine.getName() + " runner", true )
		{
			public void 
			run() 
			{
				try{
					engine.search( searchParameters, context, desired_max_matches, -1, headers, listener );
				}catch( SearchException e ){
				}
			}
		}.start();
	}
}