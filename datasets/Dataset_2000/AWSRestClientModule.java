@ConfiguresRestClient
public abstract class AWSRestClientModule<S, A> extends RestClientModule<S, A> {
   protected AWSRestClientModule(Map<Class<?>, Class<?>> delegates) {
      super(delegates);
   }
   protected AWSRestClientModule() {
   }
   protected AWSRestClientModule(TypeToken<S> syncClientType, TypeToken<A> asyncClientType) {
      super(syncClientType, asyncClientType);
   }
   protected AWSRestClientModule(TypeToken<S> syncClientType, TypeToken<A> asyncClientType,
            Map<Class<?>, Class<?>> sync2Async) {
      super(syncClientType, asyncClientType, sync2Async);
   }
   @Provides
   @ClientError
   @Singleton
   protected Set<String> provideRetryableCodes(){
      return ImmutableSet.of("RequestTimeout", "OperationAborted", "SignatureDoesNotMatch");
   }
   @Override
   protected void bindErrorHandlers() {
      bind(HttpErrorHandler.class).annotatedWith(Redirection.class).to(ParseAWSErrorFromXmlContent.class);
      bind(HttpErrorHandler.class).annotatedWith(ClientError.class).to(ParseAWSErrorFromXmlContent.class);
      bind(HttpErrorHandler.class).annotatedWith(ServerError.class).to(ParseAWSErrorFromXmlContent.class);
   }
   @Override
   protected void bindRetryHandlers() {
      bind(HttpRetryHandler.class).annotatedWith(ClientError.class).to(AWSClientErrorRetryHandler.class);
   }
}