public class HamcrestIntegrationSystemTest {
	@Rule
	public TransformerAwareRule transformerAware = new TransformerAwareRule();
	@Test
	public void testHamcrestIntegrationWithSuccess() {
		new DummyClass().method("Dummy call");
	}
	@Test(expected = AssertionError.class)
	public void testHamcrestIntegrationWithFailure() {
		new DummyClass().method("ABC");
	}
	@ContractReference(DummyContract.class)
	public static class DummyClass {
		public void method(String arg) {
		}
	}
	public static class DummyContract extends DummyClass {
		@Override
		public void method(String arg) {
			if (preCondition()) {
				assert that(arg, startsWith("Dummy"));
			}
		}
	}
}