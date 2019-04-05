@Test(groups = INTEGRATION)
@SpecVersion(spec = "cdi", version = "20091101")
public class AddDeploymentProblemTest extends AbstractTest {
    @ShouldThrowException(DeploymentException.class)
    @Deployment
    public static WebArchive createTestArchive() {
        return new WebArchiveBuilder().withTestClassPackage(AddDeploymentProblemTest.class)
                .withExtension(BeanDiscoveryObserver.class).build();
    }
    @Test
    @SpecAssertion(section = "11.5.3", id = "b")
    public void testObserverDeploymentProblemTreatedAsDeploymentError() {
    }
}