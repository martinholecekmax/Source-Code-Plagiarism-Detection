public class MapReduceMassIndexer implements MassIndexer {
   private final AdvancedCache<Object, Object> cache;
   public MapReduceMassIndexer(AdvancedCache cache, SearchFactoryIntegrator searchFactory) {
      this.cache = cache;
   }
   @Override
   public void start() {
      wipeExistingIndexes();
      new MapReduceTask<Object, Object, Object, LuceneWork>(cache)
         .mappedWith(new IndexingMapper())
         .reducedWith(new IndexingReducer())
         .execute();
   }
   private void wipeExistingIndexes() {
      QueryInterceptor queryInterceptor = ComponentRegistryUtils.getQueryInterceptor(cache);
      queryInterceptor.purgeAllIndexes();
   }
}