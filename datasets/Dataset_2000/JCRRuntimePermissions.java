public class JCRRuntimePermissions
{
   public static final RuntimePermission CREATE_SYSTEM_SESSION_PERMISSION = new RuntimePermission("createSystemSession");
   public static final RuntimePermission CREATE_DYNAMIC_SESSION_PERMISSION = new RuntimePermission("createDynamicSession");
   public static final RuntimePermission INVOKE_INTERNAL_API_PERMISSION = new RuntimePermission("invokeInternalAPI");
   public static final RuntimePermission MANAGE_REPOSITORY_PERMISSION = new RuntimePermission("manageRepository");
}