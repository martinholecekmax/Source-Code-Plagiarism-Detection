public class RedirectManager extends LinkRedirectManager
{
    protected static final Logger LOG = Logger.getLogger(RedirectManager.class);
    
    public RedirectManager(Properties webProperties) {
        super(webProperties);
    }
    @Override
    public String generateLink(InterMineAPI im, InterMineObject imo) {
        if (imo instanceof Bank) {
            try {
                return String.format("http:                    TypeUtil.getFieldValue(imo, "name").toString().trim().toLowerCase().replaceAll("\\s", "-"));
            } catch (Exception e) {
                LOG.error("When constructing url", e);
            }
        }
        return null;
    }
}