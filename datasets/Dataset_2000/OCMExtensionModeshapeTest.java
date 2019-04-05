@RunWith(Arquillian.class)
public class OCMExtensionModeshapeTest extends OCMExtensionTest {
    @Deployment(name="OCMExtensionModeshape")
    public static WebArchive createArchive() {
        return updateArchive(Utils.baseModeshapeDeployment())
            .addClass(OCMExtensionModeshapeTest.class)
            .addClass(ModeshapeRepositoryResolverProducer.class);
    }
}