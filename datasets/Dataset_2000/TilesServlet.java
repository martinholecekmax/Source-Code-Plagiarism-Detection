public class TilesServlet extends HttpServlet {
    
    protected final Log log =
        LogFactory.getLog(TilesServlet.class);
    
    private TilesInitializer initializer;
    
    public TilesServlet() {
        initializer = createTilesInitializer();
    }
    
    @Override
    public void destroy() {
        try {
            ServletUtil.setContainer(getServletContext(), null);
        } catch (TilesException e) {
            log.warn("Unable to remove tiles container from service.", e);
        }
    }
    
    @Override
    public void init() throws ServletException {
        ServletContext adaptedContext = new ServletContextAdapter(
                getServletConfig());
        ServletTilesApplicationContext preliminaryContext = new ServletTilesApplicationContext(
                adaptedContext);
        initializer.initialize(preliminaryContext);
    }
    
    protected TilesInitializer createTilesInitializer() {
        return new BasicTilesInitializer();
    }
}