public class RouteResourceBodyParamTestCase extends AbstractRouteBodyParamTestCase {
  @Deployment(testable = false)
  public static WebArchive createDeployment() {
    return createDeployment("bridge.servlet.route.resource.bodyparam");
  }
}