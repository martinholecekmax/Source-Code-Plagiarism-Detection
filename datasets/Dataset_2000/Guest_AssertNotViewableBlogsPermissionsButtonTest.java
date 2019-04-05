public class Guest_AssertNotViewableBlogsPermissionsButtonTest
	extends BaseTestCase {
	public void testGuest_AssertNotViewableBlogsPermissionsButton()
		throws Exception {
		selenium.selectWindow("null");
		selenium.selectFrame("relative=top");
		selenium.open("/web/site-name/");
		selenium.waitForVisible("link=Blogs Test Page");
		selenium.clickAt("link=Blogs Test Page",
			RuntimeVariables.replace("Blogs Test Page"));
		selenium.waitForPageToLoad("30000");
		assertTrue(selenium.isElementNotPresent("	}
}