public class DataWarehouseManagerImpl implements DataWarehouseManager {
   protected final Log logger = LogFactory.getLog(DataWarehouseManagerImpl.class);
   private List tasks;
   private SecurityService securityService;
   private boolean autoDdl = true;
   public void registerTask(WarehouseTask task) {
      getTasks().add(task);
   }
   public void execute(JobExecutionContext jobExecutionContext)
         throws JobExecutionException {
      getSecurityService().pushAdvisor(new AllowAllSecurityAdvisor());
      for (Iterator i=getTasks().iterator();i.hasNext();) {
         WarehouseTask task = (WarehouseTask)i.next();
         try {
           task.execute();
         } catch (Exception e) {
             logger.error("problem running dw warehouse task:" + e.getMessage(), e);
         }
      }
      getSecurityService().popAdvisor();
   }
   public List getTasks() {
      return tasks;
   }
   public void setTasks(List tasks) {
      this.tasks = tasks;
   }
   public SecurityService getSecurityService() {
      return securityService;
   }
   public void setSecurityService(SecurityService securityService) {
      this.securityService = securityService;
   }
   public boolean isAutoDdl() {
      return autoDdl;
   }
   public void setAutoDdl(boolean autoDdl) {
      this.autoDdl = autoDdl;
   }
}