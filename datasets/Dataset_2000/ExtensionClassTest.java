public class ExtensionClassTest {
    private static Bundle bundle;
    @BeforeClass
    @SuppressWarnings("unchecked")
    public static void setUpBeforeClass() throws Exception {
        bundle = new MockBundle();
        bundle.getHeaders().put(EXTENSION_CLASSES_HEADER, ExtensionsCount.class.getName());
    }
    @Before
    public void setUp() throws Exception {
        ExtensionsCount.reset();
    }
    @Test
    public void testLoadAll() {
        assertEquals(1, ExtensionClasses.loadAll(bundle).size());
        assertEquals(0, ExtensionsCount.getValue());
    }
}