@Singleton
public class VAppTemplatesInOrg implements Function<Org, Iterable<VAppTemplate>> {
   private final Function<Org, Iterable<CatalogItem>> allCatalogItemsInOrg;
   private final Function<Iterable<CatalogItem>, Iterable<VAppTemplate>> vAppTemplatesForCatalogItems;
   @Inject
   VAppTemplatesInOrg(Function<Org, Iterable<CatalogItem>> allCatalogItemsInOrg,
            Function<Iterable<CatalogItem>, Iterable<VAppTemplate>> vAppTemplatesForCatalogItems) {
      this.allCatalogItemsInOrg = allCatalogItemsInOrg;
      this.vAppTemplatesForCatalogItems = vAppTemplatesForCatalogItems;
   }
   @Override
   public Iterable<VAppTemplate> apply(Org from) {
      Iterable<CatalogItem> catalogs = allCatalogItemsInOrg.apply(from);
      Iterable<VAppTemplate> vAppTemplates = vAppTemplatesForCatalogItems.apply(catalogs);
      return filter(vAppTemplates, and(notNull(), new Predicate<VAppTemplate>(){
                  @Override
         public boolean apply(VAppTemplate input) {
            if (input == null)
               return false;
            return ImmutableSet.of(Status.RESOLVED, Status.POWERED_OFF).contains(input.getStatus());
         }
      }));
   }
}