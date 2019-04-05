@Test(groups = "unit", testName = "ParseExtensionListNormalTest")
public class ParseExtensionListNormalTest extends BaseSetParserTest<Extension> {
   @Override
   public String resource() {
      return "/extension_list_normal.json";
   }
   @Override
   @SelectJson("extensions")
   @Consumes(MediaType.APPLICATION_JSON)
   public Set<Extension> expected() {
      return ImmutableSet.of(
            Extension.builder().alias("os-keypairs").name("Keypairs")
                  .namespace(URI.create("http:                  .updated(new SimpleDateFormatDateService().iso8601SecondsDateParse("2011-08-08T00:00:00+00:00"))
                  .description("Keypair Support").build(),
            Extension.builder().alias("os-volumes").name("Volumes")
                  .namespace(URI.create("http:                  .updated(new SimpleDateFormatDateService().iso8601SecondsDateParse("2011-03-25T00:00:00+00:00"))
                  .description("Volumes support").build(),
            Extension.builder().alias("security_groups").name("SecurityGroups")
                  .namespace(URI.create("http:                  .updated(new SimpleDateFormatDateService().iso8601SecondsDateParse("2011-07-21T00:00:00+00:00"))
                  .description("Security group support").build(),
            Extension.builder().alias("os-floating-ips").name("Floating_ips")
                  .namespace(URI.create("http:                  .updated(new SimpleDateFormatDateService().iso8601SecondsDateParse("2011-06-16T00:00:00+00:00"))
                  .description("Floating IPs support").build());
   }
   protected Injector injector() {
      return Guice.createInjector(new NovaParserModule(), new GsonModule());
   }
}