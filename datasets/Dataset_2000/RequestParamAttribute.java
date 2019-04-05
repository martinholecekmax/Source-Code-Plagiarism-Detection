public class RequestParamAttribute<T> extends AbstractWebAttribute<T> {
        private static final Logger log = LoggerFactory.getLogger(RequestParamAttribute.class);
    public RequestParamAttribute() {
        setMutable(false);
        setCheckRequestParams(false);
    }
    public RequestParamAttribute(String name) {
        super(name);
        setMutable(false);
        setCheckRequestParams(false);
    }
    protected T onRetrieveValue(ServletRequest request, ServletResponse response) {
        return getFromRequestParam(request);
    }
    protected void onStoreValue(T value, ServletRequest request, ServletResponse response) {
        throw new UnsupportedOperationException("RequestParamStores are read-only.");
    }
    public void removeValue(ServletRequest request, ServletResponse response) {
                if (log.isWarnEnabled()) {
            String msg = "Asked to remove WebAttribute value.  A " + getClass().getName() + " implementation " +
                    "cannot remove values from the request params.";
            log.warn(msg);
        }
    }
}