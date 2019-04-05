@Test(groups = "unit", testName = "ParseVirtualGuestWithNoPasswordTest")
public class ParseVirtualGuestPausedTest extends BaseItemParserTest<VirtualGuest> {
   @Override
   public String resource() {
      return "/virtual_guest_paused.json";
   }
   @Override
   @Consumes(MediaType.APPLICATION_JSON)
   public VirtualGuest expected() {
      return VirtualGuest
               .builder()
               .id(416700).accountId(93750).billingItemId(7184019)
               .createDate(new SimpleDateFormatDateService().iso8601SecondsDateParse("2011-10-01T11:47:35-08:00"))
               .metricPollDate(new SimpleDateFormatDateService().iso8601SecondsDateParse("2011-10-02T02:32:00-08:00"))
               .dedicatedAccountHostOnly(true).domain("me.org").fullyQualifiedDomainName("node1703810489.me.org")
               .hostname("node1703810489").maxCpu(1).maxCpuUnits("CORE").maxMemory(1024)
               .modifyDate(new SimpleDateFormatDateService().iso8601SecondsDateParse("2011-10-02T03:18:12-08:00"))
               .primaryBackendIpAddress("10.37.102.195").primaryIpAddress("173.192.29.187").startCpus(1).statusId(1001)
               .uuid("02ddbbba-9225-3d54-6de5-fc603b309dd8")
               .operatingSystem(OperatingSystem.builder().id(913824)
                     .passwords(Password.builder().id(729122).username("root").password("KnJqhC2l").build())
                     .build())
               .datacenter(Datacenter.builder().id(3).name("dal01").longName("Dallas").build())
                              .powerState(new PowerState(VirtualGuest.State.PAUSED)).build();
   }
   protected Injector injector() {
      return Guice.createInjector(new SoftLayerParserModule(), new GsonModule());
   }
}