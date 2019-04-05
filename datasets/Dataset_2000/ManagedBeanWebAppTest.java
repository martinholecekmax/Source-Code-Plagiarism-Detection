public class ManagedBeanWebAppTest extends JerseyTest {
    public ManagedBeanWebAppTest() throws Exception {
        super(new WebAppDescriptor.Builder("com.sun.jersey.samples.managedbeans.resources")
                .contextPath("managed-beans-webapp").servletPath("app").build());
    }
    
    @Test
    public void testPerRequestResource() throws Exception {
        WebResource webResource = resource().queryParam("x", "x");
        String responseMsg = webResource.path("managedbean/per-request").get(String.class);
        assertEquals("message x1", responseMsg);
        responseMsg = webResource.path("managedbean/per-request").get(String.class);
        assertEquals("message x1", responseMsg);
    }
    @Test
    public void testSingletonResource() throws Exception {
        WebResource webResource = resource();
        String responseMsg = webResource.path("managedbean/singleton").get(String.class);
        assertEquals("message 1", responseMsg);
        responseMsg = webResource.path("managedbean/singleton").get(String.class);
        assertEquals("message 2", responseMsg);
        responseMsg = webResource.path("managedbean/singleton").get(String.class);
        assertEquals("message 3", responseMsg);
    }
    @Test
    public void testExceptionMapper() throws Exception {
        WebResource webResource = resource().path("managedbean/singleton/exception");
        ClientResponse cr = webResource.get(ClientResponse.class);
        assertEquals(500, cr.getStatus());
        assertEquals("ManagedBeanException", cr.getEntity(String.class));
    }
    @Test
    public void testApplicationWadl() {
        WebResource webResource = resource();
        String serviceWadl = webResource.path("application.wadl").
                accept(MediaTypes.WADL).get(String.class);
        assertTrue(serviceWadl.length() > 0);
    }    
}