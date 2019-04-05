public interface GleSYSAsyncApi {
   
   @Delegate
   ServerAsyncApi getServerApi();
   
   @Delegate
   IpAsyncApi getIpApi();
   
   @Delegate
   ArchiveAsyncApi getArchiveApi();
   
   @Delegate
   DomainAsyncApi getDomainApi();
   
   @Delegate
   EmailAccountAsyncApi getEmailAccountApi();
}