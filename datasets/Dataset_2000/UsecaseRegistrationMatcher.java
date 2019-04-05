public class UsecaseRegistrationMatcher extends AbstractLogEnabled implements Matcher, Serviceable, Poolable {
    
    public Map match(String pattern, Map objectModel, Parameters parameters)
            throws PatternException {
        Request request = ObjectModelHelper.getRequest(objectModel);
        String usecaseName = request.getParameter("lenya.usecase");
        Map result = null;
        if (usecaseName == null) {
            if (getLogger().isDebugEnabled()) {
               getLogger().debug("match() called, usecase parameter is empty - returning false");
            }
        }
        else {
            if (getLogger().isDebugEnabled()) {
               getLogger().debug("match() called for request parameter lenya.usecase = [" + usecaseName + "]; note that pattern is not relevant for this matcher");
            }
                        UsecaseResolver resolver = null;
            try {
               resolver = (UsecaseResolver) this.manager.lookup(UsecaseResolver.ROLE);
                              String url = new URLInformation().getWebappUrl();
               if (resolver.isRegistered(url, usecaseName)) {
                   result = Collections.EMPTY_MAP;
               }
               if (getLogger().isDebugEnabled()) {
                   getLogger().debug("Usecase [" + usecaseName + "] exists: [" + !(result == null) + "]");
               }
            } catch (ServiceException e) {
               throw new PatternException(e);
            } finally {
               if (resolver != null) {
                  this.manager.release(resolver);
               }
            }
        }
        return result;
    }
    private ServiceManager manager;
    
    public void service(ServiceManager _manager) throws ServiceException {
        this.manager = _manager;
    }
}