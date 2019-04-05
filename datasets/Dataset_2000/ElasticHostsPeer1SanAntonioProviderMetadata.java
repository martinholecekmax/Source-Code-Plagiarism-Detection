public class ElasticHostsPeer1SanAntonioProviderMetadata extends BaseProviderMetadata {
   
   private static final long serialVersionUID = -8914180153534735692L;
   public static Builder builder() {
      return new Builder();
   }
   @Override
   public Builder toBuilder() {
      return builder().fromProviderMetadata(this);
   }
   public ElasticHostsPeer1SanAntonioProviderMetadata() {
      super(builder());
   }
   public ElasticHostsPeer1SanAntonioProviderMetadata(Builder builder) {
      super(builder);
   }
   public static Properties defaultProperties() {
      Properties properties = new Properties();
      return properties;
   }
   public static class Builder extends BaseProviderMetadata.Builder {
      protected Builder() {
         id("elastichosts-sat-p")
         .name("ElasticHosts San Antonio Peer 1")
         .apiMetadata(new ElasticStackApiMetadata().toBuilder().version("2.0").build())
         .homepage(URI.create("https:         .console(URI.create("https:         .iso3166Codes("US-TX")
         .endpoint("https:         .defaultProperties(ElasticHostsPeer1SanAntonioProviderMetadata.defaultProperties());
      }
      @Override
      public ElasticHostsPeer1SanAntonioProviderMetadata build() {
         return new ElasticHostsPeer1SanAntonioProviderMetadata(this);
      }
      @Override
      public Builder fromProviderMetadata(ProviderMetadata in) {
         super.fromProviderMetadata(in);
         return this;
      }
   }
}