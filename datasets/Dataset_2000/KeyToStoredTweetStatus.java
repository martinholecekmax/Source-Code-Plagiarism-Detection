public class KeyToStoredTweetStatus implements Function<String, StoredTweetStatus> {
   private final String host;
   private final BlobMap map;
   private final String service;
   private final String container;
   @Resource
   protected Logger logger = Logger.NULL;
   KeyToStoredTweetStatus(BlobMap map, String service, String host, String container) {
      this.host = host;
      this.map = map;
      this.service = service;
      this.container = container;
   }
   public StoredTweetStatus apply(String id) {
      String status;
      String from;
      String tweet;
      try {
         long start = System.currentTimeMillis();
         Blob blob = map.get(id);
         status = ((System.currentTimeMillis() - start) + "ms");
         from = blob.getMetadata().getUserMetadata().get(TweetStoreConstants.SENDER_NAME);
         tweet = Strings2.toString(blob.getPayload());
      } catch (Exception e) {
         logger.error(e, "Error listing container %s         status = (e.getMessage());
         tweet = "";
         from = "";
      }
      return new StoredTweetStatus(service, host, container, id, from, tweet, status);
   }
}