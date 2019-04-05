public class FeedFactory
{
    
    private Log logger = LogFactory.make();
    
    private List<PluginFeedFetcherStrategy> siteStratagies;
    
    private PluginFeedFetcherStrategy defaultFetcher;
    
    private int timeout;
    
    private String proxyHost;
    
    private String proxyPort;
    
    public FeedFactory(final List<PluginFeedFetcherStrategy> inSiteStratagies,
            final PluginFeedFetcherStrategy inDefaultFetcher, final String inProxyHost, final String inProxyPort,
            final int inTimeout)
    {
        siteStratagies = inSiteStratagies;
        defaultFetcher = inDefaultFetcher;
        proxyHost = inProxyHost;
        proxyPort = inProxyPort;
        timeout = inTimeout;
    }
    
    public Map<String, SyndFeed> getSyndicatedFeed(final String inFeedUrl, final Collection<String> inRequestors)
            throws Exception
    {
        for (PluginFeedFetcherStrategy ps : siteStratagies)
        {
            if (Pattern.compile(ps.getSiteUrlRegEx()).matcher(inFeedUrl.toString()).find())
            {
                if (logger.isDebugEnabled())
                {
                    logger.debug("Feed being fetched from special site " + inFeedUrl);
                }
                return ps.execute(inFeedUrl, inRequestors, proxyHost, proxyPort, timeout);
            }
        }
        if (logger.isDebugEnabled())
        {
            logger.debug("Feed being fetched from normal site " + inFeedUrl);
        }
        return defaultFetcher.execute(inFeedUrl, inRequestors, proxyHost, proxyPort, timeout);
    }
}