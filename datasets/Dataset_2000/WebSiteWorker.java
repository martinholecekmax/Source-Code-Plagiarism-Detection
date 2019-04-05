public class WebSiteWorker {
    public static final String module = WebSiteWorker.class.getName();
    public static String getWebSiteId(ServletRequest request) {
        ServletContext application = ((ServletContext) request.getAttribute("servletContext"));
        if (application == null) return null;
        return application.getInitParameter("webSiteId");
    }
    public static GenericValue getWebSite(ServletRequest request) {
        String webSiteId = getWebSiteId(request);
        if (webSiteId == null) {
            return null;
        }
        return findWebSite((Delegator) request.getAttribute("delegator"), webSiteId);
    }
    
    public static GenericValue findWebSite(Delegator delegator, String webSiteId) {
        return findWebSite(delegator, webSiteId, true);
    }
    
    public static GenericValue findWebSite(Delegator delegator, String webSiteId, boolean useCache) {
        GenericValue result = null;
        try {
            result = delegator.findOne("WebSite", useCache, UtilMisc.toMap("webSiteId", webSiteId));
        }
        catch (GenericEntityException e) {
            Debug.logError("Error looking up website with id " + webSiteId, module);
        }
        return result;
    }
}