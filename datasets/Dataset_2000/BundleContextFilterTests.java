public class BundleContextFilterTests extends FilterTests {
	public static Test suite() {
		return new TestSuite(BundleContextFilterTests.class);
	}
	public Filter createFilter(String filterString) throws InvalidSyntaxException {
		return OSGiTestsActivator.getContext().createFilter(filterString);
	}
}