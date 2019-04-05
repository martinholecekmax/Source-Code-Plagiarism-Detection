@RunWith(Arquillian.class)
public class EnvEntriesArquillianStandaloneTest {
    @Resource(name = "foo")
    private String foo;
    @Deployment
    public static JavaArchive archive() {
        return ShrinkWrap.create(JavaArchive.class, EnvEntriesArquillianStandaloneTest.class.getSimpleName().concat(".jar"))
                .addAsManifestResource(EmptyAsset.INSTANCE, ArchivePaths.create("ejb-jar.xml"))
                .addAsManifestResource(new StringAsset("foo=bar"), ArchivePaths.create("env-entries.properties"));
    }
    @Test
    public void check() {
        assertEquals("bar", foo);
    }
}