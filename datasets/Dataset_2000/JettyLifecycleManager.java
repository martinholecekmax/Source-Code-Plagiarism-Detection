public class JettyLifecycleManager implements InitializingBean, DisposableBean
{
   private final static Logger logger = Logger
         .getLogger(JettyLifecycleManager.class);
   private Server servletContainer;
   public Server getServletContainer()
   {
      return servletContainer;
   }
   public void setServletContainer(Server servletContainer)
   {
      this.servletContainer = servletContainer;
   }
   public void afterPropertiesSet() throws Exception
   {
      logger.info("Starting up Jetty");
      try
      {
         servletContainer.start();
         while (!servletContainer.isStarted())
         {
            Thread.sleep(1000);
         }
      }
      catch (InterruptedException e)
      {
         logger.error("Interrupted while starting up Jetty", e);
      }
      catch (Exception e)
      {
         logger.error("Exception while starting up Jetty", e);
      }
      
   }
   public void destroy() throws Exception
   {
      logger.info("Shutting down Jetty");
      try
      {
         servletContainer.stop();
      }
      catch (Exception e)
      {
         logger.info("Exception while shutting down Jetty", e);
      }
   }
}