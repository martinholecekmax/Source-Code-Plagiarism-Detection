public class GeoServerServletContextInitializer implements ApplicationContextAware {
    
    String key;
    
    Object object;
    public GeoServerServletContextInitializer(String key, Object object) {
        this.key = key;
        this.object = object;
    }
    public void setApplicationContext(ApplicationContext context)
        throws BeansException {
        if (context instanceof WebApplicationContext) {
            WebApplicationContext webContext = (WebApplicationContext) context;
            webContext.getServletContext().setAttribute(key, object);
        }
    }
}