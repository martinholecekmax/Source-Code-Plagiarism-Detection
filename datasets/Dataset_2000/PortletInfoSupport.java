public class PortletInfoSupport implements PortletInfo
{
   private String name;
   private String applicationName;
   private PreferencesInfoSupport preferencesSupport = new PreferencesInfoSupport();
   private SecurityInfoSupport securitySupport = new SecurityInfoSupport();
   private CacheInfoSupport cacheSupport = new CacheInfoSupport();
   private MetaInfoSupport metaSupport = new MetaInfoSupport();
   private EventingInfoSupport eventsSupport = new EventingInfoSupport();
   private NavigationInfoSupport navigationSupport = new NavigationInfoSupport();
   public String getName()
   {
      return name;
   }
   public void setName(String name)
   {
      this.name = name;
   }
   public String getApplicationName()
   {
      return applicationName;
   }
   public void setApplicationName(String applicationName)
   {
      this.applicationName = applicationName;
   }
   public CapabilitiesInfo getCapabilities()
   {
      throw new UnsupportedOperationException("Implement me");
   }
   public PreferencesInfoSupport getPreferences()
   {
      return preferencesSupport;
   }
   public MetaInfoSupport getMeta()
   {
      return metaSupport;
   }
   public SecurityInfoSupport getSecurity()
   {
      return securitySupport;
   }
   public CacheInfoSupport getCache()
   {
      return cacheSupport;
   }
   public EventingInfoSupport getEventing()
   {
      return eventsSupport;
   }
   public NavigationInfoSupport getNavigation()
   {
      return navigationSupport;
   }
   public <T> T getAttachment(Class<T> type) throws IllegalArgumentException
   {
      if (type == null)
      {
         throw new IllegalArgumentException();
      }
      return null;
   }
   public Map<String, RuntimeOptionInfo> getRuntimeOptionsInfo()
   {
      throw new UnsupportedOperationException("Implement me");
   }
}