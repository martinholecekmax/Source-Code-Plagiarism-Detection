public class AddCompareCharacterTagTest extends BaseTestCase {
	public void testAddCompareCharacterTag() throws Exception {
		selenium.open("/web/guest/home/");
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}
			try {
				if (selenium.isElementPresent("link=Control Panel")) {
					break;
				}
			}
			catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Control Panel", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Tags", RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("add-tag-button", RuntimeVariables.replace(""));
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}
			try {
				if (selenium.isVisible("new-tag-name")) {
					break;
				}
			}
			catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		selenium.saveScreenShotAndSource();
		selenium.type("new-tag-name", RuntimeVariables.replace("<test>"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}
			try {
				if (RuntimeVariables.replace(
							"One of your fields contains invalid characters.")
										.equals(selenium.getText(
								"tag-portlet-messages"))) {
					break;
				}
			}
			catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		selenium.saveScreenShotAndSource();
		assertEquals(RuntimeVariables.replace(
				"One of your fields contains invalid characters."),
			selenium.getText("tag-portlet-messages"));
		assertFalse(selenium.isElementPresent("link=<test>"));
	}
}