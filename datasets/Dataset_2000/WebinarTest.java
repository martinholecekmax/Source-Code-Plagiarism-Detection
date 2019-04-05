public class WebinarTest {
  @Test public void normalizesDescription() {
        Demoable demoable = new Webinar("nice   day");
        Assert.assertEquals("nice day", demoable.getDescription());
  }
}