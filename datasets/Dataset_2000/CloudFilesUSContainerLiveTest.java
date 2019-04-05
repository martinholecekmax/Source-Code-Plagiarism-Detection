@Test(groups =  "live", testName = "CloudFilesUSContainerLiveTest")
public class CloudFilesUSContainerLiveTest extends CloudFilesContainerLiveTest {
   public CloudFilesUSContainerLiveTest() {
      provider = "cloudfiles-us";
   }
}