public class DisplayNewsItemAction extends BaseAction implements ServletResponseAware
{
   private static final Log _log = LogFactory.getLog(DisplayNewsItemAction.class); 
		   private HttpServletResponse _response;
   public void setServletResponse(HttpServletResponse r) { _response = r; }
			private NewsItem _ni;
	private String   _body;
	public NewsItem getNewsItem() { return _ni; }
	public String   getBody() { return _body; }
   public String execute()
	{

		String niPath = null;
		try {
			niPath = getParam("ni");
			if (niPath == null) {
				_log.error("News item path not specified");
				return Action.ERROR;
			}
			else {
				_ni = Source.getNewsItemFromLocalCopyPath(niPath);
				Reader       fr   = _ni.getReader();
				StringBuffer csb  = new StringBuffer();
				char[]       cbuf = new char[256];
				while (fr.read(cbuf) != -1) {
					csb.append(cbuf);
				}
				fr.close();

				String sb = csb.toString();
				int    bb = sb.indexOf("<pre>");
				int    be = sb.indexOf("</pre>");
				_body  = sb.substring(bb+5, be);
				return Action.SUCCESS;
			}
		}
		catch (Exception e) {
			_log.error("Error displaying news item - " + niPath, e);
			addActionError(getText("error.news.display"));
			try {
				_response.sendError(HttpServletResponse.SC_GONE, "Sorry! The news item has been moved and the new location is not known!");
			}
			catch (Exception ee) {
				_log.error("HMM!! Could not send 410 error message to client in response to request for news item " + niPath);
			}
			return null;
		}
	}
}