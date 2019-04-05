public abstract class IntegrationContextFactory
{
  private static Log log = LogFactory.getLog(IntegrationContextFactory.class);
  private static IntegrationContextFactory instance=null;
  
  public static IntegrationContextFactory getInstance()
  {
    log.debug("IntegrationContextFactory.getInstance()");
    if (instance==null)
    {
      try
      {
        FactoryUtil.setUseLocator(true);
        instance = FactoryUtil.lookup();
      }
      catch (Exception ex)
      {
        log.error("Unable to read integration context: " + ex);
      }
    }
    log.debug("instance="+instance);
    return instance;
  }
    public abstract boolean isIntegrated();
  public abstract AgentHelper getAgentHelper();
  public abstract GradebookHelper getGradebookHelper();
  public abstract GradebookServiceHelper getGradebookServiceHelper();
  public abstract PublishingTargetHelper getPublishingTargetHelper();
  public abstract SectionAwareServiceHelper getSectionAwareServiceHelper();
  public abstract ServerConfigurationServiceHelper getServerConfigurationServiceHelper();
}