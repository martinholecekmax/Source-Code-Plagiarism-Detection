public class PostConstructPreDestroyTest extends AbstractResourceTester {
    public static StringBuilder stringBuilder;
    public PostConstructPreDestroyTest(String testName) {
        super(testName);
    }
    @Path("/a")
    public static class ResourceA {
        protected final StringBuilder sb = new StringBuilder();
        @PostConstruct
        private void init() {
            sb.append("A");
        }
        @PreDestroy
        private void cleanup() {
            sb.append("A");
        }
        @GET
        public String getText() {
            stringBuilder = sb;
            return sb.toString();
        }
    }
    @Path("/b")
    public static class ResourceB extends ResourceA {
        @PostConstruct
        private void init() {
            sb.append("B");
        }
        @PreDestroy
        public void cleanup() {
            sb.append("B");
        }
    }
    @Path("/c")
    public static class ResourceC extends ResourceB {
        @PostConstruct
        protected void init2() {
            sb.append("C");
        }
        @PreDestroy
        private void cleanup2() {
            sb.append("C");
        }
    }
    @Path("/d")
    public static class ResourceD extends ResourceC {
        @PostConstruct
        protected void init2() {
            sb.append("D");
        }
        @PreDestroy
        private void cleanup2() {
            sb.append("D");
        }
    }
    public void testPostConstructPreDestroy() {
        initiateWebApplication(ResourceA.class, ResourceB.class, ResourceC.class, ResourceD.class);
        WebResource r = resource("/");
        String s = r.path("d").get(String.class);
        assertEquals("BD", s);
        w.destroy();
        assertEquals("BDDB", stringBuilder.toString());
    }
}