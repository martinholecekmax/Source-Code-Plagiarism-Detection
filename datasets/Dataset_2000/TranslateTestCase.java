public class TranslateTestCase extends Arquillian {
	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class)
				.addPackage(
						TranslateController.class.getPackage())
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	@Inject TranslateController controller;
	@Test 	public void shouldSetInputText() throws Exception 
	{
	   controller.setInputText("hi");
	}
	@Test(dependsOnMethods = "shouldSetInputText") 	public void shouldTranslate() throws Exception 
	{
		controller.translate();
	}
	@Test(dependsOnMethods = "shouldTranslate") 	public void shouldVerify() throws Exception 
	{
		Assert.assertEquals(controller.getTranslation(), "hei");
	}
}