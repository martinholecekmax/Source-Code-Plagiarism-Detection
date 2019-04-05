public class PartnerControllerTest extends ControllerTestCase {
    @Test
    public void run() throws Exception {
        tester.start("/partner");
        PartnerController controller = tester.getController();
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is("/partner.jsp"));
    }
}