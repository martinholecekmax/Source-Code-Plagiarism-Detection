public class JsonJacksonTest extends AbstractJsonOsgiIntegrationTest {
    @Configuration
    public static Option[] configuration() {
        List<Option> options = new ArrayList<Option>();
        options.addAll(Helper.getCommonOsgiOptions());
        options.addAll(Helper.expandedList(
                mavenBundle().groupId("org.glassfish.jersey.media").artifactId("jersey-media-json-jackson").versionAsInProject(),
                                mavenBundle().groupId("org.codehaus.jackson").artifactId("jackson-core-asl").versionAsInProject(),
                mavenBundle().groupId("org.codehaus.jackson").artifactId("jackson-mapper-asl").versionAsInProject(),
                mavenBundle().groupId("org.codehaus.jackson").artifactId("jackson-jaxrs").versionAsInProject(),
                mavenBundle().groupId("org.codehaus.jackson").artifactId("jackson-xc").versionAsInProject()
        ));
        return Helper.asArray(options);
    }
    @Override
    protected Feature getJsonProviderFeature() {
        return new JacksonFeature();
    }
    @Override
    protected Binder getJsonProviderBinder() {
        return new JacksonBinder();
    }
}