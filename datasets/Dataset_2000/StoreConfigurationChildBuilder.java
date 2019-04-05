public interface StoreConfigurationChildBuilder<S> extends LoaderConfigurationChildBuilder<S> {
   
   AsyncStoreConfigurationBuilder<S> async();
   
   SingletonStoreConfigurationBuilder<S> singletonStore();
   
   S fetchPersistentState(boolean b);
   
   S ignoreModifications(boolean b);
   
   S purgeOnStartup(boolean b);
   
   S purgerThreads(int i);
   
   S purgeSynchronously(boolean b);
}