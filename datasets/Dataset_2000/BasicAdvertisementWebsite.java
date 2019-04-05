public class BasicAdvertisementWebsite implements AdvertisementWebsiteInterface
{
   private String websiteId;
   public BasicAdvertisementWebsite(String websiteId)
   {
      this.websiteId = websiteId;
   }
   public String toString()
   {
      return this.websiteId;
   }
}