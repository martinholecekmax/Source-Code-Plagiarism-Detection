public class SA_RemovePermissionsFolderPermissionsTest extends BaseTestCase {
	public void testSA_RemovePermissionsFolderPermissions()
		throws Exception {
		selenium.open("/web/guest/home/");
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}
			try {
				if (selenium.isElementPresent(
							"link=Image Gallery Permissions Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Image Gallery Permissions Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("			RuntimeVariables.replace("Actions"));
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}
			try {
				if (selenium.isElementPresent(
							"					break;
				}
			}
			catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		selenium.saveScreenShotAndSource();
		selenium.click(RuntimeVariables.replace(
				"		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.uncheck("		selenium.clickAt("		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"Your request completed successfully."),
			selenium.getText("		assertFalse(selenium.isChecked("		selenium.saveScreenShotAndSource();
	}
}