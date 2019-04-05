public class AddPageTest extends BaseTestCase {
	public void testAddPage() throws Exception {
		selenium.open("/web/guest/home/");
		selenium.clickAt("main-content", RuntimeVariables.replace(""));
		selenium.clickAt("dockbar", RuntimeVariables.replace(""));
		selenium.clickAt("navigation", RuntimeVariables.replace(""));
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}
			try {
				if (selenium.isElementPresent("					break;
				}
			}
			catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		selenium.saveScreenShotAndSource();
		selenium.clickAt("		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}
			try {
				if (selenium.isElementPresent("					break;
				}
			}
			catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		selenium.saveScreenShotAndSource();
		selenium.type("			RuntimeVariables.replace("Unit Converter Test Page"));
		selenium.saveScreenShotAndSource();
		selenium.clickAt("		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}
			try {
				if (selenium.isElementPresent("link=Unit Converter Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Unit Converter Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
	}
}