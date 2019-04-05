public class TilesListener
    implements ServletContextListener {
    
    protected final Log log =
        LogFactory.getLog(TilesListener.class);
    
    protected TilesInitializer initializer;
    
    public TilesListener() {
        initializer = createTilesInitializer();
    }
    
    public void contextInitialized(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();
        initializer.initialize(new ServletTilesApplicationContext(
                servletContext));
    }
    
    public void contextDestroyed(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();
        try {
            ServletUtil.setContainer(servletContext, null);
        } catch (TilesException e) {
            log.warn("Unable to remove tiles container from service.", e);
        }
    }
    
    protected TilesInitializer createTilesInitializer() {
        return new BasicTilesInitializer();
    }
    
    protected TilesContainer createContainer(ServletContext context) {
        TilesApplicationContext applicationContext = new ServletTilesApplicationContext(
                context);
        AbstractTilesContainerFactory factory = AbstractTilesContainerFactory
                .getTilesContainerFactory(applicationContext);
        return factory.createContainer(applicationContext);
    }
}