public class UriNormalizationFilter implements Filter {
    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(UriNormalizationFilter.class);
    private static final String DEFAULT_CONFIG = "uri-normalization.cfg.xml";
    private String config;
    private UriNormalizationHandlerFactory handlerFactory;
    private ConfigurationService configurationManager;
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        new FilterLogicHandlerDelegate(request, response, chain).doFilter(handlerFactory.newHandler());
    }
    @Override
    public void destroy() {
        configurationManager.unsubscribeFrom(config, handlerFactory);
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        config = new FilterConfigHelper(filterConfig).getFilterConfig(DEFAULT_CONFIG);
        LOG.info("Initializing filter using config " + config);
        configurationManager = ServletContextHelper.getInstance().getPowerApiContext(filterConfig.getServletContext()).configurationService();
        handlerFactory = new UriNormalizationHandlerFactory();
        configurationManager.subscribeTo(config, handlerFactory, UriNormalizationConfig.class);
    }
}