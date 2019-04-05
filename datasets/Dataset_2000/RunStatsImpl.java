public class RunStatsImpl extends HttpServlet {
	
	private static final long serialVersionUID = -8027295471561939707L;
	@Override
	public void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
		if( Authentication.isAdmin( req ) ) {
			Queue queue = QueueFactory.getQueue( "default-queue" );
			queue.add( TaskOptions.Builder.url( "/_ah/cron/stats" ).method( Method.GET ) );
		} else
			super.doGet( req, resp );
	}
}