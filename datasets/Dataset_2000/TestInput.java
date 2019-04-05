public class TestInput extends AbstractTestInput {
    private static final TestConfiguration DEFAULT_CONFIGURATION = new PropertyTestConfiguration();
    public TestInput() {
        super(DEFAULT_CONFIGURATION);
    }
    @Test
    public void testTypeName() {
        super.testTypeName();
    }
}