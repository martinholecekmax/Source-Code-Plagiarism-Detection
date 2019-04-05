@SuppressWarnings({"unchecked","rawtypes"})
public class UrlMappingFactoryBean extends AbstractFactoryBean<Map> implements ApplicationContextAware {
    private static final Log LOG = LogFactory.getLog(UrlMappingFactoryBean.class);
    private static final String URL_MAP_BEAN = "urlMappings";
    private ApplicationContext applicationContext;
    private Map mappings = new HashMap();
    
    @Override
    protected Map createInstance() {
        if (applicationContext.containsBean(UrlMappingFactoryBean.URL_MAP_BEAN)) {
            Object o = applicationContext.getBean(UrlMappingFactoryBean.URL_MAP_BEAN);
            if (o instanceof Map) {
                mappings.putAll((Map)o);
            }
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("[UrlMappingFactoryBean] Creating URL mappings as...");
            for (Object key : mappings.keySet()) {
                LOG.debug("[UrlMappingFactoryBean] " + key + "=" + mappings.get(key));
            }
        }
        return mappings;
    }
    
    @Override
    public Class<?> getObjectType() {
        return Map.class;
    }
    public void setMappings(Map mappings) {
        this.mappings = mappings;
    }
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}