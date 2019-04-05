public class UIRepositoryProperties extends BaseDebugComponent
{
   
   public String getFamily()
   {
      return "org.alfresco.faces.debug.RepositoryProperties";
   }
   
   @SuppressWarnings("unchecked")
   public Map getDebugData()
   {
            Map properties = new TreeMap();
      FacesContext fc = FacesContext.getCurrentInstance();
      ServiceRegistry services = Repository.getServiceRegistry(fc);
      DescriptorService descriptorService = services.getDescriptorService();
      Descriptor installedRepoDescriptor = descriptorService.getInstalledRepositoryDescriptor();
      properties.put("Installed Version", installedRepoDescriptor.getVersion());
      properties.put("Installed Schema", installedRepoDescriptor.getSchema());
      Descriptor systemDescriptor = descriptorService.getServerDescriptor();
      properties.put("Server Version", systemDescriptor.getVersion());
      properties.put("Server Schema", systemDescriptor.getSchema());
      WebApplicationContext cx = FacesContextUtils.getRequiredWebApplicationContext(fc);
      PatchService patchService = (PatchService)cx.getBean("PatchService");
      List<AppliedPatch> patches = patchService.getPatches(null, null);
      for (AppliedPatch patch : patches)
      {
         StringBuilder data = new StringBuilder(256);
         data.append(patch.getAppliedOnDate())
             .append(" - ")
             .append(patch.getDescription())
             .append(" - ")
             .append(patch.getSucceeded() == true ?
                     Application.getMessage(fc, "repository_patch_succeeded") :
                     Application.getMessage(fc, "repository_patch_failed"));
         properties.put(patch.getId(), data);
      }
      return properties; 
   }
}