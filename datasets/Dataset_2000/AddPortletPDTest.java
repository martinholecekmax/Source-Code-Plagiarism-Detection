public class AddPortletPDTest extends BaseTestCase {
	public void testAddPortletPD() throws Exception {
		selenium.open("/web/guest/home/");
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}
			try {
				if (selenium.isVisible("link=Polls Display Test Page")) {
					break;
				}
			}
			catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		selenium.saveScreenShotAndSource();
		selenium.clickAt("link=Polls Display Test Page",
			RuntimeVariables.replace(""));
		selenium.waitForPageToLoad("30000");
		selenium.saveScreenShotAndSource();
		selenium.clickAt("_145_addApplication", RuntimeVariables.replace(""));
		Thread.sleep(5000);
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}
			try {
				if (selenium.isVisible("layout_configuration_content")) {
					break;
				}
			}
			catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		selenium.saveScreenShotAndSource();
		selenium.typeKeys("layout_configuration_content",
			RuntimeVariables.replace("p"));
		selenium.saveScreenShotAndSource();
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}
			try {
				if (selenium.isVisible("					break;
				}
			}
			catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		selenium.saveScreenShotAndSource();
		selenium.clickAt("			RuntimeVariables.replace(""));
		for (int second = 0;; second++) {
			if (second >= 60) {
				fail("timeout");
			}
			try {
				if (selenium.isVisible("					break;
				}
			}
			catch (Exception e) {
			}
			Thread.sleep(1000);
		}
		selenium.saveScreenShotAndSource();
		assertTrue(selenium.isVisible("	}
}