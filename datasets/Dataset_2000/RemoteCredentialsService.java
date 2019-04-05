public interface RemoteCredentialsService 
{
   
   BaseCredentialsInfo createPersonCredentials(String remoteSystem, BaseCredentialsInfo credentials); 
   
   BaseCredentialsInfo createSharedCredentials(String remoteSystem, BaseCredentialsInfo credentials);
   
   BaseCredentialsInfo updateCredentials(BaseCredentialsInfo credentials);
   
   BaseCredentialsInfo updateCredentialsAuthenticationSucceeded(boolean succeeded, BaseCredentialsInfo credentialsInfo);
   
   void deleteCredentials(BaseCredentialsInfo credentialsInfo);
   
   PagingResults<String> listPersonRemoteSystems(PagingRequest paging);
   
   PagingResults<String> listSharedRemoteSystems(PagingRequest paging);
   
   PagingResults<String> listAllRemoteSystems(PagingRequest paging);
   
   BaseCredentialsInfo getPersonCredentials(String remoteSystem);
   
   PagingResults<? extends BaseCredentialsInfo> listPersonCredentials(String remoteSystem, QName credentialsType, PagingRequest paging);
   
   PagingResults<? extends BaseCredentialsInfo> listSharedCredentials(String remoteSystem, QName credentialsType, PagingRequest paging);
   
   PagingResults<? extends BaseCredentialsInfo> listAllCredentials(String remoteSystem, QName credentialsType, PagingRequest paging);
}