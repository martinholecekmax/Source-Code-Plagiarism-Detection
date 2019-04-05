public abstract class AbstractLogoutValve extends ValveBase {
    protected final Log log = LogFactory.getLog(getClass());
    public final void invoke(final Request request, final Response response) throws IOException, ServletException {
        if (getLogoutHandler().isLogoutRequest(request)) {
            getLogoutHandler().logout(request, response);
                        return;
        }
        this.log.debug("URI is not a logout request: " + request.getRequestURI());
        getNext().invoke(request, response);
    }
    protected abstract LogoutHandler getLogoutHandler();
}