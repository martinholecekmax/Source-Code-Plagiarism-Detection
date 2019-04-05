@ConfiguredBy({
   @ConfigurationUnit(scope = ContainerScope.PORTAL, path = "conf/exo.portal.component.test.jcr-configuration.xml"),
   @ConfigurationUnit(scope = ContainerScope.PORTAL, path = "org/exoplatform/services/organization/TestOrganizationService-jdbc-configuration.xml"),
   @ConfigurationUnit(scope = ContainerScope.PORTAL, path = "org/exoplatform/services/organization/TestOrganizationService-configuration.xml")
})
public class TestOrganizationService extends AbstractTestOrganizationService
{
   @ClassRule
   public static KernelLifeCycle kernel = new KernelLifeCycle();
}