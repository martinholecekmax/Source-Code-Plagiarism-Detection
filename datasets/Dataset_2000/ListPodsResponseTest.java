@Test(groups = "unit")
public class ListPodsResponseTest extends BaseSetParserTest<Pod> {
   @Override
   public String resource() {
      return "/listpodsresponse.json";
   }
   @Override
   @SelectJson("pod")
   public Set<Pod> expected() {
      Pod pod1 = Pod.builder()
         .id("1")
         .name("Dev Pod 1")
         .zoneId("1")
         .zoneName("Dev Zone 1")
         .gateway("10.26.26.254")
         .netmask("255.255.255.0")
         .startIp("10.26.26.50")
         .endIp("10.26.26.100")
         .allocationState(AllocationState.ENABLED)
         .build();
      Pod pod2 = Pod.builder()
         .id("2")
         .name("Dev Pod 2")
         .zoneId("2")
         .zoneName("Dev Zone 2")
         .gateway("10.22.22.254")
         .netmask("255.255.255.0")
         .startIp("10.22.22.25")
         .endIp("10.22.22.50")
         .allocationState(AllocationState.ENABLED)
         .build();
      return ImmutableSet.of(pod1, pod2);
   }
}